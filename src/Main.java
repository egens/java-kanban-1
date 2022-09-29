import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();

        Task taskFirst = new Task("Помыться","Сходить в душ", "NEW");
        Task taskSecond = new Task("Сдать спринт во время","Сделать задания в Яндекс.Практикуме и сделать задание по ТЗ без ошибок", "DONE");

        ArrayList<EpicTask.SubTask> subTasksEpicTaskFirst = new ArrayList<>();
        EpicTask.SubTask subtaskFirstEpicTaskFirst = new EpicTask.SubTask("Закончить учебу",
                "Сдать все спринты", "Выполнить ТЗ", "NEW");
        EpicTask.SubTask subtaskSecondEpicTaskFirst = new EpicTask.SubTask("Закончить учебу",
                "Сделать дипломный проект", "Защитить дипломный проект", "DONE");

        subTasksEpicTaskFirst.add(subtaskFirstEpicTaskFirst);
        subTasksEpicTaskFirst.add(subtaskSecondEpicTaskFirst);

        EpicTask epicTaskFirst = new EpicTask("Закончить учебу",
                "Получить сертификат обучения", subTasksEpicTaskFirst);

        EpicTask.SubTask subtaskFirstEpicTaskSecond = new EpicTask.SubTask("Сменить работу",
                "Закончить курс по Java","Научиться программировать на языке Java",
                "NEW");
        ArrayList<EpicTask.SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskSecond.add(subtaskFirstEpicTaskSecond);

        EpicTask epicTaskSecond = new EpicTask("Найти работу"
                ,"Устроиться на должности Junior-Java", subTasksEpicTaskSecond);

        manager.saveStorage(taskFirst);
        manager.saveStorage(taskSecond);
        manager.saveStorage(subtaskFirstEpicTaskFirst);
        manager.saveStorage(subtaskSecondEpicTaskFirst);
        manager.saveStorage(epicTaskFirst);
        manager.saveStorage(subtaskFirstEpicTaskSecond);
        manager.saveStorage(epicTaskSecond);

        System.out.println("2.1 Получение списка всех задач:");
        System.out.println(manager.getCompleteListOfTasks(manager.getTaskStorage()));
        System.out.println(manager.getCompleteListOfTasks(manager.getEpicTaskStorage()));
        System.out.println(manager.getCompleteListOfTasks(manager.getSubTaskStorage()));

        manager.deleteAllTasks(manager.getEpicTaskStorage());

        System.out.println("2.2 Удаление всех задач:");
        System.out.println(manager.getCompleteListOfTasks(manager.getTaskStorage()));
        System.out.println(manager.getCompleteListOfTasks(manager.getEpicTaskStorage()));
        System.out.println(manager.getCompleteListOfTasks(manager.getSubTaskStorage()));

        System.out.println("2.3 Получение по идентификатору:");
        System.out.println(manager.getTaskOfTypeById(0));
        System.out.println(manager.getTaskOfTypeById(1));
        System.out.println(manager.getTaskOfTypeById(2));
        System.out.println(manager.getTaskOfTypeById(3));
        System.out.println(manager.getTaskOfTypeById(4));
        System.out.println(manager.getTaskOfTypeById(5));
        System.out.println(manager.getTaskOfTypeById(6));
        System.out.println(manager.getTaskOfTypeById(7));
        System.out.println(manager.getTaskOfTypeById(8));

        System.out.println("2.4 Создание. Сам объект должен передаваться в качестве параметра:");
        System.out.println(manager.createCopyOfTaskOfAnyType(taskFirst));
        System.out.println(manager.createCopyOfTaskOfAnyType(epicTaskFirst));
        System.out.println(manager.createCopyOfTaskOfAnyType(subtaskFirstEpicTaskFirst));

        manager.updateTaskOfAnyType(5, epicTaskFirst);
        manager.updateTaskOfAnyType(7, epicTaskSecond);

        System.out.println("2.5 Обновление. Новая версия объекта с верным идентификатором передаются в виде"
                + " параметра:");
        System.out.println(manager.getCompleteListOfTasks(manager.getEpicTaskStorage()));

        manager.removeTaskById(1);
        manager.removeTaskById(2);

        System.out.println("2.6 Удаление по идентификатору:");
        System.out.println(manager.getCompleteListOfTasks(manager.getTaskStorage()));

        System.out.println("3.1 Получение списка всех подзадач определённого эпика:");
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(epicTaskFirst));
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(epicTaskSecond));
    }
}