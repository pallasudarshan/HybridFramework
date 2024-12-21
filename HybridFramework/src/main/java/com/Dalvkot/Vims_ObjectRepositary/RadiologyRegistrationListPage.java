package com.Dalvkot.Vims_ObjectRepositary;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class RadiologyRegistrationListPage extends WebDriverUtility {
	public RadiologyRegistrationListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ----------X-Paths------------

	@FindBy(xpath = "//span[text()=' Radiology Registration List ']")
	private WebElement radioLogyRegistrationBtn;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
	private WebElement BillTypeDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Bill No']")
	private WebElement billNoTextField;

	@FindBy(xpath = "//input[@placeholder='Hospital No']")
	private WebElement hospitalNumbertextField;

	@FindBy(xpath = "(//input[@placeholder='Date'])[1]")
	private WebElement fromDateField;

	@FindBy(xpath = "(//input[@type='date'])[2]")
	private WebElement toDateField;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
	private WebElement departmentDropDownbtn;

	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear ']")
	private WebElement clearBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDowntext;

	@FindBy(xpath = "//a[contains(text(),'Pending')]")
	private WebElement pendingTab;

	@FindBy(xpath = "//a[contains(text(),'Completed')]")
	private WebElement completedTab;

	@FindBy(xpath = "//a[contains(text(),'Cancelled')]")
	private WebElement cancelledTab;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement billNoInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billDateInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement hospitalNumberRealPatient_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[2]//a")
	private WebElement hospitalNumber_DummyPatient_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement opNumberInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement ipNumberInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement patientNameInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement ageInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement genderInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement specialityNameInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement roomTypeInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement bedNumberInTable_PendingList;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[1]/td[13]/descendant::button")
	private WebElement viewDiagnosisInTable_PendingList;

	@FindBy(xpath = "//a[contains(.,'Next page')]")
	private WebElement nextPageBtn;

	@FindBy(xpath = "//a[contains(.,'Previous page')]")
	private WebElement previousPageBtn;

	@FindBy(xpath = "(//table[@class='table row-border hover ng-star-inserted']/tbody/tr[1]/td[2]/descendant::span)[1]")
	private WebElement serviceClassInPopup;

	@FindBy(xpath = "(//table[@class='table row-border hover ng-star-inserted']/tbody/tr[1]/td[3]/descendant::input)[1]")
	private WebElement serviceNameInPopup;

	@FindBy(xpath = "(//table[@class='table row-border hover ng-star-inserted']/tbody/tr[1]/td[4]/descendant::input)[1]")
	private WebElement QtyFieldPopup;

	@FindBy(xpath = "(//table[@class='table row-border hover ng-star-inserted']/tbody/tr[1]/td[5]/descendant::input)[1]")
	private WebElement totalAmountInPopup;

	@FindBy(xpath = "(//table[@class='table row-border hover ng-star-inserted']/tbody/tr[1]/td[6]/descendant::input)[1]")
	private WebElement clinicalNotesInPopup;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]//descendant::span[@role='presentation']")
	private WebElement radiographerDropDownbtn;

	@FindBy(xpath = "//div[@id='exampleModalCenter']//table//tr[1]//td[last()]//input[@id='selectCheckId']")
	private WebElement selectCheckboxInPopup;

	@FindBy(xpath = "//label[text()=' Select All Services     ']/following-sibling::input")
	private WebElement selectAllServicesCheckBox;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement submitBtnInPopUp;

	@FindBy(xpath = "(//button[text()=' Cancel'])[2]")
	private WebElement cancelBtnInPopUp;

	@FindBy(xpath = "(//span[text()='×'])[3]")
	private WebElement xBtnInPopup;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement registrationNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement registrationdateInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement billNoInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement billDateInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement hospitalNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement opNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement ipNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement patientNameInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement ageInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement genderInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement specialityNameInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[13]")
	private WebElement roomTypeInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[14]")
	private WebElement bedNumberInTable_CompletedList;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[1]/td[15]/descendant::button")
	private WebElement actionBtnInTable_CompletedList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[2]/descendant::A")
	private WebElement billNoInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[2]//a")
	private WebElement billDateInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement serviceNameInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumberInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement opNumberInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement ipNumberInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement patientNameInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement specialityNameInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement roomTypeInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement bedNumberRoomTypeInTable_CancelledList;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement cancelReasonTypeInTable_CancelledList;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	private WebElement checkBox_SearchFilter;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//div[@class='circle-wrap ng-star-inserted']")
	private WebElement loader;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[last()]/td[2]/descendant::a")
	private WebElement billNoInTable_PendingList_LastRow;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[last()]/td[4]")
	private WebElement hospitalNumberInTable_PendingList_LastRow;

	@FindBy(xpath = "//div[@id='pending']/descendant::table/tbody/tr[last()]/td[10]")
	private WebElement specialityNameInTable_PendingList_LastRow;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[last()]/td[4]")
	private WebElement billNoInTable_CompletedList_LastRow;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement hospitalNumberInTable_CompletedList_LastRow;

	@FindBy(xpath = "//div[@id='completed']/descendant::table/tbody/tr[last()]/td[12]")
	private WebElement specialityNameInTable_CompletedList_LastRow;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[last()]/td[2]//a")
	private WebElement billDateInTable_CancelledList_LastRow;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement hospitalNumberInTable_CancelledList_LastRow;

	@FindBy(xpath = "//div[@id='cancelled']/descendant::table/tbody/tr[last()]/td[9]")
	private WebElement specialityNameInTable_CancelledList_lastrow;

	@FindBy(xpath = "(//tr[@class='ng-star-inserted']//input)[1]")
	private WebElement serviceName_Popup;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//button[1]")
	private WebElement cancelBtn_ActionBtn_CompletedList;

	@FindBy(xpath = "//textarea[@placeholder='Reason']")
	private WebElement reasonTextArea;

	@FindBy(xpath = "//label[text()='Select Service']/following::input")
	private WebElement checkBox_CancelReason;

	@FindBy(xpath = "//div[@class='col-sm-12']//button[1]")
	private WebElement submit_Cancel;

	@FindBy(xpath = "//td[@class='text-wrap']//div[1]")
	private WebElement codeDescription_DiagnosisDetaial;

	@FindBys({ @FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr/td[3]/div[1]") })
	private List<WebElement> List_CodeDescription_DiagnosisDetaial;

	@FindBy(xpath = "//button[@data-target='#Cancelmodal']")
	private WebElement cancelBtn_Action_CompletedList;

	@FindBy(xpath = "//button[text()=' Actions ']")
	private WebElement actionBtn;

	// ---------logics----------

	public void clickOnRadiologyRegistrationScreenBtn(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, radioLogyRegistrationBtn);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void selectBillType_Filter(WebDriver driver, String billType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown_Handling(driver, 5, BillTypeDropDownBtn, dropDowntext, billType);
	}

	public void enterBillNo_filter(WebDriver driver, String billNo) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		billNoTextField.sendKeys(billNo);
	}

	public void enterHospitalNumber_filter(WebDriver driver, String hospitalNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		hospitalNumbertextField.clear();
		hospitalNumbertextField.sendKeys(hospitalNumber);
	}

	public void enterFromDate(WebDriver driver, String fromDate) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		fromDateField.sendKeys(fromDate);
	}

	public void entertoDate(WebDriver driver, String toDate) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		toDateField.sendKeys(toDate);
	}

	public void selectDepartment_Filter(WebDriver driver, String department) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown_Handling(driver, 5, departmentDropDownbtn, dropDowntext, department);
	}

	public void clickOnBillNumberInTable_pendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		billNoInTable_PendingList.click();
		;
	}

	public void clickOnSubmit(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtnInPopUp.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		getWindowHandles(driver);
	}

	public void clickOnCancel(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		cancelBtnInPopUp.click();

	}

	public void selectAllServicesCheckBox(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		selectAllServicesCheckBox.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void selectCheckBoxInTable_PopUp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		selectCheckboxInPopup.click();
	}

	public void selectRadiographer(WebDriver driver, String radiographer) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown_Handling(driver, 5, radiographerDropDownbtn, dropDowntext, radiographer);
	}

	public void clickOnXbtn_PopUp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		selectCheckboxInPopup.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnOkBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtn.click();
	}

	public void clickOnClearBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		clearBtn.click();
	}

	public void clickOnSearchBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		searchBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String captureBillNoInTable_PendingList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNo = billNoInTable_PendingList_LastRow.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		System.out.println(billNo);
		return billNo;
	}

	public String captureBillNoInTable_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNo = billNoInTable_PendingList.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return billNo;
	}

	public String captureHospitalNumberInTable_PendingList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumberInTable_PendingList_LastRow.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		System.out.println(hosp);
		return hosp;
	}

	public String captureHospitalNumberInTable_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumber_DummyPatient_PendingList.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return hosp;
	}

	public String captureHospitalNumber_RealPatient_InTable_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumberRealPatient_PendingList.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return hosp;
	}

	public String captureDepartmentInTable_PendingList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = specialityNameInTable_PendingList_LastRow.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		System.out.println(department);
		return department;
	}

	public String captureDepartmentInTable_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = specialityNameInTable_PendingList.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return department;
	}

	public void clickOnCompletedTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		completedTab.click();
	}

	public String captureBillNoInTable_CompletedList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNo = billNoInTable_CompletedList_LastRow.getText();
		System.out.println(billNo);
		return billNo;
	}

	public String captureBillNoInTable_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNo = billNoInTable_CompletedList.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return billNo;
	}

	public String captureHospitalNumberInTable_CompletedList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumberInTable_CompletedList_LastRow.getText();
		System.out.println(hosp);
		return hosp;
	}

	public String captureHospitalNumberInTable_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumberInTable_CompletedList.getText();
		System.out.println(hosp);
		return hosp;
	}

	public String captureDepartmentInTable_CompletedList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = specialityNameInTable_CompletedList_LastRow.getText();
		System.out.println(department);
		return department;
	}

	public String captureDepartmentInTable_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = specialityNameInTable_CompletedList.getText();
		return department;
	}

	public void clickOnCancelledTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		cancelledTab.click();
	}

	public String captureBillNoInTable_CancelledList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNo = billDateInTable_CancelledList_LastRow.getText();
		return billNo;
	}

	public String captureBillNoInTable_CancelledList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String billNo = billDateInTable_CancelledList.getText();
		return billNo;
	}

	public String captureHospitalNumberInTable_CancelledList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumberInTable_CancelledList_LastRow.getText();
		System.out.println(hosp);
		return hosp;
	}

	public String captureHospitalNumberInTable_CancelledList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hosp = hospitalNumberInTable_CancelledList.getText();
		System.out.println(hosp);
		return hosp;
	}

	public String captureDepartmentInTable_CancelledList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = specialityNameInTable_CancelledList_lastrow.getText();
		System.out.println(department);
		return department;
	}

	public String captureDepartmentInTable_CancelledList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = specialityNameInTable_CancelledList.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return department;
	}

	public String captureServiceName_BillNo_PopUp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ser = serviceName_Popup.getAttribute("value");
		return ser;
	}

	public void clickOnCancelUnderAction_CompletedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		doubleClick(driver, actionBtnInTable_CompletedList);
		cancelBtn_ActionBtn_CompletedList.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void enterDataInReasontextArea(WebDriver driver, String reason) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		reasonTextArea.sendKeys(reason);
	}

	public void selectCheckbox_Cancel(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, checkBox_CancelReason);
		checkBox_CancelReason.click();
	}

	public void clickOnSubmit_Cancel(WebDriver driver) throws Throwable {
		scrollToBottom(driver);
		scrollDownThePageUntilElementIsVisible(driver, submit_Cancel);
		clickOnTheElementUsedToJavascriptExecuter(driver, submit_Cancel);
	}

	public void clickOnCheckBox_SearchFilter(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		checkBox_SearchFilter.click();
	}

	public void clickOnViewFinalDiagnosis_PendingList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		viewDiagnosisInTable_PendingList.click();
	}

	public String captureCodeDescription_DiagnosisDetails(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String cd = codeDescription_DiagnosisDetaial.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return cd;
	}

	public String captureListOfCodeDescription_DiagnosisDetails(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String cd = codeDescription_DiagnosisDetaial.getText();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		return cd;
	}

	public List<String> captureListOfCodeDescription_viewDiagnosis_radiologyResgidtration(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		List<String> cd = new ArrayList<>();
		for (WebElement element : List_CodeDescription_DiagnosisDetaial) {
			String text = element.getText();
			cd.add(text);
		}
		System.out.println(cd);
		return cd;
	}

	public void verifyThatCancelButtonIsNotReflectingAfterModaliltyConfirmationIsDone(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		doubleClick(driver, actionBtn);
		try {
			if (cancelBtn_Action_CompletedList.isDisplayed()) {
				Assert.fail(
						"cancel button is displaying after modalilty confirmation is done in radiology registration list completed list");
			} else {
				System.out.println("cancel button is not displaying");
			}
		} catch (Exception e) {
		}
	}
}
