import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_04 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int myMoney = 0;
		int menuSelect = 0;
		int batMoney = 0;

		while(true) {
			System.out.printf("경마 게임에 오신 것을 환영합니다.\n1. 게임 시작\n2. 잔액 충전\n3. 잔액 조회\n4. 종료\n메뉴를 선택해주세요. >> ");
			try {
				st = new StringTokenizer(br.readLine());
				menuSelect = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				System.out.println("올바른 메뉴를 입력해주세요.");
				continue;
			}
			point1 :switch(menuSelect) {
			case 1:
				System.out.printf("!! 경마 게임을 시작하겠습니다 !!\n1. 우승 경력이 많지만 은퇴를 앞둔 말\n2. 이번 달 성적이 제일 좋은 말\n3. 최근 떠오르는 신예 말\n배팅하고 싶은 말을 선택해주세요. >>");
				while(true) {
					try {
						st = new StringTokenizer(br.readLine());
						menuSelect = Integer.parseInt(st.nextToken());
						if (menuSelect == 1 || menuSelect == 2 || menuSelect == 3) {
							System.out.println("얼마를 배팅하시겠습니까?");
							while(true) {
								try {
									st = new StringTokenizer(br.readLine());
									batMoney = Integer.parseInt(st.nextToken());
									if(batMoney > myMoney) {
										System.out.printf("잔액이 부족합니다.\n현재 잔액 : %d원\n",myMoney);
										break point1;
									}
									break;
								} catch (Exception e) {
									System.out.println("올바른 금액을 입력해주세요.");
									continue;
								}
							}
							//							int horse = (int)(Math.random()*3+1);
							int count1 = 0, count2 = 0, count3 = 0;
							int win = 0;
							for( ; ; ) {
								int a = (int)(Math.random()*100);
								int b = (int)(Math.random()*100);
								int c = (int)(Math.random()*100);
								if (a == 1) {count1++;}
								if (b == 1) {count2++;}
								if (c == 1) {count3++;}
								if (count1 == count2 || count2 == count3 || count3 == count1) {win = 4;}
								if (count1 > count2 && count1 > count3) {win = 1;}
								else if (count2 > count3 && count2 > count1) {win = 2;}
								else if (count3 > count1 && count3 > count2) {win = 3;}
								if (count1 == 10 || count2 == 10 || count3 == 10) {
									break;
								}
							}

							System.out.print("출 : ");
							for (int i = 0; i < count1; i++) {
								System.out.print("*");
							}
							System.out.println();
							System.out.print("발 : ");
							for (int i = 0; i < count2; i++) {
								System.out.print("*");
							}
							System.out.println();
							System.out.print("선 : ");
							for (int i = 0; i < count3; i++) {
								System.out.print("*");
							}
							System.out.printf("\n%d 번 말의 승리!",win);
							if (menuSelect == win) {
								myMoney += batMoney*2;
								System.out.printf("배팅에 성공하셨습니다!!\n%d원을 획득하셨습니다.\n현재 잔액 : %d원\n",batMoney*2,myMoney);
							} else if (win == 4) { 
								System.out.printf("무승부입니다.\n배팅에 사용된 금액 %d원은 다시 계좌로 돌아갑니다.\n",batMoney); // 무승부 미구현
							}else {
								myMoney -= batMoney;
								System.out.printf("배팅에 실패하셨습니다. ㅠ^ㅠ\n배팅 금액 %d원을 모두 잃으셨습니다.\n현재 잔액은 %d원 입니다.\n",batMoney,myMoney);
							}
						} else {
							System.out.println("올바른 메류를 입력해주세요.");
							continue;
						}
					}catch(Exception e) {
						System.out.println("올바른 메류를 입력해주세요.");
						continue;
					}
					break;
				}
				break;
			case 2:
				System.out.println("얼마를 충전하시겠습니까?");
				while(true) {
					try {
						st = new StringTokenizer(br.readLine());
						int inputNum = Integer.parseInt(st.nextToken());
						myMoney += inputNum;
						System.out.printf("현재 잔액은 %d원 입니다.\n",myMoney);
						break;
					} catch (Exception e) {
						System.out.println("올바른 금액을 입력해주세요.");
						continue;
					}
				}
				break;
			case 3:
				System.out.printf("현재 잔액은 %d원 입니다.\n",myMoney);
				break;
			case 4:
				System.out.println("게임을 종료하시겠습니까? (Y/N)");
				while(true) {
					try {
						String inputKey = br.readLine();
						if(inputKey.equals("y")||inputKey.equals("Y")) {
							System.out.println("프로그램을 종료합니다.");
							System.exit(0);
						} else if (inputKey.equals("n")||inputKey.equals("N") ) {
							break;
						} else {
							System.out.println("올바른 문자를 입력해주세요.");
							continue;
						}
					} catch (Exception e) {
						System.out.println("올바른 문자를 입력해주세요.");
						continue;
					}
				}
				break;
			default:
				System.out.println("올바른 메뉴를 입력해주세요.");
				break;
			}
		}
	}
}

//경마 게임에 오신 것을 환영합니다.
//1.시작
//2.잔액충전
//3.잔액조회
//4.종료

//메뉴 >
//1.우승 경력이 많지만 은퇴를 앞둔 말
//2.이번 달 성적이 제일 좋은 말
//3.최근 떨오르는 신예 말
//배팅하고 싶은 말 선택 >>
//결과 출력