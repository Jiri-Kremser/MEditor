//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.11 at 08:50:20 PM CET 
//


package cz.fi.muni.xkremser.editor.client.mods;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unstructuredText complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unstructuredText">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.loc.gov/mods/v3>stringPlusDisplayLabelPlusType">
 *       &lt;attGroup ref="{http://www.w3.org/1999/xlink}simpleLink"/>
 *       &lt;attGroup ref="{http://www.loc.gov/mods/v3}language"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unstructuredText")
@XmlSeeAlso({
    AbstractType.class,
    NoteType.class,
    TableOfContentsType.class
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class UnstructuredText
    extends StringPlusDisplayLabelPlusType
{

    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String type;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlSchemaType(name = "anyURI")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String href;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String role;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String arcrole;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String title;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String show;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String actuate;
    @XmlAttribute(name = "lang")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String valueToFixError3;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String lang;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String script;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String transliteration;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getType() {
        if (type == null) {
            return "simple";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the arcrole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getArcrole() {
        return arcrole;
    }

    /**
     * Sets the value of the arcrole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setArcrole(String value) {
        this.arcrole = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the show property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getShow() {
        return show;
    }

    /**
     * Sets the value of the show property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setShow(String value) {
        this.show = value;
    }

    /**
     * Gets the value of the actuate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getActuate() {
        return actuate;
    }

    /**
     * Sets the value of the actuate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setActuate(String value) {
        this.actuate = value;
    }

    /**
     * Gets the value of the valueToFixError3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getValueToFixError3() {
        return valueToFixError3;
    }

    /**
     * Sets the value of the valueToFixError3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setValueToFixError3(String value) {
        this.valueToFixError3 = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the script property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setScript(String value) {
        this.script = value;
    }

    /**
     * Gets the value of the transliteration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getTransliteration() {
        return transliteration;
    }

    /**
     * Sets the value of the transliteration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-11-11T08:50:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setTransliteration(String value) {
        this.transliteration = value;
    }

}