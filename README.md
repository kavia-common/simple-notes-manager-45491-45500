# simple-notes-manager-45491-45500

Notes Backend (Spring Boot) provides CRUD operations for notes with an in-memory H2 database and OpenAPI docs.

## Run
From the notes_backend directory:
- Unix/macOS: `./gradlew bootRun`
- Windows: `gradlew.bat bootRun`

App starts on port 3001.

- Health: GET http://localhost:3001/health
- Swagger UI: http://localhost:3001/swagger-ui.html
- OpenAPI JSON: http://localhost:3001/api-docs

## Endpoints
- POST /notes
- GET /notes
- GET /notes/{id}
- PUT /notes/{id}
- DELETE /notes/{id}

## Example Requests
- Create
  curl -sS -X POST http://localhost:3001/notes \
    -H "Content-Type: application/json" \
    -d '{"title":"First Note","content":"Hello world"}'

- List
  curl -sS http://localhost:3001/notes

- Get by id
  curl -sS http://localhost:3001/notes/1

- Update
  curl -sS -X PUT http://localhost:3001/notes/1 \
    -H "Content-Type: application/json" \
    -d '{"title":"Updated","content":"Updated content"}'

- Delete
  curl -sS -X DELETE http://localhost:3001/notes/1 -i

## Validation
- title: required, max 200 chars
- content: required, max 4000 chars

Validation and errors are returned as RFC7807 ProblemDetail.

## Seed Data
On startup, a few sample notes are auto-created for quick preview.

## Smoke Tests
See notes_backend/SMOKE_TESTS.md for a quick checklist.