package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DoctorMasterPage extends WebDriverUtility {
	public DoctorMasterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' DoctorMaster ']")
	private WebElement doctorMasterBtn;

	@FindBy(xpath = "//i[@class='zmdi zmdi-plus-circle']")
	private WebElement addBtn;

	@FindBy(xpath = "//input[@formcontrolname='doctorName']")
	private WebElement doctorNameText;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span[1]")
	private WebElement departmentDropdownBtn;

	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	private WebElement phoneNumberText;

	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	private WebElement emailIdText;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//span[@title='Doctor Title']/following-sibling::span")
	private WebElement doctorTitleDropdown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBy(xpath = "//input[@formcontrolname='displayName']")
	private WebElement displayNameText;

	@FindBy(xpath = "//input[@formcontrolname='employeeId']")
	private WebElement employeeIdText;

	@FindBy(xpath = "//span[@title='Gender']/following-sibling::span")
	private WebElement genderDropdown;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement emailAddressText;

	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	private WebElement mobileNumberText;

	@FindBy(xpath = "//span[@title=' Doctor Type']/following-sibling::span")
	private WebElement doctorTypeDropdown;

	@FindBy(xpath = "//span[@title=' Doctor Category']/following-sibling::span")
	private WebElement doctorCategoryDropdown;

	@FindBy(xpath = "//input[@formcontrolname='doctorKmcReg']")
	private WebElement KMC_RegNo;

	@FindBy(xpath = "//input[@formcontrolname='doctorQualification']")
	private WebElement doctorQualificationText;

	@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[1]")
	private WebElement activeStatusBtn;

	@FindBy(xpath = "//textarea[@formcontrolname='address']")
	private WebElement addressText;

	@FindBy(xpath = "//span[@title='Organisation Id']/following-sibling::span")
	private WebElement organizationDropdown;
	@FindBy(xpath = "//span[@title='Group Id']/following-sibling::span")
	private WebElement groupIdDropdown;

	@FindBy(xpath = "//span[@title='Business Id']/following-sibling::span[1]")
	private WebElement buinessIdDropdown;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement departmentDropdown_DoctorDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]/descendant::span[@role='presentation']")
	private WebElement unitDropdown_DoctorDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]/descendant::span[@class='switch-handle']")
	private WebElement isUnitChiefBtn_DoctorDetails;

	@FindBy(xpath = "(//input[@type='date'])[1]")
	private WebElement effectiveFrom_DoctorDetails;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::i")
	private WebElement actionBtn_DoctorDetails;

	@FindBy(xpath = "(//button[text()=' submit '])[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "(//button[text()=' Cancel'])[1]")
	private WebElement cancelBtn;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[2])[1]")
	private WebElement doctorName_Table;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[3])[1]")
	private WebElement deapartment_Table;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[5])[1]")
	private WebElement phoneNumber_Table;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[4])[1]")
	private WebElement unit_Table;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[6])[1]")
	private WebElement email_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionBtn_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-edit']")
	private WebElement editAction_Table;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnForMessage;

	@FindBy(xpath = "//button[text()=' PDF']")
	private WebElement pdfBtn;

	@FindBy(xpath = "//button[text()=' Excel']")
	private WebElement excelBtn;

	@FindBy(xpath = "(//small[@class='text-danger'])[1]")
	private WebElement popupErrorMessage_mandatoryFields;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[2])[1]")
	private WebElement doctorName_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[3])[1]")
	private WebElement department_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[4])[1]")
	private WebElement unit_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[5])[1]")
	private WebElement phoneNumber_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[6])[1]")
	private WebElement email_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[7])[1]")
	private WebElement doctortype_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[8])[1]")
	private WebElement doctorCatagory_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[8])[1]")
	private WebElement doctorCatagory_Table;

	@FindBy(xpath = "//label[text()='Unit']/..//span[@class='select2-selection__arrow']")
	private WebElement unitDropDownBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[7])[1]")
	private WebElement doctortype_Table;

	/*
	 * 
	 * Buiness Logics
	 * 
	 */

	public void clickOnDoctorMaster(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, doctorMasterBtn);
	}

	public void enterDoctorName(String doctorName) {
		doctorNameText.sendKeys(doctorName);
	}

	public void clearTheDoctorName(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, doctorNameText);
	}

	public void selectDepartment(WebDriver driver, String department) throws Throwable {
		Thread.sleep(1000);
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);
	}

	public void selectUnit(WebDriver driver, String department) throws Throwable {
		Thread.sleep(1000);
		unitDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberText.sendKeys(phoneNumber);
	}

	public void enterEmailId(String emailId) {
		emailIdText.sendKeys(emailId);
	}

	public void clickOnSearch(WebDriver driver) {
		searchBtn.click();
	}

	public void clickOnClear(WebDriver driver) {
		clearBtn.click();
	}

	public String doctorNameInThe_Table(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String doctorName = doctorName_Table.getText();
		return doctorName;
	}

	public String departmentNameInThe_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String department = deapartment_Table.getText();
		return department;
	}

	public String phoneNumberInThe_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String phoneNumber = phoneNumber_Table.getText();
		return phoneNumber;
	}

	public String emailIdInThe_Table(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String email = email_Table.getText();
		return email;
	}

	public void clickOnTheActions_Edit(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		doubleClick(driver, actionBtn_Table);
		invisibiltyOf_Element_ThreeDots(driver);
		moveToTheParticularElementAndClick(driver, editAction_Table);
	}

	public void clearTheDoctorName_DisplayName_EmailId_PhonNumber() {
		doctorNameText.clear();
		displayNameText.clear();
		phoneNumberText.clear();
		emailAddressText.clear();
		okBtnForMessage.click();
	}

	public void selectDoctorTitle(WebDriver driver, String doctorTitle) {
		doctorTitleDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorTitle);
	}

	public void enterDoctorName(WebDriver driver, String doctorName) {
		doctorNameText.sendKeys(doctorName);
	}

	public void enterDisplayName(WebDriver driver, String displayName) {
		displayNameText.sendKeys(displayName);
	}

	public void enterEmployeeId(WebDriver driver, String employeeId) {
		employeeIdText.sendKeys(employeeId);
	}

	public void selectGender(WebDriver driver, String gender) {
		genderDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, gender);

	}

	public void enterEmailAddress(WebDriver driver, String email) {
		emailAddressText.sendKeys(email);
	}

	public void enterMobileNumber(WebDriver driver, String phoneNumber) {
		mobileNumberText.sendKeys(phoneNumber);
	}

	public void selectDoctorType(WebDriver driver, String doctorType) {
		doctorTypeDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorType);
	}

	public void selectDoctorCategory(WebDriver driver, String doctorCategory) {
		doctorCategoryDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorCategory);
	}

	public void clickOnActiveButton(WebDriver driver) {
		activeStatusBtn.click();
	}

	public void enterAddressInTheText(WebDriver driver, String address) {
		addressText.sendKeys(address);
	}

	public void selectOrganizationId(WebDriver driver, String organizationId) {
		scroolToSpecifiedHeight(driver, 500);
		organizationDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, organizationId);
	}

	public void selectGroupId(WebDriver driver, String groupId) throws Throwable {
		Thread.sleep(1000);
		groupIdDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, groupId);
	}

	public void selectBuinessId(WebDriver driver, String buinessId) throws Throwable {
		Thread.sleep(1000);
		buinessIdDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, buinessId);
	}

	public void selectDepartment_DoctorDetails(WebDriver driver, String department) {
		departmentDropdown_DoctorDetails.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);

	}

	public void selectUnit_DoctorDetails(WebDriver driver, String unit) throws Throwable {
		Thread.sleep(1000);
		unitDropdown_DoctorDetails.click();
		moveToElementAndEnterTheData(driver, dropdownText, unit);
	}

	public void enterEffectiveFrom_DoctorDetails(WebDriver driver, String effectiveFromDate) {
		effectiveFrom_DoctorDetails.sendKeys(effectiveFromDate);
	}

	public void actionButton_DoctorDetails(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, actionBtn_DoctorDetails);
	}

	public void clickOnTheActions_Table(WebDriver driver) {
		doubleClick(driver, actionBtn_Table);

	}

	public void clickOnTheSubmitButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		moveToTheParticularElementAndClick(driver, submitBtn);
	}

	public void clickOnTheCancelButton(WebDriver driver) {
		moveToTheParticularElementAndClick(driver, cancelBtn);
	}

	public void clickOnTheOkButtonOfPopupMessage(WebDriver driver) {
		okBtnForMessage.click();
	}

	public String errorMessage_MandatoryField(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String errorMsg = popupErrorMessage_mandatoryFields.getText();
		return errorMsg;
	}

	public String captureDoctorName_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = doctorName_Table_LastRow.getText();
		return text;
	}

	public String captureDoctorName_table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = doctorName_Table.getText();
		return text;
	}

	public String captureDepartment_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = department_Table_LastRow.getText();
		return text;
	}

	public String captureUnit_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = unit_Table_LastRow.getText();
		return text;
	}

	public String captureUnit_table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = unit_Table.getText();
		return text;
	}

	public String capturePhoneNumber_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = phoneNumber_Table_LastRow.getText();
		return text;
	}

	public String captureEmail_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = email_Table_LastRow.getText();
		return text;
	}

	public String captureDoctorType_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = doctortype_Table_LastRow.getText();
		return text;
	}

	public String captureDoctorCategory_table_LastRow(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = doctorCatagory_Table_LastRow.getText();
		return text;
	}

	public String captureDoctorCategory_table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = doctorCatagory_Table.getText();
		return text;
	}

	public String captureDoctorType_table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = doctortype_Table.getText();
		return text;
	}

	public void clickOnAddButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, addBtn);
	}

}
