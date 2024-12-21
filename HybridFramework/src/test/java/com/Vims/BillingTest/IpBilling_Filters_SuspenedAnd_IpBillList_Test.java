package com.Vims.BillingTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.IpBillingPage;

public class IpBilling_Filters_SuspenedAnd_IpBillList_Test extends BaseClass {

	@Test
	public void checkThatUserShouldSearchSuspendedDetailsWithHelpOf_TransactionTypeAsCash_Test() throws Throwable {
		String transactionType = "CASH";

		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.clickOn_SuspendedTab(driver);
		ipBillingPage.selectTransactionType_Filter(driver, transactionType);
		ipBillingPage.clickOn_SearchButton(driver);
		String transactionType1 = ipBillingPage.capture_TransactionType_SuspendedList(driver);
		Assert.assertEquals(transactionType, transactionType1);
	}

	@Test
	public void checkThatUserShouldSearchSuspendedDetailsWithHelpOf_TransactionTypeAsCredit_Test() throws Throwable {
		String transactionType = "CREDIT";

		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.clickOn_SuspendedTab(driver);
		ipBillingPage.selectTransactionType_Filter(driver, transactionType);
		ipBillingPage.clickOn_SearchButton(driver);
		String transactionType1 = ipBillingPage.capture_TransactionType_SuspendedList(driver);
		Assert.assertEquals(transactionType, transactionType1);
	}

	@Test
	public void checkThatUserShouldSearchSuspendedDetailsWithHelpOf_BillNumber_Test() throws Throwable {
		String patientStatus = "ACTIVE";

		AllPatientListPage allPatientListPage = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		allPatientListPage.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		allPatientListPage.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = allPatientListPage.takeTheHospitalNumberInTheActivePatientTable(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.newBill_EnterHospital_Search(driver, hospitalNumber);
		ipBillingPage.select_ProvisionalRadioButton(driver);
		ipBillingPage.clickOn_SecondRowViewButton_IPBillingList(driver);
		ipBillingPage.clickOn_SubmitButton_ServiceDetailsTable(driver);
		ipBillingPage.clickOn_FinalSubmit(driver);

		ipBillingPage.clickOn_SuspendedTab(driver);
		ipBillingPage.enterHospitalNumber_Filter(driver, hospitalNumber);
		ipBillingPage.clickOn_SearchButton(driver);
		String billNumber = ipBillingPage.capture_BillNumber_SuspendedList(driver);
		ipBillingPage.clickOn_ClearButton(driver);
		ipBillingPage.enterBillNumber_Filter(driver, billNumber);
		ipBillingPage.clickOn_SearchButton(driver);
		String billNumber1 = ipBillingPage.capture_BillNumber_SuspendedList(driver);
		Assert.assertEquals(billNumber, billNumber1);
	}

	@Test
	public void checkThatUserShouldSearchSuspendedDetailsWithHelpOf_HospitalNumber_Test() throws Throwable {

		String patientStatus = "ACTIVE";

		AllPatientListPage allPatientListPage = new AllPatientListPage(driver);
		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		allPatientListPage.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		allPatientListPage.clear_SelectPatientStatus_Search_ActiveList(driver, patientStatus);
		String hospitalNumber = allPatientListPage.takeTheHospitalNumberInTheActivePatientTable(driver);
		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.newBill_EnterHospital_Search(driver, hospitalNumber);
		ipBillingPage.select_ProvisionalRadioButton(driver);
		ipBillingPage.clickOn_SecondRowViewButton_IPBillingList(driver);
		ipBillingPage.clickOn_SubmitButton_ServiceDetailsTable(driver);
		ipBillingPage.clickOn_FinalSubmit(driver);
		ipBillingPage.clickOn_SuspendedTab(driver);
		ipBillingPage.enterHospitalNumber_Filter(driver, hospitalNumber);
		ipBillingPage.clickOn_SearchButton(driver);
		String hospitalNumber1 = ipBillingPage.capture_HospitalNumber_SuspendedList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserShouldSearchIpBillDeatilsWithHelpOf_TransactionTypeAsCash_Test() throws Throwable {
		String transactionType = "CASH";

		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.clickOn_IpBillingListTab(driver);
		ipBillingPage.selectTransactionType_Filter(driver, transactionType);
		ipBillingPage.clickOn_SearchButton(driver);
		String transactionType1 = ipBillingPage.capture_TransactionType_IpBillingList(driver);
		Assert.assertEquals(transactionType, transactionType1);
	}

	@Test
	public void checkThatUserShouldSearchIpBillDeatilsWithHelpOf_TransactionTypeAsCredit_Test() throws Throwable {
		String transactionType = "CREDIT";

		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.clickOn_IpBillingListTab(driver);
		ipBillingPage.selectTransactionType_Filter(driver, transactionType);
		ipBillingPage.clickOn_SearchButton(driver);
		String transactionType1 = ipBillingPage.capture_TransactionType_IpBillingList(driver);
		Assert.assertEquals(transactionType, transactionType1);
	}

	@Test
	public void checkThatUserShouldSearchIpBillDeatilsWithHelpOf_BillNumber_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.clickOn_IpBillingListTab(driver);
		String billNumber = ipBillingPage.capture_LastRow_BillNumber_IpBillList(driver);
		ipBillingPage.enterBillNumber_Filter(driver, billNumber);
		ipBillingPage.clickOn_SearchButton(driver);
		String billNumber1 = ipBillingPage.capture_BillNumber_IpBillingList(driver);
		Assert.assertEquals(billNumber, billNumber1);
	}

	@Test
	public void checkThatUserShouldSearchIpBillDeatilsWithHelpOf_HospitalNumber_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		IpBillingPage ipBillingPage = new IpBillingPage(driver);

		ipBillingPage.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ipBillingPage.clickOn_IpBillingListTab(driver);
		String hospitalNumber = ipBillingPage.capture_LastRow_HospitalNumberNumber_IpBillList(driver);
		ipBillingPage.enterHospitalNumber_Filter(driver, hospitalNumber);
		ipBillingPage.clickOn_SearchButton(driver);
		String hospitalNumber1 = ipBillingPage.capture_HospitalNumber_IpBillingList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

	@Test
	public void checkThatUserShouldSearchIpBillDeatilsWithHelpOf_BillDateTest() throws Throwable {

	}

	@Test
	public void checkThatUserShouldSearchSuspendedDetailsWithHelpOf_BillDate_Test() {

	}
}
