// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package eu.masconsult.contacto.domain;

import eu.masconsult.contacto.domain.ContactDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ContactIntegrationTest_Roo_IntegrationTest {
    
    declare @type: ContactIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: ContactIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private ContactDataOnDemand ContactIntegrationTest.dod;
    
    @Test
    public void ContactIntegrationTest.testCountContacts() {
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", dod.getRandomContact());
        long count = eu.masconsult.contacto.domain.Contact.countContacts();
        org.junit.Assert.assertTrue("Counter for 'Contact' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void ContactIntegrationTest.testFindContact() {
        eu.masconsult.contacto.domain.Contact obj = dod.getRandomContact();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to provide an identifier", id);
        obj = eu.masconsult.contacto.domain.Contact.findContact(id);
        org.junit.Assert.assertNotNull("Find method for 'Contact' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Contact' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void ContactIntegrationTest.testFindAllContacts() {
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", dod.getRandomContact());
        long count = eu.masconsult.contacto.domain.Contact.countContacts();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Contact', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<eu.masconsult.contacto.domain.Contact> result = eu.masconsult.contacto.domain.Contact.findAllContacts();
        org.junit.Assert.assertNotNull("Find all method for 'Contact' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Contact' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void ContactIntegrationTest.testFindContactEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", dod.getRandomContact());
        long count = eu.masconsult.contacto.domain.Contact.countContacts();
        if (count > 20) count = 20;
        java.util.List<eu.masconsult.contacto.domain.Contact> result = eu.masconsult.contacto.domain.Contact.findContactEntries(0, (int) count);
        org.junit.Assert.assertNotNull("Find entries method for 'Contact' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Contact' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void ContactIntegrationTest.testFlush() {
        eu.masconsult.contacto.domain.Contact obj = dod.getRandomContact();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to provide an identifier", id);
        obj = eu.masconsult.contacto.domain.Contact.findContact(id);
        org.junit.Assert.assertNotNull("Find method for 'Contact' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyContact(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Contact' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void ContactIntegrationTest.testMerge() {
        eu.masconsult.contacto.domain.Contact obj = dod.getRandomContact();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to provide an identifier", id);
        obj = eu.masconsult.contacto.domain.Contact.findContact(id);
        boolean modified =  dod.modifyContact(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Contact' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void ContactIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", dod.getRandomContact());
        eu.masconsult.contacto.domain.Contact obj = dod.getNewTransientContact(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Contact' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Contact' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void ContactIntegrationTest.testRemove() {
        eu.masconsult.contacto.domain.Contact obj = dod.getRandomContact();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Contact' failed to provide an identifier", id);
        obj = eu.masconsult.contacto.domain.Contact.findContact(id);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Contact' with identifier '" + id + "'", eu.masconsult.contacto.domain.Contact.findContact(id));
    }
    
}
