# Fitness Tracker (Spring Boot)

Backend REST API for a fitness workout tracker application.  
Users can sign up, sign in, manage exercises, and create workout plans.  
Built with **Spring Boot 3, Java 21, JPA, Security**.

---

## ✅ Features implemented so far
- Project structure under `com.example.fitness`
- Security config (disabled default Spring login for now)
- Auth module:
  - Signup with hashed password
  - Signin (JWT to be added later)
- Exercises module:
  - CRUD endpoints
  - Linked with `MuscleGroup` entity
- `.gitignore` optimized for Eclipse/Maven/Spring Boot

---

## 📂 Project structure
```
com.example.fitness
 ├── config
 ├── auth
 │    ├── controller
 │    ├── dto
 │    ├── entity
 │    ├── repository
 │    └── service
 ├── exercise
 │    ├── controller
 │    ├── dto
 │    ├── entity
 │    ├── repository
 │    └── service
 └── report (to be implemented)
```

---

## 🚀 Run locally
```bash
# Run with Maven
mvn spring-boot:run

# Or build and run
mvn clean package
java -jar target/fitness-0.0.1-SNAPSHOT.jar
```

App runs by default on [http://localhost:9090](http://localhost:9090).

---

## 🔗 API endpoints (so far)
### Auth
- `POST /api/v1/auth/signup`
- `POST /api/v1/auth/signin`

### Exercises
- `POST /api/v1/exercises`
- `GET /api/v1/exercises`
- `GET /api/v1/exercises/{id}`
- `PUT /api/v1/exercises/{id}`
- `DELETE /api/v1/exercises/{id}`

---

## 🛠️ Next steps
- Add CRUD for MuscleGroup
- Implement JWT authentication
- Add Workout and WorkoutItem modules
- Generate workout reports
