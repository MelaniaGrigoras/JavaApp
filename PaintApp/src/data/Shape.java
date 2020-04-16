package data;

import app.Movable;

public abstract class Shape implements Movable {
	Point center;
	
	public abstract double getPerimeter();
	public abstract double getArea();
	public abstract double getDistanceFrom(Shape s);
	
	public Shape(Point p) {
		this.center = p;
	}
	
	public void moveUp() {
		center.y += MOVE_UNIT;
	}
	
	public void moveDown()
	{
		center.y -= MOVE_UNIT;
	}
	
	public void moveLeft() {
		center.x -= MOVE_UNIT;
	}
	
	public void moveRight() {
		center.x += MOVE_UNIT;
	}
	
	public String toString() {
		return "centrul de coordonate (" + center.x + ", " + center.y + ")";
	}
}
