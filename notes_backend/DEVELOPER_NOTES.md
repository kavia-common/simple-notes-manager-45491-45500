# Developer Notes

## Cleaning Gradle cache and rebuilding
If you notice repeated classpath-change restarts or unstable devtools reloads:

1) Stop the app.
2) Clean and rebuild:
   ./gradlew --no-daemon clean build
3) Start again:
   ./gradlew --no-daemon bootRun

This forces a clean classpath and reduces noisy restarts.

## Port and H2 settings
- Server runs on port 3001 (server.port=3001).
- H2 in-memory URL uses DB_CLOSE_DELAY=-1 and DB_CLOSE_ON_EXIT=FALSE to avoid premature close across restarts.

## API Docs
- JSON: /api-docs
- UI: /swagger-ui.html
