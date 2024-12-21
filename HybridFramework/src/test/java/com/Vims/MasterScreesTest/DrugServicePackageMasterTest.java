package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DrugServicePackageMasterPage;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DrugServicePackageMasterTest extends BaseClass{
	
	@Test
	public void createService_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		DrugServicePackageMasterPage ds = new DrugServicePackageMasterPage(driver);
		
		String packageType ="Service";
		String packageName="Test";
		String applicableTo="OP";
		String description="ActitestandFibrotes";
		String qty="2";
		
		ds.clickOnDrugServicePackageMasterBtn(driver);
		hp.homeBtnForvims(driver);
        ds.clickOnNewBtn(driver);
		ds.selectPackageType(driver, packageType);
		ds.enterPackageName(driver, packageName);
		ds.selectApplicableTo(driver, applicableTo);
		ds.enterDrugDescription(driver, description);
        ds.enterQuantity(driver, qty);
		ds.clickOnStatusBtn(driver);
		ds.clickOnAddBtnInTable(driver);
		ds.clickOnSubmitBtn(driver);
	}

	@Test
	public void verify_PleaseEnterLineItems_ErrorMsg_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		DrugServicePackageMasterPage ds = new DrugServicePackageMasterPage(driver);
		
		ds.clickOnDrugServicePackageMasterBtn(driver);
		hp.homeBtnForvims(driver);
		ds.clickOnNewBtn(driver);
		ds.clickOnSubmitBtn(driver);
		String errorMsg = ds.captureErrormsg(driver);
		Assert.assertEquals(errorMsg, "Please enter Lineitems");
		System.out.println("successfully error msg verified");
	}
	
	@Test
	public void verifyThatDeleteBtnInWorkingAsExpected_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		DrugServicePackageMasterPage ds = new DrugServicePackageMasterPage(driver);
		
		String packageType ="Service";
		String packageName="Test";
		String applicableTo="OP";
		String description="ActitestandFibrotes";
		String qty="2";
		
		ds.clickOnDrugServicePackageMasterBtn(driver);
		hp.homeBtnForvims(driver);
		ds.clickOnNewBtn(driver);
		ds.selectPackageType(driver, packageType);
		ds.enterPackageName(driver, packageName);
		ds.selectApplicableTo(driver, applicableTo);
		int counter = 1;
		while(counter<5) {
		ds.addLineItems(driver, description, qty);
		counter ++;
		}
		int counter1 = 1;
		while(counter1<5) {
		ds.clickOnDelete(driver);
		counter1 ++;
		}
	}
}
