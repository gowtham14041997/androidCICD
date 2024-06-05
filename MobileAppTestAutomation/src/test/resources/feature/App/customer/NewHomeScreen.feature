Feature: Customer App New Home Screen
  This will test Customer App New Home Screen Flows

  Background: Opening the customer app
    Given RupeekApp is opened

  #@regression @test @smoke #@TC_01
  Scenario: Check if user is able to complete sign up in rupeek app and reach new home screen
    When User enters "9999999922" phone number
    Then User enters "Test" name
    Then User enters otp for sign up for "9999999922"
    Then User enters city "delhi" and reaches to new homePage
    Then App New homepage is loaded
    Then reset the App

  @regression @test @smoke #@TC_02
  Scenario: Check if user is able to login in rupeek app and reach new home screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then reset the App

  @regression @test @smoke #@TC_03
  Scenario: New Home Screen Validation
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then validate all components of new home screen
    And reset the App

  @regression @test @smoke #@TC_04
  Scenario: Check if user is able to access Contact us section on new home screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User navigates to "Contact Us" section on new home screen
    Then reset the App

  #@regression @test @smoke #@TC_05
  Scenario: Verify Digital Journey - Doorstep Fresh Loan flow for New HS
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User clicks on At "Doorstep" and selects fresh loan for "new" homescreen
    And User completes digital journey for "Doorstep"
    Then reset the App
    And Transaction is deleted for "6000009916"

  #@regression @test @smoke #@TC_06
  Scenario: Verify Digital Journey - Doorstep Takeover flow for New Home Screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User clicks on At "Doorstep" for "new" homescreen
    And User fills "123453" and "manappuram" in loan information
    And User skips upload loan receipt and submits the request
    Then reset the App

  @regression @test @smoke #@TC_07
  Scenario: Verify Digital Journey - Branch Walk in Takeover flow for New Home Screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User clicks on At "Bank Branch" for "new" homescreen
    And User fills "123453" and "manappuram" in loan information
    And User skips upload loan receipt and submits the request
    Then reset the App

  @regression @test @smoke #@TC_08
  Scenario: Check if user is able to access refer and earn section on new home screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User navigates to "Refer and Earn" section on new home screen
    Then User is able to navigate to refer and earn page
    Then User is able to refer refer a friend
    Then reset the App

  @regression @test @smoke #@TC_09
  Scenario: Check if user is able to access Articles section on new home screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User navigates to "Articles" section on new home screen
    Then User is able to navigate to Articles page
    Then reset the App

  @regression @test @smoke #@TC_10
  Scenario: Verify Digital Journey - Bank Branch Fresh Loan flow for New HS
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User clicks on At "Bank Branch" and selects fresh loan for "new" homescreen
    Then reset the App

    
  @regression @test @smoke #@TC_11
  Scenario: Check if user is able to access Help and FAQs section on new home screen
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    Then User navigates to "Help & FAQs" section on new home screen
    Then reset the App

  @regression @test @smoke #@TC_12
  Scenario: Check if user is able to create loan using Gold Card
    When User enters "6000009916" phone number
    And user enters otp at login for "6000009916"
    And App New homepage is loaded
    And User requests Rupeek Gold Card on new HomeScreen
    And User completes digital journey for "Gold Card"
    Then Rupeek Gold Card request is submitted successfully
    And Transaction is deleted for "6000009916"
    And reset the App

  @regression @test @smoke #@TC_13
  Scenario: Verify user is able to reschedule the loan
    Given "Fresh" transaction is created for customer "6000009916"
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    And User clicks on appointment card and reschedules the appointment
    And Transaction is deleted for "6000009916"
    And reset the App

  @regression @test @smoke #@TC_14
  Scenario: Verify user is able to cancel the loan
    Given "Fresh" transaction is created for customer "6000009916"
    When User enters "6000009916" phone number
    Then user enters otp at login for "6000009916"
    Then App New homepage is loaded
    And User clicks on appointment card and cancels the appointment
    And reset the App