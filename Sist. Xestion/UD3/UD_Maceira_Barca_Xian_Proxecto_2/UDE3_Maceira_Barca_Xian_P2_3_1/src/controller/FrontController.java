/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.pdfa.PdfADocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import view.tableJFrame;

/**
 *
 * @author maceira_barca_xian
 */
public class FrontController {

    private final tableJFrame view;

    public FrontController(tableJFrame view) {
        this.view = view;
        try {
            odooTest();
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XmlRpcException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.view.addExportButtonActionListener(this.addExportButtonActionListener());
    }

    private void odooTest() throws MalformedURLException, XmlRpcException {

        final String url = "http://192.168.250.2:8069",
                db = "odoo",
                username = "maceira.barca.xian.ald@gmail.com",
                password = "8e317b95f79d9968bcd8095610423c9961501b95";

        final XmlRpcClient client = new XmlRpcClient();

        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", url)));
        client.execute(common_config, "version", emptyList());
        int uid = (int) client.execute(common_config, "authenticate", asList(db, username, password, emptyMap()));

        final XmlRpcClient models = new XmlRpcClient() {
            {
                setConfig(new XmlRpcClientConfigImpl() {
                    {
                        setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));
                    }
                });
            }
        };
        List ids = asList((Object[]) models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "search",
                asList(asList(
                        asList("is_company", "=", true)))
        )));

        List partnerResults = asList((Object[]) models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "read",
                asList(ids),
                new HashMap() {
            {
                put("fields", asList("name", "street", "city", "phone", "mobile"));
            }
        }
        )));

        DefaultTableModel dtm = (DefaultTableModel) view.getTableModel();

        System.out.println(partnerResults.toString());
        for (int i = 0; i < partnerResults.size(); i++) {
            String register = partnerResults.get(i).toString();
            String city = getField("{city=", ", phone=", register);
            System.out.println(city);
            String phone = getField(", phone=", ", street=", register);
            System.out.println(phone);
            String street = getField(", street=", ", name=", register);
            System.out.println(street);
            String name = getField(", name=", ", mobile=", register);
            System.out.println(name);
            String mobile = getField(", mobile=", ", id=", register);
            System.out.println(mobile);
            Object[] data = new Object[]{
                name, street, city, phone, mobile
            };

            dtm.addRow(data);
            view.addTableModel(dtm);
        }

    }

    private static String getField(String left, String right, String register) {
        int begin = register.lastIndexOf(left) + left.length();
        int end = register.lastIndexOf(right);
        return register.substring(begin, end);
    }

    private static void openTest() throws MalformedURLException, XmlRpcException {
        final XmlRpcClient client = new XmlRpcClient();
        final XmlRpcClientConfigImpl start_config = new XmlRpcClientConfigImpl();
        start_config.setServerURL(new URL("https://demo.odoo.com/start"));
        final Map<String, String> info = (Map<String, String>) client.execute(
                start_config, "start", emptyList());
        final String url = info.get("host"),
                db = info.get("database"),
                username = info.get("user"),
                password = info.get("password");
        System.out.println(url);
        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", url)));
        client.execute(common_config, "version", emptyList());
        System.out.println(client.execute(common_config, "version", emptyList()));
    }

    private ActionListener addExportButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File("export.pdf"));
                int value = fileChooser.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    exportPDF(file);
                }
            }
        };
        return al;
    }

    private void exportPDF(File file) {
        try {
            PdfWriter pdfWriter = new PdfWriter(file);
            PdfDocument pdfdoc = new PdfDocument(pdfWriter);
            Document doc = new Document(pdfdoc);

            int col = view.getTableModel().getColumnCount();
            int row = view.getTableModel().getRowCount();

            TableModel tm = view.getTableModel();

            Table t = new Table(col);
            for (int i = 0; i < col; i++) {
                t.addCell(tm.getColumnName(i));
            }
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (tm.getValueAt(r, c).toString().equals("false")) {
                        t.addCell("n/a");
                    } else {
                        t.addCell(tm.getValueAt(r, c).toString());
                    }
                }
            }

            doc.add(t);

            doc.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
