# Taller Práctico: API RESTful con Spring Boot + H2
## Programación Backend – Desarrollo de APIs REST

### Objetivo del Taller
Desarrollar una API RESTful utilizando **Spring Boot** para administrar un catálogo de productos de un e-commerce, aplicando:
- Arquitectura por capas.
- Validaciones de datos.
- Manejo global de excepciones.
- Documentación automática con Swagger/OpenAPI.

---

### Indicaciones Generales
- **IDE:** NetBeans.
- **Lenguaje:** Java 17 o superior.
- **Base de Datos:** H2 Database (Obligatoria).
- **Ejecución:** Local.
- **Frontend:** No se requiere.
- **Uso de IA:** Permitido como apoyo académico, pero el estudiante debe ser capaz de explicar todo el código entregado.

---

### Arquitectura y Tecnologías
#### Capas Obligatorias
1. `controller`
2. `service`
3. `repository`
4. `entity`
5. `exception`
6. `config`

#### Dependencias Necesarias
- Spring Web
- Spring Data JPA
- Validation
- H2 Database
- Swagger/OpenAPI

---

### Modelo de Datos: `Product`
| Campo | Tipo | Validación Mínima |
| :--- | :--- | :--- |
| `id` | Long | (Autogenerado) |
| `name` | String | `@NotBlank` |
| `description` | String | - |
| `price` | Double | `@Positive` |
| `stock` | Integer | `@Min(0)` |
| `category` | String | `@NotBlank` |
| `createdAt` | LocalDateTime | (Automático) |

---

### Endpoints de la API
| Método | Endpoint | Función | Respuestas Esperadas |
| :--- | :--- | :--- | :--- |
| **GET** | `/products` | Listar con paginación (`page`, `size`) | 200 OK |
| **GET** | `/products/{id}` | Obtener producto por ID | 200 OK, 404 Not Found |
| **POST** | `/products` | Crear nuevo producto | 201 Created, 400 Bad Request |
| **PUT** | `/products/{id}` | Actualizar producto existente | 200 OK, 404 Not Found |
| **DELETE** | `/products/{id}` | Eliminar producto | 204 No Content, 404 Not Found |

---

### Configuración y Requisitos

#### 1. Base de Datos H2
- Configurar en `application.properties`.
- Consola H2 habilitada en: `http://localhost:8080/h2-console`

#### 2. Paginación
- El endpoint `GET /products` debe usar `Pageable`.
- Debe permitir parámetros como `/products?page=0&size=5`.

#### 3. Manejo de Excepciones
- Crear excepción personalizada: `ProductNotFoundException`.
- Implementar manejo global con `@ControllerAdvice`.
- Retornar códigos HTTP adecuados (400, 404, 500).

#### 4. Documentación (Swagger/OpenAPI)
- Usar anotaciones `@Operation` y `@ApiResponse`.
- Acceso: `http://localhost:8080/swagger-ui.html`

---

### Criterios de Evaluación
| Criterio | Porcentaje |
| :--- | :--- |
| Arquitectura por capas | 20% |
| Endpoints funcionales | 25% |
| Uso correcto de anotaciones | 15% |
| Validaciones | 10% |
| Manejo de excepciones | 10% |
| Paginación | 10% |
| Swagger/OpenAPI | 10% |

---

### Puntos Extra (Opcionales)
- Búsqueda por categoría o nombre.
- Ordenamiento dinámico.
- Implementación de **DTOs**.
- Seguridad con **JWT**.

---
> **Recomendación:** Mantener el código organizado, usar nombres claros y verificar todas las respuestas HTTP antes de la entrega.
