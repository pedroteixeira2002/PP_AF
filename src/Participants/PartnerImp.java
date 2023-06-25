/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Partner;

/**
 *
 * This class represents a Partner
 */
public class PartnerImp extends ParticipantImp implements Partner {
    private final String website;
    private final String vat;

    /**
     * Constructor of the class PartnerImp
     * @param name of the partner
     * @param email of the partner
     * @param contactImp of the partner
     * @param instituitionImp of the partner
     * @param website of the partner
     * @param vat of the partner
     */
    public PartnerImp(String name, String email, ContactImp contactImp, InstituitionImp instituitionImp, String website, String vat) {
        super(name, email, contactImp, instituitionImp);
        this.website = website;
        this.vat = vat;
    }

    /**
     * @return vat number of the partner
     */
    @Override
    public String getVat() {return this.vat;
    }

    /**
     * @return website of the partner
     */
    @Override
    public String getWebsite() {
        return this.website;
    }

    /**
     * @return name of the partner
     */
    @Override
    public String getName() {return super.getName();
    }

    /**
     * @return email of the partner
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return contact of the partner
     */
    @Override
    public ContactImp getContact() {return super.getContact();
    }

    /**
     * @return instituition of the partner
     */
    @Override
    public InstituitionImp getInstituition() {
        return super.getInstituition();
    }

    /**
     * @param instituition of the partner
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * @param contact of the partner
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);

    }

    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return ("\n " + super.toString() +
                "\n -------Partner-------" +
                "\n Website: " + website +
                "\n Vat: " + vat);
    }
}