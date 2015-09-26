package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact(){   
		// save old state
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    int index = 1 + (int)(Math.random()*((oldList.size() - 1) + 1));
	
	    // actions		    
		app.getContactHelper().deleteContact(index);
	    
	    // save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
		//index=index-1;
		assertThat(newList, equalTo(oldList.without(index)));
	}
}