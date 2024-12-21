package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class otConfirmationPage extends WebDriverUtility {

	public otConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// xpath

	@FindBy(xpath = "//span[text()=' Surgery Confirmation list ']")
	private WebElement otConfimrationScreenBtn;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement submitBtn;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText_Filter;

	@FindBy(xpath = "//input[@formcontrolname='scheduleNumber']")
	private WebElement scheduleNumberText_Filter;

	@FindBy(xpath = "//input[@formcontrolname='patientName']")
	private WebElement patientNameText_Filter;

	@FindBy(xpath = "//input[@formcontrolname='regnDate']")
	private WebElement surgeryFromDate_Calender;

	@FindBy(xpath = "//span[@title='select Department']/following-sibling::span[1]")
	private WebElement departmentNameDropdown_Filter;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement search_Filter;

	@FindBy(css = "input[aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn_Filter;

	@FindBy(css = "button.btn.btn-white.btn-round")
	private WebElement addBtn;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[2]")
	private WebElement lastRowHospitalNumber_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[4]")
	private WebElement lastRowscheduleNumber_surgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement lastRowpatientName_surgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement lastRowdepartmentName_surgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[7]")
	private WebElement lastRowWardType_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[8]")
	private WebElement lastRowRoomType_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[9]")
	private WebElement lastRowdate_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[last()]/td[10]")
	private WebElement lastRowStatus_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[2]/descendant::a")
	private WebElement lastRow_HospitalNumber_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[4]")
	private WebElement lastRow_ScheduleNumber_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement lastRow_PatientName_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement lastRow_WardType_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[7]")
	private WebElement lastRow_RoomType_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[8]")
	private WebElement lastRow_Date_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[9]")
	private WebElement lastRow_Status_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[2]//a")
	private WebElement firstRow_HospitalNumber_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement firstRow_ScheduleNumber_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement firstRow_PatientName_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement firstRow_WardType_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement firstRow_RoomType_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement firstRow_Date_SurgeryConfirmationList;

	@FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement firstRow_Status_SurgeryConfirmationList;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Surgery Confirmation List')]") })
	private WebElement surgeryConfirmationListTab;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement firstRow_HospitalNumber_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement firstRow_ScheduleNumber_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']//table/tbody/tr[1]/td[5]")
	private WebElement firstRow_PatientName_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement firstRow_DepartmentName_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement firstRow_WardType_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement firstRow_RoomType_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement firstRow_Date_SurgeryPendingList;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement firstRow_Status_SurgeryPendingList;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButton;

	// Logics

	public void clickOnOtConfirmationScreenBtn(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, otConfimrationScreenBtn);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnHospitalNumberInTheTable(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, firstRow_HospitalNumber_SurgeryConfirmationList);
		firstRow_HospitalNumber_SurgeryConfirmationList.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnSubmitBtn(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollTillVisibleElement(driver, submitBtn);
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtn);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOn_OkButton(driver);
	}

	public void enterHospitalNumber_Filter(WebDriver driver, String hospitalNumber) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		hospitalNumberText_Filter.sendKeys(hospitalNumber);
	}

	public void enterScheduleNumber_Filter(WebDriver driver, String scheduleNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scheduleNumberText_Filter.sendKeys(scheduleNumber);

	}

	public void enterPatientNameText_Filter(WebDriver driver, String patientName) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		patientNameText_Filter.sendKeys(patientName);
	}

	public void surgeryFromDate_Filter(WebDriver driver, String date) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		surgeryFromDate_Calender.sendKeys(date);

	}

	public void surgeryToDate_Filter(WebDriver driver) {

	}

	public void departmentName_Filter(WebDriver driver, String department) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		departmentNameDropdown_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);

	}

	public void _Filter(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		search_Filter.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnSurgeryConfirmationListTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		surgeryConfirmationListTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnClearButton(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clearBtn_Filter.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String takeLastRow_HospitalNumberSurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = lastRowHospitalNumber_SurgeryPendingList.getText();
		return hospitalNumber;
	}

	public String takeLastRow_ScheduleNumber_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String scheduleNumber = lastRowscheduleNumber_surgeryPendingList.getText();
		return scheduleNumber;
	}

	public String takeLastRow_PatientName_surgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = lastRowpatientName_surgeryPendingList.getText();
		String patientName = removeSpecialCharactersAndNumbers_RemoveLastCharacters(pName, 9);
		return patientName;
	}

	public String takeLastRow_DepartmentName_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String departmentName = lastRowdepartmentName_surgeryPendingList.getText();
		return departmentName;
	}

	public String takeLastRow_WardType_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = lastRowWardType_SurgeryPendingList.getText();
		return wardType;
	}

	public String takeLastRow_RoomTyoe_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = lastRowRoomType_SurgeryPendingList.getText();
		return roomType;
	}

	public String takeLastRow_Date_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = lastRowdate_SurgeryPendingList.getText();
		return date;
	}

	public String takeLastRow_Status_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = lastRowStatus_SurgeryPendingList.getText();
		return status;
	}

	public String takeLastRow_HospitalNumber_surgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		String hospitalNumber = lastRow_HospitalNumber_SurgeryConfirmationList.getText();
		return hospitalNumber;
	}

	public String takeLastRow_ScheduleNumber_SurgeryConfirmation_List(WebDriver driver) {
		String scheduleNumber = lastRow_ScheduleNumber_SurgeryConfirmationList.getText();
		return scheduleNumber;
	}

	public String takeLastRow_PatientName_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = lastRow_PatientName_SurgeryConfirmationList.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pName, 9);
		return patientName;
	}

	public String takeLastRow_WardType_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = lastRow_WardType_SurgeryConfirmationList.getText();
		return wardType;
	}

	public String takeLastRow_RoomType_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = lastRow_RoomType_SurgeryConfirmationList.getText();
		return roomType;
	}

	public String takeLastRow_Date_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = lastRow_Date_SurgeryConfirmationList.getText();
		return date;
	}

	public String takeLastRow_Status_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = lastRow_Status_SurgeryConfirmationList.getText();
		return status;
	}

	public String takeFirstRow_HospitalNumber_SurgeryConfirmation_List(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, firstRow_HospitalNumber_SurgeryConfirmationList);
		String hospitalNumber = firstRow_HospitalNumber_SurgeryConfirmationList.getText();
		return hospitalNumber;
	}

	public String takeFirstRow_ScheduleNumber_SurgeryConfirmation_List(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		explictWaitForElementToBeVisible(driver, firstRow_ScheduleNumber_SurgeryConfirmationList);
		String scheduleNumber = firstRow_ScheduleNumber_SurgeryConfirmationList.getText();
		return scheduleNumber;
	}

	public String takeFirstRow_PatientName_SurgeryConfirmation_List(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String pName = firstRow_PatientName_SurgeryConfirmationList.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pName, 9);
		return patientName;
	}

	public String takeFirstRow_WardType_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = firstRow_WardType_SurgeryConfirmationList.getText();
		return wardType;
	}

	public String takeFirstRow_RoomType_surgeryConfirmation_List(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = firstRow_RoomType_SurgeryConfirmationList.getText();
		return roomType;
	}

	public String takeFirstRow_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = firstRow_Date_SurgeryConfirmationList.getText();
		return date;
	}

	public String takeFirstRow_Status_SurgeryConfirmation_List(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = firstRow_Status_SurgeryConfirmationList.getText();
		return status;
	}

	public void clickOnSeacrhButton_Filter(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		search_Filter.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnSurgery_Confiramton_List_Tab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		surgeryConfirmationListTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String takeFirstRow_HospitalNumber_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = firstRow_HospitalNumber_SurgeryPendingList.getText();
		return hospitalNumber;
	}

	public String takeFirstRow_ScheduleNumber_SurgeryPendingList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String scheduleNumber = firstRow_ScheduleNumber_SurgeryPendingList.getText();
		return scheduleNumber;
	}

	public String takeFirstRow_PatientName_SurgeryPendingList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String pName = firstRow_PatientName_SurgeryPendingList.getText();
		String patientName = removeSpecialCharactersAndNumbers_RemoveLastCharacters(pName, 9);
		return patientName;
	}

	public String takeFirstRow_DepartmentName_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = firstRow_DepartmentName_SurgeryPendingList.getText();
		return department;
	}

	public String takeFirstRow_RoomType_SurgeryPendingList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = firstRow_RoomType_SurgeryPendingList.getText();
		return roomType;
	}

	public String takeFirstRow_Date_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = firstRow_Date_SurgeryPendingList.getText();
		return date;
	}

	public String takeFirstRow_Status_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = firstRow_Status_SurgeryPendingList.getText();
		return status;
	}

	public void selectDepartmentName(WebDriver driver, String departmentName) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		departmentNameDropdown_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, departmentName);
	}

	public String takeFirstRow_WardType_SurgeryPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ward = firstRow_WardType_SurgeryPendingList.getText();
		return ward;
	}

	public void clickOn_OkButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okButton.click();
	}
}
