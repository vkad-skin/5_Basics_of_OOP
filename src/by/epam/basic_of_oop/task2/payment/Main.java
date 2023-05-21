package by.epam.basic_of_oop.task2.payment;

/*
 * Задача 2: Создать класс Payment с внутренним классом,
 * с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class Main {

	public static void main(String[] args) {
		
		Payment payment = new Payment();

		
		Payment.Product product1 = new Payment.Product("Coca-Cola Company", "Fanta", 1.36);
		Payment.Product product2 = new Payment.Product("Nestle", "Neskafe", 7.50);
		Payment.Product product3 = new Payment.Product("Intel", "Intel Core I7-7700", 1230.0);
		
		InfoView view = new InfoView();
		
		view.showPayment(payment);
		
		payment.addProductList(product1);
		payment.addProductList(product2);
		payment.addProductList(product3);
		
		view.showPayment(payment);
		view.showAllPrice(payment);
		view.showPayment(null);
	}
}
