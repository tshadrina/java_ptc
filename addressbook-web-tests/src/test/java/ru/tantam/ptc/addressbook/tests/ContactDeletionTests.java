package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.List;

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
    List<ContactData> before = app.contact().list();

    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().homePage();

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
