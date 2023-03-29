package functionalWtStream;

import designPatterns.behaviors.observer.lynda.City;

import java.util.Objects;

public class Address {

    private String street1, street2, state, country, postalCode;
    private City city;
/*
    public enum City {
        Washington,
        Oregon,
        California,
        Nevada,
        Alaska,
        Ohio;
    }

 */

    public Address(String street1, City city, String state, String country, String postalCode) {
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getStreet1().equals(address.getStreet1()) && getState().equals(address.getState()) && getCountry().equals(address.getCountry()) && getPostalCode().equals(address.getPostalCode()) && getCity().equals(address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet1(), getState(), getCountry(), getPostalCode(), getCity());
    }
}
