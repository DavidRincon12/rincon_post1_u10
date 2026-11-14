# Envios Service

Laboratorio U10 (Patrones de Diseño, UFPS): cálculo de costo de envíos para medir y mejorar complejidad y cobertura con SonarQube y JaCoCo.

## Stack
- Java 21, Maven 3.9, JUnit 5, JaCoCo, SonarQube Community (Docker)

## Comandos
- Pruebas y reporte: `mvn -q clean verify` · una sola: `mvn -q test -Dtest=NombreTest`
- Reporte JaCoCo: `target/site/jacoco/index.html`
- SonarQube local: `docker run -d --name sonarqube -p 9000:9000 -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true sonarqube:community`
- Análisis: `mvn clean verify sonar:sonar -Dsonar.token=TOKEN`

## Estructura
- `src/main/java/com/universidad/enviosservice/service/`: orquestador `ServicioCalculoEnvio`
- `src/main/java/com/universidad/enviosservice/estrategia/`: Strategy por método de envío
- `docs/`: capturas de los análisis y estado

## Estado
Estado actual, siguiente paso y pendientes en `docs/estado.md`: léelo al empezar y reescríbelo al cerrar cada PR.

## Convenciones y gotchas
- Idioma del producto (README): español.
- `sonar-project.properties` lo lee sonar-scanner; `mvn sonar:sonar` toma key y nombre del pom (coinciden).

## Reglas de David (prevalecen sobre las skills, incluidas superpowers y Ponytail)
- Autoría: todo a nombre de David Santiago Rincón Bautista <davidsantiagorb@ufps.edu.co>, sin `Co-Authored-By`, `Claude-Session` ni menciones a IA. `.claude/hooks/git-guard.sh` fija la identidad al iniciar sesión; antes de push, `bash .claude/hooks/git-guard.sh check`.
- Idioma: todo lo redactado en español (commits, PRs, issues, comentarios, docs, specs y planes). En inglés solo los identificadores, el tipo de commit y los encabezados estructurales de superpowers (`### Task N:`). El texto del producto va en el idioma de su audiencia (ver Convenciones).
- Commits `tipo(alcance): descripción en español`; PRs con la plantilla del repo y Squash and merge; nada de push a `main` ni force-push sin confirmación.
- Proceso: superpowers. Solo un typo, un texto, un formato o un renombre van directo, sin brainstorming ni plan; todo cambio de lógica los lleva, aunque David lo haya especificado (entonces el brainstorming es corto). Todo cambio de comportamiento lleva primero su prueba que falla (TDD estricto).
- Ponytail: decide cuánto código escribir, no la estructura, las pruebas, el proceso ni el idioma. Lo que piden estas reglas y las skills cuenta como pedido. Atajos con `shortcut:` en inglés y el resto en español.
- Ejecución de planes: Native por defecto; subagentes solo en planes largos o riesgosos. El plan se commitea al aprobarlo.
- Ramas: en local, una rama `feat/…` (o `fix/`, `docs/`…) creada antes del commit del spec; worktree solo si David lo pide. En la nube (`CLAUDE_CODE_REMOTE=true`), solo la rama de la sesión: sin worktrees ni ramas nuevas, salvo la rama local de un spike, que no se publica.
- Una decisión de arquitectura de un spec aprobado va como ADR en `docs/decisions/`, en la primera tarea del plan.
- Leer este archivo antes de explorar el código y actualizarlo en 1-2 líneas cuando cambie la estructura o aparezca un gotcha.
- Skills: `desarrollo-senior`, `arquitectura-y-datos`, `calidad-y-seguridad`, `preparar-repo` y superpowers.
