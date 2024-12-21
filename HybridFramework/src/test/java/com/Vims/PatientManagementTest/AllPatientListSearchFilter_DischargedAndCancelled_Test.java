package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class AllPatientListSearchFilter_DischargedAndCancelled_Test extends BaseClass {

	@Test
	public void checkHospitalNumberSearchFilter_DischargedTab_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnDischargedTab(driver);
		ap.selectDischargeFromDate(driver);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber = ap.take_LastrRow_HospitalNumber_DischargedList(driver);
		ap.enterTheHospitalNumber(hospitalNumber);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber1 = ap.take_LastrRow_HospitalNumber_DischargedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkPatientNameSearchFilter_DischargedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnDischargedTab(driver);
		ap.selectDischargeFromDate(driver);
		ap.clickOnTheSearchButton(driver);
		String patientName = ap.takeLastRowPatientNameInTheDischargedPatient_Table(driver);
		ap.enterThePatientName(patientName);
		ap.clickOnTheSearchButton(driver);
		String patientName1 = ap.takeLastRowPatientNameInTheDischargedPatient_Table(driver);
		Assert.assertEquals(patientName, patientName1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkPatientStatusSearchFilter_DischargedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnDischargedTab(driver);
		ap.selectDischargeFromDate(driver);
		ap.clickOnTheSearchButton(driver);
		String ps = ap.takePatientStatusInTheDischargedPatinet_LastRow_Table(driver);
		ap.selectPatientStatusDropdown_DischrgedTab(driver, ps);
		ap.clickOnTheSearchButton(driver);
		String ps1 = ap.takePatientStatusInTheDischargedPatinet_LastRow_Table(driver);
		Assert.assertEquals(ps, ps1);
		System.out.println("successfully verified");
	}

}
