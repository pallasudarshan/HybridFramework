package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class LabTemplateCreatorPage extends WebDriverUtility {
	
	public LabTemplateCreatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=' Lab Template Creator ']")
	private WebElement   labTemplateCreatorBtn;

	@FindBy(xpath="//input[@aria-label='Service Name Filter Input']")
	private WebElement   serviceNameText_Filter;
	
	
	@FindBy(xpath="//input[@aria-label='External Service Filter Input']")
	private WebElement  externalServiceText_Filter ;

	@FindBy(xpath="//input[@aria-label='Service Code Filter Input']")
	private WebElement   sericeCodeText_Filter;
	
	
	@FindBy(xpath="//input[@aria-label='Service Type Filter Input']")
	private WebElement  serviceTypeText_Filter ;

	@FindBy(xpath="//input[@aria-label='Service Group Filter Input']")
	private WebElement  serviceGroup_Filter ;
	
	
	@FindBy(xpath="//input[@aria-label='Service Class Filter Input']")
	private WebElement   serviceClass_Filter;

	@FindBy(xpath="(//div[@col-id='serviceName'])[2]")
	private WebElement   serviceName_Table;
	

	@FindBy(xpath="(//div[@col-id='externalLabStatus'])[2]")
	private WebElement  externalService_Table ;

	@FindBy(xpath="(//div[@col-id='serviceCode'])[2]")
	private WebElement  serviceCode_Table ;
	

	@FindBy(xpath="(//div[@col-id='serviceTypeName'])[2]")
	private WebElement  serviceType_Table ;

	@FindBy(xpath="(//div[@col-id='serviceGroupName'])[2]")
	private WebElement   serviceGroup_Table;
	

	@FindBy(xpath="(//div[@col-id='serviceClassName'])[2]")
	private WebElement  serviceClass_Table ;

	@FindBy(xpath="(//span[@class='switch-handle'])[1]")
	private WebElement  statusBtn_Table ;
	
	

	@FindBy(xpath="(//i[@class='zmdi zmdi-eye'])[1]")
	private WebElement  actionBtn_Table ;

	@FindBy(xpath="//span[text()='SERUM']/following-sibling::span")
	private WebElement   sampleTypeDropdownBtn;
	

	@FindBy(xpath="//input[@placeholder='Sequence']")
	private WebElement   printSequenceText;

	@FindBy(xpath="//input[@placeholder='Number of Test']")
	private WebElement  NumberOfTestText;
	

	@FindBy(xpath="//span[text()='MANUAL']/following-sibling::span")
	private WebElement  testDoneUsingDropdown;

	@FindBy(xpath="(//span[@data-on='Yes']/following-sibling::span)[1]")
	private WebElement  externalLabBtn;
	

	@FindBy(xpath="//span[text()='SHORT RESULT']/following-sibling::span")
	private WebElement  testResultTypeDropdownBtn;

	@FindBy(xpath="(//span[@data-off='No']/following-sibling::span)[2]")
	private WebElement  uploadFileBtn;
	
	@FindBy(xpath="(//span[@data-off='No']/following-sibling::span)[3]")
	private WebElement   resultComputedBtn;
	
	@FindBy(xpath="//label[text()=' Interpretation Required']/following-sibling::textarea")
	private WebElement  interpretationRequiredText;
	
	@FindBy(xpath="//label[text()=' Impression Required']/following-sibling::textarea")
	private WebElement  impressionRequiredText;
	
	@FindBy(xpath="//label[text()=' Notes ']/following-sibling::textarea")
	private WebElement   notesText;
	
	@FindBy(xpath="//table[@id='myTableElementId']/tbody/tr[1]/td[1]/descendant::span[@role='presentation']")
	private WebElement   testMethodDescriptionDropdownBtn_TestMethodListTable;
	
	@FindBy(xpath="//table[@id='myTableElementId']/tbody/tr[1]/td[3]/descendant::input[@placeholder='Reporting Sequence']")
	private WebElement  reportingSequenceText_TestMethodListTable;
	
	@FindBy(xpath="//table[@id='myTableElementId']/tbody/tr[1]/td[4]/descendant::span[@class='switchs-handle']")
	private WebElement  defaultStatus_TestMethodListTable;
	
	@FindBy(xpath="//table[@id='myTableElementId']/tbody/tr[1]/td[5]/descendant::span[@class='switchs-handle']")
	private WebElement  activeStatus_TestMethodListTable;
	
	@FindBy(xpath="//span[@title='Test']/following-sibling::span")
	private WebElement  TestDropdown_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[3]/input")
	private WebElement  headingText_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[4]/descendant::span[@title='Unit']/following-sibling::span")
	private WebElement  sampleUnitDropdown_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[6]/descendant::input[@placeholder='Code Type']")
	private WebElement  codeTypeText_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[7]/descendant::input[@placeholder='Normal Values']")
	private WebElement  normalValues_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[8]/descendant::input[@placeholder='Report Sequence']")
	private WebElement  reportSequensText_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[9]/descendant::span[@title='Test Method Code']/following-sibling::span")
	private WebElement  testMethod_AnalysisResultListTable;
	
	@FindBy(xpath="//div[@id='AnalysisResult']/descendant::tbody/tr[1]/td[last()]/descendant::i")
	private WebElement  actionBtn_AnalysisResultListTable;
	
	@FindBy(xpath="(//button[text()=' Submit '])[2]")
	private WebElement   submitBtn;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[2]/descendant::span[@role='presentation']")
	private WebElement  organismDropdownBtn_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[3]/descendant::span[@role='presentation']")
	private WebElement  cascadeType_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[4]/descendant::span[@role='presentation']")
	private WebElement   antiBioticDropdown_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[5]/descendant::span[@role='presentation']")
	private WebElement   sensitivityDropdown_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[6]/descendant::input[@placeholder='susceptible breakpoint']")
	private WebElement   suspectibleBreakPointText_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[7]/descendant::input[@placeholder='Efficient Ratio']")
	private WebElement   therapeuticIndexText_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[8]/descendant::input[@placeholder='Report Sequence']")
	private WebElement   reprotSequenceText_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[9]/descendant::span[@title='Test Method Code']/following-sibling::span")
	private WebElement   testMethod_CultureResulltList;
	
	@FindBy(xpath="//div[@id='CultureResult']/descendant::table/tbody/tr[1]/td[last()]/descendant::i[@class='zmdi zmdi-plus']")
	private WebElement   action_CultureResulltList;
	
	
	
	
	
	
	

}
