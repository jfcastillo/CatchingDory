/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package modelo;

import java.io.*;
import java.util.ArrayList;

public class Juego {
	private ArrayList<Personaje> pescado;
	private ArrayList<Jugador> player;
	private int errores;
	private Jugador actualPlayer;
	private File baseDeDatos;

	public Juego(String nickname) throws NombreIncorrectoException {
		errores = 0;
		player = new ArrayList<Jugador>();
		pescado = new ArrayList<Personaje>();
		if (nickname.length()<1) {
			throw new NombreIncorrectoException("El nombre debe tener mas de un caracter", nickname);
		}
		else {
			actualPlayer = new Jugador(nickname);
		}
		
		
	}
	public Juego() {
		player = new ArrayList<Jugador>();
		pescado = new ArrayList<Personaje>();
		actualPlayer = new Jugador("a");
		
	}
	

	public void agregarJugador(String nickname, int puntaje, int nivel) {
		player.add(new Jugador(nickname, puntaje, nivel));
	}
	public Jugador darActualPlayer() {
		return actualPlayer;
	}
	public ArrayList<Personaje> darPescado() {
		return pescado;
	}
	public ArrayList<Jugador> darPlayer() {
		return player;
	}
	public int darErrores() {
		return errores;
	}

	public void crearPescadoAleatorio() {
		int rangoY = (Personaje.MAXIMO_Y - Personaje.MINIMO_Y)+1;
		int posX = 0;
		int posY = (int) (Math.random()*rangoY)+Personaje.MINIMO_Y;
		int nRuta = (int) (Math.random()*5)+1;
		
		pescado.add(new Personaje("img/"+nRuta+".png", posX, posY));
		
	}
	
	public void moverPersonaje(int i) {
		if ((darPescado().get(i).esDory()) && (darPescado().get(i).darPosicionX()==700)) {
			errores++;
		}
		if (darPescado().get(i).darPosicionX()<=700) {
			darPescado().get(i).mover();
		} else {
			darPescado().remove(i);

		}	
		
	}
	
	public void capturarPez(int x, int y) {
		int indice = -1;
		indice = buscarPez(x,y);
		if (indice > -1) {
			if (darPescado().get(indice).esDory()) {
				darPescado().remove(indice);
				actualPlayer.setPuntaje(10);
			}
			else {
				actualPlayer.disminuirPuntaje(10);
			}
			
		}
		
		
	}
	
	public int buscarPez(int x,int y) {
		int indice = -1;
		
		boolean salida = false;	
		
		for (int i = 0; i < darPescado().size() && !salida; i++) {
			for (int j = 0; j < darPescado().get(i).darPosicionesXDisponibles().length && !salida; j++) {
				if (x == darPescado().get(i).darPosicionesXDisponibles()[j]) {
					for (int k = 0; k < darPescado().get(i).darPosicionesYDisponibles().length && !salida; k++) {
						
						if (y == darPescado().get(i).darPosicionesYDisponibles()[k]) {
							indice = i;
							salida = true;
						}
					}
				}
				
			}
			
		}
		return indice;
	}
	
	public int aumentarNivel() {
		return actualPlayer.aumentarNivel();
	}

	
	public void guardar() {
		System.out.println("guardar");
//		File archivo = new File("baseDeDatos.dat");
		player = cargarDatosJugador();
		player.add(actualPlayer);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/baseDeDatos.dat"));
			oos.writeObject(player);
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public ArrayList<Jugador> cargarDatosJugador() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/baseDeDatos.dat"));
			player = (ArrayList<Jugador>)ois.readObject();
//			actualPlayer = (Jugador)ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		String listaJugadores = "";
		for (int i = 0; i < player.size(); i++) {
			String nickname = player.get(i).getNickname();
			int puntaje = player.get(i).getPuntaje();
			int nivel = player.get(i).getNivel();
			listaJugadores += ("Nickname: "+nickname+" Puntaje: "+puntaje+" Nivel: "+nivel+"\n");
//			System.out.println(player.size());
//			System.out.println(listaJugadores);
		}
		return player;
	}
	
	public ArrayList<Jugador> ordernarPorNombreInsercion() {
		ArrayList<Jugador> jugadores = cargarDatosJugador();
		for (int i = 1; i < jugadores.size(); i++) {
			for (int j = i; j > 0 && (jugadores.get(j-1).compareTo(jugadores.get(j)))>=1; j--) {
				Jugador temp = jugadores.get(j);
				
				jugadores.set(j, jugadores.get(j-1));
				jugadores.set(j-1, temp);
			}
		}
		return jugadores;
	}
	
	public ArrayList<Jugador> ordernarPorPuntajeInsercion() {
		ArrayList<Jugador> jugadores = cargarDatosJugador();
		for (int i = 1; i < jugadores.size(); i++) {
			for (int j = i; j > 0 && (jugadores.get(j-1).compare(jugadores.get(j),jugadores.get(j-1)))>=1; j--) {
				Jugador temp = jugadores.get(j);
				
				jugadores.set(j, jugadores.get(j-1));
				jugadores.set(j-1, temp);
			}
		}
		return jugadores;
	}
	
//	public int compararPorNombres(Jugador jg1, Jugador jg2) {
//		return jg1.getNickname().compareToIgnoreCase(jg1.getNickname());
//	}

}
