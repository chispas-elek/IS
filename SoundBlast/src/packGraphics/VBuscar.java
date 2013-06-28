package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VBuscar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultComboBoxModel lmCombo = new DefaultComboBoxModel();
	private JComboBox comboBox;
	private final JPanel resultado = new JPanel();
	private JList miLista;
	private DefaultListModel lmLista = new DefaultListModel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VBuscar() {
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblBuscarPor = new JLabel("Buscar por:");
				panel.add(lblBuscarPor);
			}
			{
				comboBox = new JComboBox(lmCombo);
				lmCombo.addElement("Artistas");
				lmCombo.addElement("Grupos");
				lmCombo.addElement("Eventos");
				panel.add(comboBox);
			}
		}
		contentPanel.add(resultado, BorderLayout.CENTER);
		resultado.setLayout(new BorderLayout(0, 0));
		{
			JList list = new JList(lmLista);
			switch((String)comboBox.getSelectedItem()) {
				case "Artistas":
					//Rellenar la lista con los artistas ordenados
					break;
				case "Grupos":
					//Rellenar la lista con los grupos ordenados
					break;
				default:
					break;
			}
			resultado.add(list, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				textField = new JTextField();
				buttonPane.add(textField);
				textField.setColumns(10);
			}
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
