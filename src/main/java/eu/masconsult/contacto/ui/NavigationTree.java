package eu.masconsult.contacto.ui;

import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;

import eu.masconsult.contacto.ContactoApplication;

public class NavigationTree extends Tree {
	
	private static final long serialVersionUID = 1L;
	
	public static final Object SHOW_ALL = "Show all";
	public static final Object SEARCH = "Search";

	public NavigationTree(ContactoApplication app) {
		addItem(SHOW_ALL);
		addItem(SEARCH);
		
		setSelectable(true);
        setNullSelectionAllowed(false);
        
		addListener((ItemClickListener) app);
	}

}
