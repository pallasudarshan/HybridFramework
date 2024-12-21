package com.Vims.UserManagement_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.MenuPermissionPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class MenuPermissionTest extends BaseClass {

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_UserType_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);
		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");

	}

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_RoleType_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";
		String roleType = "SYSTEM USERS";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, roleType);
		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");

	}

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_Role_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";
		String userType = "SYSTEM USERS";
		String roleType = "BILLING";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, userType);
		mp.selectRoleType(driver, roleType);
		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");
	}

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_Organization_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";
		String userType = "SYSTEM USERS";
		String roleType = "BILLING";
		String role = "ADMIN";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, userType);
		mp.selectRoleType(driver, roleType);
		mp.selectRole(driver, role);

		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");
	}

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_Group_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";
		String userType = "SYSTEM USERS";
		String roleType = "BILLING";
		String role = "ADMIN";
		String origanization = "SRINIVASA TRUST";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, userType);
		mp.selectRoleType(driver, roleType);
		mp.selectRole(driver, role);
		mp.selectOrganization(driver, origanization);

		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");
	}

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_BuinessId_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";
		String userType = "SYSTEM USERS";
		String roleType = "BILLING";
		String role = "ADMIN";
		String origanization = "SRINIVASA TRUST";
		String group = "ASDSD";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, userType);
		mp.selectRoleType(driver, roleType);
		mp.selectRole(driver, role);
		mp.selectOrganization(driver, origanization);
		mp.selectGroup(driver, group);

		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");
	}

	@Test
	public void CheckThatUserShouldGetTheErrorPopup_FillAllDetailsExcept_MenuList_Test() throws Throwable {
		String msg = "Please Fill Mandatory(*) Fileds";
		String userType = "SYSTEM USERS";
		String roleType = "BILLING";
		String role = "ADMIN";
		String origanization = "SRINIVASA TRUST";
		String group = "VYDEHI GROUP";
		String buinessId = "VIMS";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, userType);
		mp.selectRoleType(driver, roleType);
		mp.selectRole(driver, role);
		mp.selectOrganization(driver, origanization);
		mp.selectGroup(driver, group);
		mp.selectBuinessId(driver, buinessId);

		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got a error popup message");
	}

	@Test
	public void CheckThatUserShouldCreateMenuPermission_Test() throws Throwable {
		String msg = "Page Permission Updated Successfully";
		String userType = "SYSTEM USERS";
		String roleType = "BILLING";
		String role = "ADMIN";
		String origanization = "SRINIVASA TRUST";
		String group = "VYDEHI GROUP";
		String buinessId = "VIMS";
		String menuList = "OPERATION THEATER";

		HomePage hp = new HomePage(driver);
		MenuPermissionPage mp = new MenuPermissionPage(driver);

		mp.clickOnMenuPermissionButton(driver);
		hp.homeBtnForvims(driver);

		mp.selectUserType(driver, userType);
		mp.selectRoleType(driver, roleType);
		mp.selectRole(driver, role);
		mp.selectOrganization(driver, origanization);
		mp.selectGroup(driver, group);
		mp.selectBuinessId(driver, buinessId);
		mp.selectMenuList(driver, menuList);

		mp.clickOnPermissionButton(driver);
		String msg1 = mp.takeTheErrorMessage_And_ClickOnOkButton(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, msg1);
	}

}
