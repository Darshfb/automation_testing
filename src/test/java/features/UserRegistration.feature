Feature: User Registration
  I want to check that the user can register in our e-commerce website.

  Scenario Outline: User Registration
    Given The user in the home page
    When I click on register link
    And I entered "<firstName>", "<lastName>", "<email>", "<phone>", "<password>"
    Then The registration page displayed successfully

    Examples:
      | firstName | lastName | email               | phone    | password |
      | mostafa   | mahmoud  | emaimss000000l1231@gmail.com  | 50099992 | AB123456 |
      | Mohamed   | Ayad  | email4545mm1215453@gmail.com | 50850012 | AB123456 |

