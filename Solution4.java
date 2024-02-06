package Exercies01;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {

		int[] arr = {1, 4, 2, 5, 3};
		
		
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("==============");
			if(arrayList.size() != 0)
				System.out.println("array List last num : " + arrayList.get((arrayList.size() - 1)));
			System.out.println("arr[i] : " + arr[i]);
			
			
			if(arrayList.size() == 0) {
				arrayList.add(arr[i]);
			}
			else if(arrayList.get(arrayList.size() - 1) < arr[i]) {
				arrayList.add(arr[i]);
			}
			else {
				arrayList.remove(arrayList.size() - 1);
				i--;
			}
			System.out.println("after operate : " + arrayList);
		}
		


		System.out.println(arrayList);
		System.out.println(Arrays.toString(arrayList.stream().mapToInt(i -> i).toArray()));
	}

}
