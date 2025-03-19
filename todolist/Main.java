public class Main {

    public static void main(String[] args) {
        ToDoList myToDoList = new ToDoList();

        myToDoList.addTask("ir ao médico");
        myToDoList.addTask("fazer trabalho de APS");
        myToDoList.addTask("começar projetinho java");

        myToDoList.showActiveTasks();

        myToDoList.inactivateTask(2);

        myToDoList.addTask("estudar banco de dados relacional");

        myToDoList.showActiveTasks();

        myToDoList.showTasksLog();

        myToDoList.clearActiveTasks();

        myToDoList.showActiveTasks();


    }
}

//ToDoList operations:
// addTask
// inactivateTask
// showActiveTasks
// showTasksLog
// clearActiveTasks