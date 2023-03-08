
public class Bubble_Sort {
	public static void main(String[] args) {
		
		int[] arr = new int[] {15, 24, 35, 99, 86, 34, 13, 27, 46, 66};
		
		System.out.println("정렬 전");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = (i+1); j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println();
		System.out.println("정렬 후");
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
