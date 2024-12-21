package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class PatientTypeAndCategoryLinkPage extends WebDriverUtility {

	public PatientTypeAndCategoryLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
	private WebElement patientTypeDropDownBtn;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
	private WebElement patientCategoryDropDownBtn;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[3]")
	private WebElement rateTypeDropDownBtn;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "//button[text()=' PDF']")
	private WebElement pdfBtn;

	@FindBy(xpath = "//button[text()=' Excel']")
	private WebElement excelBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	private WebElement slNoIntable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement patientTypeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3])[1]")
	private WebElement patientCategoryInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[4])[1]")
	private WebElement rateTypeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5])[1]")
	private WebElement regChargeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[6])[1]")
	private WebElement reRegChargeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[7])[1]")
	private WebElement admissionChargeInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[8]/descendant::button)[1]")
	private WebElement editBtnInTable;

	@FindBy(xpath = "//a[contains(.,'Next page')]")
	private WebElement nextBtn_pagination;

	@FindBy(xpath = "//a[contains(.,'Previous page')]")
	private WebElement previousBtn_pagination;

	@FindBy(xpath = "//span[text()=' Patient Type and Category Link ']")
	private WebElement patinetTypeandCategoryLinkbtn;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement backBtn;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//input[@formcontrolname='regnAmount']")
	private WebElement registrationChargeField;

	@FindBy(xpath = "//input[@formcontrolname='revisitAmount']")
	private WebElement revisitRegistrationChargeField;

	@FindBy(xpath = "//input[@formcontrolname='admissionCharge']")
	private WebElement admissionChargeField;

	@FindBy(xpath = "//input[@value='cashApplicable']")
	private WebElement cashCheckbox;

	@FindBy(xpath = "//input[@value='creditApplicable']")
	private WebElement creditCheckBox;

	@FindBy(xpath = "//input[@value='applicableToOP']")
	private WebElement ipCheckBox;

	@FindBy(xpath = "//input[@value='applicableToIP']")
	private WebElement opCheckBox;

	@FindBy(xpath = "//input[@value='applicableToMHC']")
	private WebElement mhcCheckBox;

	@FindBy(xpath = "(//span[@data-off='No'])[1]")
	private WebElement allowDependentSwitchBtn;

	@FindBy(xpath = "(//span[@data-off='No'])[2]")
	private WebElement validateDocumentSwitchBtn;

	@FindBy(xpath = "(//span[@data-off='No'])[3]")
	private WebElement departmentSpecificSwitchBtn;

	@FindBy(xpath = "//input[@id='employeeId']/following-sibling::span[1]")
	private WebElement employeeIdApplicableSwitchBtn;

	@FindBy(xpath = "//input[@id='studentId']/following-sibling::span[1]")
	private WebElement studentIdApplicableSwitchBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownTextField;

	@FindBy(xpath = "//span[text()=' Patient Type and Category Link ']")
	private WebElement patientTypeAndCatergoryLink;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBys({ @FindBy(xpath = "(//table)[1]/tbody/tr/td[1]") })
	private List<WebElement> listOfSerialno;

	@FindBy(xpath = "//a[contains(.,'Next page')]")
	private WebElement nextBtn;

	@FindBy(xpath = "//li//a[@aria-label='Previous page']")
	private WebElement previousBtn;

	// -------logics-------

	public void clickOnPatientAndCatagoryLinkScreenBtn(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, patientTypeAndCatergoryLink);
	}

	public void clickOnAddBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		addBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectPatientType(WebDriver driver, String patientType) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown_Handling(driver, 3, patientTypeDropDownBtn, dropDownTextField, patientType);
	}

	public void selectPatientCatagory(WebDriver driver, String patientCatagory) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown_Handling(driver, 3, patientCategoryDropDownBtn, dropDownTextField, patientCatagory);
	}

	public void selectRateType(WebDriver driver, String rateType) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown_Handling(driver, 3, rateTypeDropDownBtn, dropDownTextField, rateType);
	}

	public void enterRegistrationCharge(WebDriver driver, String registrationCharge) {
		scrollDownThePageUntilElementIsVisible(driver, registrationChargeField);
		registrationChargeField.sendKeys(registrationCharge);
	}

	public void enterRevisitRegistrationCharge(WebDriver driver, String RevisitRegistrationCharge) {
		scrollDownThePageUntilElementIsVisible(driver, revisitRegistrationChargeField);
		revisitRegistrationChargeField.sendKeys(RevisitRegistrationCharge);
	}

	public void enterAdmissionCharge(WebDriver driver, String admissionCharge) {
		scrollDownThePageUntilElementIsVisible(driver, admissionChargeField);
		admissionChargeField.sendKeys(admissionCharge);
	}

	public void selectCashCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, cashCheckbox);
		cashCheckbox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectCreditCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, creditCheckBox);
		creditCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectIpCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, ipCheckBox);
		ipCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectOpCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, opCheckBox);
		opCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void selectMhcCheckBox(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollTillVisibleElement(driver, mhcCheckBox);
		mhcCheckBox.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnSubmit(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnEditBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		editBtnInTable.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnOkBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		okBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String capturePatientTypeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String patientType = patientTypeInTable.getText();
		return patientType;
	}

	public void clickOnSearchBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public void clickOnClearBtn(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String capturePatientCategoryInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String patientCategrory = patientCategoryInTable.getText();
		return patientCategrory;
	}

	public String capturerRateTypeInTable(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1000);
		String rateType = rateTypeInTable.getText();
		return rateType;
	}

	public void verifyNextBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		for (int i = 1; i <= 5; i++) {
			WebElement lastSlNo = listOfSerialno.get(listOfSerialno.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			int res = l + 1;
			scrollDownTheStillEndOfThePage(driver);
			invisibiltyOf_Element_ThreeDots(driver);
			nextBtn.click();
			invisibiltyOf_Element_ThreeDots(driver);
			Thread.sleep(2500);
			String ls1 = slNoIntable.getText();
			int res1 = Integer.parseInt(ls1);
			Assert.assertEquals(res, res1);
		}
		System.out.println("Successfully next button is verified");
	}

	public void verifyPreviousBtnIsWorkingAsExpected(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(500);
			nextBtn.click();
		}
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(1000);
			String ls1 = slNoIntable.getText();
			int res1 = Integer.parseInt(ls1) - 1;
			invisibiltyOf_Element_ThreeDots(driver);
			previousBtn.click();
			invisibiltyOf_Element_ThreeDots(driver);
			Thread.sleep(1000);
			WebElement lastSlNo = listOfSerialno.get(listOfSerialno.size() - 1);
			String ls = lastSlNo.getText();
			int l = Integer.parseInt(ls);
			System.out.println(l);
			Assert.assertEquals(l, res1);
		}
		System.out.println("Successfully previous button is verified");
	}
}
