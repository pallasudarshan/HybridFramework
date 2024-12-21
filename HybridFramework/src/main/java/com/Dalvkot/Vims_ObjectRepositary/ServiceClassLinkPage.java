package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ServiceClassLinkPage extends WebDriverUtility {

	public ServiceClassLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===========Xpaths============

	@FindBy(xpath = "//span[text()=' Service Class Link ']")
	private WebElement serviceClassLinkPage;

	@FindBy(xpath = "//span[@title='Select Service Type']/following-sibling::span[1]")
	private WebElement serviceTypeDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Service Group']/following-sibling::span[1]")
	private WebElement serviceGroupDropDownBtn;

	@FindBy(xpath = "//span[@title='Select Service Class']/following-sibling::span[1]")
	private WebElement serviceClassDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	private WebElement slNoInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement serviceTypeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3])[1]")
	private WebElement serviceGroupInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[4])[1]")
	private WebElement serviceClassInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5]/descendant::span)[1]")
	private WebElement statusBtnInTable;

	@FindBy(xpath = "(//table//tr[1]/td[last()])[1]//button[text()=' Actions ']")
	private WebElement actionBtnInTable;

	@FindBy(xpath = "(//button[@class='dropdown-item'])[1]")
	private WebElement editBtnUnderAction;

	@FindBy(xpath = "//li//a[@aria-label='Next page']")
	private WebElement nextBtn;

	@FindBy(xpath = "//li//a[@aria-label='Previous page']")
	private WebElement previousBtn;

	@FindBys({ @FindBy(xpath = "(//table)[1]/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialNoInTable;

	@FindBy(xpath = "//button[text()=' Back']")
	private WebElement backBtn;

	@FindBy(xpath = "//span[@data-on='Yes']")
	private WebElement SwitchBtn;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	// ==========Logics===========

	public void clickOnServiceClassLink(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, serviceClassLinkPage);
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectServiceType(WebDriver driver, String serviceType) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);

		serviceTypeDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, serviceType);
	}

	public void selectServiceGroup(WebDriver driver, String serviceGroup) {
		invisibiltyOf_Element_ThreeDots(driver);

		serviceGroupDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, serviceGroup);
	}

	public void selectServiceClass(WebDriver driver, String serviceClass) {
		invisibiltyOf_Element_ThreeDots(driver);

		serviceClassDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropDownText, serviceClass);
	}

	public void clickOnSearchBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
	}

	public void clickOnAddBtn(WebDriver driver) {
		scrollToTop(driver);
		addBtn.click();
	}

	public void clickOnClearBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn.click();
	}

	public void clickOnSubmitBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		submitBtn.click();
	}

	public void clickOnCancelBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		cancelBtn.click();
	}

	public void clickOnBackBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		backBtn.click();
	}

	public void clickOnOkBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		okBtn.click();
	}

	public String captureServiceTypeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String serviceType = serviceTypeInTable.getText();
		return serviceType;
	}

	public String captureServiceGroupInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String serviceGroup = serviceGroupInTable.getText();
		System.out.println(serviceGroup);
		return serviceGroup;
	}

	public String captureServiceClass(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		String serviceClass = serviceClassInTable.getText();
		System.out.println(serviceClass);
		return serviceClass;
	}

	public void clickOnEditUnderAction(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);

		doubleClick(driver, actionBtnInTable);
		Thread.sleep(300);
		editBtnUnderAction.click();
	}

	public void verifyNextBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) {
			WebElement lastSlNo = listOfSerialNoInTable.get(listOfSerialNoInTable.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			invisibiltyOf_Element_ThreeDots(driver);
			nextBtn.click();
			invisibiltyOf_Element_ThreeDots(driver);
			Thread.sleep(2500);
			String ls1 = slNoInTable.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(500);
			invisibiltyOf_Element_ThreeDots(driver);
			nextBtn.click();
			invisibiltyOf_Element_ThreeDots(driver);
		}
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(1000);
			String ls1 = slNoInTable.getText();
			int res1 = Integer.parseInt(ls1) - 1;
			previousBtn.click();
			Thread.sleep(1000);
			WebElement lastSlNo = listOfSerialNoInTable.get(listOfSerialNoInTable.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res1);
		}
		System.out.println("Successfully previous button is verified");
	}

}