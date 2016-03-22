package ru.tantam.ptc.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.GroupData;


public class GroupDeletionTests extends BaseTest {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("test2", "test2_header", "test2_footer"));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);

  }

}
