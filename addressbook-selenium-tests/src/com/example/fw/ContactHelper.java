package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();			
		}
		return cachedContacts;
	}
	
	public void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
			String firstname = (row.findElement(By.xpath(".//td[3]"))).getText();
			String lastname = (row.findElement(By.xpath(".//td[2]"))).getText();	
			cachedContacts.add(new ContactData().withFirstname(firstname).withLastname(lastname));
		}
	}
	
	public void createContact(ContactData contact) {
		gotoNewContact();
    	fillContactForm(contact, CREATION);
    	submitContactCreation();
    	returnToHomePage();
    	rebuildCache();
	}
	
	public void modifyContact(int index, ContactData contact) {
		openContact(index);
		fillContactForm(contact, MODIFICATION);
    	submitContactModification();
    	returnToHomePage();
    	rebuildCache();
	}

	public void deleteContact(int index) {
		openContact(index);
		submitContactDeletion();
		returnToHomePage();
		rebuildCache();		
	}
	
	
	//------------------------------------------------	
	
	public ContactHelper gotoNewContact() {
	    click(By.linkText("add new"));
	    return this;
	  }

	public ContactHelper openContact(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath("//tr[" + (index+1) + "]//img[@title='Edit']"));
	    return this;
	}
	
	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"),contact.getFirstname());
		type(By.name("lastname"),contact.getLastname());
		type(By.name("address"),contact.getAddress());
		type(By.name("home"),contact.getHome());		
		type(By.name("mobile"),contact.getMobile());	
		type(By.name("work"),contact.getWork());		
		type(By.name("email"),contact.getEmail1());
		type(By.name("email2"),contact.getEmail2());	
		selectByText(By.name("bday"), contact.getDate());
		selectByText(By.name("bmonth"), contact.getMonth());
		type(By.name("byear"),contact.getYear());	
		if (formType == CREATION) {
		//selectByText(By.name("new_group"), contact.getGroup());
		}
		else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error ("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"),contact.getAddress2());
		type(By.name("phone2"),contact.getPhone2());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	 }
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	    return this;
	}

	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
	    return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
	    return this;
	}
	
}
