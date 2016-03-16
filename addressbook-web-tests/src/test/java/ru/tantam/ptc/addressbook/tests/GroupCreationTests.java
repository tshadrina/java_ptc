package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.GroupData;


public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test2", "test2_header", "test2_footer"));
  }

}
