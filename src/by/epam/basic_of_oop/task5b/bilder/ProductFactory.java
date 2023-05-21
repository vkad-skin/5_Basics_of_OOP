package by.epam.basic_of_oop.task5b.bilder;

import by.epam.basic_of_oop.task5b.bean.Product;
import by.epam.basic_of_oop.task5b.bean.Sweetness;
import by.epam.basic_of_oop.task5b.bean.Wrap;

public class ProductFactory {
	
	public ProductFactory() {
		
	}
	
	public Product createdProduct(ProductType productType, String type, String name, double price, double weight) {

		Product product = null;

		switch (productType) {
		case Sweetness:
			product = new Sweetness(type, name, price, weight);
			break;
			
		case Wrap:
			product = new Wrap(type, name, price, weight);
			break;
			
		default:
			throw new IllegalArgumentException("Wrong product type" + productType);
		}

		return product;
	}
}
