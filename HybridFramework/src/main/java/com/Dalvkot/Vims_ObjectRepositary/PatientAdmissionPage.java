package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class PatientAdmissionPage extends WebDriverUtility {
	public PatientAdmissionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Patient Admission ']")
	private WebElement patientAdmissionBtn;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitaNumberText;

	@FindBy(xpath = "button[aria-haspopup='dialog']")
	private WebElement effectiveDateBtn;

	@FindBy(xpath = "//input[@readonly='true']")
	private WebElement effectiveDatePick;

	@FindBy(xpath = "//input[@placeholder='Effective Time']")
	private WebElement effectiveTimeText;

	@FindBy(xpath = "//span[@title='Select Department']/following-sibling::span")
	private WebElement departmentDropdownBtn;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsText;

	@FindBy(xpath = "//label[text()='Admitted under Dr']/..//span[@role='presentation']")
	private WebElement admittedUnderDrDropdownBtn;

	@FindBy(xpath = "//span[@title='Admitted By Dr']/following-sibling::span")
	private WebElement admittedByDrDropdownBtn;

	@FindBy(xpath = "//span[@title='Ward Type']/following-sibling::span")
	private WebElement wardTypeDropdownBtn;

	@FindBy(xpath = "//span[@title='Room Type']/following-sibling::span")
	private WebElement roomTypeDropdownBtn;

	@FindBy(xpath = "//span[@title='Bed Number']/following-sibling::span")
	private WebElement bedNumberDropdownBtn;

	@FindBy(xpath = "(//button[text()=' Save '])[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement successfullPopupMsgOkBtn;

	@FindBy(css = "input[formcontrolname='advanceAmount']")
	private WebElement amountAdvanceText;

	@FindBy(xpath = "//input[@placeholder='Advance Amount']")
	private WebElement advanceAmountText;

	@FindBy(xpath = "//input[@placeholder='Height (in cms)']")
	private WebElement editHeightText;

	@FindBy(xpath = "//input[@placeholder='Weight (in kgs)']")
	private WebElement editWeightText;

	@FindBy(xpath = "")
	private WebElement editupdateBtn;

	@FindBy(xpath = "")
	private WebElement mlcDRopdownBtn_Vims;

	@FindBy(css = "input[formcontrolname='policeStation']")
	private WebElement policeStationTextMlc_Vims;

	@FindBy(xpath = "")
	private WebElement broughtByDropdownMlc_Vims;

	@FindBy(css = "input[formcontrolname=\"broughtDate\"]")
	private WebElement broughtDate_Vims;

	@FindBy(xpath = "")
	private WebElement nextOfKinDropdownBtn_Vims;

	@FindBy(xpath = "")
	private WebElement nameTextNextOfKin_Vims;

	@FindBy(xpath = "")
	private WebElement mobileNumberNextOfKin_Vims;

	@FindBy(xpath = "")
	private WebElement emailAddressTextNextOfKin_Vims;

	@FindBy(xpath = "")
	private WebElement actionBtnNextOfKin_Vims;

	@FindBy(xpath = "//input[@id='emergency']")
	private WebElement financialAuthorizationCheckBox;

	@FindBy(css = "input[type='file']")
	private WebElement chooseFile_Vims;

	@FindBy(xpath = "")
	private WebElement paymentModedropdown_Vims;

	@FindBy(xpath = "")
	private WebElement multiplePaymentYesyOrNoBtn_Vims;

	@FindBy(xpath = "")
	private WebElement cardTypeDropdownBtnDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement cardNumberebitCard_vims;

	@FindBy(xpath = "")
	private WebElement serviceChargeDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement terminalIdDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement batchNumberTextDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement cardExpiryTextDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement referanceNumberTextDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement cardHolderMobileNumberTextDebitCard_Vims;

	@FindBy(xpath = "")
	private WebElement cardHolderNameTextDebtCard;

	@FindBy(xpath = "")
	private WebElement paymentMode_1_dropdown_Vims;

	@FindBy(xpath = "")
	private WebElement collectedAmountTextCash_PaymentMode1_Vims;

	@FindBy(xpath = "")
	private WebElement balanceAmountToPayTextCash_PaymentMode1_Vims;

	@FindBy(xpath = "")
	private WebElement paymentMode_2_Dropdown_Vims;

	@FindBy(xpath = "")
	private WebElement cardTypeDropdownBtn_PaymentMode2_Vims;

	@FindBy(xpath = "")
	private WebElement cardNumberCreditCard_PaymentMode2_Vims;

	@FindBy(xpath = "")
	private WebElement serviceChargeCreditCard_PaymentMode2_Vims;

	@FindBy(xpath = "")
	private WebElement terminalIdCreditCard_PaymentMode2_Vims;

	@FindBy(xpath = "")
	private WebElement batchNumberCreditCard_PaymentMode2_Vims;

	@FindBy(xpath = "")
	private WebElement cardExpiryCreditCrad_PaymentMide2_Vims;

	@FindBy(xpath = "")
	private WebElement referenceNumberCreditCard_PaymentMide2_Vims;

	@FindBy(xpath = "")
	private WebElement cardHolderMibileNumberCreditCard_PaymentMide2_Vims;

	@FindBy(xpath = "")
	private WebElement cardHolderNumberCreditCard_PaymentMide2_Vims;

	@FindBy(xpath = "")
	private WebElement packageApplicable_Vims;

	@FindBy(xpath = "//span[text()='+']")
	private WebElement packageDetailsPlusBtn_Vims;

	@FindBy(xpath = "")
	private WebElement informationForDietMinusBtn_Vims;

	@FindBy(xpath = "")
	private WebElement foodHabitDropdownBtn_Vims;

	@FindBy(css = "input[formcontrolname='height']")
	private WebElement heightText_Vims;

	@FindBy(css = "input[formcontrolname='weight']")
	private WebElement weightText_Vims;

	@FindBy(xpath = "//label[text()='Patient Type']/..//span[@role='presentation']")
	private WebElement patientTypeDropdownBtn;

	@FindBy(xpath = "//label[text()='Patient Category']/..//span[@role='presentation']")
	private WebElement patientCategoryDropdownBtn_Vims;

	@FindBy(xpath = "//label[text()='Customer']/..//span[@role='presentation']")
	private WebElement customerDropdownBtn_Vims;

	@FindBy(xpath = "")
	private WebElement packageNameDropdownBtn_Vims;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorMsg;

	@FindBy(xpath = "//input[@formcontrolname='admissionCharges']")
	private WebElement admissionCharge;

	@FindBy(xpath = "//label[text()=' Clinic Name ']/..//span[@role='presentation']")
	private WebElement clinicNameDroopdownBtn;

	/*
	 * 
	 * Buisness Logics
	 * 
	 */
	public void clickOnThePatientAdmissinButton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, patientAdmissionBtn);
	}

	public void hospitalNumberText(String hospitalNumber) {
		hospitaNumberText.sendKeys(hospitalNumber, Keys.TAB);
	}

	public void effectiveTimeText(String time) throws Throwable {
		effectiveTimeText.sendKeys(Keys.SPACE);
		Thread.sleep(400);
		effectiveTimeText.sendKeys(Keys.DOWN, Keys.ENTER);
	}

	public void departmentDropdown(WebDriver driver, String department1) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, departmentDropdownBtn);
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, department1);
	}

	public void admittedUnderDrDropdown(WebDriver driver, String admittedUnderDr) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, admittedUnderDrDropdownBtn);
		admittedUnderDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedUnderDr);
	}

	public void admittedByDrDropDown(WebDriver driver, String admittedByDr) {
		scrollDownThePageUntilElementIsVisible(driver, admittedByDrDropdownBtn);
		admittedByDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedByDr);
	}

	public void wardTypeDropdown(WebDriver driver, String wardType) {
		scrollDownThePageUntilElementIsVisible(driver, wardTypeDropdownBtn);
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardType);
	}

	public void roomTypeDropdown(WebDriver driver, String roomType) {
		roomTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomType);
	}

	public void bedNumberDropdown(WebDriver driver, String bedNumberh) throws Throwable {
		Thread.sleep(2000);
		bedNumberDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedNumberh);
	}

	public void saveButton(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollTillVisibleElement(driver, submitBtn);
		submitBtn.click();
	}

	public void effectiveDateVims(WebDriver driver) {
		effectiveDateBtn.click();
		Actions ac = new Actions(driver);
		ac.moveToElement(effectiveDatePick).click(effectiveDatePick).perform();
	}

	public void successfullPopupMsg(WebDriver driver) {
		successfullPopupMsgOkBtn.click();
	}

	public void editIPPatientProcess(WebDriver driver, String height, String weight) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		editHeightText.sendKeys(height);

		editWeightText.sendKeys(weight);

		editupdateBtn.click();

		successfullPopupMsgOkBtn.click();

	}

	public void patientAdmission(WebDriver driver, String hospitalNumber, String PatientAdmissionTime,
			String department1, String admittedUnderDr, String admittedByDr, String wardType, String roomType,
			String bedNumberh) throws Throwable {

		hospitaNumberText.sendKeys(hospitalNumber);
		effectiveTimeText.sendKeys(PatientAdmissionTime);

		scrollDownByUsingJavascriptExecuter(driver);

		WebDriverWait wait = new WebDriverWait(driver, 350);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(departmentDropdownBtn)));
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, department1);

		WebDriverWait wait1 = new WebDriverWait(driver, 150);
		wait1.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(admittedUnderDrDropdownBtn)));
		admittedUnderDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedUnderDr);

		WebDriverWait wait2 = new WebDriverWait(driver, 150);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(admittedByDrDropdownBtn)));
		admittedByDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedByDr);

		JavascriptExecutor js43 = (JavascriptExecutor) driver;
		js43.executeScript("window.scrollBy(0,450)", "");
		WebDriverWait wait3 = new WebDriverWait(driver, 150);
		wait3.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(wardTypeDropdownBtn)));
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardType);

		Thread.sleep(1000);

		WebDriverWait wait4 = new WebDriverWait(driver, 150);
		wait4.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(roomTypeDropdownBtn)));
		roomTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomType);

		Thread.sleep(1000);

		WebDriverWait wait5 = new WebDriverWait(driver, 100);
		wait5.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(bedNumberDropdownBtn)));
		bedNumberDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, bedNumberh);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		amountAdvanceText.sendKeys("150000");
		WebDriverWait wait6 = new WebDriverWait(driver, 150);
		wait6.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submitBtn)));
		submitBtn.click();

		WebDriverWait wait7 = new WebDriverWait(driver, 150);
		wait7.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(successfullPopupMsgOkBtn)));
		successfullPopupMsgOkBtn.click();

	}

	public void patientAdmissionForVims(WebDriver driver, String hospitalNumber, String PatientAdmissionTime,
			String depName, String admittedUnderDr, String admittedByDr, String wardType, String roomType,
			String bednumberh) throws Throwable {

		hospitaNumberText.sendKeys(hospitalNumber, Keys.TAB);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		// effectiveTimeText.sendKeys(PatientAdmissionTime);
		effectiveTimeText.sendKeys(current_Time_Hours_Min() + generateAM_Or_PM());

		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, clinicNameDroopdownBtn);
		clinicNameDroopdownBtn.click();
		scrollTillVisibleElement(driver, dropdownsText);
		moveToElementAndEnterTheData(driver, dropdownsText, "VYDEHI CLINIC");

		Thread.sleep(1000);

		scrollDownThePageUntilElementIsVisible(driver, departmentDropdownBtn);
		departmentDropdownBtn.click();
		scrollTillVisibleElement(driver, dropdownsText);
		moveToElementAndEnterTheData(driver, dropdownsText, depName);

		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, admittedUnderDrDropdownBtn);
		admittedUnderDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedUnderDr);

		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, admittedByDrDropdownBtn);
		admittedByDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedByDr);

		JavascriptExecutor js43 = (JavascriptExecutor) driver;
		js43.executeScript("window.scrollBy(0,450)", "");

		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, wardTypeDropdownBtn);
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardType);

		Thread.sleep(2000);
		scrollTillVisibleElement(driver, roomTypeDropdownBtn);
		explictWaitForElementToBeVisible(driver, roomTypeDropdownBtn);
		roomTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomType);

		Thread.sleep(1000);

		bedNumberDropdownBtn.click();
		Thread.sleep(1000);
		dropdownsText.sendKeys(bednumberh);
		Thread.sleep(500);
		dropdownsText.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, advanceAmountText);
		advanceAmountText.sendKeys("300000");

		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollTillVisibleElement(driver, submitBtn);
		submitBtn.click();
		Thread.sleep(3000);
		getWindowHandles(driver);
		successfullPopupMsgOkBtn.click();
	}

	public void patientAdmissionWithAdvanceAmount(WebDriver driver, String hospitalNumber, String PatientAdmissionTime,
			String depName, String admittedUnderDr, String admittedByDr, String wardType, String roomType,
			String bednumberh, String advanceAmount) throws Throwable {

		hospitaNumberText.sendKeys(hospitalNumber, Keys.TAB);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		effectiveTimeText.sendKeys(PatientAdmissionTime);

		Thread.sleep(1000);

		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, depName);

		admittedUnderDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedUnderDr);

		admittedByDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedByDr);

		JavascriptExecutor js43 = (JavascriptExecutor) driver;
		js43.executeScript("window.scrollBy(0,450)", "");

		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardType);

		Thread.sleep(1000);

		roomTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomType);

		Thread.sleep(1000);

		bedNumberDropdownBtn.click();
		explictWaitForElementToBeVisible(driver, dropdownsText);
		moveToElementAndEnterTheData(driver, dropdownsText, bednumberh);

		scrollDownTheStillEndOfThePage(driver);

		advanceAmountText.sendKeys(advanceAmount);

		scrollTillVisibleElement(driver, submitBtn);
		submitBtn.click();

		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);

		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);

		successfullPopupMsgOkBtn.click();
	}

	public String popupErrorMessage(WebDriver driver) throws Throwable {
		explictWaitForElementToBeVisible(driver, errorMsg);
		String msg = errorMsg.getText();
		errorMsg.click();
		return msg;
	}

	public void selectPatientType(WebDriver driver, String patientType) throws Throwable {
		Thread.sleep(1000);

		patientTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, patientType);
	}

	public void selectPatientCategory(WebDriver driver, String patientCategory) throws Throwable {
		Thread.sleep(1000);

		patientCategoryDropdownBtn_Vims.click();
		moveToElementAndEnterTheData(driver, dropdownsText, patientCategory);
	}

	public void selectCustomery(WebDriver driver, String customer) throws Throwable {
		Thread.sleep(1000);

		customerDropdownBtn_Vims.click();
		moveToElementAndEnterTheData(driver, dropdownsText, customer);
	}

	public String captureAdmissionCharge(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, admissionCharge);
		Thread.sleep(1500);
		String ac = admissionCharge.getAttribute("value");
		String ac1 = ac.replace(".000", "");
		return ac1;
	}

	public void patientAdmissionForScheme(WebDriver driver, String hospitalNumber, String PatientAdmissionTime,
			String depName, String admittedUnderDr, String admittedByDr, String wardType, String roomType,
			String bednumberh) throws Throwable {

		hospitaNumberText.sendKeys(hospitalNumber, Keys.TAB);

		selectPatientType(driver, "government scheme");
		selectPatientCategory(driver, "scheme");
		selectCustomery(driver, "ap government employee");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		// effectiveTimeText.sendKeys(PatientAdmissionTime);
		effectiveTimeText.sendKeys(Keys.SPACE);
		Thread.sleep(400);
		effectiveTimeText.sendKeys(Keys.DOWN, Keys.ENTER);

		Thread.sleep(1000);

		clinicNameDroopdownBtn.click();
		scrollTillVisibleElement(driver, dropdownsText);
		moveToElementAndEnterTheData(driver, dropdownsText, "VYDEHI CLINIC");

		Thread.sleep(1000);

		scrollDownThePageUntilElementIsVisible(driver, departmentDropdownBtn);
		departmentDropdownBtn.click();
		scrollTillVisibleElement(driver, dropdownsText);
		moveToElementAndEnterTheData(driver, dropdownsText, depName);

		Thread.sleep(2000);

		scrollDownThePageUntilElementIsVisible(driver, admittedUnderDrDropdownBtn);
		admittedUnderDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedUnderDr);

		Thread.sleep(2000);

		admittedByDrDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, admittedByDr);

		JavascriptExecutor js43 = (JavascriptExecutor) driver;
		js43.executeScript("window.scrollBy(0,450)", "");

		Thread.sleep(1000);

		scrollDownThePageUntilElementIsVisible(driver, wardTypeDropdownBtn);
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, wardType);

		Thread.sleep(1000);

		roomTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, roomType);

		Thread.sleep(1000);

		bedNumberDropdownBtn.click();
		Thread.sleep(1000);
		dropdownsText.sendKeys(bednumberh);
		Thread.sleep(500);
		dropdownsText.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, advanceAmountText);
//		advanceAmountText.sendKeys("400000");

		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);

		scrollTillVisibleElement(driver, submitBtn);

		submitBtn.click();

		Thread.sleep(3000);
		getWindowHandles(driver);
		successfullPopupMsgOkBtn.click();
	}

}