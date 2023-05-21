package by.epam.basic_of_oop.task3.day;

public class WorkDay extends Day {

	private final boolean workDay = true;

	public WorkDay(String date) {
		super(date);
	}

	public boolean isWorkDay() {
		return workDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (workDay ? 1231 : 1237);
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
		WorkDay other = (WorkDay) obj;
		if (workDay != other.workDay)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkDay [Date= " + super.toString() + "isWorkDay= " + workDay
				+ "]";
	}
}
