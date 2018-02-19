/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author Felipillo
 */
public enum Opcion {
    
	ANADIR_CLIENTE("AÑADIR CLIENTE") {
		public void ejecutar() {
			vista.anadirCliente();
		}
	},
	BORRAR_CLIENTE("BORRAR CLIENTE") {
		public void ejecutar() {
			vista.borrarCliente();
		}
	},
	LISTAR_CLIENTES("LISTAR CLIENTES") {
		public void ejecutar() {
			vista.listarClientes();
		}
	},
	ANADIR_TURISMO("AÑADIR TURISMO") {
		public void ejecutar() {
			vista.anadirTurismo();
		}
	},
	BORRAR_TURISMO("BORRAR TURISMO") {
		public void ejecutar() {
			vista.borrarTurismo();
		}
	},
	
	LISTAR_TURISMOS("LISTAR TURISMOS") {
		public void ejecutar() {
			vista.listarTurismos();
		}
	},
	ABRIR_ALQUILER("ABRIR ALQUILER") {
		public void ejecutar() {
			vista.abrirAlquiler();
		}
	},
	CERRAR_ALQUILER("CERRAR ALQUILER") {
		public void ejecutar() {
			vista.cerrarAlquiler();
		}
	},
	LISTAR_ALQUILERES("LISTAR ALQUILERES") {
		public void ejecutar() {
			vista.listarAlquileres();
		}
	},
        SALIR("SALIR") {
		public void ejecutar() {
			vista.salir();
		}
	};
      
	
	private String mensaje;
	private static IUTextual vista;
        private Opcion(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public abstract void ejecutar();
	
	public String getMensaje() {
		return mensaje;
	}
	
	public static void setVista(IUTextual vista) {
		Opcion.vista = vista;
	}
	
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensaje);
	}
	
	public static Opcion getOpcionSegunOridnal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
	}
	
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}
}
