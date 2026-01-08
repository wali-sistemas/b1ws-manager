package co.manager.dto;

/**
 * @author jguisao
 */
public class CustomerOncreditDTO {
    public String companyName;
    public String idTypeDoc;
    public String typeDoc;
    public String docIdent;
    public String clAntg;
    public String cardName;
    public String cardCode;
    public String firstName;
    public String lastName1;
    public String lastName2;
    public String cellular;
    public String email;
    public String codCity;
    public String address;
    public String city;
    public String depart;
    public String munic;
    public Double cupo;
    public CustomerContactPersons customerContactPersons;

    public CustomerOncreditDTO() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIdTypeDoc() {
        return idTypeDoc;
    }

    public void setIdTypeDoc(String idTypeDoc) {
        this.idTypeDoc = idTypeDoc;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getDocIdent() {
        return docIdent;
    }

    public void setDocIdent(String docIdent) {
        this.docIdent = docIdent;
    }

    public String getClAntg() {
        return clAntg;
    }

    public void setClAntg(String clAntg) {
        this.clAntg = clAntg;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodCity() {
        return codCity;
    }

    public void setCodCity(String codCity) {
        this.codCity = codCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getMunic() {
        return munic;
    }

    public void setMunic(String munic) {
        this.munic = munic;
    }

    public Double getCupo() {
        return cupo;
    }

    public void setCupo(Double cupo) {
        this.cupo = cupo;
    }

    public CustomerContactPersons getCustomerContactPersons() {
        return customerContactPersons;
    }

    public void setCustomerContactPersons(CustomerContactPersons customerContactPersons) {
        this.customerContactPersons = customerContactPersons;
    }

    public static class CustomerContactPersons {
        public String idTypeDoc;
        public String docIdent;
        public String firstName;
        public String middleName;
        public String lastName;
        public String address;
        public String cellular;
        public String email;

        public CustomerContactPersons() {
        }

        public String getIdTypeDoc() {
            return idTypeDoc;
        }

        public void setIdTypeDoc(String idTypeDoc) {
            this.idTypeDoc = idTypeDoc;
        }

        public String getDocIdent() {
            return docIdent;
        }

        public void setDocIdent(String docIdent) {
            this.docIdent = docIdent;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCellular() {
            return cellular;
        }

        public void setCellular(String cellular) {
            this.cellular = cellular;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "CustomerOncreditDTO{" +
                "companyName='" + companyName + '\'' +
                ", idTypeDoc='" + idTypeDoc + '\'' +
                ", typeDoc='" + typeDoc + '\'' +
                ", docIdent='" + docIdent + '\'' +
                ", clAntg='" + clAntg + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", cellular='" + cellular + '\'' +
                ", email='" + email + '\'' +
                ", codCity='" + codCity + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", depart='" + depart + '\'' +
                ", munic='" + munic + '\'' +
                ", cupo=" + cupo +
                ", customerContactPersons=" + customerContactPersons +
                '}';
    }
}
