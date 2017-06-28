package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

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
        Contacts before = app.сontact().all();
        int index = before.size()-1;

        ContactData deleteContact = before.iterator().next();
        app.сontact().delete(deleteContact);
        Contacts after = app.сontact().all();
        assertEquals(after.size(), before.size() -1);

        assertThat(after, equalTo(before.without(deleteContact)));
    }


}
