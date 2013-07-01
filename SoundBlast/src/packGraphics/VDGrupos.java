package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import packComponentes.Artista;
import packComponentes.Grupo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VDGrupos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tNombre;
	private JTextField tLogo;
	private JList miLista, lArtistas, lDiscos, lAAntiguos;
	private JPanel pLista, pData, panel, pBotones;
	private JTextField lblNombre, lblLogo;
	private DefaultListModel lmGrupos, lmArtistas, lmDiscos, lmAAntiguos;
	private JButton btnAnadirGrupo, btnEliminarGrupo, btnEditarGrupo;
	private JButton btnActualizar;
	private JDialog vGrupo = new VGrupo();
	private JDialog vArtista = new VArtista();
	private JDialog vBuscar = new VVBuscar();
	private JButton btnBuscar;
	private JButton btnAadirArtista;
	private JButton btnBorrarArtista;
	private JButton btnReemplazarArtista;
	private JButton btnAadirDisco;
	private JButton btnBorrarDisco;
	private JButton btnGestionarDisco;
	private JDialog vaDisco = new VADisco();
	private JDialog vDisco = new VDisco();
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public VDGrupos() {
		lmGrupos = new DefaultListModel();
		lmArtistas = new DefaultListModel();
		lmDiscos = new DefaultListModel();
		lmAAntiguos = new DefaultListModel();
		initialize();
		pack();
	}
	private void initialize() {
		setTitle("SoundBlast-Grupos");
		
		vGrupo.pack();
		vArtista.pack();
		vGrupo.setVisible(false);
		vArtista.setVisible(false);
		vBuscar.pack();
		vBuscar.setVisible(false);
		
		//Es modal
		setModal(true);
		
		//Constructora
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			pLista = new JPanel();
			contentPanel.add(pLista, BorderLayout.CENTER);
			pLista.setLayout(new BorderLayout(0, 0));
			{
				panel = new JPanel();
				pLista.add(panel, BorderLayout.WEST);
				{
					
					miLista = new JList(lmGrupos);
					miLista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					miLista.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent arg0) {
							//Habilitar botones
							if(!(miLista.getSelectedValue() == null)) { 
								btnEliminarGrupo.setEnabled(true);
								btnEditarGrupo.setEnabled(true);
								Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String) miLista.getSelectedValue());
								tNombre.setText(gr.getNombre());
								tLogo.setText(gr.getLogo());
								//Rellenar las listas*/
								rellenarListas(gr);
							}
							else {
								reset();
							}
						}
					});
					
					//Vamos a rellenar la lista
					
					actualizar();
					panel.setLayout(new BorderLayout(0, 0));
					panel.add(miLista);
				}
			}
			{
				pData = new JPanel();
				pLista.add(pData, BorderLayout.CENTER);
				GridBagLayout gbl_pData = new GridBagLayout();
				gbl_pData.columnWidths = new int[]{136, 55, 35, 56, 0};
				gbl_pData.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0};
				gbl_pData.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_pData.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
				pData.setLayout(gbl_pData);
				{
					JLabel lblNombre = new JLabel("Nombre");
					GridBagConstraints gbc_lblNombre = new GridBagConstraints();
					gbc_lblNombre.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
					gbc_lblNombre.gridx = 0;
					gbc_lblNombre.gridy = 0;
					pData.add(lblNombre, gbc_lblNombre);
				}
				{
					tNombre = new JTextField();
					tNombre.setEditable(false);
					GridBagConstraints gbc_tNombre = new GridBagConstraints();
					gbc_tNombre.insets = new Insets(0, 0, 5, 5);
					gbc_tNombre.fill = GridBagConstraints.HORIZONTAL;
					gbc_tNombre.gridx = 2;
					gbc_tNombre.gridy = 0;
					pData.add(tNombre, gbc_tNombre);
					tNombre.setColumns(10);
				}
				{
					btnGestionarDisco = new JButton("Gestionar Disco");
					btnGestionarDisco.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							setVisible(false);
							((VDisco) vDisco).setLabel((String)lDiscos.getSelectedValue(), (String)miLista.getSelectedValue());
							vDisco.setVisible(true);
							setVisible(true);
						}
					});
					btnGestionarDisco.setEnabled(false);
					GridBagConstraints gbc_btnGestionarDisco = new GridBagConstraints();
					gbc_btnGestionarDisco.insets = new Insets(0, 0, 5, 0);
					gbc_btnGestionarDisco.gridx = 3;
					gbc_btnGestionarDisco.gridy = 0;
					pData.add(btnGestionarDisco, gbc_btnGestionarDisco);
				}
				{
					JLabel lblLogo = new JLabel("Logo");
					GridBagConstraints gbc_lblLogo = new GridBagConstraints();
					gbc_lblLogo.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
					gbc_lblLogo.gridx = 0;
					gbc_lblLogo.gridy = 1;
					pData.add(lblLogo, gbc_lblLogo);
				}
				{
					tLogo = new JTextField();
					tLogo.setEditable(false);
					GridBagConstraints gbc_tLogo = new GridBagConstraints();
					gbc_tLogo.insets = new Insets(0, 0, 5, 5);
					gbc_tLogo.fill = GridBagConstraints.HORIZONTAL;
					gbc_tLogo.gridx = 2;
					gbc_tLogo.gridy = 1;
					pData.add(tLogo, gbc_tLogo);
					tLogo.setColumns(10);
				}
				{
					btnBorrarDisco = new JButton("Borrar Disco");
					btnBorrarDisco.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String)miLista.getSelectedValue()).getDiscografia().elimDisco(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String)miLista.getSelectedValue()).getDiscografia().buscarDisco((String)lDiscos.getSelectedValue()));
							Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String) miLista.getSelectedValue());
							rellenarListas(gr);
						}
					});
					btnBorrarDisco.setEnabled(false);
					GridBagConstraints gbc_btnBorrarDisco = new GridBagConstraints();
					gbc_btnBorrarDisco.insets = new Insets(0, 0, 5, 0);
					gbc_btnBorrarDisco.gridx = 3;
					gbc_btnBorrarDisco.gridy = 1;
					pData.add(btnBorrarDisco, gbc_btnBorrarDisco);
				}
				{
					btnAadirDisco = new JButton("Añadir Disco");
					btnAadirDisco.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							((VADisco) vaDisco).setMiText((String)miLista.getSelectedValue());
							vaDisco.setVisible(true);
							Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String) miLista.getSelectedValue());
							rellenarListas(gr);
						}
					});
					btnAadirDisco.setEnabled(false);
					GridBagConstraints gbc_btnAadirDisco = new GridBagConstraints();
					gbc_btnAadirDisco.insets = new Insets(0, 0, 5, 0);
					gbc_btnAadirDisco.gridx = 3;
					gbc_btnAadirDisco.gridy = 2;
					pData.add(btnAadirDisco, gbc_btnAadirDisco);
				}
				{
					JLabel lblArtistas = new JLabel("Artistas");
					GridBagConstraints gbc_lblArtistas = new GridBagConstraints();
					gbc_lblArtistas.insets = new Insets(0, 0, 5, 5);
					gbc_lblArtistas.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblArtistas.gridx = 0;
					gbc_lblArtistas.gridy = 3;
					pData.add(lblArtistas, gbc_lblArtistas);
				}
				{
					lArtistas = new JList(lmArtistas);
					lArtistas.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent arg0) {
							btnReemplazarArtista.setEnabled(true);
							btnBorrarArtista.setEnabled(true);
						}
					});
					
					lArtistas.setEnabled(false);
					GridBagConstraints gbc_lArtistas = new GridBagConstraints();
					gbc_lArtistas.insets = new Insets(0, 0, 5, 5);
					gbc_lArtistas.fill = GridBagConstraints.BOTH;
					gbc_lArtistas.gridx = 2;
					gbc_lArtistas.gridy = 3;
					pData.add(lArtistas, gbc_lArtistas);
				}
				{
					btnAadirArtista = new JButton("Añadir Artista");
					btnAadirArtista.setEnabled(false);
					btnAadirArtista.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!(tNombre.getText() == null)) {
								Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String) miLista.getSelectedValue());
								((VArtista) vArtista).setMiText(gr.getNombre());
								vArtista.setVisible(true);
								rellenarListas(gr);
							}
						}
					});
					GridBagConstraints gbc_btnAadirArtista = new GridBagConstraints();
					gbc_btnAadirArtista.insets = new Insets(0, 0, 5, 0);
					gbc_btnAadirArtista.gridx = 3;
					gbc_btnAadirArtista.gridy = 3;
					pData.add(btnAadirArtista, gbc_btnAadirArtista);
				}
				{
					JLabel lblDiscografia = new JLabel("Discografia");
					GridBagConstraints gbc_lblDiscografia = new GridBagConstraints();
					gbc_lblDiscografia.anchor = GridBagConstraints.WEST;
					gbc_lblDiscografia.insets = new Insets(0, 0, 5, 5);
					gbc_lblDiscografia.gridx = 0;
					gbc_lblDiscografia.gridy = 4;
					pData.add(lblDiscografia, gbc_lblDiscografia);
				}
				{
					lDiscos = new JList(lmDiscos);
					lDiscos.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent arg0) {
							btnBorrarDisco.setEnabled(true);
							btnGestionarDisco.setEnabled(true);
						}
					});
					lDiscos.setEnabled(false);
					GridBagConstraints gbc_lDiscos = new GridBagConstraints();
					gbc_lDiscos.insets = new Insets(0, 0, 5, 5);
					gbc_lDiscos.fill = GridBagConstraints.BOTH;
					gbc_lDiscos.gridx = 2;
					gbc_lDiscos.gridy = 4;
					pData.add(lDiscos, gbc_lDiscos);
				}
				{
					btnBorrarArtista = new JButton("Borrar artista");
					btnBorrarArtista.setEnabled(false);
					btnBorrarArtista.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							lmArtistas.removeElement(lArtistas.getSelectedValue());
							packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String)miLista.getSelectedValue()).eliminarComponente(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String)miLista.getSelectedValue()).buscarComponente((String)lArtistas.getSelectedValue()));
						}
					});
					GridBagConstraints gbc_btnBorrarArtista = new GridBagConstraints();
					gbc_btnBorrarArtista.insets = new Insets(0, 0, 5, 0);
					gbc_btnBorrarArtista.gridx = 3;
					gbc_btnBorrarArtista.gridy = 4;
					pData.add(btnBorrarArtista, gbc_btnBorrarArtista);
				}
				{
					JLabel lblArtistasAntiguos = new JLabel("Artistas Antiguos");
					GridBagConstraints gbc_lblArtistasAntiguos = new GridBagConstraints();
					gbc_lblArtistasAntiguos.anchor = GridBagConstraints.WEST;
					gbc_lblArtistasAntiguos.insets = new Insets(0, 0, 0, 5);
					gbc_lblArtistasAntiguos.gridx = 0;
					gbc_lblArtistasAntiguos.gridy = 5;
					pData.add(lblArtistasAntiguos, gbc_lblArtistasAntiguos);
				}
				{
					lAAntiguos = new JList(lmAAntiguos);
					lAAntiguos.setEnabled(false);
					GridBagConstraints gbc_lAAntiguos = new GridBagConstraints();
					gbc_lAAntiguos.insets = new Insets(0, 0, 0, 5);
					gbc_lAAntiguos.fill = GridBagConstraints.BOTH;
					gbc_lAAntiguos.gridx = 2;
					gbc_lAAntiguos.gridy = 5;
					pData.add(lAAntiguos, gbc_lAAntiguos);
				}
				{
					btnReemplazarArtista = new JButton("Reemplazar Artista");
					btnReemplazarArtista.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(!(tNombre.getText() == null)) {
								Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String) miLista.getSelectedValue());
								((VArtista) vArtista).setMiText(gr.getNombre());
								((VArtista) vArtista).setMiTexto((String)lArtistas.getSelectedValue());
								((VArtista) vArtista).buttonOn();
								vArtista.setVisible(true);
								rellenarListas(gr);
							}
							
						}
					});
					btnReemplazarArtista.setEnabled(false);
					GridBagConstraints gbc_btnReemplazarArtista = new GridBagConstraints();
					gbc_btnReemplazarArtista.gridx = 3;
					gbc_btnReemplazarArtista.gridy = 5;
					pData.add(btnReemplazarArtista, gbc_btnReemplazarArtista);
				}
			}
		}
		{
			pBotones = new JPanel();
			contentPanel.add(pBotones, BorderLayout.SOUTH);
			{
				btnAnadirGrupo = new JButton("Añadir grupo");
				btnAnadirGrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vGrupo.setVisible(true);
						actualizar();
						reset();
					}
				});
				pBotones.add(btnAnadirGrupo);
			}
			{
				btnEliminarGrupo = new JButton("Eliminar grupo");
				btnEliminarGrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().eliminarGrupo((String)miLista.getSelectedValue());
						actualizar();
						reset();
						
					}
				});
				btnEliminarGrupo.setEnabled(false);
				pBotones.add(btnEliminarGrupo);
			}
			{
				btnEditarGrupo = new JButton("Editar grupo");
				btnEditarGrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tNombre.setEditable(true);
						tLogo.setEditable(true);
						btnAadirArtista.setEnabled(true);
						btnActualizar.setEnabled(true);
						btnAadirDisco.setEnabled(true);
						lArtistas.setEnabled(true);
						lAAntiguos.setEnabled(true);
						lDiscos.setEnabled(true);
					}
				});
				btnEditarGrupo.setEnabled(false);
				pBotones.add(btnEditarGrupo);
			}
			{
				btnActualizar = new JButton("Actualizar");
				btnActualizar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String nom = tNombre.getText();
						String log = tLogo.getText();
						Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String)miLista.getSelectedValue());
						gr.setNombre(nom);
						gr.setLogo(log);
						tNombre.setEditable(false);
						btnReemplazarArtista.setEnabled(false);
						tLogo.setEditable(false);
						btnActualizar.setEnabled(false);
						btnAadirArtista.setEnabled(false);
						btnBorrarArtista.setEnabled(false);
						tNombre.setText(gr.getNombre());
						tLogo.setText(gr.getLogo());
						actualizar();
						reset();
						
					}
				});
				btnActualizar.setEnabled(false);
				pBotones.add(btnActualizar);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						((VVBuscar) vBuscar).actualizar();
						vBuscar.setVisible(true);
						setVisible(true);
					}
				});
				pBotones.add(btnBuscar);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Cerramos la ventana
						setVisible(false);
						//Volvemos
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void actualizar() {
		lmGrupos.removeAllElements();
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenar(lmGrupos);
		
	}
	
	private void rellenarListas(Grupo pGr) {
		lmArtistas.removeAllElements();
		lmDiscos.removeAllElements();
		lmAAntiguos.removeAllElements();
		pGr.actArt(lmArtistas);
		pGr.actDis(lmDiscos);
		pGr.actArtAnt(lmAAntiguos);
	}
	
	private void reset() {
		tNombre.setText("");
		tLogo.setText("");
		lmArtistas.removeAllElements();
		lmAAntiguos.removeAllElements();
		lmDiscos.removeAllElements();
	}

}
