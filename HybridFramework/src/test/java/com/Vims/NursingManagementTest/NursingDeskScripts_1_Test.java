package com.Vims.NursingManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.NursingDeskPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class NursingDeskScripts_1_Test extends BaseClass {

	@Test(description = "Entered data in the text filed should be clear")
	public void checkThatUserClickonTheCancelButtonInTheNursingCarePlan_Test() throws Throwable {
		String status = "ARRIVED";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		np.selectStatusDropdown(driver, status);
		np.clickOnTheSearchButton(driver);
		np.clickOn_HospitalNumber(driver);
		np.clickOn_NursingCarePlanTab(driver);
		np.scrollDownByUsingJavascriptExecuter(driver);
		np.clickOn_PlusButton_NursingCarePlan(driver);
		np.enter_Preventive_NursingCarePlan(driver, status);
		np.clickOnCancelButtonNursingCarePlan(driver);
		String data = np.capturePreventiveDataInTheTextNursingCarePlan(driver);
		Assert.assertEquals(data, "");
	}

}
