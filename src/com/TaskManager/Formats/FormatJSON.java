package com.TaskManager.Formats;

import com.TaskManager.Task;
import com.TaskManager.TaskList;

import java.util.ArrayList;

public class FormatJSON extends TextFormat{
    @Override
    public void exportAs(ArrayList<Task> tasks, String path) {

    }

    @Override
    public ArrayList<Task> importFrom(String path) {
        return null;
    }
}
