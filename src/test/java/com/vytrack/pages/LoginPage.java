package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    // to not use web elements directly in step definition classes
    // helps to prevent code duplication and keep step definitions clear
    @FindBy(id = "prependedInput")
    private WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText(){
        return warningMessage.getText().trim();
    }

    public  void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
    }

    public void login(){
        String username = ConfigurationReader.getProperty("storemanager.username");
        String password = ConfigurationReader.getProperty("password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
    }

    public void login(String role){

        String username = "";
        String password = ConfigurationReader.getProperty("password");

        if(role.equalsIgnoreCase("store manager")){
            username = ConfigurationReader.getProperty("storemanager.username");
        }else if(role.equalsIgnoreCase("sales manager")){
            username = ConfigurationReader.getProperty("salesmanager.username");
        }else{
            username = ConfigurationReader.getProperty("driver.username");
        }

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
    }

}
