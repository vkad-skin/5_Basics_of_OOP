package by.epam.basic_of_oop.task4.view.output;

import java.util.List;

import by.epam.basic_of_oop.task4.bean.Treasure;

public class TreasureOutput {

	public TreasureOutput() {

	}

	public void showAllTreasure(List<Treasure> treasureArray) {
		
		int index = 1;
		
		try {
			for (Treasure treasure: treasureArray) {
				System.out.println(index + ". Treasure - "
						+ treasure.getName() + ", price - "
						+ treasure.getPrice() + ".");
				
				index++;
			}
			System.out.println();
		} catch (Exception e) {
			showError();
		}

	}
	
	public void showTreasure(Treasure treasure) {

		try {
			System.out.println("Treasure - "
					+ treasure.getName() + ", price - "
					+ treasure.getPrice() + ".\n");
		} catch (Exception e) {
			showError();
		}
	}
	
	public void showMenu() {

		String text = "1 - Show all treasure.\n" 
				+ "2 - Add treasure.\n"
				+ "3 - Delete treasure.\n" 
				+ "4 - Show max price.\n"
				+ "5 - Choose a treasure for a certain amount.\n"
				+ "0 - Exit.\n";

		System.out.println(text);
	}
	
	public void showEnterTreasureName() {
		System.out.println("Enter treasure name:");
	}
	
	public void showEnterTreasurePrice() {
		System.out.println("Enter treasure price:");
	}
	
	public void showCompleted(boolean isWork) {
		if (isWork) {
			System.out.println("Completed!\n");
		} else {
			showError();
		}
	}
	
	public void showEnterForSelectTreasure() {
		System.out.println("Enter the price for select the treasure");
	}
	
	public void showErrorMenu() {
		System.out.println("Menu entry error!\n Try again.");
	}
	
	private void showError() {
		System.out.println("Error!\n");
	}
	
	public void showExit() {
		System.out.println("Exit.");
	}
}
