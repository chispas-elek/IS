package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;

import packComponentes.Genero;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VACancion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tTitulo;
	private JTextField tNum;
	private JTextField tComp;
	private JTextField tPun;
	private JTextField tDur;
	private JLabel label, lGrupo;
	private JComboBox comboBox;
	private DefaultComboBoxModel cbm = new DefaultComboBoxModel(Genero.values());

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public VACancion() {
		initialize();
		pack();
	}
	
	private void initialize() {
		
		setModal(true);
		setTitle("SoundBlast-Añadir cancion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label = new JLabel("Titulo");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				panel.add(label, gbc_label);
			}
			{
				tTitulo = new JTextField();
				tTitulo.setColumns(10);
				GridBagConstraints gbc_tTitulo = new GridBagConstraints();
				gbc_tTitulo.insets = new Insets(0, 0, 5, 0);
				gbc_tTitulo.fill = GridBagConstraints.HORIZONTAL;
				gbc_tTitulo.gridx = 0;
				gbc_tTitulo.gridy = 1;
				panel.add(tTitulo, gbc_tTitulo);
			}
			{
				JLabel label = new JLabel("Numero de pista");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 2;
				panel.add(label, gbc_label);
			}
			{
				tNum = new JTextField();
				tNum.setColumns(10);
				GridBagConstraints gbc_tNum = new GridBagConstraints();
				gbc_tNum.insets = new Insets(0, 0, 5, 0);
				gbc_tNum.fill = GridBagConstraints.HORIZONTAL;
				gbc_tNum.gridx = 0;
				gbc_tNum.gridy = 3;
				panel.add(tNum, gbc_tNum);
			}
			{
				JLabel label = new JLabel("Compositor");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 4;
				panel.add(label, gbc_label);
			}
			{
				tComp = new JTextField();
				tComp.setColumns(10);
				GridBagConstraints gbc_tComp = new GridBagConstraints();
				gbc_tComp.insets = new Insets(0, 0, 5, 0);
				gbc_tComp.fill = GridBagConstraints.HORIZONTAL;
				gbc_tComp.gridx = 0;
				gbc_tComp.gridy = 5;
				panel.add(tComp, gbc_tComp);
			}
			{
				JLabel label = new JLabel("Genero");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 6;
				panel.add(label, gbc_label);
			}
			{
				comboBox = new JComboBox(cbm);
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 5, 0);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 0;
				gbc_comboBox.gridy = 7;
				panel.add(comboBox, gbc_comboBox);
			}
			{
				JLabel label = new JLabel("Puntuacion");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 8;
				panel.add(label, gbc_label);
			}
			{
				tPun = new JTextField();
				tPun.setColumns(10);
				GridBagConstraints gbc_tPun = new GridBagConstraints();
				gbc_tPun.insets = new Insets(0, 0, 5, 0);
				gbc_tPun.fill = GridBagConstraints.HORIZONTAL;
				gbc_tPun.gridx = 0;
				gbc_tPun.gridy = 9;
				panel.add(tPun, gbc_tPun);
			}
			{
				JLabel label = new JLabel("Duracion");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 10;
				panel.add(label, gbc_label);
			}
			{
				tDur = new JTextField();
				tDur.setColumns(10);
				GridBagConstraints gbc_tDur = new GridBagConstraints();
				gbc_tDur.fill = GridBagConstraints.HORIZONTAL;
				gbc_tDur.gridx = 0;
				gbc_tDur.gridy = 11;
				panel.add(tDur, gbc_tDur);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblAadirADisco = new JLabel("Añadir a disco ");
				panel.add(lblAadirADisco);
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(lGrupo.getText()).buscarDisco(label.getText()).addCancion(Integer.parseInt(tNum.getText()), Integer.parseInt(tDur.getText()), Integer.parseInt(tPun.getText()), tTitulo.getText(), tComp.getText(), (Genero)comboBox.getSelectedItem());
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
	
	public void setLabel(String pNom, String pGr) {
		label.setText(pNom);
		lGrupo.setText(pGr);
	}
	
	private void reset() {
		tTitulo.setText("");
		tNum.setText("");
		tComp.setText("");
		tPun.setText("");
		tDur.setText("");
	}

}
