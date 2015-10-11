package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidsContactGenerator")
	public void modifySomeContact(ContactData contact){   
		// save old state
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

	    //int index = 1 + (int)(Math.random()*((oldList.size() - 1) + 1));
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    		
	    // actions	
	    app.getContactHelper().modifyContact(index, contact);
	    
	    // save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}

}
