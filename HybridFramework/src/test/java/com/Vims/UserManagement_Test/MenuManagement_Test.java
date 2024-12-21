package com.Vims.UserManagement_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.MenuManagement_Page;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class MenuManagement_Test extends BaseClass {

	@Test
	public void checkThatUserClickOnSubmitButton_WithoutGivingMandatoryFieldAs_MainMenu_Test() throws Throwable {

		String pageName = "Asset Master";
		String url = "/bio-medical-management";
		String title = "Asset Master";
		String msg = "Please Select Main Menu";

		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);

		menuManagement_Page.clickOn_AddButton(driver);
		menuManagement_Page.enter_PageName(driver, pageName);
		menuManagement_Page.enter_Url(driver, url);
		menuManagement_Page.enterTitle(driver, title);
		menuManagement_Page.clickOn_SubmitButton(driver);

		String msg1 = menuManagement_Page.take_Error_PopupMessage(driver);
		Assert.assertEquals(msg, msg1);
	}

	/*
	 * @Test public void
	 * checkThatUserClickOnSubmitButton_WithoutGivingMandatoryFieldAs_PageName_Test(
	 * ) throws Throwable { String mainMenu = "testtest"; String url =
	 * "/bio-medical-management"; String title = "Asset Master";
	 * 
	 * HomePage hp = new HomePage(driver); MenuManagement_Page mm = new
	 * MenuManagement_Page(driver);
	 * 
	 * mm.clickOn_MenuManagement(driver); hp.homeBtnForvims(driver);
	 * 
	 * mm.clickOn_AddButton(driver); mm.enter_MainMenu(driver, mainMenu);
	 * mm.enter_Url(driver, url); mm.enterTitle(driver, title);
	 * mm.clickOn_SubmitButton(driver); mm.clickOn_OKButton(driver); }
	 */

	@Test
	public void checkThatUserClickOnSubmitButton_WithoutGivingMandatoryFieldAs_Url_Test() throws Throwable {

		String mainMenu = "testtest";
		String pageName = "Asset Master";
		String title = "Asset Master";
		String msg = "Please Enter Page Url";

		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);

		menuManagement_Page.clickOn_AddButton(driver);
		menuManagement_Page.enter_MainMenu(driver, mainMenu);
		menuManagement_Page.enter_PageName(driver, pageName);
		menuManagement_Page.enterTitle(driver, title);
		menuManagement_Page.clickOn_SubmitButton(driver);

		String msg1 = menuManagement_Page.take_Error_PopupMessage(driver);
		Assert.assertEquals(msg, msg1);
	}

	@Test
	public void checkThatUserClickOnSubmitButton_WithoutGivingMandatoryFieldAs_Title_Test() throws Throwable {

		String mainMenu = "testtest";
		String pageName = "Asset Master";
		String url = "Asset Master";
		String msg = "Please Enter Page Title";

		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);

		menuManagement_Page.clickOn_AddButton(driver);
		menuManagement_Page.enter_MainMenu(driver, mainMenu);
		menuManagement_Page.enter_PageName(driver, pageName);
		menuManagement_Page.enter_Url(driver, url);
		menuManagement_Page.clickOn_SubmitButton(driver);

		String msg1 = menuManagement_Page.take_Error_PopupMessage(driver);
		Assert.assertEquals(msg, msg1);
	}

	@Test
	public void checkThatUserClickOnPlusButton_WithoutSelectinAnyFieldsTable_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);

		menuManagement_Page.clickOn_AddButton(driver);
		menuManagement_Page.clickOn_PlusButton_Table(driver);
		menuManagement_Page.clickOn_OKButton(driver);
	}

	@Test
	public void checkThatUserShouldAbleToClickOnBackButton_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);

		menuManagement_Page.clickOn_AddButton(driver);
		menuManagement_Page.clickOn_BackButton(driver);
	}

	@Test
	public void checkThatUserShouldAbleToClickOnCancelButton_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);

		menuManagement_Page.clickOn_AddButton(driver);
		menuManagement_Page.clickOn_CancelButton(driver);
	}

	@Test
	public void checkThatUserShouldAbleToClickOnActonsWithEdit_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		MenuManagement_Page menuManagement_Page = new MenuManagement_Page(driver);

		menuManagement_Page.clickOn_MenuManagement(driver);
		hp.homeBtnForvims(driver);
		menuManagement_Page.clickOn_Actions_With_Edit(driver);
	}

}
