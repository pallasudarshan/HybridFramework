package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.MHCPackagePage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class MhcPackageTest extends BaseClass{

	@Test
	public void verifyRateTypeSearchFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		MHCPackagePage mp = new MHCPackagePage(driver);
		
		String rateType="HOSPITAL";
		
		mp.clickOnMhcPackage(driver);
		hp.homeBtnForvims(driver);
		mp.selectRateType(driver, rateType);
		mp.clickOnSearch(driver);
		String rateType1 = mp.captureRateTypeInTable(driver);
		
		Assert.assertEquals(rateType, rateType1,"rate type is miss matched");
		System.out.println("succesfully verified");
	}
	
	@Test
	public void verifyPackageTypeSearchFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		MHCPackagePage mp = new MHCPackagePage(driver);
		
		String packageType="General Packages";
		
		mp.clickOnMhcPackage(driver);
		hp.homeBtnForvims(driver);
		mp.selectPackageType(driver, packageType);
		mp.clickOnSearch(driver);
		String packageType1 = mp.capturePackageTypeInTable(driver);
		Assert.assertEquals(packageType, packageType1,"package type is miss matched");
		System.out.println("succesfully verified");
	}
	
	@Test
	public void verifyPackageNameSearchFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		MHCPackagePage mp = new MHCPackagePage(driver);
		
		String packageName="ONCOLOGY PACKAGE WOMEN";
		
		mp.clickOnMhcPackage(driver);
		hp.homeBtnForvims(driver);
		mp.enterPackageName(driver, packageName);
		mp.clickOnSearch(driver);
		String packageName1 = mp.capturePackageNameInTable(driver);
		
		Assert.assertEquals(packageName, packageName1,"package name is miss matched");
		System.out.println("succesfully verified");
	}
	
//	@Test
//	public void createMhcPackage_Test() throws Throwable {
//		HomePage hp = new HomePage(driver);
//		MHCPackagePage mp = new MHCPackagePage(driver);
//		
//		String rateType="HOSPITAL RATE";
//		String packageType="General Packages";
//		String packageName="Automation package";
//		String transactionType="Cash";
//		String customer="MICHAEL JONES";
//		String packagePrice="10000";
//		String servicesName="sodium (NA+)";
//		String packageCost="5000";
//		String clinicName="VYDEHI CLINIC";
//		String department="CARDIOLOGY";
//		String actualCost="10000";
//		String packageCost1="10000";
//		
//		mp.clickOnMhcPackage(driver);
//		hp.homeBtnForvims(driver);
//		mp.clickOnAdd(driver);
//		mp.selectRateType(driver, rateType);
//		mp.selectPackageType(driver, packageType);
//		mp.enterPackageName(driver, packageName);
//		mp.selectTransactionType(driver, transactionType);
//		mp.selectCustomer(driver, customer);
//		mp.enterPackagePrice(driver, packagePrice);
//		mp.enterServiceName(driver, servicesName);
//		mp.enterPackageCost(driver, packageCost);
//		mp.clickOnAdd_serviceCharge(driver);
//		scrollToBottom(driver);
//		mp.selectClinicName(driver, clinicName);
//		mp.selectDepartment(driver, department);
//		mp.enterActualCost(driver, actualCost);
//		mp.enterPackageCost_consultationCharge(driver, packageCost1);
//		mp.clickOnAdd_ConsultationCharge(driver);
//		mp.clickOnSubmit(driver);
//		
//		
//	}
		
	
	
}
