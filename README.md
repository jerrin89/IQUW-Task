# Selenium WebDriver with Cucumber Framework 
## Overview
This repository contains an automated regression testing framework built using Selenium WebDriver and Cucumber for a retail company's website. The framework aims to validate the success of a user journey (e.g., Book online windscreen repire) on the ers website.

## Prerequisites
Before running the automated tests, make sure you have the following prerequisites installed:

Java Development Kit (JDK) Maven Git

## Getting Started
Clone the repository: bash Copy code git clone https://github.com/your-username/selenium-cucumber-framework.git Navigate to the project directory:

bash Copy code cd selenium-cucumber-framework Execute the following Maven command to download dependencies and build the project:

bash Copy code mvn clean install

## Running Tests
To execute the automated tests, use the following Maven command:

bash Copy code mvn test By default, this will run the entire test suite defined in the src/test/resources/features directory.

To run specific scenarios or features, use tags in your Cucumber runner class or in the @CucumberOptions annotation. For example:

java Copy code @RunWith(Cucumber.class) @CucumberOptions( features = "src/test/resources/features", glue = "stepdefinitions", plugin = {"pretty", "html:target/cucumber-reports", "rerun:target/rerun.txt"}, dryRun = false, tags = "@ItemCartCheckout" ) public class TestRunner { // ... } This configuration will only execute scenarios tagged with @ItemCartCheckout.

## Framework Structure
src/main/java: Contains utility classes, configuration, and any reusable components. src/test/java: Includes step definitions and test runners. src/test/resources/features: Holds Gherkin syntax feature files describing test scenarios.

## Test Data
Test data is managed in the src/test/resources/testdata directory. Ensure that test data is updated as needed for accurate test execution.

## Reporting
Test execution results are generated in HTML format and stored in the target/cucumber-reports directory. Open the index.html file in a browser for detailed test results.
