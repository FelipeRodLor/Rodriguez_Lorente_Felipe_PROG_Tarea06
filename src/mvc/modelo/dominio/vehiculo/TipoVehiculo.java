/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio.vehiculo;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author Felipon
 */
public enum TipoVehiculo {
    TURISMO("TURISMO") {
        public Turismo getInstancia(Vehiculo vehiculo) {
            return new Turismo(vehiculo);
        }
    },
    DE_CARGA("DE CARGA") {
        public DeCarga getInstancia(Vehiculo vehiculo) {
            return new DeCarga(vehiculo);
        }

    },
    AUTOBUS("AUTOBUS") {
        public Autobus getInstancia(Vehiculo vehiculo) {
            return new Autobus(vehiculo);
        }

    };

    private String tipo;

    public abstract Vehiculo getInstancia(Vehiculo vehiculo);

    private TipoVehiculo(String tipoVehiculo) {
        this.tipo = tipoVehiculo;
    }

    public String toString() {
        return tipo;
    }

    public static TipoVehiculo getTipoVehiculoSegunOridnal(int ordinal) {
        if (esOrdinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
        }

    }

    public static boolean esOrdinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1);
    }

}
