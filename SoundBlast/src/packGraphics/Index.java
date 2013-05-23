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
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Index extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList<Grupo> list;
	private JList list_1;
	private JButton bAddGroup;
	private JButton bAddEvent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Index dialog = new Index();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Index() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				ArrayList<Grupo> grupos = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupos().getLista();
				list = new JList(grupos.toArray());
			}
			JButton bEvents = new JButton("Events");
			JButton bBuyTicket = new JButton("Buy ticket");
			JButton bSeeGroup = new JButton("See group");
			JButton bSeeEvent = new JButton("See event");
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(getBAddGroup())
							.addComponent(getBAddEvent())
							.addComponent(bEvents)
							.addComponent(bBuyTicket)
							.addComponent(bSeeGroup)
							.addComponent(bSeeEvent))
						.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
								.addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(getBAddGroup())
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getBAddEvent())
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bEvents)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bBuyTicket)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bSeeGroup)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bSeeEvent)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
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
	private JList getList_1() {
		if (list_1 == null) {
			list_1 = new JList();
		}
		return list_1;
	}
	private JButton getBAddGroup() {
		if (bAddGroup == null) {
			bAddGroup = new JButton("Add group");
			bAddGroup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new anadirGrupo().setVisible(true);
					Index.this.setModal(false);
					
				}
			});
		}
		return bAddGroup;
	}
	private JButton getBAddEvent() {
		if (bAddEvent == null) {
			bAddEvent = new JButton("Add event");
		}
		return bAddEvent;
	}
}
