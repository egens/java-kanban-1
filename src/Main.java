    /*
    Добрый день, Андрей! Прошу прощения за то, что отправлял Вам практически одинаковые работы, тем самым занимал Ваше драгоценное время.
    В этот раз надеюсь, что у меня получилось исправить работу и Вы пропустите меня на следующий спринт. Очень на это надеюсь.
     */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();

        Task firstTask = new Task("Выпонить задание в ЯП","Опираясь на лекцию, выполнить задание", "NEW");
        manager.saveStorage(firstTask);
        Task secondTask = new Task("Помыться","Сходить в душ", "DONE");
        manager.saveStorage(secondTask);
        ArrayList<SubTask> firstSubTaskEpicTask = new ArrayList<>();
        SubTask firstSubtaskFirstEpicTask = new SubTask("Выполнить ТЗ",
                "", "Выполнить ТЗ", "NEW");

        SubTask secondSubtaskFirstEpicTask = new SubTask("Закончить учебу",
                "Сделать дипломный проект", "Защитить дипломный проект", "DONE");

        firstSubTaskEpicTask.add(firstSubtaskFirstEpicTask);
        firstSubTaskEpicTask.add(secondSubtaskFirstEpicTask);
        manager.saveStorage(firstSubtaskFirstEpicTask);



        EpicTask firstEpicTask = new EpicTask("Закончить учебу",
                "Получить сертификат обучения", firstSubTaskEpicTask);
        manager.saveStorage(firstEpicTask);

        SubTask secondSubTaskFirstEpicTask = new SubTask("Сменить работу",
                "Закончить курс по Java","Научиться программировать на языке Java",
                "NEW");
        ArrayList<SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskSecond.add(secondSubTaskFirstEpicTask);
        manager.saveStorage(secondSubTaskFirstEpicTask);

        EpicTask secondEpicTask = new EpicTask("Найти работу","Устроиться на должности Junior-Java", subTasksEpicTaskSecond);
        manager.saveStorage(secondEpicTask);
        System.out.println("2.1 Получение списка всех задач:");
        System.out.println(manager.getReadyListOfTasks(manager.getTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getEpicTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getSubTaskStorage()));

        manager.deleteAllTasks(manager.getEpicTaskStorage());

        System.out.println("2.2 Удаление всех задач:");
        System.out.println(manager.getReadyListOfTasks(manager.getTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getEpicTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getSubTaskStorage()));

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
        System.out.println(manager.createCopyTaskOfType(firstTask));
        System.out.println(manager.createCopyTaskOfType(firstEpicTask));
        System.out.println(manager.createCopyTaskOfType(firstSubTaskEpicTask));

        manager.updateTaskOfType(5, firstEpicTask);
        manager.updateTaskOfType(7, secondEpicTask);

        System.out.println("2.5 Обновление. Новая версия объекта с верным идентификатором передаются в виде"
                + " параметра:");
        System.out.println(manager.getReadyListOfTasks(manager.getEpicTaskStorage()));

        manager.removeTaskById(1);
        manager.removeTaskById(2);

        System.out.println("2.6 Удаление по идентификатору:");
        System.out.println(manager.getReadyListOfTasks(manager.getTaskStorage()));

        System.out.println("3.1 Получение списка всех подзадач определённого эпика:");
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(firstEpicTask));
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(secondEpicTask));
    }
}
