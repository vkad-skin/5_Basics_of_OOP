package by.epam.basic_of_oop.task5b.bean;

public class Customer {
	
	private String name;
	private Gift gift;
	
	public Customer() {
		name = "Unknown";
		gift = null;
	}
	
	public Customer(String name) {
		this.name = name;
		gift = null;
	}
	
	public Customer(String name, Gift gift) {
		this.name = name;
		this.gift = gift;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gift == null) ? 0 : gift.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (gift == null) {
			if (other.gift != null)
				return false;
		} else if (!gift.equals(other.gift))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", gift=" + gift.toString() + "]";
	}
	
	
}
