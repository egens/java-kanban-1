public class Task {
    private final int id;
    private String title;
    private String description;
    private String status;
    Manager manager = new Manager();
    Task(String titleTask, String descriptionTask, String statusTask) {
        this.id = manager.getId() + 1;
        manager.setId(this.id);
        this.title = titleTask;
        this.description = descriptionTask;
        this.status = statusTask;
    }

    Task(String titleTask, String descriptionTask) {
        this.id = manager.getId() + 1;
        manager.setId(this.id);
        this.title = titleTask;
        this.description = descriptionTask;
    }

    Task(Task task) {
        this(task.title, task.description, task.status);
    }

    int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }


    public String toString() {
        return "ID задачи Task = " + id + ", " + "\nНазвание задачи = " + title + ",\nОписание = " + description
                + ", " + "\nСтатус = " + status + "\n";
    }
}
