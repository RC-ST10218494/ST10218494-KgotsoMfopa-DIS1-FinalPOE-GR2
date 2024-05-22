package src.main.Java;
import java.util.List;

public class Task {
    private String taskName;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;
    private String taskID;
    private static int taskCount = 0;

    public Task(String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        taskCount++;
    }

    public static boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    private String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerFirstName + " " + developerLastName + "\n" +
               "Task Number: " + taskCount + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hrs";
    }

    public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
}
