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
import com.Dalvkot.Vims_ObjectRepositary.SecondDoctorVerificationTestPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class SecondDoctorVerificationEntryTest extends BaseClass {

	@Test
	public void verifySecondDoctorVerificationEntrySuccessfullyCreated_Test() throws Throwable {
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
		String serviceName = "AUTOMATION TEST MAGNESIUM";
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
		df.doctorVerificationEntry(driver, hospitalNumber);

		// -------- Second doctor verification entry------------------------
		hp.homeBtnForvims(driver);
		df.clickOnSecondDoctorVerificationEntryPage(driver);
		df.doctorVerificationEntry(driver, hospitalNumber);

	}

	@Test

	public void verifyTheNotesUnderEyeIconisUpdatingAccuratlyInSecondDoctorVerification_Test() throws Throwable {
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
		String serviceName = "AUTOMATION TEST MAGNESIUM";
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
		df.doctorVerificationEntry(driver, hospitalNumber);

		// -----Doctor verification Entry-----------
		hp.homeBtnForvims(driver);
		df.clickOnSecondDoctorVerificationEntryPage(driver);
		df.searchHospitalNumberAndClickOnsampleNumberInTable(driver, hospitalNumber);
		df.verifyNotesUnderEyeIcon(driver);
	}

	@Test
	public void checkThatUserShouldVerifyTheListTableFilters_Test() throws Throwable {

	}

	@Test
	public void filterPatientDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {
		String serviceName = "AUTOMATION TEST MAGNESIUM";
		String receivedAtLab = "YES";

		SecondDoctorVerificationTestPage sd = new SecondDoctorVerificationTestPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
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

		sd.clickOnSecondDoctorVerificationButton(driver);
		hp.homeBtnForvims(driver);

		sd.clickOn_ClearButton(driver);
		sd.enter_HospitalNumber_Filters(driver, hospitalNumber);
		sd.clickOn_SearchButton(driver);

		String hospitalNumber1 = sd.captue_HospitalNumber_Table(driver);
		Assert.assertEquals(hospitalNumber1, hospitalNumber);

	}

	@Test
	public void filterPatientDetailsWithHelpOf_SampleNumber_Test() throws Throwable {
		String serviceName = "AUTOMATION TEST MAGNESIUM";
		String receivedAtLab = "YES";

		SecondDoctorVerificationTestPage sd = new SecondDoctorVerificationTestPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		HomePage hp = new HomePage(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);

		// OP billing

		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
		hs.clickOnCompletedTab(driver);
		hs.clickOnClearButton(driver);
		String hospitalNumber = hs.takeHospitalNumberCompletedBillingList(driver);
		hs.clickonNewBillButton(driver);
		hs.enterHospitalNumber(hospitalNumber);
		hs.addOneServiceInTheOpBillin(driver, serviceName);
		hs.clickOnSubmit(driver);

		// -----sample collection---------
		sam.clickOnSampleCollectionPage(driver);
		hp.homeBtnForvims(driver);
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
		df.clickOnVerfiedListTab_Only(driver);
		df.enterHospitalNumber(driver, hospitalNumber);
		df.clickOnTheSearchButton(driver);
		String sampleNumber = df.takeSampleNumber_VerifiedList(driver);

		sd.clickOnSecondDoctorVerificationButton(driver);
		hp.homeBtnForvims(driver);
		sd.clickOn_ClearButton(driver);
		sd.enterSampleNumber_Filter(driver, sampleNumber);
		sd.clickOn_SearchButton(driver);

		String sampleNumber1 = sd.capture_SampleNumber_Table(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);

	}

	@Test
	public void checkThatUserShouldSearchDetails_WithHelpOfServiceClass_Test() throws Throwable {
		String serviceName = "AFB - CYTO";
		String serviceClass = "CYTOLOGY";
		String receivedAtLab = "YES";

		HomePage hp = new HomePage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		LabTechnicianEntryPage lt = new LabTechnicianEntryPage(driver);
		DoctorVerificationEntryPage df = new DoctorVerificationEntryPage(driver);
		SecondDoctorVerificationTestPage sd = new SecondDoctorVerificationTestPage(driver);

		// OP billing
		hs.clickOnHospitalServiceBillLink(driver);
		hp.homeBtnForvims(driver);
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
		sam.clickOnTheBillNumber_NewSample(driver);
		sam.clickonAllViewbuttons_submit(driver);

		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.enter_HospitalNumber_List_Cancelled(driver, hospitalNumber);
		sam.selectServiceClassFilter(driver, serviceClass);
		sam.clickOnSearchButton_ListTable(driver);
		String sampleNumber = sam.takeSampleNumber_ListTable(driver);

		// -----reciept sampler at lab-------------
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectServiceClass(driver, serviceClass);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.enterSampleNumber(driver, sampleNumber);
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
		lt.enterSampleNumber(driver, sampleNumber);
		lt.enterHospitalNumber_Search_List_Partial(driver, hospitalNumber);
		lt.clickOn_SampleNumber_List(driver);
		lt.latTechnicianEntryProcess_For_Discriptive(driver);

		hp.homeBtnForvims(driver);
		df.clickOnDoctorVerificationEntryPage(driver);
		df.enterSampleNumber(driver, sampleNumber);
		df.selectServiceClass(driver, serviceClass);
		df.enterHospitalNumber(driver, hospitalNumber);
		df.clickOnTheSearchButton(driver);
		df.clickOn_SampleNumber_TechnicianVerifiedList(driver);
		df.clickOnDoctorVerifiedBtnAndOkBtn(driver, hospitalNumber);

		sd.clickOnSecondDoctorVerificationButton(driver);
		hp.homeBtnForvims(driver);
		sd.clickOn_ClearButton(driver);
		sd.select_ServiceClass(driver, serviceClass);
		sd.enterSampleNumber_Filter(driver, sampleNumber);
		sd.clickOn_SearchButton(driver);
		String sampleNumber2 = sd.capture_SampleNumber_Table(driver);
		Assert.assertEquals(sampleNumber, sampleNumber2);
	}

}
