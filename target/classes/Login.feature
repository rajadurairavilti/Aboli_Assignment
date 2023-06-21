@PrivateCustomer
Feature: Personal bank account opening

  @PersonalAccount
  Scenario: Open the new Personal account in the mobile bank
    Given I want to open the url link
    And accept the cookies
    When I select the our services dropdown
    And I click on Accounts and Payments option
    And I click on Personal account
    And I click on the button 'Become a private customer with Mobile BankID'
    And choose to go for 'Become a customer directly with Mobilt BankID' button 
    Then Will navigate to the new window
    Then i will check the check box for Terms and conditions
    And click on Borja Har button 
  	