package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class SurgeryMasterPage extends WebDriverUtility {

	public SurgeryMasterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Surgery Master ']")
	private WebElement surgeryMasterLink;

	@FindBy(xpath = "//input[@placeholder='Surgery Name']")
	private WebElement surgeryNameText;

	@FindBy(xpath = "//input[@placeholder='Surgery Code']")
	private WebElement surgeryCodeText;

	@FindBy(xpath = "//input[@placeholder='Effective From']")
	private WebElement effectiveFromDate;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement OkPopupBtn;

	@FindBy(xpath = "//div[text()='Please enter the service details']")
	private WebElement pleaseEnterTheServiceDetails_Popup;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[text()=' Search']/ancestor::div[@class='row']/descendant::i[@class='zmdi zmdi-close-circle']")
	private WebElement clearButton;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[2]")
	private WebElement srgeryName_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[3]")
	private WebElement surgeryCode_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[4]")
	private WebElement effectiveFromDate_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-edit']")
	private WebElement editButton_Table;

	@FindBy(xpath = "//button[text()=' Add']")
	private WebElement addButton;

	@FindBy(xpath = "//span[text()='Select Department Name']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement departmentDropdownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//span[text()='Sub group']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement subGropupDropdownBtn;

	@FindBy(xpath = "//span[text()='OT grade']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement otGradeDropdownBtn;

	@FindBy(xpath = "//span[text()='Select rate type']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement rateTypeDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='Surgery Name']")
	private WebElement surgeryNameText_ServiceDescription;

	@FindBy(xpath = "//input[@placeholder='Service Short Name']")
	private WebElement serviceShortNameText;

	@FindBy(xpath = "//input[@placeholder='Effective From']")
	private WebElement effectiveFromDate_ServiceDescription;

	@FindBy(xpath = "//input[@placeholder='Effective To']")
	private WebElement effectiveTo;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement applicableToAllRateTypeCheckBox;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement serviceDescriptionDropdownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]/descendant::span[@role='presentation']")
	private WebElement serviceTypeDropdownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]/descendant::span[@role='presentation']")
	private WebElement serviceClassDropdownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]/descendant::span[@role='presentation']")
	private WebElement serviceRuleDropdownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[6]/descendant::input[@placeholder='Rate']")
	private WebElement rateText;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[7]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement actionBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[2]/td[7]/descendant::i[@class='zmdi zmdi-delete']")
	private WebElement deleteServiceDetails;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr[*]/td[7]/descendant::i[@class='zmdi zmdi-delete']") })
	private List<WebElement> deleteMultipleServiceDetails;

	@FindBy(xpath = "//table[@id='example']/ancestor::div[@class='body']/descendant::i[@class='zmdi zmdi-card-sd']")
	private WebElement submitBtn;

	@FindBy(xpath = "//table[@id='example']/ancestor::div[@class='body']/descendant::i[@class='zmdi zmdi-close-circle']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[text()=' Please select Department ']")
	private WebElement pleaseSelectDepartnent_Popup;

	@FindBy(xpath = "//div[text()=' Please select Sub Group ']")
	private WebElement pleaseSelectSubGroup_Popup;

	@FindBy(css = "div[role='alertdialog']")
	private WebElement pleaseSelectSurgeryName_Popup;

	@FindBy(css = "div[role='alertdialog']")
	private WebElement pleaseEnterSurgeryShortName;

	// Buisness logic

	public void clickOnTheSurgeryMasterLink(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, surgeryMasterLink);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnTheAddButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButton);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void selectDepartmentDropdown(WebDriver driver, String departmentName) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, departmentName);
	}

	public void selectSubGroupDropdown(WebDriver driver, String subGroup) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		subGropupDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, subGroup);
	}

	public void enterTheDataInTheSurgeryName(String surgeryName) {
		surgeryNameText.sendKeys(surgeryName);
	}

	public void enterTheDataInTheServiceShortName(String serviceShortName) {
		serviceShortNameText.sendKeys(serviceShortName);
	}

	public void selectOtGradeDropdown(WebDriver driver, String otGrade) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		otGradeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, otGrade);
	}

	public void selectEffectiveDate(String date) {
		effectiveFromDate.sendKeys(date);
	}

	public void selectRateTypeDropdown(WebDriver driver, String rateType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		rateTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, rateType);
	}

	public void clickOnTheOkPopupBtn() {
		OkPopupBtn.click();
	}

	public String pleaseEnterTheServiceDetails_PopupMsg() {
		String msg = pleaseEnterTheServiceDetails_Popup.getText();
		return msg;
	}

	public void clickOnTheActionButton() throws Throwable {
		Thread.sleep(2000);
		actionBtn.click();
	}

	public void selectServiceDescriptionDropdown(WebDriver driver, String serviceDescription) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		serviceDescriptionDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceDescription);
	}

	public void selectServiceTypeDropdown(WebDriver driver, String serviceType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		serviceTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceType);
	}

	public void selectServiceClassDropdown(WebDriver driver, String serviceClass) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		serviceClassDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceClass);
	}

	public void selectServiceRuleDropdown(WebDriver driver, String serviceRule) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		serviceRuleDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceRule);
	}

	public void enterTheDataInTheRate(String rate) {
		rateText.sendKeys(rate);
	}

	public int countOfTheServiceDetailsInTheTable() throws Throwable {
		int count1 = 1;
		List<WebElement> count = deleteMultipleServiceDetails;
		for (WebElement w : count) {
			count1++;
		}
		return count1;

	}

	public int deleteMultipleServiceDetails(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		int count2 = 1;
		List<WebElement> count = deleteMultipleServiceDetails;
		for (WebElement w : count) {
			w.click();
			count2++;
		}
		return count2;
	}

	public void clickOnTheEdotButton() {
		editButton_Table.click();
	}

	public String errorPopupMessage(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		explictWaitForElementToBeVisible(driver, pleaseSelectSurgeryName_Popup);
		String errorMsg = pleaseSelectSurgeryName_Popup.getText();
		pleaseSelectSurgeryName_Popup.click();
		return errorMsg;
	}

	public void clickOnTheSubmitButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtn.click();
	}

}
