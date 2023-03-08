
public class Exam_06 {
	public static void main(String[] args) {

//		int size = 3;
//		int cnt = 0;
//		int[] arr = new int[size]; 
//		point1: for(;;) {
//			int a = (int)(Math.random()*5+1);
//			for(int j = 0; j < arr.length; j++) { 
//				if(a == arr[j]) {
//					continue point1;
//				}
//			}
//			arr[cnt] = a;
//			cnt++;
//			System.out.println(a);
//			if(cnt == arr.length) {break;}
//		}
		
		int[] nums = new int[] {1, 2, 3, 4, 5};
		
		for(int i = 0; i < nums.length*10; i++) {
			int x = (int)(Math.random()*5);
			int y = (int)(Math.random()*5);
			
			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
		}
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
	}
}
