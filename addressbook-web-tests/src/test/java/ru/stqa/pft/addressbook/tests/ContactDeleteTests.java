package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by bardina_md on 27.07.17.
 */
public class ContactDeleteTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() ==0){
            app.contact().createContact(new ContactData().withName("mashatest").withLastname("mashatest1").withMobile("9999999"));
        }
    }

    @Test
    public void testContactDelete() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withoutAdded(deletedContact)));
    }

}
