# sdet-mobile-automation-framework
SDET Mobile Automation Framework using Appium, Java, TestNG with Page Object Model, Extent Reports, and CI/CD integration using Git and Jenkins.

# 📱 SDET Mobile Automation Framework

## 📌 Overview

This is a **Hybrid Mobile Automation Testing Framework** built using **Java, Appium, TestNG, and Maven**.
It follows the **Page Object Model (POM)** design pattern and supports scalable automation for Android applications.

The framework is integrated with **Jenkins CI/CD** to enable automated test execution and reporting.

---

## ⚙️ Tech Stack

* Java
* Appium
* TestNG
* Maven
* Selenium WebDriver
* Android Emulator / Real Device
* Git & GitHub
* Jenkins (CI/CD Integration)

---

## 🏗️ Framework Architecture

* Page Object Model (POM)
* Base Test Setup
* Utility Classes (Waits, Config, Screenshots)
* TestNG Test Execution
* Extent Reports / TestNG Reports
* Listener implementation for logging & reporting

---

## 🚀 Features

* 📱 Mobile App Automation (Android)
* 🔍 Page Object Model Design
* 🧪 TestNG Framework
* 📊 HTML/TestNG Reports in Jenkins
* 📸 Screenshot on Failure
* 🔄 Reusable Utilities
* ⚙️ Maven Build Management
* 🔗 Git Integration
* 🔁 Jenkins CI/CD Execution

---

## ▶️ How to Run Tests

### 1. Clone Repository

```bash
git clone https://github.com/jaiyesaibaba/sdet-mobile-automation-framework.git
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Run Tests

```bash
mvn test
```

---

## ⚙️ Jenkins Integration (CI/CD)

This project is integrated with Jenkins for continuous testing.

### 🔹 Job Configuration:

* Source Code: GitHub Repository
* Build Tool: Maven
* Goals:

```bash
clean test
```

### 🔹 Post-build Actions:

* HTML Report Publishing
* Test execution logs in Jenkins Console

### 🔹 Execution Flow:

1. Code pulled from GitHub
2. Maven build triggered
3. TestNG tests executed
4. Reports generated and published

---

## 📊 Reports

### 🔹 Local Reports:

```
target/surefire-reports/index.html
```

### 🔹 Jenkins Reports:

* Accessible from **Build → TestNG Report**
* Shows:

  * Passed / Failed tests
  * Execution summary
  * Detailed logs

---

## ❌ Known Issues

* UI elements may vary across devices (e.g., Network/SIM settings)
* Requires stable emulator/device configuration

---

## 👨‍💻 Author

**Hemalatha**
QA Automation Engineer | SDET Enthusiast

---

## ⭐ Future Enhancements

* Parallel execution
* Allure Reporting integration
* BrowserStack cloud testing
* Docker integration
* API testing module integration
* GitHub Webhook (auto trigger builds)

---

## 📌 Note

This project is part of my **SDET portfolio**, demonstrating:

* Mobile Automation Framework Design
* CI/CD Integration using Jenkins
* Real-world test execution and reporting

---
