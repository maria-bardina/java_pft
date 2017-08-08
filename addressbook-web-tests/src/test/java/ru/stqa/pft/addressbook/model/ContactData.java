package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private final String name;
    private final String lastname;
    private final String mobile;
    private String group;

    public ContactData(int id, String name, String lastname, String mobile, String group) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.mobile = mobile;
        this.group = group;
    }

    public ContactData(String name, String lastname, String mobile, String group) {
        this.id = Integer.MAX_VALUE;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
