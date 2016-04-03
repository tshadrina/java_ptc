package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Tanya on 09.03.2016.
 */
public class ContactModificationTests extends BaseTest {

  @BeforeMethod
  public void preconditions() {
    if (!app.contact().isThereAContact()) {
      app.goTo().groupPage();
      if (!app.group().isThereAGroup("test2")) {
        app.group().create(new GroupData("test2", null, null));
      }
      app.goTo().contactCreation();
      app.contact().create(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com", "test2"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "first", "las", "address2", "22345", "first2.last2@mmmm.com", null);

    app.contact().modify(index, contact);

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<ContactData> byId = (c1, c2) -> (Integer.compare(c1.getId(), c2.getId()));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
