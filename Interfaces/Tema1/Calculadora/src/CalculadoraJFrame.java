/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author maceira_barca_xian
 */
public class CalculadoraJFrame extends javax.swing.JFrame {

    /**
     * Creates new form CalculadoraJFrame
     */
    public CalculadoraJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menosButton = new javax.swing.JButton();
        multiplicacionButton = new javax.swing.JButton();
        divisonButton = new javax.swing.JButton();
        sumarButton = new javax.swing.JButton();
        igualButton = new javax.swing.JButton();
        n7Button = new javax.swing.JButton();
        n8Button = new javax.swing.JButton();
        n9Button = new javax.swing.JButton();
        n4Button = new javax.swing.JButton();
        acButton = new javax.swing.JButton();
        n6Button = new javax.swing.JButton();
        n1Button = new javax.swing.JButton();
        n2Button = new javax.swing.JButton();
        n3Button = new javax.swing.JButton();
        n5Button = new javax.swing.JButton();
        n0Button = new javax.swing.JButton();
        displayTextField = new javax.swing.JTextField();
        marcaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        menosButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        menosButton.setText("-");
        menosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosButtonActionPerformed(evt);
            }
        });

        multiplicacionButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        multiplicacionButton.setText("X");
        multiplicacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplicacionButtonActionPerformed(evt);
            }
        });

        divisonButton.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        divisonButton.setText("/");
        divisonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divisonButtonActionPerformed(evt);
            }
        });

        sumarButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        sumarButton.setText("+");
        sumarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarButtonActionPerformed(evt);
            }
        });

        igualButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        igualButton.setText("=");
        igualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igualButtonActionPerformed(evt);
            }
        });

        n7Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n7Button.setText("7");
        n7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n7ButtonActionPerformed(evt);
            }
        });

        n8Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n8Button.setText("8");
        n8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n8ButtonActionPerformed(evt);
            }
        });

        n9Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n9Button.setText("9");
        n9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n9ButtonActionPerformed(evt);
            }
        });

        n4Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n4Button.setText("4");
        n4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n4ButtonActionPerformed(evt);
            }
        });

        acButton.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        acButton.setText("AC");
        acButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acButtonActionPerformed(evt);
            }
        });

        n6Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n6Button.setText("6");
        n6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n6ButtonActionPerformed(evt);
            }
        });

        n1Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n1Button.setText("1");
        n1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1ButtonActionPerformed(evt);
            }
        });

        n2Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n2Button.setText("2");
        n2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2ButtonActionPerformed(evt);
            }
        });

        n3Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n3Button.setText("3");
        n3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n3ButtonActionPerformed(evt);
            }
        });

        n5Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n5Button.setText("5");
        n5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n5ButtonActionPerformed(evt);
            }
        });

        n0Button.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        n0Button.setText("0");
        n0Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n0ButtonActionPerformed(evt);
            }
        });

        displayTextField.setEditable(false);
        displayTextField.setFont(new java.awt.Font("Uroob", 0, 48)); // NOI18N
        displayTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        displayTextField.setText("0");
        displayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayTextFieldActionPerformed(evt);
            }
        });

        marcaLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        marcaLabel.setText("CUSIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(marcaLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(displayTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(n0Button, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(n1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(n2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(n3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sumarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(igualButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(n4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(n5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(n6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(menosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(n7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(n8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(n9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(multiplicacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(acButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(divisonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(marcaLabel)
                .addGap(18, 18, 18)
                .addComponent(displayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(divisonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiplicacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sumarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igualButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n0Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void sumarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarButtonActionPerformed
        guardarValor("+");
        cleanDisplay();
    }//GEN-LAST:event_sumarButtonActionPerformed

    private void acButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acButtonActionPerformed
        acDisplay();
    }//GEN-LAST:event_acButtonActionPerformed

    private void divisonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divisonButtonActionPerformed

        guardarValor("/");
        cleanDisplay();
    }//GEN-LAST:event_divisonButtonActionPerformed

    private void n8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n8ButtonActionPerformed
        cambiarDisplay("8");
    }//GEN-LAST:event_n8ButtonActionPerformed


    private void n5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n5ButtonActionPerformed
        cambiarDisplay("5");
    }//GEN-LAST:event_n5ButtonActionPerformed

    private void displayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displayTextFieldActionPerformed

    private void n7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n7ButtonActionPerformed
        cambiarDisplay("7");
    }//GEN-LAST:event_n7ButtonActionPerformed

    private void n9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n9ButtonActionPerformed
        cambiarDisplay("9");
    }//GEN-LAST:event_n9ButtonActionPerformed

    private void multiplicacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplicacionButtonActionPerformed
        guardarValor("*");
        cleanDisplay();
    }//GEN-LAST:event_multiplicacionButtonActionPerformed

    private void n4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n4ButtonActionPerformed
        cambiarDisplay("4");
    }//GEN-LAST:event_n4ButtonActionPerformed

    private void n6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n6ButtonActionPerformed
        cambiarDisplay("6");
    }//GEN-LAST:event_n6ButtonActionPerformed

    private void menosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosButtonActionPerformed

        guardarValor("-");
        cleanDisplay();
    }//GEN-LAST:event_menosButtonActionPerformed

    private void n1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1ButtonActionPerformed
        cambiarDisplay("1");
    }//GEN-LAST:event_n1ButtonActionPerformed

    private void n2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2ButtonActionPerformed
        cambiarDisplay("2");
    }//GEN-LAST:event_n2ButtonActionPerformed

    private void n3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n3ButtonActionPerformed
        cambiarDisplay("3");
    }//GEN-LAST:event_n3ButtonActionPerformed

    private void n0ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n0ButtonActionPerformed
        cambiarDisplay("0");
    }//GEN-LAST:event_n0ButtonActionPerformed

    private void igualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igualButtonActionPerformed
        guardarValor(".");
        cleanDisplay();
        switch (operador) {
            case "+":
                cambiarDisplay(String.valueOf(num1 + num2));
                num1 = (num1 + num2);
                break;
            case "-":
                cambiarDisplay(String.valueOf(num1 - num2));
                num1 = (num1 - num2);
                break;
            case "*":
                cambiarDisplay(String.valueOf(num1 * num2));
                num1 = (num1 * num2);
                break;
            case "/":
                cambiarDisplay(String.format("%.2f",(num1 + 0.0) / num2));
                num1 = num1 / num2;
                break;
        }
        
    }//GEN-LAST:event_igualButtonActionPerformed

// Variables
    private Integer num1;
    private Integer num2;
    private Integer ult;
    private Integer res;
    private String ultOperador;
//    private Double res;
    private String operador;

// funciones
    private void cambiarDisplay(String valor) {
        String texto = displayTextField.getText();
        if ("0".equals(displayTextField.getText())) {
            displayTextField.setText(valor);
        } else {
            displayTextField.setText(texto + valor);
        }
    }

    private void cleanDisplay() {
        displayTextField.setText("");

    }
    
    private void acDisplay() {
        displayTextField.setText("0");
        num1 = null;
        num2 = null;
    }

    private void guardarValor(String operador) {

        if (num1 == null) {
            num1 = Integer.parseInt(displayTextField.getText());
            System.out.println(num1);
        } else if (num2 == null ||!ultOperador.equals(".")){
            num2 = Integer.parseInt(displayTextField.getText());
           System.out.println(num2);

        }
        
        cleanDisplay();
        if (!operador.equals(".")) {
            this.operador = operador;
        }
        ultOperador = operador;

//        System.out.println(operador);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculadoraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acButton;
    private javax.swing.JTextField displayTextField;
    private javax.swing.JButton divisonButton;
    private javax.swing.JButton igualButton;
    private javax.swing.JLabel marcaLabel;
    private javax.swing.JButton menosButton;
    private javax.swing.JButton multiplicacionButton;
    private javax.swing.JButton n0Button;
    private javax.swing.JButton n1Button;
    private javax.swing.JButton n2Button;
    private javax.swing.JButton n3Button;
    private javax.swing.JButton n4Button;
    private javax.swing.JButton n5Button;
    private javax.swing.JButton n6Button;
    private javax.swing.JButton n7Button;
    private javax.swing.JButton n8Button;
    private javax.swing.JButton n9Button;
    private javax.swing.JButton sumarButton;
    // End of variables declaration//GEN-END:variables
}