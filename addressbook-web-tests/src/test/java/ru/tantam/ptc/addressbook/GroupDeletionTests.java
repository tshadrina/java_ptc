package ru.tantam.ptc.addressbook;


import org.testng.annotations.Test;


public class GroupDeletionTests extends BaseTest {

    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }

}
