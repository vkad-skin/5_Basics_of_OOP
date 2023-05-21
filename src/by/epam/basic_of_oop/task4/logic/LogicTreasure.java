package by.epam.basic_of_oop.task4.logic;

import java.util.List;

import by.epam.basic_of_oop.task4.bean.Treasure;

public interface LogicTreasure {
	
	public Treasure searchMaxPriceTreasure(List<Treasure> treasureArray);
	public List<Treasure> selectionOfTreasureWorth(List<Treasure> treasureArray,  int treasureSum);
}
