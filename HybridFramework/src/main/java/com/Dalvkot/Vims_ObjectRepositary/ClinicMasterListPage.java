package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ClinicMasterListPage extends WebDriverUtility {

	public ClinicMasterListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Clinic Master List ']")
	private WebElement clinicMasterListLink;

	@FindBy(xpath = "//span[text()='VYDEHI CLINIC']/following-sibling::span")
	private WebElement clinicName_Dropdown_Filter;

	@FindBy(xpath = "//span[@title='Select Department Name']/following-sibling::span[1]")
	private WebElement departmentName_Dropdown_Filter;

	@FindBy(xpath = "//button[text()='Search']//i")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()='Clear']//I")
	private WebElement ClearBtn;

	@FindBy(xpath = "//a[contains(text(),'Add')]//i")
	private WebElement addBtn;

	@FindBy(xpath = "//span[@title='Select Unit Type']/following-sibling::span[1]")
	private WebElement unit_Dropdown;

	@FindBy(xpath = "(//span[@title='Select Doctor Name']/following-sibling::span)[1]")
	private WebElement doctorDropdown;

	@FindBy(xpath = "(//input[@placeholder='Consultation Charge'])[1]")
	private WebElement consultation_Charge_Text;

	@FindBy(xpath = "(//input[@placeholder='Revisit Charge'])[1]")
	private WebElement revisit_Charge_Text;

	@FindBy(xpath = "//input[@placeholder='(No. of Days)']")
	private WebElement revisit_Rule_Text;

	@FindBy(xpath = "(//input[@placeholder='Doctor %'])[1]")
	private WebElement doctor_PercentageText;

	@FindBy(xpath = "(//input[@type='date'])[1]")
	private WebElement fromDate_Btn;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[1]")
	private WebElement active_SwicthBtn;

	@FindBy(xpath = "(//button[@type='button']//i)[1]")
	private WebElement actionBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement Ok_Error_popup;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement pleaseFillTheMandatory_Fields;

	@FindBy(xpath = "")
	private WebElement dropdownText;

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 * 
	 */

	public void click_On_ClinicMaster_List(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, clinicMasterListLink);
	}

	public void select_Clinic_Name_Dropdown(WebDriver driver, String clinicName) {

		dropdown(driver, clinicMasterListLink, dropdownText, clinicName);
	}

	public void select_DepartmentName(WebDriver driver, String department) {

		dropdown(driver, departmentName_Dropdown_Filter, dropdownText, department);
	}

	public void clickOn_SearchButton(WebDriver driver) {
		searchBtn.click();
	}

	public void clickOn_ClearButton(WebDriver driver) {
		ClearBtn.click();
	}

	public void clickOn_AddButton(WebDriver driver) throws Throwable {
		addBtn.click();
	}

	public void select_UnitDropdown(WebDriver driver, String unit) {
		dropdown(driver, unit_Dropdown, dropdownText, unit);
	}

	public void select_Doctor_Dropdown(WebDriver driver, String doctor) {
		dropdown(driver, doctorDropdown, dropdownText, doctor);
	}

	public void enter_ConsultationCharge(WebDriver driver, String consultationCharge) {
		consultation_Charge_Text.sendKeys(consultationCharge);
	}

	public void enter_RevisitCharge(WebDriver driver, String revisitCharge) {
		revisit_Charge_Text.sendKeys(revisitCharge);
	}

	public void enter_RevisitRule(WebDriver driver, String revisitRule) {
		revisit_Rule_Text.sendKeys(revisitRule);
	}

	public void enter_Doctor_Percentage(WebDriver driver, String doctorPercentage) {
		doctor_PercentageText.sendKeys(doctorPercentage);
	}

	public void clickOn_FromDate(WebDriver driver) {
		fromDate_Btn.click();
	}

	public void clickOn_ActiveSwitch_Button(WebDriver driver) {
		active_SwicthBtn.click();
	}

}
