package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

public class ContactCreationTests extends BaseTest {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoGroupPage();
    //TODO а есть ли тут группа с именем "zz"
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test2", null, null));
    }
    app.getNavigationHelper().gotoContactCreation();
    app.getContactHelper().createContact(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com","test2"));
  }

}
