package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testsGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("mashatest", "headertest", "footertest"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
