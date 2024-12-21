package com.Dalvkot.Vims_ObjectRepositary;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class AllPatientListPage extends WebDriverUtility {

	public AllPatientListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// ------------------------------------------------ActivePatient-------------------------------------------------
	@FindBy(xpath = "//span[text()=' All patient List ']")
	private WebElement allPatientListBtn;

	@FindBy(xpath = "//a[text()=' Active Patient ']")
	private WebElement activeTabForVims;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hopsitalNumberText;

	@FindBy(xpath = "//input[@placeholder='patient Name']")
	private WebElement patientNameText;

	@FindBy(xpath = "//input[@placeholder='mobile Number']")
	private WebElement mobileNumberText;

	@FindBy(xpath = "//span[@title='Select Department']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement departmentDropdownBtn;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBy(xpath = "//label[text()='Patient Status']/..//span[@role='presentation']")
	private WebElement patientStatusDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Patient Type']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement patientTypeDropdownBtn;

	@FindBy(xpath = "//button[text()=' Clear ']")
	private WebElement clearBtn;

	@FindBy(xpath = "//button[text()=' Search ']//i")
	private WebElement seacrhBtn;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()]/td[3]")
	private WebElement lastRow_hospitalNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()-1]/td[3]")
	private WebElement last_To_Second_hospitalNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()-2]/td[3]")
	private WebElement last_To_Third_hospitalNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()-3]/td[3]")
	private WebElement last_To_Four_hospitalNumberInTheActivePatientTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/descendant::p")
	private WebElement patientNameInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement ipNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement departmentInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement unitInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement doctorNameInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement wardTypeInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement roomTypesInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement bedNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement admittedDateInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement categoryInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[13]")
	private WebElement customerInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[14]")
	private WebElement mobileNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[15]")
	private WebElement advanceAmountInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[16]")
	private WebElement addressInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[17]")
	private WebElement statusInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[18]")
	private WebElement dateAndTimeInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[19]")
	private WebElement userInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::button[@class='btn btn-primary dropdown-toggle btn-sm']")
	private WebElement actionsBtn_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[16]/descendant::i[@class='zmdi zmdi-edit']")
	private WebElement edit_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::i[@class='zmdi zmdi-close-circle']")
	private WebElement cancelBtn_ActivePatient;

	@FindBy(xpath = "(//button[text()=' Discharge Intimation '])[1]")
	private WebElement dischargeIntimation_ActivePatient;

	@FindBy(xpath = "//button[text()=' DischargeIntimation ']")
	private WebElement dischargeIntimation_ForClearence;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::button[text()=' Transfer Patient ']")
	private WebElement transferPatient_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::i[@class='zmdi zmdi-ticket-star']")
	private WebElement ipdPatientSticker_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::button[text()=' Admission Record Report ']")
	private WebElement admissionRecordReport_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::button[text()=' Admission Report ']")
	private WebElement admissionReport_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::button[text()=' Transfer Report ']")
	private WebElement transferReport_ActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::button[text()='Doctor Transfer ']")
	private WebElement doctorTransfer_ActivePatient;

	// ------------------------------------------Adimtted---------------------

	@FindBy(css = "input[formcontrolname='height']")
	private WebElement heightTextForVims;

	@FindBy(css = "input[formcontrolname='weight']")
	private WebElement weightTextForVims;

	@FindBy(xpath = "//div[@id='CrossReferral']/descendant::table/tbody/tr[1]/td[8]/descendant::button[@class='btn btn-primary dropdown-toggle btn-sm']")
	private WebElement actionsBtnforCrossreferral;

	@FindBy(xpath = "//div[@id='CrossReferral']/descendant::table/tbody/tr[1]/td[8]/descendant::button")
	private WebElement crConfirmSuggestion;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[20]//button[text()=' Actions ']")
	private WebElement actionBtnActivePatient;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button")
	private WebElement cancelsuggestionActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[16]/descendant::button")
	private WebElement cancelSuggetionForVims;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[@class='dropdown-item'][2]/descendant::button//i[@class='zmdi zmdi-edit']")
	private WebElement editSuggestionActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[@class='dropdown-item ng-star-inserted'][3]")
	private WebElement dischargeSuggestActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[@class='dropdown-item ng-star-inserted'][4]")
	private WebElement dischargeIntimationSuggestActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[@class='dropdown-item ng-star-inserted'][5]")
	private WebElement transferPatientSuggestActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[@class='dropdown-item ng-star-inserted'][6]")
	private WebElement ipPatientStickersuggestionActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[@class='dropdown-item ng-star-inserted'][7]")
	private WebElement admissionReportRecordSuggestionActiveList;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]/descendant::button[9]")
	private WebElement doctorTransferSuggestionActiveList;

	@FindBy(xpath = "//div[@id='Cancelmodal']/descendant::textarea[@placeholder='Min length 10 char']")
	private WebElement reasonForCancellationtextIPD;

	@FindBy(xpath = "//div[@id='Cancelmodal']/descendant::button[text()='Submit']")
	private WebElement submitBtnForCancelIPD;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButtonIPD;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement successfulOkBtnDoctorTransfer;

	@FindBy(xpath = "//a[text()='Doctor Change Request']")
	private WebElement doctorChangeRequestTab;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsText;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement YesBtnforChangeDoctorRequest;

	@FindBy(xpath = "//a[text()='Admitted']")
	private WebElement admittedTab;

	@FindBy(xpath = "//a[text()='Admitted ']")
	private WebElement admittedTabForVims;

	@FindBy(xpath = "//a[text()='Cancelled ']")
	private WebElement cancelledTabForVims;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumberInTheAdmittedTable;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumberInTheAdmittedTableForVims;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnPopup;

	@FindBy(xpath = "//input[@placeholder='Effective Discharge Date']")
	private WebElement effectiveDischargeDateDischargePatientPage;

	@FindBy(xpath = "//input[@placeholder='Effective Discharge Time']")
	private WebElement effectiveDischargeTimeDischargePatientPage;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnForPatientDischargedSuccessfully;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement getTheHospitalNumberInTheTable;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okbtn;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[2]/descendant::p[@class='a m-0']")
	private WebElement patientNameInTheLastRowActivePatientTable;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement departmentInTheActivePatientTable_lastRow;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement unitInTheActivePatientTable_lastRow;

	@FindBy(xpath = "//span[@title='Unit']/following-sibling::span[1]")
	private WebElement unitDropDownBtn_ActiveTab;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[last()]/td[17]")
	private WebElement patientStatusInTheActivePatientTable_lastRow;

	@FindBys({ @FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr/td[14]") })
	private List<WebElement> listOfPhoneNumberInTable_activetab;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[14]")
	private WebElement phoneNumberInTheActivePatientTable;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[last()]/td[3]")
	private WebElement lastRow_hospitalNumberInTheAdmittedTable;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[last()]/td[2]")
	private WebElement patientNameInTheLastRowAdmittedPatientTable;

	@FindBys({ @FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr/td[12]") })
	private List<WebElement> listOfPhoneNumberInTable_admittedTab;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement phoneNumberInTheAdmittedPatientTable;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement departmentInTheAdmittedPatientTable_lastRow;

	@FindBy(xpath = "//div[@id='Admitted']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement unitInAdmittedPatientTable_lastRow;

	@FindBy(xpath = "//a[contains(.,'Discharged')]")
	private WebElement dischargedTab;

	@FindBy(xpath = "//div[@id='Discharged']/descendant::table/tbody/tr[last()]/td[3]")
	private WebElement lastRow_hospitalNumberInTheDischargedTable;

	@FindBy(xpath = "//div[@id='Discharged']/descendant::table/tbody/tr[last()]/td[2]")
	private WebElement patientNameInTheLastRowDischargedPatientTable;

	@FindBy(xpath = "//div[@id='Discharged']/descendant::table/tbody/tr[last()]/td[18]")
	private WebElement patientStatusInTheDischargedPatientTable_lastRow;

	@FindBy(xpath = "//span[@title='Select Bill Status']/following-sibling::span[1]")
	private WebElement patientStatusDropDownBtn_DischargedTab;

	@FindBy(xpath = "//a[contains(text(),'Cross Referral')]")
	private WebElement crossReferralTab;

	@FindBy(xpath = "//div[@id='CrossReferral']//table/tbody/tr[1]/td[11]//button")
	private WebElement actionBtn_Table_CrossReferral;

	@FindBy(xpath = "//button[text()=' CR Confirm ']")
	private WebElement crConfirmBtn_Action_CrossReferral;

	@FindBy(xpath = "//span[text()=' Refer OP to IP ']")
	private WebElement referOpToIpTab;

	@FindBy(xpath = "//div[@id='ReferOPtoIP']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumber_Table_ReferOpToIp;

	@FindBy(xpath = "//label[text()='Discharge Status ']/..//span[@role='presentation']")
	private WebElement dischargeStatusDropdown_ForClearence;

	@FindBy(xpath = "//textarea[@placeholder='Type Your Discharge Result Notes Here']")
	private WebElement dischargeResult_Notes_ForClearence;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submit_Button;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement PleaseconfirmAllWardServicesAreBeingCompleted_CheckBox;

	@FindBy(xpath = "//div[@id='ReferOPtoIP']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement reason_ReferOpToIp;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	private WebElement admissionDate;

	@FindBy(xpath = "//label[text()='Admission Date']/..//input")
	private WebElement admissionDate_ActiveList;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[1]")
	private WebElement admissionFromDate;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[2]")
	private WebElement admissionToDate;

	@FindBys({ @FindBy(xpath = "//div[@id='Admitted']//table/tbody/tr/td[11]") })
	private List<WebElement> listOfAdmittedDateInTable_AdmittedTab;

	@FindBy(xpath = "(//a[@aria-label='Next page'])[1]")
	private WebElement nextPageBtn_AdmittedTab;

	@FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement admissionDate_Table_ActiveTab;

	@FindBys({ @FindBy(xpath = "//div[@id='Ongoing']/descendant::table/tbody/tr/td[11]") })
	private List<WebElement> listOfAdmissionDateInTable_ACtiveTab;

	/**
	 * 
	 * Business Logics
	 * 
	 * 
	 */

	// ---------------------------------------------Active patient
	// ----------------------------------------------

	public void clickOnTheAllPatientListButton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, allPatientListBtn);
	}

	public void enterTheHospitalNumber(String hospitalNumber) {
		hopsitalNumberText.sendKeys(hospitalNumber);
	}

	public void enterThePatientName(String patientName) {
		patientNameText.sendKeys(patientName);
	}

	public void enterTheMobileNumber(String mobileNumber) {
		mobileNumberText.sendKeys(mobileNumber);
	}

	public void selectTheDepartmentDropdown(WebDriver driver, String department) {
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, department);
	}

	public void selectPatientStatusDropdown(WebDriver driver, String patientStatus) throws Throwable {
		Thread.sleep(2000);
		patientStatusDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownsText, patientStatus);
	}

	public void clickOnTheSearchButton(WebDriver driver) throws Throwable {
		seacrhBtn.click();
		;
	}

	public void clickOnTheClearButton(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, clearBtn);
	}

	public String takeTheHospitalNumberInTheActivePatientTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumberActiveList = hospitalNumberInTheActivePatientTable.getText();
		return hospitalNumberActiveList;
	}

	public String take_LastrRow_HospitalNumber_ActiveList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = lastRow_hospitalNumberInTheActivePatientTable.getText();
		return hospitalNumber;
	}

	public String take_To_Second_HospitalNumber_ActiveList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = last_To_Second_hospitalNumberInTheActivePatientTable.getText();
		return hospitalNumber;
	}

	public String take_To_Third_HospitalNumber_ActiveList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String hospitalNumber = last_To_Third_hospitalNumberInTheActivePatientTable.getText();
		return hospitalNumber;
	}

	public String take_To_Four_HospitalNumber_ActiveList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = last_To_Four_hospitalNumberInTheActivePatientTable.getText();
		return hospitalNumber;
	}

	public String takeThePatientNameInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String str = patientNameInTheActivePatientTable.getText();
		String patientName = removeFirstCharctersAndLastCharters_WithSpecialCharacters(str, 2, 2);
		System.out.println(patientName);
		return patientName;
	}

	public String takeIpNumberInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = ipNumberInTheActivePatientTable.getText();
		return ipNumber;
	}

	public String takeDepartmentNameInTheActivePatinet_Table(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String str = departmentInTheActivePatientTable.getText();
		return str;
	}

	public String takeDoctorNameInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String doctorName = doctorNameInTheActivePatientTable.getText();
		return doctorName;
	}

	public String takeWardTypeNameInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = wardTypeInTheActivePatientTable.getText();
		return wardType;
	}

	public String takeRoomTypeInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = roomTypesInTheActivePatientTable.getText();
		return roomType;
	}

	public String takeBedNumberInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String bedNumber = bedNumberInTheActivePatientTable.getText();
		return bedNumber;
	}

	public String takeAdmittedDateInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String admittedDate = admittedDateInTheActivePatientTable.getText();
		return admittedDate;
	}

	public String takeCategoryInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String category = categoryInTheActivePatientTable.getText();
		return category;
	}

	public String takeCustomerInTheActivePatinet_Table() throws Throwable {
		Thread.sleep(1000);
		String customer = customerInTheActivePatientTable.getText();
		return customer;
	}

	public String takeMobileNumberInTheActivePatinet_Table() throws Throwable {
		Thread.sleep(1000);
		String mobileNumber = mobileNumberInTheActivePatientTable.getText();
		return mobileNumber;
	}

	public String takeAdvanceAmountInTheActivePatinet_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String str = advanceAmountInTheActivePatientTable.getText();
		String advanceAmount = str.substring(0, str.length() - 4);
		double d = Double.parseDouble(advanceAmount);
		String formattedAmount = String.format("%.3f", d);
		return formattedAmount;
	}

	public void clickOnClearButton(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		clearBtn.click();
	}

	public void clickOnClearBtn(WebDriver driver) throws Throwable {
		explictWaitForElementToBeVisible(driver, clearBtn);
		clearBtn.click();
	}

	public void clickOnActionsButton_ActiveList(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		doubleClick(driver, actionBtnActivePatient);
	}

	public void clickOn_DischargeIntimation_ActiveList(WebDriver driver) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, dischargeIntimation_ActivePatient);
		dischargeIntimation_ActivePatient.click();
	}

	public void clickOn_DischargeIntimationButton_Clearence(WebDriver driver) {
		dischargeIntimation_ForClearence.click();
	}

	public void clickOn_Ok_Button(WebDriver driver) {
		okbtn.click();
	}

	public void dischargeIntimation_Process(WebDriver driver) throws Throwable {
		clickOnActionsButton_ActiveList(driver);
		clickOn_DischargeIntimation_ActiveList(driver);
		Thread.sleep(2000);
		clickOn_DischargeIntimationButton_Clearence(driver);
		clickOn_Ok_Button(driver);
	}

	public void clickOnActiveTab(WebDriver driver) throws Throwable {
		activeTabForVims.click();
	}

	public String takeLastRowPatientNameInTheActivePatinet_Table(WebDriver driver) {
		scrollTillVisibleElement(driver, patientNameInTheLastRowActivePatientTable);
		String str = patientNameInTheLastRowActivePatientTable.getText();
		String patientName = str.substring(0, str.length() - 8);
		return patientName;
	}

	public String takeDepartmentNameInTheActivePatinet_LastRow_Table() {

		String str = departmentInTheActivePatientTable_lastRow.getText();
		return str;
	}

	public String takeUnitInTheActivePatinet_LastRow_Table() {
		String unit = unitInTheActivePatientTable_lastRow.getText();
		return unit;
	}

	public void selectUnitDropdown(WebDriver driver, String unit) {
		scrollToTop(driver);
		unitDropDownBtn_ActiveTab.click();
		moveToElementAndEnterTheData(driver, dropdownsText, unit);
	}

	public String takePatientStatusInTheActivePatinet_LastRow_Table() {
		String str = patientStatusInTheActivePatientTable_lastRow.getText();
		return str;
	}

	public String capturePhoneNumberAndIgnoreIfNa_activeList(WebDriver driver) {
		for (WebElement row : listOfPhoneNumberInTable_activetab) {
			String phoneNumberText = row.getText();
			if (!phoneNumberText.equalsIgnoreCase("N/A")) {
				System.out.println(phoneNumberText);
				return phoneNumberText;
			}
		}
		return null;
	}

	public String capturePhoneNumber_ActiveTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ph = phoneNumberInTheActivePatientTable.getText();
		return ph;
	}

	public void clickOnAdmittedTab(WebDriver driver) throws Throwable {
		admittedTabForVims.click();
	}

	public String take_LastrRow_HospitalNumber_AdmittedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = lastRow_hospitalNumberInTheAdmittedTable.getText();
		return hospitalNumber;
	}

	public String takeLastRowPatientNameInTheAdmittedePatient_Table(WebDriver driver) {
		String str = patientNameInTheLastRowAdmittedPatientTable.getText();
		String patientName = str.substring(0, str.length() - 8);
		return patientName;
	}

	public String capturePhoneNumberAndIgnoreIfNa_admittedList(WebDriver driver) {
		for (WebElement row : listOfPhoneNumberInTable_admittedTab) {
			String phoneNumberText = row.getText();
			if (!phoneNumberText.equalsIgnoreCase("N/A")) {
				System.out.println(phoneNumberText);
				return phoneNumberText;
			}
		}
		return null;
	}

	public String capturePhoneNumber_admittedTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ph = phoneNumberInTheAdmittedPatientTable.getText();
		return ph;
	}

	public String takeDepartmentName_Admitted_LastRow_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String str = departmentInTheAdmittedPatientTable_lastRow.getText();
		return str;
	}

	public String takeUnit_AdmittedPatinet_LastRow_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String unit = unitInAdmittedPatientTable_lastRow.getText();
		return unit;
	}

	public void selectDischargeFromDate(WebDriver driver) throws Throwable {
		driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[1]")).click();
		String currentDate = generateTenDaysAgoDate();
		String month = currentMonth();
		String year = generateCurrentYear();
		String first = currentDate.substring(0, 1);
		Thread.sleep(2000);
		if (first.equals("0")) {
			String second = currentDate.substring(1);
			driver.findElement(By.xpath("//td[@aria-label='" + month + " " + second + ", " + year + "']//div[1]"))
					.click();
		} else {
			driver.findElement(By.xpath("//td[@aria-label='" + month + " " + currentDate + ", " + year + "']//div[1]"))
					.click();
		}
	}

	public void clickOnDischargedTab(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		dischargedTab.click();
	}

	public String take_LastrRow_HospitalNumber_DischargedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = lastRow_hospitalNumberInTheDischargedTable.getText();
		return hospitalNumber;
	}

	public String takeLastRowPatientNameInTheDischargedPatient_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String str = patientNameInTheLastRowDischargedPatientTable.getText();
		String patientName = str.substring(0, str.length() - 8);
		return patientName;
	}

	public String takePatientStatusInTheDischargedPatinet_LastRow_Table(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String str = patientStatusInTheDischargedPatientTable_lastRow.getText();
		return str;
	}

	public void selectPatientStatusDropdown_DischrgedTab(WebDriver driver, String patientStatus) {
		patientStatusDropDownBtn_DischargedTab.click();
		moveToElementAndEnterTheData(driver, dropdownsText, patientStatus);
	}

	public String clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(WebDriver driver,
			String patientStatus) throws Throwable {
		clickOnClearBtn(driver);
		selectPatientStatusDropdown(driver, patientStatus);
		clickOnTheSearchButton(driver);
		String hospitalNumber = takeTheHospitalNumberInTheActivePatientTable(driver);
		return hospitalNumber;
	}

	public void clickOnCrConfirm_Table_CrossReferral(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, actionBtn_Table_CrossReferral);
		scrollDownByUsingJavascriptExecuter(driver);
		doubleClick(driver, actionBtn_Table_CrossReferral);
		scrollDownThePageUntilElementIsVisible(driver, crConfirmBtn_Action_CrossReferral);
		crConfirmBtn_Action_CrossReferral.click();
	}

	public void clickOnCrossReferralTab(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		explictWaitForElementToBeVisible(driver, crossReferralTab);
		crossReferralTab.click();

	}

	public void clickOnReferOpToIpTab(WebDriver driver) {
		referOpToIpTab.click();
	}

	public String captureHospitalNumber_ReferOpTOIp(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumber_Table_ReferOpToIp);
		String hospitalNumber = hospitalNumber_Table_ReferOpToIp.getText();
		return hospitalNumber;
	}

	public void clickOn_DischargeIntimation_ForClearence(WebDriver driver) {
		dischargeIntimation_ForClearence.click();
	}

	public void clickOn_OkButton(WebDriver driver) {
		okBtnPopup.click();
	}

	public void select_DischargeStatus_Clearence(WebDriver driver, String dischargeStatus) {
		dropdown_Handling(driver, getRandomNumber(), dropdownText, dropdownText, dischargeStatus);
		dropdown(driver, dischargeStatusDropdown_ForClearence, dropdownText, dischargeStatus);
	}

	public void enter_DischargeResult_Clearence(WebDriver driver, String dischargeResult) {
		dischargeResult_Notes_ForClearence.sendKeys(dischargeResult);
	}

	public void clickOn_SubmitButton(WebDriver driver) {
		submit_Button.click();
	}

	public void clickOn_PleaseConfirmAllWardServicesAreBeingCompleted_Checkbox() {
		PleaseconfirmAllWardServicesAreBeingCompleted_CheckBox.click();
	}

	public void clear_SelectPatientStatus_Search_ActiveList(WebDriver driver, String patientStatus) throws Throwable {
		clickOnClearBtn(driver);
		selectPatientStatusDropdown(driver, patientStatus);
		clickOnTheSearchButton(driver);
	}

	public String captureReason_ReferOpTOIp(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, reason_ReferOpToIp);
		String text = reason_ReferOpToIp.getText();
		return text;
	}

	public void selectdate(WebDriver driver, int MinusDate) throws Throwable {
		String date = generateDateForDatePicker_MinusDate(MinusDate);
		String[] date1 = date.split(" ");
		String month = date1[0];
		String day = date1[1];
		String year = date1[2];
		select_DatePicker(driver, admissionDate, month, day, year);
	}

	public void selectAdmissionFromDate(WebDriver driver, int MinusDate) throws Throwable {
		String date = generateDateForDatePicker_MinusDate(MinusDate);
		String[] date1 = date.split(" ");
		String month = date1[0];
		String day = date1[1];
		String year = date1[2];
		select_DatePicker(driver, admissionFromDate, month, day, year);

	}

	public void selectAdmissionToDate(WebDriver driver, int MinusDate) throws Throwable {
		String date = generateDateForDatePicker_MinusDate(MinusDate);
		String[] date1 = date.split(" ");
		String month = date1[0];
		String day = date1[1];
		String year = date1[2];
		select_DatePicker(driver, admissionToDate, month, day, year);
	}

	public void verifyThatAdmittedDatesAreWithinRange(WebDriver driver, String fromDate1, String toDate1)
			throws Throwable {
//		List<WebElement> dateElements = listOfAdmittedDateInTable_AdmittedTab;
//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
//		LocalDate fromDate = LocalDate.parse(fromDate1, dateFormatter);
//		LocalDate toDate = LocalDate.parse(toDate1, dateFormatter);
//		 try {
//	            while (true) {
//	                for (WebElement dateElement : dateElements) {
//	                    String dateText = dateElement.getText().substring(0, 10);
//	                    DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//	                    LocalDate date = LocalDate.parse(dateText, dateFormatter1);
//
//	                    if (!date.isBefore(fromDate) && !date.isAfter(toDate)) {
//	                        scrollToBottom(driver);
//	                        if (!nextPageBtn_AdmittedTab.isEnabled()) {
//	                            System.out.println("Next button is not clickable, skipping...");
//	                            return; 
//	                        } else {
//	                            scrollToBottom(driver);
//	                            explicityWaitForElemenToBeClickable(driver, nextPageBtn_AdmittedTab);
//	                            invisibiltyOf_Element_ThreeDots(driver);
//	                            nextPageBtn_AdmittedTab.click();
//	                            invisibiltyOf_Element_ThreeDots(driver);
//	                        }
//	                    } else {
//	                        Assert.fail("date is not within range");
//	                    }
//	                }
//	            }
//	        } catch (StaleElementReferenceException e) {
//	           
//	        }      
//	    }	

		List<WebElement> dateElements = listOfAdmittedDateInTable_AdmittedTab;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate fromDate = LocalDate.parse(fromDate1, dateFormatter);
		LocalDate toDate = LocalDate.parse(toDate1, dateFormatter);

		boolean dateOutOfRange = false;

		try {
			for (WebElement dateElement : dateElements) {
				String dateText = dateElement.getText().substring(0, 10);
				DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate date = LocalDate.parse(dateText, dateFormatter1);

				if (!date.isBefore(fromDate) && !date.isAfter(toDate)) {
					dateOutOfRange = false;
					scrollToBottom(driver);
					nextPageBtn_AdmittedTab.click();
				} else {
					dateOutOfRange = true;
				}
			}
			if (dateOutOfRange) {
				Assert.fail("At least one date is not within range");
			}

			if (!nextPageBtn_AdmittedTab.isEnabled()) {
				System.out.println("Next button is not clickable, skipping...");
			}
		} catch (StaleElementReferenceException e) {
		}
	}

	public String captureAdmittedDate_ActiveTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = admissionDate_Table_ActiveTab.getText().substring(0, 10).replace("-", "");
		System.out.println(date);
		return date;
	}

	public void verifyThatAdmissionDate_ActiveList(WebDriver driver) throws Throwable {

		String selectedDateStr = admissionDate_ActiveList.getAttribute("value");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date selectedDate = dateFormat.parse(selectedDateStr);

		List<WebElement> dateElements = listOfAdmissionDateInTable_ACtiveTab;
		for (WebElement dateElement : dateElements) {
			scrollDownThePageUntilElementIsVisible(driver, dateElement);
			String dateStr = dateElement.getText().substring(0, 10);
			Date date = dateFormat.parse(dateStr);

			if (date.after(selectedDate) || date.equals(selectedDate)) {
				System.out.println(dateStr + " is on or after the selected date.");
				scrollToBottom(driver);
				if (nextPageBtn_AdmittedTab.isEnabled()) {
					scrollToBottom(driver);
					System.out.println("2");
					Thread.sleep(3000);
					nextPageBtn_AdmittedTab.click();
				} else {
					System.out.println("next button is disabled ....skipping next button");
					break;
				}
			} else {
				Assert.fail("List Of date is not in the range");
			}
		}
	}

}