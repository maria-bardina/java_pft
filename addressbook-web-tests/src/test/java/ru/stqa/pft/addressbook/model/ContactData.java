package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.eclipse.jetty.util.annotation.Name;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table (name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firastname")
    private String name;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;
    @Transient
    private String group;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String home;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String work;
    @Transient
    private String allPhones;
    @Expose
    private String email1;
    @Expose
    private String email2;
    @Expose
    private String email3;
    private String allEmails;
    @Expose
    private String address;
    @Transient
    private String allAddress;


    public String getName() {
        return name;

    }

    public String getLastname() {
        return lastname;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public int getId() {
        return id;
    }

    public String getHomePhone() {
        return home;
    }

    public String getWorkPhone() {
        return work;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail() {
        return email1;
    }

    public String getEmail3() {
        return email3;
    }

    public String getEmail2() {
        return email2;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAddress() {
        return address;
    }

    public String getAllAddress() {
        return allAddress;
    }

    public ContactData withAllAddress(String allAddress) {
        this.allAddress = allAddress;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }


    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }


    public ContactData withWorkHome(String work) {
        this.work = work;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}
