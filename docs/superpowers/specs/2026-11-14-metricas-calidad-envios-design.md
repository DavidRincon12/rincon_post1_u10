# Diseño: métricas de calidad y refactor guiado en envios-service

## Intención
Entregar el post-contenido U10: diagnosticar `ServicioCalculoEnvio.calcularCosto()` con SonarQube + JaCoCo reales, refactorizarlo con un patrón justificado, subir la cobertura de forma significativa y comparar antes/después con evidencia.

## Objetivos / no objetivos
- Objetivos: CC del método −50 % o más, cobertura de ramas +15 pp o más, Quality Gate "Estándar Laboratorio" asignado y evaluado, README con las 6 decisiones.
- No objetivos: Spring Boot, capa web, persistencia.
- Anti-objetivo: subir la cobertura con pruebas que no verifican valores distintos.

## Restricciones
- Java 21, Maven, JUnit 5. Código inicial y suite inicial exactamente como en la guía.
- SonarQube Community local en Docker dentro de la sesión en la nube (efímero).
- Push solo a la rama de la sesión; `main` lo fusiona David.

## Enfoques
- **Strategy (elegido):** cada rama de `metodoEnvio` calcula el mismo resultado (un costo) con su fórmula, elegida una vez por un valor discreto. Mapa `String → EstrategiaEnvio`.
- State: descartado; el servicio no guarda estado entre llamadas.
- Chain of Responsibility: descartado; solo aplica una rama y el orden no importa.

## Decidido
- Paquete `com.universidad.enviosservice.estrategia` con interfaz y 4 estrategias; fragilidad y tipo de cliente se quedan en el orquestador (reglas transversales).
- Quality Profile y Quality Gate creados por la API web de SonarQube con los valores de la guía.
- Capturas con Playwright headless sobre el dashboard real y el HTML de JaCoCo.

## A criterio del implementador
- Valores esperados de las pruebas nuevas, calculados a mano desde las fórmulas.
