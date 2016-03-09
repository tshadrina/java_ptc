package ru.tantam.ptc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.tantam.ptc.addressbook.model.ContactData;

/**
 * Created by Tanya on 09.03.2016.
 */
public class ContactHelper extends BaseHelper{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
}
