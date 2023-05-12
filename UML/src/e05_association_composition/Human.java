package e05_association_composition;

import java.util.ArrayList;
import java.util.List;

public class Human {
	private List<Heart> haert = new ArrayList<>();
	private Eyes[] eyes = new Eyes[] {new Eyes(), new Eyes(), new Eyes()};

	public Human() {
	}


	// setter 가 존재하면 composition 도 가능하고 aggregation 도 가능하다.
	// (외부에서 주입받을 경우 life cycle이 달라지기 때문)
}
