package com.universidad.enviosservice.estrategia;

/**
 * Recargo por peso común a todos los métodos de envío: los primeros 5 kg van
 * incluidos en la tarifa base, de 5 a 20 kg se cobra la tarifa media por kg y
 * por encima de 20 kg, la alta. Cada estrategia solo aporta sus tarifas.
 */
final class RecargoPorPeso {

    private RecargoPorPeso() {
    }

    static double calcular(double pesoKg, double tarifaMediaPorKg, double tarifaAltaPorKg) {
        if (pesoKg <= 5) {
            return 0;
        }
        if (pesoKg <= 20) {
            return (pesoKg - 5) * tarifaMediaPorKg;
        }
        return 15 * tarifaMediaPorKg + (pesoKg - 20) * tarifaAltaPorKg;
    }
}
