package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class CustomerSalesPage extends WebDriverUtility {
	
	public CustomerSalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	

}
