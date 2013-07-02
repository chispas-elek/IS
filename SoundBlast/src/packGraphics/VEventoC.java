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

public class VEventoC extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public VEventoC() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			JLabel lblLugar = new JLabel("Lugar");
			GridBagConstraints gbc_lblLugar = new GridBagConstraints();
			gbc_lblLugar.insets = new Insets(0, 0, 5, 0);
			gbc_lblLugar.gridx = 1;
			gbc_lblLugar.gridy = 1;
			contentPanel.add(lblLugar, gbc_lblLugar);
		}
		{
			JLabel lblPrecioNormal = new JLabel("Precio normal");
			GridBagConstraints gbc_lblPrecioNormal = new GridBagConstraints();
			gbc_lblPrecioNormal.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrecioNormal.gridx = 1;
			gbc_lblPrecioNormal.gridy = 2;
			contentPanel.add(lblPrecioNormal, gbc_lblPrecioNormal);
		}
		{
			JLabel lblPrecioVip = new JLabel("Precio VIP");
			GridBagConstraints gbc_lblPrecioVip = new GridBagConstraints();
			gbc_lblPrecioVip.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrecioVip.gridx = 1;
			gbc_lblPrecioVip.gridy = 3;
			contentPanel.add(lblPrecioVip, gbc_lblPrecioVip);
		}
		{
			JLabel lblAforo = new JLabel("Aforo");
			GridBagConstraints gbc_lblAforo = new GridBagConstraints();
			gbc_lblAforo.gridx = 1;
			gbc_lblAforo.gridy = 4;
			contentPanel.add(lblAforo, gbc_lblAforo);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
