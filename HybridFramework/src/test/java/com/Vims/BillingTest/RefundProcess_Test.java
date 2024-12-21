package com.Vims.BillingTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.Concession_Refund_AuthorizationPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.Process_RefundPage;
import com.Dalvkot.Vims_ObjectRepositary.RefundRequestPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class RefundProcess_Test extends BaseClass {
	@Test
	public void verifyThatUserIsAbleToRefundTheOpServiceBill_Test() throws Throwable {
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
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String remarks = "Loreum Ipsum";
		String authorizationStatus = "CONFIRMED";
		String reason = "text";
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addTheService(driver, sn1);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);

		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);

		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		process_RefundPage.clickOnRefundedList(driver);
		process_RefundPage.enterHospitalNumber_refundedList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_RefundedList(driver);
		String hospitalNumber1 = process_RefundPage.captureHospitalNumber_RefundedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void verifyThatUserIsNotAbleToRasieTherequest_ifAlreadyRequestIsRaised_Test() throws Throwable {
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
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "LIPID";
		String sn3 = "PSfor";
		String remarks = "Loreum Ipsum";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling2(driver, sn1, sn2, sn3);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);

		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		String text = refundRequestPage.captureTextInPopup(driver);
		refundRequestPage.clickOnOkBtn(driver);
		System.out.println(text);
		Assert.assertEquals(text, "Request already exist for this bill");
	}

	@Test
	public void verifyThatUserShouldNotBeAbleToRefundTheAlreadyUtilizedServices_Test() throws Throwable {
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
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String remarks = "Loreum Ipsum";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		SampleCollectionPage sampleCollectionPage = new SampleCollectionPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addTheService(driver, sn1);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);

		sampleCollectionPage.clickOnSampleCollectionPage(driver);
		homePage.homeBtnForvims(driver);
		sampleCollectionPage.sampleCollectionForOneSample(driver, hospitalNumber);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		String text = refundRequestPage.captureTextInPopup(driver);
		System.out.println(text);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Consultation Amount is 0");
	}

	@Test
	public void verifyThatOnlyRequestedServicesAreProceedForRefund_Test() throws Throwable {
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
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "LIPID";
		String sn3 = "PSfor";
		String remarks = "Loreum Ipsum";
		String authorizationStatus = "CONFIRMED";
		String reason = "text";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling2(driver, sn1, sn2, sn3);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		String serviceName = refundRequestPage.captureServiceNameinPopUp(driver);
		refundRequestPage.clickOnTheCheckBox_PopUP(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);

		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);

		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		List<String> serviceName1 = process_RefundPage.captureListOfServiceNames_PopUp(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		Assert.assertTrue(serviceName1.contains(serviceName));
	}

	@Test(dependsOnMethods = "verifyThatOnlyRequestedServicesAreProceedForRefund_Test")
	public void verifyThatAlreadyRefundedServiceShouldNotReflectAgainInRefundRequestScreen_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String remarks = "test";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.clickOnConfirmedRefundListTab(driver);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnHospitalNumberInRefundedList(driver);
		concession_Refund_AuthorizationPage.clickOnCancelBtn_PopPU(driver);
		String text = concession_Refund_AuthorizationPage.captureServiceName_PopUp(driver);
		System.out.println(text);
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		List<String> serviceName = refundRequestPage.captureListOfServiceNameinPopUp(driver);
		System.out.println(serviceName);
		refundRequestPage.clickOnTheCheckBox_PopUP(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertFalse(serviceName.contains(text));
	}

	@Test(dependsOnMethods = "verifyThatOnlyRequestedServicesAreProceedForRefund_Test")
	public void verifyThatAfterPartiallyRefundIsDone_AprrovalStatusIsUpdatingInRefundRequestScreen_Test()
			throws Throwable {

		String hospitalNumber = TestData.getHospitalNumber();

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		String txt = refundRequestPage.captureApprovalStatusInTable(driver);
		Assert.assertEquals(txt, "PARTIALLY REFUND");

	}

	@Test
	public void verifyThatServiceAmountAndRefundedAmountIsMatched_Test() throws Throwable {
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
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "LIPID";
		String sn3 = "PSfor";
		String remarks = "Loreum Ipsum";
		String authorizationStatus = "CONFIRMED";
		String reason = "text";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling2(driver, sn1, sn2, sn3);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		String amt = refundRequestPage.captureTotalRefundAmountinPopUp(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		String amt1 = process_RefundPage.captureTotalAmount_PopUP(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		Assert.assertEquals(amt, amt1);
	}

	@Test
	public void checkThatUserIsAbleToRequestARefundForOpc_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("cardiologyDoctor");
		String depName = futil.getProperyKeyValue("cardiologyDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String billType = "OP CONSULTATION";
		String remarks = "loreum ipsum test";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);
		// --------Request a refund ------------
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		String text = refundRequestPage.captureTextInPopup(driver);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Successfully Created Refund Request");
		System.out.println("successfully text is verified");
	}

	@Test(dependsOnMethods = "checkThatUserIsAbleToRequestARefundForOpc_Test")
	public void checkThatSystemShouldNotAllowToRequestARefundForAlreadyRaisedBillNumber_OPC_Test() throws Throwable {
		String billType = "OP CONSULTATION";
		String remarks = "loreum ipsum test";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		String hospitalNumber = TestData.getHospitalNumber();
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		String text = refundRequestPage.captureTextInPopup(driver);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Request already exist");
		System.out.println("successfully text is verified");
	}

	@Test(dependsOnMethods = "checkThatSystemShouldNotAllowToRequestARefundForAlreadyRaisedBillNumber_OPC_Test")
	public void checkThatRefundAmountIsReflectingAfterselectingTheCheckBox_OPC_Test() throws Throwable {

		String billType = "OP CONSULTATION";
		String amt1 = "650.000";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		String hospitalNumber = TestData.getHospitalNumber();
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		String amt = refundRequestPage.captureRefundAmountInThePopup(driver);
		Assert.assertEquals(amt, amt1, "Refund Amount is miss matched");
		System.out.println("successfully refund amount is verified after selecting checkbox");
	}

	@Test
	public void verifyNextBtnIsWorkingAsExpected_PaginationInRefundRequest_OPC_test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.clickOnClearButton(driver);
		refundRequestPage.verifyNextBtnIsWorkingAsExpected(driver);
	}

	@Test
	public void verifyPreviousBtnIsWorkingAsExpected_PaginationInRefundRequest_OPC_test() throws Throwable {

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.clickOnClearButton(driver);
		refundRequestPage.verifyPreviousBtnIsWorkingAsExpected(driver);
	}

	@Test
	public void checkThatSystemShouldNotAllowForRequestARefundAfterPatientArrivalIsDone_OPC_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("cardiologyDoctor");
		String depName = futil.getProperyKeyValue("cardiologyDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String billType = "OP cons";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		DoctorDeskOpdPage doctorDeskOpdPage = new DoctorDeskOpdPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		doctorDeskOpdPage.clickOnTheDoctorDeskOpdScreenButton(driver);
		homePage.homeBtnForvims(driver);
		doctorDeskOpdPage.clickOnAllPatientListTab(driver);
		doctorDeskOpdPage.enterTheHospitalNumber(driver, hospitalNumber);
		doctorDeskOpdPage.clickOnSearchBtn(driver);
		doctorDeskOpdPage.clickOnHospitalNumberInTheAllPatientList(driver);
		doctorDeskOpdPage.clickOnPatientArrivalBtnAndSave(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		String text = refundRequestPage.captureTextInPopup(driver);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Patient Arrival Done");
		System.out.println("successfully text is verified");
	}

	@Test
	public void checkThatAfterRequestRefund_hospitalNumberIsReflectingInConcessionAuthorizationScreen_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("cardiologyDoctor");
		String depName = futil.getProperyKeyValue("cardiologyDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String billType = "OP CONSULTATION";
		String remarks = "loreum ipsum test";
		String refundType = "OPC";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);
		// --------Request a refund -----------
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		// ----concession authorization ----------
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.selectRefundTypeDropdwon(driver, refundType);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		String hospitalNumber1 = concession_Refund_AuthorizationPage.captureHospitallNumberInPendingRefundList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully hospital number is verified");
	}

	@Test(dependsOnMethods = "checkThatAfterRequestRefund_hospitalNumberIsReflectingInConcessionAuthorizationScreen_Test")
	public void checkThatAfterRefundAuthorization_HospitalNumberIsReflectingInconfirmedList_Test() throws Throwable {

		String hospitalNumber = TestData.getHospitalNumber();
		String refundType = "OPC";
		String authorizationStatus = "CONFIRMED";
		String reason = "Loreum ipsum";

		HomePage homePage = new HomePage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);

		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.selectRefundTypeDropdwon(driver, refundType);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		concession_Refund_AuthorizationPage.clickOnConfirmedRefundListTab(driver);
		concession_Refund_AuthorizationPage.selectRefundTypeDropdwon(driver, refundType);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		String hospitalNumber1 = concession_Refund_AuthorizationPage
				.captureHospitallNumberInConfirmedRefundList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully hospital number is verified");
	}

	@Test(dependsOnMethods = "checkThatAfterRefundAuthorization_HospitalNumberIsReflectingInconfirmedList_Test")
	public void checkThatAfterRefundIsConfirmed_HospitalNumberIsReflectingInProcessRefundScreen_Test()
			throws Throwable {
		String billType = "OP CON";
		String hospitalNumber = TestData.getHospitalNumber();

		HomePage homePage = new HomePage(driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.clickOnOkBtnIfDisplays(driver);
		process_RefundPage.selectBillType_PendingList(driver, billType);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		String hospitalNumber1 = process_RefundPage.captureHospitalNumber_PendingRefundedList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void verifyThatUserIsAbleToRefundOnlyTheConsultationAmount_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("cardiologyDoctor");
		String depName = futil.getProperyKeyValue("cardiologyDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String billType = "OP CONSULTATION";
		String remarks = "loreum ipsum test";
		String authorizationStatus = "CONFIRMED";
		String reason = "Loreum ipsum";
		String refundType = "OPC";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// --------Request a refund ------------
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		// ----concession authorization ----------
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.selectRefundTypeDropdwon(driver, refundType);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.clickOnOkBtnIfDisplays(driver);
		process_RefundPage.selectBillType_PendingList(driver, billType);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		String hospitalNumber1 = process_RefundPage.captureHospitalNumber_PendingRefundedList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void verifyThatUserShouldNotBeAbleToRefundTheRegistrationAmount_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("cardiologyDoctor");
		String depName = futil.getProperyKeyValue("cardiologyDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String billType = "OP CONSULTATION";
		String remarks = "test";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// --------Request a refund ------------
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnOkBtnIfDisplays(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		java.util.List<String> amt1 = refundRequestPage.captureListOfTotalAmountInPopup_ExceptFirstRow(driver);
		String amt = refundRequestPage.captureTotalRefundAmountinPopUp(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertTrue(amt1.contains(amt));
	}

	@Test
	public void verifyThatUserIsAbleToRefundOnlyCashMhcBill_Test() throws Throwable {
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
		String BillType = "MHC";
		String remarks = "test";
		String packageName = "COMPREHENSIVE HEALTH CHEKUP FOR MEN";
		String authorizationStatus = "CONFIRMED";
		String reason = "text";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		// ------OPD registration---------
		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);

		// OP billing
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.selectBillType(driver, BillType);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addThePackageName(driver, packageName);
		hospital_Service_Bill_page.selectDepartmentUnitsDropdowns(driver);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.selectBillTypeDropdown(driver, BillType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.selectRefundTypeDropdwon(driver, BillType);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.selectBillType_PendingList(driver, BillType);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		process_RefundPage.clickOnRefundedList(driver);
		process_RefundPage.enterHospitalNumber_refundedList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_RefundedList(driver);
		String hospitalNumber1 = process_RefundPage.captureHospitalNumber_RefundedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test(dependsOnMethods = "verifyThatUserIsAbleToRefundOnlyCashMhcBill_Test")
	public void verifyThatAfterMhcBillIsRefunded_ApprovalStatusIsUpdatingInRefundRequest_Test() throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String billType = "MHC";

		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.selectBillTypeDropdown(driver, billType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		String txt = refundRequestPage.captureApprovalStatusInTable(driver);
		Assert.assertEquals(txt, "REFUNDED");
	}

	@Test
	public void verifyThatMhcBillAmountShouldMatchWithTheMhcRefundAmount() throws Throwable {
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
		String BillType = "MHC";
		String remarks = "test";
		String packageName = "COMPREHENSIVE HEALTH CHEKUP FOR MEN";
		String authorizationStatus = "CONFIRMED";
		String reason = "text";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		Concession_Refund_AuthorizationPage concession_Refund_AuthorizationPage = new Concession_Refund_AuthorizationPage(
				driver);
		Process_RefundPage process_RefundPage = new Process_RefundPage(driver);

		// ------OPD registration---------
		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);
		// OP billing
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.selectBillType(driver, BillType);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addThePackageName(driver, packageName);
		hospital_Service_Bill_page.selectDepartmentUnitsDropdowns(driver);
		String amt1 = hospital_Service_Bill_page.CaptureBillAmount(driver);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.selectBillTypeDropdown(driver, BillType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
		refundRequestPage.clickOnOkBtn(driver);
		concession_Refund_AuthorizationPage.concessionAuthorizationScreen(driver);
		homePage.homeBtnForvims(driver);
		concession_Refund_AuthorizationPage.clickOnRefundListRadioBtn(driver);
		concession_Refund_AuthorizationPage.selectRefundTypeDropdwon(driver, BillType);
		concession_Refund_AuthorizationPage.enterHospitalNumber(driver, hospitalNumber);
		concession_Refund_AuthorizationPage.clickOnSearchBtn(driver);
		concession_Refund_AuthorizationPage.clickOnBillNumberInRefundPendinglist(driver);
		concession_Refund_AuthorizationPage.ClickOnSubmitAfterSelectingAuthorizationStatus(driver, authorizationStatus,
				reason);
		process_RefundPage.clickOnProcessRefundBtn(driver);
		homePage.homeBtnForvims(driver);
		process_RefundPage.selectBillType_PendingList(driver, BillType);
		process_RefundPage.enterHospitalNumber_pendingList(driver, hospitalNumber);
		process_RefundPage.clickOnSearch_pendingList(driver);
		process_RefundPage.clickOnBillNumber_PendingList(driver);
		String amt = process_RefundPage.captureTotalAmount_PopUP(driver);
		process_RefundPage.clickOnSave(driver);
		process_RefundPage.clickOnOkBtn(driver);
		Assert.assertEquals(amt, amt1);
	}

	@Test
	public void verifThatIfAnyDepartmentArrivalIsDoneItShouldNotProcessForTheMhcRefund_Test() throws Throwable {
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
		String BillType = "MHC";
		String packageName = "COMPREHENSIVE HEALTH CHEKUP FOR MEN";
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);
		LogOutPage logOutPage = new LogOutPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		DoctorDeskOpdPage doctorDeskOpdPage = new DoctorDeskOpdPage(driver);

		// ----OPD registration---------
		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// OP billing
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.selectBillType(driver, BillType);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addThePackageName(driver, packageName);
		hospital_Service_Bill_page.selectDepartmentUnitsDropdowns(driver);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		logOutPage.logoutTheApplication(driver);
		loginPage.loginToApplicationUsingDoctorLogin(un, pw, driver);
		doctorDeskOpdPage.clickOnTheDoctorDeskOpdScreenButton(driver);
		homePage.homeBtnForvims(driver);
		doctorDeskOpdPage.clickOnAllPatientListTab(driver);
		doctorDeskOpdPage.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		doctorDeskOpdPage.clickOnPatientArrivalBtnAndSave(driver);
		doctorDeskOpdPage.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		logOutPage.logoutTheApplication(driver);
		loginPage.loginToApplicationUsingDoctorLogin(username, password, driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.selectBillTypeDropdown(driver, BillType);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		String text = refundRequestPage.captureTextInPopup(driver);
		refundRequestPage.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Patient Arrival is Done");
	}

	@Test
	public void toCheckThatUserShouldGetTheDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "AUTOMATION TEST AMMONIA";
		String sn3 = "AUTOMATION TEST AMYLASE";
		String sn4 = "CSF SODIUM";
		String sn5 = "CT CALCIUM SCORING";
		String sn6 = "AFB - CYTO";
		String doctorname = futil.getProperyKeyValue("doctorName1");
		String depName = futil.getProperyKeyValue("department1");

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addListOfServicesInOpBilling(driver, sn1, sn2, sn3, sn4, sn5, sn6);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);
		String hospitalNumber1 = refundRequestPage.takehospitalNumber_Table(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Hospital number verified sucessfully");
	}

	@Test
	public void toCheckThatUserShouldGetTheDetailsWithHelpOf_billNumber_Test() throws Throwable {
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "AUTOMATION TEST AMMONIA";
		String sn3 = "AUTOMATION TEST AMYLASE";
		String sn4 = "CSF SODIUM";
		String sn5 = "CT CALCIUM SCORING";
		String sn6 = "AFB - CYTO";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addListOfServicesInOpBilling(driver, sn1, sn2, sn3, sn4, sn5, sn6);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow__RefundRequestProcess(driver);
		hospital_Service_Bill_page.clickOnOkBtn(driver);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.enterHospitalNumber_Filters(driver, hospitalNumber);
		hospital_Service_Bill_page.clickOnSearchButton_Filters(driver);
		String billNumber = hospital_Service_Bill_page.takeBillNumber_CompletedTable(driver);
		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		refundRequestPage.enterBillNumber(driver, billNumber);
		refundRequestPage.clickOnSearchButton(driver);
		String billNumber1 = refundRequestPage.takeBillNumber_Table(driver);
		Assert.assertEquals(billNumber, billNumber1);
		System.out.println("bill number verified sucessfully");
	}

	@Test
	public void toCheckThatUserShouldAbleToDoReqestARefund_For_op_PatientTest() throws Throwable {
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "AUTOMATION TEST AMMONIA";
		String sn3 = "AUTOMATION TEST AMYLASE";
		String sn4 = "CSF SODIUM";
		String sn5 = "CT CALCIUM SCORING";
		String sn6 = "AFB - CYTO";
		String remarks = "TestEtes";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addListOfServicesInOpBilling(driver, sn1, sn2, sn3, sn4, sn5, sn6);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow__RefundRequestProcess(driver);

		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		refundRequestPage.enterHospitalNumber(driver, hospitalNumber);
		refundRequestPage.clickOnSearchButton(driver);

		refundRequestPage.clickOnBillNumber(driver);
		refundRequestPage.clickOnTheSelectAllServices_RadioBtn(driver);
		refundRequestPage.enterRemarksInThe_Popup(driver, remarks);
		refundRequestPage.clickOnSaveButton(driver);
	}

	@Test
	public void verifyRemarksErrorMsgInRefundRequestScreen_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		RefundRequestPage refundRequestPage = new RefundRequestPage(driver);

		homePage.homeBtnForvims(driver);
		refundRequestPage.clickOnRefundRequestPage(driver);
		refundRequestPage.clickOnBillNumberInTable(driver);
		String errorMsg = refundRequestPage.verifyRemarksErrorMsg(driver);
		Assert.assertEquals(errorMsg, "Please Enter Remarks");
		System.out.println("successfully remarks error msg is verified");
	}

}
