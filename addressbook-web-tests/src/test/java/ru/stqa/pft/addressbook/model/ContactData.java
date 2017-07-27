package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String mobile;
    private String group;

    public ContactData(String name, String lastname, String mobile, String group) {
        this.name = name;
        this.lastname = lastname;
        this.mobile = mobile;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getGroup() {
        return group;
    }
}
