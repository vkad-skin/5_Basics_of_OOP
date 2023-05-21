package by.epam.basic_of_oop.task5b.bean;

import java.util.ArrayList;
import java.util.List;

public class Gift extends Product {

	private Wrap wrap;
	private List<Product> sweetnessArray;

	public Gift() {
		super();
		wrap = null;
		sweetnessArray = new ArrayList<Product>();
	}

	public Gift(String name, double price, Wrap wrap) {
		super(name, price, 0);
		this.wrap = wrap;
		sweetnessArray = new ArrayList<Product>();
	}

	public Wrap getWrap() {
		return wrap;
	}

	public void setWrap(Wrap wrap) {
		this.wrap = wrap;
	}

	public List<Product> getCandytArray() {
		return sweetnessArray;
	}

	public void setCandytArray(List<Product> candytArray) {
		this.sweetnessArray = candytArray;
	}

	public boolean addSweetness(Sweetness sweetness) {

		if (sweetness != null) {
			sweetnessArray.add(sweetness);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sweetnessArray == null) ? 0 : sweetnessArray.hashCode());
		result = prime * result + ((wrap == null) ? 0 : wrap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gift other = (Gift) obj;
		if (sweetnessArray == null) {
			if (other.sweetnessArray != null)
				return false;
		} else if (!sweetnessArray.equals(other.sweetnessArray))
			return false;
		if (wrap == null) {
			if (other.wrap != null)
				return false;
		} else if (!wrap.equals(other.wrap))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gift [wrap=" + wrap + ", sweetnessArray=" + sweetnessArray + ", toString()=" + super.toString() + "]";
	}

}
