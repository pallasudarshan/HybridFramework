package com.Dalvkot.Vims_ObjectRepositary;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class UserListPage extends WebDriverUtility {
	public UserListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' User List ']")
	private WebElement userListBtn;

	@FindBy(xpath = "//input[@placeholder=' Name']")
	private WebElement nameText;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailText;

	@FindBy(xpath = "//span[@title='Please select the User Type']/following-sibling::span[1]")
	private WebElement userTypedropdown;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	private WebElement phoneNumberText;

	@FindBy(xpath = "//span[@title='Please select the role']/following-sibling::span")
	private WebElement roleDropdown;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindAll({ @FindBy(xpath = "//input[@formcontrolname='firstName']"), @FindBy(id = "FirstName"),
			@FindBy(xpath = "//input[@placeholder='First Name']") })
	private WebElement firstNameText;

	@FindAll({ @FindBy(id = "SecondName"), @FindBy(xpath = "//input[@formcontrolname='SecondName']") })
	private WebElement lastName;

	@FindAll({ @FindBy(xpath = "//input[@placeholder='Employee Id']"),
			@FindBy(xpath = "//label[text()='Employee Code ']/following-sibling::input") })
	private WebElement employeeCodeText;

	@FindAll({ @FindBy(xpath = "//input[@placeholder='Mail_Id']"),
			@FindBy(xpath = "//label[text()='Email']/..//input") })
	private WebElement emailIdText;

	@FindAll({ @FindBy(xpath = "//span[@title='Gender']/following-sibling::span[1]") })
	private WebElement genderDropdownBtn;

	@FindAll({ @FindBy(xpath = "//input[@formcontrolname='mobileNumber']"), @FindBy(id = "MobileNumber") })
	private WebElement mobileNumberText;

	@FindAll({ @FindBy(id = "PinCode"), @FindBy(xpath = "//input[@formcontrolname='pincode']") })
	private WebElement pincodeText;

	@FindAll({ @FindBy(xpath = "//span[@title='Please select the department']/following-sibling::span[1]"),
			@FindBy(xpath = "//label[text()='Department ']/..//span[@class='select2-selection__arrow']") })
	private WebElement departmentDropdownBtn;

	@FindAll({ @FindBy(xpath = "//span[@title='Please select the User Type']/following-sibling::span[1]"),
			@FindBy(xpath = "//label[text()='User Type ']/..//span[@class='select2-selection__arrow']") })
	private WebElement userTypeDropdown;

	@FindAll({ @FindBy(xpath = "//span[@title='role_type']/following-sibling::span"),
			@FindBy(xpath = "//label[text()='Role Type ']/..//span[@role='presentation']") })
	private WebElement roleTypeDropdownBtn;

	@FindAll({ @FindBy(xpath = "//span[@title='Please select the role']/following-sibling::span[1]"),
			@FindBy(xpath = "//label[text()='Role ']/..//span[@class='select2-selection__arrow']") })
	private WebElement roleDropdownBtn;

	@FindAll({ @FindBy(xpath = "//textarea[@formcontrolname='addressline1']") })
	private WebElement addressLineText;

	@FindAll({ @FindBy(linkText = "Store Link"), @FindBy(xpath = "//a[contains(text(),'Store Link')]") })
	private WebElement storeLinkTab;

	@FindAll({ @FindBy(linkText = "Clearance Type"), @FindBy(xpath = "//a[contains(text(),'Clearance Type')]") })
	private WebElement clearenceTypeTab;

	@FindAll({ @FindBy(linkText = "Authorization"), @FindBy(xpath = "//a[contains(text(),'Authorization')]") })
	private WebElement authorizationTab;

	@FindAll({
			@FindBy(xpath = "//div[@id='LabLink']/descendant::table/tbody/tr[1]/td[2]/descendant::span[@role='presentation']"),
			@FindBy(xpath = "(//span[@title='Select']/following-sibling::span)[1]") })
	private WebElement serviceGroupDropdown_labRadiologyLink;

	@FindAll({
			@FindBy(xpath = "//div[@id='LabLink']/descendant::table/tbody/tr[1]/td[3]/descendant::span[@role='presentation']"),
			@FindBy(xpath = "") })
	private WebElement serviceClassDropdown_labRadiologyLink;

	@FindAll({ @FindBy(xpath = "//div[@id='LabLink']/descendant::table/tbody/tr[1]/td[5]/descendant::input") })
	private WebElement effectoveFromDate_labRadiologyLink;

	@FindAll({
			@FindBy(xpath = "//div[@id='LabLink']/descendant::table/tbody/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-plus']"),
			@FindBy(xpath = "(//button[@type='button']//i)[1]") })
	private WebElement actionBtn_labRadiologyLink;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[4])[1]")
	private WebElement email_Table;

	@FindBy(xpath = "//button[text()=' PDF ']/..//table//tbody//tr[last()]//td[4]")
	private WebElement email_Table_Last;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionBtn_Table;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[last()]/descendant::button[text()=' Reset Password'])[1]")
	private WebElement resetPassword_Table;

	@FindBy(xpath = "(//input[@formcontrolname='newPassword'])[2]")
	private WebElement newPassword_ResetPassword;

	@FindBy(xpath = "(//input[@placeholder=' Confirm new Password'])[2]")
	private WebElement confirmNewPassword_ResetPassword;

	@FindBy(xpath = "(//button[text()=' Change Password '])[2]")
	private WebElement changePasswordBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnMessagePopup;

	@FindBy(xpath = "//a[contains(.,'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorMsg;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement name_Table;

	@FindBy(xpath = "//button[text()=' PDF ']/..//table//tbody//tr[last()]//td[2]")
	private WebElement nameLast_Table;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3])[1]")
	private WebElement userType_Table;

	@FindBy(xpath = "//button[text()=' PDF ']/..//table//tbody//tr[last()]//td[5]")
	private WebElement phoneNumberLast_Table;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5])[1]")
	private WebElement phoneNumber_Table;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[6])[1]")
	private WebElement department_Table;

	@FindBy(xpath = "//button[text()=' PDF ']/..//table//tbody//tr[1]//td[last()-2]")
	private WebElement role_Table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()]//button[text()=' Edit']")
	private WebElement editBtn_Action;

	@FindBy(xpath = "//table/tbody/tr[1]/td[last()-1]//span[@data-on='Yes']/following-sibling::span")
	private WebElement statusToggleBtn;

	@FindBy(xpath = "//button[text()='Confirm Deactivate']")
	private WebElement confirmDeactivateBtn;

	@FindBy(xpath = "(//button[text()='Cancel'])[1]")
	private WebElement cancelBtn;

	/*
	 * Buiness Logics
	 * 
	 */
	public void clickOnUserList(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, userListBtn);
	}

	public void enterEmail_Filter(String email) {
		emailIdText.sendKeys(email);
	}

	public void clickOnSearch(WebDriver driver, String name) {
		nameText.sendKeys(name);
	}

	public void enterPhoneNumber_Filter(WebDriver driver, String phoneNumber) {
		phoneNumberText.sendKeys(phoneNumber);
	}

	public void selectUserType_Filter(WebDriver driver, String userType) throws Throwable {
		userTypedropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, userType);
	}

	public void selectRole_Filter(WebDriver driver, String role) throws Throwable {
		Thread.sleep(1000);
		roleDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, role);
	}

	public void clickOnSearch_Filter(WebDriver driver) {
		searchBtn.click();
	}

	public void clickOn_Clear_Filter(WebDriver driver) {
		clearBtn.click();
	}

	public void enterFirstName(WebDriver driver, String firstName) {
		scrollDownThePageUntilElementIsVisible(driver, firstNameText);
		firstNameText.clear();
		firstNameText.sendKeys(firstName);

	}

	public void enterLastName(WebDriver driver, String name) {
		lastName.clear();
		lastName.sendKeys(name);

	}

	public void enterEmployeeCode(WebDriver driver, String employeeCode) {
		employeeCodeText.clear();
		employeeCodeText.sendKeys(employeeCode);
	}

	public void enterEmailId(WebDriver driver, String emailId) {
		emailIdText.sendKeys(emailId);

	}

	public void selectGender(WebDriver driver, String gender) {
		genderDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, gender);
	}

	public void enterMobileNumber(WebDriver driver, String mobileNumber) {
		mobileNumberText.clear();
		mobileNumberText.sendKeys(mobileNumber);

	}

	public void enterPincode(WebDriver driver, String pincode) {
		pincodeText.sendKeys(pincode);

	}

	public void selectDepartment(WebDriver driver, String department) {
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);
	}

	public void selectUserType(WebDriver driver, String userType) {
		userTypedropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, userType);

	}

	public void selectRoleType(WebDriver driver, String roleType) {
		roleTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, roleType);

	}

	public void selectRole(WebDriver driver, String role) {
		roleDropdown.click();
		moveToElementAndEnterTheData(driver, dropdownText, role);

	}

	public void enterAddressText(WebDriver driver, String address) {
		addressLineText.sendKeys(address);

	}

	public void selectServiceGroup_labRadiologyLink(WebDriver driver, String serviceGroup) {
		serviceGroupDropdown_labRadiologyLink.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceGroup);

	}

	public void selectServiceClass_LabRadiologyLink(WebDriver driver, String serviceClass) {
		serviceClassDropdown_labRadiologyLink.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceClass);

	}

	public void enetrEffectiveFrom_LabRadiologyLink(WebDriver driver, String date) {
		effectoveFromDate_labRadiologyLink.sendKeys(date);
	}

	public void clickOnActionsButton_LabRadiologyLink(WebDriver driver) {
		actionBtn_labRadiologyLink.click();
	}

	public void clickOnSumbitButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitButton);
		submitButton.click();
	}

	public void enterEmail(WebDriver driver) {
		String randomEmail = generateRandomEmail();
		emailText.clear();
		emailText.sendKeys(randomEmail);
	}

	public void clickOnSearch(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, searchBtn);
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public void clickOnActions_Table(WebDriver driver) {
		actionBtn_Table.click();
	}

	public void clickOnResetPassword(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, resetPassword_Table);
		resetPassword_Table.click();
	}

	public void enterNew_ConfirmPassword_ClickOnChangeButton(WebDriver driver, String password) {
		newPassword_ResetPassword.sendKeys(password);
		confirmNewPassword_ResetPassword.sendKeys(password);

		explictWaitForElementToBeVisible(driver, changePasswordBtn);
		moveToTheParticularElementAndClick(driver, changePasswordBtn);
	}

	public void clickOnOkMessagePopup(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, okBtnMessagePopup);
		okBtnMessagePopup.click();
	}

	public void clickOnAddBtn(WebDriver driver) {
		addBtn.click();
	}

	public String captureErrorMsg(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String errorMsg1 = errorMsg.getText();
		return errorMsg1;
	}

	public void enterName_Filter(String name) {
		nameText.sendKeys(name);
	}

	public String captureNameInTable(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String name = name_Table.getText();
		return name;
	}

	public String captureNameLastInTable(WebDriver driver) throws Throwable {
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, nameLast_Table);
		String name = nameLast_Table.getText();
		return name;
	}

	public String captureEmailInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String email = email_Table.getText();
		return email;
	}

	public String captureEmailInLastTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, email_Table_Last);
		String email = email_Table_Last.getText();
		return email;
	}

	public String captureUserTypeInTable(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String userType = userType_Table.getText();
		return userType;
	}

	public String capturePhoneNumberInTable(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String phoneNumber = phoneNumber_Table.getText();
		return phoneNumber;
	}

	public String capturePhoneNumberInLastTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, phoneNumberLast_Table);
		String phoneNumber = phoneNumberLast_Table.getText();
		return phoneNumber;
	}

	public String captureRoleInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String role = role_Table.getText();
		return role;
	}

	public void enter_Email_Filter(WebDriver driver, String email) {
		emailIdText.sendKeys(email);
	}

	public void clickOnEditUnderAction_table(WebDriver driver) {
		editBtn_Action.click();
	}

	public String captureDepartmentInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		String role = department_Table.getText();
		return role;
	}

	public void clickOnStatusToggleBtn(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		statusToggleBtn.click();
	}

	public void clickOnConfirmDeactivateBtn(WebDriver driver) throws Throwable {
		confirmDeactivateBtn.click();
		clickOnOkMessagePopup(driver);
	}

	public String captureStatusToggleBtnText(WebDriver driver) throws Throwable {
		String text = statusToggleBtn.getAttribute("data-on");
		System.out.println(text);
		return text;
	}

	public void verifyToggleBtnIsNotSelected(WebDriver driver) {
		boolean isOn = statusToggleBtn.isSelected();
		if (isOn) {
			Assert.fail("tetetnjbdshdsa");
		} else {
			System.out.println("Toggle button is Off.");
		}
	}

	public void clickOnCancelBtn(WebDriver driver) throws Throwable {
		cancelBtn.click();
	}

}
