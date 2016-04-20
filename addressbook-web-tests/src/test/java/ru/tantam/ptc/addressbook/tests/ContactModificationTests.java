package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.Contacts;
import ru.tantam.ptc.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
              withMobilePhone("12345").
              withEmail("first.last@mmmm.com").
              withGroup("test2"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).
            withFirstName("first").
            withLastName("las").
            withAddress("address2").
            withMobilePhone("22345").
            withEmail("first2.last@mmmm.com");
    app.contact().modify(contact);

    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
