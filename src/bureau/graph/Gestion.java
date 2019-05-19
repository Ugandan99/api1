/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.graph;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import myconnections.DBConnection;
import bureau.DAO.BureauDAO;
import bureau.DAO.UtilisateurDAO;
/**
 *
 * @author Valentin
 */
public class Gestion extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    CardLayout cardl;

    public Gestion() {
        initComponents();
        cardl = (CardLayout) this.getContentPane().getLayout();
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("Connexion invalide");
            JOptionPane.showMessageDialog(this, "Connexion invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

        BureauDAO bureauDAO = new BureauDAO();
        bureauDAO.setConnection(dbConnect);
        UtilisateurDAO utilDAO = new UtilisateurDAO();
        utilDAO.setConnection(dbConnect);
        creabur1.setBureauDAO(bureauDAO);
        rechdescbur1.setBureauDAO(bureauDAO);
        rechidbur1.setBureauDAO(bureauDAO);
        rechidbur1.setUtilisateurDAO(utilDAO);
        /*rechCliNum.setClientDAO(clientDAO);
        rechNom.setClientDAO(clientDAO);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accueil1 = new bureau.graph.Accueil();
        modifbur1 = new bureau.graph.modifbur();
        rechdescbur1 = new bureau.graph.rechdescbur();
        suppbur1 = new bureau.graph.suppbur();
        creabur1 = new bureau.graph.creabur();
        rechidbur1 = new bureau.graph.rechidbur();
        jMenuBar1 = new javax.swing.JMenuBar();
        Bur = new javax.swing.JMenu();
        creerbur = new javax.swing.JMenuItem();
        modifbur = new javax.swing.JMenuItem();
        suppbur = new javax.swing.JMenuItem();
        rechbur = new javax.swing.JMenuItem();
        rechdescbur = new javax.swing.JMenuItem();
        Emp = new javax.swing.JMenu();
        creeremp = new javax.swing.JMenuItem();
        rechemp = new javax.swing.JMenuItem();
        modifemp = new javax.swing.JMenuItem();
        suppemp = new javax.swing.JMenuItem();
        affemp = new javax.swing.JMenuItem();
        Mess = new javax.swing.JMenu();
        affenv = new javax.swing.JMenuItem();
        affrecu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(621, 410));
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(accueil1, "card2");

        javax.swing.GroupLayout modifbur1Layout = new javax.swing.GroupLayout(modifbur1);
        modifbur1.setLayout(modifbur1Layout);
        modifbur1Layout.setHorizontalGroup(
            modifbur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        modifbur1Layout.setVerticalGroup(
            modifbur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        getContentPane().add(modifbur1, "card4");

        javax.swing.GroupLayout rechdescbur1Layout = new javax.swing.GroupLayout(rechdescbur1);
        rechdescbur1.setLayout(rechdescbur1Layout);
        rechdescbur1Layout.setHorizontalGroup(
            rechdescbur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        rechdescbur1Layout.setVerticalGroup(
            rechdescbur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        getContentPane().add(rechdescbur1, "card5");

        javax.swing.GroupLayout suppbur1Layout = new javax.swing.GroupLayout(suppbur1);
        suppbur1.setLayout(suppbur1Layout);
        suppbur1Layout.setHorizontalGroup(
            suppbur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        suppbur1Layout.setVerticalGroup(
            suppbur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        getContentPane().add(suppbur1, "card7");
        getContentPane().add(creabur1, "card3");
        getContentPane().add(rechidbur1, "card8");

        Bur.setText("Bureau");
        Bur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BurActionPerformed(evt);
            }
        });

        creerbur.setText("Nouveau");
        creerbur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerburActionPerformed(evt);
            }
        });
        Bur.add(creerbur);

        modifbur.setText("Modifier ");
        modifbur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifburActionPerformed(evt);
            }
        });
        Bur.add(modifbur);

        suppbur.setText("Suppression");
        suppbur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppburActionPerformed(evt);
            }
        });
        Bur.add(suppbur);

        rechbur.setText("Recherche id");
        rechbur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechburActionPerformed(evt);
            }
        });
        Bur.add(rechbur);

        rechdescbur.setText("Recherche description");
        rechdescbur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechdescburActionPerformed(evt);
            }
        });
        Bur.add(rechdescbur);

        jMenuBar1.add(Bur);

        Emp.setText("Employés");

        creeremp.setText("Nouveau");
        creeremp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerempActionPerformed(evt);
            }
        });
        Emp.add(creeremp);

        rechemp.setText("Recherche");
        rechemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechempActionPerformed(evt);
            }
        });
        Emp.add(rechemp);

        modifemp.setText("Modifier bureau");
        modifemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifempActionPerformed(evt);
            }
        });
        Emp.add(modifemp);

        suppemp.setText("Supprimer");
        suppemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppempActionPerformed(evt);
            }
        });
        Emp.add(suppemp);

        affemp.setText("Afficher par bureau");
        affemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affempActionPerformed(evt);
            }
        });
        Emp.add(affemp);

        jMenuBar1.add(Emp);

        Mess.setText("Messages");

        affenv.setText("Afficher envoyés");
        affenv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affenvActionPerformed(evt);
            }
        });
        Mess.add(affenv);

        affrecu.setText("Afficher reçus");
        affrecu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affrecuActionPerformed(evt);
            }
        });
        Mess.add(affrecu);

        jMenuBar1.add(Mess);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creerburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerburActionPerformed

        cardl.show(this.getContentPane(), "card3");
    }//GEN-LAST:event_creerburActionPerformed

    private void rechburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechburActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "card8");
    }//GEN-LAST:event_rechburActionPerformed

    private void rechdescburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechdescburActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "card5");
    }//GEN-LAST:event_rechdescburActionPerformed

    private void suppburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppburActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "card7");
        
    }//GEN-LAST:event_suppburActionPerformed

    private void creerempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creerempActionPerformed

    private void modifempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifempActionPerformed

    private void suppempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppempActionPerformed

    private void affempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_affempActionPerformed

    private void affenvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affenvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_affenvActionPerformed

    private void affrecuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affrecuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_affrecuActionPerformed

    private void rechempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechempActionPerformed

    private void BurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BurActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BurActionPerformed

    private void modifburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifburActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "card4");
    }//GEN-LAST:event_modifburActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Bur;
    private javax.swing.JMenu Emp;
    private javax.swing.JMenu Mess;
    private bureau.graph.Accueil accueil1;
    private javax.swing.JMenuItem affemp;
    private javax.swing.JMenuItem affenv;
    private javax.swing.JMenuItem affrecu;
    private bureau.graph.creabur creabur1;
    private javax.swing.JMenuItem creerbur;
    private javax.swing.JMenuItem creeremp;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem modifbur;
    private bureau.graph.modifbur modifbur1;
    private javax.swing.JMenuItem modifemp;
    private javax.swing.JMenuItem rechbur;
    private javax.swing.JMenuItem rechdescbur;
    private bureau.graph.rechdescbur rechdescbur1;
    private javax.swing.JMenuItem rechemp;
    private bureau.graph.rechidbur rechidbur1;
    private javax.swing.JMenuItem suppbur;
    private bureau.graph.suppbur suppbur1;
    private javax.swing.JMenuItem suppemp;
    // End of variables declaration//GEN-END:variables
}