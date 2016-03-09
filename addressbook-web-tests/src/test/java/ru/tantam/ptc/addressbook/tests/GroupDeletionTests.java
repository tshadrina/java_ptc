package ru.tantam.ptc.addressbook.tests;


import org.testng.annotations.Test;


public class GroupDeletionTests extends BaseTest {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
