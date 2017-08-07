package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        List <ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("mashatest64564564", "mashatest1", "9999999", "mashatest");
        app.getContactHelper().createContact(contact);
        List <ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);

        contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
