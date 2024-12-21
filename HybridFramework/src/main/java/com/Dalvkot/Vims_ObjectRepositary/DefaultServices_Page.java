package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DefaultServices_Page extends WebDriverUtility {

	public DefaultServices_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Default services ']")
	private WebElement defaultServiceBtn;

	@FindAll({ @FindBy(xpath = "//i[@class='zmdi zmdi-plus-circle']"), @FindBy(xpath = "//a[contains(.,'Add')]") })
	private WebElement addBtn;

	@FindBy(xpath = "//span[@title='select']/following-sibling::span")
	private WebElement wardNameDropdownBtn;

	@FindBy(xpath = "//span[@title='Rate Type']/following-sibling::span[1]")
	private WebElement rateTypeDropdownBtn;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[2]")
	private WebElement deptApplicableSwitchBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]/descendant::input")
	private WebElement serviceNameText_ServiceDetails;

	@FindBy(xpath = "//span[@title='Select']/following-sibling::span[1]")
	private WebElement periodDropdownBtn_ServiceDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]/descendant::input[@placeholder='Number']")
	private WebElement countText_ServiceDetails;

	@FindAll({ @FindBy(xpath = "//i[@class='zmdi zmdi-plus']"),
			@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[@type='button']") })
	private WebElement actionButton_ServiceDetails;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelButton;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Back')]"), @FindBy(linkText = "Back"),
			@FindBy(css = "a.btn.btn-white") })
	private WebElement backBtn;

	@FindAll({ @FindBy(xpath = "//table/tbody/tr[1]/td[2]") })
	private WebElement wardName_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	private WebElement services_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement duration_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement quantity_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/descendant::span[@data-off='No']/following-sibling::span")
	private WebElement switchStatusBtn_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[@data-toggle='dropdown']")
	private WebElement actionButton_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[text()=' Edit']")
	private WebElement editBtn_ActionTable;

	@FindBy(xpath = "//div[@id='swal2-content']")
	private WebElement errorMsg;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okPopupBtn;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPopupMsg_Corner;

	@FindAll({ @FindBy(xpath = "//div[@id='suggestions']/ul[1]/li[1]/div[1]/a"),
			@FindBy(xpath = "//div[@id='suggestions']/ul[1]/li[1]/div") })
	private WebElement suggestions_Services;

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 * 
	 * 
	 */

	public void clickOnDefaultServiceLink(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, defaultServiceBtn);
	}

	public void selectWardName(WebDriver driver, String ward) {
		wardNameDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, ward);

	}

	public void selectRateType(WebDriver driver, String rateType) {
		rateTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, rateType);
	}

	public void clickOnDeptAllpicatnble_SwicthButton(WebDriver driver) {
		deptApplicableSwitchBtn.click();
	}

	public void enterServiceNameText_ServiceDetails(WebDriver driver, String serviceNames) throws Throwable {
		Thread.sleep(2000);
		serviceNameText_ServiceDetails.sendKeys(serviceNames);
		suggestions_Services.click();
	}

	public void selectPeriod_ServiceDetails(WebDriver driver, String period) {
		periodDropdownBtn_ServiceDetails.click();
		moveToElementAndEnterTheData(driver, dropdownText, period);
	}

	public void enterCount_ServiceDetails(WebDriver driver, String count) {
		countText_ServiceDetails.sendKeys(count);
	}

	public void clickOnAction_ServiceDetail(WebDriver driver) {
		actionButton_ServiceDetails.click();
	}

	public void clickOnSubmitButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitButton);
		submitButton.click();
	}

	public void clickOnCancelButton(WebDriver driver) {
		cancelButton.click();
	}

	public String takeErrorPopupMessage(WebDriver driver) {
		String msg = errorMsg.getText();
		okPopupBtn.click();
		return msg;
	}

	public String takeWardName(WebDriver driver) {
		String ward = wardName_Table.getText();
		return ward;
	}

	public String takeServiceName(WebDriver driver) {
		String service = services_Table.getText();
		return service;
	}

	public String takeDuration(WebDriver driver) {
		String duration = duration_Table.getText();
		return duration;
	}

	public String takeQuantity(WebDriver driver) {
		String quantity = quantity_Table.getText();
		return quantity;
	}

	public void changeStatus_DefaultTable(WebDriver driver) {
		switchStatusBtn_Table.click();
	}

	public void clickOnActionButton(WebDriver driver) {
		doubleClickOnTheElement(driver, actionButton_Table);
	}

	public void clickOnEditButton(WebDriver driver) {
		editBtn_ActionTable.click();
	}

	public String errorPopupMessage_Corner(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String msg = errorPopupMsg_Corner.getText();
		return msg;
	}

}
