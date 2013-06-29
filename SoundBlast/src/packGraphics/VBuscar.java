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

import net.sf.jga.algorithms.Filter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBuscar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultComboBoxModel lmCombo = new DefaultComboBoxModel();
	private JComboBox comboBox;
	private final JPanel resultado = new JPanel();
	private JList list;
	private DefaultListModel lmLista = new DefaultListModel();
	private JTextField textField;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VBuscar() {
		initialize();
		pack();
	}
	
	public void initialize() {
		
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblBuscarPor = new JLabel("Buscar por:");
				panel.add(lblBuscarPor);
			}
			{
				comboBox = new JComboBox(lmCombo);
				comboBox.addActionListener(new SeleccionListener());
				lmCombo.addElement("Artistas");
				lmCombo.addElement("Grupos");
				lmCombo.addElement("Eventos");
				panel.add(comboBox);
			}
		}
		contentPanel.add(resultado, BorderLayout.CENTER);
		resultado.setLayout(new BorderLayout(0, 0));
		{
			list = new JList(lmLista);
			resultado.add(list, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				textField = new JTextField();
				textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						
					}	
				});
				buttonPane.add(textField);
				textField.setColumns(10);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if((String)comboBox.getSelectedItem() == "Artistas") {
							DefaultListModel lm = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().filtrarArtistas(textField.getText());
							list = new JList(lm);
							actualizarArtistas();
						}
						else {
							DefaultListModel lm = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().filtrarGrupos(textField.getText());
							list = new JList(lm);
							actualizar();
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
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void actualizar() {
		lmLista.removeAllElements();
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenar(lmLista);
		
	}
	
	private void actualizarArtistas() {
		lmLista.removeAllElements();
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenarArtistas(lmLista);
		
	}
	
	private class SeleccionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			switch((String)comboBox.getSelectedItem()) {
				case "Artistas":
					lmLista = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().rellenar(lmLista);
					DefaultListModel lm = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().ordenar(lmLista);
					list = new JList(lm);
					resultado.add(list);
					actualizarArtistas();
					break;
				case "Grupos":
					DefaultListModel lmg = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().ordenar(lmLista);
					list = new JList(lmg);
					resultado.add(list);
					actualizar();
					break;
				default:
					break;
				}
			}
		
	}

}
