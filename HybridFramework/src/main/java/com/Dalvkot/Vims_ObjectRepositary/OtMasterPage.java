package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class OtMasterPage extends WebDriverUtility {
	public OtMasterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()=' OT Master ']")
	private WebElement otMasterLink;

	@FindBy(xpath = "//div[@class='block-header']/descendant::i[@class='zmdi zmdi-plus-circle']")
	private WebElement addButton;

	@FindBy(xpath = "//span[text()='Select Store Name']/ancestor::span[@role='combobox']/descendant::span[@role='presentation']")
	private WebElement storeNameDropdownBtn;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-round']/descendant::i[@class='zmdi zmdi-search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//i[@class='zmdi zmdi-search']/following::button[@class='btn btn-primary btn-round']")
	private WebElement clearBtn;

	@FindBy(xpath = "//span[@title='Select Store Name']")
	private WebElement storeNameDropdown_EmptyName;

	@FindBy(xpath = "//ul[@class='ngx-pagination']/descendant::a[@aria-label='Next page']")
	private WebElement nextBtn_InTable;

	@FindBy(xpath = "//ul[@class='ngx-pagination']/descendant::a[@aria-label='Previous page']")
	private WebElement previousBtn_InTable;

	@FindBys({ @FindBy(xpath = "//ul[@class='ngx-pagination']/descendant::li[@class]/descendant::a[@tabindex=\"0\"]")

	})
	private List<WebElement> pageNumbers_InTable;

	@FindBy(xpath = "//label[text()=' OT Description ']/ancestor::div[@class='form-group col-lg-3 col-xl-3 col-sm-4 col-md-4 col-xs-4']/descendant::span[@role='presentation']")
	private WebElement otDescriptionDropdownBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	private WebElement storeName_InTheTable;

	@FindBy(xpath = "//label[text()='Store Description ']/ancestor::div[@class='form-group col-lg-3 col-xl-3 col-sm-4 col-md-4 col-xs-4']/descendant::span[@role='presentation']")
	private WebElement storeDescriptionDropdownBtn;

	@FindBy(xpath = "//a[@class='nav-link active']")
	private WebElement specialityTab;

	@FindBy(xpath = "//a[@class='nav-link']")
	private WebElement instrumentsTab;

	@FindBy(xpath = "//div[@id='speciality']//table//tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement clinicalDepartmentDropdownBtn;

	@FindBy(xpath = "//div[@id='speciality']/descendant::table/tbody/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement actionPlusBtn_Speciality;

	@FindBys({
			@FindBy(xpath = "//div[@id='speciality']/descendant::table/tbody/tr[position()>1]/td[last()]/descendant::i[@class='zmdi zmdi-delete']")

	})
	private List<WebElement> deleteBtnAction_SpecialityTable;

	@FindBys({
			@FindBy(xpath = "//div[@id='instruments']/descendant::table/tbody/tr[position()>1]/td[last()]/descendant::i[@class='zmdi zmdi-delete']")

	})
	private List<WebElement> deleteBtnAction_InstrumentsTable;

	@FindBy(xpath = "//div[@id='instruments']/descendant::table/tbody/tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement instrumentsDetailsDropdownBtn;

	@FindBy(xpath = "//div[@id='instruments']/descendant::table/tbody/tr[1]/td[3]/descendant::input[@placeholder='Quantity']")
	private WebElement quantityText;

	@FindBy(xpath = "//div[@id='instruments']/descendant::table/tbody/tr[1]/td[4]/descendant::span[@class='switchs-handle']")
	private WebElement activeStatus;

	@FindBy(xpath = "//div[@id='instruments']/descendant::table/tbody/tr[1]/td[5]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement actionBtn_Instruments;

	@FindBy(xpath = "//div[@id='instruments']/ancestor::form[@class='ng-untouched ng-invalid ng-dirty ng-submitted']/descendant::i[@class='zmdi zmdi-card-sd']")
	private WebElement submitBtn_Instruments;

	@FindBy(xpath = "//div[@id='instruments']/ancestor::form[@class='ng-untouched ng-invalid ng-dirty']/descendant::i[@class='zmdi zmdi-close-circle']")
	private WebElement cancelBtn_Instruments;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitBtn_Speciality;

	@FindBy(xpath = "//div[@id='speciality']/ancestor::form[@class='ng-untouched ng-invalid ng-dirty']/descendant::i[@class='zmdi zmdi-close-circle']")
	private WebElement canelBtn_Speciality;

	@FindBy(xpath = "//div[text()=' Please Select OT Description ']")
	private WebElement pleaseSelectOtDescription_Popup;

	@FindBy(xpath = "//div[text()=' Please Select Store Description ']")
	private WebElement pleaseSelectStoreDescription_Popup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement ok_Popup;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement onBtn_CombinationAleardy;

	@FindBy(xpath = "//div[text()=' Please Select Speciality Details ']")
	private WebElement pleaseSelectSpecialityDetails;

	@FindBy(xpath = "//div[text()=' Please Select Instrument Details ']")
	private WebElement pleaseSelectInstrumentsDetails;

	@FindBy(xpath = "//div[@aria-label='Please Enter Quantiy']")
	private WebElement pleaseEnterQuantity;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement popupErrorMessage_mandatoryFields;

	// Business Logics

	public void clickOnTheOtMasterLink(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, otMasterLink);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnTheAddButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		addButton.click();
	}

	public void selectStoreNameDropdown(WebDriver driver, String storeName) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		storeNameDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, storeName);
	}

	public String storeNameInTheTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String storeName = storeName_InTheTable.getText();
		return storeName;

	}

	public void clickOnOkSuccessMessageButton() throws Throwable {
		Thread.sleep(2000);
		ok_Popup.click();
	}

	public void clickOnTheSearchButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, searchBtn);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnTheClearButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, clearBtn);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnTheClearButton_ForLoader(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clearBtn.click();
	}

	public String storeNameInTheDropdown() {
		String name = storeNameDropdown_EmptyName.getText();
		return name;
	}

	public void clickOnThePageNumbersInTheTable() throws Throwable {
		List<WebElement> pages = pageNumbers_InTable;
		for (WebElement p : pages) {
			Thread.sleep(1000);
			p.click();
		}
	}

	public void selectOtDescriptionDropdown(WebDriver driver, String otDescription) throws Throwable {
		Thread.sleep(1000);
		otDescriptionDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, otDescription);
	}

	public void selectStoreDescriptionDropdown(WebDriver driver, String storeDescription) {
		storeDescriptionDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, storeDescription);
	}

	public void clickOnTheSpecialityTab(WebDriver driver) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, specialityTab);
	}

	public void clickOnTheInstrumentsTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, instrumentsTab);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void selectClinicalDepartmentDropdown(WebDriver driver, String clinicalDepartment) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, clinicalDepartmentDropdownBtn);
		clinicalDepartmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, clinicalDepartment);
	}

	public void clickOnTheActionsBtn_Speciality() throws Throwable {
		Thread.sleep(2000);
		actionPlusBtn_Speciality.click();
	}

	public void clickOnTheDeleteButton_Action_SpecialityTable(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		List<WebElement> list = deleteBtnAction_SpecialityTable;
		for (WebElement l : list) {
			l.click();
		}
		Thread.sleep(1000);
	}

	public void clickOnTheDeleteButton_Action_InstrumentsTable() {
		List<WebElement> list = deleteBtnAction_InstrumentsTable;
		for (WebElement l : list) {
			l.click();
		}
	}

	public void clickOnTheSubmitButton_Speciality() {
		submitBtn_Speciality.click();
	}

	public void clickOnTheCancelButton_Speciality() {
		canelBtn_Speciality.click();
	}

	public void selectInstrumentsDetailsDropdown(WebDriver driver, String instrumentsDetails) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		instrumentsDetailsDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, instrumentsDetails);
	}

	public void enterTheQuantity(String qty) {
		quantityText.sendKeys(qty);
	}

	public void clickOnTheActiveStatus() {

		activeStatus.click();
	}

	public void clickOnTheActionsBtn_Instruments() {
		actionBtn_Instruments.click();
	}

	public void clickOnTheSubmit_Instruments() {
		submitBtn_Instruments.click();
	}

	public void clickOnTheCancelBtn_Speciality() throws Throwable {
		cancelBtn_Instruments.click();
	}

	public String errorMessage_MandatoryField(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String errorMsg = popupErrorMessage_mandatoryFields.getText();
		return errorMsg;
	}

}
