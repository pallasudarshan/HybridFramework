package com.Vims.MasterScreesTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;
import com.Dalvkot.Vims_GenericUtility.JavaUtility;
import com.Dalvkot.Vims_ObjectRepositary.HomePage;
import com.Dalvkot.Vims_ObjectRepositary.SurgeryMasterPage;

@Listeners(com.Dalvkot.Vims_GenericUtility.ListenerImp.class)
public class SurgeryMaster_Test extends BaseClass {

	// Tc-1
	@Test
	public void checkThatWithoutSelectingDepartementMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {
		String msg1 = "Please select Department";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the :" + msg + "  :popup message successfully");
	}

	// Tc-2
	@Test
	public void checkThatWithoutSelectingSubGroupMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {

		String departmentName = "CARDIOLOGY";
		String msg1 = "Please select Sub Group";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the :" + msg + "  :popup message successfully");

	}

	// Tc-3
	@Test
	public void checkThatWithoutEnteringSurgeryNameMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {
		String departmentName = "CARDIOLOGY";
		String subGroup = "UROLOGY";
		String msg1 = "Please select Surgery Name";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.selectSubGroupDropdown(driver, subGroup);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the :" + msg + "  :popup message successfully");
	}

	// Tc-4
	@Test
	public void checkThatWithoutEnteringServiceShortNameMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {
		String departmentName = "CARDIOLOGY";
		String subGroup = "UROLOGY";
		String surgeryName = "Heart transplant";
		String msg1 = "Please enter Surgery Short Name";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.selectSubGroupDropdown(driver, subGroup);
		sp.enterTheDataInTheSurgeryName(surgeryName);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the :" + msg + " : popup message successfully");
	}

	// Tc-5
	@Test
	public void checkThatWithoutSelectingOtGradeMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {
		String departmentName = "CARDIOLOGY";
		String subGroup = "UROLOGY";
		String surgeryName = "Heart transplant";
		String serviceShortName = "Test";

		String msg1 = "Please Select OT Grade";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.selectSubGroupDropdown(driver, subGroup);
		sp.enterTheDataInTheSurgeryName(surgeryName);
		sp.enterTheDataInTheServiceShortName(serviceShortName);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the :" + msg + "  :popup message successfully");
	}

	// Tc-6
	@Test
	public void checkThatWithoutSelectingEffectiveFromMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {
		String departmentName = "CARDIOLOGY";
		String subGroup = "UROLOGY";
		String surgeryName = "Heart transplant";
		String serviceShortName = "Test";
		String otGrade = "GRADE 1";
		String msg1 = "Please Select Effective From";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.selectSubGroupDropdown(driver, subGroup);
		sp.enterTheDataInTheSurgeryName(surgeryName);
		sp.enterTheDataInTheServiceShortName(serviceShortName);
		sp.selectOtGradeDropdown(driver, otGrade);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		Assert.assertEquals(msg1, msg);
		System.out.println("User got the :" + msg + "  :popup message successfully");
	}

	// Tc-7
	@Test
	public void checkThatWithoutSelectinRateTypeMandatoryFieldClickOnTheSubmitButton_Test() throws Throwable {
		JavaUtility utility = new JavaUtility();
		String departmentName = "CARDIOLOGY";
		String subGroup = "UROLOGY";
		String surgeryName = "Heart transplant";
		String serviceShortName = "Test";
		String otGrade = "GRADE 1";
		String date = utility.currentDate();

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.selectSubGroupDropdown(driver, subGroup);
		sp.enterTheDataInTheSurgeryName(surgeryName);
		sp.enterTheDataInTheServiceShortName(serviceShortName);
		sp.selectOtGradeDropdown(driver, otGrade);
		sp.selectEffectiveDate(date);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.errorPopupMessage(driver);
		System.out.println("User got the :" + msg + " : popup messaeg successfully");
	}

	// Tc-8
	@Test
	public void checkThatWithoutSelecting_EnteringServiceDetailsClickOnTheSubmitButton_Test() throws Throwable {
		JavaUtility utility = new JavaUtility();
		String departmentName = "CARDIOLOGY";
		String subGroup = "UROLOGY";
		String surgeryName = "Heart transplant";
		String serviceShortName = "Test";
		String otGrade = "GRADE 1";
		String date = utility.currentDate();
		String rateType = "HOSPITAL RATE";
		String msg1 = "Please enter the service details";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectDepartmentDropdown(driver, departmentName);
		sp.selectSubGroupDropdown(driver, subGroup);
		sp.enterTheDataInTheSurgeryName(surgeryName);
		sp.enterTheDataInTheServiceShortName(serviceShortName);
		sp.selectOtGradeDropdown(driver, otGrade);
		sp.selectEffectiveDate(date);
		sp.selectRateTypeDropdown(driver, rateType);
		sp.clickOnTheSubmitButton(driver);
		String msg = sp.pleaseEnterTheServiceDetails_PopupMsg();
		sp.clickOnTheOkPopupBtn();
		Assert.assertEquals(msg, msg1);
		System.out.println("User got the :" + msg + "  :popup message successfully");
	}

	// TC-9
	@Test
	public void checkThatWithoutSelectServiceDescriptionfieldClickOnTheActionButton_Test() throws Throwable {

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.clickOnTheActionButton();
		String msg = sp.errorPopupMessage(driver);
		System.out.println("User got the :" + msg + ": popup message successfully");

	}

	// TC-10
	@Test
	public void checkThatWithoutSelectingServiceRulefieldClickOnTheActionButton_Test() throws Throwable {
		String serviceDescription = "SURGERY AMOUNT";

		HomePage hp = new HomePage(driver);
		SurgeryMasterPage sp = new SurgeryMasterPage(driver);

		hp.homeBtnForvims(driver);
		sp.clickOnTheSurgeryMasterLink(driver);
		sp.clickOnTheAddButton(driver);
		sp.selectServiceDescriptionDropdown(driver, serviceDescription);
		sp.clickOnTheActionButton();
		String msg = sp.errorPopupMessage(driver);
		System.out.println("User got the :" + msg + ": popup message successfully");
	}

	// TC-11
	/*
	 * @Test public void
	 * checkThatUserCanAbleToAddTheMultipleServicesInTheServicesDetailsTable_Test()
	 * {
	 * 
	 * JavaUtility utility=new JavaUtility(); String departmentName="POST NATAL";
	 * String subGroup="ENT SURGERY"; String surgeryName="Heart transplant"; String
	 * serviceShortName="Test"; String otGrade="GRADE 1"; String
	 * date=utility.currentDate(); String rateType="HOSPITAL RATE"; String
	 * serviceDescription="SURGERY AMOUNT"; String serviceRule="ENTRY";
	 * 
	 * String serviceDescription1="THEATRE CHARGES"; String
	 * serviceDescription2="ADITIONAL CHARGES";
	 * 
	 * 
	 * HomePage hp=new HomePage(driver); SurgeryMasterPage sp=new
	 * SurgeryMasterPage(driver);
	 * 
	 * hp.homeBtnForvims(driver); sp.clickOnTheSurgeryMasterLink(driver);
	 * sp.clickOnTheAddButton(driver); sp.selectDepartmentDropdown(driver,
	 * departmentName); sp.selectSubGroupDropdown(driver, subGroup);
	 * sp.enterTheDataInTheSurgeryName(surgeryName);
	 * sp.enterTheDataInTheServiceShortName(serviceShortName);
	 * sp.selectOtGradeDropdown(driver, otGrade); sp.selectEffectiveDate(date);
	 * sp.selectRateTypeDropdown(driver, rateType);
	 * 
	 * sp.selectServiceDescriptionDropdown(driver, serviceDescription);
	 * sp.selectServiceRuleDropdown(driver, serviceRule);
	 * sp.clickOnTheActionButton();
	 * 
	 * sp.selectServiceDescriptionDropdown(driver, serviceDescription);
	 * sp.selectServiceRuleDropdown(driver, serviceRule);
	 * sp.clickOnTheActionButton();
	 * 
	 * 
	 * sp.selectServiceDescriptionDropdown(driver, serviceDescription1);
	 * sp.selectServiceRuleDropdown(driver, serviceRule);
	 * sp.clickOnTheActionButton();
	 * 
	 * 
	 * sp.selectServiceDescriptionDropdown(driver, serviceDescription1);
	 * sp.selectServiceRuleDropdown(driver, serviceRule);
	 * sp.clickOnTheActionButton();
	 * 
	 * 
	 * sp.selectServiceDescriptionDropdown(driver, serviceDescription2);
	 * sp.selectServiceRuleDropdown(driver, serviceRule);
	 * sp.clickOnTheActionButton();
	 * 
	 * 
	 * sp.selectServiceDescriptionDropdown(driver, serviceDescription2);
	 * sp.selectServiceRuleDropdown(driver, serviceRule);
	 * sp.clickOnTheActionButton();
	 * 
	 * sp.clickOnTheSubmitButton(driver); }
	 * 
	 * @Test public void checkThatUserShouldAbleToDeleteTheServiceDetails_Test()
	 * throws Throwable{
	 * 
	 * 
	 * HomePage hp=new HomePage(driver); SurgeryMasterPage sp=new
	 * SurgeryMasterPage(driver);
	 * 
	 * hp.homeBtnForvims(driver); sp.clickOnTheSurgeryMasterLink(driver);
	 * sp.clickOnTheEdotButton(); int
	 * count1=sp.countOfTheServiceDetailsInTheTable(); int
	 * count2=sp.deleteMultipleServiceDetails(driver); Assert.assertEquals(count1,
	 * count2); System.out.println("Service details rows :"
	 * +count1+" :are equals to deleted rows "+count2+"  successfully"); }
	 */

}
