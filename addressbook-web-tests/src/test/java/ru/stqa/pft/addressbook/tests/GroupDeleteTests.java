package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("mashatest", "headertest", "footertest"));
        }
    }

    @Test
    public void testGroupDelete() {
        List<GroupData> before = app.getGroupHelper().getGroupList();

        int index = before.size()-1;
        app.getGroupHelper().selectGroup(index);
        app.getGroupHelper().deleneSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData>after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), index);

        before.remove (index);

        Assert.assertEquals(after, before);
    }
}
