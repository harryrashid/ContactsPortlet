/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jasig.portlet.contacts.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mfgsscw2
 */
public interface Contact extends Serializable {

    public String getURN();
    
    public String getId();
    
    /**
     * @return the addresses
     */
    public List<Address> getAddresses();
    
    /**
     * 
     * @return primary Address 
     */
    public Address getPrimaryAddress();

    /**
     * @return the contactSource
     */
    public String getContactSource();

    /**
     * @return the department
     */
    public String getDepartment();

    /**
     * @return the emailAddresses
     */
    public List<EmailAddress> getEmailAddresses();
    
    /**
     * 
     * @return primary EmailAddress
     */
    public EmailAddress getPrimaryEmailAddress();

    /**
     * @return the firstname
     */
    public String getFirstname();

    /**
     * @return the initials
     */
    public String getInitials();

    /**
     * @return the organisation
     */
    public String getOrganisation();

    /**
     * @return the phoneNumbers
     */
    public List<PhoneNumber> getPhoneNumbers();
    
    /**
     * 
     * @return primary PhoneNumber
     */
    public PhoneNumber getPrimaryPhoneNumber();

    /**
     * @return the position
     */
    public String getPosition();

    /**
     * @return the surname
     */
    public String getSurname();

    /**
     * @return the title
     */
    public String getTitle();
    
    /**
     * 
     * @return the URI for an image for the contact
     */
    public String getImageURI();

    /**
     * @param contactSource the contactSource to set
     */
    public void setContactSource(String contactSource);

    /**
     * @param department the department to set
     */
    public void setDepartment(String department);

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname);

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials);

    /**
     * @param organisation the organisation to set
     */
    public void setOrganisation(String organisation);

    /**
     * @param position the position to set
     */
    public void setPosition(String position);

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname);

    /**
     * @param title the title to set
     */
    public void setTitle(String title);
    
    /**
     * 
     * @param id the ID of the Contact
     */
    
    public void setId(String id);
    
    /**
     * 
     * @param uri String representation of the URI of a Image for the contact.
     */
    public void setImageURI(String uri);
    
}
