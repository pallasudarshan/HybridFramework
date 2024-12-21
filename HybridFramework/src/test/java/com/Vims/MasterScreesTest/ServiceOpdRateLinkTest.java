package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.ServiceOPDRateLinkPage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class ServiceOpdRateLinkTest extends BaseClass{
	
	@Test
	public void checkServiceTypeSearchFilter_Test() throws Throwable{
		ServiceOPDRateLinkPage so = new ServiceOPDRateLinkPage(driver);
		HomePage hp = new HomePage(driver);
		
		String serviceType="INVESTIGATION";
		
		so.clickOnServiceOpdRateLinkPage(driver);
		hp.homeBtnForvims(driver);
		so.selectServiceType(driver, serviceType);
		so.clickOnSearch(driver);
		String serviceType1 = so.captureServiceType_Table(driver);
	    Assert.assertEquals(serviceType,serviceType1);
	}
	

	@Test
	public void checkServiceGroupSearchFilter_Test() throws Throwable{
		ServiceOPDRateLinkPage so = new ServiceOPDRateLinkPage(driver);
		HomePage hp = new HomePage(driver);
		
		String serviceGroup="LABORATORY";
		
		so.clickOnServiceOpdRateLinkPage(driver);
		hp.homeBtnForvims(driver);
		so.selectServiceGroup(driver, serviceGroup);
		so.clickOnSearch(driver);
		String serviceGroup1 = so.captureServiceGroup_Table(driver);
	    Assert.assertEquals(serviceGroup,serviceGroup1);
	}
	
	@Test
	public void checkServiceClassSearchFilter_Test() throws Throwable{
		ServiceOPDRateLinkPage so = new ServiceOPDRateLinkPage(driver);
		HomePage hp = new HomePage(driver);
		
		String serviceClass="HAEMATOLOGY";
		
		so.clickOnServiceOpdRateLinkPage(driver);
		hp.homeBtnForvims(driver);
		so.selectServiceClass(driver,serviceClass);
		so.clickOnSearch(driver);
		String serviceClass1 = so.captureServiceClass_Table(driver);
	    Assert.assertEquals(serviceClass,serviceClass1);
	}
	
	@Test
	public void checkServiceNameSearchFilter_Test() throws Throwable{
		ServiceOPDRateLinkPage so = new ServiceOPDRateLinkPage(driver);
		HomePage hp = new HomePage(driver);
		
		so.clickOnServiceOpdRateLinkPage(driver);
		hp.homeBtnForvims(driver);
		 String serviceName=so.captureServiceName_Table_LastRow(driver);
		so.enterServiceName(driver, serviceName);
		so.clickOnSearch(driver);
		String serviceName1 = so.captureServiceName_Table(driver);
	    Assert.assertEquals(serviceName,serviceName1);
	}
	
	@Test
	public void checkServiceCodeSearchFilter_Test() throws Throwable{
		ServiceOPDRateLinkPage so = new ServiceOPDRateLinkPage(driver);
		HomePage hp = new HomePage(driver);
		
		so.clickOnServiceOpdRateLinkPage(driver);
		hp.homeBtnForvims(driver);
		 String serviceCode=so.captureServiceCode_Table_LastRow(driver);
		so.enterServiceCode(driver, serviceCode);
		so.clickOnSearch(driver);
		String ServiceCode1 = so.captureServiceCode_Table(driver);
	    Assert.assertEquals(serviceCode,ServiceCode1);
	}

}
