/*
 * Metadata Editor
 * 
 * Metadata Editor - Rich internet application for editing metadata.
 * Copyright (C) 2011  Matous Jobanek (matous.jobanek@mzk.cz)
 * Moravian Library in Brno
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * 
 */

package cz.mzk.editor.client.other;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

import cz.mzk.editor.client.LangConstants;
import cz.mzk.editor.client.dispatcher.DispatchCallback;
import cz.mzk.editor.client.gwtrpcds.UsersGwtRPCDS;
import cz.mzk.editor.client.util.Constants;
import cz.mzk.editor.client.util.Constants.USER_IDENTITY_TYPES;
import cz.mzk.editor.client.util.HtmlCode;
import cz.mzk.editor.client.view.window.AddIdentityWindow;
import cz.mzk.editor.client.view.window.ModalWindow;
import cz.mzk.editor.shared.rpc.RoleItem;
import cz.mzk.editor.shared.rpc.UserIdentity;
import cz.mzk.editor.shared.rpc.action.GetUserRolesRightsIdentitiesAction;
import cz.mzk.editor.shared.rpc.action.GetUserRolesRightsIdentitiesResult;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailLayout.
 * 
 * @author Matous Jobanek
 * @version Nov 26, 2012
 */
public class UserDetailLayout
        extends VLayout {

    private abstract class GetNewDataHandler {

        public GetNewDataHandler(Canvas toLoading,
                                 String userId,
                                 List<Constants.USER_IDENTITY_TYPES> types,
                                 boolean getRoles) {
            final ModalWindow mw = new ModalWindow(toLoading);
            mw.setLoadingIcon("loadingAnimation.gif");
            mw.show(true);

            dispatcher.execute(new GetUserRolesRightsIdentitiesAction(userId, types, getRoles),
                               new DispatchCallback<GetUserRolesRightsIdentitiesResult>() {

                                   @Override
                                   public void callback(GetUserRolesRightsIdentitiesResult result) {
                                       if (result != null) {
                                           afterGetAction(result);
                                           mw.hide();
                                       } else {
                                           SC.warn("There is no data!!!");
                                       }
                                   }

                               });
        }

        protected abstract void afterGetAction(GetUserRolesRightsIdentitiesResult result);
    }

    /**
     * The Class UniversalListGrid.
     */
    private final class UniversalSectionGrid
            extends SectionStack {

        /** The grid. */
        private final ListGrid grid;

        /**
         * Instantiates a new universal section grid.
         * 
         * @param title
         *        the title
         * @param identType
         *        the ident type
         * @param isRole
         *        the is role
         */
        public UniversalSectionGrid(String title, Constants.USER_IDENTITY_TYPES identType, boolean isRole) {
            super();

            setWidth(290);
            setHeight(100);
            setMargin(5);

            grid = new ListGrid();
            grid.setShowSortArrow(SortArrow.CORNER);
            grid.setShowAllRecords(true);
            grid.setCanSort(true);
            grid.setCanHover(true);
            grid.setHoverOpacity(75);
            grid.setHoverWidth(400);
            grid.setHoverStyle("interactImageHover");
            grid.setShowHeader(false);
            grid.setCanSelectText(true);
            grid.setCanDragSelectText(true);

            SectionStackSection sectionStackSection = new SectionStackSection(title);
            sectionStackSection.setItems(grid);
            sectionStackSection.setCanCollapse(false);
            sectionStackSection.setExpanded(true);

            ImgButton add = getAddButton(identType, isRole);
            ImgButton remove = getRemoveButton();

            sectionStackSection.setControls(add, remove);
            addSection(sectionStackSection);
        }

        /**
         * Gets the adds the button.
         * 
         * @param identType
         *        the ident type
         * @param isRole
         *        the is role
         * @return the adds the button
         */
        private ImgButton getAddButton(final Constants.USER_IDENTITY_TYPES identType, boolean isRole) {
            ImgButton add = new ImgButton();
            add.setSrc("icons/16/add.png");
            add.setWidth(16);
            add.setHeight(16);
            add.addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    if (identType != null) {
                        new AddIdentityWindow(getIdentityTitle(identType),
                                              eventBus,
                                              lang,
                                              userId,
                                              dispatcher,
                                              identType) {

                            @Override
                            protected void afterSuccessAction() {
                                ArrayList<USER_IDENTITY_TYPES> type =
                                        new ArrayList<Constants.USER_IDENTITY_TYPES>();
                                type.add(identType);
                                new GetNewDataHandler(grid, userId, type, false) {

                                    @Override
                                    protected void afterGetAction(GetUserRolesRightsIdentitiesResult result) {
                                        grid.setData(copyIdentities(result.getIdentities().get(0)));
                                    }
                                };
                            }
                        };
                    }
                }
            });

            return add;
        }

        /**
         * Gets the removes the button.
         * 
         * @return the removes the button
         */
        private ImgButton getRemoveButton() {
            ImgButton remove = new ImgButton();
            remove.setSrc("icons/16/remove.png");
            remove.setWidth(16);
            remove.setHeight(16);
            remove.addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    grid.removeSelectedData();
                }
            });

            return remove;
        }

        /**
         * Sets the fields.
         * 
         * @param fields
         *        the new fields
         */
        public void setFields(ListGridField... fields) {
            grid.setFields(fields);
        }

        /**
         * Sets the data.
         * 
         * @param data
         *        the new data
         */
        public void setData(ListGridRecord[] data) {
            grid.setData(data);
        }
    }

    /** The lang. */
    private final LangConstants lang;

    /** The dispatcher. */
    private final DispatchAsync dispatcher;

    /** The event bus. */
    private final EventBus eventBus;

    /** The user id. */
    private final String userId;

    /** The grids layout. */
    private VLayout gridsLayout;

    /**
     * Instantiates a new user detail layout.
     * 
     * @param userDataSource
     *        the user data source
     * @param record
     *        the record
     * @param grid
     *        the grid
     * @param lang
     *        the lang
     * @param dispatcher
     *        the dispatcher
     * @param eventBus
     *        the event bus
     */
    public UserDetailLayout(UsersGwtRPCDS userDataSource,
                            final ListGridRecord record,
                            final ListGrid grid,
                            LangConstants lang,
                            DispatchAsync dispatcher,
                            EventBus eventBus) {
        super();
        this.lang = lang;
        this.dispatcher = dispatcher;
        this.eventBus = eventBus;
        this.userId = record.getAttributeAsString(Constants.ATTR_USER_ID);

        setPadding(5);

        final DynamicForm nameForm = new DynamicForm();
        nameForm.setNumCols(4);
        nameForm.setDataSource(userDataSource);
        nameForm.addDrawHandler(new DrawHandler() {

            @Override
            public void onDraw(DrawEvent event) {
                nameForm.editRecord(record);
            }
        });

        IButton saveButton = new IButton("Save");
        saveButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                nameForm.saveData();
            }
        });

        IButton cancelButton = new IButton("Close");
        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                grid.collapseRecord(record);
            }
        });

        HLayout buttonsLayout = new HLayout(10);
        buttonsLayout.setAlign(Alignment.CENTER);
        buttonsLayout.addMember(saveButton);
        buttonsLayout.addMember(cancelButton);

        addMember(nameForm);

        setIdentitiesAndRoles();

        addMember(buttonsLayout);
    }

    /**
     * Sets the identities and roles.
     */
    private void setIdentitiesAndRoles() {
        if (gridsLayout == null) gridsLayout = new VLayout();
        if (gridsLayout.getMembers().length > 0) gridsLayout.removeMembers(gridsLayout.getMembers());

        new GetNewDataHandler(gridsLayout, userId, new ArrayList<Constants.USER_IDENTITY_TYPES>(), true) {

            @Override
            protected void afterGetAction(GetUserRolesRightsIdentitiesResult result) {
                HTMLFlow identities = new HTMLFlow(HtmlCode.bold(lang.identities()));
                identities.setHeight(15);
                addMember(identities);
                addMember(getIdentitiesLayout(result.getIdentities()));

                HLayout hLayout = new HLayout(2);

                hLayout.addMember(getRolesLayout(result.getRoles()));

                hLayout.addMember(getRightsLayout(result.getRights()));

                addMember(hLayout);
            }
        };
    }

    /**
     * Gets the roles layout.
     * 
     * @param roles
     *        the data
     * @return the roles layout
     */
    private VLayout getRolesLayout(ArrayList<RoleItem> roles) {
        VLayout hLayout = new VLayout();

        HTMLFlow roleFlow = new HTMLFlow(HtmlCode.bold(lang.roles()));
        roleFlow.setHeight(15);

        UniversalSectionGrid userRoleGrid = new UniversalSectionGrid(lang.role(), null, true);

        ListGridField nameField = new ListGridField(Constants.ATTR_NAME, lang.name());
        ListGridField descField = new ListGridField(Constants.ATTR_DESC, lang.description());
        userRoleGrid.setFields(nameField, descField);

        userRoleGrid.setData(copyRoles(roles));

        hLayout.addMember(roleFlow);
        hLayout.addMember(userRoleGrid);

        return hLayout;

    }

    /**
     * Gets the rights layout.
     * 
     * @param rights
     *        the rights
     * @return the rights layout
     */
    private VLayout getRightsLayout(ArrayList<Constants.EDITOR_RIGHTS> rights) {
        VLayout hLayout = new VLayout();

        HTMLFlow flow = new HTMLFlow(HtmlCode.bold(lang.otherRights()));
        flow.setHeight(15);

        UniversalSectionGrid userDataGrid = new UniversalSectionGrid(lang.right(), null, false);

        ListGridField nameField = new ListGridField(Constants.ATTR_NAME, lang.name());
        ListGridField descField = new ListGridField(Constants.ATTR_DESC, lang.description());
        userDataGrid.setFields(nameField, descField);

        userDataGrid.setData(copyRights(rights));

        hLayout.addMember(flow);
        hLayout.addMember(userDataGrid);

        return hLayout;

    }

    /**
     * Gets the identities layout.
     * 
     * @param identities
     *        the identities
     * @return the identities layout
     */
    private HLayout getIdentitiesLayout(ArrayList<UserIdentity> identities) {
        HLayout hLayout = new HLayout();

        if (identities != null && identities.size() > 0) {
            for (UserIdentity userIdentity : identities) {

                UniversalSectionGrid identityGrid =
                        new UniversalSectionGrid(getIdentityTitle(userIdentity.getType()) + " "
                                + lang.identities(), userIdentity.getType(), false);

                ListGridField identityField = new ListGridField(Constants.ATTR_IDENTITY);
                identityGrid.setFields(identityField);

                identityGrid.setData(copyIdentities(userIdentity));
                hLayout.addMember(identityGrid);
            }
        } else {
            hLayout.addMember(new HTMLFlow(HtmlCode.title("WARN: There is no identity", 1)));
        }
        return hLayout;
    }

    /**
     * Gets the identity title.
     * 
     * @param type
     *        the type
     * @return the identity title
     */
    private String getIdentityTitle(Constants.USER_IDENTITY_TYPES type) {
        switch (type) {
            case OPEN_ID:
                return "OpenID";

            case LDAP:
                return "LDAP";

            case SHIBBOLETH:
                return "Shibboleth";

            default:
                return "Unknown";
        }
    }

    /**
     * Copy identities.
     * 
     * @param userIdentity
     *        the user identity
     * @return the list grid record[]
     */
    private ListGridRecord[] copyIdentities(UserIdentity userIdentity) {
        ListGridRecord[] identityRecords = new ListGridRecord[userIdentity.getIdentities().size()];
        if (userIdentity.getIdentities() != null) {
            for (int i = 0, lastIndex = userIdentity.getIdentities().size(); i < lastIndex; i++) {
                ListGridRecord rec = new ListGridRecord();
                rec.setAttribute(Constants.ATTR_IDENTITY, userIdentity.getIdentities().get(i));
                identityRecords[i] = rec;
            }
        }
        return identityRecords;
    }

    /**
     * Copy values.
     * 
     * @param roles
     *        the role
     * @return the list grid record[]
     */
    private ListGridRecord[] copyRoles(ArrayList<RoleItem> roles) {

        ListGridRecord[] roleRecords = new ListGridRecord[roles.size()];
        if (roles != null && roles.size() > 0) {
            for (int i = 0, lastIndex = roles.size(); i < lastIndex; i++) {
                ListGridRecord rec = new ListGridRecord();
                rec.setAttribute(Constants.ATTR_NAME, roles.get(i).getName());
                rec.setAttribute(Constants.ATTR_DESC, roles.get(i).getDescription());
                roleRecords[i] = rec;
            }
        }

        return roleRecords;
    }

    /**
     * Copy rights.
     * 
     * @param rights
     *        the rights
     * @return the list grid record[]
     */
    private ListGridRecord[] copyRights(ArrayList<Constants.EDITOR_RIGHTS> rights) {
        ListGridRecord[] rightsRecords = new ListGridRecord[rights.size()];
        if (rights != null && rights.size() > 0) {
            for (int i = 0, lastIndex = rights.size(); i < lastIndex; i++) {
                ListGridRecord rec = new ListGridRecord();
                rec.setAttribute(Constants.ATTR_NAME, rights.get(i).toString());
                rec.setAttribute(Constants.ATTR_DESC, rights.get(i).getDesc());
                rightsRecords[i] = rec;
            }
        }
        return rightsRecords;
    }

}
