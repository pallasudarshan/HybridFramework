package com.Dalvkot.Vims_ObjectRepositary;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DoctorDesk_Ip_Page extends WebDriverUtility {

	public DoctorDesk_Ip_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Doctor Desk IPD ']")
	private WebElement doctorDeskIPDScreenBtn;

	@FindAll({ @FindBy(xpath = "//a[@id='INV2']"), @FindBy(xpath = "//a[@id='INV3']"),
			@FindBy(xpath = "(//a[text()='Investigation/Procedure '])[1]") })
	private WebElement investigationTab;

	@FindAll({ @FindBy(xpath = "//a[.='Pharmacy']"), @FindBy(xpath = "//a[@id='PHA3']") })
	private WebElement pharmacyTab;

	@FindAll({ @FindBy(xpath = "//a[.='Order History']") })
	private WebElement orderHistoryTab;

	private static final String[] Indications = { "MASS TRANSFUSION PROTOCOL(MTP", "SURGERY ELECTIVE",
			"SURGERY EMERGENCY", "THERAPEUTIC" };

	private static final String[] componentType = { "CRYOPRECIPITATE", "FRESH FROZEN PLASMA", "PACKED RED BLOOD CELLS",
			"PLATELET CONCENTRATE", "WHOLE BLOOD" };

	private static final String[] bloodGroup = { "A POSITIVE", "AB NEGATIVE", "AB POSITIVE", "B NEGATIVE", "O NEGATIVE",
			"O POSITIVE", "OH" };
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/descendant::input[@placeholder='Service']")
	private WebElement serviceNameTextInTheTable;

	@FindBy(className = "ng-star-inserted")
	private WebElement suggestionOption;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/descendant::input[@placeholder='Note']")
	private WebElement notesTextInTheTable;

	@FindBy(xpath = "//table/tbody/tr[1]/td[8]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement actionBtnInInvestgationTableOPD;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsTextField;

	@FindBy(css = "div[aria-label='No data for  IP Patient List']")
	private WebElement noDataForIPPatientListMsg_Vims;

	@FindBy(css = "div[aria-label='No data for  Patient List']")
	private WebElement noDataForPatientListMsg_Vims;

	@FindBy(css = "div[aria-label='created successfully']")
	private WebElement createdSuccessfullyMsgForFinalDiagnosis;

	@FindBy(xpath = "//a[@id='PRGR6']")
	private WebElement progressRecordTab;

	@FindBy(tagName = "iframe")
	private WebElement frame;

	private static final String[] Final_Diagnosis = { "cholera, unspecified", "cholera due to", "PARATYPHOID FEVER A",
			"PARATYPHOID FEVER B", "PARATYPHOID FEVER C", "SALMONELLA ENTER", "BUBONIC PLAGUE", "CELLULOCU",
			"OTHER FORMS OF PLAGUE", "OTHER FORMS OF ANTHRAX", "OTHER FORMS OF LEPROSY",
			"SHIGELLOSIS DUE TO SHIGELLA BOYDII", "SHIGELLOSIS DUE TO SHIGELLA SONNEI",
			"SHIGELLOSIS DUE TO SHIGELLA FLEXNERI", "ISOSPORIASIS", "CRYPTOSPORIDIOSIS" };

	private static final String[] Documents = { "/src/main/resources/Documents/d1.PNG" };

	private static final String[] LOREM_IPSUM_WORDS = { "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur",
			"adipiscing", "elit", "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore",
			"magna", "aliqua", "Ut", "enim", "ad", "minim", "veniam", "quis", "nostrud", "exercitation", "ullamco",
			"laboris", "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "Duis", "aute", "irure", "dolor",
			"in", "reprehenderit", "in", "voluptate", "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla",
			"pariatur", "Excepteur", "sint", "occaecat", "cupidatat", "non", "proident", "sunt", "in", "culpa", "qui",
			"offic ia", "deserunt", "mollit", "anim", "id", "est", "laborum" };

	@FindBy(xpath = "//div[@class='cke_contents cke_reset']")
	private WebElement text;

	@FindBy(css = "div[aria-label='Successfully Updated the patient arrival status']")
	private WebElement successfullyUpdatedThePatientArrivalStatus_Vims;

	@FindBy(xpath = "(//button[text()=' Search ']//i)[2]")
	private WebElement searchButtonIPD;

	// Investigation
	@FindAll({ @FindBy(xpath = "//a[@id='INV2']"), @FindBy(xpath = "//a[@id='INV3']") })
	private WebElement investigation_ProcedureTabIPD;

	@FindBy(xpath = "//div[@id='INV']/descendant::i[@class='zmdi zmdi-plus'][1]")
	private WebElement plusButtonInvetsigationsIPD;

	@FindBy(xpath = "//div[@id='investigationProcedure']/descendant::table/tbody/tr[1]/td[2]/descendant::input")
	private WebElement serviceDescriptionTextInTHeTableIPD;

	@FindBy(xpath = "//table[@id='subtableid']/tbody/tr[1]/td[8]/descendant::input[@placeholder='Clinic Note']")
	private WebElement clinickNotesInTheTableIPD;

	@FindBy(xpath = "//div[@id='investigationProcedure']/descendant::button[text()=' Submit ']")
	private WebElement submitBtnInvestgationIPD;

	@FindBy(xpath = "//div[@id='investigationProcedure']/descendant::li")
	private WebElement serivceSuggestionIPD;

	@FindBy(xpath = "/html/body/app-root/app-home/app-ward-service/section/div[3]/div[4]/div/table/tr[4]/th[3]/label/span[1]")
	private WebElement patientArrivalBtnIPD;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::i[@class='zmdi zmdi-plus'][1]")
	private WebElement dietPlanPlusBtnIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::table/tbody/tr[1]/td[2]/descendant::input[@placeholder='Time']")
	private WebElement requestTimeTextIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::table/tbody/tr[1]/td[3]/descendant::span[@class='select2-selection__arrow']")
	private WebElement npoDropdownInTheTableIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::table/tbody/tr[1]/td[6]/descendant::span[@class='select2-selection__arrow']")
	private WebElement dietTypeDropdownBtnInTheTableIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::table/tbody/tr[1]/td[7]/descendant::span[@class='select2-selection__arrow']")
	private WebElement dietCategoryDropdownBtnInTheTableIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::table/tbody/tr[1]/td[8]/descendant::input")
	private WebElement remrksTextInTHeDuetTableIPD;

	@FindBy(xpath = "//div[@id='dietRequest']/descendant::table/tbody/tr[1]/td[9]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement actionBtnInTHeDietTableIPD;

	@FindBy(xpath = "/html/body/app-root/app-home/app-ward-service/section/div[5]/div/div[3]/div/div[2]/div/div/div/div[12]/div/div[1]/form/div[3]/div/button[1]")
	private WebElement submitBtnInTHeDietPlanIPD;

	@FindBy(xpath = "//div[@id='pharmacyIndent']/descendant::i[@class='zmdi zmdi-plus'][1]")
	private WebElement plusBtnForPharmacyIPD;

	@FindBy(xpath = "//div[@id='pharmacyIndent']/descendant::table/tbody/tr[1]/td[3]/descendant::input")
	private WebElement descriptionTextInThePharmacyIPD;

	@FindBy(xpath = "//div[@id='pharmacyIndent']/descendant::li")
	private WebElement descriptionSuggestionPharmacyIPD;

	@FindBy(xpath = "//div[@id='pharmacyIndent']/descendant::table/tbody/tr[1]/td[5]/descendant::span[@class='select2-selection__arrow']")
	private WebElement repeateDropdownBtnPharmacyIPD;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsTextIPD;

	@FindBy(xpath = "//div[text()=' IP consulatation created successfully ']")
	private WebElement ipconsulatationPopupMsg;

	@FindBy(id = "toast-container")
	private WebElement popMsgForHistory;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownsText;

	// Final diagnosis
	@FindAll({ @FindBy(xpath = "(//a[contains(text(), 'Final Diagnosis  ')])[1]") })
	private WebElement finalDiagnosisTab;

	@FindBy(xpath = "(//div[@id='FDGS']//descendant::button)[1]")
	private WebElement plusBtn_FinalDiagnosis;

	@FindBy(xpath = "//span[@title='ICD Code']/following-sibling::span")
	private WebElement codeType_FinalDiagnosis;

	@FindBy(xpath = "//input[@placeholder='undefined']")
	private WebElement Icd_Code_Description;

	@FindBy(xpath = "(//td[@class='text-wrap ng-star-inserted'])[2]")
	private WebElement icd_DescriptionSuggesstion_FinalDiagnosis;

	@FindBy(xpath = "//div[@id='pharmacyIndent']//table/tbody/tr[1]/td[last()]//button")
	private WebElement actionBtn_FinalDiagnosis;

	@FindBy(xpath = "(//div[@id='pharmacyIndent'])[2]//descendant::button[text()=' Submit ']")
	private WebElement submitButton_FinalDiagnosis;

	@FindBy(xpath = "(//div[@id='pharmacyIndent'])[2]//descendant::button[text()=' Cancel ']")
	private WebElement cancelButton_FinalDiagnosis;

	@FindBy(xpath = "//table[@letxpath='letxpathtable']//descendant::i[@class='zmdi zmdi-delete']")
	private WebElement delete_FinalDiagnosis;

	// Ip consultation
	@FindAll({ @FindBy(xpath = "//a[@id='IPC4']"), @FindBy(xpath = "//a[@id='IPC5']"),
			@FindBy(xpath = "(//a[text()='IP Consultation '])[1]") })
	private WebElement ipConsultationTab;

	@FindBy(xpath = "(//div[@id='IPC']//button)[1]")
	private WebElement plusBtnFor_IpConsulationTab;

	@FindBy(xpath = "//div[@id='IPC']//table//tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement doctorNameDropdown_IpConsulation;

	@FindBy(xpath = "//div[@id='IPC']//descendant::input[@role='combobox']")
	private WebElement serviceDescriptionText_IpConsulationTab;

	@FindBy(xpath = "//div[@id='suggestions']//li//div//a")
	private WebElement serviceDescription_Suggestion_IpConsulationTab;

	@FindBy(xpath = "//div[@id='IPC']/descendant::table/tbody/tr[1]/td[8]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement actionBtn_IpConsulationTab;

	@FindBy(xpath = "//div[@id='IPC']/descendant::button[text()=' Submit ']")
	private WebElement submitBtn_IpConsulationTab;

	@FindBy(xpath = "//div[@id='IPC']/descendant::button[text()=' Cancel ']")
	private WebElement cancel_IpConsultation;

	@FindBy(xpath = "//div[@id='IPC']/descendant::input[@placeholder='Approximate Total Amount']")
	private WebElement approximate_TotalAmount;

	@FindBy(xpath = "//div[@id='DIET']//table//tr[1]/td[3]/descendant::span[@role='presentation']")
	private WebElement npoDropdownsBtn_DietPlan;

	@FindBy(className = "select2-search__field")
	private WebElement dropdownText;

//-------XPATH -----------
	// Next Enocunter Tab
	@FindAll({ @FindBy(xpath = "//a[@id='NXN8']"), @FindBy(xpath = "(//a[text()='Next Encounter '])[1]") })
	private WebElement nextEncounterTab;

	@FindBy(xpath = "//table[@id='diagnosisId']/tbody[1]/tr[1]/td[2]/input[1]")
	private WebElement date_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Subjective']")
	private WebElement subjective_Text_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Objective']")
	private WebElement objectiveText_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Assessment']")
	private WebElement assessmentText_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Plan']")
	private WebElement plan_Text_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Investigation']")
	private WebElement investigationText_NextEncounter;

	@FindBy(xpath = "//table[@id='diagnosisId']//button[1]")
	private WebElement actionBtn_NextEncounter;

	@FindBy(xpath = "//div[@id='NXN']//descendant::button[text()='Submit']")
	private WebElement submitBtn_NextEncounter;

	@FindBy(xpath = "//div[@id='NXN']//button[text()='Cancel']")
	private WebElement cancelBtn_NextEncounter;

	@FindAll({ @FindBy(xpath = "(//a[text()='Diet plan '])[1]"), @FindBy(xpath = "//a[@id='DIET10']") })
	private WebElement diet_Tab;

	@FindBy(xpath = "//div[@id='dietRequest']/form[1]/div[1]/div[1]/button[1]")
	private WebElement plusBtn_DietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[2]//input[@placeholder='Time']")
	private WebElement requestTime_DietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[3]//span[@role='presentation']")
	private WebElement NPO_DropdownDietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[4]//span[@role='presentation']")
	private WebElement RTF_DropdownDietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[6]//input[@placeholder='Time']")
	private WebElement NPO_TillTime_DietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[7]//span[@role='presentation']")
	private WebElement dietTypeDropdownBtnDietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[8]//span[@role='presentation']")
	private WebElement dietCategoryDropdownDietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[9]//span[@role='presentation']")
	private WebElement dietSubCategoryDropdownDietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[11]//input")
	private WebElement quantityDietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[12]//input")
	private WebElement remarks_DietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//table//tr[1]/td[last()]//button")
	private WebElement actionBtn_DietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//button[text()=' Submit ']")
	private WebElement submitBtn_DietPlan;

	@FindBy(xpath = "//div[@id='dietRequest']//button[text()=' Cancel ']")
	private WebElement cancelBtn_DietPlan;

	// Document

	@FindBy(xpath = "//a[@id='DOC11']")
	private WebElement Document_Tab;

	@FindBy(xpath = "//div[@id='DOC']//button[text()='Upload']")
	private WebElement uploadBtn_Document;

	@FindBy(xpath = "//input[@id='file']")
	private WebElement chooseFileOptionInDocument;

	@FindBy(xpath = "//button[@id='closeUpload']")
	private WebElement submitButtonInDocument;

	// -------XPATH -----------
	@FindBy(xpath = "//a[@id='mypatientIP']")
	private WebElement myPatientListTab;

	@FindBy(xpath = "//div[@class='ng-tns-c45-4 toast-message ng-star-inserted']")
	private WebElement createdSuccesullyPopUpAfterSubmittingInPharmacyTab;

	@FindAll({ @FindBy(css = "#allpatientIP"), @FindBy(xpath = "//a[@id='allpatientIP']") })
	private WebElement allPatientListTab;

	@FindBy(xpath = "(//div[@id='investigationProcedure']//button[@type='button'])[1]")
	private WebElement addBtnInInvestigationTab;

	@FindBy(xpath = "//div[@id='pharmacyIndent']/descendant::button//i[@class='zmdi zmdi-plus'][1]")
	private WebElement addBtnInPharmacyTab;

	@FindBy(xpath = "//div[@id='INV']/descendant::table/tbody/tr[1]/td[2]/descendant::input[@type='text']")
	private WebElement serviceDescriptionTextFieldInInvestigationTab;

	@FindBy(xpath = "//div[@id='INV']/descendant::table/tbody/tr[1]/td[9]/descendant::input[@type='text']")
	private WebElement clinicNotesInInvestigationTab;

	@FindBy(xpath = "//div[@id='INV']/descendant::table/tbody/tr[1]/td[10]/descendant::button[@type='button']")
	private WebElement addBtnForInvestigationsInInvestigationTab;

	@FindBy(xpath = "//div[@id='INV']/descendant::table/tbody/tr[1]/td[3]/descendant::input[@onkeydown='return false']")
	private WebElement collectionDateCalenderFieldInInvestigationTab;

	@FindBy(xpath = "//div[@id='Pharmacy']/descendant::table/tbody/tr[1]/td[3]/descendant::input[@type='text']")
	private WebElement descripriontextFieldInPharmacyTab;

	@FindBy(xpath = "//div[@id='suggestions']//li//a")
	private WebElement descriprion_SuggestionPharmacyTab;

	@FindBy(xpath = "//table[@id='drug-admin-entry']/tbody/tr[1]/td[2]//div[@class='rounded-lg text-wrap text-center'][1]")
	private WebElement patternText_firstRow_drugAdministration;

	@FindBy(xpath = "//table[@id='drug-admin-entry']/tbody/tr[1]/td[2]//div[@class='rounded-lg text-wrap text-center'][3]")
	private WebElement doctorNotesText_firstRow_drugAdministration;

	@FindBy(xpath = "//table[@id='drug-admin-entry']/tbody/tr[1]/td[2]//button[text()=' Modify ']")
	private WebElement modifyButton_firstRow_drugAdministration;

	@FindBy(xpath = "//table[@id='drug-admin-entry']/tbody/tr[1]/td[2]//button[text()=' Cancel ']")
	private WebElement cancelButton_firstRow_drugAdministration;

	@FindBy(xpath = "//span[@title='Select Pattern']/following-sibling::span[1]")
	private WebElement patternDropdownBtn_modifyPopup_drugAdministration;

	@FindBy(xpath = "//label[text()='Route return']/..//span[@role='presentation']")
	private WebElement routeReturnDropdownBtn_modifyPopup_drugAdministration;

	@FindBy(xpath = "//div[@id='modifyData']//textarea[@placeholder='Notes']")
	private WebElement textarea_modifyPopup_drugAdministration;

	@FindBy(xpath = "//div[@id='modifyData']//button[text()=' Modify ']")
	private WebElement modify_modifyPopup_drugAdministration;

	@FindBy(xpath = "(//div[@id='Pharmacy']//button//i[@class='zmdi zmdi-plus'])[1]")
	private WebElement plusBtn_Pharmacy;

	@FindBy(xpath = "//div[@id='Pharmacy']//table//tr[1]//td[5]//span[@role='presentation']")
	private WebElement repeatPatternDropDownBtnInPharmacyTab;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement serachBoxForDropDownInPharmacyTab;

	@FindBy(xpath = "//div[@id='Pharmacy']/descendant::table/tbody/tr[1]/td[6]/descendant::input[@type='text']")
	private WebElement quantitytextFieldInPharmacyTab;

	@FindBy(xpath = "//div[@id='Pharmacy']/descendant::table/tbody/tr[1]/td[7]//span[@role='presentation']")
	private WebElement routeDropDownFieldInPharmacyTab;

	@FindBy(xpath = "//div[@id='Pharmacy']/descendant::table/tbody/tr[1]/td[8]//input[@placeholder='Note']")
	private WebElement notes_Pharmacy;

	@FindBy(xpath = "//div[@id='Pharmacy']/descendant::table/tbody/tr[1]/td//button[@title='Add']//i")
	private WebElement addBtnToaddInPharmacyTab;

	@FindBy(xpath = "//div[@id='PHA']/descendant::button[text()=' Submit ']")
	private WebElement submitBtnToaddInPharmacyTab;

	@FindBy(xpath = "//span[text()=' Doctor Desk IPD ']")
	private WebElement doctorDeskIPDBtn;

	@FindBy(xpath = "//div[@id='investigationProcedure']/descendant::button[@type='submit']")
	private WebElement submitBtnInInvestigationAndProcedure;

	@FindAll({ @FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[1]"),
			@FindBy(xpath = "(//span[@data-off='No']/following-sibling::span)[1]"),
			@FindBy(xpath = "(//span[@class='switch-handle'])[1]") })
	private WebElement ipdpatientarrivalbtn;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement ipdsavebtn;

	@FindBy(xpath = "(//div[@id='pharmacyIndent']/descendant::table)[1]/tbody/tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement formNonFormBtnInPharmacy;

	@FindBy(xpath = "//input[@formcontrolname='hospitalnum1']")
	private WebElement hospitalNumberField;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table/tbody/tr[1]/td[3]/a[@class='badge badge-success ng-star-inserted']")
	private WebElement hospitalNumberInFirstRowAllPatientList;

	@FindAll({ @FindBy(xpath = "//a[@id='OTI5']"), @FindBy(xpath = "//a[@id='OTI6']"),
			@FindBy(xpath = "(//a[text()='OT Information '])[1]") })
	private WebElement otInformationTab;

	@FindBy(xpath = "//a[contains(text(),'OT Scheduling')]")
	private WebElement otScheduleTab;

	@FindBy(xpath = "//div[@id='OTI0001']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement scheduleKey_OtInfomation;

	@FindBy(xpath = "//div[@id='OTI0001']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement surgerydate_OtInfomation;

	@FindBy(xpath = "//div[@id='OTI0001']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement surgeryTime_OtInformation;

	@FindBy(xpath = "//div[@id='OTI0001']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement duration_OtInfomation;

	@FindBy(xpath = "//div[@id='OTI0001']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement surgeryName_OtInfomation;

	@FindBy(xpath = "//div[@id='OTI0001']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement operationType_OtInfomation;

	// Discharge summary
	@FindAll({ @FindBy(xpath = "//a[@id='DISM18']"), @FindBy(xpath = "//a[@id='DISM17']") })
	private WebElement dischargeSummary_Tab;

	@FindBy(xpath = "//label[text()='Discharge results']/..//span[@role='presentation']")
	private WebElement dischargeResultsDropdown;

	@FindBy(xpath = "//button[text()=' Draft ']")
	private WebElement draftBtn_DischargeSummary;

	@FindBy(xpath = "//button[text()=' Finalize ']")
	private WebElement finalizeBtn_DischargeSummary;

	@FindBy(xpath = "(//div[@id='DISM']//button)[1]")
	private WebElement pencilBtn_DischargeSummary;

	@FindAll({ @FindBy(xpath = "//div[@id='DISM']//iframe[@class='cke_wysiwyg_frame cke_reset']") })
	private WebElement iframe_DischargeSummary;

	@FindBys({ @FindBy(css = "body.cke_editable.cke_editable_themed") })
	private List<WebElement> otherNotesTextArea;

	@FindBy(xpath = "//*[@id='printDetails']//p")
	private WebElement dischargeSummary_EnteredNotes_Text;

	/*
	 * My list
	 */

	@FindBy(xpath = "(//input[@placeholder='Hospital Number'])[2]")
	private WebElement hospitalNumberText;

	@FindBy(xpath = "//input[@placeholder='IP Patient Name']")
	private WebElement patientNameText;

	@FindBy(xpath = "//input[@formcontrolname='ipNumber']")
	private WebElement ipNumberText;

	@FindBy(xpath = "//input[@formcontrolname='phoneNumber1']")
	private WebElement phoneNumberText;

	@FindBy(xpath = "//input[@placeholder=' AlternativePhone Number1']")
	private WebElement alternativePhoneNumberText;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::label[text()='Department Name']/..//span[@role='presentation']")
	private WebElement departmentDropdown;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::label[text()=' Unit ']/..//span[@role='presentation']")
	private WebElement unitDropdown;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::label[text()='Ward Type']/..//span[@role='presentation']")
	private WebElement wardTypeDropdown;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::label[text()='Room Type']/..//span[@role='presentation']")
	private WebElement roomTypeDropdown;

	@FindBy(xpath = "//input[@placeholder='Bed Number']")
	private WebElement bedNumber_Text;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::label[text()='Gender']/..//span[@role='presentation']")
	private WebElement genderDropdown;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::input[@formcontrolname='regnDate']")
	private WebElement registrationFromDate;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::input[@formcontrolname='toregnDate']")
	private WebElement registrationToDate;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::label[text()='Pass Port Available']/..//span[@role='presentation']")
	private WebElement passPostAvailableDropdown;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::button[text()=' Search ']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@id='IPpatient']/descendant::button[text()=' Clear ']")
	private WebElement clearButton;

	@FindAll({
			@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[2]/descendant::a[@class='badge badge-success']") })
	private WebElement hospitalNumberInFirstRowMyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[3]")
	private WebElement ipNumber_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement ipDate_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement patientName_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[6]")
	private WebElement department_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[7]")
	private WebElement gender_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[8]")
	private WebElement phoneNumber_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement totalVisits_MyList;

	@FindBy(xpath = "//div[@id='MyListIp']/descendant::table/tbody/tr[1]/td[last()]//a")
	private WebElement status_MyList;

	@FindBy(xpath = "//div[@id='IPpatient']//label//input[@type='checkbox']")
	private WebElement checkbox_ShowAllFiltes_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[3]")
	private WebElement ipNumber_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[4]")
	private WebElement ipDate_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table/tbody/tr[1]/td[5]")
	private WebElement patientName_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[6]")
	private WebElement department_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[7]")
	private WebElement unit_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[8]")
	private WebElement gender_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[9]")
	private WebElement phoneNumber_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[last()]/td[9]")
	private WebElement phoneNumber_LasatRow_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[10]")
	private WebElement totalVisits_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientListIP']//table//tr[1]/td[last()]//span")
	private WebElement statu_AllPatientList;

	// Cross referral
	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[2]/a")
	private WebElement hospiatlNumber_CrossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[3]")
	private WebElement ipNumber_CrossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[4]")
	private WebElement patientName_CrossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[5]")
	private WebElement department_CrossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[6]")
	private WebElement gender_CrossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[7]")
	private WebElement phoneNumber_crossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[8]")
	private WebElement createdAt_CrossReferral;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table//tr[1]/td[9]")
	private WebElement transactionNumber_CrossReferral;

	// History
	@FindAll({ @FindBy(xpath = "//a[@id='HIST1']"), @FindBy(xpath = "(//a[text()='History '])[1]") })
	private WebElement historyTab;

	@FindBy(xpath = "//a[@id='0']")
	private WebElement chiefComplaint;

	@FindBy(xpath = "//a[@id='1']")
	private WebElement historyOfIllness;

	@FindBy(xpath = "//div[@id='HIST']//descendant::button[@type='button']//i[@class='zmdi zmdi-plus']")
	private WebElement historyOfIllnessPlusBtn;

	@FindBy(xpath = "//a[@id='2']")
	private WebElement pmh;

	@FindBy(xpath = "//a[@id='3']")
	private WebElement psh;

	@FindBy(xpath = "//a[@id='4']")
	private WebElement familyHx;

	@FindBy(xpath = "//a[@id='5']")
	private WebElement socialHx;

	@FindBy(xpath = "//a[@id='6']")
	private WebElement drugAnd_FoodAllergy;

	@FindBy(xpath = "//a[@id='7']")
	private WebElement currentMedication;

	@FindBy(xpath = "//a[@id='8']")
	private WebElement ros;

	@FindBy(xpath = "//a[@id='9']")
	private WebElement vitalSign_Tab;

	@FindBy(xpath = "//a[@id='10']")
	private WebElement gpe;

	@FindBy(xpath = "//a[@id='11']")
	private WebElement pastInvestigation;

	@FindBy(xpath = "//a[@id='12']")
	private WebElement provisionalDiagnosis;

	@FindBy(xpath = "//a[text()='PLAN ']")
	private WebElement plan;

	@FindAll({ @FindBy(xpath = "(//div[contains(@class,'ck ck-content')])[2]") })
	private WebElement iframe_CheifComplaintTab;

	@FindBy(xpath = "//button[text()='NEXT']")
	private WebElement nextBtnForChiefComplaint;

	@FindBy(xpath = "(//input[@placeholder='Generic Name'])[2]")
	private WebElement genericNameTextFieldInCurrentMedicationTab;

	@FindBy(xpath = "//div[@class='ng-star-inserted']//a")
	private WebElement suggestion_1;

	@FindBy(xpath = "//div[@id='HIST']//table/tbody//td[5]//span[@role='presentation']")
	private WebElement routeDropDownFieldInCurrentMedicationTab;

	@FindBy(xpath = "//div[@id='HIST']//table/tbody//td[6]//span[@role='presentation']")
	private WebElement repeatPatternDropDownFieldInCurrentMedicationTab;

	@FindBy(xpath = "//input[@placeholder='Note']")
	private WebElement startDate_CurrentMediaction;

	@FindBy(xpath = "//input[@placeholder='quantity']")
	private WebElement quantity_CurrentMediaction;

	@FindBy(xpath = "//input[@placeholder='notes']")
	private WebElement notes_CurrentMedication;

	@FindBy(xpath = "//div[@id='HIST']//table/tbody//td[last()-1]//span[@role='presentation']")
	private WebElement statusDropdown_CurrentMedication;

	@FindBy(xpath = "//div[@id='HIST']//table/tbody//td[last()]//button//i")
	private WebElement actionBtn_CurrentMediaction;

	@FindBy(xpath = "//div[@id='HIST']/descendant::button[text()=' Next ']")
	private WebElement nextBtn;

	@FindBy(xpath = "//div[@id='HIST']/descendant::button[text()=' Next ']")
	private WebElement bloodRequestTab;

	@FindBy(xpath = "(//div[@id='BLOODREQ']//i)[1]")
	private WebElement addBtn_BloodRequest;

	@FindBy(xpath = "(//div[@id='BLOODREQ']//span)[4]")
	private WebElement bloodGroupDropDownBtn_BloodRequest;

	@FindBy(xpath = "//input[@formcontrolname='daignosis']")
	private WebElement diagnosisField_BloodRequest;

	@FindBy(xpath = "(//div[@id='BLOODREQ']//span)[11]")
	private WebElement indications_BloodRequest;

	@FindBy(xpath = "//input[@formcontrolname='requiredOnDate']")
	private WebElement requiredOnDate_BloodRequest;

	@FindBy(xpath = "//input[@formcontrolname='requiredOnTime']")
	private WebElement requiredOnTime_BloodRequest;

	@FindBy(xpath = "//div[@id='BLOODREQ']//table/tbody/tr[1]/td[2]//span")
	private WebElement componentType_BloodComponent;

	@FindBy(xpath = "//div[@id='BLOODREQ']//table/tbody/tr[1]/td[3]//input")
	private WebElement requiredQuantity_BloodComponent;

	@FindBy(xpath = "//div[@id='BLOODREQ']//table/tbody/tr[1]/td[4]//button")
	private WebElement addActionBtn_BloodComponent;

	@FindBy(xpath = "//input[@formcontrolname='specimenCollectedy']")
	private WebElement specimenCollectedBy_BloodComponent;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private WebElement remarks_BloodComponent;

	@FindBy(xpath = "(//form[contains(@class,'p-0 ng-invalid')]//button)[3]")
	private WebElement submitBtn_BloodComponent;

	@FindBy(xpath = "(//div[@id='HIST']//table/tbody//input[@type='text'])[1]")
	private WebElement bp_VitalSign;

	@FindBy(xpath = "(//div[@id='HIST']//table/tbody//input[@type='text'])[5]")
	private WebElement temp_VitalSign;
	@FindBy(xpath = "//div[@id='HIST']//table/tbody//input[@placeholder='GRBS']")
	private WebElement GRBS_VitalSign;

	@FindBy(xpath = "//a[text()='VITAL SIGNS ']")
	private WebElement vitalSignsTab;
	// Vital sign
	@FindBy(xpath = "(//div[@id='HIST']//input)[1]")
	private WebElement bpText_VitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='feet']")
	private WebElement height_VitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='kg']")
	private WebElement weight_VitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='° F']")
	private WebElement temparature_VitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='Pulse']")
	private WebElement pulse_VitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='GRBS']")
	private WebElement grbs_vitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='RR']")
	private WebElement rr_VitalSign;

	@FindBy(xpath = "//div[@id='HIST']//input[@placeholder='SPO2']")
	private WebElement spo2_VitalSign;

	// Doctor progress record
	@FindBy(css = "#DPR14")
	private WebElement doctorProgressRecord_Tab;

	@FindBy(xpath = "(//div[@id='DPR']//button[@data-target='#DoctorProgressRecord']//i)[1]")
	private WebElement plusBtn_DoctorProgressRecord;

	@FindAll({ @FindBy(xpath = "//div[@id='DoctorProgressRecord']//iframe[@class='cke_wysiwyg_frame cke_reset']") })
	private WebElement iframe_DoctorProgressRecord;

	@FindBy(xpath = "(//time[@class='d-none d-md-inline-block']//b)[1]")
	private WebElement doctorProgressRecordHistory_Date;

	@FindBy(xpath = "//div[@id='DoctorProgressRecord']//button[text()=' Save ']")
	private WebElement saveButton_DoctorProgressRecord;

	// OtherNotes
	@FindBy(xpath = "//a[@id='OTNS16']")
	private WebElement otherNotesTab;

	@FindBy(xpath = "//div[@id='OTNS']//label[text()='Template Type']/..//span[@role='presentation']")
	private WebElement templateType_OtherNotes;

	@FindBy(xpath = "//div[@id='OTNS']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement iframe_OtherNotes;
//
	@FindBy(xpath = "//div[@id='OTNS']//button[text()=' Submit ']")
	private WebElement submitButton_OtherNotes;
//	
	@FindBy(xpath = "(//time[@class='d-none d-md-inline-block']//b)[1]")
	private WebElement otherNotesHistory_DateAndTime;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchBoxFieldForDropDown;

	/*
	 * Cross referral list
	 */
	@FindBy(xpath = "//a[contains(text(),'Cross-Referral List')]")
	private WebElement crossReferralTab;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[2]//a")
	private WebElement hospitalNumber_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[3]")
	private WebElement ipNumber_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[4]")
	private WebElement patientName_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[5]")
	private WebElement department_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[6]")
	private WebElement gender_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[7]")
	private WebElement phoneNumber_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[8]")
	private WebElement createdAt_Lastrow_CrossreferralList;

	@FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr[last()]/td[9]")
	private WebElement transactionNumber_Lastrow_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[2]//a") })
	private List<WebElement> hospitalNumbers_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[3]") })
	private List<WebElement> ipNumbers_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[4]") })
	private List<WebElement> patientNames_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[5]") })
	private List<WebElement> departments_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[6]") })
	private List<WebElement> genders_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[7]") })
	private List<WebElement> phoneNumbers_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[8]") })
	private List<WebElement> createdAt_CrossreferralList;

	@FindBys({ @FindBy(xpath = "//div[@id='DepartMentLitsIp']//table/tbody/tr/td[9]") })
	private List<WebElement> transactionsNumbers_CrossreferralList;

	@FindBy(xpath = "(//span[@role='presentation'])[1]")
	private WebElement servicePackageDropDown;

	@FindBys({ @FindBy(xpath = "(//table[@id='subtableid']/tbody[1]/tr/td[9]//input)[position()>1]") })
	private List<WebElement> clinicalNotesField;

	@FindBy(xpath = "(//button[text()='Submit '])[2]")
	private WebElement submitButton;

	@FindAll({ @FindBy(xpath = "(//span[@title='Doctor Name']/following-sibling::span)[3]"),
			@FindBy(xpath = "(//span[@title='Doctor Name']/following-sibling::span)[2]") })
	private WebElement assignedByDropdownBtn;

	@FindBy(xpath = "//td[text()='Pat. Arrival']/..//span[@class='switch-label arrived-checked']/following-sibling::span[1]")
	private WebElement patientArrivalBtn;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement patientArrivalPopupSaveBtn;

	@FindBy(css = "div[aria-label='Successfully Updated the patient arrival status']")
	private WebElement successfullyUpdatedThePatientArrivalStatusPopup;

	@FindBy(xpath = "//a[@id='NOTE1']")
	private WebElement notesEntryTab;

	@FindBy(xpath = "//span[@title='Select Note']/following-sibling::span[1]")
	private WebElement notesDropdownBtn;

	@FindBy(xpath = "//input[@placeholder='BP']")
	private WebElement bpText_vitalSign;

	@FindBy(xpath = "//input[@placeholder='feet']")
	private WebElement heightText_vitalSign;

	@FindBy(xpath = "//input[@placeholder='kg']")
	private WebElement weightText_vitalSign;

	@FindBy(xpath = "//input[@placeholder='° F']")
	private WebElement temperature_VitalSign;

	@FindBy(xpath = "//input[@placeholder='Pulse']")
	private WebElement pulseText_VitalSign;

	@FindBy(xpath = "//input[@placeholder='RR']")
	private WebElement rrText_VitalSign;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesButtonConfirmationPopup;

	@FindBy(xpath = "//button[text()='New ']")
	private WebElement newBtn_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "(//button[text()=' New'])[1]")
	private WebElement newBtnPopup_FinalDiagnosisProgressRecord;
	@FindBy(xpath = "//div[@id='showDia']//table/tbody/tr[1]/td[2]//input[@placeholder='Diagnosis']")
	private WebElement diagnosisText_ProgressRecordPopup;

	@FindBy(xpath = "//div[@id='showDia']//table//tr[1]//td[5]/descendant::input[@id='demo']")
	private WebElement diagnosisCommentText_ProgressRecordPopup;

	@FindBy(xpath = "//div[@id='showDia']//table//tr[1]//td[last()]//button//i")
	private WebElement diagnosisActionBtn_ProgressRecordPopup;

	@FindBy(xpath = "//table[contains(@class,'table row-border')]/tbody[1]/tr[1]/td[3]")
	private WebElement suggestion;

	@FindBy(xpath = "//div[@id='showDia']//descendant::button[text()='Submit']")
	private WebElement submitBtn_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "//div[@id='showDia']//descendant::span[text()='×']")
	private WebElement closeButton_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "//button[normalize-space(text())='OK']")
	private WebElement okButton;
	@FindBy(xpath = "//button[text()='SAVE']")
	private WebElement saveButton;

	@FindBy(xpath = "(//label[text()='Assigned By']/..//span[@role='presentation'])[2]")
	private WebElement assignedDropdownBtnReviewAndConsult;

	@FindBy(xpath = "(//button[text()='Submit '])[3]")
	private WebElement submitBtnReviewAndConsult;

	@FindBy(xpath = "//label[text()='Discharge results']/..//span[@role='presentation']")
	private WebElement dischargeResultDroddownBtn;

//----------logics------------
	public void clickOnTheNotesEntryTab(WebDriver driver) {

		scrollDownThePageUntilElementIsVisible(driver, notesEntryTab);
		notesEntryTab.click();
	}

	public void selectTheNotesInTheDropdown(WebDriver driver, String notes) throws Throwable {
		explictWaitForElementToBeVisible(driver, notesDropdownBtn);
		dropdown(driver, notesDropdownBtn, searchBoxFieldForDropDown, notes);

	}

	public void clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(WebDriver driver,
			String doctorName) throws Exception {
		Thread.sleep(1000);

		try {

			if (submitButton.isDisplayed()) {
				dropdown(driver, assignedByDropdownBtn, searchBoxFieldForDropDown, doctorName);
				submitButton.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

		try {

			if (patientArrivalBtn.isDisplayed()) {

				Thread.sleep(1500);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalBtn);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalPopupSaveBtn);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

	}

	public void clickOnUpdatedPatientArrivalStatusPopUP(WebDriver driver) throws Throwable {
		try {
			Thread.sleep(1000);
			if (successfullyUpdatedThePatientArrivalStatusPopup.isDisplayed()) {
				clickOnTheElementUsedToJavascriptExecuter(driver, successfullyUpdatedThePatientArrivalStatusPopup);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
		try {
			Thread.sleep(1000);
			if (okButton.isDisplayed()) {
				okButton.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

	}

	public void ClickOnSavebtn(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, ipdsavebtn);
	}

	public void ClickOnSubmitBtnInInvestigationTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtnInInvestigationAndProcedure);
	}

	public void scrollUp(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
	}

	public void scrollUp_1(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
		a.sendKeys(Keys.UP).build().perform();
	}

	public void scrollDown(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
	}

	public void clickOnInvestigationTab(WebDriver driver) throws Exception {

		clickOnTheElementUsedToJavascriptExecuter(driver, investigationTab);
	}

	public void clickOnPharmacyTab(WebDriver driver) throws Exception {
		scrollDownThePageUntilElementIsVisible(driver, pharmacyTab);
		pharmacyTab.click();
	}

	public void clickAddBtnInInvestigationtab(WebDriver driver) throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, addBtnInInvestigationTab);
		addBtnInInvestigationTab.click();
	}

	public void clickAddBtnInPharmacytab(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, addBtnInPharmacyTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, addBtnInPharmacyTab);
	}

	public void clickOnSubmitBtnPharmacytab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtnToaddInPharmacyTab);
	}

	public void addTheInvestigation(WebDriver driver, String notes, List<String> investigations) throws Throwable {
		scrolldown(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, addBtnInInvestigationTab);
		Thread.sleep(1000);

		for (String investigation : investigations) {
			System.out.println("Investigation: " + investigation);
			serviceDescriptionTextFieldInInvestigationTab.sendKeys(investigation);

			WebElement suggestionBox = driver.findElement(By.xpath("(//div[@class='ng-star-inserted']//a)[1]"));
			suggestionBox.click();

			clickOnTheElementUsedToJavascriptExecuter(driver, collectionDateCalenderFieldInInvestigationTab);
			collectionDateCalenderFieldInInvestigationTab.sendKeys(Keys.ENTER);
			clinicNotesInInvestigationTab.sendKeys(notes);

			clickOnTheElementUsedToJavascriptExecuter(driver, addBtnForInvestigationsInInvestigationTab);
		}

	}

	public void addTheInvestigationForLabFlow(WebDriver driver, String inv1, String notes) throws Throwable {

		scrolldown(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, addBtnInInvestigationTab);
		Thread.sleep(1000);

		serviceDescriptionTextFieldInInvestigationTab.sendKeys(inv1);

		WebElement desiredSuggestion = driver.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));

		desiredSuggestion.click();

		clickOnTheElementUsedToJavascriptExecuter(driver, collectionDateCalenderFieldInInvestigationTab);

		collectionDateCalenderFieldInInvestigationTab.sendKeys(Keys.ENTER);

		clinicNotesInInvestigationTab.sendKeys(notes);

		Thread.sleep(1000);

		clickOnTheElementUsedToJavascriptExecuter(driver, addBtnForInvestigationsInInvestigationTab);

	}

	public void scrolldown(WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void clickOnTheDoctorDeskIPDScreenButton(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, doctorDeskIPDScreenBtn);
	}

	public void searchHospitalNumber(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumberField.sendKeys(hospitalNumber);
		searchButtonIPD.click();
	}

	public void clickOnTheHospitalNumberInFirstRowInMyListTab(WebDriver driver) throws Throwable {
		Thread.sleep(5000);
		myPatientListTab.click();
		clickOnTheElementUsedToJavascriptExecuter(driver, hospitalNumberInFirstRowMyList);
	}

	public void clickOnTheDoctorDeskIPDButton(WebDriver driver) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, doctorDeskIPDBtn);
	}

	public void clickOnAllPatientListInDDIPd(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		allPatientListTab.click();
	}

	public void clickONCreatedSuccefullPopUpAfterSubmittingInPharmacyTAb(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, createdSuccesullyPopUpAfterSubmittingInPharmacyTab);
	}

	public void clickOnHospitalNumberInAllPatientListTab(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumberInFirstRowAllPatientList);
		hospitalNumberInFirstRowAllPatientList.click();
	}

	public void clickOnOtInformationTab(WebDriver driver) throws Throwable {
		clickElementWithRetries(driver, 6, otInformationTab);
		Thread.sleep(1500);
	}

	public void clickOnOtScheduleTab(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, otScheduleTab);
		otScheduleTab.click();
	}

	public String captureScheduleKeyInOtInformation(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, scheduleKey_OtInfomation);
		String scheduleKey = scheduleKey_OtInfomation.getText();
		System.out.println(scheduleKey);
		return scheduleKey;
	}

	public String captureSurgeryDateInOtInformation(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, surgerydate_OtInfomation);
		String surgeryDate = surgerydate_OtInfomation.getText();
		System.out.println(surgeryDate);
		return surgeryDate;
	}

	public String captureSurgeryTimeInOtInformation(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, surgeryTime_OtInformation);
		String surgeryTime = surgeryTime_OtInformation.getText();
		String surgeryTime1 = surgeryTime.replace(":", "");
		System.out.println(surgeryTime1);
		return surgeryTime1;
	}

	public String captureDurationInOtInformation(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, duration_OtInfomation);
		String duration = duration_OtInfomation.getText();
		String duration1 = duration.trim().split("\\.")[0];
		System.out.println(duration1);
		return duration1;
	}

	public String captureSurgeryNameInOtInformation(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, surgeryName_OtInfomation);
		String surgeryName = surgeryName_OtInfomation.getText();
		System.out.println(surgeryName);
		return surgeryName;
	}

	public String captureOperationTypeInOtInformation(WebDriver driver) throws Throwable {
		scrollTillVisibleElement(driver, operationType_OtInfomation);
		String operationType = operationType_OtInfomation.getText();
		System.out.println(operationType);
		return operationType;
	}

	public void clickOn_FinaleDiagnosis_Tab(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, finalDiagnosisTab);
		finalDiagnosisTab.click();
	}

	public void clickOn_NewButton_FinalDiagnosis(WebDriver driver) {
		plusBtn_FinalDiagnosis.click();
	}

	public void select_codeType_FinalDiagnosis(WebDriver driver, String codeType) {
		dropdown(driver, codeType_FinalDiagnosis, dropdownsText, codeType);
	}

	public void enter_ICDCode_Description_FinalDiagnosis(WebDriver driver, String codeType) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, plusBtn_FinalDiagnosis);
		Thread.sleep(1000);
		scrollDownByUsingJavascriptExecuter(driver);

		Set<String> invNames = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			String inv = "";
			do {
				inv = Final_Diagnosis[random.nextInt(Final_Diagnosis.length)];
			} while (invNames.contains(inv));

			invNames.add(inv);
			select_codeType_FinalDiagnosis(driver, codeType);
			Icd_Code_Description.sendKeys(inv);
			icd_DescriptionSuggesstion_FinalDiagnosis.click();
			clickOn_ActionButton_FinalDiagnosis(driver);
		}

	}

	public void clickOn_ActionButton_FinalDiagnosis(WebDriver driver) {
		actionBtn_FinalDiagnosis.click();
	}

	public void clickOn_SubmitBtn_FinalDiagnosis(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitButton_FinalDiagnosis);
		scrollDownThePageUntilElementIsVisible(driver, submitButton_FinalDiagnosis);
		submitButton_FinalDiagnosis.click();
	}

	public void clickOn_IpConsultant_Tab(WebDriver driver) throws Throwable {
		scrollUp(driver);
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, ipConsultationTab);
		ipConsultationTab.click();
	}

	public void plusButton_IpConsultant(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, plusBtnFor_IpConsulationTab);
		plusBtnFor_IpConsulationTab.click();
	}

	public void selectDoctotName_IpConsultant(WebDriver driver, String doctorName) {
		dropdown(driver, doctorNameDropdown_IpConsulation, dropdownsText, doctorName);
	}

	public void clickOn_ActionBtn_IpConsultant(WebDriver driver) {
		actionBtn_IpConsulationTab.click();
	}

	public void clickOn_SubmitButton_IpConsultant(WebDriver driver) {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_IpConsulationTab);
		submitBtn_IpConsulationTab.click();
	}

	public void Ip_Consultant_Process(WebDriver driver, String doctorName) {
		selectDoctotName_IpConsultant(driver, doctorName);
		serviceDescription_IpConsultant(driver, "IIIP");
		clickOn_ActionBtn_IpConsultant(driver);
		clickOn_SubmitButton_IpConsultant(driver);
	}

	public void serviceDescription_IpConsultant(WebDriver driver, String serviceDescription) {
		serviceDescriptionText_IpConsulationTab.sendKeys(serviceDescription);
		serviceDescription_Suggestion_IpConsulationTab.click();

	}

	public void clickOn_NextEncounter_Tab(WebDriver driver) {
		nextEncounterTab.click();
	}

	public void selectDate_NextEncounter(WebDriver driver) {
		scrollDownByUsingJavascriptExecuter(driver);
		date_NextEncounter.click();
	}

	public void enterSubjective_NextEncounter(WebDriver driver, String subjective) {
		subjective_Text_NextEncounter.sendKeys(subjective);
	}

	public void enter_ObjectiveText_NextEncounter(WebDriver driver, String objective) {
		objectiveText_NextEncounter.sendKeys(objective);
	}

	public void enterAssessment_NextEncounter(WebDriver driver, String assessment) {
		assessmentText_NextEncounter.sendKeys(assessment);
	}

	public void enterPlan_NextEncounter(WebDriver driver, String plan) {
		plan_Text_NextEncounter.sendKeys(plan);
	}

	public void enterInvestigation_NextEncounter(WebDriver driver, String investigation) {
		investigationText_NextEncounter.sendKeys(investigation);
	}

	public void clickOn_ActionBtn_NextEncounter(WebDriver driver) {
		actionBtn_NextEncounter.click();
	}

	public void clickOn_SubmitBtn_NextEncounter(WebDriver driver) {
		submitBtn_NextEncounter.click();
	}

	public void DietPlan_Tab(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollUp(driver);
		scrollDownThePageUntilElementIsVisible(driver, diet_Tab);
		diet_Tab.click();
	}

	public void clickOn_PlusBtn_DietPlan(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_DietPlan);
		plusBtn_DietPlan.click();
	}

	public void enter_RequestTime_DietPlan(WebDriver driver, String requestTime) {
		requestTime_DietPlan.sendKeys(requestTime);
	}

	public void select_NPO_DietPlan(WebDriver driver, String npo) {
		dropdown(driver, NPO_DropdownDietPlan, dropdownsText, npo);
	}

	public void enter_NPO_TillTime_DietPlan(WebDriver driver, String npoTillTime) {
		NPO_TillTime_DietPlan.sendKeys(npoTillTime);
	}

	public void enterRemarks_DietPlan(WebDriver driver, String remarks) throws Throwable {
		Thread.sleep(1000);
		remarks_DietPlan.sendKeys(remarks);
	}

	public void click_ActionButton_DietPlan(WebDriver driver) {
		actionBtn_DietPlan.click();
	}

	public void click_SubmitButton_DietPlan(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_DietPlan);
		submitBtn_DietPlan.click();
	}

	public void select_RTF_DietPlan(WebDriver driver, String RTF) {
		dropdown(driver, RTF_DropdownDietPlan, dropdownsText, RTF);

	}

	public void dietPlan_Process(WebDriver driver) throws Throwable {
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		// enter_RequestTime_DietPlan(driver, "1230");
		select_NPO_DietPlan(driver, "NO");
		// select_RTF_DietPlan(driver, "YES");
		dropdown(driver, dietTypeDropdownBtnDietPlan, dropdownsText, "RENAL");
		dropdown(driver, dietCategoryDropdownDietPlan, dropdownsText, "CLEAR LIQUID");
		dropdown(driver, dietSubCategoryDropdownDietPlan, dropdownsText, "GLUTEN FREE");
//		enter_NPO_TillTime_DietPlan(driver, "0130");
//		enterRemarks_DietPlan(driver, "Tested");
		quantityDietPlan.sendKeys("50");
		click_ActionButton_DietPlan(driver);
		click_SubmitButton_DietPlan(driver);
	}

	public void iFrame(WebDriver driver, String notes) throws Throwable {
		WebElement iframe = iframe_DischargeSummary;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {
			Thread.sleep(1000);
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.sendKeys(notes);
		}
		driver.switchTo().defaultContent();
	}

	public void clickOn_DischargeSummary_Tab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		dischargeSummary_Tab.click();

	}

	public void selectDischargeResult_DischargeSummary(WebDriver driver, String result) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, dischargeResultsDropdown);
		dropdown(driver, dischargeResultsDropdown, dropdownsText, result);
	}

	public void clickOn_PencilBtn_DischargeSummary(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollUp(driver);
		pencilBtn_DischargeSummary.click();
	}

	public void clickOn_Draft_DischargeSummary(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, draftBtn_DischargeSummary);
		draftBtn_DischargeSummary.click();
	}

	public void clickOnFinalize_DischargeSummary(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, finalizeBtn_DischargeSummary);
		finalizeBtn_DischargeSummary.click();
	}

	public void click_PencilButton_Or_SelectDischargeResults(WebDriver driver, String result, String notes)
			throws Throwable {
		try {
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			if (pencilBtn_DischargeSummary.isDisplayed()) {
				wait_For_Invisibilty_OfElement_ForLoader(driver);
				scrollDownThePageUntilElementIsVisible(driver, pencilBtn_DischargeSummary);
				pencilBtn_DischargeSummary.click();
				iFrame(driver, notes);

			} else {
				wait_For_Invisibilty_OfElement_ForLoader(driver);
				selectDischargeResult_DischargeSummary(driver, result);
				iFrame(driver, notes);
			}

		} catch (Exception e) {
		}

	}

	public String dischargeSummaryNotes_Text(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrolldown(driver);
		Thread.sleep(1000);
		scrollUp(driver);
		scrollUp(driver);
		String notes = "";
		try {
			if (dischargeSummary_EnteredNotes_Text.isDisplayed()) {
				notes = dischargeSummary_EnteredNotes_Text.getText();
			}
		} catch (Exception e) {

		}
		return notes;
	}

	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");
	}

	public void select_RepeatPattern(WebDriver driver, String pattern) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, repeatPatternDropDownBtnInPharmacyTab);
		dropdown(driver, repeatPatternDropDownBtnInPharmacyTab, dropdownsText, pattern);

	}

	public void enter_QuantityText_Pharmacy(WebDriver driver, String qty) {
		quantitytextFieldInPharmacyTab.sendKeys(qty);
	}

	public void select_Route_Pharmacy(WebDriver driver, String route) {
		dropdown(driver, routeDropDownFieldInPharmacyTab, dropdownsText, route);
	}

	public void enter_Notes_pharmacy(WebDriver driver, String notes) {
		notes_Pharmacy.sendKeys(notes);
	}

	public void submitButton_Pharmacy(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, submitBtnToaddInPharmacyTab);
		submitBtnToaddInPharmacyTab.click();
	}

	public void actionButton_Pharmacy(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, addBtnToaddInPharmacyTab);
		addBtnToaddInPharmacyTab.click();
	}

	public void plusButton_Pharmacy(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plusBtn_Pharmacy);
		plusBtn_Pharmacy.click();
	}

	public void descriptionText_Pharmacy(WebDriver driver, String td) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, descripriontextFieldInPharmacyTab);
		descripriontextFieldInPharmacyTab.sendKeys(td);
	}

	public void addThe_Pharmacy(WebDriver driver, String pattern, String qty, String route, String notes,
			List<String> pharmacys) throws Throwable {

		scrolldown(driver);

		for (String pharmacy : pharmacys) {
			descriptionText_Pharmacy(driver, pharmacy);

			wait_For_Invisibilty_OfElement_ForLoader(driver);
			scrollDownThePageUntilElementIsVisible(driver, descriprion_SuggestionPharmacyTab);

			wait_For_Invisibilty_OfElement_ForLoader(driver);
			descriprion_SuggestionPharmacyTab.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);

			select_RepeatPattern(driver, pattern);
			enter_QuantityText_Pharmacy(driver, qty);
			select_Route_Pharmacy(driver, route);
			enter_Notes_pharmacy(driver, notes);
			actionButton_Pharmacy(driver);
		}

		submitButton_Pharmacy(driver);
	}

	public void enterHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberText.sendKeys(hospitalNumber);
	}

	public void enter_PatientName(WebDriver driver, String patientName) {
		patientNameText.sendKeys(patientName);
	}

	public void enter_IpNumber(WebDriver driver, String ipNumber) {
		ipNumberText.sendKeys(ipNumber);
	}

	public void enter_PhoneNumber(WebDriver driver, String phoneNumber) {
		phoneNumberText.sendKeys(phoneNumber);
	}

	public void enter_AlternativePhoneNumber(WebDriver driver, String alternativePhoneNum) {
		alternativePhoneNumberText.sendKeys(alternativePhoneNum);
	}

	public void selectWardType(WebDriver driver, String wardType) {
		dropdown(driver, wardTypeDropdown, dropdownsText, wardType);
	}

	public void select_RoomType(WebDriver driver, String roomType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, roomTypeDropdown, dropdownsText, roomType);
	}

	public void enter_BedNumber(WebDriver driver, String bedNumber) {
		bedNumber_Text.sendKeys(bedNumber);
	}

	public void select_Gender(WebDriver driver, String gender) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, genderDropdown, dropdownsText, gender);

	}

	public void select_PassPotAvailable(WebDriver driver, String passport) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, passPostAvailableDropdown, dropdownsText, passport);

	}

	public void select_RegistrationFromDate(WebDriver driver, String date) {
		registrationFromDate.sendKeys(date);
	}

	public void registrationToDate(WebDriver driver, String date) {
		registrationToDate.sendKeys(date);
	}

	public void clickOn_SearchButton_Filters(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		searchButton.click();
	}

	public String capture_HospitalNumberMyList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumberInFirstRowMyList.getText();
		return hospitalNumber;
	}

	public String capturePatientName_MyList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = patientName_MyList.getText();
		String patientName = removeFirstCharacters_And_RemoveSpecialCharacters_AndSpaces(pName, 2);
		return patientName;
	}

	public String captureIpNumber_MyList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = ipNumber_MyList.getText();
		return ipNumber;
	}

	public String capturePhoneNumber_MyList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = phoneNumber_MyList.getText();
		return ipNumber;
	}

	public void select_Department_MyList(WebDriver driver, String department) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, departmentDropdown, dropdownsText, department);
	}

	public void select_WardType_MyList(WebDriver driver, String wardType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, wardTypeDropdown, dropdownsText, wardType);
	}

	public String capture_DepartmentName_MyLits(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_MyList.getText();
		return department;
	}

	public String capture_Gender(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String gender = gender_MyList.getText();
		return gender;
	}

	public String capture_HospitalNumber_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumberInFirstRowAllPatientList.getText();
		return hospitalNumber;
	}

	public String capture_PatientName_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = patientName_AllPatientList.getText();
		String patientName = removeFirstCharacters_And_RemoveSpecialCharacters_AndSpaces(pName, 2);
		System.out.println(patientName);
		return patientName;
	}

	public String capture_IpNumber_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String patientName = ipNumber_AllPatientList.getText();
		return patientName;
	}

	public String capture_IpDate_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = ipDate_AllPatientList.getText();
		return date;
	}

	public String capture_department_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_AllPatientList.getText();
		return department;
	}

	public String capture_Unit_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String unit = unit_AllPatientList.getText();
		return unit;
	}

	public String capture_Gender_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String gender = gender_AllPatientList.getText();
		return gender;
	}

	public String capture_PhoneNumber_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String phoneNumber = phoneNumber_AllPatientList.getText();
		return phoneNumber;
	}

	public String capture_TotalVisits_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String visits = totalVisits_AllPatientList.getText();
		return visits;
	}

	public String capture_Status_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String status = statu_AllPatientList.getText();
		return status;
	}

	public void clickOn_Checkbox_ShowAllFilters_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		checkbox_ShowAllFiltes_AllPatientList.click();
	}

	public void addDocumentsInDdIpd_Random(WebDriver driver) throws Throwable {
		Set<String> doc1 = new HashSet<>();
		for (int i = 0; i < 2; i++) {
			Random random = new Random();
			String doc = "";
			do {
				doc = Documents[random.nextInt(Documents.length)];
			} while (doc1.contains(doc));

			wait_For_Invisibilty_OfElement_ForLoader(driver);
			scrollDownThePageUntilElementIsVisible(driver, uploadBtn_Document);
			Thread.sleep(1000);
			uploadBtn_Document.click();
			chooseFileOptionInDocument.sendKeys(doc);
			submitButtonInDocument.click();
		}
	}

	public void clickOn_DocumenytTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, Document_Tab);
		Document_Tab.click();
	}

	public static String generateLoremIpsum(int paragraphs, int wordsPerParagraph) {
		StringBuilder loremIpsumText = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < paragraphs; i++) {
			for (int j = 0; j < wordsPerParagraph; j++) {
				int randomIndex = random.nextInt(LOREM_IPSUM_WORDS.length);
				String word = LOREM_IPSUM_WORDS[randomIndex];
				loremIpsumText.append(word).append(" ");
			}
			loremIpsumText.append("\n\n");
		}

		return loremIpsumText.toString();
	}

	public void enterDataInIframe_HistoryTabs(WebDriver driver, String data) throws Throwable {
		scrolldown(driver);
		WebElement iframe = iframe_CheifComplaintTab;
		Thread.sleep(1000);
		iframe.sendKeys(data);
	}

	public void enterDataInIframe_HistoryTabs_STRING(WebDriver driver, CharSequence TEXT) throws Throwable {
		scrolldown(driver);
		WebElement iframe = iframe_CheifComplaintTab;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {

			webElement.sendKeys(TEXT);
		}
		driver.switchTo().defaultContent();
	}

	public void clickOnNextBtn_historyTabs(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextBtnForChiefComplaint);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);
	}

	public void clickOnTheSaveButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		saveButton.click();
	}

	@FindBy(xpath = "//*[text()='History and Physical Note ']/..//descendant::span[text()='×']")
	private WebElement previewPopupCloseButton;

	public void clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		previewPopupCloseButton.click();
	}

	public void addTheFinalDiagnosis_RandomProgressRecord(WebDriver driver, String comments) throws Throwable {

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		newBtn_FinalDiagnosisProgressRecord.click();
		newBtnPopup_FinalDiagnosisProgressRecord.click();

		Set<String> FinalDiagnosis = new HashSet<>();
		scrolldown(driver);
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			String fd = "";

			do {
				fd = Final_Diagnosis[random.nextInt(Final_Diagnosis.length)];
			} while (FinalDiagnosis.contains(fd));

			FinalDiagnosis.add(fd);
			diagnosisText_ProgressRecordPopup.sendKeys(fd);

			wait_For_Invisibilty_OfElement_ForLoader(driver);
			suggestion.click();
			diagnosisCommentText_ProgressRecordPopup.sendKeys(comments);
			clickOnTheElementUsedToJavascriptExecuter(driver, diagnosisActionBtn_ProgressRecordPopup);

		}
	}

	public void clickOnTheSubmit_popupCloseFinalDiagnosisProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		submitBtn_FinalDiagnosisProgressRecord.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		closeButton_FinalDiagnosisProgressRecord.click();
	}

	public void clickOnTheYesButton_ConfirmationPopup(WebDriver driver) {
		try {
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			yesButtonConfirmationPopup.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void enterDataInVitalSign(WebDriver driver, String bp, String height, String weight, String c, String pulse,
			String rr) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToBottom(driver);
		bpText_vitalSign.sendKeys(bp);
		heightText_vitalSign.sendKeys(height);
		weightText_vitalSign.sendKeys(weight);
		pulseText_VitalSign.sendKeys(pulse);
		rrText_VitalSign.sendKeys(rr);
	}

	public void clickOnHistoryTabs(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, historyTab);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, historyTab);
	}

	public void clickOnChiefComplaintTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, chiefComplaint);
		chiefComplaint.click();
	}

	public void clickOnHistoryOfIlnessTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, historyOfIllness);
		historyOfIllness.click();
	}

	public void clickOnPmhTab(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pmh);
		pmh.click();
	}

	public void clickOnPshTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, psh);
		psh.click();
	}

	public void clickOnFamilyHx(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, familyHx);
		familyHx.click();

	}

	public void clickOnSocialHx(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, socialHx);
		socialHx.click();
	}

	public void clickOnDrugAndFoodAllergy(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, drugAnd_FoodAllergy);
		drugAnd_FoodAllergy.click();
	}

	public void clickOnRosTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, ros);
		ros.click();
	}

	public void clickOnGpeTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, gpe);
		gpe.click();
	}

	public void clickOnPastInvestigationTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pastInvestigation);
		pastInvestigation.click();
	}

	public void clickOnProvisionalDiagnosisTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, provisionalDiagnosis);
		provisionalDiagnosis.click();

	}

	public void clickOnPlanTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, plan);
		plan.click();
	}

	public void addTheCurrentMedication(WebDriver driver, String route, String pattern, String date, String qty,
			String notes, String status, List<String> currentMedications) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);

		for (String currentMedication : currentMedications) {
			genericNameTextFieldInCurrentMedicationTab.sendKeys(currentMedication);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			suggestion_1.click();
			dropdown(driver, routeDropDownFieldInCurrentMedicationTab, dropdownsText, route);
			dropdown(driver, repeatPatternDropDownFieldInCurrentMedicationTab, dropdownsText, pattern);
			startDate_CurrentMediaction.sendKeys(date);
			quantity_CurrentMediaction.sendKeys(qty);
			notes_CurrentMedication.sendKeys(notes);
			scrollDownThePageUntilElementIsVisible(driver, statusDropdown_CurrentMedication);
			dropdown(driver, statusDropdown_CurrentMedication, dropdownsText, status);
			actionBtn_CurrentMediaction.click();
		}
	}

	public void clickOnCurrentMedicationTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, currentMedication);
	}

	public void clickOnNextBtn_currentMedication(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextBtn);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtn);
	}

	public void clickOn_VitalSignTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		vitalSign_Tab.click();
	}

	public void vitalSign_Process(WebDriver driver, String bp, String height) {
		bpText_VitalSign.sendKeys(bp);
		height_VitalSign.sendKeys(height);
		weight_VitalSign.sendKeys(height);
		temparature_VitalSign.sendKeys(height);
		pulse_VitalSign.sendKeys(height);
		grbs_vitalSign.sendKeys(height);
		rr_VitalSign.sendKeys(height);
		spo2_VitalSign.sendKeys(height);
	}

	public void enterData_InTheDoctorProgressRecord_CkEditor(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		plusBtn_DoctorProgressRecord.click();
		scrolldown(driver);
		WebElement iframe = iframe_DoctorProgressRecord;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {
			String text = generateLoremIpsum(5, 100);
			webElement.sendKeys(text);
		}
		driver.switchTo().defaultContent();
	}

	public void clickOn_DoctorProgressRecordTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, doctorProgressRecord_Tab);
		doctorProgressRecord_Tab.click();
	}

	public void clickOn_SaveButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, saveButton_DoctorProgressRecord);
		saveButton_DoctorProgressRecord.click();
	}

	public String capture_DoctorProgressRecord_Date(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = doctorProgressRecordHistory_Date.getText();
		return date;
	}

	public void selectTemplateType_OthersNotes(WebDriver driver, String templateType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, templateType_OtherNotes, dropdownsText, templateType);
	}

	public void selectTemplateType_enterData_InTheOtherNotes_CkEditor(WebDriver driver, String templateType)
			throws Throwable {
		selectTemplateType_OthersNotes(driver, templateType);
		scrolldown(driver);
		WebElement iframe = iframe_OtherNotes;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {
			String text = generateLoremIpsum(5, 100);
			webElement.sendKeys(text);
		}
		driver.switchTo().defaultContent();
	}

	public void clickOn_OtherNotesTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, otherNotesTab);
		otherNotesTab.click();
	}

	public void clickOn_SubmitButton_OtherNotes(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitButton_OtherNotes);
		scrollTillVisibleElement(driver, submitButton_OtherNotes);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		submitButton_OtherNotes.click();

	}

	public String capture_DateAndTime_OtherNotesHistory(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String date = otherNotesHistory_DateAndTime.getText();
		return date;
	}

	public String captureLastRow_HospitalNumber_CrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_Lastrow_CrossreferralList.getText();
		return hospitalNumber;
	}

	public String captureLastRow_IpNumber_CrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = ipNumber_Lastrow_CrossreferralList.getText();
		return ipNumber;
	}

	public String captureLastRow_patientName_CrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = patientName_Lastrow_CrossreferralList.getText();
		String patientName = removeFirstCharacters_And_RemoveSpecialCharacters_AndSpaces(pName, 2);
		return patientName;
	}

	public String captureLastRow_Department_CrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String department = department_Lastrow_CrossreferralList.getText();
		return department;
	}

	public String captureLastRow_CreatedAt_CrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String createdAt = createdAt_Lastrow_CrossreferralList.getText();
		return createdAt;
	}

	public String captureLastRow_PhoneNumber_CrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String phoneNumber = phoneNumber_Lastrow_CrossreferralList.getText();
		return phoneNumber;
	}

	public String captureLastRow_TransactionsNumberCrossReferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String transactionNumber = transactionNumber_Lastrow_CrossreferralList.getText();
		return transactionNumber;
	}

	public void capture_AndVerify_hospitalNumbers_CrossreferralList(WebDriver driver, String hospitalNumber1) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		for (WebElement string : hospitalNumbers_CrossreferralList) {
			String hospitalNumber = string.getText();
			Assert.assertEquals(hospitalNumber, hospitalNumber1);
		}

	}

	public void clickOn_CrossReferralTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		crossReferralTab.click();
	}

	public String capture_PatientName_CrossreferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String pName = patientName_CrossReferral.getText();
		String patientName = removeFirstCharacters_And_RemoveSpecialCharacters_AndSpaces(pName, 2);
		return patientName;
	}

	public String capture_IpNumber_CrossreferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = ipNumber_CrossReferral.getText();
		return ipNumber;
	}

	public String capture_PhoneNumber_CrossreferralList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ipNumber = phoneNumber_crossReferral.getText();
		return ipNumber;
	}

	public void clickOn_ClearButton_Filters(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clearButton.click();
	}

	public void captureTotalList_Genders_CrossreferralList(WebDriver driver, String gender1) {
		for (WebElement string : genders_CrossreferralList) {
			String gender = string.getText();
			Assert.assertEquals(gender1, gender);
		}

	}
//	
//	public void select_DischargeRadioButton_AllPatientList(WebDriver driver) {
//		wait_For_Invisibilty_Of_Loader(driver, 200);
//		radio
//	}

	public String capture_PhoneNumber_LastRow_AllpatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String phoneNumber = phoneNumber_LasatRow_AllPatientList.getText();
		return phoneNumber;
	}

	public void clickOnBloodRequestTab(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, bloodRequestTab);
	}

	public void selectBloodGroup_BloodRequest(WebDriver driver, String text) throws Throwable {
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, bloodGroupDropDownBtn_BloodRequest);
		dropdown(driver, bloodGroupDropDownBtn_BloodRequest, dropdownsText, text);
	}

	public void enterDiagnosis_BloodRequest(WebDriver driver, String diagnosis) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		diagnosisField_BloodRequest.sendKeys(diagnosis);
	}

	public void selectIndications_BloodRequest(WebDriver driver, String text) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, indications_BloodRequest);
		dropdown(driver, indications_BloodRequest, dropdownsText, text);
	}

	public void enterRequiredOnDate_BloodRequest(WebDriver driver, String date) {
		requiredOnDate_BloodRequest.sendKeys(date);
	}

	public void enterRequiredOnTime_BloodRequest(WebDriver driver, String time) {
		requiredOnTime_BloodRequest.sendKeys(time);
	}

	public void selectComponenetType_BloodRequest(WebDriver driver, String text) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, componentType_BloodComponent);
		dropdown(driver, componentType_BloodComponent, dropdownsText, text);
	}

	public void enterRequiredQuantity_BloodRequest(WebDriver driver, String qty) {

		requiredQuantity_BloodComponent.sendKeys(qty);
	}

	public void clickOnAddBtn_BloodComponenet(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, addActionBtn_BloodComponent);
		moveToTheParticularElementAndClick(driver, addActionBtn_BloodComponent);
	}

	public void clickOnAddBtn_BloodRequest(WebDriver driver) throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, addBtn_BloodRequest);
		moveToTheParticularElementAndClick(driver, addBtn_BloodRequest);
	}

	public void enterSpecimenCollectedBy_BloodRequest(WebDriver driver, String text) {
		scrollDownThePageUntilElementIsVisible(driver, specimenCollectedBy_BloodComponent);
		specimenCollectedBy_BloodComponent.sendKeys(text);
	}

	public void enteremarks_BloodRequest(WebDriver driver, String text) {
		scrollDownThePageUntilElementIsVisible(driver, remarks_BloodComponent);
		remarks_BloodComponent.sendKeys(text);
	}

	public void clickOnSubmit_BloodRequest(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_BloodComponent);
		moveToTheParticularElementAndClick(driver, submitBtn_BloodComponent);
	}

	public void selectIndications_BloodRequest_Random(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, indications_BloodRequest);
		Random random = new Random();
		String ind = Indications[random.nextInt(Indications.length)];
		Thread.sleep(500);
		dropdown(driver, indications_BloodRequest, dropdownsText, ind);

	}

	public void selectComponenetType_BloodRequest_Random(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, componentType_BloodComponent);
		Random random = new Random();
		String comp = componentType[random.nextInt(componentType.length)];
		Thread.sleep(500);
		dropdown(driver, componentType_BloodComponent, dropdownsText, comp);
	}

	public void selectBloodGroup_BloodRequest_Random(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, bloodGroupDropDownBtn_BloodRequest);
		Random random = new Random();
		String group = bloodGroup[random.nextInt(bloodGroup.length)];
		Thread.sleep(1000);
		dropdown(driver, bloodGroupDropDownBtn_BloodRequest, dropdownsText, group);
	}

	public void clickOnClearButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clearButton.click();
	}

	public void vitalSigns_History(WebDriver driver, String bp, String height, String weight, String temp, String pulse)
			throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToBottom(driver);

		bp_VitalSign.sendKeys(bp);
		height_VitalSign.sendKeys(height);
		weight_VitalSign.sendKeys(weight);
		temp_VitalSign.sendKeys(temp);
		pulse_VitalSign.sendKeys(pulse);
		GRBS_VitalSign.sendKeys("123");
		rr_VitalSign.sendKeys("321");
		spo2_VitalSign.sendKeys("543");
		clickOnNextBtn_currentMedication(driver);
	}

	public void selectServiePackage_Investigation(WebDriver driver, String text) {
		dropdown(driver, servicePackageDropDown, searchBoxFieldForDropDown, text);
	}

	public void enterClinicalNotes_listOfWebElement(WebDriver driver, String text) throws Throwable {
		for (WebElement webElement : clinicalNotesField) {
			scrollDownThePageUntilElementIsVisible(driver, webElement);
			webElement.sendKeys(text);
		}

	}

	public void clickOnPatientArrivalBtn(WebDriver driver, String doctorName) throws Exception {
		Thread.sleep(1000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		try {
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			if (submitButton.isDisplayed()) {
				dropdown(driver, assignedByDropdownBtn, searchBoxFieldForDropDown, doctorName);
				submitButton.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

		try {
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			if (patientArrivalBtn.isDisplayed()) {
				wait_For_Invisibilty_OfElement_ForLoader(driver);
				Thread.sleep(1500);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalBtn);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalPopupSaveBtn);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

	}

	public String capturePatternText_FirstRowDrugAdministration() {
		return patternText_firstRow_drugAdministration.getText();
	}

	public void clickOnVitalSignsTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, vitalSignsTab);
	}
}
