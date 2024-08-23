Feature: Sorting Items
  As a User
  I want to see an ordered list of the available products
  So that I can choose from them.

  Scenario Outline: Descending order of products
    Given I am on the home page
    When I select the "<type>" of sorting
    Then I see the products sorted in descending order by "<itemParameter>"

    Examples:
      | itemParameter        | type                |
      | inventory_item_price | Price (high to low) |
      | inventory_item_name  | Name (Z to A)       |

  Scenario Outline: Ascending order of products
    Given I am on the home page
    When I select the "<type>" of sorting
    Then I see the products sorted in ascending order by "<itemParameter>"

    Examples:
      | itemParameter        | type                |
      | inventory_item_price | Price (low to high) |
      | inventory_item_name  | Name (A to Z)       |
