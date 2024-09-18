class PriorityTask extends Task {
    private int priority;

    public PriorityTask(String description, int priority) {
        super(description);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}


