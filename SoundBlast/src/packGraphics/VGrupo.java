package packGraphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import packComponentes.Artista;
import packComponentes.Disco;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class VGrupo extends JFrame {

	private JPanel contentPane;
	private JPanel pContenido;
	private JLabel lblNombre;
	private JTextField tNombre;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JList artistas;
	private JList aantiguos;
	private JList discografia;
	private JPanel pBotones;
	private JButton bEdit;
	private JButton bAceptar;
	private JTextField tLogo;
	private ListaArtista a = new ListaArtista();
	private ListaArtista aa = new ListaArtista();
	private ListaDisco d = new ListaDisco();
	private packComponentes.Grupo gr;
	private DefaultListModel<String> listModelA, listModelAA, listModelD;

	/**
	 * Create the frame.
	 */
	public VGrupo() {
		setTitle("Añadir un grupo nuevo");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		initialize();
		
		//Listener editar
		bEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tNombre.setEnabled(true);
				tLogo.setEnabled(true);
				artistas.setEnabled(true);
				aantiguos.setEnabled(true);
				discografia.setEnabled(true);
				bAceptar.setEnabled(true);
			}
		});
		
		//Listener aceptar
		bAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(tNombre.getText() != "") || !(tLogo.getText() != "") || artistas.getModel().getSize() == 0) {
				} else {
					
					Artista ar = null;
					Disco di = null;
					/*TODO rellenar las listas*/
					packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo(tNombre.getText(), tLogo.getText(), a, aa, d);
					gr = new packComponentes.Grupo(tNombre.getText(), tLogo.getText(), a, aa, d);
					setVisible(false);
				}
			}
		});
		
		//Listener lista artistas
		artistas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(artistas.isEnabled()) {
					VArtista arv = new VArtista();
					arv.setVisible(true);
					/*TODO Manejar este evento dependiendo del otro: Cuando el artista este listo*/
					Artista ar = arv.getArtista();
					arv.dispose();
					gr.anadirIntegrante(ar);
					listModelA.addElement(ar.getNombre());
				}
			}
		});
		
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPContenido(), BorderLayout.CENTER);
		contentPane.add(getPBotones(), BorderLayout.SOUTH);
	}

	private JPanel getPContenido() {
		if (pContenido == null) {
			pContenido = new JPanel();
			pContenido.setLayout(new GridLayout(0, 2, 0, 0));
			pContenido.add(getLblNombre());
			pContenido.add(getTNombre());
			pContenido.add(getLblLogo());
			pContenido.add(getTLogo());
			pContenido.add(getLblNewLabel());
			pContenido.add(getArtistas());
			pContenido.add(getLblNewLabel_1());
			pContenido.add(getAantiguos());
			pContenido.add(getLblNewLabel_2());
			pContenido.add(getDiscografia());
		}
		return pContenido;
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
			tNombre.setEnabled(false);
			tNombre.setColumns(10);
		}
		return tNombre;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("Logo");
		}
		return lblLogo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Artistas");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Artistas Antiguos");
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Discografia");
		}
		return lblNewLabel_2;
	}
	private JList getArtistas() {
		if (artistas == null) {
			listModelA = new DefaultListModel();
			artistas = new JList(listModelA);
			artistas.setEnabled(false);
			artistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			artistas.setToolTipText("Presione la lista para agregar");
			artistas.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return artistas;
	}
	private JList getAantiguos() {
		if (aantiguos == null) {
			listModelAA = new DefaultListModel();
			aantiguos = new JList(listModelAA);
			aantiguos.setEnabled(false);
			aantiguos.setToolTipText("Presione la lista para agregar");
			aantiguos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			aantiguos.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return aantiguos;
	}
	private JList getDiscografia() {
		if (discografia == null) {
			listModelD = new DefaultListModel();
			discografia = new JList(listModelD);
			discografia.setEnabled(false);
			discografia.setToolTipText("Presione la lista para agregar");
			discografia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			discografia.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return discografia;
	}
	private JPanel getPBotones() {
		if (pBotones == null) {
			pBotones = new JPanel();
			pBotones.add(getBEdit());
			pBotones.add(getBAceptar());
		}
		return pBotones;
	}
	private JButton getBEdit() {
		if (bEdit == null) {
			bEdit = new JButton("Editar");
		}
		return bEdit;
	}
	private JButton getBAceptar() {
		if (bAceptar == null) {
			bAceptar = new JButton("Aceptar");
			bAceptar.setEnabled(false);
			
		}
		return bAceptar;
	}
	private JTextField getTLogo() {
		if (tLogo == null) {
			tLogo = new JTextField();
			tLogo.setEnabled(false);
			tLogo.setColumns(10);
		}
		return tLogo;
	}
	
	public String getPGrupo() {
		return this.gr.getNombre();
	}
}
