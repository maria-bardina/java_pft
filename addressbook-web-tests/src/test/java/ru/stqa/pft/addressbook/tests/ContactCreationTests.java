package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactCreationTests {//extends TestBase {


    @Test
    public void testContactCreation() {
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);

        for (Integer b:a){
            System.out.println(b);
        }


        /*Set<ContactData> before = app.сontact().all();
        ContactData contact = new ContactData().withName("Name").withLastname("Lastname");
        app.сontact().create(contact);
        Set<ContactData>after = app.сontact().all();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);*/
    }
}
