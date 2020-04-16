package app;

import java.util.NoSuchElementException;
import java.util.Scanner;

import data.Circle;
import data.Point;
import data.Rectangle;
import data.Shape;
import data.Square;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Circle circle = (Circle) readCoordinates();
		Rectangle rectangle = (Rectangle) readCoordinates();
		Square square = (Square) readCoordinates();
		
//		Circle circle = new Circle(new Point(0, 0), 5);
//		Rectangle rectangle = new Rectangle(new Point(4, 10), 10, 5);
//		Square square = new Square(new Point(10, 1), 4);
		
		System.out.println("Distanța cerc – dreptunghi : " + circle.getDistanceFrom(rectangle));
		System.out.println("Distanța dreptunghi – pătrat : " + rectangle.getDistanceFrom(square));
		System.out.println("Distanța pătrat – cerc : " + square.getDistanceFrom(circle));
	
		System.out.println("\nHow many shapes do you want o move?");
		int nr = scanner.nextInt();
		while(nr > 0)
		{
			System.out.println("Which shape do you want to move? (Choose between 1, 2 or 3)");
			System.out.println("1. Circle\n2. Rectangle\n3. Square");
			int option = scanner.nextInt();
			
			System.out.println("Where do you want to move the shape? (Choose between up, down, left, right)");
			String s = scanner.next();
			
			switch(option) {
			case 1:
				move(circle, s);
				break;
			case 2:
				move(rectangle, s);
				break;
			case 3:
				move(square, s);
				break;
			default:
				System.out.println("Invalid option");
				continue;
			}
			nr--;
	    }
	
		System.out.println("");
		
		System.out.println("Distanța cerc – dreptunghi : " + circle.getDistanceFrom(rectangle));
		System.out.println("Distanța dreptunghi – pătrat : " + rectangle.getDistanceFrom(square));
		System.out.println("Distanța pătrat – cerc : " + square.getDistanceFrom(circle));
	
		scanner.close();
	}
	
	public static void move(Shape shape, String command) {
		switch(command.toLowerCase()) {
			case "up":
				shape.moveUp();
				break;
				
			case "down":
				shape.moveDown();
				break;
				
			case "left":
				shape.moveLeft();
				break;
				
			case "right":
				shape.moveRight();
				break;
			
			default:
				System.out.println("Invalid command\n");
		}
	}
	
	public static Shape readCoordinates() {	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Which shape do you want to draw? (Choose between 1, 2 or 3)");
		System.out.println("1. Circle\n2. Rectangle\n3. Square");
		int option;
		while(!scanner.hasNextInt() || (option = scanner.nextInt()) > 3 || option < 1) {
			scanner.nextLine();
			System.out.println("The number must be integer and between 1 and 3");
		}
		
		System.out.println("Introduceti coordonatele x si y ale centrului : ");
		
		int x = 0;
		int y = 0;
		boolean input = false;
	
		while( !input) {
			if(scanner.hasNextInt() ) {
					x = scanner.nextInt();
					input = true;
			} else {
				while(!scanner.hasNextInt() && scanner.hasNext()) {
					scanner.next();
					System.out.println("x must be integer!");
				}
				continue;
			}
		}
		
		input = false;
		while( !input) {
			if(scanner.hasNextInt()) {
				y = scanner.nextInt();
				input = true;
			}
			else {
				while(!scanner.hasNextInt()) {
					scanner.next();
					System.out.println("y must be integer!");
				}
				continue;
			}
		}
		
		if( option == 1) {
			double radius = 0;
			System.out.println("Introduceti raza : ");
			
			input = false;
			while( !input) {
				if(scanner.hasNextDouble() && (radius = scanner.nextDouble()) > 0 ) {
					input = true;
				}
				else {
					while(!scanner.hasNextDouble()) {
						System.out.println("Radius must be double!");
						scanner.next();
					}
					continue;
				}
			}

			Circle c = new Circle(new Point(x, y), radius);
			return c;
		}
		else 
			{
				if( option == 2) {
				double length = 0;
				double width = 0;
				
				System.out.println("Introduceti lungimea : ");
				
				input = false;
				while( !input) {
					if(scanner.hasNextDouble()) {
						length = scanner.nextDouble();
						input = true;
					}
					else {
						while(!scanner.hasNextDouble()) {
							System.out.println("Length must be double!");
							scanner.next();
						}
						continue;
					}
				}
				System.out.println("Introduceti latimea : ");
				
				input = false;
				while( !input) {
					if(scanner.hasNextDouble()) {
						width = scanner.nextDouble();
						input = true;
					}
					else {
						while(!scanner.hasNextDouble()) {
							System.out.println("Width must be double!");
							scanner.next();
						}
						continue;
					}
				}
	
				Rectangle r = new Rectangle(new Point(x, y), length, width);
				return r;
			}
			
			else {
					if( option == 3) {
					double length = 0;
					System.out.println("Introduceti lungimea : ");
					
					input = false;
					while( !input) {
						if(scanner.hasNextDouble()) {
							length = scanner.nextDouble();
							input = true;
						}
						else {
								while(!scanner.hasNextDouble()) {
									System.out.println("Length must be double!");
									scanner.next();
								}
								continue;
						}
					}
					
					Square s = new Square(new Point(x, y), length);
					return s;
				}
			}
		}
	
		return null;
	}
	
}