
public class Quiz_01 {

	public static void main(String[] args) {

		String str = "asnkfjasnfianfvaGASGAJGAvainnvafAJfaFJINAOIGNzmioaOIGnAOIGnaoqnclkxmAaigvoianOInOInOINoiFHnoIFNHIOANFAQKWGNLANswPXkmgGAUVNOQAVzibZOXIVnzA";
		int count = countA(str);
		System.out.println("알파벳 A의 개수 : " + count);
	}
	static int countA(String str) {
		int cnt = 0;
//		for(int i = 0; i < str.length(); i++) {
//			if(str.startsWith("A", i)) {
//				cnt++;
//			}
//		}
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'A') {
				cnt++;
			}
		}
		return cnt;
	}
}