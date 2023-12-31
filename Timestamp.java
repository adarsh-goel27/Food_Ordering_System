public class Timestamp 
{
    static int getMonthFromUnixTime(int seconds)
    {

		
		int daysOfMonth[] = { 31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31 };

		int currYear, daysTillNow, extraTime, extraDays,index, date, month, hours, minutes, secondss,flag = 0;
		daysTillNow = seconds / (24 * 60 * 60);
		extraTime = seconds % (24 * 60 * 60);
		currYear = 1970;
		while (true) {
		if (currYear % 400 == 0
			|| (currYear % 4 == 0 && currYear % 100 != 0)) {
			if (daysTillNow < 366) {
				break;
			}
			daysTillNow -= 366;
		}
		else {
			if (daysTillNow < 365) {
				break;
			}
			daysTillNow -= 365;
		}
		currYear += 1;
	}

		
		extraDays = daysTillNow + 1;

		if (currYear % 400 == 0 || (currYear % 4 == 0 && currYear % 100 != 0))
			flag = 1;
		month = 0;
		index = 0;
		if (flag == 1) {
			while (true) {
				if (index == 1) {
					if (extraDays - 29 < 0)
						break;

					month += 1;
					extraDays -= 29;
				}
				else {
					if (extraDays - daysOfMonth[index]
						< 0) {
						break;
					}
					month += 1;
					extraDays -= daysOfMonth[index];
				}
				index += 1;
			}
		}
		else {
			while (true) {
				if (extraDays - daysOfMonth[index] < 0) {
					break;
				}
				month += 1;
				extraDays -= daysOfMonth[index];
				index += 1;
			}
		}

		// Current Month
		if (extraDays > 0) {
			month += 1;
			date = extraDays;
		}
		else {
			if (month == 2 && flag == 1)
				date = 29;
			else {
				date = daysOfMonth[month - 1];
			}
		}
        return month;
    }
    static String unixTimeToHumanReadable(int seconds)
	{

		// Save the time in Human
		// readable format
		String ans = "";

		// Number of days in month
		// in normal year
		int daysOfMonth[] = { 31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31 };

		int currYear, daysTillNow, extraTime, extraDays,
			index, date, month, hours, minutes, secondss,
			flag = 0;

		// Calculate total days unix time T
		daysTillNow = seconds / (24 * 60 * 60);
		extraTime = seconds % (24 * 60 * 60);
		currYear = 1970;

		// Calculating current year
		while (true) {
		if (currYear % 400 == 0
			|| (currYear % 4 == 0 && currYear % 100 != 0)) {
			if (daysTillNow < 366) {
				break;
			}
			daysTillNow -= 366;
		}
		else {
			if (daysTillNow < 365) {
				break;
			}
			daysTillNow -= 365;
		}
		currYear += 1;
	}

		// Updating extradays because it
		// will give days till previous day
		// and we have include current day
		extraDays = daysTillNow + 1;

		if (currYear % 400 == 0
			|| (currYear % 4 == 0 && currYear % 100 != 0))
			flag = 1;

		// Calculating MONTH and DATE
		month = 0;
		index = 0;
		if (flag == 1) {
			while (true) {
				if (index == 1) {
					if (extraDays - 29 < 0)
						break;

					month += 1;
					extraDays -= 29;
				}
				else {
					if (extraDays - daysOfMonth[index]
						< 0) {
						break;
					}
					month += 1;
					extraDays -= daysOfMonth[index];
				}
				index += 1;
			}
		}
		else {
			while (true) {
				if (extraDays - daysOfMonth[index] < 0) {
					break;
				}
				month += 1;
				extraDays -= daysOfMonth[index];
				index += 1;
			}
		}

		// Current Month
		if (extraDays > 0) {
			month += 1;
			date = extraDays;
		}
		else {
			if (month == 2 && flag == 1)
				date = 29;
			else {
				date = daysOfMonth[month - 1];
			}
		}

		// Calculating HH:MM:YYYY
		hours = extraTime / 3600;
		minutes = (extraTime % 3600) / 60;
		secondss = (extraTime % 3600) % 60;

		ans += String.valueOf(date);
		ans += "/";
		ans += String.valueOf(month);
		ans += "/";
		ans += String.valueOf(currYear);
		ans += " ";
		ans += String.valueOf(hours);
		ans += ":";
		ans += String.valueOf(minutes);
		ans += ":";
		ans += String.valueOf(secondss);

		// Return the time
		return ans;
	}
    static int getHHFromUnixTime(int seconds)
	{

		// Save the time in Human
		// readable format
		String ans = "";

		// Number of days in month
		// in normal year
		int daysOfMonth[] = { 31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31 };

		int currYear, daysTillNow, extraTime, extraDays,
			index, date, month, hours, minutes, secondss,
			flag = 0;

		// Calculate total days unix time T
		daysTillNow = seconds / (24 * 60 * 60);
		extraTime = seconds % (24 * 60 * 60);
		currYear = 1970;

		// Calculating current year
		while (true) {
		if (currYear % 400 == 0
			|| (currYear % 4 == 0 && currYear % 100 != 0)) {
			if (daysTillNow < 366) {
				break;
			}
			daysTillNow -= 366;
		}
		else {
			if (daysTillNow < 365) {
				break;
			}
			daysTillNow -= 365;
		}
		currYear += 1;
	}

		// Updating extradays because it
		// will give days till previous day
		// and we have include current day
		extraDays = daysTillNow + 1;

		if (currYear % 400 == 0
			|| (currYear % 4 == 0 && currYear % 100 != 0))
			flag = 1;

		// Calculating MONTH and DATE
		month = 0;
		index = 0;
		if (flag == 1) {
			while (true) {
				if (index == 1) {
					if (extraDays - 29 < 0)
						break;

					month += 1;
					extraDays -= 29;
				}
				else {
					if (extraDays - daysOfMonth[index]
						< 0) {
						break;
					}
					month += 1;
					extraDays -= daysOfMonth[index];
				}
				index += 1;
			}
		}
		else {
			while (true) {
				if (extraDays - daysOfMonth[index] < 0) {
					break;
				}
				month += 1;
				extraDays -= daysOfMonth[index];
				index += 1;
			}
		}

		// Current Month
		if (extraDays > 0) {
			month += 1;
			date = extraDays;
		}
		else {
			if (month == 2 && flag == 1)
				date = 29;
			else {
				date = daysOfMonth[month - 1];
			}
		}

		// Calculating HH:MM:YYYY
		hours = extraTime / 3600;
		minutes = (extraTime % 3600) / 60;
		secondss = (extraTime % 3600) % 60;

		

		// Return the time
		return hours;
	}
    
}
    

