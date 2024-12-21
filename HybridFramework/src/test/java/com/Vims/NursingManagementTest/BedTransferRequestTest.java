package com.Vims.NursingManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.BedTransferConfirmationPage;
import com.Dalvkot.Vims_ObjectRepositary.BedTransferRequestPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

public class BedTransferRequestTest extends BaseClass {
	/*
	 * @Test(priority = 0) public void createTheBedTransferRequest() throws
	 * Throwable {
	 * 
	 * }
	 */

	@Test(priority = 1)
	public void CheckThatWithoutEnteringhopsitalNumberFieldClickOnTheSubmit_Test() throws Throwable {
		String msg1 = "Please Enter Hospital Number";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);

		hp.homeBtnForvims(driver);
		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		btr.clickOnNewButton(driver);
		btr.clickOnSubmitButton(driver);
		String msg = btr.errorMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "  Successfully");
	}

	@Test(priority = 2)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingToDepartment_Test() throws Throwable {
		String toWard = "GENERAL WARD";
		String toRoom = "C19 TRAIGE MALE GEN WARD";
		String remarks = "test";
		String msg1 = "Please Select To Department";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		hp.homeBtnForvims(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);

		btr.clickOnNewButton(driver);
		btr.enterHospitalNumber(driver, hospitalNumber);
		btr.selectToWard(driver, toWard);
		btr.selectToRoomType(driver, toRoom);
		btr.enterRemarksComplaints(driver, remarks);
		btr.clickOnSubmitButton(driver);
		String msg = btr.errorMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "  Successfully");
	}

	@Test(priority = 3)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingToDoctor_Test() throws Throwable {
		String toDepartment = "CARDIOLOGY";
		String toWard = "GENERAL WARD";
		String toRoom = "C19 TRAIGE MALE GEN WARD";
		String remarks = "test";
		String msg1 = "Please Select To Doctor";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);
		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		btr.clickOnNewButton(driver);
		btr.enterHospitalNumber(driver, hospitalNumber);
		btr.selectToDepartment(driver, toDepartment);
		btr.selectToWard(driver, toWard);
		btr.selectToRoomType(driver, toRoom);
		btr.enterRemarksComplaints(driver, remarks);
		btr.clickOnSubmitButton(driver);
		String msg = btr.errorMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "  Successfully");
	}

	@Test(priority = 4)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingToWard_Test() throws Throwable {
		String toDoctor = futil.getProperyKeyValue("cardiologyDoctor");
		String toDepartment = futil.getProperyKeyValue("cardiologyDepartment");
		String remarks = "test";
		String msg1 = "Please Select To Ward";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);

		btr.clickOnNewButton(driver);
		btr.enterHospitalNumber(driver, hospitalNumber);
		btr.selectToDepartment(driver, toDepartment);
		btr.selectToDoctor(driver, toDoctor);
		btr.enterRemarksComplaints(driver, remarks);
		btr.clickOnSubmitButton(driver);
		String msg = btr.errorMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "  Successfully");
	}

	@Test(priority = 5)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingToRoomType_Test() throws Throwable {
		String toDoctor = futil.getProperyKeyValue("cardiologyDoctor");
		String toDepartment = futil.getProperyKeyValue("cardiologyDepartment");
		String toWard = "GENERAL WARD";
		String remarks = "test";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);

		hp.homeBtnForvims(driver);
		btr.clickOnBedTransferRequest(driver);
		String hospitalNumber = btr.takeHospitalNumber_Table(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		btr.clickOnNewButton(driver);
		btr.enterHospitalNumber(driver, hospitalNumber);
		btr.selectToDepartment(driver, toDepartment);
		btr.selectToDoctor(driver, toDoctor);
		btr.selectToWard(driver, toWard);
		btr.enterRemarksComplaints(driver, remarks);
		btr.clickOnSubmitButton(driver);
		btr.clickOnOkButton(driver);

	}

	@Test
	public void checkThatUserShouldAbleToClickOnTheBackButton_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);

		hp.homeBtnForvims(driver);
		btr.clickOnBedTransferRequest(driver);
		btr.clickOnNewButton(driver);
		btr.clickOnBackButton(driver);
		System.out.println("User redirected to main page successfully");
	}

	// TC-7
	@Test
	public void checkThatUserShouldAbleToClickOnTheCancelButton_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		hp.homeBtnForvims(driver);
		btr.clickOnBedTransferRequest(driver);
		btr.clickOnNewButton(driver);
		btr.clickOnCancelButton(driver);
		System.out.println("User canclled successfully and navigate to main page");
	}

	@Test
	public void CheckThtaIEnterWrongHopsitalNumberUserGetTheErrorPopupMsg_Test() throws Throwable {
		String hospitalnumber = "8152054343";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);

		hp.homeBtnForvims(driver);
		btr.clickOnBedTransferRequest(driver);
		btr.clickOnNewButton(driver);
		btr.enterHospitalNumber(driver, hospitalnumber);
		btr.clickOnSubmitButton(driver);
		btr.clickOnOkButton(driver);
		System.out.println("User got the error popup After entered wrong pop");
	}

	@Test
	public void CheckThatUserShouldBeCancelTheBedTrnasferRequestInTheConfirmationPage_Test() throws Throwable {
		String toDoctor = futil.getProperyKeyValue("cardiologyDoctor");
		String toDepartment = futil.getProperyKeyValue("cardiologyDepartment");
		String toWard = "GENERAL WARD";
		String toRoomType = "TRAIGE WITH";
		String Complaints = "TestTest";
		String status = "Cancelled";
		String status2 = "CANCELLED";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		BedTransferConfirmationPage bc = new BedTransferConfirmationPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		btr.bedTransferRequest(driver, hospitalNumber, toDepartment, toDoctor, toWard, toRoomType, Complaints);

		bc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);

		bc.enterHospitalNumber(driver, hospitalNumber);
		bc.clickOnSearchButton(driver);
		bc.clickOnPendingButton_Table(driver);
		bc.enter_ComplaintText(driver, Complaints);
		bc.clickOn_SubmitButton(driver);
		bc.clickOnOkButton(driver);

		bc.clear_HospitalNumber_Filter(driver);
		bc.enterHospitalNumber(driver, hospitalNumber);
		bc.clickOnSearchButton(driver);
		String status1 = bc.take_ActionStatus(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		String status3 = btr.take_Action_Status(driver);

		SoftAssert sp = new SoftAssert();
		sp.assertEquals(status, status1);

		sp.assertEquals(status2, status3);

		sp.assertAll();

	}

	@Test
	public void checkThatUserShouldbeCancelTheBedTransferRequest_Test() throws Throwable {
		String toDoctor = futil.getProperyKeyValue("cardiologyDoctor");
		String toDepartment = futil.getProperyKeyValue("cardiologyDepartment");
		String toWard = "GENERAL WARD";
		String toRoomType = "TRAIGE WITH";
		String Complaints = "TestTest";
		String reason = "As of now there is no any beds are available";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);

		btr.bedTransferRequest(driver, hospitalNumber, toDepartment, toDoctor, toWard, toRoomType, Complaints);
		btr.cancelRequest_Process(driver, reason);

	}

}
