package Exercies01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {

		String[] park = { "OSO", "OOO", "OXO", "OOO" };
		String[] routes = { "E 2", "S 3", "W 1" };
		//

		int[] currentLocation = new int[2];	
		
		ArrayList<String>[] lows = new ArrayList[park.length];
		for(int i = 0; i < park.length; i++) {
			lows[i] = new ArrayList<String>();
		}
		
		ArrayList<String>[] columns = new ArrayList[park[0].length()];
		for(int i = 0; i<park[0].length(); i++) {
			columns[i] = new ArrayList<>();
		}
		int i = 0;

		int j = 0;
		for (String locationStatus : park) {
			String[] status = locationStatus.split("");
			for (String stat : status) {
				lows[i].add(stat);
				if(stat.equals("S")) {
					currentLocation[0] = i;
					currentLocation[1] = j;
				}
				j++;
			}
			i++;
		}
		
		System.out.println("start : " + Arrays.toString(currentLocation));

		i = 0;
		for (String locationStatus : park) {
			String[] status = locationStatus.split("");
			for(i = 0; i < park[0].length(); i++) {
				columns[i].add(status[i]);
			}
			
		}
		
		System.out.println("==========================low==========================");
		for(ArrayList<String> low : lows) {
			System.out.println(low);
		}
		System.out.println("==========================column==========================");
		for(ArrayList<String> column : columns) {
			System.out.println(column);
		}
		
		System.out.println("start: " + Arrays.toString(currentLocation));
		
		
		for(String route : routes) {
			String direction = route.split(" ")[0];
			int distance = Integer.parseInt(route.split(" ")[1]);
			
			switch(direction) {
			case "N":
				System.out.println("N");
				if(!(currentLocation[0] - distance < 0) && !(columns[currentLocation[1]].subList(currentLocation[0], currentLocation[0] - distance).contains("X")))
					currentLocation[0] -= distance;
				break;
			case "S":
				System.out.println("S");
				if(!(currentLocation[0] + distance < park.length) && !(columns[currentLocation[1]].subList(currentLocation[0], currentLocation[0] - distance).contains("X")))
					currentLocation[0] += distance;
				break;
			case "W":
				System.out.println("W");
				System.out.println();
				System.out.println("currentLocation[1] - distance : " + (currentLocation[1] - distance));
				System.out.println("distance : " + distance);
				System.out.println("lows[currentLocation[0]]" + lows[currentLocation[0]]);
				
				
				System.out.println("currentLocation : " + currentLocation[0]);
				
				System.out.println("fsfdsfsdsdsfs");
				System.out.println("lows[currentLocation[0]].subList(currentLocation[1], currentLocation[1] - distance)" + (lows[currentLocation[0]].subList(currentLocation[1] -distance, currentLocation[1])));
				if(currentLocation[1] - distance >= 0 && !(lows[currentLocation[0]].subList(currentLocation[1] - distance, currentLocation[1]).contains("X")))
					currentLocation[1] -= distance;
				break;
			case "E":
				System.out.println("E");
				if(!(currentLocation[1] + distance <= park.length) && !(lows[currentLocation[0]].subList(currentLocation[1], currentLocation[1] + distance).contains("X")))
					currentLocation[1] += distance;
				break;
			}
			
		
		}
		
		System.out.println(Arrays.toString(currentLocation));
		
		
		

	}

}

