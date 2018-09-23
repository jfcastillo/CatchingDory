/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package modelo;

public class Personaje {
	public static int MINIMO_X = 0;
	public static int MAXIMO_X = 700;
	public static int MINIMO_Y = 200;
	public static int MAXIMO_Y = 540;
	/**
	 * Ruta de la imagen que va a tener el personaje
	 */
	private String rutaImagen;
	/**
	 * Posicion X en donde se encuentra en personaje en el panel
	 */
	private int posicionX;
	/**
	 * Posicion Y en donde se encuentra en personaje en el panel
	 */
	private int posicionY;
	
	private int[] posicionesXDisponibles;
	private int[] posicionesYDisponibles;
	
	public Personaje(String rutaImange, int posicionX, int posicionY) {
		this.rutaImagen = rutaImange;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		
		posicionesXDisponibles = new int[60];
		posicionesYDisponibles = new int[60];
		
	}
	
	public String darRutaImange() {
		return rutaImagen;
	}

	public void modificarRutaImange(String rutaImange) {
		this.rutaImagen = rutaImange;
	}

	public int darPosicionX() {
		return posicionX;
	}

	public void modificarRutaImangePosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int darPosicionY() {
		return posicionY;
	}

	public void modificarRutaImangePosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public int[] darPosicionesXDisponibles() {
		for (int i = 0; i < posicionesXDisponibles.length; i++) {
			posicionesXDisponibles[i] = posicionX + i;
		}
		return posicionesXDisponibles;
	}
	
	public int[] darPosicionesYDisponibles() {
		for (int i = 0; i < posicionesYDisponibles.length; i++) {
			posicionesYDisponibles[i] = posicionY + i;
		}
		return posicionesYDisponibles;
	}
	
	public void mover() {
		posicionX += 1;
		
	}
	
	public boolean esDory() {
		return rutaImagen.equals("img/1.png") ? true : false;
	}

	
}
