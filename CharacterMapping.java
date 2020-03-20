import java.util.*;

public class CharacterMapping {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		if(args[0].equalsIgnoreCase("") || args[1].equalsIgnoreCase("") || args.length < 2){
			System.out.println("Invalid Arguments entered");
			return;
		}
		
		if(args[0].length() > args[1].length()){
			System.out.println("false");
			return;
		}
		
		boolean flag = true;
		char[] c1 = args[0].toCharArray();
		char[] c2 = args[1].toCharArray();

		HashMap<Character, Integer> mapStr1 = new HashMap<>();
		HashMap<Character, Integer> mapStr2 = new HashMap<>();

		for (char c : c1) {
			if (mapStr1.containsKey(c)) mapStr1.put(c, mapStr1.get(c) + 1);
			else mapStr1.put(c, 1);
		}

		for (char c : c2) {
			if (mapStr2.containsKey(c)) mapStr2.put(c, mapStr2.get(c) + 1);
			else mapStr2.put(c, 1);
		}

		PriorityQueue<Integer> Q1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> Q2 = new PriorityQueue<>(Collections.reverseOrder());

		for(Map.Entry<Character,Integer> entry : mapStr1.entrySet()) Q1.add(entry.getValue());
		
		for(Map.Entry<Character,Integer> entry : mapStr2.entrySet()) Q2.add(entry.getValue());
		
		Iterator<Integer> iter = Q1.iterator();
		while (iter.hasNext()) {
			if(Q1.peek() != null && Q2.peek() != null ){
				if(Q1.peek() <= Q2.peek()){
					int difference = Q2.remove() - Q1.remove();
					if(difference > 0) Q2.add(difference);
				}else {
					flag = false;
					break;
				}
			}
			else if(Q1.peek() == null && Q2.peek() != null) break;
			else if(Q1.peek() != null){
				flag = false;
				break;
			}
		}
        System.out.println(flag);
	}
}