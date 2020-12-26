package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// for features: features --> right click --> copy path--> copy from content root
// for glue: step_definitions --> right click --> copy path--> copy from source root
// dryRun: true checking that before running test, cucumber checking all steps are implemented
// dryRun: false to run the test
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "timeline:target/timeline-report"
        },
        features = {
                "src/test/resources/features/Activities"
        },
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "",
        publish = true
)
public class CucumberRunner {
    //  tags = "@s_o and @with_two_columns"
    // scenario must have BOTH tags

    //  tags = "@s_o or @with_two_columns"
    // scenario must have EITHER OR tags
}
