package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class Concession_Refund_AuthorizationPage extends WebDriverUtility {

	public Concession_Refund_AuthorizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Concession/Refund  Authorization ']")
	private WebElement concessionRefundAuthorizationScreenBtn;

	@FindBy(xpath = "//span[text()='OP']/following-sibling::span")
	private WebElement concessionTypeDropDownFilterBtn;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement serachBoxForDropDown;

	@FindBy(xpath = "//input[@placeholder='Hospital No']")
	private WebElement hospitalNumberFilterField;

	@FindBy(xpath = "//input[@placeholder='Bill No']")
	private WebElement billNoFilterField;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement billDateFilter;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement concessionListRadioBtn;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement refundListRadioBtn;

	@FindBy(xpath = "(//input[@type='radio'])[3]")
	private WebElement cancelListRadioBtn;

	@FindBy(xpath = "//a[contains(text(),'Concession List')]")
	private WebElement concessionListTab;

	@FindBy(xpath = "//a[contains(text(),'Confirmed concession List')]")
	private WebElement confirmedConcessionListTab;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement hospitalNumber_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billNumber_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement departmentName_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement billAmount_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement concessionAmount_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement balanceAmount_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement concessionStatus_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[10]/descendant::button")
	private WebElement editConcessionBtn_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td/descendant::button/span[@class='zmdi zmdi-check']")
	private WebElement concessionEditRightMark_ConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td/descendant::button/span[@class='zmdi zmdi-close']")
	private WebElement concessionEditWrongMark_ConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement hospitalNumber_ConfirmedConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billNumber_ConfirmedConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_ConfirmedConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement departmentName_ConfirmedConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement billAmount_ConfirmedConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement concessionAmount_ConfirmedConcessionList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement balanceAmount_ConfirmedConcessionList;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
	private WebElement authorizationStatusDropDownBtn;

	@FindBy(xpath = "(//small[@class='text-mandatory']/following-sibling::input)[1]")
	private WebElement ConfimedreasonTextField;

	@FindBy(xpath = "(//button[text()=' Submit'])[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "(//button[text()=' Cancel'])[1]")
	private WebElement cancelBtn;

	@FindBy(xpath = "(//button[@class='close']//span)[2]")
	private WebElement xBtnToClosePopup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnForPopUp;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement billNumber_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumber_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement departmentName_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement totalBillAmount_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement requestedBy_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement refundAmount_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement status_pendingCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billNumber_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement departmentName_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement refundedAmount_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement confirmedBy_ConfirmedCreditCancelList;

	@FindBy(xpath = "//a[contains(text(),'Pending Refund List')]")
	private WebElement pendingRefundListTab;

	@FindBy(xpath = "//a[contains(text(),'Confirmed Refund List')]")
	private WebElement confirmedRefundListTab;

	@FindBy(xpath = "//a[contains(text(),'Pending Credit Cancel List')]")
	private WebElement pendingCreditCancelListTab;

	@FindBy(xpath = "//a[contains(text(),'Confirmed Credit Cancel List')]")
	private WebElement confirmedCreditCancelListTab;

	@FindBy(xpath = "/html/body/app-root/app-home/app-concession-authorization/div[1]/div/div/div[2]/div/table[1]/tbody/tr/td[4]")
	private WebElement serviceNameInConcessionPopUp;

	@FindBy(xpath = "(//textarea[contains(@class,'form-control no-resize')])[1]")
	private WebElement remarks_popup;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBys({ @FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialnoInConcessionList;

	@FindBys({ @FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialnoInConfirmedList;

	@FindBy(xpath = "(//a[@aria-label='Next page'])[1]")
	private WebElement nextBtnInConcessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[1]")
	private WebElement slNo_ConcessionList;

	@FindBy(xpath = "(//a[@aria-label='Previous page'])[1]")
	private WebElement previousBtnInConcessionList;

	@FindBy(xpath = "(//a[@aria-label='Next page'])[2]")
	private WebElement nextBtnInConfirmedList;

	@FindBy(xpath = "//div[@id='confirmedconcession']/descendant::table/tbody/tr[1]/td[1]")
	private WebElement slNo_ConFirmedList;

	@FindBy(xpath = "(//a[@aria-label='Previous page'])[2]")
	private WebElement previousBtnInConfirmedList;

	@FindBy(xpath = "//div[@aria-label='Please Enter Reason']")
	private WebElement reasonErrorMsg;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[10]/descendant::input")
	private WebElement updateConcessionTextFeild;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[11]/descendant::span")
	private WebElement tickBtn_concessionList;

	@FindBy(xpath = "//div[@id='Concession']/descendant::table/tbody/tr[1]/td[12]/descendant::span")
	private WebElement crossBtn_ConcessionList;

	@FindBy(xpath = "//input[@placeholder='Concession Amount']")
	private WebElement editConcessionAmountText;

	@FindBys({ @FindBy(xpath = "(//div[@class='modal-content'])[2]/descendant::table/tbody/tr/td[6]") })
	private List<WebElement> listOfRates_ServicePopup;

	@FindBys({ @FindBy(xpath = "(//div[@class='modal-content'])[2]/descendant::table/tbody/tr/td[7]") })
	private List<WebElement> listConcessionAmount_ServicePopup;

	@FindBys({ @FindBy(xpath = "(//div[@class='modal-content'])[2]/descendant::table/tbody/tr/td[8]") })
	private List<WebElement> listOfTotalAmount_ServicePopup;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
	private WebElement refundTypeDropDownBtn;

	@FindBy(xpath = "//div[@id='refundPEnding']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement billNumberInTable_PendingRefundList;

	@FindBy(xpath = "//div[@id='refundPEnding']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumberInTable_PendingRefundList;

	@FindBy(xpath = "//div[@id='refundconfirm']/descendant::a")
	private WebElement hospitalNumberInTable_ConfirmedRefundList;

	@FindBy(xpath = "//div[@class='bounce1']")
	private WebElement loader;

	@FindBy(xpath = "//span[@title='OP']/following-sibling::span[1]")
	private WebElement cancelTypesDropDownBtn;

	@FindBy(xpath = "//div[@id='pendingCreditCancel']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement billNumberInTable_PendingCreditCancelList;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[3]")
	private WebElement authorizationStatusDropDownBtn_PendingCreditCancelList;

	@FindBy(xpath = "(//input[@placeholder='CONFIRMED Reason'])[2]")
	private WebElement ConfimedreasonTextField_PendingCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']//table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumberInTable_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='confirmedCreditCancel']//table/tbody/tr[1]/td[6]")
	private WebElement cancelledAmountInTable_ConfirmedCreditCancelList;

	@FindBy(xpath = "//div[@id='refundconfirm']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement hospitalNumber_RefundedList;

	@FindBy(xpath = "(//table[@id='example']/tbody[1]/tr[1]/td[4])[1]")
	private WebElement serviceName_Popup;

	@FindBy(xpath = "(//button[text()=' Cancel'])[1]")
	private WebElement cancelBtn_PopUP;

	// --- Buissness logics ---
	public void concessionAuthorizationScreen(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		clickOnTheElementUsedToJavascriptExecuter(driver, concessionRefundAuthorizationScreenBtn);
	}

	public void searchHopsitalNumber(WebDriver driver, String hospitalNumber) throws Throwable {
		scrollToTop(driver);
		hospitalNumberFilterField.sendKeys(hospitalNumber);
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
	}

	public String verifyServiceNamesInConcessionList(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, hospitalNumber_ConcessionList);
		hospitalNumber_ConcessionList.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String sn = serviceNameInConcessionPopUp.getText();
		xBtnToClosePopup.click();
		return sn;
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberFilterField.clear();
		hospitalNumberFilterField.sendKeys(hospitalNumber);
	}

	public void clickOnSearchBtn(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		searchBtn.click();
	}

	public void enterBillNumber_Filter(WebDriver driver, String billNumber) {
		billNoFilterField.sendKeys(billNumber);
	}

	public String captureConcessionStatusInConcessionList(WebDriver driver) throws Throwable {

		scrollTillVisibleElement(driver, concessionStatus_ConcessionList);
		invisibiltyOf_Element_ThreeDots(driver);
		String status = concessionStatus_ConcessionList.getText();
		return status;
	}

	public void clickOnHospitalNumberInConcessionList(WebDriver driver) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		hospitalNumber_ConcessionList.click();
	}

	public void ClickOnSubmitAfterSelectingAuthorizationStatus(WebDriver driver, String authorizationStatus,
			String reason) throws Throwable {

		authorizationStatusDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, authorizationStatus);
		ConfimedreasonTextField.sendKeys(reason);
		submitBtn.click();
		okBtnForPopUp.click();
	}

	public void clearHospitalNumberTextField(WebDriver driver) throws Throwable {

		hospitalNumberFilterField.clear();
	}

	public void clickOnConfirmedList(WebDriver driver) throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, confirmedConcessionListTab);
		confirmedConcessionListTab.click();

		confirmedConcessionListTab.click();
	}

	public String captureHospitalNumberInConfirmedConcessionList(WebDriver driver) throws Throwable {

		Thread.sleep(1000);
		scrollTillVisibleElement(driver, hospitalNumber_ConfirmedConcessionList);
		String hospitalNumber = hospitalNumber_ConfirmedConcessionList.getText();
		return hospitalNumber;
	}

	public void clickOnConcessionList(WebDriver driver) throws Throwable {
		concessionListTab.click();
	}

	public void clickOnClearBtn(WebDriver driver) throws Throwable {
		scrollToTop(driver);
		clearBtn.click();
	}

	public void verifyNextBtnIsWorkingAsExpectedInConcessionList(WebDriver driver) throws Throwable {

		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) {
			WebElement lastSlNo = listOfSerialnoInConcessionList.get(listOfSerialnoInConcessionList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			nextBtnInConcessionList.click();
			Thread.sleep(2500);
			String ls1 = slNo_ConcessionList.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyNextBtnIsWorkingAsExpectedInConfirmedList(WebDriver driver) throws Throwable {

		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) {
			WebElement lastSlNo = listOfSerialnoInConfirmedList.get(listOfSerialnoInConfirmedList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			nextBtnInConfirmedList.click();
			Thread.sleep(2500);
			String ls1 = slNo_ConFirmedList.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpectedInConcessionList(WebDriver driver) throws Throwable {

		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(500);
			scrollToBottom(driver);
			nextBtnInConcessionList.click();
		}
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(1000);
			String ls1 = slNo_ConcessionList.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			scrollToBottom(driver);
			previousBtnInConcessionList.click();
			Thread.sleep(1000);
			WebElement lastSlNo = listOfSerialnoInConcessionList.get(listOfSerialnoInConcessionList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpectedInConFirmedList(WebDriver driver) throws Throwable {

		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(500);
			scrollToBottom(driver);
			nextBtnInConfirmedList.click();
		}
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(1000);
			String ls1 = slNo_ConFirmedList.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			scrollToBottom(driver);
			invisibiltyOf_Element_ThreeDots(driver);
			previousBtnInConfirmedList.click();
			invisibiltyOf_Element_ThreeDots(driver);
			WebElement lastSlNo = listOfSerialnoInConfirmedList.get(listOfSerialnoInConfirmedList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public void selectAuthorizationStatus(WebDriver driver, String authorizationStatus) throws Throwable {
		Thread.sleep(500);
		authorizationStatusDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, authorizationStatus);
	}

	public String verifyReasonErrorPopUPMsg(WebDriver driver) throws Throwable {
		submitBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
		String errorMsg = reasonErrorMsg.getText();
		reasonErrorMsg.click();
		return errorMsg;
	}

	public void allAuthorizationProcess(WebDriver driver, String hospitalNumber, String authorizationStatus,
			String reason) throws Throwable {

		int i = 0;
		while (i < 3) {
			clearHospitalNumberTextField(driver);
			searchHopsitalNumber(driver, hospitalNumber);
			clickOnHospitalNumberInConcessionList(driver);
			ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus, reason);
			i++;
		}
	}

	public String verifyEditConcessionAmount(WebDriver driver, String conAmount) throws Throwable {

		editConcessionBtn_ConcessionList.click();

		updateConcessionTextFeild.clear();
		updateConcessionTextFeild.sendKeys(conAmount);

		tickBtn_concessionList.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(800);
		String ca = concessionAmount_ConcessionList.getText();
		String[] parts = ca.split("\\.");
		String ca1 = parts[0];
		return ca1;
	}

	public String takeHospitalNumber_ConcessionList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_ConcessionList.getText();
		return hospitalNumber;
	}

	public String takeBillNumber_ConcessionList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String billNumber = billNumber_ConcessionList.getText();
		return billNumber;
	}

	public String patientName_ConcessionList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientName = patientName_ConcessionList.getText();
		return patientName;
	}

	public String takeDepartmentName_ConcessionList() throws Throwable {

		Thread.sleep(2000);
		String departmentName = departmentName_ConcessionList.getText();
		return departmentName;
	}

	public String takeBillAmount_ConcessionList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String billAmount = billAmount_ConcessionList.getText();
		return billAmount;
	}

	public String takeConcessionAmount_ConcessionList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String concessionAmount = concessionAmount_ConcessionList.getText();
		return concessionAmount;
	}

	public String takeBalanceAmount_ConcessionList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String balanceAmount = balanceAmount_ConcessionList.getText();
		return balanceAmount;
	}

	public void editConcession_ConcessionList(WebDriver driver, String editConcessionAmount) {
		editConcessionBtn_ConcessionList.click();
		editConcessionAmountText.sendKeys(editConcessionAmount);
		concessionEditRightMark_ConcessionList.click();
	}

	public void selectConcessionTypeDropdwon(WebDriver driver, String concessionType) {
		dropdown_Handling(driver, 5, concessionTypeDropDownFilterBtn, dropDownText, concessionType);
	}

	public void clickOnRefundListRadioBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		refundListRadioBtn.click();
	}

	public void selectRefundTypeDropdwon(WebDriver driver, String refundType) {
		dropdown_Handling(driver, 5, refundTypeDropDownBtn, dropDownText, refundType);
	}

	public String captureHospitallNumberInPendingRefundList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumberInTable_PendingRefundList.getText();
		return hospitalNumber;
	}

	public void clickOnBillNumberInRefundPendinglist(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, billNumberInTable_PendingRefundList);
		billNumberInTable_PendingRefundList.click();
	}

	public void enterReason(WebDriver driver, String reason) {
		ConfimedreasonTextField.sendKeys(reason);
	}

	public void clickOnConfirmedRefundListTab(WebDriver driver) {
		confirmedRefundListTab.click();

	}

	public String captureHospitallNumberInConfirmedRefundList(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumberInTable_ConfirmedRefundList);
		String hospitalNumber = hospitalNumberInTable_ConfirmedRefundList.getText();
		return hospitalNumber;
	}

	public void clickOnCancelListRadioBtn(WebDriver driver) {
		cancelListRadioBtn.click();
	}

	public void selectCancelsTypeDropdwon(WebDriver driver, String cancel) {
		dropdown_Handling(driver, 5, cancelTypesDropDownBtn, dropDownText, cancel);
	}

	public void clickOnBillNumberInPendingCreditCancellist(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollTillVisibleElement(driver, billNumberInTable_PendingCreditCancelList);
		billNumberInTable_PendingCreditCancelList.click();
	}

	public void selectAuthorizationStatus_PendingCreditCancelList(WebDriver driver, String authorizationStatus)
			throws Throwable {
		Thread.sleep(500);
		dropdown(driver, authorizationStatusDropDownBtn_PendingCreditCancelList, dropDownText, authorizationStatus);
	}

	public void enterReason_pendingCreditCancelList(WebDriver driver, String reason) {
		ConfimedreasonTextField_PendingCreditCancelList.sendKeys(reason);
	}

	public void clickOnConfirmedCreditCancelListTab(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		confirmedCreditCancelListTab.click();
	}

	public String captureHospitallNumberInConfirmedCreditCancelList(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumberInTable_ConfirmedCreditCancelList);
		String hospitalNumber = hospitalNumberInTable_ConfirmedCreditCancelList.getText();
		return hospitalNumber;
	}

	public String captureCancelledAmountInConfirmedCreditCancelList(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		scrollDownThePageUntilElementIsVisible(driver, cancelledAmountInTable_ConfirmedCreditCancelList);
		String hospitalNumber = cancelledAmountInTable_ConfirmedCreditCancelList.getText();
		double d = Double.parseDouble(hospitalNumber);
		String d1 = String.format("%.2f", d);
		return d1;
	}

	public void clickOnHospitalNumberInRefundedList(WebDriver driver) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		hospitalNumber_RefundedList.click();
	}

	public String captureServiceName_PopUp(WebDriver driver) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		String text = serviceName_Popup.getText();
		return text;
	}

	public void clickOnCancelBtn_PopPU(WebDriver driver) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		cancelBtn.click();
	}
}
