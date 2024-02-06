package Exercies01;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ranNum = 8346;
		
		boolean b = true;

		while(true) {
			ranNum = (int) (Math.random() * 10000);
			b = true;
			for(String str : (ranNum + "").split("")) {
				if((ranNum + "").replace(str, "").length() != 3) {
					b = false;
				}
			}
			if(b) {
				break;
			}
		}
		
		
		
		System.out.println(ranNum);
		
		int ballCount = 0;
		int strikeCount = 0;
		int inputNum;
		int turn = 1;
		ArrayList<Integer> ranNumArr = new ArrayList<Integer>();
		ArrayList<Integer> ranNumArrClone;
		ranNumArr.add(ranNum / 1000);
		ranNumArr.add(ranNum % 1000 / 100);
		ranNumArr.add(ranNum % 100 / 10);
		ranNumArr.add(ranNum % 10);
		
		System.out.println("ranNumArr : " + ranNumArr);
		
		tar1:
		while(true) {
			
			try {
				System.out.println("=============== turn " + turn + " ===================");
				ranNumArrClone = (ArrayList<Integer>) ranNumArr.clone();
				System.out.print("input Num : ");
				inputNum = Integer.parseInt(sc.next());
				
				if((inputNum + "").length() != 4) {
					System.out.println("올바른 숫자를 입력하시오");
					continue;
				}
				
				for(String str : (inputNum + "").split("")) {
					if((inputNum + "").replace(str, "").length() != 3) {
						System.out.println("올바른 숫자를 입력하시오");
						continue tar1;
					}
				}
				
				int i = 0;
				int k = 0;
				ballCount = 0;
				strikeCount = 0;
				for(String str : (inputNum + "").split("")) {
					if(ranNumArr.get(i) == Integer.parseInt(str)) {
						strikeCount++;
						ranNumArrClone.remove(k);
					}
					else {
						k++;
					}
					i++;
				}
				
				for(int num : ranNumArrClone) {
					if((inputNum + "").contains(num + "")) {
						ballCount++;
					}
				}
				
				if(ranNumArrClone.isEmpty()) {
					System.out.println("clear!!!");
					break;
				}
				System.out.println("Strike " + strikeCount + " // Ball : " + ballCount);
				turn++;
			}catch(Exception e) {
				System.out.println("올바른 숫자를 입력하시오");
			}
			//
		}
	}
}
