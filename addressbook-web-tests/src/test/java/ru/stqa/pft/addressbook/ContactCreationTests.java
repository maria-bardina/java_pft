package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase{
    FirefoxDriver wd;


    @Test
    public void tetContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactInforation(new ContactData("mashatest", "mashatest1", "testcompany", "testaddress", "1", "79999999990", "test@test.com"));
        app.getContactHelper().submitContactCreation();
    }

}
