package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String phone2;
	private String address2;
	private String group;
	private String year;
	private String month;
	private String date;
	private String email2;
	private String email1;
	private String work;
	private String mobile;
	private String home;
	private String address;
	private String lastname;
	private String firstname;
	
	public String getPhone2() {
		return phone2;
	}

	public String getAddress2() {
		return address2;
	}

	public String getGroup() {
		return group;
	}

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public String getDate() {
		return date;
	}

	public String getEmail2() {
		return email2;
	}

	public String getEmail1() {
		return email1;
	}

	public String getWork() {
		return work;
	}

	public String getMobile() {
		return mobile;
	}

	public String getHome() {
		return home;
	}

	public String getAddress() {
		return address;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public ContactData(){
	}

	public ContactData(String phone2, String address2, String group, String year, String month, String date,
			String email2, String email1, String work, String mobile, String home, String address, String lastname,
			String firstname) {
		this.phone2 = phone2;
		this.address2 = address2;
		this.group = group;
		this.year = year;
		this.month = month;
		this.date = date;
		this.email2 = email2;
		this.email1 = email1;
		this.work = work;
		this.mobile = mobile;
		this.home = home;
		this.address = address;
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
	
	@Override
	public String toString() {
		return "ContactData [phone2=" + phone2 + ", address2=" + address2 + ", group=" + group + ", year=" + year
				+ ", month=" + month + ", date=" + date + ", email2=" + email2 + ", email1=" + email1 + ", work=" + work
				+ ", mobile=" + mobile + ", home=" + home + ", address=" + address + ", lastname=" + lastname
				+ ", firstname=" + firstname + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}
	

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	

	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}
	

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	

	public ContactData withDate(String date) {
		this.date = date;
		return this;
	}

	public ContactData withMonth(String month) {
		this.month = month;
		return this;
	}
	
	public ContactData withYear(String year) {
		this.year = year;
		return this;
	}
	
	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}
	
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	
}