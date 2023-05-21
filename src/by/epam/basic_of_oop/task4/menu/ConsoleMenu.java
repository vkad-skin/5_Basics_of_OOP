package by.epam.basic_of_oop.task4.menu;

import java.io.IOException;

import by.epam.basic_of_oop.task4.bean.Treasure;
import by.epam.basic_of_oop.task4.dao.DaoException;
import by.epam.basic_of_oop.task4.dao.impl.DragonTreasureFile;
import by.epam.basic_of_oop.task4.logic.impl.TreasureFuction;

public class ConsoleMenu {

	private DragonTreasureFile dragonTreasureFile;
	private TreasureFuction fuction;
	private Treasure treasure;

	public ConsoleMenu() throws DaoException, IOException {
		dragonTreasureFile = DragonTreasureFile.getFile();
		fuction = new TreasureFuction();
		treasure = null;
	}

	public void startMenu() throws DaoException, IOException {

		while (true) {

			fuction.getOutput().showMenu();

			switch (fuction.getInput().menuInput()) {

			case 1:
				showAllTreasure();
				break;
			case 2:
				addTreasure();
				break;
			case 3:
				deleteTreasure();
				break;
			case 4:
				treasureMaxPrice();
				break;
			case 5:
				treasureWorth();
				break;
			case 0:
				exit();
				return;
			default:
				error();
				break;
			}
		}
	}

	private void showAllTreasure() throws DaoException, IOException {
		fuction.getOutput()
				.showAllTreasure(dragonTreasureFile.getAllTreasure());
	}

	private void addTreasure() throws DaoException, IOException {
		treasure = new Treasure();

		fuction.getOutput().showEnterTreasureName();
		treasure.setName(fuction.getInput().treasureNameInput());

		fuction.getOutput().showEnterTreasurePrice();
		treasure.setPrice(fuction.getInput().treasurePriceInput());

		fuction.getOutput().showCompleted(
				dragonTreasureFile.addTreasure(treasure));
	}

	private void deleteTreasure() throws DaoException, IOException {
		treasure = new Treasure();

		fuction.getOutput().showEnterTreasureName();
		treasure.setName(fuction.getInput().treasureNameInput());

		fuction.getOutput().showEnterTreasurePrice();
		treasure.setPrice(fuction.getInput().treasurePriceInput());

		fuction.getOutput().showCompleted(dragonTreasureFile.delete(treasure));
	}

	private void treasureMaxPrice() throws DaoException, IOException {
		Treasure treasureMaxPrice = fuction
				.searchMaxPriceTreasure(dragonTreasureFile.getAllTreasure());

		fuction.getOutput().showTreasure(treasureMaxPrice);
	}

	private void treasureWorth() throws DaoException, IOException {
		fuction.getOutput().showEnterForSelectTreasure();
		dragonTreasureFile.setSelectTheTreasure(fuction
				.selectionOfTreasureWorth(dragonTreasureFile.getAllTreasure(),
						fuction.getInput().treasurePriceInput()));

	}

	private void exit() {
		fuction.getInput().closeScanner();
		fuction.getOutput().showExit();
	}

	private void error() {
		fuction.getOutput().showErrorMenu();
	}
}
