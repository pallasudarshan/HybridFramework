package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class LabReportViwerPage extends WebDriverUtility {

	public LabReportViwerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Hospital No']")
	private WebElement hospitalNumberField;

	@FindBy(xpath = "//label[text()='Patient Name']/following-sibling::input")
	private WebElement patientNameField;

	@FindBy(xpath = "(//input[@id='selectionDate'])[1]")
	private WebElement resultFromDateField;

	@FindBy(xpath = "(//input[@placeholder='Sample date'])[2]")
	private WebElement resultToDateField;

	@FindBy(xpath = "(//span[@role='presentation'])[1]")
	private WebElement serviceClassDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement searchBoxForDropDown;

	@FindBy(xpath = "//input[@placeholder='Bill Number']")
	private WebElement billNumberTextField;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberTextField;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-default')])[2]")
	private WebElement clearBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement withHeaderCheckBox;

	@FindBy(xpath = "(//a[@class='badge badge-success'])[1]")
	private WebElement sampleNoInTable_FirstRow;

	@FindBy(xpath = "(//table[@id='example']//button)[1]")
	private WebElement printBtnInTable;

	@FindBy(xpath = "(//button[@type='button']/following-sibling::button)[2]")
	private WebElement noMailIdBtninTable;

	@FindBy(xpath = "//a[contains(text(),'Doctor Verified List')]")
	private WebElement doctorVerifiedListTab;

	@FindBy(id = "techVerification")
	private WebElement technicianVerifiedListTab;

	@FindBy(xpath = "//a[contains(text(),'External Lab Reports')]")
	private WebElement externalLabReportsTab;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table[@id='example']/tbody/tr[1]/td[1]")
	private WebElement slNoInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[2]")
	private WebElement billNoInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[3]")
	private WebElement hospitalNoInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[4]")
	private WebElement patientNameInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]//a")
	private WebElement sampleNoInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[5]")
	private WebElement billTypeInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[6]")
	private WebElement resultDateInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[7]")
	private WebElement serviceClassInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[1]/td[8]")
	private WebElement technicianVerifiedStatus_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tbody[1]/tr[1]/td[9]")
	private WebElement doctorVerifiedStatus_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tbody[1]/tr[1]/td[last()]//descendant::button[1]")
	private WebElement printBtnInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tbody[1]/tr[1]/td[last()]//descendant::button[2]")
	private WebElement sendToPatientBtnInTable_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table[@id='example']/tbody[1]/tr[1]/td[10]/descendant::button[2]")
	private WebElement noMailIdInTable_DoctorVerifiedLIst;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement backBtn;

	@FindBy(xpath = "//button[text()='Next Record ']")
	private WebElement nextRecordBtn;

	@FindBy(xpath = "//button[text()=' Previous Record']")
	private WebElement previousRecordBtn;

	@FindBy(xpath = "(//th[text()='Patient Name']/following-sibling::td)[2]")
	private WebElement patientNameUnderLabReport;

	@FindBy(xpath = "(//th[text()='Age']/following-sibling::td)[2]")
	private WebElement ageUnderLabReport;

	@FindBy(xpath = "(//th[text()='Patient Type']/following-sibling::td)[2]")
	private WebElement patientTypeUnderLabReport;

	@FindBy(xpath = "(//th[text()='Billing Date']/following-sibling::td)[2]")
	private WebElement billingDateUnderLabReport;

	@FindBy(xpath = "(//th[text()='Hospital No']/following-sibling::td)[2]")
	private WebElement hospitalNumberUnderLabReport;

	@FindBy(xpath = "(//th[text()='Sample Reg']/following-sibling::td)[2]")
	private WebElement sampleRegUnderLabReport;

	@FindBy(xpath = "(//th[text()='Room Type']/following-sibling::td)[2]")
	private WebElement roomTypeUnderLabReport;

	@FindBy(xpath = "(//th[text()='Sample Type']/following-sibling::td)[2]")
	private WebElement sampleTypeUnderLabReport;

	@FindBy(xpath = "(//th[text()='Bill No']/following-sibling::td)[2]")
	private WebElement billNoUnderLabReport;

	@FindBy(xpath = "(//th[text()='Gender']/following-sibling::td)[2]")
	private WebElement genderUnderLabReport;

	@FindBy(xpath = "(//th[text()='Bed No']/following-sibling::td)[2]")
	private WebElement bedNumberUnderLabReport;

	@FindBy(xpath = "(//th[text()='Reported on']/following-sibling::td)[2]")
	private WebElement reportedOnUnderLabReport;

	@FindBy(xpath = "(//th[text()='Doctor Name']/following-sibling::td)[2]")
	private WebElement doctorNameUnderLabReport;

	@FindBy(xpath = "(//th[text()='Sample Number']/following-sibling::td)[2]")
	private WebElement sampleNumberUnderLabReport;

	@FindBy(xpath = "(//th[text()='Sample Ack']/following-sibling::td)[2]")
	private WebElement sampleAckUnderLabReport;

	@FindBy(xpath = "//span[text()=' Lab Reporter Viewer ']")
	private WebElement labReportViewerPage;

	@FindBy(xpath = "(//a[@class='badge badge-success'])[1]")
	private WebElement sampleNoInTable_TechnicianVerifiedList;

	@FindBy(xpath = "(//table[contains(@class,'table table-responsive-md')]//td)[3]")
	private WebElement hospiatlNoInTable_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@class='content']//td[1]")
	private WebElement sampleNameUnderLabReport;

	@FindBy(xpath = "//td[@class='text']/following-sibling::td[1]")
	private WebElement resultUnderLabReport;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[2]")
	private WebElement billNumber_TechnicianVerifiedList;

	@FindBy(xpath = "//td[text()='1']/following-sibling::a")
	private WebElement sampleNumber_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[3]")
	private WebElement hospitalNumber_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[4]")
	private WebElement PatientName_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[5]")
	private WebElement billType_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[6]")
	private WebElement resultDate_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[7]")
	private WebElement serviceClass_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[1]//td[last()]//button")
	private WebElement printButton_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td[2]")
	private WebElement billNumber_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td[3]")
	private WebElement hospitalNumber_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td[4]")
	private WebElement patientName_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td[5]")
	private WebElement billType_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td[6]")
	private WebElement resultDate_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td[7]")
	private WebElement serviceClass_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table//tr[last()]//td/following-sibling::a")
	private WebElement sampleNumber_LastRow_TechnicianVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]/td[2]")
	private WebElement billNumber_LastRow_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]/td[4]")
	private WebElement patientName_LastRow_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]//a")
	private WebElement sampleNumber_LastRow_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]/td[5]")
	private WebElement billType_LastRow_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]/td[6]")
	private WebElement resultDate_LastRow_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]/td[7]")
	private WebElement serviceClass_LastRow_DoctorVerifiedList;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table//tr[last()]/td[3]")
	private WebElement hospitalNumber_LastRow_DoctorVerifiedList;

	// -----------------Buissness logics--------------------
	public void clickOnLabReportViewerPageBtn(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, labReportViewerPage);
	}

	public void clickOn_TechnicianVerifiedList_Tab(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		explictWaitForElementToBeVisible(driver, technicianVerifiedListTab);
		technicianVerifiedListTab.click();
	}

	public String verifyLabTechnicianEntryIsDisplayingInLabReportViewer(WebDriver driver, String hospitalNumber)
			throws Throwable {
		clickOn_TechnicianVerifiedList_Tab(driver);
		Thread.sleep(7000);
		hospitalNumberField.sendKeys(hospitalNumber);
		searchBtn.click();
		Thread.sleep(2000);
		explictWaitForElementToBeVisible(driver, sampleNoInTable_TechnicianVerifiedList);
		moveToTheParticularElementAndClick(driver, sampleNoInTable_TechnicianVerifiedList);
		String hsptl = hospiatlNoInTable_TechnicianVerifiedList.getText();
		explictWaitForElementToBeVisible(driver, sampleNoInTable_TechnicianVerifiedList);
		sampleNoInTable_TechnicianVerifiedList.click();
		Thread.sleep(2000);
		return hsptl;
	}

	public void ClickONVerifeidTabAndSearchHospitalNumber(WebDriver driver, String hospitalNumber)
			throws InterruptedException {

		explictWaitForElementToBeVisible(driver, doctorVerifiedListTab);
		doctorVerifiedListTab.click();
		hospitalNumberField.sendKeys(hospitalNumber);
		explictWaitForElementToBeVisible(driver, searchBtn);
		searchBtn.click();
		Thread.sleep(7000);
		moveToTheParticularElementAndClick(driver, sampleNoInTable_TechnicianVerifiedList);
		String hsptl = hospiatlNoInTable_TechnicianVerifiedList.getText();
		sampleNoInTable_TechnicianVerifiedList.click();
		Thread.sleep(2000);
	}

	public String verifyExternalLabServicesIsDisplayingInLabReportViewer(WebDriver driver, String hospitalNumber)
			throws InterruptedException {
		explictWaitForElementToBeVisible(driver, externalLabReportsTab);
		externalLabReportsTab.click();

		Thread.sleep(7000);
		hospitalNumberField.sendKeys(hospitalNumber);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		searchBtn.click();

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(7000);
		scrollDownThePageUntilElementIsVisible(driver, sampleNoInTable_TechnicianVerifiedList);
		moveToTheParticularElementAndClick(driver, sampleNoInTable_TechnicianVerifiedList);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hsptl = hospiatlNoInTable_TechnicianVerifiedList.getText();
		return hsptl;
	}

	public String verifyDoctorVerifiedIsDisplayingInLabReportViewer(WebDriver driver, String hospitalNumber)
			throws InterruptedException {

		wait_For_Invisibilty_OfElement_ForLoader(driver);

		doctorVerifiedListTab.click();

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(7000);
		hospitalNumberField.sendKeys(hospitalNumber);
		searchBtn.click();

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(7000);
		scrollDownThePageUntilElementIsVisible(driver, sampleNoInTable_TechnicianVerifiedList);
		moveToTheParticularElementAndClick(driver, sampleNoInTable_TechnicianVerifiedList);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hsptl = hospiatlNoInTable_TechnicianVerifiedList.getText();

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		sampleNoInTable_TechnicianVerifiedList.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		Thread.sleep(2000);
		return hsptl;
	}

	public String capturePatientNameInReportViewer(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pat = patientNameUnderLabReport.getText();
		int colonIndex = pat.indexOf(":");
		String pat2 = pat.substring(colonIndex + 1).trim();
		System.out.println(pat2);
		return pat2;
	}

	public String captureSampleNumberInReportViewer(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pat = sampleNumberUnderLabReport.getText();
		int colonIndex = pat.indexOf(":");
		String pat2 = pat.substring(colonIndex + 1).trim();
		System.out.println(pat2);
		return pat2;
	}

	public String captureSampleNameInReportViewer(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String sampleName = sampleNameUnderLabReport.getText();
		System.out.println(sampleName);
		return sampleName;
	}

	public String captureResultInReportViewer(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String result = resultUnderLabReport.getText();
		System.out.println(result);
		return result;
	}

	public String captureHospitalNumberInReportViewer(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String hspl2 = hospitalNumberUnderLabReport.getText();
		int colonIndex = hspl2.indexOf(":");
		String hsp3 = hspl2.substring(colonIndex + 1).trim();
		System.out.println("hsp3" + hsp3);
		return hsp3;
	}

	public String capture_BillNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billNumber = billNumber_TechnicianVerifiedList.getText();
		return billNumber;
	}

	public String capture_SampleNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String sampleNumber = sampleNumber_TechnicianVerifiedList.getText();
		return sampleNumber;
	}

	public String capture_HospitalNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospiatlNoInTable_TechnicianVerifiedList.getText();
		return hospitalNumber;
	}

	public String capture_PatientName_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String patientName = PatientName_TechnicianVerifiedList.getText();
		return patientName;
	}

	public String capture_BillType_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billType = billType_TechnicianVerifiedList.getText();
		return billType;
	}

	public String capture_ServiceClass_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String serviceClass = serviceClass_TechnicianVerifiedList.getText();
		return serviceClass;
	}

	public void clickOn_PrintButtonTechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);

		printButton_TechnicianVerifiedList.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String capture_LastRow_BillNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billNumber = billNumber_LastRow_TechnicianVerifiedList.getText();
		return billNumber;
	}

	public String capture_LastRow_SampleNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String sampleNumber = sampleNumber_LastRow_TechnicianVerifiedList.getText();
		return sampleNumber;
	}

	public String capture_LastRow_HospitalNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String hospitalNumber = hospitalNumber_LastRow_TechnicianVerifiedList.getText();
		return hospitalNumber;
	}

	public String capture_LastRow_patientName_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String patientName = patientName_LastRow_TechnicianVerifiedList.getText();
		return patientName;
	}

	public String capture_LastRow_BillType_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billType = billType_LastRow_TechnicianVerifiedList.getText();
		return billType;
	}

	public String capture_LastRow_ServiceClass_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String serviceClass = serviceClass_LastRow_TechnicianVerifiedList.getText();
		return serviceClass;
	}

	public void clickOn_SearchButton_Filter(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);

		searchBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_CLearButton_Filter(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);

		clearBtn.click();
	}

	public void enterBillNumber_Filter(WebDriver driver, String BillNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		billNumberTextField.sendKeys(BillNumber);
	}

	public void enter_HospitalNumberFilter(WebDriver driver, String hospitalNumber) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		hospitalNumberField.sendKeys(hospitalNumber);
	}

	public void enter_PatientName_Filter(WebDriver driver, String patientName) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		patientNameField.sendKeys(patientName);
	}

	public void enter_SampleNumber_Filter(WebDriver driver, String sampleNumber) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		sampleNumberTextField.sendKeys(sampleNumber);
	}

	public void selectServiceClass_Filter(WebDriver driver, String serviceClass) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		dropdown(driver, serviceClassDropDownBtn, searchBoxForDropDown, serviceClass);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String capture_BillNumber_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billNumber = billNoInTable_DoctorVerifiedList.getText();
		return billNumber;
	}

	public String capture_SampleNumber_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String sampleNumber = sampleNoInTable_DoctorVerifiedList.getText();
		return sampleNumber;
	}

	public String capture_HospitalNumber_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String hospitalNumber = hospitalNoInTable_DoctorVerifiedList.getText();
		return hospitalNumber;
	}

	public String capture_PatientName_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String patientName = patientNameInTable_DoctorVerifiedList.getText();
		return patientName;
	}

	public String capture_BillType_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billType = billTypeInTable_DoctorVerifiedList.getText();
		return billType;
	}

	public String capture_ResultDate_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = resultDateInTable_DoctorVerifiedList.getText();
		return date;
	}

	public String capture_ServiceClass_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String serviceClass = serviceClassInTable_DoctorVerifiedList.getText();
		return serviceClass;
	}

	public String capture_TechnicianEnteryVerifiedStatus_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String status = technicianVerifiedStatus_DoctorVerifiedList.getText();
		return status;
	}

	public String capture_DoctorVerifiedStatus_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String status = doctorVerifiedStatus_DoctorVerifiedList.getText();
		return status;
	}

	public String capture_LastRow_BillNumber_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billNumber = billNumber_LastRow_DoctorVerifiedList.getText();
		return billNumber;
	}

	public String capture_LastRow_SampleNumber_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String sampleNumber = sampleNumber_LastRow_DoctorVerifiedList.getText();
		return sampleNumber;
	}

	public String capture_LastRow_HospitalNumber_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String hospitalNumber = hospitalNumber_LastRow_DoctorVerifiedList.getText();
		return hospitalNumber;
	}

	public String capture_LastRow_PatientName_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String patientName = patientName_LastRow_DoctorVerifiedList.getText();
		return patientName;
	}

	public String capture_LastRow_BillType_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String billType = billType_LastRow_DoctorVerifiedList.getText();
		return billType;
	}

	public String capture_LastRow_ServiceClass_DoctorVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		String serviceClass = serviceClass_LastRow_DoctorVerifiedList.getText();
		return serviceClass;
	}

}
