package Test_All_Modules;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class Doctor_Desk_Op_Investigations_Prescriptions extends BaseClass {

	@Test
	public void CreateOpd_Investigations_Prescription_Test() throws Throwable {

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
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String repeatPattern = "1-1/2-0";
		String duration = "2";
		String route = "ORAL";
		String quantity = "2";
		String notes1 = "Testing";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		SearchPatientPage sp = new SearchPatientPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		// OPD registration

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		hp.homeBtnForvims(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		System.out.println("Hospital Number : " + hospitalNumber);
//	System.out.println("patient created successfully");

		// Login using doctor credentails and update the patient arrival

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		hp.homeBtnForvims(driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//	System.out.println("patient arrival done successfully");

		// Add investigstions
//
//		dp.clickOnInvestigationTab(driver);
//		dp.clickOnNewBtnInInvestigationTab(driver);
//		dp.scrolldown(driver);
//		dp.addTheInvestigations(driver, notes1);
//		dp.clickOnSubmitBtnInInvestigationsTab(driver);
//		dp.scrollUp(driver);
//	System.out.println("investigations added successfully");

		// Add prescription

		dp.clickOnPrescriptioinTab(driver);
		dp.scrolldown(driver);
		Thread.sleep(3000);
		dp.clickOnNewBtnInPrescriptonTab(driver);
		dp.addThePrescriptons(driver, repeatPattern, duration, route, quantity, notes1);
		dp.scrolldown(driver);
		dp.clickOnSubmitBtnInPrescriptionTab(driver);
		dp.clickOnCreatedSuccesfullyPopUpMsgInPrescription(driver);

//    System.out.println("prescription added successfully");
	}

}
