# Notes Backend

This Spring Boot app exposes CRUD endpoints for notes with H2 in-memory DB and Swagger UI.

## Run
- Unix/macOS: `./gradlew bootRun`
- Windows: `gradlew.bat bootRun`
- Swagger UI: http://localhost:3001/swagger-ui.html
- OpenAPI JSON: http://localhost:3001/api-docs
- Health: http://localhost:3001/health

## Lint (Checkstyle)
CI runs Checkstyle. You can run locally:
- `./gradlew checkstyleMain checkstyleTest`
Reports are in `build/reports/checkstyle/`. Rules are minimal and non-blocking.

## Smoke Tests
See SMOKE_TESTS.md for quick API checks.
