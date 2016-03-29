package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends BaseTest {

  @BeforeMethod
  public void preconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup("test2")) {
      app.getGroupHelper().createGroup(new GroupData("test2", null, null));
    }
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoContactCreation();

    ContactData contact = new ContactData("first", "last", "address", "12345", "first.last@mmmm.com", "test2");
    app.getContactHelper().createContact(contact);

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    Comparator<ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    contact.setId(after.stream().max(byId).get().getId());
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }

}
