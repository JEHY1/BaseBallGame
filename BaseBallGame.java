package Exercies01;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ranNum; //ranNum 의 조건 : 중복되지 않는 4자리 수
		String strRanNum; // ranNum을 문자열로 저장하기 위한 변수
		String strInputNum; //inputNum 을 문자열로 저장하기 위한 변수
		 
		boolean b = true; //ranNum의 조건에 부합하는 수 인지 확인하기 위한 변수

		while(true) {
			ranNum = (int) (Math.random() * 10000); //0 ~ 9999 사이의 수 생성
			b = true;
			if((ranNum + "").length() == 3) { //0 ~ 999 사이의 수 일 경우 앞에 0을 붙여 문자열로 만듬
				strRanNum = "0" + ranNum;
			}
			else { //1000 ~ 9999 사이의 수는 문자열로 바로 변경
				strRanNum = ranNum + "";
			}
			
			for(String str : strRanNum.split("")) {//생성된 문자열에서 하나씩 가져옴
				if(strRanNum.replace(str, "").length() != 3) { // 해당 문자를 문자열에서 제거하였을때
					//문자열의 길이가 3 이 아니라면 rauNum의 조건(중복 숫자 x)에 부함하지 않음
					//ex) "012" 에서 "0"을 뺄 경우 -> "12" (처음부터 4자리가 아니었던 경우) 
					//ex) "0122" 에서 "2"를 뺄 경우 -> "01" (중복된 숫자가 존재할 경우)
					b = false; //ranNum의 조건에 부합하지 않음으로 새 변수를 생성하기 위함
					break; //뒤의 문자는 확인할 필요 없으므로 break;
				}
			}
			if(b) { //true : 합격, false : 불합격
				break;
			}
		}

		//System.out.println(ranNum); test line
		
		int ballCount = 0; //ball 조건에 합당한 수의 갯수 
		int strikeCount = 0; //strike 조건에 합당한 수의 갯수
		int inputNum; //사용자 입력 값을 저장하는 수
		int turn = 1; //진행된 턴 수
		ArrayList<Integer> ranNumArr = new ArrayList<Integer>();//ranNum을 int 배열로 저장하기 위한 arrayList
		ArrayList<Integer> ranNumArrClone; //ranNumArr의 clone 참조
		ranNumArr.add(ranNum / 1000); //ranNum의 첫번째 자리값 (index : 0)
		ranNumArr.add(ranNum % 1000 / 100); //ranNum의 두번째 자리값 (index : 1)
		ranNumArr.add(ranNum % 100 / 10); //ranNum의 세번째 자리값 (index : 2)
		ranNumArr.add(ranNum % 10); //ranNum의 네번째 자리값 (index : 3)
		
		//System.out.println("ranNumArr : " + ranNumArr); test line
		
		tar1: //continue 탈출 위치
		while(true) {
			
			try {
				System.out.println("=============== turn " + turn + " ==================="); //console 에 현재 턴 표시
				System.out.print("input Num : "); //사용자 입력을 기다린다는 console 출력
				inputNum = Integer.parseInt(sc.next());	//사용자 입력값이 숫자로만 이루어져 있는지 확인 아닐경우 exception 발생 -> catch로 이동
				ranNumArrClone = (ArrayList<Integer>) ranNumArr.clone(); //ranNumArr 의 복제 생성
				
				if((inputNum + "").length() == 3) { 
					strInputNum = "0" + inputNum;
				}
				else {
					strInputNum = inputNum + "";
				}
				
				if(strInputNum.length() != 4) {
					System.out.println("올바른 숫자를 입력하시오");
					continue;
				}
				
				for(String str : strInputNum.split("")) {
					if(strInputNum.replace(str, "").length() != 3) {
						System.out.println("올바른 숫자를 입력하시오");
						continue tar1;
					}
				}
				//변수 생성과 마찬가지로 정답이 될 수 있는 수인지 확인하여 아닐경우 다시 입력 받음 (턴 증가 x) 63 ~ 73
				
				int i = 0; //ranNumArr 에 접근하기 위한 인덱스로 사용
				int k = 0; //ranNumArrClone 에 접근하기 위한 인덱스로 사용
				ballCount = 0; //전 턴 출력에 사용한 값초기화
				strikeCount = 0; //전 턴 출력에 사용한 값초기화
				
				for(String str : strInputNum.split("")) { //사용자 입력값을 문자열 배열(String[])로 만들어 하나씩 가져옴(가져온 값의 참조변수 str)
					if(ranNumArr.get(i) == Integer.parseInt(str)) { //ranNumArr 의 i번째 값과 str 의 값을 비교(자리값과 숫자 모두 == strike 조건)(비교를 위해 정수형으로 변환)
						strikeCount++; //strike 조건에 만족함으로 strikeCount 증가
						ranNumArrClone.remove(k); // ranNumArrClone 배열에서 k번째 인덱스를 제거
					}
					else {
						k++; //strike 조건에 부합하지 않은 경우 ranNumArrClone 배열에 접근하기 위한 인덱스값 증가
					}
					
					i++; //ranNumArr에 접근하기 위한 인덱스값 증가
					//ex)strInputNum.split("") == [1,2,3,4]
					//ranNumArr == [1, 5, 6, 3] 
					//최초 시작시 i = 0 일때 ranNumArr[i] => 1 와 str => "1"을 를비교한 후
					//ranNumClone => [1, 5, 6, 3] -> [5, 6, 3] k = 0 그대로
					//i = 1 일때 ranNumArr[i] => 5 와 str => "2" 를 비교함
					//조건문 false 이므로 k 증가
					//향상된 for 문에 의해서 strInputNum 의 길이(4) 만큼 반복됨
				}
				
				if(ranNumArrClone.isEmpty()) {//모든 숫자가 strike 조건에 부합하여 ranNumArrClone이 빌경우 
					System.out.println("clear!!!");
					break; //게임끝
				}
				
				for(int num : ranNumArrClone) { //ball 조건을 확인하기 위해 ranNumArrClone 에서 남은 값을 가져옴
					//ex) strike 조건을 거치고 남은 ranNumArrClone => [5, 6, 3]
					if(strInputNum.contains(num + "")) { //5, 6, 3 이 반복문을 돌면서 strInputNum => "1234" 에 포함되어 있는지 확인
						ballCount++; //3이 포함되어 있으므로 ballCount증가
					}
				}

				System.out.println("Strike " + strikeCount + " // Ball : " + ballCount); //사용자 입력값에 대한 strike, ball 값을 console 출력
				turn++; //턴 증가
				
			}catch(Exception e) {
				System.out.println("올바른 숫자를 입력하시오");
			}
		}
	}
}
