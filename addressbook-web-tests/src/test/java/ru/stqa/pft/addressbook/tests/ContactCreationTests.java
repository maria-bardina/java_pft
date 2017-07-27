package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().createContact(new ContactData("mashatest", "mashatest1", "9999999", "mashatest"));
    }
}
