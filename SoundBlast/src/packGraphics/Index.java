package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Index extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDialog vdGrupos = new VDGrupos();
	private JDialog vdEventos = new VDEventos();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Index() {
		initialize();
		pack();
	}
	private void initialize() {
		setTitle("SoundBlast-Main");
		
		vdGrupos.pack();
		vdGrupos.setVisible(false);
		//vdEventos.pack();
		
		//Es una ventana modal
		setModal(true);
		
		
		//Resto de la constructora
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pMenu = new JPanel();
			contentPanel.add(pMenu, BorderLayout.CENTER);
			GridBagLayout gbl_pMenu = new GridBagLayout();
			gbl_pMenu.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_pMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_pMenu.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pMenu.setLayout(gbl_pMenu);
			{
				JButton btnVerGrupos = new JButton("Ver grupos");
				btnVerGrupos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Se abre VDGrupos
						setVisible(false);
						vdGrupos.setVisible(true);
						setVisible(true);
					}
				});
				GridBagConstraints gbc_btnVerGrupos = new GridBagConstraints();
				gbc_btnVerGrupos.insets = new Insets(0, 0, 5, 0);
				gbc_btnVerGrupos.gridx = 5;
				gbc_btnVerGrupos.gridy = 1;
				pMenu.add(btnVerGrupos, gbc_btnVerGrupos);
			}
			{
				JButton btnVerEventos = new JButton("Ver eventos");
				btnVerEventos.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						vdEventos.setVisible(true);
						setVisible(true);
					}
				});
				GridBagConstraints gbc_btnVerEventos = new GridBagConstraints();
				gbc_btnVerEventos.gridx = 5;
				gbc_btnVerEventos.gridy = 4;
				pMenu.add(btnVerEventos, gbc_btnVerEventos);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Cerramos la ventana y se acaba el programa
						System.exit(EXIT_ON_CLOSE);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
