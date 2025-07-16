# 🇦🇷 EducAR Stats API 📊
1. [ ] **REST API for analyzing and predicting education indicators in Argentina**  
Designed with Java, Spring Boot, and SOLID principles.  
💡 Includes a Python-based Machine Learning microservice for predictions.

## 🚀 Features
- 📊 Education data analysis: enrollment, dropout and graduation rates
- 🔮 Prediction of graduation rate by Machine Learning (ML)
- 🧠 Province classification by educational development level (AI)
- ⚡ Efficient processing with multithreading
- 📦 Clean architecture with design patterns

## 🌐 Endpoints (MVP)
| Method | Endpoint                                  | Description                                    |
|--------|-------------------------------------------|------------------------------------------------|
| GET    | /api/education/stats/enrollment         | Enrollment rate by gender and province        |
| POST   | /api/education/predict/graduation-rate  | Predicts graduation rates using ML            |
| GET    | /api/education/classify/provinces       | Classifies provinces by educational level (AI) |

## ⚙️ Tech Stack
- ☕ Java 17
- 🌱 Spring Boot 3
- 🐘 PostgreSQL (H2 for development)
- 🧪 JUnit 5 + Mockito
- 📊 JaCoCo (test coverage)
- 🤖 Python + Flask (AI microservice)
- 🚀 Docker & Jenkins (simulated CI/CD pipeline)

## 🏁 Getting Started 
1. Clone the repo
   git clone https://github.com/iaraAlfaroAsad/educarstats.git
2. Import as Maven project in IntelliJ or run:
   ./mvnw spring-boot:run
3. Visit: http://localhost:8080

## Author 👩‍💻
Iara Alfaro Asad  
Backend Developer  
[Linkedin](https://www.linkedin.com/in/iara-alfaro-asad/)



