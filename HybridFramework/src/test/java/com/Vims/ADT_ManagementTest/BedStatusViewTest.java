package com.Vims.ADT_ManagementTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.AllPatientListPage;
import com.Dalvkot.Vims_ObjectRepositary.BedMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.BedStatusViewPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class BedStatusViewTest extends BaseClass {

	@Test
	public void checkThatUserShouldbeVerifyThe_TotalNumberOfBedsCount_Test() throws Throwable {

		String wardType = "GENERAL WARD";
		String roomType = "DAY CARE";

		HomePage hp = new HomePage(driver);
		BedStatusViewPage bs = new BedStatusViewPage(driver);

		bs.clickOn_BedStatusView(driver);
		hp.homeBtnForvims(driver);
		bs.select_WardType(driver, wardType);
		bs.select_RoomType(driver, roomType);
		bs.clickOn_SearchButton(driver);
		bs.count_TotalNumberOfBeds(driver);
	}

	@Test
	public void checkThatUserShouldbeVerifyTheHospitalNumberInTheList_Test() throws Throwable {

		String patientStatus = "ACTIVE";

		AllPatientListPage alp = new AllPatientListPage(driver);
		BedStatusViewPage bsv = new BedStatusViewPage(driver);
		HomePage hp = new HomePage(driver);

		alp.clickOnTheAllPatientListButton(driver);
		hp.homeBtnForvims(driver);
		alp.clickOnClearButton(driver);
		alp.selectPatientStatusDropdown(driver, patientStatus);
		String wardType = alp.takeWardTypeNameInTheActivePatinet_Table(driver);
		String roomType = alp.takeRoomTypeInTheActivePatinet_Table(driver);
		String hospitalNumber = alp.takeTheHospitalNumberInTheActivePatientTable(driver);
		bsv.clickOn_BedStatusView(driver);
		hp.homeBtnForvims(driver);
		bsv.select_WardType(driver, wardType);
		bsv.select_RoomType(driver, roomType);
		bsv.enterHospitalNumber(driver, hospitalNumber);
		bsv.clickOn_SearchButton(driver);
		String hospitalNumber1 = bsv.capture_HospitalNumber_List(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
	}

}
