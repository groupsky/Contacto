package eu.masconsult.contacto.server.controller;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import eu.masconsult.contacto.domain.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "contacts", formBackingObject = Contact.class)
@RequestMapping("/contacts")
@Controller
public class ContactController {
}
