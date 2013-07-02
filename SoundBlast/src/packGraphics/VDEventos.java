package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VDEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JList list;
	private DefaultListModel lm = new DefaultListModel();
	private VEventoC vEventoC = new VEventoC();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VDEventos dialog = new VDEventos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VDEventos() {
		initialize();
		pack();
	}
	
	private void initialize() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			rellenar();
			list = new JList(lm);
			contentPanel.add(list, BorderLayout.CENTER);
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
						actualizar();
					}
				});
				buttonPane.add(textField);
				textField.setColumns(10);
			}
			{
				JButton btnEliminarEvento = new JButton("Eliminar Evento");
				btnEliminarEvento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						packMae.CatalogoEventoMusical.getCatalogoEventoMusical().eliminarEvento(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()));
					}
				});
				btnEliminarEvento.setEnabled(false);
				buttonPane.add(btnEliminarEvento);
			}
			{
				JButton btnAadirEvento = new JButton("Añadir Concierto");
				btnAadirEvento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						vEventoC.setVisible(true);
						rellenar();
					}
				});
				buttonPane.add(btnAadirEvento);
			}
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
	
	private void rellenar() {
		packMae.CatalogoEventoMusical.getCatalogoEventoMusical().rellenar(lm);
	}
	
	private void actualizar() {
		packMae.CatalogoEventoMusical.getCatalogoEventoMusical().actualizar(lm, textField.getText());
	}

}
