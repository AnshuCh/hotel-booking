#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: As a customer
	I want to book my hotel
	So that I have accomodation when I reach my destination

    @tag1
    Scenario Outline: Booking a hotel
    Given PHPTravels site
    When "<location>", checkin, checkout, adults and child are entered
    And Search is clicked
    When Required hotel is selected among the list of given hotels
    And Required room is selected among the list of available rooms
    And Book Now is clicked
    When Details as "<firstName>", "<lastName>", "<email>", "<confirmEmail>", "<mobileNumber>", "<address>", country are filled for booking as a guest
    And Confirm this booking is clicked
    And An unpaid invoice is generated
    When Pay Now is clicked
    And Payment Method is selected
    And Pay Now is clicked
    Then Again an unpaid invoice is generated
    And Browser is closed
    
    Examples:
    | location | firstName | lastName | email   | confirmEmail | mobileNumber | address            |  
    | Dubai    | Michael   | Smith    | m@s.com | m@s.com      | 4444         | 10, Big St, Sydney |
    

