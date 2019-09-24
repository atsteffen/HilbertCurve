package app;

import javax.swing.JFrame;

import app.gui.HilbertCurvePanel;
import app.tools.HilbertCurve;
import app.tools.HilbertCurve2;

public class RunTestsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HilbertCurve testHilbert = new HilbertCurve(2);
		testHilbert.indexPopulate();
		testHilbert.printArray();
		
		System.out.println();
		
		HilbertCurve2 testHilbert2 = new HilbertCurve2(1);
		testHilbert2.indexPopulate();
		testHilbert2.printArray();
		
		JFrame frame = new JFrame();
		frame.setSize(650,700);
		HilbertCurvePanel newContentPane = new HilbertCurvePanel();
        frame.setContentPane(newContentPane);
        frame.setVisible(true);

	}

}
