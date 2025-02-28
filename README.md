# City Management Project

This project allows managing cities, streets, houses, and apartments.

## 1. Run and Initialize DB using PostgreSQL and PgAdmin
1. Install PostgreSQL
2. Create a new database in PgAdmin, for example, `TPP_CIty`.
3. Run SQL scripts to create and initialize necessary tables. Sql file in sql_schema/db_init.sql

## 2. Run and Initialize DB using PostgreSQL and PgAdmin
Download template. Unarchive, open folder in terminal and in IDE run -> exception

## 3. Configure DB Access in Java App
1. Open the project in Java IDE
2. In the application.properties file, configure the database connection:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/TPP_CIty
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=none
```
