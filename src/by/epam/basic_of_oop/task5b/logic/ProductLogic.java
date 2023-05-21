package by.epam.basic_of_oop.task5b.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.epam.basic_of_oop.task5b.bean.Product;
import by.epam.basic_of_oop.task5b.bean.Sweetness;
import by.epam.basic_of_oop.task5b.bean.Wrap;
import by.epam.basic_of_oop.task5b.dao.ProductFile;

public class ProductLogic {
	
	private ProductFile productFile;
	private List<Product> sweetnessArray;
	private List<Product> wrapArray;

	public ProductLogic() {
		productFile = ProductFile.getProductFile();
		sweetnessArray = new ArrayList<Product>();
		wrapArray = new ArrayList<Product>();
	}
	
	public ProductFile getProductFile() {
		return productFile;
	}
	
	public boolean setSweetnessArrayFromFile() {
		
		try {
			this.sweetnessArray = productFile.getFile(productFile.getPATH_SWEETNESS());
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public List<Product> getSweetnessArray() {
		return sweetnessArray;
	}
	
	public boolean addSweetness(Product product) {
		
		if ((product == null) && (this.sweetnessArray == null) || (this.sweetnessArray.size() == 0)) {
			return false;
		}
		
		if (product instanceof Sweetness) {
			this.sweetnessArray.add(product);
			return true;
			
		} else {
			return false;
		}
		
	}
	
	public boolean setWrapArrayFromFile() {

		try {
			this.wrapArray = productFile.getFile(productFile.getPATH_WRAP());
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}

	public List<Product> getWrapArray() {
		return wrapArray;
	}
	
	public boolean addWrap(Product product) {
	
		if ((product == null) && (this.wrapArray == null) || (this.wrapArray.size() == 0)) {
			return false;
		}
	
		if (product instanceof Wrap) {
			this.wrapArray.add(product);
			return true;
	
		} else {
			return false;
		}
	
	}

	public boolean sortNameProduct(List <Product> productArray) {
		
		if ((productArray == null) || (productArray.size() == 0)) {
			return false;
		}
		
		Collections.sort(productArray, new Comparator<Product>() {
			
			@Override
			public int compare(Product product1, Product product2) {
				
				return product1.getName().compareTo(product2.getName());
			}
		});
		
		return true;
	}
	
	public boolean sortPriceProduct(List <Product> productArray) {
		
		if ((productArray == null) || (productArray.size() == 0)) {
			return false;
		}
		
		Collections.sort(productArray, new Comparator<Product>() {
			
			@Override
			public int compare(Product product1, Product product2) {
				int comparePrice;
				
				if (product1.getPrice() > product2.getPrice()) {
					comparePrice = 1;
				} else if (product1.getPrice() > product2.getPrice()) {
					comparePrice = -1;
				} else {
					comparePrice = 0;
				}
				
				return comparePrice;
			}
		});
		
		return true;
	}
	
	public boolean saveSweetnessArrayFromFile() {
		
		if ((this.sweetnessArray == null) || (this.sweetnessArray.size() == 0)) {
			return false;
		}
		
		try {
			productFile.setFile(productFile.getPATH_SWEETNESS(), this.sweetnessArray);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean saveWrapArrayFromFile() {
		
		if ((this.wrapArray == null) || (this.wrapArray.size() == 0)) {
			return false;
		}
		
		try {
			productFile.setFile(productFile.getPATH_WRAP(), this.wrapArray);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
