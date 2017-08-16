package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bardina_md on 27.07.17.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactInforation(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("work"), contactData.getWorkPhone());

  /*     if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }*/
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void initContactModification(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" +id+ "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactInforation(contact);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillContactInforation(contact);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        submitDeleteContact();
        contactCache = null;
        returnToHomePage();

    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            ContactData contact = new ContactData().withId(id).withName(name).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();
            String allEmails = element.findElements(By.tagName("td")).get(4).getText();
            String allAddress = element.findElements(By.tagName("td")).get(3).getText();
            ContactData contact = new ContactData().withId(id).withName(name).withLastname(lastname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAllAddress(allAddress);
            contactCache.add(contact);
        }
        return contactCache;
    }

    public ContactData infoFormContactForm (ContactData contact){
        initContactModification(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkHome(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);

    }
}
