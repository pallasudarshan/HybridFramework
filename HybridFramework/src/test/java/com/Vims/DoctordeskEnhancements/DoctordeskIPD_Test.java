package com.Vims.DoctordeskEnhancements;

import java.util.List;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.ExcelUtility;
import com.Dalvkot.Vims_GenericUtility.FileUtility;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.PAC_Anaesthesia_SchedulePage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.otConfirmationPage;

public class DoctordeskIPD_Test extends BaseClass {

	@Test
	public void draftTheAllNotes() throws Throwable {

		String doctorname = "rama mishra";
		String depName = "general medicine";
		String un = "automationp@demo.com";
		String pw = "12345";
		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "ACUTE CARE UNIT";
		String bedRoomType = "ACUTE CARE UNIT";
		String floor = "4th FLOOR";
		String wings = "EAST WING";
		String time = "";
		String address = "Test";
		String fname = "t";
		String pincode = "560066";
		String postOffice = "WHITEFIELD";
		String assignDoctorName = "rama mishra";

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		OTSchedulingPage ots = new OTSchedulingPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain";

		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims3(driver, fname, address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		String notesEntry = "HISTORY & PHYSICAL";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.clickOnClearButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		ipd.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, assignDoctorName);
		ipd.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notesEntry);

		// -----------History tabs iframes----------

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);
		ipd.clickOnTheYesButton_ConfirmationPopup(driver);

		String bp1 = "12080";
		String height = "6";
		String weight = "58";
		String pulse = "98";
		String rr = "23";
		String c = "30";

		ipd.enterDataInVitalSign(driver, bp1, height, weight, c, pulse, rr);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);
		ipd.clickOnTheYesButton_ConfirmationPopup(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnTheSaveButton(driver);
		ipd.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * Progress record
		 * 
		 */
		String subjective = "persistent lower back pain for the past two weeks";

		String notes1 = "PROGRESS RECORD";
		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notes1);

		ipd.enterDataInIframe_HistoryTabs(driver, subjective);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInVitalSign(driver, bp1, height, weight, c, pulse, rr);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);
		ipd.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String comment = "test";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential";

		ipd.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		ipd.clickOnTheSubmit_popupCloseFinalDiagnosisProgressRecord(driver);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, Assessment);
		ipd.clickOnTheSaveButton(driver);
		ipd.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * Consultant notes
		 * 
		 */
		String notes2 = "CONSULTATION NOTE";

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notes2);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);
		ipd.clickOnTheYesButton_ConfirmationPopup(driver);

		ipd.enterDataInVitalSign(driver, bp1, height, weight, c, pulse, rr);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.clickOnNextBtn_historyTabs(driver);
		ipd.clickOnTheYesButton_ConfirmationPopup(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		ipd.clickOnTheSaveButton(driver);
		ipd.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * OT notes
		 * 
		 */

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notes3);

		ipd.enterDataInIframe_HistoryTabs(driver, OtNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, OtNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, OtNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, OtNotes);
		ipd.clickOnTheSaveButton(driver);
		ipd.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * POST OPERATIVE NOTES
		 * 
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis.\r\n"
				+ "Post-op Diagnosis: Acute cholecystitis with multiple cholelithiasis.\r\n"
				+ "Procedure: Laparoscopic cholecystectomy.\r\n" + "Post-op Instructions:\r\n"
				+ "Pain Management: Take prescribed pain medications as directed.\r\n"
				+ "Use ice packs on the incision sites to reduce swelling and discomfort.";

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notes4);

		ipd.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		ipd.clickOnNextBtn_historyTabs(driver);

		ipd.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		ipd.clickOnTheSaveButton(driver);
		ipd.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		String notes5 = "DEATH NOTES";
		String deathNotes = "Cause of Death: Acute myocardial infarction (heart attack)\r\n"
				+ "due to underlying hypertension and hyperlipidemia.\r\n"
				+ "Circumstances: Patient experienced sudden onset chest pain at home, \r\n"
				+ "received emergency care but pronounced dead upon arrival at the hospital.\r\n"
				+ "Family Notification: Next of kin informed of patient's passing, offered \r\n"
				+ "support and bereavement resources.\r\n"
				+ "Disposition: Patient's remains transferred to hospital morgue pending\r\n"
				+ " arrangements by family.";

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notes5);

		ipd.enterDataInIframe_HistoryTabs(driver, deathNotes);
		ipd.clickOnTheSaveButton(driver);

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n";

		ipd.clickOnTheNotesEntryTab(driver);
		ipd.selectTheNotesInTheDropdown(driver, notes6);

		ipd.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		ipd.clickOnTheSaveButton(driver);

	}

	@Test
	public void AddTheInvestigations() throws Throwable {
		String un = "automationp@demo.com";
		String pw = "12345";
		String assignDoctorName = "rama mishra";
		ExcelUtility eutil = new ExcelUtility();
		List<String> investigations = eutil.fetchDataFromExcel("Investigation", 0);

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);

		String hospitalNumber = "8813058";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		ipd.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, assignDoctorName);
		ipd.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "test";

		/*
		 * Add TheInvestigations
		 * 
		 */
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);
		ipd.addTheInvestigation(driver, notes, investigations);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
	}

	@Test
	public void addThePharmacy() throws Throwable {
		String un = "automationp@demo.com";
		String pw = "12345";
		String assignDoctorName = "rama mishra";
		ExcelUtility eutil = new ExcelUtility();
		List<String> pharmacy = eutil.fetchDataFromExcel("Investigation", 1);
		String notes = "test";
		String pattern = "1-1-1";
		String qty = "23";
		String route = "ORAL";

		String hospitalNumber = "8813058";

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		ipd.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, assignDoctorName);
		ipd.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		ipd.clickOnPharmacyTab(driver);
		ipd.plusButton_Pharmacy(driver);
		ipd.addThe_Pharmacy(driver, pattern, qty, route, notes, pharmacy);
		System.out.println(hospitalNumber + "Hospital Number");

	}

}
