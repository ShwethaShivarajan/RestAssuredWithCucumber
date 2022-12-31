Feature: To perform all the CRUD operations

  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario Outline: To Perform the POST Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I send "<Name>" and <Salary>
    And I perform post operation
    Then Response code should be 201

    Examples: 
      | Name  | Salary |
      | Nick |  18000 |
