
package co.manager.b1ws.state;

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
 *         &lt;element ref="{http://www.sap.com/SBO/DIS}StateParams" minOccurs="0"/>
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
    "stateParams"
})
@XmlRootElement(name = "DeleteState", namespace = "StatesService")
public class DeleteState {

    @XmlElement(name = "StateParams")
    protected StateParams stateParams;

    /**
     * Obtiene el valor de la propiedad stateParams.
     * 
     * @return
     *     possible object is
     *     {@link StateParams }
     *     
     */
    public StateParams getStateParams() {
        return stateParams;
    }

    /**
     * Define el valor de la propiedad stateParams.
     * 
     * @param value
     *     allowed object is
     *     {@link StateParams }
     *     
     */
    public void setStateParams(StateParams value) {
        this.stateParams = value;
    }

}
