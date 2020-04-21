package app;

import java.util.Scanner;
import data.*;
import java.util.List;
import java.util.ArrayList;

public class Application {
	
	protected static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(new Point(0, 0), 5));
		shapes.add(new Rectangle(new Point(4, 10), 10, 5));
		shapes.add(new Square(new Point(10, 1), 4));
		
		action(1, shapes);
		scanner.close();
	}
	
	public static void action(int input, List<Shape> shapes) {
		while(input != 0) {
			
			System.out.println("Choose between 1, 2, 3 or 0");
			System.out.println("1. Draw\n2. Show\n3. Move\n4. Distances\n0. Exit");

			input = scanner.nextInt();
			switch(input) {
				case 1:
					shapes.add(readCoordinates());
					break;
					
				case 2:
					for(Shape s : shapes) {
						System.out.println(s);
					}
					System.out.println("");
					break;
					
				case 3:
					System.out.println("Which shape do you want to move? (Choose a number from 1 to " + shapes.size() + ")");
					int shapeNumber;
					while(!scanner.hasNextInt() || (shapeNumber = scanner.nextInt()) > shapes.size() || shapeNumber < 1) {
						scanner.nextLine();
						System.out.println("The number must be integer and between 1 and " + shapes.size());
					}
					
					System.out.println("Where do you want to move the shape? (Choose between up, down, left, right)");
					String command = scanner.next();
					move(shapes.get(shapeNumber - 1), command.toLowerCase());
					break;
					
				case 4:
					System.out.println("Choose a number from 1 to " + shapes.size() + " for the first shape");
					int shapeNumber1;
					while(!scanner.hasNextInt() || (shapeNumber1 = scanner.nextInt()) > shapes.size() || shapeNumber1 < 1) {
						scanner.nextLine();
						System.out.println("The number must be integer and between 1 and " + shapes.size());
					}
					
					System.out.println("Choose a number from 1 to " + shapes.size() + " for the second shape");
					int shapeNumber2;
					while(!scanner.hasNextInt() || (shapeNumber2 = scanner.nextInt()) > shapes.size() || shapeNumber2 < 1) {
						scanner.nextLine();
						System.out.println("The number must be integer and between 1 and " + shapes.size());
					}
					
					System.out.println("The distance between the two shapes is equal to " + String.format("%.2f", shapes.get(shapeNumber1 - 1).getDistanceFrom(shapes.get(shapeNumber2-1))) + "\n");
					break;
				
				case 0:
					System.out.println("Goodbye!");
					break;

				default:
					System.out.println("Invalid option\n");
			}
		}
	}
	
	public static Shape readCoordinates() {	
		System.out.println("Which shape do you want to draw? (Choose between 1, 2 or 3)"
							+ "\n1. Circle\n2. Rectangle\n3. Square");
		
		int option;
		while(!scanner.hasNextInt() || (option = scanner.nextInt()) > 3 || option < 1) {
			scanner.nextLine();
			System.out.println("The number must be integer and between 1 and 3");
		}
		
		System.out.println("Introduceti coordonatele x si y ale centrului : ");
		
		int x = 0, y = 0;
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
	
}
