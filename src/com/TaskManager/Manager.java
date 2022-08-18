package com.TaskManager;

import com.TaskManager.Formats.FomatCSV;

import java.util.Date;
import java.util.UUID;

public class Manager {
    public static void main(String[] args) {

        AuthorList al = new AuthorList();
        TaskList tl = new TaskList();

        al.add("Ivan", "Ivanov");
        al.add("Pyotr", "Petrov");

        UUID IvanIivanov = al.getAuthor("Ivan", "Ivanov");
        tl.add(new Task(IvanIivanov, "Very important task", new Date(), Priority.HIGH));
        tl.add(new Task(IvanIivanov, "Just task", new Date(), Priority.MIDDLE));
        tl.add(new Task(IvanIivanov, "No important task", new Date(), Priority.LOW));

        tl.exportTasks("src/com/TaskManager/tryExport", new FomatCSV());
        tl.importTasks("src/com/TaskManager/tryExport", new FomatCSV());
    }
}
