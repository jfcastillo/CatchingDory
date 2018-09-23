package hilos;

import vista.Principal;

public class HiloMoverPez extends Thread {
	private int velocidad;
	private int indice;
	private Principal laPrincipal;
	public HiloMoverPez(Principal p, int indice,int velocidad) {
	    this.indice = indice;
	    this.velocidad = velocidad;
		laPrincipal = p;
	}
	public void run() {
		boolean condicion = true;
		while(condicion) {
			try {
//				laPrincipal.moverPez(indice);
//				laPrincipal.darPanelJuego().repaint();
				laPrincipal.pintarPanelJuego();
//				System.out.println("si");
				Thread.sleep(velocidad);
			} catch (Exception e) {

			}
		}
	}
	public void modificarIndice(int i) {
		indice = i;
	}
	public void modificarVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}
