package by.epam.basic_of_oop.task4.logic.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.basic_of_oop.task4.bean.Treasure;
import by.epam.basic_of_oop.task4.logic.LogicTreasure;
import by.epam.basic_of_oop.task4.view.input.TreasureInput;
import by.epam.basic_of_oop.task4.view.output.TreasureOutput;

public class TreasureFuction implements LogicTreasure {
	
	private TreasureOutput output;
	private TreasureInput input;
	
	public TreasureFuction() {
		output = new TreasureOutput();
		input = new TreasureInput();
	}
	
	public TreasureOutput getOutput() {
		return output;
	}

	public TreasureInput getInput() {
		return input;
	}

	@Override
	public Treasure searchMaxPriceTreasure(List<Treasure> treasureArray) {
		
		if (treasureArray.isEmpty()) {
			return null;
		}
		
		Treasure treasureMaxPrice;
		treasureMaxPrice = treasureArray.get(0);
		
		for (int index = 1;index < treasureArray.size(); index++) {
			
			if (treasureMaxPrice.getPrice() < treasureArray.get(index).getPrice()) {
				treasureMaxPrice = treasureArray.get(index);
			}
		}
		
		return new Treasure(treasureMaxPrice.getName(), treasureMaxPrice.getPrice());
	}

	@Override
	public List<Treasure> selectionOfTreasureWorth(
			List<Treasure> treasureArray, int treasureSum) {

		if (treasureSum <= 0 || treasureArray.isEmpty()) {
			return null;
		}
		int indexTreasureSum = 0;
		
		List<Treasure> treasureArrayFound;
		List<Treasure> treasureArrayWorth;
		
		treasureArrayFound = searchPriceTresure(treasureArray, treasureSum);
		treasureArrayWorth = new ArrayList<Treasure>();
		
		while (true) {
			
			if (treasureArrayFound.size() == 0) {
				break;
			}
			output.showAllTreasure(treasureArrayFound);
			
			treasureArrayWorth.add(treasureArrayFound.get(input.treasureIndexInput(treasureArrayFound.size())));
			
			treasureArrayFound.remove(treasureArrayWorth.get(indexTreasureSum));
			treasureSum -= treasureArrayWorth.get(indexTreasureSum).getPrice();
			
			treasureArrayFound = searchPriceTresure(treasureArrayFound, treasureSum);
			indexTreasureSum++;	
		}
		
		return treasureArrayWorth;
	}
	
	private List<Treasure> searchPriceTresure(List<Treasure> treasureArray,
			int treasureSum) {

		List<Treasure> treasureArrayFound = new ArrayList<Treasure>();

		for (Treasure treasure : treasureArray) {

			if (treasure.getPrice() <= treasureSum) {
				treasureArrayFound.add(treasure);
			}
		}

		return treasureArrayFound;
	}
}
