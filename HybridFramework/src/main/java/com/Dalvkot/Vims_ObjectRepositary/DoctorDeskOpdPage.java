package com.Dalvkot.Vims_ObjectRepositary;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class DoctorDeskOpdPage extends WebDriverUtility {

	public DoctorDeskOpdPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Lab investgation

	private static final String[] INVForLab_NAMES = {

			"AUTOMATION LIPID PROFILEPANEL", "AUTOMATION 24 HRS URINE MICROALBUMIN", "AUTOMATION ANALYSIS",
			"AUTOMATION ANALYSIS SELECTED", "AUTOMATION ANCA PANEL", "AUTOMATION ATL",
			"AUTOMATION COMPLETE BLOOD COUNT", "AUTOMATION LIPID PROFILEPANEL", " AUTOMATION NASAL SMEAR DC",
			"AUTOMATION SPOT URINARY MICROALBUMIN", "AUTOMATION TEST AMMONIA", };

	private static final String[] INV_NAMES = {

			"ENDOLOOP APPLICATION PROCEDURE CHARGES", "DIRECT BILIRUBIN", "INDIRECT BILIRUBIN", "QUADRUPLE TEST",
			"25 OH VITAMIN-D", "VITAMIN B12", "SPECIFIC GRAVITY", "SWAB- AUTOMATED CULTURE & SENSITIVITY",
			"SPOT URINE  CALCIUM", "URINE- ZN STAIN FOR AFB", "URINE-  FUNGAL STAIN / KOH", "MAGNESIUM",
			"24 HOURS URINE MAGNESIUM", "IMAGE GUIDED BREAST CLIP MARKER PALACEMENT", "SPOT URINE  CALCIUM",
			"24 HOURS URINARY CALCIUM", "24 HRS URINE MICRO PROTEIN", "URINE- GRAM STAIN", "URINE- ZN STAIN FOR AFB",
			"SPOT URINE SODIUM", "SODIUM (NA+)", "24 HRS URINE SODIUM", "CSF SODIUM", "GLUCOSE - FASTING",
			"GLUCOSE RANDOM", "GLUCOSE - POSTPRANDIAL", "ASCITIC GLUCOSE", "SYNOVIAL FLUID GLUCOSE",
			"SPOT URINE  GLUCOSE", "ATHORMONE(PTH INTACT)", "TIAL THROMBOPLASTIN TIME", "11Q23 OR LSI MLL GENE BREAK A",
			"T, FISH 11Q23 BREAKA", "T (PERIPHERAL BLOOD)", "T, FISH 11Q23 BREAKA", "11Q23 OR LSI MLL GENE BREAK A",
			"14Q32.3 OR LSI MLL GENE BREAKA", "SERUM PROTEIN ELECTROPHO", "SERUM PROTEIN ELECTROPHO",
			"URINE ELECTROPHO", "PLATELET PH", "H FROZEN PLASMA", "PLASMAPHE", "PEMETREXED/CARBOOPLATIN (OR CISPLATIN)",
			"HEPATITIS B VACCINATION (VYDEHI STAFF-BOOSTER)", "SPOT URINARY MICROALBUMIN",
			"24 HOURS URINARY PHOSPHOROUS", "GAMMA GLUTAMYL TRANSFERASE", "KNEE RADIOFREQUENCY ABLATION",
			"RADIOFREQUENCY ABLATION LEVEL 1", "SMEAR FOR MALARIA PARASITE", "RADIOFREQUENCY ABLATION LEVEL 1",
			"MAGNESIUM", "H1N1(swine flu)-Qualitative", "PROGESTERONE", "PROTHROMBIN TIME PANEL",
			"FNAC FINE NEEDLE ASPIRATION CYTOLOGY", "SERUM PREALBUMIN", "ASCITIC CELL TYPE", "HSV-2 IGM ELISA",
			"IUI-INTRAUTERINE INSEMINATION", "test", "GLUCOSE - FASTING", "CT CALCIUM SCORING",
			"MRI FULL STUDY (ANY ONE REGION)", "ULTRA SOUND" };

	private static final String[] prescription_Names = { "DOLOWIN SPAS TABLETS", "DOLONEX 2ML INJECTION",
			"DOLO (GLASS BOTTLE) 100ML", "LACOSAMIDE 100MG TABLETS", "OPTIUM NEO H GLUCOSE TEST STRIP",
			"CANDID V3 TABLET", "CANDID EAR DROPS", "FACE MASK N95", "DISPOLINE GLOVES LARGE", "DISPOLINE GLOVES SMALL",
			"DISPOLINE GLOVES MEDIUM", "EXCELA MAX 200G CREAM", "TAZLOC BETA 25MG", "TAZLOC CT 40MG TABLETS",
			"BOTULINUM TOXIN TYP A 50UNITS (INJECTION)",

	};

	private static final String[] Final_Diagnosis = { "cholera, unspecified", "cholera due to", "PARATYPHOID FEVER A",
			"PARATYPHOID FEVER B", "PARATYPHOID FEVER C", "SALMONELLA ENTER", "BUBONIC PLAGUE", "CELLULOCU",
			"OTHER FORMS OF PLAGUE", "OTHER FORMS OF ANTHRAX", "OTHER FORMS OF LEPROSY",
			"SHIGELLOSIS DUE TO SHIGELLA BOYDII", "SHIGELLOSIS DUE TO SHIGELLA SONNEI",
			"SHIGELLOSIS DUE TO SHIGELLA FLEXNERI", "ISOSPORIASIS", "CRYPTOSPORIDIOSIS" };

	private static final String[] Documents = { "src\\main\\resources\\Documents\\d1.PNG",
//			"D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\d2.png",
//			"D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\d3.PNG",
//			"D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\d4.PNG",
//			"D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\d5.PNG",
//			"D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\doc1.PDF",
//			"D:\\Automation Testing\\VIMS-automation\\src\\main\\resources\\Documents\\image (95).png",
			"src\\main\\resources\\Documents\\image (96).png" };

	private static final String[] LOREM_IPSUM_WORDS = { "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur",
			"adipiscing", "elit", "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore",
			"magna", "aliqua", "Ut", "enim", "ad", "minim", "veniam", "quis", "nostrud", "exercitation", "ullamco",
			"laboris", "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "Duis", "aute", "irure", "dolor",
			"in", "reprehenderit", "in", "voluptate", "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla",
			"pariatur", "Excepteur", "sint", "occaecat", "cupidatat", "non", "proident", "sunt", "in", "culpa", "qui",
			"officia", "deserunt", "mollit", "anim", "id", "est", "laborum" };

	// -----------------------------xpaths------------------------------------------------------------

	@FindBy(xpath = "//span[text()=' Doctor Desk OPD ']")
	private WebElement doctorDeskScreenBtn;

	@FindBy(xpath = "//b[text()='Patient Management']")
	private WebElement patientManagement;

	@FindBy(xpath = "//a[@id='mypatientTab']")
	private WebElement myPatientListtabBtn;

	@FindBy(xpath = "//a[@href='#AllPatientList']")
	private WebElement allPatientListtabBtn;

	@FindBy(xpath = "//a[@href='#FollowUpPatientList']")
	private WebElement followPatientListtabBtn;

	@FindBy(xpath = "//a[@href='#MyNextEncounterList']")
	private WebElement myNextEncounterListtabBtn;

	@FindBy(xpath = "//div[@id='OPD']//button[text()=' Search ']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//input[@placeholder='Hospital Number'])[1]")
	private WebElement hospitalNumberTextField;

	@FindBy(xpath = "(//input[@placeholder='Hospital Number'])[1]")
	private WebElement hospitalNumberText_MyPatientList;

	@FindBy(xpath = "//div[@id='OPD']/descendant::input[@placeholder='Patient Name']")
	private WebElement patientNameTextField;

	@FindBy(xpath = "//div[@id='OPD']/descendant::input[@placeholder='Phone Number']")
	private WebElement phonenumbertextField;

	@FindBy(xpath = "//div[@id='OPD']/descendant::input[@placeholder=' AlternativePhone Number']")
	private WebElement alternativePhoneNumbertextField;

	@FindBy(xpath = "(//input[@formcontrolname='regnDate'])[1]")
	private WebElement registrationFromDateField;

	@FindBy(xpath = "//input[@min='regnDate']")
	private WebElement registrationToDatefield;

	@FindBy(xpath = "//div[@id='OPD']/descendant::input[@placeholder='Visit Number']")
	private WebElement vistNumberTextfield;

	@FindBy(xpath = "//span[@title='Consultation Status']/following-sibling::span[1]")
	private WebElement consultationDropDownField;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchBoxFieldForDropDown;

	@FindBy(xpath = "//div[@aria-label='No data for  Patient List']")
	private WebElement noDataErrorPopUpForAllPatientListTab;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[2]/a[@class='badge badge-success']")
	private WebElement hospitalNumberInTheList_Row1;

	@FindBys({
			@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr/td[2]/a[@class='badge badge-success']") })
	private List<WebElement> hospitalNumbersInTheTable;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[4]/p[@class='a']")
	private WebElement patientNameInTheList_Row1;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement phoneNumberInTheList_Row1;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement visitNumberInTheList_Row1;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement genderInTheList_Row1;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement consultationStatusInTheList_Row1;

	@FindBy(xpath = "/html/body/app-root/app-home/app-doctor-desk/section/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div/pagination-controls/pagination-template/ul/li[7]/a")
	private WebElement nextPageBtn;

	@FindBy(xpath = "//div[@id='MyList']//table//tr[1]/td[2]/descendant::a")
	private WebElement hospitalNumberInFirstRow_MyPatientList;

	@FindBy(xpath = "//a[@id='HIST1']")
	private WebElement historyTab;

	@FindBy(xpath = "//a//b[text()='Investigation/Procedure']")
	private WebElement investigationsProcedureTab;

	@FindAll({ @FindBy(xpath = "//a[@id='Dia6']"), @FindBy(xpath = "//a[.='Final Diagnosis']") })
	private WebElement finalDiagnosisTab;

	@FindAll({ @FindBy(xpath = "//a[@id='PRE3']"), @FindBy(xpath = "//a[.='Prescription']") })
	private WebElement prescriptionTab;

	@FindBy(xpath = "//a[.='Next Encounter']")
	private WebElement nextEncounterTab;

	@FindAll({ @FindBy(xpath = "//a[@id='DOC8']"), @FindBy(xpath = "//a[.='Documents']") })
	private WebElement documentsTab;

	@FindBy(xpath = "//b[text()='CURRENT MEDICATION']")
	private WebElement currentMedicationTabUnderHistory;

	@FindBy(xpath = "//div[@id='INV']/descendant::i[@class='zmdi zmdi-plus'][1]")
	private WebElement newBtnIninvestigationsProcedureTab;

	@FindBy(xpath = "//div[@id='Dia']/descendant::button[text()=' New']//i")
	private WebElement newBtnInFinalDiagnosisTab;

	@FindBy(xpath = "//div[@id='PRE']/descendant::i[@class='zmdi zmdi-plus'][1]")
	private WebElement newBtnInprescriptionTab;

	@FindBy(xpath = "//div[@id='DOC']/descendant::button[@type='button']")
	private WebElement uploadBtnInDocumentTab;

	@FindBy(xpath = "//input[@id='file']")
	private WebElement chooseFileOptionInDocumentsTab;

	@FindBy(xpath = "//table[@id='diagnosisId']/tbody/tr[1]/td[2]/descendant::input[@type='text']")
	private WebElement serviceNameTextFieldIninvestigationsProcedureTab;

	@FindBy(xpath = "//table[@id='diagnosisId']/tbody/tr[1]/td[4]/descendant::input[@placeholder='Quantity']")
	private WebElement qtyTextFieldIninvestigationsProcedureTab;

	@FindBy(xpath = "//table[@class='table table-responsive-md text-center']/tbody/tr[1]/td[2]/descendant::span[@role='textbox']")
	private WebElement finalDiagnosisDropDownInFinalDiagnosisTab;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchBoxForDropDownInFinalDiagnosisTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[4]/descendant::input[@placeholder='Generic Name']")
	private WebElement genericNameTextFieldInPrescriptionTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[5]/descendant::span[@class='select2-selection__arrow']")
	private WebElement selectPatternDropDownInPrescriptionTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[6]/descendant::input[@placeholder='Duration']")
	private WebElement durationTextFieldInPrescriptionTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[7]/descendant::span[@class='select2-selection__arrow']")
	private WebElement routeDropDownInPrescriptionTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[8]/descendant::input[@placeholder='Quantity']")
	private WebElement quantityTextFieldInPrescriptionTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[9]/descendant::input[@placeholder='Note']")
	private WebElement notesTextFieldInPrescriptionTab;

	@FindBy(xpath = "//input[@placeholder='Investigation']")
	private WebElement investigationsTextFieldInNextEncounterTab;

	@FindBy(xpath = "//input[@id='symptoms']")
	private WebElement adviceTextFieldInNextEncounterTab;

	@FindBy(xpath = "(//input[@aria-label='Generic Name'])[2]")
	private WebElement genericNameTextFieldInCurrentMedicationTab;

	@FindBy(xpath = "(//span[@title='Select']/following-sibling::span)[1]")
	private WebElement routeDropdownBtn;

	@FindBy(xpath = "//span[@title='Select Pattern ']/following-sibling::span[1]")
	private WebElement repeatPatternDropDownBtn;

	@FindBy(xpath = "//input[@placeholder='Start Date']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@placeholder='quantity']")
	private WebElement quantityText;

	@FindBy(xpath = "//input[@placeholder='notes']")
	private WebElement notesText;

	@FindBy(xpath = "//span[@title='Select Status ']/following-sibling::span[1]")
	private WebElement statusDropDown;

	@FindBy(xpath = "//table[@id='diagnosisId']/tbody/tr[1]/td[7]/descendant::input[@placeholder='Note']")
	private WebElement noteTextFieldIninvestigationsProcedureTab;

	@FindBy(xpath = "//div[@id='Dia']//table//tr[1]//td[5]/descendant::input[@id='demo']")
	private WebElement commentsTextFieldInFinalDiagnosisTab;

	@FindBy(xpath = "(//table[@id='diagnosisId']/tbody/tr[1]/td[last()]/descendant::button[@type='button'])[1]")
	private WebElement addButtonIninvestigationsProcedureTab;

	@FindBy(xpath = "//div[@id='Dia']//table//tr[1]//td[last()]/descendant::button[@type='button']")
	private WebElement addButtonInFinalDiagnosisTab;

	@FindBy(xpath = "//table[@class='table table-responsive row-border hover']/tbody/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement addButtonInprescriptionTab;

	@FindBy(xpath = "//div[@id='NEXEN']/descendant::I[@class='zmdi zmdi-plus']")
	private WebElement addButtonInNextEncounterTab;

	@FindBy(xpath = "(//table[contains(@class,'table table-responsive-md')]//button)[1]")
	private WebElement addButtonInCurrentMedicationTab;

	@FindBy(xpath = "(//button[text()='Submit'])[1]")
	private WebElement submitButtonIninvestigationsProcedureTab;

	@FindBy(xpath = "//div[@id='Dia']/descendant::button[@class='btn btn-primary btn-round btn-sm']")
	private WebElement submitButtonInFinalDiagnosisTab;

	@FindBy(xpath = "//div[@id='PRE']/descendant::button[text()='Submit']")
	private WebElement submitButtonInPrescriptionTab;

	@FindBy(xpath = "//div[@id='NEXEN']/descendant::button[@class='btn btn-primary btn-round btn-sm']")
	private WebElement submitButtonInNextEncounterTab;

	@FindBy(xpath = "//button[@id='closeUpload']")
	private WebElement submitButtonInDocumentTab;

	@FindBy(xpath = "//div[@id='HIST']/descendant::i[@class='zmdi zmdi-card-sd']")
	private WebElement nextButtonInCurrentMedicationTab;

	@FindBy(css = "iframe[title='Editor, editor1']")
	private WebElement iframe_historyTab;

	@FindAll({ @FindBy(xpath = "//iframe[@title='Rich Text Editor, editor1']"),
			@FindBy(css = "iframe[title='Editor, editor1']") })
	private WebElement iframe_historyOfIllnessTab;

	@FindBy(css = "body[aria-label='Editor, editor1']")
	private WebElement historyTabsTextArea;

	@FindBy(css = "body[aria-label='Editor, editor1']")
	private WebElement historyOfIllnessTabTextArea;

	@FindBy(xpath = "//a[@id='0']")
	private WebElement chiefComplaintTab;

	@FindBy(xpath = "//a[@id='1']")
	private WebElement historyOfIllnessTab;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-save'])[1]")
	private WebElement nextBtnForChiefComplaint;

	@FindBy(xpath = "(//span[@data-on='Yes']/following-sibling::span)[1]")
	private WebElement patientArrivalBtn;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement patientArrivalPopupSaveBtn;

	@FindBy(xpath = "//I[@class='zmdi zmdi-edit']")
	private WebElement editBtnInChiefComplaintTab;

	@FindBy(xpath = "//div[@id='HIST']/descendant::i[@class='zmdi zmdi-delete']")
	private WebElement deleteBtnInChiefComplaintTab;

	@FindBy(xpath = "//button[@class='swal2-confirm btn btn-success']")
	private WebElement deletePopupInChieftCompaintTab;

	@FindBy(css = "div[aria-label='Created Successfully']")
	private WebElement CreatedSuccessfullyPopUp;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement successfullyUpdatedThePatientArrivalStatusPopup;

	@FindBy(css = "div[aria-label='Deleted Successfully']")
	private WebElement deletedSuccessfullyPopup;

	@FindBy(xpath = "//div[@class='ng-tns-c45-1 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-success']")
	private WebElement createdSuccessfullyPopupInFinalDiagnosis;

	@FindBy(css = "div[aria-label='Successfully document Is Uploaded']")
	private WebElement documentUploadedSuccessfullyPopUp;

	@FindBy(xpath = "//div[@aria-label='created successfully']")
	private WebElement createdSuccessfullyPopUPAfterSubmitingInvestigations;

	@FindBy(xpath = "//div[@class='ng-tns-c45-4 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-success']")
	private WebElement createdSuccessfullyPopUPAfterSubmitingprescription;

	@FindBy(xpath = "//a[@id='2']")
	private WebElement pmhTabUnderHistory;

	@FindBy(xpath = "//a[@id='3']")
	private WebElement pshTabUnderHistory;

	@FindBy(xpath = "//a[@id='4']")
	private WebElement familyHxTabUnderHistory;

	@FindBy(xpath = "//a[@id='5']")
	private WebElement socialHxTabUnderHistory;

	@FindBy(xpath = "//a[@id='6']")
	private WebElement drugAndFoodAllergyTabUnderHistory;

	@FindBy(xpath = "//a[@id='8']")
	private WebElement rosTabUnderHistory;

	@FindBy(xpath = "//a[@id='10']")
	private WebElement gpeTabUnderHistory;

	@FindBy(xpath = "//a[.='PAST INVESTIGATION']")
	private WebElement pastInvestigationsTabUnderHistory;

	@FindBy(xpath = "//a[.='LAB']")
	private WebElement labTab;

	@FindBy(xpath = "//a[@id='12']")
	private WebElement provisionalDiagnosiTabUnderHistory;

	@FindBy(xpath = "//a[.='PLAN']")
	private WebElement planTabUnderHistory;

	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement nextBtnForPagination;

	@FindBy(xpath = "//div[@id='INV']/descendant::table[@id='example'][1]/tbody/tr/td[8]")
	private WebElement investogationAmountFieldInTable;

	@FindBy(xpath = "//td[text()='Investigation : ']/following-sibling::td")
	private WebElement invAmounIntheHeaderSection;

	@FindBy(xpath = "//a[@id='BIL9']")
	private WebElement billsTabs;

	@FindBy(xpath = "//td[text()='Consultation Charges : ']/following-sibling::td")
	private WebElement consultationAmounIntheHeaderSection;

	@FindBy(xpath = "//input[@placeholder='Rate Amount']")
	private WebElement rateAmountDisabledTextFieldInInvestigation;

	@FindBy(xpath = "//a[@id='RES6']")
	private WebElement labRadResultTab;

	@FindBy(xpath = "//div[@id='RES0001']/descendant::table[@id='example']/tbody/tr[1]/td[1]")
	private WebElement sampleNumberInTheTable_LabTab;

	@FindBy(xpath = "//div[@id='RES0001']/descendant::table[@id='example']/tbody/tr[1]/td[3]")
	private WebElement serviceClassInTheTable_LabTab;

	@FindBy(xpath = "//div[@id='RES0001']/descendant::table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement serviceNameInTheTable_LabTab;

	@FindBy(xpath = "//div[@id='RES0001']/descendant::table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement patientValueInTheTable_LabTab;

	@FindBy(xpath = "//div[@id='RES0001']/descendant::table[@id='example']/tbody/tr[1]/td[7]")
	private WebElement referenceRangeInTheTable_LabTab;

	@FindBy(xpath = "//div[@id='AllPatientList']//table//tr[1]/td[3]/descendant::a")
	private WebElement hospitalNumberInTable_allPatientList;

	@FindBy(xpath = "//a[@id='OTI4']")
	private WebElement otInformationTab;

	@FindBy(xpath = "//a[contains(text(),'OT Scheduling')]")
	private WebElement otScheduletab;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[2]/descendant::a")
	private WebElement hospitalnumberInTable_AllpatientList;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorText;

	@FindBy(xpath = "//div[@id='Dia']//table//tr[1]//td[2]//input[@placeholder='Diagnosis']")
	private WebElement diagnosistext_FinalDiagnosis;

	@FindBy(xpath = "//table[contains(@class,'table row-border')]/tbody[1]/tr[1]/td[3]")
	private WebElement suggestion;

	@FindBy(xpath = "//input[@placeholder='Subjective']")
	private WebElement subjectiveText_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Objective']")
	private WebElement objectiveText_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Assessment']")
	private WebElement assessmentText_NextEncounter;

	@FindBy(xpath = "//input[@placeholder='Plan']")
	private WebElement planText_NextEncounter;

	@FindBy(xpath = "//table[@id='diagnosisId']/tbody/tr[1]/td//input[@placeholder='Comments']")
	private WebElement remarksText_NextEncounter;

	@FindAll({ @FindBy(xpath = "//a[@id='OTNS11']"), @FindBy(xpath = "//a[@id='OTNS12']") })
	private WebElement otherNotesTab;

	@FindBy(xpath = "//div[@id='OTNS']/div[1]/div[1]/div[1]/div[1]/button[1]/i[1]")
	private WebElement newBtn_OtherNotesTab;

	@FindBy(xpath = "(//div[@id='OTNS']//span[@class='select2-selection__arrow'])[1]")
	private WebElement templateType_otherNotesTab;

	@FindAll({ @FindBy(xpath = "//div[@id='OTNS']//iframe[@class='cke_wysiwyg_frame cke_reset']") })
	private WebElement iframe_OtherNotesTab;

	@FindBys({ @FindBy(css = "body.cke_editable.cke_editable_themed") })
	private List<WebElement> otherNotesTextArea;

	@FindBy(xpath = "(//div[@id='OTNS']//button[@type='button'])[3]")
	private WebElement submitBtn_OtherNotesTab;

	@FindBys({ @FindBy(xpath = "(//div[contains(@class,'ck ck-content')])[1]") })
	private List<WebElement> iframe_CheifComplaintTab;

	@FindBy(xpath = "(//button[text()=' Submit'])[2]")
	private WebElement submitBtn_historyTabs;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']//a)[1]")
	private WebElement suggestion_1;

	@FindBy(xpath = "//button[text()=' Next']")
	private WebElement nextBtn;

	@FindBy(xpath = "//a[.='VITAL SIGNS']")
	private WebElement vitalSignsTab;

	@FindBy(xpath = "//b[text()='ASSESSMENT / PLAN']")
	private WebElement assessmentPlanTab;

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

	@FindBy(xpath = "//input[@placeholder='SPO2']")
	private WebElement spo2Text_VitalSign;

	@FindAll({ @FindBy(xpath = "//div[@id='PRGR']//iframe[@class='cke_wysiwyg_frame cke_reset']") })
	private WebElement iframe_ProgressRecord;

	@FindBy(xpath = "//a[@id='PRGR7']")
	private WebElement progressRecordTab;

	@FindBy(xpath = "//button[text()='Sign']")
	private WebElement signBtn;

	@FindBy(xpath = "(//button[@id='viewSignButton']//i)[1]")
	private WebElement signBtn_DeathNote;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-file-text'])[1]")
	private WebElement draftBtn_DeathNote;

	@FindBy(xpath = "//li[@class='item ng-star-inserted'][1]")
	private WebElement suggestionBox;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-edit'])[1]")
	private WebElement editBtn_prescription;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[1]")
	private WebElement genericName_table_prescription;

	@FindBy(xpath = "//div[text()='Not found']")
	private WebElement notFoundText;

	@FindBy(xpath = "(//input[@type='date'])[4]")
	private WebElement dateField_ProgressRecord;

	@FindBy(xpath = "//input[@type='time']")
	private WebElement timeField_ProgressRecord;

	@FindBy(xpath = "(//time[@class='d-none d-md-inline-block'])[1]")
	private WebElement dateAndTime_sideList;

	@FindBy(xpath = "//button[text()='Draft']")
	private WebElement draftBtn;

	@FindBy(xpath = "(//div[@class='media']//div)[1]")
	private WebElement progressRecordDetail_FirstProgressRecord;

	@FindBy(xpath = "//label[@class='ng-star-inserted']")
	private WebElement status_ProgressRecordDetails;

	@FindBy(xpath = "(//div[@id='printDetails']//div)[15]")
	private WebElement dateAndTime_print_visitDetails;

	@FindBy(xpath = "//a[@id='ENC0']")
	private WebElement visitDetails;

	@FindBys({ @FindBy(xpath = "(//div[@id='INV']//descendant::table[@id='example'])[1]//tr//td[8]") })
	private List<WebElement> listOfTotalAmout_Investigation;

	@FindBys({ @FindBy(xpath = "//div[@id='Dia']//table[@id='example']/tbody[1]/tr/td[3]") })
	private List<WebElement> listOfDiagnosis_FinalDiagnosis;

	@FindBy(xpath = "//button[text()='View More.. ']")
	private WebElement viewMoreBtn;

	@FindBys({ @FindBy(xpath = "//div[@id=\"finalDiagModal\"]//table/tbody/tr/td[2]") })
	private List<WebElement> listOfDiagnosis_ViewMore;

	@FindBy(xpath = "//td[text()='Investigation : ']/following-sibling::td")
	private WebElement investigationAmount_BillingDetails;

	@FindBy(xpath = "//button[@data-target='#CrossReferral']")
	private WebElement crossReferralBtn;

	@FindBy(xpath = "//div[@id='CrossReferral']//label[text()='Department']/..//span[@role='presentation']")
	private WebElement departmentDropDownBtn_CrossReferral;

	@FindBy(xpath = "//div[@id='CrossReferral']//label[text()=' Doctor ']/..//span[@role='presentation']")
	private WebElement doctorDropDownBtn_CrossReferral;

	@FindBy(xpath = "//textarea[@formcontrolname='reason']")
	private WebElement reasonArea_CrossReferral;

	@FindBy(xpath = "(//button[@id='closeModal'])[2]")
	private WebElement requestBtn_CrossReferral;

	@FindBy(xpath = "//div[@id='AllPatientList']//table/tbody/tr[1]/td[6]")
	private WebElement department_Table_AllPatientList;

	@FindBy(xpath = "//button[text()=' Move OP to IP ']")
	private WebElement moveOpToIpBtn;

	@FindBy(xpath = "//div[@id='modal']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement iframe_MoveOpToIp;

	@FindBy(xpath = "//span[@title='Ward Type']/following-sibling::span")
	private WebElement wardTypeDropDownBtn_MoveOpToIp;

	@FindBy(xpath = "(//span[@title='Department']/following-sibling::span)[2]")
	private WebElement departmentDropDownBtn_MoveOpToIp;

	@FindBy(xpath = "(//span[@title='Doctor']/following-sibling::span)[2]")
	private WebElement admittedUnderDrDropDown_MoveOpToIp;

	@FindBy(xpath = "(//span[@title='Unit']/following-sibling::span)[2]")
	private WebElement unitDrDropDown_MoveOpToIp;

	@FindBy(xpath = "//span[@title='admittedBy']/following-sibling::span[1]")
	private WebElement admittedByDrDropDown_MoveOpToIp;

	@FindBy(xpath = "//button[@id='closeModalIp']")
	private WebElement submitBtn_MoveOpToIp;

	@FindBy(xpath = "(//button[text()=' Clear '])[1]")
	private WebElement clearBtn;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[last()]/td[2]/descendant::a")
	private WebElement hospitalnumberInTable_AllpatientList_LastRow;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	private WebElement showAllFilter_CheckBox;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientName_Table_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[last()]/td[4]")
	private WebElement patientName_Table_AllPatientList_LastRow;

	@FindBy(xpath = "//div[@id='AllPatientList']//table/tbody/tr[last()]/td[6]")
	private WebElement department_Table_AllPatientList_LastRow;

	@FindBy(xpath = "(//span[@title='Department Name']/following-sibling::span)[1]")
	private WebElement departmentDropDownBtn;

	@FindBy(xpath = "//div[@id='AllPatientList']//table/tbody/tr[last()]/td[7]")
	private WebElement unit_Table_AllPatientList_LastRow;

	@FindBy(xpath = "//div[@id='AllPatientList']//table/tbody/tr[last()]/td[7]")
	private WebElement unit_Table_AllPatientList;

	@FindBy(xpath = "(//span[@title='Unit']/following-sibling::span)[1]")
	private WebElement unitDropDownBtn;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement visitNumberInTheList_LastRow;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[last()]/td[12]")
	private WebElement consultationStatusInTheList_LastRow;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[12]")
	private WebElement consultationStatusInTheList;

	@FindBys({ @FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr/td[10]") })
	private List<WebElement> listOfMobileNumber_Table_AllPatientList;

	@FindBy(xpath = "//div[@id='AllPatientList']/descendant::table/tbody/tr[1]/td[10]")
	private WebElement phoneNumber_Table_allPatientList;

	@FindBy(xpath = "//div[@id='MyList']/descendant::table/tbody/tr[1]/td[4]")
	private WebElement patientNameInFirstRow_MyPatientList;

	@FindBy(xpath = "//div[@id='MyList']/descendant::table/tbody/tr[1]/td[9]")
	private WebElement phoneNumber_table_MyPatientList;

	@FindBy(xpath = "//div[@id='MyList']/descendant::table/tbody/tr[last()]/td[5]")
	private WebElement visitNumber_LastRow_MypatientList;

	@FindBy(xpath = "//div[@id='MyList']/descendant::table/tbody/tr[1]/td[5]")
	private WebElement visitNumber_MypatientList;

	@FindBy(xpath = "//div[@id='MyList']/descendant::table/tbody/tr[1]/td[11]")
	private WebElement consultationStatus_Table_MyPatientList;

	@FindBy(xpath = "//a[contains(text(),'RADIOLOGY')]")
	private WebElement radiologyTab_LabRadResultTab;

	@FindBy(xpath = "//td[text()='1']/following-sibling::td")
	private WebElement transactionNumber_table_radiology;

	@FindBy(xpath = "(//td[text()='1']/following-sibling::td)[3]")
	private WebElement serviceClass_table_radiology;

	@FindBy(xpath = "(//td[text()='1']/following-sibling::td)[4]")
	private WebElement serviceName_table_radiology;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement okBtnText;

	@FindAll({ @FindBy(xpath = "//button[text()='OK']") })
	private WebElement okBtn;

	@FindBy(xpath = "//label[@class='clearfix']//span[1]")
	private WebElement patientAriivalDatAndTime;

	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[9]")
	private WebElement templateDropDownBtn;

	@FindBy(xpath = "//i[@class='zmdi zmdi-edit']")
	private WebElement editBtn_Action_Prescription;

	@FindBy(xpath = "//button[text()=' Update']")
	private WebElement updateBtn;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[2]")
	private WebElement repeatPattern_Table_Prescription;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[3]")
	private WebElement route_Table_Prescription;

	@FindBy(xpath = "(//td[@class='ng-star-inserted']/following-sibling::td)[3]")
	private WebElement duration_Table_Prescription;

	@FindBy(xpath = "(//td[@class='ng-star-inserted']/following-sibling::td)[4]")
	private WebElement quantity_Table_Prescription;

	@FindBy(xpath = "(//td[@class='ng-star-inserted']/following-sibling::td)[5]")
	private WebElement notes_Table_Prescription;

	@FindBy(xpath = "(//div[@id='PRE']//table/tbody//td[5]//span[@class='select2-selection__arrow'])[2]")
	private WebElement selectPatternDropDownInPrescriptionTab_Edit;

	@FindBy(xpath = "(//td[@class='ng-star-inserted']//input)[1]")
	private WebElement durationTextFieldInPrescriptionTab_Edit;

	@FindBy(xpath = "(//div[@id='PRE']//table/tbody//td[6]//span[@class='select2-selection__arrow'])[1]")
	private WebElement routeDropDownInPrescriptionTab_Edit;

	@FindBy(xpath = "(//td[@class='ng-star-inserted']//input)[2]")
	private WebElement quantityTextFieldInPrescriptionTab_Edit;

	@FindBy(xpath = "(//td[@class='ng-star-inserted']//input)[3]")
	private WebElement notesTextFieldInPrescriptionTab_Edit;

	@FindBys({ @FindBy(xpath = "//table[contains(@class,'table table-bordered')]/tbody[1]/tr[position()>1]/td[2]") })
	private List<WebElement> listOfDiagnosis_MoveOpToIp;

	@FindBy(xpath = "(//td[text()='Police Station']/following-sibling::td)[2]")
	private WebElement policeStation_MlcDetails;

	@FindBy(xpath = "(//td[text()='Police Station']/following-sibling::td)[5]")
	private WebElement broughtBy_MlcDetails;

	@FindBy(xpath = "(//td[text()='Police Station']/following-sibling::td)[8]")
	private WebElement contactName_MlcDetails;

	@FindBy(xpath = "(//td[text()='Contact Number']/following-sibling::td)[2]")
	private WebElement contactNumber_MlcDetails;

	@FindBy(xpath = "(//td[text()='Contact Number']/following-sibling::td)[5]")
	private WebElement broughtDate_MlcDetails;

	@FindBy(xpath = "(//table//tr[1])[6]")
	private WebElement mlcType_MlcDetails;

	@FindBy(xpath = "//span[text()='Allergies ']/following-sibling::div")
	private WebElement allergies;

	@FindBy(xpath = "//table[contains(@class,'table table-visit')]/tr[2]/td[2]")
	private WebElement dept_Header;

	@FindBy(xpath = "//table[contains(@class,'table table-visit')]/tr[3]/td[2]")
	private WebElement unit_Header;

	@FindBy(xpath = "(//strong[text()='Progress Record '])[1]")
	private WebElement progressRecord_Text;

	@FindBy(xpath = "//button[text()='Draft and Continue']")
	private WebElement draftAndContinueButton;

	@FindBy(xpath = "(//button[text()='Draft and Continue']/following-sibling::button)[2]")
	private WebElement cancelBtn;

	@FindBy(xpath = "//a[contains(text(),'Fetch Patient Details')]")
	private WebElement fetchPatientDetails;

	@FindBy(xpath = "//input[@placeholder='Hospital Number']")
	private WebElement hospitalNumbetTextField_FetchPatientDetails;

	@FindBy(xpath = "//label[text()='OP Number']/..//span[@role='presentation']")
	private WebElement opNumberDropDownBtn_FetchPatientDetails;

	@FindBy(xpath = "//label[text()='Visit Number']/..//span[@role='presentation']")
	private WebElement visitNumberDropDownBtn_FetchPatientDetails;

	@FindBy(xpath = "//button[text()=' Fetch Details']")
	private WebElement fetchDetailsBtn;

	@FindBy(xpath = "//td[text()='#Hosp : ']/following-sibling::td")
	private WebElement hospitalNumber_PatientDetails;

	@FindBy(xpath = "//td[text()='Age : ']/following-sibling::td")
	private WebElement age_patientDetails;

	@FindBy(xpath = "(//li[@class='list-group-item doctor-desk-li']//div)[1]")
	private WebElement sideList_VisitDetails;

	@FindBy(xpath = "//button[text()='Print']")
	private WebElement printBtn_VisitDetails;

	@FindBy(xpath = "(//span[@class='switch-label'])[2]")
	private WebElement insuranceToggleButton_MoveOpToIp;

	@FindBy(xpath = "//label[text()='Customer list']/..//span[@role='presentation']")
	private WebElement customerListDropDownBtn;

	@FindBy(xpath = "//label[text()=' Insurance Type']/..//span[@role='presentation']")
	private WebElement insuranceTypeDropDownBtn;

	@FindBy(xpath = "(//div/..//h3)[1]")
	private WebElement patientMovedToIpText;

	@FindBy(xpath = "//input[@placeholder='Review Revisit After']")
	private WebElement date_NextEncounter;

	@FindBy(xpath = "(//label[text()='Next Encounter From Date1']/following::input)[1]")
	private WebElement nextEncounterFromDateField;

	@FindBy(xpath = "//div[@id='MyNextEncounterList']/descendant::table/tbody/tr[1]/td[2]")
	private WebElement hospitalNumber_MyNextEncounter_table;

	@FindBy(xpath = "//li//div[@class='ng-star-inserted']//a")
	private WebElement prescriptionSuggestion;

	@FindBy(xpath = "(//span[@title='Select'])[1]")
	private WebElement servicePackageDropDown;

	@FindBys({ @FindBy(xpath = "(//table[@id='diagnosisId']/tbody[1]/tr/td[7]//input)[position()>1]") })
	private List<WebElement> clinicalNotesField;

	@FindAll({ @FindBy(xpath = "(//span[@title='Doctor Name']/following-sibling::span)[1]"),
			@FindBy(xpath = "(//span[@title='Doctor Name']/following-sibling::span)[2]") })
	private WebElement assignedByDropdownBtn;

	/*
	 * Enhancements
	 * 
	 */

	@FindBy(xpath = "//a[@id='NOTE1']")
	private WebElement notesEntryTab;

	@FindBy(xpath = "//span[@title='Select Note']/following-sibling::span[1]")
	private WebElement notesDropdownBtn;

	@FindBy(xpath = "//button[@id='viewSignButton']//ancestor::div[@class='modal-content']//descendant::button[@aria-label='Close']")
	private WebElement closeButtonPreviewPopup;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesButtonConfirmationPopup;

	@FindBy(xpath = "(//button[text()='Yes']//following::button[text()='No'])[1]")
	private WebElement noButtonConfirmationPopup;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-save'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//button[text()='New ']")
	private WebElement newBtn_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "(//button[text()=' New'])[1]")
	private WebElement newBtnPopup_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "(//input[@placeholder='Diagnosis'])[1]")
	private WebElement diagnosisText_ProgressRecordPopup;

	@FindBy(xpath = "//div[@id='showDia']//table//tr[1]//td[5]/descendant::input[@id='demo']")
	private WebElement diagnosisCommentText_ProgressRecordPopup;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[5]/button[1]")
	private WebElement diagnosisActionBtn_ProgressRecordPopup;

	@FindBy(xpath = "//table[@id='example']/tbody[1]/tr[1]/td[5]/button[1]")
	private WebElement addBtn_FinalDiagnosis;

	@FindBy(xpath = "//div[@id='showDia']//descendant::button[text()='Submit']")
	private WebElement submitBtn_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "//div[@id='showDia']//descendant::span[text()='×']")
	private WebElement closeButton_FinalDiagnosisProgressRecord;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement previewPopupCloseButton;

	@FindBy(xpath = "(//span[text()='×'])[3]")
	private WebElement editPopupCloseButton;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]/td[2]")
	private WebElement noteName_visitDetails_1stRow;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]/td[3]")
	private WebElement doctorName_visitDetails_1stRow;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]/td[4]")
	private WebElement department_visitDetails_1stRow;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]/td[5]")
	private WebElement signDate_visitDetails_1stRow;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]/td[6]")
	private WebElement notesEntryDate_visitDetails_1stRow;

	@FindBy(xpath = "//button[@id='viewSignButton']//i[1]")
	private WebElement signBtnPopUP;

	@FindBy(xpath = "//button[@id='viewSignButton']//i[1]")
	private WebElement signBtnPopUP_PG;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']//h5)[2]")
	private WebElement viewPopUp;

	@FindBy(xpath = "//button[text()=' Actions ']")
	private WebElement actoinBtn_VisitDetails;

	@FindBy(xpath = "//button[text()=' VIEW ']")
	private WebElement viewBtn_VisitDetails;

	@FindBy(xpath = "//button[text()=' DELETE ']")
	private WebElement deleteBtn_VisitDetails;

	@FindBy(xpath = "(//button[text()=' EDIT '])[1]")
	private WebElement editBtn_VisitDetails;

	@FindBy(xpath = "//button[text()=' SIGN OR EDIT ']")
	private WebElement signOrEditBtn_VisitDetails;

	@FindBy(xpath = "//button[text()=' COPY & CREATE ']")
	private WebElement copyAndCreate_VisitDetails;

	@FindBy(xpath = "(//h4[text()='Delete Documents']/.//following::button[@type='submit'])[1]")
	private WebElement deleteBtn;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-delete'])[2]")
	private WebElement deleteBtn_deletePopUp;

	@FindBy(xpath = "(//button[text()='SUBMIT'])[3]")
	private WebElement deleteBtn_popup_VisiDetails;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-edit'])[1]")
	private WebElement pencilIcon_Edit_VisitDetail;

	@FindBy(xpath = "//i[@class='zmdi zmdi-edit']")
	private List<WebElement> pencilIcon_Edit_VisitDetail_List;

	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteBtnPpoUp;

	@FindBy(xpath = "//span[@class='ng-star-inserted']/following-sibling::span//descendant::*[@data-icon='save']")
	private WebElement saveIconAfterEdit;

	@FindBy(xpath = "(//h5[@class='ng-star-inserted'])[1]")
	private WebElement editedData_1st_popup;

	@FindBy(xpath = "(//label[text()='Fetch Latest Data ']/following::i)[1]")
	private WebElement fetchLatestDataBtn;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']//span)[3]")
	private WebElement xIcon_Edit;

	@FindBy(xpath = "(//span[@title='Doctor Name']/following-sibling::span)[1]")
	private WebElement coSignDoctor_DropDown;

	@FindBy(xpath = "(//input[@name='check'])[1]")
	private WebElement iHaveSeenCheckbox;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]/td[1]//span[@class='flashingAlert']")
	private WebElement redColorAlert;

	@FindBy(xpath = "//button[text()='REJECT']")
	private WebElement rejectBtn_PopUp;

	@FindBy(xpath = "//textarea[@placeholder='Reject Reason']")
	private WebElement rejectReasonTextArea;

	@FindBy(xpath = "(//button[text()='SUBMIT'])[1]")
	private WebElement submitBtn_RejectReason;

	@FindBy(xpath = "(//textarea[@placeholder='Delete Reason'])[3]")
	private WebElement deleteReasonTextArea_RejectedNotes;

	@FindBy(xpath = "(//i[@class='zmdi zmdi-delete'])[1]")
	private WebElement deleteBtn_RejectedNotesPopUp;

	@FindBy(xpath = "(//div[@id='ENC']/..//following::table)[3]/tbody/tr[2]")
	private WebElement Row1_VisitDetails;

	@FindBy(xpath = "//label[text()='Assigned By']")
	private WebElement assignedByText;

	@FindBy(xpath = "(//img[@title='Upload Documents'])[1]")
	private WebElement uploadDocumentIcon;

	@FindBy(xpath = "//button[@data-target='#largeModalMainDocument' and text()='Upload']")
	private WebElement uploadBtn_DocumentTab;

	@FindBy(xpath = "//div[@id='largeModalMainDocument']//input[@id='file']")
	private WebElement chooseFile;

	@FindBy(xpath = "//div[@id='largeModalMainDocument']//button[@id='closeUpload']")
	private WebElement submitBtn_DocumentUpload;

	@FindBy(xpath = "(//table[@id='table']/tbody[1]/tr[1]/td[2])[1]")
	private WebElement documentDescription_Table_DocumentUpload;

	@FindBy(xpath = "(//table[@id='table']/tbody[1]/tr[1]/td[3])[1]")
	private WebElement uploadDate_Table_DocumentUpload;

	@FindBy(xpath = "(//table[@id='table']/tbody[1]/tr[1]/td[4])[1]")
	private WebElement doctorName_Table_DocumentUpload;

	@FindBy(xpath = "//img[@title='Upload Documents']/.//following::*[@data-icon='eye']")
	private WebElement viewIcon_Table_DocumentUpload;

	@FindBy(xpath = "(//table[@id='table']/tbody[1]/tr[1]/td[last()]//i[@class='zmdi zmdi-delete'])[1]")
	private WebElement deleteIcon_Table_DocumentUpload;

	@FindBy(xpath = "(//h4[text()='Delete Documents']/.//following::textArea[@formcontrolname='reasonDelete'])[1]")
	private WebElement reasonTextArea_DocumentUpload_DeletePopUp;

	@FindBy(xpath = "(//h4[text()='Delete Documents']/.//following::button[@type='submit'])[1]")
	private WebElement submitBtn_DocumentUpload_DeletePopUp;

	@FindBy(xpath = "(//table[@id='table'])[1]/tbody[1]/tr")
	private List<WebElement> documentRows;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']/.//following::table/tbody/tr[1]/td[2])[1]")
	private WebElement documentDescription_table_view;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']/.//following::table/tbody/tr[1]/td[3])[1]")
	private WebElement uploadedDate_table_view;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']/.//following::table/tbody/tr[1]/td[4])[1]")
	private WebElement doctorName_table_view;

	@FindBy(xpath = "//span[contains(text(),'PAST INVESTIGATION')]//i[@class='zmdi zmdi-edit']")
	private WebElement pencilEditIcon_PastInvestigation;

	@FindBy(xpath = "//span[contains(text(),'LAB')]//i[@class='zmdi zmdi-edit']")
	private WebElement pencilEditIcon_labTab;

	// -------Buissness Logics--------

	public void clickOnThePatientManagementLink(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, patientManagement);
	}

	public void clickOnTheDoctorDeskOpdScreenButton(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, doctorDeskScreenBtn);
	}

	public void clickOnMyPatientListTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, myPatientListtabBtn);
	}

	public void clickOnAllPatientListTab(WebDriver driver) {
		allPatientListtabBtn.click();

	}

	public void clickOnFolllowPatientListTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, followPatientListtabBtn);
	}

	public void clickOnMyNextEncounterListTab(WebDriver driver) {
		myNextEncounterListtabBtn.click();
	}

	public void enterTheHospitalNumber(WebDriver driver, String hospitalNumber) {
		hospitalNumberTextField.sendKeys(hospitalNumber);

	}

	public void enterThePatientName(WebDriver driver, String patientName) {
		patientNameTextField.sendKeys(patientName);
	}

	public void enterThePhoneNumber(WebDriver driver, String phoneNumber) {
		phonenumbertextField.sendKeys(phoneNumber);
	}

	public void enterThevisitNumber(WebDriver driver, String visitNumber) {
		vistNumberTextfield.sendKeys(visitNumber);
	}

	public void enterTheConsultaionStatus(WebDriver driver, String cs) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, consultationDropDownField, searchBoxFieldForDropDown, cs);
	}

	public void clickOnSearchBtn(WebDriver driver) {
		searchBtn.click();
	}

	public void ClickOnErrorPopupInAllPatientListTab(WebDriver driver) throws Throwable {
		noDataErrorPopUpForAllPatientListTab.click();
		Thread.sleep(1000);
	}

	public String HospitalNumberInTable_Row1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumberRow_1 = hospitalNumberInTheList_Row1.getText();
		return hospitalNumberRow_1;

	}

	public String patientNameInTable_Row1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String patientNameInTheList = patientNameInTheList_Row1.getText();
		return patientNameInTheList;

	}

	public String phoneNumberInTable_Row1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String patientNameInTheList = phoneNumberInTheList_Row1.getText();
		return patientNameInTheList;

	}

	public String visitNumberInTable_Row1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String visitnumberInTheList = visitNumberInTheList_Row1.getText();
		return visitnumberInTheList;

	}

	public String genderInTable_Row1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String genderInTheList = genderInTheList_Row1.getText();
		return genderInTheList;
	}

	public String consultationStatusInTable_Row1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String consultationStatusInTheList = consultationStatusInTheList_Row1.getText();
		return consultationStatusInTheList;
	}

	public void scrollDownTillBottom(WebDriver driver) {
		scrollTillVisibleElement(driver, nextPageBtn);

	}

	public void enterFromDate(String regFromDate) {
		registrationFromDateField.sendKeys(regFromDate);
	}

	public void verifyTheHospitalNumber(WebDriver driver) {
		String textToVerify = "8196933";

		for (int page = 1; page <= 5; page++) {

			// List<WebElement> elements= hospitalNumbersInTheTable;

			if (driver.getPageSource().contains(textToVerify)) {
				System.out.println("Text found on " + page);
			} else {
				System.out.println("Text not found on " + page);
			}
		}
		driver.findElement(By.xpath(
				"/html/body/app-root/app-home/app-doctor-desk/section/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div/pagination-controls/pagination-template/ul/li[8]/a"))
				.click();
	}

	public void clickOnHospitalNumberInTheMyPatientList(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumberText_MyPatientList.clear();
		hospitalNumberText_MyPatientList.sendKeys(hospitalNumber);
		waitForElementWithCustomTimeOut(driver, searchBtn, 5);
		searchBtn.click();
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumberInFirstRow_MyPatientList);
		hospitalNumberInFirstRow_MyPatientList.click();
		Thread.sleep(300);
	}

	public void enterTextInHistoryTabs(WebDriver driver, String historyText) throws Throwable {

		clickOnTheElementUsedToJavascriptExecuter(driver, chiefComplaintTab);
		Thread.sleep(1000);
		WebElement iframe = iframe_historyTab;
		driver.switchTo().frame(iframe);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		nextBtnForChiefComplaint.click();

		clickOnTheElementUsedToJavascriptExecuter(driver, historyOfIllnessTab);
		Thread.sleep(1000);
		WebElement iframe1 = iframe_historyTab;
		driver.switchTo().frame(iframe1);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		nextBtnForChiefComplaint.click();

		clickOnTheElementUsedToJavascriptExecuter(driver, pmhTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe2 = iframe_historyTab;
		driver.switchTo().frame(iframe2);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		nextBtnForChiefComplaint.click();

		clickOnTheElementUsedToJavascriptExecuter(driver, pshTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe3 = iframe_historyTab;
		driver.switchTo().frame(iframe3);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, familyHxTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe4 = iframe_historyTab;
		driver.switchTo().frame(iframe4);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, socialHxTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe5 = iframe_historyTab;
		driver.switchTo().frame(iframe5);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, drugAndFoodAllergyTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe6 = iframe_historyTab;
		driver.switchTo().frame(iframe6);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, rosTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe7 = iframe_historyTab;
		driver.switchTo().frame(iframe7);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, gpeTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe8 = iframe_historyTab;
		driver.switchTo().frame(iframe8);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, pastInvestigationsTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe9 = iframe_historyTab;
		driver.switchTo().frame(iframe9);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, provisionalDiagnosiTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe10 = iframe_historyTab;
		driver.switchTo().frame(iframe10);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

		clickOnTheElementUsedToJavascriptExecuter(driver, planTabUnderHistory);
		Thread.sleep(1000);
		WebElement iframe11 = iframe_historyTab;
		driver.switchTo().frame(iframe11);
		// explicityWaitForElemenToBeClickable(driver, historyTabsTextArea);
		historyTabsTextArea.sendKeys(historyText);
		driver.switchTo().defaultContent();
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

	}

	public void enterTextInhistoryOfIllnessTab(WebDriver driver, String historyOfIllnessTabtext) {

		// explicityWaitForElemenToBeClickable(driver, iframe_historyTab);
		WebElement iframe = iframe_historyTab;
		driver.switchTo().frame(iframe);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		historyOfIllnessTabTextArea.sendKeys("historyOfIllnessTabtext");
		driver.switchTo().defaultContent();

	}

	public void enterTextInPmhTab(WebDriver driver, String historyOfIllnessTabtext) {

		// explicityWaitForElemenToBeClickable(driver, iframe_historyTab);
		WebElement iframe = iframe_historyTab;
		driver.switchTo().frame(iframe);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		historyOfIllnessTabTextArea.sendKeys("historyOfIllnessTabtext");
		driver.switchTo().defaultContent();

	}

	public void zoomOutTheScreen(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");

	}

	public void clickOnNextButtonForCheifComplaintTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);

	}

	@FindBy(xpath = "(//button[text()='Submit '])[2]")
	private WebElement submitButton;

	public void clickOnPatientArrivalBtnAndSave(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		// wait_For_Invisibilty_Of_Loader(driver, 200);
		try {
			// wait_For_Invisibilty_Of_Loader(driver, 200);
			if (patientArrivalBtn.isDisplayed()) {
				// wait_For_Invisibilty_OfElement_ForLoader(driver);
				// explicityWaitForElemenToBeClickable(driver, patientArrivalBtn);
				Thread.sleep(1500);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalBtn);
				// explicityWaitForElemenToBeClickable(driver, patientArrivalPopupSaveBtn);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalPopupSaveBtn);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

	}

	public void clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(WebDriver driver,
			String doctorName) throws Exception {
		Thread.sleep(5000);
		// wait_For_Invisibilty_Of_Loader(driver, 200);
		try {
			// wait_For_Invisibilty_Of_Loader(driver, 300);

			if (assignedByText.isDisplayed()) {
				dropdown(driver, assignedByDropdownBtn, searchBoxFieldForDropDown, doctorName);
				submitButton.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

		try {
//			wait_For_Invisibilty_Of_Loader(driver, 200);

			if (patientArrivalBtn.isDisplayed()) {
				// wait_For_Invisibilty_OfElement_ForLoader(driver);
				// explicityWaitForElemenToBeClickable(driver, patientArrivalBtn);
				Thread.sleep(1500);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalBtn);
				// explicityWaitForElemenToBeClickable(driver, patientArrivalPopupSaveBtn);
				clickOnTheElementUsedToJavascriptExecuter(driver, patientArrivalPopupSaveBtn);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

	}

	public void scrollUp(WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(1000);
	}

	public void scrolldown(WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

	public void clickOnChiefComplaintTab(WebDriver driver) {
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, chiefComplaintTab);
		chiefComplaintTab.click();
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnHistoryOfIlnessTab(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, historyOfIllnessTab);
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		historyOfIllnessTab.click();
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnEditBtnInChiefComplaintTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, editBtnInChiefComplaintTab);

	}

	public void clickOnDeleteBtnInChiefComplaintTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteBtnInChiefComplaintTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, deletePopupInChieftCompaintTab);
	}

	public void clickOnCreatedSuccessfullyPopUp(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, CreatedSuccessfullyPopUp);
		Thread.sleep(1000);

	}

	public void clickOnUpdatedPatientArrivalStatusPopUP(WebDriver driver) throws Throwable {
		try {
			Thread.sleep(1000);
			clickOnTheElementUsedToJavascriptExecuter(driver, successfullyUpdatedThePatientArrivalStatusPopup);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

		try {
			Thread.sleep(1000);
			clickOnOkBtn(driver);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	public void clickOnDeletedSuccessfullyPopUP(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, deletedSuccessfullyPopup);
	}

	public void clickOnInvestigationTab(WebDriver driver) throws Throwable {
//		explicitWaitElementToBeClickabl(driver, investigationsProcedureTab);
		Thread.sleep(2500);
		clickOnTheElementUsedToJavascriptExecuter(driver, investigationsProcedureTab);
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnNewBtnInInvestigationTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, newBtnIninvestigationsProcedureTab);

	}

	public void clickOnSubmitBtnInPharmacyTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, submitButtonInPrescriptionTab);
	}

	public void clickOnCreatedSuccesfullyPopUpMsgInPrescription(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, submitButtonInPrescriptionTab);
	}

	public void enterDataInInvestigationAndProcedureTab(WebDriver driver, String serviceName, String notes)
			throws Throwable {
		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(serviceName);
		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(Keys.DOWN, Keys.ENTER);
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

	}

	public void addTheInvestigations(WebDriver driver, String notes) throws Throwable {

		Set<String> invNames = new HashSet<>();
		scrolldown(driver);
		for (int i = 0; i < 18; i++) {
			Random random = new Random();
			String inv = "";

			do {
				inv = INV_NAMES[random.nextInt(INV_NAMES.length)];
			} while (invNames.contains(inv));

			invNames.add(inv);
			serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(inv);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebElement suggestionBox = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
			WebElement desiredSuggestion = suggestionBox
					.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
			desiredSuggestion.click();
			noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
			Thread.sleep(2000);
			clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

		}

	}

	public void addTheInvestigationsForLab(WebDriver driver, String notes) throws Throwable {

		scrolldown(driver);
		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("SPOT URINARY MICROALBUMIN");

		WebElement desiredSuggestion = driver.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		Thread.sleep(1000);
		desiredSuggestion.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("MAGNESIUM");
		Thread.sleep(1000);
		WebElement desiredSuggestion1 = driver.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion1.click();

		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("AMMONIA");
		WebElement desiredSuggestion2 = driver.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion2.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("AMYLASE");
		Thread.sleep(1000);
		WebElement desiredSuggestion3 = driver.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion3.click();

		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);

		Thread.sleep(2000);

		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);
	}

	public void addTheFinalDiagnosis(WebDriver driver, String comments, String fd1, String fd2, String fd3, String fd4,
			String fd5, String fd6) throws Throwable {
		finalDiagnosisDropDownInFinalDiagnosisTab.click();
		searchBoxFieldForDropDown.sendKeys(fd1);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

		finalDiagnosisDropDownInFinalDiagnosisTab.click();
		searchBoxFieldForDropDown.sendKeys(fd2);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

		finalDiagnosisDropDownInFinalDiagnosisTab.click();
		searchBoxFieldForDropDown.sendKeys(fd3);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

		finalDiagnosisDropDownInFinalDiagnosisTab.click();
		searchBoxFieldForDropDown.sendKeys(fd4);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

		finalDiagnosisDropDownInFinalDiagnosisTab.click();
		searchBoxFieldForDropDown.sendKeys(fd5);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

		finalDiagnosisDropDownInFinalDiagnosisTab.click();
		searchBoxFieldForDropDown.sendKeys(fd6);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		Thread.sleep(1000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

	}

	public void addThePrescriptons(WebDriver driver, String repeatPattern, String duration, String route,
			String quantity, String notes1) throws Throwable {

		scrolldown(driver);
		for (int i = 0; i < 13; i++) {
			Random random = new Random();
			String pre = prescription_Names[random.nextInt(prescription_Names.length)];
			genericNameTextFieldInPrescriptionTab.sendKeys(pre);

			// wait_For_Invisibilty_Of_Loader(driver, 200);
			// explicitWaitElementToBeClickable(driver, prescriptionSuggestion);
			prescriptionSuggestion.click();
			// wait_For_Invisibilty_Of_Loader(driver, 200);

			selectPatternDropDownInPrescriptionTab.click();
			searchBoxFieldForDropDown.sendKeys(repeatPattern);
			searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
			durationTextFieldInPrescriptionTab.sendKeys(duration);
			routeDropDownInPrescriptionTab.click();
			searchBoxFieldForDropDown.sendKeys(route);
			searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
			quantityTextFieldInPrescriptionTab.sendKeys(quantity);
			notesTextFieldInPrescriptionTab.sendKeys(notes1);

			clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInprescriptionTab);
		}
	}

	public void addTheNextEncounter(WebDriver driver, String remarks) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		for (int i = 0; i <= 3; i++) {
//			scrollDownThePageUntilElementIsVisible(driver, investigationsTextFieldInNextEncounterTab);
//			subjectiveText_NextEncounter.sendKeys(subjective);
//			objectiveText_NextEncounter.sendKeys(objective);
//			assessmentText_NextEncounter.sendKeys(assessment);
//			planText_NextEncounter.sendKeys(plan);
//			investigationsTextFieldInNextEncounterTab.sendKeys(inv);
			remarksText_NextEncounter.sendKeys(remarks);
			clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInNextEncounterTab);
		}
	}

	public void clickOnFinalDiagnosisTabinDDOPD(WebDriver driver) {
		// wait_For_Invisibilty_Of_Loader(driver, 200);
		// explicitWaitElementToBeClickabl(driver, finalDiagnosisTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, finalDiagnosisTab);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//		wait_For_Invisibilty_Of_Loader(driver, 200);

	}

	public void clickOnPrescriptioinTab(WebDriver driver) {
		// wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollDownThePageUntilElementIsVisible(driver, prescriptionTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, prescriptionTab);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//		wait_For_Invisibilty_Of_Loader(driver, 200);
	}

	public void clickOnNextEncounterTab(WebDriver driver) {
//		explicitWaitElementToBeClickabl(driver, nextEncounterTab);
		scrollDownThePageUntilElementIsVisible(driver, nextEncounterTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, nextEncounterTab);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnSubmitBtnInNextEncounterTb(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitButtonInNextEncounterTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, submitButtonInNextEncounterTab);
		okBtn.click();
	}

	public void clickOnSubmitBtnInInvestigationsTab(WebDriver driver) throws Throwable {
		Thread.sleep(2500);
		scrollDownThePageUntilElementIsVisible(driver, submitButtonIninvestigationsProcedureTab);
		submitButtonIninvestigationsProcedureTab.click();
	}

	public WebElement getNextEncounterTab() {
		return nextEncounterTab;
	}

	public void clickOnSubmitBtnInFinalDiagnosisTab(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, submitButtonInFinalDiagnosisTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, submitButtonInFinalDiagnosisTab);
		okBtn.click();
	}

	public void clickOnSubmitBtnInPrescriptionTab(WebDriver driver) {
//		wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollDownThePageUntilElementIsVisible(driver, submitButtonInPrescriptionTab);
//		explicityWaitForElemenToBeClickable(driver, submitButtonInPrescriptionTab);
		submitButtonInPrescriptionTab.click();
	}

	public void clickOnCreatedSuccessfullyPoopUPInFinalDiagnosisTab(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, createdSuccessfullyPopupInFinalDiagnosis);

	}

	public void clickOnNewBtnInFinalDiagnosisTab(WebDriver driver) {
//		wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollDownThePageUntilElementIsVisible(driver, newBtnInFinalDiagnosisTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, newBtnInFinalDiagnosisTab);
//		wait_For_Invisibilty_Of_Loader(driver, 200);
	}

	public void clickOnNewBtnInPrescriptonTab(WebDriver driver) {
//		wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollDownThePageUntilElementIsVisible(driver, newBtnInprescriptionTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, newBtnInprescriptionTab);
//		wait_For_Invisibilty_Of_Loader(driver, 200);

	}

	public void clickOnCurrentMedicationTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		currentMedicationTabUnderHistory.click();

	}

	public void scrolldownToSpecificHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
	}

	public void clickOnDocumentsTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, documentsTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, documentsTab);
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//		wait_For_Invisibilty_Of_Loader(driver, 200);
	}

	public void clickOnSuccessfullPopInInvestigationTab(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, createdSuccessfullyPopUPAfterSubmitingInvestigations);
		Thread.sleep(2000);
	}

	public void addDocumentsInDdOpd_Random(WebDriver driver) throws Throwable {
		Set<String> doc1 = new HashSet<>();
		for (int i = 0; i < 2; i++) {
			Random random = new Random();
			String doc = "";
			do {
				doc = Documents[random.nextInt(Documents.length)];
			} while (doc1.contains(doc));

			scrollDownThePageUntilElementIsVisible(driver, uploadBtnInDocumentTab);
//			wait_For_Invisibilty_Of_Loader(driver, 200);
			Thread.sleep(1000);
			uploadBtnInDocumentTab.click();
			chooseFileOptionInDocumentsTab.sendKeys(doc);
//			wait_For_Invisibilty_Of_Loader(driver, 200);
			submitButtonInDocumentTab.click();
//			wait_For_Invisibilty_OfElement_ForLoader(driver);
		}

	}

	public void addTheCurrentMedication(WebDriver driver, String route, String pattern, String sd, String qty,
			String notes, String status) throws Throwable {

//		wait_For_Invisibilty_Of_Loader(driver, 200);
		for (int i = 0; i <= 5; i++) {
			Random random = new Random();
			String gn = prescription_Names[random.nextInt(prescription_Names.length)];

//			explicitWaitElementToBeClickable(driver, genericNameTextFieldInCurrentMedicationTab);
			genericNameTextFieldInCurrentMedicationTab.sendKeys(gn);
//			wait_For_Invisibilty_Of_Loader(driver, 200);

//		/	explicitWaitElementToBeClickabl(driver, suggestion_1);
			suggestion_1.click();
//			explicitWaitElementToBeClickabl(driver, routeDropdownBtn);
			dropdown(driver, routeDropdownBtn, searchBoxFieldForDropDown, route);
			dropdown(driver, repeatPatternDropDownBtn, searchBoxFieldForDropDown, pattern);

			startDate.sendKeys(sd);
			quantityText.sendKeys(qty);
			notesText.sendKeys(notes);
			scrollDownThePageUntilElementIsVisible(driver, statusDropDown);
			// explicitWaitElementToBeClickabl(driver, statusDropDown);
			dropdown(driver, statusDropDown, searchBoxFieldForDropDown, status);
			addButtonInCurrentMedicationTab.click();
			// explicitWaitElementToBeClickabl(driver, suggestion_1);
		}
	}

	public void calculateInvestigations(WebDriver driver) throws Throwable {

		// Find all service elements and extract their amounts
		List<WebElement> amountElements = driver
				.findElements(By.xpath("//div[@id='INV']/descendant::table[@id='example'][1]/tbody/tr/td[8]"));

		double totalAmount = 0.0;

		int count = 0;
		for (WebElement element : amountElements) {

//		/	explictWaitForElementToBeVisible(driver, element);
			String amountText = element.getText();
			double amount = Double.parseDouble(amountText);
			totalAmount = totalAmount + amount;
			count++;
			if (count >= 10) {
				// explictWaitForElementToBeVisible(driver, nextBtnForPagination);
				scrollTillVisibleElement(driver, nextBtnForPagination);
				// explicityWaitForElemenToBeClickable(driver, nextBtnForPagination);
				nextBtnForPagination.click();
				scrollUp(driver);
				Thread.sleep(2000);
				List<WebElement> amountElements1 = driver
						.findElements(By.xpath("//div[@id='INV']/descendant::table[@id='example'][1]/tbody/tr/td[8]"));
				for (WebElement element1 : amountElements1) {

					// explictWaitForElementToBeVisible(driver, element1);
					String amountText1 = element1.getText();
					double amount1 = Double.parseDouble(amountText1);
					totalAmount = totalAmount + amount1;
					Thread.sleep(1000);
				}
			}
		}
		// Print the total investigations amount
		System.out.println("Total Investigations Amount: " + totalAmount);

		scrollUp(driver);
		String tt = invAmounIntheHeaderSection.getText();
		double a1 = Double.parseDouble(tt);
		System.out.println("Amount in header section : " + a1);
		Assert.assertEquals(a1, totalAmount);
		System.out.println("Successfully amount verified");
	}

	public String verifyConsultationAmountInDoctorDesk(WebDriver driver) {

		String r = consultationAmounIntheHeaderSection.getText();
		System.out.println("consultation Amount In header Section : " + r);
		return r;
	}

	public void addTheInvestigationsForLab1(WebDriver driver, String notes) throws Throwable {

		scrolldown(driver);
		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("AFB - CYTO");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement suggestionBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
		WebElement desiredSuggestion = suggestionBox.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("PAS - CYTO");
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		WebElement suggestionBox1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
		WebElement desiredSuggestion1 = suggestionBox1.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion1.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys("ALCIAN BLUE - CYTO");
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		WebElement suggestionBox3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
		WebElement desiredSuggestion3 = suggestionBox3.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion3.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

	}

	public void addTheInvestigationsForLabOneService(WebDriver driver, String inv, String notes) throws Throwable {

		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(inv);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement suggestionBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
		WebElement desiredSuggestion = suggestionBox.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);

	}

	public void clickOnLabResultTab(WebDriver driver) throws InterruptedException {
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		labRadResultTab.click();
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void scrollDown(WebDriver driver) throws InterruptedException {
		scrollDownTheStillEndOfThePage(driver);
	}

	public String captureSampleNumberInLabTab(WebDriver driver) {
		String sam1 = sampleNumberInTheTable_LabTab.getText();
		return sam1;

	}

	public String captureServiceClassInLabTab(WebDriver driver) {
		String ser1 = serviceClassInTheTable_LabTab.getText();
		return ser1;

	}

	public String captureServiceNameInLabTab(WebDriver driver) {
		String sn1 = serviceNameInTheTable_LabTab.getText();
		return sn1;

	}

	public String captureResultValueInLabTab(WebDriver driver) {
		String pt1 = patientValueInTheTable_LabTab.getText();
		return pt1;

	}

	public String captureReferencerangeInLabTab(WebDriver driver) {
		String ref1 = referenceRangeInTheTable_LabTab.getText();
		return ref1;
	}

	public void addTheInvestigationsFoLab(WebDriver driver, String notes) throws Throwable {

		Set<String> invNames = new HashSet<>();
		scrolldown(driver);
		for (int i = 0; i < 3; i++) {
			Random random = new Random();
			String inv = "";

			do {
				inv = INV_NAMES[random.nextInt(INV_NAMES.length)];
			} while (invNames.contains(inv));

			invNames.add(inv);
			serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(inv);

			WebElement desiredSuggestion = driver.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			desiredSuggestion.click();

			noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);

			Thread.sleep(2000);
			clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);
		}
	}

	public void addTheInvestigationForOPProcess(WebDriver driver, String hospitalNumber, String notes)
			throws Throwable {
		clickOnTheDoctorDeskOpdScreenButton(driver);
		clickOnMyPatientListTab(driver);
		clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		clickOnPatientArrivalBtnAndSave(driver);
		clickOnUpdatedPatientArrivalStatusPopUP(driver);
		clickOnInvestigationTab(driver);
		clickOnNewBtnInInvestigationTab(driver);
		scrolldown(driver);
		addTheInvestigationsForLab(driver, notes);
		clickOnSubmitBtnInInvestigationsTab(driver);
	}

	public void clickOnOtInformationTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		otInformationTab.click();
	}

	public void searchHospitalNumberAndClickInAllPatientList(WebDriver driver, String hospitalNumber) throws Throwable {
		Thread.sleep(1500);
		clickOnShowAllFilterCheckBox(driver);
		clearBtn.click();
		hospitalNumberText_MyPatientList.sendKeys(hospitalNumber);
		explictWaitForElementToBeVisible(driver, searchBtn);
		searchBtn.click();
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumberInTable_allPatientList);
		explictWaitForElementToBeVisible(driver, hospitalNumberInTable_allPatientList);
		hospitalNumberInTable_allPatientList.click();
	}

	public void searchHospitalNumberAndClickTheHospitalNumber(WebDriver driver, String hospitalNumber)
			throws Throwable {
		Thread.sleep(1500);
		clearBtn.click();
		Thread.sleep(1500);
		hospitalNumberTextField.sendKeys(hospitalNumber);
		waitForElementWithCustomTimeOut(driver, searchBtn, 5);
		searchBtn.click();
		scrollDownThePageUntilElementIsVisible(driver, hospitalNumberInFirstRow_MyPatientList);
		hospitalNumberInFirstRow_MyPatientList.click();
	}

	public void clickOnOtScheduleTab(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, otScheduletab);
		otScheduletab.click();
	}

	public void clickOnHospitalNumberInTheAllPatientList(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
		scrollDownThePageUntilElementIsVisible(driver, hospitalnumberInTable_AllpatientList);
		hospitalnumberInTable_AllpatientList.click();
	}

	public String captureErrorText(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = errorText.getText();
		return text;
	}

	public void addThreeInvestigations(WebDriver driver, String notes) throws Throwable {

		Set<String> invNames = new HashSet<>();
		scrolldown(driver);
		for (int i = 0; i < 15; i++) {
			Random random = new Random();
			String inv = "";
			do {
				inv = INV_NAMES[random.nextInt(INV_NAMES.length)];
			} while (invNames.contains(inv));

			invNames.add(inv);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(inv);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			Thread.sleep(500);
			suggestionBox.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			noteTextFieldIninvestigationsProcedureTab.sendKeys(notes);
			Thread.sleep(2000);
			clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);
		}
	}

	public void addTheFinalDiagnosis_Random(WebDriver driver, String comments) throws Throwable {
		Set<String> FinalDiagnosis = new HashSet<>();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrolldown(driver);
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			String fd = "";

			do {
				fd = Final_Diagnosis[random.nextInt(Final_Diagnosis.length)];
			} while (FinalDiagnosis.contains(fd));

			wait_For_Invisibilty_OfElement_ForLoader(driver);
			FinalDiagnosis.add(fd);
			diagnosistext_FinalDiagnosis.sendKeys(fd);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			suggestion.click();
			clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
		}
	}

	public void clickOnOtherNotesTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, otherNotesTab);
		otherNotesTab.click();
	}

	public void clickOnNewBtn_OtherNotesTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, newBtn_OtherNotesTab);
		newBtn_OtherNotesTab.click();
	}

	public void selectTemplateType_otherNotesTab(WebDriver driver, String templateType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, templateType_otherNotesTab);
		dropdown(driver, templateType_otherNotesTab, searchBoxFieldForDropDown, templateType);
	}

	public void enterDataOtherNotes_Iframe(WebDriver driver) throws Throwable {
		scrolldown(driver);
		WebElement iframe = iframe_OtherNotesTab;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		for (WebElement webElement : otherNotesTextArea) {
			String text = generateLoremIpsum(3, 60);
			webElement.sendKeys(text);
		}

		driver.switchTo().defaultContent();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_OtherNotesTab);
		Thread.sleep(1000);
		submitBtn_OtherNotesTab.click();
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

	public void clickOnHistoryTabs(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollDownThePageUntilElementIsVisible(driver, historyTab);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		historyTab.click();

	}

	public void enterDataInIframe_HistoryTabs(WebDriver driver, String data) throws Throwable {
		scrolldown(driver);
		Thread.sleep(1000);
		List<WebElement> list = iframe_CheifComplaintTab;
		for (WebElement webElement : list) {
			webElement.sendKeys(data);
		}

	}

	public void enterDataInIframe_HistoryTabs2(WebDriver driver, CharSequence text) throws Throwable {
		scrolldown(driver);
		scrolldown(driver);
		Thread.sleep(1000);
		List<WebElement> list = iframe_CheifComplaintTab;
		for (WebElement webElement : list) {
			webElement.sendKeys(text);
		}

	}

	public void clickOnPmhTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pmhTabUnderHistory);
		pmhTabUnderHistory.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnPshTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pshTabUnderHistory);
		pshTabUnderHistory.click();
	}

	public void clickOnFamilyHx(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, familyHxTabUnderHistory);
		familyHxTabUnderHistory.click();
	}

	public void clickOnSocialHx(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, socialHxTabUnderHistory);
		socialHxTabUnderHistory.click();
	}

	public void clickOnDrugAndFoodAllergy(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, drugAndFoodAllergyTabUnderHistory);
		drugAndFoodAllergyTabUnderHistory.click();
	}

	public void clickOnRosTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, rosTabUnderHistory);
		rosTabUnderHistory.click();
	}

	public void clickOnGpeTab(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, gpeTabUnderHistory);
		gpeTabUnderHistory.click();
	}

	public void clickOnPastInvestigationTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pastInvestigationsTabUnderHistory);
		clickOnTheElementUsedToJavascriptExecuter(driver, pastInvestigationsTabUnderHistory);

	}

	public void clickOnLabTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, labTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, labTab);

	}

	public void clickOnProvisionalDiagnosisTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, provisionalDiagnosiTabUnderHistory);
		clickOnTheElementUsedToJavascriptExecuter(driver, provisionalDiagnosiTabUnderHistory);

	}

	public void clickOnPlanTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, planTabUnderHistory);
		clickOnTheElementUsedToJavascriptExecuter(driver, planTabUnderHistory);
	}

	public void clickOnNextBtn_historyTabs(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, nextBtnForChiefComplaint);
		scrollDownTheStillEndOfThePage(driver);
		explictWaitForElementToBeVisible(driver, nextBtnForChiefComplaint);
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtnForChiefComplaint);
	}

	public void clickOnSubmitBtn_historyTabs(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_historyTabs);
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtn_historyTabs);
	}

	public void clickOnPopup(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		errorText.click();
	}

	public void clickOnNextBtn_currentMedication(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, nextBtn);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, nextBtn);
	}

	public void clickOnVitalSignsTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, vitalSignsTab);
	}

	public void enterDataInVitalSign(WebDriver driver, String bp, String height, String weight, String pulse, String rr,
			String c) {
		// wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollToBottom(driver);
		bpText_vitalSign.sendKeys(bp);
		heightText_vitalSign.sendKeys(height);
		weightText_vitalSign.sendKeys(weight);
		temperature_VitalSign.sendKeys("32");
		pulseText_VitalSign.sendKeys(pulse);
		rrText_VitalSign.sendKeys(rr);
	}

	public void enterDataInVitalSign_2(WebDriver driver, String bp, String height, String temp, String weight,
			String pulse, String rr) {
		// wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollToBottom(driver);
		bpText_vitalSign.sendKeys(bp);
		heightText_vitalSign.sendKeys(height);
		temperature_VitalSign.sendKeys(temp);
		weightText_vitalSign.sendKeys(weight);
		pulseText_VitalSign.sendKeys(pulse);
		rrText_VitalSign.sendKeys(rr);
	}

	public void clickOnProgressRecordTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, progressRecordTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, progressRecordTab);
	}

	public void enterDataInIframe_ProgressRecord(WebDriver driver) throws Throwable {
		scrolldown(driver);
		WebElement iframe = iframe_ProgressRecord;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {
			String text = generateLoremIpsum(3, 10);
			webElement.sendKeys(text);
		}
		driver.switchTo().defaultContent();

	}

	public void clickOnSignBtn(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, signBtn);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, signBtn);
	}

	public String addOnePrescriptons(WebDriver driver, String repeatPattern, String duration, String route,
			String quantity, String notes1) throws Throwable {

		Random random = new Random();
		String pre = prescription_Names[random.nextInt(prescription_Names.length)];
		genericNameTextFieldInPrescriptionTab.sendKeys(pre);
		String text = pre;
		WebDriverWait wait = new WebDriverWait(driver, 100);
		;
		WebElement suggestionBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
		WebElement desiredSuggestion = suggestionBox.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion.click();
		selectPatternDropDownInPrescriptionTab.click();
		searchBoxFieldForDropDown.sendKeys(repeatPattern);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		durationTextFieldInPrescriptionTab.sendKeys(duration);
		routeDropDownInPrescriptionTab.click();
		searchBoxFieldForDropDown.sendKeys(route);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		quantityTextFieldInPrescriptionTab.sendKeys(quantity);
		notesTextFieldInPrescriptionTab.sendKeys(notes1);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInprescriptionTab);
		return text;
	}

	public void clickOnEdit_prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		editBtn_prescription.click();
	}

	public String captureGenericName_Table_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String gen = genericName_table_prescription.getText();
		return gen;
	}

	public void addOneFinalDiagnosis(WebDriver driver, String fd, String comments) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, diagnosistext_FinalDiagnosis);
		diagnosistext_FinalDiagnosis.sendKeys(fd);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		suggestion.click();
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);
	}

	public void enteDate_ProgressRecord(WebDriver driver, String date) {
		dateField_ProgressRecord.sendKeys(date);
	}

	public void enterTime_ProgressRecord(WebDriver driver, String time) {
		timeField_ProgressRecord.sendKeys(time);
	}

	public String captureDateAndTime_ProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, dateAndTime_sideList);
		String date = dateAndTime_sideList.getText();
		String date1 = date.replace(":", "");
		return date1;
	}

	public void clickOnDraftBtn(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, draftBtn);
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

	public void clickOnProgressRecord_ProgressRecordDetails(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, progressRecordDetail_FirstProgressRecord);
		clickOnTheElementUsedToJavascriptExecuter(driver, progressRecordDetail_FirstProgressRecord);
	}

	public String captureStatus_ProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, status_ProgressRecordDetails);
		String status = status_ProgressRecordDetails.getText();
		System.out.println(status);
		return status;
	}

	public String captureDateAndTime_VisitDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, dateAndTime_print_visitDetails);
		scrollToBottom(driver);
		String dateAndTime = dateAndTime_print_visitDetails.getText().replace(":", "").replace(" ", "");
		System.out.println(dateAndTime);
		return dateAndTime;
	}

	public void clickOnVisitTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, progressRecordTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, progressRecordTab);
	}

	public void clickOnVisitDetailsTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, visitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, visitDetails);
	}

	public String captureDateAndTime_ProgressRecord1(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, dateAndTime_sideList);
		String date = dateAndTime_sideList.getText().replace(":", "").replace(" ", "");
		return date;
	}

	public int captureAndAddListOfTotslAmount_Investigation(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		int total = 0;
		List<WebElement> totalAmount = listOfTotalAmout_Investigation;
		for (WebElement webElement : totalAmount) {
			String ta = webElement.getText();
			int ta1 = Integer.parseInt(ta);
			total = total + ta1;
		}
		System.out.println(total);
		return total;
	}

	public List<String> captureListOfDiagnosis_FinalDiagnosis(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		List<WebElement> dia = listOfDiagnosis_FinalDiagnosis;
		List<String> diagnosisList = new ArrayList<>();
		for (WebElement webElement : dia) {
			String fd = webElement.getText();
			diagnosisList.add(fd);
		}
		System.out.println(diagnosisList);
		return diagnosisList;
	}

	public List<String> captureListOfDiagnosis_ViewMore(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		List<WebElement> dia = listOfDiagnosis_ViewMore;
		List<String> diagnosisList = new ArrayList<>();
		for (WebElement webElement : dia) {
			String fd = webElement.getText();
			diagnosisList.add(fd);
		}
		System.out.println(diagnosisList);
		return diagnosisList;
	}

	public void clickOnViewMoreBtn(WebDriver driver) {
		scrollToTop(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, viewMoreBtn);
	}

	public int captureInvestigationAmount_BillingDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		String inv = investigationAmount_BillingDetails.getText();
		int inv1 = Integer.parseInt(inv);
		return inv1;
	}

	public void clickOnCrossReferralBtb(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		crossReferralBtn.click();
	}

	public void selectDepartment_CrossReferral(WebDriver driver, String dep) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, departmentDropDownBtn_CrossReferral, searchBoxFieldForDropDown, dep);

	}

	public void selectDoctor_CrossReferral(WebDriver driver, String doc) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, doctorDropDownBtn_CrossReferral, searchBoxFieldForDropDown, doc);
	}

	public void enterReason_CrossReferral(WebDriver driver, String reason) {
		reasonArea_CrossReferral.sendKeys(reason);
	}

	public void clickOnRequest_CrossReferral(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		requestBtn_CrossReferral.click();

	}

	public void clickOnCrossReferral_EnterData_ClickOnRequest(WebDriver driver, String dep, String doc, String reason) {
		clickOnCrossReferralBtb(driver);
		selectDepartment_CrossReferral(driver, dep);
		selectDoctor_CrossReferral(driver, doc);
		enterReason_CrossReferral(driver, reason);
		clickOnRequest_CrossReferral(driver);
	}

	public void enterHospitalNumberAndClickOnSearch(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumberText_MyPatientList.clear();
		hospitalNumberText_MyPatientList.sendKeys(hospitalNumber);
		waitForElementWithCustomTimeOut(driver, searchBtn, 5);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		searchBtn.click();
	}

	public String captureDepartment_Table_AllPatientList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String dep = department_Table_AllPatientList.getText();
		return dep;
	}

	public void clickOnMoveopToIp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		moveOpToIpBtn.click();
	}

	public void enterDataInIframe_MoveOpToIP(WebDriver driver, String text) throws Throwable {
		scrolldown(driver);
		WebElement iframe = iframe_MoveOpToIp;
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		List<WebElement> list = otherNotesTextArea;
		for (WebElement webElement : list) {
			webElement.sendKeys(text);
		}
		driver.switchTo().defaultContent();
	}

	public void selectWardType_MoveOpToIp(WebDriver driver, String wardType) {
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		scrollDownThePageUntilElementIsVisible(driver, wardTypeDropDownBtn_MoveOpToIp);
		dropdown(driver, wardTypeDropDownBtn_MoveOpToIp, searchBoxFieldForDropDown, wardType);
	}

	public void selectDepartment_MoveOpToIp(WebDriver driver, String department) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, departmentDropDownBtn_MoveOpToIp);
		dropdown(driver, departmentDropDownBtn_MoveOpToIp, searchBoxFieldForDropDown, department);
	}

	public void selectAdmittedUnderDr_MoveOpToIp(WebDriver driver, String admittedUnderDr) {
		dropdown(driver, admittedUnderDrDropDown_MoveOpToIp, searchBoxFieldForDropDown, admittedUnderDr);
	}

	public void selectUnit_MoveOPToIp(WebDriver driver, String unit) {
		dropdown(driver, unitDrDropDown_MoveOpToIp, searchBoxFieldForDropDown, unit);
	}

	public void selectAdmittedByDr_MoveOpToIp(WebDriver driver, String admittedByDr) {
		dropdown(driver, admittedByDrDropDown_MoveOpToIp, searchBoxFieldForDropDown, admittedByDr);
	}

	public void clickOnSubmit_moveOpToIp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, submitBtn_MoveOpToIp);
		submitBtn_MoveOpToIp.click();
	}

	public void clickOnMoveOpToIp_EnterDate_ClickOnSubmit(WebDriver driver, String text, String ward, String dep,
			String admittedUnder, String unit, String admittedBy) throws Throwable {
		scrollToTop(driver);
		clickOnMoveopToIp(driver);
		enterDataInIframe_MoveOpToIP(driver, text);
		selectWardType_MoveOpToIp(driver, ward);
		selectDepartment_MoveOpToIp(driver, dep);
		selectAdmittedUnderDr_MoveOpToIp(driver, admittedUnder);
		selectUnit_MoveOPToIp(driver, unit);
		selectAdmittedByDr_MoveOpToIp(driver, admittedBy);
		clickOnSubmit_moveOpToIp(driver);
	}

	public void clickOnClearBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clearBtn.click();
	}

	public String captureHospitalNumber_Table_AllPatientList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalnumberInTable_AllpatientList_LastRow.getText();
		return hospitalNumber;
	}

	public String captureHospitalNumber_Table_AllPatientList(WebDriver driver) throws Throwable {
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String hospitalNumber = hospitalnumberInTable_AllpatientList.getText();
		return hospitalNumber;
	}

	public void clickOnShowAllFilterCheckBox(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, showAllFilter_CheckBox);
	}

	public String capturePatientName_Table_AllPatientList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = patientName_Table_AllPatientList_LastRow.getText();
		return hospitalNumber;
	}

	public String capturePatientName_Table_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = patientName_Table_AllPatientList.getText();
		return hospitalNumber;
	}

	public String captureDepartment_Table_AllPatientList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = department_Table_AllPatientList_LastRow.getText();
		return hospitalNumber;
	}

	public void selectDepartment(WebDriver driver, String dep) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, departmentDropDownBtn, searchBoxFieldForDropDown, dep);

	}

	public String captureUnit_Table_AllPatientList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = unit_Table_AllPatientList_LastRow.getText();
		return hospitalNumber;
	}

	public String captureUnit_Table_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = unit_Table_AllPatientList.getText();
		return hospitalNumber;
	}

	public void selectUnit(WebDriver driver, String unit) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, unitDropDownBtn, searchBoxFieldForDropDown, unit);

	}

	public String captureVisitNumber_Table_AllPatientList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = visitNumberInTheList_LastRow.getText();
		return hospitalNumber;
	}

	public String captureVisitNumber_Table_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = visitNumberInTheList_Row1.getText();
		return hospitalNumber;
	}

	public String captureConsultationStatus_Table_AllPatientList_LastRow(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String cs = consultationStatusInTheList_LastRow.getText().replace(".", "");
		return cs;
	}

	public String captureConsultationStatus_Table_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String cs = consultationStatusInTheList.getText().replace(".", "");
		return cs;
	}

	public String capturePhoneNumberInTableAndIgnoreIfDisplaysNa_AllPatientList(WebDriver driver) {
		String mobileNumber = "";
		for (WebElement element : listOfMobileNumber_Table_AllPatientList) {
			String text = element.getText().trim();
			if (!text.equalsIgnoreCase("N/A")) {
				mobileNumber = text;
				break;
			}
			System.out.println("mobileNumber");
		}
		return mobileNumber;
	}

	public String capturePhoneNumber_Table_AllPatientList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String ph = phoneNumber_Table_allPatientList.getText();
		return ph;
	}

	public String captureHospitalNumber_Table_MyPatientList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String hospitalNumber = hospitalNumberInFirstRow_MyPatientList.getText();
		return hospitalNumber;
	}

	public String capturePatientName_Table_MyPatientList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String name = patientNameInFirstRow_MyPatientList.getText();
		return name;
	}

	public String capturePhoneNumber_Table_MyPatientList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1500);
		String text = phoneNumber_table_MyPatientList.getText();
		return text;
	}

	public String captureVisitNumber_Table_MyPatientList_LastRow(WebDriver driver) throws InterruptedException {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String vn = visitNumber_LastRow_MypatientList.getText();
		return vn;
	}

	public String captureVisitNumber_Table_MYPatientList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String vn = visitNumber_MypatientList.getText();
		return vn;
	}

	public String captureConsultationStatus_Table_MyPatientList(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		String cs = consultationStatus_Table_MyPatientList.getText().replace(".", "");
		return cs;
	}

	public void clickOnRadiologyTab_LabResultTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollTillVisibleElement(driver, radiologyTab_LabRadResultTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, radiologyTab_LabRadResultTab);
	}

	public String captureTransactionNumber_Table_radiology(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, transactionNumber_table_radiology);
		String t = transactionNumber_table_radiology.getText();
		return t;
	}

	public String captureServiceClass_Table_radiology(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, serviceClass_table_radiology);
		String t = serviceClass_table_radiology.getText();
		return t;
	}

	public String capturetServiceNamee_Table_radiology(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, serviceName_table_radiology);
		String t = serviceName_table_radiology.getText();
		return t;
	}

	public String captureOkBtnText(WebDriver driver) {
		invisibiltyOf_Element_ThreeDots(driver);
		String text = okBtnText.getText();
		return text;
	}

	public void clickOnOkBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		okBtn.click();
	}

	public String capturePatientArrivalDateAndTime(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = patientAriivalDatAndTime.getText().replace(":", "").replaceAll("\\s", "");
		return text;
	}

	public void selectTemplateDropDown(WebDriver driver, String template) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, templateDropDownBtn);
		dropdown(driver, templateDropDownBtn, searchBoxFieldForDropDown, template);
	}

	// public List<String> captureDataInIfrmame_HistoryTabs(WebDriver driver) throws
	// Throwable {
//		scrolldown(driver);
//		WebElement iframe = iframe_CheifComplaintTab;
//		driver.switchTo().frame(iframe);
//		Thread.sleep(1000);
//		List<WebElement> ele = otherNotesTextArea;
//		List<String> text1 = new ArrayList<>();
//		for (WebElement webElement : ele) {
//			String text = webElement.getText();
//			text1.add(text);
//		}
//		driver.switchTo().defaultContent();
	// return text1;
//	}

	public void addOnePrescriptons(WebDriver driver, String gn, String repeatPattern, String duration, String route,
			String quantity, String notes1) throws Throwable {
		scrolldown(driver);
		genericNameTextFieldInPrescriptionTab.sendKeys(gn);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement suggestionBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item ng-star-inserted'][1]")));
		WebElement desiredSuggestion = suggestionBox.findElement(By.xpath("//li[@class='item ng-star-inserted'][1]"));
		desiredSuggestion.click();
		selectPatternDropDownInPrescriptionTab.click();
		searchBoxFieldForDropDown.sendKeys(repeatPattern);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		durationTextFieldInPrescriptionTab.sendKeys(duration);
		routeDropDownInPrescriptionTab.click();
		searchBoxFieldForDropDown.sendKeys(route);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		quantityTextFieldInPrescriptionTab.sendKeys(quantity);
		notesTextFieldInPrescriptionTab.sendKeys(notes1);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInprescriptionTab);
	}

	public void clickOnEditUnderAction_prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, editBtn_Action_Prescription);
		editBtn_Action_Prescription.click();
	}

	public void clickOnUpdate_prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, updateBtn);
		updateBtn.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnOkBtn(driver);
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

	public void enterDataInPrescriptionAfterClickingOnEdit(WebDriver driver, String repeatPattern, String duration,
			String route, String quantity, String notes1) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		selectPatternDropDownInPrescriptionTab_Edit.click();
		searchBoxFieldForDropDown.sendKeys(repeatPattern);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		durationTextFieldInPrescriptionTab_Edit.clear();
		durationTextFieldInPrescriptionTab_Edit.sendKeys(duration);
		routeDropDownInPrescriptionTab_Edit.click();
		searchBoxFieldForDropDown.sendKeys(route);
		searchBoxFieldForDropDown.sendKeys(Keys.DOWN, Keys.ENTER);
		quantityTextFieldInPrescriptionTab_Edit.clear();
		quantityTextFieldInPrescriptionTab_Edit.sendKeys(quantity);
		notesTextFieldInPrescriptionTab_Edit.clear();
		notesTextFieldInPrescriptionTab_Edit.sendKeys(notes1);
	}

	public String captureGenericName_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = genericName_table_prescription.getText();
		return text;
	}

	public String captureRepeatPattern_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = repeatPattern_Table_Prescription.getText();
		return text;
	}

	public String captureRoute_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = route_Table_Prescription.getText();
		return text;
	}

	public String captureDuration_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = duration_Table_Prescription.getText();
		return text;
	}

	public String captureQuantity_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = quantity_Table_Prescription.getText();
		return text;
	}

	public String captureNotes_Prescription(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = notes_Table_Prescription.getText();
		return text;
	}

	public List<String> captureListOfDiagnosis_MoveOpToIp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownByUsingJavascriptExecuter(driver);
		List<WebElement> dia = listOfDiagnosis_MoveOpToIp;
		List<String> diagnosisList = new ArrayList<>();
		for (WebElement webElement : dia) {
			String fd = webElement.getText();
			diagnosisList.add(fd);
		}
		System.out.println(diagnosisList);
		return diagnosisList;
	}

	public String captureMlcType_MlcDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = mlcType_MlcDetails.getText();
		return text;
	}

	public String capturePoliceStation_MlcDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = policeStation_MlcDetails.getText();
		return text;
	}

	public String captureBroughtBy_MlcDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = broughtBy_MlcDetails.getText();
		return text;
	}

	public String captureContactName_MlcDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = contactName_MlcDetails.getText();
		return text;
	}

	public String captureContactNumber_MlcDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = contactNumber_MlcDetails.getText();
		return text;
	}

	public String captureBroughtDate_MlcDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = broughtDate_MlcDetails.getText();
		return text;
	}

//	public void enterDataInIframe_HistoryTabs_1(WebDriver driver, String text) throws Throwable {
//		scrolldown(driver);
//		WebElement iframe = iframe_CheifComplaintTab;
//		driver.switchTo().frame(iframe);
//		Thread.sleep(1000);
//		List<WebElement> list = otherNotesTextArea;
//		for (WebElement webElement : list) {
//			webElement.sendKeys(text);
//		}
//		driver.switchTo().defaultContent();
//	}

	public String captureAllergies(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		String text = allergies.getText();
		return text;
	}

	public String captureDeptHeader(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		String text = dept_Header.getText();
		return text;
	}

	public String captureUnitHeader(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToTop(driver);
		String text = unit_Header.getText();
		return text;
	}

	public void verifySystemIsRedirectingToProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Assert.assertTrue(progressRecord_Text.isDisplayed());
	}

	public void verifyDraFtAndContinueButtonIsDisplayingOrNot(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(2000);
		if (draftAndContinueButton.isDisplayed()) {
			draftAndContinueButton.click();
		} else {
			Assert.fail("Draft and Continue button is not visible");
		}
	}

	public void clickOnCancelBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		cancelBtn.click();
	}

	public void clickOnFetchPatientDetailsBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		fetchPatientDetails.click();
	}

	public void enterHospitalNumber_FetchPatientDetails(WebDriver driver, String hospitalNumber) throws Throwable {
		hospitalNumbetTextField_FetchPatientDetails.sendKeys(hospitalNumber);
	}

	public void selectOpNumber_FetchPatientDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		opNumberDropDownBtn_FetchPatientDetails.click();
		searchBoxFieldForDropDown.sendKeys(Keys.ENTER);
	}

	public void selectVisitNumber_FetchPatientDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		visitNumberDropDownBtn_FetchPatientDetails.click();
		searchBoxFieldForDropDown.sendKeys(Keys.ENTER);
	}

	public void clickOnFetchDetailsBtn(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		fetchDetailsBtn.click();
	}

	public String captureHospitalNumber_PatientDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = hospitalNumber_PatientDetails.getText();
		return text;
	}

	public void fetchPatientDetails(WebDriver driver, String hospitalNumber1) throws Throwable {
		clickOnFetchPatientDetailsBtn(driver);
		enterHospitalNumber_FetchPatientDetails(driver, hospitalNumber1);
		Thread.sleep(2000);
		clickOnFetchDetailsBtn(driver);
		selectOpNumber_FetchPatientDetails(driver);
		selectVisitNumber_FetchPatientDetails(driver);
		clickOnFetchDetailsBtn(driver);
	}

	public String captureAge_PatientDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = age_patientDetails.getText();
		return text;
	}

	public void clickOnAddLineItem_Investigation(WebDriver driver) {
		scrollDownThePageUntilElementIsVisible(driver, addButtonIninvestigationsProcedureTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);
	}

	public void verifyThatSystemShouldNotAllowToAddSameServices_Investigation(WebDriver driver, String inv)
			throws Throwable {
		scrolldown(driver);
		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(inv);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(1000);
		if (notFoundText.isDisplayed()) {
		} else {
			Assert.fail("System is allowing to add same services multiple times");
		}
	}

	public void enterDiagnosis_FinalDiagnosis(WebDriver driver, String fd) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, diagnosistext_FinalDiagnosis);
		diagnosistext_FinalDiagnosis.sendKeys(fd);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		suggestion.click();
	}

	public void enterComments_FinalDiagnosis(WebDriver driver, String comments) throws Throwable {

		scrollDownThePageUntilElementIsVisible(driver, commentsTextFieldInFinalDiagnosisTab);
		commentsTextFieldInFinalDiagnosisTab.sendKeys(comments);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);
	}

	public void clickOnAddLineItem_FinalDiagnosis(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, addButtonInFinalDiagnosisTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInFinalDiagnosisTab);

	}

	public void clickOnSideList_visitDetails(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		sideList_VisitDetails.click();
	}

	public void checkThatPrintButtonIsNotDisplayed(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		try {
			if (printBtn_VisitDetails.isDisplayed()) {
				Assert.fail("print button is displayed");
			} else {
				System.out.println("print button is not displayed");
			}
		} catch (Exception e) {
		}
	}

	public void clickOnInsuranceToggleBtn_MoveOpToOp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, insuranceToggleButton_MoveOpToIp);
		insuranceToggleButton_MoveOpToIp.click();
	}

	public void selectCustomerList(WebDriver driver, String customerList) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, customerListDropDownBtn);
		dropdown(driver, customerListDropDownBtn, searchBoxFieldForDropDown, customerList);
	}

	public void selectInsuranceType(WebDriver driver, String insuranceType) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, insuranceTypeDropDownBtn);
		dropdown(driver, insuranceTypeDropDownBtn, searchBoxFieldForDropDown, insuranceType);
	}

	public void checkThatCrossReferralButtonIsDisabled(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		if (crossReferralBtn.isEnabled()) {
			Assert.fail("Cross referral button is enabled before patient arrival is done");
		} else {
			System.out.println("Cross referral button is disabled");
		}
	}

	public void checkThatMoveOpToIPButtonIsDisabled(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		if (moveOpToIpBtn.isEnabled()) {
			Assert.fail("move op to ip button is enabled before patient arrival is done");
		} else {
			System.out.println("move op to ip button is disabled");
		}
	}

	public void addOneNextEncounter(WebDriver driver, String date, String subjective, String objective,
			String assessment, String plan, String inv) throws Throwable {
		scrollDownByUsingJavascriptExecuter(driver);
		scrollDownThePageUntilElementIsVisible(driver, investigationsTextFieldInNextEncounterTab);
		date_NextEncounter.sendKeys(date);
		subjectiveText_NextEncounter.sendKeys(subjective);
		objectiveText_NextEncounter.sendKeys(objective);
		assessmentText_NextEncounter.sendKeys(assessment);
		planText_NextEncounter.sendKeys(plan);
		investigationsTextFieldInNextEncounterTab.sendKeys(inv);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonInNextEncounterTab);
	}

	public void selectRegistrationFromDate(WebDriver driver, String date) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		registrationFromDateField.sendKeys(date);
	}

	public String capturePatientMovedToIpText(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String text = patientMovedToIpText.getText();
		System.out.println(text);
		return text;
	}

	public void selectNextEncounterFromDate(WebDriver driver, String date) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		nextEncounterFromDateField.sendKeys(date);
	}

	public String captureHospitalNumber_Table_MyNextEncounterList(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		String hospitalNumber = hospitalNumber_MyNextEncounter_table.getText();
		return hospitalNumber;
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

	public void clickOnTheNotesEntryTab(WebDriver driver) throws Throwable {
		explictWaitForElementToBeVisible(driver, notesEntryTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, notesEntryTab);
	}

	public void selectTheNotesInTheDropdown(WebDriver driver, String notes) throws Throwable {
		Thread.sleep(3000);
		explictWaitForElementToBeVisible(driver, notesDropdownBtn);
		dropdown(driver, notesDropdownBtn, searchBoxFieldForDropDown, notes);
	}

	public void clickOnTheYesButton_ConfirmationPopup(WebDriver driver) {
		try {
			wait_For_Invisibilty_Of_Loader(driver, 200);
			yesButtonConfirmationPopup.click();
			wait_For_Invisibilty_OfElement_ForLoader(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnNoBtn_ConfirmationPopup(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, noButtonConfirmationPopup);

	}

	public void clickOnTheSaveButton(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, saveButton);
		clickOnOkBtnIfDisplays(driver);
	}

	public void addTheFinalDiagnosis_RandomProgressRecord(WebDriver driver, String comments) throws Throwable {

//		explicityWaitForElemenToBeClickable(driver, newBtn_FinalDiagnosisProgressRecord);
//		newBtn_FinalDiagnosisProgressRecord.click();
//		explicityWaitForElemenToBeClickable(driver, newBtnPopup_FinalDiagnosisProgressRecord);
//		newBtnPopup_FinalDiagnosisProgressRecord.click();

		Set<String> FinalDiagnosis = new HashSet<>();
		scrolldown(driver);
		for (int i = 0; i < 1; i++) {
			Random random = new Random();
			String fd = "";

			do {
				fd = Final_Diagnosis[random.nextInt(Final_Diagnosis.length)];
			} while (FinalDiagnosis.contains(fd));

			FinalDiagnosis.add(fd);
			Thread.sleep(4000);
			diagnosisText_ProgressRecordPopup.sendKeys(fd);
			Thread.sleep(3000);
			wait_For_Invisibilty_OfElement_ForLoader(driver);
			suggestion.click();
//			diagnosisCommentText_ProgressRecordPopup.sendKeys(comments);
			clickOnTheElementUsedToJavascriptExecuter(driver, diagnosisActionBtn_ProgressRecordPopup);
		}
	}

	public void clickOnTheSubmit_popupCloseFinalDiagnosisProgressRecord(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		submitBtn_FinalDiagnosisProgressRecord.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		closeButton_FinalDiagnosisProgressRecord.click();
	}

	public void clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		previewPopupCloseButton.click();
	}

	public void addInvestigations(WebDriver driver, String inv) throws Throwable {
		scrolldown(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		serviceNameTextFieldIninvestigationsProcedureTab.sendKeys(inv);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		Thread.sleep(500);
		suggestionBox.click();
		noteTextFieldIninvestigationsProcedureTab.sendKeys("Test");
		Thread.sleep(2000);
		clickOnTheElementUsedToJavascriptExecuter(driver, addButtonIninvestigationsProcedureTab);
	}

	public String captureNoteName_visitDetail(WebDriver driver) {
		return noteName_visitDetails_1stRow.getText();
	}

	public String captureDoctorName_visitDetail(WebDriver driver) {
		return doctorName_visitDetails_1stRow.getText();
	}

	public String captureDepartment_visitDetail(WebDriver driver) {
		return department_visitDetails_1stRow.getText();
	}

	public String captureSignDate_visitDetail(WebDriver driver) {
		return signDate_visitDetails_1stRow.getText();
	}

	public String captureNotesEntryDate_visitDetail(WebDriver driver) {
		return notesEntryDate_visitDetails_1stRow.getText();
	}

	public void addTheCurrentMedication_1(WebDriver driver, String gn, String route, String pattern, String sd,
			String qty, String notes, String status) throws Throwable {

		wait_For_Invisibilty_OfElement_ForLoader(driver);
		genericNameTextFieldInCurrentMedicationTab.sendKeys(gn);
		suggestion_1.click();
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		dropdown(driver, routeDropdownBtn, searchBoxFieldForDropDown, route);
		dropdown(driver, repeatPatternDropDownBtn, searchBoxFieldForDropDown, pattern);

		startDate.sendKeys(sd);
		quantityText.sendKeys(qty);
		notesText.sendKeys(notes);
		scrollDownThePageUntilElementIsVisible(driver, statusDropDown);
		dropdown(driver, statusDropDown, searchBoxFieldForDropDown, status);
		addButtonInCurrentMedicationTab.click();
	}

	public void clickOnSignBtnInThePopUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToBottom(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, signBtnPopUP);
	}

	public void clickOnSignBtnInThePopUp_PG(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		scrollToBottom(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, signBtnPopUP_PG);
	}

	public String captureViewPopUpData(WebDriver driver) {
		return viewPopUp.getText();
	}

	public String captureEditPopUpData(WebDriver driver) {
		return viewPopUp.getText();
	}

	public void clickOnView_Action_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);

		if (!viewBtn_VisitDetails.isDisplayed()) {
			clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		}
		scrollDownThePageUntilElementIsVisible(driver, viewBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, viewBtn_VisitDetails);
	}

	public void enterDataInIframe_HistoryTabsWithClear(WebDriver driver, String data) throws Throwable {
//		scrolldown(driver);
//		WebElement iframe = iframe_CheifComplaintTab;
//		driver.switchTo().frame(iframe);
//		Thread.sleep(1000);
//		List<WebElement> list = otherNotesTextArea;
//		for (WebElement webElement : list) {
//			webElement.clear();
//			webElement.sendKeys(data);
//		}
//		driver.switchTo().defaultContent();
	}

	public void clickOnCopyAndCreate_Action_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, copyAndCreate_VisitDetails);
	}

	public void clickOnDelete_Action_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, deleteBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteBtn_VisitDetails);
	}

	public void checkThatNoDataInVisitDetails(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		try {
			if (noteName_visitDetails_1stRow.isDisplayed()) {
				Assert.fail("Note is not deleted");
			} else {
				System.out.println("successfully notes is deleted");
			}
		} catch (NoSuchElementException e) {

		}
	}

	public void clickOnSubmit_DeletePopUP(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, deleteBtn_deletePopUp);
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteBtn_deletePopUp);
	}

	public void clickOnIhaveSeenCheckBox_PopUP(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, iHaveSeenCheckbox);
		;
		clickOnTheElementUsedToJavascriptExecuter(driver, iHaveSeenCheckbox);
	}

	public void clickOnEdit_Action_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, actoinBtn_VisitDetails);
		;
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, editBtn_VisitDetails);
	}

	public void clickOnSignOrEdit_Action_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, signOrEditBtn_VisitDetails);
	}

	public void clickOnPencil_Edit(WebDriver driver) {
		pencilIcon_Edit_VisitDetail.click();
	}

	public void clickOnDeleteBtn_PopUp(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, deleteBtnPpoUp);
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteBtnPpoUp);
	}

	public void clickOnSubmit_DeletePopUP_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, deleteBtn_popup_VisiDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteBtn_popup_VisiDetails);
	}

	public void clickOnSignBtn_DeathNote(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, signBtn_DeathNote);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, signBtn_DeathNote);
	}

	public void clickOnDraftBtn_DeathNote(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, draftBtn_DeathNote);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, draftBtn_DeathNote);
	}

	public void clickOnPencilIcon_PopUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, pencilIcon_Edit_VisitDetail);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, pencilIcon_Edit_VisitDetail);
	}

	public void clickOnXIcon_Edit(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, xIcon_Edit);
		scrollDownTheStillEndOfThePage(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, xIcon_Edit);
	}

	public void clickOnSaveicon_PopUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, saveIconAfterEdit);
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		saveIconAfterEdit.click();
	}

	public String captureEditedData1stPopUp(WebDriver driver) {
		return editedData_1st_popup.getText();
	}

//	public void edit_Notes(WebDriver driver, String dieticianNotes, String bp, String height, String weight, String c,
//			String pulse, String rr, String comment) throws Throwable {
//		for (WebElement element : pencilIcon_Edit_VisitDetail_List) {
//			clickOnTheElementUsedToJavascriptExecuter(driver, element);
//
//			try {
//				if (iframe_CheifComplaintTab.isDisplayed()) {
//					enterDataInIframe_HistoryTabs(driver, dieticianNotes);
//				}
//			} catch (NoSuchElementException e) {
//			}
//
//			try {
//				if (bpText_vitalSign.isDisplayed()) {
//					enterDataInVitalSign(driver, bp, height, c, weight, pulse, rr);
//				}
//			} catch (NoSuchElementException e) {
//			}
//
//			try {
//				if (diagnosisText_ProgressRecordPopup.isDisplayed()) {
//					addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
//				}
//			} catch (NoSuchElementException e) {
//			}
//
//			saveIconAfterEdit.click();
//		}
//	}

	private boolean isIframePresent(WebDriver driver, String text) throws Throwable {

		try {
			enterDataInIframe_HistoryTabs(driver, text);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isVitalSignPresent(WebDriver driver, String bp, String height, String weight, String c,
			String pulse, String rr) {
		try {
			enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isFinalDiagnosisPresent(WebDriver driver, String comment) throws Throwable {
		try {
			addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickOnFetchLatestDataOption(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, fetchLatestDataBtn);
	}

	public void clickOnAssessmentPlanTab(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, assessmentPlanTab);
	}

	public String captureBpField(WebDriver driver) {
		return bpText_vitalSign.getAttribute("value");
	}

	public String captureHeightField(WebDriver driver) {
		return heightText_vitalSign.getAttribute("value");
	}

	public String captureWeightField(WebDriver driver) {
		return weightText_vitalSign.getAttribute("value");
	}

	public String capturePulseField(WebDriver driver) {
		return pulseText_VitalSign.getAttribute("value");
	}

	public String captureRrField(WebDriver driver) {
		return rrText_VitalSign.getAttribute("value");
	}

	public String captureTempField(WebDriver driver) {
		return temperature_VitalSign.getAttribute("value");
	}

	public String captureSpo2Field(WebDriver driver) {
		return spo2Text_VitalSign.getAttribute("value");
	}

	public void verifyCancelIconIsNotPresent(WebDriver driver) {
		try {
			if (!xIcon_Edit.isDisplayed()) {
				Assert.fail("cancel Icon Is Displayed");
			} else {
			}
		} catch (NoSuchElementException e) {
		}
	}

	public void selectCoSignDoctor(WebDriver driver, String doc) throws Throwable {
		// wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollDownThePageUntilElementIsVisible(driver, coSignDoctor_DropDown);
		dropdown2(driver, coSignDoctor_DropDown, searchBoxFieldForDropDown, doc);
	}

//	public void selectCoSignDoctor(WebDriver driver, String doc) {
//		wait_For_Invisibilty_OfElement_ForLoader(driver);
//		scrollDownThePageUntilElementIsVisible(driver, coSignDoctor_DropDown);
//		scrollToBottom(driver);
//		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, coSignDoctor_DropDown);
//		coSignDoctor_DropDown.click();
//		clickOnTheElementByUsingJavascriptExecuter(driver, searchBoxFieldForDropDown);
//		searchBoxFieldForDropDown.sendKeys(doc, Keys.DOWN, Keys.ENTER);
//	}

	public void checkThatRedColorAlertIsDisplayed(WebDriver driver) {
		try {
			if (!redColorAlert.isDisplayed()) {
				Assert.fail("Red color alert is not displayed");
			} else {
			}
		} catch (NoSuchElementException e) {
		}
	}

	public void clickOnRejectBtnInThePopUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToBottom(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, rejectBtn_PopUp);
	}

	public void enterRejectReason(WebDriver driver, String reason) {
		rejectReasonTextArea.sendKeys(reason);
	}

	public void clickOnSubmitBtnInThePopUp(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToBottom(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, submitBtn_RejectReason);
	}

	public void enterDeleteReason(WebDriver driver, String reason) {
		scrollDownThePageUntilElementIsVisible(driver, deleteReasonTextArea_RejectedNotes);
		// explictWaitForElementToBeVisible(driver, deleteReasonTextArea_RejectedNotes);
		deleteReasonTextArea_RejectedNotes.sendKeys(reason);
	}

	public void clickOnDeleteBtn_popUp_rejectedNotes(WebDriver driver) throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		scrollToBottom(driver);
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteBtn_RejectedNotesPopUp);
	}

	public void checkThatTextIsStriked(WebDriver driver) {
		String textDecoration = Row1_VisitDetails.getCssValue("text-decoration");
		boolean isStriked = textDecoration.contains("line-through");
		if (!isStriked) {
			Assert.fail("Text is not striked");
		} else {
			System.out.println("Text is striked");
		}
	}

	public void clickOnDocumentUploadIcon(WebDriver driver) throws Throwable {
		clickOnTheElementUsedToJavascriptExecuter(driver, uploadDocumentIcon);
	}

	public void chooseFile_UploadDocument(WebDriver driver, CharSequence Doc) {
		chooseFile.sendKeys(Doc);
	}

	public void clickOnSubmit_UploadDocument(WebDriver driver) {
		submitBtn_DocumentUpload.click();
	}

	public String captureDocumentDescription_DocumentUpload(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		return documentDescription_Table_DocumentUpload.getText();
	}

	public String captureUploadDate_DocumentUpload(WebDriver driver) {
		return uploadDate_Table_DocumentUpload.getText();
	}

	public String captureDoctorName_DocumentUpload(WebDriver driver) {
		return doctorName_Table_DocumentUpload.getText();
	}

	public void clickOnDeleteIcon_DocumentUpload(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, deleteIcon_Table_DocumentUpload);
	}

	public void enterReasonDeletePopUp(WebDriver driver, String reason) {
		reasonTextArea_DocumentUpload_DeletePopUp.sendKeys(reason);
	}

	public void uploadMultipleDocuments_Loop(WebDriver driver, String absoluteFilePath, int count) throws Throwable {
		for (int i = 0; i < count; i++) {
			clickOnDocumentUploadIcon(driver);
			chooseFile_UploadDocument(driver, absoluteFilePath);
			clickOnSubmit_UploadDocument(driver);
			String text = captureOkBtnText(driver);
			Assert.assertTrue(text.toLowerCase().contains("success"), "success message is miss matched");
			clickOnOkBtn(driver);
		}
	}

	public void uploadMultipleDocumentsForPastInvestigation_Edit_Loop(WebDriver driver, String absoluteFilePath,
			int count) throws Throwable {
		for (int i = 0; i < count; i++) {
			scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, pencilEditIcon_PastInvestigation);
			clickOnPencilIcon_PastInvestigationInEditPopUP(driver);
			clickOnDocumentUploadIcon(driver);
			chooseFile_UploadDocument(driver, absoluteFilePath);
			clickOnSubmit_UploadDocument(driver);
			String text = captureOkBtnText(driver);
			Assert.assertTrue(text.toLowerCase().contains("success"), "success message is miss matched");
			clickOnOkBtn(driver);
		}
	}

	public void uploadMultipleDocumentsForLab_Edit_Loop(WebDriver driver, String absoluteFilePath, int count)
			throws Throwable {
		for (int i = 0; i < count; i++) {
			scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, pencilEditIcon_labTab);
			clickOnPencilIcon_LabInEditPopUP(driver);
			clickOnDocumentUploadIcon(driver);
			chooseFile_UploadDocument(driver, absoluteFilePath);
			clickOnSubmit_UploadDocument(driver);
			String text = captureOkBtnText(driver);
			Assert.assertTrue(text.toLowerCase().contains("success"), "success message is miss matched");
			clickOnOkBtn(driver);
		}
	}

	public void deleteMultipleDocuments_Loop(WebDriver driver, String reason, int count) throws Throwable {
		for (int i = 0; i < count; i++) {
			clickOnDeleteIcon_DocumentUpload(driver);
			enterReasonDeletePopUp(driver, reason);
			clickOnSubmit_DeletePopUP(driver);
			Thread.sleep(2000);
		}
	}

	public int getRowSize_DocumentUpload(WebDriver driver) {
		return documentRows.size();
	}

	public String captureDocumentDescription_View(WebDriver driver) {
		return documentDescription_table_view.getText();
	}

	public String captureUploadDate_view(WebDriver driver) {
		return uploadedDate_table_view.getText();
	}

	public String captureDoctorName_view(WebDriver driver) {
		return doctorName_table_view.getText();
	}

	public void clickOnTheCloseButtonInTheEditPopUp(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		editPopupCloseButton.click();

	}

	public void clickOnPencilIcon_PastInvestigationInEditPopUP(WebDriver driver) throws Throwable {
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, pencilEditIcon_PastInvestigation);
		clickOnTheElementUsedToJavascriptExecuter(driver, pencilEditIcon_PastInvestigation);
	}

	public void clickOnPencilIcon_LabInEditPopUP(WebDriver driver) throws Throwable {
		scrollDownThePageUntilTheElementIsVisibleUsingTheActionClass(driver, pencilEditIcon_labTab);
		clickOnTheElementUsedToJavascriptExecuter(driver, pencilEditIcon_labTab);
	}

	public void clickOnAction_VisitDetails(WebDriver driver) throws Throwable {
		scrollDownThePageUntilElementIsVisible(driver, actoinBtn_VisitDetails);
		clickOnTheElementUsedToJavascriptExecuter(driver, actoinBtn_VisitDetails);
	}

	public void clickOnTheUplaodfButton(WebDriver driver) {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		uploadBtn_DocumentTab.click();
	}

	public void uploadTheDocument_DocumentTab(WebDriver driver, String filePath) throws Throwable {
		clickOnDocumentsTab(driver);
		clickOnTheUplaodfButton(driver);
		String AbsolutePath = convertToAbsolutePath(filePath);
		chooseFile_UploadDocument(driver, AbsolutePath);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display = 'block';", chooseFile);
		chooseFile.sendKeys(AbsolutePath);

		clickOnSubmit_UploadDocument(driver);
	}
}