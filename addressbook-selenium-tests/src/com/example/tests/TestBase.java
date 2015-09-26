package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();	
		}	
	}
	
	public String generateRandomYear() {
		Random rnd = new Random();		
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return Integer.toString(rnd.nextInt(9999)+1);
		}	
	}
	
	public String getRandomDate(){
		String[] dateList = new String[]{"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		Random rnd = new Random();
		return dateList[rnd.nextInt(dateList.length)];
	}
	
	public String getRandomMonth(){
		String[] monthList = new String[]{
				"-", 
				"January", 
				"February", 
				"March", 
				"April", 
				"May", 
				"June", 
				"July", 
				"August", 
				"September", 
				"October", 
				"November", 
				"December"
		};
		Random rnd = new Random();
		return monthList[rnd.nextInt(monthList.length)];
	}
	
	
	
	@BeforeTest
	public void setUp() throws Exception {
	    app = new ApplicationManager();

	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }
		
	@DataProvider
	public Iterator<Object[]> randomValidsGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomString())
				.withHeader(generateRandomString())
				.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}	
	

	@DataProvider
	public Iterator<Object[]> randomValidsContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<2; i++) {
			ContactData contact = new ContactData()
					.withFirstname(generateRandomString())
					.withLastname(generateRandomString())
					.withAddress(generateRandomString())
					.withHome(generateRandomString())
					.withMobile(generateRandomString())
					.withWork(generateRandomString())
					.withEmail1(generateRandomString())
					.withEmail2(generateRandomString())
					.withDate(getRandomDate())
					.withMonth(getRandomMonth())
					.withYear(generateRandomYear())
					//.withGroup("group 1")
					.withAddress2(generateRandomString())
					.withPhone2(generateRandomString());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
}
