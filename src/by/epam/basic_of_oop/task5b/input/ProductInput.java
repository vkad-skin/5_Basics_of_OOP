package by.epam.basic_of_oop.task5b.input;

import java.util.Scanner;

import by.epam.basic_of_oop.task5b.veiw.VeiwInfoInput;

public class ProductInput {
	
	private Scanner scann;
	private VeiwInfoInput infoVeiw;
	
	public ProductInput() {
		scann = new Scanner(System.in);
		infoVeiw = new VeiwInfoInput();
	}
	
	public String enterName() {
		
		String name;
		
		infoVeiw.showEnterName();
		
		while(!scann.hasNextLine()) {
			infoVeiw.showEnterName();
		}
		
		name = scann.nextLine();
		
		return name;
	}
	
	public int enterProductNumber(int amountProducts) {
		
		int numberOfProduct;
		
		do {
			infoVeiw.showEnterProductNumber();
			
			while(!scann.hasNextInt()) {
				infoVeiw.showEnterProductNumber();
				scann.nextLine();
			}
			
			numberOfProduct = scann.nextInt();
			
		} while (numberOfProduct < 0 && numberOfProduct > amountProducts);
		
		
		return numberOfProduct;
	}
}
