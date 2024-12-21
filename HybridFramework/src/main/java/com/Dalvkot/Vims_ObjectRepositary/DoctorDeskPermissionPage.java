package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DoctorDeskPermissionPage extends WebDriverUtility {

	public DoctorDeskPermissionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Doctor Desk Permissions ']")
	private WebElement doctorDeskPermissions;

	@FindBy(xpath = "//span[@title='user Type']/following-sibling::span[1]")
	private WebElement userType_Dropdown;

	@FindBy(xpath = "//span[@title='role_type']/following-sibling::span[1]")
	private WebElement roleType_Dropdown;

	@FindBy(xpath = "//span[@title='Role']/following-sibling::span[1]")
	private WebElement role_Dropdown;

	@FindBy(xpath = "//span[@title='organisationName']/following-sibling::span[1]")
	private WebElement organisation_Dropdown;

	@FindBy(xpath = "//span[@title='groupName']/following-sibling::span[1]")
	private WebElement group_Dropdown;

	@FindBy(xpath = "//span[@title='businessName']/following-sibling::span[1]")
	private WebElement buisnessId_Dropdown;

	@FindBy(xpath = "//span[@title='Menu']/following-sibling::span[1]")
	private WebElement type_Dropdown;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "(//button[text()=' Permission '])[1]//i")
	private WebElement permission_Btn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	/*
	 * 
	 * 
	 * Buisness Logics
	 * 
	 * 
	 * 
	 */

	public void clickOn_DoctorDeskPermission(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, doctorDeskPermissions);
	}

	public void select_UserType(WebDriver driver, String userType) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, userType_Dropdown, dropdownText, userType);
	}

	public void select_RoleType(WebDriver driver, String roleType) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, roleType_Dropdown, dropdownText, roleType);
	}

	public void select_Role(WebDriver driver, String role) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, role_Dropdown, dropdownText, role);
	}

	public void select_Organisation(WebDriver driver, String organisation) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, organisation_Dropdown, dropdownText, organisation);
	}

	public void select_Group(WebDriver driver, String group) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, group_Dropdown, dropdownText, group);
	}

	public void select_BuisnessId(WebDriver driver, String buisnessId) throws Throwable {
		Thread.sleep(2000);
		dropdown(driver, buisnessId_Dropdown, dropdownText, buisnessId);
	}

	public void select_Type(WebDriver driver, String type) {
		dropdown(driver, type_Dropdown, dropdownText, type);
	}

	public void clickOn_PermissionButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		permission_Btn.click();
	}

	public void clickOn_OkButton(WebDriver driver) {
		okBtn.click();
	}

}
