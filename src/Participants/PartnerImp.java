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
     * @return
     */
    @Override
    public String getVat() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public String getWebsite() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public String getEmail() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public ContactImp getContact() {
        return null;
    }

    /**
     * @return
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
    }

    /**
     * @param contact
     */
    @Override
    public void setContact(Contact contact) {

    }

    @Override
    public String toString() {
        return ("\n " + super.toString() +
                "\n -------Partner-------" +
                "\n Website: " + website +
                "\n Vat: " + vat);
    }
}