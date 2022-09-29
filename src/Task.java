public class Task {
    private final int id;
    private final String title;
    private final String description;
    private String status;

    Task(String titleTask, String descriptionTask, String statusTask) {
        this.id = Manager.getId() + 1;
        Manager.setId(this.id);
        this.title = titleTask;
        this.description = descriptionTask;
        this.status = statusTask;
    }
    Task(String titleTask, String descriptionTask) {
        this.id = Manager.getId() + 1;
        Manager.setId(this.id);
        this.title = titleTask;
        this.description = descriptionTask;
    }
    Task(Task task) {
        this(task.title, task.description, task.status);
    }
    int getId() {
        return id;
    }
    String getTitle() {
        return title;
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
        return "ID задачи Task= " + id + ", Название задачи= " + title + ", Описание= " + description
                + ", Статус= " + status;
    }
}

