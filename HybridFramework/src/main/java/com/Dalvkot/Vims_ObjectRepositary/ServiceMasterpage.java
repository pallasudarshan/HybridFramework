package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ServiceMasterpage extends WebDriverUtility {

	public ServiceMasterpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// -------------------X-Path---------------------

	@FindBy(xpath = "//span[text()=' Service Master ']")
	private WebElement serviceMasterScreen;

	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "(//div[text()='2']/following-sibling::div)[1]")
	private WebElement serviceTypeInTable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[2]")
	private WebElement serviceGroupInTable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[3]")
	private WebElement serviceClassInTable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[4]")
	private WebElement serviceNameInTable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[5]")
	private WebElement serviceCodeInTable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[6]")
	private WebElement baseRateInTable;

	@FindBy(xpath = "(//div[@col-id='serviceShortName'])[2]")
	private WebElement shortNameInTable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[8]")
	private WebElement labLinkIntable;

	@FindBy(xpath = "(//div[text()='1']/following-sibling::div)[9]")
	private WebElement applicableGenderInTable;

	@FindBy(xpath = "((//div[text()='1']/following-sibling::div)[10]/descendant::span)[1]")
	private WebElement statusBtn;

	@FindBy(xpath = "((//div[text()='1']/following-sibling::div)[11]/descendant::button)[1]")
	private WebElement actionBtnInTable;

	@FindBy(xpath = "//span[@title='Select Service Type']/following-sibling::span[1]")
	private WebElement serviceTypeDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Service Group']/following-sibling::span[1]")
	private WebElement serviceGroupDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Service Class']/following-sibling::span[1]")
	private WebElement serviceClassDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "//input[@placeholder='Service Short Name']")
	private WebElement serviceShortNameField;

	@FindBy(xpath = "//input[@placeholder='Service Display Name']")
	private WebElement serviceDisplaynameField;

	@FindBy(xpath = "//input[@placeholder='Service Name']")
	private WebElement serviceNameField;

	@FindBy(xpath = "//span[@title='Select Gender']/following-sibling::span[1]")
	private WebElement genderDropDownBtn;

	@FindBy(xpath = "//input[@id='appBillingId']/following-sibling::span[1]")
	private WebElement applicableToBillingBtn;

	@FindBy(xpath = "//input[@placeholder='Base Rate']")
	private WebElement baseRateField;

	@FindBy(xpath = "//input[@id='baseRateAppId']/following-sibling::span[1]")
	private WebElement baseRateApplicableBtn;

	@FindBy(xpath = "//input[@placeholder='Tat Time']")
	private WebElement tatTimeField;

	@FindBy(xpath = "//input[@id='bloodScreeningId']/following-sibling::span[1]")
	private WebElement bloodScreeningBtn;

	@FindBy(xpath = "//input[@id='linkToLabId']/following-sibling::span[1]")
	private WebElement linkToLabBtn;

	@FindBy(xpath = "//input[@id='quantityAllowStatus']/following-sibling::span[1]")
	private WebElement quantityAllowBtn;

	@FindBy(xpath = "//input[@id='isFastingStatusId']/following-sibling::span[1]")
	private WebElement isFastingBtn;

	@FindBy(xpath = "//input[@formcontrolname='externalLabStatus']/following-sibling::span[1]")
	private WebElement externalLabBtn;

	@FindBy(xpath = "//input[@id='serviceTypeStatusId']/following-sibling::span[1]")
	private WebElement activeStatusBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//input[@id='isRural']/following-sibling::span[1]")
	private WebElement isRuralBtn;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement okPopUpText;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[@aria-label='Next Page']//span[1]")
	private WebElement nextPageBtn;

	@FindBy(xpath = "//div[@aria-label='Previous Page']//span[1]")
	private WebElement previousPageBtn;

	@FindBy(xpath = "//input[@aria-label='Service Type Filter Input']")
	private WebElement serviceType_Filter;

	@FindBy(xpath = "//input[@aria-label='Service Group Filter Input']")
	private WebElement serviceGroup_Filter;

	@FindBy(xpath = "//input[@aria-label='Service Class Filter Input']")
	private WebElement serviceClass_Filter;

	@FindBy(xpath = "//input[@aria-label='Service Name Filter Input']")
	private WebElement serviceName_Filter;

	@FindBy(xpath = "//input[@aria-label='Service Code Filter Input']")
	private WebElement serviceCodeFilter;

	@FindBy(xpath = "//input[@aria-label='Base Rate Filter Input']")
	private WebElement baseRate_filter;

	@FindBy(xpath = "//input[@aria-label='Short Name Filter Input']")
	private WebElement shortNameFilter;

	@FindBy(xpath = "//input[@aria-label='Lab link Filter Input']")
	private WebElement labLink_Filter;

	@FindBy(xpath = "//input[@aria-label='Applicable Gender Filter Input']")
	private WebElement applicableGender_Filter;

	@FindBy(xpath = "//button[text()=' Back']")
	private WebElement backBtn;

	@FindBy(xpath = "//input[@formcontrolname='baseRate']")
	private WebElement serviceBaserate;

	@FindBy(xpath = "(//div[@row-id='0']//div)[1]")
	private WebElement slNoInTable;

	@FindBys({ @FindBy(xpath = "//div[@col-id='SlNo']") })
	private List<WebElement> listOfSlNo;

	// --------------------Logics-----------------------

	public void clickOnServiceMasterScreen(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, serviceMasterScreen);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectServiceType(WebDriver driver, String serviceType) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);

		scrollTillVisibleElement(driver, serviceTypeDropDownBtn);
		serviceTypeDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, serviceType);
	}

	public void selectServiceGroup(WebDriver driver, String serviceGroup) throws InterruptedException {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(800);

		scrollTillVisibleElement(driver, serviceGroupDropDownBtn);
		serviceGroupDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, serviceGroup);
	}

	public void selectServiceClass(WebDriver driver, String serviceClass) throws InterruptedException {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(800);

		scrollTillVisibleElement(driver, serviceClassDropDownBtn);
		serviceClassDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, serviceClass);
	}

	public void selectGender(WebDriver driver, String gender) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, genderDropDownBtn);

		genderDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, gender);
	}

	public void enterServiceShortName(WebDriver driver, String serviceShortName) throws Throwable {
		Thread.sleep(5000);
		invisibiltyOf_Element_ThreeDots(driver);
		serviceShortNameField.sendKeys(serviceShortName);
	}

	public void enterServiceName(WebDriver driver, String serviceName) {
		scrollTillVisibleElement(driver, serviceNameField);
		serviceNameField.sendKeys(serviceName);
	}

	public void enterServiceBaseRate(WebDriver driver, String serviceBaseRate) {
		scrollTillVisibleElement(driver, serviceBaserate);
		serviceBaserate.sendKeys(serviceBaseRate);
	}

	public void enterTatTime(WebDriver driver, String tatTime) {
		scrollTillVisibleElement(driver, tatTimeField);
		tatTimeField.sendKeys(tatTime);
	}

	public void clickOnSubmit(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollToBottom(driver);

		submitBtn.click();
	}

	public void clickOnAdd(WebDriver driver) {
		scrollToTop(driver);
		invisibiltyOf_Element_ThreeDots(driver);
		addBtn.click();
	}

	public void clickOnOkBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		okBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnCancel(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollToBottom(driver);
		cancelBtn.click();
	}

	public void enterServiceType_Filter(WebDriver driver, String serviceType) throws Throwable {
		Thread.sleep(2000);
		invisibiltyOf_Element_ThreeDots(driver);
		serviceType_Filter.sendKeys(serviceType);
	}

	public void enterServiceGroup_Filter(WebDriver driver, String serviceGroup) {
		serviceGroup_Filter.sendKeys(serviceGroup);
	}

	public void enterServiceClass_Filter(WebDriver driver, String serviceClass) {
		serviceClass_Filter.sendKeys(serviceClass);
	}

	public void enterServiceName_Filter(WebDriver driver, String serviceName) {
		serviceName_Filter.sendKeys(serviceName);
	}

	public void enterServiceCode_Filter(WebDriver driver, String serviceCode) {
		serviceCodeFilter.sendKeys(serviceCode);
	}

	public void enterBaseRate_Filter(WebDriver driver, String baseRate) {
		baseRate_filter.sendKeys(baseRate);
	}

	public void enterShortName_Filter(WebDriver driver, String shortName) {
		shortNameFilter.sendKeys(shortName);
	}

	public void enterLabLink_Filter(WebDriver driver, String labLink) {
		labLink_Filter.sendKeys(labLink);
	}

	public void enterApplicableGender_Filter(WebDriver driver, String applicableGender) {
		applicableGender_Filter.sendKeys(applicableGender);
	}

	public String captureServiceTypeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String serviceType = serviceTypeInTable.getText();
		System.out.println(serviceType);
		return serviceType;
	}

	public String captureServiceGroupInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String serviceGroup = serviceGroupInTable.getText();
		System.out.println(serviceGroup);
		return serviceGroup;
	}

	public String captureServiceClassInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String serviceClass = serviceClassInTable.getText();
		System.out.println(serviceClass);
		return serviceClass;
	}

	public String captureServiceNameInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String serviceName = serviceNameInTable.getText();
		System.out.println(serviceName);
		return serviceName;
	}

	public String captureServiceCodeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String serviceCode = serviceCodeInTable.getText();
		System.out.println(serviceCode);
		return serviceCode;
	}

	public String captureBaseRateInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String baseRate = baseRateInTable.getText();
		System.out.println(baseRate);
		return baseRate;
	}

	public String captureShortNameInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String shortName = shortNameInTable.getText();
		System.out.println(shortName);
		return shortName;
	}

	public String captureLabLinkInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String labLink = labLinkIntable.getText();
		System.out.println(labLink);
		return labLink;
	}

	public String captureApplicableGenerInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		String applicableGender = applicableGenderInTable.getText();
		System.out.println(applicableGender);
		return applicableGender;
	}

//	public void verifyNextBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
//		Thread.sleep(2000);
//		for (int i = 1; i <= 3; i++) {
//			WebElement lastSlNo = listOfSlNo.get(listOfSlNo.size() - 1);
//			String ls = lastSlNo.getText();
//			int l = Integer.parseInt(ls);
//			System.out.println(l);
//			int res = l + 1;
//			scrollDownTheStillEndOfThePage(driver);
//			nextPageBtn.click();
//			Thread.sleep(2500);
//			String ls1 = slNoInTable.getText();
//			int res1 = Integer.parseInt(ls1);
//			Assert.assertEquals(res, res1);
//		}
//		System.out.println("Successfully next button is verified");
//	}
//
//	public void verifyPreviousBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
//		Thread.sleep(2000);
//		scrollDownTheStillEndOfThePage(driver);
//		for (int i = 1; i <= 2; i++) {
//			Thread.sleep(500);
//			nextPageBtn.click();
//		}
//		for (int i = 1; i <= 2; i++) {
//			Thread.sleep(1000);
//			String ls1 = slNoInTable.getText();
//			int res1 = Integer.parseInt(ls1)-1;
//			previousPageBtn.click();
//			Thread.sleep(1000);
//			WebElement lastSlNo = listOfSlNo.get(listOfSlNo.size() - 1);
//			String ls = lastSlNo.getText();
//			int l = Integer.parseInt(ls);
//			System.out.println(l);
//			Assert.assertEquals(l, res1);
//		}
//		System.out.println("Successfully previous button is verified");
//	}
//	

}
