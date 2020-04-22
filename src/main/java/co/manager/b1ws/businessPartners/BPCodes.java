
package co.manager.b1ws.businessPartners;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="BPCode" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Debit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="SystemDebit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="SystemCredit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="ForeignDebit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="ForeignCredit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="ForeignCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "bpCode"
})
@XmlRootElement(name = "BPCodes")
public class BPCodes {

    @XmlElement(name = "BPCode")
    protected List<BPCodes.BPCode> bpCode;

    /**
     * Gets the value of the bpCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bpCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBPCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BPCodes.BPCode }
     * 
     * 
     */
    public List<BPCodes.BPCode> getBPCode() {
        if (bpCode == null) {
            bpCode = new ArrayList<BPCodes.BPCode>();
        }
        return this.bpCode;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Debit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="SystemDebit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="SystemCredit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="ForeignDebit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="ForeignCredit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="ForeignCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class BPCode {

        @XmlElement(name = "Code")
        protected String code;
        @XmlElement(name = "DueDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dueDate;
        @XmlElement(name = "Debit")
        protected Double debit;
        @XmlElement(name = "Credit")
        protected Double credit;
        @XmlElement(name = "SystemDebit")
        protected Double systemDebit;
        @XmlElement(name = "SystemCredit")
        protected Double systemCredit;
        @XmlElement(name = "ForeignDebit")
        protected Double foreignDebit;
        @XmlElement(name = "ForeignCredit")
        protected Double foreignCredit;
        @XmlElement(name = "ForeignCurrency")
        protected String foreignCurrency;

        /**
         * Obtiene el valor de la propiedad code.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Define el valor de la propiedad code.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Obtiene el valor de la propiedad dueDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDueDate() {
            return dueDate;
        }

        /**
         * Define el valor de la propiedad dueDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDueDate(XMLGregorianCalendar value) {
            this.dueDate = value;
        }

        /**
         * Obtiene el valor de la propiedad debit.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getDebit() {
            return debit;
        }

        /**
         * Define el valor de la propiedad debit.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setDebit(Double value) {
            this.debit = value;
        }

        /**
         * Obtiene el valor de la propiedad credit.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getCredit() {
            return credit;
        }

        /**
         * Define el valor de la propiedad credit.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setCredit(Double value) {
            this.credit = value;
        }

        /**
         * Obtiene el valor de la propiedad systemDebit.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getSystemDebit() {
            return systemDebit;
        }

        /**
         * Define el valor de la propiedad systemDebit.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setSystemDebit(Double value) {
            this.systemDebit = value;
        }

        /**
         * Obtiene el valor de la propiedad systemCredit.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getSystemCredit() {
            return systemCredit;
        }

        /**
         * Define el valor de la propiedad systemCredit.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setSystemCredit(Double value) {
            this.systemCredit = value;
        }

        /**
         * Obtiene el valor de la propiedad foreignDebit.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getForeignDebit() {
            return foreignDebit;
        }

        /**
         * Define el valor de la propiedad foreignDebit.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setForeignDebit(Double value) {
            this.foreignDebit = value;
        }

        /**
         * Obtiene el valor de la propiedad foreignCredit.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getForeignCredit() {
            return foreignCredit;
        }

        /**
         * Define el valor de la propiedad foreignCredit.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setForeignCredit(Double value) {
            this.foreignCredit = value;
        }

        /**
         * Obtiene el valor de la propiedad foreignCurrency.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getForeignCurrency() {
            return foreignCurrency;
        }

        /**
         * Define el valor de la propiedad foreignCurrency.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setForeignCurrency(String value) {
            this.foreignCurrency = value;
        }

    }

}
