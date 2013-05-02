/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;

/**
 *
 * @author Kuba D
 */
public class NovaGame extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form NovaGame
     */
    public NovaGame(java.awt.Frame parent, boolean modal, NewGame ng) {
        super(parent, modal);
        initComponents();
        this.newGame=ng;
        this.hrac1=ng.getHrac1();this.hrac2=ng.getHrac2();
        this.jTextFieldjmeno1.setText(this.jmeno1=ng.getJmeno1());
        this.jTextFieldjmeno2.setText(this.jmeno2=ng.getJmeno2());
        this.jSpinnerNaSirku.setValue(this.naSirku=ng.getNaSirku());
        this.jSpinnerNaDelku.setValue(this.naDelku=ng.getNaDelku());
        this.jSpinnerVRade.setValue(this.vRade=ng.getvRade());
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }
    public void test(){
        System.out.println(this.newGame.countObservers());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupHrac1 = new javax.swing.ButtonGroup();
        buttonGroupHrac2 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jLabelLokalni = new javax.swing.JLabel();
        jLabelPocitac = new javax.swing.JLabel();
        jLabelServer = new javax.swing.JLabel();
        jLabelKlient = new javax.swing.JLabel();
        jRadioButtonLokalni1 = new javax.swing.JRadioButton();
        jRadioButtonPocitac1 = new javax.swing.JRadioButton();
        jRadioButtonServer1 = new javax.swing.JRadioButton();
        jRadioButtonKlient1 = new javax.swing.JRadioButton();
        jRadioButtonLokalni2 = new javax.swing.JRadioButton();
        jRadioButtonPocitac2 = new javax.swing.JRadioButton();
        jRadioButtonServer2 = new javax.swing.JRadioButton();
        jRadioButtonKlient2 = new javax.swing.JRadioButton();
        jSpinnerNaSirku = new javax.swing.JSpinner();
        jLabelNaSirku = new javax.swing.JLabel();
        jSpinnerNaDelku = new javax.swing.JSpinner();
        jLabelNaDelku = new javax.swing.JLabel();
        jSpinnerVRade = new javax.swing.JSpinner();
        jLabelNaDelkuVRade = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldjmeno1 = new javax.swing.JTextField();
        jTextFieldjmeno2 = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel.setText("Hrac:           1           2");

        jLabelLokalni.setText("lokalni");

        jLabelPocitac.setText("pocitac");

        jLabelServer.setText("server");

        jLabelKlient.setText("klient");

        buttonGroupHrac1.add(jRadioButtonLokalni1);
        jRadioButtonLokalni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLokalni1ActionPerformed(evt);
            }
        });

        buttonGroupHrac1.add(jRadioButtonPocitac1);
        jRadioButtonPocitac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPocitac1ActionPerformed(evt);
            }
        });

        buttonGroupHrac1.add(jRadioButtonServer1);
        jRadioButtonServer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonServer1ActionPerformed(evt);
            }
        });

        buttonGroupHrac1.add(jRadioButtonKlient1);
        jRadioButtonKlient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKlient1ActionPerformed(evt);
            }
        });

        buttonGroupHrac2.add(jRadioButtonLokalni2);
        jRadioButtonLokalni2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLokalni2ActionPerformed(evt);
            }
        });

        buttonGroupHrac2.add(jRadioButtonPocitac2);
        jRadioButtonPocitac2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPocitac2ActionPerformed(evt);
            }
        });

        buttonGroupHrac2.add(jRadioButtonServer2);
        jRadioButtonServer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonServer2ActionPerformed(evt);
            }
        });

        buttonGroupHrac2.add(jRadioButtonKlient2);
        jRadioButtonKlient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKlient2ActionPerformed(evt);
            }
        });

        jSpinnerNaSirku.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerNaSirkuStateChanged(evt);
            }
        });

        jLabelNaSirku.setText("Pocet poli na sirku");

        jSpinnerNaDelku.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerNaDelkuStateChanged(evt);
            }
        });

        jLabelNaDelku.setText("Pocet poli na vysku");

        jSpinnerVRade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerVRadeStateChanged(evt);
            }
        });

        jLabelNaDelkuVRade.setText("Pocet poli v rade");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextFieldjmeno1.setText("jTextField1");
        jTextFieldjmeno1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldjmeno1FocusLost(evt);
            }
        });

        jTextFieldjmeno2.setText("jTextField2");
        jTextFieldjmeno2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldjmeno2FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldjmeno1)
                    .addComponent(jTextFieldjmeno2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelLokalni)
                                                .addGap(23, 23, 23))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabelPocitac, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelServer, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonServer1)
                                            .addComponent(jRadioButtonPocitac1)
                                            .addComponent(jRadioButtonLokalni1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelKlient)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButtonKlient1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonServer2)
                                    .addComponent(jRadioButtonPocitac2)
                                    .addComponent(jRadioButtonLokalni2)
                                    .addComponent(jRadioButtonKlient2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNaSirku)
                    .addComponent(jLabelNaDelku)
                    .addComponent(jLabelNaDelkuVRade))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(jSpinnerNaSirku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerNaDelku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerVRade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelNaSirku)
                                    .addComponent(jRadioButtonLokalni2)
                                    .addComponent(jRadioButtonLokalni1)
                                    .addComponent(jLabelLokalni)
                                    .addComponent(jSpinnerNaSirku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButtonPocitac1)
                                        .addComponent(jRadioButtonPocitac2)
                                        .addComponent(jLabelPocitac, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelNaDelku)
                                    .addComponent(jSpinnerNaDelku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButtonServer2)
                                        .addComponent(jRadioButtonServer1)
                                        .addComponent(jLabelServer, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelNaDelkuVRade)))
                            .addComponent(jSpinnerVRade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelKlient)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonKlient2)
                                .addComponent(jRadioButtonKlient1))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldjmeno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldjmeno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jRadioButtonLokalni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLokalni1ActionPerformed
        hrac1=0;
    }//GEN-LAST:event_jRadioButtonLokalni1ActionPerformed

    private void jRadioButtonPocitac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPocitac1ActionPerformed
        hrac1=1;
    }//GEN-LAST:event_jRadioButtonPocitac1ActionPerformed

    private void jRadioButtonServer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonServer1ActionPerformed
        hrac1=2;
    }//GEN-LAST:event_jRadioButtonServer1ActionPerformed

    private void jRadioButtonKlient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKlient1ActionPerformed
        hrac1=3;
    }//GEN-LAST:event_jRadioButtonKlient1ActionPerformed

    private void jRadioButtonLokalni2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLokalni2ActionPerformed
        hrac2=0;
    }//GEN-LAST:event_jRadioButtonLokalni2ActionPerformed

    private void jRadioButtonPocitac2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPocitac2ActionPerformed
        hrac2=1;
    }//GEN-LAST:event_jRadioButtonPocitac2ActionPerformed

    private void jRadioButtonServer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonServer2ActionPerformed
        hrac2=2;
    }//GEN-LAST:event_jRadioButtonServer2ActionPerformed

    private void jRadioButtonKlient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKlient2ActionPerformed
        hrac2=3;
    }//GEN-LAST:event_jRadioButtonKlient2ActionPerformed

    private void jSpinnerNaSirkuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerNaSirkuStateChanged
        testJSN(this.jSpinnerNaSirku);
    }//GEN-LAST:event_jSpinnerNaSirkuStateChanged

    private void jSpinnerNaDelkuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerNaDelkuStateChanged
        testJSN(this.jSpinnerNaDelku);
    }//GEN-LAST:event_jSpinnerNaDelkuStateChanged
    private void testJSN(JSpinner jsn){
        if(((int)jsn.getValue())<((int)this.jSpinnerVRade.getValue())){
            jsn.setValue(this.jSpinnerVRade.getValue());
        }else{if(((int)jsn.getValue())>okraj){
            jsn.setValue(okraj);
        }}
        this.naDelku=((int)this.jSpinnerNaDelku.getValue());
        this.naSirku=((int)this.jSpinnerNaSirku.getValue());
    }
    private void jSpinnerVRadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerVRadeStateChanged
        if(((int)this.jSpinnerVRade.getValue())<3){
            this.jSpinnerVRade.setValue(3);
        }else{if(((int)this.jSpinnerVRade.getValue())>rada){
            this.jSpinnerVRade.setValue(rada);
        }}
        this.jSpinnerNaDelku.setValue(this.jSpinnerNaDelku.getValue());
        this.vRade=((int)this.jSpinnerVRade.getValue());
        testJSN(this.jSpinnerNaSirku);
        testJSN(this.jSpinnerNaDelku);
    }//GEN-LAST:event_jSpinnerVRadeStateChanged

    private void jTextFieldjmeno1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldjmeno1FocusLost
        if(this.jTextFieldjmeno1.getText().equals(this.jTextFieldjmeno2.getText())||this.jTextFieldjmeno1.getText().equals("")){
            this.jTextFieldjmeno1.setText(this.jmeno1);
        }else{
            this.jmeno2=this.jTextFieldjmeno2.getText();
        }
    }//GEN-LAST:event_jTextFieldjmeno1FocusLost

    private void jTextFieldjmeno2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldjmeno2FocusLost
        if(this.jTextFieldjmeno2.getText().equals(this.jTextFieldjmeno1.getText())||this.jTextFieldjmeno2.getText().equals("")){
            this.jTextFieldjmeno2.setText(this.jmeno2);
        }else{
            this.jmeno2=this.jTextFieldjmeno2.getText();
        }
    }//GEN-LAST:event_jTextFieldjmeno2FocusLost
    
    private void doClose(int retStatus) {
        System.out.println(retStatus);
        if(retStatus==RET_OK){
            System.out.println("inside");
            newGame.notifyObservers(new NewGame(naSirku, naDelku, vRade, hrac1, hrac2, jmeno1, jmeno2, true));
            newGame.set(naSirku, naDelku, vRade, hrac1, hrac2, jmeno1, jmeno2, true);
            System.out.println("behind");
        }else{
            newGame.set(naSirku, naDelku, -1, hrac1, hrac2, jmeno1, jmeno2, false);
        }
        returnStatus = retStatus;
        setVisible(false);
        dispose();
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
            java.util.logging.Logger.getLogger(NovaGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovaGame dialog = new NovaGame(new javax.swing.JFrame(), true, new NewGame(0,0,0,0,0,"","",false));
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroupHrac1;
    public javax.swing.ButtonGroup buttonGroupHrac2;
    public javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabelKlient;
    private javax.swing.JLabel jLabelLokalni;
    private javax.swing.JLabel jLabelNaDelku;
    private javax.swing.JLabel jLabelNaDelkuVRade;
    private javax.swing.JLabel jLabelNaSirku;
    private javax.swing.JLabel jLabelPocitac;
    private javax.swing.JLabel jLabelServer;
    public javax.swing.JRadioButton jRadioButtonKlient1;
    public javax.swing.JRadioButton jRadioButtonKlient2;
    public javax.swing.JRadioButton jRadioButtonLokalni1;
    public javax.swing.JRadioButton jRadioButtonLokalni2;
    public javax.swing.JRadioButton jRadioButtonPocitac1;
    public javax.swing.JRadioButton jRadioButtonPocitac2;
    public javax.swing.JRadioButton jRadioButtonServer1;
    public javax.swing.JRadioButton jRadioButtonServer2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JSpinner jSpinnerNaDelku;
    public javax.swing.JSpinner jSpinnerNaSirku;
    public javax.swing.JSpinner jSpinnerVRade;
    private javax.swing.JTextField jTextFieldjmeno1;
    private javax.swing.JTextField jTextFieldjmeno2;
    public javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
    private int hrac1 = 0, hrac2 = 0;
    private int naSirku, naDelku, vRade;
    public NewGame newGame;
    private String jmeno1,jmeno2;
    private static final int okraj = 80, rada = 10;
}
