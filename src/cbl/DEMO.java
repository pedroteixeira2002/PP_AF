/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package cbl;

import Interfaces.Portfolio;
import Participants.ContactImp;
import Participants.InstituitionImp;
import Participants.StudentImp;
import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static Menus.ParticipantManagerMenu.readParticipant;

public class DEMO {
    public static void main(String[] args) throws ParticipantAlreadyInProject, IllegalNumberOfParticipantType {

        PortfolioImp portfolio = new PortfolioImp();


        Edition edition1 = null;
        Edition edition2 = null;

        try {
            edition1 = new EditionImp("ED001", LocalDate.now(), LocalDate.of(2023, 12, 23), Status.ACTIVE);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            edition2 = new EditionImp("ED002", LocalDate.now(), LocalDate.of(2023, 12, 23), Status.INACTIVE);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }


        try {
            portfolio.addEdition(edition1);
        } catch (NullPointerException ex) {
            System.out.println(ex.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            portfolio.addEdition(edition2);
        } catch (NullPointerException ex) {
            System.out.println(ex.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        String[] tags1 = new String[]{"programming", "technology"};
        String[] tags2 = new String[]{"network", "technology"};
        String[] tags3 = new String[]{"security", "technology"};

        try {
            edition1.addProject("Project PP1", "First Project from ED001", tags1);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        try {
            edition1.addProject("Project PP2", "Second Project from ED001", tags1);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        try {
            edition1.addProject("Project RD1", "Third Project from ED001", tags2);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        try {
            edition2.addProject("Project SI1", "First Project from ED002", tags3);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        //Contacts
        Contact cont1 = new ContactImp("Rua Ramalade", "Felgueiras", "Porto", "1212-212", "Portugal", "999999999");
        Contact cont2 = new ContactImp("Avenida Salma", "Felgueiras", "Porto", "1312-112", "Portugal", "999993837");
        Contact cont3 = new ContactImp("Rua Delta", "Felgueiras", "Porto", "4230-200", "Portugal", "89323837");
        Contact cont4 = new ContactImp("Rua Chaunatau", "Felgueiras", "Porto", "4230-123", "Portugal", "982654321");
        Contact cont5 = new ContactImp("Praça Comunidades", "Felgueiras", "Porto", "4230-190", "Portugal", "982654321");
        Contact cont6 = new ContactImp("Avenida Dalai Lama", "Porto", "Porto", "4270-123", "Portugal", "982654321");
        Contact cont7 = new ContactImp("Rua Compadres", "Porto", "Porto", "4270-131", "Portugal", "982654321");
        Contact cont8 = new ContactImp("Rua Gildiniz", "Porto", "Porto", "4270-190", "Portugal", "982654321");
        Contact cont9 = new ContactImp("Praça Folha Boa", "Porto", "Porto", "4270-123", "Portugal", "999993837");
        Contact cont10 = new ContactImp("Ruas Neto", "Porto", "Porto", "4270-111", "Portugal", "999993837");
        Contact cont11 = new ContactImp("Condomino Laura", "Porto", "Porto", "-", "Portugal", "92333837");
        Contact cont12 = new ContactImp("Rua Dinarca", "Porto", "Porto", "4370-111", "Portugal", "92213837");
        Contact cont13 = new ContactImp("Rua Ponhce Caule", "Porto", "Porto", "4170-121", "Portugal", "92311837");
        Contact cont14 = new ContactImp("Avenida Aveiros", "Felgueiras", "Porto", "4270-121", "Portugal", "943837");
        Contact cont15 = new ContactImp("Rua Conde Domone", "Felgueiras", "Porto", "4270-192", "Portugal", "9253837");

//Instituitions
        Instituition inst1 = null;
        Instituition inst2 = null;
        Instituition inst3 = null;
        Instituition inst4 = null;
        Instituition inst5 = null;

        try {
            inst1 = new InstituitionImp("ESTG", cont1, "estg@ipp.pt", InstituitionType.UNIVERSITY, "estg.ipp.pt", "Polytechnic Institute");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            inst2 = new InstituitionImp("ISEP", cont2, "isep@ipp.pt", InstituitionType.UNIVERSITY, "Polytechnic Institute", "isep.ipp.pt");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            inst3 = new InstituitionImp("BLIP", cont3, "BLIP@gmail.com", InstituitionType.COMPANY, "Software Development", "blip.com");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }


        //Students
        Student stud1 = null;
        Student stud2 = null;
        Student stud3 = null;
        Student stud4 = null;
        Student stud5 = null;
        Student stud6 = null;
        Student stud7 = null;
        Student stud8 = null;


        try {
            stud1 = new StudentImp( "Gabriel Klotz", "8210255@estg.ipp.pt", cont4, inst1, 210255);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud2 = new StudentImp( "Alexandre Rex", "8210875@estg.ipp.pt", cont5, inst1,8210875);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud3 = new StudentImp( "Nelson Isac", "8210234@estg.ipp.pt", cont6, inst1, 8210234);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud4 = new StudentImp( "Guilherme Gouveia", "8110983@estg.ipp.pt", cont7, inst1,8110983);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud5 = new StudentImp( "Lilian Minhaça", "8920987@isep.ipp.pt", cont1, inst2, 88920987);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud6 = new StudentImp( "Julian Netebom", "8723454@isep.ipp.pt", cont9, inst2, 8723454);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud7 = new StudentImp( "Rebeca Nikols", "8172222@isep.ipp.pt", cont10, inst2,8723454);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            stud8 = new StudentImp("Sandro Cunha", "8150027@isep.ipp.pt", cont11, inst2, 8150027);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

    }



}
