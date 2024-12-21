package com.Vims.PatientManagementTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskOpd1Test extends BaseClass {

	@Test
	public void checkThatUserShouldBeAbleToSignTheProgressRecordUsingPastDateAndTime_Test() throws Throwable {
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
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		scrollToTop(driver);
		dp.clickOnProgressRecordTab(driver);

		String date = generateTwoDaysAgoDate_ddmmyyyy();
		System.out.println(date);
		String time = "0130";

		dp.enteDate_ProgressRecord(driver, date);
		dp.enterTime_ProgressRecord(driver, time);
		dp.enterDataInIframe_ProgressRecord(driver);

		// ----Progress record-----
		dp.clickOnSignBtn(driver);
		String dateAndTime = dp.captureDateAndTime_ProgressRecord(driver);
		Assert.assertEquals(date + " " + time, dateAndTime, "Date and time is miss matched");
	}

	@Test
	public void checkThatUserShouldBeAbleToSignTheProgressRecordUsingFutureDateAndTime_Test() throws Throwable {
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
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		scrollToTop(driver);
		dp.clickOnProgressRecordTab(driver);

		String date = generateTwoDaysFutureDate_ddmmyyyy();
		System.out.println(date);
		String time = "1245";

		dp.enteDate_ProgressRecord(driver, date);
		dp.enterTime_ProgressRecord(driver, time);
		dp.enterDataInIframe_ProgressRecord(driver);

		// ----Progress record-----
		dp.clickOnSignBtn(driver);
		String dateAndTime = dp.captureDateAndTime_ProgressRecord(driver);
		Assert.assertEquals(date + " " + time, dateAndTime);
	}

	@Test
	public void checkThatUserShouldBeAbleToDraftAndSignTheSameProgressRecord_Test() throws Throwable {
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
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		scrollToTop(driver);
		dp.clickOnProgressRecordTab(driver);
		dp.enterDataInIframe_ProgressRecord(driver);
		dp.clickOnDraftBtn(driver);
		dp.clickOnProgressRecord_ProgressRecordDetails(driver);
		// ----Progress record-----
		dp.clickOnSignBtn(driver);
		String status = dp.captureStatus_ProgressRecord(driver);
		Assert.assertEquals("Signed", status, "status is miss matched");
	}

	@Test
	public void checkThatAfterSigningProgressRecordDateAndTimeIsReflectingInVisitDetails_Test() throws Throwable {
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
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number_OP : " + hospitalNumber);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		scrollToTop(driver);
		dp.clickOnProgressRecordTab(driver);
		dp.enterDataInIframe_ProgressRecord(driver);
		dp.clickOnSignBtn(driver);
		String dateAndTime = dp.captureDateAndTime_ProgressRecord1(driver);
		scrollToTop(driver);
		dp.clickOnVisitDetailsTab(driver);
		String dateAndTime1 = dp.captureDateAndTime_VisitDetails(driver);
		Assert.assertEquals(dateAndTime, dateAndTime1, "date and time is miss matched");
	}

	@Test
	public void checkThatInvestigationAmountIsDisplayingAccuratlyAfterAdding_Test() throws Throwable {
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
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String notes = "testing";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addThreeInvestigations(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		int ta = dp.captureAndAddListOfTotslAmount_Investigation(driver);
		int ta1 = dp.captureInvestigationAmount_BillingDetails(driver);

		Assert.assertEquals(ta, ta1, "Investigation amount is miss matched");
	}

	@Test
	public void checkThatAddedFinalDiagnosisIsDisplayingInHeader_Test() throws Throwable {
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
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String comments = "Lorem ipsum dolor sit amet";
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
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnViewMoreBtn(driver);
		List<String> dia1 = dp.captureListOfDiagnosis_ViewMore(driver);
		Assert.assertEquals(dia, dia1);
	}

	@Test
	public void verifyThatTheuserIsAbleToRequestAndConfirmTheCrossReferralRequest_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String dep = "NEUROLOGY";
		String doc = "DR.SURESHA KODAPALA";
		String reason = "loreup ipsum";
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);
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
		dp.clickOnCrossReferral_EnterData_ClickOnRequest(driver, dep, doc, reason);
		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnCrossReferralTab(driver);
		ap.enterTheHospitalNumber(hospitalNumber);
		ap.clickOnTheSearchButton(driver);
		ap.clickOnCrConfirm_Table_CrossReferral(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(username, password, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.enterHospitalNumberAndClickOnSearch(driver, hospitalNumber);
		String dep1 = dp.captureDepartment_Table_AllPatientList(driver);
		Assert.assertEquals(dep, dep1, "department name is miss matched");

	}

	@Test
	public void checkThatAfterMoveOpToIp_ItIsReflectingInReferOpToIpTabUnderAllPatientListTab_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String dep = "NEUROLOGY";
		String doc = "DR.SURESHA KODAPALA";
		String reason = "loreup ipsum";
		String ward = "CRITICAL CARE UNIT";
		String unit = "1";
		String admittedBy = "DR.ABBAS";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);
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
		dp.clickOnMoveOpToIp_EnterDate_ClickOnSubmit(driver, reason, ward, dep, doc, unit, admittedBy);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnReferOpToIpTab(driver);
		ap.enterTheHospitalNumber(hospitalNumber);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber1 = ap.captureHospitalNumber_ReferOpTOIp(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

}
