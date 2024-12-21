package com.Vims.OpeartionTheaterTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PAC_Anaesthesia_SchedulePage;
import com.Dalvkot.Vims_ObjectRepositary.PacAnaesthesiaConfirmationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;

public class PacAnesthesiaConfirmation_Test extends BaseClass {

	@Test
	public void toVerifyThatUserShouldConfirThePacScheduling_Test() throws Throwable {
		String doctorname = futil.getProperyKeyValue("doctornameNeurology");
		String depName = futil.getProperyKeyValue("depNameNeurology");
		String wardType = "Day Care";
		String bedCategory = "NON TEACHING";
		String bedWardType = "DAY CARE";
		String bedRoomType = "DAY CARE";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String roomType = "DAY CARE";
		String admittedByDr = "DR.ABBAS";
		String time = current_Time_Hours_Min();
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String scheduleTime = "1230";
		String surgeryName = "Heart transplant";
		String asaClass = "I";
		String text = "121/212";
		String language = "urdu";
		String electiveEmergency = "ELECTIVE";
		String disease = "Allergies and allergic disorders are among the most com";
		String medication = "Allergies and allergic disorders are among the most com";
		String history = "test test ";
		String remarks = "Remarks entered successfully";
		String preAnesthesiaOrders = "first pre anesthesia orders in the text area";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pac = new PacAnaesthesiaConfirmationPage(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterFor_WithoutDepartment_And_Unit(driver, bedCategory, bedWardType, bedRoomType,
				floor, wings);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);

		hp.homeBtnForvims(driver);
		pas.clickOnPacScheduling(driver);
		pas.scheduleAppointment_For_Ip(driver, hospitalNumber, scheduleTime, surgeryName);

		// pac confirmation
		hp.homeBtnForvims(driver);
		pac.clickOnPacAnasthesiaConfirmation(driver);
		pac.actionBtn_ReqTable(driver);
		pac.confirmationActionBtn_ReqTable(driver);
		pac.vitalSign(driver, asaClass, text, language, electiveEmergency);
		pac.pastMedicalHisstory(driver, disease, medication);
		pac.enterTextInHistoryOfPresentIllness(driver, history);
		pac.clickOnNextButton(driver);
		pac.enterRemarks(remarks);
		pac.preAnesthesiaOrders(driver, preAnesthesiaOrders);
		Thread.sleep(2000);
		pac.clickOnFitnessReviewButton(driver);
		Thread.sleep(2000);
		pac.clickOnOkSuccessMessage(driver);
	}

	@Test
	public void checkThatOnceSendForFitnessReview_DetailsShouldReflect_InReviewList_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String surgeryName = "Heart transplant";
		String asaClass = "I";
		String text = "121/212";
		String language = "urdu";
		String electiveEmergency = "ELECTIVE";
		String disease = "Allergies and allergic disorders are among the most com";
		String medication = "Allergies and allergic disorders are among the most com";
		String history = "test test ";
		String remarks = "Remarks entered successfully";
		String preAnesthesiaOrders = "first pre anesthesia orders in the text area";
		String scheduleTime = "1230";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pac = new PacAnaesthesiaConfirmationPage(driver);

		// ----OPD registration---------
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		pas.clickOnPacScheduling(driver);
		hp.homeBtnForvims(driver);
		pas.pacScheduleFor_Op(driver, hospitalNumber, depName, scheduleTime, surgeryName);
		// pac confirmation
		pac.clickOnPacAnasthesiaConfirmation(driver);
		pac.actionBtn_ReqTable(driver);
		pac.confirmationActionBtn_ReqTable(driver);
		pac.vitalSign(driver, asaClass, text, language, electiveEmergency);
		pac.pastMedicalHisstory(driver, disease, medication);
		pac.enterTextInHistoryOfPresentIllness(driver, history);
		pac.clickOnNextButton(driver);
		pac.enterRemarks(remarks);
		pac.preAnesthesiaOrders(driver, preAnesthesiaOrders);
		Thread.sleep(2000);
		pac.clickOnFitnessReviewButton(driver);
		Thread.sleep(2000);
		pac.clickOnOkSuccessMessage(driver);
		pac.clickOnReviewListTab(driver);
		pac.hospitalNumber(hospitalNumber);
		pac.clickOnSearch(driver);
		String hospitalNumber1 = pac.takeHospitalNumber_ReviewTable(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Hospital number verified in the review list after the done fiteness review ");

	}

	@Test
	public void checkThatOnceSendForFitnessReview_DetailsShouldReflect_InPacScheduleReviewList_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String surgeryName = "Heart transplant";
		String asaClass = "I";
		String text = "121/212";
		String language = "urdu";
		String electiveEmergency = "ELECTIVE";
		String disease = "Allergies and allergic disorders are among the most com";
		String medication = "Allergies and allergic disorders are among the most com";
		String history = "test test ";
		String remarks = "Remarks entered successfully";
		String preAnesthesiaOrders = "first pre anesthesia orders in the text area";
		String scheduleTime = "1230";

		HomePage hp = new HomePage(driver);
		PAC_Anaesthesia_SchedulePage pas = new PAC_Anaesthesia_SchedulePage(driver);
		PacAnaesthesiaConfirmationPage pac = new PacAnaesthesiaConfirmationPage(driver);

		// ----OPD registration---------
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		pas.clickOnPacScheduling(driver);
		hp.homeBtnForvims(driver);
		pas.pacScheduleFor_Op(driver, hospitalNumber, depName, scheduleTime, surgeryName);
		// pac confirmation
		pac.clickOnPacAnasthesiaConfirmation(driver);
		pac.actionBtn_ReqTable(driver);
		pac.confirmationActionBtn_ReqTable(driver);
		pac.vitalSign(driver, asaClass, text, language, electiveEmergency);
		pac.pastMedicalHisstory(driver, disease, medication);
		pac.enterTextInHistoryOfPresentIllness(driver, history);
		pac.clickOnNextButton(driver);
		pac.enterRemarks(remarks);
		pac.preAnesthesiaOrders(driver, preAnesthesiaOrders);
		Thread.sleep(2000);
		pac.clickOnFitnessReviewButton(driver);
		Thread.sleep(2000);
		pac.clickOnOkSuccessMessage(driver);
		pas.clickOnPacScheduling(driver);
		hp.homeBtnForvims(driver);
		pas.clickOn_Review_Button(driver);
		pas.hospitalNumberText(hospitalNumber);
		pas.clickOnSearchButton(driver);
		String hospitalNumber1 = pas.takeFirstRow_HospitalNumber_ReviewList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Hospital number verified in the pac schedule review list after the done fiteness review ");
	}

}
