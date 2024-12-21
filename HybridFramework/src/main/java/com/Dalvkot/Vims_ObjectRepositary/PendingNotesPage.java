package com.Dalvkot.Vims_ObjectRepositary;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class PendingNotesPage extends WebDriverUtility {

	public PendingNotesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
}
