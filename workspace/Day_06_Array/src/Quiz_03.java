import java.util.ArrayList;

public class Quiz_03 {
	static int first = 0;
	static int second = 0;
	static int third = 0;
	static int fourth = 0;
	static int fifth = 0;

	public static void main(String[] args) {
		// 1 ~ 45 사이의 난수를 중첩되지 않게 7개를 뽑아서 출력하세요.
		// 오늘의 추천 로또 번호
		// 당첨 번호 7개를 뽑고 몇 번 반복한 뒤에 당첨되었는지 통계와 함께 출력
		int size = 7;
		int cnt = 0;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> match = new ArrayList<Integer>(1000);
		
		for(;;) {
			if(nums.size() != size) {nums.add(0); continue;} // 배열 nums 에 size 크기만큼 값 추가 (배열.size의 크기를 변수 size와 맞추기 위함)
			int a = (int)(Math.random()*45+1); // 1~46 의 랜덤 수 뽑기
			if(nums.contains(a)) {continue;} // 뽑은 수가 중복이라면 다시 뽑는 코드
			nums.set(cnt, a); // 뽑은 수가 중복이 아니라면 nums 배열에 값 저장(총 7개가 될 때 까지 반복)
			cnt++;
			if(cnt == nums.size()) {break;}
		}
		for(int i = 1; i > 0; i++) {
			cnt = 0;
			for(;;) {
				if(match.size() != size-1) {match.add(0); continue;}
				int a = (int)(Math.random()*45+1);
				if(match.contains(a)) {continue;}
				match.set(cnt, a);
				cnt++;
				if(cnt == match.size()) {break;}
			}
			System.out.printf("%d 번째 로또 번호 : ",i);
			for(int a : match) {
				System.out.printf("%02d ",a);
			}
			judge(match, nums);
			match.clear();
			if(first == 1) {
				System.out.printf("1등 횟수 : %d\n2등 횟수 : %d\n3등 횟수 : %d\n4등 횟수 : %d\n5등 횟수 : %d\n",first,second,third,fourth,fifth);
				break;
			}
		}
		System.out.println("★ 금주의 당첨 로또 번호 ☆\n====================");
		for(int a : nums) {
			System.out.printf("%02d ",a);
		}
	}

	static void judge(ArrayList<Integer> match, ArrayList<Integer> nums) {
		int cnt = 0;
		boolean bonus = false;
		for (int i = 0; i < match.size(); i++) {
			if(match.contains(nums.get(i))) {cnt++;}
		}
		if(match.contains(nums.get(6))) {bonus = true;}
		if(cnt < 3) {
			System.out.printf("\t당첨되지 않았습니다. ㅠㅠ\n");
		} else if (cnt == 6) {
			System.out.printf("\t축하합니다! %d 등에 당첨되었습니다.\n",1);
			first++;
		} else if (bonus == true && cnt == 5) {
			System.out.printf("\t축하합니다! %d 등에 당첨되었습니다.\n",2);
			second++;
		} else if (bonus == false && cnt == 5) {
			System.out.printf("\t축하합니다! %d 등에 당첨되었습니다.\n",3);
			third++;
		} else if (cnt == 4) {
			System.out.printf("\t축하합니다! %d 등에 당첨되었습니다.\n",4);
			fourth++;
		} else if (cnt == 3) {
			System.out.printf("\t축하합니다! %d 등에 당첨되었습니다.\n",5);
			fifth++;
		}
		return;
	}
}
