package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("mashatest", "headertest", "footertest"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleneSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }
}
