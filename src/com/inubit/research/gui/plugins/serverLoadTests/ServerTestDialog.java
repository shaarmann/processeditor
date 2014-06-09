/**
 *
 * Process Editor - inubit Workbench Server Load Test Plugin Package
 *
 * (C) 2009, 2010 inubit AG
 * (C) 2014 the authors
 *
 */
package com.inubit.research.gui.plugins.serverLoadTests;

import com.inubit.research.client.XMLHttpRequestException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import net.frapu.code.visualization.Configuration;
import net.frapu.code.visualization.ProcessModel;
import net.frapu.code.visualization.reporting.BarChart;

import org.w3c.dom.Document;

import com.inubit.research.client.ModelServer;
import com.inubit.research.client.XmlHttpRequest;
import com.inubit.research.gui.plugins.serverLoadTests.LoadTestConfiguration;
import com.inubit.research.server.ProcessEditorServerUtils;
import com.inubit.research.testUtils.ModelGenerator;
import com.inubit.research.testUtils.Seed;
import net.frapu.code.visualization.bpmn.BPMNModel;

/**
 *
 * @author jos
 */
public class ServerTestDialog extends javax.swing.JDialog implements Observer {

	private static final long serialVersionUID = 6609534777424443140L;
	private ProcessModel currentModel;
    private int finishedThreads;
    private Vector<Thread> threads;
    private int nodeNummer, finishedNodes;
    private Vector<BufferedImage> chartsImages;
    public final static String CONF_SERVER_URI = "server_uri";

    /** Creates new form ServerTestDialog */
    public ServerTestDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Configuration conf = Configuration.getInstance();
        jTx_URL.setText(conf.getProperty(CONF_SERVER_URI, "http://localhost:1205"));
        connectToServerAction();
    }

    public void setCurrentModel(ProcessModel currentModel) {
        this.currentModel = currentModel;
    }

    private void connectToServerAction() {
        // Try to fetch list of models from server
        jTx_URL.setBackground(Color.WHITE);
        try {
            ModelServer server = new ModelServer(URI.create(jTx_URL.getText()), "/",LoadTestConfiguration.getCredentials());
            server.getDirectory();
            Configuration conf = Configuration.getInstance();
            conf.setProperty(CONF_SERVER_URI, jTx_URL.getText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            jTx_URL.setBackground(Color.RED);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTx_URL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner_User = new javax.swing.JSpinner();
        jTX_testrun = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner_Delay = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jPB_Nodes = new javax.swing.JProgressBar();
        jc_Results = new javax.swing.JComboBox();
        jp_Charts = new ImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ProcessEditor Server Test");

        jButton1.setText("Start Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("ServerUrl");

        jTx_URL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTx_URLActionPerformed(evt);
            }
        });

        jLabel2.setText("Example: http://novplex:1205/");

        jLabel3.setText("Number of Users");

        jSpinner_User.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jTX_testrun.setText("Ready to run");

        jLabel4.setText("Delay in msec");

        jSpinner_Delay.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(100), null, Integer.valueOf(100)));

        jButton2.setText("Abort");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jc_Results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_ResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_ChartsLayout = new javax.swing.GroupLayout(jp_Charts);
        jp_Charts.setLayout(jp_ChartsLayout);
        jp_ChartsLayout.setHorizontalGroup(
            jp_ChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        jp_ChartsLayout.setVerticalGroup(
            jp_ChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_Charts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinner_User)
                                    .addComponent(jTx_URL, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jSpinner_Delay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPB_Nodes, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTX_testrun)
                        .addContainerGap(344, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jc_Results, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTx_URL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner_Delay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jc_Results, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_Charts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jTX_testrun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPB_Nodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (threads == null) {
                threads = new Vector<Thread>();
            }
            jc_Results.removeAllItems();
            chartsImages = new Vector<BufferedImage>();
            threads.removeAllElements();
            String uri = jTx_URL.getText();
            URI test = new URI(uri);
            test.toURL().openConnection();
            XmlHttpRequest req = new XmlHttpRequest(URI.create(uri + "/models"));
            try {
                req.addCredentials(LoadTestConfiguration.getCredentials());
            } catch (Exception ex) {
                Logger.getLogger(ServerTestDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            Document models = null;
            try {
                models = req.executeGetRequest();
            } catch (XMLHttpRequestException ex) {
                Logger.getLogger(ServerTestDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (models == null) {
                throw new IOException();
            }
            finishedThreads = 0;
            finishedNodes = 0;
            int threadNr = (Integer) jSpinner_User.getValue();
            // Calculate
            //Test
            Seed seed = new Seed();
            ModelGenerator gen = new ModelGenerator();
            currentModel = gen.generate(seed, BPMNModel.class, 50, 50);
            nodeNummer = (currentModel.getNodes().size() + currentModel.getEdges().size()) * threadNr;
            for (int i = 1; i <= threadNr; i++) {
                ServerTestThread thr = new ServerTestThread(currentModel.getProcessName(), (Integer) jSpinner_Delay.getValue(), jTx_URL.getText());
                thr.setTestModel(currentModel);
                jTX_testrun.setForeground(Color.red);
                jTX_testrun.setText("running");
                thr.addObserver(this);
                Thread t1 = new Thread(thr);
                threads.add(t1);
                t1.start();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ServerTestDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Your Server Url seems to be incorrect: " + ex.getMessage(), "ServerUrl incorrect", WIDTH);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(this, "Your Server Url seems to be incorrect: " + ex.getMessage(), "ServerUrl incorrect", WIDTH);
            Logger.getLogger(ServerTestDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No Connection to Server, is Server running?", "No Connection", WIDTH);
            Logger.getLogger(ServerTestDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * 
     * @param evt
     */
    @SuppressWarnings("deprecation")
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < threads.size(); i++) {
            Thread thread = threads.elementAt(i);
            thread.stop();
        }
        jTX_testrun.setText("Ready to Run");
        jTX_testrun.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
	 * @param evt  
	 */
    private void jc_ResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_ResultsActionPerformed
        int index = jc_Results.getSelectedIndex();
        try {
            BufferedImage img = chartsImages.get(index);
            ((ImagePanel) jp_Charts).setImage(img);
            this.repaint();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jc_ResultsActionPerformed

    private void jTx_URLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTx_URLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTx_URLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ServerTestDialog dialog = new ServerTestDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jPB_Nodes;
    private javax.swing.JSpinner jSpinner_Delay;
    private javax.swing.JSpinner jSpinner_User;
    private javax.swing.JLabel jTX_testrun;
    private javax.swing.JTextField jTx_URL;
    private javax.swing.JComboBox jc_Results;
    private javax.swing.JPanel jp_Charts;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg) {
        if (arg != null) {
            if (((String) arg).equals("node")) {
                finishedNodes++;
                Double progress = ((double) finishedNodes / (double) nodeNummer) * 100;
                System.out.println(progress);
                jPB_Nodes.setValue(progress.intValue());
            }
        } else {
            finishedThreads++;
            BarChart chart = new BarChart();
            chart.setText("Response Time of Server");
            chart.setXLabel("Request");
            chart.setYLabel("msec");
            HashMap<String, Integer> data = ((ServerTestThread) o).getExecutionMap();
            List<Integer> dataList = new ArrayList<Integer>(data.values());
            if (dataList != null) {
                chart.setData(dataList);
            }
            List<String> labelList = new ArrayList<String>(data.keySet());
            if (labelList.size() > 0) {
                chart.setLabels(labelList);
                BufferedImage img = ProcessEditorServerUtils.createNodeImage(chart);
                chartsImages.add(img);
            }
            jc_Results.addItem("Thread " + finishedThreads);
            if (finishedThreads == threads.size()) {
                jTX_testrun.setText("Ready to Run");
                jTX_testrun.setForeground(Color.BLACK);
            }
        }
    }
}
    

