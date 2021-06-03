### Demo Automation - Selenium Automation

#### System Requirement:

* JDK 1.6 or above
* Maven 3.1 or above
* Eclipse IDE or any other of choice in case there is need to update the script. (optional)
* For execution of scripts on Chrome you need to have executable files for both drivers respectively and paste them at location "\src\test\resources\drivers" in project folder.
* You can download these executable files from below links
  * Chrome: https://drive.google.com/file/d/0B4FqnK04LJRnNWZFOEE3Wjd4aFk/view

#### Execution Steps:
Please follow the instructions to execute the tests on local:

1. Checkout the code from Git
2. To add execution parameters use following command
	mvn clean verify -DxmlFile="ProductPurchaseAndProfileUpdate_TestNG.xml"
	
Or execute the runner or testNG xml present under
	\src\test\resources\testngxml
	
All these parameters also have a default value present in config file like app-url, timeout, credentials etc

#### Test Execution Result Files:	
The Test Execution Results will be stored in the following directory once the test has completed

    ./target/cucumber-html-report/index.html (for cucumber feature execution results)
