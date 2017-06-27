package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

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

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//tr[@name='entry']/td[8]/a/img")).get(index).click();
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
    public void modifyContact(int index, ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(index);
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

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td = element.findElements(By.tagName("td"));
            contacts.add(new ContactData().withName("Name").withLastname("Lastname"));
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withName("Name").withLastname("Lastname"));
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
