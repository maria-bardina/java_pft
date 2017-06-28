package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by marru on 04.06.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);

    }


    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactInforation(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }

    public void initContactModification() {
        click(By.xpath("//tr[@name='entry']/td[8]/a/img"));
        //click(By.xpath("//tr[@name='entry']/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactInforation(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification();
        fillContactInforation(contact);
        submitContactModification();
        isAlertPresent();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
       deleteSelectedContacts();
       isAlertPresent();
       delete();
       returnToHomePage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td = element.findElements(By.tagName("td"));
            String attribute = td.get(0).findElement(By.tagName("input")).getAttribute("id");
            contacts.add(
                    new ContactData()
                            .withName(td.get(2).getText())
                            .withLastname(td.get(1).getText())
                            .withId(Integer.parseInt(attribute)));
        }
        return contacts;
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void delete() {
        wd.switchTo().alert().accept();
    }
}
