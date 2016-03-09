package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.GroupData;


public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test2", "test2_header", "test2_footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
