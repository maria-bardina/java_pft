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
public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() ==0){
            app.contact().createContact(new ContactData().withName("mashatest").withLastname("mashatest1").withMobilePhone("9999999").withAddress("Address3"));
        }
    }

    @Test

    public void testContactModification(){

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("mashatest").withLastname("mashatest1").withMobilePhone("9999999").withAddress("Address3");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
    }

}
