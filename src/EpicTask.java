import java.util.ArrayList;
import java.util.List;

class EpicTask extends Task {
    private final List<SubTask> subTasks;
    Manager manager = new Manager();

    EpicTask(String titleEpicTask, String descriptionEpicTask, ArrayList<SubTask> subTasks) {
        super(titleEpicTask, descriptionEpicTask);
        this.setStatus(manager.getEpicTaskStatus(subTasks));
        this.subTasks = subTasks;
    }

    EpicTask(EpicTask epicTask) {
        this(epicTask.getTitle(), epicTask.getDescription(), (ArrayList<SubTask>) epicTask.subTasks);
    }

    List<SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "ID задачи Epic = " + getId() + ", " + "\nНазвание Epic задачи = " + getTitle() + ",\nОписание = " + getDescription()
                + ", " + subTasks + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}
