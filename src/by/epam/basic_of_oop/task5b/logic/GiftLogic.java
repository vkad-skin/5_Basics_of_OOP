package by.epam.basic_of_oop.task5b.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.basic_of_oop.task5b.bean.Gift;
import by.epam.basic_of_oop.task5b.bean.Product;
import by.epam.basic_of_oop.task5b.bean.Sweetness;
import by.epam.basic_of_oop.task5b.bean.Wrap;
import by.epam.basic_of_oop.task5b.input.ProductInput;
import by.epam.basic_of_oop.task5b.veiw.ProductVeiw;
import by.epam.basic_of_oop.task5b.veiw.VeiwInfoInput;

public class GiftLogic {
	
	private ProductLogic productLogic;
	private ProductInput productInput;
	private ProductVeiw productVeiw;
	
	public GiftLogic() {
		productLogic = new ProductLogic();
		productInput = new ProductInput();
		productVeiw = new ProductVeiw();
	}
	
	public Gift createdGift() {
		
		Gift gift = new Gift();
		
		boolean sweetnessFileFound = productLogic.setSweetnessArrayFromFile();
		boolean wrapFileFound = productLogic.setWrapArrayFromFile();
		
		if (sweetnessFileFound && wrapFileFound) {
			gift.setName(setEnternedName());
			gift.setWrap(wrapperSelection(productLogic.getWrapArray()));
			gift.setCandytArray(sweetnessSelection(productLogic.getSweetnessArray()));
			
			gift.setPrice(totalPriceCalculation(gift));
			gift.setWeight(totalWeightCalculation(gift));
			
			return gift;
			
		} else {
			return null;
		}	
	}
	
	public String setEnternedName() {
		
		String name = null;
		boolean isWord = false;
		
		while (!isWord) {
			name = productInput.enterName();
			isWord = nameCheck(name);
		}
		
		return name;
	}
	
	
	private boolean nameCheck(String name) {
		
		String regex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		
		return matcher.matches();
	}
	
	public Wrap wrapperSelection(List<Product> productArray) {
		
		if(productArray.isEmpty()) {
			return null;
		}
		
		Wrap wrap;
		int indexProduct = 0;
		
		while(indexProduct == 0) {
			productVeiw.showWrapList(productArray);
			
			indexProduct = productInput.enterProductNumber(productArray.size()) - 1;
		}
		
		wrap = (Wrap) productArray.get(indexProduct);
		
		return wrap;
	}
	
	private List<Product> sweetnessSelection(List<Product> productArray) {
		
		if (productArray.isEmpty()) {
			return null;
		}
		
		List<Product> selectedProducts = new ArrayList<Product>();
		
		VeiwInfoInput infoInput = new VeiwInfoInput();
		int indexList;
		
		while (true) {
			
			productVeiw.showSweetnessList(productArray);
			infoInput.showEnterExit();
			indexList = productInput.enterProductNumber(productArray.size()) - 1;

			if (indexList == -1) {
				break;
			}
			
			selectedProducts.add(productArray.get(indexList));
		}
		
		return selectedProducts;
	}
	
	private double totalPriceCalculation(Gift gift) {
		
		Sweetness sweetness;
		double price;

		price = gift.getWrap().getPrice();

		if (!gift.getCandytArray().isEmpty()) {

			for (Product product : gift.getCandytArray()) {
				sweetness = (Sweetness) product;
				price += sweetness.getPrice();
			}
			return price;

		} else {
			return price;
		}
	}

	private double totalWeightCalculation(Gift gift) {

		Sweetness sweetness;
		double weight;

		weight = gift.getWrap().getWeight();

		if (!gift.getCandytArray().isEmpty()) {

			for (Product product : gift.getCandytArray()) {
				sweetness = (Sweetness) product;
				weight += sweetness.getWeight();
			}
			return weight;

		} else {
			return weight;
		}
	}

}
