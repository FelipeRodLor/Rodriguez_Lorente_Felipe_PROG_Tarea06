/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

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
        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        setCilindrada(cilindrada);
        disponible = true;
    }

    public void setMatricula(String matricula) {
        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("La matricula introducida no es correcta");
        }
    }

    private boolean compruebaMatricula(String matricula) {
        Pattern patron = Pattern.compile("([0-9]{4})([a-zA-Z]{3})");
        Matcher emparejador = patron.matcher(matricula);

        return emparejador.matches();

    }

    private void setMarca(String marca) {
        if (marca != null && !marca.equals("")) {
            this.marca = marca;
        } else {
            throw new ExcepcionAlquilerVehiculos("La marca de turismo introducida no es correcta");
        }
    }

    private void setModelo(String modelo) {
        if (marca != null && !marca.equals("")) {
            this.modelo = modelo;
        } else {
            throw new ExcepcionAlquilerVehiculos("El modelo de turismo introducido no es correcto");
        }
    }

    private void setCilindrada(int cilindrada) {
        if (marca != null && !marca.equals("")&& cilindrada>0 ) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("La cilindrada del turismo introducida no es correcta");
        }
    }

    public Turismo(Turismo turismo) {
        matricula = turismo.getMatricula();
        marca = turismo.getMarca();
        modelo = turismo.getModelo();
        cilindrada = turismo.getCilindrada();
        this.disponible = turismo.disponible;

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