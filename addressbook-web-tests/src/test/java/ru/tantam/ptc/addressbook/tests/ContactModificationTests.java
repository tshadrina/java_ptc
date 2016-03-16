package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;

/**
 * Created by Tanya on 09.03.2016.
 */
public class ContactModificationTests extends BaseTest {

  @Test
  public void testContactModification(){
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("first", "last", "address", "12345", "first.last@mmmm.com","test2"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("first2", "last2", "address2", "22345", "first2.last2@mmmm.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
