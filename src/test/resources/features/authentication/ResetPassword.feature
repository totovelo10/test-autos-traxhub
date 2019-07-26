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
@resetpassword
Feature: I want to reset my password
  In order to reset my password
  As a user
  I want to navigate to reset password page
  
  """Scenario: Navigate to ResetPassword page
    Given the user is on the Login page
    When the user clicks on reset password link
  """    Then he should be redirected to the reset password page
  
  
  """Scenario Outline: Reset password email sent
    Given the user navigate to reset password page
    When the user enter his username <username>
    And  the user clicks on reset password button
  """    Then a check mails message should be displayed
    
  """   Examples:
      | username | 
      | sadati_traxens|
  """	    | sboina_sncf | 
  
  """Scenario: Navigate to ResetPassword page
    Given the user navigate to the Gmail page
    When the user log in Gmail 
    And  the user clicks on traxens email
    And  the user clicks on reset link
    And  the user clicks on go on button
  """ Then he should be redirected to connexion page
  
  """Scenario Outline: Reset password and connect with new password
    Given the user have a reset_key <resetKey>
    When the user navigate to the resetpasswordPage 
    And  the user enters his new password <newPassword>
    And  the user enters the confirm password <confirmPassword>
    And  the user clicks on reset password button
  """    Then he should see the success message
    
  """Examples:
      | resetKey | newPassword | confirmPassword|
      | 30211292964471911751|test12345|test12345|
  """ | 43211292964471911750|jetesteuneappli|jetesteuneappli|

@ResetPassword
  Scenario Outline: Reset password and connect with new password
    Given the user is on the Login page
    When the user clicks on reset password link
    And the user enter his username <username>
    And the user clicks on reset password button
    And the user navigate to the resetpasswordPage <username>
    And the user enters his new password <newPassword>
    And the user enters the confirm password <confirmPassword>
    And the user clicks on reset password button
    And the user clicks on login page link
    And the user  log in traxhub with his username <username> and newpassword <newPassword>
    Then he should see his account name <account_name>

    Examples: 
      | username    | newPassword | confirmPassword | account_name        |
      | sboina_sncf | test12345   | test12345       | Sadati BOINA (RAIL) |
      | sadati_cma  | iliketest@  | iliketest@      | Sadati BOINA (CMA)  |
