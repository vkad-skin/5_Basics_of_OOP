package by.epam.basic_of_oop.task4.view.input;

import java.util.Scanner;

public class TreasureInput {
	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public TreasureInput() {
		
	}
	
	public  int treasureIndexInput(int sizeArray) {

		int index;

		do {
			inputText();
			
			while (!SCANNER.hasNextInt()) {
				inputText();
				SCANNER.nextLine();
			}
			index = SCANNER.nextInt();

		} while ((index <= 0) || (index > sizeArray));
		
		System.out.println();
		
		return index - 1;
	}
	
	public int treasurePriceInput() {

		int index;

		do {
			inputText();
			
			while (!SCANNER.hasNextInt()) {
				inputText();
				SCANNER.nextLine();
			}
			index = SCANNER.nextInt();

		} while (index <= 0);
		
		System.out.println();
		
		return index;
	}
	
	public String treasureNameInput() {
		
		String name;
		
		inputText();
		
		while (!SCANNER.hasNext("[a-zA-Z]+")) {
			inputText();
			SCANNER.nextLine();
		}
		name = SCANNER.next();

		return name;
	}
	
	public int menuInput() {
		
		int index;

		do {
			inputText();
			
			while (!SCANNER.hasNextInt()) {
				inputText();
				SCANNER.nextLine();
			}
			index = SCANNER.nextInt();

		} while ((index < 0) || (index > 5));
		
		System.out.println();
		
		return index;
	}
	
	private void inputText() {
		System.out.print(">>");
	}
	
	public void closeScanner() {
		SCANNER.close();
	}
}
