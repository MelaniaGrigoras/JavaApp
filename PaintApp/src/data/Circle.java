package data;

public class Circle extends Shape{
	public double radius;
	
	public Circle(Point center, double radius){
		super(center);
		this.radius = radius;
	}
		
	public double getRadius() {
		return radius;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getDistanceFrom(Shape s) {
		return this.center.getDistanceFrom(s.center);
	}
	
	public String toString() {
		return "Cercul de raza " + radius + " si " + super.toString();
	}
}