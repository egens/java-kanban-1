public class SubTask extends Task {
    private final int id;

    SubTask(int id, String nameSubTask, String descriptionSubTask, String statusSubTask) {
        super(nameSubTask, descriptionSubTask, statusSubTask);
        this.id = id;
    }

    SubTask(SubTask subtask) {
        this(subtask.id, subtask.getTitle(), subtask.getDescription(), subtask.getStatus());
    }

    @Override
    public String toString() {
        return "ID подзадачи SubTask = " + id + "," + "\nID Epic задачи = " + getId()
                + ", " + "\nНазвание подзадачи = " + getTitle() + ", " + "\nОписание = " + getDescription() + ", "
                +  "\nСтатус = " + getStatus() + "\n";
    }
}

