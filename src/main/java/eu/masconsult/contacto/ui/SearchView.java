package eu.masconsult.contacto.ui;

import com.vaadin.ui.Panel;

import eu.masconsult.contacto.ContactoApplication;

public class SearchView extends Panel {
	
	private static final long serialVersionUID = 1L;

	public SearchView(final ContactoApplication app) {
        setCaption("Search contacts");
        setSizeFull();
    }
}
