/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package vista;


import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel{
	private Principal laPrincipal;
	private GridLayout grid;
	private JLabel lblJugador;
	private JLabel lblPuntos;
	private JLabel lblNivel;

	public PanelDatos() {
		
		grid = new GridLayout(1, 3);		
		setLayout(grid);
		TitledBorder tBorder = new TitledBorder("Datos");
		setBorder(tBorder);	
		
		lblJugador = new JLabel("Jugador: ");
		lblPuntos = new JLabel("Puntos: 0");
		lblNivel = new JLabel("Nivel: 0");
		add(lblJugador);
		add(lblPuntos);
		add(lblNivel);
			
	}
	public void cambiarPuntaje(int puntaje) {
		lblPuntos.setText("Puntaje: "+puntaje);
	}
	public void cambiarNombre(String nombre) {
		lblJugador.setText("Nombre: "+nombre);
	}
	public void cambiarNivel(int nivel) {
		lblNivel.setText("Nivel: "+nivel);
	}
}
