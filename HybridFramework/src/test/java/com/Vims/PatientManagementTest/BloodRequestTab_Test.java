package com.Vims.PatientManagementTest;

import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;

public class BloodRequestTab_Test extends BaseClass {

	@Test
	public void addBloodRequestTab_Test() throws Throwable {
		String registrationType = "EMERGENCY";
		String department = "NEUROLOGY";
		String doctor = "SURE";
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION";
		String floor = "5TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "abbas";
		String time = "";
		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String doctorName = "SURESHA KODAPALA";
		String route = "ORAL";

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		hp.homeBtnForvims(driver);
		op.createOpdRegistrationForIpPatients(driver, registrationType, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// add investigations
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		// ipd.clickOnPatientArrivalBtn(driver, doctorName);
		ipd.ClickOnSavebtn(driver);

		String bloodGroup = "A POSITIVE";
		String diagnosis = "TEST";
		String indications = "MASS TRANSFUSION PROTOCOL";
		String date = generateCurrentDate_DDMMYYYY_WithoutSpecialCharacter();
		String time2 = "0220";
		String componenetType = "CRYOPRECIPITATE";
		String qty2 = "2";
		String specimenCollectedBy = "SURYA";
		String remarks = "REMARKS ENTERED IN AUTOMATION TESTING";

		ipd.clickOnBloodRequestTab(driver);
		ipd.clickOnAddBtn_BloodRequest(driver);
		ipd.selectBloodGroup_BloodRequest(driver, bloodGroup);
		ipd.enterDiagnosis_BloodRequest(driver, diagnosis);
		ipd.selectIndications_BloodRequest(driver, indications);
		ipd.enterRequiredOnDate_BloodRequest(driver, date);
		ipd.enterRequiredOnTime_BloodRequest(driver, time2);
		ipd.selectComponenetType_BloodRequest(driver, componenetType);
		ipd.enterRequiredQuantity_BloodRequest(driver, qty2);
		ipd.clickOnAddBtn_BloodComponenet(driver);
		ipd.enterSpecimenCollectedBy_BloodRequest(driver, specimenCollectedBy);
		ipd.enteremarks_BloodRequest(driver, remarks);
		ipd.clickOnSubmit_BloodRequest(driver);
	}

	@Test
	public void addBloodRequestTab_RandomIndications_Components_BloodGroup_Test() throws Throwable {
		String registrationType = "EMERGENCY";
		String department = "NEUROLOGY";
		String doctor = "SURE";
		String bedCategory = "NON TEACHING";
		String bedWardType = "INFECTION DISEASE WARD";
		String bedRoomType = "INFECTION";
		String floor = "5TH FLOOR";
		String wings = "EAST WING";
		String admittedByDr = "abbas";
		String time = "";
		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";
		String pattern = "0-0-2";
		String qty = "23";
		String doctorName = "SURESHA KODAPALA";
		String route = "ORAL";

		OPDRegistrationPage op = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		hp.homeBtnForvims(driver);
		op.createOpdRegistrationForIpPatients(driver, registrationType, department, doctor);
		String hospitalNumber = op.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);

		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		System.out.println(bednumberh);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, department, doctor, admittedByDr,
				bedWardType, bedRoomType, bednumberh);

//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// add investigations
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ipd.clickOnAllPatientListInDDIPd(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnHospitalNumberInAllPatientListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);

		String bloodGroup = "A POSITIVE";
		String diagnosis = "TEST";
		String indications = "MASS TRANSFUSION PROTOCOL";
		String date = generateCurrentDate_DDMMYYYY_WithoutSpecialCharacter();
		String time2 = "0220";
		String componenetType = "CRYOPRECIPITATE";
		String qty2 = "2";
		String specimenCollectedBy = "SURYA";
		String remarks = "REMARKS ENTERED IN AUTOMATION TESTING";

		ipd.clickOnBloodRequestTab(driver);
		ipd.clickOnAddBtn_BloodRequest(driver);
		ipd.selectBloodGroup_BloodRequest_Random(driver);
		ipd.enterDiagnosis_BloodRequest(driver, diagnosis);
		ipd.selectIndications_BloodRequest_Random(driver);
		ipd.enterRequiredOnDate_BloodRequest(driver, date);
		ipd.enterRequiredOnTime_BloodRequest(driver, time2);
		ipd.selectComponenetType_BloodRequest_Random(driver);
		ipd.enterRequiredQuantity_BloodRequest(driver, qty2);
		ipd.clickOnAddBtn_BloodComponenet(driver);
		ipd.enterSpecimenCollectedBy_BloodRequest(driver, specimenCollectedBy);
		ipd.enteremarks_BloodRequest(driver, remarks);
		ipd.clickOnSubmit_BloodRequest(driver);
	}
}
