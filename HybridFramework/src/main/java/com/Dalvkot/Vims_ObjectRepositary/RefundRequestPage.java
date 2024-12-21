package com.Dalvkot.Vims_ObjectRepositary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class RefundRequestPage extends WebDriverUtility {

	public RefundRequestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Request a Refund ']")
	private WebElement requestRefundPage;

	@FindBy(xpath = "//span[text()='OP']/following-sibling::span")
	private WebElement billTypeDropdownBtn;

	@FindAll({ @FindBy(xpath = "//label[text()='Hospital Number']/following-sibling::input"),
			@FindBy(xpath = "//input[@placeholder='Hospital No']") })
	private WebElement hospitalNumberTextFilter;

	@FindBy(xpath = "//input[@placeholder='Bill No']")
	private WebElement billNumberText_Filter;

	@FindBy(xpath = "//label[text()='Bill Date']/following-sibling::input")
	private WebElement billDate_Calender;

	@FindAll({ @FindBy(xpath = "//button[text()=' Search']//i") })
	private WebElement searchBtn;

	@FindAll({ @FindBy(xpath = "//button[text()=' Clear']") })
	private WebElement clearBtn;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[2]")
	private WebElement billType_RefundRequestTable;

	@FindAll({ @FindBy(xpath = "//table//tr[1]//td[3]//a") })
	private WebElement billNumberBtnRefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[4]")
	private WebElement billDateRefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[6]")
	private WebElement hospitalNumberRefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[7]")
	private WebElement patientName_RefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[8]")
	private WebElement age_RefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[9]")
	private WebElement transactionType_RefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[10]")
	private WebElement totalAmount_RefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[12]")
	private WebElement receiptNumberRefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[13]")
	private WebElement receiptDateRefundRequestTable;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[last()]")
	private WebElement approvalStatus_RefundRequestTable;

	@FindBy(xpath = "//input[@value='Status']")
	private WebElement selectAllServicesCheckbox_Popup;

	@FindBys({ @FindBy(xpath = "//table//tr//td[last()]//input[@id='selectCheckId']") })
	private List<WebElement> selectCheckBoxsInThe_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//table)[2]/tbody/tr/td[last()]/descendant::input[@id='selectCheckId']")
	private WebElement CheckBoxsInThe_ServiceDetailsTable_Popup;

	@FindBys({ @FindBy(xpath = "(//table)[2]/tbody/tr/td[2]") })
	private List<WebElement> serviceType_ServiceDetailsTable_Popup;

	@FindBys({ @FindBy(xpath = "(//table)[2]/tbody/tr/td[3]") })
	private List<WebElement> serviceClass_ServiceDetailsTable_Popup;

	@FindBys({ @FindBy(xpath = "(//table)[2]/tbody/tr/td[4]") })
	private List<WebElement> serviceName_ServiceDetailsTable_Popup;

	@FindBys({ @FindBy(xpath = "(//table)[2]/tbody/tr/td[7]") })
	private List<WebElement> totalAmount_ServiceDetailsTable_Popup;

	@FindBys({ @FindBy(xpath = "(//table)[2]/tbody/tr/td[8]") })
	private List<WebElement> refundAmount_ServiceDetailsTable_Popup;

	@FindBys({ @FindBy(xpath = "(//table)[2]/tbody/tr/td[9]") })
	private List<WebElement> sampleCollected_ServiceDetailsTable_Popup;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private WebElement re_ServiceDetailsTable_Popup;

	@FindBy(xpath = "//button[text()=' Save']")
	private WebElement saveBtn_ServiceDetailsTable_Popup;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn_ServiceDetailsTable_Popup;

	@FindBy(xpath = "//div[@class='form-group col-lg-3 col-md-3 col-sm-3 col-xs-12']/descendant::span")
	private WebElement totalRefundAmount_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement intMark_ServiceDetailsTable_Popup;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private WebElement remarksText_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//div[@class='modal-body'])[2]/descendant::span[3]")
	private WebElement patientName_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//div[@class='modal-body'])[2]/descendant::span[4]")
	private WebElement hospitalNumber_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//div[@class='modal-body'])[2]/descendant::span[5]")
	private WebElement billNumber_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//div[@class='modal-body'])[2]/descendant::span[6]")
	private WebElement billDate_ServiceDetailsTable_Popup;

	@FindBy(xpath = "(//div[@class='modal-body'])[2]/descendant::span[7]")
	private WebElement totalAmount_ServiceDetailsTable_Popup_PatientDetails;

	@FindBy(xpath = "(//div[@class='modal-body'])[2]/descendant::span[8]")
	private WebElement departmentName_ServiceDetailsTable_Popup;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//div[@aria-label='Please Enter Remarks']")
	private WebElement remarksErrorMsg;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement textInTheOkpopup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "(//label[text()=' Select All Services ']/following::input)[3]")
	private WebElement refundAmountField;

	@FindBys({ @FindBy(xpath = "//table[@class='table table-striped row-border hover']//tr/td[1]") })
	private List<WebElement> listOfSerialno;

	@FindBy(xpath = "//li//a[@aria-label='Next page']")
	private WebElement nextBtn;

	@FindBy(xpath = "//li//a[@aria-label='Previous page']")
	private WebElement previousBtn;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[1]")
	private WebElement serialNoInTable;

	@FindBy(xpath = "(//input[@id='selectCheckId'])[1]")
	private WebElement checkBox_First;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[1]/td[4]")
	private WebElement serviceName_PopUp;

	@FindBys({ @FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr/td[4]") })
	private List<WebElement> listOfServiceNames_Popup;

	@FindBy(xpath = "//a[contains(text(),'Confirmed Refund List')]")
	private WebElement confirmedRefundListTab;

	@FindBy(xpath = "(//div[@id='modal']//span)[10]")
	private WebElement totalRefundAmount;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[14]/a[1]")
	private WebElement approvalStatus_table;

	@FindBys({
			@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[not(position()=1)]/td[7]") })
	private List<WebElement> listOfTotalAmount_Popup_ExceptFirstRow;

	/*
	 * 
	 * Buiness Logics
	 * 
	 */
	public void clickOnRefundRequestPage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, requestRefundPage);
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnOkBtnIfDisplays(driver);
	}

	public void selectBillTypeDropdown(WebDriver driver, String billType) {
		invisibiltyOf_Element_ThreeDots(driver);
		billTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, billType);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		invisibiltyOf_Element_ThreeDots(driver);
		hospitalNumberTextFilter.clear();
		hospitalNumberTextFilter.sendKeys(hospitalNumber);

	}

	public void enterBillNumber(WebDriver driver, String billNumber) {
		invisibiltyOf_Element_ThreeDots(driver);
		billNumberText_Filter.sendKeys(billNumber);

	}

	public void enterBillDate(WebDriver driver, String billDate) {
		invisibiltyOf_Element_ThreeDots(driver);
		billDate_Calender.sendKeys(billDate);
	}

	public void clickOnSearchButton(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();

	}

	public void clickOnClearButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn.click();
	}

	public String takeBillType_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String billType = billType_RefundRequestTable.getText();
		return billType;
	}

	public String takeBillNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String billNumber = billNumberBtnRefundRequestTable.getText();
		return billNumber;
	}

	public String takehospitalNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumberRefundRequestTable.getText();
		return hospitalNumber;
	}

	public String takePatientName_Table(WebDriver driver) {
		String patientName = patientName_RefundRequestTable.getText();
		return patientName;
	}

	public String takeAge_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String age = age_RefundRequestTable.getText();
		return age;
	}

	public String taketarnsactionType_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String transactionType = transactionType_RefundRequestTable.getText();
		return transactionType;
	}

	public String takeTotalAmount_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String totalAmount = totalAmount_RefundRequestTable.getText();
		return totalAmount;
	}

	public String takeReceiptNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String receiptNumber = receiptNumberRefundRequestTable.getText();
		return receiptNumber;
	}

	public String takeReceiptDate_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String receiptDate = receiptDateRefundRequestTable.getText();
		return receiptDate;
	}

	public String takeApprovalStatus_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String approvalStatus = approvalStatus_RefundRequestTable.getText();
		return approvalStatus;
	}

	public void clickOnBillNumber(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		billNumberBtnRefundRequestTable.click();
	}

	public void clickOnBillNumberInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
		billNumberBtnRefundRequestTable.click();
	}

	public String verifyRemarksErrorMsg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(4000);
		CheckBoxsInThe_ServiceDetailsTable_Popup.click();
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		scrollDownThePageUntilElementIsVisible(driver, saveBtn_ServiceDetailsTable_Popup);
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String errorMsg = remarksErrorMsg.getText();
		return errorMsg;
	}

	public void clickOnTheSelectAllServices_RadioBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		selectAllServicesCheckbox_Popup.click();
	}

	public void clickOnSaveButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, saveBtn_ServiceDetailsTable_Popup);
		saveBtn_ServiceDetailsTable_Popup.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void enterRemarksInThe_Popup(WebDriver driver, String remarks) {
		scrollDownThePageUntilElementIsVisible(driver, remarksText_ServiceDetailsTable_Popup);
		remarksText_ServiceDetailsTable_Popup.sendKeys(remarks);
	}

	public void clickOnOkBtnIfDisplays(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement okBtn = null;
		try {
			okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Ok button not found. Skipping clicking the OK button.");
		}
		if (okBtn != null) {
			okBtn.click();
		}
	}

	public String captureTextInPopup(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = textInTheOkpopup.getText();
		return text;
	}

	public void clickOnOkBtn(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		okBtn.click();
	}

	public String captureRefundAmountInThePopup(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String amt = refundAmountField.getAttribute("value");
		return amt;
	}

	public void verifyNextBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		for (int i = 1; i <= 4; i++) {
			WebElement lastSlNo = listOfSerialno.get(listOfSerialno.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			invisibiltyOf_Element_ThreeDots(driver);
			nextBtn.click();
			invisibiltyOf_Element_ThreeDots(driver);
			Thread.sleep(1500);
			invisibiltyOf_Element_ThreeDots(driver);
			String ls1 = serialNoInTable.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 0; i < 4; i++) {
			scrollToBottom(driver);
			nextBtn.click();
		}
		for (int i = 0; i < 4; i++) {
			Thread.sleep(2000);
			int expectedSerialNo = Integer.parseInt(serialNoInTable.getText()) - 1;
			scrollToBottom(driver);
			invisibiltyOf_Element_ThreeDots(driver);
			previousBtn.click();
			invisibiltyOf_Element_ThreeDots(driver);
			Thread.sleep(2000);
			int lastSerialNo = Integer.parseInt(listOfSerialno.get(listOfSerialno.size() - 1).getText());
			System.out.println(lastSerialNo);
			Assert.assertEquals(lastSerialNo, expectedSerialNo);
		}
		System.out.println("Successfully verified the previous button");
	}

	public void clickOnTheCheckBox_PopUP(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		checkBox_First.click();
	}

	public String captureServiceNameinPopUp(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = serviceName_PopUp.getText();
		return text;
	}

	public List<String> captureListOfServiceNameinPopUp(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		List<String> a = new ArrayList<>();
		for (WebElement element : listOfServiceNames_Popup) {
			String text = element.getText();
			a.add(text);
		}
		return a;
	}

	public void clickOnConfirmedRefundListTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		confirmedRefundListTab.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String captureTotalRefundAmountinPopUp(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = totalRefundAmount.getText().replace(":", "");
		System.out.println(text);
		return text;
	}

	public String captureApprovalStatusInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, approvalStatus_table);
		String txt = approvalStatus_table.getText();
		return txt;
	}

	public List<String> captureListOfTotalAmountInPopup_ExceptFirstRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		List<String> a = new ArrayList<>();
		for (WebElement element : listOfTotalAmount_Popup_ExceptFirstRow) {
			String text = element.getText();
			double te = Double.parseDouble(text);
			String te1 = String.format("%.2f", te);
			a.add(te1);
		}
		System.out.println(a);
		return a;
	}
}
