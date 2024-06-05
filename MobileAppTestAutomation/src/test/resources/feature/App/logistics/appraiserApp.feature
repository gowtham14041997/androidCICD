Feature: Appraiser App Launch Activity
  This will test Launch Activity for Appraiser App

  @TC_01_V1 @regression @test @smoke
  Scenario: LM App Fresh flow with penny tested bank details and 1 jewel
    Given Appraiser App homepage is loaded
    And "Fresh" loan flow is apprised by LM "5039156076" pictureType "TakePicture" with addressType "Aadhaar"
      |     accountnumber                  |     50100160839862               |
      |     bank                           |     HDFC Bank                    |
      |     beneficiaryname                |     bindushree b                 |
      |     ifsc                           |     HDFC0003980                  |
      |     AddressProof                   |     Aadhaar Card                |
      |     IDProof                        |     PAN Card                    |
      |     Occupation                     |     Salaried                    |
      |     Domain                         |     @gmail.com                  |
      |     OccupationDetails              |     XYZ                         |
      |     FatherName                     |     Father                      |
      |     MotherName                     |     Mother                      |
      |     Email                          |     mail                        |
      |     NomineeName                    |     Nominee                     |
      |     RelationShip                   |     DAUGHTER-IN-LAW             |
      |     Contact                        |     9999999999                  |
      |     pincode                        |     560001                      |
      |     Country                        |     India                       |
      |     State                          |     Karnataka                   |
      |     City                           |     Bengaluru                   |
      |     Address                        |     Address                     |
      |     Aadhar                         |     999955183433                |
      |     Pan                            |     ASDFG5678A                  |
      |     Passport                       |     A6045778                 |
      |     Voter                       |     ASD4545654                 |


#    Then reset the App
#    And Kyc is approved on loan admin dashboard by "5108826561"
#      |     Salutation                           |     Ms.                  |
#      |     Gender                               |     female               |
#      |     MarriageStatus                       |     single               |
#      |     Pan                                  |     ASDFG5678A           |
#    And Jewellery apprisal is approved on loan admin dashboard by "5108826561"
#    And Driver is configured for LM App
#    And Agent "5108826561" complete the appraisal process for "Fresh"
#    Then reset the App
  # And Money transfer is approved on loan admin dashboard by "5108826561"
#    Given Appraiser App homepage is loaded
#    And Agent "5108826561" submit fund transfer for Fresh loan
#    Then reset the App






  @TC_01_V2 @regression @test @smoke
  Scenario: LM App TO flow with penny tested bank details and 1 jewel
    Given Appraiser App homepage is loaded
    And "Takeover" loan flow is apprised by LM "5235324057" pictureType "TakePicture" and 1 jewel
      |     accountnumber                  |     50100160839862               |
      |     bank                           |     HDFC Bank                    |
      |     beneficiaryname                |     bindushree b                 |
      |     ifsc                           |     HDFC0003980                  |
      |     AddressProof                   |     Aadhaar Card                |
      |     IDProof                        |     PAN Card                    |
      |     Occupation                     |     Salaried                    |
      |     Domain                         |     @gmail.com                  |
      |     OccupationDetails              |     XYZ                         |
      |     FatherName                     |     Father                      |
      |     MotherName                     |     Mother                      |
      |     Email                          |     mail                        |
      |     NomineeName                    |     Nominee                     |
      |     RelationShip                   |     DAUGHTER-IN-LAW             |
      |     Contact                        |     9999999999                  |
      |     pincode                        |     560001                      |
      |     Country                        |     India                       |
      |     State                          |     Karnataka                   |
      |     City                           |     Bengaluru                   |
      |     Address                        |     Address                     |
      |     Aadhar                         |     999955183433                |
      |     Pan                            |     ASDFG5678A                  |
      |     Passport                       |     A6045778                 |
      |     Voter                          |     ASD4545654                 |
#    Then reset the App
#    And Kyc is approved on loan admin dashboard by "5883874907"
#      |     Salutation                           |     Ms.                  |
#      |     Gender                               |     female               |
#      |     MarriageStatus                       |     single               |
#      |     Pan                                  |     ASDFG5678A           |
#    And TO document is approved on loan admin dashboard by "5883874907"
#      |     Salutation                           |     Ms.                  |
#      |     Gender                               |     female               |
#      |     MarriageStatus                       |     single               |
#      |     Pan                                  |     ASDFG5678A           |
#    Given Appraiser App homepage is loaded
#    And Agent "5883874907" start TO journey on
#    Then reset the App
#    And Jewellery apprisal is approved on loan admin dashboard by "5883874907"
#    And the status code is updated to "2.7" for agent "5883874907"
#    #Given Appraiser App homepage is loaded
#    And driver is configured without reset
#    And Agent "5883874907" complete the appraisal process for "Takeover"
##    And  Agent "5324305223" Capture pledge card on LM app
#    Then reset the App
#    And Money transfer is approved on loan admin dashboard by "5883874907"
#    Then reset the App


  #@TC_01_V3 @regression @test @smoke
  Scenario: LM App Card flow with penny tested bank details and 1 jewel
    Given Appraiser App homepage is loaded
    And "Card" loan flow is apprised by LM "5746624240" pictureType "TakePicture" with addressType "Aadhaar"
      |     accountnumber                  |     50100160839862               |
      |     bank                           |     HDFC Bank                    |
      |     beneficiaryname                |     bindushree b                 |
      |     ifsc                           |     HDFC0003980                  |
      |     AddressProof                   |     Aadhaar Card                |
      |     IDProof                        |     PAN Card                    |
      |     Occupation                     |     Salaried                    |
      |     Domain                         |     @gmail.com                  |
      |     OccupationDetails              |     XYZ                         |
      |     FatherName                     |     Father                      |
      |     MotherName                     |     Mother                      |
      |     Email                          |     mail                        |
      |     NomineeName                    |     Nominee                     |
      |     RelationShip                   |     DAUGHTER-IN-LAW             |
      |     Contact                        |     9999999999                  |
      |     pincode                        |     560001                      |
      |     Country                        |     India                       |
      |     State                          |     Karnataka                   |
      |     City                           |     Bengaluru                   |
      |     Address                        |     Address                     |
      |     Aadhar                         |     999955183433                |
      |     Pan                            |     ASDFG5678A                  |
      |     Passport                       |     A6045778                 |
      |     Voter                          |     ASD4545654                 |

