
package com.gmail.sdima.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for openTaskByName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="openTaskByName"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="session" type="{http://endpoint.sdima.gmail.com/}session" minOccurs="0"/&gt;
 *         &lt;element name="nameTask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "openTaskByName", propOrder = {
    "session",
    "nameTask"
})
public class OpenTaskByName {

    protected Session session;
    protected String nameTask;

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link Session }
     *     
     */
    public Session getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link Session }
     *     
     */
    public void setSession(Session value) {
        this.session = value;
    }

    /**
     * Gets the value of the nameTask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameTask() {
        return nameTask;
    }

    /**
     * Sets the value of the nameTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameTask(String value) {
        this.nameTask = value;
    }

}
