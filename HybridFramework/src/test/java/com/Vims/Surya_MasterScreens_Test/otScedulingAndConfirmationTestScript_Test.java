package com.Vims.Surya_MasterScreens_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.OTSchedulingPage;
import com.Dalvkot.Vims_ObjectRepositary.otConfirmationPage;
@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class otScedulingAndConfirmationTestScript_Test extends BaseClass{
	
/*	@Test
	public void doOtSchedulingAndConfirmation() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		OTSchedulingPage ot=new OTSchedulingPage(driver);
		otConfirmationPage oc=new otConfirmationPage(driver);
		
		String  hospitalNumber="8315850";
		String  operationTheatre ="OPERATION THEATER 5";
		String  surgeryType="MAJOR";
		String  surgeryNature ="ELECTIVE";
		String  surgeryTime="1200";
		String  duration="6";
		String  anaestesiaType="GENERAL";
		String  specialNotes="TESTING";
		String  department="CARDIOLOGY";
		String  surgeryDescription ="FFR";
		String  doctorcategory="CARDIOLOGIST";
		String  consultantName="DR.VIJAYA SAI";
		String  instrumentName="123";
		String  description="C-ARM";
		String  quantity="5";
		String  rate="50";
		String  diagnosis="testsetst";
		
		//OT scheduling 
		hp.homeBtnForvims(driver);
		ot.clickOnOtScenduleScreenLink(driver);
		ot.clickOnTheAddBtn(driver);
		ot.enterHospitalNumber(driver, hospitalNumber);
		ot.enterDataInOtScheduling(driver,operationTheatre, surgeryType , surgeryNature,  surgeryTime,  duration,  anaestesiaType,  specialNotes,  department , surgeryDescription,  doctorcategory, consultantName,  instrumentName, description , quantity, rate,  diagnosis);
		
		//OT Confirmation
		hp.homeBtnForvims(driver);
		oc.clickOnOtConfirmationScreenBtn(driver);
		oc.clickOnHospitalNumberInTheTable(driver);
		oc.clickOnSubmitBtn(driver);
	}
	@Test
	public void verifyErroMsg() throws Throwable {

		HomePage hp = new HomePage(driver);
		OTSchedulingPage ot=new OTSchedulingPage(driver);
		
		String hospitalNumber="8315824";
		String msg=" Please Opertaion Theater Name ";
		
		hp.homeBtnForvims(driver);
		ot.clickOnOtScenduleScreenLink(driver);
		ot.clickOnTheAddBtn(driver);
		ot.enterHospitalNumber(driver, hospitalNumber);
		Thread.sleep(2000);
		ot.clickOnSubmit(driver);
		String errorMsg1 = ot.verifyErrorMsg(driver);
		Assert.assertEquals(errorMsg1, msg);
		System.out.println("User got the  :" + msg + "successfully");
		
	}*/
	
	
}
	    	    


