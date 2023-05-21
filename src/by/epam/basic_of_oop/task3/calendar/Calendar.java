package by.epam.basic_of_oop.task3.calendar;

import java.util.ArrayList;
import java.util.List;

import by.epam.basic_of_oop.task3.day.Day;

public class Calendar {
	
	private List <Day> arrayDay;
	
	public Calendar () {
		arrayDay = new ArrayList<>();
	}
	
	public List<Day> getArrayDay() {
		return arrayDay;
	}
	
	public static class DayOff extends Day {
		private final boolean dayOff = true;
		
		private boolean holiday;
		private String holidayName;
		
		public DayOff(String date) {
			super(date);
			holiday = false;
			holidayName = "-";
		}

		public DayOff(boolean holiday, String holidayName, String date) {
			super(date);
			this.holiday = holiday;
			this.holidayName = holidayName;
		}

		public boolean isHoliday() {
			return holiday;
		}

		public void setHoliday(boolean holiday, String holidayName) {
			this.holiday = holiday;
			this.holidayName = holidayName;
		}

		public String getHolidayName() {
			return holidayName;
		}

		public boolean isDayOff() {
			return dayOff;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (dayOff ? 1231 : 1237);
			result = prime * result + (holiday ? 1231 : 1237);
			result = prime * result
					+ ((holidayName == null) ? 0 : holidayName.hashCode());
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
			DayOff other = (DayOff) obj;
			if (dayOff != other.dayOff)
				return false;
			if (holiday != other.holiday)
				return false;
			if (holidayName == null) {
				if (other.holidayName != null)
					return false;
			} else if (!holidayName.equals(other.holidayName))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "DayOff [Date= " + super.toString() + "dayOff= " + dayOff
					+ ", holiday=" + holiday + ", holidayName=" + holidayName
					+ "]";
		}
	}

	public void setArrayDay(List<Day> arrayDay) {
		this.arrayDay = arrayDay;
	}

	public boolean addDay(Day day) {
		return arrayDay.add(day);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arrayDay == null) ? 0 : arrayDay.hashCode());
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
		Calendar other = (Calendar) obj;
		if (arrayDay == null) {
			if (other.arrayDay != null)
				return false;
		} else if (!arrayDay.equals(other.arrayDay))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calendar [arrayDay=" + arrayDay + "]";
	}

}
