import java.util.ArrayList;
import java.util.List;

class ToDoListImplementation implements ToDoList {
        private List<Task> tasks;

        public ToDoListImplementation() {
            this.tasks = new ArrayList<>();
        }

        @Override
        public void addTask(Task task) {
            tasks.add(task);
        }

        @Override
        public void removeTask(Task task) {
            tasks.remove(task);
        }

        @Override
        public void markTaskComplete(Task task) {
            task.setCompleted(true);
        }

        @Override
        public List<Task> getTasks() {
            return tasks;
        }

        @Override
        public List<Task> getCompletedTasks() {
            List<Task> completedTasks = new ArrayList<>();
            for (int i = 0; i < tasks.size(); i++){
                Task task = tasks.get(i);
                if (task.isCompleted()) {
                    completedTasks.add(task);
                }
            }
            return completedTasks;
        }

        @Override
        public List<Task> getPendingTasks() {
            List<Task> pendingTasks = new ArrayList<>();
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                if (!task.isCompleted()) {
                    pendingTasks.add(task);
                }
            }
            return pendingTasks;
        }
    }
