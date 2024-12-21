package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;

public class Doctor_Desk_Ip_Test extends BaseClass {

	@Test(invocationCount = 1)
	public void checkThatUserShouldCreateTheFinalDiagnosis_Test() throws Throwable {
		String codeType = "ICD";
		String doctorName = "VIJAYA SAI";
		String name = "IP PATIENT";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = "IP PATIENT";
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String wardType = "INFECTION DISEASE WARD";
		String bedCategory = "INFECTION";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION";
		String floor = "5th FLOOR";
		String wings = "WEST WING";
		String bedUnitDepartment = "1";
		String roomType = "INFECTION";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";
		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "EAR DROPS";

		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);
		// patientAdmission
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);
		System.out.println(hospitalNumber);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// add investigations
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
//		ipd.clickOnInvestigationTab(driver);
//		ipd.scrolldown(driver);
//		Thread.sleep(3000);
//		ipd.clickAddBtnInInvestigationtab(driver);
//		ipd.addTheInvestigation(driver, notes);
//		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
//		System.out.println(hospitalNumber);
		// Pharmacy
		ipd.clickOnPharmacyTab(driver);
		ipd.plusButton_Pharmacy(driver);
		// ipd.addThe_Pharmacy(driver, pattern, qty, route, notes);
		// Ip consultation
		ipd.scrollUp(driver);
		ipd.clickOn_IpConsultant_Tab(driver);
		ipd.plusButton_IpConsultant(driver);
		ipd.Ip_Consultant_Process(driver, doctorName);
		// Next Enocunter
//		dp.clickOn_NextEncounter_Tab(driver);
//		dp.selectDate_NextEncounter(driver);
		// Diet plan
		ipd.scrolldown(driver);
		ipd.DietPlan_Tab(driver);
		ipd.clickOn_PlusBtn_DietPlan(driver);
		ipd.dietPlan_Process(driver);
		// Upload the documents
//		ipd.clickOn_DocumenytTab(driver);
//		ipd.addDocumentsInDdIpd_Random(driver);
		// --------current medication-------
		String route1 = "ORAL";
		String date = "12122023";
		String status = "Continue";
		scrollToTop(driver);
		ipd.clickOnHistoryTabs(driver);
		ipd.clickOnCurrentMedicationTab(driver);
		// ipd.addTheCurrentMedication(driver, route1, pattern, date, qty, notes,
		// status);
		scrollDownTheStillEndOfThePage(driver);
		ipd.clickOnNextBtn_currentMedication(driver);

		// -------vital signs-------
		String bp1 = "223456";
		String height = "174";

		scrollToTop(driver);
		ipd.clickOn_VitalSignTab(driver);
		ipd.vitalSign_Process(driver, bp1, height);

//		// -----------History tabs iframes----------
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnChiefComplaintTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnHistoryOfIlnessTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPmhTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnChiefComplaintTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnHistoryOfIlnessTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPmhTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
////		scrollToTop(driver);
////		ipd.clickOnPshTab(driver);
////		ipd.enterDataInIframe_HistoryTabs(driver);
////		ipd.clickOnNextBtn_historyTabs(driver);
////
////		scrollToTop(driver);
////		ipd.clickOnFamilyHx(driver);
////		ipd.enterDataInIframe_HistoryTabs(driver);
////		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnSocialHx(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
////
////		scrollToTop(driver);
////		ipd.clickOnDrugAndFoodAllergy(driver);
////		ipd.enterDataInIframe_HistoryTabs(driver);
////		ipd.clickOnNextBtn_historyTabs(driver);
//
////		scrollToTop(driver);
////		ipd.clickOnRosTab(driver);
////		ipd.enterDataInIframe_HistoryTabs(driver);
////		ipd.clickOnNextBtn_historyTabs(driver);
////
////		scrollToTop(driver);
////		ipd.clickOnGpeTab(driver);
////		ipd.enterDataInIframe_HistoryTabs(driver);
////		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPastInvestigationTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnProvisionalDiagnosisTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPlanTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		System.out.println(hospitalNumber);
//		// Final dignosis
//		ipd.clickOn_FinaleDiagnosis_Tab(driver);
//		ipd.enter_ICDCode_Description_FinalDiagnosis(driver, codeType);
//		ipd.clickOn_SubmitBtn_FinalDiagnosis(driver);
//		System.out.println("Hospital Number :- " + hospitalNumber);

	}

	/*
	 * @Test(invocationCount = 1) public void
	 * checkThatOnceEditDischargeSummaryVerifiyTheDataInTheText_Test() throws
	 * Throwable {
	 * 
	 * String Notes = ""; String result = "CURED"; String notes =
	 * "The patient has been discharged in stable condition.";
	 * 
	 * HomePage hp = new HomePage(driver); DoctorDesk_Ip_Page dp = new
	 * DoctorDesk_Ip_Page(driver);
	 * 
	 * dp.clickOnTheDoctorDeskIPDButton(driver); hp.homeBtnForvims(driver);
	 * 
	 * dp.clickOnAllPatientListInDDIPd(driver);
	 * dp.clickOnHospitalNumberInAllPatientListTab(driver);
	 * 
	 * dp.clickOn_DischargeSummary_Tab(driver); Notes =
	 * dp.dischargeSummaryNotes_Text(driver); String Notes1 = notes + Notes;
	 * System.out.println("notes   :-" + notes); System.out.println("Notes   :-" +
	 * Notes);
	 * 
	 * dp.click_PencilButton_Or_SelectDischargeResults(driver, result, notes);
	 * dp.clickOn_Draft_DischargeSummary(driver);
	 * 
	 * String Notes2 = dp.dischargeSummaryNotes_Text(driver);
	 * System.out.println("One :_" + Notes1); System.out.println("Second:_" +
	 * Notes2); Assert.assertEquals(Notes2, Notes1);
	 * 
	 * System.out.println("System verified");
	 * 
	 * }
	 */

	@Test(invocationCount = 1)
	public void checkThatOnceEditDischargeSummaryVerifiyTheDataInTheText_Test() throws Throwable {
		String patientStatus = "ACTIVE";

		String Notes = "";
		String result = "CURED";
		String notes = "The patient has been discharged in stable condition.";

		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page dp = new DoctorDesk_Ip_Page(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(driver, patientStatus);

		dp.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);

		dp.clickOnAllPatientListInDDIPd(driver);
		dp.clickOnHospitalNumberInAllPatientListTab(driver);

		dp.clickOn_DischargeSummary_Tab(driver);
		Notes = dp.dischargeSummaryNotes_Text(driver);
		String Notes1 = notes + Notes;
		System.out.println("notes   :-" + notes);
		System.out.println("Notes   :-" + Notes);
		dp.click_PencilButton_Or_SelectDischargeResults(driver, result, notes);
		dp.clickOn_Draft_DischargeSummary(driver);
		String Notes2 = dp.dischargeSummaryNotes_Text(driver);
		System.out.println("One :_" + Notes1);
		System.out.println("Second:_" + Notes2);
		Assert.assertEquals(Notes2, Notes1);
		System.out.println("System verified");

	}
//	@Test(invocationCount = 1)
//	public void checkThatOnceEditDischargeSummaryVerifiyTheDataInTheText_Test() throws Throwable {
//
//		String Notes = "";
//		String result = "CURED";
//		String notes = "The patient has been discharged in stable condition.";
//
//		HomePage hp = new HomePage(driver);
//		DoctorDesk_Ip_Page dp = new DoctorDesk_Ip_Page(driver);
//
//		dp.clickOnTheDoctorDeskIPDButton(driver);
//		hp.homeBtnForvims(driver);
//
//		dp.clickOnAllPatientListInDDIPd(driver);
//		dp.clickOnHospitalNumberInAllPatientListTab(driver);
//		dp.clickOn_DischargeSummary_Tab(driver);
//		Notes = dp.dischargeSummaryNotes_Text(driver);
//		String Notes1 = notes + Notes;
//		System.out.println("notes   :-" + notes);
//		System.out.println("Notes   :-" + Notes);
//		dp.click_PencilButton_Or_SelectDischargeResults(driver, result, notes);
//		dp.clickOn_Draft_DischargeSummary(driver);
//		String Notes2 = dp.dischargeSummaryNotes_Text(driver);
//		System.out.println("One :_" + Notes1);
//		System.out.println("Second:_" + Notes2);
//		Assert.assertEquals(Notes2, Notes1);
//		System.out.println("System verified");
//
//	}

	@Test(invocationCount = 1)
	public void emergencyIpPatientGenerate_Test() throws Throwable {

		String registrationType = "EMERGENCY";
		String department = "NEUROLOGY";
		String doctor = "MOHAN";
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION";
		String floor = "5TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "abbas";
		String time = "";
		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "12345";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String route = "ORAL";

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);

		hp.homeBtnForvims(driver);
		op.createOpdRegistrationForIpPatients(driver, registrationType, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		// add investigations
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		Thread.sleep(3000);
		ipd.clickAddBtnInInvestigationtab(driver);
		// ipd.addTheInvestigation(driver, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		System.out.println(hospitalNumber);
		// Pharmacy
		ipd.clickOnPharmacyTab(driver);
		ipd.plusButton_Pharmacy(driver);
		// ipd.addThe_Pharmacy(driver, pattern, qty, route, notes);
		System.out.println(hospitalNumber + "Hospital Number");

//		// Ip consultation
//		ipd.scrollUp(driver);
//		ipd.clickOn_IpConsultant_Tab(driver);
//		ipd.plusButton_IpConsultant(driver);
//		ipd.Ip_Consultant_Process(driver, doctorName);

		// Diet plan
		ipd.scrolldown(driver);
		ipd.DietPlan_Tab(driver);
		ipd.clickOn_PlusBtn_DietPlan(driver);
		ipd.dietPlan_Process(driver);
//
		// --------current medication-------
		String route1 = "ORAL";
		String date = "12122023";
		String status = "Continue";
		scrollToTop(driver);
		ipd.clickOnHistoryTabs(driver);
		ipd.clickOnCurrentMedicationTab(driver);
		// ipd.addTheCurrentMedication(driver, route1, pattern, date, qty, notes,
		// status);
		scrollDownTheStillEndOfThePage(driver);
		ipd.clickOnNextBtn_currentMedication(driver);
//
		// -----------History tabs iframes----------
//		scrollToTop(driver);
//		ipd.clickOnHistoryTabs(driver);
//		ipd.clickOnChiefComplaintTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnHistoryOfIlnessTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPmhTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnSocialHx(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPastInvestigationTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnProvisionalDiagnosisTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		scrollToTop(driver);
//		ipd.clickOnPlanTab(driver);
//		ipd.enterDataInIframe_HistoryTabs(driver);
//		ipd.clickOnNextBtn_historyTabs(driver);
//		System.out.println(hospitalNumber);

		// Final dignosis
//		ipd.clickOn_FinaleDiagnosis_Tab(driver);
//		ipd.enter_ICDCode_Description_FinalDiagnosis(driver, codeType);
//		ipd.clickOn_SubmitBtn_FinalDiagnosis(driver);
//		System.out.println("Hospital Number :- " + hospitalNumber);
	}

}
