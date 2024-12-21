package com.Vims.NursingManagementTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.NursingDesk_WardServicesPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class NursingDesk_Ward_Services_Test extends BaseClass {

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOf_HospitalNumber_Test() throws Throwable {

		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);

		String hospitalNumber = nd.take_LastRowHospitalNumber_Table(driver);
		nd.enterHospitalNumberInTheText(hospitalNumber);
		nd.clickOnTheSearchButton(driver);
		String hospitalNumber1 = nd.take_HosptalNumberInThe_Table(driver);
		Assert.assertEquals(hospitalNumber, hospitalNumber1);
		System.out.println("Hospital Number filtered a successsfully");
	}

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOfWardType__Test() throws Throwable {

		String ward = "GENERAL WARD";

		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);
		nd.selectWardTypeDropdown(driver, ward);
		nd.clickOnTheSearchButton(driver);
		nd.wardType_List_InTheTable(driver, ward);
	}

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOf_RoomType_Test() throws Throwable {

		String roomType = "CT ICU";

		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);

		nd.selectRoomTypeDropdown(driver, roomType);
		nd.clickOnTheSearchButton(driver);
		nd.roomType_List_InThe_Table(driver, roomType);
	}

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOf_Department_Test() throws Throwable {
		String department = futil.getProperyKeyValue("cardiologyDepartment");

		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);
		nd.selcetDepartmentDropdown(driver, department);
		nd.clickOnTheSearchButton(driver);
		nd.take_Department_InTheTable(driver, department);

	}

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOf_ArriveDStatus_Test() throws Throwable {

		String status = "ARRIVED";
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);

		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		nd.take_Status_InTheTable(driver, status);
	}

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOf_DischargeIntimationDoneStatus_Test()
			throws Throwable {

		String status = "DISCHARGE INTIMATION DONE";
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);

		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		nd.take_Status_InTheTable(driver, status);
	}

	@Test
	public void checkThatUserShouldbe_FilterPatientDetails_WitHelpOf_NotArrivedStatus_Test() throws Throwable {

		String status = "NOT ARRIVED";
		NursingDesk_WardServicesPage nd = new NursingDesk_WardServicesPage(driver);
		HomePage hp = new HomePage(driver);

		nd.clickOnTheNursingDeskButton(driver);
		hp.homeBtnForvims(driver);

		nd.selectStatusDropdown(driver, status);
		nd.clickOnTheSearchButton(driver);
		nd.take_Status_InTheTable(driver, status);
	}

}
