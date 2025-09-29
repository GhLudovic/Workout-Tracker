# 🏋️ Fitness Tracker API (Spring Boot)

Backend API pour une application de suivi d’entraînement.  
Fonctionnalités : gestion des utilisateurs, groupes musculaires, exercices et plans d’entraînement.  
Auth sécurisée par **JWT**. DB gérée via **Flyway**.

---

## 🚀 Démarrage

### Prérequis
- Java 17+
- Maven
- Eclipse / VSCode
- Postman

### Lancer l’application
```bash
mvn spring-boot:run
```

L’API est dispo sur [http://localhost:9090](http://localhost:9090).

---

## 🗂️ Database
- H2 en mémoire (dev)  
- Migrations via Flyway (`src/main/resources/db/migration`):
  - `V1__create_schema.sql` → tables
  - `V2__seed_data.sql` → groupes musculaires + exercices initiaux

Console H2 : [http://localhost:9090/h2-console](http://localhost:9090/h2-console)

---

## 🔑 Auth
- `POST /api/v1/auth/signup` → créer un utilisateur
- `POST /api/v1/auth/signin` → login (JWT)

---

## 💪 MuscleGroups
- `GET /api/v1/muscle-groups` → liste
- `GET /api/v1/muscle-groups/{id}` → détail
- `POST /api/v1/muscle-groups` → créer
- `PUT /api/v1/muscle-groups/{id}` → modifier
- `DELETE /api/v1/muscle-groups/{id}` → supprimer

---

## 🏋️ Exercises
- `GET /api/v1/exercises`
- `GET /api/v1/exercises/{id}`
- `POST /api/v1/exercises`
- `PUT /api/v1/exercises/{id}`
- `DELETE /api/v1/exercises/{id}`

---

## 📅 Workouts
- `GET /api/v1/workouts?userId=1` → par utilisateur
- `GET /api/v1/workouts/{id}`
- `POST /api/v1/workouts`
- `PUT /api/v1/workouts/{id}`
- `DELETE /api/v1/workouts/{id}`

---

## 🧪 Tests avec Postman
1. Importer l’environnement :
   - `postman/fitness-tracker.postman_environment.json`
2. Importer la collection :
   - `postman/fitness-tracker-all.postman_collection.json`
3. Tester dans l’ordre :
   - Signup / Signin
   - CRUD MuscleGroups
   - CRUD Exercises
   - CRUD Workouts

---

## ✅ TODO (prochaines étapes)
- Ajouter génération de rapports (progression)
- Intégrer Swagger / OpenAPI Docs
- Ajouter tests unitaires et d’intégration
