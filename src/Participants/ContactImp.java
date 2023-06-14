package Participants;

import ma02_resources.participants.Contact;

public class ContactImp implements Contact {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phone;
    private final String country;

    public ContactImp(String street, String city, String state, String zipCode, String phone, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.country = country;
    }

    @Override
    public String getStreet() {return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        return ("\n -------Contact-------" +
                "\n Phone: " + phone +
                "\n Street: " + street +
                "\n Zip Code: " + zipCode +
                "\n City: " + city +
                "\n State: " + state +
                "\n Country: " + country +
                "\n -----------------------");
    }
}
