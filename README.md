# QA Automation Framework

A Selenium-based QA automation framework developed using Java, TestNG, Maven, Page Object Model, Apache POI, Extent Reports, and Cucumber BDD.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Apache POI
- Cucumber BDD
- Gherkin
- Extent Reports
- Git
- GitHub

## Features

- Page Object Model design pattern
- Data-driven testing using Excel and Apache POI
- TestNG DataProvider
- Positive and negative login testing
- Assertions for test validation
- Explicit waits
- Automatic screenshot capture on test failure
- TestNG listeners
- Extent HTML reports
- TestNG suite execution
- Cucumber BDD integration
- Scenario Outline and Examples for data-driven Cucumber testing

## Automated Test Scenarios

The framework currently automates:

- Valid login
- Invalid login scenarios
- Data-driven login testing
- Logout functionality
- Cucumber Scenario Outline execution with multiple credential combinations

## Project Structure

```text
src/main/java
├── base
├── pages
└── utilities

src/test/java
├── tests
├── listeners
├── stepdefinitions
└── runners

src/test/resources
└── features

testdata
└── LoginData.xlsx