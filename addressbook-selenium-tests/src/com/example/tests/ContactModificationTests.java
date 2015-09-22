package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidsContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.navigateTo().mainPage();	
	    
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    int index = 1 + (int)(Math.random()*((oldList.size() - 1) + 1));
	    
	    // actions	
	    app.getContactHelper().openContact(index);
		app.getContactHelper().fillContactForm(contact, MODIFICATION);
		app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index-1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}

}
