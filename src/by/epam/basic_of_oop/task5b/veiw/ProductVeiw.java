package by.epam.basic_of_oop.task5b.veiw;

import java.util.List;

import by.epam.basic_of_oop.task5b.bean.Product;
import by.epam.basic_of_oop.task5b.bean.Sweetness;
import by.epam.basic_of_oop.task5b.bean.Wrap;

public class ProductVeiw {

	public ProductVeiw() {

	}

	public void showWrapList(List<Product> productArray) {

		if (!productArray.isEmpty()) {

			Wrap wrap;

			for (int index = 0; index < productArray.size(); index++) {
				wrap = (Wrap) productArray.get(index);
				System.out.println((index + 1) + ". Wrap: " + wrap.getWrapType() + " ," + wrap.getName() + " ,"
						+ wrap.getPrice() + " ," + wrap.getWeight() + " ;");
			}

		} else {
			showError();
		}
	}

	public void showSweetnessList(List<Product> productArray) {

		if (!productArray.isEmpty()) {

			Sweetness sweetness;

			for (int index = 0; index < productArray.size(); index++) {
				sweetness = (Sweetness) productArray.get(index);
				System.out.println((index + 1) + ". Sweetness: " + sweetness.getSweetnessType() + " ,"
						+ sweetness.getName() + " ," + sweetness.getPrice() + " ," + sweetness.getWeight() + " ;");
			}

		} else {
			showError();
		}
	}

	private void showError() {
		System.out.println("Error!");
	}
	
	public void showEnterExit() {
		System.out.println("Enter 0 to exit .");
	}
}
