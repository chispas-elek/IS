package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import packComponentes.Disco;
import packComponentes.ListaCancion;
import packComponentes.Genero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class VADisco extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tNombre;
	private JTextField tDur;
	private JComboBox comboBox;
	private DefaultComboBoxModel cbm = new DefaultComboBoxModel(Genero.values());
	private JLabel label;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VADisco() {
		initialize();
		pack();
	}
	
	private void initialize() {
		
		setModal(true);
		setTitle("SoundBlast-Añadir Disco");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{15, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAadir = new JLabel("Añadir disco a");
			GridBagConstraints gbc_lblAadir = new GridBagConstraints();
			gbc_lblAadir.fill = GridBagConstraints.BOTH;
			gbc_lblAadir.insets = new Insets(0, 0, 5, 5);
			gbc_lblAadir.gridx = 0;
			gbc_lblAadir.gridy = 0;
			contentPanel.add(lblAadir, gbc_lblAadir);
		}
		{
			label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.gridx = 1;
			gbc_label.gridy = 0;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			tNombre = new JTextField();
			GridBagConstraints gbc_tNombre = new GridBagConstraints();
			gbc_tNombre.insets = new Insets(0, 0, 5, 0);
			gbc_tNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tNombre.gridx = 1;
			gbc_tNombre.gridy = 1;
			contentPanel.add(tNombre, gbc_tNombre);
			tNombre.setColumns(10);
		}
		{
			JLabel lblGenero = new JLabel("Genero");
			GridBagConstraints gbc_lblGenero = new GridBagConstraints();
			gbc_lblGenero.anchor = GridBagConstraints.EAST;
			gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
			gbc_lblGenero.gridx = 0;
			gbc_lblGenero.gridy = 2;
			contentPanel.add(lblGenero, gbc_lblGenero);
		}
		{
			comboBox = new JComboBox(cbm);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 2;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblDuracion = new JLabel("Duracion");
			GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
			gbc_lblDuracion.anchor = GridBagConstraints.EAST;
			gbc_lblDuracion.insets = new Insets(0, 0, 0, 5);
			gbc_lblDuracion.gridx = 0;
			gbc_lblDuracion.gridy = 3;
			contentPanel.add(lblDuracion, gbc_lblDuracion);
		}
		{
			tDur = new JTextField();
			GridBagConstraints gbc_tDur = new GridBagConstraints();
			gbc_tDur.fill = GridBagConstraints.HORIZONTAL;
			gbc_tDur.gridx = 1;
			gbc_tDur.gridy = 3;
			contentPanel.add(tDur, gbc_tDur);
			tDur.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(label.getText()).anadirDisco(tNombre.getText(), new Date(), (Genero)comboBox.getSelectedItem(), Integer.parseInt(tDur.getText()));
						reset();
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setMiText(String pNom) {
		label.setText(pNom);
	}
	
	private void reset() {
		tNombre.setText("");
		tDur.setText("");
	}

}
