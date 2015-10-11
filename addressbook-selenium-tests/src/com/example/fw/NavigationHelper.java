package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
	
	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
	  if(! onMainPage()) {
		    click(By.linkText("home"));
	  }
	 }

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;
	}

	public void groupsPage() {
		if(! onGroupsPage()) {
		    click(By.linkText("groups"));
		}
	 }

	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/groups.hph")
		&& driver.findElements(By.name("new")).size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void printPhonesPage(){
		if (! onPrintPhonePage()) {
			click(By.linkText("print phones"));
		}
	}
	
	private boolean onPrintPhonePage() {
		if (driver.getCurrentUrl().contains("all&print&phones")) {
			return true;
		}
		else {
			return false;
		}
	}
}
