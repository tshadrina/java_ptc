package ru.tantam.ptc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.tantam.ptc.addressbook.model.ContactData;
import ru.tantam.ptc.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by Tanya on 09.03.2016.
 */
public class ContactHelper extends BaseHelper {

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
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      if (contactData.getGroup() != null) {
        //TODO а если в выпадашке нет такой группы
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void initContactModification(int id) {
    wd.findElement(By.xpath(".//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void submitContactModification() {
    click(By.xpath(".//input[@value='Update' and @type='submit'][1]"));
  }

  private void selectContactById(int id) {
    WebElement contact = wd.findElement(By.id(String.valueOf(id)));
    if (!contact.isSelected()) {
      contact.click();
    }
  }

  public int count(){
    return wd.findElements(By.name("selected[]")).size();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectAll() {
    click(By.xpath("//*[@id='MassCB']"));
  }

  public void create(ContactData contact) {
    fillContactForm(contact, true);
    submitContactForm();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
    alertAccept();
  }

  public void deleteAll() {
    selectAll();
    deleteSelectedContacts();
    contactCache = null;
    alertAccept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[1]/input[@type='checkbox']"));
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String first = cells.get(2).getText();
      String last = cells.get(1).getText();
      String[] phones = cells.get(5).getText().split("\n");
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(first).withLastName(last)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
//    initContactModificationById(contact.getId());
    initContactModification(contact.getId());
    String firstname= wd.findElement(By.name("firstname")).getAttribute("value");
    String lasttname= wd.findElement(By.name("lastname")).getAttribute("value");
    String home= wd.findElement(By.name("home")).getAttribute("value");
    String mobile= wd.findElement(By.name("mobile")).getAttribute("value");
    String work= wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lasttname)
            .withMobilePhone(mobile).withHomePhone(home).withWorkPhone(work);
  }

//  private void initContactModificationById(int id) {
//    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
//    WebElement row = checkbox.findElement(By.xpath("./../.."));
//    List<WebElement> cells= row.findElements(By.tagName("td"));
//    cells.get(7).findElement(By.tagName("a")).click();
//
//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
//    wd.findElement(By.xpath(String.format("tr[.//input[@value='%s']]/td[8]/a",id))).click();
//  }
}
