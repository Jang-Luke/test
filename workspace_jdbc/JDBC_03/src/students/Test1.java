package students;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		String inputTime = "23-03-03 12:05";
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(inputTime, dateTimeFormatter);
		System.out.println(localDateTime);
		
//		
//		String time = Stream
//			.of(Stream.of(inputTime.split("/"))
//			.collect(Collectors.joining())
//				.split("-"))
//				.collect(Collectors.joining());
//		System.out.println(time);
//		System.out.println(time.matches("^\\d*$"));
//		System.out.println(time.length());
//		
	}

}
