import java.util.List;

    interface ToDoList {
        void addTask(Task task);
        void removeTask(Task task);
        void markTaskComplete(Task task);
        List<Task> getTasks();
        List<Task> getCompletedTasks();
        List<Task> getPendingTasks();
    }
