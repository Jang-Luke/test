package custom;

public class Temp {
	
	//Temp �ν��Ͻ��� ������ �ȿ� �ִ� �޼��带 ��� �� �� ����
	//������ static �޼���� ��� ���� !
	public int a;                //Instance Member Field(Instance�� ���ӵ� ����ʵ�)
	                             //Temp t = new Temp(); <Temp �ν��Ͻ��� ��������
	                             //int a �� ����� �� ����

	public static int b;         //Class Member Field(�̹� �����ϴ� ����)
	                             // static << �������� !! ������ ���۵ǰ� ���ڸ��� ���������� ������
	                             // ���������� �������� ���� (���α׷� ���������� �����Ǿ�� �ϴ� ����
	                             //                      ���� ���� ��)
	                             // static ����ʵ�� �ν��Ͻ��� ���Ե��� ����!
	                             // static�� ������ �ν��Ͻ����� ������ 
	                             //��������(�߰�ȣ�� ���� ���� �ʰ� �ƹ������� ����ؾ� �Ҷ� ��)��!

   

	public static void func2() {
		a = 10;
	}
}