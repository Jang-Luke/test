package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Programus {

	public static void main(String[] args) {
//		Solution a = new Solution();
//		String[] sarr = {"meosseugi", "1234"};
//		String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
//		System.out.println(a.solution(sarr,db));
//		List<String> test = new ArrayList<>(Arrays.asList("a","b","c","d","e"));
//		Stream<String> stream = test.stream();
//		stream = Stream.<String>builder().add("f").add("g").build();
//		stream = Stream.generate(() -> "a"+"b").limit(1);
//		Stream<String> tstream = Pattern.compile(", ").splitAsStream("a, rm, we, dooz, splw, f");
//		String test2 = tstream.sorted(Comparator.comparingInt(String::length)).toString();
//		System.out.println(test2);
//		System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 8, 10, 15).sum());
//		System.out.println(IntStream.of(10,2,1,4).reduce((n, i) -> n*i));
//		String numstring = Stream.of(1, 2, 3, 4).map(String::valueOf).collect(Collectors.joining());
//		String testing = Stream.of("a", "b", "b", "a").collect(Collectors.joining());
//		String testing2 = Stream.of("a", "b", "b", "a").sorted(Comparator.reverseOrder()).collect(Collectors.joining());
//		Consumer<String> upper = s -> System.out.print(s.toUpperCase());
//		upper.accept(testing2);2
		String s = "abc";
		System.out.println(s.matches(".*\\d.*"));
//		Solution a = new Solution();
//		System.out.println(a.solution(1999));
	}
}

class Solution {
	public int solution(int chicken) {
		if (chicken < 10) {
			return 0;
		}
		int additionalChicken = chicken / 10;
		int remainTicket = chicken % 10;
		return additionalChicken + solution(additionalChicken + remainTicket);
	}
}
