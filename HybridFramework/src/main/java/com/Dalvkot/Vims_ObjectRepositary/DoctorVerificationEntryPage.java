
package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DoctorVerificationEntryPage extends WebDriverUtility {

	public DoctorVerificationEntryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Doctor Verification Entry ']")
	private WebElement doctorVerificationEntryBtn;

	@FindBy(xpath = "//span[text()=' Second Doctor Verification Entry ']")
	private WebElement secondDoctorVerificationEntryBtn;

	@FindBy(xpath = "//span[@title='BIOCHEMISTRY']/following-sibling::span[1]")
	private WebElement serviceClassDropdownBtn;

	@FindBy(xpath = "//input[@formcontrolname='selectionDate']")
	private WebElement technicianEntryDateCalendar;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberText_SelectionDetails;

	@FindBy(xpath = "//span[@title='Select Department Name']/following-sibling::span[1]")
	private WebElement departmentNameDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span[1]")
	private WebElement wardTypeDropdownBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement emergencySampleCheckBox;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[2]//a")
	private WebElement sampleNumber_TechnicianVerifiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr/td[2]//a")
	private List<WebElement> sampleNumber_ListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[3]")
	private WebElement sampleType_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[4]")
	private WebElement technicianVerfiedDate_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumber_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[last()]/td[5]")
	private WebElement hospitalNumber_LastRow_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[6]")
	private WebElement patientName_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[7]")
	private WebElement doctorName_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[8]")
	private WebElement department_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[9]")
	private WebElement roomType_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='techniciancompleteList']//table/tbody/tr[1]/td[last()]")
	private WebElement wardType_TechnicianVeirfiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement sampleNumberInTable_verifiedListTab;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[last()]/td[2]")
	private WebElement sampleNumberInTable_LastRow_verifiedListTab;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement doctorVerifiedDate_VerifiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement hospitalNumber_VerifiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement patientName_VerifiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement doctorName_VerifiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement department_VerifiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement roomType_VerifiedListTable;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement wardType_VerifiedListTable;

	@FindBy(xpath = "//input[@formcontrolname='sampleNo']")
	private WebElement sampleNumberText;

	@FindBy(xpath = "//input[@placeholder='Sample from']")
	private WebElement sampleFrom;

	@FindBy(xpath = "//span[text()='DOCTOR VERIFIED']/following-sibling::span")
	private WebElement statusDropdownBtn;

	@FindBy(xpath = "(//span[@title='select']/following-sibling::span)[1]")
	private WebElement reasonDropdownBtn;

	@FindBy(xpath = "//label[text()='Re-Test Type']/..//span[@role='presentation']")
	private WebElement reTestTypeDropdownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]")
	private WebElement heading_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]")
	private WebElement previousResult_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]")
	private WebElement units_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement referenceRange_ResultEntryTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/input[@placeholder='Result']")
	private WebElement result_ResultEntryTable;

	@FindBy(xpath = "//table//tbody/tr[1]/td[8]/descendant::input[@placeholder='Remarks']")
	private WebElement remarks_ResultEntryTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[9]/descendant::input[@placeholder='Notes']")
	private WebElement notesToPatientText_ResultEntryTable;

	@FindBy(xpath = "//table//tr[1]/td[10]/descendant::input[@placeholder='Notes']")
	private WebElement noteToDoctor_ResultEntryTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[11]/descendant::a[contains(text(),'View')]")
	private WebElement previewResult_ResultEntryTable;

	@FindBy(xpath = "//table[@class='table table-responsive-md text-center']/tbody/tr[1]/td[2]")
	private WebElement date_previousResultDetailsPopupTable;

	@FindBy(xpath = "//table[@class='table table-responsive-md text-center']/tbody/tr[1]/td[3]")
	private WebElement serviceName_previousResultDetailsPopupTable;

	@FindBy(xpath = "//table[@class='table table-responsive-md text-center']/tbody/tr[1]/td[4]")
	private WebElement normalValues_previousResultDetailsPopupTable;

	@FindBy(xpath = "//table[@class='table table-responsive-md text-center']/tbody/tr[1]/td[5]")
	private WebElement patientValue_previousResultDetailsPopupTable;

	@FindBy(xpath = "//table[@class='table table-responsive-md text-center']/tbody/tr[1]/td[6]")
	private WebElement remarks_previousResultDetailsPopupTable;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement intMark_previousResultDetailsPopupTable;

	@FindBy(xpath = "//textarea[contains(@class,'form-control ng-pristine')]")
	private WebElement remarksNotesText;

	@FindBy(xpath = "//button[text()=' Previous Record']")
	private WebElement previousRecordBtn;

	@FindBy(xpath = "//button[text()='Next Record ']")
	private WebElement nextRecord;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement doctorVerfiedBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnsuccessfullyMessage;

	@FindBy(xpath = "//a[text()='Verified List']")
	private WebElement verifiedTab;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberInSelectionDetails;

	@FindBy(xpath = "//div[@id='doctorcompleteList']//table/tbody//tr[1]//td[last()]//a")
	private WebElement amendBtnUnderVerifiedListTab;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[12]/a[1]")
	private WebElement eyeIconFornotes;

	@FindBy(xpath = "//label[text()=' Interpretation Required']/following-sibling::textarea")
	private WebElement interpretationTextArea;

	@FindBy(xpath = "//label[text()='Impression']/following-sibling::textarea")
	private WebElement impressionTextArea;

	@FindBy(xpath = "//label[text()='Notes']/following-sibling::textarea")
	private WebElement notesTextArea;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtnUnderEyeIcon;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[11]/a[1]")
	private WebElement viewBtnInResultEntry;

	@FindBy(xpath = "/html/body/app-root/app-home/app-doctor-verification-entry-manage/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[3]")
	private WebElement serviceNameInViewPopUP;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5])[2]")
	private WebElement resultValueInViewPopUP;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]")
	private WebElement firstRowElement;

	@FindBy(xpath = "(//button[@class='close']//span)[2]")
	private WebElement xforViewPopUp;

	@FindBy(xpath = "//div[@id='doctorcompleteList']/descendant::table/tbody/tr[1]/td[last()-1]/descendant::label")
	private WebElement statusFieldInTableUnderverifeidList;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement backBtn;

	@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
	private WebElement serviceClassInSelctionDetails;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[2]")
	private WebElement headingInSelctionDetails;

	@FindBy(xpath = "(//div[contains(@class,'form-group col-lg-4')])[2]")
	private WebElement patientNameInSelectionDetails;

	@FindBy(xpath = "(//div[contains(@class,'form-group col-lg-4')]//label)[1]")
	private WebElement hospitalNumberInSelectionDetails;

	@FindBy(xpath = "//button[text()='Yes, submit it!']")
	private WebElement yesSubmitBtn;

	// ----------------------------------Buisness
	// Logics----------------------------------------

	public void clickOnDoctorVerificationEntryPage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, doctorVerificationEntryBtn);
	}

	public void clickOnSecondDoctorVerificationEntryPage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, secondDoctorVerificationEntryBtn);
	}

	public void selectServiceClass(WebDriver driver, String serviceClass) throws InterruptedException {
		serviceClassDropdownBtn.click();
		dropdownText.sendKeys(serviceClass, Keys.ENTER);
	}

	public void clickOn_SampleNumber_TechnicianVerifiedList(WebDriver driver) {
		sampleNumber_TechnicianVerifiedListTable.click();
	}

	public String doctorVerificationEntry(WebDriver driver, String hospitalNumber) throws Throwable {

		enterHospitalNumber(driver, hospitalNumber);

		clickOnTheSearchButton(driver);

		clickOn_SampleNumber_TechnicianVerifiedList(driver);

		String samnum = sampleNumberInSelectionDetails.getAttribute("value");

		scrollDownTheStillEndOfThePage(driver);

		result_ResultEntryTable.sendKeys("25");

		noteToDoctor_ResultEntryTable.sendKeys("testing");

		notesToPatientText_ResultEntryTable.sendKeys("test");

		remarks_ResultEntryTable.sendKeys("123test123");

		moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);

		clickOn_YesSubmitItBtn(driver);

		clickOn_OkButton_SuccessfullyMessage(driver);

		return samnum;
	}

	public void clickOnDoctorVerifiedBtnAndOkBtn(WebDriver driver, String hospitalNumber) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, doctorVerfiedBtn);
		clickOn_YesSubmitItBtn(driver);
		clickOn_OkButton_SuccessfullyMessage(driver);
	}

	public void searchHospitalNumberAndClickOnsampleNumberInTable(WebDriver driver, String hospitalNumber)
			throws Throwable {

		hospitalNumberText.sendKeys(hospitalNumber);
		searchBtn.click();
		moveToTheParticularElementAndClick(driver, sampleNumber_TechnicianVerifiedListTable);
	}

	public void scrollDown(WebDriver driver) throws Throwable {

		scrollDownTheStillEndOfThePage(driver);
	}

	public void retestInDoctorVerificationEntry(WebDriver driver, String retestType) throws Throwable {
		statusDropdownBtn.click();
		dropdownText.sendKeys("RE-TEST", Keys.DOWN, Keys.ENTER);

		reasonDropdownBtn.click();
		dropdownText.sendKeys("CLOTTED BLOOD SAMPLE", Keys.DOWN, Keys.ENTER);

		moveToTheParticularElementAndClick(driver, reTestTypeDropdownBtn);
		dropdownText.sendKeys(retestType, Keys.ENTER);

		scrollDownTheStillEndOfThePage(driver);

		moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);
		clickOn_YesSubmitItBtn(driver);
		clickOn_OkButton_SuccessfullyMessage(driver);
	}

	public void clickOnVerfiedListTab(WebDriver driver) throws InterruptedException {

		moveToTheParticularElementAndClick(driver, verifiedTab);
	}

	public void clickOnVerfiedListTab_Only(WebDriver driver) throws InterruptedException {

		verifiedTab.click();
	}

	public String verifyVerifiedSampleNumberIsReflectingInVerifiedList(WebDriver driver, String hospitalNumber)
			throws Throwable {
		enterHospitalNumber(driver, hospitalNumber);

		clickOnTheSearchButton(driver);

		clickOn_AmendButton_UnderVerifedListTab(driver);

		String sampleNo = capture_SampleNumberIn_SelectionDetails(driver);

		return sampleNo;

	}

	public String capture_SampleNumberIn_SelectionDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampleNo = sampleNumberInSelectionDetails.getAttribute("value");
		return sampleNo;
	}

	public void clickOn_AmendButton_UnderVerifedListTab(WebDriver driver) {

		amendBtnUnderVerifiedListTab.click();
	}

	public void clickOn_SampleNumber_VerifiedList(WebDriver driver) {

		sampleNumberInTable_verifiedListTab.click();
	}

	public String verifyVerifiedSampleNumberIsReflectingInVerifiedList2(WebDriver driver, String hospitalNumber)
			throws Throwable {

		enterHospitalNumber(driver, hospitalNumber);

		clickOnTheSearchButton(driver);

		clickOn_SampleNumber_VerifiedList(driver);

		String b = statusFieldInTableUnderverifeidList.getText();

		amendBtnUnderVerifiedListTab.click();

		return b;
	}

	public void verifyVerifiedSampleNumberIsReflectingInVerifiedList1(WebDriver driver, String hospitalNumber)
			throws Throwable {
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		clickOn_SampleNumber_VerifiedList(driver);
	}

	public String verifyAmendentText(WebDriver driver) throws InterruptedException {

		String a = statusFieldInTableUnderverifeidList.getText();
		return a;
	}

	public void verifyAmendentIsWorkingAsExpected(WebDriver driver) throws InterruptedException {
		scrollDownTheStillEndOfThePage(driver);

		noteToDoctor_ResultEntryTable.sendKeys("testing321");

		notesToPatientText_ResultEntryTable.sendKeys("test123");

		remarks_ResultEntryTable.sendKeys("123test123");

		moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);

		clickOn_YesSubmitItBtn(driver);

		clickOn_OkButton_SuccessfullyMessage(driver);
	}

	public void verifyNotesUnderEyeIcon(WebDriver driver) throws InterruptedException {

		scrollDownTheStillEndOfThePage(driver);

		eyeIconFornotes.click();

		interpretationTextArea.clear();

		interpretationTextArea.sendKeys("test123!@#");

		impressionTextArea.clear();

		impressionTextArea.sendKeys("test321$%^");

		notesTextArea.clear();

		notesTextArea.sendKeys("test456^&*");

		moveToTheParticularElementAndClick(driver, updateBtnUnderEyeIcon);

		eyeIconFornotes.click();

		String inter = interpretationTextArea.getAttribute("value");

		String imper = impressionTextArea.getAttribute("value");

		String not = notesTextArea.getAttribute("value");

		Assert.assertEquals(inter, "test123!@#");
		System.out.println("successfully inrterpretation required text is updating");

		Assert.assertEquals(imper, "test321$%^");
		System.out.println("successfully impression text is updating");

		Assert.assertEquals(not, "test456^&*");
		System.out.println("successfully notes text is updating");

	}

	public String verifyserviceNameInViewPopup(WebDriver driver) throws InterruptedException {

		scrollDownTheStillEndOfThePage(driver);
		viewBtnInResultEntry.click();

		String sn = serviceNameInViewPopUP.getText();

		clickOnTheElementUsedToJavascriptExecuter(driver, xforViewPopUp);
		return sn;
	}

	public String verifyResultValueInViewPopup(WebDriver driver) throws InterruptedException {

		String rv = resultValueInViewPopUP.getAttribute("value");

		clickOnTheElementUsedToJavascriptExecuter(driver, xforViewPopUp);
		return rv;

	}

	public void verifyNextRecordBtnAndPreviousRecordBtn(WebDriver driver) throws Throwable {

		String samNum = sampleNumberInSelectionDetails.getAttribute("value");

		int i = Integer.parseInt(samNum);

		int finalSamNum = i + 1;

		int preSamNum = i - 1;

		System.out.println(preSamNum);

		System.out.println(finalSamNum);

		scrollDownTheStillEndOfThePage(driver);

		moveToTheParticularElementAndClick(driver, nextRecord);

		scrollUpUsingActions(driver);

		String samNum1 = sampleNumberInSelectionDetails.getAttribute("value");

		scrollDownTheStillEndOfThePage(driver);

		moveToTheParticularElementAndClick(driver, previousRecordBtn);

		scrollUpUsingActions(driver);

		String presam = sampleNumberInSelectionDetails.getAttribute("value");

		Assert.assertEquals(samNum1, finalSamNum);
		System.out.println("Successfully next record button verified");

		Assert.assertEquals(presam, preSamNum);
		System.out.println("Successfully previous record button verified");

	}

	public void clickOnBackBtn(WebDriver driver) throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		backBtn.click();
	}

	public String captureSampleNumberInSelectionDetails(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sam2 = sampleNumberInSelectionDetails.getAttribute("value");
		System.out.println(sam2);
		return sam2;
	}

	public String capturePatientNameInSelectionDetails(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pat = patientNameInSelectionDetails.getText();
		int colonIndex = pat.indexOf(":");
		String pat2 = pat.substring(colonIndex + 1).trim();
		return pat2;
	}

	public String captureServiceClassInSelectionDetails(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ser = serviceClassInSelctionDetails.getAttribute("value");
		return ser;
	}

	public String captureRefernceRangeInSelectionDetails(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ref = referenceRange_ResultEntryTable.getText();
		return ref;
	}

	public String captureServiceNameInSelectionDetails(WebDriver driver) throws InterruptedException {
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, headingInSelctionDetails);
		String hea = headingInSelctionDetails.getText();
		return hea;
	}

	public String captureResultInSelectionDetails(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String res = result_ResultEntryTable.getAttribute("value");
		return res;
	}

	public String captureHospitalNumberInSelectionDetails(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hsp = hospitalNumberInSelectionDetails.getText();
		int colonIndex = hsp.indexOf(":");
		String hsp1 = hsp.substring(colonIndex + 1).trim();
		System.out.println("hsp1" + hsp1);
		return hsp1;
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void selectServiceDetails(WebDriver driver, String serviceClass) {
		dropdown_Handling(driver, 3, serviceClassDropdownBtn, dropdownText, serviceClass);
	}

	public void enterTechnicianEntryDate(WebDriver driver, String technicianEntryDate) {
		technicianEntryDateCalendar.sendKeys(technicianEntryDate);
	}

	public void enterSampleNumber(WebDriver driver, String sampleNumber) {
		sampleNumberText.sendKeys(sampleNumber);
	}

	public void selectDepartmentName(WebDriver driver, String departmentName) throws Throwable {
		departmentNameDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, departmentName);
	}

	public void selectWardType(WebDriver driver, String wardType) {

		dropdown_Handling(driver, 3, wardTypeDropdownBtn, dropdownText, wardType);
	}

	public void clickOnTheSearchButton(WebDriver driver) throws Throwable {

		searchBtn.click();

	}

	public void clickOnClearButton(WebDriver driver) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, clearBtn);
	}

	public String takeSampleNumber_TechnicainVerifiedList(WebDriver driver) {

		String sampelNumber = sampleNumberInTable_verifiedListTab.getText();
		return sampelNumber;
	}

	public String takeSampleType_TechnicainVerifiedList(WebDriver driver) {

		String sampleType = sampleType_TechnicianVeirfiedListTable.getText();
		return sampleType;
	}

	public String takeTechnicianVerifiedDate(WebDriver driver) {

		String tvDate = technicianVerfiedDate_TechnicianVeirfiedListTable.getText();
		String technicianVerifiedDate = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(tvDate, 5);
		return technicianVerifiedDate;
	}

	public String takeHospitalNumber_TechnicianVerifiedList(WebDriver driver) {

		String hospitalNumber = hospitalNumber_TechnicianVeirfiedListTable.getText();
		return hospitalNumber;
	}

	public String takePatientName_TechnicianVerifedList(WebDriver driver) {

		String pN = patientName_TechnicianVeirfiedListTable.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pN, 18);
		return patientName;
	}

	public String takeDoctorName_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String doctorName = doctorName_TechnicianVeirfiedListTable.getText();
		return doctorName;
	}

	public String takeDepartment_TechnicianVeirfiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_TechnicianVeirfiedListTable.getText();
		return department;
	}

	public String takeRoomType_TechnicianVeirfiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = roomType_TechnicianVeirfiedListTable.getText();
		return roomType;
	}

	public String takeWardType_TechnicianVerifiedist(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = wardType_TechnicianVeirfiedListTable.getText();
		return wardType;
	}

	public String takeSampleNumber_VerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampleNumber = sampleNumberInTable_verifiedListTab.getText();
		return sampleNumber;
	}

	public String takeDoctorVerifiedDate(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dVerifiedDate = doctorVerifiedDate_VerifiedListTable.getText();
		String doctorVerifiedDate = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(dVerifiedDate, 6);
		return doctorVerifiedDate;
	}

	public String takeHospitalNumber_VerificationList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_VerifiedListTable.getText();
		return hospitalNumber;
	}

	public String takePatientName_verificationList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = patientName_VerifiedListTable.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pName, 19);
		return patientName;
	}

	public String takeDoctorName_VerificationList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String doctorName = doctorName_VerifiedListTable.getText();
		return doctorName;
	}

	public String takeDepartment_VerificationList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_VerifiedListTable.getText();
		return department;
	}

	public String takeRoomType_verifictionList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String roomType = roomType_VerifiedListTable.getText();
		return roomType;
	}

	public String takeWardType_VerificationList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String wardType = wardType_VerifiedListTable.getText();
		return wardType;

	}

	public void clickOnVerifiedListButton(WebDriver driver) throws Throwable {
		verifiedTab.click();
	}

	public String takeSampleNumber_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampleNumber = sampleNumber_TechnicianVerifiedListTable.getText();
		return sampleNumber;
	}

	public void clickOnSampleNumberListTechnician_DoctorverificationProcess(WebDriver driver) throws Throwable {

		clickOn_SampleNumber_TechnicianVerifiedList(driver);

		scrollDownTheStillEndOfThePage(driver);

		noteToDoctor_ResultEntryTable.sendKeys("testing");

		notesToPatientText_ResultEntryTable.sendKeys("test");

		remarks_ResultEntryTable.sendKeys("123test123");

		moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);

		clickOn_YesSubmitItBtn(driver);

		clickOn_OkButton_SuccessfullyMessage(driver);
	}

	public void clickOn_OkButton_SuccessfullyMessage(WebDriver driver) {
		okBtnsuccessfullyMessage.click();
	}

	public void clickOnAmendButton_VerifedList(WebDriver driver) {
		scrollTillVisibleElement(driver, amendBtnUnderVerifiedListTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, amendBtnUnderVerifiedListTab);
	}

	public void clickOnCancelButton_SelectionDetails(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, cancelBtn);
		clickOnTheElementUsedToJavascriptExecuter(driver, cancelBtn);
	}

	public String takeServiceClassInTheSelectionDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String serviceClass = serviceClassInSelctionDetails.getText();
		return serviceClass;
	}

	public String capture_HospitalNumberLastRow_TechnicianVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_LastRow_TechnicianVeirfiedListTable.getText();
		return hospitalNumber;
	}

	public String takeSampleNumber_LastRow_TechnicainVerifiedList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String sampelNumber = sampleNumberInTable_LastRow_verifiedListTab.getText();
		return sampelNumber;
	}

	public void clickOn_YesSubmitItBtn(WebDriver driver) {
		yesSubmitBtn.click();
	}

	public String doctorVerificationEntry_For_Descriptive(WebDriver driver, String hospitalNumber) throws Throwable {

		enterHospitalNumber(driver, hospitalNumber);

		clickOnTheSearchButton(driver);

		clickOn_SampleNumber_TechnicianVerifiedList(driver);

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String samnum = sampleNumberInSelectionDetails.getText();
		scrollDownTheStillEndOfThePage(driver);

		noteToDoctor_ResultEntryTable.sendKeys("testing");

		notesToPatientText_ResultEntryTable.sendKeys("test");

		remarks_ResultEntryTable.sendKeys("123test123");

		moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);

		clickOn_YesSubmitItBtn(driver);

		clickOn_OkButton_SuccessfullyMessage(driver);

		return samnum;
	}

	public void doctorVerificationEntry_2(WebDriver driver, String hospitalNumber, String serviceClass)
			throws Throwable {
		enterHospitalNumber(driver, hospitalNumber);
		selectServiceClass(driver, serviceClass);
		clickOnTheSearchButton(driver);
		int count = sampleNumber_ListTable.size();
		clickOn_SampleNumber_TechnicianVerifiedList(driver);
		for (int i = 0; i < count; i++) {
			scrollDownTheStillEndOfThePage(driver);
			moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);
			clickOn_YesSubmitItBtn(driver);
			clickOn_OkButton_SuccessfullyMessage(driver);
		}
	}

	public void doctorVerificationEntry_3(WebDriver driver, String hospitalNumber) throws Throwable {

		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		int count = sampleNumber_ListTable.size();
		clickOn_SampleNumber_TechnicianVerifiedList(driver);
		for (int i = 0; i < count; i++) {

			scrollDownTheStillEndOfThePage(driver);
			moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);
			clickOn_YesSubmitItBtn(driver);
			clickOn_OkButton_SuccessfullyMessage(driver);
		}
	}

	public void doctorVerificationEntry_dynamic(WebDriver driver, List<String> serviceClasses, String hospitalNumber)
			throws Throwable {
		for (String serviceClass : serviceClasses) {

			enterHospitalNumber(driver, hospitalNumber);
			selectServiceClass(driver, serviceClass);
			clickOnTheSearchButton(driver);
			int count = sampleNumber_ListTable.size();
			clickOn_SampleNumber_TechnicianVerifiedList(driver);
			for (int i = 0; i < count; i++) {

				scrollDownTheStillEndOfThePage(driver);
				moveToTheParticularElementAndClick(driver, doctorVerfiedBtn);
				clickOn_YesSubmitItBtn(driver);
				clickOn_OkButton_SuccessfullyMessage(driver);
			}
		}
	}

}