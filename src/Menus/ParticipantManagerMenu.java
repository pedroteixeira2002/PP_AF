package Menus;

import Interfaces.MenuDisplay;
import Participants.*;
import cbl.ProjectImp;
import ma02_resources.participants.Participant;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

import java.io.IOException;

public class ParticipantManagerMenu implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Participant Manager Menu");
        System.out.println("1 - Create Participant");
        System.out.println("2 - List Participants");
        System.out.println("0 - Exit");
    }

    public static void handleParticipantManagerMenu(MenuManager menuManager, ProjectImp project) throws ParticipantAlreadyInProject, IllegalNumberOfParticipantType {

        ParticipantManagerMenu participantManager = new ParticipantManagerMenu();
        boolean isParticipantRunning = true;

        while (isParticipantRunning) {

            menuManager.displayMenu(participantManager);

            int option;

            try {
                option = menuManager.getOption();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    project.addParticipant(readParticipant());
                    break;
                case 2:
                    project.listParticipants();
                    break;
                case 0:
                    isParticipantRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }



    public static Participant readParticipant() {

        boolean isSubMenuRunning = true;

        String name, email, instituition, contact;

        while (isSubMenuRunning) {

            subMenuParticipantType();

            int option;

            try {
                option = UserInput.getInt();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1: //Student
                    int number;
                    do {
                        System.out.println("Enter the student's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            name = null;
                        }
                    } while (name == null);
                    do {
                        System.out.println("Enter the student's number:\n");
                        number = UserInput.getInt();
                    } while (number == -1);
                    do {
                        System.out.println("Enter the student's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            email = null;
                        }
                    } while (email == null);
                    do {
                        System.out.println("Enter the student's instituition:\n");
                        try {
                            instituition = UserInput.getString();
                        } catch (Exception e) {
                            instituition = null;
                        }
                    } while (instituition == null);
                    do {
                        System.out.println("Enter the student's contact:\n");
                        try {
                            contact = UserInput.getString();
                        } catch (Exception e) {
                            contact = null;
                        }
                    } while (contact == null);
                    StudentImp student = new StudentImp(name, instituition, email, number, contact);
                    manager.addParticipant(student);
                    break;
                case 2: //Partner
                    String vat, website;

                    do {
                        System.out.println("Enter the partner's vat:\n");
                        try {
                            vat = UserInput.getString();
                            if (!vat.matches("[0-9]+")) {
                                System.out.println("VAT cannot contain letters.");
                                throw new IOException();
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            vat = null;
                        }
                    } while (vat == null);
                    do {
                        System.out.println("Enter the partner's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            name = null;
                        }
                    } while (name == null);

                    do {
                        System.out.println("Enter the partner's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            email = null;
                        }
                    } while (email == null);

                    do {
                        System.out.println("Enter the partner's website:\n");
                        try {
                            website = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            website = null;
                        }
                    } while (website == null);

                    do {
                        System.out.println("Enter the partner's contact:\n");
                        try {
                            contact = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            contact = null;
                        }
                    } while (contact == null);

                    PartnerImp partner = new PartnerImp(name, vat, email, website, contact);
                    manager.addParticipant(partner);
                    break;
                case 3: //Facilitator
                    String areaOfExpertise;

                    do {
                        System.out.println("Enter the facilitator's area of expertise:\n");
                        try {
                            areaOfExpertise = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            areaOfExpertise = null;
                        }
                    } while (areaOfExpertise == null);

                    do {
                        System.out.println("Enter the facilitator's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            name = null;
                        }
                    } while (name == null);

                    do {
                        System.out.println("Enter the facilitator's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            email = null;
                        }
                    } while (email == null);

                    do {
                        System.out.println("Enter the facilitator's contact:\n");
                        try {
                            contact = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            contact = null;
                        }
                    } while (contact == null);

                    do {
                        System.out.println("Enter the facilitator's instituition:\n");
                        try {
                            instituition = UserInput.getString();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            instituition = null;
                        }
                    } while (instituition == null);

                    FacilitatorImp facilitator = new FacilitatorImp(name, areaOfExpertise, email, instituition, contact);
                    portefolio.addParticipant(facilitator);
                    break;
                case 4: //Judge
                    do {
                        System.out.println("Enter the judge's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            name = null;
                        }
                    } while (name == null);
                    do {
                        System.out.println("Enter the judge's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            email = null;
                        }
                    } while (email == null);

                    do {
                        System.out.println("Enter the judge's instituition:\n");
                        try {
                            instituition = UserInput.getString();
                        } catch (Exception e) {
                            instituition = null;
                        }
                    } while (instituition == null);
                    do {
                        System.out.println("Enter the judge's contact:\n");
                        try {
                            contact = UserInput.getString();
                        } catch (Exception e) {
                            contact = null;
                        }
                    } while (contact == null);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }


    }


    public static void subMenuParticipantType() {
        System.out.println("Choose Participant Type:");
        System.out.println("1 - Student");
        System.out.println("2 - Partner");
        System.out.println("3 - Facilitator");
        System.out.println("4 - Judge");
        System.out.println("0 - Exit");
    }

}



