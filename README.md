## Spring WebFlux | WebClient
Dans ce repo, nous allons avoir comment implementer Spring WebClient (avec Exemples CRUD).

### Qu'est-ce que Spring WebClient ?
---
**Spring WebClient** est un client Web non bloquant et réactif pour effectuer des requêtes HTTP. WebClient a été ajouté au Spring 5 (module spring-webflux) et fournit une API de style fonctionnel fluide.
Depuis le Spring 5 , WebClient c'est l'approche recommandée.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Lombok
- MapStruct
- Spring Data JPA
- spring-boot-starter-webflux
- Maven 3+
- PostgreSQL

### Exemples
---
- `socle-spring-data-jpa` un microservice CRUD qui s'exécute sur le port 8081.
- `webclient-mcs` un client Spring WebClient qui s'exécute sur le port 8082 et utilise les API REST de `socle-spring-data-jpa`. 

### Exécuter et tester le projet
---
- Exécuter en premier `socle-spring-data-jpa` puis `webclient-mcs` : `mvn spring-boot:run`
- Importer dans Postman la collection `spring_WebClient.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8081/v3/api-docs/ et/ou http://localhost:8081/swagger-ui/index.html