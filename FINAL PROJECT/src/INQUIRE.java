import java.io.IOException;

public class INQUIRE {
	public static String library;
	public static String booknumber;
	int d = -1;// book place in booksAndBranches
	int y = 1;// book exist or not

	public void bookcondition() {
		for (int i = 0; i < list.BOOKlength; ++i) {
			if (list.BOOK[i].s2.equals(booknumber)) {
				d = i;
			}
		}
		if (d == -1) {
			System.out.println("book does not exist");
			System.exit(0);
		} else if (Integer.valueOf(list.BOOK[d].s4) == 0) {
			System.out.println("書已被借走");
		} else {
			System.out.println("書原館位於" + list.BOOK[d].s0);
			System.out.println("書目前在" + list.BOOK[d].s4);
		}
	}

	public void bookBorrowed() {
		int a = 0;
		for (int i = 0; i < list.BOOKlength; ++i) {
			if (Integer.valueOf(list.BOOK[i].s4) == 0) {
				a++;
			}
		}
		System.out.println("目前總借出數量" + a);
	}

	public void peopleBorrowing() {
		int a = 0;
		for (int i = 0; i < list.UIDlength; ++i) {
			if (Integer.valueOf(list.UID[i].s3) != 0) {
				a++;
			}
		}
		System.out.println("目前總借書人數" + a);
	}

	public void userBorrowingBookRank() {
		int a = -1;
		int[] b = new int[300];
		int c = 0;
		for (int j = 10; j > -1; j--) {
			for (int i = 0; i < list.UIDlength; ++i) {
				// if (a == 10) {
				// break;
				// }
				if (Integer.valueOf(list.UID[i].s3) == j) {
					a++;
					b[a] = i;
				}

			}
			if (a > 8) {
				break;
			}
		}
		if (a == list.UIDlength) {
			while (Integer.valueOf(list.UID[b[c]].s3) > 0) {
				c++;
			}
			for (int i = 0; i < c; ++i) {
				System.out.println(i + ", " + list.UID[b[i]].s0 + ", " + list.UID[b[i]].s3);
				System.out.println(" ");
			}
		} else {
			int x = 1;
			for (int i = 1; i < a + 1; ++i) {
				System.out.println(x + ", " + list.UID[b[i - 1]].s0 + ", " + list.UID[b[i - 1]].s3);
				if (!(list.UID[b[i - 1]].s3).equals(list.UID[b[i]].s3)) {
					x++;
				}
			}
		}

		// for (int i = 1; i < a + 1; ++i) {
		// System.out.println(i + ", " + list.UID[b[i - 1]].s0 + ", " +
		// list.UID[b[i - 1]].s3);
		// }
	}

	public void userHasBorrowedBookRank() {
		int a = 0;
		int c = 0;
		int[] b = new int[300];
		int max = 0;
		for (int i = 0; i < list.UIDlength; ++i) {
			if (Integer.valueOf(list.UID[i].s4) >= max) {
				max = Integer.valueOf(list.UID[i].s4);
			}
		}

		for (int j = max; j > 0; --j) {
			for (int i = 0; i < list.UIDlength; ++i) {
				// if (a == 10) {
				// break;
				// }
				if (Integer.valueOf(list.UID[i].s4) == j) {
					b[a] = i;
					a++;
				}
			}
			if (a > 9) {
				break;
			}
		}
		if (a == list.UIDlength) {
			while (Integer.valueOf(list.UID[b[c]].s4) > 0) {
				c++;
			}
			for (int i = 0; i < c; ++i) {
				System.out.println(i + ", " + list.UID[b[i]].s0 + ", " + list.UID[b[i]].s4);
				System.out.println(" ");
			}
		} else {
			int x = 1;
			for (int i = 1; i < a + 1; ++i) {
				System.out.println(x + ", " + list.UID[b[i - 1]].s0 + ", " + list.UID[b[i - 1]].s4);
				if (!(list.UID[b[i - 1]].s4).equals(list.UID[b[i]].s4)) {
					x++;
				}
			}
		}
		// for (int i = 1; i < a + 1; ++i) {
		// System.out.println(i + ", " + list.UID[b[i - 1]].s0 + ", " +
		// list.UID[b[i - 1]].s4);
		// }
	}
}
