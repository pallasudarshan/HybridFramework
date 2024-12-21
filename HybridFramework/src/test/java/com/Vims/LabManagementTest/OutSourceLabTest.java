package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;
import com.Dalvkot.Vims_ObjectRepositary.outSourceSampleListPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class OutSourceLabTest extends BaseClass {

	@Test
	void verifyThatSelectedExternalServicesInsSampleCollectionPageIsReflectingInOutSourceLabPage_Test()
			throws Throwable {

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
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//		SampleCollectionPage sam = new SampleCollectionPage(driver);
//		outSourceSampleListPage ou = new outSourceSampleListPage(driver);
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
//		String serviceName = "AUTOMATION TEST MAGNESIUM";
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
//		sam.sampleCollectionForExternalLabServices(driver, hospitalNumber);
//
//		// -------out source lab -----------
//		hp.homeBtnForvims(driver);
//		ou.clickOnOutSourceLabPage(driver);
//		String hsptl = ou.verifyHospitalNumberIsReflectingInOutSourceLabScreen(driver);
//		Assert.assertEquals(hsptl, hospitalNumber);
//		System.out.println("successfully verified hospital number in out source lab screen");
	}

	@Test
	void verifyThatBatchNumberSearchFilterIsWorkingAsExpected_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		outSourceSampleListPage ou = new outSourceSampleListPage(driver);

		// -----out source lab-----------
		hp.homeBtnForvims(driver);
		ou.clickOnOutSourceLabPage(driver);
		ou.clickOnClearBtn(driver);
		String batchNumber = ou.captureBatchNumberInTable(driver);
		ou.SearchBatchNumber(driver, batchNumber);
		String batchNumber1 = ou.captureBatchNumberInTable(driver);
		Assert.assertEquals(batchNumber1, batchNumber);
		System.out.println("successfully batch number is verified in search filter");
	}

	@Test
	void verifyThatExternalLabNameSearchFilterIsWorkingAsExpected_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		outSourceSampleListPage ou = new outSourceSampleListPage(driver);

		// -----out source lab-----------
		hp.homeBtnForvims(driver);
		ou.clickOnOutSourceLabPage(driver);
		ou.clickOnClearBtn(driver);
		String ext = ou.captureExternalLabNameInTable(driver);
		ou.SearchExternalLabName(driver, ext);
		String ext1 = ou.captureExternalLabNameInTable(driver);
		Assert.assertEquals(ext1, ext);
		System.out.println("successfully External lab name is verified in search filter");
	}

	@Test
	void verifyThatUserIsAbleToUploadTheDocumentsSuccessfullyInOutSourceLabScreen_Test() throws Throwable {

//		HomePage hp = new HomePage(driver);
//		outSourceSampleListPage ou = new outSourceSampleListPage(driver);
//
//		// -------out source lab -----------
//		hp.homeBtnForvims(driver);
//		ou.clickOnOutSourceLabPage(driver);
//		ou.clickOnClearBtn(driver);
//		String text = ou.verifyUploadDocuments(driver);
//		Assert.assertEquals("Upload Successful.", text);
//		System.out.println("document is uploaded successfully");
	}

	@Test
	void toVerifyThatTheUserIsAbleToDoTheOutSourceFlow_Test() throws Throwable {

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
//		HomePage hp = new HomePage(driver);
//		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
//		SampleCollectionPage sam = new SampleCollectionPage(driver);
//		outSourceSampleListPage ou = new outSourceSampleListPage(driver);
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
//		String serviceName = "AUTOMATION TEST MAGNESIUM";
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
//		sam.sampleCollectionForExternalLabServices(driver, hospitalNumber);
//
//		// -------out source lab -----------
//		hp.homeBtnForvims(driver);
//		ou.clickOnOutSourceLabPage(driver);
//		ou.outSourceLabPage(driver);
	}

	@Test
	void toVerifySubmittingTheCheckBoxWithoutSelectingTheCheckBox_ErrorMSG_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		outSourceSampleListPage ou = new outSourceSampleListPage(driver);

		// -----out source lab-----------
		hp.homeBtnForvims(driver);
		ou.clickOnOutSourceLabPage(driver);
		String pop = ou.verifyErrorMsgWithoutSelectingCheckbox(driver);
		Assert.assertEquals("Please select samples", pop);
		System.out.println("successfully pop up msg 'Please select samples' is verified");
	}

}
