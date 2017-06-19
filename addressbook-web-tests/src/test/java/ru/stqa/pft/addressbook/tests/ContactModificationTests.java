package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by bardina_md on 05.06.17.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData
                    ("mashatest", "mashatest", "testcompany", "testaddress",
                            "1", "79999999990", "test@test.com"));
        }
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"mashatest", "mashatest", "testcompany", "testaddress",
                "1", "79999999990", "test@test.com");
        app.getContactHelper().fillContactInforation(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().isAlertPresent();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
