import java.io.IOException;
import java.util.Scanner;

public class MAINCLASS {
	public static String input;
	public static String user;
	public static String confirm;
	public static String confirmupday;
	public static String wanttodo;
	public static String exit;
	public static String upday;
	public static String now = "2010/01/01";

	public static void main(String[] args) throws IOException {

		inputcsv.userIn("UID.csv");
		inputcsv.bookIn("booksAndBranches.csv");
		list.length();

		while (true) {
			while (true) {
				System.out.println("今天日期為" + now);
				System.out.println("請問要更變日期嗎[y/N]");
				Scanner scannii = new Scanner(System.in);
				upday = scannii.nextLine();
				if (upday.equals("y") || upday.equals("Y")) {
				    System.out.println("請問要變更幾天");
				    Scanner scannll = new Scanner(System.in);
					String times = scannll.nextLine();
					int k = Integer.valueOf(times);
					NEXTDAY N=new NEXTDAY();
					N.today=new String(now);
					N.toseveraldays(k);
					now=new String(N.today);
					continue;
					
					//System.out.println("ready to nextday...");
					//NEXTDAY N=new NEXTDAY();
					//N.today=new String(now);
					//N.tomorrow();
					//now=new String(N.today);
					//continue;
				} else if (upday.equals("n") || upday.equals("N")) {
					System.out.println("OK,today does not change");
					System.out.println("////////////////////////////////////////////////////////////////////////////////");
					break;
				} else {
					System.out.println("error, back to question");
					continue;
				}
			}

			System.out.println("請輸入動作");
			System.out.println("若要借書 輸入 UID, \"borrow\", 館名, 書碼, 借書日期");
			System.out.println("若要還書 輸入 UID, \"return\", 館名, 書碼, 還書日期");
			System.out.println("若要續借 輸入 UID, \"renew\", 書碼, 續借日期");
			System.out.println("若要預約 輸入  UID, \"reserve\", 書碼, 預約日期");
			System.out.println(
					"若要查詢 \ninput= \"inquire\", 館名, 書碼  或是\ninput= \"inquire\",\"userBorrowingBookRank\"\ninput= \"inquire\",\"bookBorrowed\"\ninput= \"inquire\",\"peopleBorrowing\"\ninput= \"inquire\",\"userHasBorrowedBookRank\"\n");
			System.out.println("//////////////////////////////////////////////////////////////////////");
			System.out.println("please input your request:");
			while (true) {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();
				System.out.println("//////////////////////////////////////////////////////////////////////");
				System.out.println("confirm input[y/N]");
				confirm = scanner.nextLine();
				if (confirm.equals("y") || confirm.equals("Y")) {
					System.out.println("ready to begin...");
					System.out.println("//////////////////////////////////////////////////////////////////////");
					break;
				} else if (confirm.equals("n") || confirm.equals("N")) {
					System.out.println("please re-input your request:");
				} else {
					System.out.println("error, back to input your request:");
				}
			}

			String usersplit[] = input.split(",");
			user = usersplit[0];
			// inquire//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (user.equals("\"inquire\"")) {
				if (usersplit.length == 3) {
					INQUIRE I = new INQUIRE();
					INQUIRE.library = usersplit[1];
					INQUIRE.booknumber = usersplit[2];
					System.out.println("正幫您查詢書籍狀態");
					I.bookcondition();
				} else if (usersplit[1].equals("\"bookBorrowed\"")) {
					System.out.println("正幫您查詢總借出數量");
					INQUIRE I = new INQUIRE();
					I.bookBorrowed();
				} else if (usersplit[1].equals("\"peopleBorrowing\"")) {
					System.out.println("正幫您查詢總借書人數");
					INQUIRE I = new INQUIRE();
					I.peopleBorrowing();
				} else if (usersplit[1].equals("\"userBorrowingBookRank\"")) {
					System.out.println("正幫您查詢當前借閱量最多的10位user");
					INQUIRE I = new INQUIRE();
					I.userBorrowingBookRank();
				} else if (usersplit[1].equals("\"userHasBorrowedBookRank\"")) {
					System.out.println("正幫您查詢總借閱量最多的10位user");
					INQUIRE I = new INQUIRE();
					I.userHasBorrowedBookRank();
				} else {
					System.out.println("error using inquire\n");
				}
				System.out.println("///////////////////////////////////////////////////////////////////////");
				System.out.println("do you want to continue?[y/N]");
				Scanner scannerr = new Scanner(System.in);
				exit = scannerr.nextLine();
				if (exit.equals("y") || exit.equals("Y")) {
					System.out.println("ready to continue...");
					System.out.println("///////////////////////////////////////////////////////////////////////");
					continue;
				} else if (exit.equals("n") || exit.equals("N")) {
					System.out.println("ready to exit program...");
					System.exit(0);
				} else {
					System.out.println("error, default to continue program...");
					continue;
				}
			} else {
			}
			wanttodo = usersplit[1];
			// borrow///////////////////////////////////////////////////////////////////////////////////
			if (wanttodo.equals("\"borrow\"")) {
				System.out.println("正幫您借書");
				BORROW B = new BORROW();
				BORROW.user = user;
				BORROW.library = usersplit[2];
				BORROW.booknumber = usersplit[3];
				BORROW.borrowdate = now;
				boolean checkU = B.checkuser();
				boolean checkB = B.bookexist();
				if (checkU == false) {
					System.out.println("error in checkuser");
				} else if (checkB == false) {
					System.out.println("error in bookexist");
				} else if (B.userauthority() == false) {
					System.out.println("error in userauthority");
				} else if (B.bookupperlimit() == false) {
					System.out.println("error in bookupperlimit");
				} else if (B.bookexist() == false) {
					System.out.println("error in bookexist");
				} else if (B.bookinlibrary() == false) {
					System.out.println("error in bookinlibrary");
				} else if (B.samebooknumber() == false) {
					System.out.println("error in samebooknumber");
				} else if (B.serve() == false) {
					System.out.println("error in serve");
				} else {
					B.acceptborrow();
				}
				System.out.println("///////////////////////////////////////////////////////////////////////");
				System.out.println("do you want to continue?[y/N]");
				Scanner scanneaa = new Scanner(System.in);
				exit = scanneaa.nextLine();
				if (exit.equals("y") || exit.equals("Y")) {
					System.out.println("ready to continue...");
					System.out.println("///////////////////////////////////////////////////////////////////////");
					continue;
				} else if (exit.equals("n") || exit.equals("N")) {
					System.out.println("ready to exit program...");
					System.exit(0);
				} else {
					System.out.println("error, default to continue program...");
					continue;
				}
			// return//////////////////////////////////////////////////////////////////////////////////////////////////
			} else if (wanttodo.equals("\"return\"")) {
				System.out.println("正幫您還書");
				RETURN U = new RETURN();
				RETURN.user = user;
				RETURN.library = usersplit[2];
				RETURN.booknumber = usersplit[3];
				RETURN.returndate = now;
				boolean checkU = U.checkuser();
				boolean checkB = U.noborrow();
				if (checkU == false) {
					System.out.println("error in checkuser");
				} else if (checkB == false) {
					System.out.println("error in noborrow");
				} else {
					U.acceptreturn();
				}
				System.out.println("///////////////////////////////////////////////////////////////////////");
				System.out.println("do you want to continue?[y/N]");
				Scanner scannebb = new Scanner(System.in);
				exit = scannebb.nextLine();
				if (exit.equals("y") || exit.equals("Y")) {
					System.out.println("ready to continue...");
					System.out.println("///////////////////////////////////////////////////////////////////////");
					continue;
				} else if (exit.equals("n") || exit.equals("N")) {
					System.out.println("ready to exit program...");
					System.exit(0);
				} else {
					System.out.println("error, default to continue program...");
					continue;
				}
				// renew///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			} else if (wanttodo.equals("\"renew\"")) {
				System.out.println("正幫您續借");
				RENEW R = new RENEW();
				RENEW.user = user;
				RENEW.booknumber = usersplit[2];
				RENEW.borrowdate = now;
				boolean checkU = R.checkuser();
				boolean checkN = R.noborrow();
				if (checkU == false) {
					System.out.println("error in checkuser");
				} else if (checkN == false) {
					System.out.println("error in noborrow");
				} else if (R.userauthority() == false) {
					System.out.println("error in userauthority");
				} else if (R.renewlimit() == false) {
					System.out.println("error in renewlimit");
				} else if (R.otherreserve() == false) {
					System.out.println("error in otherreserve");
				} else {
					R.acceptrenew();
				}
				System.out.println("///////////////////////////////////////////////////////////////////////");
				System.out.println("do you want to continue?[y/N]");
				Scanner scannecc = new Scanner(System.in);
				exit = scannecc.nextLine();
				if (exit.equals("y") || exit.equals("Y")) {
					System.out.println("ready to continue...");
					System.out.println("///////////////////////////////////////////////////////////////////////");
					continue;
				} else if (exit.equals("n") || exit.equals("N")) {
					System.out.println("ready to exit program...");
					System.exit(0);
				} else {
					System.out.println("error, default to continue program...");
					continue;
				}
				// reserve///////////////////////////////////////////////////////////////////////////
			} else if (wanttodo.equals("\"reserve\"")) {
				System.out.println("正幫您預約");
				RESERVE S = new RESERVE();
				RESERVE.user = user;
				RESERVE.booknumber = usersplit[2];
				RESERVE.reservedate = now;
				boolean checkU = S.checkuser();
				boolean checkB = S.bookexist();
				if (checkU == false) {
					System.out.println("error in checkuser");
				} else if (checkB == false) {
					System.out.println("error in bookexist");
				} else if (S.reserveright() == false) {
					System.out.println("error in reserveright");
				} else if (S.reservelimit() == false) {
					System.out.println("error in reservelimit");
				} else if (S.samebook() == false) {
					System.out.println("error in samebook");
				} else if (S.otherlimit() == false) {
					System.out.println("error in otherlimit");
				} else {
					S.acceptreserve();
				}
				System.out.println("///////////////////////////////////////////////////////////////////////");
				System.out.println("do you want to continue?[y/N]");
				Scanner scannedd = new Scanner(System.in);
				exit = scannedd.nextLine();
				if (exit.equals("y") || exit.equals("Y")) {
					System.out.println("ready to continue...");
					System.out.println("///////////////////////////////////////////////////////////////////////");
					continue;
				} else if (exit.equals("n") || exit.equals("N")) {
					System.out.println("ready to exit program...");
					System.exit(0);
				} else {
					System.out.println("error, default to continue program...");
					continue;
				}
				// unknowrequest////////////////////////////////////////////////////////////////////////////
			} else {
				System.out.println("invalid request:out of\"borrow\".\"return\".\"renew\".\"reserve\".\"inquire\"");
				System.out.println("///////////////////////////////////////////////////////////////////////");
				continue;
			}
		}
	}
}
