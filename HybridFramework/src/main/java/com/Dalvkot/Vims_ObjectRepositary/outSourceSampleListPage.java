package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class outSourceSampleListPage extends WebDriverUtility {

	public outSourceSampleListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Batch Number']")
	private WebElement batchNumberField;

	@FindBy(xpath = "//span[@role='textbox']/following-sibling::span[1]")
	private WebElement externalLabNameDropDownBtn;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]/descendant::a")
	private WebElement batchNumberInTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]")
	private WebElement externalLabNameInTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement dateAndTimeInTable;

	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement addBtn;

	@FindBy(xpath = "//input[@type='checkbox']/following-sibling::span[1]")
	private WebElement externalLabBtn;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement searchBoxForDropDown;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[2]")
	private WebElement patientnameInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[3]")
	private WebElement hospitalNumberInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[4]")
	private WebElement billNumberInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[5]/descendant::a")
	private WebElement sampleNumberInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[6]")
	private WebElement sampleDateInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[7]")
	private WebElement serviceClassInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[8]")
	private WebElement sampleTypeInTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[9]/descendant::input")
	private WebElement checkBoxInTable;

	@FindBy(xpath = "//button[text()='Send To Lab']")
	private WebElement sendToLabBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//a[contains(.,'Back')]")
	private WebElement backBtn;

	@FindBy(xpath = "//span[text()=' Out Source List ']")
	private WebElement outSourceLabPage;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement bathchNumberInSuccessfullPopUp;

	@FindBy(xpath = "//table[@class='table table-responsive-md']/tbody/tr[1]/td[7]/descendant::button")
	private WebElement uploadBtn;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement chooseFileUnderUploadBtn;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@id='swal2-content']")
	private WebElement uploadedSuccesfullyText;

	@FindBy(xpath = "//div[text()='Please select samples']")
	private WebElement popUpForWithoutSelectingCheckbox;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement xBtnForPopUp;
//	
//	@FindBy(xpath = "")
//	private WebElement ;

	// ---------------buissness logics-----------------------

	public void clickOnOutSourceLabPage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, outSourceLabPage);
	}

	public void outSourceLabPage(WebDriver driver) throws Throwable {

		addBtn.click();
		externalLabBtn.click();
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys("ON QUEST", Keys.ENTER);

		checkBoxInTable.click();
		scrollDownTheStillEndOfThePage(driver);

		scrollDownThePageUntilElementIsVisible(driver, sendToLabBtn);
		moveToTheParticularElementAndClick(driver, sendToLabBtn);
		invisibiltyOf_Element_ThreeDots(driver);
		String bn = bathchNumberInSuccessfullPopUp.getText();
		String batchNumber = bn.substring(bn.indexOf(":") + 1, bn.indexOf("and")).trim();
		okBtn.click();
		scrollUpUsingActions(driver);
		backBtn.click();

		invisibiltyOf_Element_ThreeDots(driver);
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys("ON QUEST", Keys.ENTER);

		batchNumberField.sendKeys(batchNumber);

		searchBtn.click();

		batchNumberInTable.click();

		uploadBtn.click();
		chooseFileUnderUploadBtn.sendKeys("\\src\\main\\resources\\Documents\\d1.PNG");

		submitBtn.click();

		Thread.sleep(1000);
		okBtn.click();
		Thread.sleep(1000);
	}

	public void outSourceLabPage1(WebDriver driver) throws Throwable {

		addBtn.click();

		externalLabBtn.click();
		Thread.sleep(2000);
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys("ON QUEST", Keys.ENTER);

		waitForElementWithCustomTimeOut(driver, checkBoxInTable, 5);

		checkBoxInTable.click();
		scrollDownTheStillEndOfThePage(driver);
		moveToTheParticularElementAndClick(driver, sendToLabBtn);
		String bn = bathchNumberInSuccessfullPopUp.getText();
		String batchNumber = bn.substring(bn.indexOf(":") + 1, bn.indexOf("and")).trim();
		System.out.println(bn);
		System.out.println(batchNumber);
		okBtn.click();
		waitForElementWithCustomTimeOut(driver, backBtn, 5);
		;
		scrollUpUsingActions(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, backBtn);
		waitForElementWithCustomTimeOut(driver, externalLabNameDropDownBtn, 5);
		explictWaitForElementToBeVisible(driver, externalLabNameDropDownBtn);

		Thread.sleep(3000);
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys("ON QUEST", Keys.ENTER);
		batchNumberField.sendKeys(batchNumber);
		searchBtn.click();
		explictWaitForElementToBeVisible(driver, batchNumberInTable);

		Thread.sleep(5000);
		batchNumberInTable.click();
		uploadBtn.click();
		chooseFileUnderUploadBtn
				.sendKeys("D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\d1.PNG");
		submitBtn.click();
		okBtn.click();
		Thread.sleep(500);
		clickOnTheElementUsedToJavascriptExecuter(driver, xBtnForPopUp);
	}

	public void clickOnClearBtn(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		waitForElementWithCustomTimeOut(driver, clearBtn, 5);

		clearBtn.click();

	}

	public String captureBatchNumberInTable(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String batchNumber = batchNumberInTable.getText();
		System.out.println(batchNumber);
		return batchNumber;
	}

	public String captureExternalLabNameInTable(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String ext = externalLabNameInTable.getText();
		System.out.println(ext);
		return ext;
	}

	public void SearchBatchNumber(WebDriver driver, String batchNumber) throws Throwable {
		batchNumberField.sendKeys(batchNumber);
		searchBtn.click();
		Thread.sleep(2000);
	}

	public void SearchExternalLabName(WebDriver driver, String ext) throws Throwable {
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys(ext, Keys.ENTER);
		searchBtn.click();
		Thread.sleep(2000);
	}

	public String verifyUploadDocuments(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		batchNumberInTable.click();
		uploadBtn.click();
		chooseFileUnderUploadBtn.sendKeys("\\src\\main\\resources\\Documents\\d1.PNG");
		submitBtn.click();
		String Text = uploadedSuccesfullyText.getText();
		System.out.println(Text);
		return Text;

	}

	public String verifyHospitalNumberIsReflectingInOutSourceLabScreen(WebDriver driver) throws Throwable {
		waitForElementWithCustomTimeOut(driver, addBtn, 5);

		Thread.sleep(5000);
		addBtn.click();
		Thread.sleep(1500);
		externalLabBtn.click();
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys("ON QUEST", Keys.ENTER);
		Thread.sleep(1000);
		String hsptl = hospitalNumberInTable.getText();
		System.out.println(hsptl);
		return hsptl;
	}

	public String verifyErrorMsgWithoutSelectingCheckbox(WebDriver driver) throws Throwable {
		Thread.sleep(5000);
		addBtn.click();
		externalLabBtn.click();
		externalLabNameDropDownBtn.click();
		searchBoxForDropDown.sendKeys("ON QUEST", Keys.ENTER);
		Thread.sleep(1500);
		scrollDownTheStillEndOfThePage(driver);
		sendToLabBtn.click();
		String pop = popUpForWithoutSelectingCheckbox.getText();
		Thread.sleep(500);
		okBtn.click();
		return pop;
	}

}
