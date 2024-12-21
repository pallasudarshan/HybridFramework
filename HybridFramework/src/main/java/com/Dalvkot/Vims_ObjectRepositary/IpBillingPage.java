package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class IpBillingPage extends WebDriverUtility {
	public IpBillingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' IP Billing ']")
	private WebElement ipBillingLinkBtn;

	@FindBy(xpath = "//a[contains(text(),'New Bill')]")
	private WebElement newBillBtn;

	@FindBy(xpath = "//input[@placeholder='Hospital No']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(id = "Provisionalradio")
	private WebElement provisionalRadioBtn;

	@FindBy(id = "Finalradio")
	private WebElement finalRadioBtn;

	@FindBy(xpath = "//span[text()='CASH']/following-sibling::span")
	private WebElement transactionTypeDropdown;

	@FindBys({ @FindBy(xpath = "//div[@id='ipBillingDetailss']//table//tr/td[4]//input[@placeholder='Rate']") })
	private List<WebElement> rates_IpBillingDetailsList;

	@FindBys({
			@FindBy(xpath = "//div[@id='ipBillingDetailss']//table//tr/td[6]//input[@placeholder='Discount Amount ']") })
	private List<WebElement> discountAmount_IpBillingDetailsList;

	@FindBys({
			@FindBy(xpath = "//div[@id='ipBillingDetailss']//table//tr/td//input[@placeholder='Concession Amount ']") })
	private List<WebElement> concessionAmount_IpBillingDetailsList;

	@FindBys({
			@FindBy(xpath = "//div[@id='ipBillingDetailss']//table//tr/td//input[@placeholder='Total Net Amount']") })
	private List<WebElement> totalNetAmount_IpBillingDetailsList;

	@FindBys({ @FindBy(xpath = "//div[@id='ipBillingDetailss']//table//tr/td//*[@role='img']") })
	private List<WebElement> viewBtns_IpBillingDetailsList;

	@FindBy(xpath = "//label[text()='Bill amount ']/following-sibling::input[@placeholder='Bill amount']")
	private WebElement billAmount_BillAmountDetails;

	@FindBy(xpath = "//label[text()='Discount Amount ']/following-sibling::input")
	private WebElement discountAmount_BillAmountDetails;

	@FindBy(xpath = "//label[text()='Concession % ']/following-sibling::input")
	private WebElement concessionPercentageText_BillAmountDetails;

	@FindBy(xpath = "//label[text()='Concession Amount ']/following-sibling::input")
	private WebElement concessionAmountText_BillAmountDetails;

	@FindBy(xpath = "//label[text()='Net Amount ']/following-sibling::input")
	private WebElement netAmount_BillAmountDetails;

	@FindBy(xpath = "//label[text()='Advance Deposit ']/following-sibling::input")
	private WebElement advanceDeposit_BillAmountDetails;

	@FindBy(xpath = "//label[text()='Amount To Refund ']/following-sibling::input")
	private WebElement amountToRefund_BillAmountDetails;

	@FindBy(xpath = "//input[@placeholder='remarks']")
	private WebElement remarks_BillAmountDetails;

	@FindBy(xpath = "//a[contains(text(),'Advance Payment')]")
	private WebElement advancePayment_Tab;

	@FindBy(xpath = "//button[text()='Add Advance']")
	private WebElement addAdvanceBtn_AdvancePayment;

	@FindBy(xpath = "//div[@id='advancePayment']//table//tr[1]/td[4]")
	private WebElement paidAmount_AdvancePayment;

	@FindBy(xpath = "//div[@id='advancePayment']//table//tr[1]/td[3]")
	private WebElement receiptDate_AdvancePayment;

	@FindBy(xpath = "//div[@id='advancePayment']//table//tr[1]/td[2]")
	private WebElement receiptNumber_AdvancePayment;

	@FindBy(xpath = "//div[@id='advancePayment']//table//tr[1]/td[5]")
	private WebElement paymentMode_AdvancePayment;

	@FindBy(xpath = "//a[contains(text(),'Dicharge note')]")
	private WebElement dischargeNote_Tab;

	@FindBy(xpath = "//label[text()='Authorization']/..//span[@role='presentation']")
	private WebElement authorizationDropdownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//label[text()='Transaction Type']/..//span[@role='presentation']")
	private WebElement transactionType_Dropdown_Filter;

	@FindBy(xpath = "//input[@placeholder='Bill Number']")
	private WebElement billNumberText_Filter;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText_Filter;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn_Filter;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn_Filter;

	@FindBy(xpath = "//div[@class='card']/following-sibling::button[@type='submit']")
	private WebElement final_SubmitButton;

	@FindBy(xpath = "//div[@class='card']/following-sibling::button//i[@class='zmdi zmdi-close-circle']")
	private WebElement final_cancelBtn;

	@FindBy(xpath = "(//div[@id='ipBillingDetailss']//table//h6)[1]")
	private WebElement billTotal_Under_sumOfRateAmountst;

	@FindBy(xpath = "(//div[@id='ipBillingDetailss']//table//h6)[2]")
	private WebElement discountAmount_Under_sumOfDiscountAmountst;

	@FindBy(xpath = "(//div[@id='ipBillingDetailss']//table//h6)[3]")
	private WebElement concessionTotal_Under_sumOfConcessionAmountst;

	@FindBy(xpath = "(//div[@id='ipBillingDetailss']//table//h6)[4]")
	private WebElement netTotal_Under_sumOfNetAmountst;

	@FindBys({ @FindBy(xpath = "(//b[text()=' : ']/following-sibling::label)") })
	private List<WebElement> individualServices_Rate;

	// Suspended bill

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[2]")
	private WebElement transactionType_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[3]")
	private WebElement billDateAndTime_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[4]")
	private WebElement billNumber_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[5]")
	private WebElement patientName_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[6]")
	private WebElement hospitalNumber_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[7]")
	private WebElement ipNumber_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[8]")
	private WebElement department_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td[9]")
	private WebElement approvalStatus_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td//button[text()=' Actions ']")
	private WebElement actionBtn_SuspendedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']//table//tr[1]/td//button[text()=' View Bill']")
	private WebElement viewBill_SuspendedList;

	@FindBy(xpath = "//input[@placeholder='Advance Amount']")
	private WebElement advanceAmountText;

	@FindBy(xpath = "//input[@placeholder='Remarks']")
	private WebElement remarksText;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitButton;

	// Ip bill list
	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[2]")
	private WebElement transactionType_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[3]")
	private WebElement billDate_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[4]")
	private WebElement billNumber_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[5]")
	private WebElement patientName_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[6]")
	private WebElement hospitalNumber_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[7]")
	private WebElement ipNumber_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[8]")
	private WebElement department_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[9]")
	private WebElement provisionalBillNo_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[10]")
	private WebElement provisionalBillDoneBy_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[11]")
	private WebElement provisionalBillDate_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[last()]//button[text()=' Actions ']")
	private WebElement actionsBtn_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[1]/td[last()]//button[text()=' Cancel Bill']")
	private WebElement cancelBill_Action_IpBillList;

	@FindBy(xpath = "//div[@id='ipBillingDetailss']//table//tr[2]/td//*[@role='img']")
	private WebElement secondRow_ViewButton_IpBillingDetailsList;

	@FindBy(xpath = "(//button[text()=' Submit'])[2]")
	private WebElement serviceDetailsTables_SubmitButton;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn_popup;

	@FindBy(xpath = "//a[contains(text(),'Suspended Bill List')]")
	private WebElement suspendedTab;

	@FindBy(xpath = "//a[contains(text(),'Ip Bill List')]")
	private WebElement ipBillListTab;

	@FindBy(xpath = "//div[@id='History']//table//tr[last()]/td[4]")
	private WebElement lastrow_BilNumber_IpBillList;

	@FindBy(xpath = "//div[@id='History']//table//tr[last()]/td[6]")
	private WebElement lastrow_HospitalNumber_IpBillList;

	// OT Details
	@FindBy(xpath = "(//div[@id='ipBillingDetailss']//table//tr//td[3]//span[text()='OT SERVICES']/following::button/*[@role='img'])[1]")
	private WebElement otService_ViewButtonInThe_IpBillingDetailsTable;

	@FindBy(xpath = "(//label[text()='Ot Charges']/following-sibling::input)[1]")
	private WebElement otCharges_OT_Bill;

	@FindBy(xpath = "(//label[text()='Surgeon Charges']/following::input)[1]")
	private WebElement surgeonAmount_OT_Bill;

	@FindBy(xpath = "((//label[text()='Total Charges'])[2]/following::input)[1]")
	private WebElement totalCharges_OT_Bill;

	@FindBy(xpath = "((//label[text()='Total Charges'])[2]/following::input)[1]")
	private WebElement submitBtn_OT_Bill;

	@FindBy(xpath = "(//table/thead/tr[1]/th[2])[1]")
	private WebElement patientName_Details;

	@FindBy(xpath = "(//table/thead/tr[1]/th[4])[1]")
	private WebElement patientAge_Details;

	@FindBy(xpath = "(//table/thead/tr[1]/th[6])[1]")
	private WebElement ipNumber_Details;

	@FindBy(xpath = "(//table/thead/tr[2]/th[2])[1]")
	private WebElement hospitalNumber_Details;

	@FindBy(xpath = "(//table/thead/tr[3]/th[4])[1]")
	private WebElement wardType_Details;

	@FindBy(xpath = "(//table/thead/tr[3]/th[6])[1]")
	private WebElement roomType_Details;

	@FindBy(xpath = "(//table/thead/tr[4]/th[2])[1]")
	private WebElement bedNumber_Details;

	@FindBy(xpath = "(//table/thead/tr[4]/th[4])[1]")
	private WebElement admissionMode_Details;

	@FindBy(xpath = "(//table/thead/tr[4]/th[6])[1]")
	private WebElement admissionDate_Details;

	@FindBy(xpath = "(//span[@role='textbox'])[1]")
	private WebElement transactionTypeData;

	@FindBy(xpath = "(//span[@role='textbox'])[1]")
	private WebElement patientCategory_Details;

	/*
	 * 
	 *
	 * Buisness Logics
	 * 
	 * 
	 */

	public void clikcOn_IpBillingBtn(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, ipBillingLinkBtn);
	}

	public void newBill_EnterHospital_Search(WebDriver driver, String hospitalNumber) {
		clickOn_NewBillButton(driver);
		enterHospitalNumber(driver, hospitalNumber);
		clickOn_SearchButton(driver);
	}

	public void clickOn_NewBillButton(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 150);
		newBillBtn.click();
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		hospitalNumberText.sendKeys(hospitalNumber);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_SearchButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		searchBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void select_ProvisionalRadioButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		scrollDownThePageUntilElementIsVisible(driver, provisionalRadioBtn);
		provisionalRadioBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);

	}

	public void selectFinal_RadioButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		finalRadioBtn.click();
	}

	public String capture_BillAmount(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billAmount = billAmount_BillAmountDetails.getAttribute("value");
		return billAmount;
	}

	public String capture_DisciuntAmount(WebDriver driver) {
		String discountAmount = discountAmount_BillAmountDetails.getAttribute("value");
		return discountAmount;
	}

	public void capture_ConcessionPercentage(WebDriver driver) {
		concessionPercentageText_BillAmountDetails.getAttribute("value");
	}

	public String cpatureConcessionAmount(WebDriver driver) {
		String concessionAmt = concessionAmountText_BillAmountDetails.getAttribute("value");
		return concessionAmt;
	}

	public String capture_NetAmount(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, netAmount_BillAmountDetails);
		String netAmount = netAmount_BillAmountDetails.getAttribute("value");
		return netAmount;
	}

	public String capture_AdvanceDeposit(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, advanceDeposit_BillAmountDetails);
		String netAmount = advanceDeposit_BillAmountDetails.getAttribute("value");
		return netAmount;
	}

	public String capture_AdvanceDeposit_And_AddTheGivenAmount(WebDriver driver, int value) {
		scrollDownThePageUntilElementIsVisible(driver, advanceDeposit_BillAmountDetails);
		String currentAmountStr = advanceDeposit_BillAmountDetails.getAttribute("value");
		System.out.println(currentAmountStr);
		double currentAmount = Double.parseDouble(currentAmountStr);
		double newAmount = currentAmount + value;
		String netAmount = String.valueOf(newAmount);
		return netAmount;
	}

	public String capture_AmountToRefund(WebDriver driver) {
		String amountToRefund = amountToRefund_BillAmountDetails.getAttribute("value");
		return amountToRefund;
	}

	public void enterRemarks(WebDriver driver, String remarks) {
		remarks_BillAmountDetails.sendKeys(remarks);
	}

	public void select_Authorization(WebDriver driver, String authorization) {
		dropdown(driver, authorizationDropdownBtn, dropdownText, authorization);
	}

	public void clickOn_FinalSubmit(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, final_SubmitButton);
		final_SubmitButton.click();

		Thread.sleep(2000);
		getWindowHandles(driver);
		okBtn_popup.click();

	}

	public void clickOn_FinalCancel(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, final_cancelBtn);
		final_cancelBtn.click();
	}

	public void clickOn_AdvancePaymentTab(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, advancePayment_Tab);

		advancePayment_Tab.click();
	}

	public void clickOn_AddAdvanceButton_Payment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, addAdvanceBtn_AdvancePayment);

		addAdvanceBtn_AdvancePayment.click();
	}

	public String sumOfTheServices_Rates_InTheList(WebDriver driver) throws Throwable {
		Thread.sleep(11000);
		float rate = 0;
		List<WebElement> elements = rates_IpBillingDetailsList;
		elements.removeIf(element -> elements.indexOf(element) == elements.size() - 1);
		for (WebElement webElement : elements) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			String rr = webElement.getAttribute("value");
			float floatValue = Float.parseFloat(rr);
			rate += floatValue;
		}
		String stringValue = String.format("%.2f", rate);
		return stringValue;
	}

	public String sumOfThe_TotalNetAmount_InTheList(WebDriver driver) throws Throwable {
		Thread.sleep(10000);
		float rate = 0;
		List<WebElement> elements = totalNetAmount_IpBillingDetailsList;
		if (!elements.isEmpty()) {
			elements.remove(elements.size() - 1);
		}
		for (WebElement webElement : elements) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			String rr = webElement.getAttribute("value");
			rate += Float.parseFloat(rr);
		}
		String stringValue = String.format("%.2f", rate);
		return stringValue;
	}

	public String capture_billTotalAmount_SumOfRateAmounts(WebDriver driver) {
		String rate = billTotal_Under_sumOfRateAmountst.getText();
		String amt = remove_Characters_And_FirstCharcatersRemove(rate, 4);
		return amt;
	}

	public String capture_discountAmount_SumOfRateAmounts(WebDriver driver) {
		String discount = discountAmount_Under_sumOfDiscountAmountst.getText();
		return discount;
	}

	public String capture_concessionAmount_SumOfRateAmounts(WebDriver driver) {
		String concession = concessionTotal_Under_sumOfConcessionAmountst.getText();
		return concession;
	}

	public String capture_netTotalAmount_SumOfTotalNetAmounts(WebDriver driver) {
		String netAmount = netTotal_Under_sumOfNetAmountst.getText();
		String amt = remove_Characters_And_FirstCharcatersRemove(netAmount, 4);
		return amt;
	}

	public void clickOnActionsViewButtons_VerifyingTotalAmounts(WebDriver driver) throws Throwable {
		Thread.sleep(9000);
		List<WebElement> netAmt = totalNetAmount_IpBillingDetailsList;
		List<WebElement> view = viewBtns_IpBillingDetailsList;
		int size = view.size() - 1;
		for (int viewSize = 0; viewSize < size; viewSize++) {
			WebElement netAmount = netAmt.get(viewSize);
			WebElement viewButtons = view.get(viewSize);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			scrollDownThePageUntilElementIsVisible(driver, viewButtons);
			viewButtons.click();
			String rate = netAmount.getAttribute("value");
			List<WebElement> indRate = individualServices_Rate;
			indRate.forEach(webElement -> {
				String rate1 = webElement.getText();
				if (!rate1.isEmpty()) {
					Assert.assertEquals(rate, rate1);
				}
			});
		}
	}

	public String capture_TransactionType_SuspendedList(WebDriver driver) {
		String transactionType = transactionType_SuspendedList.getText();
		return transactionType;
	}

	public String capture_BillDateAndTime_SuspendedList(WebDriver driver) {
		String billDateAndTime = billDateAndTime_SuspendedList.getText();
		return billDateAndTime;
	}

	public String capture_BillNumber_SuspendedList(WebDriver driver) {
		String billNumber = billNumber_SuspendedList.getText();
		return billNumber;
	}

	public String capture_PatientName_SuspendedList(WebDriver driver) {
		String patientName = patientName_SuspendedList.getText();
		return patientName;
	}

	public String capture_HospitalNumber_SuspendedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_SuspendedList.getText();
		return hospitalNumber;
	}

	public String capture_IpNumber_SuspendedList(WebDriver driver) {
		String ipNumber = ipNumber_SuspendedList.getText();
		return ipNumber;
	}

	public String capture_Department_SuspendedList(WebDriver driver) {
		String department = department_SuspendedList.getText();
		return department;
	}

	public String capture_ApprovalStatus_SuspendedList(WebDriver driver) {
		String status = approvalStatus_SuspendedList.getText();
		return status;
	}

	public void clickOn_Actions_SuspendedList(WebDriver driver) {
		doubleClick(driver, actionBtn_SuspendedList);
	}

	public void clickOn_ViewBillButton_SuspendedList(WebDriver driver) {
		viewBill_SuspendedList.click();
	}

	public String billAmountMinus_DiscountAmount_Minus_ConcessionAmount(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, billAmount_BillAmountDetails);
		scrollDownThePageUntilElementIsVisible(driver, discountAmount_BillAmountDetails);

		String billAmt = billAmount_BillAmountDetails.getAttribute("value");
		String DiscountAmt = discountAmount_BillAmountDetails.getAttribute("value");
		String concessionAmt = concessionAmountText_BillAmountDetails.getAttribute("value");

		double billAmount = Double.parseDouble(billAmt);
		double DiscountAmount = Double.parseDouble(DiscountAmt);
		double concessionAmount = Double.parseDouble(concessionAmt);

		double netAmt = billAmount - DiscountAmount - concessionAmount;
		String netAmount = String.format("%.2f", netAmt);
		return netAmount;

	}

	public void enterThe_AdvanceAmount_IpAdvance(WebDriver driver, String amount) {
		invisibiltyOf_Element_ThreeDots(driver);
		invisibiltyOf_Element_ThreeDots(driver);
		advanceAmountText.sendKeys(amount);
	}

	public void enterThe_Remarks_IpAdvance(WebDriver driver, String remarks) {
		invisibiltyOf_Element_ThreeDots(driver);
		invisibiltyOf_Element_ThreeDots(driver);
		remarksText.sendKeys(remarks);
	}

	public void clickOn_SubmitButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitButton);
		submitButton.click();
	}

	public void add_AdvanceAmoun_InTheWindow(WebDriver driver, String amount, String remarks) {
		clickOn_AdvancePaymentTab(driver);
		clickOn_AddAdvanceButton_Payment(driver);

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
				enterThe_AdvanceAmount_IpAdvance(driver, amount);
				enterThe_Remarks_IpAdvance(driver, remarks);
				clickOn_SubmitButton(driver);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);

	}

	public void enter_ConcessionPercentage(WebDriver driver, String concessionPercentage) {

		scrollDownThePageUntilElementIsVisible(driver, concessionPercentageText_BillAmountDetails);
		concessionPercentageText_BillAmountDetails.sendKeys(concessionPercentage, Keys.TAB);
	}

	public void verifyingThe_NetAmount_AfterGivingConcessionPercentage(WebDriver driver, String concessionPercentage)
			throws Throwable {
		String billAmt = capture_BillAmount(driver);
		enter_ConcessionPercentage(driver, concessionPercentage);
		Thread.sleep(4000);
		String concessionAmt = concessionAmountText_BillAmountDetails.getAttribute("value");
		double billAmount = Double.parseDouble(billAmt);

		double concession_Percentage = Double.parseDouble(concessionPercentage);
		double concessionamount = (billAmount * concession_Percentage) / 100;

		double roundedNumber = 0.00;
		String numberString = Double.toString(concessionamount);
		char lastDigit = numberString.charAt(numberString.length() - 1);
		int lastDigitValue = Character.getNumericValue(lastDigit);
		System.out.println(lastDigitValue + ": TEST");
		if (lastDigitValue >= 5) {
			DecimalFormat df = new DecimalFormat("#.00");
			String roundedNumberStr = df.format(concessionamount);
			roundedNumber = Double.parseDouble(roundedNumberStr);
		}
		System.out.println(roundedNumber + "Final ");

		DecimalFormat df = new DecimalFormat("#.00");
		String myString = df.format(roundedNumber);

		Assert.assertEquals(concessionAmt, myString);

		double netAmnt = billAmount - concessionamount;
		DecimalFormat decimalFormat1 = new DecimalFormat("0.00");
		long netAmount = Math.round(netAmnt);
		String net_Amount = decimalFormat1.format(netAmount);
		String netAmount1 = capture_NetAmount(driver);
		Assert.assertEquals(net_Amount, netAmount1);
	}

	public void calculations_Of_AmountToRefund(WebDriver driver) {
		String netAmt = capture_NetAmount(driver);
		String advanceDept = capture_AdvanceDeposit(driver);
		String amountToRefund = capture_AmountToRefund(driver);
		double amtToRefund = 0.00;
		double amtToRefund1 = 0.00;

		double netAmt1 = Double.parseDouble(netAmt);
		double advanceDept1 = Double.parseDouble(advanceDept);
		if (netAmt1 > advanceDept1) {
			amtToRefund = netAmt1 - advanceDept1;
			DecimalFormat decimalFormat1 = new DecimalFormat("0.00");
			String amountToRefund1 = decimalFormat1.format(amtToRefund);
			System.out.println("first :" + amountToRefund);
			System.out.println("Second :" + amountToRefund1);

			Assert.assertEquals(amountToRefund, amountToRefund1);
		} else if (advanceDept1 > netAmt1) {
			amtToRefund1 = advanceDept1 - netAmt1;
			DecimalFormat decimalFormat1 = new DecimalFormat("0.00");
			String amountToRefund2 = decimalFormat1.format(amtToRefund1);
			System.out.println("third :" + amountToRefund);
			System.out.println("fourth :" + amountToRefund2);
			Assert.assertEquals(amountToRefund, amountToRefund2);
		}
	}

	public String capture_TransactionType_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String transactionType = transactionType_IpBillList.getText();
		return transactionType;
	}

	public String capture_BillDate_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = billDate_IpBillList.getText();
		return date;
	}

	public String capture_BillNumber_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNumber = billNumber_IpBillList.getText();
		return billNumber;
	}

	public String capture_PatientName_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String patientName = patientName_IpBillList.getText();
		return patientName;
	}

	public String capture_HospitalNumber_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_IpBillList.getText();
		return hospitalNumber;
	}

	public String capture_IpNumber_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = ipNumber_IpBillList.getText();
		return ipNumber;
	}

	public String capture_Department_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_IpBillList.getText();
		return department;
	}

	public String capture_provisionalBillNo_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String provisionalBillNo = provisionalBillNo_IpBillList.getText();
		return provisionalBillNo;
	}

	public String capture_ProvisionalBilDoneBy_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String provisionalBillDoneBy = provisionalBillDoneBy_IpBillList.getText();
		return provisionalBillDoneBy;
	}

	public String capture_ProvisionalBillDate_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String provisionalBillDate = provisionalBillDate_IpBillList.getText();
		return provisionalBillDate;
	}

	public void clickOn_Actions_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		doubleClickOnTheElement(driver, actionsBtn_IpBillList);
	}

	public void clickOn_CancelBillButtonActions_IpBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		cancelBill_Action_IpBillList.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_SecondRowViewButton_IPBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, secondRow_ViewButton_IpBillingDetailsList);

		secondRow_ViewButton_IpBillingDetailsList.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_SubmitButton_ServiceDetailsTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, serviceDetailsTables_SubmitButton);

		serviceDetailsTables_SubmitButton.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);

	}

	public void clickOn_OkButton_Popup(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtn_popup.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_SuspendedTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		scrollDownThePageUntilElementIsVisible(driver, suspendedTab);

		suspendedTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void enterHospitalNumber_Filter(WebDriver driver, String hospitalNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		hospitalNumberText_Filter.sendKeys(hospitalNumber);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void enterBillNumber_Filter(WebDriver driver, String billNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		billNumberText_Filter.sendKeys(billNumber);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void selectTransactionType_Filter(WebDriver driver, String transactionType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, transactionType_Dropdown_Filter, dropdownText, transactionType);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_ClearButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		clearBtn_Filter.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_IpBillingListTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		ipBillListTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String capture_LastRow_BillNumber_IpBillList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNumber = lastrow_BilNumber_IpBillList.getText();
		return billNumber;
	}

	public String capture_LastRow_HospitalNumberNumber_IpBillList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = lastrow_HospitalNumber_IpBillList.getText();
		return hospitalNumber;
	}

	public void clickOn_OtServiceButton_ViewButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, otService_ViewButtonInThe_IpBillingDetailsTable);
		otService_ViewButtonInThe_IpBillingDetailsTable.click();
	}

	public String capturePatientNameInTheDetails(WebDriver driver) {
		String na = patientName_Details.getText();
		String name = removeSpecialCharacters_And_Speces(na);
		return name;
	}

	public String capturePatientAgeInTheDetails(WebDriver driver) {
		String ag = patientAge_Details.getText();
		String age = removeSpecialCharacters_And_Speces(ag);
		return age;
	}

	public String captureIpNumberInTheDetails(WebDriver driver) {
		String ag = ipNumber_Details.getText();
		String ipNumber = removeSpecialCharacters_And_Speces(ag);
		return ipNumber;
	}

	public String captureHospitalNumberInTheDetails(WebDriver driver) {
		String hNumber = hospitalNumber_Details.getText();
		String hospitalNumber = removeSpecialCharacters_And_Speces(hNumber);
		return hospitalNumber;
	}

	public String captureWardTypeInTheDetails(WebDriver driver) {
		String wType = wardType_Details.getText();
		String wardType = removeSpecialCharactersAndFirstCharacters(wType, 2);
		return wardType;
	}

	public String captureRoomTypeInTheDetails(WebDriver driver) {
		String rType = roomType_Details.getText();
		String roomType = removeSpecialCharactersAndFirstCharacters(rType, 2);
		return roomType;
	}

	public String captureBedNumberInTheDetails(WebDriver driver) {
		String bNumber = bedNumber_Details.getText();
		String bedNumber = removeSpecialCharacters_And_Speces(bNumber);
		return bedNumber;
	}

	public String captureTransacionType_InTheDropdownData(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(null);
		String transactionType = transactionTypeData.getText();
		return transactionType;
	}
}
