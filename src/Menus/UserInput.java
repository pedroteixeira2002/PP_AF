package Menus;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInput {
    String city, state, country, street, zipCode, phone;
    LocalDate startDate, endDate;
    String name, description, location;


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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public boolean equals(Object o) {
        return false;
    }


}
