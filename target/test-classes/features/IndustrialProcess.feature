Feature: Lexis Nexis Industrial Process

  @FinancialServices
  Scenario: Validate the financial services are accessible or not
    Given the user is landing on the site
    When click the Choose your Industry link
    Then validate the following industry headings are present and clickable
      | Financial Services           |
      | Insurance                    |
      | Life and Pensions            |
      | Corporations and Non-Profits |
    And click on the "Financial Services" link
    Then validate the following financial services are present and clickable
      | Financial Crime Compliance       |
      | Customer Data Management         |
      | Collections and Recovery         |
      | Risk Orchestration               |
      | Fraud and Identity Management    |
      | Credit Risk Assessment           |
      | Investigations and Due Diligence |

  @FinancialServices
  Scenario: Validate the financial services are accessible or not
    Given the user is landing on the site
    When click the Choose your Industry link
    Then validate the following industry headings are present and clickable
      | Financial Services           |
      | Insurance                    |
      | Life and Pensions            |
      | Corporations and Non-Profits |
    And click on the "Financial Services" link
    Then validate the following financial services are present and clickable
      | Financial Crime Compliance       |
      | Customer Data Management         |
      | Collections and Recovery         |
      | Risk Orchestration               |
      | Fraud and Identity Management    |
      | Credit Risk Assessment           |
      | Investigations and Due Diligence |
