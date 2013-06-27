//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.27 at 11:30:42 AM EST 
//


package net.ripe.db.whois.api.whois.rdap.domain.vcard;

import java.io.Serializable;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.ripe.db.whois.api.whois.rdap.VcardObject;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyValues" type="{}hashMapType"/>
 *         &lt;element name="entryType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="entryValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "keyValues",
    "entryType",
    "entryValue"
})
@XmlRootElement(name = "email")
public class Email
    extends VcardObject
    implements Serializable
{

    @XmlElement(required = true, defaultValue = "email")
    protected String name;
    @XmlElement(required = true)
    protected HashMap keyValues;
    @XmlElement(required = true, defaultValue = "text")
    protected String entryType;
    @XmlElement(required = true)
    protected String entryValue;

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the keyValues property.
     * 
     * @return
     *     possible object is
     *     {@link HashMap }
     *     
     */
    public HashMap getKeyValues() {
        return keyValues;
    }

    /**
     * Sets the value of the keyValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link HashMap }
     *     
     */
    public void setKeyValues(HashMap value) {
        this.keyValues = value;
    }

    /**
     * Sets the value of the entryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryType(String value) {
        this.entryType = value;
    }

    /**
     * Gets the value of the entryValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryValue() {
        return entryValue;
    }

    /**
     * Sets the value of the entryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryValue(String value) {
        this.entryValue = value;
    }

    /**
     * Gets the value of the name property.
     * 
     */
    public String getName() {
        if (null == name) {
            return "email";
        }
        return name;
    }

    /**
     * Gets the value of the entryType property.
     * 
     */
    public String getEntryType() {
        if (null == entryType) {
            return "text";
        }
        return entryType;
    }

}
