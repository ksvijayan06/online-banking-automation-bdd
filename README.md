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


### Explanation of Key Directories:
1. **`XYZ_Bank.hooks`**: Contains the hooks for setting up and tearing down tests (e.g., opening and closing browsers).
2. **`XYZ_Bank.pageObject`**: Implements the Page Object Model (POM) pattern for reusability and maintainability of web elements.
3. **`XYZ_Bank.runners`**: The runner class where test execution is triggered. It specifies the feature files and step definitions for Cucumber.
4. **`XYZ_Bank.stepDefinitions`**: Contains step definitions that map the Gherkin steps in the feature files to Java methods.
5. **`XYZ_Bank.utils`**: Includes utility classes for functions that can be reused across multiple tests.
6. **`featureFile`**: Contains Cucumber feature files that define test scenarios in Gherkin syntax.
7. **`TestCase`**: Test case-related files needed for the tests.

## Getting Started:

### Prerequisites:
- **Java** (version 1.8 or higher) installed.
- **Maven** for dependency management and project build.
- **Eclipse** (or any preferred IDE) set up for Java and Maven projects.
- **Browser** for browser automation (WebDriverManager will handle Browser driver automatically).

### Setup and Execution:
1. **Clone the repository**:
Clone the project repository to your local machine using **Git**:

```bash
git clone https://github.com/ksvijayan06/online-banking-automation-bdd.git
```

### 2. Import the Project into Your IDE

#### For **Eclipse**:
1. Open **Eclipse**.
2. Go to **File** > **Import** > **General** > **Existing Projects into Workspace**.
3. Browse to the folder where you cloned the repository and select it.
4. Click **Finish**.

#### For **IntelliJ IDEA**:
1. Open **IntelliJ IDEA**.
2. Click **File** > **Open** and select the folder where you cloned the repository.
3. IntelliJ will automatically detect it as a Maven project.

### 3. Install Project Dependencies

Once the project is loaded in your IDE, **Maven** will automatically handle the dependencies. If needed, you can manually update them:

- **In Eclipse**: Right-click on the project > **Maven** > **Update Project**.
- **In IntelliJ IDEA**: Right-click on the project > **Maven** > **Reimport**.

### 4. Run the Tests

To execute the tests:

1. Navigate to the **`XYZ_Bank.runners`** package in your IDE.
2. Locate and open the **`RunnerClass.java`** file.
3. Right-click on the file and select **Run As** JUnit Test(or use your IDE's run options).
4. The framework will begin executing the tests.

## Reporting

After running the tests, you will find the following reports:

- **Cucumber HTML & JSON Reports** in the `target` directory.
- **Custom DOCX Reports** for formal documentation, can be found in the `test-report` directory.


## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

