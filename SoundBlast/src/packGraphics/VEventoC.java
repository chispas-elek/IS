package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;

import packComponentes.Concierto;
import packComponentes.Festival;
import packComponentes.Genero;
import packComponentes.Grupo;
import packComponentes.ListaEntrada;
import packComponentes.ListaGrupo;
import packComponentes.RuedaPrensa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.awt.Label;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VEventoC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tNombre;
	private JTextField tLugar;
	private JTextField tPrecio;
	private JTextField tPrecioV;
	private JTextField tAforo;
	private JTextField tGrupo;
	private JTextArea textArea;
	private JList list;
	private DefaultListModel lm = new DefaultListModel();
	private JComboBox comboBox, comboGenero;
	private DefaultComboBoxModel cbm = new DefaultComboBoxModel();
	private DefaultComboBoxModel cGen = new DefaultComboBoxModel(Genero.values());
	private JLabel lblDescripcion;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public VEventoC() {
		initialize();
		pack();
	}
	
	private void initialize() {
		
		setModal(true);
		setTitle("SoundBlast-Añadir Evento");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			tNombre = new JTextField();
			GridBagConstraints gbc_tNombre = new GridBagConstraints();
			gbc_tNombre.insets = new Insets(0, 0, 5, 0);
			gbc_tNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tNombre.gridx = 2;
			gbc_tNombre.gridy = 0;
			contentPanel.add(tNombre, gbc_tNombre);
			tNombre.setColumns(10);
		}
		{
			JLabel lblLugar = new JLabel("Lugar");
			GridBagConstraints gbc_lblLugar = new GridBagConstraints();
			gbc_lblLugar.anchor = GridBagConstraints.EAST;
			gbc_lblLugar.insets = new Insets(0, 0, 5, 5);
			gbc_lblLugar.gridx = 1;
			gbc_lblLugar.gridy = 1;
			contentPanel.add(lblLugar, gbc_lblLugar);
		}
		{
			tLugar = new JTextField();
			GridBagConstraints gbc_tLugar = new GridBagConstraints();
			gbc_tLugar.insets = new Insets(0, 0, 5, 0);
			gbc_tLugar.fill = GridBagConstraints.HORIZONTAL;
			gbc_tLugar.gridx = 2;
			gbc_tLugar.gridy = 1;
			contentPanel.add(tLugar, gbc_tLugar);
			tLugar.setColumns(10);
		}
		{
			JLabel lblPrecioNormal = new JLabel("Precio normal");
			GridBagConstraints gbc_lblPrecioNormal = new GridBagConstraints();
			gbc_lblPrecioNormal.anchor = GridBagConstraints.EAST;
			gbc_lblPrecioNormal.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioNormal.gridx = 1;
			gbc_lblPrecioNormal.gridy = 2;
			contentPanel.add(lblPrecioNormal, gbc_lblPrecioNormal);
		}
		{
			tPrecio = new JTextField();
			GridBagConstraints gbc_tPrecio = new GridBagConstraints();
			gbc_tPrecio.insets = new Insets(0, 0, 5, 0);
			gbc_tPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_tPrecio.gridx = 2;
			gbc_tPrecio.gridy = 2;
			contentPanel.add(tPrecio, gbc_tPrecio);
			tPrecio.setColumns(10);
		}
		{
			JLabel lblPrecioVip = new JLabel("Precio VIP");
			GridBagConstraints gbc_lblPrecioVip = new GridBagConstraints();
			gbc_lblPrecioVip.anchor = GridBagConstraints.EAST;
			gbc_lblPrecioVip.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioVip.gridx = 1;
			gbc_lblPrecioVip.gridy = 3;
			contentPanel.add(lblPrecioVip, gbc_lblPrecioVip);
		}
		{
			tPrecioV = new JTextField();
			GridBagConstraints gbc_tPrecioV = new GridBagConstraints();
			gbc_tPrecioV.insets = new Insets(0, 0, 5, 0);
			gbc_tPrecioV.fill = GridBagConstraints.HORIZONTAL;
			gbc_tPrecioV.gridx = 2;
			gbc_tPrecioV.gridy = 3;
			contentPanel.add(tPrecioV, gbc_tPrecioV);
			tPrecioV.setColumns(10);
		}
		{
			JLabel lblAforo = new JLabel("Aforo");
			GridBagConstraints gbc_lblAforo = new GridBagConstraints();
			gbc_lblAforo.anchor = GridBagConstraints.EAST;
			gbc_lblAforo.insets = new Insets(0, 0, 5, 5);
			gbc_lblAforo.gridx = 1;
			gbc_lblAforo.gridy = 4;
			contentPanel.add(lblAforo, gbc_lblAforo);
		}
		{
			tAforo = new JTextField();
			GridBagConstraints gbc_tAforo = new GridBagConstraints();
			gbc_tAforo.insets = new Insets(0, 0, 5, 0);
			gbc_tAforo.fill = GridBagConstraints.HORIZONTAL;
			gbc_tAforo.gridx = 2;
			gbc_tAforo.gridy = 4;
			contentPanel.add(tAforo, gbc_tAforo);
			tAforo.setColumns(10);
		}
		{
			JLabel lblTipo = new JLabel("Tipo");
			GridBagConstraints gbc_lblTipo = new GridBagConstraints();
			gbc_lblTipo.anchor = GridBagConstraints.EAST;
			gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipo.gridx = 1;
			gbc_lblTipo.gridy = 5;
			contentPanel.add(lblTipo, gbc_lblTipo);
		}
		{
			comboBox = new JComboBox(cbm);
			cbm.addElement("Concierto");
			cbm.addElement("Festival");
			cbm.addElement("Rueda de Prensa");
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 5;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblParticipantes = new JLabel("Participantes");
			GridBagConstraints gbc_lblParticipantes = new GridBagConstraints();
			gbc_lblParticipantes.insets = new Insets(0, 0, 5, 5);
			gbc_lblParticipantes.gridx = 1;
			gbc_lblParticipantes.gridy = 6;
			contentPanel.add(lblParticipantes, gbc_lblParticipantes);
		}
		{
			list = new JList(lm);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 5, 0);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 2;
			gbc_list.gridy = 6;
			contentPanel.add(list, gbc_list);
		}
		{
			JButton btnAadirParticipante = new JButton("Añadir Participante");
			btnAadirParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lm.addElement(tGrupo.getText());
					tGrupo.setText("");
				}
			});
			GridBagConstraints gbc_btnAadirParticipante = new GridBagConstraints();
			gbc_btnAadirParticipante.insets = new Insets(0, 0, 5, 5);
			gbc_btnAadirParticipante.gridx = 1;
			gbc_btnAadirParticipante.gridy = 7;
			contentPanel.add(btnAadirParticipante, gbc_btnAadirParticipante);
		}
		{
			tGrupo = new JTextField();
			GridBagConstraints gbc_tGrupo = new GridBagConstraints();
			gbc_tGrupo.insets = new Insets(0, 0, 5, 0);
			gbc_tGrupo.fill = GridBagConstraints.HORIZONTAL;
			gbc_tGrupo.gridx = 2;
			gbc_tGrupo.gridy = 7;
			contentPanel.add(tGrupo, gbc_tGrupo);
			tGrupo.setColumns(10);
		}
		{
			JLabel lblGenero = new JLabel("Genero");
			GridBagConstraints gbc_lblGenero = new GridBagConstraints();
			gbc_lblGenero.anchor = GridBagConstraints.EAST;
			gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
			gbc_lblGenero.gridx = 1;
			gbc_lblGenero.gridy = 9;
			contentPanel.add(lblGenero, gbc_lblGenero);
		}
		{
			comboGenero = new JComboBox(cGen);
			GridBagConstraints gbc_comboGenero = new GridBagConstraints();
			gbc_comboGenero.insets = new Insets(0, 0, 5, 0);
			gbc_comboGenero.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboGenero.gridx = 2;
			gbc_comboGenero.gridy = 9;
			contentPanel.add(comboGenero, gbc_comboGenero);
		}
		{
			lblDescripcion = new JLabel("Descripcion");
			GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
			gbc_lblDescripcion.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescripcion.gridx = 1;
			gbc_lblDescripcion.gridy = 11;
			contentPanel.add(lblDescripcion, gbc_lblDescripcion);
			
		}
		{
			textArea = new JTextArea();
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 2;
			gbc_textArea.gridy = 11;
			contentPanel.add(textArea, gbc_textArea);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListaGrupo pLG = getLista();
						switch((String)comboBox.getSelectedItem()) {
							case "Concierto":
								Concierto pCon = new Concierto(Integer.parseInt(tAforo.getText()), tNombre.getText(), tLugar.getText(), new Date(), new Date(), Integer.parseInt(tPrecio.getText()), Integer.parseInt(tPrecioV.getText()), (Genero)comboGenero.getSelectedItem(), pLG, new ListaEntrada(), Integer.parseInt(tAforo.getText()));
								packMae.CatalogoEventoMusical.getCatalogoEventoMusical().anadirConcierto(pCon);
								break;
							case "Festival":
								Festival pFes = new Festival(Integer.parseInt(tAforo.getText()), tNombre.getText(), tLugar.getText(), new Date(), new Date(), Integer.parseInt(tPrecio.getText()), Integer.parseInt(tPrecioV.getText()), (Genero)comboGenero.getSelectedItem(), pLG, new ListaEntrada(), Integer.parseInt(tAforo.getText()));
								packMae.CatalogoEventoMusical.getCatalogoEventoMusical().anadirFestival(pFes);
								break;
							default:
								RuedaPrensa pRP = new RuedaPrensa(tNombre.getText(), tLugar.getText(), new Date(), new Date(), (Genero)comboGenero.getSelectedItem(), pLG, textArea.getText());
								packMae.CatalogoEventoMusical.getCatalogoEventoMusical().anadirRPrensa(pRP);
								break;
						}
						setVisible(false);
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private ListaGrupo getLista() {
		ListaGrupo result = new ListaGrupo();
		while(!lm.isEmpty()) {
			result.addGrupo((String)lm.firstElement(), "");
			lm.removeElement(lm.firstElement());
		}
		return result;
	}

}
