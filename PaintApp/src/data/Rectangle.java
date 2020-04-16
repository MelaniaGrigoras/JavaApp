package data;

public class Rectangle extends Shape {
	double length;
	double width;
	
	public Rectangle(Point center, double width, double length) {
		super(center);
		this.width = width;
		this.length = length;
	}
	
	public double getDiagonal() {
		return Math.sqrt( length * length + width * width);
	}
	
	public double getPerimeter() {
		return 2 * (length + width);
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getDistanceFrom(Shape s) {
		return this.center.getDistanceFrom(s.center);
	}
	
	public String toString() {
		return "Dreptunghiul de lungime " + length + " si latime " + width + " cu " + super.toString();
	}
}