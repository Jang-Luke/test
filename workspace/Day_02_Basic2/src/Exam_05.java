
public class Exam_05 {
      public static void main(String[] args) {
	
    	  //int a = 10; //10�� ���ͷ� ���̶�� �θ�
    	  // ���Կ����� ��Ģ1. ������ �������� ���Եȴ� (���ܾ���)
    	  // ���Կ����� ��Ģ2. �׷��Ƿ� ������ �ݵ�� �����̿��߸� �Ѵ�. (����)
    	  
    	int A = 10; int B = 20;
    	// A+=B; // A = A + B // A = 10 + 20;
    	// B-=A; // B = B - A // B = 20 - 10;
    	// A*=B; // A = A * B // A = 10 * 20;
    	// A/=B; // A = A / B // A = 10 / 20;
    	// A%=B; // A = A % B // A = 10 % 20;
    	
    	A++; //A = A + 1 // A+=1
        --B; // B = B - 1// B-=1;
    	
    	// B--; --B;
    	// B = B - 1;
        
    	A++; // ��ġ�� ���� ������
    	++A; // ��ġ�� ���� ������ 
        
    	//System.out.println("A : " + A);
    	//System.out.println("B : " + B);
    	
    	//���迬����
//    	System.out.println(A == B); // A ���� B ���� ����.
//    	System.out.println(A != B); // A�� B�� ���� ���� �ʴ�.
//    	System.out.println(A < B); // A�� B���� �۴�.
//    	System.out.println(A > B); // A�� B���� ũ��.
//    	System.out.println(A <= B); // A�� B���� �۰ų� ����.
//    	System.out.println(A >= B); // A�� B���� ũ�ų� ����.
    	
    	// 10 < A < 20
//    	System.out.println(10 < A && A < 20);
    	
//    	// && ������
//    	//T && T = T
//        //T && F = F
//        //F && T = F
//        //F && F = F
//    	System.out.println(true && true);
//    	System.out.println(true && false);
//    	System.out.println(false && true);
//    	System.out.println(false && false);
//    	
//    	
//    	// || ������
//    	// T || T = T
//    	// T || F = T
//    	// F || T = T
//    	// F || F = F
//    	System.out.println("-----------------");
//    	System.out.println(true || true);
//    	System.out.println(true || false);
//    	System.out.println(false || true);
//    	System.out.println(false || false);
    	
    	System.out.println(!(A == B));
    }
}
