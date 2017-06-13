package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.appManager.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {
    FirefoxDriver wd;


    @Test
    public void tetContactCreation() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getContactHelper().createContact(new ContactData
                ("mashatest", "mashatest1", "testcompany", "testaddress",
                        "1", "79999999990", "test@test.com"));
        List<GroupData>after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()+1);
    }
}
