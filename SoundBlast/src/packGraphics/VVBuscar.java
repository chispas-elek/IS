package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

public class VVBuscar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JList list;
	private JComboBox comboBox;
	private DefaultListModel lm = new DefaultListModel();
	private DefaultComboBoxModel cbm = new DefaultComboBoxModel();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VVBuscar() {
		initialize();
		pack();
	}
	
	private void initialize() {
		
		setModal(true);
		setTitle("SoundBlast-Buscar");
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
				comboBox = new JComboBox(cbm);
				cbm.addElement("");
				cbm.addElement("Artistas");
				cbm.addElement("Grupos");
				panel.add(comboBox);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				list = new JList(lm);
				actualizar();
				panel.add(list);
			}
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
	
	public void actualizar() {
		lm.removeAllElements();
		Iterator<String> it = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenar();
		while(it.hasNext()) {
			lm.addElement(it.next());
		}
	}
	
	private void actualizarArtistas() {
		lm.removeAllElements();
		Iterator<String> it = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenarArtistas();
		while(it.hasNext()) {
			lm.addElement(it.next());
		}
	}

}
