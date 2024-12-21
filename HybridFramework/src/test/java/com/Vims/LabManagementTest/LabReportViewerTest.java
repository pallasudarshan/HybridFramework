package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorVerificationEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LabReportViwerPage;
import com.Dalvkot.Vims_ObjectRepositary.LabTechnicianEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;
import com.Dalvkot.Vims_ObjectRepositary.SendToLabPage;
import com.Dalvkot.Vims_ObjectRepositary.outSourceSampleListPage;

public class LabReportViewerTest extends BaseClass {

	@Test
	public void verifyThatAfterLabTechnicianEntryIsDoneSameHospitalNumberIsReflectingInLabReportViewer_Test()
			throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
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
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// -------Lab Report Viewer --------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		String hsptl = lrv.verifyLabTechnicianEntryIsDisplayingInLabReportViewer(driver, hospitalNumber);
		Assert.assertEquals(hospitalNumber, hsptl);
		System.out.println("successfully hospital Number is verifed in technician verified list");
	}

//
	@Test
	public void verifyThatAfterExternalLabServicesIsDoneSameHospitalNumberIsReflectingInLabReportViewer_Test()
			throws Throwable {
		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "RAMA";
		String depName = "GENERAL MEDICiNE";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String serviceName = "MAGNESIUM";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		outSourceSampleListPage ou = new outSourceSampleListPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);

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
		sam.sampleCollectionForExternalLabServices(driver, hospitalNumber);

		// -------out source lab -----------
		hp.homeBtnForvims(driver);
		ou.clickOnOutSourceLabPage(driver);
		ou.outSourceLabPage1(driver);

		// -------Lab Report Viewer --------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		String hsptl = lrv.verifyExternalLabServicesIsDisplayingInLabReportViewer(driver, hospitalNumber);
		Assert.assertEquals(hospitalNumber, hsptl);
		System.out.println("successfully hospital Number is verifed in external lab serivce list");

	}

	@Test
	public void verifyThatAfterDoctorVerifiedIsDoneSameHospitalNumberIsReflectingInLabReportViewer_Test()
			throws Throwable {

		String name = eutil.getDataFromTheExcel("DoctorVerification", 1, 3);
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String doctorname = "rama";
		String depName = "general medicine";
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);

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

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

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

		// --------Lab Report Viewer --------------------------------

		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		String hsptl = lrv.verifyDoctorVerifiedIsDisplayingInLabReportViewer(driver, hospitalNumber);
		Assert.assertEquals(hospitalNumber, hsptl);
		System.out.println("successfully hospital Number is verifed in doctor verified list");
	}

	@Test
	public void verifyThatSamePatientNameIsReflectingInLabReportViewer_Test() throws Throwable {

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

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

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// -----------doctor verification entry--------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		String pat1 = df.capturePatientNameInSelectionDetails(driver);
		df.clickOnDoctorVerifiedBtnAndOkBtn(driver, hospitalNumber);

		// ------------------------lab reporter viewer
		// --------------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		lrv.ClickONVerifeidTabAndSearchHospitalNumber(driver, hospitalNumber);
		String pat2 = lrv.capturePatientNameInReportViewer(driver);

		Assert.assertEquals(pat2, pat1);
		System.out.println("succcessfully patient name is verified");

	}

	@Test
	public void verifyThatSameSampleNoIsReflectingInLabReportViewer_Test() throws Throwable {

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
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// -----------doctor verification entry--------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		String sam1 = df.captureSampleNumberInSelectionDetails(driver);
		df.clickOnDoctorVerifiedBtnAndOkBtn(driver, hospitalNumber);

		// ------------------------lab reporter viewer
		// --------------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		lrv.ClickONVerifeidTabAndSearchHospitalNumber(driver, hospitalNumber);
		String sam2 = lrv.captureSampleNumberInReportViewer(driver);

		Assert.assertEquals(sam2, sam1);
		System.out.println("succcessfully sample number is verified");

	}

	@Test
	public void verifyThatSameServiceNameIsReflectingInLabReportViewer_Test() throws Throwable {

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

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

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// -----------doctor verification entry--------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		String hea = df.captureServiceNameInSelectionDetails(driver);
		df.clickOnDoctorVerifiedBtnAndOkBtn(driver, hospitalNumber);

		// ------------------------lab reporter viewer
		// --------------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		lrv.ClickONVerifeidTabAndSearchHospitalNumber(driver, hospitalNumber);
		String sampleName = lrv.captureSampleNameInReportViewer(driver);

		Assert.assertEquals(hea, sampleName);
		System.out.println("succcessfully sample name is verified");

	}

	@Test
	public void verifyThatSameResultIsReflectingInLabReportViewer_Test() throws Throwable {

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

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

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// -----------doctor verification entry--------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		String res = df.captureResultInSelectionDetails(driver);
		df.clickOnDoctorVerifiedBtnAndOkBtn(driver, hospitalNumber);

		// ------------------------lab reporter viewer
		// --------------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		lrv.ClickONVerifeidTabAndSearchHospitalNumber(driver, hospitalNumber);
		String result = lrv.captureResultInReportViewer(driver);

		Assert.assertEquals(res, result);
		System.out.println("succcessfully result is verified");

	}

	@Test
	public void verifyThatSameHospitalNumberIsReflectingInLabReportViewer_Test() throws Throwable {

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		LabReportViwerPage lrv = new LabReportViwerPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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
		String receivedAtLab = "YES";
		String serviceName = "MAGNESIUM";

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

		SendToLabPage sendToLab = new SendToLabPage(driver);
		// -------Send to lab -----------
		sendToLab.clickOnSendToLabScreenBtn(driver);
		hp.homeBtnForvims(driver);
		sendToLab.sendToLabFlow_2(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

		// -----------doctor verification entry--------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		String hsp1 = df.captureHospitalNumberInSelectionDetails(driver);
		df.clickOnDoctorVerifiedBtnAndOkBtn(driver, hospitalNumber);

		// ------------------------lab reporter viewer
		// --------------------------------------
		hp.homeBtnForvims(driver);
		lrv.clickOnLabReportViewerPageBtn(driver);
		lrv.ClickONVerifeidTabAndSearchHospitalNumber(driver, hospitalNumber);
		String hsp3 = lrv.captureHospitalNumberInReportViewer(driver);

		Assert.assertEquals(hsp1, hsp3);
		System.out.println("succcessfully hospital numsber is verified");

	}
}
