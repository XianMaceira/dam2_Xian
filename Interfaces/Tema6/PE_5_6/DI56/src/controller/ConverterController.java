/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import model.LengthConverter;
import view.ConverterJFrame;

/**
 *
 * @author ubuntu
 */
public class ConverterController {

    private  ConverterJFrame view;
    private  LengthConverter model;
    private final String REGEX = "[0-9]+";
    private  HelpBroker hb;

    public ConverterController(ConverterJFrame view, LengthConverter model) throws MalformedURLException, HelpSetException {
        this.view = view;
        this.model = model;
        initEventHandlers();
        initHelp();
    }

    private void initHelp() throws MalformedURLException, HelpSetException {
        File helpFile=new File("help/help_set.hs");
        URL hsURL=helpFile.toURI().toURL();
        HelpSet helpSet=new HelpSet(getClass().getClassLoader(),hsURL);
        this.hb=helpSet.createHelpBroker();
        hb.enableHelpKey(view.getContentPane(), "app", helpSet);
      
    }
    
    private void initEventHandlers() {
        this.view.conversionLabel.setText("");
        this.view.toKmsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String data = view.amountTextField.getText();
                if (data.matches(REGEX)) {
                    Double amount = Double.valueOf(data);
                    Double conversion = model.milesToKms(amount);
                    view.conversionLabel.setText("Millas son " + conversion.toString() + " KMs");
                }
            }
        });
        this.view.toMilesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String data = view.amountTextField.getText();
                if (data.matches(REGEX)) {
                    Double amount = Double.valueOf(data);
                    Double conversion = model.KmsToMiles(amount);
                    view.conversionLabel.setText("KMs son " + conversion.toString() + " Millas");
                }
            }
        });

        this.view.exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}
