package com.Vims.NursingManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.NursingDeskPage;
import com.Dalvkot.Vims_ObjectRepositary.NursingDesk_WardServicesPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class NursingDesk_PatientChart_Test extends BaseClass {

	@Test
	public void createVentilatorSetupUnderPatientChart_Test() throws Throwable {
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
		String status1 = "ARRIVED";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nw = new NursingDesk_WardServicesPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nw.selectStatusDropdown(driver, status1);
		nw.clickOnTheSearchButton(driver);
		String status = np.take_StatusTable(driver);
		np.clickOnHospitalNumber_NursingDesk(driver, status);
		np.clickOnPatientChartTab(driver);
		np.clickOnVentilatorSetupTab(driver);
		np.clickOnPlusBtn_ventilatorSetUpPlanTab(driver);
		np.createVentilatorSetup_1(driver, date, spo2, tv, rate, fio2, prsupport, peep, pc);
		np.createVentilatorSetup_2(driver, oxygen, tpiece);
		String errorMsg = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "icuChartHeader created successfully");
		System.out.println("sucessfully created");
	}

	@Test
	public void createGrbsMonitoringUnderPatientChart_Test() throws Throwable {
		String status1 = "ARRIVED";
		String date = " ";
		String type = "U GLUCOSE";
		String collectedAt = "BB";
		String value = "103";
		String remarks = "grbs monitoring";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nw = new NursingDesk_WardServicesPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nw.selectStatusDropdown(driver, status1);
		nw.clickOnTheSearchButton(driver);
		String status = np.take_StatusTable(driver);
		np.clickOnHospitalNumber_NursingDesk(driver, status);
		np.clickOnPatientChartTab(driver);
		np.clickOnGrbsMonitoringTab(driver);
		np.createGrbsUnderGrbsMonitoring(driver, date, type, collectedAt, value, remarks);
		String errorMsg = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "Successfully GRBS Monitoring is created");
		System.out.println("sucessfully created");
	}

	@Test
	public void createLinesAndTubesUnderPatientChart_Test() throws Throwable {
		String status1 = "ARRIVED";
		String text = "223";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nw = new NursingDesk_WardServicesPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nw.selectStatusDropdown(driver, status1);
		nw.clickOnTheSearchButton(driver);
		String status = np.take_StatusTable(driver);
		np.clickOnHospitalNumber_NursingDesk(driver, status);
		np.clickOnPatientChartTab(driver);
		np.clickOnLinesAndTubesTab(driver);
		np.clickOnPlusBtn_LinesAndtubesTab(driver);
		np.clickOnListOfCheckBox_LinesAndTubes(driver);
		np.enterListOfText_LinesAndTubes(driver, text);
		np.clickOnSubmitBtn_linesAndTubesTab(driver);
		String errorMsg = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "Successfully Lines and Tubes is created");
		System.out.println("sucessfully created");
	}

	@Test
	public void createInputAndOutputChartingUnderPatientChart_Test() throws Throwable {
		String date = " ";
		String fluid = "12";
		String rtf = "22";
		String urin = "23";
		String oral = "54";
		String fj = "23";
		String drainValue = "77";
		String icd = "77";
		String ivf = "123";
		String rtf1 = "22";
		String other = "43";
		String status1 = "ARRIVED";

		HomePage hp = new HomePage(driver);
		NursingDeskPage np = new NursingDeskPage(driver);
		NursingDesk_WardServicesPage nw = new NursingDesk_WardServicesPage(driver);

		np.clickOnNursingDesk(driver);
		hp.homeBtnForvims(driver);
		nw.selectStatusDropdown(driver, status1);
		nw.clickOnTheSearchButton(driver);
		String status = np.take_StatusTable(driver);
		np.clickOnHospitalNumber_NursingDesk(driver, status);
		np.clickOnPatientChartTab(driver);
		np.clickOnIntakeAndOutputChartingTab(driver);
		np.clickOnPlusBtn_IntakeAndOutputChartingTab(driver);
		np.enterChooseTime_IntakeAndOutputCharting(driver, date);
		np.enterFluid_IntakeAndOutputCharting(driver, fluid);
		np.enterRtf_IntakeAndOutputCharting(driver, rtf);
		np.enterUrinOutput_IntakeAndOutputCharting(driver, urin);
		np.enterOral_IntakeAndOutputCharting(driver, oral);
		scrollDownByUsingActionClass(driver);
		scrollDownByUsingActionClass(driver);
		np.enterFj_IntakeAndOutputCharting(driver, fj);
		np.enterDrainValue_IntakeAndOutputCharting(driver, drainValue);
		np.enterIcd_IntakeAndOutputCharting(driver, icd);
		np.enterIvfSolution_IntakeAndOutputCharting(driver, ivf);
		np.enterRtf_Aspiration_IntakeAndOutputCharting(driver, rtf1);
		np.enterOther_IntakeAndOutputCharting(driver, other);
		np.clickOnSubmit_IntakeAndOutputCharting(driver);
		String errorMsg = np.captureErrorPopUpmsg(driver);
		Assert.assertEquals(errorMsg, "intakeOutputCharting created successfully");
		System.out.println("sucessfully created");
	}
}
