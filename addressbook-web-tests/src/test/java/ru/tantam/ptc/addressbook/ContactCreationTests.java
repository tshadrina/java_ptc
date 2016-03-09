package ru.tantam.ptc.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends BaseTest {

  @Test
  public void testContactCreation() {
    gotoContactCreation();
    fillContactForm(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com"));
    submitContactForm();
    gotoHomePage();
  }

}
