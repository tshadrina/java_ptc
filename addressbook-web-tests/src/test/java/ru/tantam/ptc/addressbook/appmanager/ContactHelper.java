package ru.tantam.ptc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.tantam.ptc.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 09.03.2016.
 */
public class ContactHelper extends BaseHelper{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation){
      if (contactData.getGroup()!= null){
        //TODO а если в выпадашке нет такой группы
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home page"));
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath(".//input[@value='Update' and @type='submit'][1]"));
  }

  public void selectContact(int index) {
    WebElement contact = wd.findElements(By.name("selected[]")).get(index);
    if (!contact.isSelected()) {
      contact.click();
    }
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void createContact(ContactData contact) {
    fillContactForm(contact, true);
    submitContactForm();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[1]/input[@type='checkbox']"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element: elements){
      String first = element.findElements(By.tagName("td")).get(2).getText();
      String last = element.findElements(By.tagName("td")).get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, first, last, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
