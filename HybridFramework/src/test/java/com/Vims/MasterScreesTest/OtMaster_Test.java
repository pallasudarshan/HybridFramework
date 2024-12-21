package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OtMasterPage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class OtMaster_Test extends BaseClass{

	
	
	@Test(priority = 1)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingOtDescription_Test() throws Throwable {
		
		String msg1="Please Select OT Description";
		
		HomePage hp =new HomePage(driver);
		OtMasterPage op=new OtMasterPage(driver);
		
		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.clickOnTheSubmitButton_Speciality();
		String msg = op.errorMessage_MandatoryField(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "successfully");

	}
	@Test(priority = 2)
	public void checkThatUserClickOnTheSubmitButtonWithoutSelectingStoreDescription_Test() throws Throwable {
        String msg1="Please Select Store Description";
        String otDescription="OPERATION THEATER 17";
		
		HomePage hp =new HomePage(driver);
		OtMasterPage op=new OtMasterPage(driver);
		
		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.selectOtDescriptionDropdown(driver, otDescription);
		op.clickOnTheSubmitButton_Speciality();
		String msg = op.errorMessage_MandatoryField(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "successfully");
	}
	
	@Test(priority = 3)
	public void checkThatClickOnTheActionBtnWithoutSelectingClinicalDepartmentInSpeciality_Test() throws Throwable {
		String otDescription = "OPERATION THEATER 17";
		String storeDescription="BLOOD BANK";
		String msg1="Please Select Speciality Details";

		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.selectOtDescriptionDropdown(driver, otDescription);
		op.selectStoreDescriptionDropdown(driver, storeDescription);
		op.clickOnTheActionsBtn_Speciality();
		String msg = op.errorMessage_MandatoryField(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "successfully");
	}

	@Test(priority = 4)
	public void clickOnTheSubmitButtonWithoutSelectingSpecialtyDetails_Test() throws Throwable {
		String otDescription = "OPERATION THEATER 17";
		String storeDescription="BLOOD BANK";
		
		
		
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.selectOtDescriptionDropdown(driver, otDescription);
		op.selectStoreDescriptionDropdown(driver, storeDescription);
		op.clickOnTheSubmitButton_Speciality();
		System.out.println("User got error message sucessfully");
		
	}
	
	
	@Test(priority = 5)
	public void clickOnTheDeleteInTheSpecialtyDetailsInTheTable_Test() throws Throwable {
		String clinicalDepartment="CLINICAL";
		String clinicalDepartment1="BILLING";
		String clinicalDepartment2="CARDIOLOGY";
		String clinicalDepartment3="DERMATOLOGY";
		
		
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.selectClinicalDepartmentDropdown(driver, clinicalDepartment);
	    op.clickOnTheActionsBtn_Speciality();
	    op.selectClinicalDepartmentDropdown(driver, clinicalDepartment1);
	    op.clickOnTheActionsBtn_Speciality();
	    op.selectClinicalDepartmentDropdown(driver, clinicalDepartment2);
	    op.clickOnTheActionsBtn_Speciality();
	    op.selectClinicalDepartmentDropdown(driver, clinicalDepartment3);
	    op.clickOnTheActionsBtn_Speciality();
	  
	    op.clickOnTheDeleteButton_Action_SpecialityTable(driver);
	    System.out.println("Deleted In The Specialty Details In The Table successfully");
	   
	}
	
	@Test(priority = 6)
	public void selectOtDescriptionAndStoreDescriptionWhichAlreadySelectedCombination_Test() throws Throwable {
		
		String otDescription = "OPERATION THEATER 17";
		String storeDescription="BLOOD BANK";
		String clinicalDepartment="CLINICAL";

		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.selectOtDescriptionDropdown(driver, otDescription);
		op.selectStoreDescriptionDropdown(driver, storeDescription);
		op.selectClinicalDepartmentDropdown(driver, clinicalDepartment);
		op.clickOnTheActionsBtn_Speciality();
		op.clickOnTheSubmitButton_Speciality();
		op.clickOnOkSuccessMessageButton();
		System.out.println("User got error popup successfully");
		
	}
	@Test(priority = 7)
	public void clickOnTheActionBtnWithoutSelecting_EnteringInstrumentsDetails_Test() throws Throwable {
		String msg1="Please Select Instrument Details";
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		
		op.clickOnTheInstrumentsTab(driver);
		op.clickOnTheActionsBtn_Instruments();
		
		String msg = op.errorMessage_MandatoryField(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the  :" + msg + "successfully");
	}
		
		

	@Test(priority = 8)
	public void UserAbelToAddTheInstrumentsDetailsAndDeletingTheDetails_Test() throws Throwable {
        String instrmentsDetails="CAMRA CASE";
        String instrmentsDetails1="ARTHROSCOPE";
        String instrmentsDetails2="ENT MICRO SCOPE";
        String qty="12";
        
        
 
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		op.clickOnTheInstrumentsTab(driver);
		op.selectInstrumentsDetailsDropdown(driver,instrmentsDetails);
		op.enterTheQuantity(qty);
		op.clickOnTheActiveStatus();
		op.clickOnTheActionsBtn_Instruments();
		
		op.selectInstrumentsDetailsDropdown(driver,instrmentsDetails1);
		op.enterTheQuantity(qty);
		op.clickOnTheActiveStatus();
		op.clickOnTheActionsBtn_Instruments();
		
		op.selectInstrumentsDetailsDropdown(driver,instrmentsDetails2);
		op.enterTheQuantity(qty);
		op.clickOnTheActiveStatus();
		op.clickOnTheActionsBtn_Instruments();
		
		op.clickOnTheDeleteButton_Action_InstrumentsTable();
		
        System.out.println("User deleted a instruments deleted successfuly");
	}
	@Test(priority = 9)
	public void UserAbleClickOnTheCancelButton_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnTheAddButton(driver);
		
		op.clickOnTheCancelBtn_Speciality();
		System.out.println("User Clicked on the cancel button successfully");
	}
	@Test(priority = 10)
	public void Search_FilterTheStoreName_Test() throws Throwable {
		String storeName="HOSPITAL ADMINISTRATION";
		
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.selectStoreNameDropdown(driver,storeName);
		op.clickOnTheSearchButton(driver);
		String storeName1=op.storeNameInTheTable(driver);
		Assert.assertEquals(storeName, storeName1);
		System.out.println("User got same filtered store name in the table :"+storeName1);
	}
	
	@Test(priority = 11)
	public void userShouldAbleToClickOnTheClearButton_Test() throws Throwable {
        String storeName="HOSPITAL ADMINISTRATION";
        String name1="Select Store Name";
		
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.selectStoreNameDropdown(driver,storeName);
		op.clickOnTheSearchButton(driver);
		op.clickOnTheClearButton_ForLoader(driver);
		String name=op.storeNameInTheDropdown();
		Assert.assertEquals(name1, name);
		System.out.println("User cleared store name in the store type dropdown successfully");
		
		
		
		
	}
	/*@Test
	public void UserShouldAbleToForwardOnePageToAnotherPage_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		OtMasterPage op = new OtMasterPage(driver);

		hp.homeBtnForvims(driver);
		op.clickOnTheOtMasterLink(driver);
		op.clickOnThePageNumbersInTheTable();
		
		
	}*/
		
	}