package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import packComponentes.Artista;
import packComponentes.Grupo;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class anadirGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblQuiDeberaPoner;
	private JTextField txtTname;
	private JTextField textField;
	private JButton bAddMember;
	private JList<String> list;
	private static Grupo gr = new Grupo(null, null, new ListaArtista(), new ListaArtista(), new ListaDisco());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			anadirGrupo dialog = new anadirGrupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public anadirGrupo() {
		setBounds(100, 100, 503, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				lblNewLabel = new JLabel("Nombre");
				lblNewLabel.addMouseListener(new MouseAdapter() {
					
				});
			}
			{
				lblNewLabel_1 = new JLabel("Logo");
			}
			JLabel lblQuiDeberaPoner = new JLabel("Aqui debera poner el nombre del grupo");
			lblQuiDeberaPoner.setVisible(false);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getTxtTname(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(28)
								.addComponent(getBAddMember())))
						.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
						.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGap(22))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(30)
						.addComponent(lblQuiDeberaPoner, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(168, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(4)
						.addComponent(lblQuiDeberaPoner)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addGap(12)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addComponent(getTxtTname(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(16)
								.addComponent(getBAddMember())))
						.addContainerGap(29, Short.MAX_VALUE))
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
					public void actionPerformed(ActionEvent e) {
						packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo(anadirGrupo.this.txtTname.getText(), anadirGrupo.this.textField.getText(), new ListaArtista(), new ListaArtista(), new ListaDisco());
						anadirGrupo.this.dispose();
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
	private JTextField getTxtTname() {
		if (txtTname == null) {
			txtTname = new JTextField();
			txtTname.setColumns(10);
		}
		return txtTname;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBAddMember() {
		if (bAddMember == null) {
			bAddMember = new JButton("Añadir miembro");
			bAddMember.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new anadirMiembro().setVisible(true);
				}
			});
		}
		return bAddMember;
	}
	private JList<String> getList() {
		if (list == null) {
			ArrayList<String> noms = this.gr.extraerNombres();
			list = new JList(noms.toArray());
		}
		return list;
	}
	
	public static void addMem(Artista pArtista) {
		gr.anadirIntegrante(pArtista);
	}
	
	public void mouseEntered(MouseEvent e) {
		anadirGrupo.this.lblQuiDeberaPoner.setVisible(true);
	}
	
	public void mouseExited(MouseEvent e) {
		anadirGrupo.this.lblQuiDeberaPoner.setVisible(false);
	}
}
