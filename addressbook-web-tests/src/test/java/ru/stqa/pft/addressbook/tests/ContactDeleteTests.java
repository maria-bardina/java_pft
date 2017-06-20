package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by bardina_md on 05.06.17.
 */
public class ContactDeleteTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData
                    ("mashatest", "mashatest1", "testcompany", "testaddress",
                            "1", "79999999990", "test@test.com"));
        }
    }

    @Test
    public void testContactDelete() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size()-1;

        app.getContactHelper().selectContact(index);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().isAlertPresent();
        app.getContactHelper().delete();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove (index);

        Assert.assertEquals(after, before);
    }
}
