import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class DataUID {
	public static String[] tempUIDlist = new String[1000000];
	public static String[] tempBOOKlist = new String[1000000];
	public static String[][] UIDlist;
	public static String[][] BOOKlist;
	public static int matrixsize1 = 0;
	public static int matrixsize2 = 0;

	public DataUID() throws IOException {
		DataUID.userIn("UID.csv");
		UIDlist = DataUID.trim1();
		for (int u = 0; u < matrixsize1; u++) {
			String[] temp = tempUIDlist[u].split(",");
			for (int U = 0; U < temp.length; U++)
				UIDlist[u][U] = temp[U];
		}
		DataUID.bookIn("booksAndBranches.csv");
		BOOKlist = DataUID.trim2();
		for (int u = 0; u < matrixsize2; u++) {
			String[] temp = tempBOOKlist[u].split(",");
			for (int U = 0; U < temp.length; U++)
				BOOKlist[u][U] = temp[U];
		}
	}

	public static void userIn(String filename) throws IOException {
		BufferedReader i = new BufferedReader(new FileReader(filename));
		String a = i.readLine();
		int counter = 0;
		a = i.readLine();
		tempUIDlist[counter] = a;
		while (!(a == null)) {
			a = i.readLine();
			counter++;
			tempUIDlist[counter] = a;
		}
		i.close();
	}

	public static void bookIn(String filename) throws IOException {
		BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "unicode"));
		String a = i.readLine();
		int counter = 0;
		a = i.readLine();
		tempBOOKlist[counter] = a;
		while (!(a == null)) {
			a = i.readLine();
			counter++;
			tempBOOKlist[counter] = a;
		}
		i.close();
	}

	public static String[][] trim1() {
		for (int p = 0; p < 1000000; p++) {
			if (tempUIDlist[p] != null) {
				matrixsize1++;
			}
		}
		return new String[matrixsize1][7];
	}

	public static String[][] trim2() {
		for (int p = 0; p < 1000000; p++) {
			if (tempBOOKlist[p] != null) {
				matrixsize2++;
			}
		}
		return new String[matrixsize2][16];
	}
}
