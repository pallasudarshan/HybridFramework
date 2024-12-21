package com.Vims.NursingManagementTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.BedTransferConfirmationPage;
import com.Dalvkot.Vims_ObjectRepositary.BedTransferRequestPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

public class BedConfirmation_1_Test extends BaseClass {

	@Test
	public void CheckThatUserShouldbeFilterTheWardTypeDetails_Test() throws Throwable {
		String wardType = "GENERAL WARD";

		HomePage hp = new HomePage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.clickOnClearButton(driver);
		btc.selectWardType(driver, wardType);
		btc.clickOnSearchButton(driver);
		btc.take_ListOf_WardFrom_Table(driver, wardType);
	}

	@Test
	public void CheckThatUserShouldbeFilterTheRoomTypeDetails_Test() throws Throwable {
		String roomType = "COVID -19 DELUXE WARD";

		HomePage hp = new HomePage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.clickOnClearButton(driver);
		btc.selectRoomType(driver, roomType);
		btc.clickOnSearchButton(driver);
		btc.take_ListOf_FrommRoomType_Table(driver, roomType);
	}

	@Test
	public void CheckThatUserShouldbeFilterTheBedConfirmationDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.clickOnClearButton(driver);
		String hospitalNumber = btc.take_LastRowHospitalNumber_Table(driver);
		btc.enterHospitalNumber(driver, hospitalNumber);
		btc.clickOnSearchButton(driver);
		String hospitalNumber1 = btc.takeHospitalNumber_Table(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void CheckThatUserShouldbeFilterTheDetailsWithHelpOf_RequestDate_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		String requestDate = j.currentDate();

		String toDepartment = "CARDIOLOGY";
		String toDoctor = "VIJAYA SAI";
		String toWard = "GENERAL WARD";
		String toRoomType = "TRAIGE WITH";
		String Complaints = "TestTest";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);

		String hospitalNumber = btr.takeHospitalNumber_Table(driver);

		btr.bedTransferRequest(driver, hospitalNumber, toDepartment, toDoctor, toWard, toRoomType, Complaints);

		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.selectRequestDate(driver, requestDate);
		btc.clickOnSearchButton(driver);
		String requestDate1 = btc.RequestDate_Table(driver);

		Assert.assertEquals(requestDate, requestDate1);
	}

	@Test
	public void checkThatUserShouldbeConfirmTheBedTransferRequest_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		String fromDate = j.currentDate();
		String fromTime = j.current_Time_Hours_Min();
		String toDepartment = "CARDIOLOGY";
		String toDoctor = "VIJAYA SAI";
		String toWard = "GENERAL WARD";
		String toRoomType = "FEMALE ENDOCRINOLOGY WARD";
		String Complaints = "TestTest";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String status = "confirmed";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		btr.bedTransferRequest(driver, hospitalNumber, toDepartment, toDoctor, toWard, toRoomType, Complaints);
		BedMasterPage bp = new BedMasterPage(driver);
		String toBedNumber = bp.bedMasterForVims(driver, bedCategory, bedWardType, toRoomType, floor, wings,
				toDepartment, bedUnitDepartment);
		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.enterHospitalNumber(driver, hospitalNumber);
		btc.clickOnSearchButton(driver);
		btc.clickOnPendingButton_Table(driver);
		btc.confirm_Process(driver, toBedNumber, fromDate, fromTime);
		btc.clickOnSearchButton(driver);
		String status1 = btc.take_ActionStatus(driver);	
		Assert.assertEquals(status, status1);
	}

	@Test
	public void checkThatUserShouldbeToVerfiyTheRequestNumber_Test() throws Throwable {

		String toDepartment = "CARDIOLOGY";
		String toDoctor = "VIJAYA SAI";
		String toWard = "GENERAL WARD";
		String toRoomType = "TRAIGE WITH";
		String Complaints = "TestTest";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = btr.takeHospitalNumber_Table(driver);
		btr.bedTransferRequest(driver, hospitalNumber, toDepartment, toDoctor, toWard, toRoomType, Complaints);
		String reqNumber = btr.take_Request_Number_Table(driver);
		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.enterHospitalNumber(driver, hospitalNumber);
		btc.clickOnSearchButton(driver);
		String reqNumber1 = btc.take_Request_Number_Table(driver);
		Assert.assertEquals(reqNumber, reqNumber1);
	}

	@Test
	public void checkThatUserShouldCancelTheBedTransferRequest_Test() throws Throwable {
		String toDepartment = "CARDIOLOGY";
		String toDoctor = "VIJAYA SAI";
		String toWard = "GENERAL WARD";
		String toRoomType = "TRAIGE WITH";
		String Complaints = "No need to change the bed stay in previous bed only";
		String status = "Cancelled";

		HomePage hp = new HomePage(driver);
		BedTransferRequestPage btr = new BedTransferRequestPage(driver);
		BedTransferConfirmationPage btc = new BedTransferConfirmationPage(driver);

		btr.clickOnBedTransferRequest(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = btr.takeHospitalNumber_Table(driver);
		btr.bedTransferRequest(driver, hospitalNumber, toDepartment, toDoctor, toWard, toRoomType, Complaints);

		btc.clickOnBedTransferConfirmation(driver);
		hp.homeBtnForvims(driver);
		btc.enterHospitalNumber(driver, hospitalNumber);
		btc.clickOnSearchButton(driver);
		btc.clickOnPendingButton_Table(driver);
		btc.enter_ComplaintText(driver, Complaints);
		btc.clickOn_SubmitButton(driver);
		btc.clickOnOkButton(driver);
		btc.clickOnSearchButton(driver);
		String status1 = btc.take_CancelStatus_InTheList(driver);
		Assert.assertEquals(status, status1);
	}

}
