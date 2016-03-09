package ru.tantam.ptc.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.tantam.ptc.addressbook.appmanager.ApplicationManager;

/**
 * Created by Tanya on 09.03.2016.
 */
public class BaseTest {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
