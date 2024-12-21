package com.Vims.UserManagement_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DoctorDeskPermissionPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DoctorDeskPermissionsTest extends BaseClass {
	
	@Test
	public void checkThatUserClickOnPermissionButtonWithoutSelectingAnyMandatoryField_Test() throws Throwable {
		HomePage homepage = new HomePage(driver);
		DoctorDeskPermissionPage doctorDeskPermissionPage = new DoctorDeskPermissionPage(driver);

		doctorDeskPermissionPage.clickOn_DoctorDeskPermission(driver);
		homepage.homeBtnForvims(driver);
		doctorDeskPermissionPage.clickOn_PermissionButton(driver);
		doctorDeskPermissionPage.clickOn_OkButton(driver);
	}

	@Test
	public void checkThatUserShoudlAbleToGiveThePermission_Test() throws Throwable {
		String userType = "DOCTOR";
		String roleType = "ADMIN";
		String role = "CARDIOLOGIST";
		String organisation = "SRINIVASA TRUST";
		String group = "ASDSD";
		String buisnessId = "SAEFWE";
		String type = "OP";

		HomePage homepage = new HomePage(driver);
		DoctorDeskPermissionPage doctorDeskPermissionPage = new DoctorDeskPermissionPage(driver);

		doctorDeskPermissionPage.clickOn_DoctorDeskPermission(driver);
		homepage.homeBtnForvims(driver);

		doctorDeskPermissionPage.select_UserType(driver, userType);
		doctorDeskPermissionPage.select_RoleType(driver, roleType);
		doctorDeskPermissionPage.select_Role(driver, role);
		doctorDeskPermissionPage.select_Organisation(driver, organisation);
		doctorDeskPermissionPage.select_Group(driver, group);
		doctorDeskPermissionPage.select_BuisnessId(driver, buisnessId);
		doctorDeskPermissionPage.select_Type(driver, type);
		doctorDeskPermissionPage.clickOn_PermissionButton(driver);
		doctorDeskPermissionPage.clickOn_OkButton(driver);
	}

}
