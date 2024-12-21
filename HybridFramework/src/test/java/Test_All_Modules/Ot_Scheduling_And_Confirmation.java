package Test_All_Modules;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.otConfirmationPage;

public class Ot_Scheduling_And_Confirmation extends BaseClass {
	@Test
	public void toVerifyThatUserShouldbeConfirmTheOtScheduling_Test() throws Throwable {

		// Pass the hospitalNumber here
		String hospitalNumber = "8324531";

		OTSchedulingPage ots = new OTSchedulingPage(driver);
		otConfirmationPage ocp = new otConfirmationPage(driver);

		String operationTheater = "operation";
		String surgeryType = "MAJOR";
		String surgeryNature = "ELECTIVE";
		String surgeryTime = "1212";
		String duration = "8";
		String anastesiaType = "EPIDURAL";
		String specialNotes = "testing";
		String department = "CARDIOLOGY";
		String surgeryDescription = "TEST";
		String doctorCategory = "SURGEON";
		String consultantName = "FSDFF";
		String instrumentName = "Test";
		String description = "CAMRA CASE";
		String quantity = "12";
		String rate = "12";
		String diagnosis = "testtest";

		ots.clickOnOtScenduleScreenLink(driver);
		ots.clickOnTheAddBtn(driver);
		ots.enterHospitalNumberInOtScheduling(driver, hospitalNumber);
		ots.otScheduling_Process(driver, operationTheater, surgeryType, surgeryNature, surgeryTime, duration,
				anastesiaType, specialNotes);
		ots.otScheduling_ProcessTwo(driver, department, surgeryDescription, doctorCategory, consultantName,
				instrumentName, description, quantity, rate, diagnosis);
		System.out.println("successsfully created");

		ots.enterHospitalNumber_Filter(driver, hospitalNumber);
		Thread.sleep(2000);
		ots.clickOnSearchBtn_Filters(driver);

		String hospitalNumber1 = ots.takeHospitalNumber_OtList(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);

		ots.clickOnHospitalNumber_OtList(driver);

		ocp.clickOnSubmitBtn(driver);
	}
}
