package com.TaskManager;

import java.util.Date;
import java.util.UUID;

public class Task {
    private final UUID taskID;
    private final UUID authorID;
    private String taskContent;
    private final Date addingDate;
    private Date deadline;
    private Date dateOfCompletion;
    private Priority priority;
    private Status status;

    public Task(UUID taskID, UUID authorID, String taskContent,
                Date addingDate, Date deadline, Date dateOfCompletion,
                Priority priority, Status status) {
        this.taskID = taskID;
        this.authorID = authorID;
        this.taskContent = taskContent;
        this.addingDate = addingDate;
        this.deadline = deadline;
        this.dateOfCompletion = dateOfCompletion;
        this.priority = priority;
        this.status = status;
    }

    public Task(UUID authorID, String taskContent, Date deadline, Priority priority) {
        this(UUID.randomUUID(), authorID, taskContent, new Date(),
                deadline, null, priority, Status.AWAIT);
    }

    public UUID getTaskID() {
        return taskID;
    }

    public UUID getAuthorID() {
        return authorID;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getDateOfCompletion() {
        return dateOfCompletion;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setDateOfCompletion(Date dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
