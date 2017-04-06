public class RESERVE {
	public static String user;
	public static String booknumber;
	public static String reservedate;
	int a = 0;// using in ckeckuser
	int b = 0;// user place in UID
	int c = 0;// using in bookexist
	int d = 0;// book place in booksAndBranches

	public boolean checkuser() {
		for (int i = 0; i < list.UIDlength; ++i) {
			if ((list.UID[i].s0).equals(user)) {
				a = 1;
				b = i;
			}
		}
		if (a == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean reserveright() {
		DATE m = new DATE(reservedate);
		DATE n = new DATE(list.UID[b].s5);
		if (m.isAfter(n)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean reservelimit() {
		if (Integer.valueOf(list.UID[b].s6) == 5) {
			return false;
		} else {
			return true;
		}
	}

	public boolean samebook() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if ((list.BOOK[i].s2).equals(booknumber)) {
				c = 1;
				d = i;
			}
		}
		if (Integer.valueOf(list.BOOK[d].s4) == 0 && (list.BOOK[d].s4).equals(user)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean bookexist() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if ((list.BOOK[i].s2).equals(booknumber)) {
				c = 1;
				d = i;
			}
		}
		if (c == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean otherlimit() {
		if (Integer.valueOf(list.BOOK[d].s8) == 3) {
			return false;
		} else {
			return true;
		}
	}

	public void acceptreserve() {
		list.UID[b].s6 = String.valueOf(Integer.valueOf(list.UID[b].s6) + 1);
		list.BOOK[d].s8 = String.valueOf(Integer.valueOf(list.BOOK[d].s8) + 1);
		if (list.BOOK[d].s8.equals("1")) {
			list.BOOK[d].s9 = new String(user);
			DATE m = new DATE(reservedate);
			list.BOOK[d].s12 = m.addday(5).toString();
		} else if (list.BOOK[d].s8.equals("2")) {
			list.BOOK[d].s10 = new String(user);
		} else {
			list.BOOK[d].s11 = new String(user);
		}
		System.out.println(user+"預約成功");
		System.out.println("前面有" + (Integer.valueOf(list.BOOK[d].s8)-1) + "預約");
	}

}