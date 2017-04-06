public class BORROW {
	public static String user;
	public static String library;
	public static String booknumber;
	public static String borrowdate;
	int a = 0;// using in ckeckuser
	int b = 0;// user place in UID
	int c = 0;// using in samebooknumber
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

	public boolean userauthority() {
		if (Integer.valueOf(list.UID[b].s1) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean bookupperlimit() {
		if (Integer.valueOf(list.UID[b].s3) == 10) {
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

	public boolean samebooknumber() {
		if (Integer.valueOf(list.BOOK[d].s4) == 0) {
			if ((list.BOOK[d].s5).equals(user)) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public boolean bookinlibrary() {
		if ((list.BOOK[d].s4).equals(library)) {
			return true;
		} else {
			if ((list.BOOK[d].s4).equals("0")) {
				return false;
			} else {
				return false;
			}
		}
	}
			
	public boolean serve() {
		if (Integer.valueOf(list.BOOK[d].s8) != 0 && list.BOOK[d].s9.equals(user)) {
			return true;
		}
		else if(Integer.valueOf(list.BOOK[d].s8) != 0){
			return false;
		}
		else {
			return true;
		}
	}

	public void acceptborrow() {
		if (Integer.valueOf(list.BOOK[d].s8) != 0 && (list.BOOK[d].s9).equals(user)) {
			list.UID[b].s6 = String.valueOf((Integer.valueOf(list.UID[b].s6)) - 1);
			list.BOOK[d].s8 = String.valueOf((Integer.valueOf(list.BOOK[d].s8)) - 1);
			list.BOOK[d].s9 = new String(list.BOOK[d].s10);
			list.BOOK[d].s10 = new String(list.BOOK[d].s11);
		}
		DATE a = new DATE(borrowdate);
		list.BOOK[d].s5 = new String(user);
		list.BOOK[d].s6 = a.addday(30).toString();
		list.BOOK[d].s4 = "0";
		list.UID[b].s3 = String.valueOf((Integer.valueOf(list.UID[b].s3)) + 1);
		System.out.println(user + "借書成功");
		System.out.println("歸還期限為" + list.BOOK[d].s6);
		System.out.println("仍可借數量 " + (10 - (Integer.valueOf(list.UID[b].s3))));
		// ----------------------------------
		String[] m = new String[10];
		int x = 0;
		for (int i = 0; i < 10; ++i) {
			m[i] = new String("3000/01/01");
		}
		for (int i = 0; i < list.BOOKlength; ++i) {
			if (list.BOOK[i].s5.equals(list.UID[b].s0) && list.BOOK[i].s4.equals("0")) {
				m[x] = list.BOOK[i].s6;
				++x;
			}
		}
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				DATE p = new DATE(m[j]);
				DATE q = new DATE(m[j + 1]);
				if (q.difference(p) <= 0) {
					m[j] = new String(m[j + 1]);
				}
			}
		}
		list.UID[b].s2 = new String(m[0]);
		//System.out.println(m[0]);

	}

}
