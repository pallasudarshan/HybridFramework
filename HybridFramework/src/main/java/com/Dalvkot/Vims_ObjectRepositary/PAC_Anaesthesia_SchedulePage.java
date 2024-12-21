package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class PAC_Anaesthesia_SchedulePage extends WebDriverUtility {

	public PAC_Anaesthesia_SchedulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' PAC(Anaesthesia) Schedule ']")
	private WebElement pacAneasthesiaScheduleBtn;

	@FindBy(xpath = "//button[text()=' Schedule Appointment']")
	private WebElement scheduleAppointmentBtn;

	@FindBy(xpath = "(//button[@id='closeModal'])[2]")
	private WebElement submitBtn_Popup;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumber_Schedule;

	@FindBy(xpath = "(//span[@title='Department']/following-sibling::span)[2]")
	private WebElement departmentName_Schedule;

	@FindBy(xpath = "//input[@formcontrolname='scheduleTime']")
	private WebElement scheduleTime_Schedule;

	@FindBy(xpath = "//span[@title='MAJOR']/following-sibling::span")
	private WebElement surgeryTypeDdBtn_Schedule;

	@FindBy(xpath = "(//input[@formcontrolname='surgeryName'])[1]")
	private WebElement surgeryName_Schedule;

	@FindBy(xpath = "//input[@placeholder='Reason']")
	private WebElement reason_Popup;

	@FindBy(xpath = "(//button[@id='closeModal'])[2]")
	private WebElement submitBtn_schedule;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement successfullPopUpMsgOKBtn;

	@FindBy(xpath = "//button[@type='button']/following-sibling::button")
	private WebElement clearBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement cancel_Schedule;

	@FindBy(xpath = "//div[contains(@class,'card row')]/descendant::input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span[1]")
	private WebElement departementDropdownBtn;

	@FindBy(css = "input[autocapitalize='none']")
	private WebElement dropdownText;

	@FindBy(xpath = "(//span[@title='Surgery Type']/following-sibling::span)[1]")
	private WebElement surgeryTypeDropdownBtn_Filter;

	@FindBy(xpath = "//span[@title='Status']/following-sibling::span[1]")
	private WebElement statusDropdownBtn;

	By test = By.xpath("//span[@title='Status']/following-sibling::span");

	@FindBy(xpath = "//label[text()='Surgery Date ']/following-sibling::input")
	private WebElement surgeryDate;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr[1]/td[7]")
	private WebElement department_Table;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr[1]/td[9]")
	private WebElement surgeryType_Table;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr[1]/td[12]")
	private WebElement status_Table;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr[1]/td[5]")
	private WebElement surgeryDate_Table;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody[1]/tr[1]/td[13]/div[1]/button")
	private WebElement actionBtn_Table;

	@FindBy(xpath = "//a[contains(text(),'Review List')]")
	private WebElement reviewListTab;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[2]")
	private WebElement hopsitalN_ReviewTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[7]")
	private WebElement dep_ReviewTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[9]")
	private WebElement surgeryType_ReviewTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[11]")
	private WebElement status_ReviewTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-calendar']")
	private WebElement action_ReviewTable;

	@FindAll({ @FindBy(xpath = "//button[@type='button']/descendant::i[@class='zmdi zmdi-search']") })
	private WebElement searchBtn;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement popupErrorMessage_mandatoryFields;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okMeaasge;

	@FindBy(xpath = "//input[@formcontrolname='reScheduleTime']")
	private WebElement scheduleTime_Reschedule;

	@FindBy(css = "input.form-control.surgeryName")
	private WebElement surgeryName_Reschedule;

	@FindBy(xpath = "//label[text()='Reason ']/following::input")
	private WebElement reason_Reschedule;

	@FindBy(xpath = "(//button[text()=' Submit'])[2]")
	private WebElement submit_Reschedule;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement time_ReqTable;

	@FindBy(xpath = "//div[@id='OTLISt']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement surgeryName_ReqTable;

	@FindBy(xpath = "//li[text()='MINOR']")
	private WebElement minorSuggestion;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr[1]/td") })
	private List<WebElement> firstRowData_InTheTable;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr/td") })
	private List<WebElement> allRowsData_InTheTable;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[2]") })
	private WebElement lastRowHospitalNumber_ReviewList;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[2]") })
	private WebElement firstRowHospitalNumber_ReviewList;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[9]") })
	private WebElement lastRowSurgeryType_ReviewList;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[9]") })
	private WebElement firstRowSurgeryType_ReviewList;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[last()]/td[5]") })
	private WebElement lastRowSurgeryDate_ReviewList;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[5]") })
	private WebElement firstRowSurgeryDate_ReviewList;

	@FindAll({ @FindBy(xpath = "//div[@id='OTLISt']//table//tr[1]/td[3]") })
	private WebElement op_IpNumber_RequestersTable;

	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[3]") })
	private WebElement op_IpNumber_fitnessReview_Table;
//	
	@FindAll({ @FindBy(xpath = "//div[@id='PACLISt']/descendant::table/tbody/tr[1]/td[7]") })
	private WebElement department_fitnessReview_Table;;
//	
//	@FindAll({ @FindBy(xpath = "") })
//	private WebElement   _RequestersTable;
//	
//	@FindAll({ @FindBy(xpath = "") })
//	private WebElement   _RequestersTable;
//	
//	@FindAll({ @FindBy(xpath = "") })
//	private WebElement   _RequestersTable;
//	
//	@FindAll({ @FindBy(xpath = "") })
//	private WebElement   _RequestersTable;
//	

	/*
	 * 
	 * Buiness Logics
	 * 
	 */

	public void clickOnPacScheduling(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, pacAneasthesiaScheduleBtn);
		Thread.sleep(1500);
	}

	public void clickOnAppointmentSchedule(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, scheduleAppointmentBtn);
	}

	public void hospitalNumber_ShedulePopup(String hospitalNumber) {
		hospitalNumber_Schedule.sendKeys(hospitalNumber, Keys.TAB);
	}

	public void scheduleTimeSchedulePopup(String scheduleTime) {
		scheduleTime_Schedule.sendKeys(scheduleTime);
	}

	public void enterSurgeryNameSchedule(String surgeryName) {
		surgeryName_Schedule.sendKeys(surgeryName);
	}

	public void submit_Schedule(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtn_schedule);
	}

	public void okSuccessMessage(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okMeaasge.click();
		driver.navigate().refresh();
	}

	public void hospitalNumberText(String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void selectSurgeryType_As_Minor_Filter(WebDriver driver) throws Throwable {
		dropdown_Handling(driver, 3, surgeryTypeDropdownBtn_Filter, dropdownText, "MINOR");

	}

	public void selectSurgeryType_As_Major_Filter(WebDriver driver) throws Throwable {
		surgeryTypeDropdownBtn_Filter.click();
		moveToTheParticularElementAndClick(driver, minorSuggestion);

	}

	public void selectSurgeryType_Filter(WebDriver driver, String surgeryType) throws Throwable {
		surgeryTypeDropdownBtn_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, surgeryType);

	}

	public void selectMinorSurgeryType_ScheduleAppointment(WebDriver driver) throws Throwable {
		waitForElementWithCustomTimeOut(driver, surgeryTypeDdBtn_Schedule, 8);
		surgeryTypeDdBtn_Schedule.click();
		moveToTheParticularElementAndClick(driver, minorSuggestion);

	}

	public void selectStatusDropdown(WebDriver driver, String status) throws Throwable {
		dropdown_Handling(driver, 3, statusDropdownBtn, dropdownText, status);
	}

	public String takeHospitalNumberTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String takeSurgeryTypeTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String surgeryType = surgeryType_Table.getText();
		return surgeryType;
	}

	public void clickOnSearchButton(WebDriver driver) throws Throwable {
		searchBtn.click();
	}

	public void clickOnTheClearBtn(WebDriver driver) throws Throwable {
		clearBtn.click();
	}

	public void actions(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		actionBtn_Table.click();
	}

	public void clickOnActions_Confirm(WebDriver driver) {
		actionBtn_Table.click();
		moveToTheParticularElementAndClick(driver, departementDropdownBtn);
	}

	public void scheduleTime_InTheReschedulePopup(String scheduleTimeInReschedulePopup) {
		scheduleTime_Reschedule.sendKeys(scheduleTimeInReschedulePopup);
	}

	public void enterSurgeryNameInThe_ReschedulePopup(WebDriver driver, String surgeryNameForReschedule) {
		surgeryName_Reschedule.clear();
		surgeryName_Reschedule.sendKeys(surgeryNameForReschedule);
	}

	public String takeReasonText_Reschedule(WebDriver driver) {
		String reason = reason_Reschedule.getAttribute("Value");
		return reason;
	}

	public void submitButtonFor_Reschedule(WebDriver driver) {
		submit_Reschedule.click();
	}

	public String takeTime_ReqTable(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String time = time_ReqTable.getText();
		time = time.replaceAll("[^a-zA-Z0-9]", "");
		return time;
	}

	public String takeSurgeryName(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String surgeryName = surgeryName_ReqTable.getText();
		return surgeryName;
	}

	public String takeStatusTable(WebDriver driver) {
		String status = status_Table.getText();
		return status;
	}

	public void submitButton_Reschedule(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, submit_Reschedule);
	}

	public void clickCancel_Schedule(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, cancel_Schedule);
	}

	public String errorMessage_MandatoryField(WebDriver driver) throws Throwable {
		explictWaitForElementToBeVisible(driver, popupErrorMessage_mandatoryFields);
		String errorMsg = popupErrorMessage_mandatoryFields.getText();
		clickOnTheElementUsedToJavascriptExecuter(driver, popupErrorMessage_mandatoryFields);
		return errorMsg;
	}

	public void scheduleAppointment_For_Ip(WebDriver driver, String hospitalNumber, String scheduleTime,
			String surgeryName) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, scheduleAppointmentBtn);
		hospitalNumber_ShedulePopup(hospitalNumber);
		scheduleTime_Schedule.sendKeys(scheduleTime);
		surgeryName_Schedule.sendKeys(surgeryName);
		submitBtn_schedule.click();
		okSuccessMessage(driver);

	}

	public void firstRow_TableList(WebDriver driver, String tableData) throws Throwable {
		Thread.sleep(2000);
		for (WebElement webElement : firstRowData_InTheTable) {
			String tData = webElement.getText();
			System.out.println(tData);
			if (tData.equalsIgnoreCase(tableData)) {
				Assert.assertEquals(tData, tableData);
			}
		}
	}

	public void allRows_TableList(WebDriver driver, String tableData) throws Throwable {
		Thread.sleep(2000);
		for (WebElement webElement : allRowsData_InTheTable) {
			String tData = webElement.getText();
			if (tData.equals(tableData))
				if (tData.equals(tableData)) {
					Assert.assertEquals(tData, tableData);
				}
		}
	}

	public void pacScheduleFor_ip(WebDriver driver, String hospitalNumber, String scheduleTime, String surgeryName)
			throws Throwable {
		clickOnAppointmentSchedule(driver);
		hospitalNumber_ShedulePopup(hospitalNumber);
		scheduleTimeSchedulePopup(scheduleTime);
		enterSurgeryNameSchedule(surgeryName);
		submit_Schedule(driver);
		okSuccessMessage(driver);
	}

	public void pacScheduleFor_Op(WebDriver driver, String hospitalNumber, String departmentName, String scheduleTime,
			String surgeryName) throws Throwable {
		clickOnAppointmentSchedule(driver);
		hospitalNumber_ShedulePopup(hospitalNumber);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		departementDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, departmentName);

		scheduleTimeSchedulePopup(scheduleTime);
		enterSurgeryNameSchedule(surgeryName);
		submit_Schedule(driver);
		okSuccessMessage(driver);
	}

	public String takeLastRow_HospitalNumber_ReviewList(WebDriver driver) {
		String hospitalNumber = lastRowHospitalNumber_ReviewList.getText();
		return hospitalNumber;

	}

	public String takeFirstRow_HospitalNumber_ReviewList(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String hospitalNumber = firstRowHospitalNumber_ReviewList.getText();
		return hospitalNumber;

	}

	public void clickOn_Review_Button(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		reviewListTab.click();
	}

	public String takeLastRow_SurgeryType_ReviewList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String surgeryType = lastRowSurgeryType_ReviewList.getText();
		return surgeryType;
	}

	public String takeFirstRow_SurgeryType_ReviewList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String surgeryType = firstRowSurgeryType_ReviewList.getText();
		return surgeryType;
	}

	public String capture_OpIpNumber_RequestersTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String opNumber = op_IpNumber_RequestersTable.getText();
		return opNumber;
	}

	public String capture_DepartmentName_RequestersTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dep = department_Table.getText();
		String departmentName = remove_SpecialCharacters_And_Numbers_Speces(dep, 0);
		System.out.println(departmentName);
		return departmentName;
	}

	public String capture_OpIpNumber_FitnessReviewTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String opNumber = op_IpNumber_fitnessReview_Table.getText();
		return opNumber;
	}

	public String capture_DepartmentName_FitnessReviewTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dep = department_fitnessReview_Table.getText();
		String departmentName = removeSpecialCharactersAndNumbers_RemoveLastCharacters(dep, 0);
		System.out.println(departmentName);
		return departmentName;
	}

}
