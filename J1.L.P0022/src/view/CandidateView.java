/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Inputter;
import java.util.ArrayList;
import java.util.Calendar;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;

/**
 *
 * @author Admin
 */
public class CandidateView {

    Inputter inputter = new Inputter();

    public void displayMenu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
    }

    public Candidate inputCandidate(String id) {
        String firstName = inputter.getString("Enter first name: ");
        String lastName = inputter.getString("Enter last name: ");
        int birthDate = inputter.getInt("Enter birth date: ", 1900,
                Calendar.getInstance().get(Calendar.YEAR));
        String address = inputter.getString("Enter address: ");
        String phone = inputter.getPhone();
        String email = inputter.getEmail();
        
        return new Candidate(id, firstName, lastName, birthDate, address, phone, email);
    }

    public Experience inputExperience(Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = inputter.gettExprience(candidate.getBirthDate());
        String professionalSkill = inputter.getString("Enter professional skill: ");
        
        return new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate());
    }

    public Fresher inputFresher(Candidate candidate) {
        String graduationDate = inputter.getString("Enter graduation date: ");
        System.out.print("Enter graduation rank: ");
        String graduationRank = inputter.getGraduationRank();
        
        return new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                1);
    }

    public Internship inputInternship(Candidate candidate) {
        String major = inputter.getString("Enter major: ");
        String semester = inputter.getString("Enter semester: ");
        String university = inputter.getString("Enter university: ");
        
        return new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                2);
    }

    public void displayListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        
        System.out.println("===========FRESHER CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        
        System.out.println("===========INTERNSHIP CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }

    }

    public void displayCandidate(Candidate candidate) {
        System.out.println(candidate);
    }
    
}
