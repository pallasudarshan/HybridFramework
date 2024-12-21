package Test_All_Modules;

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
//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class Doctor_Desk_Ip_Investigations_Pharmacy extends BaseClass {

	@Test
	public void Create_Opd_Add_Investigations_Pharmacy_Test() throws Throwable {
//
//		String name = "IP PATIENT";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = "IP PATIENT";
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "SURESH";
//		String depName = "NEUROLOGY";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		String wardType = "GENERAL WARD";
//		String bedCategory = "NON TEACHING";
//		String bedWardType = "GENERAL WARD";
//		String bedRoomType = "C19 TRAIGE MALE GEN WARD";
//		String floor = "4TH FLOOR";
//		String wings = "EAST WING";
//		String bedUnitDepartment = "1";
//		String roomType = "C19 TRAIGE MALE GEN WARD";
//		String admittedByDr = "DR.ABBAS";
//		String time = "1230";
//
//		String un = "neurology_suresha1234@vimsmail.com";
//		String pw = "123456";
//		
//		
//		String notes = "testing";
//		String p1 = "DOLO";
//		String p2 = "PARACET";
//		String p3 = "DOLO (GLASS BOTTLE) 100ML";
//		String p4 = "calcium";
//		String p5 = "Destroy";
//		String p6 = "OPTIUM NEO H GLUCOSE TEST STRIP";
//		String p7 = "CANDID V3 TABLET";
//		String p8 = "CANDID EAR DROPS";
//		String p9 = "FACE MASK N95";
//		String p10 = "DISPOLINE GLOVES LARGE";
//		String rp = "1-1/2-0";
//		String q = "1";
//		String route = "ORAL";
//
//		HomePage hp = new HomePage(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		SearchPatientPage sp = new SearchPatientPage(driver);
//		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
//
//		hp.homeBtnForvims(driver);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		opdregistrationpage.submitAnd_ViewBtn(driver);
//
//		hp.homeBtnForvims(driver);
//		sp.clickOnTheSearchPatientButton(driver);
//		String hospitalNumber = sp.captureHospitalNumberInTheTable();
//		System.out.println("Hospital Number : " + hospitalNumber);
//
//		BedMasterPage bp = new BedMasterPage(driver);
//		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
//				bedUnitDepartment);
//		System.out.println(bednumberh);
//
//		// patientAdmission
//		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
//		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
//		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
//				wardType, roomType, bednumberh);
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//
//		// add investigations
//		hp.homeBtnForvims(driver);
//		ipd.clickOnTheDoctorDeskIPDButton(driver);
//		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
//		ipd.ClickOnPatientarrivalbtn(driver);
//		ipd.ClickOnSavebtn(driver);
//		ipd.clickOnInvestigationTab(driver);
//		ipd.scrolldown(driver);
//		Thread.sleep(3000);
//		ipd.clickAddBtnInInvestigationtab(driver);
//		ipd.addTheInvestigation(driver, notes);
//		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
//
//		// pharmacy tab
//		ipd.scrollUp(driver);
//		ipd.clickOnPharmacyTab(driver);
//		Thread.sleep(2000);
//		ipd.clickAddBtnInPharmacytab(driver);
//		ipd.scrolldown(driver);
//		Thread.sleep(2000);
//	//	ipd.addTheDataInPharmacyTab(driver, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, rp, q, route);
//		ipd.clickOnSubmitBtnPharmacytab(driver);
//		ipd.clickONCreatedSuccefullPopUpAfterSubmittingInPharmacyTAb(driver);
//
//		System.out.println(hospitalNumber);

	}
}
