package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.ServiceClassLinkPage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class ServiceClassLinkTest extends BaseClass{
	
	@Test
	public void checkThatEditIsWorkingAsExpected_Test() throws Throwable{
		HomePage hp = new HomePage(driver);
		ServiceClassLinkPage sc = new ServiceClassLinkPage(driver);
		
		String serviceType="CATH LAB";
		String serviceGroup="CARDIOLOGY";
		String serviceClass="ADMISSION CHARGES";
		
		sc.clickOnServiceClassLink(driver);
		hp.homeBtnForvims(driver);
		sc.selectServiceGroup(driver, serviceGroup);
		sc.selectServiceClass(driver, serviceClass);
		sc.clickOnSearchBtn(driver);
		//sc.selectServiceType(driver, serviceType);
		sc.clickOnEditUnderAction(driver);
	}
	
	@Test
	public void serviceClassLinkFlow_Test() throws Throwable{
		HomePage hp = new HomePage(driver);
		ServiceClassLinkPage sc = new ServiceClassLinkPage(driver);
		
		String serviceType="CATH LAB";
		String serviceGroup="CARDIOLOGY";
		String serviceClass="ADMISSION CHARGES";
		
		sc.clickOnServiceClassLink(driver);
		hp.homeBtnForvims(driver);
		sc.clickOnAddBtn(driver);
		sc.selectServiceType(driver, serviceType);
		sc.selectServiceGroup(driver, serviceGroup);
		sc.selectServiceClass(driver, serviceClass);
		sc.clickOnSubmitBtn(driver);
		sc.clickOnOkBtn(driver);
	}
	
	@Test
	public void verifyNextBtnInPagination_Test() throws Throwable{
		HomePage hp = new HomePage(driver);
		ServiceClassLinkPage sc = new ServiceClassLinkPage(driver);
		
		sc.clickOnServiceClassLink(driver);
		hp.homeBtnForvims(driver);
		sc.clickOnClearBtn(driver);
		sc.verifyNextBtnIsWorkingAsExpected(driver);
	}
	
	@Test
	public void verifyPreviousBtnInPagination_Test() throws Throwable{
		HomePage hp = new HomePage(driver);
		ServiceClassLinkPage sc = new ServiceClassLinkPage(driver);
		
		sc.clickOnServiceClassLink(driver);
		hp.homeBtnForvims(driver);
		sc.clickOnClearBtn(driver);
		sc.verifyPreviousBtnIsWorkingAsExpected(driver);
	}
	
	@Test
	public void checkServiceGroupSearchFilter_Test() throws Throwable{
		HomePage hp = new HomePage(driver);
		ServiceClassLinkPage sc = new ServiceClassLinkPage(driver);
		
		String serviceGroup="CARDIOLOGY";
		
		sc.clickOnServiceClassLink(driver);
		hp.homeBtnForvims(driver);
		sc.clickOnClearBtn(driver);
		sc.selectServiceGroup(driver, serviceGroup);
		sc.clickOnSearchBtn(driver);
		String serviceGroup1 = sc.captureServiceGroupInTable(driver);
		Assert.assertEquals(serviceGroup, serviceGroup1);
	}
	
	@Test
	public void checkServiceClassSearchFilter_Test() throws Throwable{
		HomePage hp = new HomePage(driver);
		ServiceClassLinkPage sc = new ServiceClassLinkPage(driver);
		
		String serviceClass="ABDOMEN";
		
		sc.clickOnServiceClassLink(driver);
		hp.homeBtnForvims(driver);
		sc.clickOnClearBtn(driver);
		sc.selectServiceClass(driver, serviceClass);
		sc.clickOnSearchBtn(driver);
		String serviceClass1 = sc.captureServiceClass(driver);
		Assert.assertEquals(serviceClass, serviceClass1);
	}

}
