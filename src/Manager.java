import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private static int id = 0;
    private final HashMap<Integer, Task> taskStorage = new HashMap<>();
    private final HashMap<Integer, EpicTask> epicTaskStorage = new HashMap<>();
    private final HashMap<Integer, EpicTask.SubTask> subTaskStorage = new HashMap<>();
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
    HashMap<Integer, EpicTask.SubTask> getSubTaskStorage() {
        return subTaskStorage;
    }
    static String getEpicTaskStatus(ArrayList<EpicTask.SubTask> subTasks) {
        String saveStatusEpicTask;
        int newCount = 0;
        int doneCount = 0;

        for (EpicTask.SubTask subTask : subTasks) {
            if (subTask.getStatus().equals("NEW")) {
                newCount++;
            }
            if (!subTask.getStatus().equals("DONE")) {
                doneCount++;
            }
        }

        if ((subTasks.isEmpty()) || (newCount == subTasks.size())) {
            saveStatusEpicTask = "NEW";
        } else if (doneCount == subTasks.size()) {
            saveStatusEpicTask = "DONE";
        } else {
            saveStatusEpicTask = "IN_PROGRESS";
        }
        return saveStatusEpicTask;
    }


    ArrayList<Object> getCompleteListOfTasks(HashMap<Integer, ? extends Task> hashMap) {
        ArrayList<Object> completeListOfTasks = new ArrayList<>();

        for (Integer key : hashMap.keySet()) {
            completeListOfTasks.add(hashMap.get(key));
        }
        return completeListOfTasks;
    }

    void deleteAllTasks(HashMap<Integer, ? extends Task> hashMap) {
        hashMap.clear();
    }


    Object createCopyOfTaskOfAnyType(Object object) {
        switch (object.getClass().toString()) {
            case "class Task": {
                return new Task((Task) object);
            }
            case "class EpicTaskSubTask": {
                return new EpicTask.SubTask((EpicTask.SubTask) object);
            }
            case "class EpicTask": {
                return new EpicTask((EpicTask) object);
            }
            default:
                return null;
        }
    }

    void updateTaskOfAnyType(int id, Object object) {
        switch (object.getClass().toString()) {
            case "class Task": {
                taskStorage.put(id, (Task) object);
                break;
            }
            case "class EpicTask": {
                epicTaskStorage.put(id, (EpicTask) object);
                break;
            }
            case "class EpicTaskSubTask": {
                subTaskStorage.put(id, (EpicTask.SubTask) object);
                break;
            }
        }
    }

    void removeTaskById(int newId) {
        for (Integer task : taskStorage.keySet()) {
            if (newId == task) {
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
    Object getTaskOfTypeById(int newId) {
        Object taskOfKinds = null;

        if (taskStorage.get(newId) != null) {
            taskOfKinds = taskStorage.get(newId);
        } else if (epicTaskStorage.get(newId) != null) {
            taskOfKinds = epicTaskStorage.get(newId);
        } else if (subTaskStorage.get(newId) != null) {
            taskOfKinds = subTaskStorage.get(newId);
        }
        return taskOfKinds;
    }
    void saveStorage(Object object) {
        switch (object.getClass().toString()) {
            case "class Task": {
                taskStorage.put(((Task) object).getId(), (Task) object);
                break;
            }
            case "class EpicTask": {
                epicTaskStorage.put(((EpicTask) object).getId(), (EpicTask) object);
                break;
            }
            case "class EpicTaskSubTask": {
                subTaskStorage.put(((EpicTask.SubTask) object).getId(), (EpicTask.SubTask) object);
                break;
            }
        }
    }

    ArrayList<EpicTask.SubTask> getCompleteListOfSubTaskByEpicTask(EpicTask epicTask) {
        return epicTask.getSubTasks();
    }
}