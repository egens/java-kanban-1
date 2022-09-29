public class SubTask extends Task {
    private final String titleEpicTask;

    SubTask(String titleEpicTask, String nameSubTask, String descriptionSubTask, String statusSubTask) {
        super(nameSubTask, descriptionSubTask, statusSubTask);
        this.titleEpicTask = titleEpicTask;
    }

    SubTask(SubTask subtask) {
        this(subtask.titleEpicTask, subtask.getTitle(), subtask.getDescription(), subtask.getStatus());
    }

    @Override
    public String toString() {
        return "ID подзадачи SubTask = " + getId() + "," + "\nНазвание Epic задачи = " + titleEpicTask
                + ", " + "\nНазвание подзадачи = " + getTitle() + ", " + "\nОписание = " + getDescription() + ", "
                +  "\nСтатус = " + getStatus() + "\n";
    }
}

