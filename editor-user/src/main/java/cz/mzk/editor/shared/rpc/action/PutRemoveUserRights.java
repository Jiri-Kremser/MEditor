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

package cz.mzk.editor.shared.rpc.action;

import java.util.List;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import cz.mzk.editor.client.util.Constants;

/**
 * @author Matous Jobanek
 * @version Nov 27, 2012
 */
@GenDispatch(isSecure = false)
@SuppressWarnings("unused")
public class PutRemoveUserRights {

    /** The user id. */
    @In(1)
    private String userId;

    /** The right names. */
    @In(2)
    private List<String> rightNames;

    /** The put. */
    @In(3)
    private boolean put;

    /** The successful. */
    @Out(1)
    private boolean successful;

    /** The rights. */
    @Out(2)
    private List<Constants.EDITOR_RIGHTS> rights;
}
