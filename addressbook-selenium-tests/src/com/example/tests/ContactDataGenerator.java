package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please, specify parameters: <amount of test data> <file> <format>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String  format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please, remove it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);	
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getPhone2() + "," + contact.getAddress2() + "," + contact.getGroup() + "," + contact.getYear() + ","
						+ contact.getMonth() + "," + contact.getDate() + "," + contact.getEmail2() + "," + contact.getEmail1() + "," 
						+ contact.getWork() + "," + contact.getMobile() + "," + contact.getHome() + "," + contact.getAddress() + "," 
						+ contact.getLastname() + "," + contact.getFirstname() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader (reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
					.withPhone2(part[0])
					.withAddress2(part[1])
					.withYear(part[3])
					.withMonth(part[4])
					.withDate(part[5])
					.withEmail2(part[6])
					.withEmail1(part[7])
					.withWork(part[8])
					.withMobile(part[9])
					.withHome(part[10])
					.withAddress(part[11])
					.withLastname(part[12])
					.withFirstname(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
		}
	
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i=0; i < amount; i++) {
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
			list.add(contact);
		}
		return list;
	}
	
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();	
		}	
	}
	
	public static String generateRandomYear() {
		Random rnd = new Random();		
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return Integer.toString(rnd.nextInt(9999)+1);
		}	
	}
	
	public static String getRandomDate(){
		String[] dateList = new String[]{"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		Random rnd = new Random();
		return dateList[rnd.nextInt(dateList.length)];
	}
	
	public static String getRandomMonth(){
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

}
