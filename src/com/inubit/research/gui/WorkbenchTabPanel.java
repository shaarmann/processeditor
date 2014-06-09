/**
 *
 * Process Editor - inubit Workbench Package
 *
 * (C) 2009, 2010 inubit AG
 * (C) 2014 the authors
 * 
 */
package com.inubit.research.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import net.frapu.code.visualization.ProcessEditor;

/**
 *
 * @author fpu
 */
public class WorkbenchTabPanel extends javax.swing.JPanel {

    private String title;
    private ProcessEditor editor;
    private Workbench workbench;

    /** Creates new form WorkbenchTabPanel */
    public WorkbenchTabPanel(Workbench workbench, ProcessEditor editor, String title) {
        initComponents();
        this.workbench = workbench;
        this.editor = editor;
        this.title = title;
        customInit();
    }

    public String getText() {
        return title;
    }

    public void setText(String title) {
        this.title = title;
        label.setText(title);
    }

    private void customInit() {
        label.setText(title);
        closeTabButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if model is dirty
                if (workbench.getSelectedModel().isDirty()) {
                    // Show warning
                    if (JOptionPane.showConfirmDialog(workbench,
                            "The model contains modifications. Really continue?",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE) != JOptionPane.OK_OPTION) {
                            return;
                    }
                }
                // Close this tab
                workbench.removeTab(editor);
                editor.dispose();
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeTabButton = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setOpaque(false);

        closeTabButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_tab.png"))); // NOI18N
        closeTabButton.setOpaque(false);
        closeTabButton.setPreferredSize(new java.awt.Dimension(16, 16));

        label.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(closeTabButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(label)
                .addComponent(closeTabButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeTabButton;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
