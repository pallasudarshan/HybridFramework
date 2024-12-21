package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DepartmentPage extends WebDriverUtility {

	public DepartmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Department ']")
	private WebElement departmentScreenBtn;

	@FindBy(xpath = "//a[normalize-space(text())='Add']")
	private WebElement addBtn;

	@FindBy(xpath = "//a[@class='btn btn-white btn-round float-right']")
	private WebElement backButton;

	@FindBy(xpath = "//label[text()='Department Type']/..//span[@role='presentation']")
	private WebElement departmentTypeDrop_Down;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement drop_downSearchBox;

	@FindBy(xpath = "//label[text()='Speciality']/..//span[@role='presentation']")
	private WebElement specialityDrop_Down;

	@FindBy(xpath = "//input[@placeholder='Department Short Name']")
	private WebElement departmentShortNameTextField;

	@FindBy(xpath = "//input[@placeholder='Department Name']")
	private WebElement departmentNameTextField;

	@FindBy(xpath = "//input[@placeholder='Number Of Unit']")
	private WebElement noOfUnitTextField;

	@FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[1]")
	private WebElement appointmentapplicableBtn;

	@FindBy(xpath = "//input[@id='RevisitRule']/following-sibling::span[1]")
	private WebElement revistRuleApplicableBtn;

	@FindBy(xpath = "//input[@id='AllowAdmission']/following-sibling::span[1]")
	private WebElement allowAdmissionBtn;

	@FindBy(xpath = "//input[@placeholder='Sequence']")
	private WebElement sequenceTextField;

	@FindBy(xpath = "//input[@id='departmentStatus']/following-sibling::span[1]")
	private WebElement statusBtn;

	@FindBy(xpath = "//label[text()='From Date']/following-sibling::input")
	private WebElement fromDateTextField;

	@FindBy(xpath = "")
	private WebElement toDateField;

	@FindBy(xpath = "//label[text()='To Date']/following-sibling::input")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Submit']/following-sibling::button")
	private WebElement cancelBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/div[@class='btn-group']")
	private WebElement actionBtnForRow1;

	@FindBy(xpath = "//button[text()=' PDF']/following-sibling::div//descendant::table/tbody/tr[1]/td[last()]//button[text()=' Edit']")
	private WebElement editBtn;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement departmentTpeErrorMsg;

	@FindBy(css = "div[aria-label='Please Select Speciality']")
	private WebElement SpecialityErrorMsg;

	@FindBy(css = "div[aria-label='Please enter Department Short Name']")
	private WebElement departmentShortNameErrorMsg;

	@FindBy(css = "div[aria-label='Please enter Department Name']")
	private WebElement departmentNameErrorMsg;

	@FindBy(css = "div[aria-label='Please enter No. Of Unit']")
	private WebElement noOfUnitErrorMsg;

	@FindBy(xpath = "//button[normalize-space(text())='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[normalize-space(text())='Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//label[text()='Department Type']/..//span[@role='presentation']")
	private WebElement departmentTypeDropDownSearchFilter;

	@FindBy(xpath = "//label[text()='Speciality']/..//span[@role='presentation']")
	private WebElement specialityDropDownSearchFilter;

	@FindBy(xpath = "//input[@placeholder='Department Name']")
	private WebElement departmentNameSearchFilter;

	@FindBy(xpath = "//button[normalize-space(text())='Search']")
	private WebElement searchBtnForSearchFilter;

	@FindBy(xpath = "//button[normalize-space(text())='Clear']")
	private WebElement clearBtnForSearchFilter;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	// Buissness logics
	public void clickOnTheDepartmentScreenButton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, departmentScreenBtn);
	}

	public void clickOnTheAddButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, addBtn);
	}

	public void selectDepartmentTypeDropdown(WebDriver driver, String departmentType) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		departmentTypeDrop_Down.click();
		moveToElementAndEnterTheData(driver, drop_downSearchBox, departmentType);
	}

	public void selectSpecialityTypeDropdown(WebDriver driver, String Speciality) {
		invisibiltyOf_Element_ThreeDots(driver);
		specialityDrop_Down.click();
		moveToElementAndEnterTheData(driver, drop_downSearchBox, Speciality);
	}

	public void enterDepartmentShortName(String departmentShortName) {
		departmentShortNameTextField.sendKeys(departmentShortName);
	}

	public void enterDepartmentName(String departmentName) {
		departmentNameTextField.sendKeys(departmentName);
	}

	public void enterNumberOfUnit(String numberOfUnit) {
		noOfUnitTextField.sendKeys(numberOfUnit);
	}

	public void enterSequence(String sequance) {
		sequenceTextField.sendKeys(sequance);
	}

	public void enterFromDate(String fromDate) {
		fromDateTextField.sendKeys(fromDate);
	}

	public void entertoDate(String toDate) {
		toDateField.sendKeys(toDate);
	}

	public void clickOnSubmit(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtn);
	}

	public void clickOnAction(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, actionBtnForRow1);
	}

	public void clickOnEdit(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, editBtn);
	}

	public String clickOnThePleaseEnterTheDepartment_Msg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String ErrorMsg = departmentTpeErrorMsg.getText();
		departmentTpeErrorMsg.click();
		Thread.sleep(1000);
		return ErrorMsg;

	}

	public String clickOnThePleaseEnterThSpeciality_Msg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String errorMsg = SpecialityErrorMsg.getText();
		SpecialityErrorMsg.click();
		Thread.sleep(1000);
		return errorMsg;

	}

	public String clickOnThePleaseEnterDepartmentTypeShoryName_Msg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String errorMsg = departmentShortNameErrorMsg.getText();
		departmentShortNameErrorMsg.click();
		Thread.sleep(1000);
		return errorMsg;

	}

	public String clickOnThePleaseEnterDepartmentName_Msg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String errorMsg = departmentNameErrorMsg.getText();
		departmentNameErrorMsg.click();
		Thread.sleep(1000);
		return errorMsg;

	}

	public String clickOnThePleaseEnterNoOfUnit_Msg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String errorMsg = noOfUnitErrorMsg.getText();
		noOfUnitErrorMsg.click();
		Thread.sleep(1000);
		return errorMsg;

	}

	public void clickOnCancelBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, cancelBtn);
	}

	public void clickOnBackBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, backButton);
	}

	public void clickOnSearcBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, searchBtn);
	}

	public void clickOnClearBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, clearBtn);

	}

	public void clickOn_OkButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		okBtn.click();
	}
}
