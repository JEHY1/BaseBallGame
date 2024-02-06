package Exercies01;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {

		String s = "aukks";
		String skip = "wbqd";	
		int index = 5;
		//
		boolean b = true;
		char[] arr = new char[26 - skip.length()];
		
		int idx = 0;
		for(int i = 97; i < 123; i++) {
			for(char c : skip.toCharArray()) {
				if(c == (char)i) {
					b = false;
					break;
				}
			}
			if(b) {
				arr[idx] = (char)i;
				idx++;
			}
			b = true;
		}
		
		System.out.println(Arrays.toString(arr));
		
		char[] sarr = s.toCharArray();
		
		for(int i = 0; i < sarr.length; i++) {
			System.out.println("=====================================");
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == sarr[i]) {
					System.out.println("before change : " + sarr[i]);
					System.out.println("key : " + arr[j] + " , index : " + j);
					System.out.println("i : " + i);
					System.out.println("arr.length : " + arr.length);
					sarr[i] = (j + 5 < arr.length) ? arr[j + 5] : arr[j + 5 - arr.length];
					System.out.println("after change : " + sarr[i]);
					break;
				}
			}
		}

		
		System.out.println(sarr);
			
		new String(sarr);
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.stream().mapToInt(i -> i).toArray();
		
		
		
		
		
	}

}
