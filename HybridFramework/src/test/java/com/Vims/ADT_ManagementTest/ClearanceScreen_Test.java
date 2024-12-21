package com.Vims.ADT_ManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.ClearanceScreenPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

public class ClearanceScreen_Test extends BaseClass {
	@Test
	public void checkThatUserShouldbeFilterDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		ClearanceScreenPage clearanceScreenPage = new ClearanceScreenPage(driver);

		clearanceScreenPage.clickOn_ClearencePage(driver);
		homePage.homeBtnForvims(driver);
		String hospitalNumber = clearanceScreenPage.take_LastRowHospitalNumber(driver);
		clearanceScreenPage.enterHospitalNumber(driver, hospitalNumber);
		clearanceScreenPage.clickOn_SearchButton(driver);
		String hospitalNumber1 = clearanceScreenPage.capture_FirstRow_hospitalNumber(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserShouldVerifyThePatientDetailsInTheClearencePopup_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		ClearanceScreenPage clearanceScreenPage = new ClearanceScreenPage(driver);

		clearanceScreenPage.clickOn_ClearencePage(driver);
		homePage.homeBtnForvims(driver);
		String hospitalNumber = clearanceScreenPage.capture_FirstRow_hospitalNumber(driver);
		String patientName = clearanceScreenPage.capture_PatientName_List(driver);
		String ipNumber = clearanceScreenPage.capture_IpNumber_List(driver);
		clearanceScreenPage.clickOn_HospitalNumber_Table(driver);
		String hospitalNumber1 = clearanceScreenPage.capture_HospitalNumber_Popup(driver);
		String ipNumber1 = clearanceScreenPage.capture_IpNumber_Popup(driver);
		String patientName1 = clearanceScreenPage.capture_PatientName_Popup(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(hospitalNumber1, hospitalNumber, "Successfully Verified a hospitalNumber in the popup");
		sa.assertEquals(patientName1, patientName, "Successfully Verified a patient Name  in the popup");
		sa.assertEquals(ipNumber1, ipNumber, "Successfully Verified a ip Number  in the popup");
		sa.assertAll();

	}

	@Test
	public void checkThatUserShouldbeVerifyThe_DischargeInitmated_PatientDetailsInTheList_Test() throws Throwable {

		String patientStatus = "DISCHARGE INTIMATED";

		HomePage homePage = new HomePage(driver);
		ClearanceScreenPage clearanceScreenPage = new ClearanceScreenPage(driver);
		AllPatientListPage allPatientListPage = new AllPatientListPage(driver);

		allPatientListPage.clickOnTheAllPatientListButton(driver);
		homePage.homeBtnForvims(driver);
		allPatientListPage.clickOnClearBtn(driver);
		allPatientListPage.selectPatientStatusDropdown(driver, patientStatus);
		allPatientListPage.clickOnTheSearchButton(driver);
		String hospitalNumber = allPatientListPage.takeTheHospitalNumberInTheActivePatientTable(driver);
		String patientName = allPatientListPage.takeThePatientNameInTheActivePatinet_Table(driver);
		String ipNumber = allPatientListPage.takeIpNumberInTheActivePatinet_Table(driver);
		String wardType = allPatientListPage.takeWardTypeNameInTheActivePatinet_Table(driver);
		String bedNumber = allPatientListPage.takeBedNumberInTheActivePatinet_Table(driver);
		String doctorName = allPatientListPage.takeDoctorNameInTheActivePatinet_Table(driver);
		String department = allPatientListPage.takeDepartmentNameInTheActivePatinet_Table(driver);

		clearanceScreenPage.clickOn_ClearencePage(driver);
		homePage.homeBtnForvims(driver);
		clearanceScreenPage.enterHospitalNumber(driver, hospitalNumber);
		clearanceScreenPage.clickOn_SearchButton(driver);
		String hospitalNumber1 = clearanceScreenPage.capture_FirstRow_hospitalNumber(driver);
		String patientName1 = clearanceScreenPage.capture_PatientName_List(driver);
		String ipNumber1 = clearanceScreenPage.capture_IpNumber_List(driver);
		String wardType1 = clearanceScreenPage.capture_WardName_List(driver);
		String bedNumber1 = clearanceScreenPage.capture_BedNumber_List(driver);
		String doctorName1 = clearanceScreenPage.capture_DoctorName_List(driver);
		String department1 = clearanceScreenPage.capture_Department_List(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(hospitalNumber1, hospitalNumber, "hospital Number Verified sucessfully");
		sa.assertEquals(patientName1, patientName, "Patient name verified sucessfully");
		sa.assertEquals(ipNumber1, ipNumber, "ip number verified successfully");
		sa.assertEquals(wardType1, wardType, "ward type verified successfully");
		sa.assertEquals(bedNumber1, bedNumber, "bed number verified successfully");
		sa.assertEquals(doctorName1, doctorName, "doctor name verified successfully");
		sa.assertEquals(department1, department, "department name verified successfully");
		sa.assertAll();
	}

	@Test
	public void checkThatUserShouldClearTheAllDepartmentsBills_Test() throws Throwable {

		String patientStatus = "ACTIVE";

		HomePage homePage = new HomePage(driver);
		ClearanceScreenPage clearanceScreenPage = new ClearanceScreenPage(driver);
		AllPatientListPage allPatientListPage = new AllPatientListPage(driver);

		allPatientListPage.clickOnTheAllPatientListButton(driver);
		homePage.homeBtnForvims(driver);
		allPatientListPage.clickOnClearButton(driver);
		allPatientListPage.selectPatientStatusDropdown(driver, patientStatus);
		allPatientListPage.clickOnTheSearchButton(driver);
		String hospitalNumber = allPatientListPage.takeTheHospitalNumberInTheActivePatientTable(driver);
		allPatientListPage.clickOnActionsButton_ActiveList(driver);
		allPatientListPage.clickOn_DischargeIntimation_ActiveList(driver);
		allPatientListPage.clickOn_DischargeIntimation_ForClearence(driver);
		allPatientListPage.clickOn_Ok_Button(driver);
		clearanceScreenPage.clickOn_ClearencePage(driver);
		homePage.homeBtnForvims(driver);
		clearanceScreenPage.clearence_Process(driver, hospitalNumber);
		System.out.println(hospitalNumber);

	}

	@Test
	public void checkThatWithoutDischargeIntimation_IfTryToClearTheBillsForRespectiveHospitalNumber_Test()
			throws Throwable {
		String patientStatus = "ACTIVE";
		String clearenceFrom = "BILL CLEARANCE";
		String msg1 = "discharge intimation Not Done";

		AllPatientListPage allPatientListPage = new AllPatientListPage(driver);
		HomePage homePage = new HomePage(driver);
		ClearanceScreenPage clearanceScreenPage = new ClearanceScreenPage(driver);

		allPatientListPage.clickOnTheAllPatientListButton(driver);
		homePage.homeBtnForvims(driver);
		allPatientListPage.clickOnClearButton(driver);
		allPatientListPage.selectPatientStatusDropdown(driver, patientStatus);
		allPatientListPage.clickOnTheSearchButton(driver);
		String hospitalNumber = allPatientListPage.takeTheHospitalNumberInTheActivePatientTable(driver);
		clearanceScreenPage.clickOn_ClearencePage(driver);
		homePage.homeBtnForvims(driver);
		clearanceScreenPage.enterHospitalNumber(driver, hospitalNumber);
		clearanceScreenPage.select_ClearenceFrom(driver, clearenceFrom);
		clearanceScreenPage.select_DischargeIntimationListCheckBox(driver);
		clearanceScreenPage.clickOn_SearchButton(driver);
		clearanceScreenPage.clickOn_HospitalNumber_Table(driver);
		clearanceScreenPage.clickOn_SaveButtonOnThe_Popup(driver);
		String msg = clearanceScreenPage.capture_OkPopups_Messages(driver);
		clearanceScreenPage.clickOn_OkPopup_Button(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test
	public void checkThatUserShouldAbleVerifyTheDischargeintimationStatusOnceDischargeIntimated_Test()
			throws Throwable {

		String patientStatus = "DISCHARGE INTIMATED";
		String status = "YES";

		AllPatientListPage alp = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		ClearanceScreenPage cs = new ClearanceScreenPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		alp.selectPatientStatusDropdown(driver, patientStatus);
		alp.clickOnTheSearchButton(driver);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		cs.clickOn_ClearencePage(driver);
		cs.enterHospitalNumber(driver, hospitalNumber);
		cs.clickOn_SearchButton(driver);
		String hospitalNumber1 = cs.capture_FirstRow_hospitalNumber(driver);
		String status1 = cs.capture_DischargeIntimationStatus_List(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		Assert.assertEquals(status1, status);

	}

}