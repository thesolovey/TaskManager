
package endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteProject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteProject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="session" type="{http://endpoint/}session" minOccurs="0"/&gt;
 *         &lt;element name="idProject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteProject", propOrder = {
    "session",
    "idProject"
})
public class DeleteProject {

    protected Session session;
    protected String idProject;

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
     * Gets the value of the idProject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProject() {
        return idProject;
    }

    /**
     * Sets the value of the idProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProject(String value) {
        this.idProject = value;
    }

}
