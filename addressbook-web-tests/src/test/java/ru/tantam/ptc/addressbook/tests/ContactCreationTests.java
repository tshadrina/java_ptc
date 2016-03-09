package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;

public class ContactCreationTests extends BaseTest {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com"));
    app.getContactHelper().submitContactForm();
    app.getContactHelper().returnToHomePage();
  }

}
