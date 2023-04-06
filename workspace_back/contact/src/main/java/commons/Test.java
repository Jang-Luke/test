package commons;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String date = "1995-11-15";
        StringBuilder stringBuilder = new StringBuilder(date);
        date = stringBuilder.append(" 00:00:00").toString();
//        System.out.println(date);
        String date2 = "1995-11-15";
        LocalDateTime localDatetime = LocalDate.parse(date2).atStartOfDay();
        System.out.println(localDatetime.toString());
//        System.out.println(Timestamp.valueOf(localDate.atStartOfDay()).toString());
        String phone = "010-2920-3659";
        String contact = phone
                .chars()
                .filter(character ->  48 <= character && character <= 57)
                .mapToObj(element -> (char)element)
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println(contact);
        System.out.println(contact.substring(0,3));
        System.out.println(contact);
        stringBuilder = new StringBuilder(contact.substring(0, 3));
        contact = stringBuilder.append("-").append(contact.substring(3,7)).append("-").append(contact.substring(7)).toString();
        System.out.println(contact);
    }
}
