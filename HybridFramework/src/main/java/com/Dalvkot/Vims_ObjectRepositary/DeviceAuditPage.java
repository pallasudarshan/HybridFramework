package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DeviceAuditPage extends WebDriverUtility {
	public DeviceAuditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Patient Care Surveillance ']")
	private WebElement patientCareSurveillanceBtn;

	@FindBy(xpath = "//button[@id='v-pills-profile-tab-6']")
	private WebElement deviceAuditButton;

	@FindBy(xpath = "//button[normalize-space(text())='New']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@placeholder='Hospital No']")

	private WebElement hospitalNumberText;

	@FindBy(xpath = "//div[@class='ng-value-container']/following-sibling::span[1]")
	private WebElement deviceDropdownBtn;

	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	private WebElement deviceInputText;

	@FindBy(css = "input[type='datetime-local']")
	private WebElement insertionDateAndTime;

	@FindBy(xpath = "//input[@placeholder='search']")
	private WebElement insertedByText;

	@FindBy(xpath = "//table/tbody/tr[1]/td[@class='text-wrap ng-star-inserted'][1]")
	private WebElement insertedBySuggestion;

	@FindBy(xpath = "//input[@id='homeRadio']")
	private WebElement dischargeNeededRadioBtn;

	@FindBy(xpath = "//input[@id='anotherRadio']")
	private WebElement oneMoreInsertRadionBtn;

	@FindBy(xpath = "//input[@id='otherRadio']")
	private WebElement otherRadioBtn;

	@FindBy(xpath = "//label[text()='Other']/..//descendant::textarea")
	private WebElement otherText;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButton;

	public void clickOnTheDeviceAuditButton(WebDriver driver) {
		deviceAuditButton.click();
	}

	public void clickOnThePatientCareSurveillance(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, patientCareSurveillanceBtn);
	}

	public void clickOnNewButtonAndenterHospitalNumber(WebDriver driver, String hospitalNumber) {
		newButton.click();
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void selectTheDevice(WebDriver driver, String deviceName) {
		deviceAuditButton.click();
		deviceInputText.sendKeys(deviceName, Keys.ENTER);
	}

	public void selectRadioButton(String option) {
		switch (option.toLowerCase()) {
		case "discharge needed":
			if (!dischargeNeededRadioBtn.isSelected()) {
				dischargeNeededRadioBtn.click();
			}
			break;

		case "another option":
			if (!oneMoreInsertRadionBtn.isSelected()) {
				oneMoreInsertRadionBtn.click();
			}
			break;

		case "other option":
			if (!otherRadioBtn.isSelected()) {
				otherRadioBtn.click();
			}
			break;

		default:
			throw new IllegalArgumentException("Invalid option: " + option);
		}
	}
}
