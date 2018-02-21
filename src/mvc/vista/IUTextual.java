/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import mvc.controlador.ControladorAlquilerVehiculos;
import utilidades.Consola;
import mvc.modelo.dao.Alquileres;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Turismo;
import mvc.modelo.dominio.Cliente;

/**
 *
 * @author Felipillo
 */
public class IUTextual {

    ControladorAlquilerVehiculos controlador;

    public IUTextual() {
        Opcion.setVista(this);
    }

    public void setControlador(ControladorAlquilerVehiculos controlador) {
        this.controlador = controlador;
    }

    public void comenzar() {
        
        int ordinalOpcion;
        do {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
    }

    public void salir() {
        System.out.println("HAS ABANDONADO SATISFACTORIAMENTE");
    }

    public void listarAlquileres() {
        Consola.mostrarCabecera("LISTADO DE ALQUILERES");
        for (Alquiler listaAlquileres : controlador.obtenerAlquileres()) {
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
            Cliente clienteAlquiler = controlador.buscarCliente(dniCierre);
            Turismo turismoAlquiler = controlador.buscarTurismo(matriculaCierre);
            controlador.cerrarAlquiler(clienteAlquiler, turismoAlquiler);
            System.out.println("\nOperacion realizada");
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
            Cliente clienteAlquiler = controlador.buscarCliente(dniAlquiler);
            Turismo turismoAlquiler = controlador.buscarTurismo(matriculaAlquiler);
            controlador.abrirAlquiler(clienteAlquiler, turismoAlquiler);
            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    public void listarTurismos() {
        Consola.mostrarCabecera("LISTADO DE TURISMOS");
        for (Turismo listaTurismos : controlador.obtenerTurismos()) {
            if (listaTurismos != null) {
                System.out.println(listaTurismos);
            }
        }
    }

    public void borrarTurismo() {
        Consola.mostrarCabecera("BORRAR TURISMO");
        String matriculaBorrar = Consola.leerMatricula();
        try {
            controlador.borrarTurismo(matriculaBorrar);
            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    public void anadirTurismo() {
        Consola.mostrarCabecera("ALTA TURISMO");
        if (Consola.leerTurismo() != null) {
            try {
                controlador.anadirTurismo(Consola.leerTurismo());
                System.out.println("\nOperacion realizada");
            } catch (ExcepcionAlquilerVehiculos i) {
                System.out.printf("\nERROR: %s%n%n", i.getMessage());
            }
        }
    }

    public void listarClientes() {
        Consola.mostrarCabecera("LISTADO DE CLIENTES");
        for (Cliente listaCliente : controlador.obtenerClientes()) {
            if (listaCliente != null) {
                System.out.println(listaCliente);
            }
        }
    }

    public void borrarCliente() {
        Consola.mostrarCabecera("BORRAR CLIENTE");
        String dniBorrar = Consola.leerDni();
        try {

            controlador.borrarCliente(dniBorrar);
            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());

        }
    }

    public void anadirCliente() {
         
        Consola.mostrarCabecera("ALTA CLIENTE");
        Cliente cliente = Consola.leerCliente();
        
        if (cliente != null) {
            try {
                controlador.anadirCliente(cliente);
                System.out.println("\nOperacion realizada");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("\nERROR: %s%n%n", e.getMessage());
            }
        }
    }

}
