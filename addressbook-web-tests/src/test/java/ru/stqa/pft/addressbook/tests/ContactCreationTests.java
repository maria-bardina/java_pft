package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.appManager.ContactData;

public class ContactCreationTests extends TestBase {
    FirefoxDriver wd;


    @Test
    public void tetContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactInforation(new ContactData("mashatest", "mashatest1", "testcompany", "testaddress", "1", "79999999990", "test@test.com"));
        app.getContactHelper().submitContactCreation();
    }

}
