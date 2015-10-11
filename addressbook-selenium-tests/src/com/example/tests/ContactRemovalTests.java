package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact(){   
		// save old state
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    System.out.println(oldList);
	    
	    //int index = 1 + (int)(Math.random()*((oldList.size() - 1) + 1));
	    if (oldList.size() >= 0) {
			int index;
			if(oldList.size()==1){
				index=0;
			}
			else {    
				Random rnd = new Random();
				index = rnd.nextInt(oldList.size()-1);
			}
		System.out.println(index);
		System.out.println(oldList.without(index));
		
	    // actions		    
		app.getContactHelper().deleteContact(index);
	   
	    
	    // save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    System.out.println(oldList.without(index));
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(index)));
	    }
	 }
}