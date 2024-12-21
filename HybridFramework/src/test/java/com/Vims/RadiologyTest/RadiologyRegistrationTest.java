package com.Vims.RadiologyTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.GeneratHospitalNumber_page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.IcdEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.RadiologyRegistrationListPage;
import com.Dalvkot.Vims_ObjectRepositary.RefundRequestPage;
import com.Dalvkot.Vims_ObjectRepositary.modalityConfirmationPage;

public class RadiologyRegistrationTest extends BaseClass {

	@Test
	public void checkThatUserIsAbleToSearchUsingBillNo_PendingList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		String billNo = rr.captureBillNoInTable_PendingList_LastRow(driver);
		rr.enterBillNo_filter(driver, billNo);
		rr.clickOnSearchBtn(driver);
		String billNo1 = rr.captureBillNoInTable_PendingList(driver);
		Assert.assertEquals(billNo, billNo1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingHospitalNumber_PendingList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		String hospitalNumber = rr.captureHospitalNumberInTable_PendingList_LastRow(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumber_RealPatient_InTable_PendingList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingDepartment_PendingList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		String dep = rr.captureDepartmentInTable_PendingList_LastRow(driver);
		rr.selectDepartment_Filter(driver, dep);
		rr.clickOnSearchBtn(driver);
		String dep1 = rr.captureDepartmentInTable_PendingList(driver);
		Assert.assertEquals(dep, dep1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingBillTypeAsOp_PendingList_Test() throws Throwable {
		String serviceName = "Radiology";
		String billType = "OP";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.selectBillType_Filter(driver, billType);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumber_RealPatient_InTable_PendingList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingBillTypeAsIp_PendingList_Test() throws Throwable {
		String billType = "IP";

		HomePage hp = new HomePage(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.selectBillType_Filter(driver, billType);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber = rr.captureHospitalNumber_RealPatient_InTable_PendingList(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnClearBtn(driver);
		ap.enterTheHospitalNumber(hospitalNumber);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber1 = ap.takeTheHospitalNumberInTheActivePatientTable(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingBillNo_CompletedList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCompletedTab(driver);
		rr.clickOnClearBtn(driver);
		String billNo = rr.captureBillNoInTable_CompletedList_LastRow(driver);
		rr.enterBillNo_filter(driver, billNo);
		rr.clickOnSearchBtn(driver);
		String billNo1 = rr.captureBillNoInTable_CompletedList(driver);
		Assert.assertEquals(billNo, billNo1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingHospitalNumber_CompletedList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCompletedTab(driver);
		rr.clickOnClearBtn(driver);
		String hospitalNumber = rr.captureHospitalNumberInTable_CompletedList_LastRow(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_CompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingDepartment_CompletedList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCompletedTab(driver);
		rr.clickOnClearBtn(driver);
		String dep = rr.captureDepartmentInTable_CompletedList_LastRow(driver);
		rr.selectDepartment_Filter(driver, dep);
		rr.clickOnSearchBtn(driver);
		String dep1 = rr.captureDepartmentInTable_CompletedList(driver);
		Assert.assertEquals(dep, dep1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingBillTypeAsOp_CompletedList_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);

		String radiographer = "SHIVANAND";
		String billType = "OP";

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.selectBillType_Filter(driver, billType);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber = rr.captureHospitalNumber_RealPatient_InTable_PendingList(driver);
		rr.clickOnBillNumberInTable_pendingList(driver);
		rr.selectRadiographer(driver, radiographer);
		rr.selectCheckBoxInTable_PopUp(driver);
		rr.clickOnSubmit(driver);
		rr.clickOnOkBtn(driver);
		rr.clickOnCompletedTab(driver);
		rr.selectBillType_Filter(driver, billType);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_CompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingBillTypeAsIp_CompletedList_Test() throws Throwable {

		String radiographer = "SHIVANAND";
		String billType = "IP";

		HomePage hp = new HomePage(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.selectBillType_Filter(driver, billType);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber = rr.captureHospitalNumber_RealPatient_InTable_PendingList(driver);
		rr.clickOnBillNumberInTable_pendingList(driver);
		rr.selectRadiographer(driver, radiographer);
		rr.selectCheckBoxInTable_PopUp(driver);
		rr.clickOnSubmit(driver);
		rr.clickOnOkBtn(driver);
		scrollToTop(driver);
		rr.clickOnCompletedTab(driver);
		rr.selectBillType_Filter(driver, billType);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_CompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingBillNo_CancelledList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.clickOnCancelledTab(driver);
		String billNo = rr.captureBillNoInTable_CancelledList_LastRow(driver);
		rr.enterBillNo_filter(driver, billNo);
		rr.clickOnSearchBtn(driver);
		String billNo1 = rr.captureBillNoInTable_CancelledList(driver);
		Assert.assertEquals(billNo, billNo1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingHospitalNumber_CancelledList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCancelledTab(driver);
		rr.clickOnClearBtn(driver);
		String hospitalNumber = rr.captureHospitalNumberInTable_CancelledList_LastRow(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_CancelledList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserIsAbleToSearchUsingDepartment_CancelledList_Test() throws Throwable {
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		HomePage hp = new HomePage(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCancelledTab(driver);
		rr.clickOnClearBtn(driver);
		String dep = rr.captureDepartmentInTable_CancelledList_LastRow(driver);
		rr.selectDepartment_Filter(driver, dep);
		rr.clickOnSearchBtn(driver);
		String dep1 = rr.captureDepartmentInTable_CancelledList(driver);
		Assert.assertEquals(dep, dep1);
	}

	@Test
	public void chechThatAddedFinalDiagnosisInIcdEntryIsReflectingInRadiologyRegistrationUnderViewDiagnosis_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		IcdEntryPage ic = new IcdEntryPage(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		String icdCode = "icd";
		String codeDescription = "Paratyphoid fever A";
		String categoryType = "Urban";
		String sn1 = "CT OR MRI FLIM";

		ic.clickOnIcdEntryScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ic.selectCategoryType(driver, categoryType);
		ic.clickOnSearch(driver);
		String hospitalNumber = ic.captureHospitalNumber_Table_PendingList(driver);
		ic.clickOnAddDiagnosis_Table(driver);
		ic.addDiagnosis(driver, icdCode, codeDescription);
		ic.clickOnSubmit(driver);
		ic.captureTextAndClickOnOkbtn(driver);
		ic.clickOnCompletedListTab(driver);
		ic.enterHospitalNumber(driver, hospitalNumber);
		ic.clickOnSearch(driver);
		ic.clickOnView_CompletedList(driver);
		List<String> cd1 = ic.captureCodeDescription_View_CompletedList(driver);
		ic.clickOnCancel_View_completedList(driver);

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addTheService(driver, sn1);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.clickOnViewFinalDiagnosis_PendingList(driver);
		List<String> cd = rr.captureListOfCodeDescription_viewDiagnosis_radiologyResgidtration(driver);
		Assert.assertEquals(cd, cd1);
	}

	@Test
	public void checkThatCancelOptionShouldNotReflectAfterModaliltyConfirmationIsDone_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		modalityConfirmationPage mc = new modalityConfirmationPage(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);

		mc.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mc.clickOnClearButton(driver);
		String hospitalNumber = mc.captureHospitalNumber_PendingList(driver);
		mc.clickOnRegistrationNumber(driver);
		mc.clickOnSubmit(driver);
		mc.clickOnOkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCompletedTab(driver);
		rr.clickOnClearBtn(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.verifyThatCancelButtonIsNotReflectingAfterModaliltyConfirmationIsDone(driver);
	}

	@Test
	public void checkThatModaliltyConfirmationDetailsShouldReflectInDoctorDesk_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		modalityConfirmationPage mc = new modalityConfirmationPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		String serviceName = "CT CONTRAST(RADIOLOGY INVESTIGATION) 60ML";
		String un = "medicine_rama1234@vimsmail.com";
		String pw = "12345";
		String radiographer = "SHIVANAND";

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.clickOnBillNumberInTable_pendingList(driver);
		rr.selectRadiographer(driver, radiographer);
		rr.selectCheckBoxInTable_PopUp(driver);
		rr.clickOnSubmit(driver);
		rr.clickOnOkBtn(driver);
		rr.clickOnCompletedTab(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String billNum = rr.captureBillNoInTable_CompletedList(driver);

		mc.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mc.enterHospitalNumber_Filter(driver, hospitalNumber);
		mc.clickOnSearch_Button_Filter(driver);
		mc.clickOnRegistrationNumber(driver);
		String serviceClass = mc.captureServiceClass_Popup(driver);
		mc.clickOnSubmit(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnLabResultTab(driver);
		dp.clickOnRadiologyTab_LabResultTab(driver);
		String tran = dp.captureTransactionNumber_Table_radiology(driver);
		String sc = dp.captureServiceClass_Table_radiology(driver);
		String sn = dp.capturetServiceNamee_Table_radiology(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(billNum, tran, "bill number is missmatched");
		sa.assertEquals(serviceClass, sc, "service class is missmatched");
		sa.assertEquals(serviceName, sn, "serviceName is missmatched");
		sa.assertAll();
	}

	@Test
	public void CheckThatIfUserIndentRadiologyServicesInTheDoctorDeskAndDoTheOpBillingThatBillNumberAndServicesShouldComeUnderRadiologyRegistrtaionPendingList_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "CT CONTRAST(RADIOLOGY INVESTIGATION) 60ML";

		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");

		String notes = "testing";
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		String doctorName = futil.getProperyKeyValue("generalmedicineHod");

		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSaveAndSelectInAssignedDoctorForIMO_And_PG(driver, doctorName);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		// ------Investigations---------
		scrollToTop(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.addTheInvestigationsForLabOneService(driver, serviceName, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit(driver);
		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.clickOnBillNumberInTable_pendingList(driver);
		String serviceName1 = rr.captureServiceName_BillNo_PopUp(driver);
		Assert.assertEquals(serviceName, serviceName1);
	}

	@Test
	public void checkThatAfterSubmittingTheHospitalNumberInPendingListIsReflectingInCompletedList_Test()
			throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		String service = "CT CONTRAST(RADIOLOGY INVESTIGATION) 60ML";
		String radiographer = "SHIVANAND";

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, service);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.clickOnBillNumberInTable_pendingList(driver);
		rr.selectRadiographer(driver, radiographer);
		rr.selectCheckBoxInTable_PopUp(driver);
		rr.clickOnSubmit(driver);
		rr.clickOnOkBtn(driver);
		rr.clickOnCompletedTab(driver);
		rr.selectBillType_Filter(driver, "OP");
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_CompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		TestData.setHospitalNumber(hospitalNumber);
	}

	@Test(dependsOnMethods = "checkThatAfterSubmittingTheHospitalNumberInPendingListIsReflectingInCompletedList_Test")
	public void checkThatUserIsAbleToCancelTheCompletedHospitalNumber_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);

		String hospitalNumber = TestData.getHospitalNumber();
		String reason = "Lorem Ipsum";

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCompletedTab(driver);
		rr.selectBillType_Filter(driver, "OP");
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnCancelUnderAction_CompletedList(driver);
		rr.enterDataInReasontextArea(driver, reason);
		rr.selectCheckbox_Cancel(driver);
		rr.clickOnSubmit_Cancel(driver);
		rr.clickOnOkBtn(driver);
		rr.clickOnCancelledTab(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_CancelledList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatSameHospitalNumberIsReflectingInModaliltyConfirmationPendingListAfterRadiologyRegistrationIsDone_test()
			throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		modalityConfirmationPage mc = new modalityConfirmationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);

		String service = "CT CONTRAST(RADIOLOGY INVESTIGATION) 60ML";
		String radiographer = "SHIVANAND";

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, service);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.clickOnBillNumberInTable_pendingList(driver);
		rr.selectRadiographer(driver, radiographer);
		rr.selectCheckBoxInTable_PopUp(driver);
		rr.clickOnSubmit(driver);
		rr.clickOnOkBtn(driver);

		mc.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mc.clickOnPendingList(driver);
		mc.enterHospitalNumber_Filter(driver, hospitalNumber);
		mc.clickOnSearch_Button_Filter(driver);
		String hospitalNumber1 = mc.captureHospitalNumber_PendingList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);

	}

	@Test(dependsOnMethods = "checkThatSameHospitalNumberIsReflectingInModaliltyConfirmationPendingListAfterRadiologyRegistrationIsDone_test")
	public void verifyThatAfterModaliltyConfirmationIsDoneHospitalNumberIsReflectingInRefundRequestScreen_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		modalityConfirmationPage mc = new modalityConfirmationPage(driver);
		RefundRequestPage rr = new RefundRequestPage(driver);

		String hospitalNumber = TestData.getHospitalNumber();
		System.out.println(hospitalNumber);
		mc.clickOnModalityConfirmation(driver);
		hp.homeBtnForvims(driver);
		mc.clickOnPendingList(driver);
		mc.enterHospitalNumber_Filter(driver, hospitalNumber);
		mc.clickOnSearch_Button_Filter(driver);
		mc.clickOnRegistrationNumber(driver);
		mc.clickOnSubmit(driver);
		mc.clickOnOkBtn(driver);

		rr.clickOnRefundRequestPage(driver);
		hp.homeBtnForvims(driver);
		rr.enterHospitalNumber(driver, hospitalNumber);
		rr.clickOnSearchButton(driver);
		String hospitalNumber1 = rr.takehospitalNumber_Table(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void createDummyPatientsAndCheckThatHospitalNumberIsReflectingInRadiologyPendingListBySelectingCheckBox_Test()
			throws Throwable {
		String hsptl = "2";
		String clinicName = "VYDEHI CLINIC";
		String gender_female = "Female";
		String qty = "2";
		String department = "DERMATOLOGY";
		String unit2 = "2";
		String icdCode = "icd";
		String codeDescription = "Paratyphoid fever A";
		String categoryType = "rural";

		HomePage hp = new HomePage(driver);
		GeneratHospitalNumber_page r = new GeneratHospitalNumber_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		IcdEntryPage ic = new IcdEntryPage(driver);

		r.generateHospitalNumber(driver);
		hp.homeBtnForvims(driver);
		r.clickNewBtn(driver);
		r.enterHospitalNumber(driver, hsptl);
		String hospitalNumber = r.captureHospitalNumber(driver);
		r.clickGenerateHospitalNumberBtn(driver);
		r.clickonokBtn(driver);
		r.clickEdit(driver);
		r.selectFromDate(driver);
		r.addLineItems(driver, clinicName, department, unit2, gender_female, qty);
		r.clicksubmitBnt(driver);
		r.ok_Btn(driver);

		ic.clickOnIcdEntryScreenBtn(driver);
		hp.homeBtnForvims(driver);
		ic.selectCategoryType(driver, categoryType);
		ic.enterHospitalNumber(driver, hospitalNumber);
		ic.clickOnSearch(driver);
		ic.clickOnAddDiagnosis_Table(driver);
		ic.addDiagnosis(driver, icdCode, codeDescription);
		ic.clickOnSubmit(driver);
		rr.clickOnOkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnCheckBox_SearchFilter(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		String hospitalNumber1 = rr.captureHospitalNumberInTable_PendingList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatAddedFinalDiagnosInDoctorDeskIsReflectingInViewDiagnosisUnderPendingList_Radiology_Test()
			throws Throwable {

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("generalMedicineDoctor");
		String depName = futil.getProperyKeyValue("generalMedicineDepartment");
		String un = futil.getProperyKeyValue("generalMedicinePG_Un");
		String pw = futil.getProperyKeyValue("generalMedicinePG_PW");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "CT CONTRAST(RADIOLOGY INVESTIGATION) 60ML";
		String notes = "testing";
		String comments = "Lorem ipsum dolor sit amet";
		String fd = "Isosporiasis";
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		RadiologyRegistrationListPage rr = new RadiologyRegistrationListPage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);

		opdregistrationpage.opdRegistrationButton(driver);
		hp.homeBtnForvims(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addTheInvestigationsForLabOneService(driver, serviceName, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);

		scrollToTop(driver);
		dp.clickOnFinalDiagnosisTabinDDOPD(driver);
		dp.clickOnNewBtnInFinalDiagnosisTab(driver);
		dp.addOneFinalDiagnosis(driver, fd, comments);
		dp.clickOnSubmitBtnInFinalDiagnosisTab(driver);
		wait_For_Invisibilty_OfElement_ForLoader(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		rr.clickOnRadiologyRegistrationScreenBtn(driver);
		hp.homeBtnForvims(driver);
		rr.clickOnClearBtn(driver);
		rr.enterHospitalNumber_filter(driver, hospitalNumber);
		rr.clickOnSearchBtn(driver);
		rr.clickOnViewFinalDiagnosis_PendingList(driver);
		String cd = rr.captureCodeDescription_DiagnosisDetails(driver);
		Assert.assertEquals(cd, fd);
	}

}
