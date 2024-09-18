import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ToDoListApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField taskField;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private ToDoList toDoList;

    public ToDoListApp() {
        super("To-Do List");

        toDoList = new ToDoListImplementation();
        listModel = new DefaultListModel<>();

        taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");
        JButton completeButton = new JButton("Mark Complete");
        JButton showPendingButton = new JButton("Show Pending");
        JButton showCompletedButton = new JButton("Show Completed");
        JButton GetAllButton = new JButton("Get All Tasks");
        taskList = new JList<>(listModel);

       
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        completeButton.addActionListener(this);
        showPendingButton.addActionListener(this);
        showCompletedButton.addActionListener(this);
        GetAllButton.addActionListener(this);
        
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(completeButton);
        inputPanel.add(showPendingButton);
        inputPanel.add(showCompletedButton);
        inputPanel.add(GetAllButton);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
        pack();
        setVisible(true);
    }

   @Override
public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    
    if ("Add Task".equals(command)) {
        addTask();
    } else if ("Remove Task".equals(command)) {
        removeSelectedTask();
    } else if ("Mark Complete".equals(command)) {
        markSelectedTaskComplete();
    } else if ("Show Pending".equals(command)) {
        showPendingTasks();
    } else if ("Show Completed".equals(command)) {
        showCompletedTasks();
    }else if ("Get All Tasks" . equals(command)){
        showAllTasks();
    }
}

    private void addTask() {
        String taskDescription = taskField.getText();
        if (!taskDescription.isEmpty()) {

        	String priorityLevel=JOptionPane.showInputDialog("Enter priority level ( 1 -High, 2 - Medium, 3 - Low ): ");
        	int priority=Integer.parseInt(priorityLevel);
        	
            Task task = new Task(taskDescription);

            
            PriorityTask pr=new PriorityTask(taskDescription,priority);

          
            toDoList.addTask(task);
            

            listModel.addElement(pr.getDescription()+"(Priority: "+ priority + ")" );
            
            
            taskField.setText("");
        }
    }
   
    private void removeSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = toDoList.getTasks().get(selectedIndex);
            toDoList.removeTask(task);
            listModel.remove(selectedIndex);
        }
    }
    
   private void showAllTasks() {
    listModel.clear();
    for (int i = 0; i < toDoList.getTasks().size(); i++) {
        Task task = toDoList.getTasks().get(i);
        listModel.addElement(task.getDescription());
    	}
   }

    private void markSelectedTaskComplete() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = toDoList.getTasks().get(selectedIndex);
            task.setCompleted(true);
            toDoList.markTaskComplete(task);
            listModel.set(selectedIndex, "[Completed] " + task.getDescription());
        }
    }
   
    private void showPendingTasks() {
        listModel.clear();
        for (Task task : toDoList.getPendingTasks()) {
            listModel.addElement(task.getDescription());
        }
    }

   
    private void showCompletedTasks() {
        listModel.clear();
        for (Task task : toDoList.getCompletedTasks()) {
            listModel.addElement("[Completed] " + task.getDescription());
        }
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}
