package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
	    
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    int index = 1 + (int)(Math.random()*((oldList.size() - 1) + 1));
	
	    // actions		    
		app.getContactHelper().openContact(index);
		app.getContactHelper().deleteContact();
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index-1);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
}
