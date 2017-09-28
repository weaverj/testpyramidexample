# RxDemo:  Java Application Demonstrating Test Pyramid Concept

## Introduction

This project illustrates the Test Pyramid testing strategy published by Mike Cohn in Software Development Using Scrum, Addison-Wesley, 2009.  Tests at different layers of the application are complimentary, with unit tests, acceptance tests for logical services, and end to end tests focused on the UI behavior.  The sample application is a prescribing application, and there are four primary parts to the application each in a sub-folder of the project:

- **RxDemo Server**: This is a java / maven3 sub-application that provides the REST services for the application, along with unit tests.
- **RxDemo UI**: This is a javascript / html sub-application that provides the web client for the application, along with unit tests.
- **RxDemo Fitnesse**: This is a [fitnesse](http://http://fitnesse.org/) instance with acceptance tests for sample features of the application.
- **RxDemo Selenium**: This is a java / maven3 sub-application containing only selenium tests to verify the UI of the example features via a browser.

A powerpoint presentation is at the root directory.

## Running RxDemo Server
You will need Java 1.8.x or higher and Maven 3 or higher installed.  You should be able to do a "java -version" and "mvn -version" from command line.

- cd to the rxdemo-server subdirectory and perform a "mvn clean install" operation.
- cd to the rxdemo-server/rest subdirectory and perform a "mvn exec:java".

At this point the server should be running and listening on port 4567.  You can confirm this by hitting the httpget call for drugs to prescribe: localhost:4567/drugs.

You may alternatively run the application from within your IDE if it has processed maven 3 dependencies.  The main class to run is in the rest sub-module, AppMainRunner.java.

Unit tests for server-side logic are in rxdemo-server/core/src/test/java.  They may be executed by a "mvn test" operation from rxdemo-server directory, or from within IDE.

## Running RxDemo UI
You will need node installed.  The application was build on node 6.10.0 but a later version should work (node --version to check your version).

- perform "npm install" from rxdemo-ui directory.
- perform "npm run run" from rxdemo-ui directory.

Application should launch on port 9000, UI should appear in browser at localhost:9000, and if RxDemo Server is running the list of drugs should be available in droplist.

Unit tests are in rxdemo-ui/test/unit, and may be executed via "npm test".

## Running RxDemo Fitnesse
Business logic / acceptance tests for RxDemo along with fitnesse instance to view and run them are in the rxdemo-fitnesse subdirectory.

- cd to rxdemo-fitnesse
- perform "java -jar fitnesse-standalone.jar -p 8080"

Fitnesse should be accessible via browser at localhost:8080.  You can navigate down the RxDemoTestPyramidTest links and run all of the tests from subsequent suite page by hitting the "Suite" button in the header, or drill down to individual tests to view or run them by hitting the "Test" button in header.

## Running Selenium Tests in rxdemo-selenium

- Download Selenium Standalone Server jar from [Selenium HQ Downloads](http://docs.seleniumhq.org/download/)
- Download driver for browser of choice (links maintained at Selenium HQ)
- Run Selenium Server with driver, i.e. `java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalon3.4.0.jar`
- Run unit test in rxdemo-selenium test/java/rxdemo 
- expected port for UI to be running on is localhost 9000, but this can be modifed via RxConstants in rxdemo-selenium.

