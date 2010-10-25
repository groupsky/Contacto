package eu.masconsult.contacto.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Entity;

@RooJavaBean
@RooToString
@Entity
@RooEntity(finders = { "findContactsByFirstName", "findContactsByLastName" })
public class Contact {

    private String firstName;

    private String lastName;

    private String email;
}
