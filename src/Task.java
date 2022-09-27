import java.io.BufferedReader;
import java.io.File;
public class Task {
    private final int id;
    private final String name;
    private final String description;
    private String status;

    Task(String nameTask, String descriptionTask, String statusTask) {
        this.id = Manager.getId() + 1;
        Manager.setId(this.id);
        this.name = nameTask;
        this.description = descriptionTask;
        this.status = statusTask;
    }
    Task(String nameTask, String descriptionTask) {
        this.id = Manager.getId() + 1;
        Manager.setId(this.id);
        this.name = nameTask;
        this.description = descriptionTask;
    }
    Task(Task task) {
        this(task.name, task.description, task.status);
    }
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    String getDescription() {
        return description;
    }
    String getStatus() {
        return status;
    }
    void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "ID задачи Task=\"" + id + "\", Название задачи=\"" + name + "\", Описание=\"" + description
                + "\", Статус=\"" + status + "\"";
    }
}

