package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleneSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
