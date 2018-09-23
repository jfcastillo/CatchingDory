/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelJuego extends JPanel implements ActionListener, MouseListener{
	
	private Principal laPrincipal;	
	
	private int indice;
	private int velocidadPez;
	private Timer temporizador;

	public PanelJuego(Principal p) {
		indice = 0;
		setPreferredSize(new Dimension(700, 600));
		laPrincipal = p;		
		addMouseListener(this);
	}
	

	@Override
	public void paint(Graphics g) {
		Dimension d = getSize();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 700, 200);
		ImageIcon imagen1 = new ImageIcon("img/fondo1 - copia.jpg");
		g.drawImage(imagen1.getImage(), 0, 0,d.width, 200,null);
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 200, 700, 400);
		ImageIcon imagen2 = new ImageIcon("img/mar.gif");
		
		g.drawImage(imagen2.getImage(), 0, 200,d.width, d.height,null);
		
		for (int i = 0; i < laPrincipal.darJuego().darPescado().size(); i++) {
			ImageIcon imagen3 = new ImageIcon(laPrincipal.darJuego().darPescado().get(i).darRutaImange());
			
			
			g.drawImage(imagen3.getImage(), laPrincipal.darJuego().darPescado().get(i).darPosicionX(), laPrincipal.darJuego().darPescado().get(i).darPosicionY(),null);
			
			indice = i;
//			laPrincipal.ejecturHiloMover(i);
			laPrincipal.moverPez(indice);
			
			
		}
	}
//	public void velocidad(int vel) {
//		temporizador = new Timer(vel, this);	
//		temporizador.start();	
//	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if (!laPrincipal.verificarErrores()) {
////			laPrincipal.aumentarVelocidad();
//			repaint();
//		}
//		else {
//			laPrincipal.mostrarDerrota();
//		}
		repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {}

	//Metodos sin usar
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		laPrincipal.capturarPez(e.getX(), e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
}


