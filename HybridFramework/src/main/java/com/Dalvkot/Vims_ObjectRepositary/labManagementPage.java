package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class labManagementPage extends WebDriverUtility{
	
	@FindBy(xpath="//span[text()='Bill Type']")
	private WebElement billTypedropdown;
	
	@FindBy(xpath="//i[@class='zmdi zmdi-search']")
	private WebElement search;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
