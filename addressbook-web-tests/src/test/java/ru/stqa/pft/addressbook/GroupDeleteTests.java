package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {
        gotoGroupPage();
        selectGroup();
        deleneSelectedGroups();
        returnToGroupPage();
    }

}
