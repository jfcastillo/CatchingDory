package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Juego;

public class JuegoTest {
	private Juego elJuego;
	
	public void configurarEscenario1() {
		elJuego = new Juego();
		elJuego.agregarJugador("Felipe", 300, 3);
		elJuego.agregarJugador("Juan", 100, 3);
		elJuego.agregarJugador("Castillo", 200, 3);
		
	}

	@Test
	public void testOrdernarPorNombreInsercion() {
		configurarEscenario1() ;
		
		assertEquals("El primero deberia ser Castillo", "Castillo", elJuego.ordernarPorNombreInsercion().get(0).getNickname());
		assertEquals("El segundo deberia ser Felipe", "Felipe", elJuego.ordernarPorNombreInsercion().get(1).getNickname());
		assertEquals("El tercero deberia ser Juan", "Juan", elJuego.ordernarPorNombreInsercion().get(2).getNickname());
	}
	
	@Test
	public void testOrdernarPorPuntajeInsercion() {
		configurarEscenario1() ;
		
		assertEquals("El primero deberia ser Castillo", "Castillo", elJuego.ordernarPorPuntajeInsercion().get(0).getNickname());
		assertEquals("El segundo deberia ser Felipe", "Felipe", elJuego.ordernarPorPuntajeInsercion().get(1).getNickname());
		assertEquals("El tercero deberia ser Juan", "Juan", elJuego.ordernarPorPuntajeInsercion().get(2).getNickname());
	}
	

}
