import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private static int Id = 0;
    private final HashMap<Integer, Task> taskStorage = new HashMap<>();
    private final HashMap<Integer, EpicTask> epicTaskStorage = new HashMap<>();
    private final HashMap<Integer, EpicTask.SubTask> subTaskStorage = new HashMap<>();
    static int getId() {
        return Id;
    }
    static void setId(int id) {
        Id = id;
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

    void saveToStorage(Object object) {
        switch (object.getClass().toString()) {
            case "class Task": {
                taskStorage.put(((Task) object).getId(), (Task) object);
                break;
            }
            case "class EpicTask": {
                epicTaskStorage.put(((EpicTask) object).getId(), (EpicTask) object);
                break;
            }
            case "class EpicTask$SubTask": {
                subTaskStorage.put(((EpicTask.SubTask) object).getId(), (EpicTask.SubTask) object);
                break;
            }
        }
    }

    ArrayList<Object> getCompleteListOfAnyTasks(HashMap<Integer, ? extends Task> treeMap) {
        ArrayList<Object> completeListOfAnyTasks = new ArrayList<>();

        for (Integer key : treeMap.keySet()) {
            completeListOfAnyTasks.add(treeMap.get(key));
        }
        return completeListOfAnyTasks;
    }

    void deleteAllTasksOfAnyType(HashMap<Integer, ? extends Task> treeMap) {
        treeMap.clear();
    }

    Object getTaskOfAnyTypeById(int id) {
        Object taskOfAnyKind = null;

        if (taskStorage.get(id) != null) {
            taskOfAnyKind = taskStorage.get(id);
        } else if (epicTaskStorage.get(id) != null) {
            taskOfAnyKind = epicTaskStorage.get(id);
        } else if (subTaskStorage.get(id) != null) {
            taskOfAnyKind = subTaskStorage.get(id);
        }
        return taskOfAnyKind;
    }

    Object createCopyOfTaskOfAnyType(Object object) {
        switch (object.getClass().toString()) {
            case "class Task": {
                return new Task((Task) object);
            }
            case "class EpicTask$SubTask": {
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
            case "class EpicTask$SubTask": {
                subTaskStorage.put(id, (EpicTask.SubTask) object);
                break;
            }
        }
    }

    void removeTaskOfAnyTypeById(int id) {
        for (Integer task : taskStorage.keySet()) {
            if (id == task) {
                taskStorage.remove(id);
                break;
            }
        }
        for (Integer epicTask : epicTaskStorage.keySet()) {
            if (id == epicTask) {
                epicTaskStorage.remove(id);
                break;
            }
        }
        for (Integer subTask : subTaskStorage.keySet()) {
            if (id == subTask) {
                subTaskStorage.remove(id);
                break;
            }
        }
    }

    ArrayList<EpicTask.SubTask> getCompleteListOfSubTaskByEpicTask(EpicTask epicTask) {
        return epicTask.getSubTasks();
    }

    static String getEpicTaskStatus(ArrayList<EpicTask.SubTask> subTasks) {
        String statusEpicTask;
        int newCount = 0;
        int doneCount = 0;

        for (EpicTask.SubTask subTask : subTasks) {
            if (subTask.getStatus().equalsIgnoreCase("NEW")) {
                newCount++;
            }
            if (!subTask.getStatus().equalsIgnoreCase("DONE")) {
                doneCount++;
            }
        }

        if ((subTasks.isEmpty()) || (newCount == subTasks.size())) {
            statusEpicTask = "NEW";
        } else if (doneCount == subTasks.size()) {
            statusEpicTask = "DONE";
        } else {
            statusEpicTask = "IN_PROGRESS";
        }
        return statusEpicTask;
    }
}