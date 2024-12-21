package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
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

public class Hospital_Service_Bill_page extends WebDriverUtility {

	public Hospital_Service_Bill_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Hospital Service Bill ']")
	private WebElement hospitalServiceBillLink;

	@FindBy(xpath = "//a[normalize-space(text())='Pending']")
	private WebElement PendingList;

	@FindBy(xpath = "//a[normalize-space(text())='Completed']")
	private WebElement CompletedList;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindAll({ @FindBy(xpath = "//label[text()='Hospital Number']/following-sibling::input"),
			@FindBy(xpath = "//input[@placeholder='Hospital Number']") })
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumber_Filerts;

	@FindBy(xpath = "//input[@placeholder='Bill Number']")
	private WebElement billNumber;

	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c80-0']")
	private WebElement billdate;

	@FindBy(xpath = "(//span[@role='presentation'])[1]")
	private WebElement transactionTypeDropdown;

	@FindBy(xpath = "//span[@title='CASH']/following-sibling::span[1]")
	private WebElement transactionTypeDropdown_NewBill;

	@FindBy(xpath = "//span[text()='OP']/following-sibling::span")
	private WebElement billTypedropdown;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchbutton;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton_Filters;

	@FindAll({ @FindBy(xpath = "//button[text()='Clear']"), @FindBy(xpath = "(//button[@type='button'])[3]"),
			@FindBy(xpath = "//i[@class='zmdi zmdi-close']"), @FindBy(xpath = "//button[@type='button']//i[1]") })
	private WebElement clearbutton;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement hospitalnumber_PendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement billnumber_PendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[4]/td[2]")
	private WebElement billnumber_FourthPlace_PendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billDate_pendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement patientName_pendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement opNumber_pendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement patientType_pendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement patientCategory_pendingTable;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement concessionStatus_pendingTable;

	// COMPLETED LIST XPATHS
	@FindBy(xpath = "//span[text()='CASH']/following-sibling::span")
	private WebElement completedlist_Transactionlisttext;
	@FindBy(xpath = "//span[text()='OP']/following-sibling::span")
	private WebElement completedlist_Billtypetext;
	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement completedlist_Hospitalnumtext;
	@FindBy(xpath = " //input[@placeholder='Bill Number']")
	private WebElement completed_list_Billnumtext;
	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement completed_Billnumbertable;
	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement completed_Hospitalnumbertable;

	// XPATHS FOR THE NEW BILL
	@FindAll({ @FindBy(xpath = "//button[normalize-space(text())='New Bill']"),
			@FindBy(xpath = "//i[@class='zmdi zmdi-plus-circle']") })
	private WebElement newbillButton;

	@FindBy(xpath = "//span[text()='OP']")
	private WebElement BillTypeNew;

	@FindBy(xpath = "//span[text()='CASH']/following-sibling::span ")
	private WebElement transactiontypeNew;

	@FindBy(xpath = "//span[@title='Credit To']/following-sibling::span[1]")
	private WebElement credtiToDropdownBtn;

	@FindBy(xpath = "//span[@title='Credit To']")
	private WebElement Creditedto_text;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalnumber_new;
	@FindBy(xpath = "//span[@title='HOSPITAL RATE']")
	private WebElement HospitalRateText;
	@FindBy(xpath = "//input[@formcontrolname='transactionDate']")
	private WebElement Billdatenew;
	@FindBy(xpath = "(//span[text()='CASH']/following-sibling::span)[2]")
	private WebElement paymentMode;

	@FindBy(xpath = "(//button[normalize-space(text())='Submit'])[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "(//button[text()=' Cancel'])[1]")
	private WebElement cancelBtn;

	@FindBys({
			@FindBy(xpath = "//table[@class='table table-responsive-md row-border hover']/tbody/tr[position()>1]/td[6]/descendant::input[@placeholder='Rate']") })
	private List<WebElement> serviceRates;

	@FindBys({ @FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialnoInCompletedList;

	@FindBys({ @FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialnoInPendingList;

	@FindBy(xpath = "//input[@placeholder='Total Amount']")
	private WebElement total_Amount;

	@FindBy(xpath = "//input[@placeholder='Bill Amount']")
	private WebElement bill_Amount;

	@FindBy(xpath = "//input[@formcontrolname='collectedAmount']")
	private WebElement collection_Amount;

	@FindAll({ @FindBy(xpath = "//button[text()='OK']") })
	private WebElement okBtnForSuccessfullPopUp;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement okBtnSuccessfullySuspendedPoup;

	@FindBy(xpath = "//a[normalize-space(text())='Completed']")
	private WebElement completedTab;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement BillNumberInTableUnderCompletedTab_FirstRow;

	@FindBy(xpath = "//input[@placeholder='Service Names']")
	private WebElement serviceNameTextField;

	@FindAll({ @FindBy(xpath = "//button[@type='button']/descendant::i[@class='zmdi zmdi-plus']"),
			@FindBy(xpath = "//i[@class='zmdi zmdi-plus']"), @FindBy(xpath = "(//button[@type='button']//i)[1]") })
	private WebElement addBtnForServices;

	@FindBy(xpath = "(//a[@class='ng-star-inserted'])[1]")
	private WebElement firstElementInSuggestionBox;

	@FindAll({ @FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[5]"),
			@FindBy(xpath = "(//td[@class='ng-star-inserted']/following-sibling::td)[1]") })
	private WebElement hospitalNumber_CompletedBillingList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement opNumber_CompletedBillingTest;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billNumber_CompletedList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement billType_CompltedList;

	@FindBy(xpath = "//label[text()='Concession On']/..//span[@role='presentation']")
	private WebElement concessionOnDropdownBtn;

	@FindBy(xpath = "//span[@title='Authorization']/following-sibling::span")
	private WebElement authorizationDropdownBtn;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[1]")
	private WebElement externaleLabRadioBtn;

	@FindBy(xpath = "//input[@placeholder='Bill Amount']")
	private WebElement billAmount_BillingDetails;

	@FindBy(xpath = "//input[@formcontrolname='totalDiscountAmount']")
	private WebElement totalDiscountAmount_BillingDetails;

	@FindBy(xpath = "//input[@placeholder='Concession Amount']")
	private WebElement concessionAmount_BillingDetails;

	@FindBy(xpath = "//input[@placeholder='Round Off']")
	private WebElement roundOff_BillingDetails;

	@FindBy(xpath = "(//input[@placeholder='Collected Amount'])[1]")
	private WebElement collectedAmount_BillingDetails;

	@FindBy(xpath = "//input[@placeholder='Balance Amount']")
	private WebElement balanceAmount_BillingDetails;

	@FindBy(xpath = "//span[@id='select2-0obc-container']/following-sibling::span[1]")
	private WebElement visitNumberDropdownData;

	@FindBy(xpath = "(//span[@title='CASH']/following-sibling::span)[2]")
	private WebElement ssinglePayment_ModeDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='Balance Amount']")
	private WebElement balanceAmount;

	@FindBy(xpath = "(//button[@type='button']//i)[2]")
	private WebElement deleteBtnForFirstRowService;

	@FindBy(xpath = "(//input[@placeholder='Rate'])[2]")
	private WebElement serviceRateField_FirstRow;

	@FindBy(xpath = "(//input[@placeholder='Quantity'])[1]")
	private WebElement quantityTextField;

	@FindBy(xpath = "(//input[@placeholder='Net Amount'])[1]")
	private WebElement netAmountField;

	@FindBy(xpath = "//div[text()='Please Enter Mandatory Field']")
	private WebElement errorPopText_AddingService;

	@FindBy(xpath = "//u[text()='Hospital Service Bill']")
	private WebElement hospitalServiceBill_BedCrums;

	@FindBy(xpath = "//a[contains(text(),'Refund Request')]")
	private WebElement refundRequest_BedCrums;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Concession')]"),
			@FindBy(xpath = "(//li[@class='breadcrumb-item active']//a)[1]"), @FindBy(linkText = "Concession") })
	private WebElement concession_BedCrums;

	@FindBy(xpath = "//a[contains(text(),'Process Refund')]")
	private WebElement processRefund_BedCrums;

	@FindBy(xpath = "//h2[text()=' Hospital Service Bill ']")
	private WebElement hospitalServiceBilltextInHeader;

	@FindBy(xpath = "//h2[text()='Refund Request ']")
	private WebElement refundRequestTextInHeader;

	@FindBy(xpath = "//h2[text()='Authorization ']")
	private WebElement concessionTextInHeader;

	@FindBy(xpath = "//h2[text()='Process Refund ']")
	private WebElement processRefundTextInHeader;

	@FindBy(xpath = "(//span[@title='Card Type']/following-sibling::span)[1]")
	private WebElement ssinglePayment_CreditCardTypeDropdownBtn;

	@FindBy(xpath = "(//input[@placeholder='Card Number'])[1]")
	private WebElement singlePayment_CreditCardNumberText;

	@FindBy(xpath = "(//input[@placeholder='Service Charge'])[1]")
	private WebElement singlePayment_CreditServiceChargeText;

	@FindBy(xpath = "(//input[@placeholder='Terminal Id'])[1]")
	private WebElement singlePayment_CreditTerminalText;

	@FindBy(xpath = "(//input[@placeholder='Batch Number'])[1]")
	private WebElement singlePayment_CreditBatchNumberText;

	@FindBy(xpath = "(//input[@placeholder='Card Expiry'])[1]")
	private WebElement singlePayment_CreditCardExpiryText;

	@FindBy(xpath = "(//input[@placeholder='Reference Number'])[1]")
	private WebElement singlePayment_CreditReferenceNumberText;

	@FindBy(xpath = "(//input[@placeholder='Card Holder Mobile Number'])[1]")
	private WebElement singlePayment_CreditCardHolderMobileNumberText;

	@FindBy(xpath = "(//input[@placeholder='Card Holder Name'])[1]")
	private WebElement singlePayment_CreditCardHolderNameText;

	@FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[2]")
	private WebElement multiplePaymentModeBtn;

	@FindBy(xpath = "(//input[@placeholder='Cheque Number'])[1]")
	private WebElement singlePayment_ChequeNumberText;

	@FindBy(xpath = "(//input[@placeholder='Approval Amount'])[2]")
	private WebElement singlePayment_ChequeApprovalAmountText;

	@FindBy(xpath = "(//input[@placeholder='Drawee Bank'])[1]")
	private WebElement singlePayment_ChequeDraweeBankText;

	@FindBy(xpath = "(//input[@placeholder='Cheque Owner Name'])[1]")
	private WebElement singlePayment_ChequeOwnerNameText;

	@FindBy(xpath = "(//input[@placeholder='Residing At'])[1]")
	private WebElement singlePayment_ChequeResidingAtText;

	@FindBy(xpath = "(//span[@title='Relation with patient']/following-sibling::span)[1]")
	private WebElement singlePayment_ChequeRelationWithPatientDropdown;

	@FindBy(xpath = "(//input[@placeholder='Mobile Number'])[1]")
	private WebElement singlePayment_ChequeMobileNumberText;

	@FindBy(xpath = "(//input[@placeholder='Police station'])[1]")
	private WebElement singlePayment_ChequePoliceStationText;

	@FindBy(xpath = "(//input[@placeholder='Branch Name'])[1]")
	private WebElement singlePayment_ChequeBranchNameText;

	@FindBy(xpath = "(//input[@placeholder='DD Number'])[1]")
	private WebElement singlePayment_DDNumberText;

	@FindBy(xpath = "(//input[@placeholder='Amount'])[2]")
	private WebElement singlePayment_DDAmountText;

	@FindBy(xpath = "(//input[@placeholder='Drawee Bank'])[2]")
	private WebElement singlePayment_DDDraweeBankText;

	@FindBy(xpath = "(//input[@placeholder='Branch Name'])[2]")
	private WebElement singlePayment_DDBranchNameText;

	@FindBy(xpath = "(//input[@placeholder='Signatory 1 code'])[1]")
	private WebElement singlePayment_DDSignatoryOneCode;

	@FindBy(xpath = "(//input[@placeholder='Signatory 2 code'])[1]")
	private WebElement singlePayment_DDSignatoryTwoCode;

	@FindBy(xpath = "(//input[@placeholder='Transfer Number'])[1]")
	private WebElement singlePayment_ElectronicMoneyTransferNumberText;

	@FindBy(xpath = "(//input[@placeholder='Transfer Date'])[1]")
	private WebElement singlePayment_ElectronicMoneyTransferTransferDateText;

	@FindBy(xpath = "(//input[@placeholder='Amount'])[1]")
	private WebElement singlePayment_ElectronicMoneyTransferAmountText;

	@FindBy(xpath = "(//input[@placeholder='Transfer From Bank'])[1]")
	private WebElement singlePayment_ElectronicMoneyTransferTransferFromBankText;

	@FindBy(xpath = "(//input[@placeholder='Transfer To Bank'])[1]")
	private WebElement singlePayment_ElectronicMoneyTransferTransferToBankText;

	@FindBy(xpath = "(//span[@title='Payment Mode']/following-sibling::span)[1]")
	private WebElement firstPayment_DropdownBtn;

	@FindBy(xpath = "(//input[@placeholder='Transfer Number'])[2]")
	private WebElement firstPayment_ElectronicMoneyTransferNumberText;

	@FindBy(xpath = "(//label[text()='Transfer Date']/following-sibling::input)[2]")
	private WebElement firstPayment_ElectronicMoneyTransferDaterText;

	@FindBy(xpath = "(//input[@placeholder='Amount'])[3]")
	private WebElement firstPayment_ElectronicMoneyTransferAmountText;

	@FindBy(xpath = "(//input[@placeholder='Transfer From Bank'])[2]")
	private WebElement firstPayment_ElectronicMoneyTransferFromBankText;

	@FindBy(xpath = "(//input[@placeholder='Transfer To Bank'])[2]")
	private WebElement firstPayment_ElectronicMoneyTransferToBankText;

	@FindBy(xpath = "(//span[@title='Mobile Wallet Type']/following-sibling::span)[2]")
	private WebElement firstPayment_MobileWalletTypeDropdown;

	@FindBy(css = "input.form-control.referenceNumberMobileFirst")
	private WebElement firstPayment_MobileWalletReferencNumberText;

	@FindBy(css = "input.form-control.phoneNumberMobileFirst")
	private WebElement firstPayment_MobileWalletPhoneNumberText;

	@FindBy(xpath = "input.form-control.collectedAmountMobileFirst")
	private WebElement firstPayment_MobileWalletColllectedAmount;

	@FindBy(xpath = "//span[@title='Payment Mode']/following-sibling::span[1]")
	private WebElement secondPayment_DropdownBtn;

	@FindBy(xpath = "(//span[@title='Card Type']/following-sibling::span)[3]")
	private WebElement secondPayment_CreditCardTypeDropdown;

	@FindBy(xpath = "(//input[@placeholder='Card Number'])[3]")
	private WebElement secondPayment_CreditCardNumber;

	@FindBy(xpath = "((//label[text()='Card Type'])[3]/following::input)[2]")
	private WebElement secondPayment_CreditApprovalAmount;

	@FindBy(xpath = "(//input[@placeholder='Service Charge'])[3]")
	private WebElement secondPayment_CreditServiceCharge;

	@FindBy(xpath = "(//input[@placeholder='Terminal Id'])[3]")
	private WebElement secondPayment_CreditTerminalId;

	@FindBy(xpath = "(//input[@placeholder='Batch Number'])[3]")
	private WebElement secondPayment_CreditBatchNumber;

	@FindBy(xpath = "(//input[@placeholder='Card Expiry'])[3]")
	private WebElement secondPayment_CreditCardExpiry;

	@FindBy(css = "input.form-control.referenceNumberMultiSecondT")
	private WebElement secondPayment_CreditReferenceNumber;

	@FindBy(css = "input.form-control.phoneNumberMultiSecondCard")
	private WebElement secondPayment_CreditCardHolderMobileNumber;

	@FindBy(css = "input.form-control.cardHolderNameMultiSecond")
	private WebElement secondPayment_CreditCardHolderName;

	@FindBy(css = "input.form-control.multiSecondChequeNumber")
	private WebElement secondPayment_ChequeNumber;

	@FindBy(xpath = "((//label[text()='Cheque date'])[3]/following::input)[1]")
	private WebElement secondPayment_ChequeDate;

	@FindBy(css = "input.form-control.multiSecondcollectedAmount")
	private WebElement secondPayment_ChequeApprovalAmount;

	@FindBy(xpath = "((//label[text()='Drawee bank'])[3]/following::input)[1]")
	private WebElement secondPayment_ChequeDraweeBank;

	@FindBy(xpath = "(//input[@placeholder='Cheque Owner Name'])[3]")
	private WebElement secondPayment_ChequeOwnerName;

	@FindBy(xpath = "(//input[@placeholder='Residing At'])[3]")
	private WebElement secondPayment_ChequeResidingAt;

	@FindBy(xpath = "(//span[@title='Relation with patient']/following-sibling::span)[3]")
	private WebElement secondPayment_ChequeRelationWithPatientDropdown;

	@FindBy(xpath = "(//input[@placeholder='Mobile Number'])[3]")
	private WebElement secondPayment_ChequeMobileNumber;

	@FindBy(xpath = "(//input[@placeholder='Police station'])[3]")
	private WebElement secondPayment_ChequePoliceStation;

	@FindBy(xpath = "(//input[@placeholder='Branch Name'])[5]")
	private WebElement secondPayment_ChequeBranchName;

	@FindBy(xpath = "(//input[@placeholder='DD Number'])[3]")
	private WebElement secondPayment_DDNumber;

	@FindBy(xpath = "(//input[@placeholder='DD Date'])[3]")
	private WebElement secondPayment_DDDate;

	@FindBy(xpath = "((//label[text()='DD number'])[3]/following::input)[3]")
	private WebElement secondPayment_DDAmount;

	@FindBy(xpath = "((//label[text()='Drawee Bank'])[3]/following::input)[1]")
	private WebElement secondPayment_DDDraweeBank;

	@FindBy(xpath = "(//input[@placeholder='Branch Name'])[6]")
	private WebElement secondPayment_DDBranchName;

	@FindBy(xpath = "//input[@placeholder='Signatory 1 code ']")
	private WebElement secondPayment_DDSignatoryOneCode;

	@FindBy(xpath = "(//input[@placeholder='Signatory 2 code'])[3]")
	private WebElement secondPayment_DDSignotoryTwoCode;

	@FindBy(xpath = "(//input[@placeholder='Transfer Number'])[3]")
	private WebElement secondPayment_ElectronicMoneyTrasnferNumber;

	@FindBy(xpath = "(//input[@placeholder='Transfer Date'])[2]")
	private WebElement secondPayment_ElectronicMoneyTrasnferDate;

	@FindBy(css = "input.form-control.collectedAmountMyltiSecondE")
	private WebElement secondPayment_ElectronicMoneyTrasnferAmount;

	@FindBy(css = "input.form-control.transferFromBankMultiSecond")
	private WebElement secondPayment_ElectronicMoneyTrasnferFromBank;

	@FindBy(css = "input.form-control.transferToBankMultiSecond")
	private WebElement secondPayment_ElectronicMoneyTrasnferToBank;

	@FindBy(xpath = "(//input[@placeholder='Collected Amount'])[3]")
	private WebElement firstPaymentMode_CashCollectedAmountText;

	@FindBy(xpath = "(//input[@placeholder='Clinic Note'])[1]")
	private WebElement clinicalNotesField;

	@FindBy(xpath = "(//input[@placeholder='Balance Amount To Pay'])[1]")
	private WebElement firstPaymentMode_CashBalanceAmountToPay;

	@FindBy(xpath = "//input[@placeholder='Package Names']")
	private WebElement packageNameText_PackageListTable;

	@FindBy(xpath = "(//table[@id='myTableElementId']/tbody/tr[1]/td[2])[2]")
	private WebElement departmentNameConsultationList;

	@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr[1]/td/descendant::span[@title='Department Unit']/following-sibling::span")
	private WebElement departmentUnitDropdwon_ConsulationList;

	@FindBy(xpath = "(//table[@id='myTableElementId']/tbody/tr[1]/td[4])[2]")
	private WebElement unitChiefName_ConsultationList;

	@FindBys({ @FindBy(xpath = "(//table[@id='myTableElementId'])[2]/tbody/tr/td[2]") })
	private List<WebElement> departmentNameSConsultationList;

	@FindBys({
			@FindBy(xpath = "//table[@id='myTableElementId']/tbody/tr/td/descendant::span[@title='Department Unit']/following-sibling::span") })
	private List<WebElement> departmentUnitDropdwonBtnsConsulationList;

	@FindBys({ @FindBy(xpath = "(//table[@id='myTableElementId'])[2]/tbody/tr/td[4]") })
	private List<WebElement> unitChiefNames_ConsultationList;

	@FindBys({ @FindBy(xpath = "//table[@class='table table-responsive-md row-border hover']/tbody/tr/td[2]") })
	private List<WebElement> listOfServiceNames;

	@FindBy(xpath = "//button[text()='Send For Approval']")
	private WebElement sendForApprovalBtn;

	@FindBy(xpath = "//label[text()='Reason']/following::textarea")
	private WebElement ReasonForConcession;

	@FindBy(xpath = "(//button[text()=' Submit']//i)[3]")
	private WebElement submit_ReasonForConcession_Popup;

	@FindBy(xpath = "(//button[text()=' Cancel'])[2]")
	private WebElement cancel_ReasonForConcession_Popup;

	@FindBy(xpath = "//div[text()='Please Select Authorization ']")
	private WebElement pleaseSelectAuthorizationPopupMsg;

	@FindBy(xpath = "//input[@data-placement='top']/following-sibling::span[1]")
	private WebElement eyeIconUnderClinicalNotes;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement notesUnderEyeIcon;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement TextForDuplicateDervicePopup;

	@FindBy(xpath = "//div[text()='patient already admitted']")
	private WebElement TextForIpPatientePopup;

	@FindBy(xpath = "//div[text()='Patient is Not Found in General Ip']")
	private WebElement errorMsg_PatientNotFoundInGeneralIp;

	@FindBy(xpath = "(//a[@aria-label='Next page'])[2]")
	private WebElement nextBtnInCompletedList;

	@FindBy(xpath = "(//li//a[@aria-label='Next page'])[1]")
	private WebElement nextBtnInPendingList;

	@FindBy(xpath = "(//a[@aria-label='Previous page'])[2]")
	private WebElement PreviousBtnInCompletedList;

	@FindBy(xpath = "(//a[@aria-label='Previous page'])[1]")
	private WebElement PreviousBtnInPendingList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[1]")
	private WebElement slNo_CompletedList;

	@FindBy(xpath = "//div[@id='Approved_Bill']/descendant::table/tbody/tr[1]/td[1]")
	private WebElement slNo_PendingList;

	@FindBy(xpath = "//div[@aria-label='Please Select Payment Mode']")
	private WebElement errorTextForPaymentmode;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='History']//tr[last()]/td[5]")
	private WebElement lastRow_hospitalNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billNumberNumberInTable_CompletedList;

	@FindBy(xpath = "(//div[contains(@class,'col-lg-6 col-md-6')])[3]")
	private WebElement OpNumber_patientDetails;

	@FindBy(xpath = "(//label[contains(@class,'form-group col-lg-12')])[1]")
	private WebElement patientName_patientDetails;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement patientName_completedList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement opNumber_completedList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement billAmount_completedList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement collectedAmount_completedList;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement transactionType_completedList;

	@FindBy(xpath = "(//span[@role='presentation'])[2]")
	private WebElement billTypeDropDownBtn;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement billDateBtn;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement billDate_completedList;

	@FindBy(xpath = "//div[text()='OP BILL NOT ALLOWED AFTER 24 HOURS']")
	private WebElement ErrorMsg_24hrs;

	@FindBy(xpath = "//div[@aria-label='Concession amount can not be greater the bill amount']")
	private WebElement ErrorMsg_concessionAmtGreaterThanBillAmt;

	@FindBy(xpath = "//table[@class='table table-responsive-md row-border hover']/tbody/tr[2]/td[2]")
	private WebElement serviceName;

	@FindBy(xpath = "//input[contains(@class,'form-control concessionArrayClass')]")
	private WebElement concessionPrecentageField;

	@FindBy(xpath = "(//button[text()=' Actions '])[1]")
	private WebElement actionBtn_table;

	@FindBy(xpath = "(//button[@data-target='#CancelOpd'])[1]")
	private WebElement cancelBill_Action;

	@FindBy(xpath = "//sup[@class='text-danger']/following-sibling::textarea[1]")
	private WebElement ReasonForConcession_cancelPopup_CompletedList;

	@FindBy(xpath = "//span[@title='CASH']/following-sibling::span[1]")
	private WebElement paymentModeDropDownBtn;

	@FindAll({ @FindBy(xpath = "(//button[text()=' Submit'])[2]"),
			@FindBy(xpath = "(//i[@class='zmdi zmdi-card-sd'])[2]") })
	private WebElement submitBtn_cancelPopup;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement okBtnText;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[14]//a")
	private WebElement cancelledStatus_CompletedList;

	/*
	 * Business Logics
	 * 
	 */

	public void enterHospitalNumber(String hospitalNumber) throws InterruptedException {
		Thread.sleep(1500);
		hospitalNumberText.sendKeys(hospitalNumber, Keys.TAB);
	}

	public void clickOnSarch(WebDriver driver) throws Throwable {
		searchbutton.click();
	}

	public void selectBillType(WebDriver driver, String BillType) throws Throwable {
		dropdown_Handling(driver, 3, billTypedropdown, dropdownText, BillType);
	}

	// Logics for completed list

	public void selectTransactionTypeCompletedList(WebDriver driver, String transactionTypeCompleted) {
		dropdown_Handling(driver, 6, completedlist_Transactionlisttext, dropdownText, transactionTypeCompleted);
	}

	public void enterHospitalNumberCompleted(WebDriver driver, String hospitalNumberCompleted) {
		explictWaitForElementToBeVisible(driver, completedlist_Hospitalnumtext);
		completedlist_Hospitalnumtext.sendKeys(hospitalNumberCompleted);
	}

	public void selectBillTypeCompleted(WebDriver driver, String BillTypeCompleted) {
		completedlist_Billtypetext.click();
		moveToElementAndEnterTheData(driver, dropdownText, BillTypeCompleted);
	}

	public void clickOnSubmit(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver, submitBtn);
		scrollUntilElementVisible(driver, submitBtn);
		Thread.sleep(2000);
		submitBtn.click();
		Thread.sleep(5000);
		getWindowHandles(driver);
		invisibiltyOf_Element_ThreeDots(driver);
		okBtnForSuccessfullPopUp.click();
	}

	public String captureBillNoUnderCompletedTab(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String billNo = BillNumberInTableUnderCompletedTab_FirstRow.getText();
		return billNo;
	}

	public void addTheServicesRateAmounts(WebDriver driver) {
		int invetisgationsAmounts = 0;
		List<WebElement> list = serviceRates;
		for (WebElement webElement : list) {
			String rates = webElement.getAttribute("value");
			int i = Integer.parseInt(rates);
			invetisgationsAmounts = invetisgationsAmounts + i;

		}
		System.out.println("added inv amount : " + invetisgationsAmounts);
		scrollDownThePageUntilElementIsVisible(driver, collection_Amount);
		String CollectionAmount = collection_Amount.getAttribute("value");
		int collctedAmount = Integer.parseInt(CollectionAmount);
		String tM = total_Amount.getAttribute("value");
		int totalAmount = Integer.parseInt(tM);

		scrollDownThePageUntilElementIsVisible(driver, bill_Amount);
		String BillAmount = bill_Amount.getAttribute("value");
		int Billamountcol = Integer.parseInt(BillAmount);
		System.out.println("Bill Amount  :" + Billamountcol);

		Assert.assertEquals(invetisgationsAmounts, collctedAmount);
		System.out.println("Investigation Amount equals to the collectd Amount ");

		Assert.assertEquals(invetisgationsAmounts, totalAmount);
		System.out.println("Collection amount is equals to Totalamount ");

		Assert.assertEquals(Billamountcol, totalAmount);
		System.out.println("Bill amount is equal to the total amount ");

	}

	public void clickonNewBillButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, newbillButton);
	}

	public void clickOnHospitalServiceBillLink(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, hospitalServiceBillLink);
	}

	public void selectMhcBillType(WebDriver driver) {
		dropdown_Handling(driver, 3, billTypedropdown, dropdownText, "MHC");
	}

	public void addServicesInOpBilling(WebDriver driver, String serviceName) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		explictWaitForElementToBeVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(serviceName);
		explictWaitForElementToBeVisible(driver, firstElementInSuggestionBox);
		firstElementInSuggestionBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2500);
		clickOnTheElementUsedToJavascriptExecuter(driver, addBtnForServices);
	}

	public void addServicesInOpBilling3(WebDriver driver, String serviceName) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		Thread.sleep(1000);
		explictWaitForElementToBeVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(serviceName);
		firstElementInSuggestionBox.click();
		Thread.sleep(2500);
		addBtnForServices.click();
		Thread.sleep(1500);
	}

	public void addServicesInOpBilling2(WebDriver driver, String sn1, String sn2, String sn3) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);

		serviceNameTextField.sendKeys(sn1);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		addBtnForServices.click();
		Thread.sleep(1000);
		serviceNameTextField.sendKeys(sn2);
		explictWaitForElementToBeVisible(driver, firstElementInSuggestionBox);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		addBtnForServices.click();
		Thread.sleep(1000);
		serviceNameTextField.sendKeys(sn3);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		addBtnForServices.click();
		Thread.sleep(1000);
	}

	public void OpBilling(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, newbillButton);
		Thread.sleep(2000);
		hospitalNumberText.sendKeys(hospitalNumber, Keys.TAB);
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
		Thread.sleep(6000);
		getWindowHandles(driver);
		okBtnForSuccessfullPopUp.click();
	}

	public void addListOfServicesInOpBilling(WebDriver driver, String sn1, String sn2, String sn3, String sn4,
			String sn5, String sn6) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		serviceNameTextField.sendKeys(sn1);
		invisibiltyOf_Element_ThreeDots(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		invisibiltyOf_Element_ThreeDots(driver);
		addBtnForServices.click();
		invisibiltyOf_Element_ThreeDots(driver);
		serviceNameTextField.sendKeys(sn2);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		addBtnForServices.click();
		invisibiltyOf_Element_ThreeDots(driver);
		serviceNameTextField.sendKeys(sn3);
		firstElementInSuggestionBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		addBtnForServices.click();
		invisibiltyOf_Element_ThreeDots(driver);
		serviceNameTextField.sendKeys(sn4);
		invisibiltyOf_Element_ThreeDots(driver);
		firstElementInSuggestionBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		addBtnForServices.click();
		invisibiltyOf_Element_ThreeDots(driver);
		serviceNameTextField.sendKeys(sn5);
		invisibiltyOf_Element_ThreeDots(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		invisibiltyOf_Element_ThreeDots(driver);
		addBtnForServices.click();
		serviceNameTextField.sendKeys(sn6);
		invisibiltyOf_Element_ThreeDots(driver);
		firstElementInSuggestionBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		addBtnForServices.click();
	}

	public void addOneServiceInTheOpBillin(WebDriver driver, String serviceName) throws Throwable {
		/// wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(serviceName);
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		firstElementInSuggestionBox.click();
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		moveToTheParticularElementAndClick(driver, addBtnForServices);
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
	}

	public void clickOnCompletedTab(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, completedTab);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String takeHospitalNumberCompletedBillingList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_CompletedBillingList.getText();
		return hospitalNumber;
	}

	public String takeOpNumber_CompletedBillingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String opNumber = opNumber_CompletedBillingTest.getText();
		return opNumber;

	}

	public void addServicesInThreeServicesInTheOpBilling(WebDriver driver, String sn1, String sn2, String sn3)
			throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		serviceNameTextField.sendKeys(sn1);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		addBtnForServices.click();
		Thread.sleep(1000);
		serviceNameTextField.sendKeys(sn2);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		addBtnForServices.click();
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		serviceNameTextField.sendKeys(sn3);
		firstElementInSuggestionBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		addBtnForServices.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
	}

	public String takeBillNumber_CompletedTable(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		String billNumber = billNumber_CompletedList.getText();
		return billNumber;
	}

	public String takeBillNumber_CompletedTable_ScrollUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		scrollUpUsingActions(driver);
		scrollUpUsingActions(driver);
		scrollUpUsingActions(driver);

		scrollDownThePageUntilElementIsVisible(driver, billNumber_CompletedList);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNumber = billNumber_CompletedList.getText();
		return billNumber;
	}

	public String takeBillType_CompletedTable(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		String billType = billType_CompltedList.getText();
		return billType;
	}

	public void verifyBalanceAmount(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		scrollDownTheStillEndOfThePage(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String tM = total_Amount.getAttribute("value");
		int totalAmount = Integer.parseInt(tM);
		System.out.println(totalAmount);

		String ca = collection_Amount.getAttribute("value");
		int collectedAmount = Integer.parseInt(ca);
		System.out.println(collectedAmount);

		int result = totalAmount - collectedAmount;
		System.out.println("calculated amount: " + result);

		String ba = balanceAmount.getAttribute("value");
		int balanceAmount = Integer.parseInt(ba);

		Assert.assertEquals(result, balanceAmount);
		System.out.println("balance amount: " + balanceAmount);
		System.out.println("Successfully balance amount is verified");
	}

	public void verifyTotalAmountIsGettingUpdatedAfterDeletingService(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String tM = total_Amount.getAttribute("value");
		int totalAmount = Integer.parseInt(tM);
		System.out.println("total amount: " + totalAmount);

		String sr = serviceRateField_FirstRow.getAttribute("value");
		int serviceRate = Integer.parseInt(sr);
		System.out.println("service rate: " + serviceRate);

		int result = totalAmount - serviceRate;
		System.out.println("result :" + result);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		deleteBtnForFirstRowService.click();

		String tM1 = total_Amount.getAttribute("value");
		int totalAmount1 = Integer.parseInt(tM1);
		System.out.println("total amount: " + totalAmount1);

		Assert.assertEquals(result, totalAmount1);
		System.out.println("successfully total amount is getting updated after services is deleted");
	}

	public void verifyNetAmountIsGettingUpdatedAfterChangingTheQuantity(WebDriver driver, String serviceName, String q)
			throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(serviceName);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String na = netAmountField.getAttribute("value");
		int netAmount = Integer.parseInt(na);
		System.out.println("Net amount before changing quantity : " + netAmount);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		quantityTextField.clear();
		quantityTextField.sendKeys(q);
		Thread.sleep(1000);
		int quantity = Integer.parseInt(q);

		String na1 = netAmountField.getAttribute("value");
		int netAmount1 = Integer.parseInt(na1);
		System.out.println("Net amount after changing quantity : " + netAmount1);

		int result = netAmount * quantity;
		System.out.println("calculated amount : " + result);

		Assert.assertEquals(netAmount1, result);
		System.out.println("succesfully net amount is getting updated after quantity is changed");
	}

	public String verifyErrorPopAddingServicesWithoutEnteringMandatoryData(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		addBtnForServices.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String errorPopup = errorPopText_AddingService.getText();
		okBtnForSuccessfullPopUp.click();
		return errorPopup;
	}

	public void SinglePaymentMode_Credit(WebDriver driver, String mode, String cardType, String serviceCharge,
			String cardExpiry) throws Throwable {

		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, ssinglePayment_ModeDropdownBtn);

		ssinglePayment_ModeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, ssinglePayment_CreditCardTypeDropdownBtn);

		ssinglePayment_CreditCardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, cardType);
		singlePayment_CreditCardNumberText.sendKeys("434231");
		singlePayment_CreditServiceChargeText.sendKeys(serviceCharge);
		singlePayment_CreditTerminalText.sendKeys("1212");
		singlePayment_CreditBatchNumberText.sendKeys("4342");
		singlePayment_CreditCardExpiryText.sendKeys(cardExpiry);
		singlePayment_CreditReferenceNumberText.sendKeys("43231");
		singlePayment_CreditCardHolderMobileNumberText.sendKeys("8768763526");
		singlePayment_CreditCardHolderNameText.sendKeys("TestEngineer");
	}

	public void addTheService(WebDriver driver, String sn1) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		explictWaitForElementToBeVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(sn1);
		scrollDownThePageUntilElementIsVisible(driver, firstElementInSuggestionBox);

		firstElementInSuggestionBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		addBtnForServices.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void addTheServiceOne(WebDriver driver, String sn1) throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(sn1);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(1500);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		addBtnForServices.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
	}

	public void clickOnSubmit_CloseWindow_OkBtn(WebDriver driver) throws Throwable {
		clickOnSubmit(driver);
	}

	public void clickOnSubmit_CloseWindow__RefundRequestProcess(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);

		moveToTheParticularElementAndClick(driver, submitBtn);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(3000);
		getWindowHandles(driver);

	}

	public void SinglePaymentMode_Cheque(WebDriver driver, String mode) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, ssinglePayment_ModeDropdownBtn);

		ssinglePayment_ModeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		singlePayment_ChequeNumberText.sendKeys("43321");
		singlePayment_ChequeDraweeBankText.sendKeys("2345");
		singlePayment_ChequeOwnerNameText.sendKeys("2345");
		singlePayment_ChequeResidingAtText.sendKeys("7554");
		scrollDownThePageUntilElementIsVisible(driver, singlePayment_ChequeRelationWithPatientDropdown);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		singlePayment_ChequeRelationWithPatientDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, "BROTHER");
		singlePayment_ChequeMobileNumberText.sendKeys("6543278290");
		singlePayment_ChequePoliceStationText.sendKeys("POLICE STATION");
		singlePayment_ChequeBranchNameText.sendKeys("Branch name");
	}

	public void SinglePaymentMode_DD(WebDriver driver, String mode) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, ssinglePayment_ModeDropdownBtn);

		ssinglePayment_ModeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, singlePayment_DDNumberText);
		singlePayment_DDNumberText.sendKeys("2424");
		singlePayment_DDDraweeBankText.sendKeys("4321");
		singlePayment_DDBranchNameText.sendKeys("Test env");
		singlePayment_DDSignatoryOneCode.sendKeys("321");
		singlePayment_DDSignatoryTwoCode.sendKeys("4321");
	}

	public void SinglePaymentMode_ElectronicsMoneyTransfer(WebDriver driver, String mode) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, ssinglePayment_ModeDropdownBtn);

		ssinglePayment_ModeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		scrollDownByUsingJavascriptExecuter(driver);
		singlePayment_ElectronicMoneyTransferNumberText.sendKeys("43535");
		singlePayment_ElectronicMoneyTransferTransferFromBankText.sendKeys("sai baba");
		singlePayment_ElectronicMoneyTransferTransferToBankText.sendKeys("Vydehi");
	}

	public String verifyHospitalServiceBedCrums(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		hospitalServiceBill_BedCrums.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String hsb = hospitalServiceBilltextInHeader.getText();
		return hsb;
	}

	public String verifyRefundRequestBedCrums(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		refundRequest_BedCrums.click();
		Thread.sleep(1000);
		String rr = refundRequestTextInHeader.getText();
		return rr;
	}

	public String verifyConcessionBedCrums(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);

		concession_BedCrums.click();
		Thread.sleep(1000);
		String c = concessionTextInHeader.getText();
		return c;
	}

	public String verifyProcessRefundtBedCrums(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);

		processRefund_BedCrums.click();
		Thread.sleep(1000);
		String pr = processRefundTextInHeader.getText();
		return pr;
	}

	public String verifyClinicalNotesUnderEyeIcon(WebDriver driver, String serviceName, String clinicalNotes)
			throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		Thread.sleep(1000);
		serviceNameTextField.sendKeys(serviceName);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		firstElementInSuggestionBox.click();
		Thread.sleep(2500);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clinicalNotesField.sendKeys(clinicalNotes);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		addBtnForServices.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		eyeIconUnderClinicalNotes.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(500);
		String clinicalNotes1 = notesUnderEyeIcon.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtnForSuccessfullPopUp.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		zoomInUsingActions(driver);
		return clinicalNotes1;
	}

	public String firstPaymentMode_AsCash(WebDriver driver, String mode, String amount) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, multiplePaymentModeBtn);
		multiplePaymentModeBtn.click();
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, firstPayment_DropdownBtn);

		firstPayment_DropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		scrollDownByUsingJavascriptExecuter(driver);
		firstPaymentMode_CashCollectedAmountText.sendKeys(amount);
		String balanceAmount = firstPaymentMode_CashBalanceAmountToPay.getText();
		return balanceAmount;
	}

	public void firstPaymentMode_AsElectronicMoneyTransfer(WebDriver driver, String mode, String amount) {
		scrollDownThePageUntilElementIsVisible(driver, multiplePaymentModeBtn);

		multiplePaymentModeBtn.click();
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, firstPayment_DropdownBtn);

		firstPayment_DropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		scrollDownByUsingJavascriptExecuter(driver);
		firstPayment_ElectronicMoneyTransferNumberText.sendKeys("121212");
		firstPayment_ElectronicMoneyTransferAmountText.sendKeys(amount);
		firstPayment_ElectronicMoneyTransferFromBankText.sendKeys("vydehi");
		firstPayment_ElectronicMoneyTransferToBankText.sendKeys("Satya sai hospital");
	}

	public void clickOnCancelBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);

		cancelBtn.click();
	}

	public String verifyCancelBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		String hsb = hospitalServiceBilltextInHeader.getText();
		return hsb;
	}

	public String VerifyByAddingDuplicatServices(WebDriver driver, String sn1, String sn2) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(sn1);
		firstElementInSuggestionBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		addBtnForServices.click();
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		serviceNameTextField.sendKeys(sn2);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		firstElementInSuggestionBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String dps = TextForDuplicateDervicePopup.getText();
		System.out.println(dps);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtnForSuccessfullPopUp.click();
		return dps;
	}

	public String VerifyIpPatientInOPBilling(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String text = TextForIpPatientePopup.getText();

		okBtnForSuccessfullPopUp.click();
		return text;
	}

	public String VerifyOpNumberInBillTypeAsIp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String text = errorMsg_PatientNotFoundInGeneralIp.getText();
		clickOnTheElementUsedToJavascriptExecuter(driver, okBtnForSuccessfullPopUp);
		return text;
	}

	public void clickOnClearButton(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);

		clearbutton.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void verifyNextBtnIsWorkingAsExpectedInCompletedList(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		for (int i = 1; i <= 5; i++) {
			WebElement lastSlNo = listOfSerialnoInCompletedList.get(listOfSerialnoInCompletedList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			nextBtnInCompletedList.click();
			Thread.sleep(2500);
			String ls1 = slNo_CompletedList.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpectedInCompletedList(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(500);
			nextBtnInCompletedList.click();
		}
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(2000);
			String ls1 = slNo_CompletedList.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			PreviousBtnInCompletedList.click();
			Thread.sleep(1500);
			WebElement lastSlNo = listOfSerialnoInCompletedList.get(listOfSerialnoInCompletedList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public void clickOnPendingListTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, PendingList);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void verifyNextBtnIsWorkingAsExpectedInPendingList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) {
			WebElement lastSlNo = listOfSerialnoInPendingList.get(listOfSerialnoInPendingList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			nextBtnInPendingList.click();
			Thread.sleep(2500);
			String ls1 = slNo_PendingList.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpectedInPendingList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(500);
			nextBtnInPendingList.click();
		}
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2000);
			String ls1 = slNo_PendingList.getText();
			int res1 = Integer.parseInt(ls1);
			int res11 = res1 - 1;
			PreviousBtnInPendingList.click();
			Thread.sleep(1500);
			WebElement lastSlNo = listOfSerialnoInPendingList.get(listOfSerialnoInPendingList.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res11);
		}
		System.out.println("Successfully previous button is verified");
	}

	public void firstPaymentMode_AsMobileWalletr(WebDriver driver, String mode, String mobileWalletType,
			String amount) {
		scrollDownThePageUntilElementIsVisible(driver, multiplePaymentModeBtn);

		multiplePaymentModeBtn.click();
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, firstPayment_DropdownBtn);

		firstPayment_DropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, firstPayment_MobileWalletTypeDropdown);

		moveToElementAndEnterTheData(driver, dropdownText, mobileWalletType);
		firstPayment_MobileWalletReferencNumberText.sendKeys("4321");
		firstPayment_MobileWalletPhoneNumberText.sendKeys("6543627281S");
		firstPayment_MobileWalletColllectedAmount.sendKeys(amount);
	}

	public void secondPaymentModeAs_Credit(WebDriver driver, String mode, String cardType, String charge)
			throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, secondPayment_DropdownBtn);

		secondPayment_DropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, secondPayment_CreditCardTypeDropdown);

		secondPayment_CreditCardTypeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, cardType);
		secondPayment_CreditCardNumber.sendKeys("4321");
		secondPayment_CreditServiceCharge.sendKeys(charge);
		secondPayment_CreditTerminalId.sendKeys("45463");
		secondPayment_CreditBatchNumber.sendKeys("6538");
		secondPayment_CreditCardExpiry.sendKeys("122023");
		secondPayment_CreditReferenceNumber.sendKeys("5418");
		secondPayment_CreditCardHolderMobileNumber.sendKeys("1243526271");
		secondPayment_CreditCardHolderName.sendKeys("Test Engineer");
	}

	public void secondPaymentModeAs_Cheque(WebDriver driver, String mode, String approvalAmount) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, secondPayment_DropdownBtn);

		secondPayment_DropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		secondPayment_ChequeNumber.sendKeys("6767");
		secondPayment_ChequeApprovalAmount.sendKeys(approvalAmount);
		secondPayment_ChequeDraweeBank.sendKeys("vydehi");
		secondPayment_ChequeOwnerName.sendKeys("Test Engineer");
		secondPayment_ChequeResidingAt.sendKeys("Tst");
		scrollDownThePageUntilElementIsVisible(driver, secondPayment_ChequeRelationWithPatientDropdown);

		secondPayment_ChequeRelationWithPatientDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, "BROTHE");
		secondPayment_ChequeMobileNumber.sendKeys("7632617171");
		secondPayment_ChequePoliceStation.sendKeys("Police station");
		secondPayment_ChequeBranchName.sendKeys("Vydehi branch");
	}

	public void secondPaymentModeAs_DD(WebDriver driver, String mode, String approvalAmount) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, secondPayment_DropdownBtn);

		secondPayment_DropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, mode);
		secondPayment_DDNumber.sendKeys("43526");
		secondPayment_DDDate.sendKeys("12122023");
		secondPayment_DDDraweeBank.sendKeys("test");
		secondPayment_DDBranchName.sendKeys("Vydehi");
		secondPayment_DDSignatoryOneCode.sendKeys("4232");
		secondPayment_DDSignotoryTwoCode.sendKeys("52727");
	}

	public void addThePackageName(WebDriver driver, String packageName) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		scrollDownThePageUntilElementIsVisible(driver, packageNameText_PackageListTable);
		packageNameText_PackageListTable.sendKeys(packageName);
		firstElementInSuggestionBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
	}

	public HashSet<String> takeDepartmentNames() throws Throwable {
		Thread.sleep(1000);
		List<WebElement> departments = departmentNameSConsultationList;
		HashSet<String> set = new HashSet<>();
		for (WebElement webElement : departments) {
			String dep = webElement.getText();
			String test = dep.replaceAll("\\s+", "");
			set.add(test);
		}
		return set;
	}

	public HashSet<String> takeUnitChiefsName_ConsultationList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		List<WebElement> unit = unitChiefNames_ConsultationList;
		HashSet<String> set = new HashSet<>();
		for (WebElement webElement : unit) {
			String dep = webElement.getText();
			set.add(dep);
		}
		return set;
	}

	public void selectDepartmentUnitsDropdowns(WebDriver driver) {
		for (WebElement webElement : departmentUnitDropdwonBtnsConsulationList) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			webElement.click();
			moveToElementAndEnterTheData(driver, dropdownText, "1");
		}

	}

	public void clickOnExternalLabRadioButton(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollToTop(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		externaleLabRadioBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);

	}

	public String takeBillNumber_PendingList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, billnumber_PendingTable);
		String billNumber = billnumber_PendingTable.getText();
		return billNumber;
	}

	public void selectConcessionOnDropdown(WebDriver driver, String concessionOn) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, concessionOnDropdownBtn);
		concessionOnDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, concessionOn);
	}

	public void selectAuthorization(WebDriver driver, String authorization) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilElementIsVisible(driver, authorizationDropdownBtn);

		authorizationDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, authorization);
		scrollUpUsingActions(driver);
	}

	public void clickOnsendForApprovalButton(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilElementIsVisible(driver, sendForApprovalBtn);
		clickOnTheElementUsedToJavascriptExecuter(driver, sendForApprovalBtn);
	}

	public void enterTheReasonForCancellation(WebDriver driver, String reason) {
		ReasonForConcession.sendKeys(reason);

	}

	public void enterTheConcessionAmount(WebDriver driver, String amount) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilElementIsVisible(driver, concessionAmount_BillingDetails);
		concessionAmount_BillingDetails.sendKeys(amount);
	}

	public void clickOnSubmitButton_reasonForConcessionPopup(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);

		submit_ReasonForConcession_Popup.click();
	}

	public String takePleaseSelectAuthorization_PopupMessage(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, pleaseSelectAuthorizationPopupMsg);
		String msg = pleaseSelectAuthorizationPopupMsg.getText();
		okBtnForSuccessfullPopUp.click();
		return msg;
	}

	public void pendingProcess(WebDriver driver, String hospitalNumber, String concessionOn, String authorization,
			String sn1, String amount, String reason) throws Throwable {
		selectConcessionOnDropdown(driver, concessionOn);
		selectAuthorization(driver, authorization);
		addServicesInOpBilling(driver, sn1);
		enterTheConcessionAmount(driver, amount);
		clickOnsendForApprovalButton(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		enterTheReasonForCancellation(driver, reason);
		clickOnSubmitButton_reasonForConcessionPopup(driver);

		okBtnSuccessfullySuspendedPoup.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void pendingProcessForOnServiceConcession(WebDriver driver, String hospitalNumber, String concessionOn,
			String authorization, String sn1, String percentage, String reason) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		selectConcessionOnDropdown(driver, concessionOn);
		selectAuthorization(driver, authorization);
		addTheService(driver, sn1);
		concessionPrecentageField.sendKeys(percentage);
		clickOnsendForApprovalButton(driver);
		Thread.sleep(1000);
		enterTheReasonForCancellation(driver, reason);
		clickOnSubmitButton_reasonForConcessionPopup(driver);
		okBtnSuccessfullySuspendedPoup.click();
	}

	public void pendingProcess_WithoutAuthorization(WebDriver driver, String hospitalNumber, String concessionOn,
			String sn1, String amount, String reason) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		selectConcessionOnDropdown(driver, concessionOn);
		addTheServiceOne(driver, sn1);
		enterTheConcessionAmount(driver, amount);
		clickOnsendForApprovalButton(driver);
		enterTheReasonForCancellation(driver, reason);
		clickOnSubmitButton_reasonForConcessionPopup(driver);
	}

	public void clickOnMultiplePaymentModeBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, multiplePaymentModeBtn);
		multiplePaymentModeBtn.click();
	}

	public void clickOnSubmitBtn(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String verifyErrorPopupIfweClickONSubmitWithoutSelectingPaymentMode(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String error = errorTextForPaymentmode.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(500);
		errorTextForPaymentmode.click();
		return error;
	}

	public String verifyHospitalNumberIsReflectingInCompletedList(WebDriver driver, String hospitalNumber)
			throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		scrollToTop(driver);

		completedTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		hospitalNumberText.sendKeys(hospitalNumber);
		searchbutton.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		String hospitalNumber1 = hospitalNumberInTable_CompletedList.getText();
		return hospitalNumber1;
	}

	public String CaptureHospitalNumberInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumberInTable_CompletedList.getText();
		System.out.println(hospitalNumber);
		return hospitalNumber;
	}

	public String Capture_LastRow_HospitalNumberInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = lastRow_hospitalNumberInTable_CompletedList.getText();
		System.out.println(hospitalNumber);
		return hospitalNumber;
	}

	public String CaptureBillNumberInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String billNumber = billNumberNumberInTable_CompletedList.getText();
		System.out.println(billNumber);
		return billNumber;
	}

	public String CaptureOpNumberInPatientDetails(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(3000);
		String op = OpNumber_patientDetails.getText();
		String opNumber = op.substring(1).trim();
		System.out.println(opNumber);
		return opNumber;
	}

	public String CaptureBillAmount(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		String billAmount = billAmount_BillingDetails.getAttribute("value");
		System.out.println(billAmount);
		return billAmount;
	}

	public String CaptureCollectedAmount(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String collectedAmount = collectedAmount_BillingDetails.getAttribute("value");
		System.out.println(collectedAmount);
		return collectedAmount;
	}

	public String CapturePatientName(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(3000);
		String patientName = patientName_patientDetails.getText();
		System.out.println(patientName);
		return patientName;
	}

	public String CapturePatientNameInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = patientName_completedList.getText();
		String patientName = removeSpecialCharactersAndNumbers_RemoveLastCharacters(pName, 0);
		return patientName;
	}

	public String CaptureOpNumberInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String opNumber = opNumber_completedList.getText();
		return opNumber;
	}

	public String CaptureBillAmountInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String ba = billAmount_completedList.getText();
		String billAmount = ba.substring(0, ba.indexOf("."));
		return billAmount;
	}

	public String CaptureCollectedAmountInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String ca = collectedAmount_completedList.getText();
		String collectedAmount = ca.substring(0, ca.indexOf("."));
		return collectedAmount;
	}

	public void selectTansactionTypeInConmpletedList(WebDriver driver, String transactionType) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		transactionTypeDropdown.click();
		dropdownText.sendKeys(transactionType, Keys.ENTER);
	}

	public void selecttBillTypeInConmpletedList(WebDriver driver, String billType) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		billTypeDropDownBtn.click();
		dropdownText.sendKeys(billType, Keys.ENTER);
	}

	public String captureTransactionTypeInTable(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, transactionType_completedList);
		String transactionType = transactionType_completedList.getText();
		return transactionType;
	}

	public String captureBillTypeInTable(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, billType_CompltedList);
		String billType = billType_CompltedList.getText();
		return billType;
	}

	public void enterHospitalNumber1(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void enterBillNumberNumber(WebDriver driver, String billNumber1) throws Throwable {
		billNumber.sendKeys(billNumber1);
	}

	public void selectBillDateInCompletedList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(4000);
		scrollToTop(driver);

		billDateBtn.click();
		Thread.sleep(2000);
		billDateBtn.sendKeys(Keys.ENTER);
	}

	public void selectTwoDaysBackBillDateInCompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		billDateBtn.click();
		String currentDate = generateTwoDaysBackDate();
		String month = currentMonth();
		String year = generateCurrentYear();
		driver.findElement(By.xpath("//td[@aria-label='" + month + " " + currentDate + ", " + year + "']//div[1]"))
				.click();
	}

	public String captureBillDateInCompletedList(WebDriver driver) throws Throwable {
		String desiredFormat = "dd-MM-yyyy";
		scrollDownThePageUntilElementIsVisible(driver, billDate_completedList);
		String billDate = billDate_completedList.getText();
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = inputFormat.parse(billDate);
		SimpleDateFormat outputFormat = new SimpleDateFormat(desiredFormat);
		String formattedDate = outputFormat.format(date);
		System.out.println(formattedDate);
		return formattedDate;
	}

	public String capture24hrsErrormsg(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String errorMsg = ErrorMsg_24hrs.getText();
		return errorMsg;
	}

	public void SelectConcessionOnDropdown(WebDriver driver, String concessionOn) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilElementIsVisible(driver, concessionOnDropdownBtn);
		concessionOnDropdownBtn.click();
		dropdownText.sendKeys(concessionOn, Keys.ENTER);
	}

	public String verifyConcessionAmountByEnteringMoreAmount(WebDriver driver) throws Throwable {
		String ca = collectedAmount_BillingDetails.getAttribute("value");
		int ca1 = Integer.parseInt(ca);
		int ca2 = ca1 + 1;
		String ca3 = String.valueOf(ca2);
		concessionAmount_BillingDetails.sendKeys(ca3);
		Thread.sleep(500);
		String errorMsg = ErrorMsg_concessionAmtGreaterThanBillAmt.getText();
		ErrorMsg_concessionAmtGreaterThanBillAmt.click();
		return errorMsg;
	}

	public void enterHospitalNumber_Filters(WebDriver dricer, String hospitalNumber) throws Throwable {
		hospitalNumber_Filerts.sendKeys(hospitalNumber);
	}

	public void clickOnSearchButton_Filters(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		searchButton_Filters.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String takeHospitalNumber_PendingList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalnumber_PendingTable.getText();
		return hospitalNumber;
	}

	public String takeBillNumberPendingList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String billNumber = billnumber_PendingTable.getText();
		return billNumber;
	}

	public String takeBillDatePendingList(WebDriver driver) throws Throwable {
		String desiredFormat = "dd-MM-yyyy";
		scrollDownThePageUntilElementIsVisible(driver, billDate_pendingTable);
		String billDate = billDate_pendingTable.getText();
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = inputFormat.parse(billDate);
		SimpleDateFormat outputFormat = new SimpleDateFormat(desiredFormat);
		String formattedDate = outputFormat.format(date);
		System.out.println(formattedDate);
		return formattedDate;

	}

	public String takePatientNamePendingList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientName = patientName_pendingTable.getText();
		return patientName;
	}

	public String takeOPNumberPendingList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String opNumber = opNumber_pendingTable.getText();
		return opNumber;
	}

	public String takePateientType_PendingList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientType = patientType_pendingTable.getText();
		return patientType;
	}

	public String takePatientCategory_PendingList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String patientCategory = patientCategory_pendingTable.getText();
		return patientCategory;
	}

	public String takeConcessonStatus_PendingList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String status = concessionStatus_pendingTable.getText();
		return status;
	}

	public String take_FourthPlace_BillNumber_PendingList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String billNumber = billnumber_FourthPlace_PendingTable.getText();
		return billNumber;

	}

	public String takePatientName_CompletedList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String name = patientName_completedList.getText();
		String name1 = removeSpecialCharacters_And_Speces(name);
		String patientName = removeFirst_n_NumberOfCharacters(name1, 2);
		return patientName;
	}

	public String pendingProcessForCapturingServiceName(WebDriver driver, String hospitalNumber, String concessionOn,
			String authorization, String sn1, String amount, String reason) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		selectConcessionOnDropdown(driver, concessionOn);
		selectAuthorization(driver, authorization);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		scrollDownThePageUntilElementIsVisible(driver, serviceNameTextField);
		serviceNameTextField.sendKeys(sn1);
		firstElementInSuggestionBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		addBtnForServices.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String text = serviceName.getText();
		enterTheConcessionAmount(driver, amount);
		return text;

	}

	public List<String> captureListOfServices(WebDriver driver) throws Throwable {
		List<String> text = getTextFromElements(listOfServiceNames);
		return text;
	}

	public void selectTransactionTypeDropdwon(WebDriver driver, String transactionType) {
		invisibiltyOf_Element_ThreeDots(driver);

		transactionTypeDropdown_NewBill.click();
		moveToElementAndEnterTheData(driver, dropdownText, transactionType);
	}

	public void selectCreditToDropdown(WebDriver driver, String creditTo) {
		invisibiltyOf_Element_ThreeDots(driver);

		credtiToDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, creditTo);
	}

	public String concessionAuthorizationProcess(WebDriver driver, String concessionOn, String authorization,
			String sn1, String amount, String reason) throws Throwable {
		clickOnCompletedTab(driver);
		clickOnClearButton(driver);
		String hospitalNumber = takeHospitalNumberCompletedBillingList(driver);
		clickonNewBillButton(driver);
		enterHospitalNumber(hospitalNumber);
		pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount, reason);
		return hospitalNumber;
	}

	public void clickOnSendApproval(WebDriver driver, String reason) throws Throwable {
		clickOnsendForApprovalButton(driver);
		enterTheReasonForCancellation(driver, reason);
		clickOnSubmitButton_reasonForConcessionPopup(driver);
		okBtnSuccessfullySuspendedPoup.click();
	}

	public void EnterHospitalNumberAndSearchInPendingList(WebDriver driver, String hospitalNumber)
			throws InterruptedException {
		invisibiltyOf_Element_ThreeDots(driver);
		hospitalNumber_Filerts.sendKeys(hospitalNumber);
		Thread.sleep(700);
		searchButton_Filters.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnBillNumberInPendingList(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, billnumber_PendingTable);
		billnumber_PendingTable.click();
	}

	public String verifyHospitalNumberInCompletedList(WebDriver driver) throws InterruptedException {
		invisibiltyOf_Element_ThreeDots(driver);
		String hospitalNumber = hospitalNumber_CompletedBillingList.getText();
		return hospitalNumber;
	}

	public void concessionAuthorizationProcess_For_Ip(WebDriver driver, String hospitalNumber, String concessionOn,
			String authorization, String sn1, String amount, String reason) throws Throwable {
		pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount, reason);

	}

	public void clickOnCancelUnderAction(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		doubleClick(driver, actionBtn_table);
		scrollDownThePageUntilElementIsVisible(driver, cancelBill_Action);
		cancelBill_Action.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void enterTheReasonForCancellation_cancelPopUp_CompletedList(WebDriver driver, String reason) {
		ReasonForConcession_cancelPopup_CompletedList.sendKeys(reason);
	}

	public void selectPaymentMode(WebDriver driver, String mode) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, paymentModeDropDownBtn);

		dropdown(driver, paymentModeDropDownBtn, dropdownText, mode);
	}

	public void clickOnSubmit_cancelPopUp(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_cancelPopup);
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);

		submitBtn_cancelPopup.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		getWindowHandles(driver);
		Thread.sleep(1000);
		okBtnForSuccessfullPopUp.click();
	}

	public String captureOkBtnText(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = okBtnText.getText();
		return text;
	}

	public void clickOnOkBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);

		okBtnForSuccessfullPopUp.click();
	}

	public String CaptureBillAmount_doubleFormate(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		String billAmount = billAmount_BillingDetails.getAttribute("value");
		double doubleValue = Double.parseDouble(billAmount);
		String formattedNumber = String.format("%.2f", doubleValue);
		return formattedNumber;
	}

	public String clickOnSubmit_captureText_ClickOnOkBtn(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_cancelPopup);
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);

		submitBtn_cancelPopup.click();
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		getWindowHandles(driver);
		Thread.sleep(1000);
		String text = captureOkBtnText(driver);
		okBtnForSuccessfullPopUp.click();
		return text;
	}

	public String captureCancelledStatus_CompletedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownTheStillEndOfThePage(driver);
		String text = cancelledStatus_CompletedList.getText();
		return text;
	}
}
