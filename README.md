# Gym Management – Back-end (Spring Boot)

API REST de l'application **Gym Management**, une application de gestion de salle de sport.
Le front-end Angular se trouve dans le dépôt [gym-management-app](https://github.com/ahmmedFAYE/gym-management-app).

> Projet personnel en cours de développement.

## Stack

- **Java 17**, **Spring Boot** (Spring Web MVC, Spring Data JPA)
- **PostgreSQL** (Hibernate, création automatique du schéma)
- **Lombok**
- Maven

## Architecture

Architecture en couches classique :

```
controller/   → points d'entrée REST
service/      → logique métier (interface + implémentation)
repository/   → accès aux données (Spring Data JPA)
entity/       → entités JPA (Member)
dto/          → objets d'échange (LoginRequest, AuthResponse, UserDto)
```

## Endpoints

Toutes les routes sont préfixées par `/api`.

| Méthode | Route | Description |
|---|---|---|
| `GET` | `/api/members` | Liste des membres |
| `GET` | `/api/members/{id}` | Détail d'un membre |
| `POST` | `/api/members` | Créer un membre |
| `PUT` | `/api/members/{id}` | Modifier un membre |
| `DELETE` | `/api/members/{id}` | Supprimer un membre |
| `POST` | `/api/aut/login` | Connexion (réponse simulée pour l'instant) |

## Lancer le projet

Prérequis : Java 17, PostgreSQL avec une base `gym_db`.

```bash
cd gym-backend
export DB_PASSWORD=votre_mot_de_passe
# facultatif : DB_URL, DB_USERNAME (par défaut : localhost:5432/gym_db, postgres)
./mvnw spring-boot:run
```

L'API est alors disponible sur `http://localhost:8080/api`.

## Prochaines étapes

- Authentification réelle avec Spring Security et JWT (la connexion renvoie aujourd'hui un utilisateur simulé)
- Validation des données et gestion centralisée des erreurs
- Tests unitaires et d'intégration

## Auteur

**Mouhamadou Lamine Faye** – développeur full-stack (Angular / Spring Boot)
[GitHub](https://github.com/ahmmedFAYE) · [LinkedIn](https://linkedin.com/in/mouhamadou-lamine-faye-dev-full-stack)
