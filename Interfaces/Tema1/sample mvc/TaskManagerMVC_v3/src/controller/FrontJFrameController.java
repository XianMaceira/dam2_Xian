/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.taskManager.TaskList;
import view.MainJFrame;
import view.taskManager.TaskManagerJDialog;

/**
 *
 * @author dides
 */
public class caFrontJFrameController {

    private MainJFrame view;
    private TaskList taskListModel;

    public FrontJFrameController(MainJFrame view, TaskList taskListModel) {
        this.view = view;
        this.taskListModel = taskListModel;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setTaskManagerMenuItemListener(this.setTaskManagerMenuItemActionListener());
    }

    private ActionListener setQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }

    private ActionListener setTaskManagerMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskManagerJDialog tm = new TaskManagerJDialog(view, true);
                TaskManagerController tmc = new TaskManagerController(taskListModel, tm);
                tm.setVisible(true);
            }   

        };
        return al;

    }

}
