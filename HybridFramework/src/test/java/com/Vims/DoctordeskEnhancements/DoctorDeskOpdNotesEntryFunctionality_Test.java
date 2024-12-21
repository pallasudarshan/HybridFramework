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

public class DoctorDeskOpdNotesEntryFunctionality_Test extends BaseClass {

	@Test(description = "Verify that the PG is able to draft the history and physical by entering data in all tabs. Ensure that the drafted notes is displayed in the visit details tab")
	public void VerifyPGIsAbleToDraftHistoryAndPhysicalByEnteringDataInAllTabs_Test() throws Throwable {

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

		String gn = "Test";
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

		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " HISTORY & PHYSICAL   (PG DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to sign the history and physical by entering data in all tabs. Ensure that the signed notes is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToSignHistoryAndPhysicalByEnteringDataInAllTabs_Test() throws Throwable {

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
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " HISTORY & PHYSICAL   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the PG is able to draft the Progress record by entering data in all tabs. Ensure that the drafted notes is displayed in the visit details tab")
	public void VerifyPGIsAbleToDraftProgressRecordByEnteringDataInAllTabs_Test() throws Throwable {
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
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " PROGRESS RECORD   (PG DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to Sign the Progress record by entering data in all tabs. Ensure that the Signed notes is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToSignProgressRecordByEnteringDataInAllTabs_Test() throws Throwable {
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

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " PROGRESS RECORD   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify User Can View Signed Progress Record Notes in Visit Details by Clicking on 'View' Option under Action")
	public void VerifyUserCanViewSignedProgressRecordNotesInVisitDetailsByClickingOnViewOptionUnderAction_Test()
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

		dp.enterDataInIframe_HistoryTabsWithClear(driver, subjective);
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

		String comment = "comments entered for tesing";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential differential diagnoses based on the subjective and objective findings";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabsWithClear(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);
		String view = dp.captureViewPopUpData(driver);
		System.out.println(view);
		SoftAssert sa = new SoftAssert();
//		sa.assertTrue(view.contains(Assessment), "Assessment text is not displayed in the view pop up");
//		sa.assertTrue(view.contains(subjective), "Subjective text is not displayed in the view pop up");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to copy and create the signed progress record in the visit details, and ensure that a new row is created with the progress record drafted.")
	public void VerifyUserIsAbleToCopyAndCreateTheSignedProgressRecordInTheVisitDetails() throws Throwable {
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

		dp.enterDataInIframe_HistoryTabsWithClear(driver, subjective);
		dp.clickOnNextBtn_historyTabs(driver);

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";

		String userName = captureUserName(driver);

		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);

		dp.clickOnNextBtn_historyTabs(driver);
		dp.clickOnTheYesButton_ConfirmationPopup(driver);

		String comment = "comments entered for tesing";
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential differential diagnoses based on the subjective and objective findings";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabsWithClear(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnCopyAndCreate_Action_VisitDetails(driver);
		Thread.sleep(4000);
		String successText = dp.captureErrorText(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(successText, "Copied note!", "success pop up message is miss matched");
		sa.assertEquals(noteName, " PROGRESS RECORD   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to copy and create the drafted progress record in the visit details, and ensure that a new row is created with the progress record drafted.")
	public void VerifyUserIsAbleToCopyAndCreateTheDraftedProgressRecordInTheVisitDetails() throws Throwable {
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
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnCopyAndCreate_Action_VisitDetails(driver);
		Thread.sleep(4000);
		String successText = dp.captureErrorText(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(successText, "Copied note!", "success pop up message is miss matched");
		sa.assertEquals(noteName, " PROGRESS RECORD   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete drafted progress records in the visit details and ensure that the data is deleted from the visit details.")
	public void VerifyUserIsAbleToDeleteTheDraftedProgressRecordInTheVisitDetails() throws Throwable {
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
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.clickOnSubmit_DeletePopUP(driver);

		String successText = dp.captureErrorText(driver);
		dp.checkThatNoDataInVisitDetails(driver);
		Assert.assertEquals(successText, "Deleted successfully!", "success pop up message is miss matched");
	}

	@Test(description = "Verify that the user is able to edit and sign the drafted progress records in the visit details")
	public void VerifyUserIsAbleToEditAndSignTheDraftedProgressRecordInTheVisitDetails() throws Throwable {
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
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String successText = dp.captureOkBtnText(driver);
		dp.clickOnOkBtn(driver);

		Assert.assertEquals(successText, "Signed successfully", "success pop up message is miss matched");
	}

	@Test(description = "Verify that the user is able to edit and delete the drafted progress records in the visit details")
	public void VerifyUserIsAbleToEditAndDeleteTheDraftedProgressRecordInTheVisitDetails() throws Throwable {
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
		dp.clickOnTheCloseButtonInTheAllNotePreviewPopupCloaseButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnEdit_Action_VisitDetails(driver);
		dp.clickOnDeleteBtn_PopUp(driver);
		dp.clickOnSubmit_DeletePopUP_VisitDetails(driver);

		String successText = dp.captureErrorText(driver);
		dp.checkThatNoDataInVisitDetails(driver);
		Assert.assertEquals(successText, "Deleted successfully!", "success pop up message is miss matched");
	}

	@Test(description = "Verify that the PG is able to draft the OT notes by entering data in all tabs. Ensure that the drafted notes is displayed in the visit details tab")
	public void VerifyPgIsAbleToDraftOtNotesByEnteringDataInAllTabs_Test() throws Throwable {

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
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

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
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " OT NOTES   (PG DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to sign the OT notes by entering data in all tabs. Ensure that the signed notes is displayed in the visit details tab")
	public void VerifyPgIsAbleToSignOtNotesByEnteringDataInAllTabs_Test() throws Throwable {

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

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

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
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " OT NOTES   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete drafted OT Notes in the visit details and ensure that the data is deleted from the visit details.")
	public void VerifyUserIsAbleToDeleteTheOtNotesInTheVisitDetails() throws Throwable {
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

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis.\r\n" + "Post-op Diagnosis: Acute appendiciti\r\n"
				+ "with perforation.\r\n" + "Specimen Removed: Gangrenous appendix.\r\n"
				+ "Procedure Description: Laparoscopic appendectomy\r\n" + " performed under \r\n"
				+ "general anesthesia. A 1.5 cm infraumbilical incision \r\n"
				+ "made for camera insertion followed by two additional\r\n"
				+ " 0.5 cmtrocar incisions in the right lower quadrant.";

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
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.clickOnSubmit_DeletePopUP(driver);

		String successText = dp.captureErrorText(driver);
		dp.checkThatNoDataInVisitDetails(driver);
		Assert.assertEquals(successText, "Deleted successfully!", "success pop up message is miss matched");
	}

	@Test(description = "Verify that the Doctor is able to sign the Consultation Note by entering data in all tabs. Ensure that the Signed notes is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToSignConsultationNoteByEnteringDataInAllTabs_Test() throws Throwable {
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
		 * Consultant notes
		 */

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

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
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
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " CONSULTATION NOTE   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to draft the Consultation Note by entering data in all tabs. Ensure that the Drafted note is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToDraftConsultationNoteByEnteringDataInAllTabs_Test() throws Throwable {
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
		 * Consultant notes
		 */

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

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
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

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " CONSULTATION NOTE   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete drafted consultataion note in the visit details and ensure that the data is deleted from the visit details.")
	public void VerifyUserIsAbleToDeleteTheDraftedConsultationNoteInTheVisitDetails() throws Throwable {
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
		 * Consultant notes
		 */

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

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
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

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.clickOnSubmit_DeletePopUP(driver);

		String successText = dp.captureErrorText(driver);
		dp.checkThatNoDataInVisitDetails(driver);
		Assert.assertEquals(successText, "Deleted successfully!", "success pop up message is miss matched");
	}

	@Test(description = "Verify that the user is able to copy and create the signed consultation note in the visit details, and ensure that a new row is created")
	public void VerifyUserIsAbleToCopyAndCreateTheSignedConsultationNoteInTheVisitDetails() throws Throwable {
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
		 * Consultant notes
		 */

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

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
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
		dp.clickOnSignBtnInThePopUp(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnCopyAndCreate_Action_VisitDetails(driver);
		Thread.sleep(4000);
		String successText = dp.captureErrorText(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);
		String userName = dp.captureUserName(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(successText, "Copied note!", "success pop up message is miss matched");
		sa.assertEquals(noteName, " CONSULTATION NOTE   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to copy and create the drafted consultation note in the visit details, and ensure that a new row is created")
	public void VerifyUserIsAbleToCopyAndCreateTheDraftedConsultationNoteInTheVisitDetails() throws Throwable {
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
		 * Consultant notes
		 */

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

		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
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

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnCopyAndCreate_Action_VisitDetails(driver);
		Thread.sleep(4000);
		String successText = dp.captureErrorText(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);
		String userName = dp.captureUserName(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(successText, "Copied note!", "success pop up message is miss matched");
		sa.assertEquals(noteName, " CONSULTATION NOTE   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to sign the POST OPERATIVE NOTES by entering data in all tabs. Ensure that the Signed notes is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToSignPostOperativeNotesByEnteringDataInAllTabs_Test() throws Throwable {
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

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " POST OPERATIVE NOTES   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to draft the Post Operative Notes by entering data in all tabs. Ensure that the Drafted note is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToDraftPostOperativeNotesByEnteringDataInAllTabs_Test() throws Throwable {
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

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " POST OPERATIVE NOTES   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to draft the death Note by entering data in all tabs. Ensure that the Drafted note is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToDraftDeathNotes2_Test() throws Throwable {
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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " DEATH NOTES   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to sign the death Note. Ensure that the signed note is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToSignDeathNotes_Test() throws Throwable {
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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " DEATH NOTES   (DOCTOR SIGNED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the Doctor is able to draft the death Note. Ensure that the drafted note is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToDraftDeathNotes_Test() throws Throwable {
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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnDraftBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " DEATH NOTES   (DOCTOR DRAFTED)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete drafted death note in the visit details and ensure that the data is deleted from the visit details.")
	public void VerifyUserIsAbleToDeleteTheDraftedDeathNoteInTheVisitDetails() throws Throwable {
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

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnDraftBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.clickOnSubmit_DeletePopUP(driver);

		String successText = dp.captureErrorText(driver);
		dp.checkThatNoDataInVisitDetails(driver);
		Assert.assertEquals(successText, "Deleted successfully!", "success pop up message is miss matched");
	}

	@Test(description = "Verify that the Doctor is able to save the DIETICIAN Notes. Ensure that the saved note is displayed in the visit details tab")
	public void VerifyDoctorIsAbleToSaveDieticianNotes_Test() throws Throwable {
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
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n" + "Goals:\r\n"
				+ "Reduce calories.\r\n" + "Increase fruits, veggies, lean proteins.\r\n"
				+ "Limit carbs, sugary drinks.\r\n" + "Plan:\r\n" + "Balanced meals, healthy snacks.\r\n"
				+ "Portion control, mindful eating.\r\n" + "Regular physical activity.\r\n" + "Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		String userName = captureUserName(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(noteName, " DIETICIAN NOTES   (DOCTOR NOTE)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to copy and create the saved dietician note in the visit details, and ensure that a new row is created")
	public void VerifyUserIsAbleToCopyAndCreateTheSavedDieticianNoteInTheVisitDetails() throws Throwable {
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
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n" + "Goals:\r\n"
				+ "Reduce calories.\r\n" + "Increase fruits, veggies, lean proteins.\r\n"
				+ "Limit carbs, sugary drinks.\r\n" + "Plan:\r\n" + "Balanced meals, healthy snacks.\r\n"
				+ "Portion control, mindful eating.\r\n" + "Regular physical activity.\r\n" + "Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnCopyAndCreate_Action_VisitDetails(driver);
		Thread.sleep(4000);
		String successText = dp.captureErrorText(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String docName = dp.captureDoctorName_visitDetail(driver);
		String userName = dp.captureUserName(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(successText, "Copied note!", "success pop up message is miss matched");
		sa.assertEquals(noteName, " DIETICIAN NOTES   (DOCTOR NOTE)", "Note name is miss matched");
		sa.assertEquals(docName, userName, "Doctor name is miss matched");
		sa.assertAll();
	}

	@Test(description = "Verify that the user is able to delete saved dietician note in the visit details and ensure that the data is deleted from the visit details.")
	public void VerifyUserIsAbleToDeleteTheSavedDieticianNoteInTheVisitDetails() throws Throwable {
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
		String dieticianNotes = "Reason: Weight management.\r\n" + "Assessment:\r\n" + "BMI: 32 (Obese).\r\n"
				+ "Current Diet:\r\n" + "High processed foods, low fruits/veggies.\r\n" + "Goals:\r\n"
				+ "Reduce calories.\r\n" + "Increase fruits, veggies, lean proteins.\r\n"
				+ "Limit carbs, sugary drinks.\r\n" + "Plan:\r\n" + "Balanced meals, healthy snacks.\r\n"
				+ "Portion control, mindful eating.\r\n" + "Regular physical activity.\r\n" + "Follow-Up: One month.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.clickOnSubmit_DeletePopUP(driver);

		String successText = dp.captureErrorText(driver);
		dp.checkThatNoDataInVisitDetails(driver);
		Assert.assertEquals(successText, "Deleted successfully!", "success pop up message is miss matched");
	}

	@Test(description = "Verify User Can View saved dietician Notes in Visit Details by Clicking on 'View' Option under Action")
	public void VerifyUserCanViewSavedDieticaisnNotesInVisitDetailsByClickingOnViewOptionUnderAction_Test()
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
		 * DIETICIAN NOTES
		 */

		String notes6 = "DIETICIAN NOTES";
		String dieticianNotes = "lacking energy. Dietary habits include regular consumption of fast food and sugary snacks. Patient's BMI is above the healthy range.Recommended dietary changes: Increase intake of fruits, vegetables, and lean proteins. Reduce consumption of processed foods and sugary beverages.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes6);

		dp.enterDataInIframe_HistoryTabs(driver, dieticianNotes);
		dp.clickOnTheSaveButton(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);
		String view = dp.captureViewPopUpData(driver);
		System.out.println(view);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(view.contains(dieticianNotes), "dietician Notes is not displayed in the view pop up");
		sa.assertAll();
	}

	@Test(description = "Verify User Can View signed death Notes in Visit Details by Clicking on 'View' Option under Action")
	public void VerifyUserCanViewSignedDeathNotesInVisitDetailsByClickingOnViewOptionUnderAction_Test()
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
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = "Patient reports occasional dizziness. Blood pressure readings consistently above 140/90 mmHg";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnSignBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);
		String view = dp.captureViewPopUpData(driver);
		System.out.println(view);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(view.contains(deathNotes), "Notes is not displayed in the view pop up");
		sa.assertAll();
	}

	@Test(description = "Verify User Can View drafted death Notes in Visit Details by Clicking on 'View' Option under Action")
	public void VerifyUserCanViewDraftedDeathNotesInVisitDetailsByClickingOnViewOptionUnderAction_Test()
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
		 * DEATH NOTES
		 */

		String notes5 = "DEATH NOTES";
		String deathNotes = "Patient presents with worsening mood, insomnia and loss of appetite";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes5);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.clickOnDraftBtn_DeathNote(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnView_Action_VisitDetails(driver);
		String view = dp.captureViewPopUpData(driver);
		System.out.println(view);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(view.contains(deathNotes), "Notes is not displayed in the view pop up");
		sa.assertAll();
	}

}
