@automationCheck
Feature: Automation Assignment

  Background: Navigation to the URL
    Given User navigate to URL and open the landing page

  @URLRedirection
  Scenario: User navigate to URL, User redirect to landing page with expected current URL
    When User is on landing page
    Then Validate current URL of landing page with expected URL

  @MyWishList1
  Scenario Outline: User is able to login into the application
    Given User click on Wishlist icon  from home page
    When User redirected to login page of the application where title us "Majestic Solitaire Diamond Ring"
    And User enters "<emailid>" and click on Continue button
    And User is displayed with the message as "OTP is sent on mailid"
    And User enters "OTP" and click on login button1
    Then User successfully login and landing to My Wish List1

    Examples: 
      | emailid                |
      | suchitatayde@gmail.com |

  @MyWishList
  Scenario Outline: User is able to login into the application
    Given User click on Wishlist icon  from home page
    When User redirected to login page of the application where title us "Majestic Solitaire Diamond Ring"
    When User click on sign in button
    And User enters "<Name>" and  "<emailid>" and "<Phone>"
    And User is click on create account
    Then User successfully login and landing to My WishList1

    Examples: 
      | Name      | emailid                     | Phone      |
      | Sam       | dp.wadhe@gmail.com          | 9004913480 |
      | Rishikesh | sonarrushikesh222@gmail.com | 9356911554 |
      | Preet     | taydesuchita11@gmail.com    | 9960760446 |

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
      |  400068 |
