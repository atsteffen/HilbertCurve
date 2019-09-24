package app;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

import app.gui.HilbertCurvePanel;


public class HilbertCurveApplet extends JApplet{

	private static final long serialVersionUID = 1L;

	//Called when this applet is loaded into the browser.
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) { 
            System.err.println("createGUI didn't complete successfully");
        }
    }
    
	private void createGUI() {
	
		setSize(650,650);
		HilbertCurvePanel newContentPane = new HilbertCurvePanel();
        newContentPane.setOpaque(true); 
        setContentPane(newContentPane);		
	}

}
