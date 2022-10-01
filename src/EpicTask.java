import java.util.List;

public class EpicTask extends Task {
    private final List<SubTask> subTasks;
    Manager manager = new Manager();
    EpicTask(String titleEpicTask, String descriptionEpicTask, List<SubTask> subTasks) {
        super(titleEpicTask, descriptionEpicTask);
        this.setStatus(manager.getEpicTaskStatus(subTasks));
        this.subTasks = subTasks;
    }

    EpicTask(EpicTask epicTask) {
        this(epicTask.getTitle(), epicTask.getDescription(), epicTask.subTasks);
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
