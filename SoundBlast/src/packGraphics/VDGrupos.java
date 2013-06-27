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

public class VDGrupos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tNombre;
	private JTextField tLogo;
	private JList miLista, lArtistas, lDiscos, lAAntiguos;
	private JPanel pLista, pData, panel, pBotones;
	private JTextField lblNombre, lblLogo;
	private DefaultListModel lm = new DefaultListModel();
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public VDGrupos() {
		initialize();
	}
	private void initialize() {
		setTitle("SoundBlast-Grupos");
		
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
					
					miLista = new JList(lm);
					miLista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					miLista.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent arg0) {
							Grupo gr = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo((String) miLista.getSelectedValue());
							lblNombre.setText(gr.getNombre());
							lblLogo.setText(gr.getLogo());
							//Rellenar las listas*/
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
				gbl_pData.rowHeights = new int[]{15, 0, 0, 0, 0, 0};
				gbl_pData.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_pData.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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
					tNombre.setEnabled(false);
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
					tLogo.setEnabled(false);
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
					JLabel lblArtistas = new JLabel("Artistas");
					GridBagConstraints gbc_lblArtistas = new GridBagConstraints();
					gbc_lblArtistas.insets = new Insets(0, 0, 5, 5);
					gbc_lblArtistas.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblArtistas.gridx = 0;
					gbc_lblArtistas.gridy = 2;
					pData.add(lblArtistas, gbc_lblArtistas);
				}
				{
					JList lArtistas = new JList();
					lArtistas.setEnabled(false);
					GridBagConstraints gbc_lArtistas = new GridBagConstraints();
					gbc_lArtistas.insets = new Insets(0, 0, 5, 5);
					gbc_lArtistas.fill = GridBagConstraints.BOTH;
					gbc_lArtistas.gridx = 2;
					gbc_lArtistas.gridy = 2;
					pData.add(lArtistas, gbc_lArtistas);
				}
				{
					JLabel lblDiscografia = new JLabel("Discografia");
					GridBagConstraints gbc_lblDiscografia = new GridBagConstraints();
					gbc_lblDiscografia.anchor = GridBagConstraints.WEST;
					gbc_lblDiscografia.insets = new Insets(0, 0, 5, 5);
					gbc_lblDiscografia.gridx = 0;
					gbc_lblDiscografia.gridy = 3;
					pData.add(lblDiscografia, gbc_lblDiscografia);
				}
				{
					JList lDiscos = new JList();
					lDiscos.setEnabled(false);
					GridBagConstraints gbc_lDiscos = new GridBagConstraints();
					gbc_lDiscos.insets = new Insets(0, 0, 5, 5);
					gbc_lDiscos.fill = GridBagConstraints.BOTH;
					gbc_lDiscos.gridx = 2;
					gbc_lDiscos.gridy = 3;
					pData.add(lDiscos, gbc_lDiscos);
				}
				{
					JLabel lblArtistasAntiguos = new JLabel("Artistas Antiguos");
					GridBagConstraints gbc_lblArtistasAntiguos = new GridBagConstraints();
					gbc_lblArtistasAntiguos.anchor = GridBagConstraints.WEST;
					gbc_lblArtistasAntiguos.insets = new Insets(0, 0, 0, 5);
					gbc_lblArtistasAntiguos.gridx = 0;
					gbc_lblArtistasAntiguos.gridy = 4;
					pData.add(lblArtistasAntiguos, gbc_lblArtistasAntiguos);
				}
				{
					JList lAAntiguos = new JList();
					lAAntiguos.setEnabled(false);
					GridBagConstraints gbc_lAAntiguos = new GridBagConstraints();
					gbc_lAAntiguos.insets = new Insets(0, 0, 0, 5);
					gbc_lAAntiguos.fill = GridBagConstraints.BOTH;
					gbc_lAAntiguos.gridx = 2;
					gbc_lAAntiguos.gridy = 4;
					pData.add(lAAntiguos, gbc_lAAntiguos);
				}
			}
		}
		{
			pBotones = new JPanel();
			contentPanel.add(pBotones, BorderLayout.SOUTH);
			{
				JButton btnAadirGrupo = new JButton("Añadir grupo");
				btnAadirGrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new VGrupo().setVisible(true);
						actualizar();
					}
				});
				pBotones.add(btnAadirGrupo);
			}
			{
				JButton btnEliminarGrupo = new JButton("Eliminar grupo");
				btnEliminarGrupo.setEnabled(false);
				pBotones.add(btnEliminarGrupo);
			}
			{
				JButton btnEditarGrupo = new JButton("Editar grupo");
				btnEditarGrupo.setEnabled(false);
				pBotones.add(btnEditarGrupo);
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void actualizar() {
		lm.removeAllElements();
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenar(lm);
		
	}

}
