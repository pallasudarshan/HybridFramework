package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class MHCPackagePage extends WebDriverUtility {

	public MHCPackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' MHC Package ']")
	private WebElement MHCPackage;

	@FindBy(xpath = "//span[@title='Rate Type']/following-sibling::span")
	private WebElement rateTypeDropdown;

	@FindBy(xpath = "//span[@title='Package Type']/following-sibling::span")
	private WebElement packageTypeDropdown;

	@FindBy(xpath = "//input[@formcontrolname='packageName']")
	private WebElement packageNameText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[contains(.,'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[2])[1]")
	private WebElement rateType_Table;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[3])[1]")
	private WebElement packageType_Table;

	@FindBy(xpath = "(//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[4])[1]")
	private WebElement packageName_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionBtn_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-striped')]/tbody[1]/tr[1]/td[last()]/descendant::button[text()=' Edit']")
	private WebElement editActions_Table;

	@FindBy(xpath = "//span[@title='Transaction Type']/following-sibling::span[1]")
	private WebElement transactionTypeDropdown;

	@FindBy(xpath = "//span[@title='Select Customer']/following-sibling::span[1]")
	private WebElement customerDrodown;

	@FindBy(xpath = "//input[@formcontrolname='packageCost']")
	private WebElement packagePriceText;

	@FindBy(xpath = "//table[@id='subtableid']/tbody/tr[1]/td[2]/descendant::input[@placeholder=\"Enter Service Name\"]")
	private WebElement servicesNameText;

	@FindBy(xpath = "//table[@id='subtableid']/tbody/tr[1]/td[last()-1]/descendant::input[@placeholder='Package Cost']")
	private WebElement packageCostText;

	@FindBy(xpath = "//table[@id='subtableid']//tr[1]/td[5]//button")
	private WebElement actionBtn_ServiceCharge;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tfoot/tr[1]/td[2]/descendant::span[@title='Select clinic name']/following-sibling::span")
	private WebElement clinicNameDropdown;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tfoot/tr[1]/td[3]/descendant::span[@title='Select Dept Type']/following-sibling::span")
	private WebElement departmentDropdown_ConsultationCharge;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tfoot/tr[1]/td[4]/descendant::input[@placeholder='Actual Cost']")
	private WebElement actualCost_ConsultationCharge;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tfoot/tr[1]/td[last()-1]/descendant::input[@placeholder='Package Cost']")
	private WebElement packageCost_ConsultationCharge;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']/tfoot/tr[1]/td[last()]/descendant::button[@type='button']")
	private WebElement actionBtn_ConsultationCharge;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

//--------------------------------Logics----------------------------------------

	public void clickOnMhcPackage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, MHCPackage);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectRateType(WebDriver driver, String rateType) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, rateTypeDropdown, dropDownText, rateType);
	}

	public void selectPackageType(WebDriver driver, String packageType) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, packageTypeDropdown, dropDownText, packageType);
	}

	public void enterPackageName(WebDriver driver, String packageName) {
		invisibiltyOf_Element_ThreeDots(driver);
		packageNameText.sendKeys(packageName);
	}

	public void clickOnSearch(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
	}

	public void clickOnClear(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn.click();
	}

	public void clickOnAdd(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		addBtn.click();
	}

	public void selectTransactionType(WebDriver driver, String transactionType) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, transactionTypeDropdown, dropDownText, transactionType);
	}

	public void selectCustomer(WebDriver driver, String customer) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, customerDrodown, dropDownText, customer);
	}

	public void enterPackagePrice(WebDriver driver, String packagePrice) {
		invisibiltyOf_Element_ThreeDots(driver);
		packagePriceText.sendKeys(packagePrice);
	}

	public void enterServiceName(WebDriver driver, String serviceName) {
		invisibiltyOf_Element_ThreeDots(driver);
		servicesNameText.sendKeys(serviceName);
	}

	public void enterPackageCost(WebDriver driver, String packageCost) {
		packageCostText.sendKeys(packageCost);
	}

	public void clickOnAdd_serviceCharge(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(500);
		scrollDownThePageUntilElementIsVisible(driver, actionBtn_ServiceCharge);
		clickOnTheElementUsedToJavascriptExecuter(driver, actionBtn_ServiceCharge);
	}

	public void selectClinicName(WebDriver driver, String clinicName) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, clinicNameDropdown, dropDownText, clinicName);
	}

	public void selectDepartment(WebDriver driver, String department) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, departmentDropdown_ConsultationCharge, dropDownText, department);
	}

	public void enterActualCost(WebDriver driver, String actualCost) {
		actualCost_ConsultationCharge.sendKeys(actualCost);
	}

	public void enterPackageCost_consultationCharge(WebDriver driver, String packageCost) {
		packageCost_ConsultationCharge.sendKeys(packageCost);
	}

	public void clickOnAdd_ConsultationCharge(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		actionBtn_ConsultationCharge.click();
	}

	public String captureRateTypeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(500);
		String ratetype = rateType_Table.getText();
		return ratetype;
	}

	public String capturePackageTypeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(500);
		String packageType = packageType_Table.getText();
		return packageType;
	}

	public String capturePackageNameInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(500);
		String packageName = packageName_Table.getText();
		return packageName;
	}

	public void clickOnSubmit(WebDriver driver) {
		scrollToBottom(driver);
		submitBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnCancel(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollToBottom(driver);
		cancelBtn.click();
	}

}
