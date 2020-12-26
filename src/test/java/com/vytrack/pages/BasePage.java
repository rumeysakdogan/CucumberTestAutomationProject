package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    @FindBy( className = "oro-subtitle")
    protected WebElement pageSubtitle;

    @FindBy( xpath = "(//button[contains(text(),'Save and Close')])[1]")
    protected WebElement saveAndCloseButton;

    @FindBy( css = "[class='loader-mask']")
    protected List<WebElement> loaderMask;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getPageSubTitleText(){
        return pageSubtitle.getText();

    }

    /**
     * Method for navigation in vytrack app
     * @param tab, for example:  Fleet, Dashboard, Sales, Activities..
     * @param module, one of the values that will be visible after clicking on the tab.
     *                For Fleet, these are the modules: Vehicles, Vehicle Odometer, Vehicle Costs, etc.
     */
    public void navigateTo(String tab, String module){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

        String tabXpath = "//*[contains(text(),'" + tab + "') and @class='title title-level-1']";
        String moduleXpath = "//*[contains(text(),'" + module + "') and @class='title title-level-2']";

        // wait until loader mask disappears
        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));

        BrowserUtils.wait(3);
        //wait for presence and ability to click on element
        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();

        // wait until loader mask disappears
        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));
        BrowserUtils.wait(3);
    }

    public void clickSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndCloseButton);
    }
}
