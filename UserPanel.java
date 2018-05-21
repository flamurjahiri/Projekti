/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekti;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Flamur
 */
public class UserPanel extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;

    /**
     * Creates new form UserPanel
     */
    public UserPanel() throws IOException {
        initComponents();
        setTitle("UserPanel : ");
        setSize(410, 358);
        setLocationRelativeTo(null);
        setVisible(true);

        RecetMapper rm1 = new RecetMapper();
        for (int i = 0; i < rm1.getRecetat().size(); i++) {
            choice1.add(rm1.getRecetat().get(i));

        }


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        choice1 = new java.awt.Choice();
        jButton1 = new javax.swing.JButton();

        jButton1.setText("Hap Receten");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RecetaException ex) {
                    Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(257, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, RecetaException {
        HapRecetenFrame obj = new HapRecetenFrame(choice1.getSelectedItem());
        this.setVisible(false);
    }
    // End of variables declaration                   
}
