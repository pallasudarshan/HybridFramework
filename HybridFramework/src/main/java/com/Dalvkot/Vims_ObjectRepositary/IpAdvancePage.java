package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.BaseClass;

import freemarker.core.ReturnInstruction.Return;

public class IpAdvancePage extends BaseClass {

	public IpAdvancePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' IP Advance ']")
	private WebElement ipAdvacneBtn;

	@FindBy(xpath = "//input[@placeholder='Patient Name']")
	private WebElement patientNameText;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText_Filter;

	@FindBy(xpath = "//input[contains(@class,'form-control hosNo')]")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//input[@placeholder='Receipt Number']")
	private WebElement receiptNumberText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;
	@FindAll({ @FindBy(xpath = "//a[contains(text(),'New Advance')]"), @FindBy(css = "a.btn.btn-white") })
	private WebElement newAdvanceBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
	private WebElement receiptNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement receiptDate_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[text()=' View ']")
	private WebElement viewBtn_Table;

	@FindBy(xpath = "//input[@formcontrolname='advanceAmount']")
	private WebElement advanceAmountText;

	@FindBy(xpath = "//input[@formcontrolname='paidBy']")
	private WebElement paidByText;

	@FindBy(xpath = "//input[@formcontrolname='remarks']")
	private WebElement remarksText;

	@FindBy(xpath = "//span[@title='CASH']/following-sibling::span")
	private WebElement PaymentModeDropdown;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okPopupMessageBtn;

	@FindBy(xpath = "//input[@formcontrolname='chequeNumber']")
	private WebElement chequeNumberText;

	@FindBy(xpath = "//input[@formcontrolname='chequeDate']")
	private WebElement chequeDate;

	@FindBy(xpath = "(//input[@placeholder='Drawee Bank'])[1]")
	private WebElement draweeBankText;

	@FindBy(xpath = "//input[@formcontrolname='chequeOwnerName']")
	private WebElement chequeOwnerNumberText;

	@FindBy(xpath = "//input[@formcontrolname='residingAt']")
	private WebElement residingAtText;

	@FindBy(xpath = "//span[@title='Relation With Patient']/following-sibling::span[1]")
	private WebElement relationWithPatientDropdown;

	@FindBy(xpath = "//input[@formcontrolname='mobileNumber']")
	private WebElement mobileNumberText;

	@FindBy(xpath = "//input[@formcontrolname='policeStation']")
	private WebElement policeStationText;

	@FindBy(xpath = "(//input[@formcontrolname='branchName'])[1]")
	private WebElement branchNameText;

	@FindBy(xpath = "//span[@title='Card Type']/following-sibling::span")
	private WebElement cardTypeDropdown;

	@FindBy(xpath = "//input[@formcontrolname='cardNumber']")
	private WebElement cardNumberText;

	@FindBy(xpath = "//input[@formcontrolname='serviceCharges']")
	private WebElement serviceChargesText;

	@FindBy(xpath = "//input[@formcontrolname='terminalID']")
	private WebElement terminalIdText;

	@FindBy(xpath = "//input[@formcontrolname='batchNumber']")
	private WebElement batchNumberText;

	@FindBy(xpath = "//input[@formcontrolname='cardMonth']")
	private WebElement cardExpiryMonth;

	@FindBy(xpath = "//input[@formcontrolname='cardYear']")
	private WebElement cardExpiryYear;

	@FindBy(xpath = "//input[@formcontrolname='referenceNumber']")
	private WebElement referrenceNumberText;

	@FindBy(xpath = "//input[@formcontrolname='cardHolderNumber']")
	private WebElement cardHolderNumberText;

	@FindBy(xpath = "//input[@formcontrolname='cardHolderName']")
	private WebElement cardHolderNameText;

	@FindBy(xpath = "//input[@formcontrolname='ddNumber']")
	private WebElement ddNumberText;

	@FindBy(xpath = "//input[@formcontrolname='transferNumber']")
	private WebElement transferNumberText;

	@FindBy(xpath = "//input[@formcontrolname='transferDate']")
	private WebElement transferDate;

	@FindBy(xpath = "//input[@formcontrolname='fromBank']")
	private WebElement transferFromBankText;

	@FindBy(xpath = "//input[@formcontrolname='toBank']")
	private WebElement transferToBankText;

	@FindBy(xpath = "//input[@formcontrolname='ddDate']")
	private WebElement ddDate;

	@FindBy(xpath = "(//input[@formcontrolname='branchName'])[2]")
	private WebElement branchName_DD;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorMessage;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[2]")
	private WebElement lastRowPatientName_Table;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
	private WebElement lastRowHospitalNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[4]")
	private WebElement lastRowIpNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[5]")
	private WebElement lastRowReceiptNumber_Table;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[6]")
	private WebElement lastRowReceiptDate_Table;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']/..//span")
	private WebElement errorMessageHospitalNumber;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr/td[7]") })
	private List<WebElement> advanceAmountListTable;

	@FindBy(xpath = "//div[@id='swal2-content']")
	private WebElement popupMessage;

	@FindBy(xpath = "//label[text()='Payment Mode']/..//span[@role='presentation']")
	private WebElement paymentModeDropdownBtn;

	@FindBy(xpath = "//label[text()='Card Type']/..//span[@role='presentation']")
	private WebElement cardTypeDropdownBtn_CreditCard;

	@FindBy(xpath = "//input[@formcontrolname='cardNumber']")
	private WebElement cardNumber;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[1]")
	private WebElement patientName_PatientDetails;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[2]")
	private WebElement ipNumber_PatientDetails;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[5]")
	private WebElement department_PatientDetails;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[6]")
	private WebElement roomType_PatientDetails;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[7]")
	private WebElement wardType_PatientDetails;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[10]")
	private WebElement patientType_PatientDetails;

	/*
	 * 
	 * Buiness Logics
	 * 
	 * 
	 */

	public void clickOnIpAdvance(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, ipAdvacneBtn);
	}

	public void enterPatientName(WebDriver driver, String patientName) {
		patientNameText.sendKeys(patientName);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText_Filter.sendKeys(hospitalNumber);

	}

	public void enterReceiptNumber(WebDriver driver, String receiptNumber) {
		receiptNumberText.sendKeys(receiptNumber);

	}

	public void clickOnSearch(WebDriver driver) {
//		invisibiltyOf_Element_ThreeDots(driver);
//		explicityWaitForElemenToBeClickable(driver, searchBtn);
		moveToTheParticularElementAndClick(driver, searchBtn);
		// invisibiltyOf_Element_ThreeDots(driver);

	}

	public void clickOnClearl(WebDriver driver) {
//		invisibiltyOf_Element_ThreeDots(driver);
//		explicityWaitForElemenToBeClickable(driver, clearBtn);
		moveToTheParticularElementAndClick(driver, clearBtn);
		// invisibiltyOf_Element_ThreeDots(driver);

	}

	public void clickOnSubmitBtn(WebDriver driver) {
		// explicityWaitForElemenToBeClickable(driver, submitBtn);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
	}

	public void clickOnSubmit_HandleWindow(WebDriver driver) throws Throwable {
		// explicityWaitForElemenToBeClickable(driver, submitBtn);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		String firstWindowHandle = driver.getWindowHandle();
		for (String handle : windowHandles) {
			if (!handle.equals(firstWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(firstWindowHandle);
	}

	public void clickOnOkButtonSuccessfullMessage(WebDriver driver) {
		// invisibiltyOf_Element_ThreeDots(driver);
		okPopupMessageBtn.click();
	}

	public void chequePaymentMode(WebDriver driver, String chequeNumber, String cheDate, String draweeBank,
			String chequeOwnerNumber, String residingAt, String relationWithPatient, String mobileNumber,
			String policeStation, String branchName) {
		chequeNumberText.sendKeys(chequeNumber);
		chequeDate.sendKeys(cheDate);
		draweeBankText.sendKeys(draweeBank);
		chequeOwnerNumberText.sendKeys(chequeOwnerNumber);
		explictWaitForElementToBeVisible(driver, residingAtText);
		scrollDownThePageUntilElementIsVisible(driver, residingAtText);
		residingAtText.sendKeys(residingAt);

		// explicityWaitForElemenToBeClickable(driver, relationWithPatientDropdown);
		relationWithPatientDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, relationWithPatient);

		mobileNumberText.sendKeys(mobileNumber);
		policeStationText.sendKeys(policeStation);
		branchNameText.sendKeys(branchName);

	}

	public void debitCardPaymentMode(WebDriver driver, String cardType, String cardNumber, String serviceCharges,
			String terminalId, String batchNumber, String ExpiryMonth, String expiryYear, String referrenceNumber,
			String cardHolderNumber, String cardHolderName) throws Throwable {
		explictWaitForElementToBeVisible(driver, cardTypeDropdown);
		// explicityWaitForElemenToBeClickable(driver, cardTypeDropdown);
		scrollDownThePageUntilElementIsVisible(driver, cardTypeDropdown);
		cardTypeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, cardType);
		cardNumberText.sendKeys(cardNumber);
		serviceChargesText.sendKeys(serviceCharges);
		terminalIdText.sendKeys(terminalId);
		batchNumberText.sendKeys(batchNumber);
		cardExpiryMonth.sendKeys(ExpiryMonth);
		cardExpiryYear.sendKeys(expiryYear);
		referrenceNumberText.sendKeys(referrenceNumber);
		cardHolderNumberText.sendKeys(cardHolderNumber);
		cardHolderNameText.sendKeys(cardHolderName);

	}

	public String takePatientName(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientName = patientName_Table.getText();
		return patientName;

	}

	public String takeHospitalNumber(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String takeReceiptNumber(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String receiptNumber = receiptNumber_Table.getText();
		return receiptNumber;

	}

	public void clickOnReportView(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, viewBtn_Table);
	}

	public void clickOnNewAdvanceButton(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		moveToTheParticularElementAndClick(driver, newAdvanceBtn);
	}

	public void clearThePaidBy() {
		paidByText.clear();
	}

	public void enterAdvanceAmount(WebDriver driver, String advanceAmount) {
		advanceAmountText.sendKeys(advanceAmount);
	}

	public void selectPaymentMode(WebDriver driver, String paymentMode) {
		scroolToSpecifiedHeight(driver, 350);
		PaymentModeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, paymentMode);
	}

	public void enterPaidBy(WebDriver driver, String paidBy) {
		paidByText.clear();
		paidByText.sendKeys(paidBy);
	}

	public void enterRemarks(WebDriver driver, String remarks) {
		remarksText.sendKeys(remarks);
	}

	public String errorMessageCapture(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, errorMessage);
		String msg = errorMessage.getText();
		return msg;
	}

	public String capture_LastRowPatientName_Table(WebDriver driver) {
		String patientName = lastRowPatientName_Table.getText();
		return patientName;
	}

	public String captureLastRowHospitalNumber_Table(WebDriver driver) {
		String hospitalNumber = lastRowHospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String captureLastRowReceiptNumber_Table(WebDriver driver) {
		String receiptNumber = lastRowReceiptNumber_Table.getText();
		return receiptNumber;
	}

	public String captureErrorMessage(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String msg = errorMessageHospitalNumber.getText();
		return msg;
	}

	public String capturePopupMessage(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String msg = popupMessage.getText();
		return msg;
	}

	public String captureTotalAdvanceAmountList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		double number = 0.00;
		for (WebElement webElement : advanceAmountListTable) {
			String amt = webElement.getText();
			double number1 = Double.parseDouble(amt);
			number += number1;
		}
		String formattedAmount = String.format("%.3f", number);
		return formattedAmount;
	}

	public void selectCardType_CreditCard(WebDriver driver, String cardType) {
		scrollDownThePageUntilElementIsVisible(driver, cardTypeDropdownBtn_CreditCard);
		dropdown(driver, cardTypeDropdownBtn_CreditCard, dropdownText, cardType);
	}

	public void credit_DebitCardDetails(WebDriver driver, String cardType, String number) {
		selectCardType_CreditCard(driver, cardType);
		cardNumberText.sendKeys(number);
	}

	public String capturePatientDetailsPatientDetails(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientName = patientName_PatientDetails.getText();
		return patientName;
	}

	public String captureIpNumberPatientDetails(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String ipNumber = ipNumber_PatientDetails.getText();
		return ipNumber;
	}

	public String captureDepartmentPatientDetails(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String department = department_PatientDetails.getText();
		return department;
	}

	public String captureRoomTypePatientDetails(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String roomType = roomType_PatientDetails.getText();
		return roomType;
	}

	public String captureWardTypePatientDetails(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String wardType = wardType_PatientDetails.getText();
		return wardType;
	}

	public String capturePatientTypePatientDetails(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientType = patientType_PatientDetails.getText();
		return patientType;
	}

}