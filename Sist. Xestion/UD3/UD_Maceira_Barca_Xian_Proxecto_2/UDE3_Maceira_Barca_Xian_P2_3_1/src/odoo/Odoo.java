/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package odoo;

import controller.FrontController;
import view.tableJFrame;
import java.net.MalformedURLException;
import org.apache.xmlrpc.XmlRpcException;


/**
 *
 * @author fermigo
 */
public class Odoo {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     * @throws org.apache.xmlrpc.XmlRpcException
     */
    
    private tableJFrame view;

    public Odoo(tableJFrame view) {
        this.view = view;
    }
    
    
    
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        tableJFrame view=new tableJFrame();

        FrontController fc=new FrontController(view);

        view.setVisible(true);
    }

} 