package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDesk_Ip_Page;
import com.Dalvkot.Vims_ObjectRepositary.DoctorVerificationEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LabTechnicianEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.PatientAdmissionPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)

public class LabTechnicianEntryTest extends BaseClass {

//	@Test
//
//	public void RecieptAtSampler() throws Throwable {
//		
//		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
//		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
//		
//		HomePage hp = new HomePage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		SearchPatientPage sp = new SearchPatientPage(driver);
//	    Hospital_Service_Bill_page hs=new Hospital_Service_Bill_page(driver);
//		LogOutPage l=new LogOutPage(driver);
//		LoginPage lp= new LoginPage(driver);
//	
//		
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName ="general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//	
//		
//		String un="medicine_rama2915@vimsmail.com";
//		String pw ="12345";
//		String notes="testing";
//		
//
//		String un1= "surya.V@dalvkot.com";
//		String pw1="123456";
//		
//		String receivedAtLab = "YES";
//		SampleCollectionPage sam =new SampleCollectionPage(driver);
//		
//		
//        //----OPD registration---------
//		hp.homeBtnForvims(driver);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,postOffice, depName, doctorname);
//		Thread.sleep(1000);
//		opdregistrationpage.submitAnd_ViewBtn(driver);
//		hp.homeBtnForvims(driver);
//		sp.clickOnTheSearchPatientButton(driver);
//
//		String hospitalNumber=sp.captureHospitalNumberInTheTable();
//		
//
//
//		l.logoutTheApplication(driver);
//		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
//		
//		//------add investigstion --------
//		hp.homeBtnForvims(driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);	
//		dp.clickOnMyPatientListTab(driver);
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnInvestigationTab(driver);
//		dp.clickOnNewBtnInInvestigationTab(driver);
//		dp.scrolldown(driver);
//		dp.addTheInvestigationsForLab(driver, notes);
//		dp.clickOnSubmitBtnInInvestigationsTab(driver);
//		l.logoutTheApplication(driver);
//		
//		
//		//----op billing-----------
//		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickonNewBillButton(driver);
//		hs.enterHospitalNumber(hospitalNumber);
//		Thread.sleep(2000);
//		hs.clickOnSubmit(driver);
//		String billNumber=hs.captureBillNoUnderCompletedTab(driver);
//		System.out.println(billNumber);
//		
//		//-----sample collection---------
//		hp.homeBtnForvims(driver);
//		sam.clickOnSampleCollectionPage(driver);
//		sam.sampleCollection(driver, hospitalNumber);
//		
//		//-----reciept sampler at lab-------------
//		hp.homeBtnForvims(driver);
//		rsa.clickOnReceiptAtSampleLabBtn(driver);
//		rsa.clickOnSelectionCheckBox_Table(driver);
//		rsa.clickOnNextButton(driver);
//		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
//		rsa.clickOnSubmitButton(driver);
//		rsa.clickOnOkButton(driver);
//	
//	}

	@Test
	public void verifyLabResultsBasedOnReferenceRange_Test() throws Throwable {
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
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
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
		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);
		// --------lab technician entry-------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabtechnicianEntryResult(driver, hospitalNumber);
	}

	@Test
	public void verifySampleNumInLabTechnicianEnteryScreen_Test() throws Throwable {
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
		String notes = "testing";
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// ------add investigstion --------
		hp.homeBtnForvims(driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addTheInvestigationsForLab(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		l.logoutTheApplication(driver);

		// ----op billing-----------
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		Thread.sleep(2000);
		hs.clickOnSubmit(driver);
		String billNumber = hs.captureBillNoUnderCompletedTab(driver);
		System.out.println(billNumber);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifySampleNumberInLabTechnicianEntryScreen(driver, hospitalNumber);

	}

	@Test
	public void verifyLabTechnicianEntryIsCreatedSuccessfully_Test() throws Throwable {

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
		String notes = "testing";
		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		String un = futil.getProperyKeyValue("un1");
		String pw = futil.getProperyKeyValue("pw1");
		String receivedAtLab = "YES";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);
		// ------add investigstion --------
		hp.homeBtnForvims(driver);
		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
		dp.clickOnMyPatientListTab(driver);
		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
		dp.clickOnPatientArrivalBtnAndSave(driver);
		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
		dp.clickOnInvestigationTab(driver);
		dp.clickOnNewBtnInInvestigationTab(driver);
		dp.scrolldown(driver);
		dp.addTheInvestigationsForLab(driver, notes);
		dp.clickOnSubmitBtnInInvestigationsTab(driver);
		l.logoutTheApplication(driver);
		// ----op billing-----------
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		Thread.sleep(2000);
		hs.clickOnSubmit(driver);
		String billNumber = hs.captureBillNoUnderCompletedTab(driver);
		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);

	}

	@Test
	public void verifyRetestForExistingSampleInLabTechnicianEntry_Test() throws Throwable {
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

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		// ----op billing-----------
		String serviceName = "MAGNESIUM";
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
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		// ----lab technician entry-------
		lt.labtechnicianEntryPage(driver);
		lt.searchhospitalNumnberAndClickOnSampleNumberInthetable(driver, hospitalNumber);
		String sampleNum = lt.captureSampleNumberInSelectionDetailsSection(driver);
		lt.verifyRetestForExistingSampleInLabTechnicianEntry(driver);
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		String sampleNumber = rsa.takeSampleNumber(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		Assert.assertEquals(sampleNum, sampleNumber);
		System.out.println("Succesfully retest for existing sample is verified");
	}

	@Test
	public void verifyRetestForNewSampleInLabTechnicianEntryWithColourCountAndRetestReason_Test() throws Throwable {

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
		String serviceName = "AUTOMATION TEST MAGNESIUM";
		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInOpBilling(driver, serviceName);
		hs.clickOnSubmit(driver);
		int numberOfIterations = 3;
		int counter = 0;
		while (counter < numberOfIterations) {
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
			lt.searchhospitalNumnberAndClickOnSampleNumberInthetable(driver, hospitalNumber);
			lt.verifyRetestForNewSampleInLabTechnicianEntry(driver);
			counter++;
		}
		// --------sample collection -------------------------
		String re = "Retest  - CLOTTED BLOOD SAMPLE  3";
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		String ret = sam.verifySampleCollectionRetestForNewSample(driver, hospitalNumber);
		Assert.assertEquals(re, ret);
		System.out.println("Successfully retest reason and count is verified");

	}

	@Test
	public void ClickOnSubmitWithoutEnteringResult_Test() throws Throwable {

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		lt.labtechnicianEntryPage(driver);
		lt.clickOnClearBtn_Filters(driver);
		lt.clickOn_SampleNumber_List(driver);
		lt.verifyByClickingOnSubmitWithoutEnteringResult(driver);

	}

	@Test
	public void verifyDataIsReflectingInPartialTab_Test() throws Throwable {
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
		String sn1 = "AFB - CYTO";
		String sn2 = "PAS - CYTO";
		String sn3 = "ALCIAN BLUE - CYTO";
		String serviceClass = "CYTOLOGY";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
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
		hs.addServicesInOpBilling2(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);
		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);
		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropDown_EnterHospitalNum_Search(driver, serviceClass, hospitalNumber);
		lt.verifyPartialList(driver, hospitalNumber, serviceClass);
	}

	@Test
	public void verifyViewResultInLabTechnicianEntry_Test() throws Throwable {
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		String receivedAtLab = "YES";
//		String serviceName = "Ammonia";
//
//		SampleCollectionPage sam = new SampleCollectionPage(driver);
//		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
//		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//
//		// ----OPD registration---------
//		hp.homeBtnForvims(driver);
//		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
//		opdregistrationpage.opdRegistrationButton(driver);
//		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
//				postOffice, depName, doctorname);
//		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
//
//		// ------OP billing--------------
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickonNewBillButton(driver);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.addServicesInOpBilling(driver, serviceName);
//		hs.clickOnSubmit(driver);
//
//		// -----sample collection---------
//		hp.homeBtnForvims(driver);
//		sam.clickOnSampleCollectionPage(driver);
//		sam.sampleCollection(driver, hospitalNumber);
//
//		// -----reciept sampler at lab-------------
//		hp.homeBtnForvims(driver);
//		rsa.clickOnReceiptAtSampleLabBtn(driver);
//		rsa.enterHospitalNumber(driver, hospitalNumber);
//		rsa.clickOnTheSearchButton(driver);
//		rsa.clickOnSelectionCheckBoxs_Table(driver);
//		rsa.clickOnNextButton(driver);
//		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
//		rsa.clickOnSubmitButton(driver);
//		rsa.clickOnOkButton(driver);
//
//		// -------lab technician entryy----------------------------
//		hp.homeBtnForvims(driver);
//		lt.labtechnicianEntryPage(driver);
//		String serviceNa = lt.enterHospiatlNoAndClickOnSampleNumber(driver, hospitalNumber);
//		String result = lt.enterResultAndClickOntestVerify(driver);
//
//		// --------OP Billing---------------------------------------
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickonNewBillButton(driver);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.addServicesInOpBilling(driver, serviceName);
//		hs.clickOnSubmit(driver);
//
//		// -----sample collection-------------------------------------
//		hp.homeBtnForvims(driver);
//		sam.clickOnSampleCollectionPage(driver);
//		sam.sampleCollection(driver, hospitalNumber);
//
//		// -----reciept sampler at lab-------------
//		hp.homeBtnForvims(driver);
//		rsa.clickOnReceiptAtSampleLabBtn(driver);
//		rsa.enterHospitalNumber(driver, hospitalNumber);
//		rsa.clickOnTheSearchButton(driver);
//		rsa.clickOnSelectionCheckBoxs_Table(driver);
//		rsa.clickOnNextButton(driver);
//		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
//		rsa.clickOnSubmitButton(driver);
//		rsa.clickOnOkButton(driver);
//
//		// -------lab technician entryy----------------------------
//		hp.homeBtnForvims(driver);
//		lt.labtechnicianEntryPage(driver);
//		lt.EnterHospitalNoAndSearch_ClickOnSampleNo(driver, hospitalNumber);
//		lt.clickOnViewBtnUnderPreviewResult(driver);
//		String sn1 = lt.captureServiceNameInViewPopUp(driver);
//		String res = lt.captureResultInViewPopUp(driver);
//
//		Assert.assertEquals(serviceNa, sn1);
//		System.out.println("Successfully service name is verified in previous results pop up");
//
//		Assert.assertEquals("25", res);
//		System.out.println("Successfully result is verified in previous results pop up");
	}

	@Test
	public void verifyAfterLabTechnicianEntryDataIsReflectingInDDOPD_Test() throws Throwable {
//		String name = "S";
//		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
//		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
//		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
//		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
//		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
//		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
//		String doctorname = "rama";
//		String depName = "general medicine";
//		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);
//		String un1 = "medicine_rama1234@vimsmail.com";
//		String pw1 = "12345";
//		String receivedAtLab = "YES";
//		String serviceName = "AUTOMATION TEST MAGNESIUM";
//
//		SampleCollectionPage sam = new SampleCollectionPage(driver);
//		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
//		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//		LogOutPage l = new LogOutPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		DoctorDeskOpdPage dp = new DoctorDeskOpdPage(driver);
//		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
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
//		// ----op billing-----------
//		hp.homeBtnForvims(driver);
//		hs.clickOnHospitalServiceBillLink(driver);
//		hs.clickonNewBillButton(driver);
//		hs.enterHospitalNumber(hospitalNumber);
//		hs.addServicesInOpBilling(driver, serviceName);
//		hs.clickOnSubmit(driver);
//
//		// -----sample collection---------
//		hp.homeBtnForvims(driver);
//		sam.clickOnSampleCollectionPage(driver);
//		sam.sampleCollection(driver, hospitalNumber);
//
//		// -----reciept sampler at lab-------------
//		hp.homeBtnForvims(driver);
//		rsa.clickOnReceiptAtSampleLabBtn(driver);
//		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);
//
//		// -------lab technician entryy----------------------------
//		hp.homeBtnForvims(driver);
//		lt.labtechnicianEntryPage(driver);
//		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);
//		hp.homeBtnForvims(driver);
//		df.clickOnDoctorVerificationEntryPage(driver);
//		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
//		String sam2 = df.captureSampleNumberInSelectionDetails(driver);
//		System.out.println(sam2);
//		String hea = df.captureServiceNameInSelectionDetails(driver);
//		System.out.println(hea);
//		df.scrollDown(driver);
//		String res = df.captureResultInSelectionDetails(driver);
//		System.out.println(res);
//		String ref = df.captureRefernceRangeInSelectionDetails(driver);
//		System.out.println(ref);
//
//		l.logoutTheApplication(driver);
//
//		// --------------DD OPD-----------
//		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);
//		hp.homeBtnForvims(driver);
//		dp.clickOnTheDoctorDeskOpdScreenButton(driver);
//		dp.clickOnMyPatientListTab(driver);
//
//		dp.clickOnHospitalNumberInTheMyPatientList(driver, hospitalNumber);
//		dp.clickOnPatientArrivalBtnAndSave(driver);
//		dp.clickOnUpdatedPatientArrivalStatusPopUP(driver);
//		dp.clickOnLabResultTab(driver);
//
//		String sam1 = dp.captureSampleNumberInLabTab(driver);
//		System.out.println(sam1);
//		String sn1 = dp.captureServiceNameInLabTab(driver);
//		System.out.println(sn1);
//		String pt1 = dp.captureResultValueInLabTab(driver);
//		System.out.println(pt1);
//		String ref1 = dp.captureReferencerangeInLabTab(driver);
//		System.out.println(ref1);
//
//		Assert.assertEquals(sam2, sam1);
//		System.out.println("succcessfully sample number verified");
//
//		Assert.assertEquals(sn1, hea);
//		System.out.println("succcessfully service name verified");
//
//		Assert.assertEquals(res, pt1);
//		System.out.println("succcessfully result value verified");
//
//		Assert.assertEquals(ref, ref1);
//		System.out.println("succcessfully reference range verified");

	}

	@Test
	public void toVerifyThePreviouRecordButtonIsWorkingAsExpected_Test() throws Throwable {
		String receivedAtLab = "YES";
		String sn1 = "SPOT URINARY MICROALBUMIN";
		String sn2 = "CSF CALCIUM";
		String sn3 = "HDL CHOLESTEROL";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		sam.clickonAllViewbuttons_submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String lastRowSampleNumber = lt.takeLastRowSampleNumber_ListTable(driver);
		lt.enterSampleNumber(driver, lastRowSampleNumber);
		lt.clickOnSearchButton(driver);
		lt.clickOn_SampleNumber_List(driver);
		lt.previousButtonVerifcation(driver);
	}

	@Test
	public void toVerifyTheNextRecordButtonIsWorkingAsExpected_Test() throws Throwable {
		String receivedAtLab = "YES";

		String sn1 = "SPOT URINARY MICROALBUMIN";
		String sn2 = "CSF CALCIUM";
		String sn3 = "HDL CHOLESTEROL";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnLast_Row_BillNumber_NewSamples(driver);
		sam.clickOnAllViewButtons_And_Submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectAllCheckBoxs_ReceiptSampleProcess(driver, hospitalNumber, receivedAtLab);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String firstRowSampleNumber = lt.takeSampleNumber_ListTable(driver);
		lt.enterSampleNumber(driver, firstRowSampleNumber);
		lt.clickOnSearchButton(driver);
		lt.clickOn_SampleNumber_List(driver);
		lt.nextButttonVerification(driver);
	}

	@Test(description = "Verify the blinking notification in the lab technician's entry on sample number, when patient name and age have been edited in the OPD registration")
	public void checkTheBlinkingNotificationInSampleNumberIfNameAndAgeEditedInOpdRegistration_Test() throws Throwable {
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
		String serviceName = "Lipid Profile";
		String receivedAtLab = "YES";
		String name1 = "test";
		String age = "76";

		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SearchPatientPage sp = new SearchPatientPage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);
		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);
		// search page
		sp.clickOnTheSearchPatientButton(driver);
		hp.homeBtnForvims(driver);
		sp.rightClickOnHospitalNumberAndClickonEdit_Table(driver);
		Thread.sleep(11000);
		opdregistrationpage.enterFirstName(driver, name1);
		opdregistrationpage.enterAge(driver, age);
		opdregistrationpage.clickOnSubmit(driver);
		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
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
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		lt.checkThatBlinklingCircleIsDisplayingOrNot(driver);
	}

	@Test(priority = 1)
	public void checkThatUserShouldAbleToFilterSamplesDetailsWithHelpOfSamplenumberFieldListTable_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// ---Lab technician entry----
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.clickOnClearBtn_Filters(driver);
		String sampleNumber = lt.take_LastRow_SampleNumber_ListTable(driver);
		lt.enterSampleNumber(driver, sampleNumber);
		lt.clickOnSearchButton(driver);
		String sampleNumber1 = lt.takeSampleNumber_ListTable(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println("User filtered a patient details with help of sample number successfully");
	}

	@Test(priority = 2)
	public void checkThatUserShouldAbleToFilterSamplesDetailsWithHelpOfHospitalNumberFieldListTable_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// --Lab techician entry
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.clickOnClearBtn_Filters(driver);

		String hospitalNumber = lt.takeHospitalNumber_LastRow_ListTable(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);

		String hospitalNumber1 = lt.takeHospitalNumber_ListTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println("User filtered a patient details with help of hospital number successfully");
	}

	@Test
	public void checkThatUserShouldAbleToFilterSamplesDetailsWithHelpOfServiceClassFieldListTable_Test()
			throws Throwable {

		String receivedAtLab = "YES";
		String serviceName = "AUTOMATION TEST MAGNESIUM";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
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
		String serviceClass1 = lt.takeServiceClass_SelectionDetails(driver);
		Assert.assertEquals(serviceClass1, serviceClass);
		System.out.println("User filtered a patient details with help of service class  successfully");
	}

	@Test
	public void checkThatUserShouldAbleToFilterSamplesDetailsWithHelpOfSelctionDateFieldListTable_Test()
			throws Throwable {

		String receivedAtLab = "YES";
		String serviceName = "AUTOMATION TEST MAGNESIUM";
		String selectionDate = currentDate();

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
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

		// --Lab techician entry---
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.enterSelectionDate(driver, selectionDate);
		lt.clickOnSearchButton(driver);
		String selectionDate1 = lt.takeSampleDate_ListTable(driver);
		Assert.assertEquals(selectionDate1, selectionDate);
		System.out.println("User filtered a patient details with help of selection date[sample date] successfully");
	}

	@Test
	public void checkThatUserShouldAbleToFilterSamplesDetailsWithHelpOfDepartmentNameFieldListTable_Test()
			throws Throwable {

		String receivedAtLab = "YES";
		String serviceName = "AUTOMATION TEST MAGNESIUM";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
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
		rsa.ReceiptAtSampleLab(driver, hospitalNumber, receivedAtLab);

		// --Lab techician entry---
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectDepartmentNameDropdown(driver, department);
		lt.clickOnSearchButton(driver);
		String department1 = lt.takeDepartment_ListTable(driver);
		Assert.assertEquals(department1, department);
		System.out.println("User filtered a patient details with help of department name successfully");
	}

	@Test
	public void checkThatUserShouldAbleToVerifyDoctorNameInTheListTable_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// --Lab techician entry
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.clickOnClearBtn_Filters(driver);
		String hospitalNumber = lt.takeHospitalNumber_LastRow_ListTable(driver);
		String doctorName = lt.takeDoctorName_LastRow_ListTable(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.takeDoctorName_ListTable(driver);
		lt.clickOnSearchButton(driver);
		String doctorName1 = lt.takeDoctorName_ListTable(driver);
		Assert.assertEquals(doctorName1, doctorName);
		System.out.println("User verified a doctor name in the list table successfully");
	}

	@Test
	public void checkThatUserShouldAbleToVerifySampleTypeInTheListTable_Test() throws Throwable {
		String serviceName = "AUTOMATION TEST MAGNESIUM";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
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
		rsa.hospitalNumber_Search_SelectionOneSample_Next(driver, hospitalNumber);
		String sampleType = rsa.takeSampleType_SampleList(driver);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// --Lab techician entry---
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String sampleType1 = lt.takeSampleType_ListTable(driver);
		Assert.assertEquals(sampleType1, sampleType);
		System.out.println("User verified a sample type  in the list table successfully");

	}

	@Test
	public void checkThatUserShouldAbleToVerifyOPNumberInTheListTable_Test() throws Throwable {
		String serviceName = "AUTOMATION TEST MAGNESIUM";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
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
		String opNumber = rsa.takeOp_Ip_Number(driver);
		rsa.selectionOneSample_Next_Submit_OkPopup(driver);

		// --Lab techician entry---
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String opNumber1 = lt.takeOP_IpNumber_ListTable(driver);
		Assert.assertEquals(opNumber1, opNumber);
		System.out.println("User verified a op number  in the list table successfully");
	}

	@Test
	public void checkThatUserShouldAblToFilter_SearchSampleDetailsWithHelpOfSampleNumberInThePartialList_Test()
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
		String sn1 = "AFB - CYTO";
		String sn2 = "PAS - CYTO";
		String sn3 = "ALCIAN BLUE - CYTO";
		String serviceClass = "CYTOLOGY";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

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
		hs.addServicesInOpBilling2(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollection(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		String sampleNumber = rsa.takeSampleNumber(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		System.out.println(hospitalNumber);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.clickOnClearBtn_Filters(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterSampleNumber(driver, sampleNumber);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		lt.clickOn_SampleNumber_List(driver);
		lt.enterResults_clickOnDrafButton(driver);

		lt.labtechnicianEntryPage(driver);
		hp.homeBtnForvims(driver);
		lt.clickOnPartialTab(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterSampleNumber(driver, sampleNumber);
		lt.clickOnSearchButton(driver);
		String sampleNumber1 = lt.takeSampleNumber_PartialTable(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println(
				"User filtered a patient details with help of sample number in the partial table  successfully");
	}

	@Test
	public void checkThatUserShouldAblToFilter_SearchSampleDetailsWithHelpOfHospitalNumberInThePartialList_Test()
			throws Throwable {

		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// -------lab technician entry----------------------------
		lt.labtechnicianEntryPage(driver);
		hp.homeBtnForvims(driver);
		lt.clickOnPartialTab(driver);
		lt.clickOnClearBtn_Filters(driver);
		String hospitalNumber = lt.takeHospitalNumber_LastRow_PartialTable(driver);
		lt.enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String hospitalNumber1 = lt.takeHospitalNumber_PartialTable(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);
		System.out.println(
				"User filtered a patient details with help of hospital  number in the partial table  successfully");
	}

	@Test
	public void checkThatUserShouldAblToFilter_SearchSampleDetailsWithHelpOfServiceClassInThePartialList_Test()
			throws Throwable {
		String receivedAtLab = "YES";

		String sn1 = "AFB - CYTO";
		String sn2 = "PAS - CYTO";
		String sn3 = "ALCIAN BLUE - CYTO";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnTheBillNumber_NewSample(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickonAllViewbuttons_submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		lt.clickOn_SampleNumber_List(driver);
		lt.enterResults_selectTwoCheckboxs_clickOnTestVerfiyBtn(driver);

		lt.clickOnPartialTab(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		lt.clickOnSampleNumber_Partial(driver);
		String serviceClass1 = lt.takeServiceClass_SelectionDetails(driver);
		Assert.assertEquals(serviceClass1, serviceClass1);
		System.out.println(
				"User filtered a patient details with help of service class  in the partial table  successfully");
	}

	@Test
	public void checkThatUserShouldAblToFilter_SearchSampleDetailsWithHelpOfDepartmentNameInThePartialList_Test()
			throws Throwable {
		String receivedAtLab = "YES";

		String sn1 = "AFB - CYTO";
		String sn2 = "PAS - CYTO";
		String sn3 = "ALCIAN BLUE - CYTO";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		String departmentName = sam.takeDepartmentIn_SelectinCreteriaTable(driver);
		sam.clickOnTheBillNumber_NewSample(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickonAllViewbuttons_submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		lt.clickOn_SampleNumber_List(driver);
		lt.enterResults_selectTwoCheckboxs_clickOnTestVerfiyBtn(driver);

		lt.clickOnPartialTab(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String departmentName1 = lt.takeDepartment_PartialTable(driver);
		Assert.assertEquals(departmentName1, departmentName);
		System.out.println(
				"User filtered a patient details with help of department name  in the partial table  successfully");
	}

	@Test
	public void checkThatUserShouldAbleToVerifySampleTypeInThePartialTable_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// -------lab technician entry----------------------------
		lt.labtechnicianEntryPage(driver);
		hp.homeBtnForvims(driver);

		lt.clickOnPartialTab(driver);
		lt.clickOnClearBtn_Filters(driver);
		String sampleType = lt.takeSampleType_LastRow_PartialTable(driver);
		String hospitalNumber = lt.takeHospitalNumber_LastRow_PartialTable(driver);

		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String sampleType1 = lt.takeSampleType_PartialTable(driver);
		Assert.assertEquals(sampleType1, sampleType);
		System.out.println("User verified a sample type in the partial table successfully");

	}

	@Test
	public void cheeckThatUserShouldAbleToVerifyPatientNameInThePartialTable_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.clickOnPartialTab(driver);

		lt.clickOnClearBtn_Filters(driver);
		String patientName = lt.takePatientName_LastRow_PartialTable(driver);
		String hospitalNumber = lt.takeHospitalNumber_LastRow_PartialTable(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String patientName1 = lt.takePatientName_PartialTable(driver);
		Assert.assertEquals(patientName1, patientName);
		System.out.println("User verified a patient name  in the partial table successfully");
	}

	@Test
	public void checkThatUserShouldAbleToVerifyDoctorNameInThePartialTable_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.clickOnPartialTab(driver);
		lt.clickOnClearBtn_Filters(driver);
		String doctorName = lt.takeDoctor_LastRow_PartialTable(driver);
		String hospitalNumber = lt.takeHospitalNumber_LastRow_PartialTable(driver);
		lt.enterHospitalNumber_List_Partial(driver, hospitalNumber);
		lt.clickOnSearchButton(driver);
		String doctorName1 = lt.takeDoctor_PartialTable(driver);
		Assert.assertEquals(doctorName1, doctorName);
		System.out.println("User verified a Doctor name  in the partial table successfully");
	}

	@Test
	public void checkThatUserShouldAbleToFilterSamplesDetailsWithHelpOfSelctionDateFieldPartialTable_Test()
			throws Throwable {

		String selectionDate = currentDate();
		String receivedAtLab = "YES";
		String sn1 = "AFB - CYTO";
		String sn2 = "PAS - CYTO";
		String sn3 = "ALCIAN BLUE - CYTO";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		hp.homeBtnForvims(driver);
		hs.clickOnHospitalServiceBillLink(driver);
		hs.clickOnCompletedTab(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addServicesInThreeServicesInTheOpBilling(driver, sn1, sn2, sn3);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnNewSampleButton(driver);
		sam.enter_HopsitalNumber_NewSample(driver, hospitalNumber);
		sam.clickOn_Search_Button_NewSamples(driver);
		sam.clickOnTheBillNumber_NewSample(driver);
		String serviceClass = sam.takeServiceClassName_ServiceDetailsTable(driver);
		sam.clickonAllViewbuttons_submit(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		rsa.selectReceivedAtLabAllDropdownsButtons(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// -------lab technician entry----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		lt.clickOn_SampleNumber_List(driver);
		lt.enterResults_selectTwoCheckboxs_clickOnTestVerfiyBtn(driver);

		lt.clickOnPartialTab(driver);
		lt.selectServiceClassDropdown(driver, serviceClass);
		lt.enterSelectionDate(driver, selectionDate);
		lt.clickOnSearchButton(driver);
		String selectionDate1 = lt.takeSampleDate_PartialTable(driver);
		Assert.assertEquals(selectionDate1, selectionDate);
		System.out.println(
				"User filtered a patient details with help of selection date  in the partial table  successfully");
	}

	@Test
	public void verifyThatUserShouldBeAbleToCreateSampleCollectionForIpPatientSuccessfully_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRIAGE";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRIAGE";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";

		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);

		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// ---------add investigations--------
		hp.homeBtnForvims(driver);
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);
		String inv1 = "automation test magnesium";
		ipd.addTheInvestigationForLabFlow(driver, inv1, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		l.logoutTheApplication(driver);

		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollectionForOneSample1(driver, hospitalNumber);
		System.out.println("Successfully sample collection is created for ip patient");

	}

	@Test
	public void verifyThatUserShouldBeAbleToCreateRecieptSamplerAtLabForIpPatientSuccessfully_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRIAGE";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRIAGE";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";

		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);

		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// ---------add investigations--------
		hp.homeBtnForvims(driver);
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);
		String inv1 = "automation test magnesium";
		ipd.addTheInvestigationForLabFlow(driver, inv1, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		l.logoutTheApplication(driver);

		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollectionForOneSample1(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		String receivedAtLab = "yes";
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		System.out.println("Successfully reciept sampler at lab is created for ip patient");

	}

	@Test
	public void verifyThatUserShouldBeAbleToCreateLabTechnicianEntryForIpPatientSuccessfully_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRIAGE";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRIAGE";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";

		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);

		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// ---------add investigations--------
		hp.homeBtnForvims(driver);
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);
		String inv1 = "automation test magnesium";
		ipd.addTheInvestigationForLabFlow(driver, inv1, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		l.logoutTheApplication(driver);

		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollectionForOneSample1(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		String receivedAtLab = "yes";
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// -------lab technician entryy----------------------------
		hp.homeBtnForvims(driver);
		lt.labtechnicianEntryPage(driver);
		lt.verifyLabTechnicianEntryCreatedSuccessfully(driver, hospitalNumber);
		System.out.println("Successfully lab technician entry is done for ip patient");

	}

	@Test
	public void verifyThatUserShouldBeAbleToDoDoctorVerificationEntryEntryForIpPatientSuccessfully_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRIAGE";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRIAGE";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";

		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);

		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// ---------add investigations--------
		hp.homeBtnForvims(driver);
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);
		String inv1 = "automation test magnesium";
		ipd.addTheInvestigationForLabFlow(driver, inv1, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		l.logoutTheApplication(driver);

		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollectionForOneSample1(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		String receivedAtLab = "yes";
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
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
		System.out.println("Successfully Doctor verification entry is done for ip patient");

	}

	@Test
	public void verifyThatUserShouldBeAbleToDoSecondDoctorVerificationEntryEntryForIpPatientSuccessfully_Test()
			throws Throwable {
		HomePage hp = new HomePage(driver);
		LogOutPage l = new LogOutPage(driver);
		LoginPage lp = new LoginPage(driver);
		DoctorDesk_Ip_Page ipd = new DoctorDesk_Ip_Page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		String doctorname = "SURESH";
		String depName = "NEUROLOGY";
		String wardType = "GENERAL WARD";
		String bedCategory = "NON TEACHING";
		String bedWardType = "GENERAL WARD";
		String bedRoomType = "C19 TRIAGE";
		String floor = "4TH FLOOR";
		String wings = "EAST WING";
		String bedUnitDepartment = "1";
		String roomType = "C19 TRIAGE";
		String admittedByDr = "DR.ABBAS";
		String time = "1230";

		String un = "neurology_suresha1234@vimsmail.com";
		String pw = "123456";
		String notes = "testing";

		String name = "S";
		String year = eutil.getDataFromTheExcel("Opdreg1", 2, 5);
		String fname = eutil.getDataFromTheExcel("Opdreg1", 2, 6);
		String mobilenum = eutil.getDataFromTheExcel("Opdreg1", 2, 7);
		String mail = eutil.getDataFromTheExcel("Opdreg1", 2, 8);
		String address = eutil.getDataFromTheExcel("Opdreg1", 2, 9);
		String pincode = eutil.getDataFromTheExcel("Opdreg1", 2, 10);
		String postOffice = eutil.getDataFromTheExcel("Opdreg1", 2, 14);

		// ----OPD registration---------
		hp.homeBtnForvims(driver);
		OPDRegistrationPage opdregistrationpage = new OPDRegistrationPage(driver);
		opdregistrationpage.opdRegistrationButton(driver);

		opdregistrationpage.OpdRegistartionForVims2(driver, name, year, fname, mobilenum, mail, address, pincode,
				postOffice, depName, doctorname);
		String hospitalNumber = opdregistrationpage.submitAnd_ViewBtn(driver);

		BedMasterPage bp = new BedMasterPage(driver);
		String bednumberh = bp.bedMasterForVims(driver, bedCategory, bedWardType, bedRoomType, floor, wings, depName,
				bedUnitDepartment);

		// -------- patientAdmission-------
		PatientAdmissionPage patientAdmissionPage = new PatientAdmissionPage(driver);
		patientAdmissionPage.clickOnThePatientAdmissinButton(driver);
		patientAdmissionPage.patientAdmissionForVims(driver, hospitalNumber, time, depName, doctorname, admittedByDr,
				wardType, roomType, bednumberh);

		System.out.println(hospitalNumber);
		l.logoutTheApplication(driver);
		lp.loginToApplicationUsingDoctorLogin(un, pw, driver);

		// ---------add investigations--------
		hp.homeBtnForvims(driver);
		ipd.clickOnTheDoctorDeskIPDButton(driver);
		ipd.searchHospitalNumber(driver, hospitalNumber);
		ipd.clickOnTheHospitalNumberInFirstRowInMyListTab(driver);
		// ipd.ClickOnPatientarrivalbtn(driver);
		ipd.ClickOnSavebtn(driver);
		ipd.clickOnInvestigationTab(driver);
		ipd.scrolldown(driver);
		ipd.clickAddBtnInInvestigationtab(driver);
		String inv1 = "automation test magnesium";
		ipd.addTheInvestigationForLabFlow(driver, inv1, notes);
		ipd.ClickOnSubmitBtnInInvestigationTab(driver);
		l.logoutTheApplication(driver);

		String un1 = futil.getProperyKeyValue("username");
		String pw1 = futil.getProperyKeyValue("password");
		lp.loginToApplicationUsingDoctorLogin(un1, pw1, driver);

		// -----sample collection---------
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.sampleCollectionForOneSample1(driver, hospitalNumber);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.clickOnSelectionCheckBoxs_Table(driver);
		rsa.clickOnNextButton(driver);
		String receivedAtLab = "yes";
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
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

		// -------- Second doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnSecondDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);
		System.out.println("Successfully Second Doctor verification entry is done for ip patient");
	}

}