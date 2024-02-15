/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc;

import controller.ConverterController;
import java.net.MalformedURLException;
import javax.help.HelpSetException;
import model.LengthConverter;
import view.ConverterJFrame;

/**
 *
 * @author ubuntu
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, HelpSetException {
        // TODO code application logic here
       // testConverter();
        ConverterJFrame view=new ConverterJFrame();
        LengthConverter model=new LengthConverter();
        ConverterController controller=new ConverterController(view, model);
        view.getContentPane().setBackground(new java.awt.Color(204,204,255));
        view.setVisible(true);
       
       
    }

    private static void testConverter() {
        LengthConverter lc = new LengthConverter();
        Double miles = 10.0;
        Double kms = 0.0;
        kms = lc.milesToKms(miles);
        System.out.println(miles + " millas son " + kms + " kms");

        kms = 1.0;
        miles = lc.KmsToMiles(kms);
        System.out.println(kms + " kms son " + miles + " millas");

    }
}
