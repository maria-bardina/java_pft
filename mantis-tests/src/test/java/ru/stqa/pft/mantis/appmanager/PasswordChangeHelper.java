package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PasswordChangeHelper extends HelperBase {

    public PasswordChangeHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Войти']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Войти']"));
    }


    public void goToUsersPage() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    }

    public void goToUserPage() {
        WebElement table = wd.findElement(By.className("table-responsive"));
        List<WebElement> tds = table.findElement(By.tagName("tbody")).findElements(By.tagName("a"));
         tds.get(1).click();
    }

    public String getUsername() {
        return wd.findElement(By.id("edit-username")).getAttribute("value");
    }

    public void clickPasswordChange() {
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }

    public void goToResetPage(String link) {
        wd.get(link);
    }

    public void setNewPassword(String newPassword) {
        type(By.id("password"), newPassword);
        type(By.id("password-confirm"), newPassword);
        click(By.tagName("button"));
    }
}
