package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DrugServicePackageMasterPage extends WebDriverUtility {

	public DrugServicePackageMasterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ----------------Xpath------------------------
	@FindBy(xpath = "//span[text()=' drug-service-package ']")
	private WebElement drugServicePackageMasterBtn;

	@FindBy(xpath = "//a[contains(text(),'Drugs')]")
	private WebElement drugsTab;

	@FindBy(xpath = "//a[contains(text(),'Service')]")
	private WebElement serviceTab;

	@FindBy(xpath = "//div[contains(@class,'form-group col-lg-7')]//button[1]")
	private WebElement newBtn;

	@FindBy(xpath = "(//div[@id='Service']/descendant::table/tbody/tr[1]/td[1])[1]")
	private WebElement slNoInTable_service;

	@FindBy(xpath = "(//div[@id='Service']/descendant::table/tbody/tr[1]/td[2])[1]")
	private WebElement packageCodeInTable_service;

	@FindBy(xpath = "(//div[@id='Service']/descendant::table/tbody/tr[1]/td[3])[1]")
	private WebElement packageNameInTable_service;

	@FindBy(xpath = "(//div[@id='Service']/descendant::table/tbody/tr[1]/td[5])[1]")
	private WebElement departmentApplicableInTable_service;

	@FindBy(xpath = "(//div[@id='Service']/descendant::table/tbody/tr[1]/td[6])[1]")
	private WebElement departmentNameInTable_service;

	@FindBy(xpath = "(//div[@id='Service']/descendant::table/tbody/tr[1]/td[7]/descendant::button)[1]")
	private WebElement actionBtnInTable_service;

	@FindBy(xpath = "(//button[text()=' Edit'])[1]")
	private WebElement editBtnUnderActionInTable_service;

	@FindBy(xpath = "(//button[text()=' Cancel'])[1]")
	private WebElement cancelBtnUnderActionInTable_service;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement submitBtnIncancelPopup;

	@FindBy(xpath = "(//button[@type='submit']/following-sibling::button)[3]")
	private WebElement cancelBTnInCancelPopUp;

	@FindBy(xpath = "(//textarea[@placeholder='Reason'])[2]")
	private WebElement reasonTextFieldInCancelpopup;

	@FindBy(xpath = "(//span[@title='Select']/following-sibling::span)[1]")
	private WebElement packageTypeDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement packageNameField;

	@FindBy(xpath = "(//span[@role='textbox']/following-sibling::span)[2]")
	private WebElement applicableToDropDownBtn;

	@FindBy(xpath = "(//span[@data-off='No'])[1]")
	private WebElement departmentApplicableBtn;

	@FindBy(xpath = "(//div[@class='input-container']//input)[1]")
	private WebElement drugDescriptionFieldInTable_serviceDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]/descendant::input")
	private WebElement quantityFieldInTable_serviceDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]/descendant::span")
	private WebElement statusBtnInTable_serviceDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/descendant::i")
	private WebElement addBtnInTable_serviceDescription;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[1]/td[2]/div[1]/ng-autocomplete[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/a[1]/b[1]")
	private WebElement suggestion;

	@FindBy(xpath = "//div[@aria-label='Please enter Lineitems']")
	private WebElement errorMsg;

	@FindBy(xpath = "//i[@class='zmdi zmdi-delete']")
	private WebElement deleteBtn;

	// --------------------------Logics--------------------------------

	public void clickOnDrugServicePackageMasterBtn(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, drugServicePackageMasterBtn);
	}

	public void clickOnNewBtn(WebDriver driver) {
		scrollToTop(driver);
		newBtn.click();
	}

	public void selectPackageType(WebDriver driver, String packageType) {
		packageTypeDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, packageType);
	}

	public void selectApplicableTo(WebDriver driver, String applicableTo) throws Throwable {
		Thread.sleep(1000);
		applicableToDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, applicableTo);
	}

	public void enterPackageName(WebDriver driver, String packageName) {
		packageNameField.sendKeys(packageName);
	}

	public void clickOnDepartmentApplicable(WebDriver driver) {
		departmentApplicableBtn.click();
	}

	public void enterDrugDescription(WebDriver driver, String drugDescription) throws Throwable {
		drugDescriptionFieldInTable_serviceDetails.sendKeys(drugDescription);
		Thread.sleep(400);
		suggestion.click();
	}

	public void enterQuantity(WebDriver driver, String quanity) {
		quantityFieldInTable_serviceDetails.sendKeys(quanity);
	}

	public void clickOnStatusBtn(WebDriver driver) {
		statusBtnInTable_serviceDetails.click();
	}

	public void clickOnAddBtnInTable(WebDriver driver) throws Throwable {
		addBtnInTable_serviceDescription.click();
	}

	public void clickOnSubmitBtn(WebDriver driver) {
		submitBtn.click();
	}

	public void clickOnCancelBtn(WebDriver driver) {
		cancelBtn.click();
	}

	public void clickOnDrugsTab(WebDriver driver) {
		drugsTab.click();
	}

	public void clickOnServiceTab(WebDriver driver) {
		serviceTab.click();
	}

	public String captureErrormsg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(500);
		String errorMsg1 = errorMsg.getText();
		return errorMsg1;
	}

	public void addLineItems(WebDriver driver, String description, String qty) throws Throwable {
		enterDrugDescription(driver, description);
		enterQuantity(driver, qty);
		clickOnStatusBtn(driver);
		clickOnAddBtnInTable(driver);
	}

	public void clickOnDelete(WebDriver driver) {
		deleteBtn.click();
	}

}
