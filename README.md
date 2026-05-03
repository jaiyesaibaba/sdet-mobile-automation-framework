# sdet-mobile-automation-framework
SDET Mobile Automation Framework using Appium, Java, TestNG with Page Object Model, Extent Reports, and CI/CD integration using Git and Jenkins.
# 📱 SDET Mobile Automation Framework

## 📌 Overview
This is a **Hybrid Mobile Automation Testing Framework** built using **Java, Appium, TestNG, and Maven**.  
It follows industry-standard **Page Object Model (POM)** design pattern and supports scalable test automation for Android applications.

---

## ⚙️ Tech Stack

- Java
- Appium
- TestNG
- Maven
- Selenium WebDriver
- Android Emulator / Real Device
- Git & GitHub
- Jenkins (CI/CD - upcoming integration)

---

## 🏗️ Framework Architecture

- Page Object Model (POM)
- Base Test Setup
- Utility Classes (Waits, Config, Screenshots)
- TestNG Test Execution
- Extent Reports for reporting
- Listener implementation for logging & reporting

---

## 📁 Project Structure
src
├── test
│ ├── java
│ │ ├── com.qa.base
│ │ ├── com.qa.pages
│ │ ├── com.qa.tests
│ │ ├── com.qa.utils
│ │ └── com.qa.listeners
│
├── resources
│ └── config.properties


---

## 🚀 Features

- 📱 Mobile App Automation (Android)
- 🔍 Page Object Model Design
- 🧪 TestNG Test Framework
- 📊 Extent Reports Integration
- 📸 Screenshot on Failure
- 🔄 Reusable Utilities
- ⚙️ Maven Build Management
- 🔗 Git Version Control Ready

---

## ▶️ How to Run Tests

### 1. Clone Repository
```bash
git clone https://github.com/your-username/sdet-mobile-automation-framework.git

2. Install Dependencies
mvn clean install

3. Run Tests
mvn test

📊 Reports
After execution, reports will be generated at: /reports/ExtentReport.html

🔧 CI/CD Integration (Upcoming)
Jenkins Pipeline integration
GitHub Actions support
Docker + Selenium Grid (future enhancement)
BrowserStack cloud execution (planned)

👨‍💻 Author
Hemalatha SDET
QA Automation Engineer | SDET Enthusiast

⭐ Future Enhancements
Parallel execution
BrowserStack cloud testing
Docker integration
API testing module integration
Advanced reporting dashboards

📌 Note

This project is part of my SDET portfolio demonstrating real-world mobile automation framework design and CI/CD readiness.
