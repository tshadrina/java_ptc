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
        app.group().create(new GroupData().withName("test2"));
      }
      app.goTo().contactCreation();
      app.contact().create(new ContactData().
              withFirstName("first").
              withLastName("last").
              withAddress("address").
              withMobile("12345").
              withEmail("first.last@mmmm.com").
              withGroup("test2"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().
            withId(before.get(index).getId()).
            withFirstName("first").
            withLastName("las").
            withAddress("address2").
            withMobile("22345").
            withEmail("first2.last@mmmm.com");

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
