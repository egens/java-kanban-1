    /*
    Добрый день, Андрей! Очень сильно старался всё исправить, но , к сожалению, не все получилосью :(
    Надеюсь, что эта работа сможет пройти дальше, т.к. осталось делать еще 4 спринт до конца каникул ( это уже просто мысли в слух, простите :)).
     */

import java.util.ArrayList;
;

    public class Main {
    public static void main(String[] args) {


        Manager manager = new Manager();
        Task taskFirst = new Task("Поесть","Принять пищу", "NEW");
        Task taskSecond = new Task("Поспать","Хорошенько выспаться", "DONE");

        ArrayList<SubTask> subTasksEpicTaskFirst = new ArrayList<>();
        SubTask subtaskFirstEpicTaskFirst = new SubTask( 1,
                        "Сдать все спринты", "Вовремя выполнить ТЗ", "NEW");
        SubTask subtaskSecondEpicTaskFirst = new SubTask(2,
                        "Сдать дипломный проект", "Сделать дипломный проект", "DONE");

        subTasksEpicTaskFirst.add(subtaskFirstEpicTaskFirst);
        subTasksEpicTaskFirst.add(subtaskSecondEpicTaskFirst);

        EpicTask epicTaskFirst = new EpicTask("Закончить учебу",
                        "Получить сертификат обучения", subTasksEpicTaskFirst);

        SubTask subtaskFirstEpicTaskSecond = new SubTask(3,
                        "Закончить курс по Java","Научиться программировать на языке Java",
                        "NEW");
        ArrayList<SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskSecond.add(subtaskFirstEpicTaskSecond);

        EpicTask epicTaskSecond = new EpicTask("Сменить работу"
                        ,"Начать работать Java разработчиком", subTasksEpicTaskSecond);

        manager.saveTaskStorage(taskFirst);
        manager.saveTaskStorage(taskSecond);
        manager.saveSubTaskStorage(subtaskFirstEpicTaskFirst);
        manager.saveSubTaskStorage(subtaskSecondEpicTaskFirst);
        manager.saveEpicTaskStorage(epicTaskFirst);
        manager.saveSubTaskStorage(subtaskFirstEpicTaskSecond);
        manager.saveEpicTaskStorage(epicTaskSecond);

        System.out.println("           2.1 Получение списка всех задач:");
        System.out.println(manager.getReadyListOfTasks(manager.getTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getEpicTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getSubTaskStorage()));

        manager.deleteAllTasks(manager.getEpicTaskStorage());

        System.out.println("           2.2 Удаление всех задач:");
        System.out.println(manager.getReadyListOfTasks(manager.getTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getEpicTaskStorage()));
        System.out.println(manager.getReadyListOfTasks(manager.getSubTaskStorage()));

        System.out.println("           2.3 Получение по идентификатору:");
        System.out.println(manager.getTaskOfTypeById(0));
        System.out.println(manager.getTaskOfTypeById(1));
        System.out.println(manager.getTaskOfTypeById(2));
        System.out.println(manager.getTaskOfTypeById(3));
        System.out.println(manager.getTaskOfTypeById(4));
        System.out.println(manager.getTaskOfTypeById(5));
        System.out.println(manager.getTaskOfTypeById(6));
        System.out.println(manager.getTaskOfTypeById(7));
        System.out.println(manager.getTaskOfTypeById(8));

        System.out.println("           2.4 Создание. Сам объект должен передаваться в качестве параметра:");
        System.out.println(manager.createCopyTaskOfType(taskFirst));
        System.out.println(manager.createCopyTaskOfType(epicTaskFirst));
        System.out.println(manager.createCopyTaskOfType(subtaskFirstEpicTaskFirst));

        manager.updateTaskOfType(2, epicTaskFirst);
        manager.updateTaskOfType(3, epicTaskSecond);

        System.out.println("           2.5 Обновление. Новая версия объекта с верным идентификатором передаются в виде"
                + " параметра:");
        System.out.println(manager.getReadyListOfTasks(manager.getEpicTaskStorage()));

        manager.removeTaskById(5);
        manager.removeTaskById(7);

        System.out.println("           2.6 Удаление по идентификатору:");
        System.out.println(manager.getReadyListOfTasks(manager.getTaskStorage()));

        System.out.println("           3.1 Получение списка всех подзадач определённого эпика:");
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(epicTaskFirst));
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(epicTaskSecond));
    }
}
