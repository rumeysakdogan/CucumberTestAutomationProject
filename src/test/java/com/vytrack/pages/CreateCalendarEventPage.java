package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalendarEventPage extends BasePage {

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

    // switch to iframe
    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEventButton;

    public void clickOnCreateCalendarEvent(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventButton)).click();

        System.out.println("Clicking on 'Create Calendar Event' button");
    }

    public void enterTitle(String title){

        BrowserUtils.enterText(titleInputBox,title);
    }

    public void enterDescription(String description){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

        // exit from all frames
        Driver.getDriver().switchTo().defaultContent();
        // wait fro frame and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        //enter text

        //BrowserUtils.enterText(descriptionInputBox,description);
        // for frames, value attribute will not get the text value
        // so in out getText method, explicit wait will make out test fail
        descriptionInputBox.sendKeys(description);
        //exit from the frame
        Driver.getDriver().switchTo().defaultContent();

    }

    public String getDataFromGeneralInfo(String parameterName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath = "//label[text()='" + parameterName + "']/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();
    }


}
