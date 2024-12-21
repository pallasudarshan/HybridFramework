package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ServiceOPDRateLinkPage extends WebDriverUtility {

	public ServiceOPDRateLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// -----xpaths------

	@FindBy(xpath = "//span[@title='Select Service Type']/following-sibling::span[1]")
	private WebElement serviceTypeDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Service Group']/following-sibling::span[1]")
	private WebElement serviceGroupDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Service Class']/following-sibling::span[1]")
	private WebElement serviceClassDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Service Name']")
	private WebElement serviceNameText;

	@FindBy(xpath = "//input[@placeholder='Service Code']")
	private WebElement serviceCodeText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[contains(.,'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement serviceType_Table;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[last()])[1]")
	private WebElement serviceType_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3])[1]")
	private WebElement serviceGroup_Table;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[3])[1]")
	private WebElement serviceGroup_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[4])[1]")
	private WebElement serviceClass_Table;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[4])[1]")
	private WebElement serviceClass_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5])[1]")
	private WebElement serviceName_Table;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[5])[1]")
	private WebElement serviceName_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[6])[1]")
	private WebElement serviceCode_Table;

	@FindBy(xpath = "(//table/tbody/tr[last()]/td[6])[1]")
	private WebElement serviceCode_Table_LastRow;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[7])[1]")
	private WebElement serviceRule_Table;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[11]//button)[1]")
	private WebElement editButton_Table;

	@FindBy(xpath = "//a[contains(.,'Next page')]")
	private WebElement nextBtn;

	@FindBy(xpath = "//a[contains(.,'Previous page')]")
	private WebElement previousBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "//span[@title='Select Rate Type']/following-sibling::span[1]")
	private WebElement rateTypeDropDownBtn;

	@FindBy(xpath = "//button[text()=' Save']")
	private WebElement saveBTn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//span[text()=' Service OPD rate link ']")
	private WebElement serviceOpdrateLink;

	// -----Logics------

	public void clickOnServiceOpdRateLinkPage(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, serviceOpdrateLink);
	}

	public void selectServiceType(WebDriver driver, String serviceType) {
		invisibiltyOf_Element_ThreeDots(driver);

		dropdown(driver, serviceTypeDropDownBtn, dropDownText, serviceType);
	}

	public void selectServiceGroup(WebDriver driver, String serviceGroup) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);

		dropdown(driver, serviceGroupDropDownBtn, dropDownText, serviceGroup);
	}

	public void selectServiceClass(WebDriver driver, String serviceClass) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);

		dropdown(driver, serviceClassDropDownBtn, dropDownText, serviceClass);
	}

	public void enterServiceName(WebDriver driver, String serviceName) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		serviceNameText.sendKeys(serviceName);
	}

	public void enterServiceCode(WebDriver driver, String serviceCode) {
		invisibiltyOf_Element_ThreeDots(driver);
		serviceCodeText.sendKeys(serviceCode);
	}

	public void clickOnSearch(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnClear(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnAddBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		addBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectRateType(WebDriver driver, String rateType) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, rateTypeDropDownBtn, dropDownText, rateType);
	}

	public void clickOnEditBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		editButton_Table.click();
	}

	public String captureServiceType_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String service = serviceType_Table.getText();
		return service;
	}

	public String captureServiceGroup_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String service = serviceGroup_Table.getText();
		return service;
	}

	public String captureServiceClass_Table(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String service = serviceClass_Table.getText();
		return service;
	}

	public String captureServiceName_Table(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String service = serviceName_Table.getText();
		return service;
	}

	public String captureServiceName_Table_LastRow(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String service = serviceName_Table_LastRow.getText();
		return service;
	}

	public String captureServiceCode_Table(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String service = serviceCode_Table.getText();
		return service;
	}

	public String captureServiceCode_Table_LastRow(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String service = serviceCode_Table_LastRow.getText();
		return service;
	}

}
