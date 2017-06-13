package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appManager.ContactData;
import ru.stqa.pft.addressbook.appManager.HelperBase;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by bardina_md on 05.06.17.
 */
public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData
                    ("mashatest", "mashatest1", "testcompany", "testaddress",
                            "1", "79999999990", "test@test.com"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().isAlertPresent();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()-1);
    }
}
