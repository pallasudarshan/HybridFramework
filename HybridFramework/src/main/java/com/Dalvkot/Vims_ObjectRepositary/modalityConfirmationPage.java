package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class modalityConfirmationPage extends WebDriverUtility {

	public modalityConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Modalilty Confirmation ']")
	private WebElement modalityConfirmationBtn;

	@FindAll({ @FindBy(xpath = "//label[text()='Bill Type']/..//span[@role='presentation']") })
	private WebElement billTypeDropdown_Filter;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindAll({ @FindBy(xpath = "//input[@placeholder='Hospital No']") })
	private WebElement hospitalNumber_Filter;

	@FindAll({ @FindBy(xpath = "//span[@title='Service Class']/following-sibling::span[1]") })
	private WebElement serviceClassDropdown_Filter;

	@FindAll({ @FindBy(xpath = "(//input[@placeholder='Date'])[1]"), @FindBy(xpath = "(//input[@type='date'])[1]") })
	private WebElement fromDate_Filter;

	@FindAll({ @FindBy(xpath = "(//input[@type='date'])[2]"), @FindBy(xpath = "(//input[@placeholder='Date'])[2]") })
	private WebElement toDate_Filter;

	@FindAll({ @FindBy(xpath = "//button[text()=' Search']"), @FindBy(xpath = "//i[@class='zmdi zmdi-search']") })
	private WebElement searchBtn;

	@FindAll({ @FindBy(xpath = "(//button[text()=' Cancel'])[1]"), @FindBy(xpath = "//i[@class='zmdi zmdi-close']") })
	private WebElement cancelBtn;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[2]/descendant::a") })
	private WebElement registrationNumber_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[3]") })
	private WebElement registrationDate_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[4]") })
	private WebElement billNumber_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[5]") })
	private WebElement billDate_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[6]") })
	private WebElement hospitalNumber_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[7]") })
	private WebElement patientName_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[8]") })
	private WebElement age_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[9]") })
	private WebElement gender_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[10]") })
	private WebElement specilityName_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[last()]/descendant::a") })
	private WebElement status_Pending;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Completed')]") })
	private WebElement completed_Tab;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[2]/descendant::a") })
	private WebElement registrationNumber_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[3]") })
	private WebElement billNumber_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[4]") })
	private WebElement billDate_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[5]") })
	private WebElement hospitalNumber_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[6]") })
	private WebElement patientName_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[7]") })
	private WebElement age_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[8]") })
	private WebElement gender_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[9]") })
	private WebElement specilityName_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[10]") })
	private WebElement unit_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[11]") })
	private WebElement roomType_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[12]") })
	private WebElement bedNumber_Completed;

	@FindAll({ @FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[last()]/descendant::a") })
	private WebElement status_Completed;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement hospitalNumber_LastRow_Pending;

	@FindAll({ @FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[last()]/td[2]/descendant::a") })
	private WebElement registrationNumber_LastRow_Pending;

	@FindBy(xpath = "(//span[@role='textbox'])[3]")
	private WebElement serviceClass_Popup;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement xBtn;

	@FindBy(xpath = "//button[text()=' Search']/following-sibling::button")
	private WebElement cancelBtn_Search;

	@FindBy(xpath = "//a[contains(@class,'nav-link tab-pane')]")
	private WebElement pendingTab;

	@FindBy(xpath = "(//button[text()=' Submit '])[1]")
	private WebElement submitBtn_popup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//div[@style='display: block;']")
	private WebElement okPopup_Message;

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 */

	public void clickOnModalityConfirmation(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, modalityConfirmationBtn);
	}

	public void selectBillType_Filter(WebDriver driver, String billType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		billTypeDropdown_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownText, billType);
	}

	public void enterHospitalNumber_Filter(WebDriver driver, String hospitalNumber) {
		hospitalNumber_Filter.sendKeys(hospitalNumber);

	}

	public void selectServiceClass(WebDriver driver, String service) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollToTop(driver);
		dropdown(driver, serviceClassDropdown_Filter, dropdownText, service);
	}

	public void fromDate_calender(WebDriver driver, String date) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		fromDate_Filter.sendKeys(date);
	}

	public void toDate_Calender(WebDriver driver, String date) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		toDate_Filter.sendKeys(date);
	}

	public void clickOnSearch_Button_Filter(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		searchBtn.click();
	}

	public void clickOnClearButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		cancelBtn_Search.click();
	}

	public void clickOnRegistrationNumber_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, registrationNumber_LastRow_Pending);
		registrationNumber_LastRow_Pending.click();
	}

	public void clickOnRegistrationNumber(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, registrationNumber_Pending);
		registrationNumber_Pending.click();
	}

	public String takeRegistrationDate_Pending(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = registrationDate_Pending.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return date;
	}

	public String take_BillNumber_Pending(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNumber = billNumber_Pending.getText();
		return billNumber;
	}

	public String take_BillDate_Pending(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billDate = billDate_Pending.getText();
		return billDate;
	}

	public String take_HospitalNumber_Pending(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hos = hospitalNumber_Pending.getText();
		return hos;
	}

	public String take_HospitalNumber_LastRow_Pending(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hos = hospitalNumber_LastRow_Pending.getText();
		return hos;
	}

	public String captureServiceClass_Popup(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String serviceClass = serviceClass_Popup.getText();
		System.out.println(serviceClass);
		return serviceClass;
	}

	public void clickOnXbtn_popup(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		xBtn.click();
	}

	public void clickOnPendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		pendingTab.click();
	}

	public String captureHospitalNumber_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_Pending.getText();
		System.out.println(hospitalNumber_Pending);
		return hospitalNumber;
	}

	public void clickOnSubmit(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, submitBtn_popup);
		submitBtn_popup.click();

	}

	public void clickOnOkBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtn.click();
	}

	public void clickOnCompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		completed_Tab.click();
	}

	public String captureHospitalNumber_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_Completed.getText();
		return hospitalNumber;
	}

	public String capture_OkpopupMessage(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String msg = okPopup_Message.getText();
		return msg;
	}

	public void clickOn_CompleteTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		completed_Tab.click();
	}

}
