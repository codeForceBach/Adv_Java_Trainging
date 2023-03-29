package javaEssential.fileIo;

import java.util.Objects;

/*
POJO: basic class object with
 */
public class Member implements Comparable<Member> {
    private String firstName;
    private String lastName;
    /*
    private String address;
    private String cityName;
    private String state;

     */
    private int age;
    private Address address;

    /*
    Constructor with all the field argument
     */
    public Member(String firstName, String lastName, String street, String cityName, String state, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        /*
        this.address = address;
        this.cityName = cityName;
        this.state = state;
         */
        address = new Address (street, cityName, state);
        this.age = Integer.parseInt(age.replace("\"",""));
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

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    /*
   @Override

   // Intellij IDE default equals method override


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member that = (Member) o;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName());
    }

    @Override

    //intellij IDE default hashCode override

    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }//end hashCode
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return getAge() == member.getAge() && Objects.equals(getFirstName(), member.getFirstName()) && Objects.equals(getLastName(), member.getLastName()) && Objects.equals(getAddress(), member.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getAddress());
    }

    @Override
    public String toString() {
        return "[lastName='" + lastName + "\'" +
                ", firstName='" + firstName + "\'" +
                ", age=" + age +
                ", " + getAddress().toSimpleString() +
                ']';
    }//end toString

    @Override
    public int compareTo(Member o) {

        int compareResult = this.getLastName().compareTo(o.getLastName());
        if (compareResult == 0){
            //System.out.format("Comparing %s with %s%n", this.firstName, o.firstName);
            return this.getFirstName().compareTo(o.getFirstName());

        } else {
            return compareResult;
        }
    }//end compareTo

}//end class
