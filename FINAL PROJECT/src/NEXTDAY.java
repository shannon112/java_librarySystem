public class NEXTDAY {
	public String today;

	public void toseveraldays(int n) {
		for (int i = 1; i <= n; ++i) {
			tomorrow();
		}
	}

	public void tomorrow() {
		DATE e = new DATE(today);
		e = e.addday(1);
		today = e.toString();
		//System.out.println(today);
		tooriginallibrary();
		overday1();
		overday2();
		overday3();
		overday4();
	}

	public void tooriginallibrary() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if (Integer.valueOf(list.BOOK[i].s4) != 0
					&& Integer.valueOf(list.BOOK[i].s4) != Integer.valueOf(list.BOOK[i].s0)) {
				list.BOOK[i].s4 = String.valueOf(Integer.valueOf(list.BOOK[i].s0));
			}
		}
	}

	public void overday1() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if (Integer.valueOf(list.BOOK[i].s4) == 0) {
				DATE m = new DATE(today);
				DATE n = new DATE(list.BOOK[i].s6);
				if (m.isAfter(n)) {
					for (int j = 0; j < list.UIDlength; ++j) {
						if (list.BOOK[i].s5.equals(list.UID[j].s0)) {
							list.UID[j].s1 = "-1";
						}
					}
				}
			}
		}

	}

	public void overday2() {
		for (int j = 0; j < list.UIDlength; ++j) {
			if (Integer.valueOf(list.UID[j].s1) == -1) {
				int a = 0;
				for (int i = 0; i < list.BOOKlength; ++i) {
					if ((list.BOOK[i].s5).equals(list.UID[j].s0) && Integer.valueOf(list.BOOK[i].s4) == 0) {
						a++;
					}
				}
				//System.out.println(a);
				DATE m = new DATE(today);
				DATE n1 = new DATE(list.UID[j].s2);
				//System.out.println(list.UID[j].s2);
				list.UID[j].s2 = n1.addday(a * 2).toString();
				DATE n2 = new DATE(list.UID[j].s2);
				//System.out.println(list.UID[j].s2);
				if (n2.difference(n1) > 60) {
					list.UID[j].s2 = m.addday(60).toString();
				}
			}
		}
	}

	public void overday3() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if (Integer.valueOf(list.BOOK[i].s4) != 0) {
				DATE m = new DATE(today);
				DATE n = new DATE(list.BOOK[i].s12);
				if (m.isAfter(n)) {
					for (int g = 0; g < list.UIDlength; ++g) {
						if (list.UID[g].s0.equals(list.BOOK[i].s9)) {
							DATE k = new DATE(list.UID[g].s5);
							k = m.addday(90);
							list.UID[g].s5 = k.toString();
						}
					}
				}
			}
		}
	}

	public void overday4() {
		for (int i = 0; i < list.UIDlength; ++i) {
			DATE m = new DATE(today);
			DATE n = new DATE(list.UID[i].s2);
			if (m.difference(n) >= 0 && list.UID[i].s1.equals("0")) {
				list.UID[i].s1 = "1";
			}
		}
	}

}