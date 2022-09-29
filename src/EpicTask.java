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
        return "ID задачи Epic= " + getId() + ", Название Epic задачи= " + getTitle() + ", Описание= " + getDescription()
                + ", " + subTasks + ", Статус= " + getStatus();
    }
    static class SubTask extends Task {
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
            return "ID подзадачи SubTask= " + getId() + ", Название Epic задачи= " + titleEpicTask
                    + ", Название подзадачи= " + getTitle() + ", Описание= " + getDescription() + ", Статус= " + getStatus();
        }
    }
}