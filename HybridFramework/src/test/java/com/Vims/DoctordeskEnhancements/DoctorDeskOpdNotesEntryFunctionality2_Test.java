package com.Vims.DoctordeskEnhancements;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class DoctorDeskOpdNotesEntryFunctionality2_Test extends BaseClass {

	@Test(description = "To verify that the note name, doctor name, department, sign date & time, and notes entry date & time are displayed correctly in the visit detail after the post-operative notes are signed.")
	public void verifyThatDetailsAreReflectedCorrectlyInTheVisitDetailsAfterPostOperativeNotesIsSigned_Test()
			throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
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
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);
		String department = dp.captureDepartment_visitDetail(driver);
		String signDate = dp.captureSignDate_visitDetail(driver);
		String notesEntryDate = dp.captureNotesEntryDate_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " POST OPERATIVE NOTES   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertTrue(department.contains("GENERAL MEDICINE"), "Department ");
		sa.assertEquals(signDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "sign date is miss matched");
		sa.assertEquals(signDate.substring(11, 16), generateCurrentTime_HHMM(), "sign time is miss matched");
		sa.assertEquals(notesEntryDate.substring(0, 10), generateCurrentDate_DDMMYYYY(),
				"notes entry data is miss matched");
		sa.assertEquals(notesEntryDate.substring(11, 16), generateCurrentTime_HHMM(),
				"notes entry time is miss matched");
		sa.assertAll();
	}

	@Test(description = "To verify that the note name, doctor name, department, sign date & time, and notes entry date & time are displayed correctly in the visit detail after the post-operative note is drafted")
	public void verifyThatDetailsAreReflectedCorrectlyInTheVisitDetailsAfterPostOperativeNoteIsDrafted_Test()
			throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
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

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);
		String department = dp.captureDepartment_visitDetail(driver);
		String signDate = dp.captureSignDate_visitDetail(driver);
		String notesEntryDate = dp.captureNotesEntryDate_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " POST OPERATIVE NOTES   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertTrue(department.contains("GENERAL MEDICINE"), "Department ");
		sa.assertEquals(signDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "sign date is miss matched");
		sa.assertEquals(notesEntryDate.substring(0, 10), generateCurrentDate_DDMMYYYY(),
				"notes entry data is miss matched");
		sa.assertAll();
	}

	@Test(description = "To verify that the note name, doctor name, department, sign date & time, and notes entry date & time are displayed correctly in the visit detail after the progress record is signed")
	public void verifyThatDetailsAreReflectedCorrectlyInTheVisitDetailsAfterProgressRecordIsSigned_Test()
			throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		String subjective = "persistent lower back pain for the past two weeks";

		String notes1 = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes1);

		dp.enterDataInIframe_HistoryTabs(driver, subjective);
		dp.clickOnNextBtn_historyTabs(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

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
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);
		String department = dp.captureDepartment_visitDetail(driver);
		String signDate = dp.captureSignDate_visitDetail(driver);
		String notesEntryDate = dp.captureNotesEntryDate_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " PROGRESS RECORD   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertTrue(department.contains("GENERAL MEDICINE"), "Department ");
		sa.assertEquals(signDate.substring(0, 10), generateCurrentDate_DDMMYYYY(), "sign date is miss matched");
		sa.assertEquals(notesEntryDate.substring(0, 10), generateCurrentDate_DDMMYYYY(),
				"notes entry data is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify Editing and Saving of Signed Post-operative Note in Visit Detail")
	public void verifyThatUserIsAbleToEditAndSaveTheSignedPostOperativeNote_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);

		String postOperativeNotes_edit = "test 5678";

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes_edit);
		dp.clickOnSaveicon_PopUp(driver);

		String editedDate = dp.captureEditedData1stPopUp(driver);
		System.out.println(postOperativeNotes_edit + postOperativeNotes);
		System.out.println(editedDate);
		Assert.assertTrue(editedDate.contains(postOperativeNotes_edit) && editedDate.contains(postOperativeNotes),
				"Edited date is not reflected after saving");
	}

	@Test(description = "Verify Editing and Saving of drafted Post-operative Note in Visit Detail")
	public void verifyThatUserIsAbleToEditAndSaveTheDraftedPostOperativeNote_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);
		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);

		String postOperativeNotes_edit = "test 5678";

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes_edit);
		dp.clickOnSaveicon_PopUp(driver);

		String editedDate = dp.captureEditedData1stPopUp(driver);
		System.out.println(postOperativeNotes_edit + postOperativeNotes);
		System.out.println(editedDate);
		Assert.assertTrue(editedDate.contains(postOperativeNotes_edit) && editedDate.contains(postOperativeNotes),
				"Edited date is not reflected after saving");
	}

	@Test(description = "Verify Editing and Saving of drafted OT Note in Visit Detail")
	public void VerifyThatUserIsAbleToEditAndSaveTheDraftedOtNotes_Test() throws Throwable {

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

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		// -----------History tabs iframes----------
		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis Post-op Diagnosis: Acute appendiciti";

		scrollToTop(driver);
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

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);

		String OtNotes_edit = "test 5678";

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes_edit);
		dp.clickOnSaveicon_PopUp(driver);

		String editedDate = dp.captureEditedData1stPopUp(driver);
		System.out.println(OtNotes_edit + OtNotes);
		System.out.println(editedDate);
		Assert.assertTrue(editedDate.contains(OtNotes_edit) && editedDate.contains(OtNotes),
				"Edited date is not reflected after saving");

	}

	@Test(description = "Verify Editing and Saving of signed OT Note in Visit Detail")
	public void VerifyThatUserIsAbleToEditAndSaveTheSignedOtNotes_Test() throws Throwable {

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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		// -----------History tabs iframes----------
		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis Post-op Diagnosis: Acute appendiciti";

		scrollToTop(driver);
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
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);

		String OtNotes_edit = "test 5678";

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes_edit);
		dp.clickOnSaveicon_PopUp(driver);

		String editedDate = dp.captureEditedData1stPopUp(driver);
		System.out.println(OtNotes_edit + OtNotes);
		System.out.println(editedDate);
		Assert.assertTrue(editedDate.contains(OtNotes_edit) && editedDate.contains(OtNotes),
				"Edited date is not reflected after saving");
	}

	@Test(description = "Verify that editing and saving of drafted Death Note in Visit Detail, and confirm that the updated data is displayed in the view option.")
	public void verifyThatUserIsAbleToEditAndSaveTheDraftedDeathNote_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);
		String deathNotesEdit = " received emergency care but pronounced dead upon arrival at the hospital";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnDraftBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.enterDataInIframe_HistoryTabs(driver, deathNotesEdit);
		dp.clickOnDraftBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		String updated_Data = dp.captureViewPopUpData(driver);

		System.out.println(deathNotesEdit + deathNotes);
		System.out.println(updated_Data);
		Assert.assertEquals(updated_Data, deathNotesEdit + deathNotes,
				"Edited data is not displayed in the view option");
	}

	@Test(description = "Verify that editing and saving of signed Death Note in Visit Detail, and confirm that the updated data is displayed in the view option.")
	public void verifyThatUserIsAbleToEditAndSaveTheSignedDeathNote_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = eutil.getDataFromTheExcel_DoctorDesk("DDNotesEntry", 0, 0);
		String deathNotesEdit = " received emergency care but pronounced dead upon arrival at the hospital";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.enterDataInIframe_HistoryTabs(driver, deathNotesEdit);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		String updated_Data = dp.captureViewPopUpData(driver);

		System.out.println(deathNotesEdit + deathNotes);
		System.out.println(updated_Data);
		Assert.assertTrue(updated_Data.contains(deathNotesEdit + deathNotes),
				"Edited data is not displayed in the view option");
	}

	@Test(description = "Verify that editing and saving of saved dietician Note in Visit Detail, and confirm that the updated data is displayed in the view option.")
	public void verifyThatUserIsAbleToEditAndSaveTheSavedDieticianNote_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = "Reason: Weight management Assessment: BMI: 32 (Obese)";
		String dieticianNotes_Edit = " Portion control, mindful eating Regular physical activity Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes_Edit);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);

		String updated_Data = dp.captureViewPopUpData(driver);

		System.out.println(dieticianNotes_Edit + dieticianNotes);
		System.out.println(updated_Data);
		Assert.assertTrue(updated_Data.contains(dieticianNotes_Edit + dieticianNotes),
				"Edited data is not displayed in the view option");
	}

	@Test(description = "Verify Editing and Saving of Signed H&P Note in Visit Detail")
	public void VerifyThatUserIsAbleToEditAndSaveTheHistoryAndPhysicalNote_Test() throws Throwable {

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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain";
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
		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
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

		String gn = "dolo";
		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		dp.addTheCurrentMedication_1(driver, gn, route, pattern, startDate1, qty, notes, status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

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

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);

		String hp_edit = "test 5678";

		dp.enterDataInIframe_HistoryTabs(driver, hp_edit);
		dp.clickOnSaveicon_PopUp(driver);

		String editedDate = dp.captureEditedData1stPopUp(driver);
		System.out.println(hp_edit + consultationNotes_historyAndPhysicalNotes);
		System.out.println(editedDate);
		Assert.assertTrue(
				editedDate.contains(hp_edit) && editedDate.contains(consultationNotes_historyAndPhysicalNotes),
				"Edited date is not reflected after saving");
	}

	@Test(description = "Verify that editing and saving of drafted progress record in Visit Detail ('Reason for visit','vital signs' , 'physical examination','lab','final diagnosis','assessment/plan'), and confirm that the updated data is displayed in the view option.")
	public void verifyThatUserIsAbleToEditAndSaveProgressRecordData_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		String subjective = "persistent lower back pain for the past two weeks";

		dp.enterDataInIframe_HistoryTabs(driver, subjective);
		dp.clickOnNextBtn_historyTabs(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		String comment = "test";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential procedures, and lifestyle modifications.]";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
//		dp.edit_Notes(driver, Assessment, bp, height, weight, c, pulse, rr, comment);
//		dp.clickOnVisitDetailsTab(driver);
	}

	@Test(description = "Verify Editing and Saving of drafted H&P Note in Visit Detail")
	public void VerifyThatUserIsAbleToEditAndSaveTheDraftedHistoryAndPhysicalNote_Test() throws Throwable {

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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain";
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
		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
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

		String gn = "dolo";
		String route = "ORAL";
		String pattern = "1-0-0";
		String startDate1 = "12";
		String qty = "12";
		String status = "CONTINUE";

		dp.addTheCurrentMedication_1(driver, gn, route, pattern, startDate1, qty, notes, status);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

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

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);

		String hp_edit = "test 5678";

		dp.enterDataInIframe_HistoryTabs(driver, hp_edit);
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		String editedDate = dp.captureEditedData1stPopUp(driver);
		System.out.println(hp_edit + consultationNotes_historyAndPhysicalNotes);
		System.out.println(editedDate);
		Assert.assertTrue(
				editedDate.contains(hp_edit) && editedDate.contains(consultationNotes_historyAndPhysicalNotes),
				"Edited date is not reflected after saving");
	}

	@Test(description = "Verify Vital Signs Fetch Latest Data functionality HISTORY & PHYSICAL")
	public void verifyVitalSigns_FetchLatestDta_HistoryAndPhysical_Test() throws Throwable {

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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain";
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
		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		// -----------History tabs iframes----------

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String temp = "45";
		String pulse = "98";
		String rr = "23";

		dp.clickOnVitalSignsTab(driver);
		dp.enterDataInVitalSign_2(driver, bp, height, temp, weight, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnPlanTab(driver);
		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.clickOnVitalSignsTab(driver);
		dp.clickOnFetchLatestDataOption(driver);

		Thread.sleep(2000);
		String bp_getText = dp.captureBpField(driver);
		String height_getText = dp.captureHeightField(driver);
		String weight_getText = dp.captureWeightField(driver);
		String temp_getText = dp.captureTempField(driver);
		String pulse_getText = dp.capturePulseField(driver);
		String rr_getText = dp.captureRrField(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(bp_getText.replace("/", ""), bp, "BP");
		sa.assertEquals(height_getText, height, "height");
		sa.assertEquals(weight_getText, weight, "weight");
		sa.assertEquals(temp_getText, temp, "temp");
		sa.assertEquals(pulse_getText, pulse, "pulse");
		sa.assertEquals(rr_getText, rr, "rr");
		sa.assertAll();
	}

	@Test(description = "Verify Vital Signs Fetch Latest Data functionality Progress record")
	public void verifyVitalSigns_FetchLatestDtaProgressRecord_Test() throws Throwable {

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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "Progress Record";

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain";
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
		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		// -----------History tabs iframes----------

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String temp = "45";
		String pulse = "98";
		String rr = "23";

		dp.clickOnVitalSignsTab(driver);
		dp.enterDataInVitalSign_2(driver, bp, height, temp, weight, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnAssessmentPlanTab(driver);
		dp.enterDataInIframe_HistoryTabs(driver, consultationNotes_historyAndPhysicalNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);
		dp.clickOnVitalSignsTab(driver);
		dp.clickOnFetchLatestDataOption(driver);

		Thread.sleep(2000);
		String bp_getText = dp.captureBpField(driver);
		String height_getText = dp.captureHeightField(driver);
		String weight_getText = dp.captureWeightField(driver);
		String temp_getText = dp.captureTempField(driver);
		String pulse_getText = dp.capturePulseField(driver);
		String rr_getText = dp.captureRrField(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(bp_getText.replace("/", ""), bp, "BP");
		sa.assertEquals(height_getText, height, "height");
		sa.assertEquals(weight_getText, weight, "weight");
		sa.assertEquals(temp_getText, temp, "temp");
		sa.assertEquals(pulse_getText, pulse, "pulse");
		sa.assertEquals(rr_getText, rr, "rr");
		sa.assertAll();
	}

	@Test(description = "Verify that users can cancel the editing process after clicking the edit icon for a signed post-operative note.")
	public void verifyThatUserIsAbleToCancelAfterClickingOnEditForSignedPostOperativeNote_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);
		dp.clickOnXIcon_Edit(driver);
		String text = dp.captureOkBtnText(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		Assert.assertEquals(text, "Do you want to Draft and Continue ?");
	}

	@Test(description = "Verify 'Do you want to Draft and Continue ?' confirmation message is displayed after clicking on cancel icon")
	public void verify_DoYouWantToDraftAndContinue_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);
		dp.clickOnXIcon_Edit(driver);
		String text = dp.captureOkBtnText(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		Assert.assertEquals(text, "Do you want to Draft and Continue ?");
	}

	@Test(description = "Verify that when the user clicks 'Cancel' during the editing process and then selects 'No' in the confirmation popup, they are redirected back to the editing process")
	public void VerifyRedirectionToEditingProcessAfterClickingCancelAndSelectingNoInTheConfirmationPopupDuringEdit_Test()
			throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);
		dp.clickOnXIcon_Edit(driver);
		dp.clickOnNoBtn_ConfirmationPopup(driver);
	}

	@Test(description = "Verify that if the user updates the data after clicking on 'Edit' and subsequently cancels the edit process, selecting 'No' in the confirmation pop-up, the updated data should not be saved")
	public void verifyThatDataIsNotSavedAfterCancellingEdit_Test() throws Throwable {
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
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String doctorName_visitDeatils = futil.getProperyKeyValue("generalmedicineHod");
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

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * POST OPERATIVE NOTES
		 */

		String notes4 = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis";
		String postOperativeNotes_Updated = "Test 352162 003298 trst";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes4);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnPencil_Edit(driver);
		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes_Updated);
		dp.clickOnXIcon_Edit(driver);
		dp.clickOnNoBtn_ConfirmationPopup(driver);

		String text = dp.captureViewPopUpData(driver);
		Assert.assertEquals(text, postOperativeNotes);
	}
}