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

public class Index extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList<String> list;
	private JList list_1;
	private JButton bAddGroup;
	private JButton bAddEvent;
	private JButton btnSeeGroup;
	private JButton btnSeeEvent;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JButton bEvents = new JButton("Events");
			JButton bBuyTicket = new JButton("Buy ticket");
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				ArrayList<String> noms = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupos().extraerNombres();
				list = new JList(noms.toArray());
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						Index.this.btnSeeGroup.setEnabled(true);
					}
				});
			}
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
							.addComponent(getBtnSeeGroup())
							.addComponent(getBtnSeeEvent()))
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
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
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getBtnSeeGroup())
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getBtnSeeEvent())))
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
			list_1.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					Index.this.btnSeeEvent.setEnabled(true);
				}
			});
		}
		return list_1;
	}
	private JButton getBAddGroup() {
		if (bAddGroup == null) {
			bAddGroup = new JButton("Add group");
			bAddGroup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new anadirGrupo().setVisible(true);
					Index.this.dispose();
					
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
	private JButton getBtnSeeGroup() {
		if (btnSeeGroup == null) {
			btnSeeGroup = new JButton("See group");
			btnSeeGroup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(Index.this.list.getSelectedValue());
					new ModifGrupo(Index.this.list.getSelectedValue()).setVisible(true);
					Index.this.dispose();
				}
			});
			
			btnSeeGroup.setEnabled(false);
		}
		return btnSeeGroup;
	}
	private JButton getBtnSeeEvent() {
		if (btnSeeEvent == null) {
			btnSeeEvent = new JButton("See event");
			btnSeeEvent.setEnabled(false);
		}
		return btnSeeEvent;
	}
}


