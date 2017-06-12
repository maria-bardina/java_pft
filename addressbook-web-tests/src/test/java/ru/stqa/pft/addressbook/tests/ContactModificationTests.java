package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appManager.ContactData;

/**
 * Created by bardina_md on 05.06.17.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData
                    ("mashatest", "mashatest", "testcompany", "testaddress",
                            "1", "79999999990", "test@test.com"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactInforation(new ContactData
                ("mashatest", "mashatest1", "testcompany", "testaddress",
                        "1", "79999999990", "test@test.com"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().isAlertPresent();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
