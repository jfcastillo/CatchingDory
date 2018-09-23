package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Jugador;

public class VentanaPuntajes extends JFrame {
	public static String[] TITULOS = {"Nickname", "Puntaje", "Nivel"};

	private JTable tabla;
	private JLabel lblMensaje;
	
	private Principal laPrin;
	private PanelOrdenamiento pOrden;	

	public VentanaPuntajes(Principal p) {
		super("Puntajes");
		setLayout(new BorderLayout());
		setResizable(true);
		setVisible(false);
		setSize(500, 400);
		laPrin = p;
		pOrden = new PanelOrdenamiento(this);
		lblMensaje = new JLabel("*NOTA*: Para ver los puntajes actualizados dar doble click sobre el boton");
		add(lblMensaje, BorderLayout.NORTH);
		add(pOrden, BorderLayout.SOUTH);		
	}
	public Principal darPrincipal() {
		return laPrin;
	}
	
	public void mostrarPuntajes(ArrayList<Jugador> jugadores) {
		
		String [][] datos = new String [jugadores.size()][3];
//		  DefaultTableModel dtm= new DefaultTableModel(datos, TITULOS);
		
		for (int i = 0; i < jugadores.size(); i++) {
			datos[i][0] = jugadores.get(i).getNickname();
			datos[i][1] = jugadores.get(i).getPuntaje()+"";
			datos[i][2] = jugadores.get(i).getNivel()+"";					
		}
		tabla = new JTable(datos, TITULOS);
		JScrollPane scroll = new JScrollPane(tabla);
		add(scroll, BorderLayout.CENTER);
		
	}
//	public void limpiarTabla() {
//		for (int i = 0; i < tabla.getRowCount(); i++) {
//			tabla.removeR
//		}
//	}
	

}
