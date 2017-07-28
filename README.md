# RxDemo:  Java Application Demonstrating Test Pyramid Concept

## Running Selenium Tests in rxdemo-selenium

- Download Selenium Standalone Server jar from [Selenium HQ Downloads](http://docs.seleniumhq.org/download/)
- Download driver for browser of choice (links maintained at Selenium HQ)
- Run Selenium Server with driver, i.e. `java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalon3.4.0.jar`
- Run unit test in rxdemo-selenium test/java/rxdemo 
- expected port for UI to be running on is localhost 9000, but this can be modifed via RxConstants in rxdemo-selenium.

