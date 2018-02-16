/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.dao.Alquileres;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Turismo;
import mvc.modelo.dominio.Cliente;
import utilidades.Entrada;

/**
 *
 * @author Felipillo
 */
public class IUTextual {

    AlquilerVehiculos alquilerVehiculos = new AlquilerVehiculos();

    public static void main(String[] args) {
        AlquilerVehiculos alquilerVehiculos = new AlquilerVehiculos();
        IUTextual iuTextual = new IUTextual();
        int opcion;
        alquilerVehiculos.añadirDatosPrueba();
        do {
            do {

                System.out.println("----------------");
                System.out.println("1-AÑADIR CLIENTE");
                System.out.println("2-BORRAR CLIENTE");
                System.out.println("3-LISTAR CLIENTES");
                System.out.println("4-AÑADIR TURUSMO");
                System.out.println("5-BORRAR TURISMO");
                System.out.println("6-LISTAR TURISMOS");
                System.out.println("7-ABRIR ALQUILER");
                System.out.println("8-CERRAR ALQUILER");
                System.out.println("9-LISTAR ALQUILER");
                System.out.println("10-SALIR");

                opcion = Entrada.entero();

                switch (opcion) {

                    case 1:
                        anadirCliente();
                        break;

                    case 2:

                        borrarCliente();
                        break;

                    case 3:

                        listarClientes();
                        break;

                    case 4:
                        anadirTurismo();
                        break;

                    case 5:
                        borrarTurismo();
                        break;

                    case 6:

                        listarTurismos();
                        break;

                    case 7:

                        abrirAlquiler();

                        break;

                    case 8:
                        cerrarAlquiler();

                        break;

                    case 9:

                        listarAlquileres();
                        break;

                }

            } while (opcion > 10 || opcion < 0);

        } while (opcion != 10);
        System.out.println("Has abandonado satisfactoriamente");
    }

    public void listarAlquileres() {
        Consola.mostrarCabecera("LISTADO DE ALQUILERES");
        for (Alquiler listaAlquileres : alquilerVehiculos.obtenerAlquileres()) {
            if (listaAlquileres != null) {
                System.out.println(listaAlquileres);
            }
        }
    }

    public void cerrarAlquiler() {
        Alquileres alquileres = null;

        Consola.mostrarCabecera("CIERRE DE ALQUILER");
        String dniCierre = Consola.leerDni();
        String matriculaCierre = Consola.leerMatricula();

        try {
            Cliente clienteAlquiler = alquilerVehiculos.buscarCliente(dniCierre);
            Turismo turismoAlquiler = alquilerVehiculos.buscarTurismo(matriculaCierre);
            alquilerVehiculos.closeAlquiler(clienteAlquiler, turismoAlquiler);
            System.out.println("Operacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR:  %s%n%n", e.getMessage());

        }
    }

    public void abrirAlquiler() {
        Alquiler nuevoAlquiler = null;

        Consola.mostrarCabecera("APERTURA DE ALQUILER");
        String dniAlquiler = Consola.leerDni();
        String matriculaAlquiler = Consola.leerMatricula();

        try {
            Cliente clienteAlquiler = alquilerVehiculos.buscarCliente(dniAlquiler);
            Turismo turismoAlquiler = alquilerVehiculos.buscarTurismo(matriculaAlquiler);
            alquilerVehiculos.abrirAlquiler(clienteAlquiler, turismoAlquiler);

            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    public void listarTurismos() {
        Consola.mostrarCabecera("LISTADO DE TURISMOS");
        for (Turismo listaTurismos : alquilerVehiculos.obtenerTurismo()) {
            if (listaTurismos != null) {
                System.out.println(listaTurismos);
            }
        }
    }

    public void borrarTurismo() {
        Consola.mostrarCabecera("BORRAR TURISMO");
        String matriculaBorrar = Consola.leerMatricula();
        try {
            alquilerVehiculos.borrarTurismo(matriculaBorrar);
            System.out.println("Operacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    public void anadirTurismo() {
        Consola.mostrarCabecera("ALTA TURISMO");
        if (Consola.leerTurismo() != null) {
            try {
                alquilerVehiculos.añadirTurismo(Consola.leerTurismo());
                System.out.println("\nOperacion realizada");
            } catch (ExcepcionAlquilerVehiculos i) {
                System.out.printf("\nERROR: %s%n%n", i.getMessage());
            }
        }
    }

    public void listarClientes() {
        Consola.mostrarCabecera("LISTADO DE CLIENTES");
        for (Cliente listaCliente : alquilerVehiculos.obtenerClientes()) {
            if (listaCliente != null) {
                System.out.println(listaCliente);
            }
        }
    }

    public void borrarCliente() {
        Consola.mostrarCabecera("BORRAR CLIENTE");
        String dniBorrar = Consola.leerDni();
        try {

            alquilerVehiculos.borrarCliente(dniBorrar);
            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());

        }
    }

    public void anadirCliente() {

        Consola.mostrarCabecera("ALTA CLIENTE");
        if (Consola.leerCliente() != null) {
            try {
                alquilerVehiculos.añadirCliente(Consola.leerCliente());
                System.out.println("\nOperacion realizada");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("\nERROR: %s%n%n", e.getMessage());
            }
        }
    }

}
