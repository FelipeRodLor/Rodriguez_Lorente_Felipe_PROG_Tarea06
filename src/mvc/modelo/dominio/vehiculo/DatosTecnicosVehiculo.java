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
public class DatosTecnicosVehiculo {

    private int cilindrada;
    private int numeroPlazas;
    private int pma;

    public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicosVehiculo) {
        cilindrada = datosTecnicosVehiculo.getCilindrada();
        numeroPlazas = datosTecnicosVehiculo.getNumeroPlazas();
        pma = datosTecnicosVehiculo.getPma();

    }

    public DatosTecnicosVehiculo(int cilindrada, int numeroPlazas, int pma) {
        this.cilindrada = cilindrada;
        this.numeroPlazas = numeroPlazas;
        this.pma = pma;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;

        } else {
            throw new ExcepcionAlquilerVehiculos("La cilindrada  introducida no es correcta");
        }
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        if (numeroPlazas > 0) {
            this.numeroPlazas = numeroPlazas;

        } else {
            throw new ExcepcionAlquilerVehiculos("El numero de plazas introducido no es correcto");
        }
    }

    public int getPma() {
        return pma;
    }

    public void setPma(int pma) {
        if (pma > 0) {
            this.pma = pma;

        } else {
            throw new ExcepcionAlquilerVehiculos("El PMA introducido no es correcto");
        }

    }

    public String toString() {
        return (" CILINDRADA: " + cilindrada + " NUMERO DE PLAZAS: " + numeroPlazas + " PMA: " + pma);
    }

}