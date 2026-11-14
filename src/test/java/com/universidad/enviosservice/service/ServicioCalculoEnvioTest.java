package com.universidad.enviosservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServicioCalculoEnvioTest {

    private final ServicioCalculoEnvio servicio = new ServicioCalculoEnvio();

    @Test
    void calculaEnvioEstandarPesoBajo() {
        double costo = servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "REGULAR", false);
        assertEquals(50.0, costo, 0.01);
    }

    @Test
    void aplicaDescuentoClientePremium() {
        double costo = servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "PREMIUM", false);
        assertEquals(45.0, costo, 0.01);
    }

    // Antes sin cubrir: la selección de EXPRESS, OVERNIGHT e INTERNACIONAL (líneas 19, 31 y 42 del original).
    @ParameterizedTest
    @CsvSource({
        "EXPRESS,       156.0",
        "OVERNIGHT,     220.0",
        "INTERNACIONAL, 230.0"
    })
    void delegaEnLaFormulaDeCadaMetodoDeEnvio(String metodo, double esperado) {
        assertEquals(esperado, servicio.calcularCosto(metodo, 3.0, 100.0, "REGULAR", false), 0.01);
    }

    // Antes sin cubrir: esFragil == true (línea 58 del original).
    @Test
    void aplicaRecargoDel15PorCientoSiEsFragil() {
        assertEquals(57.5, servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "REGULAR", true), 0.01);
    }

    // Antes sin cubrir: descuento CORPORATIVO (línea 64 del original).
    @Test
    void aplicaDescuentoClienteCorporativo() {
        assertEquals(42.5, servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "CORPORATIVO", false), 0.01);
    }

    // El recargo por fragilidad se aplica antes del descuento: 50 * 1.15 * 0.9.
    @Test
    void combinaFragilidadYDescuentoEnOrden() {
        assertEquals(51.75, servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "PREMIUM", true), 0.01);
    }

    // Antes sin cubrir: el else de método no soportado (línea 54 del original).
    @Test
    void rechazaMetodoDeEnvioNoSoportado() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class,
            () -> servicio.calcularCosto("AEREO", 3.0, 100.0, "REGULAR", false));
        assertEquals("Metodo de envio no soportado: AEREO", error.getMessage());
    }

    // La excepción de OVERNIGHT debe seguir llegando al cliente del servicio tras el refactor.
    @Test
    void propagaElRechazoDeOvernightPorDistancia() {
        assertThrows(IllegalArgumentException.class,
            () -> servicio.calcularCosto("OVERNIGHT", 3.0, 301.0, "REGULAR", false));
    }
}
