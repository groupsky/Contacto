package eu.masconsult.contacto.data;

import java.io.Serializable;

import com.vaadin.Application;
import com.vaadin.data.util.BeanItemContainer;

import eu.masconsult.contacto.domain.Contact;

public class PersonContainer extends BeanItemContainer<Contact> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public static final Object[] NATURAL_COL_ORDER = new Object[] {
			"firstName", "lastName", "email", "city"};
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
			"First name", "Last name", "Email", "City"};

	public PersonContainer() throws InstantiationException,
			IllegalAccessException {
		super(Contact.class);
	}

	public static PersonContainer getAllContacts(Application app)
			throws InstantiationException, IllegalAccessException {
		PersonContainer cont = new PersonContainer();

		Contact cc = new Contact();
		cc.setFirstName("ivan");
		cc.setLastName("petrov");
		cc.setEmail("ivan@masconsult.eu");
		cc.setCity("Plovdiv");
		cc.merge();

		for (Contact c : Contact.findAllContacts())
			cont.addBean(c);

		return cont;
	}
}
