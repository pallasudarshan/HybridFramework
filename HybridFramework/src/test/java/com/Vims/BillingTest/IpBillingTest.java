package com.Vims.BillingTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.TestData;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.Concession_Refund_AuthorizationPage;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskOpdPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.Hospital_Service_Bill_page;
import com.Dalvkot.Vims_ObjectRepositary.IpBillingPage;
import com.Dalvkot.Vims_ObjectRepositary.LogOutPage;
import com.Dalvkot.Vims_ObjectRepositary.LoginPage;
import com.Dalvkot.Vims_ObjectRepositary.OPDRegistrationPage;
import com.Dalvkot.Vims_ObjectRepositary.SearchPatientPage;

//@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class IpBillingTest extends BaseClass {
	@Test
	public void checkThatTotalServiceRatesAmountShouldMatchWithBillTotal_Test() throws Throwable {
		String patientStatus = "ACTIVE";

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = alp.clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(driver,
				patientStatus);
		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		String rate = ip.sumOfTheServices_Rates_InTheList(driver);
		String rate1 = ip.capture_billTotalAmount_SumOfRateAmounts(driver);
		System.out.println(rate1);
		Assert.assertEquals(rate, rate1);
	}

	@Test
	public void checkThatServicesNetAmountShouldMatchWithTotalNetAmount_Test() throws Throwable {
		String patientStatus = "ACTIVE";

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = alp.clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(driver,
				patientStatus);

		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		String sumOf_netAmount = ip.sumOfThe_TotalNetAmount_InTheList(driver);
		String sumOf_netAmount1 = ip.capture_netTotalAmount_SumOfTotalNetAmounts(driver);
		System.out.println(sumOf_netAmount + " : First");
		System.out.println(sumOf_netAmount1 + " : Second");
		Assert.assertEquals(sumOf_netAmount, sumOf_netAmount1);
	}

	@Test
	public void checkThatUserShouldbeverifyEachNetAmountWith_IndividualAmounts_Test() throws Throwable {
		String patientStatus = "ACTIVE";

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);
		AllPatientListPage alp = new AllPatientListPage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = alp.clear_SelectPatientStatus_Search_CaptureHospitalNumber_ActiveList(driver,
				patientStatus);
		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		ip.clickOnActionsViewButtons_VerifyingTotalAmounts(driver);
	}

	@Test
	public void validateThatSubtractingTheDiscountAndConcessionAmountFromTheBillAmountResultsInA_NetAmountThatMatchesTheExpectedNetAmount_Test()
			throws Throwable {

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);

		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);

		String hospitalNumber = ip.capture_HospitalNumber_SuspendedList(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		String netAmount = ip.billAmountMinus_DiscountAmount_Minus_ConcessionAmount(driver);
		String netAmount1 = ip.capture_NetAmount(driver);
		System.out.println(netAmount);
		System.out.println(netAmount1);
		Assert.assertEquals(netAmount, netAmount1);

	}

	@Test
	public void checkThatUserShouldbeAddTheAdvanceAmountAndThenVerifyItWithinTheAdvancedDepositTextField_Test()
			throws Throwable {

		int amount = 1000;
		String amount1 = "1000";
		String remarks = "Test";

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);

		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = ip.capture_HospitalNumber_SuspendedList(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		String advanceDeposit = ip.capture_AdvanceDeposit_And_AddTheGivenAmount(driver, amount);
		ip.add_AdvanceAmoun_InTheWindow(driver, amount1, remarks);
		String advanceDeposit1 = ip.capture_AdvanceDeposit(driver);

	}

	@Test(description = "If the user provides a concession percentage, the"
			+ " program should calculate the concession amount. Subtracting this con"
			+ "cession amount from the bill amount results in the net amount.")
	public void checkThatUserShouldGiveTheConcessionPercentageTheNetAmountShouldChange_Test() throws Throwable {

		String concessionPercentage = "09.9";

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);

		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);

		String hospitalNumber = ip.capture_HospitalNumber_SuspendedList(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		ip.select_ProvisionalRadioButton(driver);
		ip.verifyingThe_NetAmount_AfterGivingConcessionPercentage(driver, concessionPercentage);
	}

	@Test
	public void checkThatUserShouldVerifyThe_AmountToRefundAmount_Test() throws Throwable {

		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);

		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		String hospitalNumber = ip.capture_HospitalNumber_SuspendedList(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		ip.calculations_Of_AmountToRefund(driver);
	}

	@Test
	public void toVerifySystemIsAbleToShowThePatientDetailsAfterEnteringTheHospitalNumber_Test() throws Throwable {

		AllPatientListPage alp = new AllPatientListPage(driver);
		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		String patientName = alp.takeThePatientNameInTheActivePatinet_Table(driver);
		String ipNumber = alp.takeIpNumberInTheActivePatinet_Table(driver);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String bedNumber = alp.takeBedNumberInTheActivePatinet_Table(driver);

		ip.clikcOn_IpBillingBtn(driver);
		ip.clickOn_NewBillButton(driver);
		ip.enterHospitalNumber(driver, hospitalNumber);
		ip.clickOn_SearchButton(driver);
		String hospitalNumber1 = ip.captureHospitalNumberInTheDetails(driver);
		String patientName1 = ip.capturePatientNameInTheDetails(driver);
		String ipNumber1 = ip.captureIpNumberInTheDetails(driver);
		String wardType1 = ip.captureWardTypeInTheDetails(driver);
		String roomType1 = ip.captureRoomTypeInTheDetails(driver);
		String bedNumber1 = ip.captureBedNumberInTheDetails(driver);

		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		Assert.assertEquals(patientName, patientName1);
		Assert.assertEquals(ipNumber1, ipNumber);
		Assert.assertEquals(wardType1, wardType);
		Assert.assertEquals(roomType1, roomType);
		Assert.assertEquals(bedNumber1, bedNumber);
	}

	@Test
	public void toVerifyTheSystemAbleToShowTheTransactionTypeAsCreditForInsurancePatient_Test() throws Throwable {

		String transactionType = "CREDIT";
		IpBillingPage ip = new IpBillingPage(driver);
		HomePage hp = new HomePage(driver);

		ip.clikcOn_IpBillingBtn(driver);
		hp.homeBtnForvims(driver);
		ip.selectTransactionType_Filter(driver, transactionType);
		ip.clickOn_SearchButton(driver);
		String hospitalNumber = ip.capture_HospitalNumber_SuspendedList(driver);
		ip.newBill_EnterHospital_Search(driver, hospitalNumber);
		String transactionType1 = ip.captureTransacionType_InTheDropdownData(driver);
		Assert.assertEquals(transactionType, transactionType1);
	}

}
