package com.Vims.Surya_MasterScreens_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskIpdTestScript_Test extends BaseClass {
	/*
	 * @Test public void navigateToDoctorDeskIPD_Test() throws Throwable {
	 * 
	 * HomePage hp = new HomePage(driver); DoctorDesk_Ip_Page ipd = new
	 * DoctorDesk_Ip_Page(driver); LogOutPage l = new LogOutPage(driver); LoginPage
	 * lp = new LoginPage(driver); String un = "neurology_suresha4234@vimsmail.com";
	 * String pw = "12345"; String notes = "testing";
	 * 
	 * l.logoutTheApplication(driver); lp.loginToApplicationUsingDoctorLogin(un, pw,
	 * driver);
	 * 
	 * hp.homeBtnForvims(driver); ipd.clickOnTheDoctorDeskIPDButton(driver);
	 * ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver); //
	 * ipd.ClickOnPatientarrivalbtn(driver); // ipd.ClickOnSavebtn(driver);
	 * ipd.clickOnInvestigationTab(driver);
	 * ipd.clickAddBtnInInvestigationtab(driver); ipd.addTheInvestigation(driver,
	 * notes); ipd.ClickOnSubmitBtnInInvestigationTab(driver);
	 * 
	 * }
	 * 
	 * @Test public void enterDataInPharmacyTab_Test() throws Throwable {
	 * 
	 * HomePage hp = new HomePage(driver); DoctorDesk_Ip_Page ipd = new
	 * DoctorDesk_Ip_Page(driver); LogOutPage l = new LogOutPage(driver); LoginPage
	 * lp = new LoginPage(driver); String un = "neurology_suresha4234@vimsmail.com";
	 * String pw = "12345"; String p1 = "HAND SANITIZER 500ML"; String p2 =
	 * "DOLONEX 2ML INJECTION"; String p3 = "DOLO (GLASS BOTTLE) 100ML"; String p4 =
	 * "LACOSAMIDE 100MG TABLETS"; String p5 = "Destroy"; String p6 =
	 * "OPTIUM NEO H GLUCOSE TEST STRIP"; String p7 = "CANDID V3 TABLET"; String p8
	 * = "CANDID EAR DROPS"; String p9 = "FACE MASK N95"; String p10 =
	 * "DISPOLINE GLOVES LARGE"; String rp = "1-1/2-0"; String q = "1"; String route
	 * = "ORAL"; l.logoutTheApplication(driver);
	 * lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
	 * 
	 * hp.homeBtnForvims(driver); ipd.clickOnTheDoctorDeskIPDButton(driver);
	 * ipd.clickOnAllPatientListInDDIPd(driver); Thread.sleep(2000);
	 * ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
	 * ipd.clickOnPharmacyTab(driver); Thread.sleep(2000);
	 * ipd.clickAddBtnInPharmacytab(driver); ipd.scrolldown(driver);
	 * Thread.sleep(2000); ipd.addTheDataInPharmacyTab(driver, p1, p2, p3, p4, p5,
	 * p6, p7, p8, p9, p10, rp, q, route); ipd.clickOnSubmitBtnPharmacytab(driver);
	 * 
	 * }
	 */

	@Test(invocationCount = 5)
	public void admit_Test() throws Throwable {
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
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRAIGE MALE GEN WARD";
		String floor = "2ND FLOOR";
		String wings = "WEST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRAIGE MALE GEN WARD";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";
		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";

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
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// add investigations
		hp.homeBtnForvims(driver);
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
	//	ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		Thread.sleep(3000);
		ipd.clickAddBtnInInvestigationtab(driver);
	//	ipd.addTheInvestigation(driver, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		System.out.println(hospitalNumber);

//		Thread.sleep(5000);
//		// pharmacy tab
//		ipd.scrollUp(driver);
//		ipd.clickOnPharmacyTab(driver);
//		Thread.sleep(2000);
//		ipd.clickAddBtnInPharmacytab(driver);
//		ipd.scrolldown(driver);
//		Thread.sleep(2000);
//		ipd.addTheDataInPharmacyTab(driver, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, rp, q, route);
//		ipd.clickOnSubmitBtnPharmacytab(driver);
//		ipd.clickONCreatedSuccefullPopUpAfterSubmittingInPharmacyTAb(driver);
//		System.out.println(hospitalNumber);

	}

}
