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
  
  
  Scenario: See sub-categories item
    Given I login as a traxens Admin
    When I click on manage
  Then I should see sub-categories item

  @CreateSubcategory
  Scenario Outline: Add all type of subcategories
    Given I login as a traxens Admin
    When I click on manage
    And I click on subcategory item
    And I click on create subcategory button
    And I choose a category <category>
    And I enter code <code> and name <category> subcategory
    And I save
    Then I should see the subcategory <code> in subcategory list

    Examples: 
      | category  | code                 | name                  |
      | container | Container-TestsAutos | Container Tests Autos |
      | genset    | Genset-TestsAutos    | Genset Tests Autos    |
      | pallet    | Pallet-TestsAutos    | Pallet Tests Autos    |
      | trailer   | Trailer-TestsAutos   | Trailer Tests Autos   |
      | unknown   | Unknown-TestsAutos   | Unknown Tests Autos   |
      | wagon     | Wagon-TestsAutos     | Wagon Tests Autos     |
