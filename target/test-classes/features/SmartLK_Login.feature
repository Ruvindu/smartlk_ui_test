
  Feature: SmartLK Test

    @ui @login
    Scenario Outline: Test SmartLK Login
      Given Launch SmartLK Login "https://smartlive.lk/login"
      When  Input <email> and <password>
      And Press Login
      Then <user> is logged in
      Examples:
        | email                         | password   | user      |
        | "ruvindumadushanka@gmail.com" | "rmsk@123" | "Ruvindu" |
#        | "ruvindumadushanka@gmail.com" | "rmsk@123" | "Ruvindu" |




    @SmokeTest
    Scenario Outline: Test Universal App login with valid credentials
      Given User is on welcome page
      When User enters '<idnumber>' in ID text box
      And Click user Continue
      And User enters '<username>' and '<password>'
      And Click user login
      Then User is on dashboard
      Examples:
        | idnumber | username | password |
        | 123456   | RUVI     | Ruvi@128 |




#    @ui @logout
#    Scenario: User Logout
#      Given On click logout
#      Then User is logged out