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

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class LabTechnicianEntryForDescriptive extends BaseClass {

	@Test
	public void verifyLabTechnicianEntryForDescriptive_Test() throws Throwable {
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
		String receivedAtLab = "YES";

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
		String serviceName = "AUTOMATION ANCA PANEL";
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
		String serviceClass = "HAEMATOLOGY";

		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropDown_EnterHospitalNum_Search(driver, serviceClass, hospitalNumber);
		lt.LabTechnicianEntryForDescriptive(driver);

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.selectServiceClass(driver, serviceClass);
		df.doctorVerificationEntry(driver, hospitalNumber);

	}

	@Test
	public void verifyDraftedSampleInLabTechnicianEntryShouldReflectInPartialTabAndDoctorVerificationEntryScreen_Test()
			throws Throwable {

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
		String receivedAtLab = "YES";
		String serviceName = "AUTOMATION ANCA PANEL";
		String serviceClass = "HAEMATOLOGY";

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
		rsa.selectServiceClass(driver, serviceClass);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropDown_EnterHospitalNum_Search(driver, serviceClass, hospitalNumber);
		String hs1 = lt.verifDraftInLteScreen(driver, hospitalNumber, serviceClass);
		Assert.assertEquals(hospitalNumber, hs1);
		System.out.println("Successfully data verified in partial tab");

		// --------doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.selectServiceClass(driver, serviceClass);
		df.doctorVerificationEntry_For_Descriptive(driver, hospitalNumber);

	}

	@Test
	public void verifyDataInPartialTabIsRemovdAfterTestVerifyIsDone_Test() throws Throwable {
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
		String receivedAtLab = "YES";
		String serviceName = "AUTOMATION ANCA PANEL";
		String serviceClass = "HAEMATOLOGY";

		SampleCollectionPage sam = new SampleCollectionPage(driver);
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
		rsa.selectServiceClass(driver, serviceClass);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropDown_EnterHospitalNum_Search(driver, serviceClass, hospitalNumber);
		lt.verifDraftedSampleIsRemovedAfterTestverifyIsDone(driver, hospitalNumber, serviceClass);

	}

}