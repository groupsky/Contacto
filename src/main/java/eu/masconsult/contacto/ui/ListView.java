package eu.masconsult.contacto.ui;

import com.vaadin.ui.SplitPanel;

public class ListView extends SplitPanel {
	
	private static final long serialVersionUID = 1L;

	public ListView(PersonList personList, PersonForm personForm) {
		addStyleName("view");
        setFirstComponent(personList);
        setSecondComponent(personForm);
        setSplitPosition(40);
    }

}
