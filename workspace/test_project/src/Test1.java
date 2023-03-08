import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;

		// 반복문을 통한 입력
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 숫자 입력 : ");
			arr[i] = scanner.nextInt();
			sum += arr[i];
		}

		// 내림차순 정렬 코드
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		// 출력 코드
		System.out.print("정렬 결과 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.println("입력한 수의 총 합은 : " + sum);
	}
}
/*
문제점 1. 배열의 합계를 저장하는 변수 sum에 합계를 저장하는 것이 아닌 가장 마지막에 입력한 값을 저장하고 있습니다.
문제가 되는 코드는 입력 for문 가장 아랫줄인 sum = arr[i] 부분입니다.

해당 코드대로 실행하면, sum의 값이 반복문의 횟수만큼 바뀌기만 할 뿐 그 값들이 더해지진 않습니다.

프로그램의 의도대로 입력되는 값들이 모두 더해지도록 sum += arr[i] 로 대입식을 바꿔주면 해결됩니다.

------------------------------------------------------------------------------------------------------------------------------​

// 반복문을 통한 입력

for (int i = 0; i < arr.length; i++) {

	System.out.print((i + 1) + "번째 숫자 입력 : ");

	arr[i] = scanner.nextInt();

	sum += arr[i];

}

--------------------------------------------------------------------------------------------------------------------------​----​

문제점 2. 내림차순 정렬 코드의 알고리즘이 잘못되었습니다.

문제가 되는 코드는 if문의 조건문 부분입니다.

쓰여진 대로 (arr[j] < arr[i]) 가 참일 경우 두 값을 바꾼다면

더 큰 값이 왼쪽으로(앞쪽으로) 이동하여 의도했던 내림차순 정렬이 아닌 오름차순으로 정렬됩니다.

이를 해결하기 위해 더 작은 값이 앞으로 이동하도록 (arr[j] < arr[i]) 로 조건문을 바꿔주었습니다.



추가로, 이대로 두어도 정렬은 정상적으로 작동하지만,

변수 i를 활용하는 첫 번째 for 문의 조건 중 i <= arr.length 부분을 i < arr.length-1 로 바꿔주면

이미 정렬된 배열을 두 바퀴 훑는 의미 없는 동작을 줄일 수 있습니다.

최악의 경우를 고려해도 arr.length-1 번째 반복에서 이미 정렬이 완료되기 때문입니다.

-----------------------------------------------------------------------------------------------------------------​-------------​

// 내림차순 정렬 코드

int temp = 0;

for (int i = 0; i < arr.length-1; i++) {

	for (int j = i + 1; j < arr.length; j++) {

		if (arr[j] > arr[i]) {

			temp = arr[i];

			arr[i] = arr[j];

			arr[j] = temp;

		}

	}

}

------------------------------------------------------------------------------------------------​------------------------------​
*/
