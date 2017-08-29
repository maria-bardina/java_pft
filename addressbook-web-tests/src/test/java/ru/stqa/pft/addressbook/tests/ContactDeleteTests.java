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
public class ContactDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().conacts().size() == 0) {
            app.goTo().homePage();
            app.contact().createContact(new ContactData().withName("mashatest").withLastname("mashatest1").withMobilePhone("9999999"));
        }
    }

    @Test
    public void testContactDelete() {
        app.goTo().homePage();
        Contacts before = app.db().conacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().conacts();

        assertThat(after, equalTo(before.withoutAdded(deletedContact)));
    }

}
