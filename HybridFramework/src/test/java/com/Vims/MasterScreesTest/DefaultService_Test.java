package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.DefaultServices_Page;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class DefaultService_Test extends BaseClass {

	@Test
	public void checkThatUserShouldErrorPopupIfClickOnSubmitWithoutSelecting_WardName_Test() throws Throwable {
		String msg = "Please Select The Ward Name..!";

		HomePage hp = new HomePage(driver);
		DefaultServices_Page dsp = new DefaultServices_Page(driver);

		dsp.clickOnDefaultServiceLink(driver);
		hp.homeBtnForvims(driver);
		dsp.clickOnSubmitButton(driver);

		String msg1 = dsp.takeErrorPopupMessage(driver);
		Assert.assertEquals(msg1, msg);
	}

	@Test
	public void checkThatUserShouldErrorPopupIfClickOnSubmitWithoutSelecting_RateType_Test() throws Throwable {

//		String msg = "\\\"rateType\\\" must be a string";
//		String serviceNames = "ENDOLOOP EACH UNIT";
//		String period = "DAILY APPLICABLE";
//		String count = "1";
//		String ward = "DAY CARE";
//
//		HomePage hp = new HomePage(driver);
//		DefaultServices_Page dsp = new DefaultServices_Page(driver);
//
//		dsp.clickOnDefaultServiceLink(driver);
//		hp.homeBtnForvims(driver);
//		dsp.selectWardName(driver, ward);
//		dsp.enterServiceNameText_ServiceDetails(driver, serviceNames);
//		dsp.selectPeriod_ServiceDetails(driver, period);
//		dsp.enterCount_ServiceDetails(driver, count);
//		dsp.clickOnAction_ServiceDetail(driver);
//		dsp.clickOnSubmitButton(driver);
//		Thread.sleep(3000);
//		String msg1 = dsp.takeErrorPopupMessage(driver);
//		Assert.assertEquals(msg1, msg);

	}

	@Test
	public void checkThatUserShouldErrorPopupIfClickOnSubmitWithoutEntering_ServiceNames_Test() throws Throwable {

		String msg = "Please Enter service";
		String ward = "DAY CARE";
		String rateType = "TPA RATE";

		HomePage hp = new HomePage(driver);
		DefaultServices_Page dsp = new DefaultServices_Page(driver);

		dsp.clickOnDefaultServiceLink(driver);
		hp.homeBtnForvims(driver);

		dsp.selectWardName(driver, ward);
		dsp.selectRateType(driver, rateType);
		dsp.clickOnSubmitButton(driver);

		String msg1 = dsp.errorPopupMessage_Corner(driver);
		Assert.assertEquals(msg1, msg);

	}
}
