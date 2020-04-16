package data;

public class Square extends Rectangle {
	double legth;
	
	public Square(Point center, double length) {
		super(center, length, length);
	}
	
	public String toString() {
		return super.toString();
	}
}
