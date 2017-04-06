public class RENEW {
	public static String user;
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

	public boolean noborrow() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if ((list.BOOK[i].s2).equals(booknumber)) {
				d = i;
			}
		}
		if (!((list.BOOK[d].s5).equals(user))) {
			return false;
		} else {
			return true;
		}
	}

	public boolean renewlimit() {
		if (Integer.valueOf(list.BOOK[d].s7) == 2) {
			return false;
		} else {
			list.BOOK[d].s7 = String.valueOf(Integer.valueOf(list.BOOK[d].s7) + 1);
			return true;
		}
	}

	public boolean otherreserve() {
		if (Integer.valueOf(list.BOOK[d].s8) != 0)
			return false;
		else {
			return true;
		}
	}

	public void acceptrenew() {
		DATE a = new DATE(borrowdate);
		list.BOOK[d].s6 = a.addday(30).toString();
		System.out.println(user + " 續借成功");
		System.out.println("歸還期限  " + list.BOOK[d].s6);
		System.out.println("仍可借數量  " + (10 - (Integer.valueOf(list.UID[b].s3))));
	}

}