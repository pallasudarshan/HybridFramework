package com.Vims.PatientManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class AllPatientListSearchFilter_activeAndAdmitted_Test extends BaseClass {

	@Test
	public void checkHospitalNumberSearchFilter_ActivePatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		String hospitalNumber = ap.take_LastrRow_HospitalNumber_ActiveList(driver);
		ap.enterTheHospitalNumber(hospitalNumber);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber1 = ap.take_LastrRow_HospitalNumber_ActiveList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkPatientNameSearchFilter_ActivePatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		String patientName = ap.takeLastRowPatientNameInTheActivePatinet_Table(driver);
		ap.enterThePatientName(patientName);
		ap.clickOnTheSearchButton(driver);
		String patientName1 = ap.takeThePatientNameInTheActivePatinet_Table(driver);
		Assert.assertEquals(patientName, patientName1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkDepartmentSearchFilter_ActivePatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		String dep = ap.takeDepartmentNameInTheActivePatinet_LastRow_Table();
		ap.selectTheDepartmentDropdown(driver, dep);
		ap.clickOnTheSearchButton(driver);
		String dep1 = ap.takeDepartmentNameInTheActivePatinet_Table(driver);
		Assert.assertEquals(dep, dep1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkUnitSearchFilter_ActivePatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		String unit = ap.takeUnitInTheActivePatinet_LastRow_Table();
		String dep = ap.takeDepartmentNameInTheActivePatinet_LastRow_Table();
		ap.selectTheDepartmentDropdown(driver, dep);
		Thread.sleep(1000);
		ap.selectUnitDropdown(driver, unit);
		ap.clickOnTheSearchButton(driver);
		String unit1 = ap.takeUnitInTheActivePatinet_LastRow_Table();
		Assert.assertEquals(unit, unit1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkPatientStatusSearchFilter_ActivePatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		String ps = ap.takePatientStatusInTheActivePatinet_LastRow_Table();
		ap.selectPatientStatusDropdown(driver, ps);
		ap.clickOnTheSearchButton(driver);
		String ps1 = ap.takePatientStatusInTheActivePatinet_LastRow_Table();
		Assert.assertEquals(ps, ps1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkMobileNumberSearchFilter_ActivePatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.clickOnClearBtn(driver);
		String phone = ap.capturePhoneNumberAndIgnoreIfNa_activeList(driver);
		ap.enterTheMobileNumber(phone);
		ap.clickOnTheSearchButton(driver);
		String phone1 = ap.capturePhoneNumber_ActiveTab(driver);
		Assert.assertEquals(phone, phone1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkHospitalNumberSearchFilter_Admitted_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnAdmittedTab(driver);
		ap.clickOnClearBtn(driver);
		String hospitalNumber = ap.take_LastrRow_HospitalNumber_AdmittedList(driver);
		ap.enterTheHospitalNumber(hospitalNumber);
		ap.clickOnTheSearchButton(driver);
		String hospitalNumber1 = ap.take_LastrRow_HospitalNumber_AdmittedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkPatientNameSearchFilter_AdmittedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnAdmittedTab(driver);
		ap.clickOnClearBtn(driver);
		String patientName = ap.takeLastRowPatientNameInTheAdmittedePatient_Table(driver);
		ap.enterThePatientName(patientName);
		ap.clickOnTheSearchButton(driver);
		String patientName1 = ap.takeLastRowPatientNameInTheAdmittedePatient_Table(driver);
		Assert.assertEquals(patientName, patientName1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkMobileNumberSearchFilter_AdmittedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnAdmittedTab(driver);
		ap.clickOnClearBtn(driver);
		String phone = ap.capturePhoneNumberAndIgnoreIfNa_admittedList(driver);
		ap.enterTheMobileNumber(phone);
		ap.clickOnTheSearchButton(driver);
		String phone1 = ap.capturePhoneNumber_admittedTab(driver);
		Assert.assertEquals(phone, phone1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkDepartmentSearchFilter_AdmittedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnAdmittedTab(driver);
		ap.clickOnClearBtn(driver);
		String dep = ap.takeDepartmentName_Admitted_LastRow_Table(driver);
		ap.selectTheDepartmentDropdown(driver, dep);
		ap.clickOnTheSearchButton(driver);
		String dep1 = ap.takeDepartmentName_Admitted_LastRow_Table(driver);
		Assert.assertEquals(dep, dep1);
		System.out.println("successfully verified");
	}

	@Test
	public void checkUnitSearchFilter_AdmittedPatient_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnAdmittedTab(driver);
		ap.clickOnClearBtn(driver);
		String unit = ap.takeUnit_AdmittedPatinet_LastRow_Table(driver);
		String dep = ap.takeDepartmentName_Admitted_LastRow_Table(driver);
		ap.selectTheDepartmentDropdown(driver, dep);
		Thread.sleep(1000);
		ap.selectUnitDropdown(driver, unit);
		ap.clickOnTheSearchButton(driver);
		String unit1 = ap.takeUnit_AdmittedPatinet_LastRow_Table(driver);
		Assert.assertEquals(unit, unit1);
		System.out.println("successfully verified");
	}

	@Test(description = "Verify the list of data by checking the 'from' and 'to' date filters to ensure that the data falls within the specified date range.")
	public void checkThatUserShouldBeAbleToFilterTheListUsingFromAndToDate_test() throws Throwable {
		JavaUtility j = new JavaUtility();
		int minusDate = 4;
		int minusDate1 = 0;
		String fromDate = j.generateDate_minusDate_ddMMyyyy(1);
		String toDate = j.generateDate_minusDate_ddMMyyyy(0);

		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnAdmittedTab(driver);
		ap.selectAdmissionFromDate(driver, minusDate);
		ap.selectAdmissionToDate(driver, minusDate1);
		ap.clickOnTheSearchButton(driver);
		ap.verifyThatAdmittedDatesAreWithinRange(driver, fromDate, toDate);
	}

	@Test
	public void checkThatUserShouldBeAbleToFilterUsingAdmissionDate_ActiveList_test() throws Throwable {
		JavaUtility j = new JavaUtility();
		int minusDate = 0;
		String date1 = j.generateDate_minusDate_ddMMyyyy(4);
		System.out.println(date1);

		HomePage hp = new HomePage(driver);
		AllPatientListPage ap = new AllPatientListPage(driver);

		ap.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		ap.clickOnActiveTab(driver);
		ap.selectdate(driver, minusDate);
		ap.clickOnTheSearchButton(driver);
		ap.verifyThatAdmissionDate_ActiveList(driver);
	}
}
