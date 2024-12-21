package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
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

public class NursingDeskPage extends WebDriverUtility {
	private static final boolean WebElement = false;

	public NursingDeskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Nursing Desk ']")
	private WebElement nursingDeskLink;

	@FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[1]")
	private WebElement patientArrival;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save_PatientArrival;

	@FindBy(css = "div[aria-label='Updated successfully']")
	private WebElement updatedSuccessfullyPopup;

	@FindBy(xpath = "//table//tr[1]/td[2]/descendant::a")
	private WebElement hospitalNumber_Table;

	@FindBy(xpath = "//div[@class='detail']//h4[1]")
	private WebElement userName;

	@FindBy(xpath = "//table//tr[1]/td[12]//a")
	private WebElement status_Table;

	// -------------------------------------------------------Nursing
	// Assessment-----------------------------------------------------------------//

	@FindBy(xpath = "//a[@id='NURAS13']")
	private WebElement nursing_Assessment_Tab;

	@FindBy(xpath = "(//div[@id='NURAS']/descendant::button)[1]//i")
	private WebElement plusBtn_Nurse_Assessment;

	@FindBy(css = "input[formcontrolname='symptoms']")
	private WebElement symptomsText;

	@FindBy(xpath = "//div[@id='NURAS']/descendant::label[text()='Physical Restaint']/..//span[@data-off='No']")
	private WebElement physicalRestaint_Nursing_Assessment;

	@FindBy(xpath = "(//span[@class='switch-label']/following-sibling::span)[3]")
	private WebElement initialPainAssessment_Nursing_Assessment;

	@FindBy(xpath = "//div[@id='NURAS']//table//tr[1]/td[2]//span[@role='presentation']")
	private WebElement locationDropdown_AssessentDetails_NursingAssessment;

	@FindBy(xpath = "//div[@id='NURAS']//table//tr[1]/td[3]//span[@role='presentation']")
	private WebElement numericRatingDropdown_AssessmentDetails_NursingAssessment;

	@FindBy(xpath = "//div[@id='NURAS']//table//tr[1]/td[4]/descendant::i")
	private WebElement actionBtn_AssessmentDeatils_NursingAssessmenet;

	@FindBy(xpath = "//div[@id='NURAS']//table/tbody/tr[1]/td[4]/descendant::i[@class='zmdi zmdi-delete']")
	private WebElement actionDelete_AssessementDetails_NursingAssessment;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement symtomsErrorPopupOkBtn;

	@FindBy(css = "textarea[formcontrolname='obstetricHistory']")
	private WebElement obstetricHistory_NursingAssessment;

	@FindBy(xpath = "//input[@id='bedSore']/following-sibling::span[@data-on='Yes']")
	private WebElement bedsore_Switch_Button;

	@FindBy(xpath = "//input[@placeholder='enter the Location']")
	private WebElement location_NursingAssessment;

	@FindBy(xpath = "//input[@placeholder='cm X cm X cm ']")
	private WebElement size_NursingAssessment;

	@FindBy(xpath = "//label[text()='Classification']//..//span[@role='presentation']")
	private WebElement classificationDropdown_NursingAssessment;

	@FindBy(xpath = "//input[@placeholder='classificationDetail']")
	private WebElement classificationDetails_NursingAssessment;

	@FindBys({
			@FindBy(xpath = "//div[@id='NURAS']/descendant::table[@class='table table-striped row-border hover']/tbody/tr/td[2]") })
	private List<WebElement> activityOfDailyLiving_Independent_NursingAssessment;
	@FindBys({
			@FindBy(xpath = "//div[@id='NURAS']/descendant::table[@class='table table-striped row-border hover']/tbody/tr/td[3]") })
	private List<WebElement> activityOfDailyLiving_Assisted_NursingAssessment;

	@FindBys({
			@FindBy(xpath = "//div[@id='NURAS']/descendant::table[@class='table table-striped row-border hover']/tbody/tr/td[4]") })
	private List<WebElement> activityOfDailyLiving_dependent_NursingAssessment;

	@FindBy(xpath = "//div[@id='NURAS']/descendant::button[text()=' Submit ']")
	private WebElement submitBtn_NursingAssessment;

	@FindBy(xpath = "//div[@id='NURAS']/descendant::button[text()=' Cancel ']")
	private WebElement cancelBtn_NursingAssessment;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownText;

	@FindBy(xpath = "(//div[@class='media-heading']//small)[1]")
	private WebElement assessment_HistoryFirstTabAdminName_NursingAssessment;

	@FindBy(xpath = "(//time[@class='d-none d-md-inline-block']//b)[1")
	private WebElement assessmentHistoryFirstTabDate_NursingAssessment;

	// ------------------------------------------------------------------------Nursing
	// Care Plan -----------------------//

	@FindBy(xpath = "//a[@id='NURC14']")
	private WebElement nursingCarePlanTabBtn;

	@FindBy(xpath = "(//div[@id='NURC']//descendant::div[@id='CarePlan']//descendant::button)[1]")
	private WebElement plusBtn_NursingCarePlan;

	@FindBys({ @FindBy(xpath = "//div[@id='NURC']//table[1]///tr/td//span[@class='switchs-handle']") })
	private List<WebElement> firstTable_NurasingCarePlan;

	@FindBys({ @FindBy(xpath = "//div[@id='NURC']//table[1]//tr/td//span[@class='switchs-handle']") })
	private List<WebElement> allActivity_SwitchButtons_NursingCarePlan;

	@FindBys({ @FindBy(xpath = "//div[@id='NURC']//table[2]//tr/td//span[@class='switchs-handle']") })
	private List<WebElement> secondTable_NursingCarePlan;

	@FindBys({
			@FindBy(xpath = "//div[@id='NURC']/descendant::table[3]/tbody/tr/td/descendant::span[@class='switchs-handle']") })
	private List<WebElement> thirdTable_NursingCarePlan;

	@FindBy(css = "textarea[formcontrolname='preventive']")
	private WebElement preventiveText_NursingCarePlan;

	@FindBy(xpath = "//label[text()='Preventive']/following-sibling::textarea")
	private WebElement preventiveTextData_NursingCarePlan;

	@FindBy(css = "textarea[formcontrolname='curative']")
	private WebElement curative_NursingCarePlan;

	@FindBy(xpath = "//div[@id='CarePlan']/descendant::button[2]/i")
	private WebElement submitBtn_NursingCarePlan;

	@FindBy(xpath = "//div[@id='CarePlan']//i[@class='zmdi zmdi-close-circle']")
	private WebElement cancelBtn_NursingCarePlan;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnForErrorPopup_NursingCarePlan;

	@FindBy(xpath = "(//div[@class='media-heading']//small)[1]")
	private WebElement adminName_UnderNursing_CarePlanHistoryTab;

	@FindBy(xpath = "(//small[contains(@class,'float-left text-muted')])[2]")
	private WebElement departmentName_History_NursingCarePlan;

	// ------------------------------------------------Nursing Progress
	// Record-------------------------------------//

	@FindBy(xpath = "//a[@id='NPR16']")
	private WebElement nursingPregressRecordTab;

	@FindBy(xpath = "//div[@id='NPR']/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement plusButton_NursingProgressRecord;

	@FindBy(xpath = "(//label[text()='Instruction'])[1]/..//span[@role='presentation']")
	private WebElement instruction_DropdownBtn;

	@FindAll({ @FindBy(xpath = "(//button[@id='closeNurseModal'])[1]"),
			@FindBy(xpath = "(//button[text()=' Save '])[2]") })
	private WebElement saveButton_NursingProgressRecord;

	@FindBy(xpath = "(//button[@id='closeNurseModal']/following-sibling::button)[2]")
	private WebElement cancelButton_NursingProgressRecord;

	// ----------------------------------------------Patient
	// Chart--------------------------------------------------------------------

	@FindBy(xpath = "//a[@id='ICUCH19']")
	private WebElement patientChartTab;

	@FindBy(xpath = "//a[contains(text(),'VENTILATOR SETUP/ICU Care Plan')]")
	private WebElement ventilatorSetupIcuCarePlanTab;

	@FindBy(xpath = "//a[contains(text(),'GRBS MONITORING')]")
	private WebElement grbsMonitoringTab;

	@FindBy(xpath = "//a[contains(text(),'NEUROMONITORING')]")
	private WebElement neuroMonitoringTab;

	@FindBy(xpath = "//a[contains(text(),'LINES AND TUBES')]")
	private WebElement linesAndTubesTab;

	@FindBy(xpath = "//a[contains(text(),'INTAKE AND OUTPUT CHARTING')]")
	private WebElement intakeAndOutputChartingTab;

	@FindBy(xpath = "//button[@data-target='#ICUCARE']")
	private WebElement plusBtn_ventilatorSetupTab;

	@FindBy(xpath = "//input[contains(@class,'form-control ng-pristine')]")
	private WebElement dateField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@formcontrolname='effectiveT']")
	private WebElement chooseDateTime_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='SPO2']")
	private WebElement spo2Field_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='TV ']")
	private WebElement tvField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@formcontrolname='RateValue']")
	private WebElement rateField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='FIO2']")
	private WebElement fio2Field_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='PR Support']")
	private WebElement prSupportField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='PEEP']")
	private WebElement peepField_ventilatorSetupTab;

	@FindBy(xpath = "//input[@placeholder='PC']")
	private WebElement pcField_ventilatorSetUpTab;

	@FindBy(xpath = "//input[@placeholder='Oxygen']")
	private WebElement oxygenField_ventilatorSetUpTab;

	@FindBy(xpath = "//input[@placeholder='T-Piece']")
	private WebElement tPieceField_ventilatorSetUpTab;

	@FindBy(xpath = "(//input[@id='linkToLabId']/following-sibling::span)[1]")
	private WebElement roomAirBtn_ventilatorSetup;

	@FindBy(xpath = "(//div[@class='form-group col-lg-2']/descendant::span[@class='switch-label'])[2]")
	private WebElement vomittingBtn_ventilatorSetup;

	@FindBy(xpath = "(//input[@id='linkToLabId']/following-sibling::span)[3]")
	private WebElement positioningBackCareBtn_ventilatorSetup;

	@FindBy(xpath = "(//label[@class='switch switch-flat']/descendant::span[@class='switch-label'])[8]")
	private WebElement bedBathBtn_ventilatorSetup;

	@FindBy(xpath = "(//label[@class='switch switch-flat']/descendant::span[@class='switch-label'])[9]")
	private WebElement oralCareBtn_ventilatorSetup;

	@FindBy(xpath = "(//label[@class='switch switch-flat']/descendant::span[@class='switch-label'])[10]")
	private WebElement chestPhysioBtn_ventilatorBtn;

	@FindBy(xpath = "(//label[@class='switch switch-flat']/descendant::span[@class='switch-label'])[11]")
	private WebElement stoolBtn_ventilatorBtn;

	@FindBy(xpath = "(//label[@class='switch switch-flat']/descendant::span[@class='switch-label'])[12]")
	private WebElement woundDressingBtn_ventilatorSetup;

	@FindBy(xpath = "//button[@id='closeVentilator']/following-sibling::button[1]")
	private WebElement cancelBtn_ventilatorSetup;

	@FindBy(xpath = "//button[@id='closeVentilator']")
	private WebElement submitBtn_ventilatorSetup;

	@FindBy(xpath = "//a[text()='GRBS']")
	private WebElement grbsTab_grbsMonitoringTab;

	@FindBy(xpath = "//a[contains(text(),'ABG')]")
	private WebElement abgTab_grbsMonitoringTab;

	@FindBy(xpath = "(//input[@type='datetime-local'])[2]")
	private WebElement dateInTable_grbsTab;

	@FindBy(xpath = "(//div[@id='GRBSCO']//table/tbody/tr[1]/td[3]//span[@class='select2-selection__arrow'])[1]")
	private WebElement typeDropDownBtn_grbsTab;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownText;

	@FindBy(xpath = "(//div[@id='GRBSCO']//table/tbody/tr[1]/td[4]//span[@class='select2-selection__arrow'])[1]")
	private WebElement collectedAtDropDownBtn_grbsTab;

	@FindBy(xpath = "//input[@placeholder='value']")
	private WebElement valueField_grbsTab;

	@FindBy(xpath = "//input[@placeholder='Enter Remarks']")
	private WebElement remarksField_grbsTab;

	@FindBy(xpath = "//div[@id='GRBSCO']/descendant::table[@id='subtableid']/tbody/tr[1]/td[7]/descendant::button")
	private WebElement addBtnInTable_grbsTab;

	@FindBy(xpath = "//div[@id='GRBSCO']//button[@type='submit']")
	private WebElement submitBtn_grbsTab;

	@FindBy(xpath = "//div[@id='GRBSCO']//button[@type='reset']")
	private WebElement cancelBtn_grbsTab;

	@FindBy(xpath = "//div[@id='GRBSCO']/descendant::table[@id='subtableid']/tbody/tr[2]/td[7]/descendant::button")
	private WebElement deleteBtnInTable_Grbstab;

	@FindBy(xpath = "//button[text()='View Graphs']")
	private WebElement viewGraphsBtn_grbsTab;

	@FindBy(xpath = "//button[text()='View Details']")
	private WebElement viewDetailsBtn_grbsTab;

	@FindBy(xpath = "//div[@id='GRBSCO']//input[@type='date']")
	private WebElement dateField_grbsTab;

	@FindBy(xpath = "//div[@id='ABGS']//input[@type='date']")
	private WebElement dateField_abgTab;

	@FindBy(xpath = "//div[@id='ICUCH00004']//input[@type='date']")
	private WebElement dateField_neuromonitoringTab;

	@FindBy(xpath = "//div[@id='ICUCH00005']//input[@type='date']")
	private WebElement dateField_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[1]")
	private WebElement vasofixCheckbox_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[2]")
	private WebElement foleysCatheterCheckBox_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[3]")
	private WebElement rylesTubesCheckBox_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[4]")
	private WebElement TracheostomyCheckBox_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[5]")
	private WebElement cvpCheckBox_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[6]")
	private WebElement icdCheckBox_linesAndTubesTab;

	@FindBy(xpath = "(//input[@id='Impression'])[7]")
	private WebElement ettCheckBox_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[1]/th[4]//input")
	private WebElement vasofixDateField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[2]/th[4]//input")
	private WebElement foleysCatheterDateField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[3]/th[4]//input")
	private WebElement rylesTubesDateField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[4]/th[4]//input")
	private WebElement TracheostomyDateField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[5]/th[4]//input")
	private WebElement cvpDateField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[6]/th[4]//input")
	private WebElement icdDateField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[7]/th[4]//input")
	private WebElement ettDateField_linesAndTubesTab;

	@FindBy(xpath = "//button[@id='closeLines']")
	private WebElement submitBtn_linesAndTubesTab;

	@FindBy(xpath = "//button[@id='closeLines']/following-sibling::button[1]")
	private WebElement cancelBtn_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[1]/th[3]//input")
	private WebElement vasofixTextField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[2]/th[3]//input")
	private WebElement foleysCatheteTextField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[3]/th[3]//input")
	private WebElement rylesTubesTextField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[4]/th[3]//input")
	private WebElement TracheostomyTextField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[5]/th[3]//input")
	private WebElement cvpTextField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[6]/th[3]//input")
	private WebElement icdTextField_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr[7]/th[3]//input")
	private WebElement ettTextField_linesAndTubesTab;

	@FindBy(xpath = "//button[@data-target='#lineandTubes']")
	private WebElement plusBtn_linesAndTubesTab;

	@FindBy(xpath = "//div[@id='ICUCH00006']//input")
	private WebElement dateField_intakeAndOutputCharting;

	@FindBy(xpath = "(//div[@class='col-lg-2']//button)[2]")
	private WebElement plusBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='IntakeTime']")
	private WebElement chooseTimeField_intakeAndOutputCharting;

	@FindBy(xpath = "//label[text()='Fluid']/following-sibling::input")
	private WebElement fluidTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='RTF']")
	private WebElement rtfTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='oral']")
	private WebElement oralTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='fj']")
	private WebElement fjTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='ivfsolution']")
	private WebElement ivfSolutionTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='amountIntake']")
	private WebElement amountInTakeTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='urineOutput']")
	private WebElement urinOutputTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//span[@id='select2-i2a6-container']/following-sibling::span[1]")
	private WebElement drainDropDownBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='icd']")
	private WebElement icdTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='amountoutput']")
	private WebElement amountOutputTextField_intakeAndOutputCharting;

	@FindBy(xpath = "//button[@id='closeIntake']")
	private WebElement submitBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//button[@id='closeIntake']/following-sibling::button[1]")
	private WebElement cancelBtn_intakeAndOutputCharting;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement first_Option_InstructionDropdown;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorPopUpMsg;

	@FindBys({ @FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr/th[2]//input") })
	private List<WebElement> listOfCheckBox_LinesAndtubes;

	@FindBys({ @FindBy(xpath = "//div[@id='lineandTubes']//table/tbody/tr/th[3]//input") })
	private List<WebElement> listOfTextField_LinesAndtubes;

	@FindBy(xpath = "//input[@formcontrolname='drainValue']")
	private WebElement drainValueBtn_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='rtfOutput']")
	private WebElement rtfText_Aspiraiton_intakeAndOutputCharting;

	@FindBy(xpath = "//input[@formcontrolname='other']")
	private WebElement otherText_Aspiraiton_intakeAndOutputCharting;

	@FindBy(xpath = "(//li[contains(@class,'list-group-item doctor-desk-li')])[1]")
	private WebElement sideDate_NursingProgressRecord;

	@FindBy(xpath = "(//td[@class='displayInline'])[1]")
	private WebElement reportInTable_NursingProgressRecord;

	@FindBy(xpath = "//img[@alt='User']/following-sibling::b[1]")
	private WebElement userName1;

	@FindBy(xpath = "//button[@data-toggle='modal']/following-sibling::button[1]")
	private WebElement viewBtn_NursingProgreeRecord;

	@FindBy(xpath = "(//div[@class='blog-post']//p)[3]")
	private WebElement report_underViewBtn_ProgressRecord;

	@FindBy(xpath = "(//tr[@class='ng-star-inserted']//button)[1]")
	private WebElement editBtn_NursingProgreeRecord;

	@FindAll({ @FindBy(css = "iframe[title='Editor, editor5']"),
			@FindBy(css = "iframe[title='Rich Text Editor, editor6'") })
	private WebElement iframe_NursingProgressRecord;

	@FindAll({ @FindBy(css = "body[aria-label='Editor, editor5']"),
			@FindBy(css = "body[aria-label='Rich Text Editor, editor6']") })
	private WebElement textOfNursingProgressRecord;

	@FindBy(xpath = "(//input[@type='date'])[1]")
	private WebElement dateField_NursingProgreeRecord;

	@FindBy(xpath = "//span[@title='Status']/following-sibling::span[1]")
	private WebElement statusDropdownBtns_Filter;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownsText;

	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement searchBtn_Filter;

	@FindBy(xpath = "//div[@id='CarePlan']//descendant::button[text()=' Cancel ']")
	private WebElement cancelButtonNursingCarePlan;

	// ------------------------------------------------------------Business
	// logics---------------------------------------------

	// ------------------------------------------------------for Nursing
	// Assessemnt--------------------------------------------------

	public void clickOnThePatientArrival_Save_UpadatedPopup(WebDriver driver) throws Throwable {

	}

	/*
	 * 
	 * 
	 * Buiness Logics
	 * 
	 * 
	 * 
	 */
	public void clickOnNursingDesk(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, nursingDeskLink);
	}

	public void clickOnTheNursingAssessmentTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, nursing_Assessment_Tab);
	}

	public void clickOnThePlusBtnOfNursingAssessment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		plusBtn_Nurse_Assessment.click();
	}

	public void enterTheSymptoms(WebDriver driver, String symptoms) {
		scrollDownByUsingJavascriptExecuter(driver);
		symptomsText.sendKeys(symptoms);
	}

	public void clickOnTheActionBtnInTheAssessmentTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		actionBtn_AssessmentDeatils_NursingAssessmenet.click();
	}

	public void clickOnTheDeleteOfTheAssessmentTable() {
		actionDelete_AssessementDetails_NursingAssessment.click();
	}

	public void selectTheClassificationDropdown(WebDriver driver, String classification) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, classificationDropdown_NursingAssessment, dropdownText, classification);
	}

	public void clickOnTheOkButton() {

		symtomsErrorPopupOkBtn.click();
	}

	public void clickOnTheCancelButton() {
		cancelBtn_NursingAssessment.click();
	}

	public String fetchTheAssessmentHistoryTabDate() {
		String assissmentCreatedDate = assessmentHistoryFirstTabDate_NursingAssessment.getText();
		return assissmentCreatedDate;
	}

	public void enterTheDataInTheNursingProgressRecordText(WebDriver driver, String nursingProgressRecord)
			throws Throwable {
		WebElement iframe = iframe_NursingProgressRecord;
		driver.switchTo().frame(iframe);
		textOfNursingProgressRecord.sendKeys(nursingProgressRecord);
		driver.switchTo().defaultContent();
	}

	public void clickOn_HospitalNumber(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, hospitalNumber_Table);
	}

	public void clickOn_PlusButton_NursingAssessement(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_Nurse_Assessment);
		plusBtn_Nurse_Assessment.click();
	}

	public void clickOn_PhysicalRestaint(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		physicalRestaint_Nursing_Assessment.click();

	}

	public void clickOn_IntialPain_Assessment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		initialPainAssessment_Nursing_Assessment.click();
	}

	public void select_Location_AssessementDeatils(WebDriver driver, String location) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		locationDropdown_AssessentDetails_NursingAssessment.click();
		moveToElementAndEnterTheData(driver, dropdownText, location);
	}

	public void select_NumericRating_NursingAssessement(WebDriver driver, String numericRating) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		numericRatingDropdown_AssessmentDetails_NursingAssessment.click();
		moveToElementAndEnterTheData(driver, dropdownText, numericRating);
	}

	public void clickOn_AddButton_NursingAssessment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		actionBtn_AssessmentDeatils_NursingAssessmenet.click();
	}

	public void clickOn_BedSoreSwitchButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		bedsore_Switch_Button.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void enter_Location_NursingAssessment(WebDriver driver, String location) {
		location_NursingAssessment.sendKeys(location);
	}

	public void enter_Size_NursingAssessement(WebDriver driver, String size) {
		size_NursingAssessment.sendKeys(size);
	}

	public void select_Clasification(WebDriver driver, String clasification) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		classificationDropdown_NursingAssessment.click();
		moveToElementAndEnterTheData(driver, dropdownText, clasification);
	}

	public void enter_Clasification_NursingAssessement(WebDriver driver, String clasification) {
		classificationDetails_NursingAssessment.sendKeys(clasification);
	}

	public void clkckOn_SubmitButton_NursingAssessement(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtn_NursingAssessment.click();
	}

	public String assessement_History_AdminName(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String ms = assessment_HistoryFirstTabAdminName_NursingAssessment.getText();
		String msg = removeSpecialCharactersAndNumbers_RemoveLastCharacters(ms, 1);
		return msg;
	}

	public String assessement_History_DateAndYear(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String msg = assessmentHistoryFirstTabDate_NursingAssessment.getText();
		return msg;
	}

	public void activityOfDailyLiving_swiatchButtons_Independent_NursingAssessment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		for (WebElement webElement : activityOfDailyLiving_Independent_NursingAssessment) {
			webElement.click();
		}
	}

	// -----------------------------------------------------Nursing care
	// plan----------------------------------------------------------------------------//

	public void activityOfDailyLiving_SwitchButtons_Assisted_NursingAssessment(WebDriver driver) {
		for (WebElement webElement : activityOfDailyLiving_Assisted_NursingAssessment) {
			webElement.click();
		}
	}

	public void activityOfDailyLiving_SwitchButtons_dependent_NursingAssessment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		for (WebElement webElement : activityOfDailyLiving_dependent_NursingAssessment) {
			webElement.click();
		}
	}

	public String take_UserName(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		String name = userName.getText();
		return name;
	}

	public void clickOnTheSubmitButton_NursingAssessment(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		submitBtn_NursingAssessment.click();
	}

	public void create_NursingAssessment(WebDriver driver, String status, String symptoms, String location,
			String numericRating, String size, String classification) throws Throwable {

		if (status.equals("ARRIVED0")) {
			clickOn_HospitalNumber(driver);
		} else if (status.equals("NOT ARRIVED0")) {
			clickOn_HospitalNumber(driver);
			clickOn_PatientArrival(driver);
			clickOn_SaveButton(driver);
		}

		clickOnTheNursingAssessmentTab(driver);
		clickOn_PlusButton_NursingAssessement(driver);
		enterTheSymptoms(driver, symptoms);

		clickOn_PhysicalRestaint(driver);

		clickOn_IntialPain_Assessment(driver);

		select_Location_AssessementDeatils(driver, location);
		select_NumericRating_NursingAssessement(driver, numericRating);
		clickOnTheActionBtnInTheAssessmentTable(driver);

		clickOn_BedSoreSwitchButton(driver);
		enter_Location_NursingAssessment(driver, location);
		enter_Size_NursingAssessement(driver, size);
		selectTheClassificationDropdown(driver, classification);
		enter_Clasification_NursingAssessement(driver, classification);
		activityOfDailyLiving_swiatchButtons_Independent_NursingAssessment(driver);
		activityOfDailyLiving_SwitchButtons_Assisted_NursingAssessment(driver);
		activityOfDailyLiving_SwitchButtons_dependent_NursingAssessment(driver);

		clickOnTheSubmitButton_NursingAssessment(driver);
		okBtnForErrorPopup_NursingCarePlan.click();
	}

	public void clickOn_NursingCarePlanTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nursingCarePlanTabBtn);
		nursingCarePlanTabBtn.click();
	}

	public void clickOn_PlusButton_NursingCarePlan(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_NursingCarePlan);
		clickOnTheElementUsedToJavascriptExecuter(driver, plusBtn_NursingCarePlan);
	}

	public void clickOn_AllSwitchButtons_NursingCarePlan(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownByUsingJavascriptExecuter(driver);
		Thread.sleep(2000);
		for (WebElement webElement : allActivity_SwitchButtons_NursingCarePlan) {
			webElement.click();
		}
	}

	public void enter_Preventive_NursingCarePlan(WebDriver driver, String preventive) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, preventiveText_NursingCarePlan);
		preventiveText_NursingCarePlan.sendKeys(preventive);
	}

	public void enter_Curative_NursingCarePlan(WebDriver driver, String curative) {
		curative_NursingCarePlan.sendKeys(curative);
	}

	public void clickOn_Submit_NursingCarePlan(WebDriver driver) {
		scrollDownTheStillEndOfThePage(driver);
		submitBtn_NursingCarePlan.click();
	}

	public void clickOn_PatientArrival(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		patientArrival.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_SaveButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		save_PatientArrival.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void nursingCarePlan(WebDriver driver, String status, String preventive, String curative) throws Throwable {

		if (status.equals("ARRIVED0")) {
			clickOn_HospitalNumber(driver);
		} else if (status.equals("NOT ARRIVED0")) {
			clickOn_HospitalNumber(driver);
			clickOn_PatientArrival(driver);
			clickOn_SaveButton(driver);
		}
		clickOn_NursingCarePlanTab(driver);
		clickOn_PlusButton_NursingCarePlan(driver);
		clickOn_AllSwitchButtons_NursingCarePlan(driver);
		enter_Preventive_NursingCarePlan(driver, preventive);
		enter_Curative_NursingCarePlan(driver, curative);
		clickOn_Submit_NursingCarePlan(driver);
		okBtnForErrorPopup_NursingCarePlan.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	// -------------------------------------------------Nursing progres
	// record-------------------------------------------------------------

	public String take_StatusTable(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = status_Table.getText();
		return status;
	}

	public void clickOn_NursingProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nursingPregressRecordTab);
		nursingPregressRecordTab.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_PlusButton_NursingProgressecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plusButton_NursingProgressRecord);
		plusButton_NursingProgressRecord.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOn_FirstOption_InstructionNursingProgressRecord(WebDriver driver) {
		first_Option_InstructionDropdown.click();
	}

	public void select_Instruction_NursingProgressRecord(WebDriver driver, String instruction) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, instruction_DropdownBtn);
		instruction_DropdownBtn.click();
		Thread.sleep(2000);
		moveToElementAndEnterTheData(driver, dropdownText, instruction);
	}

	public void nursingProgress_Record(WebDriver driver, String status, String instruction) throws Throwable {

		if (status.equals("ARRIVED0")) {
			clickOn_HospitalNumber(driver);
		} else if (status.equals("NOT ARRIVED0")) {
			clickOn_HospitalNumber(driver);
			clickOn_PatientArrival(driver);
			clickOn_SaveButton(driver);
		}

		clickOn_NursingProgressRecord(driver);

		clickOn_PlusButton_NursingProgressecord(driver);

		select_Instruction_NursingProgressRecord(driver, instruction);

		WebElement iframe = iframe_NursingProgressRecord;
		driver.switchTo().frame(iframe);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		textOfNursingProgressRecord.sendKeys("Nurse Entered notes in the progress record");
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		clickOnTheSaveButtonInNUrisngProgressRecord(driver);

	}

	public void clickOnTheSaveButtonInNUrisngProgressRecord(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, saveButton_NursingProgressRecord);
		clickOnTheElementUsedToJavascriptExecuter(driver, saveButton_NursingProgressRecord);

	}

	// --------------------------------------Patient
	// Chart---------------------------------------

	public void clickOnPlusBtn_ventilatorSetUpPlanTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_ventilatorSetupTab);

		plusBtn_ventilatorSetupTab.click();
		Thread.sleep(500);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void enterDate_ventilatorSetUpPlanTab(WebDriver driver, String date) {
		dateField_ventilatorSetupTab.sendKeys(date);
	}

	public void enterChooseDateAndTime_ventilatorSetUpPlanTab(WebDriver driver, String date) throws Throwable {
		chooseDateTime_ventilatorSetupTab.sendKeys(date);
		Thread.sleep(400);
		chooseDateTime_ventilatorSetupTab.sendKeys(Keys.ENTER);
	}

	public void enterSpo2_ventilatorSetUpPlanTab(WebDriver driver, String spo2) {
		spo2Field_ventilatorSetupTab.sendKeys(spo2);
	}

	public void enterTv_ventilatorSetUpPlanTab(WebDriver driver, String tv) {
		tvField_ventilatorSetupTab.sendKeys(tv);
	}

	public void enterRate_ventilatorSetUpPlanTab(WebDriver driver, String rate) {
		rateField_ventilatorSetupTab.sendKeys(rate);
	}

	public void enterFio2_ventilatorSetUpPlanTab(WebDriver driver, String fio2) {
		fio2Field_ventilatorSetupTab.sendKeys(fio2);
	}

	public void enterPrSupport_ventilatorSetUpPlanTab(WebDriver driver, String prSupport) {
		prSupportField_ventilatorSetupTab.sendKeys(prSupport);
	}

	public void enterPeep_ventilatorSetUpPlanTab(WebDriver driver, String peep) {
		peepField_ventilatorSetupTab.sendKeys(peep);
	}

	public void enterPc_ventilatorSetUpPlanTab(WebDriver driver, String pc) {
		pcField_ventilatorSetUpTab.sendKeys(pc);
	}

	public void enterOxygen_ventilatorSetUpPlanTab(WebDriver driver, String oxygen) {
		oxygenField_ventilatorSetUpTab.sendKeys(oxygen);
	}

	public void enterTpiece_ventilatorSetUpPlanTab(WebDriver driver, String tpiece) {
		tPieceField_ventilatorSetUpTab.sendKeys(tpiece);
	}

	public void clickOnRoomAirBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		roomAirBtn_ventilatorSetup.click();
	}

	public void clickOnVomittingBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		vomittingBtn_ventilatorSetup.click();
	}

	public void clickOnPositioningBackCareBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		positioningBackCareBtn_ventilatorSetup.click();
	}

	public void clickOnBathBedBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		bedBathBtn_ventilatorSetup.click();
	}

	public void clickOnOralCareBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		oralCareBtn_ventilatorSetup.click();
	}

	public void clickOnChestPhysioBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		chestPhysioBtn_ventilatorBtn.click();
	}

	public void clickOnStoolBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		stoolBtn_ventilatorBtn.click();
	}

	public void clickOnWoundDressingBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		woundDressingBtn_ventilatorSetup.click();
	}

	public void clickOnSubmitBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		scrollToBottom(driver);
		submitBtn_ventilatorSetup.click();
	}

	public void clickOnCancelBtn_ventilatorSetUpPlanTab(WebDriver driver) {
		scrollToBottom(driver);
		cancelBtn_ventilatorSetup.click();
	}

	public void enterDateInTable_grbsTab(WebDriver driver, String date) throws InterruptedException {
		dateInTable_grbsTab.sendKeys(date);
		Thread.sleep(400);
		dateInTable_grbsTab.sendKeys(Keys.ENTER);
	}

	public void selectTypeInTable_grbsTab(WebDriver driver, String selectType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		typeDropDownBtn_grbsTab.click();
		moveToElementAndEnterTheData(driver, dropDownText, selectType);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void selectCollectedAtInTable_grbsTab(WebDriver driver, String collectedAt) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		collectedAtDropDownBtn_grbsTab.click();
		moveToElementAndEnterTheData(driver, dropDownText, collectedAt);
	}

	public void enterValueInTable_grbsTab(WebDriver driver, String value) {
		valueField_grbsTab.sendKeys(value);
	}

	public void enterRemarksInTable_grbsTab(WebDriver driver, String remarks) {
		remarksField_grbsTab.sendKeys(remarks);
	}

	public void clickOnAddBtnInTable_grbsTab(WebDriver driver) {
		addBtnInTable_grbsTab.click();
	}

	public void clickOnSubmitBtn_grbsTab(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_grbsTab);
		submitBtn_grbsTab.click();
	}

	public void clickOnViewGraphsBtn_grbsTab(WebDriver driver) {
		viewGraphsBtn_grbsTab.click();
	}

	public void enterDate_grbsTab(WebDriver driver, String date) throws Throwable {
		dateField_grbsTab.sendKeys(date);
	}

	public void clickOnGrbsTab(WebDriver driver) {
		grbsTab_grbsMonitoringTab.click();
	}

	public void clickOnAbgTab(WebDriver driver) {
		abgTab_grbsMonitoringTab.click();
	}

	public void clickOnVentilatorSetupTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		ventilatorSetupIcuCarePlanTab.click();
	}

	public void clickOnHospitalNumber_NursingDesk(WebDriver driver, String status) throws Throwable {

		if (status.equals("ARRIVED0")) {
			clickOn_HospitalNumber(driver);
		} else if (status.equals("NOT ARRIVED0")) {
			clickOn_HospitalNumber(driver);
			clickOn_PatientArrival(driver);
			clickOn_SaveButton(driver);
		}
	}

	public void clickOnPatientChartTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, patientChartTab);
		patientChartTab.click();
	}

	public String captureErrorPopUpmsg(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String errorMsg = errorPopUpMsg.getText();
		return errorMsg;
	}

	public void createVentilatorSetup_1(WebDriver driver, String date, String spo2, String tv, String rate, String fio2,
			String prsupport, String peep, String pc) throws Throwable {
		enterChooseDateAndTime_ventilatorSetUpPlanTab(driver, date);
		enterSpo2_ventilatorSetUpPlanTab(driver, spo2);
		enterTv_ventilatorSetUpPlanTab(driver, tv);
		enterRate_ventilatorSetUpPlanTab(driver, rate);
		enterFio2_ventilatorSetUpPlanTab(driver, fio2);
		enterPrSupport_ventilatorSetUpPlanTab(driver, prsupport);
		enterPeep_ventilatorSetUpPlanTab(driver, peep);
		enterPc_ventilatorSetUpPlanTab(driver, pc);
	}

	public void createVentilatorSetup_2(WebDriver driver, String oxygen, String tpiece) {
		for (int i = 0; i <= 2; i++) {
			scrollDownByUsingActionClass(driver);
		}
		enterOxygen_ventilatorSetUpPlanTab(driver, oxygen);
		enterTpiece_ventilatorSetUpPlanTab(driver, tpiece);
		clickOnRoomAirBtn_ventilatorSetUpPlanTab(driver);
		clickOnVomittingBtn_ventilatorSetUpPlanTab(driver);
		clickOnPositioningBackCareBtn_ventilatorSetUpPlanTab(driver);
		clickOnBathBedBtn_ventilatorSetUpPlanTab(driver);
		clickOnOralCareBtn_ventilatorSetUpPlanTab(driver);
		clickOnChestPhysioBtn_ventilatorSetUpPlanTab(driver);
		clickOnStoolBtn_ventilatorSetUpPlanTab(driver);
		clickOnWoundDressingBtn_ventilatorSetUpPlanTab(driver);
		clickOnSubmitBtn_ventilatorSetUpPlanTab(driver);
	}

	public void clickOnGrbsMonitoringTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		grbsMonitoringTab.click();
		Thread.sleep(500);
	}

	public void createGrbsUnderGrbsMonitoring(WebDriver driver, String date, String type, String collectedAt,
			String value, String remarks) throws Throwable {
		for (int i = 0; i <= 4; i++) {
			scrollDownByUsingJavascriptExecuter(driver);
			enterDateInTable_grbsTab(driver, date);
			selectTypeInTable_grbsTab(driver, type);
			selectCollectedAtInTable_grbsTab(driver, collectedAt);
			enterValueInTable_grbsTab(driver, value);
			enterRemarksInTable_grbsTab(driver, remarks);
			clickOnAddBtnInTable_grbsTab(driver);
		}
		clickOnSubmitBtn_grbsTab(driver);
	}

	public void clickOnLinesAndTubesTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		linesAndTubesTab.click();
		Thread.sleep(500);
	}

	public void clickOnPlusBtn_LinesAndtubesTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_linesAndTubesTab);
		plusBtn_linesAndTubesTab.click();
		Thread.sleep(500);
	}

	public void clickOnListOfCheckBox_LinesAndTubes(WebDriver driver) throws Throwable {
		for (WebElement element : listOfCheckBox_LinesAndtubes) {
			element.click();
		}
	}

	public void enterListOfText_LinesAndTubes(WebDriver driver, String text) throws Throwable {
		for (WebElement element : listOfTextField_LinesAndtubes) {
			element.sendKeys(text);
		}
	}

	public void clickOnSubmitBtn_linesAndTubesTab(WebDriver driver) {
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_linesAndTubesTab);
		submitBtn_linesAndTubesTab.click();
	}

	public void clickOnIntakeAndOutputChartingTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		intakeAndOutputChartingTab.click();
		Thread.sleep(500);
	}

	public void clickOnPlusBtn_IntakeAndOutputChartingTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_intakeAndOutputCharting);
		plusBtn_intakeAndOutputCharting.click();
		Thread.sleep(500);
	}

	public void enterChooseTime_IntakeAndOutputCharting(WebDriver driver, String date) throws Throwable {
		chooseTimeField_intakeAndOutputCharting.sendKeys(date);
		Thread.sleep(400);
		chooseTimeField_intakeAndOutputCharting.sendKeys(Keys.ENTER);
	}

	public void enterFluid_IntakeAndOutputCharting(WebDriver driver, String fluid) throws Throwable {
		fluidTextField_intakeAndOutputCharting.sendKeys(fluid);
	}

	public void enterRtf_IntakeAndOutputCharting(WebDriver driver, String Rtf) throws Throwable {
		rtfTextField_intakeAndOutputCharting.sendKeys(Rtf);
	}

	public void enterOral_IntakeAndOutputCharting(WebDriver driver, String oral) throws Throwable {
		oralTextField_intakeAndOutputCharting.sendKeys(oral);
	}

	public void enterFj_IntakeAndOutputCharting(WebDriver driver, String fj) throws Throwable {
		fjTextField_intakeAndOutputCharting.sendKeys(fj);
	}

	public void enterIvfSolution_IntakeAndOutputCharting(WebDriver driver, String ivf) throws Throwable {
		ivfSolutionTextField_intakeAndOutputCharting.sendKeys(ivf);
	}

	public void enterUrinOutput_IntakeAndOutputCharting(WebDriver driver, String urinOutput) throws Throwable {
		urinOutputTextField_intakeAndOutputCharting.sendKeys(urinOutput);
	}

	public void enterDrainValue_IntakeAndOutputCharting(WebDriver driver, String drainValue) throws Throwable {
		drainValueBtn_intakeAndOutputCharting.sendKeys(drainValue);
	}

	public void selectDrain_IntakeAndOutputCharting(WebDriver driver, String drain) throws Throwable {
		dropdown(driver, drainDropDownBtn_intakeAndOutputCharting, dropdownText, drain);
	}

	public void enterIcd_IntakeAndOutputCharting(WebDriver driver, String icd) throws Throwable {
		icdTextField_intakeAndOutputCharting.sendKeys(icd);
	}

	public void enterRtf_Aspiration_IntakeAndOutputCharting(WebDriver driver, String rtf) throws Throwable {
		rtfText_Aspiraiton_intakeAndOutputCharting.sendKeys(rtf);
	}

	public void enterOther_IntakeAndOutputCharting(WebDriver driver, String other) throws Throwable {
		otherText_Aspiraiton_intakeAndOutputCharting.sendKeys(other);
	}

	public void clickOnSubmit_IntakeAndOutputCharting(WebDriver driver) throws Throwable {
		submitBtn_intakeAndOutputCharting.click();
	}

	public void enterData_NursingProgressRecird_Iframe(WebDriver driver, String text) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, iframe_NursingProgressRecord);
		scrollTillVisibleElement(driver, iframe_NursingProgressRecord);
		scrollTillVisibleElement(driver, iframe_NursingProgressRecord);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		WebElement iframe = iframe_NursingProgressRecord;
		driver.switchTo().frame(iframe);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		scrollTillVisibleElement(driver, textOfNursingProgressRecord);
		textOfNursingProgressRecord.clear();
		textOfNursingProgressRecord.sendKeys(text);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	public void clickOnSideDate_NursingRecord(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		Thread.sleep(2000);
		scrollTillVisibleElement(driver, sideDate_NursingProgressRecord);
		scrollDownThePageUntilElementIsVisible(driver, sideDate_NursingProgressRecord);
		sideDate_NursingProgressRecord.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String captureReport_NursingProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = reportInTable_NursingProgressRecord.getText();
		return text;
	}

	public String captureUserName(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = userName1.getText();
		return text;
	}

	public void clickOnViewBtn_NursingProgressRecord_Test(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, viewBtn_NursingProgreeRecord);
		viewBtn_NursingProgreeRecord.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String captureReport_UnderViewBtn_NursingProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = report_underViewBtn_ProgressRecord.getText();
		return text;
	}

	public void clickOnEditBtn_NursingProgressRecord_Test(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, editBtn_NursingProgreeRecord);
		editBtn_NursingProgreeRecord.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public String captureDate_NursingProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, sideDate_NursingProgressRecord);
		String text = sideDate_NursingProgressRecord.getText();
		return text;
	}

	public void enterDate_NursingProgressRecord(WebDriver driver, String date) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dateField_NursingProgreeRecord.sendKeys(date);
	}

	public void selectStatusDropdown(WebDriver driver, String status) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		statusDropdownBtns_Filter.click();
		moveToElementAndEnterTheData(driver, dropdownsText, status);
	}

	public void clickOnTheSearchButton(WebDriver driver) throws Throwable {
		invisibiltyOf_Element_ThreeDots(driver);
		searchBtn_Filter.click();
		Thread.sleep(1000);
	}

	public String capturePreventiveDataInTheTextNursingCarePlan(WebDriver driver) {
		String data = preventiveTextData_NursingCarePlan.getText();
		return data;
	}

	public void clickOnCancelButtonNursingCarePlan(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, cancelButtonNursingCarePlan);
		scrollDownThePageUntilElementIsVisible(driver, cancelButtonNursingCarePlan);
		cancelButtonNursingCarePlan.click();
	}

}