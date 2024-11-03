Feature:  OrangeHRM Management

  Scenario Outline: Add a record and verify count increases by one
    Given user has logged in to OrangeHRM with username and password
    And user navigates to Admin tab
    When user retrieves the number of records
    Then user adds a new record with <role> and <status> and <username> and <password>
    Then the records count should increase by one

    Examples:
      | role  | status  | username | password  |
      | Admin | Enabled | Mohamed  | Test@1234 |

  Scenario Outline: Delete a record and verify count decreases by one
    Given user has logged in to OrangeHRM with username and password
    And user navigates to Admin tab
    And user retrieves the number of records
    When user search for the recently added <username>
    And user deletes the recently added record
    And user click on reset button
    Then the records count should decrease by one

    Examples:
      | username |
      | Mohamed  |




