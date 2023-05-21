package by.epam.basic_of_oop.task3.day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Day {

	private Date date;

	public Day(String date) {
		try {
			setDate(new SimpleDateFormat("d.M.yyyy").parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Day other = (Day) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Day [date=" + new SimpleDateFormat("d.M.yyyy E").format(date) + "]";
	}

}
