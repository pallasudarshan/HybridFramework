package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class ReceiptSampleAtLabPage extends WebDriverUtility {

	public ReceiptSampleAtLabPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Receipt Sample At Lab ']")
	private WebElement receiptSampleAtLabBtn;

	@FindBy(xpath = "//span[text()='BIOCHEMISTRY']/following-sibling::span")
	private WebElement serviceClassDropdownBtn;

	@FindBy(xpath = "//input[@formcontrolname='selectionDate']")
	private WebElement sampleDate_Calender;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberText;

//	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary')])[2]")
//	private WebElement searchBtn;
	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]//input[@id='selectCheckId']")
	private WebElement selectBox_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]/descendant::a")
	private WebElement sampleNumber_Table;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[2]/input") })
	private List<WebElement> selectionCheckBoxs;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement sampleDate_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[4]")
	private WebElement lastRow_sampleDate_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement hospitalNumber_Table;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[4]") })
	private List<WebElement> sampleDates_Table;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[5]") })
	private List<WebElement> hospitalNumbers_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[6]")
	private WebElement op_ipNumber_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[7]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[8]")
	private WebElement age_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[9]")
	private WebElement gender_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[10]")
	private WebElement roomType_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[11]")
	private WebElement bedNumber_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[12]")
	private WebElement billNumber_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[13]")
	private WebElement billType_Table;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[last()]")
	private WebElement retestReason_Table;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr[1]/td[3])[2]")
	private WebElement serviceClassName_ServiceDetailsPopupTable;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr[1]/td[4])[2]")
	private WebElement serviceName_ServiceDetailsPopupTable;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr[1]/td[5])[2]")
	private WebElement sampleType_ServiceDetailsPopupTable;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement intMark_ServiceDetailsPopupTable;

	@FindBy(xpath = "//button[text()=' Next ']")
	private WebElement nextBtn;

	@FindBy(xpath = "//button[text()=' Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[3]")
	private WebElement serviceClass_SampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[4]")
	private WebElement serviceName_SampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[5]")
	private WebElement sampleType_SampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[6]/descendant::span[text()='YES']/following-sibling::span")
	private WebElement receivedAtLabDropdownBtn_SampleListTable;

	@FindBys({
			@FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[6]/descendant::span[text()='YES']/following-sibling::span") })
	private List<WebElement> receivedAtLabDropdown_ListBtns_SampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[2]/descendant::a")
	private WebElement sampleNumber_SampleListTable;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[3]/descendant::a") })
	private List<WebElement> sampleNumberS_SampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[7]/descendant::span[@title='Rejection reason']/following-sibling::span")
	private WebElement rejectReasonDropdownBtn_SampleListTable;

	@FindBys({
			@FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[last()-1]//span[@title='Rejection reason']/following-sibling::span") })
	private List<WebElement> rejectReasonDropdown_ListBtns_SampleListTable;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnForSuccessfullPopup;

	@FindBy(xpath = "//div[text()='Successfully Receipt Sample at Lab']")
	private WebElement successfullyReceiptSampleAtLabMsg;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[3]")
	private WebElement serviceClass_sampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[3]")
	private WebElement lastrowSampleNumber_sampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[5]")
	private WebElement lastrowHospitalNumber_sampleListTable;;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[6]")
	private WebElement lastrow_ip_opNumber_sampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[7]")
	private WebElement lastrow_PatientName_sampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[8]")
	private WebElement lastrowAge_sampleListTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[last()]/td[9]")
	private WebElement lastrowGender_sampleListTable;

	/*
	 * 
	 * 
	 * Buniess Logicss
	 * 
	 * 
	 * 
	 */
	public void clickOnReceiptAtSampleLabBtn(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, receiptSampleAtLabBtn);
	}

	public void selectServiceClass(WebDriver driver, String serviceClass) throws Throwable {
		serviceClassDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceClass);
	}

	public void selectServiceClassDropdown(WebDriver driver, String serviceClass) throws Throwable {
		serviceClassDropdownBtn.click();
		dropdownText.sendKeys(serviceClass, Keys.ENTER);
	}

	public void selectSampleDate(WebDriver driver, String sampleDate) {
		sampleDate_Calender.sendKeys(sampleDate);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);

	}

	public void SelectServiceClass(WebDriver driver, String ServiceClass) {
		serviceClass_SampleListTable.click();
	}

	public void enterSampleNumber(WebDriver driver, String sampleNumber) {
		sampleNumberText.sendKeys(sampleNumber);

	}

	public void clickOnTheSearchButton(WebDriver driver) throws Throwable {
		moveToTheParticularElementAndClick(driver, searchBtn);
	}

	public String takeSampleDate(WebDriver driver) {
		String sDate = sampleDate_Table.getText();
		String sampleDate1 = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sDate, 6);
		return sampleDate1;
	}

	public String takeLastRowSampleDate(WebDriver driver) {
		String sDate = lastRow_sampleDate_Table.getText();
		String sampleDate1 = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sDate, 6);
		return sampleDate1;
	}

	public void takeSampleDates(WebDriver driver, String sampleDate) {
		for (WebElement webElement : sampleDates_Table) {
			String sd = webElement.getText();
			String sampleDate1 = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sd, 6);
			Assert.assertEquals(sampleDate1, sampleDate);
		}
		System.out.println("Filtered a sample collected a  dates successfully");
	}

	public void clickOnClearButton(WebDriver driver) {
		clearBtn.click();
	}

	public void verifySampleNumber(WebDriver driver, String sample) throws Throwable {
		sampleNumberText.sendKeys(sample);
		clickOnTheSearchButton(driver);

		String sn = sampleNumber_Table.getText();
		Assert.assertEquals(sample, sn);
		System.out.println("Successfully Sample Number Verified");

	}

	public void clickOnFirst_SelectionCheckBox_Table(WebDriver driver) {
		selectBox_Table.click();
	}

	public void clickOnSelectionCheckBoxs_Table(WebDriver driver) throws Throwable {
		Thread.sleep(5000);

		int count = 1;
		for (WebElement wElement : selectionCheckBoxs) {
			WebElement webElement = driver.findElement(By.xpath(
					"//table[@id='example']/tbody/tr[" + count + "]/td[2]/descendant::input[@id='selectCheckId']"));
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.click();
			count++;
		}
	}

	public void clickOnSampleNumber_Table(WebDriver driver) {

		moveToTheParticularElementAndClick(driver, sampleNumber_Table);
	}

	public void clickOnNextButton(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownTheStillEndOfThePage(driver);
		nextBtn.click();
	}

	public String takeSampleNumber_SampleListTable(WebDriver driver) {
		String sampleNumber = sampleNumber_SampleListTable.getText();
		return sampleNumber;
	}

	public void takeSampleNumbersInTheTable() {
		List<WebElement> elements = sampleNumberS_SampleListTable;
		for (WebElement webElement : elements) {
			String sampleNumbers = webElement.getText();
		}

	}

	public void selectReceivedAtLabAtSampleList(WebDriver driver, String receivedAtLab) {
		receivedAtLabDropdownBtn_SampleListTable.click();
		moveToElementAndEnterTheData(driver, dropdownText, receivedAtLab);
	}

	public void selectReceivedAtLabAllDropdownsButtons(WebDriver driver, String receivedAtLab) throws Throwable {

		for (WebElement webElement : receivedAtLabDropdown_ListBtns_SampleListTable) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.click();
			moveToElementAndEnterTheData(driver, dropdownText, receivedAtLab);
		}

	}

	public void selectRejectReason_AllDropdownsButtons(WebDriver driver, String rejectReason) throws Throwable {
		for (WebElement webElement : rejectReasonDropdown_ListBtns_SampleListTable) {
			scrollDownTheStillEndOfThePage(driver);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.click();
			moveToElementAndEnterTheData(driver, dropdownText, rejectReason);
		}
	}

	public void selectRejectReasonAtSampleList(WebDriver driver, String rejectReason) {
		rejectReasonDropdownBtn_SampleListTable.click();
		moveToElementAndEnterTheData(driver, dropdownText, rejectReason);
	}

	public void clickOnSubmitButton(WebDriver driver) throws Throwable {

		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn);
		submitBtn.click();
	}

	public void clickOnOkButton(WebDriver driver) throws Throwable {
		okBtnForSuccessfullPopup.click();
	}

	public String takeHospitalNumbers_Table(WebDriver driver) {

		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String takeHospitalNumber_Table(WebDriver driver) {

		String hospitalNumber = hospitalNumber_Table.getText();
		return hospitalNumber;
	}

	public String takeBillNumber() {
		String billNumber = billNumber_Table.getText();
		return billNumber;
	}

	public void selectAllSamplesInTheTable(WebDriver driver) {

		int count = 1;
		for (WebElement wElement : selectionCheckBoxs) {
			WebElement webElement = driver.findElement(By.xpath(
					"//table[@id='example']/tbody/tr[" + count + "]/td[2]/descendant::input[@id='selectCheckId']"));
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			moveToTheParticularElementAndClick(driver, webElement);
			count++;
		}
	}

	public void verifyUnselectedSelectionCheckBox(WebDriver driver) {
		for (WebElement webElement : selectionCheckBoxs) {

			Assert.assertFalse(webElement.isSelected());
		}
	}

	public void selectCheckBox_CheckIsSelectedOrNot(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		clickOnFirst_SelectionCheckBox_Table(driver);
		boolean isSelected = selectBox_Table.isSelected();
		Assert.assertTrue(isSelected, "Checkbox is not selected");
	}

	public String takeSampleNumber(WebDriver driver) {
		String sampleNumber = sampleNumber_Table.getText();
		return sampleNumber;
	}

	public void clickOnCancelButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, cancelBtn);
		cancelBtn.click();

	}

	public void ReceiptAtSampleLab(WebDriver driver, String hospitalNumber, String receivedAtLab) throws Throwable {
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		clickOnFirst_SelectionCheckBox_Table(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		clickOnSubmitButton(driver);
		okBtnForSuccessfullPopup.click();
	}

	public String takeServiceClass_SampleList(WebDriver driver) {

		String serviceClass = serviceClass_sampleListTable.getText();
		return serviceClass;
	}

	public String takeServiceName_SampleList() {
		String serviceName = serviceName_SampleListTable.getText();
		return serviceName;
	}

	public String takeSampleType_SampleList(WebDriver driver) {
		String sampleType = sampleType_SampleListTable.getText();
		return sampleType;
	}

	public void hospitalNumber_Search_SelectionOneSample_Next(WebDriver driver, String hospitalNumber)
			throws Throwable {
		Thread.sleep(2000);
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		clickOnFirst_SelectionCheckBox_Table(driver);
		clickOnNextButton(driver);
	}

	public String takeOp_Ip_Number(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, op_ipNumber_Table);
		String opNumber = op_ipNumber_Table.getText();
		return opNumber;
	}

	public void selectionOneSample_Next_Submit_OkPopup(WebDriver driver) throws Throwable {
		moveToTheParticularElementAndClick(driver, selectBox_Table);
		clickOnNextButton(driver);
		clickOnSubmitButton(driver);
		okBtnForSuccessfullPopup.click();
	}

	public void receivedSampleAtLab_Reject_Process(WebDriver driver, String serviceClass, String hospitalNumber,
			String receivedAtLab, String rejectReason) throws Throwable {
		enterHospitalNumber(driver, hospitalNumber);
		selectServiceClassDropdown(driver, serviceClass);
		clickOnTheSearchButton(driver);
		selectAllSamplesInTheTable(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		selectRejectReason_AllDropdownsButtons(driver, rejectReason);
		clickOnSubmitButton(driver);
		clickOnOkButton(driver);
	}

	public void selectAllCheckBoxs_ReceiptSampleProcess(WebDriver driver, String hospitalNumber, String receivedAtLab)
			throws Throwable {
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		select_AllCheckboxs(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		clickOnSubmitButton(driver);
		okBtnForSuccessfullPopup.click();

	}

	public void rejectAllSamples_Process(WebDriver driver, String hospitalNumber, String receivedAtLab,
			String rejectReason) throws Throwable {
		Thread.sleep(2000);
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		select_AllCheckboxs(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		selectRejectReason_AllDropdownsButtons(driver, rejectReason);

		okBtnForSuccessfullPopup.click();
	}

	public String takeLastRow_HospitalNumber(WebDriver driver) {
		String hospitalNumber = lastrowHospitalNumber_sampleListTable.getText();
		return hospitalNumber;
	}

	public String takeLastRow_SampleNumber_List(WebDriver driver) {
		String sampleNumber = lastrowSampleNumber_sampleListTable.getText();
		return sampleNumber;
	}

	public String takeFirstRow_SampleNumber_List(WebDriver driver) {
		String sampleNumber = sampleNumber_SampleListTable.getText();
		return sampleNumber;
	}

	public void select_AllCheckboxs(WebDriver driver) {

		for (WebElement webElement : selectionCheckBoxs) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
		}
	}

	public void ReceiptAtSampleLab_2(WebDriver driver, String serviceClass, String hospitalNumber, String receivedAtLab)
			throws Throwable {
		Thread.sleep(5000);
		selectServiceClassDropdown(driver, serviceClass);
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		clickOnSelectionCheckBoxs_Table(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		clickOnSubmitButton(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtnForSuccessfullPopup.click();
	}

	public void ReceiptAtSampleLab_3(WebDriver driver, String hospitalNumber, String receivedAtLab) throws Throwable {
		Thread.sleep(5000);
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		clickOnSelectionCheckBoxs_Table(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		clickOnSubmitButton(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtnForSuccessfullPopup.click();
	}

	public void ReceiptAtSampleLab_Dynamic(WebDriver driver, String serviceClass, String hospitalNumber,
			String receivedAtLab) throws Throwable {
		Thread.sleep(12000);
		selectServiceClassDropdown(driver, serviceClass);
		enterHospitalNumber(driver, hospitalNumber);
		clickOnTheSearchButton(driver);
		clickOnSelectionCheckBoxs_Table(driver);
		clickOnNextButton(driver);
		selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		clickOnSubmitButton(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtnForSuccessfullPopup.click();
	}

	public void runReceiptAtSampleLab(WebDriver driver, List<String> serviceClasses, String hospitalNumber,
			String receivedAtLab) throws Throwable {
		for (String serviceClass : serviceClasses) {
			ReceiptAtSampleLab_Dynamic(driver, serviceClass, hospitalNumber, receivedAtLab);
		}
	}

}
