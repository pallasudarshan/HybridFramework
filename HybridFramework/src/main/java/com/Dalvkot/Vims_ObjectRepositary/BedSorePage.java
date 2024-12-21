package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class BedSorePage extends WebDriverUtility {

	public BedSorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@id='v-pills-profile-tab-5']")
	private WebElement bedSoreBtn;

}
