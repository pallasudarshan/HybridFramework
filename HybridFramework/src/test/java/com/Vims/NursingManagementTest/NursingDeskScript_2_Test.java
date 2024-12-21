package com.Vims.NursingManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.NursingDeskPage;
import com.Dalvkot.Vims_ObjectRepositary.NursingDesk_WardServicesPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class NursingDeskScript_2_Test extends BaseClass {

	@Test(priority = 0)
	public void checkThatUserShouldCreateTheNursingAssessment_Test() throws Throwable {
		String location = "CHEST";
		String symptoms = " rash";
		String numericRating = "1";
		String size = "123456789123";
		String clasification = "STAGE";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);

		String status = np.take_StatusTable(driver);
		np.create_NursingAssessment(driver, status, symptoms, location, numericRating, size, clasification);
		hp.homeBtnForvims(driver);
		String userName = np.take_UserName(driver);
		hp.homeBtnForvims(driver);

		String userName1 = np.assessement_History_AdminName(driver);
		Assert.assertEquals(userName, userName1);
	}

	@Test(priority = 1)
	public void checkThatUserShouldCreateTheNursingCarePlan_Test() throws Throwable {

		String preventive = "Test";
		String curative = "Test";
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		String status = np.take_StatusTable(driver);
		np.nursingCarePlan(driver, status, preventive, curative);

		hp.homeBtnForvims(driver);
		String userName = np.take_UserName(driver);
		hp.homeBtnForvims(driver);

		String userName1 = np.assessement_History_AdminName(driver);
		Assert.assertEquals(userName, userName1);
	}

	@Test(priority = 2)
	public void checkThatUserShouldCreateTheNursingProgresRecord_As_Arrival_Test() throws Throwable {

		String instruction = "ARRIVAL";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		String status = np.take_StatusTable(driver);
		np.nursingProgress_Record(driver, status, instruction);
	}

	@Test(priority = 3, invocationCount = 3)
	public void checkThatUserShouldCreateTheNursingProgresRecord_As_Medication_Test() throws Throwable {

		String instruction = "MEDICATION";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		String status = np.take_StatusTable(driver);
		np.nursingProgress_Record(driver, status, instruction);
	}

	@Test
	public void checkThatSystemShouldNotAllowToSubmitWithoutEnteringSymptoms_NursingAssesment_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);

		String status = "ARRIVED";

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOnTheNursingAssessmentTab(driver);
		np.clickOn_PlusButton_NursingAssessement(driver);
		np.clickOnTheSubmitButton_NursingAssessment(driver);
		String text = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(text, "Please Select symptoms");
	}

	@Test
	public void checkThatSystemShouldNotAllowToSubmitWithoutEnteringPreventive_NursingCarePlan_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);

		String status = "ARRIVED";

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingCarePlanTab(driver);
		np.clickOn_PlusButton_NursingCarePlan(driver);
		np.clickOn_Submit_NursingCarePlan(driver);
		String text = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(text, "please select preventive");
	}

	@Test
	public void checkThatSystemShouldNotAllowToSubmitWithoutEnteringCurative_NursingCarePlan_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);

		String status = "ARRIVED";
		String preventive = "Test";

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingCarePlanTab(driver);
		np.clickOn_PlusButton_NursingCarePlan(driver);
		np.enter_Preventive_NursingCarePlan(driver, preventive);

		np.clickOn_Submit_NursingCarePlan(driver);
		String text = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(text, "please select curative");
	}

	@Test
	public void checkThatEnteredDataInProgressRecordIsDisplayingInTheListCorrectlyAfterSubmit_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);

		String status = "ARRIVED";
		String instruction = "MEDICATION";
		String text = "TEST";

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingProgressRecord(driver);
		np.clickOn_PlusButton_NursingProgressecord(driver);
		np.select_Instruction_NursingProgressRecord(driver, instruction);
		np.enterData_NursingProgressRecird_Iframe(driver, text);
		np.clickOnTheSaveButtonInNUrisngProgressRecord(driver);
		np.clickOnSideDate_NursingRecord(driver);
		String text1 = np.captureReport_NursingProgressRecord(driver);
		Assert.assertEquals(text, text1, "nursing record data missmatched");
	}

	@Test
	public void checkThatUserNameAndReportInTableIsReflectingSameInViewDetails_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);

		String status = "ARRIVED";
		String instruction = "MEDICATION";
		String text = "TEST";

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingProgressRecord(driver);
		np.clickOn_PlusButton_NursingProgressecord(driver);
		np.select_Instruction_NursingProgressRecord(driver, instruction);
		np.enterData_NursingProgressRecird_Iframe(driver, text);
		np.clickOnTheSaveButtonInNUrisngProgressRecord(driver);
		np.clickOnSideDate_NursingRecord(driver);
		String report = np.captureReport_NursingProgressRecord(driver);
		np.clickOnViewBtn_NursingProgressRecord_Test(driver);
		String report1 = np.captureReport_UnderViewBtn_NursingProgressRecord(driver);
		Assert.assertEquals(report, report1, "nursing record data missmatched");
	}

	@Test
	public void checkThatDateIsReflectingCorrectlyAfterSubmittingNursingProgressRecord_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		JavaUtility j = new JavaUtility();

		String status = "ARRIVED";
		String instruction = "MEDICATION";
		String text = "TEST";
		String date = j.generateCurrentDate_DDMMYYYY();

		System.out.println(date);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingProgressRecord(driver);
		np.clickOn_PlusButton_NursingProgressecord(driver);
		np.select_Instruction_NursingProgressRecord(driver, instruction);
		np.enterData_NursingProgressRecird_Iframe(driver, text);
		np.clickOnTheSaveButtonInNUrisngProgressRecord(driver);
		String date1 = np.captureDate_NursingProgressRecord(driver);
		Assert.assertEquals(date, date1, "date is missmatched");
	}

	@Test
	public void checkThatUserIsAbleToFilterUsingDateInNursingProgressRecord_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);

		String status = "ARRIVED";
		String instruction = "MEDICATION";
		String text = "TEST";

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingProgressRecord(driver);
		np.clickOn_PlusButton_NursingProgressecord(driver);
		np.select_Instruction_NursingProgressRecord(driver, instruction);
		np.enterData_NursingProgressRecird_Iframe(driver, text);
		np.clickOnTheSaveButtonInNUrisngProgressRecord(driver);
		String date = np.captureDate_NursingProgressRecord(driver);
		np.enterDate_NursingProgressRecord(driver, date);
		String date1 = np.captureDate_NursingProgressRecord(driver);
		Assert.assertEquals(date, date1, "date is missmatched");
	}

	@Test
	public void checkThatUserIsAbleToEditTheNursingProgressRecordAndVerifyTheData_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		NursingDeskPage np = new NursingDeskPage(driver);
//		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
//
//		String status = "ARRIVED";
//		String instruction = "MEDICATION";
//		String text = "TEST";
//		String text1 = "Loreum Ipsum";
//
//		np.clickOnNursingDesk(driver);
//		hp.homeBtnForvims(driver);
//		nd.selectStatusDropdown(driver, status);
//		nd.clickOnTheSearchButton(driver);
//		np.clickOn_HospitalNumber(driver);
//		np.clickOn_NursingProgressRecord(driver);
//		np.clickOn_PlusButton_NursingProgressecord(driver);
//		np.select_Instruction_NursingProgressRecord(driver, instruction);
//		np.enterData_NursingProgressRecird_Iframe(driver, text);
//		np.clickOnTheSaveButtonInNUrisngProgressRecord(driver);
//		np.clickOnSideDate_NursingRecord(driver);
//		np.clickOnEditBtn_NursingProgressRecord_Test(driver);
//		np.enterData_NursingProgressRecird_Iframe(driver, text1);
//		np.clickOnTheSaveButtonInNUrisngProgressRecord(driver);
//		np.clickOnSideDate_NursingRecord(driver);
//		String report = np.captureReport_NursingProgressRecord(driver);
//		Assert.assertEquals(report, text1, "nursing record data missmatched");
	}

}
