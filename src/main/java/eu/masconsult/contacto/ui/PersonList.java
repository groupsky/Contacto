package eu.masconsult.contacto.ui;

import com.vaadin.data.Property;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;

import eu.masconsult.contacto.ContactoApplication;
import eu.masconsult.contacto.data.PersonContainer;
import eu.masconsult.contacto.domain.Contact;

public class PersonList extends Table {

	private static final long serialVersionUID = 1L;
	
	 public PersonList(ContactoApplication app) {
         setSizeFull();
         
         addGeneratedColumn("email", new ColumnGenerator() {
             public Component generateCell(Table source, Object itemId,
                     Object columnId) {
                 Contact contact = (Contact) itemId;
                 Link l = new Link();
                 l.setResource(new ExternalResource("mailto:" + contact.getEmail()));
                 l.setCaption(contact.getEmail());
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
