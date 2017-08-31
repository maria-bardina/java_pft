package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

/**
 * Created by bardina_md on 31.08.17.
 */
public class DeleteContactFromGroup extends TestBase {

    @BeforeMethod
    public void ensureContactPreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().createContact(new ContactData().withName("mashatest").withLastname("mashatest1").withMobilePhone("9999999"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("mashatest"));
        }if (app.db().contactsInGroup().size()==0){
            app.goTo().homePage();
            app.contact().contactToGroup(app.db().contacts().iterator().next());
        };
    }

    @Test
    public void removeContactFromGroupTests() {
        app.goTo().homePage();
        Contacts before = app.db().contactsInGroup();
        ContactData addedContact =  before.iterator().next();
        app.contact().removeContactFromGroup(addedContact);
        Contacts after = app.db().contacts();
        assertTrue(after.iterator().next().getGroups().isEmpty());
    }
}
