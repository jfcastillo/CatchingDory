/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package hilos;

import modelo.Juego;

public class HiloCrearPersonaje extends Thread {
	public static int VELOCIDAD_INICIAL = 800;
	private int velocidadCrear;
	private Juego elJuego;

	public HiloCrearPersonaje(Juego jg) {
		velocidadCrear = VELOCIDAD_INICIAL;
		elJuego = jg;
	}

	@Override
	public void run() {
		boolean condicion = true;
		while(condicion) {
			try {
				elJuego.crearPescadoAleatorio();

				Thread.sleep(velocidadCrear);
			} catch (Exception e) {

			}
		}
	}
	public void modificarVelocidad(int velocidad) {
		velocidadCrear = velocidad;
	}

}
