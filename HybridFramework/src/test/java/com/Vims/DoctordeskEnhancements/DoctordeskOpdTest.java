package com.Vims.DoctordeskEnhancements;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class DoctordeskOpdTest extends BaseClass {

	@Test(invocationCount = 1)
	public void draftTheAllNotesInTheD() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
		String notes = "HISTORY & PHYSICAL";
		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain.";
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		// -----------History tabs iframes----------
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		// dp.addTheCurrentMedication(driver, route, pattern, startDate1, qty, notes,
		// status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * Progress record
		 * 
		 */
		String subjective = "persistent lower back pain for the past two weeks";

		String notes1 = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes1);

		dp.enterDataInIframe_HistoryTabs(driver, subjective);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String comment = "test";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential \r\n"
				+ "differential diagnoses based on the subjective and objective findings.]  \r\n"
				+ " Plan :- Treatment Plan: [Outline the specific treatments or interventions \r\n"
				+ "recommended for the patient's condition, including medications, therapies, \r\n"
				+ "procedures, and lifestyle modifications.]";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * Consultant notes
		 * 
		 * 
		 */
		String notes2 = "CONSULTATION NOTE";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes2);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * OT notes
		 * 
		 * 
		 */

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes3);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		String notes5 = "DEATH NOTES";
		String deathNotes = "Cause of Death: Acute myocardial infarction (heart attack)\r\n"
				+ "due to underlying hypertension and hyperlipidemia.\r\n"
				+ "Circumstances: Patient experienced sudden onset chest pain at home, \r\n"
				+ "received emergency care but pronounced dead upon arrival at the hospital.\r\n"
				+ "Family Notification: Next of kin informed of patient's passing, offered \r\n"
				+ "support and bereavement resources.\r\n"
				+ "Disposition: Patient's remains transferred to hospital morgue pending\r\n"
				+ " arrangements by family.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnTheSaveButton(driver);

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n" + "Goals:\r\n"
				+ "Reduce calories.\r\n" + "Increase fruits, veggies, lean proteins.\r\n"
				+ "Limit carbs, sugary drinks.\r\n" + "Plan:\r\n" + "Balanced meals, healthy snacks.\r\n"
				+ "Portion control, mindful eating.\r\n" + "Regular physical activity.\r\n" + "Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		/*
		 * 
		 * Hod
		 * 
		 * 
		 */

//		String un1 = futil.getProperyKeyValue("generalMedicineHOD_Un");
//		String pw1 = futil.getProperyKeyValue("generalMedicineHOD_PW");
//
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
//
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnAllPatientListTab(driver);
//		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes);
//		// -----------History tabs iframes----------
//		scrollToTop(driver);
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		// dp.addTheCurrentMedication(driver, route, pattern, startDate1, qty, notes,
//		// status);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.clickOnNextBtn_historyTabs(driver);
//		dp.clickOnTheYesButton_ConfirmationPopup(driver);
////
//
//		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.clickOnNextBtn_historyTabs(driver);
//		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnTheSaveButton(driver);
//		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);
//
//		/*
//		 * Progress record
//		 * 
//		 */
//
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes1);
//
//		dp.enterDataInIframe_HistoryTabs(driver, subjective);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.clickOnNextBtn_historyTabs(driver);
//		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
//		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
//		dp.clickOnTheSubmit_popupCloseFinalDiagnosisProgressRecord(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
//		dp.clickOnTheSaveButton(driver);
//		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);
//
//		/*
//		 * 
//		 * Consultant notes
//		 * 
//		 */
//
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes2);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.clickOnNextBtn_historyTabs(driver);
//		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
//		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.clickOnNextBtn_historyTabs(driver);
//		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
//		dp.clickOnTheSaveButton(driver);
//		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);
//
//		/*
//		 * OT notes
//		 * 
//		 */
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes3);
//
//		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
//		dp.clickOnTheSaveButton(driver);
//		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);
//
//		/*
//		 * 
//		 * POST OPERATIVE NOTES
//		 * 
//		 */
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes4);
//
//		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
//		dp.clickOnTheSaveButton(driver);
//		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);
//
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes5);
//
//		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
//		dp.clickOnTheSaveButton(driver);
//
//		dp.clickOnTheNotesEntryTab(driver);
//		dp.selectTheNotesInTheDropdown(driver, notes6);
//
//		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
//		dp.clickOnTheSaveButton(driver);

	}

	@Test(invocationCount = 50)
	public void createTheInvestigations() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "test";

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addThreeInvestigations(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
	}

	@Test
	public void createThePrescription() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		String repeatPattern = "1-1-1";
		String duration_prescription = "33";
		String route = "ORAL";
		String quantity = "33";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "test";

		// ----------Prescription-------------
		scrollToTop(driver);
		dp.clickOnPrescriptioinTab(driver);
		dp.clickOnNewBtnInPrescriptonTab(driver);
		dp.addThePrescriptons(driver, repeatPattern, duration_prescription, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);

	}

	@Test
	public void createTheFinalDiagnosis() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		String repeatPattern = "1-1-1";
		String duration_prescription = "33";
		String route = "ORAL";
		String quantity = "33";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String comments = "test";

		// --------final diagnosis--------
		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
		dp.addTheFinalDiagnosis_Random(driver, comments);
		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
	}

//	@Test
//	public void addTheDocuments() throws Throwable {
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
//		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
//		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
//		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
//		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
//		String repeatPattern = "1-1-1";
//		String duration_prescription = "33";
//		String route = "ORAL";
//		String quantity = "33";
//
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//		System.out.println("Hospital Number_OP : " + hospitalNumber);
//
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnAllPatientListTab(driver);
//		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//
//		// ---------------Documents-------------
//		scrollToTop(driver);
//		dp.clickOnDocumentsTab(driver);
//		dp.addDocumentsInDdOpd_Random(driver);
//
//	}

	@Test
	public void createTheNextEncounter() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		String repeatPattern = "1-1-1";
		String duration_prescription = "33";
		String route = "ORAL";
		String quantity = "33";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String comments = "test";
		// ------------Next encounter---------
		String subjective = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur, quam id ";
		String objective = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";
		String assessment = "eros eu gravida dictum, nunc ex laoreet justo, a interdum leo odio a dolor. Sed euismod risus ";
		String plan = "eu tortor efficitur, eu finibus justo scelerisque. Vestibulum id augue et ipsum tristique";
		String inv = "pellentesque. Vivamus eleifend, lectus vel scelerisque congue, justo metus blandit urna, nec ";

		// ------------Next encounter---------
		scrollToTop(driver);
		dp.clickOnNextEncounterTab(driver);
		// dp.addTheNextEncounter(driver, subjective, objective, assessment, plan, inv);
		dp.clickOnSubmitBtnInNextEncounterTb(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

	}

	@Test(invocationCount = 50)
	public void DataEntry() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";
		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain.\r\n"
				+ "\r\n"
				+ "History of Illness: Patient reports experiencing intermittent abdominal pain for the past two months, worsened after meals.\r\n"
				+ "\r\n"
				+ "PMH: Hypertension, controlled with medication. No other significant medical history reported.\r\n"
				+ "\r\n" + "PSH: Cholecystectomy performed in 2018.\r\n" + "\r\n"
				+ "Family Hx: Father had a history of heart disease; otherwise, family history unremarkable.\r\n"
				+ "\r\n" + "Social Hx: Works as a teacher. Nonsmoker, occasional alcohol use.\r\n" + "\r\n"
				+ "Drug & Food Allergy: Allergic to penicillin. No known food allergies.\r\n"
				+ "Past Investigation: Previous abdominal ultrasound showed gallstones.\r\n" + "\r\n"
				+ "Lab: CBC and BMP within normal limits. Lipid panel pending.\r\n" + "\r\n"
				+ "Provisional Diagnosis: Chronic cholecystitis.\r\n" + "\r\n" + "Plan:\r\n" + "\r\n"
				+ "Schedule follow-up for lipid panel results.\r\n"
				+ "Initiate dietary modifications to reduce fat intake.\r\n"
				+ "Consider referral to gastroenterology for further evaluation of chronic abdominal pain.";
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		// -----------History tabs iframes----------
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		// dp.addTheCurrentMedication(driver, route, pattern, startDate1, qty, notes,
		// status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * Progress record
		 * 
		 */
		String subjective = "persistent lower back pain for the past two weeks";

		String notes1 = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes1);

		dp.enterDataInIframe_HistoryTabs(driver, subjective);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String comment = "test";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential \r\n"
				+ "differential diagnoses based on the subjective and objective findings.]  \r\n"
				+ " Plan :- Treatment Plan: [Outline the specific treatments or interventions \r\n"
				+ "recommended for the patient's condition, including medications, therapies, \r\n"
				+ "procedures, and lifestyle modifications.]";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnTheSubmit_popupCloseFinalDiagnosisProgressRecord(driver);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * Consultant notes
		 * 
		 * 
		 */
		String notes2 = "CONSULTATION NOTE";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes2);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * OT notes
		 * 
		 * 
		 */

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes3);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		String notes5 = "DEATH NOTES";
		String deathNotes = "Cause of Death: Acute myocardial infarction (heart attack)\r\n"
				+ "due to underlying hypertension and hyperlipidemia.\r\n"
				+ "Circumstances: Patient experienced sudden onset chest pain at home, \r\n"
				+ "received emergency care but pronounced dead upon arrival at the hospital.\r\n"
				+ "Family Notification: Next of kin informed of patient's passing, offered \r\n"
				+ "support and bereavement resources.\r\n"
				+ "Disposition: Patient's remains transferred to hospital morgue pending\r\n"
				+ " arrangements by family.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnTheSaveButton(driver);

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n" + "Goals:\r\n"
				+ "Reduce calories.\r\n" + "Increase fruits, veggies, lean proteins.\r\n"
				+ "Limit carbs, sugary drinks.\r\n" + "Plan:\r\n" + "Balanced meals, healthy snacks.\r\n"
				+ "Portion control, mindful eating.\r\n" + "Regular physical activity.\r\n" + "Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addThreeInvestigations(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

		String repeatPattern = "1-1-1";
		String duration_prescription = "33";
		String quantity = "33";

		// ----------Prescription-------------
		scrollToTop(driver);
		dp.clickOnPrescriptioinTab(driver);
		dp.clickOnNewBtnInPrescriptonTab(driver);
		dp.addThePrescriptons(driver, repeatPattern, duration_prescription, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);

		String comments = "test";

		// --------final diagnosis--------
		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
		dp.addTheFinalDiagnosis_Random(driver, comments);
		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		// ------------Next encounter---------
		String objective = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";
		String assessment = "eros eu gravida dictum, nunc ex laoreet justo, a interdum leo odio a dolor. Sed euismod risus ";
		String plan = "eu tortor efficitur, eu finibus justo scelerisque. Vestibulum id augue et ipsum tristique";
		String inv = "pellentesque. Vivamus eleifend, lectus vel scelerisque congue, justo metus blandit urna, nec ";

		// ------------Next encounter---------
		scrollToTop(driver);
		dp.clickOnNextEncounterTab(driver);
		// dp.addTheNextEncounter(driver, subjective, objective, assessment, plan, inv);
		dp.clickOnSubmitBtnInNextEncounterTb(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

	}

	@Test
	public void checkThatUserAbleToUploadTheDocument_Test() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw = futil.getProperyKeyValue("generalMedicineHOD_PW");
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		String repeatPattern = "1-1-1";
		String duration_prescription = "33";
		String route = "ORAL";
		String quantity = "33";

		String filePath = "./src/main/resources/Documents/d1.PNG";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.uploadTheDocument_DocumentTab(driver, filePath);
	}

	@Test(invocationCount = 10)
	public void FullTabsData_OPD() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";
		String consultationNotes_historyAndPhysicalNotes = "Chest pain, 3 days.\r\n"
				+ "49M with sharp chest pain radiating to left arm, worse with exertion, 8/10, minimal relief with ibuprofen. No trauma/fever/chills.\r\n"
				+ "Appendectomy, 1995";
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		// -----------History tabs iframes----------
		scrollToTop(driver);
		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		// dp.addTheCurrentMedication(driver, route, pattern, startDate1, qty, notes,
		// status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * Progress record
		 * 
		 */
		String subjective = "persistent lower back pain for the past two weeks";

		String notes1 = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes1);

		dp.enterDataInIframe_HistoryTabs(driver, subjective);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);
//
		String comment = "test";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential \r\n"
				+ "differential diagnoses based on the subjective and objective findings.]  \r\n"
				+ " Plan :- Treatment Plan: [Outline the specific treatments or interventions \r\n"
				+ "recommended for the patient's condition, including medications, therapies, \r\n"
				+ "procedures, and lifestyle modifications.]";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * Consultant notes
		 * 
		 * 
		 */
		String notes2 = "CONSULTATION NOTE";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes2);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		/*
		 * 
		 * OT notes
		 * 
		 * 
		 */

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes3);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		String notes5 = "DEATH NOTES";
		String deathNotes = "Cause of Death: Acute myocardial infarction (heart attack)\r\n"
				+ "due to underlying hypertension and hyperlipidemia.\r\n"
				+ "Circumstances: Patient experienced sudden onset chest pain at home, \r\n"
				+ "received emergency care but pronounced dead upon arrival at the hospital.\r\n"
				+ "Family Notification: Next of kin informed of patient's passing, offered \r\n"
				+ "support and bereavement resources.\r\n"
				+ "Disposition: Patient's remains transferred to hospital morgue pending\r\n"
				+ " arrangements by family.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnTheSaveButton(driver);

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n" + "Goals:\r\n"
				+ "Reduce calories.\r\n" + "Increase fruits, veggies, lean proteins.\r\n"
				+ "Limit carbs, sugary drinks.\r\n" + "Plan:\r\n" + "Balanced meals, healthy snacks.\r\n"
				+ "Portion control, mindful eating.\r\n" + "Regular physical activity.\r\n" + "Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);
//
		String repeatPattern = "1-1-1";
		String duration_prescription = "33";
		String quantity = "33";

		String comments = "test";
		// ------------Next encounter---------

		String remarks = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";

		// ------------Next encounter---------
		scrollToTop(driver);
		dp.clickOnNextEncounterTab(driver);
		dp.addTheNextEncounter(driver, remarks);
		dp.clickOnSubmitBtnInNextEncounterTb(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		String filePath = "./src/main/resources/Documents/d1.PNG";
		// DOCUMENT UPLOAD
		// dp.uploadTheDocument_DocumentTab(driver, filePath);

		// --------final diagnosis--------
		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
		dp.addTheFinalDiagnosis_Random(driver, comments);
		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addThreeInvestigations(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

//		// ----------Prescription-------------
		scrollToTop(driver);
		dp.clickOnPrescriptioinTab(driver);
		dp.clickOnNewBtnInPrescriptonTab(driver);
		dp.addThePrescriptons(driver, repeatPattern, duration_prescription, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);

	}
}
