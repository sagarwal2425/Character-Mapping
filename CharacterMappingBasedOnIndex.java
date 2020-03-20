import java.util.HashMap;
import java.util.Scanner;

public class kargo1 {
	static boolean flag = true;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st String:");
		String str1 = sc.nextLine();
		System.out.println("Enter 2nd String:");
		String str2 = sc.nextLine();
		
		if(str1.equalsIgnoreCase("") || str2.equalsIgnoreCase("")){
			System.out.println("Arguments can not be null");
			return;
		}
		char[] s1_Char = str1.toCharArray();
		char[] s2_Char = str2.toCharArray();
		HashMap<Character, Character> hash = new HashMap<Character, Character>();
		for(int i=0; i<s1_Char.length; i++) {
			if(s2_Char.length>i) {
				if(!hash.containsKey(s1_Char[i])) hash.put(s1_Char[i], s2_Char[i]);
				else {
					if(hash.get(s1_Char[i])!=s2_Char[i]) {
						flag = false;
						break;
					}
				}
			}
			else break;
		}
		System.out.println(flag?"true":"false");
	}
}