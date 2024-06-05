Feature: Customer App Old Home Screen
  This will test Customer App Old Home Screen Flows

  Background: Opening the customer app
    Given RupeekApp is opened

  #@regression @test @smoke @TC_01
  Scenario: Check if user is able to complete sign up in rupeek app
    When User enters "9999999922" phone number
    Then User enters "Test" name
    Then User enters otp for sign up for "9999999922"
    Then User enters city "bangalore" and reaches to homePage
    Then App homepage is loaded
    And User navigates to "logout" section
    Then reset the App

  @regression @test @smoke #@TC_02
  Scenario: Check if user is able to login in rupeek app
    When User enters "9999999922" phone number
    Then user enters otp at login for "9999999922"
    Then App homepage is loaded
    Then reset the App

  @regression @test @smoke #@TC_03
  Scenario: Check if user is able to access refer and earn section
    When User enters "9999999922" phone number
    Then user enters otp at login for "9999999922"
    Then App homepage is loaded
    Then User navigates to "refer_friends" section
    Then User is able to navigate to refer and earn page
    #Then User is able to refer refer a friend
    Then reset the App

  #@regression @test @smoke #@TC_04
  Scenario: Verify Digital Journey - Doorstep Takeover flow for Old HS
    When User enters "9999999922" phone number
    Then user enters otp at login for "9999999922"
    Then App homepage is loaded
    Then User clicks on At "Doorstep" for "old" homescreen
    And User fills "123453" and "Muthoot" in loan information
    And User skips upload loan receipt and submits the request
    Then reset the App

  @regression @test @smoke #@TC_05
  Scenario: Verify Digital Journey - Branch Walk in Takeover flow for old HS
    When User enters "9999999922" phone number
    Then user enters otp at login for "9999999922"
    Then App homepage is loaded
    Then User clicks on At "Bank Branch" for "old" homescreen
    And User fills "123453" and "Muthoot" in loan information
    And User skips upload loan receipt and submits the request
    Then reset the App

  #@regression @test @smoke #@TC_06
  Scenario: Verify Digital Journey - Doorstep Fresh Loan flow for Old HS
    When User enters "9999999922" phone number
    Then user enters otp at login for "9999999922"
    Then App homepage is loaded
    Then User clicks on At "Doorstep" and selects fresh loan for "old" homescreen
    And User completes digital journey for "Doorstep"
    Then reset the App
    And Transaction is deleted for "9999999922"

  @regression @test @smoke #@TC_07
  Scenario: Check if user is able to access Help and FAQs section
    When User enters "6000002582" phone number
    Then user enters otp at login for "6000002582"
    Then App homepage is loaded
    Then User navigates to "help" section
    Then reset the App

  @regression @test @smoke #@TC_08
  Scenario: Homepage Validation
    When User enters "6000002582" phone number
    Then user enters otp at login for "6000002582"
    Then App homepage is loaded
    Then validate all components of homePage
    Then reset the App
    #Then user for "9999999922" is deleted from core DB

  @regression @test @smoke #@TC_09
  Scenario: Verify Digital Journey - Bank Branch Fresh Loan flow for Old HS
    When User enters "9999999922" phone number
    Then user enters otp at login for "9999999922"
    Then App homepage is loaded
    Then User clicks on At "Bank Branch" and selects fresh loan for "old" homescreen
    Then reset the App
    And Transaction is deleted for "9999999922"

  @regression @test @smoke #@TC_10
  Scenario: Check if user is able to access Articles section
    When User enters "6000002582" phone number
    Then user enters otp at login for "6000002582"
    Then App homepage is loaded
    Then User navigates to "article" section
    Then User is able to navigate to Articles page
    Then reset the App

  @regression @test @smoke #@TC_11
  Scenario: Check if user is able to access Contact Us section
    When User enters "6000002582" phone number
    Then user enters otp at login for "6000002582"
    Then App homepage is loaded
    Then User navigates to "locate" section
    Then reset the App