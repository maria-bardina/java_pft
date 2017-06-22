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
        ContactData contact = new ContactData().withId(before.get(before.size()-1).getId()).withName("Name").withLastname("Lastname");
        app.getContactHelper().createContact(contact);
        List<ContactData>after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }
}
