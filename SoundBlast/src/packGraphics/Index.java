package packGraphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTree;
import javax.swing.JButton;

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
		initialize();
		tree.addTreeSelectionListener(new TreeSelector());
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
	}

	private JPanel getPArbol() {
		if (pArbol == null) {
			pArbol = new JPanel();
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
			//tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		}
		return tree;
	}
	private JButton getBNGrupo() {
		if (bNGrupo == null) {
			bNGrupo = new JButton("Añadir grupo");
		}
		return bNGrupo;
	}
}
