package packGraphics;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class TreeSelector implements TreeSelectionListener{

	public void valueChanged(TreeSelectionEvent e) {
		System.out.println("Se ha seleccionado un nodo");
	}

}
