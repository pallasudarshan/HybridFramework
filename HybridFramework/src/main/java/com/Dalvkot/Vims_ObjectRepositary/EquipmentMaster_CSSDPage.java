package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EquipmentMaster_CSSDPage {

	public EquipmentMaster_CSSDPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space(text())='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//label[contains(.,'Equipment Name *')]/..//span[@role='presentation']")
	private WebElement equipmentMasterDropdownBtn;

	@FindBy(xpath = "//input[contains(@class,'form-control tempC')]")
	private WebElement temparatureInCentigradeText;

	@FindBy(xpath = "//input[contains(@class,'form-control pressLbs')]")
	private WebElement pressureInLBS_Text;

	@FindBy(xpath = "//input[@formcontrolname='exposureDuration']")
	private WebElement exposureDuration;

	@FindBy(xpath = "//input[@id='time']")
	private WebElement dryTimeText;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPopupMessage;

	@FindBy(xpath = "//label[text()='Equipment Name']/..//span[@role='presentation']")
	private WebElement equipmentNameDropdownBtn;

	@FindBy(xpath = "//label[text()='Status']/..//span[@role='presentation']")
	private WebElement statusDropdownBtn;

//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	

}
