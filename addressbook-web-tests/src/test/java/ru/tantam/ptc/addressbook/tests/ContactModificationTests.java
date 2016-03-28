package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Tanya on 09.03.2016.
 */
public class ContactModificationTests extends BaseTest {

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com", "test2"));
    }

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);

    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "first", "las", "address2", "22345", "first2.last2@mmmm.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<ContactData> byId = (c1, c2) -> (Integer.compare(c1.getId(), c2.getId()));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
