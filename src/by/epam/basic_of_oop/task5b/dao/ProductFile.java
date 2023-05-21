package by.epam.basic_of_oop.task5b.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam.basic_of_oop.task5b.bean.Product;
import by.epam.basic_of_oop.task5b.bean.Sweetness;
import by.epam.basic_of_oop.task5b.bean.Wrap;
import by.epam.basic_of_oop.task5b.bilder.ProductFactory;
import by.epam.basic_of_oop.task5b.bilder.ProductType;

public class ProductFile implements FileHandling {

	private static ProductFile productFile;
	private final File PATH_SWEETNESS = new File(
			"./src/by/epam/basic_of_oop/task5b/database_product/Database_sweetness.txt");
	private final File PATH_WRAP = new File("./src/by/epam/basic_of_oop/task5b/database_product/Database_wrap.txt");
	private ProductFactory productFactory = new ProductFactory();

	private ProductFile() {

	}

	public static synchronized ProductFile getProductFile() {
		if (productFile == null) {
			productFile = new ProductFile();
		}
		return productFile;
	}

	public File getPATH_SWEETNESS() {
		return PATH_SWEETNESS;
	}

	public File getPATH_WRAP() {
		return PATH_WRAP;
	}

	@Override
	public List<Product> getFile(File file) throws IOException {

		List<Product> productArray = new ArrayList<Product>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		int countFieldProduct = 4;

		String lineProduct;
		String[] fieldProduct = new String[countFieldProduct - 1];

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while ((lineProduct = bufferedReader.readLine()) != null) {

				lineProduct = lineProduct.substring(lineProduct.indexOf(' '), lineProduct.length() - 1).replaceAll(" ",
						"");
				fieldProduct = lineProduct.split(",");

				if (getPATH_SWEETNESS().equals(file)) {
					productArray.add(productFactory.createdProduct(ProductType.Sweetness, fieldProduct[0],
							fieldProduct[1], Double.parseDouble(fieldProduct[2]), Double.parseDouble(fieldProduct[3])));

				} else if (getPATH_WRAP().equals(file)) {
					productArray.add(productFactory.createdProduct(ProductType.Wrap, fieldProduct[0], fieldProduct[1],
							Double.parseDouble(fieldProduct[2]), Double.parseDouble(fieldProduct[3])));
					
				} else {
					return null;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bufferedReader.close();
		}

		return productArray;
	}

	@Override
	public boolean setFile(File file, List<Product> productArray) throws IOException {

		boolean isWork = false;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		Sweetness productSweetness = null;
		Wrap productWrap = null;

		isWork = true;

		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);

			if (file.equals(PATH_SWEETNESS)) {

				for (int indexProduct = 0; indexProduct < productArray.size(); indexProduct++) {
					productSweetness = (Sweetness) productArray.get(indexProduct);

					bufferedWriter.write(
							"Sweetness: " + productSweetness.getSweetnessType() + ", " + productSweetness.getName()
									+ ", " + productSweetness.getPrice() + ", " + productSweetness.getWeight() + ";");

					if (indexProduct != (productArray.size() - 1)) {
						bufferedWriter.newLine();
					}
				}

			} else if (file.equals(PATH_WRAP)) {

				for (int indexProduct = 0; indexProduct < productArray.size(); indexProduct++) {
					productWrap = (Wrap) productArray.get(indexProduct);

					bufferedWriter.write("Wrap: " + productWrap.getWrapType() + ", " + productWrap.getName() + ", "
							+ productWrap.getPrice() + ", " + productWrap.getWeight() + ";");

					if (indexProduct != (productArray.size() - 1)) {
						bufferedWriter.newLine();
					}
				}

			} else {
				isWork = false;
			}

		} catch (IOException e) {
			isWork = false;
			e.printStackTrace();

		} finally {
			bufferedWriter.close();
		}

		return isWork;
	}

}
