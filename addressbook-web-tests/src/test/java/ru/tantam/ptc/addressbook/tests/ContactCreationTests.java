package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;

public class ContactCreationTests extends BaseTest {

  @Test
  public void testContactCreation() {
    app.gotoContactCreation();
    app.fillContactForm(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com"));
    app.submitContactForm();
    app.gotoHomePage();
  }

}
