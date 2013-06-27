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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tNombre;
	private JTextField tLogo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VGrupo() {
		setModal(true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 4;
			gbc_lblNombre.gridy = 2;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			tNombre = new JTextField();
			GridBagConstraints gbc_tNombre = new GridBagConstraints();
			gbc_tNombre.insets = new Insets(0, 0, 5, 0);
			gbc_tNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tNombre.gridx = 6;
			gbc_tNombre.gridy = 2;
			contentPanel.add(tNombre, gbc_tNombre);
			tNombre.setColumns(10);
		}
		{
			JLabel lblLogo = new JLabel("Logo");
			GridBagConstraints gbc_lblLogo = new GridBagConstraints();
			gbc_lblLogo.insets = new Insets(0, 0, 0, 5);
			gbc_lblLogo.gridx = 4;
			gbc_lblLogo.gridy = 3;
			contentPanel.add(lblLogo, gbc_lblLogo);
		}
		{
			tLogo = new JTextField();
			GridBagConstraints gbc_tLogo = new GridBagConstraints();
			gbc_tLogo.fill = GridBagConstraints.HORIZONTAL;
			gbc_tLogo.gridx = 6;
			gbc_tLogo.gridy = 3;
			contentPanel.add(tLogo, gbc_tLogo);
			tLogo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!(tNombre.getText() == null || tLogo.getText() == null)) {
							packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo(tNombre.getName(), tLogo.getText());
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
