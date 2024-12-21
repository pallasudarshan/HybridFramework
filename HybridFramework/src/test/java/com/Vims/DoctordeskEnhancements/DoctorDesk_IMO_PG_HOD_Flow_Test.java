package com.Vims.DoctordeskEnhancements;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class DoctorDesk_IMO_PG_HOD_Flow_Test extends BaseClass {

	@Test(description = "Verify that an IMO is able to sign the History and Physical (H&P) note by cosigning to a PG doctor.\r\n"
			+ "Verify that a PG doctor is able to sign the IMO H&P note by cosigning it to the HOD doctor.\r\n"
			+ "Verify that the HOD is able to sign the PG H&P note.")
	public void verifyHistoryAndPhysicalNoteSigningFlowbyImoPgAndHod_Test() throws Throwable {

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
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "Patient presented with several symptoms indicative of moderate depression.";

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

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String un_pg = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw_pg = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_pg, pw_pg, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		String un_hod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw_hod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_hod, pw_hod, driver, doctorName_visitDeatils);

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

	@Test(description = "Verify that an IMO is able to sign the progress record by cosigning to a PG doctor.\r\n"
			+ "Verify that a PG doctor is able to sign the IMO progress record by cosigning it to the HOD doctor.\r\n"
			+ "Verify that the HOD is able to sign the PG progress record.")
	public void verifyProgressRecordSigningFlowbyImoPgAndHod_Test() throws Throwable {

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

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String notes = "PROGRESS RECORD";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		String subjective = "persistent lower back pain for the past two weeks";
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String un_pg = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw_pg = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_pg, pw_pg, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		String un_hod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw_hod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_hod, pw_hod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that an IMO is able to sign the OT note by cosigning to a PG doctor.\r\n"
			+ "Verify that a PG doctor is able to sign the IMO OT note by cosigning it to the HOD doctor.\r\n"
			+ "Verify that the HOD is able to sign the OT note.")
	public void verifyOtNoteSignFunctionalityFlowbyImoPgAndHod_Test() throws Throwable {

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

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String un_pg = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw_pg = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_pg, pw_pg, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		String un_hod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw_hod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_hod, pw_hod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that an IMO is able to sign the post operative note by cosigning to a PG doctor.\r\n"
			+ "Verify that a PG doctor is able to sign the IMO post operative note by cosigning it to the HOD doctor.\r\n"
			+ "Verify that the HOD is able to sign the post operative note.")
	public void verifyPostOperativeNoteSignFunctionalityFlowbyImoPgAndHod_Test() throws Throwable {

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

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String un_pg = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw_pg = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_pg, pw_pg, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		Thread.sleep(3000);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		String un_hod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw_hod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_hod, pw_hod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that an IMO is able to sign the consultation note by cosigning to a PG doctor.\r\n"
			+ "Verify that a PG doctor is able to sign the IMO consultation note by cosigning it to the HOD doctor.\r\n"
			+ "Verify that the HOD is able to sign the consultation note.")
	public void verifyConsultationNoteSignFunctionalityFlowbyImoPgAndHod_Test() throws Throwable {

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

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String un_pg = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw_pg = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_pg, pw_pg, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		Thread.sleep(3000);
		dp.selectCoSignDoctor(driver, doctorName_visitDeatils);
		dp.clickOnSignBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		String un_hod = futil.getProperyKeyValue("generalMedicineHOD_Un");
		String pw_hod = futil.getProperyKeyValue("generalMedicineHOD_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_hod, pw_hod, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnIhaveSeenCheckBox_PopUP(driver);
		dp.clickOnSignBtnInThePopUp(driver);
		String text = dp.captureOkBtnText(driver);
		Assert.assertEquals(text, "Signed successfully");
		dp.clickOnOkBtn(driver);
	}

	@Test(description = "Verify that a PG is able to reject the IMO signed History and physical Notes")
	public void verifyThatPGIsAbleToRejectImoHistoryAndPhysicalNote_test() throws Throwable {

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
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "The headache has been gradually worsening over the last 48 hours and is exacerbated by bright lights and loud noises.";

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

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
		String noteName_expected = notes + "   (IMO SIGNED - DOCTOR " + PGName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a PG is able to reject the IMO signed Progress record")
	public void verifyThatPGIsAbleToRejectImoProgressRecord_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

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
		String noteName_expected = notes + "   (IMO SIGNED - DOCTOR " + PGName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a PG is able to reject the IMO signed OT note")
	public void verifyThatPGIsAbleToRejectImoOtNotes_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

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
		String noteName_expected = notes + "   (IMO SIGNED - DOCTOR " + PGName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a PG is able to reject the IMO signed consultation note")
	public void verifyThatPGIsAbleToRejectImoConsultationNote_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

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
		String noteName_expected = notes + "   (IMO SIGNED - DOCTOR " + PGName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a PG is able to reject the post operative note")
	public void verifyThatPGIsAbleToRejectPostOperativeNote_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

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
		String noteName_expected = notes + "   (IMO SIGNED - DOCTOR " + PGName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that a PG is able to reject the IMO signed death note")
	public void verifyThatPGIsAbleToRejectImoDeathNote_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes = "DEATH NOTES";
		String deathNotes = "Cause of Death: Acute myocardial infarction (heart attack)\r\n"
				+ "due to underlying hypertension and hyperlipidemia.\r\n"
				+ "Circumstances: Patient experienced sudden onset chest pain at home, \r\n"
				+ "received emergency care but pronounced dead upon arrival at the hospital.\r\n"
				+ "Family Notification: Next of kin informed of patient's passing, offered \r\n"
				+ "support and bereavement resources.\r\n"
				+ "Disposition: Patient's remains transferred to hospital morgue pending\r\n"
				+ " arrangements by family.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

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
		String noteName_expected = notes + "   (IMO SIGNED - DOCTOR " + PGName_visitDeatils + " REJECTED)";
		Assert.assertEquals(noteName.replace(" ", ""), noteName_expected.replace(" ", ""),
				"Note name is miss matched in visit details tab");
	}

	@Test(description = "Verify that the IMO is able to delete the rejected H&P notes by the PG and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatImoIsAbleToDeleteTheRejectedHistoryAndPhysicalNote_test() throws Throwable {

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
		String notes = "HISTORY & PHYSICAL";

		String consultationNotes_historyAndPhysicalNotes = "The headache has been gradually worsening over the last 48 hours and is exacerbated by bright lights and loud noises.";

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, doctorName_visitDeatils);

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

	@Test(description = "Verify that the IMO is able to delete the rejected progress record by the PG and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatImoIsAbleToDeleteTheRejectedProgressRecord_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, doctorName_visitDeatils);

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

	@Test(description = "Verify that the IMO is able to delete the rejected OT notes by the PG and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatImoIsAbleToDeleteTheRejectedOtNotes_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, doctorName_visitDeatils);

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

	@Test(description = "Verify that the IMO is able to delete the rejected Consultation notes by the PG and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatImoIsAbleToDeleteTheRejectedConsultationNotes_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, doctorName_visitDeatils);

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

	@Test(description = "Verify that the IMO is able to delete the rejected post operative notes by the PG and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatImoIsAbleToDeleteTheRejectedPostOperativeNote_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
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
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, doctorName_visitDeatils);

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

	@Test(description = "Verify that the IMO is able to delete the rejected death notes by the PG and ensure that in the visit details tab, Note Name, Doctor Name, Department (Unit), Sign Date, and Notes Entry Date are striked")
	public void verifyThatImoIsAbleToDeleteTheRejectedDeathNote_test() throws Throwable {

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

		String PGName_visitDeatils = futil.getProperyKeyValue("generalmedicinePG");

		String un_imo = futil.getProperyKeyValue("generalMedicineIMO_Un");
		String pw_imo = futil.getProperyKeyValue("generalMedicineIMO_PW");
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, PGName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, PGName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		/*
		 * DEATH NOTES
		 */

		String notes = "DEATH NOTES";
		String deathNotes = "Cause of Death: Acute myocardial infarction (heart attack)\r\n"
				+ "due to underlying hypertension and hyperlipidemia.\r\n"
				+ "Circumstances: Patient experienced sudden onset chest pain at home, \r\n"
				+ "received emergency care but pronounced dead upon arrival at the hospital.\r\n"
				+ "Family Notification: Next of kin informed of patient's passing, offered \r\n"
				+ "support and bereavement resources.\r\n"
				+ "Disposition: Patient's remains transferred to hospital morgue pending\r\n"
				+ " arrangements by family.";

		dp.clickOnTheNotesEntryTab(driver);
		dp.selectTheNotesInTheDropdown(driver, notes);

		dp.enterDataInIframe_HistoryTabs(driver, deathNotes);
		dp.selectCoSignDoctor(driver, PGName_visitDeatils);
		dp.clickOnSignBtnInThePopUp_PG(driver);

		String unPG = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pwPG = futil.getProperyKeyValue("generalMedicinePG_PW");

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(unPG, pwPG, driver, doctorName_visitDeatils);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName_visitDeatils);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "rejected for testing";

		dp.clickOnVisitDetailsTab(driver);
		dp.clickOnSignOrEdit_Action_VisitDetails(driver);
		dp.clickOnRejectBtnInThePopUp(driver);
		dp.enterRejectReason(driver, reason);
		dp.clickOnSubmitBtnInThePopUp(driver);
		dp.clickOnOkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLoginForPgAndHIMO(un_imo, pw_imo, driver, doctorName_visitDeatils);

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
