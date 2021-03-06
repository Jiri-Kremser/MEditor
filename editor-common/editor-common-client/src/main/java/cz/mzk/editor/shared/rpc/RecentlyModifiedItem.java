/*
 * Metadata Editor
 * @author Jiri Kremser
 * 
 * 
 * 
 * Metadata Editor - Rich internet application for editing metadata.
 * Copyright (C) 2011  Jiri Kremser (kremser@mzk.cz)
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

package cz.mzk.editor.shared.rpc;

import java.io.Serializable;

import java.util.Date;

import cz.mzk.editor.shared.domain.DigitalObjectModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RecentlyModifiedItem.
 */
public class RecentlyModifiedItem
        implements Serializable, Comparable<RecentlyModifiedItem> {

    private static final long serialVersionUID = 6277003854763995255L;

    /** The uuid. */
    private String uuid;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The model. */
    private DigitalObjectModel model;

    private Date modified;

    private LockInfo lockInfo;

    // @SuppressWarnings("unused")
    /**
     * Instantiates a new recently modified item.
     */
    public RecentlyModifiedItem() {

    }

    /**
     * Instantiates a new recently modified item.
     * 
     * @param uuid
     *        the uuid
     * @param name
     *        the name
     * @param description
     *        the description
     * @param model
     *        the model
     */
    public RecentlyModifiedItem(String uuid,
                                String name,
                                String description,
                                DigitalObjectModel model,
                                Date modifed) {
        super();
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.model = model;
        this.modified = modifed;
    }

    /**
     * Gets the uuid.
     * 
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the uuid.
     * 
     * @param uuid
     *        the new uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *        the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *        the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the model.
     * 
     * @return the model
     */
    public DigitalObjectModel getModel() {
        return model;
    }

    /**
     * Sets the model.
     * 
     * @param model
     *        the new model
     */
    public void setModel(DigitalObjectModel model) {
        this.model = model;
    }

    /**
     * Gets the modified.
     * 
     * @return the modified
     */
    public Date getModified() {
        return modified;
    }

    /**
     * Sets the modified.
     * 
     * @param modified
     *        the new modified
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RecentlyModifiedRecord [uuid=" + uuid + ", name=" + name + ", description=" + description
                + ", model=" + model + ", modified=" + modified + "]";
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        RecentlyModifiedItem other = (RecentlyModifiedItem) obj;
        if (uuid == null) {
            if (other.uuid != null) return false;
        } else if (!uuid.equals(other.uuid)) return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public int compareTo(RecentlyModifiedItem o) {
        return o.getModified().getTime() < this.getModified().getTime() ? -1 : 1;
    }

    /**
     * @return the lockInfo
     */

    public LockInfo getLockInfo() {
        return lockInfo;
    }

    /**
     * @param lockInfo
     *        the lockInfo to set
     */

    public void setLockInfo(LockInfo lockInfo) {
        this.lockInfo = lockInfo;
    }

}
