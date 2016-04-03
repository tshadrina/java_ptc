package ru.tantam.ptc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tantam.ptc.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Tanya on 09.03.2016.
 */
public class GroupModificationTests extends BaseTest {

  @BeforeMethod
  public void preconditions() {
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()) {
      app.group().create(new GroupData().
              withName("test1").withHeader("test2_header").withFooter("test2_footer"));
    }
  }

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData().
            withId(before.get(index).getId()).withName("test1").withHeader("test2_header").withFooter("test2_footer");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);

  }
}
