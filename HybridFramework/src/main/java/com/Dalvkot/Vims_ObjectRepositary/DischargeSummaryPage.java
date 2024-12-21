package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DischargeSummaryPage extends WebDriverUtility {

	public DischargeSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Discharge Summary ']")
	private WebElement dischargeSummaryBtn;

	@FindBy(xpath = "//span[@title=' All Ward']/following-sibling::span[1]")
	private WebElement wardDropDownBtn;

	@FindBy(xpath = "//label[text()='Admission Date']/following-sibling::input")
	private WebElement admissionDateField;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement admissionDate_table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]//a")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement nextBtn;

	@FindBy(xpath = "//a[@aria-label='Previous page']")
	private WebElement previousBtn;

	@FindBy(xpath = "//span[@title='Summary Template']/following-sibling::span[1]")
	private WebElement summaryTemplatedropDownBtn;

	@FindBy(xpath = "//span[@title='Discharge Result']/following-sibling::span[1]")
	private WebElement dishargeResultDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "//div[@aria-label='Editor editing area: main']")
	private WebElement textArea;

	@FindBy(xpath = "//button[text()=' Draft']")
	private WebElement draftBtn;

	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement backBtn;

	// -------------------------------Logics------------------------------------

	public void clickOnDischargeSummaryBtn(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, dischargeSummaryBtn);
	}

	public void selectWard(WebDriver driver, String ward) {
		invisibiltyOf_Element_ThreeDots(driver);
		dropdown(driver, wardDropDownBtn, dropDownText, ward);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		invisibiltyOf_Element_ThreeDots(driver);
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clickOnSearch(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn.click();
	}

	public void clickOnClear(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		clearBtn.click();
	}

	public void clickOnHospitalNumber_Table(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		hospitalNumber_Table.click();
	}

}
