import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Manager {


    private int id = 0;
    private final Map<Integer, Task> taskStorage = new HashMap<>();
    private final Map<Integer, EpicTask> epicTaskStorage = new HashMap<>();
    private final Map<Integer, SubTask> subTaskStorage = new HashMap<>();
    void setId(int id) {
        this.id = id;
    }
    int getId() {
        return id;
    }

    Map<Integer, Task> getTaskStorage() {
        return taskStorage;
    }
    Map<Integer, EpicTask> getEpicTaskStorage() {
        return epicTaskStorage;
    }
    Map<Integer, SubTask> getSubTaskStorage() {
        return subTaskStorage;
    }

    String getEpicTaskStatus(List<SubTask> subTasks) {
        String saveEpicTaskStatus;
        int newCount = 0;
        int doneCount = 0;

        for (SubTask subTask : subTasks) {
            if (subTask.getStatus().equals("NEW")) {
                newCount++;
            }
            if (!subTask.getStatus().equals("DONE")) {
                doneCount++;
            }
        }

        if ((subTasks.isEmpty()) || (newCount == subTasks.size())) {
            saveEpicTaskStatus = "NEW";
        } else if (doneCount == subTasks.size()) {
            saveEpicTaskStatus = "DONE";
        } else {
            saveEpicTaskStatus = "IN_PROGRESS";
        }
        return saveEpicTaskStatus;
    }


    List<Object> getReadyListOfTasks(Map<Integer, ? extends Task> map) {
        List<Object> completeListOfTasks = new ArrayList<>();

        for (Integer key : map.keySet()) {
            completeListOfTasks.add(map.get(key));
        }
        return completeListOfTasks;
    }

    Object createCopyTaskOfType(Object object) {
        switch (object.getClass().toString()) {
            case "Task": {
                return new Task((Task) object);
            }
            case "SubTask": {
                return new SubTask((SubTask) object);
            }
            case "EpicTask": {
                return new EpicTask((EpicTask) object);
            }
            default:
                return null;
        }
    }

    void saveTaskStorage(Object object){
        taskStorage.put(((Task) object).getId(), (Task) object);
    }

    void saveEpicTaskStorage(Object object){
        epicTaskStorage.put(((EpicTask) object).getId(), (EpicTask) object);
    }

    void saveSubTaskStorage(Object object){
        subTaskStorage.put(((SubTask) object).getId(), (SubTask) object);
    }

    void updateTaskOfType(int id, Object object) {
        switch (object.getClass().toString()) {
            case "Task": {
                taskStorage.put(id, (Task) object);
                break;
            }
            case "EpicTask": {
                epicTaskStorage.put(id, (EpicTask) object);
                break;
            }
            case "SubTask": {
                subTaskStorage.put(id, (SubTask) object);
                break;
            }
        }
    }

    Object getTaskOfTypeById(int newId) {
        Object kindTask = null;

        if (taskStorage.get(newId) != null) {
            kindTask = taskStorage.get(newId);
        } else if (epicTaskStorage.get(newId) != null) {
            kindTask = epicTaskStorage.get(newId);
        } else if (subTaskStorage.get(newId) != null) {
            kindTask = subTaskStorage.get(newId);
        }
        return kindTask;
    }



    ArrayList<SubTask> getCompleteListOfSubTaskByEpicTask(EpicTask epicTask) {
        return (ArrayList<SubTask>) epicTask.getSubTasks();
    }
    void removeTaskById(int newId) {
        for (Integer tasks : taskStorage.keySet()) {
            if (newId == tasks) {
                taskStorage.remove(newId);
                break;
            }
        }
        for (Integer epicTask : epicTaskStorage.keySet()) {
            if (newId == epicTask) {
                epicTaskStorage.remove(newId);
                break;
            }
        }
        for (Integer subTask : subTaskStorage.keySet()) {
            if (newId == subTask) {
                subTaskStorage.remove(newId);
                break;
            }
        }
    }
    void deleteAllTasks(Map<Integer, ? extends Task> map) {
        map.clear();
    }
}
