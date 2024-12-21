package com.Vims.PatientManagementTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.ClearanceScreenPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class AllPatientList_AtiveList_Test extends BaseClass {

	@Test
	public void checkThat_UserShouldbeDischargeThePatient_Test() throws Throwable {
//		String patientStatus = "ACTIVE";
//		String dischargeStatus = "CURED";
//		String dischargeResult = "A 49-year-old man with respiratory distress, history of coronary "
//				+ "artery disease with prior myocardial infarctions, "
//				+ "and recently admitted with pneumonia and respiratory failure.";
//
//		HomePage homePage = new HomePage(driver);
//		ClearanceScreenPage clearanceScreenPage = new ClearanceScreenPage(driver);
//		AllPatientListPage allPatientListPage = new AllPatientListPage(driver);
//
//		allPatientListPage.clickOnTheAllPatientListButton(driver);
//		homePage.homeBtnForvims(driver);
//		allPatientListPage.clickOnClearButton(driver);
//		allPatientListPage.selectPatientStatusDropdown(driver, patientStatus);
//		allPatientListPage.clickOnTheSearchButton(driver);
//		String hospitalNumber = allPatientListPage.takeTheHospitalNumberInTheActivePatientTable(driver);
//		allPatientListPage.clickOnActionsButton_ActiveList(driver);
//		allPatientListPage.clickOn_DischargeIntimation_ActiveList(driver);
//		allPatientListPage.clickOn_DischargeIntimation_ForClearence(driver);
//		allPatientListPage.clickOn_Ok_Button(driver);
//
//		clearanceScreenPage.clickOn_ClearencePage(driver);
//		homePage.homeBtnForvims(driver);
//		clearanceScreenPage.clearence_Process(driver, hospitalNumber);
//
//		allPatientListPage.clickOnTheAllPatientListButton(driver);
//		homePage.homeBtnForvims(driver);
//		allPatientListPage.clickOnClearButton(driver);
//		allPatientListPage.enterTheHospitalNumber(hospitalNumber);
//		allPatientListPage.clickOnTheSearchButton(driver);
//		allPatientListPage.clickOn_DischargeIntimation_ActiveList(driver);
//		allPatientListPage.select_DischargeStatus_Clearence(driver, dischargeStatus);
//		allPatientListPage.enter_DischargeResult_Clearence(driver, dischargeResult);
	}
}
