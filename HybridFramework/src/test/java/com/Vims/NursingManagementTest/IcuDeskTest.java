package com.Vims.NursingManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.IcuDaskPage;

public class IcuDeskTest extends BaseClass {

	@Test
	public void createVentilator_Test() throws Throwable {
		String date = " ";
		String spo2 = "12";
		String tv = "22";
		String rate = "23";
		String fio2 = "12";
		String prsupport = "54";
		String peep = "23";
		String pc = "77";
		String oxygen = "123";
		String tpiece = "22";

		HomePage hp = new HomePage(driver);
		IcuDaskPage id = new IcuDaskPage(driver);

		id.clickOnIcuDesk(driver);
		hp.homeBtnForvims(driver);
		id.clickOnHospitalNumberInTable(driver);
		id.clickOnVentilatorPlusBtn(driver);
		id.createVentilatorSetup_1(driver, date, spo2, tv, rate, fio2, prsupport, peep, pc);
		id.createVentilatorSetup_2(driver, oxygen, tpiece);

		String errorMsg = id.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "icuChartHeader created successfully");
		System.out.println("sucessfully created");
	}

	@Test
	public void createGrbs_Test() throws Throwable {
		String date = " ";
		String type = "U GLUCOSE";
		String collectedAt = "BB";
		String value = "103";
		String remarks = "grbs monitoring";

		HomePage hp = new HomePage(driver);
		IcuDaskPage id = new IcuDaskPage(driver);

		id.clickOnIcuDesk(driver);
		hp.homeBtnForvims(driver);
		hp.homeBtnForvims(driver);
		id.clickOnIcuDesk(driver);
		id.clickOnHospitalNumberInTable(driver);
		id.clickOnGrbsMonitoringPlusBtn(driver);
		id.createGrbs(driver, date, type, collectedAt, value, remarks);
		String errorMsg = id.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "Successfully GRBS Monitoring is created");
		System.out.println("sucessfully created");
	}

	@Test
	public void createAbs_Test() throws Throwable {
		String ph = "123";
		String pco2 = "22";
		String po2 = "33";
		String so2 = "123";
		String lac = "67";
		String hco2 = "69";

		HomePage hp = new HomePage(driver);
		IcuDaskPage id = new IcuDaskPage(driver);

		id.clickOnIcuDesk(driver);
		hp.homeBtnForvims(driver);
		id.clickOnHospitalNumberInTable(driver);
		id.clickOnAbgMonitoringPlusBtn(driver);
		id.enterChooseTime_abg(driver);
		id.enterPh(driver, ph);
		id.enterPco2(driver, pco2);
		id.enterPo2(driver, po2);
		id.enterSo2(driver, so2);
		id.enterLac(driver, lac);
		id.enterHco2(driver, hco2);
		id.clickOnSubmit_ags(driver);
		String errorMsg = id.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "Successfully ABG Monitoring is created");
		System.out.println("sucessfully created");
	}

	@Test
	public void createNeuroMonitoring_Test() throws Throwable {
		String sizeOnRight = "12";
		String sizeOnLeft = "24";

		HomePage hp = new HomePage(driver);
		IcuDaskPage id = new IcuDaskPage(driver);

		id.clickOnIcuDesk(driver);
		hp.homeBtnForvims(driver);
		id.clickOnHospitalNumberInTable(driver);
		id.clickOnNeuroMonitoringPlusBtn(driver);
		id.enterChooseTime_neuroMonitoring(driver);
		id.enterSizeOnRight(driver, sizeOnRight);
		id.enterSizeOnleft(driver, sizeOnLeft);
		id.clickOnRightArmCheckBox(driver);
		id.clickOnLeftArmCheckBox(driver);
		id.clickOnRightLegCheckBox(driver);
		id.clickOnLeftLegCheckBox(driver);
		id.clickOnSubmit_NeuroMonitoring(driver);
		String errorMsg = id.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "neuroMonitoring created successfully");
		System.out.println("sucessfully created");
	}

	@Test
	public void createLinesAndTubes_Test() throws Throwable {
		String text = "223";

		HomePage hp = new HomePage(driver);
		IcuDaskPage id = new IcuDaskPage(driver);

		id.clickOnIcuDesk(driver);
		hp.homeBtnForvims(driver);
		id.clickOnHospitalNumberInTable(driver);
		id.clickOnLinesAndTubesPlusBtn(driver);
		id.clickOnListOfCheckBox_LinesAndTubes(driver);
		id.enterListOfText_LinesAndTubes(driver, text);
		id.clickOnSubmitBtn_linesAndTubes(driver);
		String errorMsg = id.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "Successfully Lines and Tubes is created");
		System.out.println("sucessfully created");
	}

	@Test
	public void createInputAndOutputCharting_Test() throws Throwable {
		String date = " ";
		String fluid = "12";
		String rtf = "22";
		String urin = "23";
		String oral = "54";
		String fj = "23";
		String drainValue = "77";
		String icd = "77";
		String ivf = "123";
		String rta = "50";
		String inputType = "111";
		String input = "222";
		String outputType = "333";
		String output = "444";

		HomePage hp = new HomePage(driver);
		IcuDaskPage id = new IcuDaskPage(driver);

		id.clickOnIcuDesk(driver);
		hp.homeBtnForvims(driver);
		id.clickOnHospitalNumberInTable(driver);
		id.clickOnIntakeAndOutputChartingPlusBtn(driver);
		id.enterChooseTime_IntakeAndOutputCharting(driver, date);
		id.enterFluid_IntakeAndOutputCharting(driver, fluid);
		id.enterRtf_IntakeAndOutputCharting(driver, rtf);
		id.enterUrinOutput_IntakeAndOutputCharting(driver, urin);
		id.enterOral_IntakeAndOutputCharting(driver, oral);
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		id.enterFj_IntakeAndOutputCharting(driver, fj);
		id.enterDrainValue_IntakeAndOutputCharting(driver, drainValue);
		id.enterIcd_IntakeAndOutputCharting(driver, icd);
		id.enterIvfSolution_IntakeAndOutputCharting(driver, ivf);
		id.enterRta_IntakeAndOutputCharting(driver, rta);
		id.enterInputType_IntakeAndOutputCharting(driver, inputType);
		id.enterInput_IntakeAndOutputCharting(driver, input);
		id.enterOutputType_IntakeAndOutputCharting(driver, outputType);
		id.enterOutput_IntakeAndOutputCharting(driver, output);
		id.clickOnSubmit_IntakeAndOutputCharting(driver);
		String errorMsg = id.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "intakeOutputCharting created successfully");
		System.out.println("sucessfully created");
	}

}
