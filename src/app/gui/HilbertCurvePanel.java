package app.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.tools.HilbertCurve;

public class HilbertCurvePanel extends JPanel implements ActionListener{
	
	/**
	 *  locals
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nValueText;
	private SimpleCanvas curveCanvas;

	public HilbertCurvePanel(){
		
		super(new BorderLayout());
		
		// Panel 1 (Top): panel with N value input and buttons
		JPanel mainPanelInstructions = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
		JLabel nValueLabel = new JLabel("N: ");
		nValueText = new JTextField("0");
		nValueText.setColumns(3);
		nValueText.addActionListener(this);
		
		JButton showNums = new JButton("Numbers");
		showNums.addActionListener(this);
		
		JButton showColors = new JButton("Colors");
		showColors.addActionListener(this);
		
		mainPanelInstructions.add(nValueLabel);
		mainPanelInstructions.add(nValueText);
		mainPanelInstructions.add(showNums);
		mainPanelInstructions.add(showColors);
		
		// Panel 2 (Center): drawing canvas
		curveCanvas = new SimpleCanvas();
		
		// Add Sub-panels to main content panel
		add(mainPanelInstructions, BorderLayout.NORTH);
		add(curveCanvas, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		// get level and keep it within reasonable size limits
		int level = 2;
		if (nValueText != null){
			level = Integer.parseInt(nValueText.getText());
		}
		if (level > 5) level = 5;
		if (level < 0) level = 0;
		
		// rebuild HilbertCurve
		HilbertCurve testHilbert = new HilbertCurve(level);
		testHilbert.indexPopulate();
		curveCanvas.setArray2D(testHilbert.getArray());
		
		if (cmd.equals("Numbers")) curveCanvas.setShowNumbers();
		if (cmd.equals("Colors")) curveCanvas.setShowColors();

		curveCanvas.repaint();
	}

}
