package com.universidad.enviosservice.estrategia;

/**
 * Strategy: fórmula de costo base de un método de envío.
 * Cada implementación encapsula los tramos de peso y los recargos o límites
 * de distancia propios de su método; los ajustes por fragilidad y tipo de
 * cliente son transversales y se quedan en el orquestador.
 */
public interface EstrategiaEnvio {
    double calcular(double pesoKg, double distanciaKm);
}
