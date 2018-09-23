/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package modelo;

import java.io.Serializable;
import java.util.Comparator;



public class Jugador implements Serializable,Comparable<Jugador>, Comparator<Jugador>{
	/**
	 * Nombre del jugador que ha jugado
	 */
	private String nickname;
	/**
	 * Puntaje que ha logrado
	 */
	private int puntaje;
	/**
	 * Nivel en el que el jugador se encuentra
	 */
	private int nivel;
	

	public Jugador(String nickname) {
		this.nickname = nickname;
		puntaje = 0;
		nivel = 1;
		
	}
	public Jugador(String nickname, int puntaje, int nivel) {
		this.nickname = nickname;
		this.puntaje = puntaje;
		this.nivel = nivel;
		
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getPuntaje() {
		return puntaje;
	}


	public void setPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}
	public void disminuirPuntaje(int puntaje) {
		this.puntaje -= puntaje;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int aumentarNivel() {
//		if (puntaje<30) {
//			nivel = 1; 
//		}
		
		if (puntaje == 30) {
			nivel = 2;
		}
		else if (puntaje == 60) {
			nivel = 3;
		}
		return nivel;
	}


	@Override
	public int compareTo(Jugador arg0) {
		
		return nickname.compareTo(arg0.getNickname());
	}


	@Override
	public int compare(Jugador o1, Jugador o2) {		
		return o1.getPuntaje() - o2.puntaje;
	}
	
	
	

}
