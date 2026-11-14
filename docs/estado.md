# Estado

## Estado actual
- Proyecto Maven `envios-service` con Strategy por método de envío (`estrategia/`) y orquestador en `service/`.
- 32 pruebas JUnit 5 en verde; JaCoCo con 100 % de líneas y ramas.
- README con las 6 decisiones de diseño, la tabla antes/después y las capturas en `docs/`.
- Último análisis en SonarQube local: Quality Gate "Estándar Laboratorio" en Passed.

## Último cambio
Rama `claude/clever-cori-8di7ls`: laboratorio U10 completo (Parte 1 diagnóstico, Parte 2 refactor + gate).

## Siguiente paso
- Fusionar la rama en `main` y subir el enlace del repo a NPLAD UFPS.

## Decisiones vigentes
- Strategy con `Map<String, EstrategiaEnvio>`; fragilidad y tipo de cliente se quedan en el orquestador (README, decisión 4).
- `RecargoPorPeso` concentra los tramos de peso comunes (salió del gate por duplicación).
- Gate: cobertura ≥ 70 %, 0 code smells nuevos, duplicación ≤ 5 %; perfil con S1541 ≤ 10.

## Pendientes y gotchas
- `mvn sonar:sonar` no lee `sonar-project.properties`: el host va en el pom (si no, el plugin 5.x apunta a SonarCloud).
- SonarQube 26.11: el perfil por defecto es "Sonar way core" (sin S1541/S3776) y al crear un gate agrega 4 condiciones solo.
- El servidor SonarQube vivía en la sesión en la nube: para reproducir hay que levantarlo y recrear perfil y gate (pasos en el README).
