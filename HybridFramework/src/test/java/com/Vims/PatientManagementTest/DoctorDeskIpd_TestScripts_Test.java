package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;

public class DoctorDeskIpd_TestScripts_Test extends BaseClass {

	@Test
	public void CheckThatUserShouldAbleToEnterTheDoctorProgressRecord_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");
		String date = currentDate_Dd_Mm_Yyyy();

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = alp.clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(driver,
				patientStatus);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.searchHospitalNumber(driver, hospitalNumber);
		ip.clickOnHospitalNumberInAllPatientListTab(driver);
		ip.clickOn_DoctorProgressRecordTab(driver);
		ip.enterData_InTheDoctorProgressRecord_CkEditor(driver);
		ip.clickOn_SaveButton(driver);
		String date1 = ip.capture_DoctorProgressRecord_Date(driver);
		Assert.assertEquals(date1, date);
	}

	@Test
	public void checkThatUserShouldbeEnterTheOtherNotes_Test() throws Throwable {
		String patientStatus = "ACTIVE";
		String templateType = "OT NOTES";
		String un = futil.getProperyKeyValue("doctorUserName");
		String pw = futil.getProperyKeyValue("doctorPassword");
		String date = curretDateAndTime_DDMMYYY_H_M();

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDesk_Ip_Page ip = new DoctorDesk_Ip_Page(driver);
		LoginPage lp = new LoginPage(driver);
		LogOutPage l = new LogOutPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = alp.clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(driver,
				patientStatus);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		ip.clickOnTheDoctorDeskIPDButton(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnAllPatientListInDDIPd(driver);
		ip.searchHospitalNumber(driver, hospitalNumber);
		ip.clickOnHospitalNumberInAllPatientListTab(driver);
		ip.clickOn_OtherNotesTab(driver);
		ip.selectTemplateType_enterData_InTheOtherNotes_CkEditor(driver, templateType);
		ip.clickOn_SubmitButton_OtherNotes(driver);
		String date1 = ip.capture_DateAndTime_OtherNotesHistory(driver);
		Assert.assertEquals(date, date1);
	}

}
