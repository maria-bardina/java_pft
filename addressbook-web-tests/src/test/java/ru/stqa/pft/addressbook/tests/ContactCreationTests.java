package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {
    FirefoxDriver wd;


    @Test
    public void tetContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"mashatest", "mashatest1", "testcompany", "testaddress",
                "1", "79999999990", "test@test.com");
        app.getContactHelper().createContact(contact);
        List<ContactData>after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }
}
