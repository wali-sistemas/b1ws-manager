
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
 *         &lt;element ref="{http://www.sap.com/SBO/DIS}OpenningBalanceAccount" minOccurs="0"/>
 *         &lt;element ref="{http://www.sap.com/SBO/DIS}BPCodes" minOccurs="0"/>
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
    "openningBalanceAccount",
    "bpCodes"
})
@XmlRootElement(name = "CreateOpenBalance", namespace = "BusinessPartnersService")
public class CreateOpenBalance {

    @XmlElement(name = "OpenningBalanceAccount")
    protected OpenningBalanceAccount openningBalanceAccount;
    @XmlElement(name = "BPCodes")
    protected BPCodes bpCodes;

    /**
     * Obtiene el valor de la propiedad openningBalanceAccount.
     * 
     * @return
     *     possible object is
     *     {@link OpenningBalanceAccount }
     *     
     */
    public OpenningBalanceAccount getOpenningBalanceAccount() {
        return openningBalanceAccount;
    }

    /**
     * Define el valor de la propiedad openningBalanceAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link OpenningBalanceAccount }
     *     
     */
    public void setOpenningBalanceAccount(OpenningBalanceAccount value) {
        this.openningBalanceAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad bpCodes.
     * 
     * @return
     *     possible object is
     *     {@link BPCodes }
     *     
     */
    public BPCodes getBPCodes() {
        return bpCodes;
    }

    /**
     * Define el valor de la propiedad bpCodes.
     * 
     * @param value
     *     allowed object is
     *     {@link BPCodes }
     *     
     */
    public void setBPCodes(BPCodes value) {
        this.bpCodes = value;
    }

}
