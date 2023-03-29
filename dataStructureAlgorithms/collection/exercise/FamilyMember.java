package dataStructureAlgorithms.collection.exercise;

import dataStructureAlgorithms.collection.Room;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/*
POJO: basic class object with
 */
public class FamilyMember implements Comparable<FamilyMember> {
    private String firstName;
    private String lastName;
    private String address;
    private String cityName;
    private String state;
    private int age;

    /*
    Constructor with all the field argument
     */
    public FamilyMember(String firstName, String lastName, String address, String cityName, String state, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cityName = cityName;
        this.state = state;
        this.age = Integer.parseInt(age);
    }//end constructor


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

   @Override
    /*
    Intellij IDE default equals method override
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyMember)) return false;
        FamilyMember that = (FamilyMember) o;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName());
    }

    @Override
    /*
    intellij IDE default hashCode override
     */
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }//end hashCode

    @Override
    public String toString() {
        return "[" +
                "lastName='" + lastName  +
                "', firstName='" + firstName  +
                "', address='" + address  +
                "', city='" + cityName  +
                "', state='" + state  +
                "', age=" + age  +
                ']';
    }//end toString

    @Override
    public int compareTo(FamilyMember o) {

        int compareResult = this.getLastName().compareTo(o.getLastName());
        if (compareResult == 0){
            //System.out.format("Comparing %s with %s%n", this.firstName, o.firstName);
            return this.getFirstName().compareTo(o.getFirstName());

        } else {
            return compareResult;
        }
    }//end compareTo

}//end class
