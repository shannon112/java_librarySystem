public class RETURN {
	public static String user;
	public static String library;
	public static String booknumber;
	public static String returndate;
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

	public boolean noborrow() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if ((list.BOOK[i].s2).equals(booknumber)) {
				d = i;
			}
		}
		if (((list.BOOK[d].s5).equals(user)) && Integer.valueOf(list.BOOK[d].s4) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void acceptreturn() {
		list.BOOK[d].s4 = String.valueOf(Integer.valueOf(library));
		list.BOOK[d].s7 = String.valueOf(0);
		list.BOOK[d].s3 = String.valueOf(Integer.valueOf(list.BOOK[d].s3) + 1);
		list.UID[b].s3 = String.valueOf(Integer.valueOf(list.UID[b].s3) - 1);
		list.UID[b].s4 = String.valueOf(Integer.valueOf(list.UID[b].s4) + 1);
		DATE m = new DATE(returndate);
		list.BOOK[d].s12 = m.addday(5).toString();
		// ---------------------------------
		int g = 0;
		DATE n = new DATE(list.UID[b].s2);
		if (m.difference(n) < 0) {
			g = n.difference(m);
			//System.out.println(m.toString());
			//System.out.println(n.toString());
			} else {
		}
		// ---------------------------------
		if (list.UID[b].s1.equals("-1")&&list.UID[b].s3.equals("0")) {
			list.UID[b].s1 = new String("0");
		}
		if (list.UID[b].s1.equals("1")) {
			System.out.println("還書成功");
			System.out.println("仍可借" + (10 - Integer.valueOf(list.UID[b].s3)));
		} else {
			if (g > 60) {
				System.out.println("還書成功");
				System.out.println("暫停借書權 " + 60 + "天");
				System.out.println("仍可借 " + (10 - Integer.valueOf(list.UID[b].s3)));
				//list.UID[b].s2 = new String (m.addday(60).toString());
			}
			if (g <= 60 && g > 0) {
				System.out.println("還書成功");
				System.out.println("暫停借書權 " + g + "天");
				System.out.println("仍可借 " + (10 - Integer.valueOf(list.UID[b].s3)));
				//list.UID[b].s2 = new String (m.addday(g).toString());
			} else if (g <= 0) {
				// System.out.println("g = "+g);
				System.out.println("還書成功");
				System.out.println("仍可借 " + (10 - Integer.valueOf(list.UID[b].s3)));
			}
		}
	}
}