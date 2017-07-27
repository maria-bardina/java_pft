package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by bardina_md on 27.07.17.
 */
public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("mashatest", "mashatest1", "9999999", "mashatest"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitDeleteContact();
        app.getNavigationHelper().goToHomePage();
    }
}
