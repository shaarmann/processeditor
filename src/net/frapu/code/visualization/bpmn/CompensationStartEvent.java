/**
 *
 * Process Editor - BPMN Package
 *
 * (C) 2008,2009 Frank Puhlmann
 *
 * http://frapu.net
 *
 */
package net.frapu.code.visualization.bpmn;

import java.awt.Graphics2D;

/**
 *
 * @author frank
 */
public class CompensationStartEvent extends StartEvent {

    protected void drawMarker(Graphics2D g2) {
        this.drawCompensation(g2);
    }

}
