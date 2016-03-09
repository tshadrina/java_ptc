package ru.tantam.ptc.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test2", "test2_header", "test2_footer"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
