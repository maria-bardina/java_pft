package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.appmanager.MailHelper;
import ru.stqa.pft.mantis.appmanager.PasswordChangeHelper;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Random;

import static org.testng.AssertJUnit.assertTrue;

public class PasswordChangeTests extends TestBase {
    private PasswordChangeHelper helper;
    private MailHelper mailHelper;

    @BeforeMethod
    public void init() {
        helper = new PasswordChangeHelper(app);
        mailHelper = new MailHelper(app);
        mailHelper.start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        helper.login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        helper.goToUsersPage();
        helper.goToUserPage();
        String username = helper.getUsername();
        helper.clickPasswordChange();
        MailMessage mailMessage = mailHelper.waitForMail(1, 60000).get(0);
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        String link = regex.getText(mailMessage.text);
        helper.goToResetPage(link);
        String newPassword = "password" + new Random().nextInt();
        helper.setNewPassword(newPassword);
        HttpSession session = app.newSession();

        assertTrue(session.login(username, newPassword));
        assertTrue(session.isLoggedInAs(username));
    }
}
