# 📑 Changelog
Toutes les modifications notables de ce projet seront documentées ici.

Le format est basé sur [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),  
et ce projet suit [Semantic Versioning](https://semver.org/).

---

## [Unreleased]

### Added
- Module **MuscleGroup** : entity, repository, service et controller (CRUD complet)
- Flyway migrations :
  - `V1__create_schema.sql` : création des tables (`users`, `muscle_groups`, `exercises`, `workouts`, `workout_items`)
  - `V2__seed_data.sql` : insertion des groupes musculaires + exercices initiaux
- Postman configuration :
  - `fitness-tracker-all.postman_collection.json`
  - `fitness-tracker.postman_environment.json`
- Documentation mise à jour :
  - README avec endpoints MuscleGroup et instructions Postman
  - CHANGELOG ajouté

### Changed
- Alignement `ExerciseRepository` : méthode `findByMuscleGroup_Id(Long)` au lieu de `findByMuscleGroup(String)`
- Entité `WorkoutItem` : champ `weight` mappé en `BigDecimal` avec précision `(6,2)`
- Ajout de `@Table(name="exercises")` à `Exercise`
- `SecurityConfig` : ajout d’un `PasswordEncoder` bean

### Fixed
- Problèmes de build liés au type de colonne `weight` et à la comparaison MuscleGroup/String
