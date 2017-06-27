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
        if (! app.сontact().isThereAContact()){
            app.сontact().create(new ContactData().withName("name").withLastname("Lastname"));
        }
    }

    @Test
    public void testContactDelete() {
        List<ContactData> before = app.сontact().getContactList();
        int index = before.size()-1;

        ContactData deleteContact = before.iterator().next();
        app.сontact().delete(deleteContact);
        List<ContactData> after = app.сontact().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove (index);

        Assert.assertEquals(after, before);
    }


}
