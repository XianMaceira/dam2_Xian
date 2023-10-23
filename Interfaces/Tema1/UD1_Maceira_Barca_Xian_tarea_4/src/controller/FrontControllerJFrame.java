/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.manageSalonPalace.ManageSalonPalaceController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.managesalonPalace.ManageSalonPalaceJDialog;

/**
 *
 * @author dides
 */
public class FrontControllerJFrame {

    private MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
this.view.setManageSalonPalaceMenuItemListener(setManageSalonPalaceMenuItemActionListener());

    }

    private ActionListener setQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        };
        return al;
    }
    
    private ActionListener setManageSalonPalaceMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageSalonPalaceJDialog msp = new ManageSalonPalaceJDialog(view, true);
                ManageSalonPalaceController mspc = new ManageSalonPalaceController(msp);
                msp.setVisible(true);
            }
        };
        return al;
    }

}
