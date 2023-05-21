package by.epam.basic_of_oop.task2.payment;

import java.util.ArrayList;
import java.util.List;

public class Payment {

	private List<Product> productList;

	public Payment() {
		productList = new ArrayList<>();
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void addProductList(Product product) {
		productList.add(product);
	}

	public boolean removeProduct(Product product) {
		return productList.remove(product);
	}

	public double allPriceProduct() {
		
		double allPrice;
		allPrice = 0;
		
		for (Product product : productList) {
			allPrice += product.getPrice();
		}
		return allPrice;
	}

	public static class Product {

		private String manufacturerName;
		private String name;
		private double price;

		public Product() {
			manufacturerName = null;
			name = null;
			price = 0;
		}

		public Product(String manufacturerName, String name, double price) {
			this.manufacturerName = manufacturerName;
			this.name = name;
			this.price = price;
		}

		public String getManufacturerName() {
			return manufacturerName;
		}

		public void setManufacturerName(String manufacturerName) {
			this.manufacturerName = manufacturerName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((manufacturerName == null) ? 0 : manufacturerName
							.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (manufacturerName == null) {
				if (other.manufacturerName != null)
					return false;
			} else if (!manufacturerName.equals(other.manufacturerName))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double
					.doubleToLongBits(other.price))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Product [manufacturerName=" + manufacturerName + ", name="
					+ name + ", price=" + price + "]";
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [productList=" + productList + "]";
	}

}
