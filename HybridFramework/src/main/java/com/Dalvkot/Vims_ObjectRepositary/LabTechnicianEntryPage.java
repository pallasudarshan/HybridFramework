package com.Dalvkot.Vims_ObjectRepositary;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class LabTechnicianEntryPage extends WebDriverUtility {

	public LabTechnicianEntryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Lab Technician Entry ']")
	private WebElement labTechnicianEntryPageBtn;

	@FindBy(xpath = "//span[text()=' Lab Technician Entry ']")
	private WebElement labTechnicianEntryPage;

	@FindBy(xpath = "//input[@formcontrolname='sampleNo']")
	private WebElement sampleNumberTextField;

	@FindBy(xpath = "//input[@formcontrolname='hospitalNumber']")
	private WebElement hospitalNumberTextField_List_Partial;

	@FindBy(xpath = "//label[text()='Service Class']/..//span[@role='presentation']")
	private WebElement serviceClassDropDownBtn;

	@FindBy(xpath = "//label[text()='Service Class']/..//span[@role='presentation']")
	private WebElement serviceClassDropdownButton;

	@FindBy(xpath = "//input[@formcontrolname='selectionDate']")
	private WebElement selectionDateField;

	@FindBy(xpath = "//span[@title='Select Department Name']/following-sibling::span")
	private WebElement departmentNameDropDown;

	@FindBy(xpath = "//span[@title='Select Ward Type']/following-sibling::span")
	private WebElement wardTypeDropdownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement searchBooxForDropDown;

	@FindBy(xpath = "//input[@id='testresult']")
	private WebElement completeRadioButton;

	@FindBy(xpath = "//input[@id='pendingtestorder']")
	private WebElement incompleteRadioButton;

	@FindBy(xpath = "//input[@id='emergency']")
	private WebElement emergencyCheckBoxBtn;

	@FindAll({ @FindBy(xpath = "//button[text()=' Search']"),
			@FindBy(xpath = "//button[text()=' Search']/descendant::i[@class='zmdi zmdi-search']"),
			@FindBy(xpath = "(//button[@type='button'])[2]") })
	private WebElement searchBtn_List_Partial;

	@FindBys({ @FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[5]") })
	private List<WebElement> hospitalNumbers_ListTable;

	@FindBy(xpath = "//button[text()=' Clear']")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[text()='List']")
	private WebElement listTab;

	@FindAll({ @FindBy(xpath = "//a[@id='partialList']"), @FindBy(xpath = "//a[contains(text(),'Partial List')]") })
	private WebElement partialTab;

	@FindAll({ @FindBy(xpath = "//div[@id='OPD']//table//tr[1]/td[2]/descendant::a") })
	private WebElement sampleNumberInTableUnderListTab_FirstRow;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement ruralCheckBoxUnderFilter;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement sampleNumber_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[last()]/td[2]/descendant::a")
	private WebElement sampleNumber_LastRow_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[last()]/td[2]/descendant::a")
	private WebElement sampleNumber_ListLastRowTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[1]/td[3]")
	private WebElement sampleType_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[last()]/td[3]")
	private WebElement sampleType_LastrRow_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[1]/td[4]")
	private WebElement sampleDate_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[1]/td[7]")
	private WebElement patientName_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[last()]/td[7]")
	private WebElement patientName_LastRow_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[1]/td[8]")
	private WebElement department_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[1]/td[9]")
	private WebElement doctorName_PartialTable;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[last()]/td[9]")
	private WebElement doctorName_LastRow_PartialTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement sampleType_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement sampleDate_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement hospitalNumber_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[last()]/td[6]")
	private WebElement hospitalNumber_LastRow_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement op_ipNumber_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement patientName_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement Department_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement doctorName_ListTable;

	@FindBy(xpath = "//div[@id='OPD']/descendant::table/tbody/tr[last()]/td[10]")
	private WebElement doctorName_LastRow_ListTable;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table/tbody/tr[1]/td[2]/a")
	private WebElement sampleNumberInTable;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[6]/input[@placeholder='Result']")
	private WebElement resultTextFiled;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement referenceRangeFiled;

	@FindBy(xpath = "//input[@placeholder='Remarks']")
	private WebElement remarksTextField;

	@FindBy(xpath = "//input[@placeholder='Sample Number']")
	private WebElement sampleNumberField_selectionDetails;

	@FindBy(xpath = "//input[@placeholder='Sample from']")
	private WebElement sampleDateField_selectionDetails;

	@FindBy(xpath = "//button[text()=' Test Verify']")
	private WebElement testVerifyBtn_SelectionDetails;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement OkBtnInPopup;

	@FindBy(xpath = "//label[text()='Status']/..//span[@role='presentation']")
	private WebElement statusDropDownBtn;

	@FindBy(xpath = "//label[text()='Reason']/..//span[@role='presentation']")
	private WebElement reasonDropDownBtn;

	@FindBy(xpath = "//label[text()='Re-Test Type']/..//span[@role='presentation']")
	private WebElement retestTypeDropDownBtn;

	@FindBy(xpath = "//div[text()='Please enter results to submit']")
	private WebElement popUpTeXtForClickingOnSubmitWithoutResult;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[6]/input[@placeholder='Result']") })
	private List<WebElement> listOfResultTextField;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[11]/descendant::input[@type='checkbox']")
	private WebElement checkBoxInResultEntry_Firstrow;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[2]/td[11]/descendant::input[@type='checkbox']")
	private WebElement checkBoxInResultEntry_Secondrow;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[2]") })
	private List<WebElement> listOfServiceNames;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[2]") })
	private List<WebElement> listOfServiceNames1;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[10]/a[1]")
	private WebElement viewBtnUnderPreviewResult;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[2]")
	private WebElement serviceNameInResultEntry;

	@FindBy(xpath = "//div[@class='modal-content']/descendant::table[@class='table table-responsive-md text-center ng-star-inserted']/tbody/tr[1]/td[3]")
	private WebElement serviceNamefieldInViewPopUp;

	@FindBy(xpath = "//div[@class='modal-content']/descendant::table[@class='table table-responsive-md text-center ng-star-inserted']/tbody/tr[1]/td[5]")
	private WebElement reultfieldInViewPopUp;

	@FindBy(xpath = "//a[contains(text(),'Gram Stain')]")
	private WebElement gramStainBtn;

	@FindBy(xpath = "(//input[@name='check'])[1]")
	private WebElement noGrowthCheckBox;

	@FindBy(xpath = "(//input[@name='check'])[2]")
	private WebElement positiveGrowthCheckBox;

	@FindBy(xpath = "(//input[@name='check'])[3]")
	private WebElement finalGrowthCheckBox;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[2]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]")
	private WebElement organismDropDownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[3]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]")
	private WebElement antibioticDropDownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[4]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]")
	private WebElement cascadeTypeDropDownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[5]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]")
	private WebElement sensitivityDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='breakpoint']")
	private WebElement susceptibleBreakPointTextField;

	@FindBy(xpath = "//input[@placeholder='MIC']")
	private WebElement mcTextField;

	@FindBy(xpath = "//input[@placeholder='Efficient Ratio']")
	private WebElement BMQTextField;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[9]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]")
	private WebElement senesitivityMethodDropDownBtn;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[10]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]")
	private WebElement cultureMethodDropDownBtn;

	@FindBy(xpath = "(//input[@placeholder='Notes'])[2]")
	private WebElement notesToDoctorTextField;

	@FindBy(xpath = "(//input[contains(@class,'check ng-untouched')])[2]")
	private WebElement sendResultCheckbox;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary')])[2]")
	private WebElement addBtnForResultEntry;

	@FindBys({
			@FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[5]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]") })
	private List<WebElement> listOfsensitifityDropDownBtn;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[6]/descendant::input") })
	private List<WebElement> ListOfSusceptibleBreakPointTextField;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[7]/descendant::input") })
	private List<WebElement> listOfMicTextField;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody/tr/td[8]/descendant::input") })
	private List<WebElement> listOfBmqTextField;

	@FindBys({
			@FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[9]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]") })
	private List<WebElement> listOfSensitivityMethodDropDownMethod;

	@FindBys({
			@FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[10]/ng-select2[1]/span[1]/span[1]/span[1]/span[2]") })
	private List<WebElement> listOfcultureMethodDropDown;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[12]/input[1]") })
	private List<WebElement> listOfNotesToDoctorTextField;

	@FindAll({ @FindBy(xpath = "//body[@aria-label='Editor, editor1']"),
			@FindBy(xpath = "//body[@aria-label='Rich Text Editor, editor1']") })
	private WebElement inputFieldFirResultIframe;

	@FindAll({ @FindBy(xpath = "//iframe[@title='Editor, editor1']"),
			@FindBy(xpath = "//iframe[@title='Rich Text Editor, editor1']") })
	private WebElement iframe_result;

	@FindBy(xpath = "//a[contains(text(),'Result')]")
	private WebElement resultBtnForDescriptive;

	@FindBy(xpath = "(//div[@class='col-lg-12 text-right']//button)[1]")
	private WebElement saveBtnUnderResult_descriptive;

	@FindBy(xpath = "//button[text()='Draft']")
	private WebElement draftBtn;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table[@class='table table-striped row-border hover']/tbody/tr[1]/td[6]")
	private WebElement hospitalNumberInTable_PartialTab;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::table[@class='table table-striped row-border hover']/tbody/tr[last()]/td[6]")
	private WebElement hospitalNumberInTable_LastRow_PartialTab;

	@FindBy(xpath = "//div[@id='IPpatient']//table//tr[1]//td[2]//a")
	private WebElement sampleNumberrInTable_PartialTab;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[7]/descendant::input") })
	private List<WebElement> listOfRemarksTextField;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[8]/descendant::input") })
	private List<WebElement> listOfNotesToPatientTextField_Analysis;

	@FindBys({ @FindBy(xpath = "//table[@id='example']/tbody[1]/tr/td[9]/descendant::input") })
	private List<WebElement> listOfNotesToDoctorTextField_Analysis;

	@FindBys({
			@FindBy(xpath = "//table[@id='example']/tbody/tr/td[6]/descendant::span[@class='select2-selection__arrow']") })
	private List<WebElement> listOfResultDropDownBtn_Analysis;

	@FindBy(xpath = "//button[text()='Next Record ']")
	private WebElement nextRecordBtbn;

	@FindAll({ @FindBy(xpath = "(//span[@role='textbox'])[1]"), @FindBy(xpath = "(//span[@role='combobox']//span)[1]"),
			@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]") })
	private WebElement serviceClass_SelectionDetails;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement dropdownText;

	@FindBy(xpath = "//button[text()=' Previous Record']")
	private WebElement previousButton;

	@FindBy(xpath = "//button[text()='Next Record ']")
	private WebElement nextRecordButton;

	@FindBy(xpath = "//button[text()='No, cancel']/..//button[text()='Yes, submit it!']")
	private WebElement yesSubmitBtn;

	@FindBy(xpath = "(//div[@class='circle blinking'])[1]")
	private WebElement blinckingCircle;

	@FindBy(xpath = "//div[@id='OPD']//table//tr/td[2]/descendant::a")
	private List<WebElement> sampleNumber_Table_List;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement dropdown1stData;

	// ----------------------------------------------Buisness
	// Logics-------------------------------------------------

	public void clickOnLabTechnicianEntryButton(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, labTechnicianEntryPageBtn);
	}

	public void enterSampleNumber(WebDriver driver, String sampleNumber) {
		sampleNumberTextField.sendKeys(sampleNumber);
	}

	public void labtechnicianEntryPage(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, labTechnicianEntryPage);
	}

	public void verifyLabtechnicianEntryResult(WebDriver driver, String hospitalNumber) throws Throwable {
		enterHospitalNumber_List_Partial(driver, hospitalNumber);
		clickOnSearchButton(driver);
		clickOn_SampleNumber_List(driver);

		scrollDownTheStillEndOfThePage(driver);
		// -----------capturing refernce range-------------
		String referenceRange = referenceRangeFiled.getText();
		System.out.println(referenceRange);
		String[] rangeBounds = referenceRange.split("-");
		double lowerBound = Double.parseDouble(rangeBounds[0].trim());
		double upperBound = Double.parseDouble(rangeBounds[1].trim());
		double pickedValue = (upperBound + lowerBound) / 2;
		resultTextFiled.sendKeys(String.valueOf(pickedValue));

		// --------------verifying normal values ------------------
		String remarksValue = remarksTextField.getText();
		if (remarksValue.isEmpty()) {
			System.out.println("Remarks field is empty as expected.");
		} else {
			System.out.println("Remarks field is not empty.");
		}

		System.out.println("Successfully verified normal ");

		resultTextFiled.clear();
		// --------------verifying high values ------------------
		double resultValue = upperBound + 1;
		// System.out.println(String.valueOf(resultValue));
		resultTextFiled.sendKeys(String.valueOf(resultValue));

		String rm = remarksTextField.getAttribute("value");
		Assert.assertEquals(rm, "HIGH");
		System.out.println("Successfully verified " + rm);

		resultTextFiled.clear();

		// --------------verifying low values -----------------
		double r = lowerBound - 0.5;
		resultTextFiled.sendKeys(String.valueOf(r));
		String rm1 = remarksTextField.getAttribute("value");
		Assert.assertEquals(rm1, "LOW");
		System.out.println("Successfully verified " + rm1);

		resultTextFiled.clear();

		// --------------verifying C-HIGH values with colour------------------
		double a = upperBound + 100;
		resultTextFiled.sendKeys(String.valueOf(a));
		String z = remarksTextField.getAttribute("value");
		Assert.assertEquals(z, "C-HIGH");
		System.out.println("Successfully verified " + z);
		String col = remarksTextField.getCssValue("color");
		System.out.println("css value : " + col);
		if (col.equals(col)) {
			System.out.println("The element is displayed in the expected color: red C-HIGH");
		} else {
			System.out.println("The element is not displayed in the expected color:  red C-HIGH");
		}
		resultTextFiled.clear();

		// --------------verifying C-LOW values with colour------------------
		double w = lowerBound - 100;
		resultTextFiled.sendKeys(String.valueOf(w));
		String t = remarksTextField.getAttribute("value");
		Assert.assertEquals(t, "C-LOW");
		System.out.println("Successfully verified " + t);
		String e = remarksTextField.getCssValue("color");
		System.out.println("css value : " + e);
		if (e.equals(e)) {
			System.out.println("The element is displayed in the expected color:  red C-LOW");
		} else {
			System.out.println("The element is not displayed in the expected color: red C-LOW");
		}

	}

	public void verifySampleNumberInLabTechnicianEntryScreen(WebDriver driver, String hospitalNumber) throws Throwable {
		clickOnClearBtn_Filters(driver);
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		String sn = sampleNumberInTableUnderListTab_FirstRow.getText();
		clickOn_SampleNumber_List(driver);
		String sn1 = sampleNumberField_selectionDetails.getAttribute("value");
		Assert.assertEquals(sn, sn1);
		System.out.println("Successfully sample number is verified in selection details");
	}

	public void verifyLabTechnicianEntryCreatedSuccessfully(WebDriver driver, String hospitalNumber) throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);

		clickOn_SampleNumber_List(driver);

		scrollDownTheStillEndOfThePage(driver);

		resultTextFiled.sendKeys("25");

		clickOn_Test_Verify_Button_SelectionDetails(driver);

		clickOn_Ok_Popup_Button(driver);
	}

	public void verifyLabTechnicianEntryCreatedSuccessfully2(WebDriver driver, String hospitalNumber) throws Throwable {
		int counter = 0;
		while (counter < 3) {
			enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
			clickOn_SampleNumber_List(driver);
			scrollDownTheStillEndOfThePage(driver);
			resultTextFiled.sendKeys("25");
			clickOn_Test_Verify_Button_SelectionDetails(driver);
			clickOn_Ok_Popup_Button(driver);
			counter++;
		}
	}

	public String enterHospiatlNoAndClickOnSampleNumber(WebDriver driver, String hospitalNumber) throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		String servicaNa = serviceNameInResultEntry.getText();
		return servicaNa;

	}

	public String enterResultAndClickOntestVerify(WebDriver driver) throws Throwable {

		resultTextFiled.sendKeys("25");

		String result = resultTextFiled.getText();

		clickOn_Test_Verify_Button_SelectionDetails(driver);

		OkBtnInPopup.click();

		return result;
	}

	public String verifyLabTechnicianEntryCreatedSuccessfully1(WebDriver driver, String hospitalNumber)
			throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		scrollDownTheStillEndOfThePage(driver);
		resultTextFiled.sendKeys("25");
		String serviceName = serviceNameInResultEntry.getText();
		String resultValue = resultTextFiled.getText();
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
		return serviceName;
	}

	public void searchhospitalNumnberAndClickOnSampleNumberInthetable(WebDriver driver, String hospitalNumber)
			throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
	}

	public String captureSampleNumberInSelectionDetailsSection(WebDriver driver) {

		String sampleNum = sampleNumberField_selectionDetails.getAttribute("value");
		return sampleNum;
	}

	public void clickOnSearchButton(WebDriver driver) throws InterruptedException {
		clickElementWithRetries(driver, 5, searchBtn_List_Partial);
	}

	public void takeHospitalNumberS_ListTable(WebDriver driver, String hospitalNumber) {
		JavaUtility j = new JavaUtility();
		for (WebElement webElement : hospitalNumbers_ListTable) {
			String hn = webElement.getText();
			String hospitalNumber1 = j.removeLast_n_NumberOfCharacters(hn, 4);
			Assert.assertEquals(hospitalNumber1, hospitalNumber);
		}
		System.out.println("User verified a hospital number in the table successfully");
	}

	public String takeSampleNumberList_Table() {
		String sampleNumber = sampleNumber_ListTable.getText();
		return sampleNumber;
	}

	public void enterHospitalNumber_List_Partial(WebDriver driver, String hospitalNumber) {
		hospitalNumberTextField_List_Partial.sendKeys(hospitalNumber);
	}

	public void verifyRetestForExistingSampleInLabTechnicianEntry(WebDriver driver) throws Throwable {

		dropdown_Handling(driver, 5, statusDropDownBtn, searchBooxForDropDown, "RE-TEST");

		reasonDropDownBtn.click();
		searchBooxForDropDown.sendKeys(Keys.ENTER);

		retestTypeDropDownBtn.click();

		searchBooxForDropDown.sendKeys("EXISTING SAMPLE", Keys.ENTER);
		scrollDownTheStillEndOfThePage(driver);
		resultTextFiled.sendKeys("25");
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

	}

	public void verifyRetestForNewSampleInLabTechnicianEntry(WebDriver driver) throws Throwable {
		statusDropDownBtn.click();
		searchBooxForDropDown.sendKeys("RE-TEST", Keys.ENTER);

		dropdown_Handling(driver, 5, reasonDropDownBtn, searchBooxForDropDown, "CLOTTED BLOOD SAMPLE");

		waitForElementWithCustomTimeOut(driver, retestTypeDropDownBtn, 3);
		retestTypeDropDownBtn.click();

		searchBooxForDropDown.sendKeys("NEW SAMPLE", Keys.ENTER);
		scrollDownTheStillEndOfThePage(driver);
		resultTextFiled.sendKeys("25");
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void verifyByClickingOnSubmitWithoutEnteringResult(WebDriver driver) throws Throwable {
		clickOn_Test_Verify_Button_SelectionDetails(driver);

		String errorMsg = popUpTeXtForClickingOnSubmitWithoutResult.getText();
		clickOn_Ok_Popup_Button(driver);
		Assert.assertEquals(errorMsg, "Please enter results to submit");
		System.out.println("Successfully error msg verified");
	}

	public void selectServiceClassDropDown_EnterHospitalNum_Search(WebDriver driver, String serviceClass,
			String hospitalNumber) throws Throwable {

		Thread.sleep(1000);
		serviceClassDropDownBtn.click();
		dropdownText.sendKeys(serviceClass, Keys.ENTER);
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);

	}

	public void verifyPartialList(WebDriver driver, String hospitalNumber, String serviceClass) throws Throwable {

		scrollDownTheStillEndOfThePage(driver);
		for (WebElement webElement : listOfResultTextField) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			webElement.sendKeys("25");
		}

		checkBoxInResultEntry_Firstrow.click();

		checkBoxInResultEntry_Secondrow.click();

		for (WebElement webElement : listOfServiceNames) {
			String serviceNames = webElement.getText();
			System.out.println(serviceNames);
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

		Thread.sleep(1000);

		partialTab.click();

		selectServiceClassDropdown(driver, serviceClass);

		enterHospitalNumber_List_Partial(driver, hospitalNumber);
		clickOnSearchButton(driver);

		sampleNumberInTable.click();

		scrollDownTheStillEndOfThePage(driver);
		for (WebElement webElement : listOfServiceNames) {
			String serviceNames = webElement.getText();
			System.out.println(serviceNames);
		}
		List<String> fullListServiceNames = new ArrayList<>();
		List<String> partialListServiceNames = new ArrayList<>();
		for (WebElement service : listOfServiceNames) {
			fullListServiceNames.add(service.getText());
		}
		for (WebElement service : listOfServiceNames1) {
			partialListServiceNames.add(service.getText());
		}
		boolean isDisplayingCorrectly = partialListServiceNames.containsAll(fullListServiceNames);
		Assert.assertTrue(isDisplayingCorrectly, "Not visible");
	}

	public void EnterHospitalNoAndSearch_ClickOnSampleNo(WebDriver driver, String hospitalNumber) throws Throwable {

		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		scrollDownTheStillEndOfThePage(driver);
	}

	public void clickOnViewBtnUnderPreviewResult(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, viewBtnUnderPreviewResult);
		viewBtnUnderPreviewResult.click();
	}

	public String captureServiceNameInViewPopUp(WebDriver driver) throws Throwable {
		String sn1 = serviceNamefieldInViewPopUp.getText();
		return sn1;

	}

	public String captureResultInViewPopUp(WebDriver driver) throws Throwable {
		String res = reultfieldInViewPopUp.getText();
		return res;

	}

	public void selectPositveAndFinalGrowthAndSubmit(WebDriver driver) throws Throwable {

		positiveGrowthCheckBox.click();

		finalGrowthCheckBox.click();

		scrollDownTheStillEndOfThePage(driver);

		organismDropDownBtn.click();
		searchBooxForDropDown.sendKeys("ACINETOBACTER BAUMANNII", Keys.DOWN, Keys.ENTER);

		for (WebElement webElement : listOfsensitifityDropDownBtn) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			webElement.click();
			searchBooxForDropDown.sendKeys("INTERMEDIATE", Keys.DOWN, Keys.ENTER);
		}
	}

	public void LabTechnicianEntryForDescriptive(WebDriver driver) throws Throwable {

		scrollTillVisibleElement(driver, resultBtnForDescriptive);

		resultBtnForDescriptive.click();

		WebElement iframe1 = iframe_result;
		driver.switchTo().frame(iframe1);
		inputFieldFirResultIframe.sendKeys(Keys.DOWN, Keys.UP, "Data to pass", Keys.DOWN, "testing", Keys.DOWN,
				"testing123");
		driver.switchTo().defaultContent();
		saveBtnUnderResult_descriptive.click();

		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public String verifDraftInLteScreen(WebDriver driver, String hospitalNumber, String serviceClass) throws Throwable {

		scrollTillVisibleElement(driver, resultBtnForDescriptive);

		resultBtnForDescriptive.click();

		WebElement iframe1 = iframe_result;
		driver.switchTo().frame(iframe1);
		inputFieldFirResultIframe.sendKeys(Keys.DOWN, Keys.UP, "Data to pass", Keys.DOWN, "testing", Keys.DOWN,
				"testing123");
		driver.switchTo().defaultContent();
		saveBtnUnderResult_descriptive.click();

		clickOn_DraftButton(driver);

		clickOn_Ok_Popup_Button(driver);

		partialTab.click();

		serviceClassDropDownBtn.click();
		searchBooxForDropDown.sendKeys(serviceClass, Keys.ENTER);
		enterHospitalNumber_List_Partial(driver, hospitalNumber);
		clickOnSearchButton(driver);

		String hs1 = hospitalNumberInTable_PartialTab.getText();
		return hs1;
	}

	public void verifDraftedSampleIsRemovedAfterTestverifyIsDone(WebDriver driver, String hospitalNumber,
			String serviceClass) throws Throwable {

		scrollTillVisibleElement(driver, resultBtnForDescriptive);

		resultBtnForDescriptive.click();
		WebElement iframe1 = iframe_result;
		driver.switchTo().frame(iframe1);
		inputFieldFirResultIframe.sendKeys(Keys.DOWN, Keys.UP, "Data to pass", Keys.DOWN, "testing", Keys.DOWN,
				"testing123");
		driver.switchTo().defaultContent();

		saveBtnUnderResult_descriptive.click();
		clickOn_DraftButton(driver);
		clickOn_Ok_Popup_Button(driver);

		clickElementWithRetries(driver, 8, partialTab);

		serviceClassDropDownBtn.click();
		searchBooxForDropDown.sendKeys(serviceClass, Keys.ENTER);

		enterHospitalNumber_List_Partial(driver, hospitalNumber);
		clickOnSearchButton(driver);
		clickOnSampleNumber_Partial(driver);
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

		partialTab.click();
		serviceClassDropDownBtn.click();
		searchBooxForDropDown.sendKeys(serviceClass, Keys.ENTER);
		enterHospitalNumber_List_Partial(driver, hospitalNumber);
		clickOnSearchButton(driver);

	}

	public String takeSampleNumber_ListTable(WebDriver driver) {
		String sampleNumber = sampleNumber_ListTable.getText();
		return sampleNumber;
	}

	public String take_LastRow_SampleNumber_ListTable(WebDriver driver) {
		String sampleNumber = sampleNumber_LastRow_ListTable.getText();
		return sampleNumber;
	}

	public String takeSampleType_ListTable(WebDriver driver) {
		String sampleType = sampleType_ListTable.getText();
		return sampleType;
	}

	public String takeSampleDate_ListTable(WebDriver driver) {
		String sDate = sampleDate_ListTable.getText();
		String sampleDate = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sDate, 6);
		return sampleDate;
	}

	public String takeHospitalNumber_ListTable(WebDriver driver) {
		String hNumber = hospitalNumber_ListTable.getText();
		String hospitalNumber = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(hNumber, 4);
		return hospitalNumber;
	}

	public String takeHospitalNumber_LastRow_ListTable(WebDriver driver) {
		String hNumber = hospitalNumber_LastRow_ListTable.getText();
		String hospitalNumber = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(hNumber, 4);
		return hospitalNumber;
	}

	public String takeOP_IpNumber_ListTable(WebDriver driver) {
		String op_IpNumber = op_ipNumber_ListTable.getText();
		return op_IpNumber;
	}

	public String takeDepartment_ListTable(WebDriver driver) {
		String department = Department_ListTable.getText();
		return department;
	}

	public String takeDoctorName_ListTable(WebDriver driver) {
		String doctorName = doctorName_ListTable.getText();
		return doctorName;
	}

	public String takeDoctorName_LastRow_ListTable(WebDriver driver) {

		String doctorName = doctorName_LastRow_ListTable.getText();
		return doctorName;
	}

	public String takePatientName_YearOfBirth(WebDriver driver) {
		String patientName = patientName_ListTable.getText();
		return patientName;
	}

	public String takePatientName_ListTable(WebDriver driver) {
		String pN = patientName_ListTable.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pN, 18);
		return patientName;
	}

	public void verifyLabTechnicianEntryCreatedSuccessfullyForEntry_Anaslysis(WebDriver driver, String hospitalNumber)
			throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		scrollDownByUsingJavascriptExecuter(driver);
		for (WebElement webElement : listOfResultTextField) {
			webElement.sendKeys("12");
		}
		for (WebElement webElement : listOfRemarksTextField) {
			webElement.sendKeys("testing");
		}
		for (WebElement webElement : listOfNotesToPatientTextField_Analysis) {
			webElement.sendKeys("reactive");
		}
		for (WebElement webElement : listOfNotesToDoctorTextField_Analysis) {
			webElement.sendKeys("based on result");
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

	}

	public void verifyLabTechnicianEntryCreatedSuccessfully_Long(WebDriver driver, String hospitalNumber)
			throws Throwable {
		Thread.sleep(1500);
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		scrollDownByUsingJavascriptExecuter(driver);
		for (WebElement webElement : listOfResultTextField) {
			webElement.sendKeys("12");
		}
		for (WebElement webElement : listOfRemarksTextField) {
			webElement.sendKeys("testing");
		}
		for (WebElement webElement : listOfNotesToPatientTextField_Analysis) {
			webElement.sendKeys("reactive");
		}
		for (WebElement webElement : listOfNotesToDoctorTextField_Analysis) {
			webElement.sendKeys("based on result");
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

	}

	public void verifyLabTechnicianEntryCreatedSuccessfullyForSelection_Anaslysis(WebDriver driver,
			String hospitalNumber) throws Throwable {

		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		scrollDownByUsingJavascriptExecuter(driver);
		for (WebElement webElement : listOfResultDropDownBtn_Analysis) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			webElement.click();
			searchBooxForDropDown.sendKeys(Keys.ENTER);
		}
		for (WebElement webElement : listOfRemarksTextField) {
			webElement.sendKeys("testing");
		}
		for (WebElement webElement : listOfNotesToPatientTextField_Analysis) {
			webElement.sendKeys("reactive");
		}
		for (WebElement webElement : listOfNotesToDoctorTextField_Analysis) {
			webElement.sendKeys("based on result");
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

	}

	public void enterHospitalNumber_Search_List_Partial(WebDriver driver, String hospitalNumber) throws Throwable {
		enterHospitalNumber_List_Partial(driver, hospitalNumber);
		clickOnSearchButton(driver);
	}

	public void enterTheResult_Remarks_And_ClickOnTestVerirfy(WebDriver driver, String remarks) throws Throwable {
		resultTextFiled.sendKeys("20");
		remarksTextField.sendKeys(remarks);
		scrollDownTheStillEndOfThePage(driver);
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);

	}

	public void clickOn_SampleNumber_List(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		sampleNumberInTableUnderListTab_FirstRow.click();

	}

	public void clickOnSampleNumber_Partial(WebDriver driver) {
		sampleNumberrInTable_PartialTab.click();
	}

	public void verifyLabTechnicianEntryCreatedSuccessfullyForEntryAndSelection_Anaslysis(WebDriver driver,
			String hospitalNumber) throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		clickOn_SampleNumber_List(driver);
		scrollDownByUsingJavascriptExecuter(driver);
		for (WebElement webElement : listOfResultTextField) {
			webElement.sendKeys("12");
		}
		for (WebElement webElement : listOfResultDropDownBtn_Analysis) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			webElement.click();
			searchBooxForDropDown.sendKeys(Keys.ENTER);
		}
		for (WebElement webElement : listOfRemarksTextField) {
			webElement.sendKeys("testing");
		}
		for (WebElement webElement : listOfNotesToPatientTextField_Analysis) {
			webElement.sendKeys("reactive");
		}
		for (WebElement webElement : listOfNotesToDoctorTextField_Analysis) {
			webElement.sendKeys("based on result");
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public String takeServiceClass_SelectionDetails(WebDriver driver) {
		String serviceClass = serviceClass_SelectionDetails.getText();
		return serviceClass;
	}

	public void selectServiceClassDropdown(WebDriver driver, String serviceClass) throws Throwable {
		dropdown_Handling(driver, 4, serviceClassDropdownButton, dropdownText, serviceClass);
	}

	public void enterSelectionDate(WebDriver driver, String SelectionDate) {
		selectionDateField.sendKeys(SelectionDate);
	}

	public void selectDepartmentNameDropdown(WebDriver driver, String department) throws Throwable {
		dropdown_Handling(driver, 4, departmentNameDropDown, dropdownText, department);
	}

	public void selectWardTypeDropdown(WebDriver driver, String wardType) {
		wardTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, wardType);
	}

	public void enterResults_selectTwoCheckboxs_clickOnTestVerfiyBtn(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		for (WebElement webElement : listOfResultTextField) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);

			webElement.sendKeys("25");
		}

		checkBoxInResultEntry_Firstrow.click();
		checkBoxInResultEntry_Secondrow.click();
		for (WebElement webElement : listOfServiceNames) {
			String serviceNames = webElement.getText();
			System.out.println(serviceNames);
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void clickOnPartialTab(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, partialTab);
	}

	public String takeSampleNumber_PartialTable(WebDriver driver) {
		String sampleNumber = sampleNumberrInTable_PartialTab.getText();
		return sampleNumber;
	}

	public String takeHospitalNumber_PartialTable(WebDriver driver) {
		String hospitalNumber = hospitalNumberInTable_PartialTab.getText();
		return hospitalNumber;
	}

	public String takeHospitalNumber_LastRow_PartialTable(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		String hospitalNumber = hospitalNumberInTable_LastRow_PartialTab.getText();
		return hospitalNumber;
	}

	public String takeSampleType_PartialTable(WebDriver driver) {
		String sampleType = sampleType_PartialTable.getText();
		return sampleType;
	}

	public String takeSampleType_LastRow_PartialTable(WebDriver driver) {
		String sampleType = sampleType_LastrRow_PartialTable.getText();
		return sampleType;
	}

	public String takeSampleDate_PartialTable(WebDriver driver) {
		String sDate = sampleDate_PartialTable.getText();
		String sampleDate = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(sDate, 6);
		return sampleDate;
	}

	public String takePatientName_PartialTable(WebDriver driver) {
		String pName = patientName_PartialTable.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pName, 20);
		return patientName;
	}

	public String takePatientName_LastRow_PartialTable(WebDriver driver) {
		String pName = patientName_LastRow_PartialTable.getText();
		String patientName = removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(pName, 20);
		return patientName;
	}

	public String takeDepartment_PartialTable(WebDriver driver) {
		String department = department_PartialTable.getText();
		return department;
	}

	public String takeDoctor_PartialTable(WebDriver driver) {
		String doctorName = doctorName_PartialTable.getText();
		return doctorName;
	}

	public String takeDoctor_LastRow_PartialTable(WebDriver driver) {
		String doctorName = doctorName_LastRow_PartialTable.getText();
		return doctorName;
	}

	public String takeLastRowSampleNumber_ListTable(WebDriver driver) {
		String sampleNumber = sampleNumber_ListLastRowTable.getText();
		return sampleNumber;

	}

	public void clickOnPreviousButton(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, previousButton);
		previousButton.click();
	}

	public void clickOnNextsButton(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextRecordButton);
		nextRecordButton.click();
	}

	public void previousButtonVerifcation(WebDriver driver) throws Throwable {
		String str1 = "";
		String str2 = "";

		for (int i = 1; i <= 3; i++) {
			str1 = sampleNumberField_selectionDetails.getAttribute("value");
			int sampleNum1 = Integer.parseInt(str1);
			System.out.println("First" + sampleNum1);

			clickOnPreviousButton(driver);
			scrollDownThePageUntilElementIsVisible(driver, sampleNumberField_selectionDetails);
			str2 = sampleNumberField_selectionDetails.getAttribute("value");
			int sampleNum2 = Integer.parseInt(str2);
			System.out.println("Second" + sampleNum2);
			Assert.assertTrue(sampleNum1 > sampleNum2,
					"Previous sample number user got higher than the current sample");

		}

	}

	public void nextButttonVerification(WebDriver driver) throws Throwable {
		int previousSampleNum = -1;
		for (int nextBtnCount = 1; nextBtnCount <= 3; nextBtnCount++) {
			int currentSampleNum = getSampleNumber(sampleNumberField_selectionDetails, driver);
			if (previousSampleNum != -1) {
				Assert.assertTrue(currentSampleNum > previousSampleNum,
						"Previous sample number is not less than the current sample");
			}
			clickOnNextsButton(driver);
			scrollDownThePageUntilElementIsVisible(driver, sampleNumberField_selectionDetails);
			previousSampleNum = currentSampleNum;
		}
	}

	private int getSampleNumber(WebElement sampleNumberField, WebDriver driver) {
		String sampleNumStr = sampleNumberField.getAttribute("value");
		return Integer.parseInt(sampleNumStr);
	}

	public void clickOnClearBtn_Filters(WebDriver driver) {
		clickElementWithRetries(driver, 4, clearBtn);
	}

	public void clickOn_Test_Verify_Button_SelectionDetails(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		testVerifyBtn_SelectionDetails.click();
		clickOn_YesSubmitItBtn(driver);
	}

	public void clickOn_Ok_Popup_Button(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, OkBtnInPopup);
		OkBtnInPopup.click();
	}

	public void clickOn_YesSubmitItBtn(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		yesSubmitBtn.click();
	}

	public void clickOn_DraftButton(WebDriver driver) throws Throwable {
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, draftBtn);
		draftBtn.click();
		clickOn_YesSubmitItBtn(driver);
		clickOn_Ok_Popup_Button(driver);

	}

	public void latTechnicianEntryProcess_For_Discriptive(WebDriver driver) throws Throwable {
		for (WebElement webElement : listOfRemarksTextField) {
			webElement.sendKeys("Test");
		}
		for (WebElement webElement : listOfNotesToPatientTextField_Analysis) {
			webElement.sendKeys("Test");
		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void enterResults_clickOnDrafButton(WebDriver driver) throws Throwable {
		for (WebElement webElement : listOfResultTextField) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.sendKeys("25");
		}

		for (WebElement webElement : listOfRemarksTextField) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.sendKeys("Test");
		}
		clickOn_DraftButton(driver);
	}

	public void checkThatBlinklingCircleIsDisplayingOrNot(WebDriver driver) {
		if (blinckingCircle.isDisplayed()) {
			System.out.println("system is displaying the notification");
		} else {
			Assert.fail("system is not blinking the sample number");
		}
	}

	public int captureNumberOfSampleNo_Table(WebDriver driver) throws Throwable {
		int count = sampleNumber_Table_List.size();
		return count;
	}

	public void techinicianEntryFLow(WebDriver driver, String hospitalNumber, int numberOfIterations) throws Throwable {
		clickOn_SampleNumber_List(driver);
		for (int i = 0; i < numberOfIterations; i++) {
			scrollDownTheStillEndOfThePage(driver);
			enterResults_clickOnTestVerifyButton(driver);
		}
	}

	public void enterResults_clickOnTestVerifyButton(WebDriver driver) throws Throwable {

		for (WebElement webElement : listOfResultTextField) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
//			webElement.sendKeys("25");
			webElement.sendKeys(generateRandomNumberBelow_100());
		}

		for (WebElement webElement : listOfResultDropDownBtn_Analysis) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.click();
			dropdown1stData.click();

		}

		for (WebElement webElement : listOfNotesToDoctorTextField_Analysis) {
			explictWaitForElementToBeVisible(driver, webElement);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.sendKeys("review of the patient's symptom");

		}

//		for (WebElement webElement : listOfRemarksTextField) {
//			explictWaitForElementToBeVisible(driver, webElement);
//			scrollDownThePageUntilElementIsVisible(driver, webElement);
//			webElement.sendKeys("Test");
//		}
		clickOn_Test_Verify_Button_SelectionDetails(driver);
		clickOn_Ok_Popup_Button(driver);
	}

	public void labTechnician(WebDriver driver, String serviceClass3, String hospitalNumber) throws Throwable {
		selectServiceClassDropDown_EnterHospitalNum_Search(driver, serviceClass3, hospitalNumber);
		int count = captureNumberOfSampleNo_Table(driver);
		techinicianEntryFLow(driver, hospitalNumber, count);
	}

	public void labTechnician_1(WebDriver driver, String serviceClass3, String hospitalNumber) throws Throwable {
		EnterHospitalNoAndSearch(driver, hospitalNumber);
		int count = captureNumberOfSampleNo_Table(driver);
		techinicianEntryFLow(driver, hospitalNumber, count);
	}

	public void EnterHospitalNoAndSearch(WebDriver driver, String hospitalNumber) throws Throwable {
		enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
	}

	public void labTechnician_Dynamic(WebDriver driver, List<String> serviceClasses, String hospitalNumber)
			throws Throwable {
		Thread.sleep(10000);
		for (String serviceClass : serviceClasses) {
			selectServiceClassDropDown_EnterHospitalNum_Search(driver, serviceClass, hospitalNumber);
			int count = captureNumberOfSampleNo_Table(driver);
			techinicianEntryFLow(driver, hospitalNumber, count);
		}
	}
}
