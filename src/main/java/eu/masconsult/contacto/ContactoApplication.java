package eu.masconsult.contacto;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ContactoApplication extends Application {

	@Override
	public void init() {
		Window mainWindow = new Window("Contacto");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
