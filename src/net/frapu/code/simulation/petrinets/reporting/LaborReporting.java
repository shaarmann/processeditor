/**
 *
 * Process Editor - Simulation Reporting Package
 *
 * (C) 2008,2009 Frank Puhlmann
 *
 * http://frapu.net
 *
 */
package net.frapu.code.simulation.petrinets.reporting;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import net.frapu.code.simulation.petrinets.LaneReport;
import net.frapu.code.simulation.petrinets.PetriNetSimulation;
import net.frapu.code.simulation.petrinets.PetriNetSimulationListener;
import net.frapu.code.visualization.ProcessEditor;
import net.frapu.code.visualization.ProcessNode;
import net.frapu.code.visualization.petrinets.LaborPlace;
import net.frapu.code.visualization.reporting.PieChart;
import net.frapu.code.visualization.reporting.ReportingModel;

/**
 *
 * @author fpu
 */
public class LaborReporting extends javax.swing.JPanel implements PetriNetSimulationListener {

	private static final long serialVersionUID = -7074228318708496238L;
	private ProcessEditor editor;
    private ReportingModel model;
    private PetriNetSimulation sim;
    private PieChart chart1;
    private PieChart chart2;

    /** Creates new form CostReporting */
    public LaborReporting(PetriNetSimulation sim) {
        // Initialize components
        initComponents();
        initCustomComponents();
        // Register listener
        this.sim = sim;
        sim.addListener(this);
    }

    public void initCustomComponents() {
        // Initialize model
        model = new ReportingModel("Labor");

        chart1 = new PieChart();
        chart1.setSize(220, 220);
        chart1.setPos(125, 125);
        chart1.setText("Labor Distribution");
        model.addNode(chart1);
        chart1.setProperty(PieChart.PROP_VALUES, "");

        chart2 = new PieChart();
        chart2.setSize(220, 220);
        chart2.setPos(365, 125);
        chart2.setText("Avg Lane Times");
        model.addNode(chart2);
        chart2.setProperty(PieChart.PROP_VALUES, "");

        // Create editor and add to ViewportView
        editor = new ProcessEditor(model);
        jScrollPane1.setViewportView(editor);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void refreshDisplay() {
        // ignore
    }

    public void simulationFinished() {
        // Data lists
        LinkedList<Integer> laborDistData = new LinkedList<Integer>();
        LinkedList<Integer> laneData = new LinkedList<Integer>();
        // Lanes
        String laneLabels = "";
        String laborLabels = "";
        // Retrieve labor labels
        for (ProcessNode n : sim.getModel().getNodes()) {
            if (n instanceof LaborPlace) {
                LaborPlace lp = (LaborPlace) n;
                laborLabels += lp.getText() + ",";
                laborDistData.add(lp.getTokenCount());
            }
        }
        List<LaneReport> sortedReports = new LinkedList<LaneReport>();
        // Check if Lane label matches laborLabel
        StringTokenizer st = new StringTokenizer(laborLabels, ",");
        int index = 0;
        //boolean found = false;
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            // Iterate over all reports
            for (LaneReport r : sim.getLaneReports()) {
                if (name.startsWith(r.getLaneName())) {
                    // Add to sortedReports
                    sortedReports.add(r);
                    //found = true;
                    break;
                }
            }
            index++;
        }
        // Add remaining reports
        for (LaneReport r: sim.getLaneReports()) {
            if (!sortedReports.contains(r)) sortedReports.add(r);
        }


        // Retrieve lane data
        int outerIndex = 0;
        for (LaneReport r : sortedReports) {
            laneLabels += r.getLaneName() + ",";

            try {
                laneData.add((int) Double.parseDouble(r.getLaneResult(LaneReport.LANE_DUR_AVG)));
            } catch (Exception e) {
                chart2.setErrorMessage("Error parsing data!");
            }
            outerIndex++;
        }
        if (laneLabels.length() > 0) {
            laneLabels = laneLabels.substring(0, laneLabels.length() - 1);
        }
        if (laborLabels.length() > 0) {
            laborLabels = laborLabels.substring(0, laborLabels.length() - 1);
        }

        chart1.setProperty(PieChart.PROP_LABELS, laborLabels);

        chart1.setData(laborDistData);

        chart2.setProperty(PieChart.PROP_LABELS, laneLabels);

        chart2.setData(laneData);

        repaint();
    }

    public void simulationStarted() {
        // Reset values
        chart1.setData(null);
        chart2.setData(null);
        repaint();

    }
}
