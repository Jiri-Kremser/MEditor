//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.13 at 05:02:55 odp. CET 
//

package cz.fi.muni.xkremser.editor.client.mods;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import cz.fi.muni.xkremser.editor.server.mods.CopyInformationType;

public class HoldingSimpleTypeClient implements IsSerializable {

	protected List<CopyInformationTypeClient> copyInformation;

	/**
	 * Gets the value of the copyInformation property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the copyInformation property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCopyInformation().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link CopyInformationType }
	 * 
	 * 
	 */
	public List<CopyInformationTypeClient> getCopyInformation() {
		if (copyInformation == null) {
			copyInformation = new ArrayList<CopyInformationTypeClient>();
		}
		return this.copyInformation;
	}

}