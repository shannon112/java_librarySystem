//class array
public class list {
	static usercontent[] UID=new usercontent[100000];
	static bookcontent[] BOOK=new bookcontent[1000000];
	public static int UIDlength=0;
	public static int BOOKlength=0;
	public static void length(){
	for(int i=0;i<1000;i++){
		if(!(UID[i]==null)){
			list.UIDlength++;
		}
	}
	for(int i=0;i<10000;i++){
		if(!(BOOK[i]==null)){
			list.BOOKlength++;
		}
	}
	}
}
