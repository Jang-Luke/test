class Solution {	
	public int solution(int[] array, int height) {

		int answer = 0;

		for(int i = 0; i<array.length; i++) {
			if(array[i] > height) {
				answer++;
			}
		}
		return answer;	
	}
}
public class Test_0213 {	
	public static void main(String[] args) {

		int[] array = new int[] {166,170,150,165,180};
		int height = 168;

		Solution solution = new Solution();

		int result = solution.solution(array, height);
		System.out.println(result);
	}
}
