package com.example.tests;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    gotoNewContact();
    ContactData contact = new ContactData();
    contact.firstname="firstname";
    contact.lastname="lastname";
    contact.address="address";
    contact.home="home";
    contact.mobile="mobile";
    contact.work="work";
    contact.email1="email 1";
    contact.email2="email 2";
    contact.date="1";
    contact.month="January";
    contact.year="1";
    contact.group="group 1";
    contact.address2="address 2";
    contact.phone2="phone 2";
 	fillContactForm(contact);
    submitCreation();
    returnToHomePage();
  }

@Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    gotoNewContact();
    fillContactForm(new ContactData("", "", "[none]", "", "-", "-", "", "", "", "", "", "", "", ""));
    submitCreation();
    returnToHomePage();
  }
}
