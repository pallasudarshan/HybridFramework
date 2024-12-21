package com.Vims.PatientManagementTest;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskOpd2Test extends BaseClass {

	@Test
	public void verifyThatSystemShouldNotAllowToEnterDataWithoutDoingPatientArrival_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String doctorname = "rama";
		String depName = "general medicine";
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

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
		String inv = "pellentesque. Vivamus";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnNextEncounterTab(driver);
		dp.addTheNextEncounter(driver, inv);
		dp.clickOnSubmitBtnInNextEncounterTb(driver);
		String text = dp.captureOkBtnText(driver);
		dp.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Please Change Patient Arrival Status to Continue");
	}

	@Test
	public void verifyDateAndTimeAfterPatientArrivalIsDone_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		JavaUtility j = new JavaUtility();
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.capturePatientArrivalDateAndTime(driver);
		String text = dp.capturePatientArrivalDateAndTime(driver);
		String date = j.generateCurrentDate_DDMMYYYY();
		String time = j.generateCurrentTime_HHMM().replace(":", "").replaceAll("\\s", "");
		Assert.assertEquals(text, date + time);
	}

	@Test
	public void VerifyThatIfWeSelectTheTemplateTypeToViewTheDataInTheHistoryTabAndSubmitForEachAndEveryTab_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String template = "PAST";

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		scrollToTop(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnChiefComplaintTab(driver);
		dp.selectTemplateDropDown(driver, template);
		// List<String> text = dp.captureDataInIfrmame_HistoryTabs(driver);
//		System.out.println(text);
//		dp.clickOnNextBtn_historyTabs(driver);
//		Assert.assertTrue(text.contains("Status : YES /NO"));
	}

	@Test
	public void verifyThatUserShouldAbleToEditThePrescriptionDataAfterEditing_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");

		String repeatPattern = "1-1/2-0";
		String gn = "DOLOWIN SPAS TABLETS";
		String duration = "2";
		String route = "ORAL";
		String quantity = "2";
		String notes = "Testing";

		String repeatPattern1 = "0-1-1";
		String route1 = "EAR DROPS";
		String quantity1 = "5";
		String duration1 = "5";
		String notes1 = "Loreum Ipsum";

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnPrescriptioinTab(driver);
		dp.clickOnNewBtnInPrescriptonTab(driver);
		dp.addOnePrescriptons(driver, gn, repeatPattern, duration, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);
		dp.clickOnEditUnderAction_prescription(driver);
		dp.enterDataInPrescriptionAfterClickingOnEdit(driver, repeatPattern1, duration1, route1, quantity1, notes1);
		dp.clickOnUpdate_prescription(driver);
		String gn1 = dp.captureGenericName_Table_Prescription(driver);
		String rp = dp.captureRepeatPattern_Prescription(driver);
		String r = dp.captureRoute_Prescription(driver);
		String d = dp.captureDuration_Prescription(driver);
		String qty = dp.captureQuantity_Prescription(driver);
		String n = dp.captureNotes_Prescription(driver);
		dp.captureQuantity_Prescription(driver);
		dp.captureNotes_Prescription(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(gn1, gn, "Generic name is missmatched");
		sa.assertEquals(rp, repeatPattern1, "repeat pattern is missmatched");
		sa.assertEquals(r, route1, "route is missmatched");
		sa.assertEquals(d, duration1, "duration is missmatched");
		sa.assertEquals(qty, quantity1, "quantity is missmatched");
		sa.assertEquals(n, notes1, "notes is missmatched");
		sa.assertAll();
	}

	@Test
	public void verifyThatSystemShouldNotAbleToDoCrossReferralForSameDepartmentAndValidateTheErrorPopup_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String reason = "loreup ipsum";

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnCrossReferral_EnterData_ClickOnRequest(driver, depName, doctorname, reason);
		String text = dp.captureErrorText(driver);
		Assert.assertEquals(text, "for same department and doctor cross refferal can not be done");
	}

	@Test
	public void verifyThatAddedDiagnosisIsDisplayedProperlyInTheMoveOpToIp_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String comments = "Lorem ipsum dolor sit amet";

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
		dp.addTheFinalDiagnosis_Random(driver, comments);
		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
		List<String> dia = dp.captureListOfDiagnosis_FinalDiagnosis(driver);
		dp.clickOnMoveopToIp(driver);
		List<String> dia1 = dp.captureListOfDiagnosis_MoveOpToIp(driver);
		Assert.assertEquals(dia, dia1);
	}

	@Test
	public void verifyThatSystemShouldAbleToVerifyTheMlcDataOfThePatientDisplayedInDoctorDeskOpd_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String mlc = "MLC";
		String policeStation = "KR PURAM";
		String broughtBy = "FATHER";
		String contactName = "RAJU";
		String contactNumber = "";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		JavaUtility j = new JavaUtility();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2_Mlc(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, mlc, policeStation, broughtBy, contactName, contactNumber, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		String mlc1 = dp.captureMlcType_MlcDetails(driver);
		String policeStation1 = dp.capturePoliceStation_MlcDetails(driver);
		String broughtBy1 = dp.captureBroughtBy_MlcDetails(driver);
		String contactName1 = dp.captureContactName_MlcDetails(driver);
		String broughtDate = dp.captureBroughtDate_MlcDetails(driver);
		String currentDate = j.generateCurrentDate_DDMMYYYY();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals("MLC Type :" + mlc, mlc1);
		sa.assertEquals(policeStation, policeStation1);
		sa.assertEquals(broughtBy, broughtBy1);
		sa.assertEquals(contactName, contactName1);
//		sa.assertEquals(contactNumber, contactNumber1);
		sa.assertEquals(broughtDate, currentDate);
		sa.assertAll();
	}

	@Test
	public void verifyThatUserShouldAbleViewTheAllergyDataInTheHeaderOfDoctorDeskOpd_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String text = "Lorem ipsum dolor sit amet";

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnDrugAndFoodAllergy(driver);
		// dp.enterDataInIframe_HistoryTabs_1(driver, text);
		dp.clickOnNextBtn_historyTabs(driver);
		String text1 = dp.captureAllergies(driver);
		Assert.assertEquals(text, text1);
	}

	@Test
	public void verifyThatUserShouldAbleToValidateTheDepartmentAndUnitInTheHeader_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "GENERAL MEDICINE";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		String dept = dp.captureDeptHeader(driver);
		String unit = dp.captureUnitHeader(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(dept, depName);
		sa.assertEquals(unit, "6");
		sa.assertAll();
	}

	@Test
	public void verifyThatUserShouldAbleToRedirectToProgressRecordAfterSubmitThePlanDataInTheHistoryTabs_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = "rama";
		String depName = "general medicine";
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

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
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnPlanTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
		dp.clickOnNextBtn_historyTabs(driver);
		dp.verifySystemIsRedirectingToProgressRecord(driver);
	}

	@Test
	public void verifyThatSystemShouldAbleToDisplayThePopupOfDraftAndContinueAndCancelPopupAfterShiftToAnotherTabFromProgressRecord_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String doctorname = "rama";
		String depName = "general medicine";
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

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
		TestData.setHospitalNumber(hospitalNumber);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnProgressRecordTab(driver);
		dp.enterDataInIframe_ProgressRecord(driver);
		Thread.sleep(2000);
		dp.clickOnPrescriptioinTab(driver);
		dp.verifyDraFtAndContinueButtonIsDisplayingOrNot(driver);
	}

	@Test(dependsOnMethods = "verifyThatSystemShouldAbleToDisplayThePopupOfDraftAndContinueAndCancelPopupAfterShiftToAnotherTabFromProgressRecord_Test")
	public void verifyThatUserShouldAbleToClickOnCancelAndDataShouldNotBeDraftedAfterClickOnCancelButton_Test()
			throws Throwable {
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		String hospitalNumber = TestData.getHospitalNumber();

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnProgressRecordTab(driver);
		dp.enterDataInIframe_ProgressRecord(driver);
		Thread.sleep(2000);
		dp.clickOnPrescriptioinTab(driver);
		dp.clickOnCancelBtn(driver);
	}

	@Test
	public void verifyThatSystemShouldDisplayThePatientIsAlreadyAdmittedToClickHere_Test() throws Throwable {

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		int minusDate = 7;
		String date = jutil.generateDate_minusDate_ddMMyyyy(minusDate);

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		ap.selectdate(driver, minusDate);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber = ap.takeTheHospitalNumberInTheActivePatientTable(driver);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.clickOnShowAllFilterCheckBox(driver);
		dp.selectRegistrationFromDate(driver, date);
		dp.enterTheHospitalNumber(driver, hospitalNumber);
		dp.clickOnSearchBtn(driver);
		dp.clickOnHospitalNumberInTheAllPatientList(driver);
		String text = dp.capturePatientMovedToIpText(driver);
		Assert.assertEquals(text, "Patient Has been moved to IP Click here Ward Service");

	}

}
