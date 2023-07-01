Feature: To verify RSA App

  Scenario Outline: user should login the Home page
    Given Open the RSA App
    When User should enter the "<Country>", "<UserName>","<Gender>"
    Then User should enter into Login Page

    Examples: 
      | Country   | UserName | Gender |
      | India     | Logesh   | Male   |
      | Argentina | Malini   | Female |
