package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JTextField;

import packComponentes.Artista;
import packComponentes.Disco;
import packComponentes.Grupo;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblLogo;
	private JLabel lblArtistas;
	private JLabel lblAnteriores;
	private JLabel lblDiscografia;
	private JList list;
	private JList list_1;
	private JList list_2;
	private JTextField textField;
	private JTextField textField_1;
	private Grupo grupo;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			ModifGrupo dialog = new ModifGrupo();
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
	public ModifGrupo(String pGrupo) {
		grupo = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(pGrupo);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(getLblLogo())
								.addContainerGap(381, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLblArtistas())
									.addComponent(getLblNombre()))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(91)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(getLblAnteriores())
											.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(getList_2(), GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addComponent(getLblDiscografia()))
										.addGap(27))
									.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(228))))))
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(345, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblNombre())
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblLogo())
							.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblArtistas())
							.addComponent(getLblAnteriores())
							.addComponent(getLblDiscografia()))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(15)
								.addComponent(getList_2(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(24, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().eliminarGrupo(grupo.getNombre());
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo(ModifGrupo.this.textField.getText(), ModifGrupo.this.textField_1.getText(), new ListaArtista(), new ListaArtista(), new ListaDisco());
						ModifGrupo.this.dispose();
						new Index().setVisible(true);
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
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
		}
		return lblNombre;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("Logo");
		}
		return lblLogo;
	}
	private JLabel getLblArtistas() {
		if (lblArtistas == null) {
			lblArtistas = new JLabel("Artistas");
		}
		return lblArtistas;
	}
	private JLabel getLblAnteriores() {
		if (lblAnteriores == null) {
			lblAnteriores = new JLabel("Anteriores");
		}
		return lblAnteriores;
	}
	private JLabel getLblDiscografia() {
		if (lblDiscografia == null) {
			lblDiscografia = new JLabel("Discografia");
		}
		return lblDiscografia;
	}
	private JList getList() {
		if (list == null) {
			ArrayList<Artista> artistas = grupo.getComponentes().getLista();
			list = new JList(artistas.toArray());
		}
		return list;
	}
	private JList getList_1() {
		if (list_1 == null) {
			ArrayList<Artista> artistasA = grupo.getComponentesAnteriores().getLista();
			list_1 = new JList(artistasA.toArray()); 
		}
		return list_1;
	}
	private JList getList_2() {
			if (list_2 == null) {
				ArrayList<Disco> discos = grupo.getDiscografia().getDiscos();
				list_2 = new JList(discos.toArray()); 
			}
			return list_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField(grupo.getNombre());
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField(grupo.getLogo());
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
