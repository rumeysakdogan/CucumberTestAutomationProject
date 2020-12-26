package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitions {

    CreateCarPage createCarPage = new CreateCarPage();

    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
        BrowserUtils.wait(3);
        createCarPage.clickOnCreateCar();
    }

    /**
     *  When user adds new vehicle information
     *     | Licence Plate | SDET |
     *     | Model Year    | 2021 |
     *           key        value
     *
     *           dataTable.get("Licence plate") --> SDET
     *           dataTable.get("Model Year") --> 2021
     *     after we specify datatable structure, cucumber will convert it
     *     no need to add anything to that step
     *
     *     map is a data structure where every value is referenced by key
     *
     *     in arraylist, it's always index
     *     dataTable = { Licence Plate = SDET , Model Year = 2021}
     *
     *     If you want to turn datatable into map, it must be exactly 2 columns
     *
     *     If it's a 1 column, it can be just List:
     *
     *     Then user verifies the following list:
     *          | 10 |
     *          | 20 |
     *          | 50 |
     *
     * @ Then ("user_verifies_the_following_list:")
     * public void user_verifies_the_following_list(List<String> dataTable){}
     */
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String,String> dataTable) {
        // to get all keys and values one by one
        //dataTable.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));

        System.out.println("Licence plate: " + dataTable.get("Licence Plate"));
        System.out.println("Model year: " + dataTable.get("Model Year"));

        createCarPage.enterLicensePlate(dataTable.get("Licence Plate"));
        createCarPage.enterModelYear(dataTable.get("Model Year"));
    }



}
