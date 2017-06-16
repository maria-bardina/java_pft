package ru.stqa.pft.addressbook.model;

public class ContactData {


    private int id;
    private final String name;
    private final String lastname;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String email;

    public ContactData(int id, String name, String lastname, String company, String address, String home, String mobile, String email) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
    }
    public ContactData(String name, String lastname, String company, String address, String home, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
   
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
