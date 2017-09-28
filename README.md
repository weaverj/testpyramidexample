# RxDemo:  Java Application Demonstrating Test Pyramid Concept

## Introduction

This project illustrates the Test Pyramid testing strategy published by Mike Cohn in Software Development Using Scrim, Addison-Wesley, 2009.  Tests at different layers of the application are complimentary, with unit tests, acceptance tests for logical services, and end to end tests focused on the UI behavior.  The sample application is a prescribing application, and there are four primary parts to the application each in a sub-folder of the project:

- **RxDemo Server**: This is a java / maven3 sub-application that provides the REST services for the application, along with unit tests.
- **RxDemo UI**: This is a javascript / html sub-application that provides the web client for the application, along with unit tests.
- **RxDemo Fitnesse**: This is a [fitnesse](http://http://fitnesse.org/) instance with acceptance tests for sample features of the application.
- **RxDemo Selenium**: This is a java / maven3 sub-application containing only selenium tests to verify the UI of the example features via a browser.

## Running Selenium Tests in rxdemo-selenium

- Download Selenium Standalone Server jar from [Selenium HQ Downloads](http://docs.seleniumhq.org/download/)
- Download driver for browser of choice (links maintained at Selenium HQ)
- Run Selenium Server with driver, i.e. `java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalon3.4.0.jar`
- Run unit test in rxdemo-selenium test/java/rxdemo 
- expected port for UI to be running on is localhost 9000, but this can be modifed via RxConstants in rxdemo-selenium.

