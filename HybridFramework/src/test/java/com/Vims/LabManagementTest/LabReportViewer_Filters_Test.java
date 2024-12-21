package com.Vims.LabManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.LabReportViwerPage;

public class LabReportViewer_Filters_Test extends BaseClass {

	@Test
	public void checkThatUserShouldbeFilterTheTechnicianVerifiedDetailsWithHelpOf_HospitalNumber_Test()
			throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_TechnicianVerifiedList_Tab(driver);
		String billNumber = lr.capture_LastRow_BillNumber_TechnicianVerifiedList(driver);
		lr.enterBillNumber_Filter(driver, billNumber);
		lr.clickOn_SearchButton_Filter(driver);
		String billNumber1 = lr.capture_BillNumber_TechnicianVerifiedList(driver);
		Assert.assertEquals(billNumber, billNumber1);
	}

	@Test
	public void checkThatUserShouldbeFilterTheTechnicianVerifiedDetailsWithHelpOf_PatientName_Test() throws Throwable {

		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_TechnicianVerifiedList_Tab(driver);
		String patientName = lr.capture_LastRow_patientName_TechnicianVerifiedList(driver);
		lr.enter_PatientName_Filter(driver, patientName);
		lr.clickOn_SearchButton_Filter(driver);
		String patientName1 = lr.capture_PatientName_TechnicianVerifiedList(driver);
		Assert.assertEquals(patientName1, patientName);
	}

	@Test
	public void checkThatUserShouldbeFilterTheTechnicianVerifiedDetailsWithHelpOf_ServiceClass_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_TechnicianVerifiedList_Tab(driver);
		String serviceClass = lr.capture_LastRow_ServiceClass_TechnicianVerifiedList(driver);
		lr.selectServiceClass_Filter(driver, serviceClass);
		lr.clickOn_SearchButton_Filter(driver);
		String serviceClass1 = lr.capture_ServiceClass_TechnicianVerifiedList(driver);
		Assert.assertEquals(serviceClass1, serviceClass);
	}

	@Test
	public void checkThatUserShouldbeFilterTheTechnicianVerifiedDetailsWithHelpOf_BillNumber_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_TechnicianVerifiedList_Tab(driver);
		String billNumber = lr.capture_LastRow_BillNumber_TechnicianVerifiedList(driver);
		lr.enterBillNumber_Filter(driver, billNumber);
		lr.clickOn_SearchButton_Filter(driver);
		String billNumber1 = lr.capture_BillNumber_TechnicianVerifiedList(driver);
		Assert.assertEquals(billNumber1, billNumber);
	}

	@Test
	public void checkThatUserShouldbeFilterTheTechnicianVerifiedDetailsWithHelpOf_SampleNumber_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_TechnicianVerifiedList_Tab(driver);
		String sampleNumber = lr.capture_SampleNumber_TechnicianVerifiedList(driver);
		lr.enter_SampleNumber_Filter(driver, sampleNumber);
		lr.clickOn_SearchButton_Filter(driver);
		String sampleNumber1 = lr.capture_LastRow_SampleNumber_TechnicianVerifiedList(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
	}

	@Test
	public void checkThatUserShouldFilterTheDoctorVerifiedDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_CLearButton_Filter(driver);
		String hospitalNumber = lr.capture_LastRow_HospitalNumber_DoctorVerifiedList(driver);
		lr.enter_HospitalNumberFilter(driver, hospitalNumber);
		lr.clickOn_SearchButton_Filter(driver);
		String hospitalNumber1 = lr.capture_HospitalNumber_DoctorVerifiedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserShouldFilterTheDoctorVerifiedDetailsWithHelpOf_PatientName_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_CLearButton_Filter(driver);
		String patientName = lr.capture_LastRow_PatientName_DoctorVerifiedList(driver);
		lr.enter_PatientName_Filter(driver, patientName);
		lr.clickOn_SearchButton_Filter(driver);
		String patientName1 = lr.capture_LastRow_PatientName_DoctorVerifiedList(driver);
		Assert.assertEquals(patientName1, patientName);
	}

	@Test
	public void checkThatUserShouldFilterTheDoctorVerifiedDetailsWithHelpOf_ServiceClass_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_CLearButton_Filter(driver);
		String serviceClass = lr.capture_LastRow_ServiceClass_DoctorVerifiedList(driver);
		lr.selectServiceClass_Filter(driver, serviceClass);
		lr.clickOn_SearchButton_Filter(driver);
		String serviceClass1 = lr.capture_ServiceClass_DoctorVerifiedList(driver);
		Assert.assertEquals(serviceClass1, serviceClass);
	}

	@Test
	public void checkThatUserShouldFilterTheDoctorVerifiedDetailsWithHelpOf_BillNumber_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_CLearButton_Filter(driver);
		String billNumber = lr.capture_LastRow_BillNumber_DoctorVerifiedList(driver);
		lr.enterBillNumber_Filter(driver, billNumber);
		lr.clickOn_SearchButton_Filter(driver);
		String billNumber1 = lr.capture_BillNumber_DoctorVerifiedList(driver);
		Assert.assertEquals(billNumber1, billNumber);
	}

	@Test
	public void checkThatUserShouldFilterTheDoctorVerifiedDetailsWithHelpOf_SampleNumber_Test() throws Throwable {
		LabReportViwerPage lr = new LabReportViwerPage(driver);
		HomePage hp = new HomePage(driver);

		lr.clickOnLabReportViewerPageBtn(driver);
		hp.homeBtnForvims(driver);
		lr.clickOn_CLearButton_Filter(driver);
		String sampleNumber = lr.capture_LastRow_SampleNumber_DoctorVerifiedList(driver);
		lr.enter_SampleNumber_Filter(driver, sampleNumber);
		lr.clickOn_SearchButton_Filter(driver);
		String sampleNumber1 = lr.capture_SampleNumber_DoctorVerifiedList(driver);
		Assert.assertEquals(sampleNumber1, sampleNumber);
	}

}
