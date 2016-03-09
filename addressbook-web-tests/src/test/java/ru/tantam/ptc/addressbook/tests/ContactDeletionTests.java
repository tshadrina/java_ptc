package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Tanya on 10.03.2016.
 */
public class ContactDeletionTests extends BaseTest {

  @Test
  public void testContactDeletion(){
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().gotoHomePage();
  }
}
