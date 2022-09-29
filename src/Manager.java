import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private static int id = 0;
    private final HashMap<Integer, Task> taskStorage = new HashMap<>();
    private final HashMap<Integer, EpicTask> epicTaskStorage = new HashMap<>();
    private final HashMap<Integer, SubTask> subTaskStorage = new HashMap<>();
    static int getId() {
        return id;
    }
    static void setId(int newId) {
        id = newId;
    }

    HashMap<Integer, Task> getTaskStorage() {
        return taskStorage;
    }
    HashMap<Integer, EpicTask> getEpicTaskStorage() {
        return epicTaskStorage;
    }
    HashMap<Integer, SubTask> getSubTaskStorage() {
        return subTaskStorage;
    }
    static String getEpicTaskStatus(ArrayList<SubTask> subTasks) {
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


    ArrayList<Object> getReadyListOfTasks(HashMap<Integer, ? extends Task> hashMap) {
        ArrayList<Object> completeListOfTasks = new ArrayList<>();

        for (Integer key : hashMap.keySet()) {
            completeListOfTasks.add(hashMap.get(key));
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

    void updateTaskOfType(int id, Object object) {
        switch (object.getClass().toString()) {
            case "Task": {
                taskStorage.put(id, (EpicTask) object);
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
    void saveStorage(Object object) {
        switch (object.getClass().toString()) {
            case "Task": {
                taskStorage.put(((Task) object).getId(), (Task) object);
                break;
            }
            case "EpicTask": {
                epicTaskStorage.put(((EpicTask) object).getId(), (EpicTask) object);
                break;
            }
            case "SubTask": {
                subTaskStorage.put(((SubTask) object).getId(), (SubTask) object);
                break;
            }
        }
    }

    ArrayList<SubTask> getCompleteListOfSubTaskByEpicTask(EpicTask epicTask) {
        return epicTask.getSubTasks();
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
    void deleteAllTasks(HashMap<Integer, ? extends Task> hashMap) {
        hashMap.clear();
    }
}
