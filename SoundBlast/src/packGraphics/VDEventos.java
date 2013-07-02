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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import packComponentes.EventoMusical;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Iterator;

public class VDEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private DefaultListModel lm = new DefaultListModel();
	private VEventoC vEventoC = new VEventoC();
	private JList list;
	private JButton btnEliminarEvento, btnComprarEntrada, btnComprarEntradavip;
	private JTextField textField_1;
	private JTextField tNombe;
	private JTextField tLugar;
	private JTextField tEntrada;
	private JTextField tVip;
	private JTextField tGen;
	private DefaultListModel lmP = new DefaultListModel();
	private JTextField tEntradas;
	private JTextField tBeneficios;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VDEventos() {
		initialize();
		pack();
	}
	
	private void initialize() {
		setModal(true);
		setTitle("SoundBlast-Eventos");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel pLista = new JPanel();
				panel.add(pLista);
				pLista.setLayout(new BorderLayout(0, 0));
				{
					list = new JList(lm);
					list.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent arg0) {
							btnEliminarEvento.setEnabled(true);
							try {
								controlEntradas();
								btnComprarEntrada.setEnabled(true);
								btnComprarEntradavip.setEnabled(true);
							String option = packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).getClass().toString();
							switch(option) {
								case "class packComponentes.Concierto":
									textField_1.setText("Concierto");
									break;
								case "class packComponentes.Festival":
									textField_1.setText("Festival");
									break;
								default:
									textField_1.setText("Rueda de prensa");
									break;
							}
							
							tNombe.setText(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).getNombre());
							tLugar.setText(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).getLugar());
							tEntrada.setText(Integer.toString(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).getPrecioEntrada()));
							tVip.setText(Integer.toString(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).getPrecioEntradaVip()));
							tGen.setText(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).getGenero().toString());
						}
							catch(NullPointerException e) {
								
							}
						}	
					});
					pLista.add(list, BorderLayout.CENTER);
				}
			}
		}
		{
			JPanel panel_1 = new JPanel();
			contentPanel.add(panel_1, BorderLayout.CENTER);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{201, 109, 114, 0};
			gbl_panel_1.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				JLabel lblTipoDeEvento = new JLabel("Tipo de Evento:");
				GridBagConstraints gbc_lblTipoDeEvento = new GridBagConstraints();
				gbc_lblTipoDeEvento.anchor = GridBagConstraints.WEST;
				gbc_lblTipoDeEvento.insets = new Insets(0, 0, 5, 5);
				gbc_lblTipoDeEvento.gridx = 1;
				gbc_lblTipoDeEvento.gridy = 0;
				panel_1.add(lblTipoDeEvento, gbc_lblTipoDeEvento);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.insets = new Insets(0, 0, 5, 0);
				gbc_textField_1.anchor = GridBagConstraints.NORTHWEST;
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 0;
				panel_1.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.anchor = GridBagConstraints.EAST;
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.gridx = 1;
				gbc_lblNombre.gridy = 1;
				panel_1.add(lblNombre, gbc_lblNombre);
			}
			{
				tNombe = new JTextField();
				tNombe.setEditable(false);
				GridBagConstraints gbc_tNombe = new GridBagConstraints();
				gbc_tNombe.insets = new Insets(0, 0, 5, 0);
				gbc_tNombe.fill = GridBagConstraints.HORIZONTAL;
				gbc_tNombe.gridx = 2;
				gbc_tNombe.gridy = 1;
				panel_1.add(tNombe, gbc_tNombe);
				tNombe.setColumns(10);
			}
			{
				JLabel lblLugar = new JLabel("Lugar");
				GridBagConstraints gbc_lblLugar = new GridBagConstraints();
				gbc_lblLugar.anchor = GridBagConstraints.EAST;
				gbc_lblLugar.insets = new Insets(0, 0, 5, 5);
				gbc_lblLugar.gridx = 1;
				gbc_lblLugar.gridy = 2;
				panel_1.add(lblLugar, gbc_lblLugar);
			}
			{
				tLugar = new JTextField();
				tLugar.setEditable(false);
				GridBagConstraints gbc_tLugar = new GridBagConstraints();
				gbc_tLugar.insets = new Insets(0, 0, 5, 0);
				gbc_tLugar.fill = GridBagConstraints.HORIZONTAL;
				gbc_tLugar.gridx = 2;
				gbc_tLugar.gridy = 2;
				panel_1.add(tLugar, gbc_tLugar);
				tLugar.setColumns(10);
			}
			{
				JLabel lblPrecioEntradaNormal = new JLabel("Precio Entrada normal");
				GridBagConstraints gbc_lblPrecioEntradaNormal = new GridBagConstraints();
				gbc_lblPrecioEntradaNormal.anchor = GridBagConstraints.EAST;
				gbc_lblPrecioEntradaNormal.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrecioEntradaNormal.gridx = 1;
				gbc_lblPrecioEntradaNormal.gridy = 3;
				panel_1.add(lblPrecioEntradaNormal, gbc_lblPrecioEntradaNormal);
			}
			{
				tEntrada = new JTextField();
				tEntrada.setEditable(false);
				GridBagConstraints gbc_tEntrada = new GridBagConstraints();
				gbc_tEntrada.insets = new Insets(0, 0, 5, 0);
				gbc_tEntrada.fill = GridBagConstraints.HORIZONTAL;
				gbc_tEntrada.gridx = 2;
				gbc_tEntrada.gridy = 3;
				panel_1.add(tEntrada, gbc_tEntrada);
				tEntrada.setColumns(10);
			}
			{
				JLabel lblPrecioVip = new JLabel("Precio VIP");
				GridBagConstraints gbc_lblPrecioVip = new GridBagConstraints();
				gbc_lblPrecioVip.anchor = GridBagConstraints.EAST;
				gbc_lblPrecioVip.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrecioVip.gridx = 1;
				gbc_lblPrecioVip.gridy = 4;
				panel_1.add(lblPrecioVip, gbc_lblPrecioVip);
			}
			{
				tVip = new JTextField();
				tVip.setEditable(false);
				GridBagConstraints gbc_tVip = new GridBagConstraints();
				gbc_tVip.insets = new Insets(0, 0, 5, 0);
				gbc_tVip.fill = GridBagConstraints.HORIZONTAL;
				gbc_tVip.gridx = 2;
				gbc_tVip.gridy = 4;
				panel_1.add(tVip, gbc_tVip);
				tVip.setColumns(10);
			}
			{
				JLabel lblGenero = new JLabel("Genero");
				GridBagConstraints gbc_lblGenero = new GridBagConstraints();
				gbc_lblGenero.anchor = GridBagConstraints.EAST;
				gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
				gbc_lblGenero.gridx = 1;
				gbc_lblGenero.gridy = 5;
				panel_1.add(lblGenero, gbc_lblGenero);
			}
			{
				tGen = new JTextField();
				tGen.setEditable(false);
				GridBagConstraints gbc_tGen = new GridBagConstraints();
				gbc_tGen.insets = new Insets(0, 0, 5, 0);
				gbc_tGen.fill = GridBagConstraints.HORIZONTAL;
				gbc_tGen.gridx = 2;
				gbc_tGen.gridy = 5;
				panel_1.add(tGen, gbc_tGen);
				tGen.setColumns(10);
			}
			{
				JLabel lblEntradasDisponibles = new JLabel("Entradas disponibles");
				GridBagConstraints gbc_lblEntradasDisponibles = new GridBagConstraints();
				gbc_lblEntradasDisponibles.anchor = GridBagConstraints.EAST;
				gbc_lblEntradasDisponibles.insets = new Insets(0, 0, 5, 5);
				gbc_lblEntradasDisponibles.gridx = 1;
				gbc_lblEntradasDisponibles.gridy = 6;
				panel_1.add(lblEntradasDisponibles, gbc_lblEntradasDisponibles);
			}
			{
				tEntradas = new JTextField();
				tEntradas.setEditable(false);
				GridBagConstraints gbc_tEntradas = new GridBagConstraints();
				gbc_tEntradas.insets = new Insets(0, 0, 5, 0);
				gbc_tEntradas.fill = GridBagConstraints.HORIZONTAL;
				gbc_tEntradas.gridx = 2;
				gbc_tEntradas.gridy = 6;
				panel_1.add(tEntradas, gbc_tEntradas);
				tEntradas.setColumns(10);
			}
			{
				btnComprarEntrada = new JButton("Comprar entrada");
				btnComprarEntrada.setEnabled(false);
				btnComprarEntrada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).venderEntradaNormal();
						controlEntradas();
					}
				});
				GridBagConstraints gbc_btnComprarEntrada = new GridBagConstraints();
				gbc_btnComprarEntrada.insets = new Insets(0, 0, 5, 5);
				gbc_btnComprarEntrada.gridx = 1;
				gbc_btnComprarEntrada.gridy = 7;
				panel_1.add(btnComprarEntrada, gbc_btnComprarEntrada);
			}
			{
				btnComprarEntradavip = new JButton("Comprar entradaVIP");
				btnComprarEntradavip.setEnabled(false);
				btnComprarEntradavip.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()).venderEntradaVip();
						controlEntradas();
					}
				});
				GridBagConstraints gbc_btnComprarEntradavip = new GridBagConstraints();
				gbc_btnComprarEntradavip.insets = new Insets(0, 0, 5, 0);
				gbc_btnComprarEntradavip.gridx = 2;
				gbc_btnComprarEntradavip.gridy = 7;
				panel_1.add(btnComprarEntradavip, gbc_btnComprarEntradavip);
			}
			{
				JLabel lblBeneficios = new JLabel("Beneficios");
				GridBagConstraints gbc_lblBeneficios = new GridBagConstraints();
				gbc_lblBeneficios.anchor = GridBagConstraints.EAST;
				gbc_lblBeneficios.insets = new Insets(0, 0, 5, 5);
				gbc_lblBeneficios.gridx = 1;
				gbc_lblBeneficios.gridy = 8;
				panel_1.add(lblBeneficios, gbc_lblBeneficios);
			}
			{
				tBeneficios = new JTextField();
				tBeneficios.setEditable(false);
				GridBagConstraints gbc_tBeneficios = new GridBagConstraints();
				gbc_tBeneficios.insets = new Insets(0, 0, 5, 0);
				gbc_tBeneficios.fill = GridBagConstraints.HORIZONTAL;
				gbc_tBeneficios.gridx = 2;
				gbc_tBeneficios.gridy = 8;
				panel_1.add(tBeneficios, gbc_tBeneficios);
				tBeneficios.setColumns(10);
			}
		}
		{
			rellenar();
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
				btnEliminarEvento = new JButton("Eliminar Evento");
				btnEliminarEvento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						packMae.CatalogoEventoMusical.getCatalogoEventoMusical().eliminarEvento(packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue()));
						rellenar();
						btnEliminarEvento.setEnabled(false);
						reset();
						btnComprarEntrada.setEnabled(false);
						btnComprarEntradavip.setEnabled(false);
					}
				});
				{
					JButton btnBuscaar = new JButton("Buscar");
					btnBuscaar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actualizar();
						}
					});
					buttonPane.add(btnBuscaar);
				}
				btnEliminarEvento.setEnabled(false);
				buttonPane.add(btnEliminarEvento);
			}
			{
				JButton btnAadirEvento = new JButton("Añadir Evento");
				btnAadirEvento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnComprarEntrada.setEnabled(false);
						btnComprarEntradavip.setEnabled(false);
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
		lm.removeAllElements();
		Iterator<String> it = packMae.CatalogoEventoMusical.getCatalogoEventoMusical().rellenar();
		while(it.hasNext()) {
			lm.addElement(it.next());
		}
	}
	
	private void actualizar() {
		lm.removeAllElements();
		Iterator<String> it = packMae.CatalogoEventoMusical.getCatalogoEventoMusical().actualizar(textField.getText());
		while(it.hasNext()) {
			lm.addElement(it.next());
		}
	}
	
	private void reset() {
		textField.setText("");
		tNombe.setText("");
		tLugar.setText("");
		tEntrada.setText("");
		tVip.setText("");
		tGen.setText("");
	}
	
	private void controlEntradas() {
		EventoMusical ev = packMae.CatalogoEventoMusical.getCatalogoEventoMusical().buscarEvento((String)list.getSelectedValue());
		tEntradas.setText(Integer.toString(ev.getMaxEntradas() - ev.cuantasTiene()));
		tBeneficios.setText(Integer.toString(ev.obtenerBeneficio()));
		if(Integer.parseInt(tEntradas.getText()) == 0) {
			btnComprarEntrada.setEnabled(false);
			btnComprarEntradavip.setEnabled(false);
		}
	}

}
