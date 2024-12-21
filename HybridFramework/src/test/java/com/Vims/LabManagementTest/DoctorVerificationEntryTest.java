package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorVerificationEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LabTechnicianEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;
import com.Dalvkot.Vims_ObjectRepositary.SendToLabPage;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorVerificationEntryTest extends BaseClass {
	@Test
	public void verifyDoctorVerificationEntrySuccessfullyCreated_Test() throws Throwable {

		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 1, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 1, 2);

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SendToLabPage sendToLab = new SendToLabPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow(driver, "");

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);

	}

	@Test
	public void verifyRetestForExisitingSampleInDoctorVerificationEntry_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 2, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 2, 2);
		String retestType = eutil.getDataFromTheExcel("DoctorVerification", 2, 3);

		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		df.retestInDoctorVerificationEntry(driver, retestType);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);
	}

	@Test
	public void verifyRetestForNewSampleInDoctorVerificationEntry_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 3, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 3, 2);
		String retestType = eutil.getDataFromTheExcel("DoctorVerification", 3, 3);

		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		df.retestInDoctorVerificationEntry(driver, retestType);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
	}

	@Test
	public void verifyCreatedDoctorVerificationEntryisDisplayingInVerifiedList_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		String samnum = df.doctorVerificationEntry(driver, hospitalNumber);
		df.clickOnVerfiedListTab(driver);
		String samNo = df.verifyVerifiedSampleNumberIsReflectingInVerifiedList(driver, hospitalNumber);
		Assert.assertEquals(samnum, samNo);
		System.out.println("data is reflecting in verified list after doctor verification entry is done");

	}

	@Test
	public void verifyTheNotesUnderEyeIconisUpdatingAccuratly_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);
		// -----Doctor verification Entry-----------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		df.verifyNotesUnderEyeIcon(driver);

	}

	@Test
	public void verifyTheViewPopupInDoctorVerificationEntryScreen_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		String serviceNa = lt.enterHospiatlNoAndClickOnSampleNumber(driver, hospitalNumber);
		lt.enterResultAndClickOntestVerify(driver);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		String sn = df.verifyserviceNameInViewPopup(driver);

//		String rv = df.verifyResultValueInViewPopup(driver);

		Assert.assertEquals("AUTOMATION TEST MAGNESIUM", sn);
		System.out.println("successfully verified view pop-up");

//		Assert.assertEquals(result, rv);
//		System.out.println("successfully result value is verified in view popup");
	}

	@Test
	public void verifyAmendentAndNotAmendentIsWorkingAsExpected_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --doctor verification entry----
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);
		df.clickOnVerfiedListTab(driver);
		String b = df.verifyVerifiedSampleNumberIsReflectingInVerifiedList2(driver, hospitalNumber);
		df.verifyAmendentIsWorkingAsExpected(driver);
		df.clickOnVerfiedListTab(driver);
		df.verifyVerifiedSampleNumberIsReflectingInVerifiedList1(driver, hospitalNumber);
		String a = df.verifyAmendentText(driver);
		Assert.assertEquals(b, "Not Amended");
		System.out.println("Not Amended verified successfully");
		Assert.assertEquals(a, "Amendment Done");
		System.out.println("Amendment done verified successfully");
	}

	@Test
	public void checkThatUserShouldVerifyTheListTableFilters_Test() throws Throwable {

	}
//	@Test
//
//	public void verifyNextRecordAndPreviousRecordBtnInDoctorVerificationEntry() throws Throwable {
//		HomePage hp =new HomePage(driver);
//		DoctorVerificationEntryPage df= new DoctorVerificationEntryPage(driver);
//		
//		String hospitalNumber="";
//		
//		hp.homeBtnForvims(driver);
//		df.clickOnDoctorVerificationEntryPage(driver);
//		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
//		df.verifyNextRecordBtnAndPreviousRecordBtn(driver);
//	}
//	

	@Test
	public void checkThatFilterTheDoctorVerifiedDetailsWithHelpOfSampleNumber_Test() throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = futil.getProperyKeyValue("doctorname");
		String depName = futil.getProperyKeyValue("depName");
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		HomePage homePage = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		// ----OPD registration---------
		homePage.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		homePage.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		homePage.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		homePage.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		String sampleNumber = rsa.takeSampleNumber(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// -------lab technician entryy----------------------------
		homePage.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --------doctor verification entry------------------------
		homePage.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		String samnum = df.doctorVerificationEntry(driver, hospitalNumber);
		df.clickOnVerfiedListTab(driver);

		df.enterSampleNumber(driver, sampleNumber);
		df.clickOnTheSearchButton(driver);
		String sampleNumber1 = df.takeSampleNumber_VerifiedList(driver);

		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println("User successfully filtered a sample details with help of sample number");
	}

	@Test
	public void checkThatFilterTheDoctorVerifiedDetailsWithHelpOfHospitalNumber_Test() throws Throwable {

		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);
		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);
		df.clickOnVerfiedListTab(driver);
		df.enterHospitalNumber(driver, hospitalNumber);
		df.clickOnTheSearchButton(driver);
		String hospitalNumber1 = df.takeHospitalNumber_VerificationList(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User filtered  hospital number in the veification list successfully");
	}

	@Test
	public void checkThatFilterTheDoctorVerifiedDetailsWithHelpOfDepartment_Test() throws Throwable {

		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String department = sam.takeDepartmentIn_SelectinCreteriaTable(driver);
		sam.billNumber_To_Submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.clickOnVerfiedListTab(driver);
		df.selectDepartmentName(driver, department);
		df.clickOnTheSearchButton(driver);
		String department1 = df.takeDepartment_VerificationList(driver);
		Assert.assertEquals(department1, department);
		System.out.println("User filtered  department  in the veification list successfully");
	}

	@Test
	public void checkThatFilterTheDoctorVerifiedDetailsWithHelpOfDoctorVeirfedDate_Test() throws Throwable {

		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		String selectionDate = currentDate();

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.clickOnVerfiedListTab(driver);
		df.enterTechnicianEntryDate(driver, selectionDate);
		df.clickOnTheSearchButton(driver);
		String selectionDate1 = df.takeDoctorVerifiedDate(driver);
		Assert.assertEquals(selectionDate1, selectionDate);
		System.out.println("User filtered   doctor verified date  in the veification list successfully");

	}

	@Test
	public void checkThatFilterTheDoctorVerifiedDetailsWithHelpOfServiceClass_Test() throws Throwable {
		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		String serviceClass = rsa.takeServiceClass_SampleList(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// --Lab techician entry
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.clickOnSearchButton(driver);
		lt.clickOn_SampleNumber_List(driver);
		lt.enterResultAndClickOntestVerify(driver);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.enterHospitalNumber(driver, hospitalNumber);
		df.selectServiceClass(driver, serviceClass);
		df.clickOnTheSearchButton(driver);
		df.clickOnSampleNumberListTechnician_DoctorverificationProcess(driver);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.clickOnVerfiedListTab(driver);
		df.enterHospitalNumber(driver, hospitalNumber);
		df.clickOnTheSearchButton(driver);
		df.clickOnAmendButton_VerifedList(driver);
		String serviceClass1 = df.takeServiceClassInTheSelectionDetails(driver);
		Assert.assertEquals(serviceClass1, serviceClass);
		System.out.println("User filtered   serviceClass  in the veification list successfully");

	}

	@Test
	public void toCheckThaUserShouldVerifyTheDoctorNameInTheVerifiedList_Test() throws Throwable {

		String receivedAtLab = eutil.getDataFromTheExcel("DoctorVerification", 4, 1);
		String serviceName = eutil.getDataFromTheExcel("DoctorVerification", 4, 2);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String doctorName = sam.takeDoctorNameSelectionDetailsTable(driver);
		sam.billNumber_To_Submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.clickOnVerfiedListTab(driver);
		df.enterHospitalNumber(driver, hospitalNumber);
		df.clickOnTheSearchButton(driver);
		String doctorName1 = df.takeDoctorName_VerificationList(driver);
		Assert.assertEquals(doctorName1, doctorName);
		System.out.println("User verified a doctor name in  the veification list successfully");

	}

///*	@Test
//	public void toCheckThaUserShouldVerifyThePatientNameInTheVerifiedList_Test() throws Throwable {
//
//		String receivedAtLab = "YES";
//		String serviceName = "AUTOMATION TEST MAGNESIUM";
//
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//		SampleCollectionPage sam = new SampleCollectionPage(driver);
//		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
//		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
//		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
////
////		hp.homeBtnForvims(driver);
////		hs.clickOnHospitalServiceBillLink(driver);
////		hs.clickOnCompletedTab(driver);
////		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
////		hs.clickonNewBillButton(driver);
////		hs.enterHospitalNumber(hospitalNumber);
////		hs.addOneServiceInTheOpBillin(driver, serviceName);
////		hs.clickOnSubmit(driver);
////
////		// -----sample collection---------
////		hp.homeBtnForvims(driver);
////		sam.clickOnSampleCollectionPage(driver);
////		sam.clickOnNewSampleButton(driver);
////		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
////		sam.clickOn_Search_Button_NewSamples(driver);
////		String patientName = sam.takePatientName_SelectionCreteria(driver);
////		sam.clickOnTheBillNumber_NewSample(driver);
////		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
////		sam.clickonAllViewbuttons_submit(driver);
////
////		// -----reciept sampler at lab-------------
////		hp.homeBtnForvims(driver);
////		rsa.clickOnReceiptAtSampleLabBtn(driver);
////		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);
////
////		// -------lab technician entryy----------------------------
////		hp.homeBtnForvims(driver);
////		lt.labtechnicianEntryPage(driver);
////		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);
//
//		String hospitalNumber = "8342792";
//		String patientName = "BLOOD";
//		// --------doctor verification entry------------------------
//		hp.homeBtnForvims(driver);
//		df.clickOnDoctorVerificationEntryPage(driver);
//		df.doctorVerificationEntry(driver, hospitalNumber);
//		df.clickOnCancelButton_SelectionDetails(driver);
//		df.clickOnVerfiedListTab(driver);
//		df.clickOnTheSearchButton(driver);
//		String patientName1 = df.takePatientName_verificationList(driver);
//		Assert.assertEquals(patientName1, patientName);
//		System.out.println("User verified a patient name in  the veification list successfully");
//	}

	@Test
	public void checkThatUserShouldSearchTechnicianVerifiedDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {
		DoctorVerificationEntryPage doctorVerificationEntryPage = new DoctorVerificationEntryPage(driver);
		HomePage hp = new HomePage(driver);

		doctorVerificationEntryPage.clickOnDoctorVerificationEntryPage(driver);
		hp.homeBtnForvims(driver);
		doctorVerificationEntryPage.clickOnClearButton(driver);
		String hospitalNumber = doctorVerificationEntryPage
				.capture_HospitalNumberLastRow_TechnicianVerifiedList(driver);
		doctorVerificationEntryPage.enterHospitalNumber(driver, hospitalNumber);
		doctorVerificationEntryPage.clickOnTheSearchButton(driver);
		String hospitalNumber1 = doctorVerificationEntryPage.takeHospitalNumber_TechnicianVerifiedList(driver);

		Assert.assertEquals(hospitalNumber, hospitalNumber1);

	}

	@Test
	public void checkThatUserShouldSearchTechnicianVerifiedDetailsWithHelpOf_SampleNumber_Test() throws Throwable {
		DoctorVerificationEntryPage doctorVerificationEntryPage = new DoctorVerificationEntryPage(driver);
		HomePage hp = new HomePage(driver);

		doctorVerificationEntryPage.clickOnDoctorVerificationEntryPage(driver);
		hp.homeBtnForvims(driver);
		doctorVerificationEntryPage.clickOnClearButton(driver);
		String SampleNumber = doctorVerificationEntryPage.takeSampleNumber_LastRow_TechnicainVerifiedList(driver);
		doctorVerificationEntryPage.enterSampleNumber(driver, SampleNumber);
		doctorVerificationEntryPage.clickOnTheSearchButton(driver);
		String SampleNumber1 = doctorVerificationEntryPage.takeSampleNumber_TechnicainVerifiedList(driver);
		Assert.assertEquals(SampleNumber1, SampleNumber);

	}

}
