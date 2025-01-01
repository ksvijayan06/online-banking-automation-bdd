# Online Banking Automation Framework

The **Online Banking Automation Framework** is an **End-to-End (E2E) BDD Cucumber** automation framework built to test the core banking functionalities of **XYZ Bank**. Developed during the **Furlough period in 2024**, this framework is designed to provide robust, maintainable, and scalable test automation solutions for banking applications. It leverages **Java**, **Selenium WebDriver**, and **Cucumber** to ensure seamless, cross-browser testing and efficient reporting.

## Key Features

- **Scalable and Maintainable**: Designed to handle growing applications with ease while ensuring future-proof maintenance.
- **Cross-Browser Testing**: Supports testing across multiple browsers to ensure compatibility and stability.
- **BDD with Cucumber**: Behavior-Driven Development with clear, readable Gherkin syntax that bridges the gap between technical and non-technical stakeholders.
- **Comprehensive Reporting**: Generates detailed **HTML**, **JSON**, and **DOCX** reports, providing both summary and detailed views of test results.
- **Efficient Logging**: Utilizes **Log4j** for comprehensive logging, aiding in better traceability and debugging.
- **Reusable Codebase**: Encourages reusability of code across different test scenarios, making the framework easily extendable and maintainable.

## Technologies and Tools

### Core Technologies:
- **Java**: Robust and scalable programming language for framework development.
- **Selenium WebDriver**: For automating browser interactions and UI testing.
- **Cucumber**: Behavior-Driven Development (BDD) tool that supports Gherkin syntax for writing test scenarios.
- **JUnit4**: For managing test execution and results.
- **Log4j**: Logging framework that provides efficient logging functionality.

### Libraries:
- **WebDriverManager**: Automatically manages browser drivers, eliminating manual setup.
- **poi-ooxml**: Used for generating custom DOCX reports.

## Folder Structure

The project is organized to ensure ease of navigation and scalability. Below is an overview of the folder structure:


## Project Folder Structure

- `src/`
  - `main/`
    - `java/`
      - `XYZ_Bank/`
        - `hooks/`
        - `pageObject/`
        - `runners/`
        - `stepDefinitions/`
          - `customerOperations/`
        - `utils/`
    - `resources/`
      - `featureFile/`
      - `TestCase/`
      - `config.properties`
      - `log4j.properties`
  
- `src/test/`
  - `java/`
    - `XYZ_Bank/`
      - `OnlineBankingApplication/`

- `target/` (Generated after execution)

- `test-report/` (Generated after execution)




