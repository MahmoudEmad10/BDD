Feature:  OrangeHRM Management

  Scenario: Add a record and verify count increases by one
    Given user has logged in to OrangeHRM with username and password
    And user navigates to Admin tab
    When user retrieves the number of records
    And user adds a new record
    Then the records count should increase by one

  Scenario: Delete a record and verify count decreases by one
    Given user has logged in to OrangeHRM with username and password
    And user navigates to Admin tab
    And user retrieves the number of records
    When user search for the recently added record
    And user deletes the recently added record
    And user click on reset button
    Then the records count should decrease by one



