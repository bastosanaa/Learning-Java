
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ToDoList {
    ArrayList<Task> tasks;
    int tasksCount;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.tasksCount = 0;
    }

    private List<Task> getActiveTasks(){
        return this.tasks.stream()
                .filter(task -> task.active)
                .toList();
    }

    public void addTask(String taskDescription) {
        Task newTask = new Task(taskDescription, this.tasksCount);
        this.tasks.add(newTask);
        System.out.println("Nova task adicionada: " + taskDescription);
        this.tasksCount++;
    }

    public void inactivateTask(int taskNumber) {
        System.out.println(" ");

        List<Task> activeTasks = this.getActiveTasks();

        activeTasks.stream()
                .filter(task -> task.taskNumber == taskNumber)
                .findFirst()
                .ifPresentOrElse(
                       task -> {
                           task.inactivate();
                           System.out.println("A task de número " + taskNumber + " foi desativada com sucesso!" );
                       },
                        () -> System.out.println("❌Erro: A task de número " + taskNumber + " não existe ou já foi desativada ❌")
                );
    }

    public void showTasksLog() {
        System.out.println(" ");
        System.out.println("=== Logs de tarefas ===");

        tasks.forEach(task -> {
            String taskStatus = task.active ? "Ativa" : "Inativa";
            System.out.println("Tarefa " + task.taskNumber + ": " + task.description + "| status: " + taskStatus);

        });
    }

    public void showActiveTasks() {
        System.out.println(" ");
        System.out.println("=== Lista de tarefas ativas: ===");

        List<Task> activeTasks = this.getActiveTasks();
        if(activeTasks.size() > 0) {
            activeTasks.forEach(task -> {
                System.out.println("Tarefa " + task.taskNumber + ": " + task.description);
            });
        } else {
            System.out.println("Sem tarefas ativas :(");
        }

    }


    public void clearActiveTasks() {
        int count = 0;
        int maxCount = this.tasks.size();

        while(count < maxCount) {
            tasks.get(count).inactivate();
            count ++;
        }

        System.out.println(" ");
        System.out.println("Lista de tarefas ativas limpa com sucesso!");
    }
}

class Task {
    String description;
    int taskNumber;
    boolean active;

    public Task(String description, int taskNumber) {
        this.description = description;
        this.taskNumber = taskNumber;
        active = true;
    }

    public void editDescription(String newDescription) {
        this.description = newDescription;
    }

    public void inactivate() {
        this.active = false;
    }

}
