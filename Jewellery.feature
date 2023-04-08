@automationCheck
Feature: Automation Assignment

  Background: Navigation to the URL
    Given User navigate to URL and open the landing page

  @URLRedirection
  Scenario: User navigate to URL, User redirect to landing page with expected current URL
    When User is on landing page
    Then Validate current URL of landing page with expected URL

  @MyWishList
  Scenario Outline: User is able to login into the application
    Given User click on Wishlist icon  from home page
    When User redirected to login page of the application where title us "Majestic Solitaire Diamond Ring"
    And User enters "<emailid>" and click on Continue button
    And User is displayed with the message as "OTP is sent on mailid"
    And User enters "OTP" and click on login button
    Then User successfully login and landing to My Wish List

    Examples: 
      | emailid                |
      | suchitatayde@gmail.com |

  @ExploreDGRPLinkopen&close
  Scenario: User able to see Trending on landing page
    When User see the Trending option on screen
    And User select DGRP and click on it
    Then User close the window

  @SizeDropdown
  Scenario Outline: User able to see Rings on landing page
    When User select the size of the ring
    And User enters "<Pincode>" and click on Check button
    Then User see the Expected Delivery Date

    Examples: 
      | Pincode |
      |  400066 |
      |  4000068 |
