package by.epam.basic_of_oop.task5b.bean;

public class Sweetness extends Product {
	
	private String sweetnessType;
	
	public Sweetness() {
		super();
		sweetnessType = null;
	}
	
	public Sweetness(String sweetnessType, String name, double price, double weight) {
		super(name,price,weight);
		this.sweetnessType = sweetnessType;
	}

	public String getSweetnessType() {
		return sweetnessType;
	}

	public void setSweetnessType(String candyType) {
		this.sweetnessType = candyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sweetnessType == null) ? 0 : sweetnessType.hashCode());
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
		Sweetness other = (Sweetness) obj;
		if (sweetnessType == null) {
			if (other.sweetnessType != null)
				return false;
		} else if (!sweetnessType.equals(other.sweetnessType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sweetness [candyType=" + sweetnessType + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getWeight()=" + getWeight() + "]";
	}

	
}
