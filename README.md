# E2E Testing for SauceDemo Application

This project is an end-to-end (E2E) testing suite for the SauceDemo application using Selenium. The suite covers functionalities such as login, cart operations, inventory management, and checkout processes. It leverages the Page Object Model (POM) to enhance maintainability and readability.

## Table of Contents

- [Project Overview](#project-overview)
- [Installation](#installation)
- [Usage](#usage)
- [Test Data](#test-data)
- [Running Tests](#running-tests)

## Project Overview

The project consists of the following main components:

- **Page Objects**: Encapsulate the UI interactions for different pages (Login, Inventory, Cart, Checkout).
- **Tests**: Test suites that validate the application functionalities using the Selenium and TestNG framework.

### Page Objects

- `LoginPage`: Handles actions related to user login.
- `InventoryPage`: Manages inventory-related actions, including filtering and adding items to the cart.
- `CartPage`: Handles operations related to viewing and modifying the shopping cart.
- `CheckoutPage`: Manages the checkout process.

## Installation

To set up this project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Muhdo/YouVerify.git
   cd YouVerify
   Import the project into your IDE as a Maven project.
   Install project dependencies
   Run the testng file
   The tests are runs automatically every day at 12pm and whenever a push or pull request is made to the main branch of the repository.

2. Run the project from github actions:
    ```bash
   To run the code on github actions manually, go to the repository and go to the actions tab, select the name of your workflow (YouVerify Web Automation Assessment CI with maven), Click on the run workflow button and select Run workflow
