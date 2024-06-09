@Regression
Feature: Get status of HW phone
  This Feature file contains all the get calls on

  Scenario: Get HW Phone status
    Given I have endpoint as "apiBaseUrl/GET_STATUS"
    When I send the "get" request to "get Status of the HW phone"
      | description | key     | value                                |
      | queryParam  | user_id | cHJhdmVlbkBuaXN3ZXkuY29tfDI3MjAzMjc= |
    Then I should see the response status code as "200"
@Smoke
    Scenario: Get Properties
      Given I have endpoint as "apiBaseUrl/GET_PROPERTIES"
      When I send the "get" request to "get properties of the HW phone"
        | description | key     | value                                |
        | queryParam  | user_id | cHJhdmVlbkBuaXN3ZXkuY29tfDI3MjAzMjc= |
        | queryParam  | contact_id | 21728779167 |
        | queryParam  | object_type | contacts |
      Then I should see the response status code as "200"
@R
  Scenario: create template
    Given I have endpoint as "apiBaseUrl/CREATE_TEMPLATE"
    When I send the "post" request to "create template" using request body as "createTemplate"
    Then I should see the response status code as "200"
    And I should see the following parameters in response
      | Description          | Key          |
      | template id | JSON_PATH_CREATE_TEMPLATE_ID |


