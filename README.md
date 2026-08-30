# Selenium Docker - Automated Test Suite

Automated test suite for web application testing using Selenium WebDriver 4 and TestNG. Implements the Page Object Model pattern to test flight reservation workflows including user registration, flight search, and booking confirmation with data-driven testing via JSON files.

## 🎯 Features

✅ **Page Object Model (POM)** - Organized, maintainable test structure  
✅ **Data-Driven Testing** - JSON-based parameterized test data  
✅ **TestNG Framework** - Advanced test execution with dependencies and reporting  
✅ **WebDriverManager** - Automatic browser driver management  
✅ **Multi-Test Scenarios** - Supports 1-4 passenger flight reservation workflows  
✅ **Logging & Reporting** - SLF4J logging with detailed test output  
✅ **Docker Ready** - Containerized setup for CI/CD pipelines  

## 📋 Prerequisites

- **Java 21** or higher
- **Maven 3.6** or higher
- **Chrome Browser** (for WebDriver testing)
- **Git** (for version control)

## 🚀 Installation

### 1. Clone the Repository
```bash
git clone https://github.com/steverogers2597/selenium-docker.git
cd selenium-docker
```

### 2. Verify Maven Installation
```bash
mvn -v
```

### 3. Install Dependencies
```bash
mvn clean install
```

## 📁 Project Structure

```
selenium-docker/
├── src/
│   ├── main/java/com/steverogers2597/
│   │   ├── pages/              # Page Object classes
│   │   │   ├── flightreservation/
│   │   │   │   ├── RegistrationPage.java
│   │   │   │   ├── RegistrationConfirmationPage.java
│   │   │   │   ├── FlightsSearchPage.java
│   │   │   │   ├── FLightsSelectionPage.java
│   │   │   │   └── FlightConfirmationPage.java
│   │   │   └── vendorportal/
│   │   └── utils/
│   │
│   └── test/java/com/steverogers2597/
│       ├── tests/
│       │   ├── AbstractTest.java        # Base test class
│       │   ├── flightreservation/
│       │   │   ├── FlightReservationTest.java
│       │   │   └── model/
│       │   │       └── FlightReservationTestData.java
│       │   └── vendorportal/
│       ├── utils/
│       │   ├── JsonUtil.java
│       │   └── ResourceLoader.java
│       └── resources/
│           ├── test-data/
│           │   └── flight-reservation/
│           │       ├── passenger-1.json
│           │       ├── passenger-2.json
│           │       ├── passenger-3.json
│           │       └── passenger-4.json
│           ├── test-suites/
│           │   ├── flight-reservation.xml
│           │   └── vendor-portal.xml
│           └── logback.xml
├── pom.xml
├── test-suite.xml
└── README.md
```

## 🧪 Test Scenarios

### Flight Reservation Test Suite

Complete end-to-end test workflow:

1. **userRegistrationTest** - Register new user with personal details
2. **registrationConfirmationTest** - Verify registration and navigate to flights
3. **flightSearch** - Search for flights (Two Way, Business Class, London → Zurich)
4. **flightSelectionTest** - Select outbound and return flights
5. **flightConfirmationTest** - Confirm booking and verify total price

**Test Data:**
- 4 test scenarios (1-4 passengers)
- Pricing: $584, $1169, $1753, $2338 USD

## 🔧 Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn clean test -Dtest=FlightReservationTest
```

### Run with Specific Suite
```bash
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/test-suites/flight-reservation.xml
```

### Run from IDE (IntelliJ IDEA)
1. Right-click test class → **Run 'FlightReservationTest'**
2. Right-click test method → **Run specific test**

## 📊 Test Data Format

Test data is stored in JSON format:

```json
{
  "firstName": "Mike",
  "lastName": "Dawson",
  "email": "test@example.com",
  "password": "test123",
  "street": "123 main street",
  "city": "NY",
  "zip": "132212",
  "passengersCount": "1",
  "expectedPrice": "$584 USD"
}
```

## 📦 Technology Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 21 | Programming Language |
| Selenium WebDriver | 4.30.0 | Browser Automation |
| TestNG | 7.11.0 | Test Framework |
| Jackson | 2.19.0 | JSON Processing |
| WebDriverManager | 6.2.0 | Driver Management |
| Logback | 1.5.18 | Logging |
| Maven | 3.11.0 | Build Tool |

## 🔑 Key Classes

| Class | Purpose |
|-------|---------|
| `AbstractTest` | Base test class with WebDriver setup/teardown |
| `FlightReservationTest` | Main test workflow for flight booking |
| `JsonUtil` | JSON data loading and parsing utility |
| `ResourceLoader` | File resource resolution utility |
| `RegistrationPage` | Page Object for registration page |
| `FlightsSearchPage` | Page Object for flight search page |
| `FLightsSelectionPage` | Page Object for flight selection page |

## 📝 Test Report

After running tests, reports are generated in:
```
target/test-output/
```

View HTML reports for detailed test execution results.

## 🐛 Troubleshooting

### Issue: Chrome Driver Not Found
```bash
# Solution: WebDriverManager will automatically download it
mvn clean test
```

### Issue: Test Data Not Loading
- Verify JSON files exist in `src/test/resources/test-data/`
- Check property names match Java record fields
- Review logs for ResourceLoader details

### Issue: Chrome Fails to Start
- Ensure Chrome is installed
- Check for compatible Chrome version
- Review AbstractTest.java ChromeOptions settings

## 📚 Learning Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Page Object Model Pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see LICENSE file for details.

## 👨‍💻 Author

**Arnab Banerjee**  
- GitHub: [@steverogers2597](https://github.com/steverogers2597)
- Email: arnab.banerjee1997@gmail.com

---

## 🎓 Getting Started Quick Guide

```bash
# 1. Clone repository
git clone https://github.com/steverogers2597/selenium-docker.git

# 2. Navigate to project
cd selenium-docker

# 3. Run tests
mvn clean test

# 4. View reports
# Reports generated in target/test-output/
```

## ⭐ Future Enhancements

### Infrastructure & Containerization
- [ ] **Docker Containerization** - Run tests inside Docker containers for consistency across environments
- [ ] **Selenium Grid Infrastructure** - Disposable Selenium Grid setup using Docker for parallel test execution
- [ ] **Docker Compose** - Multi-container orchestration for easy local testing environment setup

### CI/CD Integration
- [ ] **Jenkins Pipeline** - Automated test execution triggered by code commits
- [ ] **Jenkins Agents** - Distributed testing across multiple Jenkins agents
- [ ] **Build Artifacts** - Automated test report generation and artifact storage

### Cloud Deployment
- [ ] **AWS Infrastructure** - Deploy and run tests on AWS EC2 instances
- [ ] **AWS Lambda** - Serverless test execution for on-demand testing
- [ ] **S3 Integration** - Store test reports and artifacts in AWS S3
- [ ] **CloudWatch** - Monitoring and logging for test execution metrics

### Testing Enhancements
- [ ] Allure reporting integration
- [ ] Parallel test execution with TestNG
- [ ] Cross-browser testing (Firefox, Edge, Safari)
- [ ] Performance metrics collection
- [ ] Screenshot and video recording on failure
- [ ] Email notifications for test results

### DevOps & Monitoring
- [ ] Kubernetes deployment for test infrastructure
- [ ] Prometheus metrics collection
- [ ] Grafana dashboards for test metrics visualization
- [ ] Slack notifications for build status

---

**Happy Testing! 🚀**
