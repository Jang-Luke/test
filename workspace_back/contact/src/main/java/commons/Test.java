package commons;

import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        String date = "1995-11-15";
        StringBuilder stringBuilder = new StringBuilder(date);
        date = stringBuilder.append(" 00:00:00").toString();
        System.out.println(date);
    }
}
