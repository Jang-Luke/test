package e05_association_composition;

import java.util.ArrayList;
import java.util.List;

public class Human {
	private List<Heart> haert = new ArrayList<>();
	private Eyes[] eyes = new Eyes[] {new Eyes(), new Eyes(), new Eyes()};

	public Human() {
	}


	// setter �� �����ϸ� composition �� �����ϰ� aggregation �� �����ϴ�.
	// (�ܺο��� ���Թ��� ��� life cycle�� �޶����� ����)
}
