package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ViewTest extends JPanel {
    public ViewTest() {
    	
    }
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	String s1 = "1. 17130202 - Nguyen Tan Tai";
    	String s2 = "1. 17130202 - Nguyen Tan Tai";
    	String s3 = "1. 17130202 - Nguyen Tan Tai";
    	String s4 = "1. 17130202 - Nguyen Tan Tai";
    	String s5 = "1. 17130202 - Nguyen Tan Tai";
    	g.drawString(s1, 100, 200);
    	g.drawString(s2, 100, 205);
    	g.drawString(s3, 100, 210);
    	g.drawString(s4, 100, 225);
    	g.drawString(s5, 100, 220);
    	
    }
}
