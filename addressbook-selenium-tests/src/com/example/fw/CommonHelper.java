package com.example.fw;

import org.openqa.selenium.By;

public class CommonHelper extends HelperBase {
	public CommonHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitCreation() {
		click(By.name("submit"));
	 }
}
