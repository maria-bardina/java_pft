package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by bardina_md on 05.06.17.
 */
public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete() {
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData
                    ("mashatest", "mashatest1", "testcompany", "testaddress",
                            "1", "79999999990", "test@test.com"));
        }
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().isAlertPresent();
        app.getContactHelper().delete();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove (before.size()-1);

        Assert.assertEquals(after, before);
    }
}
