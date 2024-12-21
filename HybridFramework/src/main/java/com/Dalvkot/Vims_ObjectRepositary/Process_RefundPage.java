package com.Dalvkot.Vims_ObjectRepositary;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class Process_RefundPage extends WebDriverUtility {
	public Process_RefundPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Process Refund ']")
	private WebElement processRefundbtnScreenBtn;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
	private WebElement billTypeDropDownBtn_pendingRefund;

	@FindBy(xpath = "(//input[@placeholder='Hospital Number'])[1]")
	private WebElement hospitalNumberTextField_pendingRefund;

	@FindBy(xpath = "(//input[@placeholder='Bill Number'])[1]")
	private WebElement billNumberTextField_pendingRefund;

	@FindBy(xpath = "(//button[text()=' Search'])[1]")
	private WebElement searchBtn_pendingRefund;

	@FindBy(xpath = "(//button[text()=' Clear'])[1]")
	private WebElement clearBtn_pendingRefund;

	@FindBy(xpath = "//a[contains(text(),'Pending Refund List')]")
	private WebElement pendingReundListTab;

	@FindBy(xpath = "//a[contains(text(),'Refunded List')]")
	private WebElement refundListTab;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement billNumberIntable_pendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement billTypeIntable_pendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement billDateIntable_pendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumberIntable_pendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement patientNameIntable_pendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement OpNumberIntable_PendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement requestedRefundAmount_pendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement approvalStatus_PendingList;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement refundStatus_PendingList;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDowntext;

	@FindBy(xpath = "//textarea[@placeholder='reason']")
	private WebElement approvedReason;

	@FindBy(xpath = "(//span[@role='presentation'])[3]")
	private WebElement paymentModedropDownBtn;

	@FindAll({ @FindBy(xpath = "//button[text()=' Save']"), @FindBy(xpath = "(//button[@type='submit']//i)[2]") })
	private WebElement saveBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "(//input[@placeholder='Hospital Number'])[2]")
	private WebElement hospitalNumberTextField_RefundedList;

	@FindBy(xpath = "(//button[text()=' Search'])[2]")
	private WebElement searchBtn_RefundesList;

	@FindBy(xpath = "//div[@id='AdjustedAdvance']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumberIntable_RefundedList;

	@FindBys({ @FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr/td[4]") })
	private List<WebElement> listOfServiceNames_PopUp;

	@FindBy(xpath = "(//div[@id='modal']//span)[7]")
	private WebElement totalAmount;

	@FindBy(xpath = "//div[@id='Pending']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement hospitalNumberIntable_PendingRefundedList;

	// ---logics----

	public void clickOnProcessRefundBtn(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, processRefundbtnScreenBtn);
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnOkBtnIfDisplays(driver);
	}

	public void selectBillType_PendingList(WebDriver driver, String billType) throws Throwable {
		Thread.sleep(1500);
		dropdown_Handling(driver, 5, billTypeDropDownBtn_pendingRefund, dropDowntext, billType);
	}

	public void enterHospitalNumber_pendingList(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumberTextField_pendingRefund.sendKeys(hospitalNumber);
	}

	public void clickOnSearch_pendingList(WebDriver driver) throws Throwable {
		searchBtn_pendingRefund.click();
	}

	public void clickOnBillNumber_PendingList(WebDriver driver) throws Throwable {
		Thread.sleep(3500);
		Thread.sleep(1000);
		invisibiltyOf_Element_ThreeDots(driver);
		billNumberIntable_pendingList.click();
	}

	public void clickOnSave(WebDriver driver) throws Throwable {
		Thread.sleep(1500);
		clickOnTheElementUsedToJavascriptExecuter(driver, saveBtn);
		invisibiltyOf_Element_ThreeDots(driver);
		Thread.sleep(1500);
		getWindowHandles(driver);
	}

	public void clickOnOkBtnIfDisplays(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement okBtn = null;
		try {
			okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Ok button not found. Skipping clicking the OK button.");
		}
		if (okBtn != null) {
			okBtn.click();
		}
	}

	public void clickOnOkBtn(WebDriver driver) throws Throwable {

		okBtn.click();
	}

	public void clickOnRefundedList(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		refundListTab.click();
		invisibiltyOf_Element_ThreeDots(driver);
		clickOnOkBtnIfDisplays(driver);
	}

	public void enterHospitalNumber_refundedList(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumberTextField_RefundedList.sendKeys(hospitalNumber);
	}

	public void clickOnSearch_RefundedList(WebDriver driver) throws Throwable {
		searchBtn_RefundesList.click();
		invisibiltyOf_Element_ThreeDots(driver);
	}

	public String captureHospitalNumber_RefundedList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hsp = hospitalNumberIntable_RefundedList.getText();
		return hsp;
	}

	public List<String> captureListOfServiceNames_PopUp(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		List<String> t = new ArrayList<>();
		for (WebElement element : listOfServiceNames_PopUp) {
			String text = element.getText();
			t.add(text);
		}
		return t;
	}

	public String captureTotalAmount_PopUP(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String amt = totalAmount.getText().replace(":", "");
		double d = Double.parseDouble(amt);
		String d1 = String.format("%.2f", d);
		return d1;
	}

	public String captureHospitalNumber_PendingRefundedList(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String hsp = hospitalNumberIntable_PendingRefundedList.getText();
		return hsp;
	}
}