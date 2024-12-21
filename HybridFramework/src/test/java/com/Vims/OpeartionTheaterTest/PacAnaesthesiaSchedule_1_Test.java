package com.Vims.OpeartionTheaterTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PAC_Anaesthesia_SchedulePage;
import com.Dalvkot.Vims_ObjectRepositary.PacAnaesthesiaConfirmationPage;

public class PacAnaesthesiaSchedule_1_Test extends BaseClass {

	@Test(priority = 0)
	public void checkThatUserClickOnTheSubmitButtonWithoutEnterHospitalNumber_Test() throws Throwable {
		String msg1 = "Please Enter Hospital Number";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);

		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.clickOnAppointmentSchedule(driver);
		pas.submit_Schedule(driver);

		String msg = pas.errorMessage_MandatoryField(driver);
		pas.clickCancel_Schedule(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the : " + msg + "  message successsfully");
	}

	@Test(priority = 1)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingScheduleTime_Test() throws Throwable {

		String msg1 = "Please Select Scheduled Time";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnTheAllPatientListButton(driver);
		ap.clickOnClearButton(driver);
		String hospitalNumber = ap.takeTheHospitalNumberInTheActivePatientTable(driver);

		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.clickOnAppointmentSchedule(driver);
		pas.hospitalNumber_ShedulePopup(hospitalNumber);
		pas.submit_Schedule(driver);

		String msg = pas.errorMessage_MandatoryField(driver);
		pas.clickCancel_Schedule(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the : " + msg + "  message successsfully");

	}

	@Test(priority = 3)
	public void checkThatUserClickOnTheSubmitButtonWithoutEnteringSurgeryName_Test() throws Throwable {

		String msg1 = "Please Enter Surgery Name";
		String scheduleTime = "1230AM";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnTheAllPatientListButton(driver);
		ap.clickOnClearButton(driver);
		String hospitalNumber = ap.takeTheHospitalNumberInTheActivePatientTable(driver);

		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.clickOnAppointmentSchedule(driver);
		pas.hospitalNumber_ShedulePopup(hospitalNumber);
		pas.scheduleTimeSchedulePopup(scheduleTime);
		pas.submit_Schedule(driver);

		String msg = pas.errorMessage_MandatoryField(driver);
		pas.clickCancel_Schedule(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the : " + msg + "  message successsfully");

	}

	@Test(priority = 4)
	public void checkThatUserShouldbeCreateThePacAnesthesiaSchedule_Test() throws Throwable {

		String scheduleTime = "1230AM";
		String surgeryName = "Heart transplant";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		hp.homeBtnForvims(driver);
		ap.clickOnTheAllPatientListButton(driver);
		ap.clickOnClearButton(driver);
		String hospitalNumber = ap.takeTheHospitalNumberInTheActivePatientTable(driver);

		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.clickOnAppointmentSchedule(driver);
		pas.hospitalNumber_ShedulePopup(hospitalNumber);
		pas.scheduleTimeSchedulePopup(scheduleTime);
		pas.enterSurgeryNameSchedule(surgeryName);
		pas.submit_Schedule(driver);
		pas.okSuccessMessage(driver);
	}

	@Test(priority = 5)
	public void checkThatUserShouldAbleToRescheduleThePacScheduling_Test() throws Throwable {
		String reasonForReschedule = "TIME ENTERED WRONG";
		String reschedule1 = "Rescheduled";
		String sccheduleTime = "1230AM";
		String surgeryName = "TCholecystectomy.";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.clickOnTheClearBtn(driver);
		String hospitalNumber = pas.takeHospitalNumberTable(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		// Pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.rescheduleProcess(driver, hospitalNumber, reasonForReschedule);

		// Pac schedule page
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		String reschedule = pas.takeStatusTable(driver);
		Assert.assertEquals(reschedule1, reschedule);
		System.out.println("User filtered a rescheduled details  successfully");
	}

	@Test
	public void checkThatUserShouldConfirmTheReschedulePacScheduleAppointment_Test() throws Throwable {
		String reasonForReschedule = "TIME ENTERED WRONG";
		String scheduleTimeInReschedulePopup = "0130AM";
		String surgeryNameForReschedule = "Aneurysm repair";
		String sccheduleTime = "1230AM";
		String surgeryName = "Circumcision";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_LastrRow_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		// Pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.rescheduleProcess(driver, hospitalNumber, reasonForReschedule);

		// Pac schedule page
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.hospitalNumberText(hospitalNumber);

		pas.clickOnSearchButton(driver);
		pas.actions(driver);
		pas.scheduleTime_InTheReschedulePopup(scheduleTimeInReschedulePopup);
		pas.enterSurgeryNameInThe_ReschedulePopup(driver, surgeryNameForReschedule);
		pas.submitButton_Reschedule(driver);
		pas.okSuccessMessage(driver);
		System.out.println("Reschedule confirmation  done successfully  ");
	}

	@Test
	public void checkThatUserShouldOnceRescheduleDoneVerifyRescheduleTimeInTheList_Test() throws Throwable {

		String reasonForReschedule = "TIME ENTERED WRONG";
		String scheduleTimeInReschedulePopup = "0130";
		String surgeryNameForReschedule = "Circumcision";
		String sccheduleTime = "1230AM";
		String surgeryName = "Dental Restoration";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Second_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		// Pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.rescheduleProcess(driver, hospitalNumber, reasonForReschedule);

		// Pac schedule page
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		pas.actions(driver);
		pas.scheduleTime_InTheReschedulePopup(scheduleTimeInReschedulePopup);
		pas.enterSurgeryNameInThe_ReschedulePopup(driver, surgeryNameForReschedule);
		pas.submitButton_Reschedule(driver);
		pas.okSuccessMessage(driver);

		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		String surgeryTime = pas.takeTime_ReqTable(driver);
		Assert.assertEquals(scheduleTimeInReschedulePopup, surgeryTime);
		System.out.println("Changed a surgery time  verified in table successfully");
	}

	@Test
	public void checkThatUserOnceRecsheduleConfirmVerifyTheRescheduleSurgeryNameInTheList_Test() throws Throwable {

		String reasonForReschedule = "TIME ENTERED WRONG";
		String scheduleTimeInReschedulePopup = "0130";
		String surgeryNameForReschedule = "Dental Restoration";
		String scheduleTime = "1230AM";
		String surgeryName = "Hernia Surgery";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Third_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, scheduleTime, surgeryName);

		// Pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.rescheduleProcess(driver, hospitalNumber, reasonForReschedule);

		// Pac schedule page
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		pas.actions(driver);
		pas.scheduleTime_InTheReschedulePopup(scheduleTimeInReschedulePopup);
		pas.enterSurgeryNameInThe_ReschedulePopup(driver, surgeryNameForReschedule);
		pas.submitButton_Reschedule(driver);
		pas.okSuccessMessage(driver);

		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		String surgeryName1 = pas.takeSurgeryName(driver);
		Assert.assertEquals(surgeryNameForReschedule, surgeryName1);
		System.out.println("Changed a surgery name verified in table successfully");
	}

	@Test
	public void checkThatUserFilterPatientDetailsWithHelpOfHospitalNumber_Test() throws Throwable {

		String scheduleTime = "0130AM";
		String surgeryName = "Craniotomy";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Third_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, scheduleTime, surgeryName);

		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		String hospitalNumber1 = pas.takeHospitalNumberTable(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("User got the schedule details with help of hospital number");
	}

	@Test
	public void checkThatUserFilterPatientDetailsWithHelpOfSurgeryType_Test() throws Throwable {
		String scheduleTime = "0130AM";
		String surgeryName = "Hernia Surgery";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Third_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.clickOnAppointmentSchedule(driver);
		pas.hospitalNumber_ShedulePopup(hospitalNumber);
		pas.scheduleTimeSchedulePopup(scheduleTime);
		pas.enterSurgeryNameSchedule(surgeryName);
		pas.selectMinorSurgeryType_ScheduleAppointment(driver);
		pas.submit_Schedule(driver);
		pas.okSuccessMessage(driver);

		pas.selectSurgeryType_As_Minor_Filter(driver);
		pas.clickOnSearchButton(driver);
		pas.firstRow_TableList(driver, "MINOR");
	}

	@Test
	public void checkThatUserFilteredRescheduledScheduleDetailsWithHelpOfStatusDropdown_Test() throws Throwable {
		String reasonForReschedule = "TIME ENTERED WRONG";
		String reschedule1 = "Rescheduled";
		String sccheduleTime = "1230AM";
		String surgeryName = "Spinal Surgery";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Second_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		// Pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.rescheduleProcess(driver, hospitalNumber, reasonForReschedule);

		// Pac schedule page
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.selectStatusDropdown(driver, reschedule1);
		pas.clickOnSearchButton(driver);

		// Verify
		pas.firstRow_TableList(driver, reschedule1);

	}

	@Test
	public void checkThatUserShouldAbleToCancelThePacSchedule_Test() throws Throwable {

		String reason = "Wrong time did schedule";
		String sccheduleTime = "0450AM";
		String surgeryName = "Breast Biopsy";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Four_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		// pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.scheduleCancelProcess(driver, hospitalNumber, reason);
	}

	@Test
	public void checkThatUserFilteredCancelled_ScheduleDetailsWithHelpOfStatusDropdown_Test() throws Throwable {
		String reason = "Wrong time did schedule";
		String sccheduleTime = "0450AM";
		String surgeryName = "Breast Biopsy";
		String status = "Cancelled";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage psc = new PacAnaesthesiaConfirmationPage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Four_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		// pac confirmation
		hp.homeBtnForvims(driver);
		psc.clickOnPacAnasthesiaConfirmation(driver);
		psc.scheduleCancelProcess(driver, hospitalNumber, reason);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.selectStatusDropdown(driver, status);
		pas.clickOnSearchButton(driver);

		// Verify
		pas.firstRow_TableList(driver, status);
	}

	@Test
	public void checkThatUserFilteredPending_ScheduleDetailsWithHelpOfStatusDropdown_Test() throws Throwable {
		String sccheduleTime = "0450AM";
		String surgeryName = "Breast Biopsy";
		String status = "PENDING";

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);

		// All patient list
		hp.homeBtnForvims(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.take_To_Four_HospitalNumber_ActiveList(driver);

		// Pac scheduling
		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, sccheduleTime, surgeryName);

		pas.selectStatusDropdown(driver, status);
		pas.clickOnSearchButton(driver);

		// Verify
		pas.allRows_TableList(driver, status);
	}

	/*
	 * @Test(priority = 6) public void
	 * checkThatUserShouldVerifyThePacConfirmationDetailsInTheDoctorDeskIpd_Test()
	 * throws Throwable { String asaClass = "II"; String text = "asAS123,*. >pl";
	 * String language = "URDU"; String electiveEmergency = "ELECTIVE"; String
	 * history =
	 * "This is the first admission for this 56 yeod health until establish a chronology.\r\none week prior to admission. At that time she noticed the\r\n"
	 * ; String remarks = "Test"; String preAnesthesiaOrders = "TEST";
	 * 
	 * HomePage hp = new HomePage(driver); PAC_Anaesthesia_SchedulePage pas = new
	 * PAC_Anaesthesia_SchedulePage(driver); PacAnaesthesiaConfirmationPage psc =
	 * new PacAnaesthesiaConfirmationPage(driver);
	 * 
	 * hp.homeBtnForvims(driver); psc.clickOnPacAnasthesiaConfirmation(driver);
	 * String hospitalNumber = psc.takeHospitalNumber_ReqTable();
	 * psc.actionBtn_ReqTable(driver); psc.confirmationActionBtn_ReqTable(driver);
	 * psc.vitalSign(driver, asaClass, text, language, electiveEmergency);
	 * psc.enterTextInHistoryOfPresentIllness(driver, history);
	 * psc.clickOnNextButton(driver); psc.enterRemarks(remarks);
	 * psc.preAnesthesiaOrders(driver, preAnesthesiaOrders);
	 * psc.clickOnFitnessReviewButton(driver); psc.clickOnOkSuccessMessage(driver);
	 * 
	 * }
	 * 
	 * @Test(priority = 1) public void IpPatientTest() throws Throwable { String
	 * name = "IP PATIENT"; String year = eutil.getDataFromTheExcel("Opdreg1", 2,
	 * 5); String fname = "IP PATIENT"; String mobilenum =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 7); String mail =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 8); String address =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 9); String pincode =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 10); String doctorname = "VIJAY";
	 * String depName = "CARDIOLOGY"; String postOffice =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 14); String wardType =
	 * eutil.getDataFromTheExcel("Bedmaster", 1, 4);
	 * 
	 * String bedCategory = "NON TEACHING"; String bedWardType = "GENERAL WARD";
	 * String bedRoomType = "C19 TRAIGE MALE GEN WARD"; String floor = "4TH FLOOR";
	 * String wings = "EAST WING"; String bedUnitDepartment = "1"; String roomType =
	 * "C19 TRAIGE MALE GEN WARD"; String admittedByDr = "DR.ABBAS"; String time =
	 * eutil.getDataFromTheExcel("Otsche", 1, 3);
	 * 
	 * HomePage hp = new HomePage(driver); hp.homeBtnForvims(driver);
	 * OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
	 * opdregistrationpage.opdRegistrationButton(driver);
	 * opdregistrationpage.OpdRegistartionForVims(driver, name, year, fname,
	 * mobilenum, mail, address, pincode, postOffice, depName, doctorname);
	 * opdregistrationpage.submitAnd_ViewBtn(driver);
	 * System.out.println("Opd registration successfully");
	 * 
	 * String hospitalNumber =
	 * opdregistrationpage.hospitalNumberInTheTableForVims(driver); BedMasterPage bp
	 * = new BedMasterPage(driver); String bednumberh = bp.bedMasterForVims(driver,
	 * bedCategory, bedWardType, bedRoomType, floor, wings, depName,
	 * bedUnitDepartment); System.out.println(bednumberh); // patientAdmission
	 * PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
	 * patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
	 * patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time,
	 * depName, doctorname, admittedByDr, wardType, roomType, bednumberh); }
	 */

	@Test
	public void checkThatUserShouldbeFilterTheReviewDetailsWithHelpOfHospitalNumber_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pac = new PAC_Anaesthesia_SchedulePage(driver);

		pac.clickOnPacScheduling(driver);
		hp.homeBtnForvims(driver);

		pac.clickOn_Review_Button(driver);

		String hospitalNumber = pac.takeLastRow_HospitalNumber_ReviewList(driver);
		pac.hospitalNumberText(hospitalNumber);
		pac.clickOnSearchButton(driver);
		String hospitalNumber1 = pac.takeFirstRow_HospitalNumber_ReviewList(driver);

		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Filtered a hospital number successfull");
	}

	@Test
	public void checkThatUserShouldbeFilterTheReviewDetailsWithHelpOfSurgeryType_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pac = new PAC_Anaesthesia_SchedulePage(driver);

		pac.clickOnPacScheduling(driver);
		hp.homeBtnForvims(driver);

		pac.clickOn_Review_Button(driver);

		String surgeryType = pac.takeLastRow_SurgeryType_ReviewList(driver);
		pac.selectSurgeryType_Filter(driver, surgeryType);
		pac.clickOnSearchButton(driver);
		String surgeryType1 = pac.takeFirstRow_SurgeryType_ReviewList(driver);

		Assert.assertEquals(surgeryType1, surgeryType);
		System.out.println("Filtered a surgeryType  successfull");
	}

	@Test
	public void checkThatUserShouldbeFilterTheReviewDetailsWithHelpOfSurgeryDate_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pac = new PAC_Anaesthesia_SchedulePage(driver);

		pac.clickOnPacScheduling(driver);
		hp.homeBtnForvims(driver);

		pac.clickOn_Review_Button(driver);

		String surgeryType = pac.takeLastRow_SurgeryType_ReviewList(driver);
		pac.selectSurgeryType_Filter(driver, surgeryType);
		pac.clickOnSearchButton(driver);
		String surgeryType1 = pac.takeFirstRow_SurgeryType_ReviewList(driver);

		Assert.assertEquals(surgeryType1, surgeryType);
		System.out.println("Filtered a surgeryType  successfull");
	}

	@Test
	public void checkThatUserFilerThePacScheduleDetailsInTheRequestersListWithHelpOf_HospitalNumber_Test()
			throws Throwable {

		String status = "PENDING";

		PAC_Anaesthesia_SchedulePage pac_Anaesthesia_SchedulePage = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pacAnaesthesiaConfirmationPage = new PacAnaesthesiaConfirmationPage(driver);
		HomePage homePage = new HomePage(driver);

		pac_Anaesthesia_SchedulePage.clickOnPacScheduling(driver);
		homePage.homeBtnForvims(driver);
		pac_Anaesthesia_SchedulePage.clickOnTheClearBtn(driver);
		pac_Anaesthesia_SchedulePage.selectStatusDropdown(driver, status);
		pac_Anaesthesia_SchedulePage.clickOnSearchButton(driver);
		String hospitalNumber = pac_Anaesthesia_SchedulePage.takeHospitalNumberTable(driver);

		pacAnaesthesiaConfirmationPage.clickOnPacAnasthesiaConfirmation(driver);
		homePage.homeBtnForvims(driver);
		pacAnaesthesiaConfirmationPage.clickOnClear(driver);
		pacAnaesthesiaConfirmationPage.hospitalNumber(status);
		pacAnaesthesiaConfirmationPage.clickOnSearch(driver);
		String hospitalNumber1 = pacAnaesthesiaConfirmationPage.takeHospitalNumber_ReqTable(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserFilerThePacScheduleDetailsInTheRequestersListWithHelpOf_IpNumber_Test() throws Throwable {
		String status = "PENDING";

		PAC_Anaesthesia_SchedulePage pac_Anaesthesia_SchedulePage = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pacAnaesthesiaConfirmationPage = new PacAnaesthesiaConfirmationPage(driver);
		HomePage homePage = new HomePage(driver);

		pac_Anaesthesia_SchedulePage.clickOnPacScheduling(driver);
		homePage.homeBtnForvims(driver);
		pac_Anaesthesia_SchedulePage.clickOnTheClearBtn(driver);
		pac_Anaesthesia_SchedulePage.selectStatusDropdown(driver, status);
		pac_Anaesthesia_SchedulePage.clickOnSearchButton(driver);
		String op_IpNumber = pac_Anaesthesia_SchedulePage.capture_OpIpNumber_RequestersTable(driver);

		pacAnaesthesiaConfirmationPage.clickOnPacAnasthesiaConfirmation(driver);
		homePage.homeBtnForvims(driver);
		pacAnaesthesiaConfirmationPage.clickOnClear(driver);
		pacAnaesthesiaConfirmationPage.enter_IpNumber_Filter(driver, op_IpNumber);
		pacAnaesthesiaConfirmationPage.clickOnSearch(driver);
		String op_IpNumber1 = pacAnaesthesiaConfirmationPage.takeIpNumber_RequTable(driver);
		Assert.assertEquals(op_IpNumber1, op_IpNumber);
	}

	@Test
	public void checkThatUserFilerThePacScheduleDetailsInTheRequestersListWithHelpOf_DepartmentName_Test()
			throws Throwable {

		PAC_Anaesthesia_SchedulePage pac_Anaesthesia_SchedulePage = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pacAnaesthesiaConfirmationPage = new PacAnaesthesiaConfirmationPage(driver);
		HomePage homePage = new HomePage(driver);

		pac_Anaesthesia_SchedulePage.clickOnPacScheduling(driver);
		homePage.homeBtnForvims(driver);
		pac_Anaesthesia_SchedulePage.clickOnTheClearBtn(driver);
		String department = pac_Anaesthesia_SchedulePage.capture_DepartmentName_RequestersTable(driver);

		pacAnaesthesiaConfirmationPage.clickOnPacAnasthesiaConfirmation(driver);
		homePage.homeBtnForvims(driver);
		pacAnaesthesiaConfirmationPage.clickOnClear(driver);
		pacAnaesthesiaConfirmationPage.select_DepartmentName_Filter(driver, department);
		pacAnaesthesiaConfirmationPage.clickOnSearch(driver);
		String department1 = pacAnaesthesiaConfirmationPage.takeDepartmentName_ReqTable(driver);
		Assert.assertEquals(department1, department);

	}

	@Test
	public void checkThatUserFilerThePacScheduleDetailsInTheReviewListWithHelpOf_HospitalNumber_Test()
			throws Throwable {
		PAC_Anaesthesia_SchedulePage pac_Anaesthesia_SchedulePage = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pacAnaesthesiaConfirmationPage = new PacAnaesthesiaConfirmationPage(driver);
		HomePage homePage = new HomePage(driver);

		pac_Anaesthesia_SchedulePage.clickOnPacScheduling(driver);
		homePage.homeBtnForvims(driver);
		pac_Anaesthesia_SchedulePage.clickOn_Review_Button(driver);
		pac_Anaesthesia_SchedulePage.clickOnTheClearBtn(driver);
		String hospitalNumber = pac_Anaesthesia_SchedulePage.takeFirstRow_HospitalNumber_ReviewList(driver);

		pacAnaesthesiaConfirmationPage.clickOnPacAnasthesiaConfirmation(driver);
		homePage.homeBtnForvims(driver);
		pacAnaesthesiaConfirmationPage.clickOnReviewListTab(driver);
		pacAnaesthesiaConfirmationPage.clickOnClear(driver);
		pacAnaesthesiaConfirmationPage.hospitalNumber(hospitalNumber);
		pacAnaesthesiaConfirmationPage.clickOnSearch(driver);
		String hospitalNumber1 = pacAnaesthesiaConfirmationPage.takeHospitalNumber_ReviewTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserFilerThePacScheduleDetailsInTheReviewListWithHelpOf_IpNumber_Test() throws Throwable {

		PAC_Anaesthesia_SchedulePage pac_Anaesthesia_SchedulePage = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pacAnaesthesiaConfirmationPage = new PacAnaesthesiaConfirmationPage(driver);
		HomePage homePage = new HomePage(driver);

		pac_Anaesthesia_SchedulePage.clickOnPacScheduling(driver);
		homePage.homeBtnForvims(driver);
		pac_Anaesthesia_SchedulePage.clickOn_Review_Button(driver);
		pac_Anaesthesia_SchedulePage.clickOnTheClearBtn(driver);
		String op_IpNumber = pac_Anaesthesia_SchedulePage.capture_OpIpNumber_FitnessReviewTable(driver);

		pacAnaesthesiaConfirmationPage.clickOnPacAnasthesiaConfirmation(driver);
		homePage.homeBtnForvims(driver);
		pacAnaesthesiaConfirmationPage.clickOnReviewListTab(driver);
		pacAnaesthesiaConfirmationPage.clickOnClear(driver);
		pacAnaesthesiaConfirmationPage.enter_IpNumber_Filter(driver, op_IpNumber);
		pacAnaesthesiaConfirmationPage.clickOnSearch(driver);
		String op_IpNumber1 = pacAnaesthesiaConfirmationPage.takeIpNumber_ReviewTable(driver);
		Assert.assertEquals(op_IpNumber1, op_IpNumber);

	}

	@Test
	public void checkThatUserFilerThePacScheduleDetailsInTheReviewListWithHelpOf_DepartmentName_Test()
			throws Throwable {
		PAC_Anaesthesia_SchedulePage pac_Anaesthesia_SchedulePage = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pacAnaesthesiaConfirmationPage = new PacAnaesthesiaConfirmationPage(driver);
		HomePage homePage = new HomePage(driver);

		pac_Anaesthesia_SchedulePage.clickOnPacScheduling(driver);
		homePage.homeBtnForvims(driver);
		pac_Anaesthesia_SchedulePage.clickOn_Review_Button(driver);
		pac_Anaesthesia_SchedulePage.clickOnTheClearBtn(driver);
		String department = pac_Anaesthesia_SchedulePage.capture_DepartmentName_FitnessReviewTable(driver);

		pacAnaesthesiaConfirmationPage.clickOnPacAnasthesiaConfirmation(driver);
		homePage.homeBtnForvims(driver);
		pacAnaesthesiaConfirmationPage.clickOnReviewListTab(driver);
		pacAnaesthesiaConfirmationPage.clickOnClear(driver);
		pacAnaesthesiaConfirmationPage.select_DepartmentName_Filter(driver, department);
		pacAnaesthesiaConfirmationPage.clickOnSearch(driver);
		String department1 = pacAnaesthesiaConfirmationPage.capture_DepartmentName_FitnessReviewList(driver);
		Assert.assertEquals(department1, department);
	}

	@Test(priority = 4)
	public void pacScheduleFor_OP_PatientTest() throws Throwable {

		String doctorname = "RAMA MISHRA";
		String depName = "GENERAL MEDICINE";
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String scheduleTime = "1230AM";
		String surgeryName = "Hemorrhoidectomy";

		HomePage hp = new HomePage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println("Hospital Number - OP : " + hospitalNumber);

		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.pacScheduleFor_Op(driver, hospitalNumber, depName, scheduleTime, surgeryName);
	}

}
