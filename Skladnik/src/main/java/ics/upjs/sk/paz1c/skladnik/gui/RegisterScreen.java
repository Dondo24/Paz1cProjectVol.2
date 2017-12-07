/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.gui;

import Factory.ObjectFactory;
import dao.PouzivatelDao;
import dao.SkladDao;
import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import ics.upjs.sk.paz1c.skladnik.entity.Sklad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class RegisterScreen extends javax.swing.JFrame {
    private SkladDao skladDao = ObjectFactory.INSTANCE.getSkladDao();
    private PouzivatelDao pouzivatelDao = ObjectFactory.INSTANCE.getPouzivatelDao();
    private List <String> pouzivatelia = new ArrayList<>();
    private List <String> vsetkySklady = new ArrayList<>();
    private boolean menojeok = false;
    private boolean menoniejenull = false;
    private boolean dlzkamena = false;
    private boolean menosanepouziva = false ;
    private boolean heslojeok = false;
    private boolean heslasazhoduju = false;
    private boolean dlzkahesla = false;
   
    private boolean skladjeok = false;
    /**
     * Creates new form RegisterScreen
     */
    public RegisterScreen() {
        initComponents();
       // jHesloPasswordField2.setText("");
        //jHesloZnovuPasswordField1.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jHesloZnovuPasswordField1 = new javax.swing.JPasswordField();
        jHesloPasswordField2 = new javax.swing.JPasswordField();
        jMenoTextField1 = new javax.swing.JTextField();
        jNazovSkladuTextField2 = new javax.swing.JTextField();
        jspatButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Registruj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Meno");

        jLabel2.setText("Heslo");

        jLabel3.setText("Heslo znovu");

        jLabel4.setText("Názov skladu");

        jHesloZnovuPasswordField1.setText("jPasswordField1");

        jHesloPasswordField2.setText("jPasswordField2");

        jNazovSkladuTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNazovSkladuTextField2ActionPerformed(evt);
            }
        });

        jspatButton2.setText("Späť");
        jspatButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jspatButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jMenoTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNazovSkladuTextField2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jHesloPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jHesloZnovuPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jspatButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMenoTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHesloPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jHesloZnovuPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jNazovSkladuTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jspatButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String meno = jMenoTextField1.getText();
        char[] heslo = jHesloPasswordField2.getPassword();
        char[] hesloznovu  = jHesloZnovuPasswordField1.getPassword();
        String nazovSkladu = jNazovSkladuTextField2.getText();
       
       
        pouzivatelia = pouzivatelDao.dajVsetkychMena();
        vsetkySklady = skladDao.dajVsetkySklady();
        
        if(meno == null){
           JOptionPane.showMessageDialog(null, "zadaj meno");
           menoniejenull = false;
      }else{
            menoniejenull = true;
        }
        if(pouzivatelia.contains(meno)){
            JOptionPane.showMessageDialog(null, "Použivatelske meno je už obsadene");
            menosanepouziva=false;
        }else{
        menosanepouziva=true;
    }
        if(meno.length()<4){
            JOptionPane.showMessageDialog(null,"pouzivatelske meno musi byt dlhsie ako 4 znaky");
            dlzkamena =false;
        }else{
            dlzkamena = true;
        }
        if(meno.length()>15){
            JOptionPane.showMessageDialog(null,"Pouzivatelske meno musi byť kratšie ako 15 znakov");
            dlzkamena= false;
        }else{
        dlzkamena = true;
        }
        if(dlzkamena && menosanepouziva&&menoniejenull){
            menojeok = true;
            
        }else{
            menojeok= false;
        }
        
      if(heslo == null && hesloznovu == null){
            JOptionPane.showMessageDialog(null, "zadaj heslo");
            dlzkahesla= false;
        }else{
          dlzkahesla= true;
      }
      if(!Arrays.equals(heslo, hesloznovu)){
          JOptionPane.showMessageDialog(null, "Hesla sa nezhoduju");
          heslasazhoduju= false;
      }else{
          heslasazhoduju= true;
      }
      if(heslo.length<4){
          JOptionPane.showMessageDialog(null, "heslo musi byť dlhsie ako 4 ");
          dlzkahesla = false;
      }else{
          dlzkahesla = true;
      }
      if(heslo.length >15){
          JOptionPane.showMessageDialog(null, "heslo nemože byť dlhsie ako 15 znakov");
            dlzkahesla = false;
      }else{
          dlzkahesla = true;
      }
      
      if(dlzkahesla&&heslasazhoduju ){
      heslojeok=true;
      }else{
          heslojeok=false;
      }
      
      
      if(vsetkySklady.contains(nazovSkladu)){
          skladjeok=true;
          
      }else{
          skladjeok=false;
          JOptionPane.showMessageDialog(null, "Sklad neexistuje");
      }
      
      
       if(menojeok &&heslojeok&&skladjeok){
      String heslozcharov = "";
        for (int i = 0; i < heslo.length; i++) {
            heslozcharov = heslozcharov + heslo[i];
        }
         Sklad sklad =skladDao.dajIdSkladu(nazovSkladu);
      long idskladu = sklad.getId();
      Pouzivatel p = new Pouzivatel();
       p.setId_sklad(idskladu);
       p.setMeno(meno);
      p.setHeslo(heslozcharov);
      pouzivatelDao.pridajPouzivatela(p);
      
      LoginScreen login = new LoginScreen();
      login.setVisible(true);
      this.setVisible(false);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jNazovSkladuTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNazovSkladuTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNazovSkladuTextField2ActionPerformed

    private void jspatButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jspatButton2ActionPerformed
       LoginScreen lc = new LoginScreen();
       lc.setVisible(true);
       this.setVisible(false);
       dispose();
    }//GEN-LAST:event_jspatButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField jHesloPasswordField2;
    private javax.swing.JPasswordField jHesloZnovuPasswordField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jMenoTextField1;
    private javax.swing.JTextField jNazovSkladuTextField2;
    private javax.swing.JButton jspatButton2;
    // End of variables declaration//GEN-END:variables
}
