package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;

import java.util.concurrent.TimeUnit;

/**
 * Created by marru on 03.06.2017.
 */
public class TestBase {

    public final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.getGroupHelper().wd.quit();
    }

}
