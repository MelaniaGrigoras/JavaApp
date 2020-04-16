package data;

public class Point {
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public double getDistanceFrom(Point p) {
		return Math.sqrt( (p.x-this.x) * (p.x-this.x) + (p.y-this.y) * (p.y-this.y) );
	}
}
