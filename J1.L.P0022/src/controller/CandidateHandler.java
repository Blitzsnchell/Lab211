/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Inputter;
import java.util.ArrayList;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import view.CandidateView;

/**
 *
 * @author Admin
 */
public class CandidateHandler {

    CandidateView candidateView = new CandidateView();
    Inputter inputter = new Inputter();
    ArrayList<Candidate> candidateList = new ArrayList<>();

    public void handleCandidate() {
        while (true) {
            candidateView.displayMenu();
            int choice = inputter.getInt("Choose: ", 1, 5);
            switch (choice) {
                case 1:
                    createCandidate(0);
                    break;
                case 2:
                    createCandidate(1);
                    break;
                case 3:
                    createCandidate(2);
                    break;
                case 4:
                    if (candidateList.isEmpty()) {
                        inputter.displayErr("Candidate list is empty!");
                    } else {
                        searchCandidate();
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void createCandidate(int type) {
        while (true) {
            String id = inputter.getString("Enter candidate ID: ");
            
            if (!inputter.checkIdExist(candidateList, id)) {
                Candidate candidate = candidateView.inputCandidate(id);
                switch (type) {
                    case 0:
                        Experience experience = candidateView.inputExperience(candidate);
                        candidateList.add(experience);
                        inputter.displayNotice("Create Experience candidate successfully!");
                        break;
                    case 1:
                        Fresher fresher = candidateView.inputFresher(candidate);
                        candidateList.add(fresher);
                        inputter.displayNotice("Create Fresher candidate successfully!");
                        break;
                    case 2:
                        Internship internship = candidateView.inputInternship(candidate);
                        candidateList.add(internship);
                        inputter.displayNotice("Create Internship candidate successfully!");
                        break;
                }
            } else {
                return;
            }
            
            if (!inputter.getYN()) {
                return;
            }
        }
    }

    private void searchCandidate() {
        candidateView.displayListNameCandidate(candidateList);
        String nameSearch = inputter.getString("Enter andidate name (First name or Last name): ");
        int typeCandidate = inputter.getInt("Enter type of candidate: 0-Experience, 1-Fresher,2-Internship: ", 0, 2);
        ArrayList<Candidate> searchedCan = new ArrayList<>();
        
        for (Candidate candidate : candidateList) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && (candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch))) {
                searchedCan.add(candidate);
            }
        }
        
        if (searchedCan.isEmpty()) {
            inputter.displayErr("Don't have any Candidate with inputted name");
        } else {
            for (Candidate candidate : searchedCan) {
                candidateView.displayCandidate(candidate);
            }
        }
    }
}
