package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Tanya on 10.03.2016.
 */
public class ContactDeletionTests extends BaseTest {

  @BeforeMethod
  private void preconditions() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup("test2")) {
        app.getGroupHelper().createGroup(new GroupData("test2", null, null));
      }
      app.getNavigationHelper().gotoContactCreation();
      app.getContactHelper().createContact(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com", "test2"));
    }
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.getContactHelper().getContactList();

    int index = before.size() - 1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
