package eu.masconsult.contacto.ui;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import eu.masconsult.contacto.ContactoApplication;
import eu.masconsult.contacto.data.PersonContainer;
import eu.masconsult.contacto.domain.Contact;

public class PersonForm extends Form implements ClickListener {

	private static final long serialVersionUID = 1L;

	private Button save = new Button("Save", (ClickListener) this);
	private Button cancel = new Button("Cancel", (ClickListener) this);
	private Button edit = new Button("Edit", (ClickListener) this);
	private ContactoApplication app;

	private boolean newContactMode = false;
	private Contact newContact = null;

	private final ComboBox cities = new ComboBox("City");

	public PersonForm(ContactoApplication app) {
		this.app = app;
		setWriteThrough(false);

		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		footer.addComponent(edit);
		footer.setVisible(false);

		setFooter(footer);

		/* Allow the user to enter new cities */
		cities.setNewItemsAllowed(true);
		/* We do not want to use null values */
		cities.setNullSelectionAllowed(false);
		/* Add an empty city used for selecting no city */
		cities.addItem("");
		/* Populate cities select using the cities in the data container */
		PersonContainer ds = app.getDataSource();
		for (Iterator<Object> it = ds.getItemIds().iterator(); it.hasNext();) {
			String city = ds.getItem(it.next()).getEntity().getCity();
			cities.addItem(city);
		}

		/*
		 * Field factory for overriding how the component for city selection is
		 * created
		 */
		setFormFieldFactory(new DefaultFieldFactory() {
			@Override
			public Field createField(Item item, Object propertyId,
					Component uiContext) {
				if (propertyId.equals("city")) {
					return cities;
				} else {
					Field field = super.createField(item, propertyId, uiContext);
					
					TextField tf = (TextField) field;
					tf.setNullRepresentation("");
					tf.setRequired(true);
					
					if (propertyId.equals("email")) {
						tf.addValidator(new EmailValidator("Email you entered is not valid."));
					}
					return field;
				}
			}
		});
	}

	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();
		if (source == save) {
			if (!isValid()) {
				return;
			}
			commit();
			if (newContactMode) {
				setItemDataSource(app.getDataSource().getItem(app.getDataSource().addEntity(newContact)));
				newContactMode = false;
			}
			setReadOnly(true);
		} else if (source == cancel) {
			if (newContactMode) {
				newContactMode = false;
				setItemDataSource(null);
			} else {
				discard();
			}
			setReadOnly(true);
		} else if (source == edit) {
			setReadOnly(false);
		}
	}

	@Override
	public void setItemDataSource(Item newDataSource) {
		newContactMode = false;
		if (newDataSource != null) {
			List<Object> orderedProperties = Arrays
					.asList(PersonContainer.NATURAL_COL_ORDER);
			super.setItemDataSource(newDataSource, orderedProperties);
			setReadOnly(true);
			getFooter().setVisible(true);
		} else {
			super.setItemDataSource(null);
			getFooter().setVisible(false);
		}
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		save.setVisible(!readOnly);
		cancel.setVisible(!readOnly);
		edit.setVisible(readOnly);
	}

	public void addContact() {
		// Create a temporary item for the form
		newContact = new Contact();
		setItemDataSource(new BeanItem<Contact>(newContact));
		newContactMode = true;
		setReadOnly(false);
	}
}
