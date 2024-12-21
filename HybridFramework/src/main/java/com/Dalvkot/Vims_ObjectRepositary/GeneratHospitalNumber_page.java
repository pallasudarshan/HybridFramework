package com.Dalvkot.Vims_ObjectRepositary;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class GeneratHospitalNumber_page extends WebDriverUtility {

	public GeneratHospitalNumber_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[contains(@class,'zmdi zmdi-menu')]")
	private WebElement menuBTn;

	@FindBy(xpath = "//span[text()=' Generate Hospital Number ']")
	private WebElement generateHospitalNumber;

	@FindBy(xpath = "//a[contains(.,'New')]")
	private WebElement NewBtn;

	@FindBy(xpath = "(//input[@placeholder='Number'])[2]")
	private WebElement HospitalNumber;

	@FindBy(xpath = "//button[text()=' Generate Hospital']")
	private WebElement generateHospitalNumberBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/descendant::a")
	private WebElement editBtn;

	@FindBy(xpath = "//input[@formcontrolname='effectiveDateOfAdmission']")
	private WebElement fromDate;

	@FindBy(xpath = "//span[@title='Clinic Name']/following-sibling::span")
	private WebElement clinicName;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement DropDown;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span")
	private WebElement departmentName;

	@FindBy(xpath = "//span[@title='Unit']/following-sibling::span[1]")
	private WebElement unitNo;

	@FindBy(xpath = "//span[@title='Gender']/following-sibling::span")
	private WebElement gender;

	@FindBy(xpath = "//input[@placeholder='New Quntity']")
	private WebElement newQuantity;

	@FindBy(xpath = "//table/tbody/tr[1]/td[12]//button")
	private WebElement addBtn;

	@FindBy(xpath = "//button[text()=' Submit']//i")
	private WebElement submitBtn;

	@FindBy(xpath = "//span[text()=' ICD Entry ']")
	private WebElement icdEntry;

	@FindBy(xpath = "//span[@title='Select Category Type']/following-sibling::span")
	private WebElement CategoryType;

	@FindBy(xpath = "//i[@class='zmdi zmdi-search']")
	private WebElement IcdsearchBtn;

	@FindBy(xpath = "//div[@id='pending']//table/tbody/tr[1]/td[9]//button")
	private WebElement addDiagnosis;

	@FindBy(xpath = "//span[@title='ICD Code']/following-sibling::span")
	private WebElement CodeType;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement popUpText_OkBtn;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumber_Disabled;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPopUpMsg;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement okBtnText;

	@FindBy(xpath = "//label[text()='Total Number of Patient']/following::input")
	private WebElement totalNumberOfPatientField;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr[position()>1]/td[11]") })
	List<WebElement> listOfQuantity;

	@FindBys({ @FindBy(xpath = "//table[@class='table']//tr[position()>1]/td[12]/div[1]/button") })
	List<WebElement> deleteBtnLineItem;

	@FindBy(xpath = "//table[@class='table']/tbody[1]/tr[2]/12abh")
	private WebElement lineItem;

	// ---------logics-----------

	public void generateHospitalNumber(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, generateHospitalNumber);
	}

	public void clickNewBtn(WebDriver driver) {
		NewBtn.click();
	}

	public void enterHospitalNumber(WebDriver driver) {
		HospitalNumber.sendKeys("100");
	}

	public void clickGenerateHospitalNumberBtn(WebDriver driver) {
		generateHospitalNumberBtn.click();
	}

	public void clickonokBtn(WebDriver driver) {
		okBtn.click();
	}

	public void clickEdit(WebDriver driver) {
		editBtn.click();
	}

	public void selectFromDate(WebDriver driver) {
		fromDate.sendKeys("10102016");
	}

	public void selectclinicName(WebDriver driver, String clinicName1) {
		clinicName.click();
		DropDown.sendKeys(clinicName1, Keys.ENTER);
	}

	public void selectDepartment(WebDriver driver, String department) throws Throwable {
		departmentName.click();
		DropDown.sendKeys(department, Keys.ENTER);
	}

	public void selectunitNo(WebDriver driver, String unit) throws Throwable {
		dropdown(driver, unitNo, DropDown, unit);
	}

	public void selectGender(WebDriver driver, String gender1) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, gender);
		;
		gender.click();
		DropDown.sendKeys(gender1, Keys.DOWN, Keys.DOWN, Keys.ENTER);
	}

	public void enternewQuantity(WebDriver driver, String qty) {
		newQuantity.clear();
		newQuantity.sendKeys(qty);
	}

	public void clickaddBtn(WebDriver driver) {
		addBtn.click();

	}

	public void addLineItems(WebDriver driver, String clinicName1, String department, String unit, String gender1,
			String qty) throws Throwable {

		selectclinicName(driver, clinicName1);
		selectDepartment(driver, department);
		selectunitNo(driver, unit);
		selectGender(driver, gender1);
		enternewQuantity(driver, qty);
		clickaddBtn(driver);
		clickOnOkBtnIfDisplays(driver);
	}

	public void clicksubmitBnt(WebDriver driver) throws InterruptedException {
		scrollToBottom(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
	}

	public void ok_Btn(WebDriver driver) {
		okBtn.click();
	}

	public void clickAddDiagnosis(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		addDiagnosis.click();
	}

	public void selectCodeType(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		CodeType.click();
		DropDown.sendKeys("icd", Keys.ENTER);
	}

	public String captureTextAndClickOnOkbtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = popUpText_OkBtn.getText();
		System.out.println(text);
		okBtn.click();
		return text;
	}

	public void enterHospitalNumber(WebDriver driver, String hsptl) {
		HospitalNumber.sendKeys(hsptl);
	}

	public String captureHospitalNumber(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hsp = hospitalNumber_Disabled.getAttribute("value");
		System.out.println(hospitalNumber_Disabled);
		return hsp;
	}

	public String captureErrorPopUpmsg(WebDriver driver) throws Throwable {
		String errorMsg = errorPopUpMsg.getText();
		return errorMsg;
	}

	public String captureOkBtnText(WebDriver driver) throws Throwable {
		String text = okBtnText.getText();
		return text;
	}

	public void clickOnOkBtnIfDisplays(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement okBtn = null;
		try {
			okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (okBtn != null) {
			okBtn.click();
		}
	}

	public int captureTotalNumberOfPatinet(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = totalNumberOfPatientField.getAttribute("value");
		int text1 = Integer.parseInt(text);
		return text1;
	}

	public int captureAndCalculateNewQuantity(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		int totalQuantity = 0;
		for (WebElement element : listOfQuantity) {
			String qty = element.getText();
			int qty1 = Integer.parseInt(qty);
			totalQuantity = qty1 + totalQuantity;
		}
		return totalQuantity;
	}

	public void clickOnDeleteBtn_LineItem(WebDriver Driver) {
		wait_For_Invisibilty_OfElement_ForLoader(Driver);
		for (WebElement webElement : deleteBtnLineItem) {
			webElement.click();
		}
	}

	public void checkThatLineItemIsDeletedOrNot(WebDriver Driver) {
		try {
			if (lineItem.isDisplayed()) {
				Assert.fail("line item is not deleted");
			} else {
				System.out.println("Item is deleted");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
	}

}
