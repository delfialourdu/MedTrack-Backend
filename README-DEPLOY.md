# MedTrack backend deployment

## Railway
1. Push this folder's contents to a GitHub repository (the `pom.xml` and `Dockerfile` should be at repository root).
2. Create a Railway MySQL service.
3. Deploy this repository as a separate Railway service. Railway should detect the Dockerfile.
4. In the backend service Variables, set:
   - `MYSQLHOST` = reference to MySQL service's `MYSQLHOST`
   - `MYSQLPORT` = reference to MySQL service's `MYSQLPORT`
   - `MYSQLDATABASE` = reference to MySQL service's `MYSQLDATABASE`
   - `MYSQLUSER` = reference to MySQL service's `MYSQLUSER`
   - `MYSQLPASSWORD` = reference to MySQL service's `MYSQLPASSWORD`
   Railway variable references are usually entered as `${{MySQL.MYSQLHOST}}` etc.; use the exact MySQL service name in place of `MySQL`.
5. Generate a public domain for the backend service. API base path is `/api/medicines`.

## Local run
Set `MYSQLPASSWORD` in your local environment (and any other MYSQL* variables if different), then run `./mvnw spring-boot:run` (Windows: `mvnw.cmd spring-boot:run`).

Never commit database passwords or local environment files.
