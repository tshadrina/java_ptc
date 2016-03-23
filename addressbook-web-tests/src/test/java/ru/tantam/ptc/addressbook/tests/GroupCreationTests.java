package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test2", "test2_header", "test2_footer");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (GroupData g: after){
      if (g.getId() > max){
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }

}
