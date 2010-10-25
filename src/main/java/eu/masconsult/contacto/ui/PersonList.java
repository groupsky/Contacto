package eu.masconsult.contacto.ui;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;

import eu.masconsult.contacto.ContactoApplication;
import eu.masconsult.contacto.data.PersonContainer;

public class PersonList extends Table {

	private static final long serialVersionUID = 1L;
	
	 public PersonList(ContactoApplication app) {
         setSizeFull();
         
         setContainerDataSource(app.getDataSource());
         
         setVisibleColumns(PersonContainer.NATURAL_COL_ORDER);
         setColumnHeaders(PersonContainer.COL_HEADERS_ENGLISH);
         
         setSelectable(true);
         setImmediate(true);
         addListener((Property.ValueChangeListener) app);
         setNullSelectionAllowed(false);
   }

}
