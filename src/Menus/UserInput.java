/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package Menus;

import Participants.InstituitionImp;
import cbl.*;
import Participants.ContactImp;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.project.Status;
import ma02_resources.project.Task;


import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 This class implements the UserInput interface and defines the methods
 */
public class UserInput {
    String city, state, country, street, zipCode, phone;
    LocalDate startDate, endDate;
    String name, description, location;

    /**
     * This method returns a string that is read from the keyboard.
     * @return The string that was read from the keyboard.
     */
    public static Contact getContact() {
        Scanner scanner = new Scanner(System.in);
        String city, state, country, street, zipCode, phone;
        int nDoor;

        do {
            try {
                System.out.println("Enter the city's name:\n");
                city = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                city = null;
            }
        } while (city == null);

        do {
            try {
                System.out.println("Enter the state's name:\n");
                state = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                state = null;
            }
        } while (state == null);

        do {
            try {
                System.out.println("Enter the country's name:\n");
                country = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                country = null;
            }
        } while (country == null);

        do {
            try {
                System.out.println("Enter the street's name:\n");
                street = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                street = null;
            }
        } while (street == null);

        do {
            try {
                System.out.println("Enter the Zip Code:\n");
                zipCode = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                zipCode = null;
            }
        } while (zipCode == null);

        do {
            try {
                System.out.println("Enter the Phone number:\n");
                phone = getString();
                if (!phone.matches("[0-9]+")) {
                    System.err.println("Phone number cannot contain letters.");
                    throw new IOException();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                phone = null;
            }
        } while (phone == null);

        return new ContactImp(city, state, country, street, zipCode, phone);

    }

    /**
     * This method returns a string that is read from the keyboard.
     * @return The string that was read from the keyboard.
     */
    public static Instituition getInstituition() {
        Scanner scanner = new Scanner(System.in);
        String name, description, location, website, email;

        do {
            try {
                System.out.println("Enter the institution's name:\n");
                name = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                name = null;
            }
        } while (name == null);

        do {
            try {
                System.out.println("Enter the institution's email:\n");
                email = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                email = null;
            }
        } while (email == null);
        do {
            try {
                System.out.println("Enter the institution's description:\n");
                description = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                description = null;
            }
        } while (description == null);

        do {
            try {
                System.out.println("Enter the institution's website:\n");
                website = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                website = null;
            }
        } while (website == null);

        do {
            try {
                System.out.println("Enter the institution's location:\n");
                location = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                location = null;
            }
        } while (location == null);
        ContactImp contact = (ContactImp) getContact();
        InstituitionType type = getInstitution();

        return new InstituitionImp(name, contact, email, type, description, website);
    }

    /**
     * This method returns a string that is read from the keyboard.
     * @return The string that was read from the keyboard.
     */
    public static InstituitionType getInstitution() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the institution type:\n" +
                "1 - NGO\n" +
                "2 - Company\n" +
                "3 - University\n" +
                "4 - Other\n");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                return InstituitionType.NGO;
            case 2:
                return InstituitionType.COMPANY;
            case 3:
                return InstituitionType.UNIVERSITY;
            case 4:
                return InstituitionType.OTHER;
            default:
                return null;
        }
    }

    /**
     * This method returns a string that is read from the keyboard.
     * @return The string that was read from the keyboard.
     *
     * @throws IOException If the string is null, empty or blank.
     */
    public static String getString() throws IOException {
        String string;
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IOException("String can't be Null, Empty or Blank");
        }
        return string;
    }

    /**
     * This method returns an integer that is read from the keyboard.
     * @return The integer that was read from the keyboard.
     */
    public static int getInt() {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        return num;
    }

    /**
     * This method returns a LocalDate that is read from the keyboard.
     * @return The LocalDate that was read from the keyboard.
     */
    public static LocalDate getLocalDate() {
        LocalDate localDate = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            localDate = LocalDate.parse(input);
        } catch (Exception e) {
            System.err.println("Invalid date format. Please enter a date in the format YYYY-MM-DD.");
        }
        return localDate;
    }

    /**
     * This method returns a Task that is read from the keyboard.
     * @return The Task that was read from the keyboard.
     *
     */
    public static Task getTask() {

        String title, description;
        LocalDate start, end;
        int duration, extendDeadline;

        do {
            try {
                System.out.println("Enter the task's title:\n");
                title = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                title = null;
            }
        } while (title == null);

        do {
            try {
                System.out.println("Enter the task's description:\n");
                description = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                description = null;
            }
        } while (description == null);

        do {
            try {
                System.out.println("Enter the task's start date:\n");
                start = getLocalDate();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                start = null;
            }
        } while (start == null);

        do {
            try {
                System.out.println("Enter the task's end date:\n");
                end = getLocalDate();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                end = null;
            }
        } while (end == null);


        do {
            try {
                System.out.println("Enter the task's extend deadline:\n");
                extendDeadline = getInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                extendDeadline = -1;
            }
        } while (extendDeadline == -1);

        //Task task = new TaskImp(title, description, start, end, extendDeadline);
        return null;
    }

    /**
     * This method returns a Contact that is read from the keyboard.
     * @return The Contact that was read from the keyboard.
     */
    public static Status getStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the status:\n" +
                "1 - Active\n" +
                "2 - Inactive\n" +
                "3 - Closed\n" +
                "4 - Canceled\n");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                return Status.ACTIVE;
            case 2:
                return Status.INACTIVE;
            case 3:
                return Status.CLOSED;
            case 4:
                return Status.CANCELED;
            default:
                return null;
        }
    }

    /**
     * This method returns the contact's stree.
     * @return The Contact that was read from the keyboard.
     */
    public String getStreet() {
        do {
            try {
                System.out.println("Enter the street's name:\n");
                street = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                street = null;
            }
        } while (street == null);
        return street;
    }

    /**
     * This method returns the contact's city.
     * @return The Contact that was read from the keyboard.
     */
    public String getCity() {
        do {
            try {
                System.out.println("Enter the city's name:\n");
                city = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                city = null;
            }
        } while (city == null);
        return city;
    }

    /**
     * This method returns the contact's state.
     * @return The Contact that was read from the keyboard.
     */
    public String getState() {
        do {
            try {
                System.out.println("Enter the state's name:\n");
                state = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                state = null;
            }
        } while (state == null);
        return state;
    }


    /**
     * This method returns a Contact that is read from the keyboard.
     * @return The Contact that was read from the keyboard.
     *
     */
    public String getZipCode() {
        do {
            try {
                System.out.println("Enter the Zip Code:\n");
                zipCode = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                zipCode = null;
            }
        } while (zipCode == null);
        return zipCode;
    }

    /**
     * This method returns the contact's country.
     * @return The Contact that was read from the keyboard.
     */
    public String getCountry() {
        do {
            try {
                System.out.println("Enter the country's name:\n");
                country = getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                country = null;
            }
        } while (country == null);
        return country;
    }

    /**
     * This method returns the contact's phone number.
     * @return The Contact that was read from the keyboard.
     */
    public String getPhone() {
        do {
            try {
                System.out.println("Enter the Phone number:\n");
                phone = getString();
                if (!phone.matches("[0-9]+")) {
                    System.err.println("Phone number cannot contain letters.");
                    throw new IOException();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                phone = null;
            }
        } while (phone == null);
        return phone;
    }

    /**
     * This method returns equal if the objects are equal, false otherwise.
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        return false;
    }

}
