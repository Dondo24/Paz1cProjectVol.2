/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.gui;

import Factory.ObjectFactory;
import dao.MaterialDao;
import ics.upjs.sk.paz1c.skladnik.entity.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class PridajKartuMaterialuScreen extends javax.swing.JFrame {
       private MaterialDao material = ObjectFactory.INSTANCE.getMaterialDao();
       
    /**
     * Creates new form PridajKartuMaterialuScreen
     */
    public PridajKartuMaterialuScreen() {
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

        jPridajMaterialButton1 = new javax.swing.JButton();
        jZrusitPridavanieButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jNazovMaterialuTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPridajMaterialButton1.setBackground(new java.awt.Color(0, 102, 0));
        jPridajMaterialButton1.setText("Pridaj material");
        jPridajMaterialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPridajMaterialButton1ActionPerformed(evt);
            }
        });

        jZrusitPridavanieButton2.setBackground(new java.awt.Color(0, 102, 0));
        jZrusitPridavanieButton2.setText("Zrušiť");
        jZrusitPridavanieButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jZrusitPridavanieButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Názov");

        jNazovMaterialuTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNazovMaterialuTextField1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jNazovMaterialuTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jZrusitPridavanieButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPridajMaterialButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNazovMaterialuTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPridajMaterialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jZrusitPridavanieButton2))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jZrusitPridavanieButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jZrusitPridavanieButton2ActionPerformed
       MainScreen ms = new MainScreen();
       ms.setVisible(true);
       this.setVisible(false);
       dispose();
    }//GEN-LAST:event_jZrusitPridavanieButton2ActionPerformed

    private void jNazovMaterialuTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNazovMaterialuTextField1ActionPerformed
       
        
    }//GEN-LAST:event_jNazovMaterialuTextField1ActionPerformed

    private void jPridajMaterialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPridajMaterialButton1ActionPerformed
         String nazovNovehoMaterialu = jNazovMaterialuTextField1.getText();
         Material novyMaterial = new Material();
         List<String> vsetkyMaterialy = new ArrayList<String>();
         vsetkyMaterialy = material.dajNazovVsetkychMaterialov();
         if(vsetkyMaterialy.contains(nazovNovehoMaterialu)){
             JOptionPane.showMessageDialog(null, "Material sa uz nachadza v databáze");
             
         }else{
             novyMaterial.setNazov(nazovNovehoMaterialu);
             //toto som dal na tvrdo ptm sa to zmeni ak vyriesime toho pouzivatela
             novyMaterial.setId_sklad(1);
             novyMaterial.setStav(0);
             material.pridajMaterial(novyMaterial);
             JOptionPane.showMessageDialog(null, "Pridanie bolo uspesne");
         
         }
    }//GEN-LAST:event_jPridajMaterialButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PridajKartuMaterialuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridajKartuMaterialuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridajKartuMaterialuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridajKartuMaterialuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PridajKartuMaterialuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNazovMaterialuTextField1;
    private javax.swing.JButton jPridajMaterialButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jZrusitPridavanieButton2;
    // End of variables declaration//GEN-END:variables
}
