package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.LabTechnicianEntryPage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.ReceiptSampleAtLabPage;
import com.Dalvkot.Vims_ObjectRepositary.SampleCollectionPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class ReceiptSampleAtLabTest extends BaseClass {

	@Test
	public void checkThatUserShouldVerifyTheCheckboxIsSelectedOrNot_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);

		rsa.clickOnClearButton(driver);
		rsa.selectCheckBox_CheckIsSelectedOrNot(driver);
	}

	@Test
	public void checkThatUserShouldSearch_FilterTheSamplesByUsingSampleDateField_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		String sampleDate = j.currentDate();
		String serviceName = eutil.getDataFromTheExcel("ReceiptAtSample", 1, 1);

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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

		// Receipt at sample
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.selectSampleDate(driver, sampleDate);
		rsa.clickOnTheSearchButton(driver);
		rsa.takeSampleDates(driver, sampleDate);
	}

	@Test
	public void checkThatUserShouldAbleToSelectReceivedAtLabAsRejectAndClickOnSubmit_Test() throws Throwable {

		String serviceName = eutil.getDataFromTheExcel("ReceiptAtSample", 1, 1);
		String receivedAtLab = eutil.getDataFromTheExcel("ReceiptAtSample", 2, 1);

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

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

		// Receipt sampel at lab
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		String sampleNumber = rsa.takeSampleNumber_SampleListTable(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// Sample collection
		hp.homeBtnForvims(driver);
		sam.clickOnSampleCollectionPage(driver);
		sam.clickOnCancelledListTab(driver);
		sam.enterSampleNumberFilter(driver, sampleNumber);
		sam.clickOnSearchButton_Cancelled_ListTable(driver);
		String sampleNumber1 = sam.takeSampleNumberInCancelledList(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println("Rejected sample verified in the sample collection page under concelled list");
	}

	@Test
	public void checkThatUserShouldAbleToSelectReceivedAtLabAsNoAndClickOnSubmit_Test() throws Throwable {

		String receivedAtLab = "NO";
		String serviceName = "AUTOMATION TEST MAGNESIUM";

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);

		// Op billing
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

		// Receipt sample at lab
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		String sampleNumber = rsa.takeSampleNumber_SampleListTable(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);
		rsa.enterSampleNumber(driver, sampleNumber);
		rsa.clickOnTheSearchButton(driver);
		String sampleNumber1 = rsa.takeSampleNumber(driver);
		Assert.assertEquals(sampleNumber, sampleNumber1);
		System.out.println("Not confirmed sample verified in the receipt sample at lab page succesfully");

	}

	@Test
	public void checkThatUserShouldAbleToSelectReceivedAtLabAsYesAndClickOnSubmit_Test() throws Throwable {

		String receivedAtLab = "YES";
		String serviceName = "AUTOMATION TEST MAGNESIUM";

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);
		Hospital_Service_Bill_page hs = new Hospital_Service_Bill_page(driver);
		SampleCollectionPage sam = new SampleCollectionPage(driver);
		LabTechnicianEntryPage lte = new LabTechnicianEntryPage(driver);

		// Op billing
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

		// Receipt sample at lab
		hp.homeBtnForvims(driver);
		rsa.clickOnReceiptAtSampleLabBtn(driver);
		rsa.clickOnFirst_SelectionCheckBox_Table(driver);
		rsa.clickOnNextButton(driver);
		String sampleNumber = rsa.takeSampleNumber_SampleListTable(driver);
		rsa.selectReceivedAtLabAtSampleList(driver, receivedAtLab);
		rsa.clickOnSubmitButton(driver);
		rsa.clickOnOkButton(driver);

		// Lab technician entry
		hp.homeBtnForvims(driver);
		lte.clickOnLabTechnicianEntryButton(driver);
		lte.enterSampleNumber(driver, sampleNumber);
		lte.clickOnSearchButton(driver);
		String sampleNumber1 = lte.takeSampleNumberList_Table();
		Assert.assertEquals(sampleNumber, sampleNumber1);
		System.out.println("Receipt confirmed sample verified in lab technician entry page ");
	}

	@Test
	public void checkThatUserShouldClickOnTheCancelButtonOnceCheckboxsSelect_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);

		rsa.clickOnClearButton(driver);
		String hosptalNumber = rsa.takeHospitalNumbers_Table(driver);
		rsa.enterHospitalNumber(driver, hosptalNumber);
		rsa.clickOnTheSearchButton(driver);
		rsa.selectAllSamplesInTheTable(driver);
		rsa.clickOnCancelButton(driver);
		rsa.verifyUnselectedSelectionCheckBox(driver);
	}

	@Test
	public void checkThatUserShouldSearchSampleDetails_WithHelpOf_HospitalNumber_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);

		rsa.clickOnClearButton(driver);
		String hospitalNumber = rsa.takeLastRow_HospitalNumber(driver);
		rsa.enterHospitalNumber(driver, hospitalNumber);
		rsa.clickOnTheSearchButton(driver);
		String hospitalNumber1 = rsa.takeHospitalNumber_Table(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Filtered a sample details with help of hospital number successfully");
	}

	@Test
	public void checkThatUserShouldSearchSampleDetails_WithHelpOf_SampleNumber_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);

		rsa.clickOnClearButton(driver);
		String sampleNumber = rsa.takeLastRow_SampleNumber_List(driver);
		rsa.enterSampleNumber(driver, sampleNumber);
		rsa.clickOnTheSearchButton(driver);
		String sampleNumber1 = rsa.takeSampleNumber(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
		System.out.println("Filtered a sample details with help of sample number successfully");
	}

	@Test
	public void checkThatUserShouldSearchSampleDetails_WithHelpOf_SampleDates_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);

		rsa.clickOnClearButton(driver);
		String sampleDate = rsa.takeLastRowSampleDate(driver);
		rsa.selectSampleDate(driver, sampleDate);
		rsa.clickOnTheSearchButton(driver);
		rsa.takeSampleDates(driver, sampleDate);
		System.out.println("Filtered a sample details with help of sample number successfully");
	}

	@Test
	public void checkThatVerifyTheDetailsOf_op_ip_PatientName_Gender_AgeDetailsInTheList_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		ReceiptSampleAtLabPage rsa = new ReceiptSampleAtLabPage(driver);

		rsa.clickOnReceiptAtSampleLabBtn(driver);
		hp.homeBtnForvims(driver);
		rsa.clickOnClearButton(driver);

	}

}
