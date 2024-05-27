public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");

        Epic epic1 = new Epic("Epic 1", "Description 1");
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addEpic(epic1);

        Subtask subtask1 = new Subtask("Subtask 1", "Description 1", epic1.getId());
        Subtask subtask2 = new Subtask("Subtask 2", "Description 2", epic1.getId());
        manager.addSubtask(subtask1);
        manager.addSubtask(subtask2);

        System.out.println("All tasks:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task.getTitle() + " - " + task.getStatus());
        }

        System.out.println("All epics:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic.getTitle() + " - " + epic.getStatus());
        }

        System.out.println("All subtasks:");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask.getTitle() + " - " + subtask.getStatus());
        }

        // Updating status
        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);

        subtask2.setStatus(Status.DONE);
        manager.updateSubtask(subtask2);

        System.out.println("Epic status after subtasks are done:");
        System.out.println(epic1.getTitle() + " - " + epic1.getStatus());
    }
}