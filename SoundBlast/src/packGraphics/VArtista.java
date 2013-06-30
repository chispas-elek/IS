package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import packComponentes.Artista;
import packComponentes.Grupo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VArtista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tNombre;
	private JTextField tTipo;
	private JLabel label, labelN, lblReemplazarA, lblAadirArtistaAl;
	private JButton btnReemplazar, okButton;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VArtista() {
		initialize();
		pack();
	}
	
	private void initialize() {
		
		setModal(true);
		
		setTitle("SoundBlast-Añadir Artista");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblAadirArtistaAl = new JLabel("Añadir artista al grupo");
			GridBagConstraints gbc_lblAadirArtistaAl = new GridBagConstraints();
			gbc_lblAadirArtistaAl.insets = new Insets(0, 0, 5, 5);
			gbc_lblAadirArtistaAl.gridx = 2;
			gbc_lblAadirArtistaAl.gridy = 0;
			contentPanel.add(lblAadirArtistaAl, gbc_lblAadirArtistaAl);
		}
		{
			label = new JLabel();
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 4;
			gbc_label.gridy = 0;
			contentPanel.add(label, gbc_label);
		}
		{
			lblReemplazarA = new JLabel("Reemplazar a");
			GridBagConstraints gbc_lblReemplazarA = new GridBagConstraints();
			gbc_lblReemplazarA.insets = new Insets(0, 0, 5, 5);
			gbc_lblReemplazarA.gridx = 2;
			gbc_lblReemplazarA.gridy = 1;
			lblReemplazarA.setVisible(false);
			contentPanel.add(lblReemplazarA, gbc_lblReemplazarA);
		}
		{
			labelN = new JLabel("");
			GridBagConstraints gbc_labelN = new GridBagConstraints();
			gbc_labelN.insets = new Insets(0, 0, 5, 5);
			gbc_labelN.gridx = 3;
			gbc_labelN.gridy = 1;
			labelN.setVisible(false);
			contentPanel.add(labelN, gbc_labelN);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 6;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			tNombre = new JTextField();
			GridBagConstraints gbc_tNombre = new GridBagConstraints();
			gbc_tNombre.insets = new Insets(0, 0, 5, 0);
			gbc_tNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tNombre.gridx = 8;
			gbc_tNombre.gridy = 1;
			contentPanel.add(tNombre, gbc_tNombre);
			tNombre.setColumns(10);
		}
		{
			JLabel lblTipo = new JLabel("Tipo");
			GridBagConstraints gbc_lblTipo = new GridBagConstraints();
			gbc_lblTipo.insets = new Insets(0, 0, 0, 5);
			gbc_lblTipo.gridx = 6;
			gbc_lblTipo.gridy = 3;
			contentPanel.add(lblTipo, gbc_lblTipo);
		}
		{
			tTipo = new JTextField();
			GridBagConstraints gbc_tTipo = new GridBagConstraints();
			gbc_tTipo.fill = GridBagConstraints.HORIZONTAL;
			gbc_tTipo.gridx = 8;
			gbc_tTipo.gridy = 3;
			contentPanel.add(tTipo, gbc_tTipo);
			tTipo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Añadir el artista al grupo
						Artista ar = new Artista(tNombre.getText(), tTipo.getText());
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(label.getText()).anadirIntegrante(ar);
						dispose();
					}
				});
				{
					btnReemplazar = new JButton("Reemplazar");
					btnReemplazar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Artista ar = new Artista(tNombre.getText(), tTipo.getText());
							packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().reemplazarIntegrante(ar, packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(label.getText()).buscarComponente(labelN.getText()), label.getText());
							setVisible(false);
						}
					});
					btnReemplazar.setVisible(false);
					buttonPane.add(btnReemplazar);
				}
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
	
	public void setMiText(String pAr) {
		label.setText(pAr);
	}
	
	public void setMiTexto(String pAr) {
		labelN.setText(pAr);
	}
	
	public void buttonOn() {
		btnReemplazar.setVisible(true);
		labelN.setVisible(true);
		lblReemplazarA.setVisible(true);
		label.setVisible(false);
		lblAadirArtistaAl.setVisible(false);
		okButton.setVisible(false);
	}
	
}
