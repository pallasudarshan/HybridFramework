package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.ServiceMasterpage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class ServiceMasterTest extends BaseClass {

	@Test
	public void createServiceMaster_Test() throws Throwable {
		JavaUtility j = new JavaUtility();
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String serviceType = "BED CHARGES";
		String serviceGroup = "BED CHARGES";
		String serviceClass = "BED CHARGES";
		String serviceShortName = "t" + j.getRandomNumber();
		String serviceName = "BED123";
		String gender = "BOTH";
		String baseRate = "1000";
		String tatTime = "5";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.clickOnAdd(driver);
		sm.selectServiceType(driver, serviceType);
		sm.selectServiceGroup(driver, serviceGroup);
		sm.selectServiceClass(driver, serviceClass);
		sm.enterServiceShortName(driver, serviceShortName);
		sm.enterServiceName(driver, serviceName);
		sm.selectGender(driver, gender);
		sm.enterServiceBaseRate(driver, baseRate);
		sm.enterTatTime(driver, tatTime);
		sm.clickOnSubmit(driver);
	}

	@Test
	public void checkServiceTypeFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String serviceType = "INVESTIGATION";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterServiceType_Filter(driver, serviceType);
		String serviceType1 = sm.captureServiceTypeInTable(driver);
		Assert.assertEquals(serviceType, serviceType1);
		System.out.println("service type filter is verified");
	}

	@Test
	public void checkServiceGroupFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String serviceGroup = "LABORATORY";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterServiceGroup_Filter(driver, serviceGroup);
		String serviceGroup1 = sm.captureServiceGroupInTable(driver);
		Assert.assertEquals(serviceGroup, serviceGroup1);
		System.out.println("service group filter is verified");
	}

	@Test
	public void checkServiceClassFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String serviceClass = "DIETARY";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterServiceClass_Filter(driver, serviceClass);
		String serviceClass1 = sm.captureServiceClassInTable(driver);
		Assert.assertEquals(serviceClass, serviceClass1);
		System.out.println("service class filter is verified");
	}

	@Test
	public void checkServiceNameFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String serviceName = "ALDOSTERONE,24-HOURURINE,Radioimmunoassay";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterServiceName_Filter(driver, serviceName);
		String serviceName1 = sm.captureServiceNameInTable(driver);
		Assert.assertEquals(serviceName, serviceName1);
		System.out.println("service name filter is verified");
	}

	@Test
	public void checkServiceCodeFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String serviceCode = "AM0015";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterServiceCode_Filter(driver, serviceCode);
		String serviceCode1 = sm.captureServiceCodeInTable(driver);
		Assert.assertEquals(serviceCode, serviceCode1);
		System.out.println("service code filter is verified");
	}

	@Test
	public void checkBaseRateFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String baseRate = "2144";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterBaseRate_Filter(driver, baseRate);
		String baseRate1 = sm.captureBaseRateInTable(driver);
		Assert.assertEquals(baseRate, baseRate1);
		System.out.println("base rate filter is verified");
	}

	@Test
	public void checkServiceShortNameFilter_Test() throws Throwable {
		String shortName = "DHEA-S";

		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterServiceShortName(driver, shortName);
		String shortName1 = sm.captureShortNameInTable(driver);
		System.out.println(shortName1);
		Assert.assertEquals(shortName, shortName1);
		System.out.println("short name filter is verified");
	}

	@Test
	public void checkBaserateFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String baseRate = "1280";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterBaseRate_Filter(driver, baseRate);
		String baseRate1 = sm.captureBaseRateInTable(driver);
		Assert.assertEquals(baseRate, baseRate1);
		System.out.println("base rate filter is verified");
	}

	@Test
	public void checkShortNameFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String shortName = "DIET";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterShortName_Filter(driver, shortName);
		String shortName1 = sm.captureShortNameInTable(driver);
		Assert.assertEquals(shortName, shortName1);
		System.out.println("short name filter is verified");
	}

	@Test
	public void checkLabLinkFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String labLink = "Yes";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterLabLink_Filter(driver, labLink);
		String labLink1 = sm.captureLabLinkInTable(driver);
		Assert.assertEquals(labLink, labLink1);
		System.out.println("lab link filter is verified");
	}

	@Test
	public void checkApplicableFilter_Test() throws Throwable {
		HomePage hp = new HomePage(driver);
		ServiceMasterpage sm = new ServiceMasterpage(driver);

		String applicableGender = "BOTH";

		sm.clickOnServiceMasterScreen(driver);
		hp.homeBtnForvims(driver);
		sm.enterApplicableGender_Filter(driver, applicableGender);
		String applicableGender1 = sm.captureApplicableGenerInTable(driver);
		Assert.assertEquals(applicableGender, applicableGender1);
		System.out.println("applicable gender filter is verified");
	}

//	@Test
//	public void verifyNextBtnPaginationIsWorkingAsExpected_Test() throws Throwable{
//		HomePage hp = new HomePage(driver);
//		ServiceMasterpage sm = new ServiceMasterpage(driver);
//		
//		sm.clickOnServiceMasterScreen(driver);
//		hp.homeBtnForvims(driver);
//		sm.verifyNextBtnIsWorkingAsExpected(driver);
//		
//	}
}
