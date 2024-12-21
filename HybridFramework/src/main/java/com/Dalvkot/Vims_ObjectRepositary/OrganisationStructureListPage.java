package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class OrganisationStructureListPage extends WebDriverUtility {

	public OrganisationStructureListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Add')]//i")
	private WebElement OrganisationStructureList;

	@FindBy(xpath = "//input[@placeholder='Organisation']")
	private WebElement organisation_Text;

	@FindBy(xpath = "//input[@placeholder='Group']")
	private WebElement group_Text;

	@FindBy(xpath = "//input[@placeholder='Buisness Id']")
	private WebElement buisnessId_Text;

	@FindBy(xpath = "//input[@placeholder='Buisness Head']")
	private WebElement buisnessHeadText;

	@FindBy(xpath = "//input[@placeholder='Address']")
	private WebElement address_Text;

	@FindBy(xpath = "//input[@placeholder='Pincode']")
	private WebElement pincode_Text;

	@FindBy(xpath = "//span[@title='Post Office']/following-sibling::span")
	private WebElement postOffice_Dropdown;

	@FindBy(xpath = "//input[@placeholder='E-Mail']")
	private WebElement emailId_Text;

	@FindBy(xpath = "//input[@placeholder='Landline Number']")
	private WebElement landlineNumber_Text;

	@FindBy(xpath = "//input[@placeholder='Mobile NO']")
	private WebElement mobileNumber_Text;

}
