package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

/**
 * Hooks name is not reserved. You may name this class in any way.
 * For example: SuiteSetupAndTearDown
 * Hooks triggered based on tags not class name or their location.
 * These methods can be a part of any step definition class.
 * Common practice is to store them in the separate class.
 */
public class Hooks {


//  hook before = @BeforeMethod in TestNG
//  hook after = @AfterMethod in TestNG
//  it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//  usually, we just use explicit and fluent waits.

        @Before
        public void setup(Scenario scenario){
            System.out.println(scenario.getSourceTagNames());
            System.out.println("::: Start of Automation :::");
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

 // this hook will run only before scenarios with a tag @db
        @Before("@db")
        public void dbSetup(){
            System.out.println("::: Connecting to the database :::");
        }

        /**
         * @db
         * Scenario: IDK but here I'm connecting to DB
         * Given user runs following query "SELECT * ...."
         */
        @After("@db")
        public void dbTearDown(){
            System.out.println("::: Disconnecting from the database :::");
        }


        @After
        public void tearDown(Scenario scenario){
            //close browser, close DB connection, close tunnel, capture screenshot of the error, etc.
            // this is a hook after
            // run automatically after every test

            if(scenario.isFailed()){
                byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(data, "image/png", scenario.getName());
            }

            Driver.closeDriver();
            System.out.println(":::(^_^) End of Test Execution (*_*):::");
        }



}
