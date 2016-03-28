package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Tanya on 10.03.2016.
 */
public class ContactDeletionTests extends BaseTest {

  @Test
  public void testContactDeletion(){
    preconditions();
    List<ContactData> before =app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after =app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }

  private void preconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test2", null, null));
    }
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com","test2"));
    }
  }
}
