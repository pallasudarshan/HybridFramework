package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class SystemCodePage extends WebDriverUtility {

	public SystemCodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ----------------X-Path-----------------------

	@FindBy(xpath = "//span[text()=' System Code ']")
	private WebElement systemCodePage;

	@FindBy(xpath = "(//input[@placeholder='Code'])[1]")
	private WebElement CodeField;

	@FindBy(xpath = "(//input[@placeholder='Description'])[1]")
	private WebElement descriptionField;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//button[text()=' Add']")
	private WebElement addBtn;

	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement nextBtn;

	@FindBy(xpath = "//a[@aria-label='Previous page']")
	private WebElement previousBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	private WebElement slNoTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement codesInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[3]/descendant::a)[1]")
	private WebElement descriptionInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[4]/descendant::span)[1]")
	private WebElement statusBtnInTable;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5]/descendant::button)[1]")
	private WebElement actionBtnInTable;

	@FindBy(xpath = "(//button[@class='dropdown-item'])[1]")
	private WebElement editBtnUnderAction;

	@FindBy(xpath = "//input[@formcontrolname='codeId']")
	private WebElement codeIdField;

	@FindBy(xpath = "//input[@formcontrolname='codeTypeDesc']")
	private WebElement descriptionFieldInPopup;

	@FindBy(xpath = "(//button[@type='submit']//i)[3]")
	private WebElement submitBtn;

	@FindBy(xpath = "(//button[text()=' Cancel'])[1]")
	private WebElement cancelBtn;

	@FindBy(xpath = "((//label[text()='System Codes'])[2]/following::input)[1]")
	private WebElement systemCodesField_applicationCodes;

	@FindBy(xpath = "((//label[text()='System Codes'])[2]/following::input)[2]")
	private WebElement descriptionField_applicationCodes;

	@FindBy(xpath = "(//input[@placeholder='Code Id'])[3]")
	private WebElement codeIdField_applicationCodes;

	@FindBy(xpath = "//input[@formcontrolname='applicationCode']")
	private WebElement applicationCodeFieldInTable_applicationCode;

	@FindBy(xpath = "//input[@formcontrolname='applicationCodeDesc']")
	private WebElement applicationCodeDescriptionInTable_applicationCode;

	@FindBy(xpath = "(//span[@class='switch-label'])[1]")
	private WebElement defaultValueBtn;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[3]")
	private WebElement applicationCodesInTable;

	@FindBy(xpath = "(//input[contains(@class,'switchs-input ng-untouched')]/following-sibling::span)[1]")
	private WebElement defaultVauleBtnInTable_applicationCode;

	@FindBy(xpath = "(//input[@id='checkId']/following-sibling::span)[1]")
	private WebElement statusBtnInTable_applicationCode;

	@FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[1]")
	private WebElement editBtnInTable_applicationCode;

	@FindBy(xpath = "(//span[@aria-hidden='true'])[4]")
	private WebElement xBtnInPopup;

	@FindBys({ @FindBy(xpath = "(//table)[1]/tbody/tr/td[1]") })
	private List<WebElement> listOfSlNoInTable;

	// -----------Logics--------------

	public void clickOnSystemCodeScreen(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, systemCodePage);
	}

	public void enterCodes(WebDriver driver, String codeField) {
		CodeField.sendKeys(codeField);
	}

	public void enterDescription(WebDriver driver, String description) {
		descriptionField.sendKeys(description);
	}

	public void clickOnSearch(WebDriver driver) {
		searchBtn.click();
	}

	public void clickOnClear(WebDriver driver) {
		clearBtn.click();
	}

	public void clickOnEditBtnUnderAction(WebDriver driver) {
		actionBtnInTable.click();
		actionBtnInTable.click();
		editBtnUnderAction.click();
	}

	public void clickOnAdd(WebDriver driver) {
		scrollToTop(driver);
		addBtn.click();
	}

	public void enterDescriptionInThePopUp(WebDriver driver, String description) {
		descriptionFieldInPopup.sendKeys(description);
	}

	public void enterCodeIdInThePopUp(WebDriver driver, String codeId) {
		codeIdField.sendKeys(codeId);
	}

	public void clickOnSubmit(WebDriver driver) {
		submitBtn.click();
	}

	public void clickOnCancel(WebDriver driver) {
		cancelBtn.click();
	}

	public void clickOnXBtnInPopUp(WebDriver driver) {
		xBtnInPopup.click();
	}
}
