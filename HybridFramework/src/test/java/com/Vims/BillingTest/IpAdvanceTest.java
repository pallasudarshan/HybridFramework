package com.Vims.BillingTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.IpAdvancePage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class IpAdvanceTest extends BaseClass {

	@Test
	public void ipPatientCreate_Test() throws Throwable {
		String name = "IP PATIENT";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = "IP PATIENT";
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "MAYURNATH REDDY";
		String depName = "DENTAL";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String wardType = eutil.getDataFromTheExcel("Bedmaster", 1, 4);
		String advanceAmount = "1000";

		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRAIGE MALE GEN WARD";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRAIGE MALE GEN WARD";
		String admittedByDr = "DR.ABBAS";
		String time = current_Time_Hours_Min();

		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		HomePage hp = new HomePage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);
		System.out.println(bednumberh);
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionWithAdvanceAmount(driver, hospitalNumber, time, depName, doctorname,
				admittedByDr, wardType, roomType, bednumberh, advanceAmount);
	}

	@Test
	public void checkThatUserShouldFilterDetailsWithHelpOfPatientName_Test() throws Throwable {

		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);

		hp.homeBtnForvims(driver);
		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnClearl(driver);
		String patientName = ip.capture_LastRowPatientName_Table(driver);
		ip.enterPatientName(driver, patientName);
		ip.clickOnSearch(driver);
		String patientName1 = ip.takePatientName(driver);
		Assert.assertEquals(patientName1, patientName);

	}

	@Test
	public void checkThatUserShouldFilterDetailsWithHelpOfHospitalNumber_Test() throws Throwable {

		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);

		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnClearl(driver);
		String hospitalNumber = ip.captureLastRowHospitalNumber_Table(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOnSearch(driver);
		String hospitalNumber1 = ip.takeHospitalNumber(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void checkThatUserShouldFilterDetailsWithHelpOfReceiptNumber_Test() throws Throwable {

		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);

		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnClearl(driver);
		String ReceiptNumber = ip.captureLastRowReceiptNumber_Table(driver);
		ip.enterReceiptNumber(driver, ReceiptNumber);
		ip.clickOnSearch(driver);
		String ReceiptNumber1 = ip.takeReceiptNumber(driver);
		Assert.assertEquals(ReceiptNumber1, ReceiptNumber);
	}

	@Test(description = "User should get the error message as  'please enter the hospital number' ")
	public void checkThatClickOnSearchButtonWithpoutEntringTheHospitalNumberInTheF_Test() throws Throwable {
		String msg = "please enter hospital number";
		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);

		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnNewAdvanceButton(driver);
		ip.clickOnSearch(driver);
		String msg1 = ip.captureErrorMessage(driver);
		Assert.assertEquals(msg1, msg);

	}

	@Test(description = "User should get the error popup message")
	public void checkThatUserEnterTheWrongHospitalNumber_Test() throws Throwable {
		String hospitalNumber = "5343452";
		String msg = "Data not found";
		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);

		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnNewAdvanceButton(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOnSearch(driver);
		String msg1 = ip.capturePopupMessage(driver);
		ip.clickOnOkButtonSuccessfullMessage(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test(description = "Its should display a error messsage. ")
	public void checkThatUserEnterTheAlphabetsInHospitalNumberTextAndSearch_Test() throws Throwable {
		String hospitalNumber = "abcde";

		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);

		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnNewAdvanceButton(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOnSearch(driver);
	}

	@Test
	public void checkThatOnceUserGiveTheAdvanceAmountItsShouldbeUpdate_Test() throws Throwable {
		String amount = "20";
		String remarks = "test";
		String paymentMode = "CREDIT";
		String cardType = "MASTER";
		String number = "1234";

		IpAdvancePage ip = new IpAdvancePage(driver);
		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearBtn(driver);
		String hospitalNumber = alp.take_To_Second_HospitalNumber_ActiveList(driver);
		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnNewAdvanceButton(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOnSearch(driver);
		ip.enterAdvanceAmount(driver, amount);
		ip.enterRemarks(driver, remarks);
		ip.selectPaymentMode(driver, paymentMode);
		ip.credit_DebitCardDetails(driver, cardType, number);
		ip.clickOnSubmit_HandleWindow(driver);
		ip.clickOnOkButtonSuccessfullMessage(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOnSearch(driver);
		String Amount = ip.captureTotalAdvanceAmountList(driver);
		alp.clickOnTheAllPatientListButton(driver);
		alp.clickOnClearBtn(driver);
		alp.enterTheHospitalNumber(hospitalNumber);
		alp.clickOnTheSearchButton(driver);
		String Amount1 = alp.takeAdvanceAmountInTheActivePatinet_Table(driver);
		Assert.assertEquals(Amount, Amount1);
	}

	@Test
	public void checkThatUserShouldVerifyThePatientDetailsInTheAdvanceScreen_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);
		IpAdvancePage ip = new IpAdvancePage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String patientName = alp.takeLastRowPatientNameInTheActivePatinet_Table(driver);
		String ipNumber = alp.takeIpNumberInTheActivePatinet_Table(driver);
		String department = alp.takeDepartmentNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String wardtype = alp.takeWardTypeNameInTheActivePatinet_Table(driver);

		ip.clickOnIpAdvance(driver);
		hp.homeBtnForvims(driver);
		ip.clickOnNewAdvanceButton(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOnSearch(driver);

	}

}
