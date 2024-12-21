package com.Vims.OpeartionTheaterTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.IpBillingPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.otConfirmationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class Ot_Confirmation_Test extends BaseClass {
	@Test
	public void toVerifyThatUserShouldbeConfirmTheOtScheduling_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "TEST";
		String doctorCategory = "UG DOCTORS";
		String consultantName = "LOKESH";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String date = jutil.currentDate();
		String dep = "CARDIOLOGY";

		OTSchedulingPage ots = new OTSchedulingPage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

//		hp.homeBtnForvims(driver);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		Thread.sleep(1000);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		String hospitalNumber = "8352157";

		ots.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumber(driver, hospitalNumber);
		ots.selectDepartmentInOtScheduling(driver, depName);
		ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
		ots.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduleProcess_two(driver, dep, surgeryDescription, doctorCategory, consultantName, diagnosis);
		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		Thread.sleep(2000);
		ots.clickOnSearchBtn_Filters(driver);
		String hospitalNumber1 = ots.takeHospitalNumber_OtList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		ots.clickOnHospitalNumber_OtList(driver);
		ocp.clickOnSubmitBtn(driver);
	}

	/*
	 * @Test public void
	 * checkThat_TryToDoConfirmFor_AlreadyConfirmedOtScheduledPatient_Test() throws
	 * Throwable {
	 * 
	 * String status = "CONFIRMED"; String msg = "already confirmed"; String name =
	 * "S"; String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5); String fname =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 6); String mobilenum =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 7); String mail =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 8); String address =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 9); String pincode =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 10); String doctorname = "RAMA";
	 * String depName = "general medicine"; String postOffice =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 14);
	 * 
	 * String operationTheater = "operation"; String surgeryType = "MAJOR"; String
	 * surgeryNature = "ELECTIVE"; String surgeryTime = "1212"; String duration =
	 * "8"; String anastesiaType = "EPIDURAL"; String specialNotes = "testing";
	 * String surgeryDescription = "TEST"; String doctorCategory = "SURGEON"; String
	 * consultantName = "FSDFF"; String instrumentName = "Test"; String description
	 * = "CAMRA CASE"; String quantity = "12"; String rate = "12"; String diagnosis
	 * = "testtest"; String dep="CARDIOLOGY";
	 * 
	 * OTSchedulingPage ots = new OTSchedulingPage(driver); HomePage hp = new
	 * HomePage(driver);
	 * 
	 * hp.homeBtnForvims(driver); OPDRegistrationPage opdregistrationpage = new
	 * OPDRegistrationPage(driver);
	 * opdregistrationpage.opdRegistrationButton(driver);
	 * opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname,
	 * mobilenum, mail, address, pincode, postOffice, depName, doctorname);
	 * Thread.sleep(1000); String hospitalNumber =
	 * opdregistrationpage.submitAnd_ViewBtn(driver);
	 * 
	 * ots.clickOnOtScenduleScreenLink(driver); ots.clickOnTheAddBtn(driver);
	 * ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
	 * ots.selectDepartmentInOtScheduling(driver, depName);
	 * ots.selectOperationTheaterInOtScheduling(driver, operationTheater);
	 * ots.otScheduling_Process(driver, operationTheater, surgeryType,
	 * surgeryNature, surgeryTime, duration, anastesiaType, specialNotes);
	 * ots.otScheduling_ProcessTwo(driver, dep, surgeryDescription, doctorCategory,
	 * consultantName, instrumentName, description, quantity, rate, diagnosis);
	 * System.out.println("successsfully created");
	 * 
	 * ots.enterHospitalNumber_Filter(driver, hospitalNumber); Thread.sleep(2000);
	 * ots.clickOnSearchBtn_Filters(driver);
	 * 
	 * ots.clickOnHospitalNumber_OtList(driver);
	 * 
	 * String msg1 = ots.takeAlready_Confirmed_PopupStatus_OkBtn(driver);
	 * Assert.assertEquals(msg1, msg); }
	 */

	@Test
	public void checkThatOnceTheOtScheduleAndConfirmationDone_VerifySrgeons_And_OtAmountsInBilling_Test()
			throws Throwable {
		String operationTheater = "operation";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String surgeryDescription = "TEST";
		String diagnosis = "testtest";
		String SurgeryType = "MAJOR";
		String SurgeryNature = "ELECTIVE";
		String SurgeryTime = "1200";
		String department = "CARDIOLOGY";
		String doctorCateory1 = "SENIOR DOCTOR";
		String consultantName1 = "PAULAMI";
		String consultantName2 = "TEST";
		String consultantName3 = "RAMYA";
		String consultantName4 = "RAMYA";
		String surgeonAmount = "124";
		String name = "IP PATIENT";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = "IP PATIENT";
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRAIGE MALE GEN WARD";
		String floor = "2ND FLOOR";
		String wings = "WEST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRAIGE MALE GEN WARD";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";
		String date = jutil.currentDate();
		String doctorname = futil.getProperyKeyValue("doctornameNeurology");
		String depName = futil.getProperyKeyValue("depNameNeurology");

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ot = new OTSchedulingPage(driver);
		otConfirmationPage oct = new otConfirmationPage(driver);
		IpBillingPage ip = new IpBillingPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);
		// patientAdmission
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);
		// String dep = alp.takeDepartmentNameInTheActivePatinet_Table(driver);
		ot.clickOnOtScenduleScreenLink(driver);
		hp.homeBtnForvims(driver);
		ot.clickOnTheAddBtn(driver);
		ot.enterHospitalNumber(driver, hospitalNumber);
		ot.otScheduleProcess_one(driver, operationTheater, SurgeryType, SurgeryNature, date, SurgeryTime, duration,
				anastesiaType, specialNotes);
		ot.otScheduleProcess_two(driver, department, surgeryDescription, doctorCateory1, consultantName1, diagnosis);
		Thread.sleep(2000);
		ot.enterHospitalNumber_Filter(driver, hospitalNumber);
		ot.clickOnSearchBtn_Filters(driver);
		ot.clickOnHospitalNumber_OtList(driver);
		oct.clickOnSubmitBtn(driver);
		oct.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		oct.clickOnSurgery_Confiramton_List_Tab(driver);
		oct.enterHospitalNumber_Filter(driver, hospitalNumber);
		oct.clickOnSeacrhButton_Filter(driver);
		oct.clickOnHospitalNumberInTheTable(driver);
		System.out.println(hospitalNumber);
		Thread.sleep(2000);
		oct.clickOn_OkButton(driver);
		ot.clickOn_PencilButtonIn_SurgeryDetails(driver);
		ot.deletelineItem_surgeryDetailsPopUP(driver);
		ot.surgeonDetails_InThePopup(driver, doctorCateory1, consultantName1, surgeonAmount);
		ot.surgeonDetails_InThePopup(driver, doctorCateory1, consultantName2, surgeonAmount);
		ot.surgeonDetails_InThePopup(driver, doctorCateory1, consultantName3, surgeonAmount);
		ot.surgeonDetails_InThePopup(driver, doctorCateory1, consultantName4, surgeonAmount);
		String surgeonAmounts = ot.capture_SurgerRates_SurgeryDetails_Tab_InThePopup(driver);
		String additionalChargesWithHours = ot.capture_ServiceName_Amounts_SurgeonDetailsPopup(driver, duration);
		String theaterCharges = ot.capture_TheaterCharges_SurgeryDetailsPopup(driver);
		System.out.println("theater amount" + theaterCharges);
		System.out.println("Additional amount" + additionalChargesWithHours);
		System.out.println("Surgeon amount" + surgeonAmounts);
		ot.clickOnSubmit_SurgeryDetailsPopPU(driver);
		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		ip.clickOn_OtServiceButton_ViewButton(driver);
	}

	@Test
	public void checkThatUserShouldbeSurgeryConfirmationListDetails_WithHelpOfHospitalNumber_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ocp.clickOnClearButton(driver);
		ocp.clickOnSurgery_Confiramton_List_Tab(driver);
		String hospitalNumber = ocp.takeLastRow_HospitalNumber_surgeryConfirmation_List(driver);
		ocp.enterHospitalNumber_Filter(driver, hospitalNumber);
		ocp.clickOnSeacrhButton_Filter(driver);
		String hospitalNumber1 = ocp.takeFirstRow_HospitalNumber_SurgeryConfirmation_List(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("Filtered a surgery confiramtion list details with help of hospital number successfully ");
	}

	@Test
	public void checkThatUserShouldbeSurgeryConfirmationListDetails_WithHelpOfScheduleNumber_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ocp.clickOnClearButton(driver);
		ocp.clickOnSurgery_Confiramton_List_Tab(driver);
		String scheduleNumber = ocp.takeLastRow_ScheduleNumber_SurgeryConfirmation_List(driver);
		ocp.enterScheduleNumber_Filter(driver, scheduleNumber);
		ocp.clickOnSeacrhButton_Filter(driver);
		String scheduleNumber1 = ocp.takeFirstRow_ScheduleNumber_SurgeryConfirmation_List(driver);
		Assert.assertEquals(scheduleNumber1, scheduleNumber);
		System.out.println("Filtered a surgery confiramtion list details with help of schedulel number successfully ");
	}

	@Test
	public void checkThatUserShouldbeSurgeryConfirmationListDetails_WithHelpOfPatientName_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ocp.clickOnClearButton(driver);
		ocp.clickOnSurgery_Confiramton_List_Tab(driver);
		String patientName = ocp.takeLastRow_PatientName_SurgeryConfirmation_List(driver);
		ocp.enterPatientNameText_Filter(driver, patientName);
		ocp.clickOnSeacrhButton_Filter(driver);
		String patientName1 = ocp.takeFirstRow_PatientName_SurgeryConfirmation_List(driver);
		Assert.assertEquals(patientName1, patientName);
		System.out.println("Filtered a surgery confiramtion list details with help of patient name  successfully ");
	}

	@Test
	public void checkThatUserShouldbeSurgeryPendingListDetails_WithHelpOfHospitalNumber_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ocp.clickOnClearButton(driver);
		String hospitalNumber = ocp.takeLastRow_HospitalNumberSurgeryPendingList(driver);
		ocp.enterHospitalNumber_Filter(driver, hospitalNumber);
		ocp.clickOnSeacrhButton_Filter(driver);
		String hospitalNumber1 = ocp.takeFirstRow_HospitalNumber_SurgeryPendingList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("Filtered a surgery pending  list details with help of hospital number successfully ");

	}

	@Test
	public void checkThatUserShouldbeSurgeryPendingListDetails_WithHelpOfscheduleNumber_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);

		ocp.clickOnClearButton(driver);
		String scheduleNumber = ocp.takeLastRow_ScheduleNumber_SurgeryPendingList(driver);
		ocp.enterScheduleNumber_Filter(driver, scheduleNumber);
		ocp.clickOnSeacrhButton_Filter(driver);
		String scheduleNumber1 = ocp.takeFirstRow_ScheduleNumber_SurgeryPendingList(driver);
		Assert.assertEquals(scheduleNumber1, scheduleNumber);
		System.out.println("Filtered a surgery pending  list details with help of schedule number  successfully ");

	}

	@Test
	public void checkThatUserShouldbeSurgeryPendingListDetails_WithHelpOfPatientName_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);

		ocp.clickOnClearButton(driver);
		String patientName = ocp.takeLastRow_PatientName_surgeryPendingList(driver);
		ocp.enterPatientNameText_Filter(driver, patientName);
		ocp.clickOnSeacrhButton_Filter(driver);
		String patientName1 = ocp.takeFirstRow_PatientName_SurgeryPendingList(driver);
		Assert.assertEquals(patientName1, patientName);
		System.out.println("Filtered a surgery pending  list details with help of patient name successfully ");

	}

	@Test
	public void checkThatUserShouldbeSurgeryPendingListDetails_WithHelpOfDepartmentName_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);

		ocp.clickOnClearButton(driver);
		String departmentName = ocp.takeLastRow_DepartmentName_SurgeryPendingList(driver);
		ocp.selectDepartmentName(driver, departmentName);
		ocp.clickOnSeacrhButton_Filter(driver);
		String departmentName1 = ocp.takeFirstRow_DepartmentName_SurgeryPendingList(driver);
		Assert.assertEquals(departmentName1, departmentName);
		System.out.println("Filtered a surgery pending  list details with help of department  name successfully ");

	}

	@Test
	public void checkThatUserShouldbeSurgeryPendingListDetails_WithHelpOfWard_Room_Status_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		SoftAssert sa = new SoftAssert();

		ocp.clickOnClearButton(driver);
		String hospitalNumber = ocp.takeLastRow_HospitalNumberSurgeryPendingList(driver);
		String wardType = ocp.takeLastRow_WardType_SurgeryPendingList(driver);
		String roomType = ocp.takeLastRow_RoomTyoe_SurgeryPendingList(driver);
		String status = ocp.takeLastRow_Status_SurgeryPendingList(driver);

		ocp.enterHospitalNumber_Filter(driver, hospitalNumber);
		ocp.clickOnSeacrhButton_Filter(driver);

		String wardType1 = ocp.takeFirstRow_WardType_SurgeryPendingList(driver);

		sa.assertEquals(wardType1, wardType);
		System.out.println(wardType1 + wardType);

		String roomType1 = ocp.takeFirstRow_RoomType_SurgeryPendingList(driver);
		sa.assertEquals(roomType1, roomType);
		System.out.println(roomType + roomType);

		String status1 = ocp.takeFirstRow_Status_SurgeryPendingList(driver);
		sa.assertEquals(status1, status);
		System.out.println(status1 + status);

		sa.assertAll();
	}

	@Test
	public void checkThatUserShouldbeSurgeryConfirmationListDetails_WithHelpOfWard_Room_Status_Test() throws Throwable {

		otConfirmationPage ocp = new otConfirmationPage(driver);
		HomePage hp = new HomePage(driver);

		ocp.clickOnOtConfirmationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ocp.clickOnSurgery_Confiramton_List_Tab(driver);
		SoftAssert sa = new SoftAssert();

		ocp.clickOnClearButton(driver);
		String hospitalNumber = ocp.takeLastRow_HospitalNumber_surgeryConfirmation_List(driver);
		String wardType = ocp.takeLastRow_WardType_SurgeryConfirmation_List(driver);
		String roomType = ocp.takeLastRow_RoomType_SurgeryConfirmation_List(driver);
		String status = ocp.takeLastRow_Status_SurgeryConfirmation_List(driver);

		ocp.enterHospitalNumber_Filter(driver, hospitalNumber);
		ocp.clickOnSeacrhButton_Filter(driver);

		String wardType1 = ocp.takeFirstRow_WardType_SurgeryConfirmation_List(driver);
		sa.assertEquals(wardType1, wardType);
		System.out.println(wardType1 + wardType);

		String roomType1 = ocp.takeFirstRow_RoomType_surgeryConfirmation_List(driver);
		sa.assertEquals(roomType1, roomType);
		System.out.println(roomType + roomType);

		String status1 = ocp.takeFirstRow_Status_SurgeryConfirmation_List(driver);
		sa.assertEquals(status1, status);
		System.out.println(status1 + status);

		sa.assertAll();
	}

}
