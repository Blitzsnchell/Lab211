package Manager;

import Entity.History;
import Entity.Worker;
import java.util.ArrayList;

public class WorkerManager {
    private ArrayList<Worker> lstWorker;
    private ArrayList<History> lstHistory;

    public WorkerManager() {
        lstWorker = new ArrayList<>();
        lstHistory = new ArrayList<>();
    }

    public ArrayList<Worker> getLstWorker() {
        return lstWorker;
    }

    public ArrayList<History> getLstHistory() {
        return lstHistory;
    }

    // Thêm worker vào danh sách
    public boolean addWorker(Worker worker) {
        // Kiểm tra xem worker đã tồn tại chưa
        for (Worker w : lstWorker) {
            if (w.getId().equalsIgnoreCase(worker.getId())) {
                return false; // Trùng ID
            }
        }
        lstWorker.add(worker);
        return true;
    }

    // Tìm worker theo ID
    public Worker findWorkerById(String id) {
        for (Worker worker : lstWorker) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    // Cập nhật lương của worker và thêm vào history
    public boolean updateSalary(Worker worker, int newSalary, String status, String date) {
        if (worker == null) return false;
        worker.setSalary(newSalary);
        lstHistory.add(new History(status, date, worker.getId(), worker.getName(), worker.getAge(), newSalary, worker.getWorkLocation()));
        return true;
    }
    public void printHistory(Entity.History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
