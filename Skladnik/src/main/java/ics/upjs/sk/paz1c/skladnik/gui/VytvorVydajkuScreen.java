/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.gui;

import Factory.ObjectFactory;
import dao.MaterialDao;
import dao.MysqlPrijemkaDao;
import dao.PohybMaterialuDao;
import dao.PouzivatelDao;
import dao.PrijemkaDao;
import dao.VydajkaDao;
import ics.upjs.sk.paz1c.skladnik.entity.Material;
import ics.upjs.sk.paz1c.skladnik.entity.PohybMaterialu;
import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import ics.upjs.sk.paz1c.skladnik.entity.Vydajka;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author Marcel
 */
public class VytvorVydajkuScreen extends javax.swing.JFrame {
    
       VydajkaDao vydajkaDao = ObjectFactory.INSTANCE.getVydajkaDao();
       PohybMaterialuDao pohybMaterialuDao = ObjectFactory.INSTANCE.getPohybMaterialuDao();
       MaterialDao materialDao = ObjectFactory.INSTANCE.getMaterialDao();
       PouzivatelDao pouzivatelDao = ObjectFactory.INSTANCE.getPouzivatelDao();
        private int idVydajky = vydajkaDao.getLastId()+1;
        //Pouzivatel pouzivatel;
     
    /**
     * Creates new form VytvorPrijemkuScreen
     */
    public VytvorVydajkuScreen() {
        initComponents();       
        
        idTextField.setText(Integer.toString(idVydajky));      
      
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        pocetLabel = new javax.swing.JLabel();
        idMaterialuLabel = new javax.swing.JLabel();
        idMaterualuTextField = new javax.swing.JTextField();
        pocetTextField = new javax.swing.JTextField();
        cenaLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        materialTable = new javax.swing.JTable();
        potvrdVydajkuButton = new javax.swing.JButton();
        stornoButton = new javax.swing.JButton();
        pridajMaterialuButton = new javax.swing.JButton();
        cenaSpoluTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        uzivatelLabel = new javax.swing.JLabel();
        vymazPohybMaterialuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(51, 51, 51));
        idLabel.setText("ID:");

        idTextField.setEditable(false);
        idTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        pocetLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pocetLabel.setForeground(new java.awt.Color(51, 51, 51));
        pocetLabel.setText("Pocet:");

        idMaterialuLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idMaterialuLabel.setForeground(new java.awt.Color(51, 51, 51));
        idMaterialuLabel.setText("ID materialu:");

        idMaterualuTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idMaterualuTextFieldMouseClicked(evt);
            }
        });
        idMaterualuTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idMaterualuTextFieldActionPerformed(evt);
            }
        });

        cenaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cenaLabel.setForeground(new java.awt.Color(51, 51, 51));

        materialTable.setBackground(new java.awt.Color(0, 204, 102));
        materialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID pohybu", "ID materialu", "Nazov materialu", "Cena", "Pocet"
            }
        ));
        jScrollPane1.setViewportView(materialTable);

        potvrdVydajkuButton.setBackground(new java.awt.Color(0, 102, 0));
        potvrdVydajkuButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        potvrdVydajkuButton.setText("Potvrdiť");
        potvrdVydajkuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potvrdVydajkuButtonActionPerformed(evt);
            }
        });

        stornoButton.setBackground(new java.awt.Color(0, 102, 0));
        stornoButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stornoButton.setText("Storno");
        stornoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stornoButtonActionPerformed(evt);
            }
        });

        pridajMaterialuButton.setBackground(new java.awt.Color(0, 102, 0));
        pridajMaterialuButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pridajMaterialuButton.setText("Pridaj material");
        pridajMaterialuButton.setActionCommand("Pridať material");
        pridajMaterialuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajMaterialuButtonActionPerformed(evt);
            }
        });

        cenaSpoluTextField.setEditable(false);
        cenaSpoluTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cenaSpoluTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Cena spolu:");

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));

        uzivatelLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uzivatelLabel.setForeground(new java.awt.Color(0, 204, 0));
        uzivatelLabel.setText("Uzivatel");

        vymazPohybMaterialuButton.setBackground(new java.awt.Color(0, 102, 0));
        vymazPohybMaterialuButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vymazPohybMaterialuButton.setText("Vymaž pohyb");
        vymazPohybMaterialuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vymazPohybMaterialuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cenaLabel)
                            .addComponent(pocetLabel)
                            .addComponent(idMaterialuLabel))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idMaterualuTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(pocetTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(pridajMaterialuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vymazPohybMaterialuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(idLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(idTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(potvrdVydajkuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(stornoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(cenaSpoluTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uzivatelLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cenaSpoluTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(potvrdVydajkuButton)
                        .addGap(18, 18, 18)
                        .addComponent(stornoButton)
                        .addGap(22, 22, 22))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uzivatelLabel)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idMaterualuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idMaterialuLabel))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pocetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pocetLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(cenaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pridajMaterialuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vymazPohybMaterialuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajMaterialuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajMaterialuButtonActionPerformed
        if(idMaterualuTextField.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Prosim zadajte id materialu");
        return;
        }
        long idMaterialu = Long.parseLong(idMaterualuTextField.getText());
       if(pocetTextField.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Prosim zadajte pocet");
        return;
        }
        double pocet = Double.parseDouble(pocetTextField.getText());
         Material pridavanyMaterial = materialDao.dajMaterialById(idMaterialu);
        Pouzivatel  p =  pouzivatelDao.dajPouzivatela(uzivatelLabel.getText());
       long idSkladuPouzivatela = p.getId_sklad();
        long idSkladuMaterialu = pridavanyMaterial.getId_sklad();
      
        double cena = materialDao.dajMaterialById(idMaterialu).getCena();
    
        if(idSkladuMaterialu==idSkladuPouzivatela){
        PohybMaterialu pohybMaterialu = new PohybMaterialu();
       if(materialDao.dajVsetkyId().contains(idMaterialu)){
        pohybMaterialu.setId_materialu(idMaterialu);
        }else{
        JOptionPane.showMessageDialog(null, "Material neexistuje");
        }
        pohybMaterialu.setPocet(pocet);
        pohybMaterialu.setVydajka_id(idVydajky);
        pohybMaterialu.setCena(cena);
        
        
        if(pohybMaterialu.getPocet() > materialDao.dajMaterialById(idMaterialu).getStav()){
         JOptionPane.showMessageDialog(null, "Nie je dostatok materiálu na sklade!");
        }else{   
        
        pohybMaterialuDao.pridajPohybMaterialuVydaj(pohybMaterialu);        
        DefaultTableModel model= (DefaultTableModel) materialTable.getModel();        
        model.addRow(new Object[]{pohybMaterialuDao.getLastId(),idMaterialu,materialDao.dajMaterialById(idMaterialu).getNazov(),new DecimalFormat("##.##").format(cena).replace(',','.'),pocet});        
        cenaSpoluTextField.setText(new DecimalFormat("##.##").format(sumaSpolu(model,3,4)).replace(',','.'));
        
        }
       
        }else{
            JOptionPane.showMessageDialog(null, "Material sa nenachadza na sklade");
       }
        
    }//GEN-LAST:event_pridajMaterialuButtonActionPerformed

    private void potvrdVydajkuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potvrdVydajkuButtonActionPerformed
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());       
         Pouzivatel  p =  pouzivatelDao.dajPouzivatela(uzivatelLabel.getText());
        Vydajka vydajka = new Vydajka();        
        vydajka.setId_pouzivatel(p.getId());     
        vydajka.setDatum(timeStamp);  
        vydajka.setTyp_pohybu(2L);
       // vydajka.setId(vydajkaDao.getLastId());
      
        vydajka.setCena(Double.parseDouble(cenaSpoluTextField.getText()));
        upravStavMaterialu((DefaultTableModel)materialTable.getModel());
        vydajkaDao.pridajVydajku(vydajka); 
        int idVydajky =vydajkaDao.getLastId();
       
        
        MainScreen main = new MainScreen();                       
        main.setVisible(true);
        main.uzivatelLable.setText(this.uzivatelLabel.getText());
        this.setVisible(false);
        dispose();
        
    }//GEN-LAST:event_potvrdVydajkuButtonActionPerformed

    private void stornoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stornoButtonActionPerformed
        vydajkaDao.odstranVydajku(vydajkaDao.dajVydajkaById((long)vydajkaDao.getLastId()));
        MainScreen main = new MainScreen();
        main.setVisible(true);
        main.uzivatelLable.setText(this.uzivatelLabel.getText());
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_stornoButtonActionPerformed

    private void cenaSpoluTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cenaSpoluTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cenaSpoluTextFieldActionPerformed

    private void vymazPohybMaterialuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vymazPohybMaterialuButtonActionPerformed
        int row = materialTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) materialTable.getModel();
        long id = (Long) model.getValueAt(row, 0);
        long idMaterialu = (Long) model.getValueAt(row, 1);
        double pocet = (Double) model.getValueAt(row, 4);      
        pohybMaterialuDao.odstranPohybMaterialu(pohybMaterialuDao.dajPohybMaterialuById(id));
        model.removeRow(row);
        cenaSpoluTextField.setText(new DecimalFormat("##.##").format(sumaSpolu(model,3,4)));

    }//GEN-LAST:event_vymazPohybMaterialuButtonActionPerformed

    private void idMaterualuTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMaterualuTextFieldMouseClicked
       if(evt.getClickCount()==2){
           VyhliadavanieMaterialScreen VMS = new VyhliadavanieMaterialScreen(null,this,2);
           VMS.uzivatelLabel.setText(this.uzivatelLabel.getText());
           VMS.jLabel3.setText("Vydajka");
           VMS.setVisible(true);
           this.setVisible(false);
       }
      //     dispose();
    }//GEN-LAST:event_idMaterualuTextFieldMouseClicked

    private void idMaterualuTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idMaterualuTextFieldActionPerformed
        
    }//GEN-LAST:event_idMaterualuTextFieldActionPerformed
    
    public double sumaSpolu(DefaultTableModel mdl, int columnCena, int columnPocet) {
    double total = 0;
    // iterate over all columns
    for (int i = 0 ; i < mdl.getRowCount() ; i++) {
        // null or not Integer will throw exception
        
        total += Double.parseDouble((String) mdl.getValueAt(i, columnCena)) * (Double) mdl.getValueAt(i, columnPocet);
    }
    return total;
}
    
    public void upravStavMaterialu(DefaultTableModel mdl){
      long idMaterialu;
     double pocet;         
     for (int i = 0 ; i < mdl.getRowCount() ; i++) {
        idMaterialu =  (Long) mdl.getValueAt(i,1);
        pocet = (Double) mdl.getValueAt(i, 4);      
        if(pocet > materialDao.dajMaterialById(idMaterialu).getStav()){
         JOptionPane.showMessageDialog(null, "Nie je dostatok materiálu na sklade!");
        }else{
         
        materialDao.upravStavMaterial(idMaterialu, pocet, 2);
              
        }
    } 
    
  
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
            java.util.logging.Logger.getLogger(VytvorVydajkuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VytvorVydajkuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VytvorVydajkuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VytvorVydajkuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VytvorVydajkuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cenaLabel;
    private javax.swing.JTextField cenaSpoluTextField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idMaterialuLabel;
    public javax.swing.JTextField idMaterualuTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable materialTable;
    private javax.swing.JLabel pocetLabel;
    private javax.swing.JTextField pocetTextField;
    private javax.swing.JButton potvrdVydajkuButton;
    private javax.swing.JButton pridajMaterialuButton;
    private javax.swing.JButton stornoButton;
    public javax.swing.JLabel uzivatelLabel;
    private javax.swing.JButton vymazPohybMaterialuButton;
    // End of variables declaration//GEN-END:variables
}
