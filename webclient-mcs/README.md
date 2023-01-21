## Spring WebFlux | WebClient
Dans ce repo, nous allons avoir comment implementer Spring WebClient (avec Exemples CRUD).

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Lombok
- MapStruct
- spring-boot-starter-webflux
- Maven 3+

### Exemples
---
- `webclient-mcs` un client Spring WebClient qui s'exécute sur le port 8082 et utilise les API REST de `socle-spring-data-jpa`. 

### Exécuter et tester le projet
---
- Exécuter l'application : `mvn spring-boot:run`
- Importer dans Postman la collection `spring_WebClient.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8082/v3/api-docs/ et/ou http://localhost:8082/swagger-ui/index.html