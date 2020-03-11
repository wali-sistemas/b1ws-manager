package co.manager.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
public class CustomerDTO {
    private String cardCode;
    private String nit;
    private String cardName;
    private String addressToDef;
    private String location;
    private String phone;
    private String cellular;
    private String email;
    private String wayToPay;
    private Integer plazo;
    private String contact;
    private String seller;
    private String length;
    private String latitude;
    private Integer priceList;
    private String notes;
    private BigDecimal discountCommercial;
    private String condition;
    private String excent;
    private BigDecimal cupo;
    private List<CustomerAddressesDTO> addresses;

    public CustomerDTO() {
    }

    public CustomerDTO(String cardCode, String nit, String cardName, String addressToDef, String location, String phone, String cellular, String email, String wayToPay, Integer plazo, String contact, String seller, String length, String latitude, Integer priceList, String notes, BigDecimal discountCommercial, String condition, String excent, BigDecimal cupo, List<CustomerAddressesDTO> addresses) {
        this.cardCode = cardCode;
        this.nit = nit;
        this.cardName = cardName;
        this.addressToDef = addressToDef;
        this.location = location;
        this.phone = phone;
        this.cellular = cellular;
        this.email = email;
        this.wayToPay = wayToPay;
        this.plazo = plazo;
        this.contact = contact;
        this.seller = seller;
        this.length = length;
        this.latitude = latitude;
        this.priceList = priceList;
        this.notes = notes;
        this.discountCommercial = discountCommercial;
        this.condition = condition;
        this.excent = excent;
        this.cupo = cupo;
        this.addresses = addresses;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getAddressToDef() {
        return addressToDef;
    }

    public void setAddressToDef(String addressToDef) {
        this.addressToDef = addressToDef;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getWayToPay() {
        return wayToPay;
    }

    public void setWayToPay(String wayToPay) {
        this.wayToPay = wayToPay;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getDiscountCommercial() {
        return discountCommercial;
    }

    public void setDiscountCommercial(BigDecimal discountCommercial) {
        this.discountCommercial = discountCommercial;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getExcent() {
        return excent;
    }

    public void setExcent(String excent) {
        this.excent = excent;
    }

    public BigDecimal getCupo() {
        return cupo;
    }

    public void setCupo(BigDecimal cupo) {
        this.cupo = cupo;
    }

    public List<CustomerAddressesDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddressesDTO> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", nit='" + nit + '\'' +
                ", cardName='" + cardName + '\'' +
                ", addressToDef='" + addressToDef + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", cellular='" + cellular + '\'' +
                ", email='" + email + '\'' +
                ", wayToPay='" + wayToPay + '\'' +
                ", plazo=" + plazo +
                ", contact='" + contact + '\'' +
                ", seller='" + seller + '\'' +
                ", length=" + length +
                ", latitude=" + latitude +
                ", priceList=" + priceList +
                ", notes='" + notes + '\'' +
                ", discountCommercial=" + discountCommercial +
                ", condition='" + condition + '\'' +
                ", excent='" + excent + '\'' +
                ", cupo=" + cupo +
                ", addresses=" + addresses +
                '}';
    }

    public static class CustomerAddressesDTO {
        private String lineNum;
        private String address;
        private String city;
        private String country;

        public CustomerAddressesDTO() {
        }

        public CustomerAddressesDTO(String lineNum, String address, String city, String country) {
            this.lineNum = lineNum;
            this.address = address;
            this.city = city;
            this.country = country;
        }

        public String getLineNum() {
            return lineNum;
        }

        public void setLineNum(String lineNum) {
            this.lineNum = lineNum;
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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "CustomerAddressesDTO{" +
                    "lineNum=" + lineNum +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}