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
Feature: Manage sub-categories equipments
  As a traxens Admin 
  I want to manage Sub-categories equipment
  
  
  """  Scenario: See sub-categories item
    Given I login as a traxens Admin
    When I click on manage
  """ Then I should see sub-categories item

  Scenario Outline: See sub-categories item
    Given I login as a traxens Admin
    When I click on manage
    And I click on subcategory item
    And I click on create subcategory button
    And I choose a category <category>
    And I enter code and name subcategory
    And I save
    Then I should see a message alert

    Examples: 
      | category  |
      | container |
      | genset    |
      | pallet    |
      | trailer   |
      | unknown   |
      | wagon     |
