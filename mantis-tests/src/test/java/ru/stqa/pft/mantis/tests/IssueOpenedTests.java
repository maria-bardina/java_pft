package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by marru on 12.09.2017.
 */
public class IssueOpenedTests extends TestBase{
    @Test
    public void testIfOpened() {
        skipIfNotFixed(1);
    }

    @Test
    public void testIfOpenedBugify() {
        skipIfNotFixedBugify(1);
    }
}
