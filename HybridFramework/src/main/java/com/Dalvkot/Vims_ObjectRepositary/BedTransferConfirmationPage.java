package com.Dalvkot.Vims_ObjectRepositary;

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
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class BedTransferConfirmationPage extends WebDriverUtility {
	public BedTransferConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Bed Transfer Confirmation ']")
	private WebElement bedTransferConfirmation;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span")
	private WebElement wardTypeDropdown;

	@FindBy(xpath = "//span[@title='Select Room Type']/following-sibling::span")
	private WebElement roomTypeDropdown;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsText;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(css = "input[formcontrolname='requestDate']")
	private WebElement requestDate_Calender;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement requestNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement requestDateAndTime_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[4]")
	private WebElement hospitalNumber_LastRow_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement fromWard_Table;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr/td[6]") })
	private List<WebElement> fromWard_List_Table;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr/td[7]") })
	private List<WebElement> fromRoomType_List_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]")
	private WebElement fromRoomType_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[8]")
	private WebElement toWard_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[9]")
	private WebElement toRoomType_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()-1]")
	private WebElement confirmedBy_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[text()='Pending']")
	private WebElement pendingBtn_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/button[@type='button']")
	private WebElement actionStatus;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]//button[text()='Cancelled']")
	private WebElement cancelledStatus;

	@FindBy(xpath = "//span[@data-on='Yes']/following-sibling::span")
	private WebElement doYouWantToConfirmTheTransfer;

	@FindBy(xpath = "//label[text()='complaints']/following::input")
	private WebElement complaintText;

	@FindBy(xpath = "//span[@title='Bed Number']/following-sibling::span")
	private WebElement toBedNumberDropdown;

	@FindBy(xpath = "//input[@formcontrolname='effectiveFromDate']")
	private WebElement effectiveFromDate_Calender;

	@FindBy(xpath = "//input[@formcontrolname='effectiveFromTime']")
	private WebElement effectiveFromTimeText;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//div[text()='Bed Confirmation Done ']")
	private WebElement bedConfirmationDonePopup;

	@FindBy(xpath = "//button[text()=' Submit']//i")
	private WebElement submitButton;

	@FindBy(xpath = "//table//tr[last()]/td[1]")
	private WebElement lastRow_SiNo;

	@FindBy(xpath = "//li//a[@aria-label='Next page']")
	private WebElement nextButton_Table;

	/*
	 * 
	 * Buiness Logics
	 * 
	 */

	public void clickOnBedTransferConfirmation(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, bedTransferConfirmation);
	}

	public void EnterTheHopsitalNumber(String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);

	}

	public void selectWardType(WebDriver driver, String wardType) throws Throwable {
		Thread.sleep(1000);
		wardTypeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardType);
	}

	public void selectRoomType(WebDriver driver, String roomType) throws Throwable {
		Thread.sleep(1000);
		roomTypeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomType);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clear_HospitalNumber_Filter(WebDriver driver) {
		hospitalNumberText.clear();
	}

	public void selectRequestDate(WebDriver driver, String requestDate) {
		requestDate_Calender.sendKeys(requestDate);
	}

	public String RequestDate_Table(WebDriver driver) {
		String rd = requestDateAndTime_Table.getText();
		String requestDate = removedSpecialCharctersAndRemovedSpaces(rd, 9);
		return requestDate;
	}

	public void clickOnSearchButton(WebDriver driver) {
		searchBtn.click();
	}

	public void clickOnClearButton(WebDriver driver) {
		clearBtn.click();
	}

	public void clickOnPendingButton_Table(WebDriver driver) {
		pendingBtn_Table.click();
	}

	public void clickOnDoYouWantConfirmTheTransfer(WebDriver driver) {
		doYouWantToConfirmTheTransfer.click();
	}

	public void selectToBedNumber(WebDriver driver, String toBedNumber) {
		toBedNumberDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownsText, toBedNumber);
	}

	public void enterEffectiveFromDate(WebDriver driver, String effectiveFromDate) {
		effectiveFromDate_Calender.sendKeys(effectiveFromDate);

	}

	public void effectiveFromTime(WebDriver driver, String effectiveFromTime) {
		effectiveFromTimeText.sendKeys(effectiveFromTime);

	}

	public void clickOnOkButton(WebDriver driver) {
		okBtn.click();
	}

	public String takeHospitalNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String take_LastRowHospitalNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_LastRow_Table.getText();
		return hospitalNumber;
	}

	public String takeFromWard_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String fromWard = fromWard_Table.getText();
		return fromWard;
	}

	public void enter_ComplaintText(WebDriver driver, String complaint) {
		complaintText.sendKeys(complaint);
	}

	public void clickOn_SubmitButton(WebDriver driver) throws Throwable {
		submitButton.click();
	}

	public String take_ActionStatus(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String status = actionStatus.getText();
		return status;
	}

	public int take_LastRowSerialNumber(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String Msg = lastRow_SiNo.getText();
		int t = Integer.parseInt(Msg);
		return t;
	}

	public void clickOn_NexButton_Table(WebDriver driver) {
		nextButton_Table.click();
	}

	public void take_ListOf_WardFrom_Table(WebDriver driver, String list) {
		invisibiltyOf_Element_ThreeDots(driver);
		for (WebElement webElement : fromWard_List_Table) {
			String list1 = webElement.getText();
			Assert.assertEquals(list, list1);
		}

	}

	public void take_ListOf_FrommRoomType_Table(WebDriver driver, String list) {
		invisibiltyOf_Element_ThreeDots(driver);
		for (WebElement webElement : fromRoomType_List_Table) {
			String list1 = webElement.getText();
			Assert.assertEquals(list, list1);
		}

	}

	public void clickOn_OkButton(WebDriver driver) {
		okBtn.click();
	}

	public void confirm_Process(WebDriver driver, String toBedNumber, String fromDate, String fromTime)
			throws Throwable {
		clickOnDoYouWantConfirmTheTransfer(driver);
		selectToBedNumber(driver, toBedNumber);

		effectiveFromDate_Calender.sendKeys(Keys.SPACE, Keys.ENTER);

		effectiveFromTimeText.sendKeys(Keys.SPACE);
		Thread.sleep(400);
		effectiveFromTimeText.sendKeys(Keys.ENTER);
		clickOn_SubmitButton(driver);
		clickOn_OkButton(driver);
	}

	public String take_Request_Number_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String reqNumber = requestNumber_Table.getText();
		return reqNumber;
	}

	public String take_CancelStatus_InTheList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String status = cancelledStatus.getText();
		return status;
	}

}