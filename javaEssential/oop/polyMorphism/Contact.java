package javaEssential.oop.polyMorphism;

public class Contact {
    private String name;
    private PhoneNumber phone;
    private String eMail;

    public Contact(String name, PhoneNumber phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public Contact(String name) {
        this.name = name;
    }


    public Contact(String name, PhoneNumber phone, String eMail) {
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
