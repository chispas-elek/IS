package packGraphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import packComponentes.Artista;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VArtista extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField tNombre;
	private JLabel lblTipo;
	private JTextField tTipo;
	private JPanel panel;
	private Artista ar = new Artista(null, null);
	private JPanel pBotones;
	private JButton bAceptar;
	private boolean listo = false;

	/**
	 * Create the frame.
	 */
	public VArtista() {
		initialize();
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ar.setNombre(tNombre.getText());
				ar.setTipo(tTipo.getText());
				setVisible(false);
				listo = true;
			}
		});
	}
	private void initialize() {
		setTitle("Añadir un artista nuevo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPBotones(), BorderLayout.SOUTH);
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
		}
		return lblNombre;
	}
	private JTextField getTNombre() {
		if (tNombre == null) {
			tNombre = new JTextField();
			tNombre.setColumns(10);
		}
		return tNombre;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo");
		}
		return lblTipo;
	}
	private JTextField getTTipo() {
		if (tTipo == null) {
			tTipo = new JTextField();
			tTipo.setColumns(10);
		}
		return tTipo;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getLblNombre());
			panel.add(getTNombre());
			panel.add(getLblTipo());
			panel.add(getTTipo());
		}
		return panel;
	}
	private JPanel getPBotones() {
		if (pBotones == null) {
			pBotones = new JPanel();
			pBotones.add(getBAceptar());
		}
		return pBotones;
	}
	private JButton getBAceptar() {
		if (bAceptar == null) {
			bAceptar = new JButton("Aceptar");
			
		}
		return bAceptar;
	}
	
	public Artista getArtista() {
		return ar;
	}
	
	public boolean getListo() {
		return this.listo;
	}
}
