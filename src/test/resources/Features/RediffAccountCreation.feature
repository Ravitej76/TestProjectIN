Feature: Rediff Account Creation flow

  @rediffTC1
  Scenario Outline: Creation of Account
    Given User in Rediff Page
    And user enter "<FullName>" in fullname field
    And user enter "<RediffID>" in id field
    And user click on check availabilty
    And user should see message "Yippie! The ID you've chosen is available."
    And user enter "<Password>" in password field
    And user enter "<Retype password>" in retype password field
    And user enter "<Alternate Email Address>" in email field
    And user enter "<Mobile No.>" in mobile no field
    And user selects date of birth as "<Day>" "<Month>" "<Year>"
    And user enter "<Gender>" in gender field
    And user enter "<Country>" in country field
    And user enter "<City>" in city field

    Examples:
      | FullName | RediffID     | Password | Retype password | Alternate Email Address       | Mobile No. | Day | Month | Year | Gender | Country | City      |
      | Raviteja | teja.ravi476 | TEj@1234 | TEj@1234        | ravitejaparamkusam.@gmail.com | 9618586895 | 06  | NOV   | 1990 | Male   | India   | Bangalore |