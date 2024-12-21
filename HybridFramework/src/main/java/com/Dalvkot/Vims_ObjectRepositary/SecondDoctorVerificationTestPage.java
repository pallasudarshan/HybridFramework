package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class SecondDoctorVerificationTestPage extends WebDriverUtility {
	public SecondDoctorVerificationTestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Second Doctor Verification Entry ']")
	private WebElement secondDoctorVerificationEntry;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement emergencySampleCheckox;

	@FindBy(xpath = "//label[text()='Service Class']/..//span[@role='presentation']")
	private WebElement serviceClassDropdownBtn_Filter;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText_Filter;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberText_Filter;

	@FindBy(xpath = "//input[@formcontrolname='selectionDate']")
	private WebElement doctorVerifiedDate_Filter;

	@FindBy(xpath = "//span[@title='Select Department Name']/following-sibling::span[1]")
	private WebElement departmentNameDropdownBtn_Filter;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span[1]")
	private WebElement wardTypeDropdownBtn_Filter;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]/descendant::a")
	private WebElement sampleNumber_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[2]/descendant::a")
	private WebElement sampleNumber_LastRow_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]")
	private WebElement sampleType_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[3]")
	private WebElement sampleType__LastRow_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement doctorVerifiedDate_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement hospitalNumber_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[5]")
	private WebElement hospitalNumber_LastRow_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[6]")
	private WebElement patientName_PatientListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[6]")
	private WebElement patientName_LastRow_PatientListTable;

	@FindBy(xpath = "//span[@role='combobox']//span[1]")
	private WebElement serviceClassDropdownData;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberData;

	@FindBy(xpath = "//input[@placeholder='Sample form']")
	private WebElement sampleFromData;

	@FindBy(xpath = "//input[@placeholder='Sample Type']")
	private WebElement sampleTypeData;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]")
	private WebElement heading_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]")
	private WebElement previousResult_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement units_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement referenceRange_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[6]/descendant::input[@placeholder='Result']")
	private WebElement result_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[8]/descendant::input[@placeholder='Remarks']")
	private WebElement remarks_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[9]/descendant::input[@placeholder='Notes']")
	private WebElement notesToPatient_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[10]/descendant::input[@placeholder='Notes']")
	private WebElement notesToDoctor_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[last()]/descendant::a[contains(text(),'View')]")
	private WebElement previewResult_ResultEntryTable;

	@FindBy(xpath = "//label[text()='Remarks/Note']/following-sibling::textarea")
	private WebElement remarks_NotesText;

	@FindBy(xpath = "//button[text()=' Previous Record']")
	private WebElement previousRecordBtn;

	@FindBy(xpath = "//button[text()=' Second Doctor Verified']")
	private WebElement secondDoctorVerifiedBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnSuccessfullMessage;

	@FindBy(xpath = "//div[text()='Successfully doctor verification is updated']")
	private WebElement successfullyDoctorVerficationIsUpdatedMsg;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	/*
	 * 
	 * Buiness Logics
	 * 
	 */

	public void clickOnSecondDoctorVerificationButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, secondDoctorVerificationEntry);
	}

	public void select_ServiceClass(WebDriver driver, String serviceClass) {
		dropdown(driver, serviceClassDropdownBtn_Filter, dropdownText, serviceClass);
	}

	public void enter_HospitalNumber_Filters(WebDriver driver, String hospitalNumber) {
		hospitalNumberText_Filter.sendKeys(hospitalNumber);
	}

	public void enterSampleNumber_Filter(WebDriver driver, String sampleNumber) {
		sampleNumberText_Filter.sendKeys(sampleNumber);
	}

	public void select_DoctorVerifiedDate_Filter(WebDriver driver, String date) {
		doctorVerifiedDate_Filter.sendKeys(date);
	}

	public void select_DepartmentName_Filter(WebDriver driver, String departmentName) {
		dropdown(driver, departmentNameDropdownBtn_Filter, dropdownText, departmentName);
	}

	public void select_WardType_Filter(WebDriver driver, String wardType) {

		dropdown(driver, wardTypeDropdownBtn_Filter, dropdownText, wardType);
	}

	public String capture_SampleNumber_Table(WebDriver driver) {
		String sampleNumber = sampleNumber_PatientListTable.getText();
		return sampleNumber;
	}

	public String capture_SampleNumber_LastRow_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampleNumber = sampleNumber_LastRow_PatientListTable.getText();
		return sampleNumber;
	}

	public String capture_SampleType_table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampleType = sampleType_PatientListTable.getText();
		return sampleType;
	}

	public String capture_SampleType_LastRow_table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampleType = sampleType__LastRow_PatientListTable.getText();
		return sampleType;
	}

	public String capture_DoctorVerifedDate_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = doctorVerifiedDate_PatientListTable.getText();
		String date1 = removeSpecialCharactersAndNumbers_RemoveLastCharacters(date, 5);
		return date1;
	}

	public String captue_HospitalNumber_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_PatientListTable.getText();
		return hospitalNumber;
	}

	public String captue_HospitalNumber_LastRow_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_LastRow_PatientListTable.getText();
		return hospitalNumber;
	}

	public String capture_PatientName_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String patientName = patientName_PatientListTable.getText();
		return patientName;
	}

	public String capture_PatientName_LastRow_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String patientName = patientName_LastRow_PatientListTable.getText();
		return patientName;
	}

	public void clickOn_SearchButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		searchBtn.click();
	}

	public void clickOn_ClearButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clearBtn.click();
	}
}