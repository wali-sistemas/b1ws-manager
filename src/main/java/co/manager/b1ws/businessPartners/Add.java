
package co.manager.b1ws.businessPartners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sap.com/SBO/DIS}BusinessPartner" minOccurs="0"/>
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
    "businessPartner"
})
@XmlRootElement(name = "Add", namespace = "BusinessPartnersService")
public class Add {

    @XmlElement(name = "BusinessPartner")
    protected BusinessPartner businessPartner;

    /**
     * Obtiene el valor de la propiedad businessPartner.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner }
     *     
     */
    public BusinessPartner getBusinessPartner() {
        return businessPartner;
    }

    /**
     * Define el valor de la propiedad businessPartner.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner }
     *     
     */
    public void setBusinessPartner(BusinessPartner value) {
        this.businessPartner = value;
    }

}
