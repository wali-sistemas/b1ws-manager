
package co.manager.b1ws.incomingPayments;

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
 *         &lt;element ref="{http://www.sap.com/SBO/DIS}PaymentParams" minOccurs="0"/>
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
    "paymentParams"
})
@XmlRootElement(name = "Cancel", namespace = "IncomingPaymentsService")
public class Cancel {

    @XmlElement(name = "PaymentParams")
    protected PaymentParams paymentParams;

    /**
     * Obtiene el valor de la propiedad paymentParams.
     * 
     * @return
     *     possible object is
     *     {@link PaymentParams }
     *     
     */
    public PaymentParams getPaymentParams() {
        return paymentParams;
    }

    /**
     * Define el valor de la propiedad paymentParams.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentParams }
     *     
     */
    public void setPaymentParams(PaymentParams value) {
        this.paymentParams = value;
    }

}
