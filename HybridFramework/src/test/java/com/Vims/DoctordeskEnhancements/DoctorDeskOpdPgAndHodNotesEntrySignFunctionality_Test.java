package com.Vims.DoctordeskEnhancements;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class DoctorDeskOpdPgAndHodNotesEntrySignFunctionality_Test extends BaseClass {

	@Test(description = "Verify that PG is able to sign the History and physical note by co-signing HOD doctor and verify that HOD doctor is able to sign the PG H&P note")
	public void VerifyPGCanSignHistoryAndPhysicalNoteByCoSigningHODAndVerifyHODCanSignPGNote_test() throws Throwable {

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

		String consultationNotes_historyAndPhysicalNotes = "The headache has been gradually worsening over the last 48 hours and is exacerbated by bright lights and loud noises. John has a past medical history significant for hypertension diagnosed 3 years ago and a long-standing history of migraine headaches since adolescence. Additionally, he underwent an appendectomy at age 20. Family history reveals that his father has hypertension and type 2 diabetes, while his mother was diagnosed with breast cancer at age 50; however, there are no significant medical issues reported among his siblings. John has a blood type of A+ and reports an allergy to penicillin.";

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
		dp.clickOnNextBtn_historyTabs(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that PG is able to sign the Progress record by co-signing HOD doctor and verify that HOD doctor is able to sign the PG progrss record")
	public void VerifyPGCanSignProgressRecordByCoSigningHODAndVerifyHODCanSignPGProgressRecord_Test() throws Throwable {

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

		String subjective = "persistent lower back pain for the past two weeks";
		String notes = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

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
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential ";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that PG is able to sign the OT note by co-signing HOD doctor and verify that HOD doctor is able to sign the PG OT note")
	public void VerifyPGCanSignOtNoteByCoSigningHODAndVerifyHODCanSignPGOtNote_Test() throws Throwable {

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

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis Post-op Diagnosis: Acute appendiciti with perforation.Specimen Removed: Gangrenous appendix";
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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that PG is able to sign the consultation note by co-signing HOD doctor and verify that HOD doctor is able to sign the PG consultation note")
	public void VerifyPGCanSignConsultationNoteByCoSigningHODAndVerifyHODCanSignPGConsultationNote_Test()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
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
		System.out.println("Hospital Number_OP : " + hospitalNumber);

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

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain ";
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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that PG is able to sign the post operative note by co-signing HOD doctor and verify that HOD doctor is able to sign the PG post operative note")
	public void VerifyPGCanSignPostOperativeNoteByCoSigningHODAndVerifyHODCanSignPGPostoperativeNote_Test()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
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
		System.out.println("Hospital Number_OP : " + hospitalNumber);

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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that the red color alert is displayed next to the note name for the HOD doctor when the PG signs the History and Physical note by cosigning it to the HOD doctor")
	public void VerifyThatTheRedColorAlertIsDisplayedNextToTheNotenameForTheHODDoctorWhenThePGSignsTheHistoryAndPhysicalNoteByCosigningItToTheHODDoctor_Text()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "The headache has been gradually worsening over the last 48 hours and is exacerbated by bright lights and loud noises. John has a past medical history significant for hypertension diagnosed 3 years ago and a long-standing history of migraine headaches since adolescence. Additionally, he underwent an appendectomy at age 20. Family history reveals that his father has hypertension and type 2 diabetes, while his mother was diagnosed with breast cancer at age 50; however, there are no significant medical issues reported among his siblings. John has a blood type of A+ and reports an allergy to penicillin.";

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
		dp.clickOnNextBtn_historyTabs(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.checkThatRedColorAlertIsDisplayed(driver);

		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that the red color alert is displayed next to the note name for the HOD doctor when the PG signs the progress record by cosigning it to the HOD doctor")
	public void VerifyThatTheRedColorAlertIsDisplayedNextToTheNotenameForTheHODDoctorWhenThePGSignsTheProgressRecordNoteByCosigningItToTheHODDoctor_Text()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
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
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String subjective = "persistent lower back pain for the past two weeks";
		String notes = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

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
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential ";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.checkThatRedColorAlertIsDisplayed(driver);

		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that the red color alert is displayed next to the note name for the HOD doctor when the PG signs the OT note by cosigning it to the HOD doctor")
	public void VerifyThatTheRedColorAlertIsDisplayedNextToTheNotenameForTheHODDoctorWhenThePGSignsTheOTNoteByCosigningItToTheHODDoctor_Text()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
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
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis Post-op Diagnosis: Acute appendiciti with perforation.Specimen Removed: Gangrenous appendix";
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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.checkThatRedColorAlertIsDisplayed(driver);

		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that the red color alert is displayed next to the note name for the HOD doctor when the PG signs the Consultation note by cosigning it to the HOD doctor")
	public void VerifyThatTheRedColorAlertIsDisplayedNextToTheNotenameForTheHODDoctorWhenThePGSignsTheConsultationNoteByCosigningItToTheHODDoctor_Text()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
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
		System.out.println("Hospital Number_OP : " + hospitalNumber);

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

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain ";
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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.checkThatRedColorAlertIsDisplayed(driver);

		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that the red color alert is displayed next to the note name for the HOD doctor when the PG signs the Post operative note by cosigning it to the HOD doctor")
	public void VerifyThatTheRedColorAlertIsDisplayedNextToTheNotenameForTheHODDoctorWhenThePGSignsThePostOperativeNoteByCosigningItToTheHODDoctor_Text()
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
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
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
		System.out.println("Hospital Number_OP : " + hospitalNumber);

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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		dp.clickOnVisitDetailsTab(driver);
		dp.checkThatRedColorAlertIsDisplayed(driver);

		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that a doctor is able to reject the PG signed History and physical Notes")
	public void verifyThatHodIsAbleToRejectPgHistoryAndPhysicalNote_test() throws Throwable {

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

		String consultationNotes_historyAndPhysicalNotes = "The headache has been gradually worsening over the last 48 hours and is exacerbated by bright lights and loud noises. John has a past medical history significant for hypertension diagnosed 3 years ago and a long-standing history of migraine headaches since adolescence. Additionally, he underwent an appendectomy at age 20. Family history reveals that his father has hypertension and type 2 diabetes, while his mother was diagnosed with breast cancer at age 50; however, there are no significant medical issues reported among his siblings. John has a blood type of A+ and reports an allergy to penicillin.";

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
		dp.clickOnNextBtn_historyTabs(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Rejected successfully");
		dp.clickOnOkBtn(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String noteName_expected = notes + "   (PG SIGNED - DOCTOR " + doctorName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a doctor is able to reject the PG signed Progress record")
	public void verifyThatHodIsAbleToRejectPgSignedProgressRecord_test() throws Throwable {

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

		String subjective = "persistent lower back pain for the past two weeks";
		String notes = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

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
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential ";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Rejected successfully");
		dp.clickOnOkBtn(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String noteName_expected = notes + "   (PG SIGNED - DOCTOR " + doctorName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a doctor is able to reject the PG signed OT Notes")
	public void verifyThatDoctorIsAbleToRejectPgSignedOTNote_test() throws Throwable {

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

		String notes = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis Post-op Diagnosis: Acute appendiciti with perforation.Specimen Removed: Gangrenous appendix";
		scrollToTop(driver);
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, OtNotes);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Rejected successfully");
		dp.clickOnOkBtn(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String noteName_expected = notes + "   (PG SIGNED - DOCTOR " + doctorName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a doctor is able to reject the PG signed Consultation Notes")
	public void verifyThatDoctorIsAbleToRejectPgSignedConsultationNote_test() throws Throwable {

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

		/*
		 * Consultant notes
		 */

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain ";
		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
		String notes = "CONSULTATION NOTE";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Rejected successfully");
		dp.clickOnOkBtn(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String noteName_expected = notes + "   (PG SIGNED - DOCTOR " + doctorName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a doctor is able to reject the PG signed Post Operative Notes")
	public void verifyThatDoctorIsAbleToRejectPgSignedPostOperativeNote_test() throws Throwable {

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

		String notes = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis.\r\n"
				+ "Post-op Diagnosis: Acute cholecystitis with multiple cholelithiasis.\r\n"
				+ "Procedure: Laparoscopic cholecystectomy.\r\n" + "Post-op Instructions:\r\n"
				+ "Pain Management: Take prescribed pain medications as directed.\r\n"
				+ "Use ice packs on the incision sites to reduce swelling and discomfort.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Rejected successfully");
		dp.clickOnOkBtn(driver);

		String noteName = dp.captureNoteName_visitDetail(driver);
		String noteName_expected = notes + "   (PG SIGNED - DOCTOR " + doctorName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that the PG is able to delete the rejected H&P notes by the doctor and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatPgIsAbleToDeleteTheRejectedHistoryAndPhysicakNote_test() throws Throwable {

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

		String consultationNotes_historyAndPhysicalNotes = "The headache has been gradually worsening over the last 48 hours and is exacerbated by bright lights and loud noises. John has a past medical history significant for hypertension diagnosed 3 years ago and a long-standing history of migraine headaches since adolescence. Additionally, he underwent an appendectomy at age 20. Family history reveals that his father has hypertension and type 2 diabetes, while his mother was diagnosed with breast cancer at age 50; however, there are no significant medical issues reported among his siblings. John has a blood type of A+ and reports an allergy to penicillin.";

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
		dp.clickOnNextBtn_historyTabs(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.enterDeleteReason(driver, reason);
		dp.clickOnDeleteBtn_popUp_rejectedNotes(driver);
		dp.checkThatTextIsStriked(driver);
	}

	@Test(description = "Verify that the PG is able to delete the rejected Progress record by the doctor and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatPgIsAbleToDeleteTheRejectedProgressRecord_test() throws Throwable {

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

		String subjective = "persistent lower back pain for the past two weeks";
		String notes = "PROGRESS RECORD";
		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

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
		String Assessment = "Diagnosis/Differential Diagnosis: [List the confirmed diagnosis or potential ";

		dp.addTheFinalDiagnosis_RandomProgressRecord(driver, comment);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, Assessment);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.enterDeleteReason(driver, reason);
		dp.clickOnDeleteBtn_popUp_rejectedNotes(driver);
		dp.checkThatTextIsStriked(driver);
	}

	@Test(description = "Verify that the PG is able to delete the rejected OT notes by the doctor and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatPgIsAbleToDeleteTheRejectedOtNotes_test() throws Throwable {

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

		String notes3 = "OT NOTES";
		String OtNotes = "Pre-op Diagnosis: Acute appendicitis Post-op Diagnosis: Acute appendiciti with perforation.Specimen Removed: Gangrenous appendix";
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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.enterDeleteReason(driver, reason);
		dp.clickOnDeleteBtn_popUp_rejectedNotes(driver);
		dp.checkThatTextIsStriked(driver);
	}

	@Test(description = "Verify that the PG is able to delete the rejected consultation notes by the doctor and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatPgIsAbleToDeleteTheRejectedConsultationNotes_test() throws Throwable {

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

		/*
		 * Consultant notes
		 */

		String consultationNotes_historyAndPhysicalNotes = "Reason for Consultation: Patient referred for evaluation of persistent abdominal pain ";
		String bp = "12080";
		String height = "6";
		String weight = "58";
		String c = "32";
		String pulse = "98";
		String rr = "23";
		String notes = "CONSULTATION NOTE";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

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
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.enterDeleteReason(driver, reason);
		dp.clickOnDeleteBtn_popUp_rejectedNotes(driver);
		dp.checkThatTextIsStriked(driver);
	}

	@Test(description = "Verify that the PG is able to delete the rejected post operative notes by the doctor and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatPgIsAbleToDeleteTheRejectedPostOperativeNotes_test() throws Throwable {

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

		String notes = "POST OPERATIVE NOTES";
		String postOperativeNotes = "Pre-op Diagnosis: Cholecystitis with cholelithiasis.\r\n"
				+ "Post-op Diagnosis: Acute cholecystitis with multiple cholelithiasis.\r\n"
				+ "Procedure: Laparoscopic cholecystectomy.\r\n" + "Post-op Instructions:\r\n"
				+ "Pain Management: Take prescribed pain medications as directed.\r\n"
				+ "Use ice packs on the incision sites to reduce swelling and discomfort.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnNextBtn_historyTabs(driver);

		dp.enterDataInIframe_HistoryTabs(driver, postOperativeNotes);
		dp.clickOnTheSaveButton(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unHod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pwHod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unHod, pwHod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un, pw, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnDelete_Action_VisitDetails(driver);
		dp.enterDeleteReason(driver, reason);
		dp.clickOnDeleteBtn_popUp_rejectedNotes(driver);
		dp.checkThatTextIsStriked(driver);
	}
}
