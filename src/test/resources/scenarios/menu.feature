Feature: menu test

  Background: set up
    When I open the Login page
    And I login into the system

  @run
  Scenario Outline: Verify menu items
    Then The following items are '<visibility>' on the menu widget
      | Обзор учетной записи |
      | Информация о записи  |
      | Безопасност          |

    Examples:
      | visibility    |
      | DISPLAYED     |
      | NOT_DISPLAYED |


  Scenario: Verify menu items - negative test
    Then The following items are 'NOT_DISPLAYED' on the menu widget
      | Инфо         |
      | Параметры    |
      | Безопасность |