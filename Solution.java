package Exercies01;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Solution {

	public static void main(String[] args) {

		String[] park = { "OSO", "OOO", "OXO", "OOO" };
		String[] routes = { "E 2", "S 3", "W 1" };
		//

		int[] currentLocation = new int[2];
		char[][] parkMap = new char[park.length][park[0].length()];
		boolean cantMove = false;

		int k = 0;
		for (int i = 0; i < park.length; i++) {
			parkMap[i] = park[i].toCharArray();
			for (char c : parkMap[i]) {
				{
					if (c == 'S') {
						currentLocation[0] = i;
						currentLocation[1] = k;
					}
					k++;
				}

			}
		}

		System.out.println("======================================");

		System.out.println("park Map: ");
		System.out.println(Arrays.deepToString(parkMap));
		System.out.println("currentLocation : " + Arrays.toString(currentLocation));

		System.out.println("==================move start=====================");
		for (String route : routes) {

			int[] beforeMoveLocation = currentLocation.clone();
			String[] directionAndDistance = route.split(" ");
			System.out.println("before move : " + Arrays.toString(currentLocation));
			System.out.println("direction : " + directionAndDistance[0]);
			System.out.println("distance : " + directionAndDistance[1]);
			switch (directionAndDistance[0]) {
			case "S":
				for (int i = 0; i < Integer.parseInt(directionAndDistance[1]); i++) {
					if (currentLocation[0] < park.length
							&& parkMap[currentLocation[0] + 1][currentLocation[1]] != 'X') {
						currentLocation[0]++;
					} else {
						System.out.println("can't move");
						currentLocation = beforeMoveLocation;
						break;
					}
				}
				break;
			case "E":
				for (int i = 0; i < Integer.parseInt(directionAndDistance[1]); i++) {
					//System.out.println("can move? " + (currentLocation[1] < park[0].length()
							//&& parkMap[currentLocation[0]][currentLocation[1] + 1] != 'X'));
					//System.out.println("Distance" + Integer.parseInt(directionAndDistance[1]));
					if (currentLocation[1] < park[0].length() - 1
							&& parkMap[currentLocation[0]][currentLocation[1] + 1] != 'X') {
						System.out.println("move");
						currentLocation[1]++;
						System.out.println("after move : " + Arrays.toString(currentLocation));
					} else {
						System.out.println("can't move");
						currentLocation = beforeMoveLocation;
						System.out.println("after move : " + Arrays.toString(currentLocation));
						break;
					}
					System.out.println("fsfsdfdsfdsfdfsfdd");
					System.out.println("i : " + i);
					System.out.println("Distance : " + Integer.parseInt(directionAndDistance[1]));
				}
				break;

			case "N":
				for (int i = 0; i < Integer.parseInt(directionAndDistance[1]); i++) {
					if (currentLocation[0] > 0 && parkMap[currentLocation[0] - 1][currentLocation[1]] != 'X') {
						currentLocation[0]--;
					} else {
						System.out.println("can't move");
						currentLocation = beforeMoveLocation;
						break;
					}
				}
				break;
			case "W":
				for (int i = 0; i < Integer.parseInt(directionAndDistance[1]); i++) {
					if (currentLocation[1] > 0 && parkMap[currentLocation[0]][currentLocation[1] - 1] != 'X') {
						currentLocation[1]--;
					} else {
						System.out.println("can't move");
						currentLocation = beforeMoveLocation;
						break;
					}
				}
				break;
			}
			System.out.println("==================move clear=====================");
			System.out.println("after move : " + Arrays.toString(currentLocation));
		}
		
		System.out.println(Arrays.toString(currentLocation));
		
		
		

	}

}
