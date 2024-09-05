# SwagLabs BDD Automated Test

## Description

The **SwagLabs BDD Automated Test** is a practice project designed to implement Behavior Driven Development (BDD) for automated testing of a web application. The project utilizes the Page Object Model (POM) design pattern for structuring tests, with test cases defined in Gherkin language within feature files. The tests are executed using Cucumber, integrated with Selenium and JUnit.

## Dependencies

This project requires the following software and libraries:

- [![Java](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [![JUnit](https://img.shields.io/badge/JUnit-4.13.2-green)](https://junit.org/junit4/)
- [![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen)](https://www.selenium.dev/documentation/)
- [![Cucumber](https://img.shields.io/badge/Cucumber-6.x-yellow)](https://cucumber.io/docs/guides/10-minute-tutorial/)
- [![Maven](https://img.shields.io/badge/Maven-optional-blueviolet)](https://maven.apache.org/guides/index.html)

## Installation

Follow these steps to install and run the project:

1. **Install Java:** Ensure that Java is installed on your machine. If not, download and install the latest version of the [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Clone the repository:** Clone the project from GitHub or download the zip file.

   ```bash
   git clone https://github.com/username/swaglabs-bdd-automated-test.git
   cd swagLabsBdd
   
3. **Install Maven (optional):** If you don't have Maven installed, download and install it from the official website. Maven is used for managing dependencies and running tests.

    [Maven Installation Guide](https://maven.apache.org/install.html)

4. **Add environment variables:** The project requires certain environment variables to run.
    ```bash
   set PASSWORD=secret_sauce
   set STANDARD_USER=standard_user

5. **Install dependencies:** If you are using Maven, run the following command in the project root directory to install the dependencies.
   ```bash
   mvn clean install


## Usage
You can run the tests as follows:

1. Run from IDE: Open the project in a Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse). You can run the tests directly from the IDE.

2. Run with Maven: Execute the tests using Maven with the following command:
    ```bash
   mvn test
   
3. View Test Reports: After running the tests, Cucumber generates an HTML report that can be viewed in the test-reports/ directory.

## User Stories

- **As a User,** I want to log in so that I have access to features that require identification.
- **As a User,** I want to log out so that another user can use the application.
- **As a User,** I want to see an ordered list of the available products so that I can choose from them.
- **As a User,** I want to see every product on its own page so that I can get detailed information on the product.
- **As a User,** I want to put products into the cart so that I can buy them.
- **As a User,** I want to check out so that I can finish shopping.

## Contact


Feel free to reach out if you have any questions or suggestions! You can contact me at [gefazekas92@gmail.com].


