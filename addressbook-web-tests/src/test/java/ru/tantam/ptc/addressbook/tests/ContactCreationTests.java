package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.Contacts;
import ru.tantam.ptc.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends BaseTest {

  @BeforeMethod
  public void preconditions() {
    app.goTo().groupPage();
    if (!app.group().isThereAGroup("test2")) {
      app.group().create(new GroupData().withName("test2"));
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().contactCreation();

    ContactData contact = new ContactData().
            withFirstName("first").
            withLastName("last").
            withAddress("address").
            withMobilePhone("12345").
            withEmail("first.last@mmmm.com").
            withGroup("test2");
    app.contact().create(contact);

    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
