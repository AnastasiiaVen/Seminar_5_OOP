package com.TaskManager;

import com.TaskManager.Formats.TextFormat;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList = null;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public void importTasks(String path, @NotNull TextFormat format) {
        taskList.addAll(format.importFrom(path));
    }

    public void exportTasks(String path, @NotNull TextFormat format) {
        format.exportAs(taskList, path);
    }

}
