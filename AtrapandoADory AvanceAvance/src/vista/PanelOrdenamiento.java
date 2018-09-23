package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOrdenamiento extends JPanel implements ActionListener{
	public static final String PUNTAJE = "punt";
	public static final String NOMBRE = "nom";	
	
	private JButton btnPuntaje;
	private JButton btnNombre;
	
	private VentanaPuntajes vPuntajes;
	
	public PanelOrdenamiento(VentanaPuntajes vPunt) {
		setLayout(new GridLayout(1,2));
		TitledBorder tBorder = new TitledBorder("Ordenar por");
		setBorder(tBorder);	
		
		vPuntajes = vPunt;
		
		btnPuntaje = new JButton("Puntaje");
		btnNombre = new JButton("Nombre");
		
		btnPuntaje.setActionCommand(PUNTAJE);
		btnNombre.setActionCommand(NOMBRE);
		
		btnPuntaje.addActionListener(this);
		btnNombre.addActionListener(this);
		
		add(btnPuntaje);
		add(btnNombre);
	}
		
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(PUNTAJE)) {
			vPuntajes.darPrincipal().verPuntajesPorPuntaje();
			System.out.println("punta");
		}
		else if (comando.equals(NOMBRE)) {
			vPuntajes.darPrincipal().verPuntajesPorNombre();
			System.out.println("nom");
		}
	}

}
