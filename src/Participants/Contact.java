package Participants;

public class Contact implements ma02_resources.participants.Contact{
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phone;
    private final String country;

    public Contact(String street, String city, String state, String zipCode, String phone, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.country = country;
    }
    @Override
    public String getStreet() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public String getZipCode() {
        return null;
    }

    @Override
    public String getCountry() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }
}
