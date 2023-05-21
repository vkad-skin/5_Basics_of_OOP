package by.epam.basic_of_oop.task3.calendar;

import java.util.Collections;
import java.util.Comparator;

import by.epam.basic_of_oop.task3.calendar.Calendar.DayOff;
import by.epam.basic_of_oop.task3.day.Day;

public class CalendarFuction {

	public CalendarFuction() {

	}

	public Calendar sortDay(Calendar calendar) {
		if (calendar != null) {

			if (calendar.getArrayDay().size() > 1) {

				Collections.sort(calendar.getArrayDay(), new Comparator<Day>() {
					@Override
					public int compare(Day day1, Day day2) {
						return day1.getDate().compareTo(day2.getDate());
					}
				});
				return calendar;
			}
			return null;
		}
		return null;
	}

	public Day firstDayOffSearch(Calendar calendar) {

		DayOff dayOff;

		if (calendar != null) {

			if (calendar.getArrayDay().size() > 0) {

				for (int index = 0; index < calendar.getArrayDay().size(); index++) {

					if (calendar.getArrayDay().get(index) instanceof DayOff) {
						dayOff = (DayOff) calendar.getArrayDay().get(index);

						if ((dayOff.isDayOff() == true) && (dayOff.isHoliday() == false)) {
							return dayOff;
						}
					}
				}
			}
			return null;
		}
		return null;
	}

	public Day firstHolidaySearch(Calendar calendar) {

		DayOff dayOff;

		if (calendar != null) {

			if (calendar.getArrayDay().size() > 0) {

				for (int index = 0; index < calendar.getArrayDay().size(); index++) {

					if (calendar.getArrayDay().get(index) instanceof DayOff) {
						dayOff = (DayOff) calendar.getArrayDay().get(index);

						if ((dayOff.isDayOff() == true) && (dayOff.isHoliday() == true)) {
							return dayOff;
						}
					}
				}
			}
			return null;
		}
		return null;
	}
}
