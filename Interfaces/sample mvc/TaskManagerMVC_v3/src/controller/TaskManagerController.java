/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.taskManager.Task;
import model.taskManager.TaskList;
import view.taskManager.TaskManagerJDialog;

/**
 *
 * @author dides
 */
public class TaskManagerController {

    private final TaskList taskModel;
    private final TaskManagerJDialog taskView;

    public TaskManagerController(TaskList taskModel, TaskManagerJDialog taskView) {
        this.taskModel = taskModel;
        this.taskView = taskView;
        this.taskView.addButtonActionListener(this.AddTaskListener());
        this.updateTaskListView();
    }

    private ActionListener AddTaskListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add");
                String description = taskView.getTaskDescription();
                if (!description.isEmpty()) {
                    Task task = new Task(description);
                    taskModel.addTask(task);
                    updateTaskListView();
                }
            }
        };
        return al;
    }

    private void updateTaskListView() {
        List<Task> tasks = taskModel.getTasks();
        List<String> taskList = new ArrayList<String>();
        for (Task t : tasks) {
            taskList.add(t.getDescription());
        }
        taskView.updateTaskList(taskList);
    }

}
