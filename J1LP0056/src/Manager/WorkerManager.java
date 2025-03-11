/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.History;
import Entity.Worker;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fpt
 */
public class WorkerManager {
    private ArrayList<Worker> lstWorker;
    private ArrayList<History> lstHistory;

    public ArrayList<History> getLstHistory() {
        return lstHistory;
    }

    public void setLstHistory(ArrayList<History> lstHistory) {
        this.lstHistory = lstHistory;
    }
    

    public ArrayList<Worker> getLstWorker() {
        return lstWorker;
    }

    public void setLstWorker(ArrayList<Worker> lstWorker) {
        this.lstWorker = lstWorker;
    }

    public WorkerManager() {
        lstWorker = new ArrayList<Worker>();
        lstHistory = new ArrayList<History>();
    }

    public ArrayList<Worker> getWorkerList() {
        return new ArrayList<>(lstWorker);
    }

    public Worker findById(String WorkerID) {
        Worker Worker;
        WorkerID = WorkerID.toLowerCase().trim();
        for (int i = 0; i < lstWorker.size(); i++) {
            Worker = lstWorker.get(i);
            if (Worker.getId().toLowerCase().equals(WorkerID)) {
                return Worker;
            }
        }
        return null;
    }
    
    //get worker by code
    public Worker getWorkerByCode(String id) {
        for (Worker worker : lstWorker) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

}
