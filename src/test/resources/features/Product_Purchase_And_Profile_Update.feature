Feature: Purchase product and Profile update
	this use case verifies the product purchase and profile update functionality
	
Scenario Outline: Place T-shirt order
	Given User is on Application Home page
	When User Login with valid <email> and <password>
	Then User is navigate to My Account page
	When User selects T-shirts
	And User add the T-shirt to the cart
	And User place order for the T-shirt
	Then User verifies the order is placed successfully
	
	
Examples: 
	|	email						|	password		|
	|	vishaljauhari40@gmail.com	|	Visknp123		|
	
Scenario: Update Personal Information in My Account
	When User select user info form header
	Then User is navigate to My Account page
	When User select My Personal Information
	And User update first name Information
	Then User verifies the updated Information
	And User closes the browser session