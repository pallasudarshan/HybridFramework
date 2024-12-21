package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskTestScripts_Test extends BaseClass {

	@Test
	public void checkThatUserIsAbleToDoPatientArrivalSuccessfully_OPD_Test() throws Throwable {
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
		String text = dp.captureErrorText(driver);
		Assert.assertEquals(text, "Successfully Updated the patient arrival status");
	}

//	@Test
//	public void checkThatUserIsAbleToAddInvestigation_OPD_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//		String notes = "testing";
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnInvestigationTab(driver);
//		dp.clickOnNewBtnInInvestigationTab(driver);
//		dp.scrolldown(driver);
//		dp.addThreeInvestigations(driver, notes);
//		dp.clickOnSubmitBtnInInvestigationsTab(driver);
//		String text = dp.captureErrorText(driver);
//		Assert.assertEquals(text, "Created successfully");
//	}
//
//	@Test
//	public void checkThatUserIsAbleToAddDataInFinalDiagnosis_OPD_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//		String comments = "Lorem ipsum dolor sit amet";
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
//		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
//		dp.addTheFinalDiagnosis_Random(driver, comments);
//		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
//		String text = dp.captureErrorText(driver);
//		Assert.assertEquals(text, "created successfully");
//	}
//
//	@Test
//	public void checkThatUserIsAbleToAddPrescription_OPD_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//		String repeatPattern = "1-1/2-0";
//		String duration = "2";
//		String route = "ORAL";
//		String quantity = "2";
//		String notes = "Testing";
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnPrescriptioinTab(driver);
//		dp.clickOnNewBtnInPrescriptonTab(driver);
//		dp.addThePrescriptons(driver, repeatPattern, duration, route, quantity, notes);
//		dp.clickOnSubmitBtnInPrescriptionTab(driver);
//		String text = dp.captureErrorText(driver);
//		Assert.assertEquals(text, "Successfully created Drug Prescription..!");
//	}
//
//	@Test
//	public void checkThatUserIsAbleToAddNextEncounter_OPD_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//		String subjective = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur, quam id ";
//		String objective = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";
//		String assessment = "eros eu gravida dictum, nunc ex laoreet justo, a interdum leo odio a dolor. Sed euismod risus ";
//		String plan = "eu tortor efficitur, eu finibus justo scelerisque. Vestibulum id augue et ipsum tristique";
//		String inv = "pellentesque. Vivamus eleifend, lectus vel scelerisque congue, justo metus blandit urna, nec ";
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnNextEncounterTab(driver);
//		dp.addTheNextEncounter(driver, subjective, objective, assessment, plan, inv);
//		dp.clickOnSubmitBtnInNextEncounterTb(driver);
//		String text = dp.captureErrorText(driver);
//		Assert.assertEquals(text, "Created successfully");
//	}
//
//	@Test
//	public void checkThatUserIsAbleToUploadDocuments_Test() throws Throwable {
// HomePage hp = new HomePage(driver);
// DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
// LogOutPage l = new LogOutPage(driver);
// LoginPage lp = new LoginPage(driver);
// String name = "S";
// String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
// String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
// String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
// String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
// String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
// String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
// String doctorname = "rama";
// String depName = "general medicine";
// String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
// OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
// opdregistrationpage.opdRegistrationButton(driver);
// hp.homeBtnForvims(driver);
// opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
// postOffice, depName, doctorname);
// String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
// String un = "medicine_rama1234@vimsmail.com";
// String pw = "12345";
// l.logoutTheApplication(driver);
// lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
// hp.homeBtnForvims(driver);
// dp.clickOnTheDoctorDeskOpdScreenButton(driver);
// dp.clickOnMyPatientListTab(driver);
// dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);

	@Test
	public void checkThatUserIsAbleToAddInvestigation_OPD_Test() throws Throwable {
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
		String text = dp.captureErrorText(driver);
		Assert.assertEquals(text, "Created successfully");
	}

	@Test
	public void checkThatUserIsAbleToAddDataInFinalDiagnosis_OPD_Test() throws Throwable {
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
		String text = dp.captureErrorText(driver);
		Assert.assertEquals(text, "created successfully");
	}

	@Test
	public void checkThatUserIsAbleToAddPrescription_OPD_Test() throws Throwable {
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
		String repeatPattern = "1-1/2-0";
		String duration = "2";
		String route = "ORAL";
		String quantity = "2";
		String notes = "Testing";
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
		dp.addThePrescriptons(driver, repeatPattern, duration, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);
		String text = dp.captureErrorText(driver);
		Assert.assertEquals(text, "Successfully created Drug Prescription..!");
	}

	@Test
	public void checkThatUserIsAbleToAddNextEncounter_OPD_Test() throws Throwable {
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
		String subjective = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur, quam id ";
		String objective = "tincidunt posuere, quam dolor bibendum mi, vel vehicula dui ex at orci. Fusce scelerisque, ";
		String assessment = "eros eu gravida dictum, nunc ex laoreet justo, a interdum leo odio a dolor. Sed euismod risus ";
		String plan = "eu tortor efficitur, eu finibus justo scelerisque. Vestibulum id augue et ipsum tristique";
		String inv = "pellentesque. Vivamus eleifend, lectus vel scelerisque congue, justo metus blandit urna, nec ";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnNextEncounterTab(driver);
		dp.addTheNextEncounter(driver, inv);
		dp.clickOnSubmitBtnInNextEncounterTb(driver);
		String text = dp.captureErrorText(driver);
		Assert.assertEquals(text, "Created successfully");
	}

	@Test
	public void checkThatUserIsAbleToUploadDocuments_Test() throws Throwable {
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//		
//		
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		
//		
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//		
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnDocumentsTab(driver);
//		dp.addDocumentsInDdOpd_Random(driver);
	}

	@Test
	public void checkThatUserIsAbleToEnterDataInOtherNotesTab_OPD_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		hp.homeBtnForvims(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//
//		String un = "medicine_rama1234@vimsmail.com";
//		String pw = "12345";
//		String templateType = "OT NOTES";
//
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnOtherNotesTab(driver);
//		dp.clickOnNewBtn_OtherNotesTab(driver);
//		dp.selectTemplateType_otherNotesTab(driver, templateType);
//		dp.enterDataOtherNotes_Iframe(driver);
//		String text = dp.captureErrorText(driver);
//		Assert.assertEquals(text, "successfully created");
	}

	@Test
	public void checkThatUserIsAbleToEnterDataHistoryTabs_Iframes_OPD_Test() throws Throwable {
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

//		dp.clickOnChiefComplaintTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnHistoryOfIlnessTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPmhTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPshTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnFamilyHx(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnSocialHx(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnDrugAndFoodAllergy(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnRosTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnGpeTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnPastInvestigationTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//
//		scrollToTop(driver);
//		dp.clickOnProvisionalDiagnosisTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);

//		scrollToTop(driver);
//		dp.clickOnPlanTab(driver);
//		dp.enterDataInIframe_HistoryTabs(driver);
//		dp.clickOnNextBtn_historyTabs(driver);
//		dp.clickOnSubmitBtn_historyTabs(driver);
//		dp.clickOnPopup(driver);
//		dp.clickOnSignBtn(driver);
	}

	@Test
	public void checkThatUserIsAbleToAddCurrentmedication_Test() throws Throwable {
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

		String route = "ORAL";
		String pattern = "1-1/2-0";
		String since = "< 3 MONTHS";
		String notes = "Testing";
		String qty = "5";
		String status = "Continue";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnCurrentMedicationTab(driver);
		dp.addTheCurrentMedication(driver, route, pattern, since, qty, notes, status);
		scrollDownTheStillEndOfThePage(driver);
		dp.clickOnNextBtn_currentMedication(driver);
	}

	@Test
	public void checkThatuserIsAbleToEnterDataInViatalSigns_HistoryTabs_OPD_Test() throws Throwable {
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

		String bp = "223456";
		String height = "174";
		String weight = "66";
		String c = "35";
		String pulse = "156";
		String rr = "987";
		String spo2 = "111";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnHistoryTabs(driver);
		dp.clickOnVitalSignsTab(driver);
		dp.enterDataInVitalSign(driver, bp, height, weight, c, pulse, rr);
	}

	@Test
	public void checkThatSameGenericNameIsDisplayingAfterEditingThePrescription_OPD_Test() throws Throwable {
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
		String repeatPattern = "1-1/2-0";
		String duration = "2";
		String route = "ORAL";
		String quantity = "2";
		String notes = "Testing";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnPrescriptioinTab(driver);
		String pre = dp.addOnePrescriptons(driver, repeatPattern, duration, route, quantity, notes);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);
		dp.clickOnEdit_prescription(driver);
		Object pre1 = dp.captureGenericName_Table_Prescription(driver);
		Assert.assertEquals(pre1, pre);
	}

}

/*
 * @Test (priority = 2) public void
 * VerifySearchFilterByEnteringHospitalNumber_Test() throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); SearchPatientPage sp = new
 * SearchPatientPage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver);
 * 
 * hp.homeBtnForvims(driver); sp.clickOnTheSearchPatientButton(driver); String
 * hospitalNumber = sp.captureHospitalNumberInTheTable();
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver); dp.enterTheHospitalNumber(driver,
 * hospitalNumber);
 * 
 * 
 * dp.clickOnSearchBtn(driver); String hospitalNumberRow_1 =
 * dp.HospitalNumberInTable_Row1(driver); Assert.assertEquals(hospitalNumber,
 * hospitalNumberRow_1);
 * System.out.println("user got hospital number successfully");
 * 
 * 
 * }
 * 
 * @Test (priority = 3) public void
 * VerifySearchFilterByEnteringPatientName_Test() throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); SearchPatientPage sp = new
 * SearchPatientPage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver);
 * 
 * hp.homeBtnForvims(driver); sp.clickOnTheSearchPatientButton(driver); String
 * patientName = sp.captureThePatientName_Table();
 * 
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver); dp.enterThePatientName(driver,
 * patientName); dp.clickOnSearchBtn(driver); String patientNameRow_1 =
 * dp.patientNameInTable_Row1(driver); Assert.assertEquals(patientName,
 * patientNameRow_1); System.out.println("user got Patient Name successfully");
 * 
 * }
 * 
 * @Test (priority = 4) public void
 * VerifySearchFilterByEnteringPhoneNumber_Test() throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); SearchPatientPage sp = new
 * SearchPatientPage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver);
 * 
 * hp.homeBtnForvims(driver); sp.clickOnTheSearchPatientButton(driver); String
 * phoneNumber = sp.capturePhoneNumberInTheTable();
 * 
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver); dp.enterThePhoneNumber(driver,
 * phoneNumber); dp.clickOnSearchBtn(driver); String phoneNumberRow_1 =
 * dp.phoneNumberInTable_Row1(driver); Assert.assertEquals(phoneNumber,
 * phoneNumberRow_1); System.out.println("user got Phone Number successfully");
 * 
 * }
 * 
 * @Test (priority = 5) public void
 * VerifySearchFilterByEnteringVisitNUmber_Test() throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); SearchPatientPage sp = new
 * SearchPatientPage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver);
 * 
 * hp.homeBtnForvims(driver); sp.clickOnTheSearchPatientButton(driver); String
 * visitNumber = sp.captureVisitNUmber_Table();
 * 
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * 
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver); dp.enterThevisitNumber(driver,
 * visitNumber); dp.clickOnSearchBtn(driver); String visitNumber_Row1 =
 * dp.visitNumberInTable_Row1(driver); Assert.assertEquals(visitNumber,
 * visitNumber_Row1); System.out.println("user got visit Number successfully");
 * 
 * }
 * 
 * @Test (priority = 6) public void VerifySearchFilterByEnteringGender_Test()
 * throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); String gender= "MALE";
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver); dp.enterTheGender(driver);
 * dp.clickOnSearchBtn(driver); String gender_Row1 =
 * dp.genderInTable_Row1(driver); Assert.assertEquals(gender, gender_Row1);
 * System.out.println("verified gender successfully");
 * 
 * }
 * 
 * @Test (priority = 7) public void
 * VerifySearchFilterByEnteringConsultationStatus_Test() throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); String status= "COMPLETED";
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver); dp.enterTheConsultaionStatus(driver);
 * dp.clickOnSearchBtn(driver); String consultationStatus_Row1 =
 * dp.consultationStatusInTable_Row1(driver); Assert.assertEquals(status,
 * consultationStatus_Row1);
 * System.out.println("verified Consultation status successfully");
 * 
 * }
 * 
 * @Test (priority = 8) public void VerifyHospitalNumberInNextPages_Test()
 * throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); String RegFromDate="21042023";
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.clickOnAllPatientListTab(driver);
 * dp.ClickOnErrorPopupInAllPatientListTab(driver);
 * dp.enterFromDate(RegFromDate); dp.clickOnSearchBtn(driver);
 * dp.scrollDownTillBottom(driver); dp.verifyTheHospitalNumber(driver);
 * 
 * }
 */

/*
 * 
 * @Test (priority = 3) public void editDataInCheifComplainttextArea_Test()
 * throws Throwable {
 * 
 * 
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); LogOutPage l=new LogOutPage(driver); LoginPage lp=
 * new LoginPage(driver); String un="cardio_vijaysai@vimsmail.com"; String pw
 * ="123456"; String chiefComplaintTabtext="Ut"; l.logoutTheApplication(driver);
 * lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
 * 
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.clickOnMyPatientListTab(driver);
 * dp.clickOnHospitalNumberInTheMyPatientList(driver);
 * dp.clickOnHistoryTab(driver); dp.clickOnChiefComplaintTab(driver);
 * dp.clickOnEditBtnInChiefComplaintTab(driver);
 * dp.enterTextInCheifComplaintTab(driver,chiefComplaintTabtext);
 * dp.clickOnNextButtonForCheifComplaintTab(driver);
 * 
 * 
 * }
 * 
 * @Test (priority = 4)
 * 
 * public void deleteDataInCheifComplainttextAreaAndEnterDataAgain_Test() throws
 * Throwable {
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); LogOutPage l=new LogOutPage(driver); LoginPage lp=
 * new LoginPage(driver); String un="cardio_vijaysai@vimsmail.com"; String pw
 * ="123456"; String chiefComplaintTabtext="Ut"; l.logoutTheApplication(driver);
 * lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
 * 
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.clickOnMyPatientListTab(driver);
 * dp.clickOnHospitalNumberInTheMyPatientList(driver);
 * dp.clickOnHistoryTab(driver); dp.clickOnChiefComplaintTab(driver);
 * Thread.sleep(1000); dp.clickOnDeleteBtnInChiefComplaintTab(driver);
 * dp.clickOnDeletedSuccessfullyPopUP(driver); dp.scrollUp(driver);
 * dp.enterTextInCheifComplaintTab(driver,chiefComplaintTabtext);
 * dp.clickOnNextButtonForCheifComplaintTab(driver);
 * dp.clickOnCreatedSuccessfullyPopUp(driver);
 * 
 * 
 * 
 * }
 * 
 * @Test (priority = 5)
 * 
 * public void enterDataInHistoryOfIllness_Test() throws Throwable {
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); LogOutPage l=new LogOutPage(driver); LoginPage lp=
 * new LoginPage(driver); String un="cardio_vijaysai@vimsmail.com"; String pw
 * ="123456"; String historyOfIllness="testing"; l.logoutTheApplication(driver);
 * lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
 * 
 * 
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.clickOnMyPatientListTab(driver);
 * dp.clickOnHospitalNumberInTheMyPatientList(driver); Thread.sleep(2000);
 * dp.clickOnHistoryTab(driver); Thread.sleep(2000);
 * dp.clickOnHistoryOfIlnessTab(driver); Thread.sleep(1000);
 * dp.enterTextInhistoryOfIllnessTab(driver, historyOfIllness);
 * Thread.sleep(1000); dp.clickOnNextButtonForCheifComplaintTab(driver); }
 */

/*
 * @Test public void enterDataInHistoryTabs_Test() throws Throwable {
 * 
 * HomePage hp = new HomePage(driver); DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); SearchPatientPage sp=new
 * SearchPatientPage(driver); LogOutPage l=new LogOutPage(driver); LoginPage lp=
 * new LoginPage(driver); String un="medicine_rama1234@vimsmail.com"; String pw
 * ="12345"; String
 * historyText="Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim "
 * ;
 * 
 * 
 * l.logoutTheApplication(driver); lp.loginToApplicationUsingDoctorLogin(un, pw,
 * driver);
 * 
 * hp.homeBtnForvims(driver); sp.clickOnTheSearchPatientButton(driver); String
 * hospitalNumber=sp.captureHospitalNumberInTheTable();
 * hp.homeBtnForvims(driver); dp.clickOnTheDoctorDeskOpdScreenButton(driver);
 * dp.clickOnMyPatientListTab(driver);
 * dp.clickOnHospitalNumberInTheMyPatientList(driver,hospitalNumber);
 * dp.clickOnPatientArrivalBtnAndSave(driver);
 * dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
 * dp.zoomOutTheScreen(driver); dp.clickOnHistoryTab(driver);
 * Thread.sleep(2000); dp.scrolldown(driver); dp.enterTextInHistoryTabs(driver,
 * historyText); dp.clickOnCreatedSuccessfullyPopUp(driver);
 * 
 * // dp.clickOnPatientArrivalBtnAndSave(driver); //
 * dp.clickOnUpdatedPatientArrivalStatusPopUP(driver); >>>>>>>
 * 788938924b30f5c1c6facf0a28a7378e60d2e19d dp.clickOnOtherNotesTab(driver);
 * dp.clickOnNewBtn_OtherNotesTab(driver);
 * dp.selectTemplateType_otherNotesTab(driver, templateType);
 * dp.enterDataOtherNotes_Iframe(driver, otherNotes); }
 * 
 * // @Test // public void checkThatUserIsAbleToAddCurrentmedication_Test()
 * throws Throwable { // HomePage hp = new HomePage(driver); //
 * DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver); // SearchPatientPage sp
 * = new SearchPatientPage(driver); // LogOutPage l = new LogOutPage(driver); //
 * LoginPage lp = new LoginPage(driver); // String un =
 * "medicine_rama1234@vimsmail.com"; // String pw = "12345"; // String gn1 =
 * "ONETOUCH SELECT 10 TEST STRIP"; // String route = "ORAL"; // String pattern
 * = "1-1/2-0"; // String since = "< 3 MONTHS"; // String notes = "Testing"; //
 * l.logoutTheApplication(driver); // lp.loginToApplicationUsingDoctorLogin(un,
 * pw, driver); // hp.homeBtnForvims(driver); //
 * sp.clickOnTheSearchPatientButton(driver); // String hospitalNumber =
 * sp.captureHospitalNumberInTheTable(); // hp.homeBtnForvims(driver); //
 * dp.clickOnTheDoctorDeskOpdScreenButton(driver); //
 * dp.clickOnMyPatientListTab(driver); //
 * dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber); ////
 * dp.clickOnHistoryTab(driver); // dp.clickOnCurrentMedicationTab(driver); //
 * dp.scrolldown(driver); // dp.addTheCurrentMedication(driver, gn1, route,
 * pattern, since, notes); // } //10:37 //@Test //public void
 * checkThatToVerifyTheInvestigationAmount_Test() throws Throwable { // //
 * String name = "S"; // String year = eutil.getDataFromTheExcel("Opdreg1", 2,
 * 5); // String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6); // String
 * mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7); // String mail =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 8); // String address =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 9); // String pincode =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 10); // String doctorname = "rama";
 * // String depName ="GENERAL MEDICINE"; // String postOffice =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 14); // String
 * un="medicine_rama1234@vimsmail.com"; // String pw ="12345"; // String
 * notes1="Testing"; // // // HomePage hp = new HomePage(driver); //
 * DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver); // SearchPatientPage sp
 * = new SearchPatientPage(driver); // LogOutPage l=new LogOutPage(driver); //
 * LoginPage lp= new LoginPage(driver); // // // //OPD registration // //
 * hp.homeBtnForvims(driver); // OPDRegistrationPage opdregistrationpage = new
 * OPDRegistrationPage(driver); //
 * opdregistrationpage.opdRegistrationButton(driver); //
 * opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname,
 * mobilenum, mail, address, pincode,postOffice, depName, doctorname); //
 * opdregistrationpage.submitAnd_ViewBtn(driver); // hp.homeBtnForvims(driver);
 * // sp.clickOnTheSearchPatientButton(driver); // String hospitalNumber =
 * sp.captureHospitalNumberInTheTable(); //
 * System.out.println("Hospital Number : "+hospitalNumber); // //Login using
 * doctor credentails and update the patient arrival // //
 * l.logoutTheApplication(driver); // lp.loginToApplicationUsingDoctorLogin(un,
 * pw, driver); // hp.homeBtnForvims(driver); //
 * dp.clickOnTheDoctorDeskOpdScreenButton(driver); //
 * dp.clickOnMyPatientListTab(driver); //
 * dp.clickOnHospitalNumberInTheMyPatientList(driver,hospitalNumber); //
 * dp.clickOnPatientArrivalBtnAndSave(driver); //
 * dp.clickOnUpdatedPatientArrivalStatusPopUP(driver); // // //Add
 * investigstions // // dp.clickOnInvestigationTab(driver); //
 * dp.clickOnNewBtnInInvestigationTab(driver); // dp.scrolldown(driver); //
 * dp.addTheInvestigations(driver, notes1); //
 * dp.clickOnSubmitBtnInInvestigationsTab(driver); // //verify investigation
 * amount // // dp.calculateInvestigations(driver); //} //10:37 //@Test //public
 * void toVerifyConsultationAmountIndoctordesk_test() throws Throwable { //
 * String name = ""; // String year = eutil.getDataFromTheExcel("Opdreg1", 2,
 * 5); // String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6); // String
 * mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7); // String mail =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 8); // String address =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 9); // String pincode =
 * eutil.getDataFromTheExcel("Opdreg1", 2, 10); // String doctorname =
 * "SURESHA KODAPALA"; // String depName ="neurology"; // String
 * un="neurology_suresha4234@vimsmail.com"; // String pw ="12345"; // String
 * postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14); // // HomePage hp =
 * new HomePage(driver); // DoctorDeskOpdPage dp = new
 * DoctorDeskOpdPage(driver); // LoginPage lp = new LoginPage(driver); //
 * LogOutPage lo = new LogOutPage(driver); // SearchPatientPage sp=new
 * SearchPatientPage(driver); // // // hp.homeBtnForvims(driver); //
 * OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver); //
 * opdregistrationpage.opdRegistrationButton(driver); // String
 * consulationAmount=opdregistrationpage.toVerifyTheConsultationAmount(driver,
 * name, year, fname, mobilenum, mail, address, pincode,postOffice, depName,
 * doctorname); // Thread.sleep(1000); //
 * opdregistrationpage.submitAnd_ViewBtn(driver); // //
 * lo.logoutTheApplication(driver); // lp.loginToApplicationUsingDoctorLogin(un,
 * pw, driver); // hp.homeBtnForvims(driver); //
 * sp.clickOnTheSearchPatientButton(driver); // String hospitalNumber =
 * sp.captureHospitalNumberInTheTable(); // // // hp.homeBtnForvims(driver); //
 * dp.clickOnTheDoctorDeskOpdScreenButton(driver); //
 * dp.clickOnMyPatientListTab(driver); //
 * dp.clickOnHospitalNumberInTheMyPatientList(driver,hospitalNumber); //
 * dp.clickOnPatientArrivalBtnAndSave(driver); //
 * dp.clickOnUpdatedPatientArrivalStatusPopUP(driver); // String
 * consultaionAmount1=dp.verifyConsultationAmountInDoctorDesk(driver); //
 * Assert.assertEquals(consulationAmount, consultaionAmount1); //
 * System.out.println("Successfully consultation amount is verified"); // // //
 * } }
 * 
 */
