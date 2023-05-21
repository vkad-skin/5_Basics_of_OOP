package by.epam.basic_of_oop.task4.dao;

import java.io.IOException;
import java.util.List;

import by.epam.basic_of_oop.task4.bean.Treasure;

public interface DaoDragonTreasure {
	public boolean addTreasure(Treasure treasure)throws DaoException, IOException;
	public List<Treasure> getAllTreasure() throws DaoException, IOException;
	public boolean delete(Treasure treasure) throws DaoException, IOException;
}
