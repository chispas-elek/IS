package packGraphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTree;

import packComponentes.Artista;
import packComponentes.ArtistaAntiguo;
import packComponentes.Disco;
import packComponentes.Grupo;
import packComponentes.ListaArtista;
import packComponentes.ListaDisco;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class Index extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTree tree = new JTree();
	private static DefaultMutableTreeNode root = new DefaultMutableTreeNode("SoundBlast");
	private static DefaultMutableTreeNode grupos = new DefaultMutableTreeNode("Grupos");
	private static DefaultMutableTreeNode eventos = new DefaultMutableTreeNode("Eventos");
	private static DefaultTreeModel model = new DefaultTreeModel(root);
	private static JTextField tNombre;
	private static JTextField tGen;
	private static JPanel pData;
	private static JPanel pThings;
	private static JPanel panel;
	private static JPanel pBots;
	private static JPanel layGroup;
	private static JList lGrupos;
	

	
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
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new BorderLayout(0, 0));
			{
				tree = new JTree(root);
				tree.addTreeSelectionListener(new ControladorArbol());
				tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
				
				DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
				root = (DefaultMutableTreeNode)model.getRoot();
				this.relleno();
				this.arbol();
				System.out.println(grupos.getChildCount());
				model.reload(root);
				panel.add(tree, BorderLayout.CENTER);
			}
			panel.add(new JScrollPane(tree));
		}
		{
			pData = new JPanel();
			contentPanel.add(pData, BorderLayout.CENTER);
			pData.setLayout(new BorderLayout(0, 0));
			{
				pBots = new JPanel();
				pData.add(pBots, BorderLayout.EAST);
				{
					JButton bAnadirGrupo = new JButton("Añadir grupo");
					pBots.add(bAnadirGrupo);
				}
			}
			{
				pThings = new JPanel();
				pData.add(pThings, BorderLayout.CENTER);
				pThings.setLayout(new CardLayout(0, 0));
				{
					DefaultListModel listModel = new DefaultListModel();
					lGrupos = new JList(listModel);
					pThings.add(lGrupos, "name_86232383496078");
					lGrupos.setVisible(false);
				}
				{
					layGroup = new JPanel();
					pThings.add(layGroup, "name_86265886431051");
					layGroup.setLayout(new FormLayout(new ColumnSpec[] {
							ColumnSpec.decode("75px"),
							ColumnSpec.decode("55px:grow"),},
						new RowSpec[] {
							FormFactory.LINE_GAP_ROWSPEC,
							RowSpec.decode("15px"),
							FormFactory.RELATED_GAP_ROWSPEC,
							FormFactory.DEFAULT_ROWSPEC,
							FormFactory.RELATED_GAP_ROWSPEC,
							RowSpec.decode("default:grow"),
							FormFactory.RELATED_GAP_ROWSPEC,
							RowSpec.decode("default:grow"),
							FormFactory.RELATED_GAP_ROWSPEC,
							RowSpec.decode("default:grow"),}));
					{
						JLabel lNombre = new JLabel("Nombre");
						layGroup.add(lNombre, "1, 2, left, top");
					}
					{
						tNombre = new JTextField();
						layGroup.add(tNombre, "2, 2, fill, default");
						tNombre.setColumns(10);
					}
					{
						JLabel lblGenero = new JLabel("Genero");
						layGroup.add(lblGenero, "1, 4, right, default");
					}
					{
						tGen = new JTextField();
						layGroup.add(tGen, "2, 4, fill, default");
						tGen.setColumns(10);
					}
					{
						JLabel lblDisocs = new JLabel("Discos");
						layGroup.add(lblDisocs, "1, 6");
					}
					{
						JList lDiscos = new JList();
						layGroup.add(lDiscos, "2, 6, fill, fill");
					}
					{
						JLabel lblArtistasAntiguos = new JLabel("Antiguos");
						layGroup.add(lblArtistasAntiguos, "1, 8");
					}
					{
						JList lAntiguos = new JList();
						layGroup.add(lAntiguos, "2, 8, fill, fill");
					}
					{
						JLabel lblArtistas = new JLabel("Artistas");
						layGroup.add(lblArtistas, "1, 10");
					}
					{
						JList lArtistas = new JList();
						layGroup.add(lArtistas, "2, 10, fill, fill");
					}
					layGroup.setVisible(false);
				}
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
	public void relleno() {
		System.out.println("Pintando grupos");
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo("sss", "fg", new ListaArtista(), new ListaArtista(), new ListaDisco());
		System.out.println("Pintando grupos");
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo("sss", "fg", new ListaArtista(), new ListaArtista(), new ListaDisco());
		System.out.println("Pintando grupos");
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo("sss", "fg", new ListaArtista(), new ListaArtista(), new ListaDisco());
		System.out.println("Pintando grupos");
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo("sss", "fg", new ListaArtista(), new ListaArtista(), new ListaDisco());
		System.out.println("Pintando grupos");
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo("sss", "fg", new ListaArtista(), new ListaArtista(), new ListaDisco());
		System.out.println("Pintando grupos");
		packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().addGrupo("sss", "fg", new ListaArtista(), new ListaArtista(), new ListaDisco());
		System.out.println("Pintando grupos");
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
			grupos.add(adder);
			DefaultMutableTreeNode logo = new DefaultMutableTreeNode(gr.getLogo());
			DefaultMutableTreeNode a = new DefaultMutableTreeNode("Artistas");
			DefaultMutableTreeNode aa = new DefaultMutableTreeNode("Artistas antiguos");
			DefaultMutableTreeNode d = new DefaultMutableTreeNode("Discografia");
			adder.add(logo);
			adder.add(a);
			while(itArt.hasNext()) {
				art = itArt.next();
				DefaultMutableTreeNode adding = new DefaultMutableTreeNode(art.getNombre());
				a.add(adding);
			}
			adder.add(aa);
			while(itAA.hasNext()) {
				art = itAA.next();
				DefaultMutableTreeNode adding = new DefaultMutableTreeNode(art.getNombre());
				aa.add(adding);
			}
			adder.add(d);
			while(it2.hasNext()) {
				disc = it2.next();
				DefaultMutableTreeNode adding = new DefaultMutableTreeNode(disc.getNombreDisco());
				d.add(adding);
			}
			
		}
	}
	public void eventos() {
		
	}
	
	public static void hacerLista() {
		Iterator<Grupo> it = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupos().obIterator();
		Grupo g = null;
		Component gr = null;
		DefaultListModel listModel = (DefaultListModel) lGrupos.getModel();
		while(it.hasNext()) {
			g = it.next();
			listModel.addElement(g);
		}
	}
	
	public void arbol() {
		root.add(grupos);
		root.add(eventos);
		this.rellenar();
		this.eventos();
	}
	
	public static void invisible() {
		Index.lGrupos.setVisible(false);
		Index.layGroup.setVisible(false);
	}
	
	public static JTree getTree() {
		return tree;
	}
	
	public static void room() {
		invisible();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) Index.getTree().getLastSelectedPathComponent();
		if (node == null){
		}
		Object nodeInfo = packMae.CatalogoGrupoArtista.getCatalogoGrupoArtista().getGrupo(node.getUserObject().toString());
		if (node.isNodeChild(root) && node.getUserObject().toString() == "Grupos") {
			hacerLista();
			Index.lGrupos.setVisible(true);
		} else {
			 
		}
	}
}
