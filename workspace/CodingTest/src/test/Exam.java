package test;
import java.util.ArrayList;
import java.util.List;

public class Exam {
	
	public static void main(String[] args) {
		
		ArrayList <User> userList = new ArrayList<User>();

		User user1 = new User("user01", "1234", "����1", 23, "01022478875");
		User user2 = new User("user02", "1357", "����2", 27, "01095887774");
		User user3 = new User("user03", "2468", "����3", 34, "01036425456");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

		System.out.println("���̵�\t��й�ȣ\t�̸�\t����\t��ȭ��ȣ");

		for(User user : userList) {

						
			System.out.println(user.getId()+"\t"+user.getPw()+"\t"+user.getName()+"\t"+user.getAge()+"\t"+user.getPhone());

			//set�� ���� �־�]�ִ� �޼��� �̱� ������ ���� ��� �޼����� get�� ������� 
		}
	}
}