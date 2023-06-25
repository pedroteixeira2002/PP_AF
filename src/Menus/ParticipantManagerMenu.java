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

import Interfaces.MenuDisplay;
import Participants.*;
import cbl.ProjectImp;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Participant;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

import java.io.IOException;

/**
 * This class represents the Participant Manager Menu
 */
public class ParticipantManagerMenu implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Participant Manager Menu");
        System.out.println("1 - Create Participant");
        System.out.println("2 - List Participants");
        System.out.println("0 - Exit");
    }

    /**
     * This method handles the Participant Manager Menu
     * @param menuManager the menu manager
     * @param project the project to add the participant to
     * @throws ParticipantAlreadyInProject if the participant is already in the project
     * @throws IllegalNumberOfParticipantType if the number of participants is illegal
     */
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


    /**
     * This method displays the sub menu for the participant type
     */
    public static Participant readParticipant() {

        boolean isSubMenuRunning = true;

        String name, email;

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

                    ContactImp contact = (ContactImp) UserInput.getContact();
                    InstituitionImp instituition = (InstituitionImp) UserInput.getInstituition();

                    StudentImp student = new StudentImp(name, email, contact, instituition, number);
                    return student;

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

                    ContactImp contact1 = (ContactImp) UserInput.getContact();
                    InstituitionImp instituition1 = (InstituitionImp) UserInput.getInstituition();


                    PartnerImp partner = new PartnerImp(name, email, contact1, instituition1, vat, website);
                    return partner;
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

                    ContactImp contact2 = (ContactImp) UserInput.getContact();
                    InstituitionImp instituition2 = (InstituitionImp) UserInput.getInstituition();

                    FacilitatorImp facilitator = new FacilitatorImp(name, email, contact2, instituition2, areaOfExpertise);
                    return facilitator;

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

                    ContactImp contact3 = (ContactImp) UserInput.getContact();
                    InstituitionImp instituition3 = (InstituitionImp) UserInput.getInstituition();
                    JudgeImp judge = new JudgeImp(name, email, contact3, instituition3);

                    return judge;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        return null;
    }

    /**
     * This method displays the sub menu for the participant type
     */
    public static void subMenuParticipantType() {
        System.out.println("Choose Participant Type:");
        System.out.println("1 - Student");
        System.out.println("2 - Partner");
        System.out.println("3 - Facilitator");
        System.out.println("4 - Judge");
        System.out.println("0 - Exit");
    }

}



