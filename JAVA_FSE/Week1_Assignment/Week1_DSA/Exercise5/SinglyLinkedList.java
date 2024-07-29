package Exercise5;

public class SinglyLinkedList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public void deleteTask(String taskId) {
        if (head == null) {
            return;
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        taskList.addTask(new Task("T001", "Task 1", "Pending"));
        taskList.addTask(new Task("T002", "Task 2", "Completed"));
        taskList.addTask(new Task("T003", "Task 3", "In Progress"));

        System.out.println("All tasks:");
        taskList.traverseTasks();

        System.out.println("Search for task T002:");
        System.out.println(taskList.searchTask("T002"));

        System.out.println("Delete task T002:");
        taskList.deleteTask("T002");

        System.out.println("All tasks after deletion:");
        taskList.traverseTasks();
    }
}

