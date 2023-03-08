
public class Exam_05 {
	public static void main(String[] args) {
		// int[] arr = new int[] {24, 86, 13, 46};
		int[] arr = new int[] {15, 24, 35, 99, 86, 34, 13, 27, 46, 66};
		int tmp2 = arr[0];
		System.out.print("정렬 전 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		//------------------------------정렬코드 (Bubble Sort)
		for(int a = 0; a < arr.length; a++) {
			for(int b = (a+1); b < arr.length; b++) {
				if(arr[a] > arr[b]) {
					int tmp1;
					tmp1 = arr[b];
					arr[b] = arr[a];
					arr[a] = tmp1;
				}
			}
		}
		//		for(int a = 0; a < arr.length-1; a++) {
		//			for(int b = 0; b < arr.length-1; b++) {
		//				if(arr[b] > arr[b+1]) {
		//					int tmp = arr[b];
		//					arr[b] = arr[b+1];
		//					arr[b+1] = tmp;
		//				}
		//			}
		//		}
		//------------------------------정렬코드 (Bubble Sort)
		System.out.println("\n=============================================");
		System.out.print("정렬 후 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
