package com.example.tests;

public class Sample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args){
	String b = "    +7 (916) 123-45-67    ";
	b = b.trim();
	System.out.println(b);
	b = b.replaceAll("[ ()\\-]", "");
	System.out.println(b);
	System.out.println(b.matches("\\+\\d+"));
	}
}
