package Participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Partner;

public class PartnerImp extends ParticipantImp implements Partner {
    private final String website;
    private final String vat;

    public PartnerImp(String name, String email, ContactImp contactImp, InstituitionImp instituitionImp, String website, String vat) {
        super(name, email, contactImp, instituitionImp);
        this.website = website;
        this.vat = vat;
    }

    /**
     * @return vat
     */
    @Override
    public String getVat() {return this.vat;
    }

    /**
     * @return website
     */
    @Override
    public String getWebsite() {
        return this.website;
    }

    /**
     * @return super.getName()
     */
    @Override
    public String getName() {return super.getName();
    }

    /**
     * @return super.getEmail()
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return super.getContact()
     */
    @Override
    public ContactImp getContact() {return super.getContact();
    }

    /**
     * @return super.getInstituition()
     */
    @Override
    public InstituitionImp getInstituition() {
        return super.getInstituition();
    }

    /**
     * @param instituition
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * @param contact
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);

    }

    @Override
    public String toString() {
        return ("\n " + super.toString() +
                "\n -------Partner-------" +
                "\n Website: " + website +
                "\n Vat: " + vat);
    }
}