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

public class UserInput {
    String city, state, country, street, zipCode, phone;
    LocalDate startDate, endDate;
    String name, description, location;

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

    public static String getString() throws IOException {
        String string;
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IOException("String can't be Null, Empty or Blank");
        }
        return string;
    }

    public static int getInt() {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        return num;
    }

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


    public boolean equals(Object o) {
        return false;
    }

}
