package by.epam.basic_of_oop.task5b.bean;

public class Wrap extends Product{
	
	private String wrapType;
	
	public Wrap(){
		super();
		wrapType = null;
	}

	public Wrap(String wrapType, String name, double price, double weight) {
		super(name, price, weight);
		this.wrapType = wrapType;
	}

	public String getWrapType() {
		return wrapType;
	}

	public void setWrapType(String wrapType) {
		this.wrapType = wrapType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((wrapType == null) ? 0 : wrapType.hashCode());
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
		Wrap other = (Wrap) obj;
		if (wrapType == null) {
			if (other.wrapType != null)
				return false;
		} else if (!wrapType.equals(other.wrapType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wrap [wrapType=" + wrapType + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getWeight()=" + getWeight() + "]";
	}

}
