/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.graph;

import javax.swing.JOptionPane;
import messages.metier.Message;
import messages.metier.Message;
import messages.metier.Utilisateur;
import bureau.DAO.UtilisateurDAO;
import messages.metier.Infos;
import bureau.DAO.InfosDAO;
import bureau.DAO.MessageDAO;
import java.util.Scanner;
import bureau.DAO.BureauDAO;
import bureau.DAO.DAO;
import java.sql.SQLException;
import java.util.List;
import messages.metier.Bureau;
import myconnections.DBConnection;

/**
 *
 * @author USER
 */
public class affenv extends javax.swing.JPanel {

    MessageDAO messDAO = null;
    Bureau m2 = null;

    /**
     * Creates new form affenv
     */
    public affenv() {
        initComponents();

    }

    public void setMessageDAO(MessageDAO messDAO) {
        this.messDAO = messDAO;
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
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        valider = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmessage = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Afficher les messages envoyés par un utilisateur");

        lblid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblid.setText("Id de l'utilisateur :");

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        txtmessage.setColumns(20);
        txtmessage.setRows(5);
        jScrollPane1.setViewportView(txtmessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(lblid)
                        .addGap(30, 30, 30)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(valider)))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valider)
                    .addComponent(lblid))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        // TODO add your handling code here:
        if (txtid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucune valeur entrée", "ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            int idemp = Integer.parseInt(txtid.getText());
            String total = "";
            int cpt=0;
            String cours ="";
            try {
                List<Message> alc = messDAO.search(idemp);
                for (Message m1 : alc) {
                    cpt++;
                    cours=m1.getDateenvoi()+"\nMessage numero : " + cpt + " envoyé au matricule " +m1.getDest()+" Contenu : \n"+m1.getContenu()+"\n\n";
                    total = total+cours;
                }
                txtmessage.setText("" + total);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_validerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextArea txtmessage;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
