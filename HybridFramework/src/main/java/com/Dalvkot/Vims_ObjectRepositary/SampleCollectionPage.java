package com.Dalvkot.Vims_ObjectRepositary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class SampleCollectionPage extends WebDriverUtility {

	public SampleCollectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ----------------------------------------------XPATH-------------------------------------------------------------

	@FindBy(xpath = "//span[text()=' Sample Collection ']")
	private WebElement sampleCollectionPage;

	@FindBy(xpath = "//span[text()='OP']/following-sibling::span")
	private WebElement billTypeFilterDropDownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//span[@title='Select Service Class']/following-sibling::span")
	private WebElement serviceClassFilterDropDownBtn;

	@FindBy(xpath = "//label[text()='Sample Date']/following-sibling::input")
	private WebElement sampleDateFilter;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberFieldFilter;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumberField_List_Cancelled;

	@FindBy(xpath = "//input[@placeholder='Hospital No']")
	private WebElement hospitalNumber_NewSample;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumber_List;

	@FindBy(xpath = "//label[text()='Bill Number']/following-sibling::input")
	private WebElement billNumberFieldFilter;

	@FindBy(xpath = "//label[text()='Patient Name']/following::input")
	private WebElement patientNameFieldFilter;

	@FindBy(xpath = "(//button[text()=' Search']//i)[1]")
	private WebElement searchBtnFor_NewCollection;

	@FindBy(xpath = "(//button[text()=' Search'])[1]")
	private WebElement serahcBtnFor_ListTable;

	@FindBy(xpath = "(//button[text()=' Search'])[2]")
	private WebElement searchBtnForCancelledListTableFilter;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement clearBtnForFilter_List;

	@FindBy(xpath = "(//button[text()=' Clear'])[2]")
	private WebElement clearBtnFor_CancelledList;

	@FindBy(xpath = "//a[contains(text(),'New Sample')]")
	private WebElement newSampleBtn;

	@FindBy(xpath = "//input[@formcontrolname='selectionDate']")
	private WebElement billDate_SelectionCreteria;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span[1]")
	private WebElement departmentDropDownBtn;

	@FindBy(xpath = "//label[text()='Department']/following::input")
	private WebElement ruralPatientCheckBox;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement searchBoxForDropDown;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[2]")
	private WebElement hospitalNumberInTable_FirstRow;

	@FindBy(xpath = "//div[@id='OPD']//table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumberInListTable_FirstRow;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]/descendant::a")
	private WebElement billNoIntable_FirstRow;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]/descendant::a")
	private WebElement billNumberSelectionCreteria_LastRow;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[4]")
	private WebElement lastRowPatientName_SelectionCreteria;

	@FindAll({ @FindBy(xpath = "//table//tr[last()]/td[3]//a") })
	private WebElement lastRowBillNum_NewSample;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[4]")
	private WebElement patientNameInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[5]")
	private WebElement ageInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[6]")
	private WebElement genderInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[7]")
	private WebElement departmentInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[8]")
	private WebElement doctorNameInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[9]")
	private WebElement billDateInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[10]")
	private WebElement roomTypeInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[11]")
	private WebElement wardTypeInTable_FirstRow;

	@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr[1]/td[12]")
	private WebElement bedNumberInTable_FirstRow;

	@FindBy(xpath = "(//span[@class='select2-selection__rendered']/following-sibling::span)[3]")
	private WebElement sampleCollectedDropDownBtnInTable_Firstrow;

	@FindBy(xpath = "//span[@id='select2-ji4l-container']/following-sibling::span[1]")
	private WebElement rejectedReasonDropDownBtnInTable_Firstrow;

	@FindBy(xpath = "//span[@id='select2-ji4l-container']/following-sibling::span[1]")
	private WebElement existingSampleNumberDropDownBtnInTable_FirstRow;

	@FindAll({
			@FindBy(xpath = "//table[@class='table table-striped row-border hover']/tbody/tr/td[last()]/descendant::button[@data-target='#exampleModalCenter']//a") })
	private WebElement viewBtnInTable_NewSample;

	@FindBys({ @FindBy(xpath = "//button[@data-target='#exampleModalCenter']//i[@class='zmdi zmdi-edit']") })
	private WebElement viewBtnInTable;

	@FindBys({ @FindBy(xpath = "//table//tr//td//button[@data-target='#exampleModalCenter']") })
	private List<WebElement> listOfViewButtons_ServiceDetailsTable;

	@FindAll({ @FindBy(xpath = "//button[text()='OK']") })
	private WebElement okBtnMsg1;

	@FindAll({ @FindBy(xpath = "(//button[@type='submit'])[2]"), @FindBy(xpath = "(//button[text()=' Submit '])[1]") })
	private WebElement submitBtnIn_SampleCollectionPage;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[@id='exampleModalCenter']//button[text()=' Submit ']")
	private WebElement submitBtn_ServicesPopup;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Cancelled List')]"), @FindBy(linkText = "Cancelled List"),
			@FindBy(xpath = "(//a[@data-toggle='tab'])[2]") })
	private WebElement cancelledListTab;

	@FindBy(xpath = "(//li[@class='pagination-next disabled']//span)[1]")
	private WebElement nextBtnForPaginationUnderTable;

	@FindBy(xpath = "(//li[@class='pagination-previous disabled']//span)[1]")
	private WebElement previousBtnForPaginationUnderTable;

	@FindBy(xpath = "/html/body/app-root/app-home/app-sample-collection-list/section/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/table/tbody/tr[1]/td[7]")
	private WebElement serviceClassInTable_FirstRow;

	@FindBy(xpath = "/html/body/app-root/app-home/app-sample-collection-list/section/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/table/tbody/tr[1]/td[5]")
	private WebElement sampleNumberInTable_FirstRow;

	@FindBy(xpath = "/html/body/app-root/app-home/app-sample-collection-list/section/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/table/tbody/tr/td[3]")
	private WebElement hospitalNumberInTableSearchPage_FirstRow;

	@FindBy(xpath = "/html/body/app-root/app-home/app-sample-collection-list/section/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]")
	private WebElement billNumberInTableSearchPage_FirstRow;

	@FindBy(xpath = "/html/body/app-root/app-home/app-sample-collection-list/section/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/table/tbody/tr/td[2]")
	private WebElement patientNameInTableSearchPage_FirstRow;

	@FindBy(xpath = "(//table/tbody[1]/tr[1]/td[6]//span[@role='presentation'])[2]")
	private WebElement sampleCollectedDropDownBtnInViewPopup;

	@FindBys({
			@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr/td[6]//span[@role='presentation']") })
	private List<WebElement> sampleCollectedDropDownBtns_InViewPopup;

	@FindBy(xpath = "(//button[@aria-label='Close']//span)[2]")
	private WebElement closeBtnInViewPopUp;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement submitBtnInViewPopUp;

	@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[3]")
	private WebElement sampleCollectedTextInTable;

	@FindBy(xpath = "//button[text()=' Back ']")
	private WebElement backBtn;

	@FindBy(xpath = "(//td[text()='1']/following-sibling::td)[1]")
	private WebElement serviceClassInServiceDetailsTable;

	@FindBy(xpath = "(//td[text()='1']/following-sibling::td)[2]")
	private WebElement serviceTypeInServiceDetailsTable;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[1]")
	private WebElement serviceClassInViewPopup;

	@FindBy(xpath = "(//b[text()=':']/following-sibling::label)[2]")
	private WebElement serviceTypeInViewPopup;

	@FindBy(xpath = "(//li[contains(@class,'select2-results__option select2-results__option--selectable')])[1]")
	private WebElement NoInSampleCollectedDropDown_viewpopup;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement patientName_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumber_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement billNumber_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[5]//a")
	private WebElement sampleNumber_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement sampleNumberInLastToThe_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement sampleDate_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement serviceClass_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement sampleType_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement sampleStatus_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement receivedBy_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionButton_ListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement patientName_CacnelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement hospitalNumber_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement billNumber_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[5]/descendant::a")
	private WebElement sampleNumberIn_CancelledList;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement sampleDate_CancelledListTable;

	@FindBys({ @FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr/td[6]") })
	private List<WebElement> sampleDates_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement serviceClass_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement sampleType_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement rejectionReason_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement receivedBy_CancelledListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionBtn_CancelledListTable;

	@FindBy(xpath = "(//table[@class='table table-responsive-md']//td)[2]")
	private WebElement serviceName_CancelledSampleNumberPopup;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement intMark_CancelledListSampleNumberPopup;

	@FindBy(xpath = "//td[text()='1']/following-sibling::td[1]")
	private WebElement serviceClass_ServiceDetailsTable;

	@FindBy(xpath = "//table[@class='table table-responsive-md']/tbody/tr[1]/td[4]/descendant::span[1]")
	private WebElement externalLabBtn;

	@FindBy(xpath = "//table[@class='table table-responsive-md']/tbody/tr[1]/td[5]/descendant::span[@class='select2-selection__arrow']")
	private WebElement externalLabNameDropDownBtn;

	@FindBy(xpath = "(//li[@class='select2-results__option select2-results__option--selectable'])[1]")
	private WebElement searchBoxDropDownFirstElement;

	@FindBys({ @FindBy(xpath = "//table[@letxpath='letxpathtable']/tbody/tr/td[2]/descendant::span") })
	private List<WebElement> servicesClass_ExternalLab_ServiceDetails;

	@FindBys({ @FindBy(xpath = "//table/tbody/tr/td[7]") })
	private List<WebElement> serviceClass_ListTable_List;

	// ------------------------logics-------------------------------------

	public void clickOnSampleCollectionPage(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, sampleCollectionPage);
	}

	public void clickOnNewSampleButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, newSampleBtn);

	}

	public void selectBillTypeFilter(WebDriver driver, String billType) throws Throwable {
		billTypeFilterDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, billType);
	}

	public void selectServiceClassFilter(WebDriver driver, String serviceClass) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		serviceClassFilterDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, serviceClass);

	}

	public void enterSampleDateFilter(WebDriver driver, String sampleDate) {
		sampleDateFilter.sendKeys(sampleDate);
	}

	public void enterSampleNumberFilter(WebDriver driver, String sampleNumber) {
		sampleNumberFieldFilter.sendKeys(sampleNumber);

	}

	public void enter_HospitalNumber_List_Cancelled(WebDriver driver, String hospitalNumber) {
		hospitalNumberField_List_Cancelled.sendKeys(hospitalNumber);
	}

	public void enterBillNumberFilter(WebDriver driver, String billNumber) throws Throwable {
		billNumberFieldFilter.sendKeys(billNumber);
	}

	public void enterPatientNameFilter(WebDriver driver, String patientName) {
		patientNameFieldFilter.sendKeys(patientName);
	}

	public void clickOnSearchButton_Cancelled_ListTable(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		searchBtnForCancelledListTableFilter.click();
	}

	public void clickOn_Clear_Button_List(WebDriver driver) {
		clearBtnForFilter_List.click();
	}

	public void sampleCollection(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public void sampleCollection_ProcessForSingleSample(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);
		scrollDownTheStillEndOfThePage(driver);

		viewBtnInTable.click();
		submitBtn_ServicesPopup.click();

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public String verifySampleCollectionRetestForNewSample(WebDriver driver, String hospitalNumber) throws Throwable {

		enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);

		clickOnSearchButton_ListTable(driver);

		String ret = sampleStatus_ListTable.getText();

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textColor = (String) jsExecutor.executeScript("return getComputedStyle(arguments[0]).color;",
				sampleStatus_ListTable);

		String expectedColor = "rgb(32, 107, 247)";

		if (textColor.equals(expectedColor)) {
			System.out.println("Text color is as expected [blue].");
		} else {
			System.out.println("Text color is not as expected [blue].");
		}

		return ret;

	}

	public void verifyBySelectingNoInSalmpleCollectedDropDown(WebDriver driver) throws Throwable {

		clickOnNewSampleButton(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);

		clickOnTheElementUsedToJavascriptExecuter(driver, billNumberSelectionCreteria_LastRow);

		scrollDownTheStillEndOfThePage(driver);

		sampleCollectedDropDownBtnInTable_Firstrow.click();
		searchBoxForDropDown.sendKeys("NO");
		searchBoxForDropDown.sendKeys(Keys.ENTER);

		boolean isVisible = isElementPresent(driver);
		Assert.assertEquals(isVisible, false);
		System.out.println("Element is not visible ");

	}

	public boolean isElementPresent(WebDriver driver) {
		try {
			viewBtnInTable_NewSample.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void sampleCollected_AllDropdownButtons_ViewPopup(WebDriver driver) {
		for (WebElement webElement : sampleCollectedDropDownBtns_InViewPopup) {
			webElement.click();
			searchBoxForDropDown.sendKeys("NO");
			searchBoxForDropDown.sendKeys(Keys.ENTER);
		}
	}

	public void verifySampleCollectedTextInTable(WebDriver driver) throws Throwable {

		clickOnNewSampleButton(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);

		viewBtnInTable.click();

		sampleCollected_AllDropdownButtons_ViewPopup(driver);

		submitBtnInViewPopUp.click();

		String sc = sampleCollectedTextInTable.getText();
		Assert.assertEquals("NO", sc);

	}

	public String clickOnBackBtnAndCaptureSampleNumber(WebDriver driver, String hospitalNumber) throws Throwable {

		moveToTheParticularElementAndClick(driver, backBtn);

		enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		String sampleNo = sampleNumberInTable_FirstRow.getText();
		return sampleNo;
	}

	public String captureSampleNumber(WebDriver driver) throws Throwable {
		String sample = sampleNumberInTable_FirstRow.getText();
		return sample;

	}

	public void verifyServiceClassAndServiceTypeInViewPopup(WebDriver driver) throws Throwable {

		clickOnNewSampleButton(driver);

		String bn = billNumberSelectionCreteria_LastRow.getText();

		billNumberFieldFilter.sendKeys(bn);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, viewBtnInTable_NewSample);

		viewBtnInTable_NewSample.click();

		scrollDownTheStillEndOfThePage(driver);
		String sc = serviceClassInServiceDetailsTable.getText();
		String st = serviceTypeInServiceDetailsTable.getText();
		Thread.sleep(2000);

		String sc1 = serviceClassInViewPopup.getText();
		String st1 = serviceTypeInViewPopup.getText();

		Assert.assertEquals(sc, sc1);
		Assert.assertEquals(st, st1);
		System.out.println("Successfully service class and service type is verified");

	}

	public void clickOnBackAndVerifyCreatedSampleInTheList(WebDriver driver, String hospitalNumber) throws Throwable {
		clickOnBackButton(driver);

		enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		String hs = hospitalNumberInListTable_FirstRow.getText();
		Assert.assertEquals(hospitalNumber, hs);
		System.out.println("successfully created sample collection is verified in the sample collection list");

	}

	public void sampleCollection1(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, newSampleBtn);

		selectBillTypeFilter(driver, "IP");

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);
		clickOnLast_Row_BillNumber_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);

		moveToTheParticularElementAndClick(driver, viewBtnInTable);

		moveToTheParticularElementAndClick(driver, sampleCollectedDropDownBtnInViewPopup);
		moveToElementAndEnterTheData(driver, dropdownText, "NO");

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public void clickOnCancelledListTab(WebDriver driver) throws Throwable {

		clickElementWithRetries(driver, 4, cancelledListTab);
	}

	public String captureSampleNumberInTable(WebDriver driver) throws Throwable {
		explictWaitForElementToBeVisible(driver, sampleNumberInTable_FirstRow);
		String sampleNumber = sampleNumberInTable_FirstRow.getText();
		return sampleNumber;
	}

	public String takeHospitalNumber_SelectionCreteria(WebDriver driver) {

		String hospitalNumber = hospitalNumberInTable_FirstRow.getText();
		return hospitalNumber;
	}

	public String takeLastRowBillNumberThe_SelectionCreteriaTable(WebDriver driver) throws InterruptedException {

		String lastBillNumber = billNumberSelectionCreteria_LastRow.getText();
		return lastBillNumber;
	}

	public String takeBillNumberInThe_SelectionCreteriaTable(WebDriver driver) {
		String billNumber = billNoIntable_FirstRow.getText();
		return billNumber;

	}

	public String takePatientNameInTheSelectionCreteriaTable(WebDriver driver) {
		String patientName = patientNameInTable_FirstRow.getText();
		return patientName;
	}

	public String takeBillDate_SelectioncreteriaTable(WebDriver driver) {

		String bd = billDateInTable_FirstRow.getText();
		String billDate = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(bd, 8);
		return billDate;

	}

	public String takeDepartmentIn_SelectinCreteriaTable(WebDriver driver) throws Throwable {

		String department = departmentInTable_FirstRow.getText();
		return department;
	}

	public void enterBillDate(WebDriver driver, String billdate) {

		billDate_SelectionCreteria.sendKeys(billdate);

	}

	public void selectDepartment(WebDriver driver, String department) throws Throwable {
		Thread.sleep(2000);
		departmentDropDownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);

	}

	public void selectSampleDate(WebDriver driver) {
		enterSampleDateFilter(driver, getSystemDateAndTime());

	}

	public void clickOnBackButton(WebDriver driver) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, backBtn);
	}

	public String takePatientName_ListTable() {
		String name = patientName_ListTable.getText();
		String name1 = removeSpecialCharacters_And_Speces(name);
		String patientName = removeFirst_n_NumberOfCharacters(name1, 2);
		return patientName;
	}

	public String takeHospitalName_ListTable(WebDriver driver) {

		String hospitalNumber = hospitalNumber_ListTable.getText();
		return hospitalNumber;
	}

	public String takeBillNumber_ListTable(WebDriver driver) {
		String billNumber = billNumber_ListTable.getText();
		return billNumber;
	}

	public String takeSampleDate_ListTable(WebDriver driver) {
		String sd = sampleDate_ListTable.getText();
		String sampleDate = removedSpecialCharctersAndRemovedSpaces(sd, 5);
		return sampleDate;
	}

	public String takeSampleNumber_ListTable(WebDriver driver) {
		String sampleNumber = sampleNumber_ListTable.getText();
		return sampleNumber;
	}

	public String takeSampleNumber_ListLastRow_Table() {
		String sampleNumber = sampleNumberInLastToThe_ListTable.getText();
		return sampleNumber;
	}

	public String takeServiceClass_ListTable(WebDriver driver) {
		String serviceClass = serviceClass_ListTable.getText();
		return serviceClass;
	}

	public String takeSampleType_ListTable(WebDriver driver) {
		String sampleType = sampleType_ListTable.getText();
		return sampleType;
	}

	public String takeSampleStatus_ListTable(WebDriver driver) {
		String sampleStatus = sampleStatus_ListTable.getText();
		return sampleStatus;
	}

	public String takeReceivedBy_ListTable(WebDriver driver) {
		String receivedBy = receivedBy_ListTable.getText();
		return receivedBy;
	}

	public String takePatientName_CancelledListTable(WebDriver driver) {
		String patientName = patientName_CacnelledListTable.getText();
		return patientName;
	}

	public String takeHospitalNumber_CancelledListTable(WebDriver driver) {
		String hospitalNumber = hospitalNumber_CancelledListTable.getText();
		return hospitalNumber;
	}

	public String takeBillNumber_CancelledListTable(WebDriver driver) {
		String billNumber = billNumber_CancelledListTable.getText();
		return billNumber;
	}

	public String takeSampleNumberInCancelledList(WebDriver driver) {
		String sampleNumber = sampleNumberIn_CancelledList.getText();
		return sampleNumber;
	}

	public String takeSampleDate_CancelledListTable(WebDriver driver) throws InterruptedException {

		Thread.sleep(2000);
		String sDate = sampleDate_CancelledListTable.getText();
		String sampleDate = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sDate, 8);
		return sampleDate;
	}

	public void takeSampleDates_CancelledListTable(WebDriver driver, String sampleDate) throws Throwable {
		Thread.sleep(2000);
		for (WebElement webElement : sampleDates_CancelledListTable) {
			String sDate1 = webElement.getText();
			String sampleDate1 = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sDate1, 8);
			Assert.assertEquals(sampleDate1, sampleDate);
		}
	}

	public String takeServiceClass_CancelledListTable(WebDriver driver) {
		String serviceClass = serviceClass_CancelledListTable.getText();
		return serviceClass;
	}

	public String takeSampleType_CancelledListTable(WebDriver driver) {
		String sampleType = sampleType_CancelledListTable.getText();
		return sampleType;
	}

	public String takeRejectoinReason_CancelledListTable(WebDriver driver) {
		String rejectionReason = rejectionReason_CancelledListTable.getText();
		return rejectionReason;
	}

	public String takeReceivedBy_CancelledList(WebDriver driver) {
		String receivedBy = receivedBy_CancelledListTable.getText();
		return receivedBy;
	}

	public void clickOnSampleNumber_CancelledList(WebDriver driver) {
		sampleNumberIn_CancelledList.click();
	}

	public String takeServiceNameInThe_CancelledSampleNumberPopup() {
		String serviceName = serviceName_CancelledSampleNumberPopup.getText();
		return serviceName;

	}

	public void clickOnCancelledListSampleNumber_PopupIntMark(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, intMark_CancelledListSampleNumberPopup);

	}

	public void clickOnSearchButton_ListTable(WebDriver driver) throws Throwable {
		serahcBtnFor_ListTable.click();
	}

	public void clickOnClearButtonFor_CancelledList(WebDriver driver) throws InterruptedException {

		moveToTheParticularElementAndClick(driver, clearBtnFor_CancelledList);
	}

	public void sampleCollectionForExternalLabServices(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public void sampleCollectionForOneSample(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public void sampleCollectionForOneSample1(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);
		// explicityWaitForElemenToBeClickable(driver, billTypeFilterDropDownBtn);

		billTypeFilterDropDownBtn.click();
		searchBoxForDropDown.sendKeys("IP", Keys.DOWN, Keys.ENTER);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		searchBtnFor_NewCollection.click();

		clickOnLast_Row_BillNumber_NewSamples(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public void billNumber_To_Submit(WebDriver driver) throws Throwable {

		clickOnLast_Row_BillNumber_NewSamples(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public String takeDoctorNameSelectionDetailsTable(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		String doctorName = doctorNameInTable_FirstRow.getText();
		return doctorName;
	}

	public String takeServiceClassName_ServiceDetailsTable(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		String serviceClass = serviceClass_ServiceDetailsTable.getText();
		return serviceClass;
	}

	public void clickOnTheBillNumber_NewSample(WebDriver driver) {
		billNumberSelectionCreteria_LastRow.click();
	}

	public void clickonAllViewbuttons_submit(WebDriver driver) throws Throwable {

		scrollDownTheStillEndOfThePage(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		Thread.sleep(1000);
		clickOn_Ok_Popup_Button(driver);
	}

	public String takePatientName_SelectionCreteria(WebDriver driver) {
		String patientName = patientNameInTable_FirstRow.getText();
		return patientName;
	}

	public void clickOnViewButtons_And_ClickOnSubmit(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		clickOnAllViewButtons_PopupSubmitButton(driver);
		clickOnSubmitButton_newSampleCollectionPage(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void clickOnLastRowBillNumber_NewSample(WebDriver driver) throws Throwable {

		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, lastRowBillNum_NewSample);

	}

	public String takeLastRowPatientName_SelectionCreteria(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		String lastRowPatientName = lastRowPatientName_SelectionCreteria.getText();
		return lastRowPatientName;
	}

	public void sampleCollectionFor_Updated_BillNumber(WebDriver driver, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		scrollDownTheStillEndOfThePage(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void clickOnAllViewButtons_And_Submit(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		clickOnAllViewButtons_PopupSubmitButton(driver);
		clickOnSubmitButton_newSampleCollectionPage(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void serviceClass_ExtrenalLab_ServiceDetailsTable(WebDriver driver, String serviceClass) {
		scrollDownTheStillEndOfThePage(driver);
		for (WebElement webElement : servicesClass_ExternalLab_ServiceDetails) {
			String serviceClass1 = webElement.getText();
			Assert.assertEquals(serviceClass1, serviceClass);
			System.out.println("Externale Lab service class verified in the sample collection page successfully");
		}
	}

	public void clickOnSubmitButton_newSampleCollectionPage(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtnIn_SampleCollectionPage.click();
	}

	public void clickOnSubmitButton_ServicesPopup_NewSample(WebDriver driver) throws Throwable {
		Thread.sleep(500);
		submitBtn_ServicesPopup.click();
	}

	public void clickOnAllViewButtons_PopupSubmitButton(WebDriver driver) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownTheStillEndOfThePage(driver);
		for (WebElement Element : listOfViewButtons_ServiceDetailsTable) {
			scrollDownTheStillEndOfThePage(driver);
			scrollDownThePageUntilElementIsVisible(driver, Element);
			Thread.sleep(500);
			Element.click();
			
			explictWaitForElementToBeVisible(driver, sampleCollectedDropDownBtnInViewPopup);
			sampleCollectedDropDownBtnInViewPopup.click();
			moveToElementAndEnterTheData(driver, dropdownText, "YES");
			
			clickOnSubmitButton_ServicesPopup_NewSample(driver);
		}
	}

	public void clickOnLast_Row_BillNumber_NewSamples(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, lastRowBillNum_NewSample);
		lastRowBillNum_NewSample.click();
	}

	public void clickOn_Search_Button_NewSamples(WebDriver driver) {
		searchBtnFor_NewCollection.click();
	}

	public void enter_HopsitalNumber_NewSample(WebDriver driver, String hospitalNumber) {
		hospitalNumber_NewSample.sendKeys(hospitalNumber);
	}

	public void enter_HopsitalNumber_List(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(5000);
		hospitalNumber_List.sendKeys(hospitalNumber);
	}

	public void clickOn_Ok_Popup_Button(WebDriver driver) {
		okBtnMsg1.click();
	}

	public void sampleCollection(WebDriver driver, String billType, String hospitalNumber) throws Throwable {

		clickOnNewSampleButton(driver);

		selectBillTypeFilter(driver, billType);

		enter_HopsitalNumber_NewSample(driver, hospitalNumber);

		clickOn_Search_Button_NewSamples(driver);

		clickOnLast_Row_BillNumber_NewSamples(driver);

		clickOnAllViewButtons_PopupSubmitButton(driver);

		clickOnSubmitButton_newSampleCollectionPage(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public List<String> captureListOfServiceClasses_ListTable(WebDriver driver) {
		List<String> textData = new ArrayList<>();
		for (WebElement element : serviceClass_ListTable_List) {
			textData.add(element.getText());
		}
		return textData;
	}
}
