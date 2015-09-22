package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String phone2;
	public String address2;
	public String group;
	public String year;
	public String month;
	public String date;
	public String email2;
	public String email1;
	public String work;
	public String mobile;
	public String home;
	public String address;
	public String lastname;
	public String firstname;
	
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
	
}