package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.Set;

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
    Set<ContactData> before = app.contact().all();
    app.goTo().contactCreation();

    ContactData contact = new ContactData().
            withFirstName("first").
            withLastName("last").
            withAddress("address").
            withMobile("12345").
            withEmail("first.last@mmmm.com").
            withGroup("test2");
    app.contact().create(contact);

    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(after, before);
  }

}
