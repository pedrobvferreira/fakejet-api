package fakejet.utils;

import java.time.LocalDate;

public class DateUtils {

	static public String addDaysToDate(String date, long daysToAdd) {
		return LocalDate.parse(date).plusDays(daysToAdd).toString();
	}
}
