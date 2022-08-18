package com.TaskManager.Formats;

import com.TaskManager.Priority;
import com.TaskManager.Status;
import com.TaskManager.Task;
import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class FomatCSV extends TextFormat {
    @Override
    public void exportAs(@NotNull ArrayList<Task> tasks, String path) {
        try (FileWriter writer = new FileWriter(path + ".csv", false)) {
            for (Task task : tasks) {
                StringBuilder sb = new StringBuilder();
                sb.append(task.getTaskID()).append(";")
                        .append(task.getAuthorID()).append(";")
                        .append(task.getTaskContent()).append(";")
                        .append(task.getAddingDate()).append(";")
                        .append(task.getDeadline()).append(";")
                        .append(task.getDateOfCompletion()).append(";")
                        .append(task.getPriority()).append(";")
                        .append(task.getStatus()).append("\n");
                writer.write(sb.toString());
            }
            writer.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Task> importFrom(String path) {
        ArrayList<Task> tasks = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        try (FileReader reader = new FileReader(path + ".csv")) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                tasks.add(new Task(UUID.fromString(line[0]), UUID.fromString(line[1]),
                        line[2], formatter.parse(line[3]), formatter.parse(line[4]), formatter.parse(line[5]),
                        Priority.valueOf(line[6]), Status.valueOf(line[7])));
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
