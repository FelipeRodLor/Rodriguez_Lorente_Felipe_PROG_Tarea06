/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tarea05.ExcepcionAlquilerVehiculos;

/**
 *
 * @author Felipillo
 */
public class Turismo {

    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;

    public Turismo(String matricula, String marca, String modelo, int cilindrada) {

        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("La matricula introducida no es correcta");
        }
        this.marca = marca;
        this.modelo = modelo;
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("La cilindrada introducida no es correcta");
        }
        disponible = true;
    }

    public Turismo(Turismo turismo) {
        this.matricula = turismo.matricula;
        this.marca = turismo.marca;
        this.modelo = turismo.modelo;
        this.cilindrada = turismo.cilindrada;
        this.disponible = turismo.disponible;

    }

    private boolean compruebaMatricula(String matricula) {
        Pattern patron = Pattern.compile("([0-9]{4})([a-zA-Z]{3})");
        Matcher emparejador = patron.matcher(matricula);

        return emparejador.matches();

    }

    public String getMatricula() {
        return matricula;

    }

    public String getMarca() {
        return marca;

    }

    public String getModelo() {
        return modelo;

    }

    public int getCilindrada() {
        return cilindrada;

    }

    public boolean getDisponible() {
        return disponible;

    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String toString() {
        return (" MATRICULA; " + matricula + " MARCA; " + marca + " MODELO; " + modelo + " CILINDRADA; " + cilindrada + " DISPONIBLE; " + disponible);
    }
}
