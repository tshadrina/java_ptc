package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tanya on 20.04.2016.
 */
public class ContactPhoneTests extends BaseTest {

  @BeforeMethod
  private void preconditions() {
    app.contact().deleteAll();
    app.goTo().contactCreation();
    app.contact().create(new ContactData().withFirstName("first").withLastName("last").
            withMobilePhone("+7(111)").
            withWorkPhone("11-22-33").
            withHomePhone("333 333"));
  }

  @Test
  public void testContactPhone() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }

}
