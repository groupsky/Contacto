package eu.masconsult.contacto.ui;

import com.vaadin.data.Property;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;

import eu.masconsult.contacto.ContactoApplication;
import eu.masconsult.contacto.data.PersonContainer;

public class PersonList extends Table {

	private static final long serialVersionUID = 1L;
	
	 public PersonList(ContactoApplication app) {
         setSizeFull();
         
         addGeneratedColumn("email", new ColumnGenerator() {
             public Component generateCell(Table source, Object itemId,
                     Object columnId) {
                 Link l = new Link();
                 l.setResource(new ExternalResource("mailto:" + source.getContainerProperty(itemId, "email").getValue()));
                 l.setCaption(source.getContainerProperty(itemId, "email").getValue() + "");
                 return l;
             }
         });
         
         setContainerDataSource(app.getDataSource());
         
         setVisibleColumns(PersonContainer.NATURAL_COL_ORDER);
         setColumnHeaders(PersonContainer.COL_HEADERS_ENGLISH);
         
         setSelectable(true);
         setImmediate(true);
         addListener((Property.ValueChangeListener) app);
         setNullSelectionAllowed(false);
         
         setColumnCollapsingAllowed(true);
         setColumnReorderingAllowed(true);
   }

}
