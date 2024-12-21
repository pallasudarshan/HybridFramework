package Test;

import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;

public class IpAdmission_Test extends BaseClass {
	@Test(invocationCount = 5)
	public void test() throws Throwable {
		String doctorname = "sha";
		String depName = "medical oncology";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";

		String admittedByDr = "geeta kiran";
		String bedCategory = "NON TEACHING";
		String bedWardType = "day care";
		String bedRoomType = "day care";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);

		hp.homeBtnForvims(driver);
		op.opdRegistrationButton(driver);
		op.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName,
				doctorname);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
		System.out.println("Hospital Ip : " + hospitalNumber);

	}

	@Test(invocationCount = 20)
	public void scheme() throws Throwable {
		String doctorname = "rama mishra";
		String depName = "GENERAL medicine";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String notes = "HISTORY & PHYSICAL";
		String admittedByDr = "ABBAS";
		String bedCategory = "NON TEACHING";
		String bedWardType = "CRITICAL CARE UNIT";
		String bedRoomType = "CCU";
		String floor = "3RD FLOOR";
		String wings = "EAST WING";
		String time = "";

		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);

		opdregistrationpage.selectPatientCategoryDropdown(driver, "scheme");
		opdregistrationpage.selectFinancialResponsibility(driver, "ap government employee");
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number - OP : " + hospitalNumber);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForScheme(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				bedWardType, bedRoomType, bednumberh);
		System.out.println("Hospital Number - IP : " + hospitalNumber);
	}

}
