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
    app.goTo().groupPage();
    if (!app.group().isThereAGroup("test2")) {
      app.group().create(new GroupData("test2", null, null));
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.contact().list();
    app.goTo().contactCreation();

    ContactData contact = new ContactData("first", "last", "address", "12345", "first.last@mmmm.com", "test2");
    app.contact().create(contact);

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    Comparator<ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    contact.setId(after.stream().max(byId).get().getId());
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }

}
