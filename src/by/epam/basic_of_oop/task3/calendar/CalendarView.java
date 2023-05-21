package by.epam.basic_of_oop.task3.calendar;

import java.text.SimpleDateFormat;

import by.epam.basic_of_oop.task3.calendar.Calendar.DayOff;
import by.epam.basic_of_oop.task3.day.Day;
import by.epam.basic_of_oop.task3.day.WorkDay;

public class CalendarView {

	public CalendarView() {

	}

	public void showCalendar(Calendar calendar) {

		if (calendar != null) {
			if (calendar.getArrayDay().size() > 0) {

				for (Day day : calendar.getArrayDay()) {
					showDay(day);
				}
				System.out.println();
				return;
			}
		}
		showError();
	}

	public void showDay(Day day) {

		if (day != null) {

			if (day instanceof WorkDay) {
				showWorkDay((WorkDay) day);

			} else if (day instanceof DayOff) {

				if (!((DayOff) day).isHoliday()) {
					showDayOff((DayOff) day);

				} else {
					showHoliday((DayOff) day);
				}
			}

		} else {
			showError();
		}
	}

	private void showWorkDay(WorkDay workDay) {
		System.out.println("Work day : "
				+ new SimpleDateFormat("d.M.yyyy E").format(workDay.getDate()));
	}

	private void showDayOff(DayOff dayOff) {
		System.out.println("Day off : "
				+ new SimpleDateFormat("d.M.yyyy E").format(dayOff.getDate()));
	}

	private void showHoliday(DayOff dayOff) {
		System.out.println("Holiday : "
				+ new SimpleDateFormat("d.M.yyyy E").format(dayOff.getDate())
				+ " | Name holiday: " + dayOff.getHolidayName());
	}

	private void showError() {
		System.out.println("Error!");
	}
}
