
public class Exam_01 {
	public static void main(String[] args) {

		// try - catch : ����ó�� ����
		try {

			int num = Integer.parseInt("123");
			System.out.println("�м��� ���ڴ� : " + num);

		}catch(Exception e) { 
			// ���ܰ� �߻����� ��, �����ڰ� �����ְ��� �ϴ� �ൿ
			System.out.println("�м��ϴ� �����Ͱ� ������ ���°� �ƴմϴ�.");
		}
		System.out.println("���α׷� ���� ����");
	}
}