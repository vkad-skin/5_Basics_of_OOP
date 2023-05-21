package by.epam.basic_of_oop.task2.payment;

import by.epam.basic_of_oop.task2.payment.Payment.Product;

public class InfoView {

	public InfoView() {

	}

	public void showPayment(Payment payment) {

		if (!isEmtyPayment(payment)) {

			if (isZeroSize(payment)) {
				showErrorProduct();
				return;
			}

			for (int index = 0; index < payment.getProductList().size(); index++) {
				showProduct(payment.getProductList().get(index), index);
			}
			return;
		}
		showError();
	}

	private boolean isEmtyPayment(Payment payment) {
		return payment == null ? true : false;
	}
	
	private boolean isZeroSize(Payment payment) {
		return payment.getProductList().size() == 0 ? true : false;
	}

	private void showProduct(Product product, int index){
		System.out.println("|" + (index + 1) + "|" + "Product >>"
				+ " " + product.getManufacturerName()
				+ " " + product.getName()
				+ " " + product.getPrice());
	}
	
	private void showErrorProduct() {
		System.out.println("No product!");
	}

	public void showAllPrice(Payment payment) {
		System.out.println("All price >> " + payment.allPriceProduct());
	}

	public void showError() {
		System.out.println("Error!");
	}
}