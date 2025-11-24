# Notes Backend - Smoke Tests

These quick checks validate that the app started cleanly and core endpoints work.

1) Start the app
   ./gradlew clean bootRun

Expected in logs:
- No ConflictingBeanDefinitionException
- Hibernate Validator initialized (no "Unable to create a Configuration, because no Bean Validation provider could be found" warning)
- H2 started; URL contains DB_CLOSE_ON_EXIT=FALSE
- Tomcat started on port(s): 3001

2) API docs
- OpenAPI JSON:   curl -sS http://localhost:3001/api-docs | jq '.openapi'
  Expected: returns "3.0.x"
- Swagger UI:     open http://localhost:3001/swagger-ui.html

3) Health and hello
- Health:         curl -sS http://localhost:3001/health
  Expected: "OK"
- Hello:          curl -sS http://localhost:3001/
  Expected: Welcome string

4) CRUD
- Create:
  curl -sS -X POST http://localhost:3001/notes \
    -H "Content-Type: application/json" \
    -d '{"title":"First Note","content":"Hello world"}'
  Expected: 201 and a JSON with id/title/content

- List:
  curl -sS http://localhost:3001/notes
  Expected: array with seeded and created notes

- Get by id:
  curl -sS http://localhost:3001/notes/1

- Update:
  curl -sS -X PUT http://localhost:3001/notes/1 \
    -H "Content-Type: application/json" \
    -d '{"title":"Updated","content":"Updated content"}'

- Delete:
  curl -i -sS -X DELETE http://localhost:3001/notes/1
  Expected: 204 No Content
