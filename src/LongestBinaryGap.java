import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;


public class LongestBinaryGap {

	public static void main(String[] args) {
		//int N = 51712;
		int N = 4787;
		//int N = 6;
		//int N = 16;
		//int N = 1041;
		StringBuilder s = binaryRep(N);
		System.out.println("Binary representation of " + N + " is " + s);
		String[] splitted = split(s.toString());
		int longestGap = longestGap(splitted, s).getAsInt();
		System.out.println("The Longest gap is: " + longestGap);
	}

	public static StringBuilder binaryRep(int N){
		StringBuilder s = new StringBuilder();
		while(N >= 1)
		{
			s.append(N%2);
			N = N/2;
		}
			
		return s.reverse();
	}
	
	public static String[] split(String s){
		return s.toString().split("1");
	}
	
	public static OptionalInt longestGap(String[] splitted, StringBuilder s){
		List<Integer> list = new ArrayList<Integer>();
		if(s.toString().startsWith("1") & s.toString().endsWith("1"))
		{
			for (int i = 0; i < splitted.length; i++) {
				
				list.add(splitted[i].length());
			}
			
			OptionalInt o = list.stream().mapToInt(Integer::intValue).max();
			return o;
		}
		else
			return OptionalInt.of(0);
	}
}
