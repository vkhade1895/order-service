Feature: Order management

  Scenario: Get all orders
    Given the system knows about the following orders:
      | id | status  |
      | 1  | CREATED |
    Then make an GET call

  Scenario: Create an order
    Given create valid order
    Then make an POST call
    Then check order created in database successfully