package app.tools;

public class HilbertCurve {
	
	protected int array2D[][];
	protected int size;
	protected int dir[];
	protected int pos[];
	protected int distance;
	
	public HilbertCurve(int level){
		this.size = level;
		resizeArray((int)java.lang.Math.pow (2,this.size));
	}

	protected void resizeArray(int dimension){	
		array2D = new int[dimension][];
		for (int i = 0; i < dimension; i++){
			array2D[i] = new int[dimension];
		}	
	}
	
	public void indexPopulate(){
		this.distance = 0;
		this.dir = new int[]{0,1};
		this.pos = new int[]{0,0};
		hilbert2D(this.size,90.0);
	}
	
	protected void hilbert2D(int level, double angle){
		
		//"L" -> "+RF-LFL-FR+"
		
		if (level == 0) {
			array2D[pos[0]][pos[1]] = distance++;
			return;
		}
		
	    turn(angle);
	    hilbert2D(level - 1, -angle);
	    forward();
	    turn(-angle);
	    hilbert2D(level - 1, angle);
	    forward();
	    hilbert2D(level - 1, angle);
	    turn(-angle);
	    forward();
	    hilbert2D(level - 1, -angle);
	    turn(angle);

	}
	
	public void printArray(){
		for (int i = 0; i<array2D.length; i++){
			for(int j = 0; j<array2D.length; j++){
				System.out.print(array2D[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	protected void turn(double angle){
		int direction = (int)java.lang.Math.sin(java.lang.Math.PI*angle/180);
		
		int temp = dir[0];
		dir[0] = direction*dir[1];
		dir[1] = -direction*temp;
	}
	
	protected void forward(){
		pos[0] = pos[0]+dir[0];
		pos[1] = pos[1]+dir[1];
	}

	public int[][] getArray() {
		return array2D;
	}

}
