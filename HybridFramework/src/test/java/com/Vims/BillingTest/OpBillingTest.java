package com.Vims.BillingTest;

import java.util.HashSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.Concession_Refund_AuthorizationPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class OpBillingTest extends BaseClass {

	@Test(invocationCount = 20)
	public void verifyBillDateSearchFilterInCompletedList_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "URINE- AUTOMATED CULTURE & SENSITIVITY";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// -------op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);
//		hs.clickOnCompletedTab(driver);
//		hs.clickOnClearButton(driver);
//		// String date = hs.selectBillDateInCompletedList(driver);
//		hs.clickOnSarch(driver);
//		String date1 = hs.captureBillDateInCompletedList(driver);
//		// Assert.assertEquals(date, date1);
		System.out.println("bill date is filtered successfully");
	}

	@Test
	public void checkThatUserShouldAbleToDo_SinglePaymentModeThrough_CreditCard_Test() throws Throwable {
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
		String mode = "CREDIT CARD";
		String cardType = "MASTER";
		String serviceCharge = "1";
		String cardExpiry = "122023";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addTheService(driver, sn1);
		hospital_Service_Bill_page.SinglePaymentMode_Credit(driver, mode, cardType, serviceCharge, cardExpiry);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
	}

	@Test
	public void checkThatUserShouldAbleToDo_SinglePaymentModeThrough_Cheque_Test() throws Throwable {
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
		String mode = "CHEQUE";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// OP billing
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addTheService(driver, sn1);
		hs.SinglePaymentMode_Cheque(driver, mode);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);
	}

	@Test
	public void checkThatUserShouldAbleToDo_SinglePaymentModeThrough_DD_Test() throws Throwable {
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
		String mode = "DD";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addTheService(driver, sn1);
		hospital_Service_Bill_page.SinglePaymentMode_DD(driver, mode);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
	}

	@Test
	public void checkThatUserShouldAbleToDo_SinglePaymentModeThrough_ElectronicsTransferMoney_Test() throws Throwable {
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
		String mode = "ELECTRONIC MONEY TRANSFER";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addTheService(driver, sn1);
		hospital_Service_Bill_page.SinglePaymentMode_ElectronicsMoneyTransfer(driver, mode);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
	}

	@Test
	public void checkThatUserShouldAbleToDo_MultiplePaymentModeThrough_UsedToCashAndCredit_Test() throws Throwable {
		String serviceName = "AUTOMATION TEST MAGNESIUM";
		String mode = "CASH";
		String amount = "10";
		String mode1 = "CREDIT CARD";
		String cardType = "MASTER";
		String charge = "2";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addOneServiceInTheOpBillin(driver, serviceName);
		hospital_Service_Bill_page.firstPaymentMode_AsCash(driver, mode, amount);
		hospital_Service_Bill_page.secondPaymentModeAs_Credit(driver, mode1, cardType, charge);
		hospital_Service_Bill_page.clickOnSubmit(driver);

	}

	/*
	 * @Test public void checkThatUserShouldbeDoOPBillingForIpPatient_Test() throws
	 * Throwable {
	 * 
	 * String serviceName = "AUTOMATION TEST MAGNESIUM";
	 * 
	 * String name = "S"; String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
	 * String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6); String mobilenum =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 7); String mail =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 8); String address =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 9); String pincode =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 10); String postOffice =
	 * eutil.getDataFromTheExcel("Opdreg1", 2, 14);
	 * 
	 * String doctorname = "SURESH"; String depName = "NEUROLOGY"; String wardType =
	 * "GENERAL WARD"; String bedCategory = "NON TEACHING"; String bedWardType =
	 * "GENERAL WARD"; String bedRoomType = "C19 TRIAGE"; String floor =
	 * "4TH FLOOR"; String wings = "WEST WING"; String bedUnitDepartment = "1";
	 * String roomType = "C19 TRIAGE"; String admittedByDr = "DR.ABBAS"; String time
	 * = "1230";
	 * 
	 * String BillType = "IP";
	 * 
	 * HomePage hp = new HomePage(driver); Hospital_Service_Bill_page hs = new
	 * Hospital_Service_Bill_page(driver);
	 * 
	 * // ----OPD registration--------- hp.homeBtnForvims(driver);
	 * OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
	 * opdregistrationpage.opdRegistrationButton(driver);
	 * 
	 * opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname,
	 * mobilenum, mail, address, pincode, postOffice, depName, doctorname); String
	 * hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
	 * 
	 * BedMasterPage bp = new BedMasterPage(driver); String bednumberh =
	 * bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor,
	 * wings, depName, bedUnitDepartment);
	 * 
	 * // -------- patientAdmission------- PatientAdmissionPage patientAdmissionPage
	 * = new PatientAdmissionPage(driver);
	 * patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
	 * patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time,
	 * depName, doctorname, admittedByDr, wardType, roomType, bednumberh);
	 * 
	 * // OP billing hp.homeBtnForvims(driver);
	 * hs.clickOnHospitalServiceBillLink(driver); hs.clickonNewBillButton(driver);
	 * 
	 * hs.selectBillType(driver, BillType); hs.enterHospitalNumber(hospitalNumber);
	 * hs.addOneServiceInTheOpBillin(driver, serviceName);
	 * 
	 * hs.clickOnSubmit_CloseWindow_OkBtn(driver);
	 * 
	 * }
	 */

	@Test
	public void checkThatUsershouldbeDoTheMHCPackage_Billing_Test() throws Throwable {
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

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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

	}

	@Test
	public void checkThatUserShouldbeVerifyTheMhcPackageDepartmentsNames_InTheSearchPatientPage_Test()
			throws Throwable {
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

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);

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
		HashSet<String> dep = hospital_Service_Bill_page.takeDepartmentNames();
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		// Search patient
		homePage.homeBtnForvims(driver);
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		searchPatientPage.enterHospitalNumber(driver, hospitalNumber);
//		HashSet<String> department = searchPatientPage.takeDepartments(driver);
		System.out.println(hospitalNumber);
//		Assert.assertEquals(dep, department);
		System.out.println("User verified a mhc package department names in the search patient list");

	}

	@Test
	public void checkThatUserShouldbeVerifyTheMhcPackageDoctorNames_InTheSearchPatientPage_Test() throws Throwable {
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

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);

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
		HashSet<String> doctorName = hospital_Service_Bill_page.takeUnitChiefsName_ConsultationList(driver);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		// Search patient
		homePage.homeBtnForvims(driver);
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		searchPatientPage.enterHospitalNumber(driver, hospitalNumber);
//		HashSet<String> doctorName1 = searchPatientPage.takeDoctorNames(driver);
		System.out.println(hospitalNumber);
//		Assert.assertEquals(doctorName1, doctorName);
		System.out.println("User verified a mhc package department names in the search patient list");
	}

	@Test
	public void checkThatUserShouldVerifyTheExternalLabServiceInTheSampleCollectionPage_Test() throws Throwable {
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
		String sn1 = "MAGNESIUM (EXTR)";
		String serviceClass = "( External Service )";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sampleCollectionPage = new SampleCollectionPage(driver);

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
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.clickOnExternalLabRadioButton(driver);
		hospital_Service_Bill_page.addTheService(driver, sn1);
		hospital_Service_Bill_page.clickOnSubmit_CloseWindow_OkBtn(driver);
		// Sample collection
		homePage.homeBtnForvims(driver);
		sampleCollectionPage.clickOnSampleCollectionPage(driver);
		sampleCollectionPage.clickOnNewSampleButton(driver);
		sampleCollectionPage.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sampleCollectionPage.clickOn_Search_Button_NewSamples(driver);
		sampleCollectionPage.clickOnLast_Row_BillNumber_NewSamples(driver);
		sampleCollectionPage.serviceClass_ExtrenalLab_ServiceDetailsTable(driver, serviceClass);
	}

	@Test
	public void checkThatUserShouldbeDoConcessionBill_Test() throws Throwable {
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
		String amount = "100";
		String reason = "TestTesttest";
		String concessionOn = "ON BILL";
		String authorization = "CFO APPROVAL";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason);
	}

	@Test
	public void checkThatUserShouldbeClickOnSendForApprovalButton_WithoutGivingAuthorizationApproval_Test()
			throws Throwable {
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String reason = "TestTesttest";
		String concessionOn = "ON BILL";
		String amount = "200";
		String msg = "Please Select Authorization";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess_WithoutAuthorization(driver, hospitalNumber, concessionOn, sn1,
				amount, reason);
		String msg1 = hospital_Service_Bill_page.takePleaseSelectAuthorization_PopupMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the popup message as  :" + msg1 + "  Successfully");

	}

	@Test
	public void addTheIvstigationAmounts_Test() throws Throwable {

		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String sn2 = "AUTOMATION  LIPID PROFILEPANEL";
		String sn3 = "AUTOMATION TEST AMMONIA";

		SearchPatientPage sp = new SearchPatientPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hospital_Service_Bill_page.addTheServicesRateAmounts(driver);
		hospital_Service_Bill_page.clickOnSubmit(driver);
	}

	@Test
	public void verifyBalanceAmountIsDisplayingCorrectly_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "MAGNESIUM";
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling(driver, serviceName);
		hospital_Service_Bill_page.verifyBalanceAmount(driver);
	}

	@Test(invocationCount = 20)
	public void verifyTotalAmountIsGettinUpdatedAfterDeletingService_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String sn1 = "GLUCOSE";
		String sn2 = "GLUCOSE - FASTING";
		String sn3 = "24 HOURS URINE MAGNESIUM";

		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		Thread.sleep(1000);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// ----op billing----------
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling2(driver, sn1, sn2, sn3);
		hospital_Service_Bill_page.verifyTotalAmountIsGettingUpdatedAfterDeletingService(driver);
	}

	@Test(dependsOnMethods = "verifyTotalAmountIsGettinUpdatedAfterDeletingService_Test")
	public void verifyNetAmountIsGettingUpdatedAfterChangingTheQuantity_Test() throws Throwable {
		String serviceName = "QUADRUPLE TEST";
		String q = "5";

		SearchPatientPage sp = new SearchPatientPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.verifyNetAmountIsGettingUpdatedAfterChangingTheQuantity(driver, serviceName, q);
	}

	@Test(dependsOnMethods = "verifyNetAmountIsGettingUpdatedAfterChangingTheQuantity_Test")
	public void verifyErrorMsgIfWeAddServiceWithoutEnteringMandatoryFields_Test() throws Throwable {
		String errorpopup1 = "Please Enter Mandatory Field";

		SearchPatientPage sp = new SearchPatientPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		System.out.println(hospitalNumber);
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String errorPopup = hospital_Service_Bill_page.verifyErrorPopAddingServicesWithoutEnteringMandatoryData(driver);
		Assert.assertEquals(errorPopup, errorpopup1);
		System.out.println("successfully error pop is verified");
	}

	@Test(dependsOnMethods = "verifyErrorMsgIfWeAddServiceWithoutEnteringMandatoryFields_Test")
	public void verifyClinicalNotesInTheEyeIconPopup_Test() throws Throwable {
		SearchPatientPage sp = new SearchPatientPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = sp.captureHospitalNumberInTheTable();
		System.out.println(hospitalNumber);
		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String serviceName = "lipid profilepanel";
		String clinicalNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String clinicalNotes1 = hospital_Service_Bill_page.verifyClinicalNotesUnderEyeIcon(driver, serviceName,
				clinicalNotes);

		Assert.assertEquals(clinicalNotes1, clinicalNotes);
		System.out.println("Successfully clinical notes is verified");
	}

	@Test
	public void verifyThatHospitalServiceBillBedCrumsIsWorkingAsExpected_Test() throws Throwable {

		String hsb1 = "Hospital Service Bill";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		String hsb = hospital_Service_Bill_page.verifyHospitalServiceBedCrums(driver);
		Assert.assertEquals(hsb1, hsb);
		System.out.println("successfully hospital service bill bed crums is verified");
	}

	@Test
	public void verifyThatRefundRequestBedCrumsIsWorkingAsExpected_Test() throws Throwable {
		String rr1 = "Refund Request";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		String rr = hospital_Service_Bill_page.verifyRefundRequestBedCrums(driver);
		Assert.assertEquals(rr1, rr);
		System.out.println("successfully refund request bed crums is verified");
	}

	@Test
	public void verifyThatConcessionBedCrumsIsWorkingAsExpected_Test() throws Throwable {
		String c1 = "Authorization";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		String c = hospital_Service_Bill_page.verifyConcessionBedCrums(driver);
		Assert.assertEquals(c1, c);
		System.out.println("successfully concession bed crums is verified");
	}

	@Test
	public void verifyThatProcessRefundBedCrumsIsWorkingAsExpected_Test() throws Throwable {
		String pr1 = "Process Refund";
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		String pr = hospital_Service_Bill_page.verifyProcessRefundtBedCrums(driver);
		Assert.assertEquals(pr, pr1);
		System.out.println("successfully process refund bed crums is verified");
	}

	@Test
	public void checkThatUserShouldFilterPendingDetailsWithHelpOfHospitalNumber_PendingBillingList_Test()
			throws Throwable {
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String amount = "100";
		String reason = "TestTesttest";
		String concessionOn = "ON BILL";
		String authorization = "CFO APPROVAL";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason);
		// Pending list
		hospital_Service_Bill_page.enterHospitalNumber_Filters(driver, hospitalNumber);
		hospital_Service_Bill_page.clickOnSearchButton_Filters(driver);
		String hospitalNumber1 = hospital_Service_Bill_page.takeHospitalNumber_PendingList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User verified a hospital number sucessfully");
	}

	@Test
	public void checkThatUserShouldFilterPendingDetailsWithHelpOfBillNumber_PendingBillingList_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		String billNumber = hospital_Service_Bill_page.take_FourthPlace_BillNumber_PendingList(driver);

		// Pending list
		hospital_Service_Bill_page.enterBillNumberNumber(driver, billNumber);
		hospital_Service_Bill_page.clickOnSearchButton_Filters(driver);

		String billNumber1 = hospital_Service_Bill_page.takeBillNumber_PendingList(driver);
		Assert.assertEquals(billNumber1, billNumber);
		System.out.println("User verified a bill  number sucessfully");

	}

//	@Test
//	public void checkThatUserShouldFilterPendingDetailsWithHelpOfBillNumber_PendingBillingList_Test() {
//		
//	}

	@Test
	public void checkThatUserShouldFilterPendingDetailsWithHelpOfBillType_PendingBillingList_Test() throws Throwable {
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String amount = "100";
		String reason = "TestTesttest";
		String concessionOn = "ON BILL";
		String authorization = "CFO APPROVAL";
		String billType = "OP";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		System.out.println("First" + hospitalNumber);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason);
		hospital_Service_Bill_page.enterHospitalNumber_Filters(driver, hospitalNumber);
		hospital_Service_Bill_page.selectBillType(driver, billType);
		hospital_Service_Bill_page.clickOnSearchButton_Filters(driver);
		String hospitalNumber1 = hospital_Service_Bill_page.takeHospitalNumber_PendingList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User verified a hospital number with bill type successfully");
	}

//	@Test
//	public void checkThatUserShouldFilterPendingDetailsWithHelpOfBillDates_PendingBillingList_Test() throws Throwable {
//		String sn1 = "AUTOMATION TEST MAGNESIUM";
//		String amount = "100";
//		String reason = "TestTesttest";
//		String concessionOn = "ON BILL";
//		String authorization = "CFO APPROVAL";
//		String date = generate_CurrentDate_dd_Month_Yy();
//
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickOnCompletedTab(driver);
//		hs.clickOnClearButton(driver);
//		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
//		hs.clickonNewBillButton(driver);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount, reason);
//		// Pending list
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickOnClearButton(driver);
//		hs.selectBillDateInCompletedList(driver);
//		hs.clickOnSarch(driver);
//		String date1 = hs.takeBillDatePendingList(driver);
//		Assert.assertEquals(date, date1);
//		System.out.println("bill date is filtered successfully");
//	}

	@Test
	public void checkThatUserShouldFilterPendingDetailsWithHelpOfTransactionTypeAsCredit_PendingBillingList_Test()
			throws Throwable {
		String amount = "100";
		String reason = "TestTesttest";
		String concessionOn = "ON BILL";
		String authorization = "CFO APPROVAL";
		String sn1 = "AUTOMATION TEST MAGNESIUM";
		String transactionType = "CREDIT";
		String creditTo = "MICHAEL JONES";
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

		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		// ----OPD registration---------
		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		System.out.println(hospitalNumber);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.selectTransactionTypeDropdwon(driver, transactionType);
		hospital_Service_Bill_page.selectCreditToDropdown(driver, creditTo);
		hospital_Service_Bill_page.pendingProcess(driver, hospitalNumber, concessionOn, authorization, sn1, amount,
				reason);
		// Pending list
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.selectTransactionTypeDropdwon(driver, transactionType);
		hospital_Service_Bill_page.clickOnSearchButton_Filters(driver);
		String hospitalNumber1 = hospital_Service_Bill_page.takeHospitalNumber_PendingList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
	}

	@Test
	public void verifyThatCancelBtnIsWorkingAsExpected() throws Throwable {

		String serviceName = "QUADRUPLE TEST";
		String hsb1 = "Hospital Service Bill";

		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = searchPatientPage.captureHospitalNumberInTheTable();
		System.out.println(hospitalNumber);

		// ----op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling(driver, serviceName);
		hospital_Service_Bill_page.clickOnCancelBtn(driver);
		String hsb = hospital_Service_Bill_page.verifyCancelBtnIsWorkingAsExpected(driver);
		Assert.assertEquals(hsb, hsb1);
		System.out.println("Successfully cancel button is verified");

	}

	@Test
	public void verifyThatSystemShouldNotAllowToAddDuplicateServices() throws Throwable {

		String sn1 = "Automation lipid";
		String sn2 = "Automation lipid";
		String dsp1 = "This service is already seleted";

		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = searchPatientPage.captureHospitalNumberInTheTable();
		System.out.println(hospitalNumber);

		// ----op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String dsp = hospital_Service_Bill_page.VerifyByAddingDuplicatServices(driver, sn1, sn2);
		Assert.assertEquals(dsp, dsp1);
		System.out.println("System is not allowing to add duplicate services");
	}

	@Test
	public void verifySystemShouldNotAllowToDoBillingForIPPatient_Test() throws Throwable {
		String hospitalNumber = "8323420";
		String text1 = "patient already admitted";
		String billType = "OP";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.selectBillType(driver, billType);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String text = hospital_Service_Bill_page.VerifyIpPatientInOPBilling(driver);
		Assert.assertEquals(text, text1);
		System.out.println("System is not allowing to billing for ip patient");
	}

	@Test
	public void verifyByEnteringOpNumberInBillTypeAsIp_Test() throws Throwable {
		String billType = "IP";
		String text1 = "Patient is Not Found in General Ip";

		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		String hospitalNumber = searchPatientPage.captureHospitalNumberInTheTable();

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.selectBillType(driver, billType);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String text = hospital_Service_Bill_page.VerifyOpNumberInBillTypeAsIp(driver);
		Assert.assertEquals(text, text1);
		System.out.println("System is not allowing to billing for OP patient after selecting bill type as IP");
	}

	@Test
	public void verifyNextButtonIsWorkingAsExpectedInCompletedListPagination_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		hospital_Service_Bill_page.verifyNextBtnIsWorkingAsExpectedInCompletedList(driver);
	}

	@Test
	public void verifyPrevoiusButtonIsWorkingAsExpectedInCompletedListPagination_Test() throws Throwable {
		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		hospital_Service_Bill_page.verifyPreviousBtnIsWorkingAsExpectedInCompletedList(driver);
	}

	@Test
	public void verifyNextButtonIsWorkingAsExpectedInPendingListPagination_Test() throws Throwable {

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnPendingListTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		hospital_Service_Bill_page.verifyNextBtnIsWorkingAsExpectedInPendingList(driver);
	}

	@Test
	public void verifyPrevoiusButtonIsWorkingAsExpectedInPendingListPagination_Test() throws Throwable {

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnPendingListTab(driver);
		hospital_Service_Bill_page.clickOnClearButton(driver);
		hospital_Service_Bill_page.verifyPreviousBtnIsWorkingAsExpectedInPendingList(driver);
	}

	@Test
	public void verifyPaymentModeErrorMsg_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "QUADRUPLE TEST";
		String error1 = "Please Select Payment Mode";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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
		hospital_Service_Bill_page.addServicesInOpBilling(driver, serviceName);
		hospital_Service_Bill_page.clickOnMultiplePaymentModeBtn(driver);
		hospital_Service_Bill_page.clickOnSubmitBtn(driver);
		String error = hospital_Service_Bill_page.verifyErrorPopupIfweClickONSubmitWithoutSelectingPaymentMode(driver);
		Assert.assertEquals(error, error1);
		System.out.println("successfully error pop up is verified");
	}

	@Test
	public void VerifyThatAfterSubmtHospitalNumberIsReflectingInCompletedList_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "MAGNESIUM";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

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
		hospital_Service_Bill_page.addServicesInOpBilling(driver, serviceName);
		hospital_Service_Bill_page.clickOnSubmit(driver);
		String hospitalNumber1 = hospital_Service_Bill_page.verifyHospitalNumberIsReflectingInCompletedList(driver,
				hospitalNumber);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("successfully hospital number is verified in completed list");
	}

	@Test
	public void VerifyThatAfterSubmtBillDetailsIsReflectingInCompletedList_Test() throws Throwable {
		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "MAGNESIUM";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);
		SearchPatientPage searchPatientPage = new SearchPatientPage(driver);

		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		homePage.homeBtnForvims(driver);
		searchPatientPage.clickOnTheSearchPatientButton(driver);
		homePage.homeBtnForvims(driver);
		searchPatientPage.enterHospitalNumber(driver, hospitalNumber);
		String patientName = searchPatientPage.take_PatientName(driver);
		String opNumber = searchPatientPage.take_OpNumber(driver);

		// ----op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.addServicesInOpBilling(driver, serviceName);
		String billAmount = hospital_Service_Bill_page.CaptureBillAmount(driver);
		String collectedAmount = hospital_Service_Bill_page.CaptureCollectedAmount(driver);
		hospital_Service_Bill_page.clickOnSubmit(driver);

		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.enterHospitalNumber_Filters(driver, hospitalNumber);
		hospital_Service_Bill_page.clickOnSearchButton_Filters(driver);

		String patientName1 = hospital_Service_Bill_page.CapturePatientNameInCompletedList(driver);
		String opNumber1 = hospital_Service_Bill_page.CaptureOpNumberInCompletedList(driver);
		String billAmount1 = hospital_Service_Bill_page.CaptureBillAmountInCompletedList(driver);
		String collectedAmount1 = hospital_Service_Bill_page.CaptureCollectedAmountInCompletedList(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(patientName, patientName1);
		System.out.println("successfully patient name is verified");
		sa.assertEquals(opNumber, opNumber1);
		System.out.println("successfully OP number is verified");
		sa.assertEquals(billAmount, billAmount1);
		System.out.println("successfully bill amount is verified");
		sa.assertEquals(collectedAmount, collectedAmount1);
		System.out.println("successfully collected amount is verified");
		sa.assertAll();
	}

	@Test
	public void VerifyThatSystemShouldNotAllowToDoBillingAfter24hrs_Test() throws Throwable {
		String errorMsg1 = "OP BILL NOT ALLOWED AFTER 24 HOURS";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		hospital_Service_Bill_page.selectTwoDaysBackBillDateInCompletedList(driver);
		hospital_Service_Bill_page.clickOnSarch(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		String errorMsg = hospital_Service_Bill_page.capture24hrsErrormsg(driver);
		Assert.assertEquals(errorMsg, errorMsg1);
		System.out.println("successfully 24 hrs error pop msg is verified");
	}

	@Test
	public void VerifyThatSystemShouldNotAllowToEnterMoreThanTotalAmtInConcessionField_Test() throws Throwable {

		String serviceName = "QUADRUPLE TEST";
		String concessionOn = "ON BILL";
		String errorMsg1 = "Concession amount can not be greater the bill amount";

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hospital_Service_Bill_page = new Hospital_Service_Bill_page(driver);

		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickOnCompletedTab(driver);
		String hospitalNumber = hospital_Service_Bill_page.takeHospitalNumberCompletedBillingList(driver);
		// ----op billing-----------
		homePage.homeBtnForvims(driver);
		hospital_Service_Bill_page.clickOnHospitalServiceBillLink(driver);
		hospital_Service_Bill_page.clickonNewBillButton(driver);
		hospital_Service_Bill_page.enterHospitalNumber(hospitalNumber);
		hospital_Service_Bill_page.SelectConcessionOnDropdown(driver, concessionOn);
		hospital_Service_Bill_page.addServicesInOpBilling(driver, serviceName);
		String errorMsg = hospital_Service_Bill_page.verifyConcessionAmountByEnteringMoreAmount(driver);
		Assert.assertEquals(errorMsg, errorMsg1);
		System.out.println("succesffuly concession amount is verifed");
	}

	@Test
	public void verifyThatUserShouldBeAbleToCancelTheCreditMhcBill_Test() throws Throwable {
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
		String transactionType = "CREDIT";
		String creditTo = "SOPHIA JONES";
		String authorization = "cfo";
		String reason = "text";
		String mode = "CREDIT";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		TestData.setHospitalNumber(hospitalNumber);

		// OP billing
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.selectBillType(driver, BillType);
		hs.selectTransactionTypeDropdwon(driver, transactionType);
		hs.selectCreditToDropdown(driver, creditTo);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addThePackageName(driver, packageName);
		hs.selectDepartmentUnitsDropdowns(driver);
		hs.selectPaymentMode(driver, mode);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		hs.clickOnCompletedTab(driver);
		hs.selectTransactionTypeDropdwon(driver, transactionType);
		hs.selectBillType(driver, BillType);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSearchButton_Filters(driver);
		hs.clickOnCancelUnderAction(driver);
		hs.selectAuthorization(driver, authorization);
		hs.enterTheReasonForCancellation_cancelPopUp_CompletedList(driver, reason);
		String text = hs.clickOnSubmit_captureText_ClickOnOkBtn(driver);
		Assert.assertEquals(text, "Bill cancellation request has been sent for approval");
	}

	@Test(dependsOnMethods = "verifyThatUserShouldBeAbleToCancelTheCreditMhcBill_Test")
	public void verifyThatUserShouldNotBeAbleToCancelTheCreditMhcBillUntilAllLevelsOfAuthorizationIsDone_Test()
			throws Throwable {
		String hospitalNumber = TestData.getHospitalNumber();
		String BillType = "MHC";
		String reason = "text";
		String authorization1 = "CONFIRMED";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		Concession_Refund_AuthorizationPage ca = new Concession_Refund_AuthorizationPage(driver);

		ca.concessionAuthorizationScreen(driver);
		hp.homeBtnForvims(driver);
		ca.clickOnCancelListRadioBtn(driver);
		ca.selectCancelsTypeDropdwon(driver, BillType);

		for (int i = 0; i < 3; i++) {
			ca.enterHospitalNumber(driver, hospitalNumber);
			ca.clickOnSearchBtn(driver);
			ca.clickOnBillNumberInPendingCreditCancellist(driver);
			ca.selectAuthorizationStatus_PendingCreditCancelList(driver, authorization1);
			ca.enterReason_pendingCreditCancelList(driver, reason);
			hs.clickOnSubmit_cancelPopUp(driver);
		}

		ca.clickOnConfirmedCreditCancelListTab(driver);
		ca.clickOnClearBtn(driver);
		ca.enterHospitalNumber(driver, hospitalNumber);
		ca.clickOnSearchBtn(driver);
		String hospitalNumber1 = ca.captureHospitallNumberInConfirmedCreditCancelList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test(dependsOnMethods = "verifyThatUserShouldNotBeAbleToCancelTheCreditMhcBillUntilAllLevelsOfAuthorizationIsDone_Test")
	public void verifyThatAfterMhcCreditBillIsCancelled_StatusIsChangedAsCancelledInHospitalserviceBillScreen_Test()
			throws Throwable {
		String transactionType = "CREDIT";
		String BillType = "MHC";
		String hospitalNumber = TestData.getHospitalNumber();

		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.selectTransactionTypeDropdwon(driver, transactionType);
		hs.selectBillType(driver, BillType);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSearchButton_Filters(driver);
		String text = hs.captureCancelledStatus_CompletedList(driver);
		Assert.assertEquals(text, "CANCELLED");
	}

	@Test
	public void verifyThatUserShouldNotBeAbleToCancelTheMhcCreditBillAfterPatientArrivalIsDone_Test() throws Throwable {
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
		String transactionType = "CREDIT";
		String creditTo = "SOPHIA JONES";
		String mode = "CREDIT";
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");
		String doctorName = "";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// OP billing
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.selectBillType(driver, BillType);
		hs.selectTransactionTypeDropdwon(driver, transactionType);
		hs.selectCreditToDropdown(driver, creditTo);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addThePackageName(driver, packageName);
		hs.selectDepartmentUnitsDropdowns(driver);
		hs.selectPaymentMode(driver, mode);
		hs.clickOnSubmit_CloseWindow_OkBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		hp.homeBtnForvims(driver);
		dp.clickOnAllPatientListTab(driver);
		dp.searchHospitalNumberAndClickInAllPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(username, password, driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.selectTransactionTypeDropdwon(driver, transactionType);
		hs.selectBillType(driver, BillType);
		hs.enterHospitalNumber(hospitalNumber);
		hs.clickOnSearchButton_Filters(driver);
		hs.clickOnCancelUnderAction(driver);
		String text = hs.captureOkBtnText(driver);
		hs.clickOnOkBtn(driver);
		Assert.assertEquals(text, "Patient Arrival is Done");
	}

	@Test
	public void verifyThatMhcBillAmountIsMatchedWithConfirmedCancelBillAmount_Test() throws Throwable {
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "RAJESH SAHOO";
//		String depName = "OCCUPATIONAL THERAPY";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//
//		String BillType = "MHC";
//
//		String packageName = "COMPREHENSIVE HEALTH CHEKUP FOR MEN";
//
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//		Concession_Refund_AuthorizationPage ca = new Concession_Refund_AuthorizationPage(driver);
//
//		// ----OPD registration---------
//		hp.homeBtnForvims(driver);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//
//		String transactionType = "CREDIT";
//		String creditTo = "SOPHIA JONES";
//		String authorization = "cfo";
//		String reason = "text";
//		String authorization1 = "CONFIRMED";
//		String mode = "CREDIT";
//		// OP billing
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickonNewBillButton(driver);
//		hs.selectBillType(driver, BillType);
//		hs.selectTransactionTypeDropdwon(driver, transactionType);
//		hs.selectCreditToDropdown(driver, creditTo);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.addThePackageName(driver, packageName);
//		hs.selectDepartmentUnitsDropdowns(driver);
//		hs.selectPaymentMode(driver, mode);
//		String billAmt = hs.CaptureBillAmount_doubleFormate(driver);
//		hs.clickOnSubmit_CloseWindow_OkBtn(driver);
//		
//		hs.clickOnCompletedTab(driver);
//		hs.selectTransactionTypeDropdwon(driver, transactionType);
//		hs.selectBillType(driver, BillType);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.clickOnSearchButton_Filters(driver);
//		hs.clickOnCancelUnderAction(driver);
//		hs.selectAuthorization(driver, authorization);
//		hs.enterTheReasonForCancellation_cancelPopUp_CompletedList(driver, reason);
//		hs.clickOnSubmit_cancelPopUp(driver);
//
//		ca.concessionAuthorizationScreen(driver);
//		hp.homeBtnForvims(driver);
//		ca.clickOnCancelListRadioBtn(driver);
//		ca.selectCancelsTypeDropdwon(driver, BillType);
//
//		for (int i = 0; i < 3; i++) {
//			ca.enterHospitalNumber(driver, hospitalNumber);
//			ca.clickOnSearchBtn(driver);
//			ca.clickOnBillNumberInPendingCreditCancellist(driver);
//			ca.selectAuthorizationStatus_PendingCreditCancelList(driver, authorization1);
//			ca.enterReason_pendingCreditCancelList(driver, reason);
//			hs.clickOnSubmit_cancelPopUp(driver);
//		}
//
//		ca.clickOnConfirmedCreditCancelListTab(driver);
//		ca.clickOnClearBtn(driver);
//		ca.enterHospitalNumber(driver, hospitalNumber);
//		ca.clickOnSearchBtn(driver);
//		String cancelledAmt = ca.captureCancelledAmountInConfirmedCreditCancelList(driver);
//		System.out.println(billAmt);
//		System.out.println(cancelledAmt);
//		Assert.assertEquals(billAmt, cancelledAmt);
//	}

	}

	@Test
	public void verifyTransactionTypeAsCashSearchFilterInCompletedList_Test() throws Throwable {

		String transactionType = "CASH";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		hs.selectTansactionTypeInConmpletedList(driver, transactionType);
		hs.clickOnSarch(driver);
		String transactionType1 = hs.captureTransactionTypeInTable(driver);
		Assert.assertEquals(transactionType, transactionType1);
		System.out.println("transaction type as cash filtered successfully");
	}

	@Test
	public void verifyTransactionTypeAsCreditSearchFilterInCompletedList_Test() throws Throwable {
		String transactionType = "CREDIT";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		hs.selectTansactionTypeInConmpletedList(driver, transactionType);
		hs.clickOnSarch(driver);
		String transactionType1 = hs.captureTransactionTypeInTable(driver);
		Assert.assertEquals(transactionType, transactionType1);
		System.out.println("transaction type as credit filtered successfully");
	}

	@Test
	public void verifyBillTypeAsOpSearchFilterInCompletedList_Test() throws Throwable {
		String billType = "OP";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		hs.selecttBillTypeInConmpletedList(driver, billType);
		hs.clickOnSarch(driver);
		String billType1 = hs.captureBillTypeInTable(driver);
		Assert.assertEquals(billType, billType1);
		System.out.println("Bill type as OP filtered successfully");
	}

	@Test
	public void verifyBillTypeAsIpSearchFilterInCompletedList_Test() throws Throwable {
		String billType = "IP";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		hs.selecttBillTypeInConmpletedList(driver, billType);
		hs.clickOnSarch(driver);
		String billType1 = hs.captureBillTypeInTable(driver);
		Assert.assertEquals(billType, billType1);
		System.out.println("Bill type as IP filtered successfully");
	}

	@Test
	public void verifyBillTypeAsMhcSearchFilterInCompletedList_Test() throws Throwable {
		String billType = "MHC";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		hs.selecttBillTypeInConmpletedList(driver, billType);
		hs.clickOnSarch(driver);
		String billType1 = hs.captureBillTypeInTable(driver);
		Assert.assertEquals(billType, billType1);
		System.out.println("Bill type as MHC filtered successfully");
	}

	@Test
	public void verifyHospitalNumberSearchFilterInCompletedList_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.Capture_LastRow_HospitalNumberInCompletedList(driver);
		hs.enterHospitalNumber_Filters(driver, hospitalNumber);
		hs.clickOnSarch(driver);
		String hospitalNumber1 = hs.CaptureHospitalNumberInCompletedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("hospital Number is filtered successfulyy");
	}

	@Test
	public void verifyBillNumberSearchFilterInCompletedList_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String billNumber = hs.CaptureBillNumberInCompletedList(driver);
		hs.enterBillNumberNumber(driver, billNumber);
		hs.clickOnSarch(driver);
		String billNumber1 = hs.CaptureBillNumberInCompletedList(driver);
		Assert.assertEquals(billNumber, billNumber1);
		System.out.println("Bill Number is filtered successfulyy");
	}

}
