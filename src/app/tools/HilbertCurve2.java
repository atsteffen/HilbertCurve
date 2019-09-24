package app.tools;

public class HilbertCurve2 extends HilbertCurve{

	public HilbertCurve2(int level) {
		super(level);
		this.size = level;
		resizeArray((int)java.lang.Math.pow (3,this.size));
	}
	
    @Override protected void hilbert2D(int level, double angle){
		
		//"X" -> "XFYFX+F+YFXFY-F-XFYFX"
		
		if (level == 0) {
			array2D[pos[0]][pos[1]] = distance++;
			return;
		}
		
	    hilbert2D(level - 1, angle);
	    forward();
	    hilbert2D(level - 1, -angle);
	    forward();
	    hilbert2D(level - 1, angle);
	    
	    turn(angle);
	    forward();
	    turn(angle);
	    
	    hilbert2D(level - 1, -angle);
	    forward();
	    hilbert2D(level - 1, angle);
	    forward();
	    hilbert2D(level - 1, -angle);
	    
	    turn(-angle);
	    forward();
	    turn(-angle);
	    
	    hilbert2D(level - 1, angle);
	    forward();
	    hilbert2D(level - 1, -angle);
	    forward();
	    hilbert2D(level - 1, angle);

	}

}
