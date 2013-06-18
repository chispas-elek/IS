package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.JTree;

import packComponentes.Artista;
import packComponentes.ArtistaAntiguo;
import packComponentes.Disco;
import packComponentes.Grupo;

public class Index extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("SoundBlast");
	private DefaultMutableTreeNode artistas = new DefaultMutableTreeNode("Artistas");
	private DefaultMutableTreeNode eventos = new DefaultMutableTreeNode("Eventos");
	private DefaultTreeModel model = new DefaultTreeModel(root);

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
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JTree tree = new JTree(root);
				panel.add(tree, BorderLayout.CENTER);
				DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
				root = (DefaultMutableTreeNode)model.getRoot();
				arbol();
				model.reload(root);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
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
	
	public void rellenar() {
		Iterator<Grupo> it = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupos().obIterator();
		Grupo gr = null;
		while(it.hasNext()) {
			gr = it.next();
			DefaultMutableTreeNode adder = new DefaultMutableTreeNode(gr.getNombre());
			Iterator<Disco> it2 = gr.getDiscografia().obIterator();
			Iterator<Artista> itArt = gr.getComponentes().obIterator();
			Iterator<Artista> itAA = gr.getComponentesAnteriores().obIterator();
			Disco disc = null;
			Artista art = null;
			artistas.add(adder);
			while(itArt.hasNext()) {
				art = itArt.next();
				DefaultMutableTreeNode adding = new DefaultMutableTreeNode(art.getNombre());
				adder.add(adding);
			}
			while(itAA.hasNext()) {
				art = itAA.next();
				DefaultMutableTreeNode adding = new DefaultMutableTreeNode(art.getNombre());
				adder.add(adding);
			}
			while(it2.hasNext()) {
				disc = it2.next();
				DefaultMutableTreeNode adding = new DefaultMutableTreeNode(disc.getNombreDisco());
				adder.add(adding);
			}
		}
	}
	public void eventos() {
		
	}
	
	public void arbol() {
		root.add(artistas);
		root.add(eventos);
		this.rellenar();
		this.eventos();
	}

}
