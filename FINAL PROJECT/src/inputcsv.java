import java.io.*;

public class inputcsv {
	public static int counter1;
	public static int counter2;

	public static void userIn(String filename) throws IOException {
		BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "unicode"));
		String a = i.readLine();
		a = i.readLine();
		int counter1 = 0;
		while (!(a == null)) {
			list.UID[counter1] = new usercontent(a);
			counter1++;
			a = i.readLine();
		}
		i.close();
	}

	public static void bookIn(String filename) throws IOException {
		BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "unicode"));
		String a = i.readLine();
		a = i.readLine();
		int counter2 = 0;
		while (!(a == null)) {
			list.BOOK[counter2] = new bookcontent(a);
			counter2++;
			a = i.readLine();
		}
		i.close();
	}
}