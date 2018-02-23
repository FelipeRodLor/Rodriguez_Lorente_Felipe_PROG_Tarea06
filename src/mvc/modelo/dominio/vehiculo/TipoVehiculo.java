/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio.vehiculo;

/**
 *
 * @author Felipon
 */
public enum TipoVehiculo {
    TURISMO("TURISMO") {

    },
    DE_CARGA("DE CARGA") {

    },
    AUTOBUS("AUTOBUS") {

    };

    private String tipo;

    private TipoVehiculo(String tipoVehiculo) {
        this.tipo = tipoVehiculo;
    }

    public String toString() {
        return tipo;
    }
}
