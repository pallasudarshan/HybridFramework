package com.Dalvkot.Vims_ObjectRepositary;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class SearchPatientPage extends WebDriverUtility {

	public SearchPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space(text())='Add']")
	private WebElement addBtn;

	@FindBy(xpath = "//span[text()=' Search Patient ']")
	private WebElement searchPatientBtn;

	@FindBy(xpath = "//table[@id='myTableElementId']//tbody/tr[1]/td[2]//a")
	private WebElement HospitalNumber_Table;

	@FindBy(css = "input[formcontrolname='patientName']")
	private WebElement patientNameText;

	@FindBy(css = "input[formcontrolname='hospitalNumber']")
	private WebElement hospitalNumbetText;

	@FindBy(css = "input[formcontrolname='phoneNumber']")
	private WebElement phoneNumberText;

	@FindBy(css = "input[formcontrolname='idProofNo']")
	private WebElement idProofNumberText;

	@FindBy(css = "input[formcontrolname='regnDate']")
	private WebElement registrationText;

	@FindBy(css = "input[formcontrolname='dateOfBirth']")
	private WebElement dateOfBirthText;

	@FindBy(css = "input[formcontrolname='fatherName']")
	private WebElement fatherNameText;

	@FindBy(css = "input[formcontrolname='husbandName']")
	private WebElement spouseNameText;

	@FindBy(xpath = "//span[@title='Select Department Name']/following-sibling::span")
	private WebElement departmentDropdownBtn;

	@FindBy(xpath = "//span[@title='Registration Type']/following-sibling::span")
	private WebElement registrationTypeDropdownBtn;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[normalize-space(text())='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//table//tr[1]/td[4]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table//tr[1]/td[3]")
	private WebElement OpNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement department_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]")
	private WebElement doctorName_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[8]")
	private WebElement registerDate_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[10]")
	private WebElement visitNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[11]")
	private WebElement departmentVisit_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[12]")
	private WebElement idCardNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()-2]")
	private WebElement status_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement phoneNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[9]")
	private WebElement registrtaionType_Table;

	@FindBy(xpath = "//button[normalize-space(text())='Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//input[@placeholder='Search Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//button[text()=' Edit']")
	private WebElement editBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getIdProofNumberText() {
		return idProofNumberText;
	}

	public WebElement getPhoneNumberInTheTable() {
		return phoneNumber_Table;
	}

	public WebElement getHospitalNumber_Table() {
		return HospitalNumber_Table;
	}

	public WebElement getPatientName_Table() {
		return patientName_Table;
	}

	public WebElement getDepartment_Table() {
		return department_Table;
	}

	public WebElement getDoctorName_Table() {
		return doctorName_Table;
	}

	public WebElement getRegisterDate_Table() {
		return registerDate_Table;
	}

	public WebElement getVisitNumber_Table() {
		return visitNumber_Table;
	}

	public WebElement getDepartmentVisit_Table() {
		return departmentVisit_Table;
	}

	public WebElement getIdCardNumber_Table() {
		return idCardNumber_Table;
	}

	public WebElement getStatus_Table() {
		return status_Table;
	}

	public WebElement getPhoneNumber_Table() {
		return phoneNumber_Table;
	}

	public WebElement getRegistrtaionType_Table() {
		return registrtaionType_Table;
	}

	public WebElement getClearBtn() {
		return clearBtn;
	}

	public WebElement getRegistrtaionTypeInTheTable() {
		return registrtaionType_Table;
	}

	public WebElement getPatientNameText() {
		return patientNameText;
	}

	public WebElement getHospitalNumbetText() {
		return hospitalNumbetText;
	}

	public WebElement getPhoneNumberText() {
		return phoneNumberText;
	}

	public WebElement getIdProofNumber() {
		return idProofNumberText;
	}

	public WebElement getRegistrationText() {
		return registrationText;
	}

	public WebElement getDateOfBirthText() {
		return dateOfBirthText;
	}

	public WebElement getFatherNameText() {
		return fatherNameText;
	}

	public WebElement getSpouseNameText() {
		return spouseNameText;
	}

	public WebElement getDepartmentDropdownBtn() {
		return departmentDropdownBtn;
	}

	public WebElement getRegistrationTypeDropdownBtn() {
		return registrationTypeDropdownBtn;
	}

	public WebElement getDropdownText() {
		return dropdownText;
	}

	public WebElement getSearchPatientBtn() {
		return searchPatientBtn;
	}

	public WebElement getCpatureHospitalNumber() {
		return HospitalNumber_Table;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	/**
	 * 
	 * Buisness Logics
	 * 
	 * @throws Throwable
	 * 
	 * 
	 */
	public void clickOnTheSearchPatientButton(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, searchPatientBtn);
	}

	public String captureHospitalNumberInTheTable() throws Throwable {
		Thread.sleep(2500);
		String hospitalNumber = HospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String capturePatientNameInTheTable() {
		String patientName = HospitalNumber_Table.getText();
		return patientName;
	}

	public void clickOnTheAddButton(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(addBtn)));
		addBtn.click();
	}

	public void SearchPatientName(WebDriver driver, String name) {
		patientNameText.sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void searchHopsitalNumber(WebDriver driver, String hospiatlNumber) {
		hospitalNumbetText.sendKeys(hospiatlNumber);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void searchPhoneNumber(WebDriver driver, String mobilenum) {
		phoneNumberText.sendKeys(mobilenum);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void searchIdProofNumber(WebDriver driver, String idProofNumber) {
		idProofNumberText.sendKeys(idProofNumber);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void seacrhFatherName(WebDriver driver, String fname) {
		fatherNameText.sendKeys(fname);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void searchSpouseName(WebDriver driver, String spouse) {
		spouseNameText.sendKeys(spouse);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void searchDateOfBirth(WebDriver driver) {
		dateOfBirthText.sendKeys();
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void registrationDate(WebDriver driver, String currentDate) {
		registrationText.sendKeys(currentDate);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void searchDepartment(WebDriver driver, String depName) {
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, depName);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);

	}

	public void searchRegistartionType(WebDriver driver, String regType) {
		registrationTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, regType);
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(searchBtn)));
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public String capturePhoneNumberInTheTable() {

		String phoneNuberinTheTable = phoneNumber_Table.getText();
		return phoneNuberinTheTable;

	}

	public void clickOnTheClearBtn(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(clearBtn)));
		moveToTheParticularElementAndClick(driver, clearBtn);

	}

	public String captureTheSpouseNameInTheTable() {
		String spouseName1 = spouseNameText.getText();
		return spouseName1;
	}

	public String captureThePatientName_Table() {
		String patientName = patientName_Table.getText();
		String lastNum = patientName.substring(0, patientName.length() - 8);
		String firstNum = lastNum.substring(3);
		System.out.println(firstNum);
		return firstNum;
	}

	public String captureTheDepartmentName_Table() {
		String str = department_Table.getText();
		String departmentName = removeLast_n_NumberOfCharacters(str, 4);
		return departmentName;
	}

	public String captureDoctorNameInTheTable() {
		String doctorName = doctorName_Table.getText();
		return doctorName;
	}

	public String captureRegistrationDateAndTimeTable() {
		String registrationDateAndTime = registerDate_Table.getText();
		return registrationDateAndTime;

	}

	public String captureRegistartionTypeTable() {
		String registrationType = registrtaionType_Table.getText();
		return registrationType;

	}

	public String captureVisitNUmber_Table() {
		String visitNumber = visitNumber_Table.getText();
		return visitNumber;
	}

	public String capturedepartmentVisitNumberTable() {

		String departmentVisitNumber = departmentVisit_Table.getText();
		return departmentVisitNumber;
	}

	public String captureIdCardNumberTable() {
		String idCardNumber = idCardNumber_Table.getText();
		return idCardNumber;
	}

	public String catureStatusInTheTable() {
		String status = status_Table.getText();
		return status;
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(1500);
		scrollDownTheStillEndOfThePage(driver);
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public String take_PatientName(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String pName = patientName_Table.getText();
		String patientName = removeSpecialCharactersAndNumbers_RemoveLastCharacters(pName, 12);
		System.out.println(patientName);
		return patientName;
	}

	public String take_OpNumber(WebDriver driver) {
		String opNumber = OpNumber_Table.getText();
		return opNumber;
	}

	public String captureAge_Table() {
		String patientName = patientName_Table.getText().replace(" ", "").replace("/", ",");
		String age = patientName.substring(patientName.indexOf("("), patientName.indexOf(")") + 1);
		return age;
	}

	public void rightClickOnHospitalNumberAndClickonEdit_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Actions actions = new Actions(driver);
		actions.contextClick(HospitalNumber_Table).perform();
		editBtn.click();
	}
}
