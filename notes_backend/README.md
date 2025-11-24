# Notes Backend

This Spring Boot app exposes CRUD endpoints for notes with H2 in-memory DB and Swagger UI.

## Run
- Unix/macOS: `./gradlew bootRun`
- Windows: `gradlew.bat bootRun`
- Swagger UI: http://localhost:8080/swagger-ui.html
- Health: http://localhost:8080/health

## Lint (Checkstyle)
CI runs Checkstyle. You can run locally:
- `./gradlew checkstyleMain checkstyleTest`
Reports are in `build/reports/checkstyle/`. Rules are minimal and non-blocking.
