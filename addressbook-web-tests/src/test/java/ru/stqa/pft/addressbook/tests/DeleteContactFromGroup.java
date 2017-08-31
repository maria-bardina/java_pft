package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

/**
 * Created by bardina_md on 31.08.17.
 */
public class DeleteContactFromGroup extends TestBase {

    @Test

    public void removeContactFromGroupTests() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData addedContact =  before.iterator().next();
        app.contact().removeContactFromGroup(addedContact);

    }
}
