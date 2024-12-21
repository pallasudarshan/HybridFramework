package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class SendToLabPage extends WebDriverUtility {
	public SendToLabPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Send To Lab ']")
	private WebElement sendToLabScreenBtn;

	@FindBy(xpath = "//a[contains(.,'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberField;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement SearchBtn;

	@FindBy(xpath = "(//table//tbody/tr[1]/td[last()]//input)[1]")
	private WebElement actionCheckBox;

	@FindBy(xpath = "//button[text()='Send To Lab']")
	private WebElement sendToLabBtn;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberField;

	@FindBy(xpath = "(//table//tbody/tr/td[last()]//input)")
	private List<WebElement> actionCheckBox_list;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	public void clickOnSendToLabScreenBtn(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, sendToLabScreenBtn);
	}

	public void clickOnAddBtn(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, addBtn);
		addBtn.click();
	}

	public void enterSampleNumber(WebDriver driver, String sampleNumber) {
		sampleNumberField.sendKeys(sampleNumber);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberField.sendKeys(hospitalNumber);
	}

	public void clickOnSearchBtn(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, SearchBtn);
		SearchBtn.click();
	}

	public void clickOnCheckBox_Action(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, actionCheckBox);
		actionCheckBox.click();
	}

	public void clickOnCheckBox_Action_List(WebDriver driver) throws Throwable {

		for (WebElement webElement : actionCheckBox_list) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			clickOnTheElementUsedToJavascriptExecuter(driver, webElement);
		}
	}

	public void clickOnSendToLabBtn(WebDriver driver) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, sendToLabBtn);
		Thread.sleep(5000);
	}

	public void sendToLabFlow(WebDriver driver, String sampleNumber) throws Throwable {
		clickOnAddBtn(driver);
		clickOnCheckBox_Action(driver);
		clickOnSendToLabBtn(driver);
	}

	public void sendToLabFlow_2(WebDriver driver, String hospitalNumber) throws Throwable {
		clickOnAddBtn(driver);
		Thread.sleep(15000);
		enterHospitalNumber(driver, hospitalNumber);
		clickOnSearchBtn(driver);
		Thread.sleep(15000);
		clickOnCheckBox_Action_List(driver);
		clickOnSendToLabBtn(driver);
		Thread.sleep(15000);
		explictWaitForElementToBeVisible(driver, okBtn);
		okBtn.click();
	}

}
