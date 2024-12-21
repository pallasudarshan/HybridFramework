package com.Vims.PatientManagementTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskOpdPattientScreenTestScripts_Test extends BaseClass{
	
	/*Tc-1 ToVerifyThatUserAble_To_AddTheInvestigations_In_DoctorDesk
	  Tc-2 To verify that user should able to add the prescriptions in the doctor desk.
	  Tc-3 ToVerifyThatUserShouldAbleToAddThe_Final_Diagnosis_Test
	  Tc-4 ToVerifyThatUserAbleTo_Upload_The_DocumntTest.
	  Tc-5 ToVerifyThaeUserShouldAbleTo_AddTheInvestigations_In_NextEncounter.
	  Tc-6 ToverifyThatUserShouldAble_CrossReferal_ThePatient.
	  Tc-7 ToverfyThatUserShouldAbleTo_FetchThePatient_Details_Test
	 */
	
	
/*	@Test
	public void ToVerifyThatUserAble_To_AddTheInvestigations_In_DoctorDeskTest() throws Throwable {
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		
		
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);
		dp.clickOnTheDoctorDeskButton(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
		dp.addInvestigationsInOPDPatient(driver);
		System.out.println("User successfully added a investogations in doctor desk op patient");	
	}
	
	@Test
	public void ToVerifyThatUserAbleToAddThe_Prescriptions_Test() throws Throwable {
		
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);
		dp.clickOnTheDoctorDeskButton(driver);
		hp.homeBtnForvims(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
		dp.addThePrescriptionsInTheOpdPteientForVims(driver);
	}
	
	//Tc-3
	@Test
	public void ToVerifyThatUserShouldAbleToAddThe_Final_Diagnosis_Test() throws Throwable {
		
		
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver,name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);
		dp.clickOnTheDoctorDeskButton(driver);
		hp.homeBtnForvims(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
		dp.addTheDignosisInThe_FinalDiagnosis_OpdVims(driver);
	}
	
	//Tc-4
	@Test
	public void ToVerifyThatUserAbleTo_Upload_The_DocumntTest() throws Throwable {

		
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);
		dp.clickOnTheDoctorDeskButton(driver);
		hp.homeBtnForvims(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
//		dp.enterTheProgressRecordTest(driver);
		dp.documentUploadOPDVims(driver);
	}
	
	//Tc-5
	@Test
	public void ToVerifyThaeUserShouldAbleTo_AddTheInvestigations_In_NextEncounter_Test() throws Throwable {
		
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String investigation="Dolo";
		
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);
		
		dp.clickOnTheDoctorDeskButton(driver);
		hp.homeBtnForvims(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
		dp.addThe_IvestigationsIn_NextEncounterOpdVims(driver, investigation);
	}
	
	//Tc-6
	@Test
	public void TpverifyThatUserShouldAble_CrossReferal_ThePatient_Test() throws Throwable {
		
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String clinicName="VYDEHI CLINIC";
		String department="CARDIOLOGY";
		String doctor="DR.VIJAYA SAI";
		String reason="sdsf";
		
		
		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);

		
		dp.clickOnTheDoctorDeskButton(driver);
		hp.homeBtnForvims(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
		dp.crossferralProcesForSubmit(driver,clinicName, department,doctor,reason);
		
		AllPatientListPage ap=new AllPatientListPage(driver);
		ap.clickOnTheAllPatientListButton(driver);


	}
	
	//Tc-7
	@Test
	public void ToverfiyThatUserShouldAbleTo_FetchThePatient_Details_Test() throws Throwable {
		
		String name = eutil.getDataFromTheExcel("Opdreg1", 2, 4);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "DR.VIJAYA SAI";
		String depName = "CARDIOLOGY";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		DoctorDeskPage dp=new DoctorDeskPage(driver);
		
		hp.homeBtnForvims(driver);
		
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname, mobilenum, mail, address, pincode, postOffice, depName, doctorname);
		opdregistrationpage.submitAnd_ViewBtn(driver);
		String hospitalNumber = opdregistrationpage.hospitalNumberInTheTableForVims(driver);
		String opNumber=opdregistrationpage.opNumber();
		
		dp.clickOnTheDoctorDeskButton(driver);
		hp.homeBtnForvims(driver);
		dp.clikOnTheDoctorDesk_And_IPDTab_AllPatietnListTab_Search_ip_Hospital_And_PatientArrivalOPD(driver, hospitalNumber);
		dp.fetchPatientDetailsProcessOPDvims(driver, hospitalNumber,opNumber);
	}
	*/
	

}
