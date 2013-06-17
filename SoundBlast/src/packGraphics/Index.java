package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JList;

import packComponentes.Grupo;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;
import packComponentes.ListaGrupo;
import packMae.CatalogoGrupoArtista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Index extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList list;
	private JTextArea textArea;
	private JList lReprod;
	private JComboBox order;
	private JPanel operations;
	private JButton bBuy;
	private JButton bEventos;
	private JButton bLetra;
	private JButton bAddGroup;
	private JButton bDelGrupor;
	private JButton bEditGroup;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Index dialog = new Index();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Index() {
		setTitle("SoundBlast - Inicio");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel artists = new JPanel();
			contentPanel.add(artists);
			artists.setLayout(new BorderLayout(0, 0));
			artists.add(getList());
			artists.add(getOrder(), BorderLayout.NORTH);
		}
		{
			JPanel lyrics = new JPanel();
			contentPanel.add(lyrics);
			lyrics.setLayout(new BorderLayout(0, 0));
			lyrics.add(getTextArea(), BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getList_1_1());
		}
		contentPanel.add(getOperations(), BorderLayout.SOUTH);
		{
			{
				ArrayList<String> noms = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupos().extraerNombres();
			}
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
	private JList getList() {
		if (list == null) {
			ArrayList<String> noms = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupos().extraerNombres();
			list = new JList(noms.toArray());
		}
		return list;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JList getList_1_1() {
		if (lReprod == null) {
			lReprod = new JList();
		}
		return lReprod;
	}
	private JComboBox getOrder() {
		if (order == null) {
			order = new JComboBox();
		}
		return order;
	}
	private JPanel getOperations() {
		if (operations == null) {
			operations = new JPanel();
			operations.add(getBBuy());
			operations.add(getBEventos());
			operations.add(getBLetra());
			operations.add(getBAddGroup());
			operations.add(getBDelGrupor());
			operations.add(getBEditGroup());
		}
		return operations;
	}
	private JButton getBBuy() {
		if (bBuy == null) {
			bBuy = new JButton("Comprar entrada");
		}
		return bBuy;
	}
	private JButton getBEventos() {
		if (bEventos == null) {
			bEventos = new JButton("Ver Eventos");
		}
		return bEventos;
	}
	private JButton getBLetra() {
		if (bLetra == null) {
			bLetra = new JButton("Modificar letra");
		}
		return bLetra;
	}
	private JButton getBAddGroup() {
		if (bAddGroup == null) {
			bAddGroup = new JButton("Añadir grupo");
			bAddGroup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new anadirGrupo().setVisible(true);
					Index.this.dispose();
				}
			});
			
		}
		return bAddGroup;
	}
	private JButton getBDelGrupor() {
		if (bDelGrupor == null) {
			bDelGrupor = new JButton("Eliminar grupo");
		}
		return bDelGrupor;
	}
	private JButton getBEditGroup() {
		if (bEditGroup == null) {
			bEditGroup = new JButton("Editar grupo");
		}
		return bEditGroup;
	}
	
}


