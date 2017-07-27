package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by bardina_md on 27.07.17.
 */
public class ContactModificationTests extends TestBase{

    @Test

    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("mashatest", "mashatest1", "9999999", "mashatest"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactInforation(
                new ContactData("mashatest2", "mashatest1", "9999999", null));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }
}
