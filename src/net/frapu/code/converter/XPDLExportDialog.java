/**
 *
 * Process Editor
 *
 * (C) 2009 inubit AG
 * (C) 2014 the authors
 *
 */
package net.frapu.code.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jos
 */
public class XPDLExportDialog extends javax.swing.JDialog {

    public ConversiontSettingsDTO con;

    /** Creates new form XPDLExportDialo */
    public XPDLExportDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            con = new ConversiontSettingsDTO();
        } catch (Exception ex) {
            Logger.getLogger(XPDLExportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jCB_addLane = new javax.swing.JCheckBox();
        jCB_Gateway = new javax.swing.JCheckBox();
        jCB_laneRel = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("XPDL Export Settings");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCB_addLane.setText("Add Lane to Pool Without one");
        jCB_addLane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_addLaneActionPerformed(evt);
            }
        });

        jCB_Gateway.setText("Deprecated GatewayNames");

        jCB_laneRel.setText("Lanes have a realtive Position to their Pool");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jCB_laneRel)
                    .addComponent(jCB_Gateway)
                    .addComponent(jCB_addLane))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jCB_addLane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_Gateway)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_laneRel)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jCB_addLane.isSelected()) {
            con.setNeedsLanes(true);
        } else {
            con.setNeedsLanes(false);
        }

        if (jCB_Gateway.isSelected()) {
            con.setBizAgiGateways(true);
        } else {
            con.setBizAgiGateways(false);
        }

        if (jCB_laneRel.isSelected()) {
            con.setLanesRelativetoPool(true);
        } else {
            con.setLanesRelativetoPool(false);
        }

       

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCB_addLaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_addLaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_addLaneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                XPDLExportDialog dialog = new XPDLExportDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCB_Gateway;
    private javax.swing.JCheckBox jCB_addLane;
    private javax.swing.JCheckBox jCB_laneRel;
    // End of variables declaration//GEN-END:variables
}
