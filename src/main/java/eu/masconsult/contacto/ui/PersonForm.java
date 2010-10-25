package eu.masconsult.contacto.ui;

import java.util.Arrays;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;

import eu.masconsult.contacto.ContactoApplication;
import eu.masconsult.contacto.data.PersonContainer;

public class PersonForm extends Form implements ClickListener {

	private static final long serialVersionUID = 1L;

	private Button save = new Button("Save", (ClickListener) this);
	private Button cancel = new Button("Cancel", (ClickListener) this);
	private Button edit = new Button("Edit", (ClickListener) this);
	private ContactoApplication app;

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
	}

	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();
		if (source == save) {
			if (!isValid()) {
				return;
			}
			commit();
			setReadOnly(true);
		} else if (source == cancel) {
			discard();
			setReadOnly(true);
		} else if (source == edit) {
			setReadOnly(false);
		}
	}

	@Override
	public void setItemDataSource(Item newDataSource) {
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
}
