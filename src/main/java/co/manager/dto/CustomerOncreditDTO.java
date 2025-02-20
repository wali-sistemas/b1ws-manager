package co.manager.dto;

import java.util.Date;

/**
 * @author jguisao
 */
public class CustomerOncreditDTO {
    public String docId;
    public String typeDoc;
    public String firstName;
    public String middleName;
    public String firstlastName;
    public String middlelastName;
    public String cellular;
    public String email;
    public String birthDate;
    public String gender;
    public String expDocDate;
    public String placeExp;
    public String companyName;
    public int age;

    public CustomerOncreditDTO() {
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
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

    public String getFirstlastName() {
        return firstlastName;
    }

    public void setFirstlastName(String firstlastName) {
        this.firstlastName = firstlastName;
    }

    public String getMiddlelastName() {
        return middlelastName;
    }

    public void setMiddlelastName(String middlelastName) {
        this.middlelastName = middlelastName;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExpDocDate() {
        return expDocDate;
    }

    public void setExpDocDate(String expDocDate) {
        this.expDocDate = expDocDate;
    }

    public String getPlaceExp() {
        return placeExp;
    }

    public void setPlaceExp(String placeExp) {
        this.placeExp = placeExp;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
