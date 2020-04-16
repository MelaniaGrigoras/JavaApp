package app;

import java.util.Scanner;

import data.Circle;
import data.Point;
import data.Rectangle;
import data.Shape;
import data.Square;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(new Point(0, 0), 5));
		shapes.add(new Rectangle(new Point(4, 10), 10, 5));
		shapes.add(new Square(new Point(10, 1), 4));
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose between 1, 2, 3 or 0");
			System.out.println("1. Draw\n2. Show\n3. Move\n4. Distances\n0. Exit");
			int option = scanner.nextInt();
			
			switch(option) {
				case 1:
					shapes.add(Test.readCoordinates());
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
					Test.move(shapes.get(shapeNumber - 1), command.toLowerCase());
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
					
					System.out.println("The distance between the two shapes is equal to " + shapes.get(shapeNumber1 - 1).getDistanceFrom(shapes.get(shapeNumber2-1)) + "\n");
					break;
					
				case 0:
					System.exit(0);
					
				default:
					System.out.println("Invalid option\n");
			}
		}
	}
	
	

}
