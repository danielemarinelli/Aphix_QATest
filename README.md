# Aphix_QATest

Tools Used for testing --

TestNG Framework


How to execute --

This is a maven project and its enabled to handle configurations and data source for following environments

DEV
INT

The test can be triggered with the following command.
For this test the browsers are chrome or firefox

mvn clean test -Denv=[ENVIRONMENT] -Dbrowser[browser name]

