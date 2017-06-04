package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.ContactData;

/**
 * Created by marru on 04.06.2017.
 */
public class ContactHelper extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {
        super(wd);

    }


    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactInforation(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContacts() {
        click(By.name("delete"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }
}
