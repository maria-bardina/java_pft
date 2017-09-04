package ru.stqa.pft.mantis.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

/**
 * Created by bardina_md on 04.09.17.
 */
public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException{
        HttpSession session = app.newSession();
        Assert.assertTrue(session.login("administrator", "root"));
        org.testng.Assert.assertTrue(session.isLoggedInAs("administrator"));
    }
}
