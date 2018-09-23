/**
 * Laboratorio unidad 3
 * @author Juan Felipe Castillo Codigo: A00348879
 * @version 1.4
 *
 */
package vista;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener{
	public static final String INICIAR = "ini";
	public static final String PUNTAJE = "punt";
	public static final String GUARDAR = "save";
	private Principal laPrincipal;
	private GridLayout grid;
	private JButton btnGuardar;
	private JButton btnPuntaje;
	private JButton btnIniciar;

	public PanelOpciones(Principal prin) {
		
		laPrincipal = prin;
		grid = new GridLayout(1, 3);		
		setLayout(grid);
		TitledBorder tBorder = new TitledBorder("Opciones");
		setBorder(tBorder);		
						
		btnGuardar = new JButton("Guardar");
		btnPuntaje = new JButton("Ver puntaje");
		btnIniciar = new JButton("Iniciar");
		btnGuardar.setActionCommand(GUARDAR);
		btnPuntaje.setActionCommand(PUNTAJE);
		btnIniciar.setActionCommand(INICIAR);
		btnGuardar.addActionListener(this);
		btnPuntaje.addActionListener(this);
		btnIniciar.addActionListener(this);
		add(btnGuardar);
		add(btnPuntaje);
		add(btnIniciar);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(INICIAR)) {
			laPrincipal.iniciarJuego();
		}
		else if (comando.equals(GUARDAR)) {
			laPrincipal.guardarJuego();
		}
		else if (comando.equals(PUNTAJE)) {
//			JOptionPane.showMessageDialog(null, laPrincipal.verPuntajes());
			laPrincipal.verPuntajesPorPuntaje();
		}
		
	}


}
