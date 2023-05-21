package by.epam.basic_of_oop.task3.main;

import by.epam.basic_of_oop.task3.calendar.Calendar;
import by.epam.basic_of_oop.task3.calendar.Calendar.DayOff;
import by.epam.basic_of_oop.task3.calendar.CalendarFuction;
import by.epam.basic_of_oop.task3.calendar.CalendarView;
import by.epam.basic_of_oop.task3.day.Day;
import by.epam.basic_of_oop.task3.day.WorkDay;

/*
 * Задача 3: Создать класс Календарь с внутренним классом, 
 * с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

public class Main {

	public static void main(String[] args) {

		Day day1 = new WorkDay("09.04.2020");
		Day day2 = new WorkDay("10.04.2020");
		Day day3 = new DayOff("11.04.2020");
		Day day4 = new DayOff("12.04.2020");
		Day day5 = new DayOff(true, "Unknown Holiday", "13.04.2020");

		Calendar calendar = new Calendar();
		CalendarFuction fuction = new CalendarFuction();
		CalendarView view = new CalendarView();

		calendar.addDay(day1);
		calendar.addDay(day3);
		calendar.addDay(day2);
		calendar.addDay(day5);
		calendar.addDay(day4);

		view.showCalendar(calendar);

		fuction.sortDay(calendar);
		view.showCalendar(calendar);

		view.showDay(fuction.firstDayOffSearch(calendar));
		view.showDay(fuction.firstHolidaySearch(calendar));

	}

}
