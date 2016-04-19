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
 * Created by Tanya on 10.03.2016.
 */
public class ContactDeletionTests extends BaseTest {

  @BeforeMethod
  private void preconditions() {
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
  public void testContactDeletion() {
    Contacts before = app.contact().all();

    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();

    assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}
