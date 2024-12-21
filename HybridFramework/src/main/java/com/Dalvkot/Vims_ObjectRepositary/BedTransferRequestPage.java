package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class BedTransferRequestPage extends WebDriverUtility {

	public BedTransferRequestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=' Bed Transfer Request ']")
	private WebElement bedTransferRequestBtn;

	@FindAll({ @FindBy(xpath = "//i[@class='zmdi zmdi-plus-circle']"),
			@FindBy(xpath = "//a[@class='btn btn-white btn-round ng-star-inserted']/descendant::i[@class='zmdi zmdi-plus-circle']") })
	private WebElement newBtn;

	@FindAll({ @FindBy(xpath = "//a[contains(.,'Back')]"), @FindBy(xpath = "//i[@class='zmdi zmdi-arrow-left']") })
	private WebElement backBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	private WebElement RequestedBy_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement requestNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement requestDate_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]")
	private WebElement fromDepartment_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[8]")
	private WebElement fromUnit_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[9]")
	private WebElement fromDoctor_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[10]")
	private WebElement fromWard_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[11]")
	private WebElement fromRoom_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[12]")
	private WebElement fromBed_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[14]")
	private WebElement toUnit_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[15]")
	private WebElement toDoctor_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[16]")
	private WebElement toWard_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[17]")
	private WebElement toRoom_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[18]")
	private WebElement toBed_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[19]")
	private WebElement reason_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[text()='Cancel Request']")
	private WebElement cancelRequest_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]//button")
	private WebElement action_Status;

	@FindBy(xpath = "//textarea[@formcontrolname='cancelReason']")
	private WebElement reasonTextFor_TransferCancel;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//span[@title='To Department']/following-sibling::span")
	private WebElement toDepartmentDropdown;

	@FindBy(xpath = "//span[@title='To Doctor']/following-sibling::span[1]")
	private WebElement toDoctorDropdown;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//span[@title='To Unit']/following-sibling::span[1]")
	private WebElement toUnitDropdown;

	@FindBy(xpath = "//span[@title='To Ward']/following-sibling::span[1]")
	private WebElement toWardDropdown;

	@FindBy(xpath = "//span[@title='To Room Type']/following-sibling::span[1]")
	private WebElement toRoomTypeDropdown;

	@FindBy(xpath = "//input[@formcontrolname='remarks']")
	private WebElement remarksComplaintsText;

	@FindBy(xpath = "//button[text()=' Submit']//i")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorMsg;

	@FindBy(xpath = "//img[@alt='User']/following-sibling::b[1]")
	private WebElement loginUserName;

	/*
	 * Buiness Logics
	 * 
	 */

	public void clickOnBedTransferRequest(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, bedTransferRequestBtn);
	}

	public void clickOnNewButton(WebDriver driver) throws InterruptedException {
		newBtn.click();
	}

	public void clickOnBackButton(WebDriver driver) {
		backBtn.click();
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void selectToDepartment(WebDriver driver, String toDepartment) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, toDepartmentDropdown);
		toDepartmentDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, toDepartment);
	}

	public void selectToDoctor(WebDriver driver, String toDoctor) throws Throwable {
		dropdown_Handling(driver, 5, toDoctorDropdown, dropdownText, toDoctor);

	}

	public void selectToWard(WebDriver driver, String toWard) {
		scrollDownThePageUntilElementIsVisible(driver, toWardDropdown);
		toWardDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, toWard);
	}

	public void selectToRoomType(WebDriver driver, String toRoomType) throws InterruptedException {
	
		toRoomTypeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, toRoomType);
	}

	public void enterRemarksComplaints(WebDriver driver, String remarksComplaints) {
		remarksComplaintsText.sendKeys(remarksComplaints);
	}

	public void clickOnSubmitButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		submitBtn.click();
	}

	public void clickOn_SubmitButtonForCancelReq(WebDriver driver) {
		submitBtn.click();
	}

	public void clickOnCancelButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		cancelBtn.click();
	}

	public String errorMessage(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String msg = errorMsg.getText();
		return msg;
	}

	public void bedTransferRequest(WebDriver driver, String hospitalNumber, String toDepartment, String toDoctor,
			String toWard, String toRoomType, String Complaints) throws Throwable {

		clickOnNewButton(driver);

		hospitalNumberText.sendKeys(hospitalNumber);

		selectToDepartment(driver, toDepartment);

		selectToDoctor(driver, toDoctor);

		selectToWard(driver, toWard);

		selectToRoomType(driver, toRoomType);

		scrollDownTheStillEndOfThePage(driver);
		remarksComplaintsText.sendKeys(Complaints);

		submitBtn.click();

		okBtn.click();

	}

	public String takeReason_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String reason = reason_Table.getText();
		return reason;
	}

	public String takeToBed(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String bed = toBed_Table.getText();
		return bed;
	}

	public String takeToRoom(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String room = toRoom_Table.getText();
		return room;
	};

	public String takeToWard(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String ward = toWard_Table.getText();
		return ward;
	}

	public String takeLoginUserName(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String requestName = loginUserName.getText();
		return requestName;
	}

	public void clickOnOkButton(WebDriver driver) {
		okBtn.click();
	}

	public String takeHospitalNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String takeRequestByName_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String requestBy = RequestedBy_Table.getText();
		return requestBy;
	}

	public String take_Action_Status(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String status = action_Status.getText();
		return status;
	}

	public void clickOn_CancelRequstButton(WebDriver driver) {
		cancelRequest_Table.click();
	}

	public void enter_ReasonForCancelRequest(WebDriver driver, String reason) {
		reasonTextFor_TransferCancel.sendKeys(reason);
	}

	public void cancelRequest_Process(WebDriver driver, String reason) {
		clickOn_CancelRequstButton(driver);

		enter_ReasonForCancelRequest(driver, reason);

		clickOn_SubmitButtonForCancelReq(driver);

		okBtn.click();
	}

	public String take_Request_Number_Table(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String req = requestNumber_Table.getText();
		return req;
	}

}