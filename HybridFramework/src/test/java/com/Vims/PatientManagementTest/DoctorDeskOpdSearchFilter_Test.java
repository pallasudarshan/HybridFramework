package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskOpdSearchFilter_Test extends BaseClass {

	@Test(priority = 1)
	public void checkThatUserIsAbleToSearchUsingHospitalNumber_AllPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);

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

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnClearBtn(driver);
		dd.enterTheHospitalNumber(driver, hospitalNumber);
		dd.clickOnSearchBtn(driver);
		String hospitalNumber1 = dd.captureHospitalNumber_Table_AllPatientList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test(priority = 2)
	public void checkThatUserIsAbleToSearchUsingPatientName_AllPatientList_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		String name = "SIMON";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = j.generateRandomMobileNumber();
		String mail = j.generateRandomEmail();
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "GENERAL MEDICINE";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String aadhaar = j.generateRandomAadhaarNumber();

		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims_searchFilter(driver, name, year, fname, mobilenum, mail, address,
				pincode, postOffice, aadhaar, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnShowAllFilterCheckBox(driver);
		dd.clickOnClearBtn(driver);
		dd.enterThePatientName(driver, name);
		dd.clickOnSearchBtn(driver);
		String patientName1 = dd.capturePatientName_Table_AllPatientList(driver);
		Assert.assertEquals(name, patientName1);
	}

	@Test(priority = 3)
	public void checkThatUserIsAbleToSearchUsingDepartment_AllPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		JavaUtility j = new JavaUtility();

		String name = "Richard";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = j.generateRandomMobileNumber();
		String mail = j.generateRandomEmail();
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "GENERAL MEDICINE";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String aadhaar = j.generateRandomAadhaarNumber();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims_searchFilter(driver, name, year, fname, mobilenum, mail, address,
				pincode, postOffice, aadhaar, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnShowAllFilterCheckBox(driver);
		dd.clickOnClearBtn(driver);
		dd.selectDepartment(driver, depName);
		dd.clickOnSearchBtn(driver);
		String dep1 = dd.captureDepartment_Table_AllPatientList(driver);
		Assert.assertEquals(depName, dep1);
	}

	@Test(priority = 4)
	public void checkThatUserIsAbleToSearchUsingDepartmentUnit_AllPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		JavaUtility j = new JavaUtility();

		String name = "Richard";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = j.generateRandomMobileNumber();
		String mail = j.generateRandomEmail();
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "GENERAL MEDICINE";

		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String aadhaar = j.generateRandomAadhaarNumber();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims_searchFilter(driver, name, year, fname, mobilenum, mail, address,
				pincode, postOffice, aadhaar, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String unit = "6";

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnShowAllFilterCheckBox(driver);
		dd.clickOnClearBtn(driver);
		dd.selectDepartment(driver, depName);
		dd.selectUnit(driver, unit);
		dd.clickOnSearchBtn(driver);
		String dep1 = dd.captureDepartment_Table_AllPatientList(driver);
		String unit1 = dd.captureUnit_Table_AllPatientList_LastRow(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(depName, dep1);
		sa.assertEquals(unit, unit1);
		sa.assertAll();
	}

	@Test(priority = 5)
	public void checkThatUserIsAbleToSearchUsingVisitNumber_AllPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnShowAllFilterCheckBox(driver);
		dd.clickOnClearBtn(driver);
		String visit = dd.captureVisitNumber_Table_AllPatientList_LastRow(driver);
		dd.enterThevisitNumber(driver, visit);
		dd.clickOnSearchBtn(driver);
		String visit1 = dd.captureVisitNumber_Table_AllPatientList(driver);
		Assert.assertEquals(visit, visit1);
	}

	@Test(priority = 6)
	public void checkThatUserIsAbleToSearchUsingConsultationStatus_AllPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		String cs = "PT NOT ARRIVED";

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnShowAllFilterCheckBox(driver);
		dd.clickOnClearBtn(driver);
		dd.enterTheConsultaionStatus(driver, cs);
		dd.clickOnSearchBtn(driver);
		String cs1 = dd.captureConsultationStatus_Table_AllPatientList(driver);
		Assert.assertEquals(cs, cs1);
	}

	@Test(priority = 7)
	public void checkThatUserIsAbleToSearchUsingPhoneNumber_AllPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		JavaUtility j = new JavaUtility();

		String name = "Simon";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = j.generateRandomMobileNumber();
		String mail = j.generateRandomEmail();
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String aadhaar = j.generateRandomAadhaarNumber();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims_searchFilter(driver, name, year, fname, mobilenum, mail, address,
				pincode, postOffice, aadhaar, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);

		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnAllPatientListTab(driver);
		dd.clickOnShowAllFilterCheckBox(driver);
		dd.clickOnClearBtn(driver);
		dd.enterThePhoneNumber(driver, mobilenum);
		dd.clickOnSearchBtn(driver);
		String mobilenum1 = dd.capturePhoneNumber_Table_AllPatientList(driver);
		Assert.assertEquals(mobilenum, mobilenum1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingHospitalNumber_MyPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
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
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnMyPatientListTab(driver);
		dd.clickOnClearBtn(driver);
		dd.enterTheHospitalNumber(driver, hospitalNumber);
		dd.clickOnSearchBtn(driver);
		String hospitalNumber1 = dd.captureHospitalNumber_Table_MyPatientList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingPatientName_MyPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		JavaUtility j = new JavaUtility();
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		String name = "SIMON";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = j.generateRandomMobileNumber();
		String mail = j.generateRandomEmail();
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String aadhaar = j.generateRandomAadhaarNumber();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims_searchFilter(driver, name, year, fname, mobilenum, mail, address,
				pincode, postOffice, aadhaar, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnMyPatientListTab(driver);
		dd.clickOnClearBtn(driver);
		dd.enterThePatientName(driver, name);
		dd.clickOnSearchBtn(driver);
		String patientName = dd.capturePatientName_Table_MyPatientList(driver);
		Assert.assertEquals(name, patientName);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingPhoneNumber_MyPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		JavaUtility j = new JavaUtility();
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		String name = "SIMON";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = j.generateRandomMobileNumber();
		String mail = j.generateRandomEmail();
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String aadhaar = j.generateRandomAadhaarNumber();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims_searchFilter(driver, name, year, fname, mobilenum, mail, address,
				pincode, postOffice, aadhaar, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnMyPatientListTab(driver);
		dd.clickOnClearBtn(driver);
		dd.enterThePhoneNumber(driver, mobilenum);
		dd.clickOnSearchBtn(driver);
		String ph = dd.capturePhoneNumber_Table_MyPatientList(driver);
		Assert.assertEquals(mobilenum, ph);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingVisitNumber_MyPatientList_Test() throws Throwable {
		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnMyPatientListTab(driver);
		dd.clickOnClearBtn(driver);
		String visit = dd.captureVisitNumber_Table_MyPatientList_LastRow(driver);
		dd.enterThevisitNumber(driver, visit);
		dd.clickOnSearchBtn(driver);
		String visit1 = dd.captureVisitNumber_Table_MYPatientList(driver);
		Assert.assertEquals(visit, visit1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingConsultationStatus_MyPatientList_Test() throws Throwable {
		String cs = "PT NOT ARRIVED";
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";

		DoctorDeskOpdPage dd = new DoctorDeskOpdPage(driver);
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dd.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dd.clickOnMyPatientListTab(driver);
		dd.clickOnClearBtn(driver);
		dd.enterTheConsultaionStatus(driver, cs);
		dd.clickOnSearchBtn(driver);
		String cs1 = dd.captureConsultationStatus_Table_MyPatientList(driver);
		Assert.assertEquals(cs, cs1);
	}
}
