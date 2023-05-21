package by.epam.basic_of_oop.task4.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam.basic_of_oop.task4.bean.Treasure;
import by.epam.basic_of_oop.task4.dao.DaoDragonTreasure;
import by.epam.basic_of_oop.task4.dao.DaoException;

public class DragonTreasureFile implements DaoDragonTreasure {
	
	private static final File PATH = new File(
			"./src/by/epam/basic_of_oop/task4/database_treasure/Database_treasure.txt");
	private static final File PATH_SELECT_TREASURE = new File(
			"./src/by/epam/basic_of_oop/task4/database_treasure/Select_treasure.txt");
	private static final DragonTreasureFile FILE = new DragonTreasureFile();

	private DragonTreasureFile() {

	}

	public static DragonTreasureFile getFile() {
		return FILE;
	}

	public static File getPath() {
		return PATH;
	}

	@Override
	public boolean addTreasure(Treasure treasure) throws DaoException,
			IOException {

		FileWriter writerTreasure = new FileWriter(PATH, true);
		BufferedWriter bufferTreasure = new BufferedWriter(writerTreasure);
		boolean isWork = true;

		try {
			bufferTreasure.newLine();
			bufferTreasure
					.write(treasure.getName() + "-" + treasure.getPrice());

		} catch (IOException e) {
			isWork = false;
			throw new DaoException(e);

		} finally {
			bufferTreasure.close();
		}
		return isWork;
	}

	@Override
	public List<Treasure> getAllTreasure() throws DaoException, IOException {

		List<Treasure> treasureArray = new ArrayList<Treasure>();
		int textArraySize = 2;
		
		String[] textArray = new String[textArraySize];
		String line;

		FileReader readTreasure = new FileReader(PATH);
		BufferedReader bufferTreasure = new BufferedReader(readTreasure);

		try {
			while ((line = bufferTreasure.readLine()) != null) {
				textArray = line.split("-");
				treasureArray.add(new Treasure(textArray[0], Integer
						.parseInt(textArray[1])));
			}

		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			bufferTreasure.close();
		}
		return treasureArray;
	}

	@Override
	public boolean delete(Treasure treasure) throws DaoException, IOException {

		List<Treasure> treasureArray;
		if (treasure != null) {
				treasureArray = getAllTreasure();
				
				if (treasureArray.remove(treasure)) {
					return setAllTreasure(treasureArray);
				}
		}
		return false;
	}

	private boolean setAllTreasure(List<Treasure> treasureArray)
			throws DaoException, IOException {

		if (treasureArray.isEmpty()) {
			return false;
		}

		FileWriter writerTreasure = new FileWriter(PATH);
		BufferedWriter bufferTreasure = new BufferedWriter(writerTreasure);
		boolean isWork = true;

		try {
			for (int index = 0; index < treasureArray.size(); index++) {
				bufferTreasure.write(treasureArray.get(index).getName() + "-"
						+ treasureArray.get(index).getPrice());

				if (index != treasureArray.size() - 1) {
					bufferTreasure.newLine();
				}
			}

		} catch (IOException e) {
			isWork = false;
			throw new DaoException(e);

		} finally {
			bufferTreasure.close();
		}
		return isWork;
	}

	public boolean setSelectTheTreasure(List<Treasure> treasureArray)
			throws DaoException, IOException {

		if (treasureArray.isEmpty()) {
			return false;
		}

		FileWriter writerTreasure = new FileWriter(PATH_SELECT_TREASURE);
		BufferedWriter bufferTreasure = new BufferedWriter(writerTreasure);
		boolean isWork = true;

		try {
			for (int index = 0; index < treasureArray.size(); index++) {
				bufferTreasure.write(treasureArray.get(index).getName() + "-"
						+ treasureArray.get(index).getPrice());

				if (index != treasureArray.size() - 1) {
					bufferTreasure.newLine();
				}
			}

		} catch (IOException e) {
			isWork = false;
			throw new DaoException(e);

		} finally {
			bufferTreasure.close();
		}
		return isWork;
	}
}
