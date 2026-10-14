# Fase3DMD

Cliente de escritorio (JavaFX) que se conecta a la base de datos `fase2_dmd` (MySQL, cargada en la Fase 2 vía Pentaho) y construye el dashboard/reportes de la Fase 3 — proyecto de cátedra DMD104, Universidad Don Bosco.

## Stack

- **JavaFX 17** — UI de escritorio
- **Maven** — build y dependencias (usar el wrapper `./mvnw` o `mvnw.cmd`, no requiere Maven instalado aparte del JDK)
- **MySQL Connector/J 9.7.0** — driver JDBC
- **MySQL Server** (`fase2_dmd`, `localhost:3306`) — mismo motor/base usado en Fase 2
- **IntelliJ IDEA** — IDE recomendado (plugin JavaFX + integración Git nativa)

## Requisitos para correr el proyecto

1. JDK 11+ instalado (Temurin recomendado).
2. MySQL Server corriendo localmente con la base `fase2_dmd` ya restaurada (script en `DMD FASE 2/Faae2_DMD.sql`).
3. Clonar el repo y abrir con IntelliJ IDEA, o ejecutar:
   ```
   ./mvnw clean javafx:run      # Linux/Mac
   mvnw.cmd clean javafx:run    # Windows
   ```

## Arquitectura de trabajo (4 personas)

División por capas, cada una en su propia rama hasta integrarse a `main` vía Pull Request:

| Área | Paquete | Responsable | Rama |
|---|---|---|---|
| Conexión y acceso a datos (JDBC, DAO/Repository) | `com.example.fase3dmd.dao` | — | `feature/dao-conexion` |
| Modelos y lógica de negocio (entidades, servicios) | `com.example.fase3dmd.model`, `com.example.fase3dmd.service` | — | `feature/modelo-servicios` |
| UI del dashboard (vistas FXML + controllers) | `com.example.fase3dmd.controller`, `resources/.../*.fxml` | — | `feature/ui-dashboard` |
| Reportes y gráficos (JavaFX Charts, export) | `com.example.fase3dmd.reportes` | — | `feature/reportes-graficos` |

## Flujo de ramas (GitHub Flow)

- `main` siempre estable/funcional — nunca se le hace push directo.
- Cada persona trabaja en su rama `feature/...`.
- Al terminar una funcionalidad: Pull Request hacia `main`, pedir revisión de al menos un compañero antes de mergear.
- Hacer `pull` de `main` seguido y frecuente para evitar conflictos grandes.
