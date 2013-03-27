/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Kuba D
 */
public class Oknoi extends javax.swing.JFrame {

    /**
     * Creates new form Piskvorky
     */
    public Oknoi() {
        initComponents();
        hra = new Piskvorka(20);
        nv = new int[2];
        nv[0]=20;nv[1]=5;ui=false;
        jLayeredPane1.add(puiskvorkovniceND = new PuiskvorkovniceND(nv[0],nv[0]), BorderLayout.CENTER);
        hra.puis=puiskvorkovniceND;
        poslouchej();
    }

    private void poslouchej(){
        puiskvorkovniceND.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                i=((me.getX())/20);
                j=((me.getY())/20);
                jLabel1.setText(i + ", " + j);
                if(i<hra.piskvorky.length&&j<hra.piskvorky[0].length){
                    hra.dalsiTah(i, j);
                    puiskvorkovniceND.repaint();
                    if(hra.konec[0]!=-1){
                        jLabel1.setText("Vyhrály " + hra.piskvorky[hra.konec[0]][hra.konec[1]] + " " + hra.konec[2] +".");
                    }else{if(hra.getPrazdnoty()==0){
                        jLabel1.setText("Remíza.");
                    }}
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //bez ucinku;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                //bez ucinku;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                //bez ucinku;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //bez ucinku;
            }
        });
    }

    private void novaHra(){
        final NovaHra uj = new NovaHra(this, true);
        uj.jLabelNadpis.setText("Novou hru?");
        uj.setTitle("Nová hra");
        uj.jLabelNastaveni.setText("nastvení");
        uj.jLabelVelikost.setText("velikost hrciho pole a polí v řadě (3-70)");
        uj.jRadioButton7.setText("křížky x kolečka");
        uj.jRadioButton8.setText("křížky x počítač");
        uj.jRadioButton9.setText("počítač x kolečka");
        uj.jRadioButton7.setSelected(true);
        uj.jCheckBox3.setSelected(true);
        uj.jCheckBox10.setSelected(true);
        uj.okButton.addActionListener(new ActionListener(){

            public boolean vPoradku(){
                switch(uj.typ){
                    default:    ui=false;
                                uiK=KK.PRAZDNE;
                                break;
                    case 1:     ui=true;
                                uiK=KK.KOLECKO;
                                break;
                    case 2:     ui=true;
                                uiK=KK.KRIZEK;
                                break;
                }
                nv[0]=0;nv[1]=0;
                if(uj.jCheckBox1.isSelected())nv[0]+=3;
                if(uj.jCheckBox2.isSelected())nv[0]+=4;
                if(uj.jCheckBox3.isSelected())nv[0]+=5;
                if(uj.jCheckBox4.isSelected())nv[0]+=6;
                if(uj.jCheckBox5.isSelected())nv[0]+=10;
                if(uj.jCheckBox6.isSelected())nv[0]+=20;
                if(uj.jCheckBox7.isSelected())nv[0]+=40;
                if(uj.jCheckBox8.isSelected())nv[1]+=3;
                if(uj.jCheckBox9.isSelected())nv[1]+=4;
                if(uj.jCheckBox10.isSelected())nv[1]+=5;
                if(uj.jCheckBox11.isSelected())nv[1]+=6;
                if(uj.jCheckBox12.isSelected())nv[1]+=10;
                if(uj.jCheckBox13.isSelected())nv[1]+=20;
                if(uj.jCheckBox14.isSelected())nv[1]+=40;
                if(nv[0]<nv[1]||nv[1]<3){
                    uj.jCheckBox8.setSelected(true);return false;
                }
                if(nv[0]<3){
                    uj.jCheckBox1.setSelected(true);return false;
                }
                if(nv[0]>70){
                    uj.jCheckBox7.setSelected(false);
                    uj.jCheckBox14.setSelected(false);return false;
                }
                return true;
            }
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(vPoradku()){
                    if(ui){
//                        hra = new UI(nv[0], nv[1], uiK);
                        hra = new Piskvorka(nv[0], nv[1],null);
                    }else{
                        hra = new Piskvorka(nv[0], nv[1],null);
                    }
                    jLayeredPane1.remove(0);
                    jLayeredPane1.add(puiskvorkovniceND = new PuiskvorkovniceND(nv[0],nv[0]), BorderLayout.CENTER);
                    hra.puis=puiskvorkovniceND;
                    puiskvorkovniceND.repaint();
                    poslouchej();
                    jLabel1.setText("Nová hra. " + hra.naTahu() + " na tahu.");
//                    uj.okButton.removeActionListener(this);
                    uj.doClose(NovaHra.RET_OK);
                }
            }

        });
        uj.setVisible(true);
//        hra = new Piskvorka(20);
//        this.jLayeredPane1.remove(0);
//        jLayeredPane1.add(puiskvorkovniceND = new PuiskvorkovniceND(hra.piskvorky), BorderLayout.WEST);
//        puiskvorkovniceND.vykresli(hra.piskvorky);
//        jLabel1.setText("Nová hra. Křížky na tahu.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu1 = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        restartjMenuItem = new javax.swing.JMenuItem();
        returnjMenuItem = new javax.swing.JMenuItem();
        loadjMenuItem = new javax.swing.JMenuItem();
        savejMenuItem = new javax.swing.JMenuItem();
        saveAsjMenuItem = new javax.swing.JMenuItem();
        exitjSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jScrollPane1.setViewportView(jLayeredPane1);

        fileMenu1.setMnemonic('f');
        fileMenu1.setText("Hra");

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        newGameMenuItem.setMnemonic('o');
        newGameMenuItem.setText("Nová hra");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
        fileMenu1.add(newGameMenuItem);

        restartjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        restartjMenuItem.setText("Restart");
        restartjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartjMenuItemActionPerformed(evt);
            }
        });
        fileMenu1.add(restartjMenuItem);

        returnjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        returnjMenuItem.setText("Zpět");
        returnjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnjMenuItemActionPerformed(evt);
            }
        });
        fileMenu1.add(returnjMenuItem);

        loadjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        loadjMenuItem.setText("Nahrát");
        loadjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadjMenuItemActionPerformed(evt);
            }
        });
        fileMenu1.add(loadjMenuItem);

        savejMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        savejMenuItem.setText("Uložit");
        savejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejMenuItemActionPerformed(evt);
            }
        });
        fileMenu1.add(savejMenuItem);

        saveAsjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        saveAsjMenuItem.setText("Uložit jako");
        saveAsjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsjMenuItemActionPerformed(evt);
            }
        });
        fileMenu1.add(saveAsjMenuItem);
        fileMenu1.add(exitjSeparator);

        exitMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem1.setMnemonic('x');
        exitMenuItem1.setText("Ukončit");
        exitMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu1.add(exitMenuItem1);

        menuBar.add(fileMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuItemActionPerformed
        this.novaHra();
    }//GEN-LAST:event_newGameMenuItemActionPerformed

    private void returnjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnjMenuItemActionPerformed
////        if(hra.zpet()!=0){
////            sachovnicka.vykresli(hra.sachovnice, hra.naTahu());
////            jLabel1.setText("Vráceno. ");
////            naTahu();
////        }else{
////            jLabel1.setText("Nelze vrátit. " + jLabel1.getText());
////        }
//        hra = new Piskvorka(20);
//        this.jLayeredPane1.remove(0);
//        jLayeredPane1.add(puiskvorkovniceND = new PuiskvorkovniceND(hra.piskvorky), BorderLayout.WEST);
//        puiskvorkovniceND.vykresli(hra.piskvorky);
//        jLabel1.setText("Nová hra. Křížky na tahu.");
    }//GEN-LAST:event_returnjMenuItemActionPerformed

    private void loadjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadjMenuItemActionPerformed
//        final UlozitJako uj = new UlozitJako(this, true);
//        uj.jLabel.setText("Jako hru chcete nahrát?");
//        uj.setTitle("Nahrát");
//        uj.okButton.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                hra.setName(uj.namejTextField.getText());
//                /*if(!pamet.uloz(hra, hra.getName())){
//                    jLabel1.setText("Nelze nahrát. " + jLabel1.getText());
//                }else{
//                    jLabel1.setText("Nahráno. ");
//                }*/
//                hra=pamet.nahraj(hra, hra.getName());
//                sachovnicka.vykresli(hra.sachovnice, hra.naTahu());
//                pesakNaKonci();
//                jLabel1.setText("Nahrána " + hra.getName() + ". ");
//                naTahu();
//                uj.doClose(UlozitJako.RET_OK);
//            }
//
//        });
//        uj.setVisible(true);
    }//GEN-LAST:event_loadjMenuItemActionPerformed

    private void savejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejMenuItemActionPerformed
//        if(!pamet.uloz(hra, hra.getName())){
//            saveAsjMenuItemActionPerformed(evt);
//        }else{
//            jLabel1.setText("Uloženo. " + jLabel1.getText());
//        }
    }//GEN-LAST:event_savejMenuItemActionPerformed

    private void saveAsjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsjMenuItemActionPerformed
//        final UlozitJako uj = new UlozitJako(this, true);
//
//        uj.okButton.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                hra.setName(uj.namejTextField.getText());
//                if(!pamet.uloz(hra, hra.getName())){
//                    jLabel1.setText("Nelze uložit. " + jLabel1.getText());
//                }else{
//                    jLabel1.setText("Uložena " + hra.getName() + ". " + jLabel1.getText());
//                }
//                uj.doClose(UlozitJako.RET_OK);
//            }
//
//        });
//        uj.setVisible(true);
    }//GEN-LAST:event_saveAsjMenuItemActionPerformed

    private void exitMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItem1ActionPerformed
//        pamet.uloz(hra);
        System.exit(0);
    }//GEN-LAST:event_exitMenuItem1ActionPerformed

    private void restartjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartjMenuItemActionPerformed
//        if(ui){
//            hra = new UI(nv[0], nv[1], uiK);
//        }else{
//            hra = new Piskvorka(nv[0], nv[1]);
//        }
//        puiskvorkovniceND.vykresli(hra.piskvorky);
//        jLabel1.setText("Nová hra. " + hra.naTahu() + " na tahu.");
    }//GEN-LAST:event_restartjMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(Oknoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Oknoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Oknoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Oknoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Oknoi().setVisible(true);
            }
        });
    }
    private boolean ui;
    private KK uiK;
    private int[] nv;
    private Piskvorka hra;
    private PuiskvorkovniceND puiskvorkovniceND;
    private int i, j;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem exitMenuItem1;
    private javax.swing.JPopupMenu.Separator exitjSeparator;
    private javax.swing.JMenu fileMenu1;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem loadjMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JMenuItem restartjMenuItem;
    private javax.swing.JMenuItem returnjMenuItem;
    private javax.swing.JMenuItem saveAsjMenuItem;
    private javax.swing.JMenuItem savejMenuItem;
    // End of variables declaration//GEN-END:variables
}
