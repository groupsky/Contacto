package eu.masconsult.contacto.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class SharingOptions extends Window {

	private static final long serialVersionUID = 1L;

	public SharingOptions() {
		setModal(true);
		setWidth("50%");
		center();

		setCaption("Sharing options");
		addComponent(new Label(
				"With these setting you can modify contact sharing "
						+ "options. (non-functional, example of modal dialog)"));
		addComponent(new CheckBox("Gmail"));
		addComponent(new CheckBox(".Mac"));
		Button close = new Button("OK");
		addComponent(close);
	}

}
