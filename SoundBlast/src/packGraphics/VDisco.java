package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import packComponentes.Grupo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VDisco extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultListModel lm = new DefaultListModel();
	private JList list;
	private JLabel label, lGrupo;
	private JTextField tDur;
	private JTextField tPunt;
	private JTextField tGen;
	private JTextField tComp;
	private JTextField tTitulo;
	private JTextField tNum;
	private JButton btnBorrarCancion;
	private VACancion vaCancion = new VACancion();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VDisco() {
		initialize();
		pack();
	}
	
	private void initialize() {
		
		setModal(true);
		setTitle("SoundBlast-Gestionar Disco");
		setBounds(100, 100, 387, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblVerDisco = new JLabel("Ver Disco ");
				panel.add(lblVerDisco);
			}
			{
				label = new JLabel("");
				panel.add(label);
			}
			{
				JLabel lblDelGrupo = new JLabel("del grupo ");
				panel.add(lblDelGrupo);
			}
			{
				lGrupo = new JLabel("");
				panel.add(lGrupo);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					list = new JList(lm);
					list.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent arg0) {
							tTitulo.setText(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()).getTitulo());
							tNum.setText(Integer.toString(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()).getNumeroPistas()));
							tComp.setText(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()).getCompositor());
							tGen.setText(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()).getGen().toString());
							tPunt.setText(Integer.toString(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()).getPuntuacion()));
							tDur.setText(Integer.toString(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()).getDuracion()));
							btnBorrarCancion.setEnabled(true);
						}
					});
					GridBagConstraints gbc_list = new GridBagConstraints();
					gbc_list.gridheight = 6;
					gbc_list.insets = new Insets(0, 0, 0, 5);
					gbc_list.fill = GridBagConstraints.BOTH;
					gbc_list.gridx = 1;
					gbc_list.gridy = 0;
					panel_1.add(list, gbc_list);
				}
				{
					JLabel lblNombre = new JLabel("Titulo");
					GridBagConstraints gbc_lblNombre = new GridBagConstraints();
					gbc_lblNombre.anchor = GridBagConstraints.EAST;
					gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
					gbc_lblNombre.gridx = 3;
					gbc_lblNombre.gridy = 0;
					panel_1.add(lblNombre, gbc_lblNombre);
				}
				{
					tTitulo = new JTextField();
					GridBagConstraints gbc_tTItulo = new GridBagConstraints();
					gbc_tTItulo.insets = new Insets(0, 0, 5, 5);
					gbc_tTItulo.fill = GridBagConstraints.HORIZONTAL;
					gbc_tTItulo.gridx = 6;
					gbc_tTItulo.gridy = 0;
					panel_1.add(tTitulo, gbc_tTItulo);
					tTitulo.setColumns(10);
				}
				{
					JButton btnAadirCancion = new JButton("Añadir Cancion");
					btnAadirCancion.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							((VACancion) vaCancion).setLabel(label.getText(), lGrupo.getText());
							vaCancion.setVisible(true);
							actualizar();
						}
					});
					GridBagConstraints gbc_btnAadirCancion = new GridBagConstraints();
					gbc_btnAadirCancion.insets = new Insets(0, 0, 5, 5);
					gbc_btnAadirCancion.gridx = 8;
					gbc_btnAadirCancion.gridy = 0;
					panel_1.add(btnAadirCancion, gbc_btnAadirCancion);
				}
				{
					JLabel lblNumeroDePista = new JLabel("Numero de pista");
					GridBagConstraints gbc_lblNumeroDePista = new GridBagConstraints();
					gbc_lblNumeroDePista.insets = new Insets(0, 0, 5, 5);
					gbc_lblNumeroDePista.gridx = 3;
					gbc_lblNumeroDePista.gridy = 1;
					panel_1.add(lblNumeroDePista, gbc_lblNumeroDePista);
				}
				{
					tNum = new JTextField();
					GridBagConstraints gbc_tNum = new GridBagConstraints();
					gbc_tNum.insets = new Insets(0, 0, 5, 5);
					gbc_tNum.fill = GridBagConstraints.HORIZONTAL;
					gbc_tNum.gridx = 6;
					gbc_tNum.gridy = 1;
					panel_1.add(tNum, gbc_tNum);
					tNum.setColumns(10);
				}
				{
					JLabel lblCompositor = new JLabel("Compositor");
					GridBagConstraints gbc_lblCompositor = new GridBagConstraints();
					gbc_lblCompositor.insets = new Insets(0, 0, 5, 5);
					gbc_lblCompositor.gridx = 3;
					gbc_lblCompositor.gridy = 2;
					panel_1.add(lblCompositor, gbc_lblCompositor);
				}
				{
					tComp = new JTextField();
					GridBagConstraints gbc_tComp = new GridBagConstraints();
					gbc_tComp.insets = new Insets(0, 0, 5, 5);
					gbc_tComp.fill = GridBagConstraints.HORIZONTAL;
					gbc_tComp.gridx = 6;
					gbc_tComp.gridy = 2;
					panel_1.add(tComp, gbc_tComp);
					tComp.setColumns(10);
				}
				{
					btnBorrarCancion = new JButton("Borrar Cancion");
					btnBorrarCancion.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().eliminarCancion(packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().buscarCancion((String)list.getSelectedValue()));
							
							actualizar();
							btnBorrarCancion.setEnabled(false);
						}
					});
					btnBorrarCancion.setEnabled(false);
					GridBagConstraints gbc_btnBorrarCancion = new GridBagConstraints();
					gbc_btnBorrarCancion.insets = new Insets(0, 0, 5, 5);
					gbc_btnBorrarCancion.gridx = 8;
					gbc_btnBorrarCancion.gridy = 2;
					panel_1.add(btnBorrarCancion, gbc_btnBorrarCancion);
				}
				{
					JLabel lblGenero = new JLabel("Genero");
					GridBagConstraints gbc_lblGenero = new GridBagConstraints();
					gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
					gbc_lblGenero.gridx = 3;
					gbc_lblGenero.gridy = 3;
					panel_1.add(lblGenero, gbc_lblGenero);
				}
				{
					tGen = new JTextField();
					GridBagConstraints gbc_tGen = new GridBagConstraints();
					gbc_tGen.insets = new Insets(0, 0, 5, 5);
					gbc_tGen.fill = GridBagConstraints.HORIZONTAL;
					gbc_tGen.gridx = 6;
					gbc_tGen.gridy = 3;
					panel_1.add(tGen, gbc_tGen);
					tGen.setColumns(10);
				}
				{
					JLabel lblPuntuacion = new JLabel("Puntuacion");
					GridBagConstraints gbc_lblPuntuacion = new GridBagConstraints();
					gbc_lblPuntuacion.insets = new Insets(0, 0, 5, 5);
					gbc_lblPuntuacion.gridx = 3;
					gbc_lblPuntuacion.gridy = 4;
					panel_1.add(lblPuntuacion, gbc_lblPuntuacion);
				}
				{
					tPunt = new JTextField();
					GridBagConstraints gbc_tPunt = new GridBagConstraints();
					gbc_tPunt.insets = new Insets(0, 0, 5, 5);
					gbc_tPunt.fill = GridBagConstraints.HORIZONTAL;
					gbc_tPunt.gridx = 6;
					gbc_tPunt.gridy = 4;
					panel_1.add(tPunt, gbc_tPunt);
					tPunt.setColumns(10);
				}
				{
					JLabel lblDuracion = new JLabel("Duracion");
					GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
					gbc_lblDuracion.insets = new Insets(0, 0, 0, 5);
					gbc_lblDuracion.gridx = 3;
					gbc_lblDuracion.gridy = 5;
					panel_1.add(lblDuracion, gbc_lblDuracion);
				}
				{
					tDur = new JTextField();
					GridBagConstraints gbc_tDur = new GridBagConstraints();
					gbc_tDur.insets = new Insets(0, 0, 0, 5);
					gbc_tDur.fill = GridBagConstraints.HORIZONTAL;
					gbc_tDur.gridx = 6;
					gbc_tDur.gridy = 5;
					panel_1.add(tDur, gbc_tDur);
					tDur.setColumns(10);
				}
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
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setLabel(String pNom, String pGr) {
		label.setText(pNom);
		lGrupo.setText(pGr);
	}
	
	private void actualizar() {
		lm.removeAllElements();
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).getCanciones().actualizar(lm);
	}
	
	private void reset() {
		
	}

}
