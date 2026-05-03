# Gestión Académica API

API REST desarrollada con Spring Boot para gestionar profesores, asignaturas, cursos, estudiantes y matrículas.

## Tecnologías

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger / OpenAPI
- Jakarta Validation

## Funcionalidades

- Crear y consultar profesores.
- Crear y consultar asignaturas.
- Crear, consultar y actualizar cursos.
- Crear y consultar estudiantes.
- Crear y consultar matrículas.
- Respuestas estandarizadas con `ResponseBase`.
- Validación de requests con `@Valid`.
- Manejo global de errores con `GlobalExceptionHandler`.

## Swagger

Con la aplicación ejecutándose, la documentación está disponible en:

```text
http://127.0.0.1:8080/swagger-ui.html
```

## Base de datos

La API usa PostgreSQL con una base de datos llamada `gestion_academica`.
