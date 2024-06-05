Feature: Customer App PostD
  This will test Customer App PostD Flows

  Background: Opening the customer app
    Given RupeekApp is opened

  @regression @test @smoke @postD #@TC_01
  Scenario: Check if user is able to access My Loans section
    Given loan is created in account service
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "my_loan" section
    Then validate all the active loans
    And reset the App

  @regression @test @smoke @postD #@TC_02
  Scenario: Check if user is able to access Repay/Renew/Release section and pays interest
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "replay_loan" section
    And "replay_loan" page is opened
    Then User clicks on active loans and "pays interest" with insurance "disabled"
    And user pays the pending amount
    And User navigates to "logout" section
    And reset the App

  #@regression @test @smoke @TC_03  @postD
  Scenario: Check if user is able to access Repay/Renew/Release section and closes the loan
    Given loan is created in account service
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "replay_loan" section
    And "replay_loan" page is opened
    Then User clicks on active loans and "closes loan" with insurance "enabled"
    And user pays the pending amount
    And book delivery slot through "Bank Branch"
    And reset the App
    And loan is deleted for the user

  #@regression @test @smoke @TC_04 @postD
  Scenario: Check if user is able to access Repay/Renew/Release section and closes the loan
    Given loan is created in account service
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "replay_loan" section
    And "replay_loan" page is opened
    Then User clicks on active loans and "closes loan" with insurance "enabled"
    And user pays the pending amount
    And book delivery slot through "Doorstep"
    And reset the App
    And loan is deleted for the user

  @regression @test @smoke @postD #@TC_05
  Scenario: Check if user is able to access Repay/Renew/Release section and pays amount
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "replay_loan" section
    And "replay_loan" page is opened
    Then User clicks on active loans and "part payment" with insurance "disabled"
    And user pays the pending amount
    And User navigates to "logout" section
    And reset the App

  @regression @test @smoke @postD @TC_06
  Scenario: Check if user is able to access Repay/Renew/Release section and renews the loan with insurance
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "replay_loan" section
    And "replay_loan" page is opened
    And User clicks on renew loan with "BestValue" and insurance "enabled"
    And user pays the pending amount
    #Then user e-signs the pledge
    And User navigates to "logout" section
    And loan is deleted for the user
    And reset the App

  @regression @test @smoke @postD #@TC_07
  Scenario: Check if user is able to access Payment History section
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And App homepage is loaded
    And User navigates to "payment_history" section
    And "payment_history" page is opened
    Then validate all the payments
    And reset the App

  @regression @test @smoke  @postD #@TC_08
  Scenario: Check if user is able to access Repay/Renew/Release section from widget and pays interest
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And "Pay Interest" widget is opened
    And "pay interest" page is opened
    Then User clicks on active loans and "pays interest" with insurance "disabled"
    And user pays the pending amount
    And User navigates to "logout" section
    And reset the App

  @regression @test @smoke @postD  @TC_09
  Scenario: Check if user is able to access Repay/Renew/Release section from widget and renews the loan without insurance
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And "Renewal or Top Up" widget is opened
    And "Renewal or Top Up" page is opened
    And User clicks on renew loan with "NoBestValue" and insurance "enabled"
    And user pays the pending amount
    #Then user e-signs the pledge
    And User navigates to "logout" section
    And loan is deleted for the user
    And reset the App

  @regression @test @smoke @postD #@TC_10
  Scenario: Check if user is able to access Repay/Renew/Release section from widget and pays amount
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And "Part payment" widget is opened
    And "part payment" page is opened
    Then User clicks on active loans and "part payment" with insurance "disabled"
    And user pays the pending amount
    And User navigates to "logout" section
    And reset the App

  #@regression @test @smoke @postD @TC_11
  Scenario: Check if user is able to access Repay/Renew/Release section from widget and does partial release with insurance
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And "Partial Release" widget is opened
    Then "partial release" page is opened
    And user releases a jewel
    And user pays the pending amount
    And User navigates to "logout" section
    And reset the App

  #@regression @test @smoke @postD #@TC_12 #incomplete
  Scenario: Check if user is able to access Repay/Renew/Release section from widget and closes the loan without insurance
    Given loan is created in account service
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And "Close loan" widget is opened
    And "Close Loan" page is opened
    Then User clicks on active loans and "closes loan" with insurance "disabled"
    And user pays the pending amount
    And book delivery slot through "Bank Branch"
    And loan is deleted for the user
    And reset the App

  #@regression @test @smoke @postD #@TC_13 #incomplete
  Scenario: Check if user is able to access Repay/Renew/Release section from widget and closes the loan without insurance
    Given loan is created in account service
    When User enters "9999999922" phone number
    And user enters otp at login for "9999999922"
    And "Close loan" widget is opened
    And "Close Loan" page is opened
    Then User clicks on active loans and "closes loan" with insurance "disabled"
    And user pays the pending amount
    And book delivery slot through "Doorstep"
    And loan is deleted for the user
    And reset the App