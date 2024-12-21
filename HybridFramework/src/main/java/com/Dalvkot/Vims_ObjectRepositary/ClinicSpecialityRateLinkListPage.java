package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ClinicSpecialityRateLinkListPage extends WebDriverUtility {

	public ClinicSpecialityRateLinkListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ----------------------Xpath------------------------

	@FindBy(xpath = "//span[text()=' Clinic speciality rate link page ']")
	private WebElement clinicSpecialityRateLinkPage;

	@FindBy(xpath = "//input[@placeholder='Clinic Name']")
	private WebElement clinicNameField;

	@FindBy(xpath = "//input[@placeholder='Rate Type']")
	private WebElement rateTypeField;

	@FindBy(xpath = "//input[@placeholder='Department']")
	private WebElement departmentField;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[contains(.,'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	private WebElement slNoInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement clinicNameInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3])[1]")
	private WebElement rateTypeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[4])[1]")
	private WebElement departmentInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5])[1]")
	private WebElement depUnitInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[6])[1]")
	private WebElement consultationChargeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[7])[1]")
	private WebElement revisitConsultationCharge;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[8])[1]")
	private WebElement doctorInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[9])[1]")
	private WebElement hospitalInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[10])[1]")
	private WebElement statusInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[11]/descendant::button)[1]")
	private WebElement editBtnInTable;

	@FindBy(xpath = "//span[@id='select2-j1rh-container']/following-sibling::span[1]")
	private WebElement clinicNameDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Rate Type']/following-sibling::span[1]")
	private WebElement rateTypeDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[2]/descendant::span[@class='select2-selection__arrow'])[1]")
	private WebElement departmentNameDropDownBtn_inTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[3]/descendant::span[@class='select2-selection__arrow'])[1]")
	private WebElement departmentUnitDropDownBtn_inTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[4]/descendant::input)[1]")
	private WebElement consultationChargeField_inTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[5]/descendant::input)[1]")
	private WebElement revisitChargeField_inTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[6]/descendant::input)[1]")
	private WebElement doctorPercentageField_inTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[7]/descendant::input)[1]")
	private WebElement hospitalPercentage_inTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[8]/descendant::span)[1]")
	private WebElement statusBtnInTable;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[9]/descendant::button)[1]")
	private WebElement addBtnInTable;

	@FindBy(xpath = "(//button[text()=' Save'])[1]")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement backBtn;

	// -------------------------Logics----------------------------------

	public void clickOnClinicSpecialityRateLinkTest(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, clinicSpecialityRateLinkPage);
	}

	public void enterClinicName(WebDriver driver, String clinicName) {
		clinicNameField.sendKeys(clinicName);
	}

	public void enterRateType(WebDriver driver, String rateType) {
		clinicNameField.sendKeys(rateType);
	}

	public void enterDepartment(WebDriver driver, String department) {
		departmentField.sendKeys(department);
	}

	public void clickOnSearchBtn(WebDriver driver) {
		scrollTillVisibleElement(driver, searchBtn);
		searchBtn.click();
	}

	public void clickOnClearBtn(WebDriver driver) {
		scrollTillVisibleElement(driver, clearBtn);
		clearBtn.click();
	}

	public void clickOnAddbtn(WebDriver driver) {
		scrollToTop(driver);
		addBtn.click();
	}

	public void clickOnEditBtn(WebDriver driver) {
		scrollTillVisibleElement(driver, editBtnInTable);
		editBtnInTable.click();
	}

	public void selectClinicName(WebDriver driver, String clinicName) {
		clinicNameDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, clinicName);
	}

	public void selectRateType(WebDriver driver, String rateType) {
		invisibiltyOf_Element_ThreeDots(driver);
		rateTypeDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, rateType);
	}

	public void selectDepartmentName(WebDriver driver, String departmentName) {

		departmentNameDropDownBtn_inTable.click();
		moveToElementAndEnterTheData(driver, dropDownText, departmentName);
	}

	public void selectDepartmentUnit(WebDriver driver, String departmentUnit) {
		departmentUnitDropDownBtn_inTable.click();
		moveToElementAndEnterTheData(driver, dropDownText, departmentUnit);
	}

	public void enterConsultationCharge(WebDriver driver, String consultationCharge) {

		departmentField.sendKeys(consultationCharge);
	}

	public void enterRevisitCharge(WebDriver driver, String revisitCharge) {

		revisitChargeField_inTable.sendKeys(revisitCharge);
	}

	public void enterDoctorPercentage(WebDriver driver, String doctorPercentage) {
		doctorPercentageField_inTable.sendKeys(doctorPercentage);
	}

	public void clickOnStatusBtn(WebDriver driver) {
		statusBtnInTable.click();
	}

	public void clickOnAddLineItem(WebDriver driver) {
		addBtnInTable.click();
	}

	public void clickOnSaveBtn(WebDriver driver) {
		scrollTillVisibleElement(driver, saveBtn);
		saveBtn.click();
	}

	public void clickOnCancelBtn(WebDriver driver) {
		scrollTillVisibleElement(driver, cancelBtn);
		cancelBtn.click();
	}

}
