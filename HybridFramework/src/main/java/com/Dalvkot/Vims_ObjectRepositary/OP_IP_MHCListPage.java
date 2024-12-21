package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.Popup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class OP_IP_MHCListPage extends WebDriverUtility {

	public OP_IP_MHCListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Appointment link
	@FindBy(xpath = "//a[text()=' Hospital Service Bill ']")
	private WebElement hospitalServiceBill;

	@FindBy(xpath = "//i[@class='zmdi zmdi-plus-circle']")
	private WebElement newBillBtn;

	@FindBy(xpath = "//label[text()='Hospital Number']/ancestor::div[@class='form-group col-lg-4 col-xl-4 col-sm-6 col-md-4 col-xs-12']/descendant::input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//label[text()='Transaction Type']/ancestor::div[@class='form-group col-lg-4 col-xl-4 col-sm-6 col-md-4 col-xs-12']/descendant::span[@class='select2-selection__arrow']")
	private WebElement transactionTypeBtn;

	@FindBy(xpath = "/html/body/app-root/app-home/app-op-mhc-ip-general-billing/section/div[2]/form/div[2]/button[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement popuopOkBtn;

	@FindBy(xpath = "//a[text()='Completed']")
	private WebElement completeTabBtn;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberTextInTheCompleteTab;

	@FindBy(xpath = "//i[@class='zmdi zmdi-close']/ancestor::div[@class='form-group col-sm-12 col-xs-12 col-md-4 col-lg-4 col-xl-4 text-right']/descendant::i[@class='zmdi zmdi-search']")
	private WebElement completeTabSearchBtnForVims;

	@FindBy(xpath = "//div[@id='History']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement completTabBillNumberGetTextInTheTable;

	public WebElement getHospitalServiceBill() {
		return hospitalServiceBill;
	}

	public WebElement getHospitalNumberTextInTheCompleteTab() {
		return hospitalNumberTextInTheCompleteTab;
	}

	public WebElement getCompleteTabSearchBtnForVims() {
		return completeTabSearchBtnForVims;
	}

	public WebElement getNewBillBtn() {
		return newBillBtn;
	}

	public WebElement getHospitalNumberText() {
		return hospitalNumberText;
	}

	public WebElement getTransactionTypeBtn() {
		return transactionTypeBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getPopuopOkBtn() {
		return popuopOkBtn;
	}

	public WebElement getCompleteTabBtn() {
		return completeTabBtn;
	}

	public WebElement getCompleteTabHosptalNumberText() {
		return hospitalNumberTextInTheCompleteTab;
	}

	public WebElement getCompleteTabSearchBtn() {
		return completeTabSearchBtnForVims;
	}

	public WebElement getCompletTabBillNumberGetTextInTheTable() {
		return completTabBillNumberGetTextInTheTable;
	}

	/**
	 * 
	 * Business Logics
	 * 
	 * @throws Throwable
	 * 
	 * 
	 */
	public void clickOnTheOpIpMhcButtonForVims(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, hospitalServiceBill);
		Robot hd = new Robot();
		hd.keyPress(KeyEvent.VK_PAGE_UP);
		hd.keyPress(KeyEvent.VK_PAGE_UP);
		hd.keyPress(KeyEvent.VK_PAGE_UP);
		hd.keyPress(KeyEvent.VK_PAGE_UP);
	}

	public void clickOnNewBillButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, newBillBtn);
	}

	public void hospitalNumberTextField(String hospitalNumber) {

		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void clickOnThetransactionButton(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(transactionTypeBtn)));
		transactionTypeBtn.click();
	}

	public void scrollDownTheEndOfThePage(WebDriver driver) {
		JavascriptExecutor jslj = (JavascriptExecutor) driver;
		jslj.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollUpThePageFullUp(WebDriver driver) {

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,-1200)", "");
	}

	public void clickOnTheSubmitButton(WebDriver driver) throws Throwable {
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submitBtn)));

		submitBtn.click();
		Thread.sleep(1000);
		Robot er11 = new Robot();
		er11.keyPress(KeyEvent.VK_ESCAPE);
		er11.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		er11.keyPress(KeyEvent.VK_CONTROL);
		er11.keyPress(KeyEvent.VK_W);
		er11.keyRelease(KeyEvent.VK_CONTROL);
		er11.keyRelease(KeyEvent.VK_W);

	}

	public void clickOnTheSuccessfullOkBtn(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(popuopOkBtn)));
		popuopOkBtn.click();
	}

	public void clickOnTheCompleteTabBtn(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(completeTabBtn)));

		completeTabBtn.click();
	}

	public void completeHospitalNumberText(String hospitalNumber) {
		hospitalNumberTextInTheCompleteTab.sendKeys(hospitalNumber);
	}

	public void completeTabSearchButtonForVims(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(completeTabSearchBtnForVims)));
		completeTabSearchBtnForVims.click();
	}

	public String completTabBillNumberGetFromTheTable() {
		String billNumber = completTabBillNumberGetTextInTheTable.getText();
		return billNumber;
	}

	public String oP_Billing_ProcessForVims(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, newBillBtn);

		hospitalNumberText.sendKeys(hospitalNumber);

		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(transactionTypeBtn)));
		transactionTypeBtn.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(transactionTypeBtn)));
		transactionTypeBtn.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submitBtn)));

		submitBtn.click();
		Thread.sleep(1000);
		Robot er11 = new Robot();
		er11.keyPress(KeyEvent.VK_ESCAPE);
		er11.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		er11.keyPress(KeyEvent.VK_CONTROL);
		er11.keyPress(KeyEvent.VK_W);
		er11.keyRelease(KeyEvent.VK_CONTROL);
		er11.keyRelease(KeyEvent.VK_W);

		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		wait4.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(popuopOkBtn)));
		popuopOkBtn.click();

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,-1200)", "");

		WebDriverWait wait5 = new WebDriverWait(driver, 50);
		wait5.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(completeTabBtn)));

		completeTabBtn.click();

		hospitalNumberTextInTheCompleteTab.sendKeys(hospitalNumber);

		WebDriverWait wait6 = new WebDriverWait(driver, 50);
		wait6.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(completeTabSearchBtnForVims)));
		Actions ac = new Actions(driver);
		ac.moveToElement(completeTabSearchBtnForVims).click(completeTabSearchBtnForVims).perform();

		WebDriverWait wait41 = new WebDriverWait(driver, 50);
		wait41.until(ExpectedConditions
				.refreshed(ExpectedConditions.elementToBeClickable(completTabBillNumberGetTextInTheTable)));
		String billNumber = completTabBillNumberGetTextInTheTable.getText();

		return billNumber;

	}

}