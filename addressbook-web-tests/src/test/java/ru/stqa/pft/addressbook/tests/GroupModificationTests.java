package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by bardina_md on 05.06.17.
 */
public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupModificarion() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("mashatest", "headertest", "footertest"));
        }
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size()-1).getId(),"mashatest1", "headertest1", "footertest1");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData>after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
;
        before.remove(before.size()-1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after));

    }

}
