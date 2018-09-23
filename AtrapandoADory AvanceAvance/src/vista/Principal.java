/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hilos.HiloCrearPersonaje;
import hilos.HiloMoverPez;
import modelo.Juego;
import modelo.Jugador;

public class Principal extends JFrame{
	private Juego elJuego;
	private PanelJuego pJuego;
	private PanelDatos pDatos;
	private PanelOpciones pOpciones;
	private VentanaPuntajes vPuntajes;
	private HiloCrearPersonaje hiloCrear;
	private HiloMoverPez hiloMover;
	

	public Principal() {
		BorderLayout border = new BorderLayout();
		setLayout(border);
		setVisible(true);
		
		//Pide el nombre del jugador 
		String nombre = JOptionPane.showInputDialog(null, "Por favor ingrese su nickname");
		
		//Inicializacion de clases relacionadas
		try {
			elJuego = new Juego(nombre);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		pJuego = new PanelJuego(this);
		pDatos = new PanelDatos();
		pOpciones = new PanelOpciones(this);
		vPuntajes = new VentanaPuntajes(this); 	
		//Creacion de hilos
		hiloCrear = new HiloCrearPersonaje(elJuego);
		hiloMover = new HiloMoverPez(this, 0, 10);
		add(pJuego, BorderLayout.NORTH);
		add(pDatos, BorderLayout.CENTER);
		add(pOpciones, BorderLayout.SOUTH);
		pack();
	}
	
	public void iniciarJuego() {
		//Inicia los campos de datos
		pDatos.cambiarNombre(elJuego.darActualPlayer().getNickname());
		pDatos.cambiarPuntaje(elJuego.darActualPlayer().getPuntaje());
		pDatos.cambiarNivel(elJuego.darActualPlayer().getNivel());
		//Se empiezan a crear los peces
		hiloCrear.start();
		hiloMover.start();
//		pJuego.velocidad(10);
	}
	
	public Juego darJuego() {
		return elJuego;
	}
	public PanelJuego darPanelJuego() {
		return pJuego;
	}
	public void moverPez(int i) {
		elJuego.moverPersonaje(i);
	}
	public void pintarPanelJuego() {
		pJuego.repaint();
	}
	
//	public void iniciarCrearPersonajes() {
//		hiloCrear.start();
//	}
	public void capturarPez(int x, int y) {
		elJuego.capturarPez(x,y);
		pDatos.cambiarPuntaje(elJuego.darActualPlayer().getPuntaje());
		aumentarVelocidad();
	}
	public void aumentarVelocidad() {
		int nivel = elJuego.aumentarNivel();
		if (nivel == 1) {
//			pJuego.velocidad(10);
			hiloMover.modificarVelocidad(8);
			hiloCrear.modificarVelocidad(600);
		}
		else if (nivel == 2) {
//			pJuego.velocidad(1);
			hiloMover.modificarVelocidad(5);
			hiloCrear.modificarVelocidad(400);
		}
		else if (nivel == 3) {
//			pJuego.velocidad(-2);
			hiloMover.modificarVelocidad(2);
			hiloCrear.modificarVelocidad(200);
		}
		pDatos.cambiarNivel(nivel);
		
	}
//	public void mostrarDerrota() {
//		JOptionPane.showConfirmDialog(null, "¡Has perdido!");
//		iniciarJuego();
//	}
//	public boolean verificarErrores() {
//		
//		return elJuego.darErrores()>=3 ? true : false;
//	}
	public void guardarJuego() {
		elJuego.guardar();
	}
	public void verPuntajesPorNombre() {

		ArrayList<Jugador> ordenados = elJuego.ordernarPorNombreInsercion();
		String listaJugadores = "";

		for (int i = 0; i < ordenados.size(); i++) {
			String nickname = ordenados.get(i).getNickname();
			int puntaje = ordenados.get(i).getPuntaje();
			int nivel = ordenados.get(i).getNivel();
			listaJugadores += ("Nickname: "+nickname+" Puntaje: "+puntaje+" Nivel: "+nivel+"\n");
		}

//		System.out.println(listaJugadores);
//		JOptionPane.showMessageDialog(null, listaJugadores);
//		vPuntajes.removeAll();
//		vPuntajes = new VentanaPuntajes(this);
		vPuntajes.setVisible(true);
		vPuntajes.mostrarPuntajes(ordenados);
		
	}
	public void verPuntajesPorPuntaje() {

		ArrayList<Jugador> ordenados = elJuego.ordernarPorPuntajeInsercion();
		String listaJugadores = "";

		for (int i = 0; i < ordenados.size(); i++) {
			String nickname = ordenados.get(i).getNickname();
			int puntaje = ordenados.get(i).getPuntaje();
			int nivel = ordenados.get(i).getNivel();
			listaJugadores += ("Nickname: "+nickname+" Puntaje: "+puntaje+" Nivel: "+nivel+"\n");
		}

		System.out.println(listaJugadores);
//		JOptionPane.showMessageDialog(null, listaJugadores);
//		vPuntajes.removeAll();
//		vPuntajes = new VentanaPuntajes(this);
		vPuntajes.setVisible(true);
		vPuntajes.mostrarPuntajes(ordenados);
		
		
	}

	public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
