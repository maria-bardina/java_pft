package ru.stqa.pft.mantis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.bugify.Issue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by marru on 03.06.2017.
 */
public class TestBase {


    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop();
    }

    public boolean isIssueOpened(int issueId) {
        try {
            return app.soap().isIssueOpened(issueId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void skipIfNotFixed(int issueId) {
        if (isIssueOpened(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public boolean isIssueOpenedBugify(int issueId) throws IOException {
        String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues/"+issueId+".json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        Issue issue = new Gson().<List<Issue>>fromJson(issues, new TypeToken<List<Issue>>() {
        }.getType()).get(0);
        return !(issue.getState_name().equals("Resolved") || issue.getState_name().equals("Closed"));
    }

    public void skipIfNotFixedBugify(int issueId) {
        try {
            if (isIssueOpenedBugify(issueId)) {
                throw new SkipException("Ignored because of issue " + issueId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("28accbe43ea112d9feb328d2c00b3eed", "");
    }
}
