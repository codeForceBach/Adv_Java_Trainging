package javaEssential.fileIo;

import java.util.Objects;

public class Address {

    private String street;
    private String city;
    private String state;
    private String postCode;

    public Address(String street, String cityName, String state) {
        this.street = street;
        this.city = cityName;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getState(), address.getState()) && Objects.equals(getPostCode(), address.getPostCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getCity(), getState(), getPostCode());
    }

    @Override
    public String toString() {

        return "Address[" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postCode='" + postCode + '\'' +
                ']';
    }

    public String toSimpleString(){
        return  "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postCode='" + postCode + '\''
                ;
    }
}
