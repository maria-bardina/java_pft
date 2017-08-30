package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by bardina_md on 27.07.17.
 */
public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() ==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("mashatest"));
        }
    }

    @Test
    public void testGroupModification(){
        app.goTo().groupPage();
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("mashatest1").withHeader("headertest1").withFooter("footertest1");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after= app.db().groups();

        assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withAdded(group)));
        verifyGroupListInUi();
    }

}
