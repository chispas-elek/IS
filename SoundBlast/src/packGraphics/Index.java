package packGraphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JPanel pArbol;
	private JPanel pBotones;
	private JTree tree;
	private JButton bNGrupo;
	
	/**
	 * Create the frame.
	 */
	public Index() {
		setTitle("SoundBlast");
		initialize();
		
		//Listener de seleccion de arbol:mono
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(nodo.isLeaf()) {
					
				}
			}
		});
		
		//Listener de boton añadir
		bNGrupo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Grupo target = new Grupo();
				target.setVisible(true);
				while(!target.isVisible()){
				String g = target.getPGrupo();
				anadir(g);
				target.dispose();
				}
			}
		});
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPArbol(), BorderLayout.CENTER);
		contentPane.add(getPBotones(), BorderLayout.SOUTH);
		iniciarArbol();
	}

	private JPanel getPArbol() {
		if (pArbol == null) {
			pArbol = new JPanel();
			pArbol.setLayout(new BorderLayout(0, 0));
			pArbol.add(getTree());
		}
		return pArbol;
	}
	private JPanel getPBotones() {
		if (pBotones == null) {
			pBotones = new JPanel();
			pBotones.add(getBNGrupo());
		}
		return pBotones;
	}
	private JTree getTree() {
		if (tree == null) {
			tree = new JTree();
			this.iniciarArbol();
		}
		return tree;
	}
	private JButton getBNGrupo() {
		if (bNGrupo == null) {
			bNGrupo = new JButton("Añadir grupo");
			
		}
		return bNGrupo;
	}
	private void iniciarArbol() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("SoundBlast");
		DefaultMutableTreeNode grupos = new DefaultMutableTreeNode("Grupos");
		tree = new JTree(nodo);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		nodo.add(grupos);
	}
	
	public void anadir(String pNombre) {
		DefaultTreeModel nodo = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode added = new DefaultMutableTreeNode(pNombre);
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) nodo.getRoot();
		nodo.insertNodeInto(added, (MutableTreeNode) root.getChildAfter(root), root.getChildCount());
	}
}
