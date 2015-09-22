package com.example.tests;


import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
  
  @Test(dataProvider = "randomValidsContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
    
	// save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
	
	// actions
    app.getContactHelper().gotoNewContact();
 	app.getContactHelper().fillContactForm(contact);
    app.getCommonHelper().submitCreation();
    app.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states 
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);   
    assertEquals(newList, oldList);
  }

}
