package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bardina_md on 16.08.17.
 */
public class ContactPhoneTest extends TestBase{

    @Test

    public void  testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData infoFormContactForm = app.contact().infoFormContactForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(infoFormContactForm)));
     }

       private String mergePhones(ContactData contact) {
       return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }


    public static String cleaned (String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
