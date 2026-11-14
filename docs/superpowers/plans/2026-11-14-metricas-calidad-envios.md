# Plan: métricas de calidad y refactor en envios-service

Spec: `docs/superpowers/specs/2026-11-14-metricas-calidad-envios-design.md`. Ejecución: Native.

### Task 1: Proyecto Maven y clase de negocio
`pom.xml` (Java 21, JUnit 5, JaCoCo prepare-agent/report) y `ServicioCalculoEnvio` tal cual la guía. Verificar con `mvn -q compile`. Commit `feat: agregar ServicioCalculoEnvio...`.

### Task 2: Suite inicial y configuración de Sonar
`ServicioCalculoEnvioTest` (2 pruebas) y `sonar-project.properties` comentado. `mvn clean verify` en verde y `jacoco.xml` generado. Commit `test: agregar suite inicial...`.

### Task 3: Análisis inicial
Crear proyecto y token en SonarQube, `mvn sonar:sonar`, leer métricas por API (complexity, branch_coverage, line_coverage, code_smells), capturas en `docs/`, README con Parte 1. Commit `docs: documentar hallazgos...`.

### Task 4: Pruebas de estrategias (TDD, rojo)
Pruebas por estrategia con tramos de peso, límites (5, 20, 300, 500, 5000 km) y la excepción de OVERNIGHT. Deben fallar por no existir las clases.

### Task 5: Refactor Strategy (verde)
Interfaz + 4 estrategias + orquestador con `Map.of`. La suite inicial y las nuevas en verde. Commit `refactor: extraer calculo...`.

### Task 6: Ampliar ServicioCalculoEnvioTest
Fragilidad, CORPORATIVO, método no soportado, combinación por método. Commit `test: agregar pruebas de estrategias...`.

### Task 7: Quality Profile, Quality Gate y segundo análisis
Por API: perfil "Estándar Laboratorio" (copia de Sonar way) con S1541 umbral 10; gate con las 3 condiciones; asignarlos; re-analizar; capturas finales; README completo y `docs/estado.md`. Commits `docs: completar README...` y `docs: version final del README...`.
