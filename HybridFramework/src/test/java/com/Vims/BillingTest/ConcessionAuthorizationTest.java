package com.Vims.BillingTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.Concession_Refund_AuthorizationPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class ConcessionAuthorizationTest extends BaseClass {

	@Test
	public void verifyThatSameServicesAreReflectingInConcessionScreen_Test() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason = "TEST AUTOMATION";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String serviceName = hospital_Service_Bill_page.pendingProcessForCapturingServiceName(driver, hospitalNumber,
				concessionOn, authorization, sn1, amount, reason);
		hospital_Service_Bill_page.clickOnSendApproval(driver, reason);
		System.out.println(serviceName);

		// ----- concessoin screen -----
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String servicename1 = concession_Refund_AuthorizationPage.verifyServiceNamesInConcessionList(driver);
		System.out.println(servicename1);
		Assert.assertEquals(serviceName, servicename1);
		System.out.println("successfully service name is verified");
	}

	@Test
	public void verifyHodApprovalInConcesstionAuthorization_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String status1 = "PENDING FROM HOD Approval";
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing HOD approval";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);

		String status = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		Assert.assertEquals(status, status1);
		System.out.println("successfully hod approval is verified");
	}

	@Test
	public void verifyAOApprovalInConcesstionAuthorization_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing AO approval";
		String status1 = "PENDING FROM AO APPROVAL";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String status = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		Assert.assertEquals(status, status1);
		System.out.println("successfully AO approval is verified");
	}

	@Test
	public void verifyCfoApprovalInConcesstionAuthorization_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing AO approval";
		String status1 = "PENDING FROM Cfo Approval";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String status = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		Assert.assertEquals(status, status1);
		System.out.println("successfully CFO approval is verified");
	}

	@Test
	public void verifyHospitalNumberIsReflectingInConfirmedListAfterAuthorizationIsConfirmed_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing AO approval";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.allAuthorizationProcess(driver, hospitalNumber, authorizationStatus,
				reason1);
		concession_Refund_AuthorizationPage.clickOnConfirmedList(driver);
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String hospitalNumber1 = concession_Refund_AuthorizationPage
				.captureHospitalNumberInConfirmedConcessionList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Successfully hospital number is reflecting in confirmed list");
	}

	@Test
	public void verifyNextButtonIsWorkingAsExpectedInConcessionListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		hp.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.clickOnConcessionList(driver);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.verifyNextBtnIsWorkingAsExpectedInConcessionList(driver);
	}

	@Test
	public void verifyPrevoiusButtonIsWorkingAsExpectedInConcessionListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		hp.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.clickOnConcessionList(driver);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.verifyPreviousBtnIsWorkingAsExpectedInConcessionList(driver);
	}

	@Test
	public void verifyNextButtonIsWorkingAsExpectedInConfirmedListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		hp.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.clickOnConfirmedList(driver);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.verifyNextBtnIsWorkingAsExpectedInConfirmedList(driver);
	}

	@Test
	public void verifyPrevoiusButtonIsWorkingAsExpectedInConfirmedListPagination_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		Concession_Refund_AuthorizationPage ca = new Concession_Refund_AuthorizationPage(driver);
		hp.homeBtnForvims(driver);
		ca.concessionAuthorizationScreen(driver);
		ca.clickOnConfirmedList(driver);
		ca.clickOnClearBtn(driver);
		ca.verifyPreviousBtnIsWorkingAsExpectedInConFirmedList(driver);
	}

	@Test
	public void verifyAllAuthorizationStatusForHod_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "PENDING";
		String reason1 = "testing All Approval";
		String authorizationStatus1 = "HOLD";
		String authorizationStatus2 = "CANCELLED";
		String authorizationStatus3 = "RESCHEDULED";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		SoftAssert sa = new SoftAssert();

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		hp.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);

		// --------pending-------------
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String pendingStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(pendingStatus, "PENDING FROM HOD Approval");

		// ---------Hold---------------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus1,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String holdStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(holdStatus, "HOLD FROM HOD Approval");

		// ----------cancelled----------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus2,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String cancelledStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(cancelledStatus, "Cancelled FROM HOD Approval");

		// -----------Rescheduled--------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus3,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String rescheduledStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(rescheduledStatus, "Rescheduled FROM HOD Approval");
		sa.assertAll();
	}

	@Test
	public void verifyAllAuthorizationStatusForAO_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing HOD approval";
		String authorizationStatus4 = "PENDING";
		String reason4 = "testing All Approval";
		String authorizationStatus1 = "HOLD";
		String authorizationStatus2 = "CANCELLED";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason1);

		SoftAssert sa = new SoftAssert();

		// --------pending-------------
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus4,
				reason4);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String pendingStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(pendingStatus, "PENDING FROM AO APPROVAL");

		// ---------Hold---------------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus1,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String holdStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(holdStatus, "HOLD FROM AO APPROVAL");

		// ----------cancelled----------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus2,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String cancelledStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(cancelledStatus, "Cancelled FROM AO APPROVAL");

		// -----------Rescheduled--------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		String authorizationStatus3 = "RESCHEDULED";
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus3,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String rescheduledStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(rescheduledStatus, "Rescheduled FROM AO APPROVAL");
		sa.assertAll();
	}

	@Test
	public void verifyAllAuthorizationStatusForCFO_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing AO approval";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);

		// ----- concessoin screen -------
		hp.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		int i = 0;
		while (i < 2) {
			concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
			concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
			concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
			concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver,
					authorizationStatus, reason1);
			i++;
		}
		SoftAssert sa = new SoftAssert();

		// --------pending-------------
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		String authorizationStatus4 = "PENDING";
		String reason4 = "testing All Approval";
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus4,
				reason4);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String pendingStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(pendingStatus, "PENDING FROM Cfo Approval");

		// ---------Hold---------------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		String authorizationStatus1 = "HOLD";
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus1,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String holdStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(holdStatus, "HOLD FROM Cfo Approval");

		// ----------cancelled----------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		String authorizationStatus2 = "CANCELLED";
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus2,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String cancelledStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(cancelledStatus, "Cancelled FROM Cfo Approval");

		// -----------Rescheduled--------
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		String authorizationStatus3 = "RESCHEDULED";
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus3,
				reason1);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String rescheduledStatus = concession_Refund_AuthorizationPage.captureConcessionStatusInConcessionList(driver);
		sa.assertEquals(rescheduledStatus, "Rescheduled FROM Cfo Approval");
		sa.assertAll();
	}

	@Test
	public void verifyReasonErrorMsgInConcessionAuthorizationScreen_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		String selectAuthorizationStatus = "CONFIRMED";

		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		concession_Refund_AuthorizationPage.clickOnClearBtn(driver);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.selectAuthorizationStatus(driver, selectAuthorizationStatus);
		String errorMsg = concession_Refund_AuthorizationPage.verifyReasonErrorPopUPMsg(driver);
		Assert.assertEquals(errorMsg, "Please Enter Reason");
		System.out.println("successfully reason error msg in verified");
	}

	@Test
	public void verifyOnBillConcessionFlow_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "100";
		String reason2 = "TEST AUTOMATION";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);
		// ------ concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing AO approval";
		concession_Refund_AuthorizationPage.allAuthorizationProcess(driver, hospitalNumber, authorizationStatus,
				reason1);
		// -------------OP billing---------------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnPendingListTab(driver);
		hospital_Service_Bill_page.EnterHospitalNumberAndSearchInPendingList(driver, hospitalNumber);
		hospital_Service_Bill_page.clickOnBillNumberInPendingList(driver);
		hospital_Service_Bill_page.clickOnSubmit(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.EnterHospitalNumberAndSearchInPendingList(driver, hospitalNumber);
		String hospitalNumber1 = hospital_Service_Bill_page.verifyHospitalNumberInCompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully hospital number is verified in completed list");
	}

	@Test
	public void verifyOnServiceConcessionFlow_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON SERVICE";
		String authorization = "CFO";
		String percentage = "40";
		String reason2 = "TEST AUTOMATION";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		homePage.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcessForOnServiceConcession(driver, hospitalNumber, concessionOn,
				authorization, sn1, percentage, reason2);
		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		String authorizationStatus = "CONFIRMED";
		String reason1 = "testing AO approval";
		concession_Refund_AuthorizationPage.allAuthorizationProcess(driver, hospitalNumber, authorizationStatus,
				reason1);
		// -------------OP billing---------------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnPendingListTab(driver);
		hospital_Service_Bill_page.EnterHospitalNumberAndSearchInPendingList(driver, hospitalNumber);
		hospital_Service_Bill_page.clickOnBillNumberInPendingList(driver);
		hospital_Service_Bill_page.clickOnSubmit(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.EnterHospitalNumberAndSearchInPendingList(driver, hospitalNumber);
		String hospitalNumber1 = hospital_Service_Bill_page.verifyHospitalNumberInCompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully hospital number is verified in completed list");
	}

	@Test
	public void verifyEditConcessionAmountForAllAuthorizationLevels_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "LIPID PROFILEPANEL";
		String concessionOn = "ON BILL";
		String authorization = "CFO";
		String amount = "98";
		String reason2 = "TEST AUTOMATION";
		String authorizationStatus = "CONFIRMED";
		String reason = "testing edit concession";
		String conAmount = "100";
		String conAmount1 = "250";
		String conAmount2 = "300";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		SoftAssert softAssert = new SoftAssert();

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason2);
		// ----- concessoin screen -------
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		// --------------hod-----------------
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String ca1 = concession_Refund_AuthorizationPage.verifyEditConcessionAmount(driver, conAmount);
		System.out.println(ca1);
		softAssert.assertEquals(ca1, conAmount);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		// --------------AO--------------------
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String ca2 = concession_Refund_AuthorizationPage.verifyEditConcessionAmount(driver, conAmount1);
		System.out.println(ca2);
		softAssert.assertEquals(ca2, conAmount1);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInConcessionList(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		// --------------CFO-------------------
		concession_Refund_AuthorizationPage.clearHospitalNumberTextField(driver);
		concession_Refund_AuthorizationPage.searchHopsitalNumber(driver, hospitalNumber);
		String ca3 = concession_Refund_AuthorizationPage.verifyEditConcessionAmount(driver, conAmount2);
		System.out.println(ca3);
		softAssert.assertEquals(ca3, conAmount2);
		System.out.println("successfully edit concession is verified");
		softAssert.assertAll();
	}

	@Test(groups = { "Smoke Test" })
	public void ToCheckUserShouldFilterTheDetailsWithHelpOfHospitalNumber_ConcessionList_Test() throws Throwable {
		String sn1 = eutil.getDataFromTheExcel("ConcessionAuth", 1, 1);
		String amount = eutil.getDataFromTheExcel("ConcessionAuth", 1, 2);
		String reason = eutil.getDataFromTheExcel("ConcessionAuth", 1, 3);
		String concessionOn = eutil.getDataFromTheExcel("ConcessionAuth", 1, 4);
		String authorization = eutil.getDataFromTheExcel("ConcessionAuth", 1, 5);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage cr = new Concession_Refund_AuthorizationPage(driver);

		// OP BILLING
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		String hospitalNumber = hs.concessionAuthorizationProcess(driver, concessionOn, authorization, sn1, amount,
				reason);

		// Concession authorization
		hp.homeBtnForvims(driver);
		cr.concessionAuthorizationScreen(driver);
		cr.enterHospitalNumber(driver, hospitalNumber);
		cr.clickOnSearchBtn(driver);
		String hospitalNumber1 = cr.takeHospitalNumber_ConcessionList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Hospital number filtered successfully");

	}

	@Test(groups = { "Smoke Test" })
	public void ToCheckUserShouldFilterTheDetailsWithHelpOfBillNumber_ConcessionList_Test() throws Throwable {
		String sn1 = eutil.getDataFromTheExcel("ConcessionAuth", 1, 1);
		String amount = eutil.getDataFromTheExcel("ConcessionAuth", 1, 2);
		String reason = eutil.getDataFromTheExcel("ConcessionAuth", 1, 3);
		String concessionOn = eutil.getDataFromTheExcel("ConcessionAuth", 1, 4);
		String authorization = eutil.getDataFromTheExcel("ConcessionAuth", 1, 5);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage cr = new Concession_Refund_AuthorizationPage(driver);

		// OP BILLING
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		String hospitalNumber = hs.concessionAuthorizationProcess(driver, concessionOn, authorization, sn1, amount,
				reason);

		hp.homeBtnForvims(driver);
		cr.concessionAuthorizationScreen(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.enterHospitalNumber_Filters(driver, hospitalNumber);
		hs.clickOnSearchButton_Filters(driver);
		String billNumber = hs.takeBillNumberPendingList(driver);

		// Concession authorization
		hp.homeBtnForvims(driver);
		cr.concessionAuthorizationScreen(driver);
		cr.enterBillNumber_Filter(driver, billNumber);
		cr.clickOnSearchBtn(driver);
		String hospitalNumber1 = cr.takeBillNumber_ConcessionList(driver);
		Assert.assertEquals(billNumber, hospitalNumber1);
		System.out.println("Hospital number filtered successfully");
	}
}
