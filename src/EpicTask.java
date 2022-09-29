import java.util.ArrayList;

public class EpicTask extends Task {
    private final ArrayList<SubTask> subTasks;

    EpicTask(String titleEpicTask, String descriptionEpicTask, ArrayList<SubTask> subTasks) {
        super(titleEpicTask, descriptionEpicTask);
        this.setStatus(Manager.getEpicTaskStatus(subTasks));
        this.subTasks = subTasks;
    }

    EpicTask(EpicTask epicTask) {
        this(epicTask.getTitle(), epicTask.getDescription(), epicTask.subTasks);
    }

    ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "ID задачи Epic = " + getId() + ", " + "\nНазвание Epic задачи = " + getTitle() + ",\nОписание = " + getDescription()
                + ", " + subTasks + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}
