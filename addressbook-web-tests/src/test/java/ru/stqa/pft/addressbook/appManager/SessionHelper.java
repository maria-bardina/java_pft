package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by marru on 04.06.2017.
 */
public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {

        super(wd);
    }

    public void login(String username, String password) {
        wd.get("http://localhost/addressbook/index.php");
        type(By.name("pass"), password);
        type(By.name("user"), username);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
