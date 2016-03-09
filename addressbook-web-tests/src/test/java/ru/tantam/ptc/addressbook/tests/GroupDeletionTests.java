package ru.tantam.ptc.addressbook.tests;


import org.testng.annotations.Test;


public class GroupDeletionTests extends BaseTest {

    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }

}
