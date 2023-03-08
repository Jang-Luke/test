package test_package;

public class Test2 {
	
	public static void main(String[] args) {
		
		Exam e = new Exam();

		e.exam1();
		
	}
}
/*
Exam 클래스의 exam1 메서드에 잘못된 부분이 있어 하나씩 고쳐 나가겠습니다.


문제점 1. User 클래스의 생성자에 오류가 있습니다.

User 클래스에는 기본 생성자만 존재하나, exam1 메서드에서는 매개변수 5개를 활용하여 생성자를 호출하고 있습니다.

이 부분은 편의상 User 클래스에 exam1 메서드에서 전달하는 매개변수들을 각 멤버변수로 대입해주는 생성자를 생성하는 쪽이 더 간단하게 문제를 해결할 수 있다고 판단하였습니다.

------------------------------------------------------------------------------------------------​------------------------------​​

// 기존 코드를

public User(){

super();

}

// 아래와 같이 수정

public User(String id, String pw, String name, int age, String phone) {

		this.id = id;

		this.pw = pw;

		this.name = name;

		this.age = age;

		this.phone = phone;

}

------------------------------------------------------------------------------------------------​------------------------------​​

문제점 2. 만들어진 ArrayList<User> userList 배열에 요소를 추가하는 부분이 잘못되었습니다.

예제 코드에서는 userList.put() 을 입력하였으나, ArrayList에 put 메서드는 존재하지 않습니다.

맥락 상 배열에 요소를 추가하려는 것으로 보이며, put 대신에 이에 적절한 메서드인 add 메서드를 호출하는 것으로 수정하였습니다.

------------------------------------------------------------------------------------------------​------------------------------​​

// 기존 코드를

userList.put(user1);

userList.put(user2);

userList.put(user3);

// 아래와 같이 수정​


userList.add(user1);

userList.add(user2);


userList.add(user3);

------------------------------------------------------------------------------------------------​------------------------------​​

​문제점 3. 회원 정보를 출력하는 부분에서, 반복 횟수 지정 및 출력 값을 불러오는 부분이 잘못되었습니다.

예제 코드 for문의 반복 조건 설정에 userList.length 를 사용하였으나, ArrayList를 활용한 배열에서는 .length를 사용할 수 없습니다.

대신에 userList.size() 를 이용하여 배열의 크기를 불러올 수 있어, 해당 부분을 대체하였습니다.

멤버변수에 저장된 값을 불러와 출력해주는 부분도 잘못되었는데, private으로 정보 은닉이 적용된 멤버변수들의 값을 불러오기 위해

.get멤버변수명() 을 사용하여야 하나, 예제에서는 멤버 변수의 값을 설정(변경) 해주는 .set멤버변수명() 메서드로 잘못 호출한 것을 확인할 수 있습니다.

해당 set 부분을 get 부분으로 고쳐주었습니다.

------------------------------------------------------------------------------------------------​------------------------------​​

// 기존 코드를

for(int i=0;i<userList.length;i++) {

	User u = userList.get(i);

	System.out.println(u.setId()+"\t"+u.setPw()+"\t"+u.setName()+"\t"+u.setAge()+"\t"+u.setPhone());

}

// 아래와 같이 수정

for(int i=0;i<userList.size();i++) {

	User u = userList.get(i);

	System.out.println(u.getId()+"\t"+u.getPw()+"\t"+u.getName()+"\t"+u.getAge()+"\t"+u.getPhone());

}

------------------------------------------------------------------------------------------------​------------------------------​​

추가로, 위 내용들만 수정하여도 프로그램은 정상 작동하나, exam1() 메서드의 첫 줄

List<User> userList = new ArrayList<User>();

코드를 보면, userList가 ArrayList 타입이 아닌 List 타입으로 선언된 것을 확인할 수 있습니다.

List 인터페이스에도 예제에 사용된 코드들이 모두 명시되어 있어 오류는 발생하지 않지만

import java.util.List; 구문 삭제 및​ 약간의 통일성을 더 확보하기 위해 아래와 같이 수정하였습니다.

import java.util.List;​ (삭제)
ArrayList<User> userList = new ArrayList<User>();​​
*/