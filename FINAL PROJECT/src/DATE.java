public class DATE {
	private int month, day, year;
	public DATE(int year, int month, int day) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public int getyear(){
		return year;
	}
	public int getmonth(){
		return month;
	}
	public int getday(){
		return day;
	}

	public DATE(String s) {
//		int a = -2, b = -2;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.indexOf(i) == '/') {
//				if (a == -2)
//					a = i + 1;
//				else if (b == -2)
//					b = i + 1;
//				else
//					;// error
//			}
//		}
//		if (a == -2 || b == -2 || a - 1 < 1 || a - 1 > 2 || b - a - 1 < 1 || b - a - 1 > 2 || s.length() - b > 4
//				|| b - a - 1 < 1) {
//			// error
//		}
		String[] monthdayyear = new String[3];
		monthdayyear = s.split("/");
		this.month = Integer.parseInt(monthdayyear[1]);
		this.day = Integer.parseInt(monthdayyear[2]);
		this.year = Integer.parseInt(monthdayyear[0]);
	}

	boolean isLeapYear() {// find leap year
		if (year % 400 == 0)
			return true;
		else if (year % 100 == 0)
			return false;
		else if (year % 4 == 0)
			return true;
		else
			return false;
	}
	
	boolean isLeapYear(int x) {
		if (x % 400 == 0)
			return true;
		else if (x % 100 == 0)
			return false;
		else if (x % 4 == 0)
			return true;
		else
			return false;
	}

	private int daysInMonth(int month) {
		if (this.isLeapYear())// leap year
			switch (month) {
			case 1:
				return 31;
			case 2:
				return 29;
			case 3:
				return 31;
			case 4:
				return 30;
			case 5:
				return 31;
			case 6:
				return 30;
			case 7:
				return 31;
			case 8:
				return 31;
			case 9:
				return 30;
			case 10:
				return 31;
			case 11:
				return 30;
			case 12:
				return 31;
			default:
				return -1;
			}
		else
			switch (month) {
			case 1:
				return 31;
			case 2:
				return 28;
			case 3:
				return 31;
			case 4:
				return 30;
			case 5:
				return 31;
			case 6:
				return 30;
			case 7:
				return 31;
			case 8:
				return 31;
			case 9:
				return 30;
			case 10:
				return 31;
			case 11:
				return 30;
			case 12:
				return 31;
			default:
				return -1;
			}
	}

	public boolean isValidDate() {
		if (month >= 1 && month <= 12 && year >= 1 && day >= 1 && day <= daysInMonth(month)) {
			return true;
		} else
			return false;
	}

	public String toString() {
		String x, y, z;
		x = String.valueOf(month);
		y = String.valueOf(day);
		z = String.valueOf(year);
		String a;
		if(day<10){
			if(month<10){
				a = z + "/0" + x + "/0" + y;
			}else{
				a = z + "/" + x + "/0" + y;
			}
		}
		else{
			if(month<10){
				a = z + "/0" + x + "/" + y;
			}else{
				a = z + "/" + x + "/" + y;
			}
		}
		return a;
	}
	
	public boolean isAfter(DATE d) {
		if (year > d.year)
			return true;
		else if (year == d.year) {
			if (month > d.month)
				return true;
			else if (month == d.month) {
				if (day > d.day)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}

	public int dayInYear() {
		int p=0;
		for (int i = 1; i < month;i++) {//add days form 1 to "month"-1
			p += daysInMonth(i);
		}
		p += day;//add the days in "month"
		return p;
	}
	
	public int difference(DATE d) {
		int f=0;
		if (year == d.year)//in the same year
			return dayInYear() - d.dayInYear();
		else if (year > d.year) {//test year is larger
			for (int i = d.year + 1; i < year; i++) {
				if (isLeapYear(i))
					f += 366;
				else
					f += 365;
			}
			if (d.isLeapYear())
				f += 366 - d.dayInYear();
			else
				f += 365 - d.dayInYear();
			f += dayInYear();
			return f;
		}
		else if (year < d.year) {//test year is smaller
			for (int i = year + 1; i < d.year; i++) {
				if (isLeapYear(i))
					f -= 366;
				else
					f -= 365;
			}
			if (isLeapYear())
				f =f -366 + dayInYear();
			else
				f =f -365 + dayInYear();
			f -= d.dayInYear();
			return f;
		}
		else {
			//error
			return 0;
		}
	}
	
	public int todayInYear() {
		int p = 0;
		for (int i = 1; i < month; i++) {// add days form 1 to "month"-1
			p += daysInMonth(i);
		}
		p += day;// add the days in "month"
		return p;
	}

	public DATE addday(int a) {
		int x = this.todayInYear() + a;
		int diy, k;
		if (this.isLeapYear()) {
			diy = 366;
		} else {
			diy = 365;
		}
		if (x > diy) {
			x -= diy;
			for (k = 1; x > this.daysInMonth(k) && k < 12;) {
				x -= this.daysInMonth(k);
				k++;
			}
			DATE c = new DATE(year + 1,k, x );
			return c;
		} else {
			for (k = 1; x > this.daysInMonth(k) && k < 12;) {
				x -= this.daysInMonth(k);
				k++;
			}
			DATE c = new DATE(year,k, x );
			return c;
		}
	}

}