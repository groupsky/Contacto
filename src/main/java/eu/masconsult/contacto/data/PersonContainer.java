package eu.masconsult.contacto.data;

import javax.persistence.EntityManager;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.provider.BatchableLocalEntityProvider;

import eu.masconsult.contacto.domain.Contact;

public class PersonContainer extends JPAContainer<Contact> {

	private static final long serialVersionUID = 1L;

	public static final Object[] NATURAL_COL_ORDER = new Object[] {
			"firstName", "lastName", "email", "city" };
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
			"First name", "Last name", "Email", "City" };

	public PersonContainer(EntityManager entityManager) {
		super(Contact.class);
		BatchableLocalEntityProvider<Contact> lep = new BatchableLocalEntityProvider<Contact>(
				Contact.class, entityManager);
		setEntityProvider(lep);
		setAutoCommit(true);
	}
}
