/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dao;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author Felipillo
 *
 */
public class Turismos {

    private final int MAX_TURISMOS = 3;
    private Vehiculo[] turismos;

    public Turismos() {
        turismos = new Vehiculo[MAX_TURISMOS];
    }

    public Vehiculo[] getVehiculo() {

        return turismos.clone();
    }

    public void añadir(Vehiculo vehiculo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);

        if (indiceNoSuperaTamaño(indice)) {
            turismos[indice] = new Vehiculo(vehiculo) {};

        } else {
            throw new ExcepcionAlquilerVehiculos("El array de vehiculos está lleno.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
        int indice = 0;
        boolean clienteEncontrado = false;

        while (indiceNoSuperaTamaño(indice) && !clienteEncontrado) {
            if (turismos[indice] == null) {
                clienteEncontrado = true;
            } else if (turismos[indice].getMatricula().equals(vehiculo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un vehiculo con esa matricula");

            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamaño(int indice) {
        return indice < turismos.length;
    }

    public void borrar(String matricula) {
        int indice = buscarIndiceVehiculo(matricula);
        desplazarUnaPosicionHaciaIzquierda(indice);
    }

    private int buscarIndiceVehiculo(String matricula) {
        int indice = 0;
        boolean existe = false;
       
        while (indiceNoSuperaTamaño(indice) && !existe) {
            if (turismos[indice] != null && turismos[indice].getMatricula().equals(matricula)) {
                existe = true;

            } else {
                indice++;
            }
        }
        if (existe) {
            return indice;

        } else {
            throw new ExcepcionAlquilerVehiculos("El vehiculo introducido no existe");
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int posicion) {

        for (int i = posicion; i < turismos.length - 1; i++) {
            turismos[i] = turismos[i + 1];
        }
        turismos[turismos.length - 1] = null;
    }

    public Vehiculo buscar(String matricula) {

        /*

        Turismo copiaTurismo = new Turismo(turismos[buscarIndiceTurismo(matricula)]);

        return copiaTurismo;

         */
        return turismos[buscarIndiceVehiculo(matricula)];
    }
}
