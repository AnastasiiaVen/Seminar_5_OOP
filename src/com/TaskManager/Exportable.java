package com.TaskManager;

import java.util.ArrayList;

public interface Exportable {
    public void exportAs(ArrayList<Task> tasks, String path);
}
