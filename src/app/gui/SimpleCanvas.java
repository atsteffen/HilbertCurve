package app.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SimpleCanvas extends JPanel{
	
	/**
	 *  member variables
	 */
	private static final long serialVersionUID = 1L;
	private int array2D[][];
	private boolean showColors;
	private boolean showNumbers;
	
   public SimpleCanvas() {
        setBackground(Color.WHITE);
        showColors = false;
        showNumbers = false;
    }
   
    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        if (array2D != null){
        	if (showColors){
            	printColorArray(g2);
        	}
        	if (showNumbers){
        		printNumberArray(g2);
        	}
        }
        
    }
    
    public void printNumberArray(Graphics2D g2) {
    	for (int i = 0; i < array2D.length; i++){
    		for (int j = 0; j < array2D[i].length; j++){
    			drawNumber(g2,array2D[i][j],i,j);
    		}
    	}
    }
    
    public void printColorArray(Graphics2D g2) {
    	for (int i = 0; i < array2D.length; i++){
    		for (int j = 0; j < array2D[i].length; j++){
    			drawColor(g2,array2D[i][j],i,j);
    		}
    	}
    }

	private void drawColor(Graphics2D g2, int value, int x, int y) {
		double fraction = (double)value/((double)array2D.length*array2D.length);
		int boxsize = 600/array2D.length;
		int red = 0;
		int green = 0;
		int blue = 0;
		if (fraction < 0.5){
			red = (int)((1.0-fraction*2.0)*255.0);
			green = (int)(fraction*2.0*255.0);
			blue = 0;
		}
		else {
			red = 0;
			green = (int)((2.0-fraction*2.0)*255.0);
			blue = (int)((fraction*2.0-1.0)*255.0);
		}
		g2.setColor(new Color(red, green, blue));
		g2.fillRect(x*boxsize+23, y*boxsize+10, boxsize-1, boxsize-1);
	}

	private void drawNumber(Graphics2D g2, int value, int x, int y) {
		int boxsize = 600/array2D.length;
		g2.setColor(Color.BLACK);
		int fontsize = java.lang.Math.max(20-array2D.length/2,6);
		g2.setFont(new Font(null,Font.PLAIN,fontsize));
		g2.drawString(Integer.toString(value), x*boxsize+25, y*boxsize+25);	
	}

	public int[][] getArray2D() {
		return array2D;
	}

	public void setArray2D(int array2D[][]) {
		this.array2D = array2D;
	}
	
	public void setShowColors(){
		showColors = !showColors;
	}
	
	public void setShowNumbers(){
		showNumbers = !showNumbers;
	}
}
