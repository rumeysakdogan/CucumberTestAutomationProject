package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage{

    @FindBy(css = "[title='Create Car']")
    private WebElement createCarButton;

    @FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licensePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInputBox;

    public void clickOnCreateCar(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(createCarButton)).click();

        System.out.println("Clicking on 'Create car' button");
    }

    public void enterLicensePlate(String licensePlate){
        BrowserUtils.enterText(licensePlateInputBox, licensePlate);
    }

    /**
     * sometimes , for very long strings webdriver might enter text not fully.
     */

    public void enterModelYear(String modelYear){

        BrowserUtils.enterText(modelYearInputBox, modelYear);
    }
}
