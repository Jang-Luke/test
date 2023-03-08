package custom;

public class Student {
	static private int stdNum = 0;
	private String stdName;
	private int korScore;
	private int engScore;
	private int mthScore;
	private int instStdNum;
	
	public Student() {
		this.stdName = "default"+ ++stdNum;
		this.korScore = 0;
		this.engScore = 0;
		this.mthScore = 0;
		this.instStdNum = stdNum;
		System.out.printf("default%d학생 생성\n",stdNum);
	}
	
	public Student(String stdName, int korScore, int engScore, int mthScore) {
		++stdNum;
		this.stdName = stdName;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mthScore = mthScore;
		this.instStdNum = stdNum;
		System.out.printf("%d번 학생 %s 생성\n국어 : %d 영어 : %d 수학 : %d\n",this.instStdNum,stdName,korScore,engScore,mthScore);
	}
	
	public String getStdName() {
		return stdName;
	}
	public Student setStdName(String stdName) {
		this.stdName = stdName;
		System.out.printf("%d번 학생 이름 %s(으)로 변경\n",this.instStdNum,stdName);
		return this;
	}
	public int getKorScore() {
		return korScore;
	}
	public Student setKorScore(int korScore) {
		this.korScore = korScore;
		System.out.printf("%d번 학생 국어 점수 %d점으로 변경\n",this.instStdNum,korScore);
		return this;
	}
	public int getEngScore() {
		return engScore;
	}
	public Student setEngScore(int engScore) {
		this.engScore = engScore;
		System.out.printf("%d번 학생 영어 점수 %d점으로 변경\n",this.instStdNum,engScore);
		return this;
	}
	public int getMthScore() {
		return mthScore;
	}
	public Student setMthScore(int mthScore) {
		this.mthScore = mthScore;
		System.out.printf("%d번 학생 수학 점수 %d점으로 변경\n",this.instStdNum,mthScore);
		return this;
	}
	public Student getThis() {
		return this; 
	}
	public int getSumScore() {
		return korScore + engScore + mthScore;
	}
	public double getAvgScore() {
		return getSumScore() / 3.0;
	}
	public void showStdInfo() {
		System.out.println("-----------------");
		System.out.println("이름 : " + stdName);
		System.out.println("국어 : " + korScore);
		System.out.println("영어 : " + engScore);
		System.out.println("수학 : " + mthScore);
		System.out.println("-----------------");
		if (getSumScore() % 3 == 0) {
			System.out.printf("합계 : %d\n평균 : %.0f\n", getSumScore(), getAvgScore());
		} else {
			System.out.printf("합계 : %d\n평균 : %.2f\n", getSumScore(), getAvgScore());
		}
		System.out.println("-----------------");
		return;
	}
}
