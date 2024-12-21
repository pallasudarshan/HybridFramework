package Test;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

public class ReferredfromHospital_Location extends BaseClass {

	@Test(invocationCount = 1000)
	public void RferredfromHospital_LocationTest_New() throws Throwable {
		String doctorname = "HOD DOCTOR";
		String depName = "general medicine";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		HomePage hp = new HomePage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForReferredFromHospitalLocation(driver, name, year, fname, mobilenum, mail,
				address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number - OP : " + hospitalNumber);

	}

	@Test(invocationCount = 1000)
	public void RferredfromHospital_LocationTest_Emergency() throws Throwable {
		String doctorname = "HOD DOCTOR";
		String depName = "general medicine";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String regType = "EMERGENCY";

		HomePage hp = new HomePage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		opdregistrationpage.OpdRegistartionForReferredFromHospitalLocation_Emergency(driver, name, year, fname,
				mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number - OP : " + hospitalNumber);
	}

	@Test(invocationCount = 1000)
	public void RferredfromHospital_LocationTest_Revisit() throws Throwable {
		String doctorname = "HOD DOCTOR";
		String depName = "general medicine";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String regType = "revisit";

		String doctorname2 = "sha";
		String depName2 = "medical oncology";
		HomePage hp = new HomePage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForReferredFromHospitalLocation(driver, name, year, fname, mobilenum, mail,
				address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number - OP : " + hospitalNumber);

		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.selectRegistrationType(driver, regType);
		Thread.sleep(1000);
		opdregistrationpage.OpdRegistartionForReferredFromHospitalLocation_Revisit(driver, hospitalNumber, depName2,
				doctorname2);
		opdregistrationpage.submitAnd_ViewBtn_2(driver);
	}

	@Test(invocationCount = 1000)
	public void RferredfromHospital_LocationTest_CrossReferral() throws Throwable {
		String doctorname = "geeta";
		String depName = "dermatology";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorName = "gen";

		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForReferredFromHospitalLocation(driver, name, year, fname, mobilenum, mail,
				address, pincode, postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		String reason = "cross referral automation";
		String doctorName2 = "vijay";
		String depName2 = "cardiology";

		Thread.sleep(2000);
		dp.clickOnCrossReferral_EnterData_ClickOnRequest(driver, depName2, doctorName2, reason);
		Thread.sleep(1000);

		alp.clickOnTheAllPatientListButton(driver);
		Thread.sleep(4000);
		alp.clickOnCrossReferralTab(driver);
		Thread.sleep(2000);
		alp.clickOnCrConfirm_Table_CrossReferral(driver);

		opdregistrationpage.OpdRegistartionForReferredFromHospitalLocation_CrossReferral(driver);
//		opdregistrationpage.submitAnd_ViewBtn_2(driver);
		opdregistrationpage.submitAnd_ViewBtn_2(driver);

	}
}
