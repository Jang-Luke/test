package classs;

public class Silver extends Member {    //�ڽ� Ŭ����, ���� Ŭ����  
	                                    //Member �ʵ尡 ������ member�� ��ӹ޾�
	                                    // ������
	                                    // ����� �ѹ��� �ϳ��ۿ� ���� ���� .
	                                    // �� �������ʿ� ���ļ� ��ӵǴ°� �� 
	
	public Silver(int id, String name, double point) {
		super(id,name,point);		
	}
	
	public double getBonus() {
		return this.getPoint() * 0.02; 
	}	                               //�߻�޼��带 ��ӹ޾� ������ ä�� 
		                               //implement : �����ϴ� 
		                               //�������̵��� ������ �ִ� �޼��带 ��ӹ޾�
		                               //���� ������ ä�� �ִ� �� !(��ȿȭ�ϴ�)
	
	
//	public double getBonus() {
//		return this.getPoint() * 0.02; -> �������̵�� �޼��� 
//	}
	//overrides : ��ȿȭ��Ű��
	// �θ� Ŭ�����κ��� ��� ���� �޼��带 �����ϰ� ������ ������Ÿ���� �ٽ� �����ϸ�
	// ��ӹ��� �޼��带 ���� ����� ȿ���� ������.
	
	//�����ε� vs �������̵��� ���� !! *****
}
